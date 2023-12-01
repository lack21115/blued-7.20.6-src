package com.bumptech.glide.load.resource.gif;

import android.graphics.Bitmap;
import com.bumptech.glide.gifdecoder.GifDecoder;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapResource;

/* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/resource/gif/GifFrameResourceDecoder.class */
public final class GifFrameResourceDecoder implements ResourceDecoder<GifDecoder, Bitmap> {

    /* renamed from: a  reason: collision with root package name */
    private final BitmapPool f20999a;

    public GifFrameResourceDecoder(BitmapPool bitmapPool) {
        this.f20999a = bitmapPool;
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    public Resource<Bitmap> a(GifDecoder gifDecoder, int i, int i2, Options options) {
        return BitmapResource.a(gifDecoder.i(), this.f20999a);
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    public boolean a(GifDecoder gifDecoder, Options options) {
        return true;
    }
}
