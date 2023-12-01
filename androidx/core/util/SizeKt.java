package androidx.core.util;

import android.util.Size;
import android.util.SizeF;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-8756600-dex2jar.jar:androidx/core/util/SizeKt.class */
public final class SizeKt {
    public static final float component1(SizeF sizeF) {
        Intrinsics.e(sizeF, "<this>");
        return sizeF.getWidth();
    }

    public static final int component1(Size size) {
        Intrinsics.e(size, "<this>");
        return size.getWidth();
    }

    public static final float component2(SizeF sizeF) {
        Intrinsics.e(sizeF, "<this>");
        return sizeF.getHeight();
    }

    public static final int component2(Size size) {
        Intrinsics.e(size, "<this>");
        return size.getHeight();
    }
}
