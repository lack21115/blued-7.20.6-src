package java.lang.annotation;

import java.lang.reflect.Method;

/* loaded from: source-2895416-dex2jar.jar:java/lang/annotation/AnnotationTypeMismatchException.class */
public class AnnotationTypeMismatchException extends RuntimeException {
    private static final long serialVersionUID = 8125925355765570191L;
    private Method element;
    private String foundType;

    public AnnotationTypeMismatchException(Method method, String str) {
        super("The annotation element " + method + " doesn't match the type " + str);
        this.element = method;
        this.foundType = str;
    }

    public Method element() {
        return this.element;
    }

    public String foundType() {
        return this.foundType;
    }
}
