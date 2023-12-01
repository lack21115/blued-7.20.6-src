package kotlin.reflect;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.reflect.KMutableProperty;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/reflect/KMutableProperty2.class */
public interface KMutableProperty2<D, E, V> extends KMutableProperty<V>, KProperty2<D, E, V> {

    @Metadata
    /* loaded from: source-3503164-dex2jar.jar:kotlin/reflect/KMutableProperty2$Setter.class */
    public interface Setter<D, E, V> extends Function3<D, E, V, Unit>, KMutableProperty.Setter<V> {
    }
}
