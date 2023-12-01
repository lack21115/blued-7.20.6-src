package io.grpc.internal;

/* loaded from: source-3503164-dex2jar.jar:io/grpc/internal/LongCounterFactory.class */
final class LongCounterFactory {
    LongCounterFactory() {
    }

    public static LongCounter create() {
        return ReflectionLongAdderCounter.isAvailable() ? new ReflectionLongAdderCounter() : new AtomicLongCounter();
    }
}
