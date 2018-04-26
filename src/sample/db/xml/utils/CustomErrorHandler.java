package sample.db.xml.utils;

import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

public class CustomErrorHandler implements ErrorHandler {

    Boolean errorProduced = Boolean.FALSE;

    public Boolean isValid() {
        return !this.errorProduced;
    }

    @Override
    public void error(SAXParseException exception) throws SAXException {
        errorProduced = Boolean.TRUE;
    }

    @Override
    public void fatalError(SAXParseException exception) throws SAXException {
        errorProduced = Boolean.TRUE;
    }

    @Override
    public void warning(SAXParseException exception) throws SAXException {
        errorProduced = Boolean.TRUE;
    }
}
