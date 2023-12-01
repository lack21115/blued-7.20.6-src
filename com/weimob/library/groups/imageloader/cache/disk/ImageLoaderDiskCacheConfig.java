package com.weimob.library.groups.imageloader.cache.disk;

import android.content.Context;
import com.facebook.cache.disk.DiskCacheConfig;
import java.io.File;

/* loaded from: source-8829756-dex2jar.jar:com/weimob/library/groups/imageloader/cache/disk/ImageLoaderDiskCacheConfig.class */
public class ImageLoaderDiskCacheConfig {

    /* loaded from: source-8829756-dex2jar.jar:com/weimob/library/groups/imageloader/cache/disk/ImageLoaderDiskCacheConfig$Singleton.class */
    enum Singleton {
        INSTANCE;
        
        private ImageLoaderDiskCacheConfig singleton = new ImageLoaderDiskCacheConfig();

        Singleton() {
        }

        public ImageLoaderDiskCacheConfig getInstance() {
            return this.singleton;
        }
    }

    private ImageLoaderDiskCacheConfig() {
    }

    private File getDataPath(Context context) {
        return context.getExternalFilesDir("image_loader_cache");
    }

    public static ImageLoaderDiskCacheConfig getInstance() {
        return Singleton.INSTANCE.getInstance();
    }

    public DiskCacheConfig getMainDiskCacheConfig(Context context, int i, boolean z) {
        return DiskCacheConfig.newBuilder(context).setBaseDirectoryName("images").setBaseDirectoryPath(getDataPath(context)).setMaxCacheSize(i).setDiskTrimmableRegistry(ImageLoaderDiskTrimmableRegistry.getInstance()).setCacheEventListener(ImageLoaderCacheEventListener.getInstance().setDebug(z)).build();
    }

    public DiskCacheConfig getSmallDiskCacheConfig(Context context, int i, boolean z) {
        return DiskCacheConfig.newBuilder(context).setBaseDirectoryName("thumb").setBaseDirectoryPath(getDataPath(context)).setMaxCacheSize(i).setDiskTrimmableRegistry(ImageLoaderDiskTrimmableRegistry.getInstance()).setCacheEventListener(ImageLoaderCacheEventListener.getInstance().setDebug(z)).build();
    }
}
