package com.bumptech.glide.load.resource.bitmap;

import android.content.ContentResolver;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.drawable.ResourceDrawableDecoder;

/* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/resource/bitmap/ResourceBitmapDecoder.class */
public class ResourceBitmapDecoder implements ResourceDecoder<Uri, Bitmap> {

    /* renamed from: a  reason: collision with root package name */
    private final ResourceDrawableDecoder f20967a;
    private final BitmapPool b;

    public ResourceBitmapDecoder(ResourceDrawableDecoder resourceDrawableDecoder, BitmapPool bitmapPool) {
        this.f20967a = resourceDrawableDecoder;
        this.b = bitmapPool;
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    public Resource<Bitmap> a(Uri uri, int i, int i2, Options options) {
        Resource<Drawable> a2 = this.f20967a.a(uri, i, i2, options);
        if (a2 == null) {
            return null;
        }
        return DrawableToBitmapConverter.a(this.b, a2.f(), i, i2);
    }

    @Override // com.bumptech.glide.load.ResourceDecoder
    public boolean a(Uri uri, Options options) {
        return ContentResolver.SCHEME_ANDROID_RESOURCE.equals(uri.getScheme());
    }
}
