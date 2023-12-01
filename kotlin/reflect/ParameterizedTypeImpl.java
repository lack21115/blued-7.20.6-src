package kotlin.reflect;

import com.j256.ormlite.stmt.query.SimpleComparison;
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

    /* renamed from: a  reason: collision with root package name */
    private final Class<?> f42606a;
    private final Type b;

    /* renamed from: c  reason: collision with root package name */
    private final Type[] f42607c;

    public ParameterizedTypeImpl(Class<?> rawType, Type type, List<? extends Type> typeArguments) {
        Intrinsics.e(rawType, "rawType");
        Intrinsics.e(typeArguments, "typeArguments");
        this.f42606a = rawType;
        this.b = type;
        Object[] array = typeArguments.toArray(new Type[0]);
        if (array == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        }
        this.f42607c = (Type[]) array;
    }

    public boolean equals(Object obj) {
        if (obj instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) obj;
            return Intrinsics.a(this.f42606a, parameterizedType.getRawType()) && Intrinsics.a(this.b, parameterizedType.getOwnerType()) && Arrays.equals(getActualTypeArguments(), parameterizedType.getActualTypeArguments());
        }
        return false;
    }

    @Override // java.lang.reflect.ParameterizedType
    public Type[] getActualTypeArguments() {
        return this.f42607c;
    }

    @Override // java.lang.reflect.ParameterizedType
    public Type getOwnerType() {
        return this.b;
    }

    @Override // java.lang.reflect.ParameterizedType
    public Type getRawType() {
        return this.f42606a;
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
            sb.append(this.f42606a.getSimpleName());
        } else {
            b = TypesJVMKt.b(this.f42606a);
            sb.append(b);
        }
        if (!(this.f42607c.length == 0)) {
            ArraysKt.a(this.f42607c, sb, null, SimpleComparison.LESS_THAN_OPERATION, SimpleComparison.GREATER_THAN_OPERATION, 0, null, ParameterizedTypeImpl$getTypeName$1$1.f42608a, 50, null);
        }
        String sb2 = sb.toString();
        Intrinsics.c(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    public int hashCode() {
        int hashCode = this.f42606a.hashCode();
        Type type = this.b;
        return (hashCode ^ (type != null ? type.hashCode() : 0)) ^ Arrays.hashCode(getActualTypeArguments());
    }

    public String toString() {
        return getTypeName();
    }
}
