package com.ss.android.socialbase.downloader.utils;

import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: source-8457232-dex2jar.jar:com/ss/android/socialbase/downloader/utils/LruCache.class */
public class LruCache<K, T> extends LinkedHashMap<K, T> {
    private static final int DEFAULT_SIZE = 4;
    private int mMaxSize;

    public LruCache() {
        this(4, 4);
    }

    public LruCache(int i, int i2) {
        this(i, i2, true);
    }

    public LruCache(int i, int i2, boolean z) {
        super(i, 0.75f, z);
        setMaxSize(i2);
    }

    @Override // java.util.LinkedHashMap
    protected boolean removeEldestEntry(Map.Entry<K, T> entry) {
        return size() > this.mMaxSize;
    }

    public void setMaxSize(int i) {
        this.mMaxSize = i;
    }
}
