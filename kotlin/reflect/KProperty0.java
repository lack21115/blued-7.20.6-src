package kotlin.reflect;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.reflect.KProperty;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/reflect/KProperty0.class */
public interface KProperty0<V> extends Function0<V>, KProperty<V> {

    @Metadata
    /* loaded from: source-3503164-dex2jar.jar:kotlin/reflect/KProperty0$Getter.class */
    public interface Getter<V> extends Function0<V>, KProperty.Getter<V> {
    }

    V a();

    Getter<V> b();
}
