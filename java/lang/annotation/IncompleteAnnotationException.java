package java.lang.annotation;

/* loaded from: source-2895416-dex2jar.jar:java/lang/annotation/IncompleteAnnotationException.class */
public class IncompleteAnnotationException extends RuntimeException {
    private static final long serialVersionUID = 8445097402741811912L;
    private Class<? extends Annotation> annotationType;
    private String elementName;

    public IncompleteAnnotationException(Class<? extends Annotation> cls, String str) {
        super("The element " + str + " is not complete for the annotation " + cls.getName());
        this.annotationType = cls;
        this.elementName = str;
    }

    public Class<? extends Annotation> annotationType() {
        return this.annotationType;
    }

    public String elementName() {
        return this.elementName;
    }
}
