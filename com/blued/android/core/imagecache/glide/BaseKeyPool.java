package com.blued.android.core.imagecache.glide;

import com.blued.android.core.imagecache.glide.Poolable;
import java.util.Queue;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/core/imagecache/glide/BaseKeyPool.class */
abstract class BaseKeyPool<T extends Poolable> {
    private final Queue<T> a = Util.a(20);

    public void a(T t) {
        if (this.a.size() < 20) {
            this.a.offer(t);
        }
    }

    protected abstract T b();

    /* JADX INFO: Access modifiers changed from: protected */
    public T c() {
        T poll = this.a.poll();
        T t = poll;
        if (poll == null) {
            t = b();
        }
        return t;
    }
}
