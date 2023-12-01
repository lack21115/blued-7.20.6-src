package com.bumptech.glide.load.resource.drawable;

import android.graphics.drawable.Drawable;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;

/* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/resource/drawable/UnitDrawableDecoder.class */
public class UnitDrawableDecoder implements ResourceDecoder<Drawable, Drawable> {
    @Override // com.bumptech.glide.load.ResourceDecoder
    public Resource<Drawable> a(Drawable drawable, int i, int i2, Options options) {
        return NonOwnedDrawableResource.a(drawable);
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    public boolean a(Drawable drawable, Options options) {
        return true;
    }
}
