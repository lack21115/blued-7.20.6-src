package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import com.google.common.primitives.Primitives;
import com.google.errorprone.annotations.Immutable;
import java.io.Serializable;
import java.util.Map;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

@Immutable(containerOf = {"B"})
/* loaded from: source-8110460-dex2jar.jar:com/google/common/collect/ImmutableClassToInstanceMap.class */
public final class ImmutableClassToInstanceMap<B> extends ForwardingMap<Class<? extends B>, B> implements ClassToInstanceMap<B>, Serializable {
    private static final ImmutableClassToInstanceMap<Object> EMPTY = new ImmutableClassToInstanceMap<>(ImmutableMap.of());
    private final ImmutableMap<Class<? extends B>, B> delegate;

    /* loaded from: source-8110460-dex2jar.jar:com/google/common/collect/ImmutableClassToInstanceMap$Builder.class */
    public static final class Builder<B> {
        private final ImmutableMap.Builder<Class<? extends B>, B> mapBuilder = ImmutableMap.builder();

        private static <B, T extends B> T cast(Class<T> cls, B b) {
            return (T) Primitives.wrap(cls).cast(b);
        }

        public ImmutableClassToInstanceMap<B> build() {
            ImmutableMap<Class<? extends B>, B> build = this.mapBuilder.build();
            return build.isEmpty() ? ImmutableClassToInstanceMap.of() : new ImmutableClassToInstanceMap<>(build);
        }

        public <T extends B> Builder<B> put(Class<T> cls, T t) {
            this.mapBuilder.put(cls, t);
            return this;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public <T extends B> Builder<B> putAll(Map<? extends Class<? extends T>, ? extends T> map) {
            for (Map.Entry<? extends Class<? extends T>, ? extends T> entry : map.entrySet()) {
                Class<? extends T> key = entry.getKey();
                this.mapBuilder.put(key, cast(key, entry.getValue()));
            }
            return this;
        }
    }

    private ImmutableClassToInstanceMap(ImmutableMap<Class<? extends B>, B> immutableMap) {
        this.delegate = immutableMap;
    }

    public static <B> Builder<B> builder() {
        return new Builder<>();
    }

    public static <B, S extends B> ImmutableClassToInstanceMap<B> copyOf(Map<? extends Class<? extends S>, ? extends S> map) {
        return map instanceof ImmutableClassToInstanceMap ? (ImmutableClassToInstanceMap) map : new Builder().putAll(map).build();
    }

    public static <B> ImmutableClassToInstanceMap<B> of() {
        return (ImmutableClassToInstanceMap<B>) EMPTY;
    }

    public static <B, T extends B> ImmutableClassToInstanceMap<B> of(Class<T> cls, T t) {
        return new ImmutableClassToInstanceMap<>(ImmutableMap.of(cls, t));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.common.collect.ForwardingMap, com.google.common.collect.ForwardingObject
    public Map<Class<? extends B>, B> delegate() {
        return this.delegate;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [T extends B, java.lang.Object] */
    @Override // com.google.common.collect.ClassToInstanceMap
    @NullableDecl
    public <T extends B> T getInstance(Class<T> cls) {
        return this.delegate.get(Preconditions.checkNotNull(cls));
    }

    @Override // com.google.common.collect.ClassToInstanceMap
    @Deprecated
    public <T extends B> T putInstance(Class<T> cls, T t) {
        throw new UnsupportedOperationException();
    }

    Object readResolve() {
        return isEmpty() ? of() : this;
    }
}
