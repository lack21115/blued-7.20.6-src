package java.lang.reflect;

import java.lang.reflect.GenericDeclaration;

/* loaded from: source-2895416-dex2jar.jar:java/lang/reflect/TypeVariable.class */
public interface TypeVariable<D extends GenericDeclaration> extends Type {
    Type[] getBounds();

    D getGenericDeclaration();

    String getName();
}
