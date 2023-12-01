package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import com.bumptech.glide.load.EncodeStrategy;
import com.bumptech.glide.load.Option;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceEncoder;
import com.bumptech.glide.load.engine.bitmap_recycle.ArrayPool;

/* loaded from: source-7206380-dex2jar.jar:com/bumptech/glide/load/resource/bitmap/BitmapEncoder.class */
public class BitmapEncoder implements ResourceEncoder<Bitmap> {

    /* renamed from: a  reason: collision with root package name */
    public static final Option<Integer> f7332a = Option.a("com.bumptech.glide.load.resource.bitmap.BitmapEncoder.CompressionQuality", 90);
    public static final Option<Bitmap.CompressFormat> b = Option.a("com.bumptech.glide.load.resource.bitmap.BitmapEncoder.CompressionFormat");

    /* renamed from: c  reason: collision with root package name */
    private final ArrayPool f7333c;

    @Deprecated
    public BitmapEncoder() {
        this.f7333c = null;
    }

    public BitmapEncoder(ArrayPool arrayPool) {
        this.f7333c = arrayPool;
    }

    private Bitmap.CompressFormat a(Bitmap bitmap, Options options) {
        Bitmap.CompressFormat compressFormat = (Bitmap.CompressFormat) options.a(b);
        return compressFormat != null ? compressFormat : bitmap.hasAlpha() ? Bitmap.CompressFormat.PNG : Bitmap.CompressFormat.JPEG;
    }

    @Override // com.bumptech.glide.load.ResourceEncoder
    public EncodeStrategy a(Options options) {
        return EncodeStrategy.TRANSFORMED;
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x00d3 A[Catch: all -> 0x014b, TryCatch #4 {all -> 0x014b, blocks: (B:3:0x002b, B:16:0x008b, B:34:0x00ca, B:36:0x00d3, B:37:0x0139, B:42:0x0144, B:44:0x014a), top: B:58:0x002b }] */
    @Override // com.bumptech.glide.load.Encoder
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean a(com.bumptech.glide.load.engine.Resource<android.graphics.Bitmap> r6, java.io.File r7, com.bumptech.glide.load.Options r8) {
        /*
            Method dump skipped, instructions count: 345
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.resource.bitmap.BitmapEncoder.a(com.bumptech.glide.load.engine.Resource, java.io.File, com.bumptech.glide.load.Options):boolean");
    }
}
