The suggested order for a proper understanding of these classes is the following
================================================================================

1. DTDCheckerReport.java: Check if a Report in XML is valid against a DTD.
2. Java2XmlReport.java: Marshall a Report taken from the database into a XML.
3. Xml2JavaReport.java: Unmarshall a Report from a XML and store it in the database.
4. XML2HTMLReport.java: Generate a HTML web page from a Report in XML using a XSLT stylesheet.

Note that some of these classes use JPA. So the student must understand JPA before looking at them.