package com.blued.android.core.imagecache;

import android.util.SparseArray;
import java.lang.ref.WeakReference;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/core/imagecache/MemoryRequest.class */
public class MemoryRequest {
    private SparseArray<WeakReference<MemoryListener>> a = new SparseArray<>();

    /* loaded from: source-6737240-dex2jar.jar:com/blued/android/core/imagecache/MemoryRequest$MemoryListener.class */
    public interface MemoryListener {
        void a();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-6737240-dex2jar.jar:com/blued/android/core/imagecache/MemoryRequest$SingletonCreator.class */
    public static class SingletonCreator {
        private static final MemoryRequest a = new MemoryRequest();

        private SingletonCreator() {
        }
    }

    public static MemoryRequest a() {
        return SingletonCreator.a;
    }

    public void a(int i) {
        RecyclingImageLoader.a(i);
    }

    public void a(MemoryListener memoryListener) {
        if (memoryListener != null) {
            this.a.put(memoryListener.hashCode(), new WeakReference<>(memoryListener));
        }
    }

    public void b() {
        RecyclingImageLoader.d();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.a.size()) {
                System.gc();
                return;
            }
            MemoryListener memoryListener = this.a.valueAt(i2).get();
            if (memoryListener != null) {
                memoryListener.a();
            }
            i = i2 + 1;
        }
    }

    public void b(MemoryListener memoryListener) {
        if (memoryListener != null) {
            this.a.remove(memoryListener.hashCode());
        }
    }
}
