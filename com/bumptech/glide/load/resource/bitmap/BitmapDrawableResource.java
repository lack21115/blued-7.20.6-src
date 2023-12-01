package com.bumptech.glide.load.resource.bitmap;

import android.graphics.drawable.BitmapDrawable;
import com.bumptech.glide.load.engine.Initializable;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.drawable.DrawableResource;
import com.bumptech.glide.util.Util;

/* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/resource/bitmap/BitmapDrawableResource.class */
public class BitmapDrawableResource extends DrawableResource<BitmapDrawable> implements Initializable {

    /* renamed from: a  reason: collision with root package name */
    private final BitmapPool f7331a;

    @Override // com.bumptech.glide.load.engine.Resource
    public Class<BitmapDrawable> a() {
        return BitmapDrawable.class;
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public int b() {
        return Util.a(((BitmapDrawable) this.d).getBitmap());
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public void c() {
        this.f7331a.a(((BitmapDrawable) this.d).getBitmap());
    }

    @Override // com.bumptech.glide.load.resource.drawable.DrawableResource, com.bumptech.glide.load.engine.Initializable
    public void d() {
        ((BitmapDrawable) this.d).getBitmap().prepareToDraw();
    }
}
