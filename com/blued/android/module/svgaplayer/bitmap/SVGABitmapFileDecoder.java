package com.blued.android.module.svgaplayer.bitmap;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/svgaplayer/bitmap/SVGABitmapFileDecoder.class */
public final class SVGABitmapFileDecoder extends SVGABitmapDecoder<String> {
    public static final SVGABitmapFileDecoder a = new SVGABitmapFileDecoder();

    private SVGABitmapFileDecoder() {
    }

    @Override // com.blued.android.module.svgaplayer.bitmap.SVGABitmapDecoder
    public Bitmap a(String data, BitmapFactory.Options ops) {
        Intrinsics.e(data, "data");
        Intrinsics.e(ops, "ops");
        return BitmapFactory.decodeFile(data, ops);
    }
}
