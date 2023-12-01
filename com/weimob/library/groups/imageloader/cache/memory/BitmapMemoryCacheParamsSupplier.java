package com.weimob.library.groups.imageloader.cache.memory;

import com.facebook.common.internal.Supplier;
import com.facebook.imagepipeline.cache.MemoryCacheParams;

/* loaded from: source-8829756-dex2jar.jar:com/weimob/library/groups/imageloader/cache/memory/BitmapMemoryCacheParamsSupplier.class */
public class BitmapMemoryCacheParamsSupplier implements Supplier<MemoryCacheParams> {
    private static final int MAX_CACHE_ENTRIES = 128;
    private static final int MAX_CACHE_ENTRY_SIZE = Integer.MAX_VALUE;
    private static final int MAX_EVICTION_QUEUE_ENTRIES = Integer.MAX_VALUE;
    private static final int MAX_EVICTION_QUEUE_SIZE = Integer.MAX_VALUE;
    private int maxMemoryCacheSize;

    public BitmapMemoryCacheParamsSupplier() {
    }

    public BitmapMemoryCacheParamsSupplier(int i) {
        this.maxMemoryCacheSize = i;
    }

    /* renamed from: get */
    public MemoryCacheParams m8331get() {
        int i = this.maxMemoryCacheSize;
        return new MemoryCacheParams(i, 128, i, Integer.MAX_VALUE, Integer.MAX_VALUE);
    }
}
