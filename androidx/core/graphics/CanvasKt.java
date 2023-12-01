package androidx.core.graphics;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-8756600-dex2jar.jar:androidx/core/graphics/CanvasKt.class */
public final class CanvasKt {
    public static final void withClip(Canvas canvas, float f, float f2, float f3, float f4, Function1<? super Canvas, Unit> block) {
        Intrinsics.e(canvas, "<this>");
        Intrinsics.e(block, "block");
        int save = canvas.save();
        canvas.clipRect(f, f2, f3, f4);
        try {
            block.invoke(canvas);
            InlineMarker.b(1);
            canvas.restoreToCount(save);
            InlineMarker.c(1);
        } catch (Throwable th) {
            InlineMarker.b(1);
            canvas.restoreToCount(save);
            InlineMarker.c(1);
            throw th;
        }
    }

    public static final void withClip(Canvas canvas, int i, int i2, int i3, int i4, Function1<? super Canvas, Unit> block) {
        Intrinsics.e(canvas, "<this>");
        Intrinsics.e(block, "block");
        int save = canvas.save();
        canvas.clipRect(i, i2, i3, i4);
        try {
            block.invoke(canvas);
            InlineMarker.b(1);
            canvas.restoreToCount(save);
            InlineMarker.c(1);
        } catch (Throwable th) {
            InlineMarker.b(1);
            canvas.restoreToCount(save);
            InlineMarker.c(1);
            throw th;
        }
    }

    public static final void withClip(Canvas canvas, Path clipPath, Function1<? super Canvas, Unit> block) {
        Intrinsics.e(canvas, "<this>");
        Intrinsics.e(clipPath, "clipPath");
        Intrinsics.e(block, "block");
        int save = canvas.save();
        canvas.clipPath(clipPath);
        try {
            block.invoke(canvas);
            InlineMarker.b(1);
            canvas.restoreToCount(save);
            InlineMarker.c(1);
        } catch (Throwable th) {
            InlineMarker.b(1);
            canvas.restoreToCount(save);
            InlineMarker.c(1);
            throw th;
        }
    }

    public static final void withClip(Canvas canvas, Rect clipRect, Function1<? super Canvas, Unit> block) {
        Intrinsics.e(canvas, "<this>");
        Intrinsics.e(clipRect, "clipRect");
        Intrinsics.e(block, "block");
        int save = canvas.save();
        canvas.clipRect(clipRect);
        try {
            block.invoke(canvas);
            InlineMarker.b(1);
            canvas.restoreToCount(save);
            InlineMarker.c(1);
        } catch (Throwable th) {
            InlineMarker.b(1);
            canvas.restoreToCount(save);
            InlineMarker.c(1);
            throw th;
        }
    }

    public static final void withClip(Canvas canvas, RectF clipRect, Function1<? super Canvas, Unit> block) {
        Intrinsics.e(canvas, "<this>");
        Intrinsics.e(clipRect, "clipRect");
        Intrinsics.e(block, "block");
        int save = canvas.save();
        canvas.clipRect(clipRect);
        try {
            block.invoke(canvas);
            InlineMarker.b(1);
            canvas.restoreToCount(save);
            InlineMarker.c(1);
        } catch (Throwable th) {
            InlineMarker.b(1);
            canvas.restoreToCount(save);
            InlineMarker.c(1);
            throw th;
        }
    }

    public static final void withMatrix(Canvas canvas, Matrix matrix, Function1<? super Canvas, Unit> block) {
        Intrinsics.e(canvas, "<this>");
        Intrinsics.e(matrix, "matrix");
        Intrinsics.e(block, "block");
        int save = canvas.save();
        canvas.concat(matrix);
        try {
            block.invoke(canvas);
            InlineMarker.b(1);
            canvas.restoreToCount(save);
            InlineMarker.c(1);
        } catch (Throwable th) {
            InlineMarker.b(1);
            canvas.restoreToCount(save);
            InlineMarker.c(1);
            throw th;
        }
    }

    public static /* synthetic */ void withMatrix$default(Canvas canvas, Matrix matrix, Function1 block, int i, Object obj) {
        if ((i & 1) != 0) {
            matrix = new Matrix();
        }
        Intrinsics.e(canvas, "<this>");
        Matrix matrix2 = matrix;
        Intrinsics.e(matrix2, "matrix");
        Intrinsics.e(block, "block");
        int save = canvas.save();
        canvas.concat(matrix);
        try {
            block.invoke(canvas);
            InlineMarker.b(1);
            canvas.restoreToCount(save);
            InlineMarker.c(1);
        } catch (Throwable th) {
            InlineMarker.b(1);
            canvas.restoreToCount(save);
            InlineMarker.c(1);
            throw th;
        }
    }

    public static final void withRotation(Canvas canvas, float f, float f2, float f3, Function1<? super Canvas, Unit> block) {
        Intrinsics.e(canvas, "<this>");
        Intrinsics.e(block, "block");
        int save = canvas.save();
        canvas.rotate(f, f2, f3);
        try {
            block.invoke(canvas);
            InlineMarker.b(1);
            canvas.restoreToCount(save);
            InlineMarker.c(1);
        } catch (Throwable th) {
            InlineMarker.b(1);
            canvas.restoreToCount(save);
            InlineMarker.c(1);
            throw th;
        }
    }

    public static /* synthetic */ void withRotation$default(Canvas canvas, float f, float f2, float f3, Function1 block, int i, Object obj) {
        if ((i & 1) != 0) {
            f = 0.0f;
        }
        if ((i & 2) != 0) {
            f2 = 0.0f;
        }
        if ((i & 4) != 0) {
            f3 = 0.0f;
        }
        Intrinsics.e(canvas, "<this>");
        Intrinsics.e(block, "block");
        int save = canvas.save();
        canvas.rotate(f, f2, f3);
        try {
            block.invoke(canvas);
            InlineMarker.b(1);
            canvas.restoreToCount(save);
            InlineMarker.c(1);
        } catch (Throwable th) {
            InlineMarker.b(1);
            canvas.restoreToCount(save);
            InlineMarker.c(1);
            throw th;
        }
    }

    public static final void withSave(Canvas canvas, Function1<? super Canvas, Unit> block) {
        Intrinsics.e(canvas, "<this>");
        Intrinsics.e(block, "block");
        int save = canvas.save();
        try {
            block.invoke(canvas);
            InlineMarker.b(1);
            canvas.restoreToCount(save);
            InlineMarker.c(1);
        } catch (Throwable th) {
            InlineMarker.b(1);
            canvas.restoreToCount(save);
            InlineMarker.c(1);
            throw th;
        }
    }

    public static final void withScale(Canvas canvas, float f, float f2, float f3, float f4, Function1<? super Canvas, Unit> block) {
        Intrinsics.e(canvas, "<this>");
        Intrinsics.e(block, "block");
        int save = canvas.save();
        canvas.scale(f, f2, f3, f4);
        try {
            block.invoke(canvas);
            InlineMarker.b(1);
            canvas.restoreToCount(save);
            InlineMarker.c(1);
        } catch (Throwable th) {
            InlineMarker.b(1);
            canvas.restoreToCount(save);
            InlineMarker.c(1);
            throw th;
        }
    }

    public static /* synthetic */ void withScale$default(Canvas canvas, float f, float f2, float f3, float f4, Function1 block, int i, Object obj) {
        if ((i & 1) != 0) {
            f = 1.0f;
        }
        if ((i & 2) != 0) {
            f2 = 1.0f;
        }
        if ((i & 4) != 0) {
            f3 = 0.0f;
        }
        if ((i & 8) != 0) {
            f4 = 0.0f;
        }
        Intrinsics.e(canvas, "<this>");
        Intrinsics.e(block, "block");
        int save = canvas.save();
        canvas.scale(f, f2, f3, f4);
        try {
            block.invoke(canvas);
            InlineMarker.b(1);
            canvas.restoreToCount(save);
            InlineMarker.c(1);
        } catch (Throwable th) {
            InlineMarker.b(1);
            canvas.restoreToCount(save);
            InlineMarker.c(1);
            throw th;
        }
    }

    public static final void withSkew(Canvas canvas, float f, float f2, Function1<? super Canvas, Unit> block) {
        Intrinsics.e(canvas, "<this>");
        Intrinsics.e(block, "block");
        int save = canvas.save();
        canvas.skew(f, f2);
        try {
            block.invoke(canvas);
            InlineMarker.b(1);
            canvas.restoreToCount(save);
            InlineMarker.c(1);
        } catch (Throwable th) {
            InlineMarker.b(1);
            canvas.restoreToCount(save);
            InlineMarker.c(1);
            throw th;
        }
    }

    public static /* synthetic */ void withSkew$default(Canvas canvas, float f, float f2, Function1 block, int i, Object obj) {
        if ((i & 1) != 0) {
            f = 0.0f;
        }
        if ((i & 2) != 0) {
            f2 = 0.0f;
        }
        Intrinsics.e(canvas, "<this>");
        Intrinsics.e(block, "block");
        int save = canvas.save();
        canvas.skew(f, f2);
        try {
            block.invoke(canvas);
            InlineMarker.b(1);
            canvas.restoreToCount(save);
            InlineMarker.c(1);
        } catch (Throwable th) {
            InlineMarker.b(1);
            canvas.restoreToCount(save);
            InlineMarker.c(1);
            throw th;
        }
    }

    public static final void withTranslation(Canvas canvas, float f, float f2, Function1<? super Canvas, Unit> block) {
        Intrinsics.e(canvas, "<this>");
        Intrinsics.e(block, "block");
        int save = canvas.save();
        canvas.translate(f, f2);
        try {
            block.invoke(canvas);
            InlineMarker.b(1);
            canvas.restoreToCount(save);
            InlineMarker.c(1);
        } catch (Throwable th) {
            InlineMarker.b(1);
            canvas.restoreToCount(save);
            InlineMarker.c(1);
            throw th;
        }
    }

    public static /* synthetic */ void withTranslation$default(Canvas canvas, float f, float f2, Function1 block, int i, Object obj) {
        if ((i & 1) != 0) {
            f = 0.0f;
        }
        if ((i & 2) != 0) {
            f2 = 0.0f;
        }
        Intrinsics.e(canvas, "<this>");
        Intrinsics.e(block, "block");
        int save = canvas.save();
        canvas.translate(f, f2);
        try {
            block.invoke(canvas);
            InlineMarker.b(1);
            canvas.restoreToCount(save);
            InlineMarker.c(1);
        } catch (Throwable th) {
            InlineMarker.b(1);
            canvas.restoreToCount(save);
            InlineMarker.c(1);
            throw th;
        }
    }
}
