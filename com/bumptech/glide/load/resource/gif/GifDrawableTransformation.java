package com.bumptech.glide.load.resource.gif;

import android.content.Context;
import android.graphics.Bitmap;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.resource.bitmap.BitmapResource;
import com.bumptech.glide.util.Preconditions;
import java.security.MessageDigest;

/* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/resource/gif/GifDrawableTransformation.class */
public class GifDrawableTransformation implements Transformation<GifDrawable> {
    private final Transformation<Bitmap> b;

    public GifDrawableTransformation(Transformation<Bitmap> transformation) {
        this.b = (Transformation) Preconditions.a(transformation);
    }

    @Override // com.bumptech.glide.load.Transformation
    public Resource<GifDrawable> a(Context context, Resource<GifDrawable> resource, int i, int i2) {
        GifDrawable f = resource.f();
        Resource<Bitmap> bitmapResource = new BitmapResource(f.b(), Glide.a(context).a());
        Resource<Bitmap> a2 = this.b.a(context, bitmapResource, i, i2);
        if (!bitmapResource.equals(a2)) {
            bitmapResource.c();
        }
        f.a(this.b, a2.f());
        return resource;
    }

    @Override // com.bumptech.glide.load.Key
    public void a(MessageDigest messageDigest) {
        this.b.a(messageDigest);
    }

    @Override // com.bumptech.glide.load.Key
    public boolean equals(Object obj) {
        if (obj instanceof GifDrawableTransformation) {
            return this.b.equals(((GifDrawableTransformation) obj).b);
        }
        return false;
    }

    @Override // com.bumptech.glide.load.Key
    public int hashCode() {
        return this.b.hashCode();
    }
}
