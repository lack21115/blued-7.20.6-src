package com.bumptech.glide.load.engine.bitmap_recycle;

/* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/engine/bitmap_recycle/ArrayPool.class */
public interface ArrayPool {
    <T> T a(int i, Class<T> cls);

    void a();

    void a(int i);

    <T> void a(T t);

    <T> T b(int i, Class<T> cls);
}
