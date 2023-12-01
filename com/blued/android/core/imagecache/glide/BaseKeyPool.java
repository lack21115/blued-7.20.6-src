package com.blued.android.core.imagecache.glide;

import com.blued.android.core.imagecache.glide.Poolable;
import java.util.Queue;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/core/imagecache/glide/BaseKeyPool.class */
abstract class BaseKeyPool<T extends Poolable> {

    /* renamed from: a  reason: collision with root package name */
    private final Queue<T> f9642a = Util.a(20);

    public void a(T t) {
        if (this.f9642a.size() < 20) {
            this.f9642a.offer(t);
        }
    }

    protected abstract T b();

    /* JADX INFO: Access modifiers changed from: protected */
    public T c() {
        T poll = this.f9642a.poll();
        T t = poll;
        if (poll == null) {
            t = b();
        }
        return t;
    }
}
