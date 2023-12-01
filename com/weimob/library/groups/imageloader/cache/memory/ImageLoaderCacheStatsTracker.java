package com.weimob.library.groups.imageloader.cache.memory;

import com.facebook.cache.common.CacheKey;
import com.facebook.imagepipeline.cache.CountingMemoryCache;
import com.facebook.imagepipeline.cache.ImageCacheStatsTracker;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: source-8829756-dex2jar.jar:com/weimob/library/groups/imageloader/cache/memory/ImageLoaderCacheStatsTracker.class */
public class ImageLoaderCacheStatsTracker implements ImageCacheStatsTracker {
    private boolean debug;
    private final Logger logger;

    /* loaded from: source-8829756-dex2jar.jar:com/weimob/library/groups/imageloader/cache/memory/ImageLoaderCacheStatsTracker$Singleton.class */
    enum Singleton {
        INSTANCE;
        
        private ImageLoaderCacheStatsTracker singleton = new ImageLoaderCacheStatsTracker();

        Singleton() {
        }

        public ImageLoaderCacheStatsTracker getInstance() {
            return this.singleton;
        }
    }

    private ImageLoaderCacheStatsTracker() {
        this.logger = Logger.getLogger("ImageCacheStatsTracker");
    }

    public static ImageLoaderCacheStatsTracker getInstance() {
        return Singleton.INSTANCE.getInstance();
    }

    private void log(String str) {
        if (this.debug) {
            this.logger.log(Level.INFO, str);
        }
    }

    public void onBitmapCacheHit(CacheKey cacheKey) {
        StringBuilder sb = new StringBuilder();
        sb.append(" 获取到缓存图片 ======> onBitmapCacheHit: ");
        sb.append(cacheKey != null ? cacheKey.getUriString() : null);
        log(sb.toString());
    }

    public void onBitmapCacheMiss() {
        log(" 没有获取到缓存图片 ======> onBitmapCacheMiss");
    }

    public void onBitmapCachePut() {
        log(" 尝试将图片缓存到内存 ======> onBitmapCachePut");
    }

    public void onDiskCacheGetFail() {
    }

    public void onDiskCacheHit() {
    }

    public void onDiskCacheHit(CacheKey cacheKey) {
    }

    public void onDiskCacheMiss() {
    }

    public void onMemoryCacheHit(CacheKey cacheKey) {
        StringBuilder sb = new StringBuilder();
        sb.append(" 获取到缓存的未解码(编码)图片 =======> onMemoryCacheHit: ");
        sb.append(cacheKey != null ? cacheKey.getUriString() : null);
        log(sb.toString());
    }

    public void onMemoryCacheMiss() {
        log(" 没有获取到缓存的未解码(编码)图片 =======> onMemoryCacheMiss");
    }

    public void onMemoryCachePut() {
        log(" 尝试将未解码(编码)图片缓存到内存 =======> onMemoryCachePut");
    }

    public void onStagingAreaHit(CacheKey cacheKey) {
    }

    public void onStagingAreaMiss() {
    }

    public void registerBitmapMemoryCache(CountingMemoryCache<?, ?> countingMemoryCache) {
        log(" 注册图片缓存 ======> registerBitmapMemoryCache: " + countingMemoryCache);
    }

    public void registerEncodedMemoryCache(CountingMemoryCache<?, ?> countingMemoryCache) {
        log(" 注册未解码(编码)图片缓存 ======> registerEncodedMemoryCache: " + countingMemoryCache);
    }

    public ImageLoaderCacheStatsTracker setDebug(boolean z) {
        this.debug = z;
        return this;
    }
}
