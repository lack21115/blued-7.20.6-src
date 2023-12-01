package java.lang.reflect;

/* loaded from: source-2895416-dex2jar.jar:java/lang/reflect/ParameterizedType.class */
public interface ParameterizedType extends Type {
    Type[] getActualTypeArguments();

    Type getOwnerType();

    Type getRawType();
}
