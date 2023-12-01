package com.bumptech.glide.load.engine.bitmap_recycle;

import com.bumptech.glide.load.engine.bitmap_recycle.Poolable;
import com.bumptech.glide.util.Util;
import java.util.Queue;

/* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/engine/bitmap_recycle/BaseKeyPool.class */
abstract class BaseKeyPool<T extends Poolable> {

    /* renamed from: a  reason: collision with root package name */
    private final Queue<T> f20802a = Util.a(20);

    public void a(T t) {
        if (this.f20802a.size() < 20) {
            this.f20802a.offer(t);
        }
    }

    abstract T b();

    /* JADX INFO: Access modifiers changed from: package-private */
    public T c() {
        T poll = this.f20802a.poll();
        T t = poll;
        if (poll == null) {
            t = b();
        }
        return t;
    }
}
