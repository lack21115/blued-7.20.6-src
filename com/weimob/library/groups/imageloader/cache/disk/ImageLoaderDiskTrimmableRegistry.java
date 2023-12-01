package com.weimob.library.groups.imageloader.cache.disk;

import com.facebook.common.disk.DiskTrimmable;
import com.facebook.common.disk.DiskTrimmableRegistry;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8829756-dex2jar.jar:com/weimob/library/groups/imageloader/cache/disk/ImageLoaderDiskTrimmableRegistry.class */
public class ImageLoaderDiskTrimmableRegistry implements DiskTrimmableRegistry {
    private List<DiskTrimmable> cacheTrimmableList;

    /* loaded from: source-8829756-dex2jar.jar:com/weimob/library/groups/imageloader/cache/disk/ImageLoaderDiskTrimmableRegistry$Singleton.class */
    enum Singleton {
        INSTANCE;
        
        private ImageLoaderDiskTrimmableRegistry singleton = new ImageLoaderDiskTrimmableRegistry();

        Singleton() {
        }

        public ImageLoaderDiskTrimmableRegistry getInstance() {
            return this.singleton;
        }
    }

    private ImageLoaderDiskTrimmableRegistry() {
        this.cacheTrimmableList = new ArrayList();
    }

    public static ImageLoaderDiskTrimmableRegistry getInstance() {
        return Singleton.INSTANCE.getInstance();
    }

    public void registerDiskTrimmable(DiskTrimmable diskTrimmable) {
        if (diskTrimmable != null) {
            this.cacheTrimmableList.add(diskTrimmable);
        }
    }

    public void unregisterDiskTrimmable(DiskTrimmable diskTrimmable) {
        if (diskTrimmable != null) {
            this.cacheTrimmableList.remove(diskTrimmable);
        }
    }
}
