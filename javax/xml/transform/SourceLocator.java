package javax.xml.transform;

/* loaded from: source-2895416-dex2jar.jar:javax/xml/transform/SourceLocator.class */
public interface SourceLocator {
    int getColumnNumber();

    int getLineNumber();

    String getPublicId();

    String getSystemId();
}
