package com.bumptech.glide.load.resource.bitmap;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import com.bumptech.glide.load.engine.Initializable;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.util.Preconditions;

/* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/resource/bitmap/LazyBitmapDrawableResource.class */
public final class LazyBitmapDrawableResource implements Initializable, Resource<BitmapDrawable> {

    /* renamed from: a  reason: collision with root package name */
    private final Resources f7357a;
    private final Resource<Bitmap> b;

    private LazyBitmapDrawableResource(Resources resources, Resource<Bitmap> resource) {
        this.f7357a = (Resources) Preconditions.a(resources);
        this.b = (Resource) Preconditions.a(resource);
    }

    public static Resource<BitmapDrawable> a(Resources resources, Resource<Bitmap> resource) {
        if (resource == null) {
            return null;
        }
        return new LazyBitmapDrawableResource(resources, resource);
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public Class<BitmapDrawable> a() {
        return BitmapDrawable.class;
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public int b() {
        return this.b.b();
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public void c() {
        this.b.c();
    }

    @Override // com.bumptech.glide.load.engine.Initializable
    public void d() {
        Resource<Bitmap> resource = this.b;
        if (resource instanceof Initializable) {
            ((Initializable) resource).d();
        }
    }

    @Override // com.bumptech.glide.load.engine.Resource
    /* renamed from: e */
    public BitmapDrawable f() {
        return new BitmapDrawable(this.f7357a, this.b.f());
    }
}
