package kotlin.reflect;

import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/reflect/TypeVariableImpl.class */
public final class TypeVariableImpl implements TypeVariable<GenericDeclaration>, TypeImpl {

    /* renamed from: a  reason: collision with root package name */
    private final KTypeParameter f42609a;

    public TypeVariableImpl(KTypeParameter typeParameter) {
        Intrinsics.e(typeParameter, "typeParameter");
        this.f42609a = typeParameter;
    }

    public boolean equals(Object obj) {
        if (obj instanceof TypeVariable) {
            TypeVariable typeVariable = (TypeVariable) obj;
            return Intrinsics.a((Object) getName(), (Object) typeVariable.getName()) && Intrinsics.a(getGenericDeclaration(), typeVariable.getGenericDeclaration());
        }
        return false;
    }

    @Override // java.lang.reflect.TypeVariable
    public Type[] getBounds() {
        Type b;
        List<KType> c2 = this.f42609a.c();
        ArrayList arrayList = new ArrayList(CollectionsKt.a((Iterable) c2, 10));
        for (KType kType : c2) {
            b = TypesJVMKt.b(kType, true);
            arrayList.add(b);
        }
        Object[] array = arrayList.toArray(new Type[0]);
        if (array != null) {
            return (Type[]) array;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
    }

    @Override // java.lang.reflect.TypeVariable
    public GenericDeclaration getGenericDeclaration() {
        throw new NotImplementedError("An operation is not implemented: " + ("getGenericDeclaration() is not yet supported for type variables created from KType: " + this.f42609a));
    }

    @Override // java.lang.reflect.TypeVariable
    public String getName() {
        return this.f42609a.a();
    }

    public String getTypeName() {
        return getName();
    }

    public int hashCode() {
        return getName().hashCode() ^ getGenericDeclaration().hashCode();
    }

    public String toString() {
        return getTypeName();
    }
}
