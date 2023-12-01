package com.bumptech.glide.load.engine.bitmap_recycle;

import android.graphics.Bitmap;

/* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/engine/bitmap_recycle/LruPoolStrategy.class */
interface LruPoolStrategy {
    Bitmap a();

    Bitmap a(int i, int i2, Bitmap.Config config);

    void a(Bitmap bitmap);

    String b(int i, int i2, Bitmap.Config config);

    String b(Bitmap bitmap);

    int c(Bitmap bitmap);
}
