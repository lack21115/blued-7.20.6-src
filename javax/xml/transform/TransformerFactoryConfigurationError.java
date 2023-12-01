package javax.xml.transform;

/* loaded from: source-2895416-dex2jar.jar:javax/xml/transform/TransformerFactoryConfigurationError.class */
public class TransformerFactoryConfigurationError extends Error {
    private Exception exception;

    public TransformerFactoryConfigurationError() {
        this.exception = null;
    }

    public TransformerFactoryConfigurationError(Exception exc) {
        super(exc.toString());
        this.exception = exc;
    }

    public TransformerFactoryConfigurationError(Exception exc, String str) {
        super(str);
        this.exception = exc;
    }

    public TransformerFactoryConfigurationError(String str) {
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
