package sample.db.xml;

import java.io.File;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import sample.db.pojos.Report;
import sample.db.pojos.Employee;

public class Xml2JavaReport {

	private static final String PERSISTENCE_PROVIDER = "company-provider";
	private static EntityManagerFactory factory;

	public static void main(String[] args) throws JAXBException {

		// Create the JAXBContext
		JAXBContext jaxbContext = JAXBContext.newInstance(Report.class);
		// Get the unmarshaller
		Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

		// Use the Unmarshaller to unmarshal the XML document from a file
		File file = new File("./xmls/External-Report.xml");
		Report report = (Report) unmarshaller.unmarshal(file);

		// Print the report
		System.out.println("Report:");
		System.out.println("Name: " + report.getName());
		System.out.println("Content: " + report.getContent());
		System.out.println("Date: " + report.getLocalDate());
		List<Employee> emps = report.getAuthors();
		for (Employee emp : emps) {
			System.out.println("Author: " + emp.getName());
		}

		// Store the report in the database
		// Create entity manager
		factory = Persistence.createEntityManagerFactory(PERSISTENCE_PROVIDER);
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();
		em.createNativeQuery("PRAGMA foreign_keys=ON").executeUpdate();
		em.getTransaction().commit();

		// Create a transaction
		EntityTransaction tx1 = em.getTransaction();

		// Start transaction
		tx1.begin();

		// Persist
		// We assume the authors are not already in the database
		// In a real world, we should check if they already exist
		// and update them instead of inserting as new
		for (Employee employee : emps) {
			em.persist(employee);
		}
		em.persist(report);
		
		// End transaction
		tx1.commit();
	}
}
