package com.weimob.library.groups.imageloader.cache.memory;

import com.facebook.common.internal.Supplier;
import com.facebook.imagepipeline.cache.MemoryCacheParams;

/* loaded from: source-8829756-dex2jar.jar:com/weimob/library/groups/imageloader/cache/memory/EncodedMemoryCacheParamsSupplier.class */
public class EncodedMemoryCacheParamsSupplier implements Supplier<MemoryCacheParams> {
    private static final int MAX_CACHE_ENTRIES = Integer.MAX_VALUE;
    private static final int MAX_EVICTION_QUEUE_ENTRIES = Integer.MAX_VALUE;
    private int maxMemoryCacheSize;

    public EncodedMemoryCacheParamsSupplier() {
    }

    public EncodedMemoryCacheParamsSupplier(int i) {
        this.maxMemoryCacheSize = i;
    }

    /* renamed from: get */
    public MemoryCacheParams m11375get() {
        int i = this.maxMemoryCacheSize / 8;
        int i2 = this.maxMemoryCacheSize;
        return new MemoryCacheParams(i2, Integer.MAX_VALUE, i2, Integer.MAX_VALUE, i);
    }
}
