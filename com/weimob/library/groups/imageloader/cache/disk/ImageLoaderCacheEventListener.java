package com.weimob.library.groups.imageloader.cache.disk;

import com.facebook.cache.common.CacheEvent;
import com.facebook.cache.common.CacheEventListener;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: source-8829756-dex2jar.jar:com/weimob/library/groups/imageloader/cache/disk/ImageLoaderCacheEventListener.class */
public class ImageLoaderCacheEventListener implements CacheEventListener {
    private boolean debug;
    private final Logger logger;

    /* loaded from: source-8829756-dex2jar.jar:com/weimob/library/groups/imageloader/cache/disk/ImageLoaderCacheEventListener$Singleton.class */
    enum Singleton {
        INSTANCE;
        
        private ImageLoaderCacheEventListener singleton = new ImageLoaderCacheEventListener();

        Singleton() {
        }

        public ImageLoaderCacheEventListener getInstance() {
            return this.singleton;
        }
    }

    private ImageLoaderCacheEventListener() {
        this.logger = Logger.getLogger("ImageDiskStatsTracker");
    }

    public static ImageLoaderCacheEventListener getInstance() {
        return Singleton.INSTANCE.getInstance();
    }

    private void log(String str) {
        if (this.debug) {
            this.logger.log(Level.INFO, str);
        }
    }

    public void onCleared() {
    }

    public void onEviction(CacheEvent cacheEvent) {
    }

    public void onHit(CacheEvent cacheEvent) {
        StringBuilder sb = new StringBuilder();
        sb.append(" 获取磁盘缓存 =========> onHit: ");
        sb.append(cacheEvent != null ? cacheEvent.getCacheKey() : null);
        log(sb.toString());
    }

    public void onMiss(CacheEvent cacheEvent) {
        StringBuilder sb = new StringBuilder();
        sb.append(" 没有获取磁盘缓存 =========> onMiss: ");
        sb.append(cacheEvent != null ? cacheEvent.getCacheKey() : null);
        log(sb.toString());
    }

    public void onReadException(CacheEvent cacheEvent) {
        StringBuilder sb = new StringBuilder();
        sb.append(" 磁盘缓存读取异常 =========> onReadException: ");
        sb.append(cacheEvent != null ? cacheEvent.getCacheKey() : null);
        log(sb.toString());
    }

    public void onWriteAttempt(CacheEvent cacheEvent) {
        StringBuilder sb = new StringBuilder();
        sb.append(" 磁盘缓存开始尝试写入 =========> onWriteAttempt: ");
        sb.append(cacheEvent != null ? cacheEvent.getCacheKey() : null);
        log(sb.toString());
    }

    public void onWriteException(CacheEvent cacheEvent) {
        StringBuilder sb = new StringBuilder();
        sb.append(" 磁盘缓存写入异常 =========> onWriteException: ");
        sb.append(cacheEvent != null ? cacheEvent.getCacheKey() : null);
        log(sb.toString());
    }

    public void onWriteSuccess(CacheEvent cacheEvent) {
        StringBuilder sb = new StringBuilder();
        sb.append(" 磁盘缓存开始写入成功 =========> onWriteSuccess: ");
        sb.append(cacheEvent != null ? cacheEvent.getCacheKey() : null);
        log(sb.toString());
    }

    public ImageLoaderCacheEventListener setDebug(boolean z) {
        this.debug = z;
        return this;
    }
}
