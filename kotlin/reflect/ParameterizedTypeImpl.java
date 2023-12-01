package kotlin.reflect;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/reflect/ParameterizedTypeImpl.class */
public final class ParameterizedTypeImpl implements ParameterizedType, TypeImpl {
    private final Class<?> a;
    private final Type b;
    private final Type[] c;

    public ParameterizedTypeImpl(Class<?> rawType, Type type, List<? extends Type> typeArguments) {
        Intrinsics.e(rawType, "rawType");
        Intrinsics.e(typeArguments, "typeArguments");
        this.a = rawType;
        this.b = type;
        Object[] array = typeArguments.toArray(new Type[0]);
        if (array == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        }
        this.c = (Type[]) array;
    }

    public boolean equals(Object obj) {
        if (obj instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) obj;
            return Intrinsics.a(this.a, parameterizedType.getRawType()) && Intrinsics.a(this.b, parameterizedType.getOwnerType()) && Arrays.equals(getActualTypeArguments(), parameterizedType.getActualTypeArguments());
        }
        return false;
    }

    @Override // java.lang.reflect.ParameterizedType
    public Type[] getActualTypeArguments() {
        return this.c;
    }

    @Override // java.lang.reflect.ParameterizedType
    public Type getOwnerType() {
        return this.b;
    }

    @Override // java.lang.reflect.ParameterizedType
    public Type getRawType() {
        return this.a;
    }

    public String getTypeName() {
        String b;
        String b2;
        StringBuilder sb = new StringBuilder();
        Type type = this.b;
        if (type != null) {
            b2 = TypesJVMKt.b(type);
            sb.append(b2);
            sb.append("$");
            sb.append(this.a.getSimpleName());
        } else {
            b = TypesJVMKt.b(this.a);
            sb.append(b);
        }
        if (!(this.c.length == 0)) {
            ArraysKt.a(this.c, sb, null, "<", ">", 0, null, ParameterizedTypeImpl$getTypeName$1$1.a, 50, null);
        }
        String sb2 = sb.toString();
        Intrinsics.c(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    public int hashCode() {
        int hashCode = this.a.hashCode();
        Type type = this.b;
        return (hashCode ^ (type != null ? type.hashCode() : 0)) ^ Arrays.hashCode(getActualTypeArguments());
    }

    public String toString() {
        return getTypeName();
    }
}
