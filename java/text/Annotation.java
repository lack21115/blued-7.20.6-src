package java.text;

/* loaded from: source-2895416-dex2jar.jar:java/text/Annotation.class */
public class Annotation {
    private Object value;

    public Annotation(Object obj) {
        this.value = obj;
    }

    public Object getValue() {
        return this.value;
    }

    public String toString() {
        return getClass().getName() + "[value=" + this.value + ']';
    }
}
