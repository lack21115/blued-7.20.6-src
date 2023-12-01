package com.google.common.cache;

import com.google.common.base.Supplier;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: source-8110460-dex2jar.jar:com/google/common/cache/LongAddables.class */
final class LongAddables {
    private static final Supplier<LongAddable> SUPPLIER;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8110460-dex2jar.jar:com/google/common/cache/LongAddables$PureJavaLongAddable.class */
    public static final class PureJavaLongAddable extends AtomicLong implements LongAddable {
        private PureJavaLongAddable() {
        }

        @Override // com.google.common.cache.LongAddable
        public void add(long j) {
            getAndAdd(j);
        }

        @Override // com.google.common.cache.LongAddable
        public void increment() {
            getAndIncrement();
        }

        @Override // com.google.common.cache.LongAddable
        public long sum() {
            return get();
        }
    }

    static {
        Supplier<LongAddable> supplier;
        try {
            new LongAdder();
            supplier = new Supplier<LongAddable>() { // from class: com.google.common.cache.LongAddables.1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.google.common.base.Supplier
                public LongAddable get() {
                    return new LongAdder();
                }
            };
        } catch (Throwable th) {
            supplier = new Supplier<LongAddable>() { // from class: com.google.common.cache.LongAddables.2
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.google.common.base.Supplier
                public LongAddable get() {
                    return new PureJavaLongAddable();
                }
            };
        }
        SUPPLIER = supplier;
    }

    LongAddables() {
    }

    public static LongAddable create() {
        return SUPPLIER.get();
    }
}
