package kotlin.reflect;

import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.reflect.KProperty;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/reflect/KProperty2.class */
public interface KProperty2<D, E, V> extends Function2<D, E, V>, KProperty<V> {

    @Metadata
    /* loaded from: source-3503164-dex2jar.jar:kotlin/reflect/KProperty2$Getter.class */
    public interface Getter<D, E, V> extends Function2<D, E, V>, KProperty.Getter<V> {
    }

    V a(D d, E e);

    Getter<D, E, V> a();
}
