package java.lang.annotation;

/* loaded from: source-2895416-dex2jar.jar:java/lang/annotation/Annotation.class */
public interface Annotation {
    Class<? extends Annotation> annotationType();

    boolean equals(Object obj);

    int hashCode();

    String toString();
}
