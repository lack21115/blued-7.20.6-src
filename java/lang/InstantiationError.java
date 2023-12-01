package java.lang;

/* loaded from: source-2895416-dex2jar.jar:java/lang/InstantiationError.class */
public class InstantiationError extends IncompatibleClassChangeError {
    private static final long serialVersionUID = -4885810657349421204L;

    public InstantiationError() {
    }

    InstantiationError(Class<?> cls) {
        super(cls.getName());
    }

    public InstantiationError(String str) {
        super(str);
    }
}
