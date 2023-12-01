package com.blued.android.core.imagecache.glide;

import android.graphics.Bitmap;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-6737240-dex2jar.jar:com/blued/android/core/imagecache/glide/LruPoolStrategy.class */
public interface LruPoolStrategy {
    Bitmap a();

    Bitmap a(int i, int i2, Bitmap.Config config);

    void a(Bitmap bitmap);

    String b(int i, int i2, Bitmap.Config config);

    String b(Bitmap bitmap);

    int c(Bitmap bitmap);
}
