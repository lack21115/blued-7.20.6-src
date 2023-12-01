package androidx.core.graphics;

import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import android.graphics.drawable.Drawable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-8756600-dex2jar.jar:androidx/core/graphics/ImageDecoderKt.class */
public final class ImageDecoderKt {
    public static final Bitmap decodeBitmap(ImageDecoder.Source source, final Function3<? super ImageDecoder, ? super ImageDecoder.ImageInfo, ? super ImageDecoder.Source, Unit> action) {
        Intrinsics.e(source, "<this>");
        Intrinsics.e(action, "action");
        Bitmap decodeBitmap = ImageDecoder.decodeBitmap(source, new ImageDecoder.OnHeaderDecodedListener() { // from class: androidx.core.graphics.ImageDecoderKt$decodeBitmap$1
            @Override // android.graphics.ImageDecoder.OnHeaderDecodedListener
            public final void onHeaderDecoded(ImageDecoder decoder, ImageDecoder.ImageInfo info, ImageDecoder.Source source2) {
                Intrinsics.e(decoder, "decoder");
                Intrinsics.e(info, "info");
                Intrinsics.e(source2, "source");
                action.a(decoder, info, source2);
            }
        });
        Intrinsics.c(decodeBitmap, "crossinline action: ImageDecoder.(info: ImageInfo, source: Source) -> Unit\n): Bitmap {\n    return ImageDecoder.decodeBitmap(this) { decoder, info, source ->\n        decoder.action(info, source)\n    }");
        return decodeBitmap;
    }

    public static final Drawable decodeDrawable(ImageDecoder.Source source, final Function3<? super ImageDecoder, ? super ImageDecoder.ImageInfo, ? super ImageDecoder.Source, Unit> action) {
        Intrinsics.e(source, "<this>");
        Intrinsics.e(action, "action");
        Drawable decodeDrawable = ImageDecoder.decodeDrawable(source, new ImageDecoder.OnHeaderDecodedListener() { // from class: androidx.core.graphics.ImageDecoderKt$decodeDrawable$1
            @Override // android.graphics.ImageDecoder.OnHeaderDecodedListener
            public final void onHeaderDecoded(ImageDecoder decoder, ImageDecoder.ImageInfo info, ImageDecoder.Source source2) {
                Intrinsics.e(decoder, "decoder");
                Intrinsics.e(info, "info");
                Intrinsics.e(source2, "source");
                action.a(decoder, info, source2);
            }
        });
        Intrinsics.c(decodeDrawable, "crossinline action: ImageDecoder.(info: ImageInfo, source: Source) -> Unit\n): Drawable {\n    return ImageDecoder.decodeDrawable(this) { decoder, info, source ->\n        decoder.action(info, source)\n    }");
        return decodeDrawable;
    }
}
