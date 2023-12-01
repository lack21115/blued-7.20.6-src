package com.weimob.library.groups.imageloader.cache.disk;

import com.facebook.cache.disk.DiskCacheConfig;
import com.facebook.cache.disk.DiskStorage;
import com.facebook.cache.disk.DiskStorageCache;
import com.facebook.cache.disk.FileCache;
import com.facebook.imagepipeline.core.DiskStorageFactory;
import com.facebook.imagepipeline.core.DynamicDefaultDiskStorageFactory;
import com.facebook.imagepipeline.core.FileCacheFactory;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/* loaded from: source-8829756-dex2jar.jar:com/weimob/library/groups/imageloader/cache/disk/ImageLoaderDiskStorageCacheFactory.class */
public class ImageLoaderDiskStorageCacheFactory implements FileCacheFactory {
    private DiskStorageFactory mDiskStorageFactory;

    /* loaded from: source-8829756-dex2jar.jar:com/weimob/library/groups/imageloader/cache/disk/ImageLoaderDiskStorageCacheFactory$Singleton.class */
    enum Singleton {
        INSTANCE;
        
        private ImageLoaderDiskStorageCacheFactory singleton = new ImageLoaderDiskStorageCacheFactory();

        Singleton() {
        }

        public ImageLoaderDiskStorageCacheFactory getInstance() {
            return this.singleton;
        }
    }

    private ImageLoaderDiskStorageCacheFactory() {
        this.mDiskStorageFactory = new DynamicDefaultDiskStorageFactory();
    }

    private DiskStorageCache buildDiskStorageCache(DiskCacheConfig diskCacheConfig, DiskStorage diskStorage) {
        return buildDiskStorageCache(diskCacheConfig, diskStorage, Executors.newSingleThreadExecutor());
    }

    private DiskStorageCache buildDiskStorageCache(DiskCacheConfig diskCacheConfig, DiskStorage diskStorage, Executor executor) {
        return new ImageLoaderDiskStorageCache(diskStorage, diskCacheConfig.getEntryEvictionComparatorSupplier(), new DiskStorageCache.Params(diskCacheConfig.getMinimumSizeLimit(), diskCacheConfig.getLowDiskSpaceSizeLimit(), diskCacheConfig.getDefaultSizeLimit()), diskCacheConfig.getCacheEventListener(), diskCacheConfig.getCacheErrorLogger(), diskCacheConfig.getDiskTrimmableRegistry(), diskCacheConfig.getContext(), executor, diskCacheConfig.getIndexPopulateAtStartupEnabled());
    }

    public static ImageLoaderDiskStorageCacheFactory getInstance() {
        return Singleton.INSTANCE.getInstance();
    }

    public FileCache get(DiskCacheConfig diskCacheConfig) {
        return buildDiskStorageCache(diskCacheConfig, this.mDiskStorageFactory.get(diskCacheConfig));
    }
}
