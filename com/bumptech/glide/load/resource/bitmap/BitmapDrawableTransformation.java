package com.bumptech.glide.load.resource.bitmap;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.Resource;
import java.security.MessageDigest;

@Deprecated
/* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/resource/bitmap/BitmapDrawableTransformation.class */
public class BitmapDrawableTransformation implements Transformation<BitmapDrawable> {
    private final Transformation<Drawable> b;

    /* JADX WARN: Multi-variable type inference failed */
    private static Resource<BitmapDrawable> a(Resource<Drawable> resource) {
        if (resource.f() instanceof BitmapDrawable) {
            return resource;
        }
        throw new IllegalArgumentException("Wrapped transformation unexpectedly returned a non BitmapDrawable resource: " + resource.f());
    }

    private static Resource<Drawable> b(Resource<BitmapDrawable> resource) {
        return resource;
    }

    @Override // com.bumptech.glide.load.Transformation
    public Resource<BitmapDrawable> a(Context context, Resource<BitmapDrawable> resource, int i, int i2) {
        return a(this.b.a(context, b(resource), i, i2));
    }

    @Override // com.bumptech.glide.load.Key
    public void a(MessageDigest messageDigest) {
        this.b.a(messageDigest);
    }

    @Override // com.bumptech.glide.load.Key
    public boolean equals(Object obj) {
        if (obj instanceof BitmapDrawableTransformation) {
            return this.b.equals(((BitmapDrawableTransformation) obj).b);
        }
        return false;
    }

    @Override // com.bumptech.glide.load.Key
    public int hashCode() {
        return this.b.hashCode();
    }
}
