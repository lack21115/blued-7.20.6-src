package com.bumptech.glide.load.resource.drawable;

import android.graphics.drawable.Drawable;
import com.bumptech.glide.load.engine.Resource;

/* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/resource/drawable/NonOwnedDrawableResource.class */
final class NonOwnedDrawableResource extends DrawableResource<Drawable> {
    private NonOwnedDrawableResource(Drawable drawable) {
        super(drawable);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Resource<Drawable> a(Drawable drawable) {
        if (drawable != null) {
            return new NonOwnedDrawableResource(drawable);
        }
        return null;
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public Class<Drawable> a() {
        return this.d.getClass();
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public int b() {
        return Math.max(1, this.d.getIntrinsicWidth() * this.d.getIntrinsicHeight() * 4);
    }

    @Override // com.bumptech.glide.load.engine.Resource
    public void c() {
    }
}
