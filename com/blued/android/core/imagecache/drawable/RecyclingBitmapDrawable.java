package com.blued.android.core.imagecache.drawable;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import com.blued.android.core.imagecache.RecyclingImageLoader;
import com.blued.android.core.imagecache.RecyclingUtils;
import com.blued.android.core.imagecache.drawable.IRecyclingDrawable;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/core/imagecache/drawable/RecyclingBitmapDrawable.class */
public class RecyclingBitmapDrawable extends BitmapDrawable implements IRecyclingDrawable {
    private static boolean d = true;

    /* renamed from: a  reason: collision with root package name */
    public int f9619a;
    public int b;

    /* renamed from: c  reason: collision with root package name */
    public int f9620c;
    private IRecyclingDrawable.CountRef e;
    private String f;

    public RecyclingBitmapDrawable(Resources resources, Bitmap bitmap) {
        super(resources, bitmap);
        this.e = new IRecyclingDrawable.CountRef(this);
    }

    private boolean f() {
        boolean z;
        synchronized (this) {
            Bitmap bitmap = getBitmap();
            if (bitmap != null) {
                if (!bitmap.isRecycled()) {
                    z = true;
                }
            }
            z = false;
        }
        return z;
    }

    @Override // com.blued.android.core.imagecache.drawable.IRecyclingDrawable
    public void a(String str) {
        this.f = str;
    }

    @Override // com.blued.android.core.imagecache.drawable.IRecyclingDrawable
    public void a(boolean z) {
        this.e.a(z);
    }

    @Override // com.blued.android.core.imagecache.drawable.IRecyclingDrawable
    public boolean a() {
        return true;
    }

    @Override // com.blued.android.core.imagecache.drawable.IRecyclingDrawable
    public String b() {
        return this.f;
    }

    @Override // com.blued.android.core.imagecache.drawable.IRecyclingDrawable
    public void b(boolean z) {
        this.e.b(z);
    }

    @Override // com.blued.android.core.imagecache.drawable.IRecyclingDrawable
    public boolean c() {
        return f();
    }

    @Override // com.blued.android.core.imagecache.drawable.IRecyclingDrawable
    public void d() {
        RecyclingImageLoader.a(getBitmap());
    }

    @Override // com.blued.android.core.imagecache.drawable.IRecyclingDrawable
    public int e() {
        int a2 = RecyclingUtils.a(this);
        int i = a2;
        if (a2 == 0) {
            i = 1;
        }
        return i;
    }
}
