package com.blued.android.core.imagecache.drawable.apng;

import android.graphics.Bitmap;
import android.net.Uri;
import android.widget.ImageView;
import com.blued.android.core.imagecache.drawable.IRecyclingDrawable;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/core/imagecache/drawable/apng/RecyclingApngDrawable.class */
public class RecyclingApngDrawable extends ApngDrawable implements IRecyclingDrawable {
    String k;

    public RecyclingApngDrawable(String str, Bitmap bitmap, Uri uri, ImageView.ScaleType scaleType) {
        super(bitmap, uri, scaleType);
        a(str);
    }

    @Override // com.blued.android.core.imagecache.drawable.IRecyclingDrawable
    public void a(String str) {
        this.k = str;
    }

    @Override // com.blued.android.core.imagecache.drawable.IRecyclingDrawable
    public void a(boolean z) {
        if (z) {
            start();
            return;
        }
        stop();
        a((ApngPlayListener) null);
    }

    @Override // com.blued.android.core.imagecache.drawable.IRecyclingDrawable
    public boolean a() {
        return true;
    }

    @Override // com.blued.android.core.imagecache.drawable.IRecyclingDrawable
    public String b() {
        return this.k;
    }

    @Override // com.blued.android.core.imagecache.drawable.IRecyclingDrawable
    public void b(boolean z) {
    }

    @Override // com.blued.android.core.imagecache.drawable.IRecyclingDrawable
    public boolean c() {
        return true;
    }

    @Override // com.blued.android.core.imagecache.drawable.IRecyclingDrawable
    public void d() {
        stop();
        a((ApngPlayListener) null);
    }

    @Override // com.blued.android.core.imagecache.drawable.IRecyclingDrawable
    public int e() {
        return this.f9627c * this.d * 4 * 4;
    }
}
