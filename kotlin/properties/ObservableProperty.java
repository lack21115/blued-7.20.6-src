package kotlin.properties;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/properties/ObservableProperty.class */
public abstract class ObservableProperty<V> implements ReadWriteProperty<Object, V> {

    /* renamed from: a  reason: collision with root package name */
    private V f42561a;

    @Override // kotlin.properties.ReadOnlyProperty
    public V b(Object obj, KProperty<?> property) {
        Intrinsics.e(property, "property");
        return this.f42561a;
    }
}
