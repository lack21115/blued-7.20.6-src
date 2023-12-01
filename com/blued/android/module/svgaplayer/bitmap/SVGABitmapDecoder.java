package com.blued.android.module.svgaplayer.bitmap;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import kotlin.Metadata;

@Metadata
/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/svgaplayer/bitmap/SVGABitmapDecoder.class */
public abstract class SVGABitmapDecoder<T> {
    public final Bitmap a(T t, int i, int i2) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = i > 0 && i2 > 0;
        options.inPreferredConfig = Bitmap.Config.RGB_565;
        Bitmap a2 = a(t, options);
        if (options.inJustDecodeBounds) {
            options.inSampleSize = BitmapSampleSizeCalculator.f15983a.a(options, i, i2);
            options.inJustDecodeBounds = false;
            return a(t, options);
        }
        return a2;
    }

    public abstract Bitmap a(T t, BitmapFactory.Options options);
}
