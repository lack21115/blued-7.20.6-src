package com.bumptech.glide.load.engine.bitmap_recycle;

import android.graphics.Bitmap;

/* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/engine/bitmap_recycle/BitmapPool.class */
public interface BitmapPool {
    Bitmap a(int i, int i2, Bitmap.Config config);

    void a();

    void a(int i);

    void a(Bitmap bitmap);

    Bitmap b(int i, int i2, Bitmap.Config config);
}
