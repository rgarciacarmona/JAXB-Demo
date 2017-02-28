About the SQLDateAdapter Class
==============================

The SQLDateAdapter class has been created so objects that use the *java.sql.Date* class can be properly marshalled and unmarshalled using JAXB. They convert the *java.sql.Date* to and from a String that follows a pattern established by the *DateTimeFormatter* declared in the class.