package java.lang.reflect;

/* loaded from: source-2895416-dex2jar.jar:java/lang/reflect/Member.class */
public interface Member {
    public static final int DECLARED = 1;
    public static final int PUBLIC = 0;

    Class<?> getDeclaringClass();

    int getModifiers();

    String getName();

    boolean isSynthetic();
}
