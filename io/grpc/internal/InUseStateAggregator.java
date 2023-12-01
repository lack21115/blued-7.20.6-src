package io.grpc.internal;

import java.util.HashSet;

/* loaded from: source-3503164-dex2jar.jar:io/grpc/internal/InUseStateAggregator.class */
public abstract class InUseStateAggregator<T> {
    private final HashSet<T> inUseObjects = new HashSet<>();

    protected abstract void handleInUse();

    protected abstract void handleNotInUse();

    public final boolean isInUse() {
        return !this.inUseObjects.isEmpty();
    }

    public final void updateObjectInUse(T t, boolean z) {
        int size = this.inUseObjects.size();
        if (z) {
            this.inUseObjects.add(t);
            if (size == 0) {
                handleInUse();
            }
        } else if (this.inUseObjects.remove(t) && size == 1) {
            handleNotInUse();
        }
    }
}
