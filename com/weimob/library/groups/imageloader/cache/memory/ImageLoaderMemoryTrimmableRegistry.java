package com.weimob.library.groups.imageloader.cache.memory;

import com.facebook.common.memory.MemoryTrimType;
import com.facebook.common.memory.MemoryTrimmable;
import com.facebook.common.memory.MemoryTrimmableRegistry;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8829756-dex2jar.jar:com/weimob/library/groups/imageloader/cache/memory/ImageLoaderMemoryTrimmableRegistry.class */
public class ImageLoaderMemoryTrimmableRegistry implements MemoryTrimmableRegistry {
    private List<MemoryTrimmable> cacheTrimmableList;

    /* loaded from: source-8829756-dex2jar.jar:com/weimob/library/groups/imageloader/cache/memory/ImageLoaderMemoryTrimmableRegistry$Singleton.class */
    enum Singleton {
        INSTANCE;
        
        private ImageLoaderMemoryTrimmableRegistry singleton = new ImageLoaderMemoryTrimmableRegistry();

        Singleton() {
        }

        public ImageLoaderMemoryTrimmableRegistry getInstance() {
            return this.singleton;
        }
    }

    private ImageLoaderMemoryTrimmableRegistry() {
        this.cacheTrimmableList = new ArrayList();
    }

    public static ImageLoaderMemoryTrimmableRegistry getInstance() {
        return Singleton.INSTANCE.getInstance();
    }

    public void onLowMemory() {
        onTrimMemory(MemoryTrimType.OnSystemLowMemoryWhileAppInBackground);
    }

    public void onTrimMemory(MemoryTrimType memoryTrimType) {
        for (MemoryTrimmable memoryTrimmable : this.cacheTrimmableList) {
            memoryTrimmable.trim(memoryTrimType);
        }
    }

    public void registerMemoryTrimmable(MemoryTrimmable memoryTrimmable) {
        if (memoryTrimmable != null) {
            this.cacheTrimmableList.add(memoryTrimmable);
        }
    }

    public void unregisterMemoryTrimmable(MemoryTrimmable memoryTrimmable) {
        if (memoryTrimmable != null) {
            this.cacheTrimmableList.remove(memoryTrimmable);
        }
    }
}
