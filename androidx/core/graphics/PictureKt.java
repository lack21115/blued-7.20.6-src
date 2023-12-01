package androidx.core.graphics;

import android.graphics.Canvas;
import android.graphics.Picture;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-8756600-dex2jar.jar:androidx/core/graphics/PictureKt.class */
public final class PictureKt {
    public static final Picture record(Picture picture, int i, int i2, Function1<? super Canvas, Unit> block) {
        Intrinsics.e(picture, "<this>");
        Intrinsics.e(block, "block");
        Canvas beginRecording = picture.beginRecording(i, i2);
        Intrinsics.c(beginRecording, "beginRecording(width, height)");
        try {
            block.invoke(beginRecording);
            InlineMarker.b(1);
            picture.endRecording();
            InlineMarker.c(1);
            return picture;
        } catch (Throwable th) {
            InlineMarker.b(1);
            picture.endRecording();
            InlineMarker.c(1);
            throw th;
        }
    }
}
