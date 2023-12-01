package android.hardware.camera2.utils;

import com.android.internal.util.Preconditions;
import com.j256.ormlite.stmt.query.SimpleComparison;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;

/* loaded from: source-9557208-dex2jar.jar:android/hardware/camera2/utils/TypeReference.class */
public abstract class TypeReference<T> {
    private final int mHash;
    private final Type mType;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-9557208-dex2jar.jar:android/hardware/camera2/utils/TypeReference$SpecializedBaseTypeReference.class */
    public static class SpecializedBaseTypeReference extends TypeReference {
        public SpecializedBaseTypeReference(Type type) {
            super(type);
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/hardware/camera2/utils/TypeReference$SpecializedTypeReference.class */
    private static class SpecializedTypeReference<T> extends TypeReference<T> {
        public SpecializedTypeReference(Class<T> cls) {
            super(cls);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public TypeReference() {
        this.mType = ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        if (containsTypeVariable(this.mType)) {
            throw new IllegalArgumentException("Including a type variable in a type reference is not allowed");
        }
        this.mHash = this.mType.hashCode();
    }

    private TypeReference(Type type) {
        this.mType = type;
        if (containsTypeVariable(this.mType)) {
            throw new IllegalArgumentException("Including a type variable in a type reference is not allowed");
        }
        this.mHash = this.mType.hashCode();
    }

    public static boolean containsTypeVariable(Type type) {
        if (type == null) {
            return false;
        }
        if (type instanceof TypeVariable) {
            return true;
        }
        if (type instanceof Class) {
            Class cls = (Class) type;
            if (cls.getTypeParameters().length != 0) {
                return true;
            }
            return containsTypeVariable(cls.getDeclaringClass());
        } else if (!(type instanceof ParameterizedType)) {
            if (type instanceof WildcardType) {
                WildcardType wildcardType = (WildcardType) type;
                return containsTypeVariable(wildcardType.getLowerBounds()) || containsTypeVariable(wildcardType.getUpperBounds());
            }
            return false;
        } else {
            Type[] actualTypeArguments = ((ParameterizedType) type).getActualTypeArguments();
            int length = actualTypeArguments.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    return false;
                }
                if (containsTypeVariable(actualTypeArguments[i2])) {
                    return true;
                }
                i = i2 + 1;
            }
        }
    }

    private static boolean containsTypeVariable(Type[] typeArr) {
        if (typeArr == null) {
            return false;
        }
        int length = typeArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return false;
            }
            if (containsTypeVariable(typeArr[i2])) {
                return true;
            }
            i = i2 + 1;
        }
    }

    public static <T> TypeReference<T> createSpecializedTypeReference(Class<T> cls) {
        return new SpecializedTypeReference(cls);
    }

    public static TypeReference<?> createSpecializedTypeReference(Type type) {
        return new SpecializedBaseTypeReference(type);
    }

    private static final Class<?> getArrayClass(Class<?> cls) {
        return Array.newInstance(cls, 0).getClass();
    }

    private static Type getComponentType(Type type) {
        Preconditions.checkNotNull(type, "type must not be null");
        if (type instanceof Class) {
            return ((Class) type).getComponentType();
        }
        if (type instanceof ParameterizedType) {
            return null;
        }
        if (type instanceof GenericArrayType) {
            return ((GenericArrayType) type).getGenericComponentType();
        }
        if (type instanceof WildcardType) {
            throw new UnsupportedOperationException("TODO: support wild card components");
        }
        if (type instanceof TypeVariable) {
            throw new AssertionError("Type variables are not allowed in type references");
        }
        throw new AssertionError("Unhandled branch to get component type for type " + type);
    }

    private static final Class<?> getRawType(Type type) {
        if (type == null) {
            throw new NullPointerException("type must not be null");
        }
        if (type instanceof Class) {
            return (Class) type;
        }
        if (type instanceof ParameterizedType) {
            return (Class) ((ParameterizedType) type).getRawType();
        }
        if (type instanceof GenericArrayType) {
            return getArrayClass(getRawType(((GenericArrayType) type).getGenericComponentType()));
        }
        if (type instanceof WildcardType) {
            return getRawType(((WildcardType) type).getUpperBounds());
        }
        if (type instanceof TypeVariable) {
            throw new AssertionError("Type variables are not allowed in type references");
        }
        throw new AssertionError("Unhandled branch to get raw type for type " + type);
    }

    private static final Class<?> getRawType(Type[] typeArr) {
        Class<?> cls;
        if (typeArr == null) {
            cls = null;
        } else {
            int length = typeArr.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    return null;
                }
                Class<?> rawType = getRawType(typeArr[i2]);
                cls = rawType;
                if (rawType != null) {
                    break;
                }
                i = i2 + 1;
            }
        }
        return cls;
    }

    private static void toString(Type type, StringBuilder sb) {
        if (type == null) {
            return;
        }
        if (type instanceof TypeVariable) {
            sb.append(((TypeVariable) type).getName());
        } else if (type instanceof Class) {
            Class cls = (Class) type;
            sb.append(cls.getName());
            toString(cls.getTypeParameters(), sb);
        } else if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            sb.append(((Class) parameterizedType.getRawType()).getName());
            toString(parameterizedType.getActualTypeArguments(), sb);
        } else if (!(type instanceof GenericArrayType)) {
            sb.append(type.toString());
        } else {
            toString(((GenericArrayType) type).getGenericComponentType(), sb);
            sb.append("[]");
        }
    }

    private static void toString(Type[] typeArr, StringBuilder sb) {
        if (typeArr == null || typeArr.length == 0) {
            return;
        }
        sb.append(SimpleComparison.LESS_THAN_OPERATION);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= typeArr.length) {
                sb.append(SimpleComparison.GREATER_THAN_OPERATION);
                return;
            }
            toString(typeArr[i2], sb);
            if (i2 != typeArr.length - 1) {
                sb.append(", ");
            }
            i = i2 + 1;
        }
    }

    public boolean equals(Object obj) {
        return (obj instanceof TypeReference) && this.mType.equals(((TypeReference) obj).mType);
    }

    public TypeReference<?> getComponentType() {
        Type componentType = getComponentType(this.mType);
        if (componentType != null) {
            return createSpecializedTypeReference(componentType);
        }
        return null;
    }

    public final Class<? super T> getRawType() {
        return (Class<? super T>) getRawType(this.mType);
    }

    public Type getType() {
        return this.mType;
    }

    public int hashCode() {
        return this.mHash;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("TypeReference<");
        toString(getType(), sb);
        sb.append(SimpleComparison.GREATER_THAN_OPERATION);
        return sb.toString();
    }
}
