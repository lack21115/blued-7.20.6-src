package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import com.bumptech.glide.load.EncodeStrategy;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceEncoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import java.io.File;

/* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/resource/bitmap/BitmapDrawableEncoder.class */
public class BitmapDrawableEncoder implements ResourceEncoder<BitmapDrawable> {

    /* renamed from: a  reason: collision with root package name */
    private final BitmapPool f7330a;
    private final ResourceEncoder<Bitmap> b;

    public BitmapDrawableEncoder(BitmapPool bitmapPool, ResourceEncoder<Bitmap> resourceEncoder) {
        this.f7330a = bitmapPool;
        this.b = resourceEncoder;
    }

    @Override // com.bumptech.glide.load.ResourceEncoder
    public EncodeStrategy a(Options options) {
        return this.b.a(options);
    }

    @Override // com.bumptech.glide.load.Encoder
    public boolean a(Resource<BitmapDrawable> resource, File file, Options options) {
        return this.b.a(new BitmapResource(resource.f().getBitmap(), this.f7330a), file, options);
    }
}
