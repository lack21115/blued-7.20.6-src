package kotlin.reflect;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KMutableProperty;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/reflect/KMutableProperty0.class */
public interface KMutableProperty0<V> extends KMutableProperty<V>, KProperty0<V> {

    @Metadata
    /* loaded from: source-3503164-dex2jar.jar:kotlin/reflect/KMutableProperty0$Setter.class */
    public interface Setter<V> extends Function1<V, Unit>, KMutableProperty.Setter<V> {
    }
}
