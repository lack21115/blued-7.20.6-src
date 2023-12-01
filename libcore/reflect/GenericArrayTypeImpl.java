package libcore.reflect;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.util.Objects;

/* loaded from: source-2895416-dex2jar.jar:libcore/reflect/GenericArrayTypeImpl.class */
public final class GenericArrayTypeImpl implements GenericArrayType {
    private final Type componentType;

    public GenericArrayTypeImpl(Type type) {
        this.componentType = type;
    }

    public boolean equals(Object obj) {
        if (obj instanceof GenericArrayType) {
            return Objects.equals(getGenericComponentType(), ((GenericArrayType) obj).getGenericComponentType());
        }
        return false;
    }

    @Override // java.lang.reflect.GenericArrayType
    public Type getGenericComponentType() {
        try {
            return ((ParameterizedTypeImpl) this.componentType).getResolvedType();
        } catch (ClassCastException e) {
            return this.componentType;
        }
    }

    public int hashCode() {
        return Objects.hashCode(getGenericComponentType());
    }

    public String toString() {
        return this.componentType.toString() + "[]";
    }
}
