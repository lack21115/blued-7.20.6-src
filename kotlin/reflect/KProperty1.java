package kotlin.reflect;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/reflect/KProperty1.class */
public interface KProperty1<T, V> extends Function1<T, V>, KProperty<V> {

    @Metadata
    /* loaded from: source-3503164-dex2jar.jar:kotlin/reflect/KProperty1$Getter.class */
    public interface Getter<T, V> extends Function1<T, V>, KProperty.Getter<V> {
    }

    V a(T t);

    Getter<T, V> a();
}
