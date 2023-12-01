package com.bumptech.glide.load.resource.transcode;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapResource;
import com.bumptech.glide.load.resource.gif.GifDrawable;

/* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/resource/transcode/DrawableBytesTranscoder.class */
public final class DrawableBytesTranscoder implements ResourceTranscoder<Drawable, byte[]> {

    /* renamed from: a  reason: collision with root package name */
    private final BitmapPool f7399a;
    private final ResourceTranscoder<Bitmap, byte[]> b;

    /* renamed from: c  reason: collision with root package name */
    private final ResourceTranscoder<GifDrawable, byte[]> f7400c;

    public DrawableBytesTranscoder(BitmapPool bitmapPool, ResourceTranscoder<Bitmap, byte[]> resourceTranscoder, ResourceTranscoder<GifDrawable, byte[]> resourceTranscoder2) {
        this.f7399a = bitmapPool;
        this.b = resourceTranscoder;
        this.f7400c = resourceTranscoder2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static Resource<GifDrawable> a(Resource<Drawable> resource) {
        return resource;
    }

    @Override // com.bumptech.glide.load.resource.transcode.ResourceTranscoder
    public Resource<byte[]> a(Resource<Drawable> resource, Options options) {
        Drawable f = resource.f();
        if (f instanceof BitmapDrawable) {
            return this.b.a(BitmapResource.a(((BitmapDrawable) f).getBitmap(), this.f7399a), options);
        }
        if (f instanceof GifDrawable) {
            return this.f7400c.a(a(resource), options);
        }
        return null;
    }
}
