package com.blued.android.module.svgaplayer.bitmap;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/svgaplayer/bitmap/SVGABitmapByteArrayDecoder.class */
public final class SVGABitmapByteArrayDecoder extends SVGABitmapDecoder<byte[]> {

    /* renamed from: a  reason: collision with root package name */
    public static final SVGABitmapByteArrayDecoder f15984a = new SVGABitmapByteArrayDecoder();

    private SVGABitmapByteArrayDecoder() {
    }

    @Override // com.blued.android.module.svgaplayer.bitmap.SVGABitmapDecoder
    public Bitmap a(byte[] data, BitmapFactory.Options ops) {
        Intrinsics.e(data, "data");
        Intrinsics.e(ops, "ops");
        return BitmapFactory.decodeByteArray(data, 0, data.length, ops);
    }
}
