package kotlin.reflect;

import kotlin.Metadata;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/reflect/KProperty.class */
public interface KProperty<V> extends KCallable<V> {

    @Metadata
    /* loaded from: source-3503164-dex2jar.jar:kotlin/reflect/KProperty$Accessor.class */
    public interface Accessor<V> {
    }

    @Metadata
    /* loaded from: source-3503164-dex2jar.jar:kotlin/reflect/KProperty$DefaultImpls.class */
    public static final class DefaultImpls {
    }

    @Metadata
    /* loaded from: source-3503164-dex2jar.jar:kotlin/reflect/KProperty$Getter.class */
    public interface Getter<V> extends KFunction<V>, Accessor<V> {
    }
}
