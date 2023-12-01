package com.bumptech.glide.load.resource.bitmap;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import java.security.MessageDigest;

/* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/resource/bitmap/DrawableTransformation.class */
public class DrawableTransformation implements Transformation<Drawable> {
    private final Transformation<Bitmap> b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f7348c;

    public DrawableTransformation(Transformation<Bitmap> transformation, boolean z) {
        this.b = transformation;
        this.f7348c = z;
    }

    private Resource<Drawable> a(Context context, Resource<Bitmap> resource) {
        return LazyBitmapDrawableResource.a(context.getResources(), resource);
    }

    public Transformation<BitmapDrawable> a() {
        return this;
    }

    @Override // com.bumptech.glide.load.Transformation
    public Resource<Drawable> a(Context context, Resource<Drawable> resource, int i, int i2) {
        BitmapPool a2 = Glide.a(context).a();
        Drawable f = resource.f();
        Resource<Bitmap> a3 = DrawableToBitmapConverter.a(a2, f, i, i2);
        if (a3 != null) {
            Resource<Bitmap> a4 = this.b.a(context, a3, i, i2);
            if (a4.equals(a3)) {
                a4.c();
                return resource;
            }
            return a(context, a4);
        } else if (this.f7348c) {
            throw new IllegalArgumentException("Unable to convert " + f + " to a Bitmap");
        } else {
            return resource;
        }
    }

    @Override // com.bumptech.glide.load.Key
    public void a(MessageDigest messageDigest) {
        this.b.a(messageDigest);
    }

    @Override // com.bumptech.glide.load.Key
    public boolean equals(Object obj) {
        if (obj instanceof DrawableTransformation) {
            return this.b.equals(((DrawableTransformation) obj).b);
        }
        return false;
    }

    @Override // com.bumptech.glide.load.Key
    public int hashCode() {
        return this.b.hashCode();
    }
}
