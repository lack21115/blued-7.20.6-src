package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import com.bumptech.glide.load.engine.Initializable;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.util.Preconditions;
import com.bumptech.glide.util.Util;

/* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/resource/bitmap/BitmapResource.class */
public class BitmapResource implements Initializable, Resource<Bitmap> {

    /* renamed from: a  reason: collision with root package name */
    private final Bitmap f20940a;
    private final BitmapPool b;

    public BitmapResource(Bitmap bitmap, BitmapPool bitmapPool) {
        this.f20940a = (Bitmap) Preconditions.a(bitmap, "Bitmap must not be null");
        this.b = (BitmapPool) Preconditions.a(bitmapPool, "BitmapPool must not be null");
    }

    public static BitmapResource a(Bitmap bitmap, BitmapPool bitmapPool) {
        if (bitmap == null) {
            return null;
        }
        return new BitmapResource(bitmap, bitmapPool);
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public Class<Bitmap> a() {
        return Bitmap.class;
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public int b() {
        return Util.a(this.f20940a);
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public void c() {
        this.b.a(this.f20940a);
    }

    @Override // com.bumptech.glide.load.engine.Initializable
    public void d() {
        this.f20940a.prepareToDraw();
    }

    @Override // com.bumptech.glide.load.engine.Resource
    /* renamed from: e */
    public Bitmap f() {
        return this.f20940a;
    }
}
