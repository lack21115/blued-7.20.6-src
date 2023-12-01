package javax.xml.transform;

/* loaded from: source-2895416-dex2jar.jar:javax/xml/transform/ErrorListener.class */
public interface ErrorListener {
    void error(TransformerException transformerException) throws TransformerException;

    void fatalError(TransformerException transformerException) throws TransformerException;

    void warning(TransformerException transformerException) throws TransformerException;
}
