package kotlin.reflect;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.reflect.KProperty;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/reflect/KMutableProperty.class */
public interface KMutableProperty<V> extends KProperty<V> {

    @Metadata
    /* loaded from: source-3503164-dex2jar.jar:kotlin/reflect/KMutableProperty$Setter.class */
    public interface Setter<V> extends KFunction<Unit>, KProperty.Accessor<V> {
    }
}
