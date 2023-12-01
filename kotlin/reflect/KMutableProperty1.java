package kotlin.reflect;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.reflect.KMutableProperty;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/reflect/KMutableProperty1.class */
public interface KMutableProperty1<T, V> extends KMutableProperty<V>, KProperty1<T, V> {

    @Metadata
    /* loaded from: source-3503164-dex2jar.jar:kotlin/reflect/KMutableProperty1$Setter.class */
    public interface Setter<T, V> extends Function2<T, V, Unit>, KMutableProperty.Setter<V> {
    }
}
