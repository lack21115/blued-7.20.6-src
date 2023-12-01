package com.blued.android.core.imagecache;

import android.graphics.drawable.Drawable;
import com.blued.android.core.imagecache.view.RecyclingImageView;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/core/imagecache/ImageLoadingListener.class */
public interface ImageLoadingListener {
    void a(int i, int i2);

    void a(String str, RecyclingImageView recyclingImageView, LoadOptions loadOptions);

    void a(String str, RecyclingImageView recyclingImageView, LoadOptions loadOptions, Drawable drawable, boolean z);

    void a(String str, RecyclingImageView recyclingImageView, LoadOptions loadOptions, FailReason failReason);

    boolean a();

    void b(String str, RecyclingImageView recyclingImageView, LoadOptions loadOptions);
}
