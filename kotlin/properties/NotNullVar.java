package kotlin.properties;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/properties/NotNullVar.class */
final class NotNullVar<T> implements ReadWriteProperty<Object, T> {

    /* renamed from: a  reason: collision with root package name */
    private T f42560a;

    @Override // kotlin.properties.ReadOnlyProperty
    public T b(Object obj, KProperty<?> property) {
        Intrinsics.e(property, "property");
        T t = this.f42560a;
        if (t != null) {
            return t;
        }
        throw new IllegalStateException("Property " + property.getName() + " should be initialized before get.");
    }
}
