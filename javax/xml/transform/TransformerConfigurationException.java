package javax.xml.transform;

/* loaded from: source-2895416-dex2jar.jar:javax/xml/transform/TransformerConfigurationException.class */
public class TransformerConfigurationException extends TransformerException {
    public TransformerConfigurationException() {
        super("Configuration Error");
    }

    public TransformerConfigurationException(String str) {
        super(str);
    }

    public TransformerConfigurationException(String str, Throwable th) {
        super(str, th);
    }

    public TransformerConfigurationException(String str, SourceLocator sourceLocator) {
        super(str, sourceLocator);
    }

    public TransformerConfigurationException(String str, SourceLocator sourceLocator, Throwable th) {
        super(str, sourceLocator, th);
    }

    public TransformerConfigurationException(Throwable th) {
        super(th);
    }
}
