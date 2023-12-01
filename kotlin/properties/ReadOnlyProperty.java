package kotlin.properties;

import kotlin.Metadata;
import kotlin.reflect.KProperty;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/properties/ReadOnlyProperty.class */
public interface ReadOnlyProperty<T, V> {
    V b(T t, KProperty<?> kProperty);
}
