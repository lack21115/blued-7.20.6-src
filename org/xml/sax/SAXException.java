package org.xml.sax;

/* loaded from: source-2895416-dex2jar.jar:org/xml/sax/SAXException.class */
public class SAXException extends Exception {
    private Exception exception;

    public SAXException() {
        this.exception = null;
    }

    public SAXException(Exception exc) {
        this.exception = exc;
    }

    public SAXException(String str) {
        super(str);
        this.exception = null;
    }

    public SAXException(String str, Exception exc) {
        super(str);
        this.exception = exc;
    }

    public Exception getException() {
        return this.exception;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        String message = super.getMessage();
        String str = message;
        if (message == null) {
            str = message;
            if (this.exception != null) {
                str = this.exception.getMessage();
            }
        }
        return str;
    }

    @Override // java.lang.Throwable
    public String toString() {
        return this.exception != null ? this.exception.toString() : super.toString();
    }
}
