package kotlin.reflect;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/reflect/GenericArrayTypeImpl.class */
public final class GenericArrayTypeImpl implements GenericArrayType, TypeImpl {
    private final Type a;

    public GenericArrayTypeImpl(Type elementType) {
        Intrinsics.e(elementType, "elementType");
        this.a = elementType;
    }

    public boolean equals(Object obj) {
        return (obj instanceof GenericArrayType) && Intrinsics.a(getGenericComponentType(), ((GenericArrayType) obj).getGenericComponentType());
    }

    @Override // java.lang.reflect.GenericArrayType
    public Type getGenericComponentType() {
        return this.a;
    }

    public String getTypeName() {
        String b;
        StringBuilder sb = new StringBuilder();
        b = TypesJVMKt.b(this.a);
        sb.append(b);
        sb.append("[]");
        return sb.toString();
    }

    public int hashCode() {
        return getGenericComponentType().hashCode();
    }

    public String toString() {
        return getTypeName();
    }
}
