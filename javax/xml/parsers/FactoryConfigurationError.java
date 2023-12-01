package javax.xml.parsers;

/* loaded from: source-2895416-dex2jar.jar:javax/xml/parsers/FactoryConfigurationError.class */
public class FactoryConfigurationError extends Error {
    private Exception exception;

    public FactoryConfigurationError() {
        this.exception = null;
    }

    public FactoryConfigurationError(Exception exc) {
        super(exc.toString());
        this.exception = exc;
    }

    public FactoryConfigurationError(Exception exc, String str) {
        super(str);
        this.exception = exc;
    }

    public FactoryConfigurationError(String str) {
        super(str);
        this.exception = null;
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
}
