package java.lang;

/* loaded from: source-2895416-dex2jar.jar:java/lang/InstantiationException.class */
public class InstantiationException extends ReflectiveOperationException {
    private static final long serialVersionUID = -8441929162975509110L;

    public InstantiationException() {
    }

    InstantiationException(Class<?> cls) {
        super(cls.getName());
    }

    public InstantiationException(String str) {
        super(str);
    }
}
