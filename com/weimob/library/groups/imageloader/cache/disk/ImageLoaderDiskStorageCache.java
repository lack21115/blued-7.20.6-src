package com.weimob.library.groups.imageloader.cache.disk;

import android.content.Context;
import com.facebook.cache.common.CacheErrorLogger;
import com.facebook.cache.common.CacheEventListener;
import com.facebook.cache.disk.DiskStorage;
import com.facebook.cache.disk.DiskStorageCache;
import com.facebook.cache.disk.EntryEvictionComparatorSupplier;
import com.facebook.common.disk.DiskTrimmableRegistry;
import java.util.Iterator;
import java.util.concurrent.Executor;

/* loaded from: source-8829756-dex2jar.jar:com/weimob/library/groups/imageloader/cache/disk/ImageLoaderDiskStorageCache.class */
public class ImageLoaderDiskStorageCache extends DiskStorageCache {
    private DiskStorage diskStorage;

    public ImageLoaderDiskStorageCache(DiskStorage diskStorage, EntryEvictionComparatorSupplier entryEvictionComparatorSupplier, DiskStorageCache.Params params, CacheEventListener cacheEventListener, CacheErrorLogger cacheErrorLogger, DiskTrimmableRegistry diskTrimmableRegistry, Context context, Executor executor, boolean z) {
        super(diskStorage, entryEvictionComparatorSupplier, params, cacheEventListener, cacheErrorLogger, diskTrimmableRegistry, context, executor, z);
        this.diskStorage = diskStorage;
    }

    public long getTotalSize() {
        long j;
        long j2 = 0;
        long j3 = 0;
        try {
            Iterator it = this.diskStorage.getEntries().iterator();
            while (true) {
                j3 = j2;
                j = j2;
                if (!it.hasNext()) {
                    break;
                }
                long j4 = j2;
                j2 += ((DiskStorage.Entry) it.next()).getSize();
            }
        } catch (Exception e) {
            e.printStackTrace();
            j = j3;
        }
        return j;
    }
}
