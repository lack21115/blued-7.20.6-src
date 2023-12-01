package com.kwad.sdk.core.imageloader.cache.memory.impl;

import com.kwad.sdk.core.imageloader.cache.memory.MemoryCache;
import com.kwad.sdk.core.imageloader.core.decode.DecodedResult;
import com.kwad.sdk.utils.ao;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashMap;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/imageloader/cache/memory/impl/LruMemoryCache.class */
public class LruMemoryCache implements MemoryCache {
    private final LinkedHashMap<String, DecodedResult> map;
    private final int maxSize;
    private int size;

    public LruMemoryCache(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        this.maxSize = i;
        this.map = new LinkedHashMap<>(0, 0.75f, true);
    }

    private int sizeOf(String str, DecodedResult decodedResult) {
        return decodedResult.getByteSize();
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x00a5, code lost:
        throw new java.lang.IllegalStateException(getClass().getName() + ".sizeOf() is reporting inconsistent results!");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void trimToSize(int r7) {
        /*
            r6 = this;
        L0:
            r0 = r6
            monitor-enter(r0)
            r0 = r6
            int r0 = r0.size     // Catch: java.lang.Throwable -> La6
            if (r0 < 0) goto L7f
            r0 = r6
            java.util.LinkedHashMap<java.lang.String, com.kwad.sdk.core.imageloader.core.decode.DecodedResult> r0 = r0.map     // Catch: java.lang.Throwable -> La6
            boolean r0 = r0.isEmpty()     // Catch: java.lang.Throwable -> La6
            if (r0 == 0) goto L1a
            r0 = r6
            int r0 = r0.size     // Catch: java.lang.Throwable -> La6
            if (r0 != 0) goto L7f
        L1a:
            r0 = r6
            int r0 = r0.size     // Catch: java.lang.Throwable -> La6
            r1 = r7
            if (r0 <= r1) goto L7c
            r0 = r6
            java.util.LinkedHashMap<java.lang.String, com.kwad.sdk.core.imageloader.core.decode.DecodedResult> r0 = r0.map     // Catch: java.lang.Throwable -> La6
            boolean r0 = r0.isEmpty()     // Catch: java.lang.Throwable -> La6
            if (r0 == 0) goto L2f
            goto L7c
        L2f:
            r0 = r6
            java.util.LinkedHashMap<java.lang.String, com.kwad.sdk.core.imageloader.core.decode.DecodedResult> r0 = r0.map     // Catch: java.lang.Throwable -> La6
            java.util.Set r0 = r0.entrySet()     // Catch: java.lang.Throwable -> La6
            java.util.Iterator r0 = r0.iterator()     // Catch: java.lang.Throwable -> La6
            java.lang.Object r0 = r0.next()     // Catch: java.lang.Throwable -> La6
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0     // Catch: java.lang.Throwable -> La6
            r9 = r0
            r0 = r9
            if (r0 != 0) goto L4b
            r0 = r6
            monitor-exit(r0)     // Catch: java.lang.Throwable -> La6
            return
        L4b:
            r0 = r9
            java.lang.Object r0 = r0.getKey()     // Catch: java.lang.Throwable -> La6
            java.lang.String r0 = (java.lang.String) r0     // Catch: java.lang.Throwable -> La6
            r8 = r0
            r0 = r9
            java.lang.Object r0 = r0.getValue()     // Catch: java.lang.Throwable -> La6
            com.kwad.sdk.core.imageloader.core.decode.DecodedResult r0 = (com.kwad.sdk.core.imageloader.core.decode.DecodedResult) r0     // Catch: java.lang.Throwable -> La6
            r9 = r0
            r0 = r6
            java.util.LinkedHashMap<java.lang.String, com.kwad.sdk.core.imageloader.core.decode.DecodedResult> r0 = r0.map     // Catch: java.lang.Throwable -> La6
            r1 = r8
            java.lang.Object r0 = r0.remove(r1)     // Catch: java.lang.Throwable -> La6
            r0 = r6
            r1 = r6
            int r1 = r1.size     // Catch: java.lang.Throwable -> La6
            r2 = r6
            r3 = r8
            r4 = r9
            int r2 = r2.sizeOf(r3, r4)     // Catch: java.lang.Throwable -> La6
            int r1 = r1 - r2
            r0.size = r1     // Catch: java.lang.Throwable -> La6
            r0 = r6
            monitor-exit(r0)     // Catch: java.lang.Throwable -> La6
            goto L0
        L7c:
            r0 = r6
            monitor-exit(r0)     // Catch: java.lang.Throwable -> La6
            return
        L7f:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> La6
            r1 = r0
            r1.<init>()     // Catch: java.lang.Throwable -> La6
            r8 = r0
            r0 = r8
            r1 = r6
            java.lang.Class r1 = r1.getClass()     // Catch: java.lang.Throwable -> La6
            java.lang.String r1 = r1.getName()     // Catch: java.lang.Throwable -> La6
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch: java.lang.Throwable -> La6
            r0 = r8
            java.lang.String r1 = ".sizeOf() is reporting inconsistent results!"
            java.lang.StringBuilder r0 = r0.append(r1)     // Catch: java.lang.Throwable -> La6
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> La6
            r1 = r0
            r2 = r8
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> La6
            r1.<init>(r2)     // Catch: java.lang.Throwable -> La6
            throw r0     // Catch: java.lang.Throwable -> La6
        La6:
            r8 = move-exception
            r0 = r6
            monitor-exit(r0)     // Catch: java.lang.Throwable -> La6
            r0 = r8
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.core.imageloader.cache.memory.impl.LruMemoryCache.trimToSize(int):void");
    }

    @Override // com.kwad.sdk.core.imageloader.cache.memory.MemoryCache
    public void clear() {
        trimToSize(-1);
    }

    @Override // com.kwad.sdk.core.imageloader.cache.memory.MemoryCache
    public final DecodedResult get(String str) {
        DecodedResult decodedResult;
        ao.ah(str, "key");
        synchronized (this) {
            decodedResult = this.map.get(str);
        }
        return decodedResult;
    }

    @Override // com.kwad.sdk.core.imageloader.cache.memory.MemoryCache
    public Collection<String> keys() {
        HashSet hashSet;
        synchronized (this) {
            hashSet = new HashSet(this.map.keySet());
        }
        return hashSet;
    }

    @Override // com.kwad.sdk.core.imageloader.cache.memory.MemoryCache
    public final boolean put(String str, DecodedResult decodedResult) {
        ao.ah(str, "key");
        ao.f(decodedResult, "value");
        synchronized (this) {
            this.size += sizeOf(str, decodedResult);
            DecodedResult put = this.map.put(str, decodedResult);
            if (put != null) {
                this.size -= sizeOf(str, put);
            }
        }
        trimToSize(this.maxSize);
        return true;
    }

    @Override // com.kwad.sdk.core.imageloader.cache.memory.MemoryCache
    public final DecodedResult remove(String str) {
        DecodedResult remove;
        ao.ah(str, "key");
        synchronized (this) {
            remove = this.map.remove(str);
            if (remove != null) {
                this.size -= sizeOf(str, remove);
            }
        }
        return remove;
    }

    public final String toString() {
        String format;
        synchronized (this) {
            format = String.format("LruCache[maxSize=%d]", Integer.valueOf(this.maxSize));
        }
        return format;
    }
}
