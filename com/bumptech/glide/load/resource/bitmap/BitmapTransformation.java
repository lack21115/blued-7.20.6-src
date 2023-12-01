package com.bumptech.glide.load.resource.bitmap;

import android.content.Context;
import android.graphics.Bitmap;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.util.Util;

/* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/resource/bitmap/BitmapTransformation.class */
public abstract class BitmapTransformation implements Transformation<Bitmap> {
    protected abstract Bitmap a(BitmapPool bitmapPool, Bitmap bitmap, int i, int i2);

    @Override // com.bumptech.glide.load.Transformation
    public final Resource<Bitmap> a(Context context, Resource<Bitmap> resource, int i, int i2) {
        if (!Util.a(i, i2)) {
            throw new IllegalArgumentException("Cannot apply transformation on width: " + i + " or height: " + i2 + " less than or equal to zero and not Target.SIZE_ORIGINAL");
        }
        BitmapPool a2 = Glide.a(context).a();
        Bitmap f = resource.f();
        int i3 = i;
        if (i == Integer.MIN_VALUE) {
            i3 = f.getWidth();
        }
        int i4 = i2;
        if (i2 == Integer.MIN_VALUE) {
            i4 = f.getHeight();
        }
        Bitmap a3 = a(a2, f, i3, i4);
        return f.equals(a3) ? resource : BitmapResource.a(a3, a2);
    }
}
