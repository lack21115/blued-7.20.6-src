package com.blued.android.module.svgaplayer.bitmap;

import kotlin.Metadata;

@Metadata
/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/svgaplayer/bitmap/BitmapSampleSizeCalculator.class */
public final class BitmapSampleSizeCalculator {
    public static final BitmapSampleSizeCalculator a = new BitmapSampleSizeCalculator();

    private BitmapSampleSizeCalculator() {
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0051, code lost:
        if (r0 > r5) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int a(android.graphics.BitmapFactory.Options r4, int r5, int r6) {
        /*
            r3 = this;
            r0 = r4
            java.lang.String r1 = "options"
            kotlin.jvm.internal.Intrinsics.e(r0, r1)
            r0 = r4
            int r0 = r0.outHeight
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r1 = r4
            int r1 = r1.outWidth
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            kotlin.Pair r0 = kotlin.TuplesKt.a(r0, r1)
            r4 = r0
            r0 = r4
            java.lang.Object r0 = r0.c()
            java.lang.Number r0 = (java.lang.Number) r0
            int r0 = r0.intValue()
            r11 = r0
            r0 = r4
            java.lang.Object r0 = r0.d()
            java.lang.Number r0 = (java.lang.Number) r0
            int r0 = r0.intValue()
            r10 = r0
            r0 = 1
            r9 = r0
            r0 = 1
            r7 = r0
            r0 = r9
            r8 = r0
            r0 = r6
            if (r0 <= 0) goto L83
            r0 = r5
            if (r0 > 0) goto L44
            r0 = 1
            return r0
        L44:
            r0 = r11
            r1 = r6
            if (r0 > r1) goto L54
            r0 = r9
            r8 = r0
            r0 = r10
            r1 = r5
            if (r0 <= r1) goto L83
        L54:
            r0 = r11
            r1 = 2
            int r0 = r0 / r1
            r9 = r0
            r0 = r10
            r1 = 2
            int r0 = r0 / r1
            r10 = r0
        L60:
            r0 = r7
            r8 = r0
            r0 = r9
            r1 = r7
            int r0 = r0 / r1
            r1 = r6
            if (r0 < r1) goto L83
            r0 = r7
            r8 = r0
            r0 = r10
            r1 = r7
            int r0 = r0 / r1
            r1 = r5
            if (r0 < r1) goto L83
            r0 = r7
            r1 = 2
            int r0 = r0 * r1
            r7 = r0
            goto L60
        L83:
            r0 = r8
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blued.android.module.svgaplayer.bitmap.BitmapSampleSizeCalculator.a(android.graphics.BitmapFactory$Options, int, int):int");
    }
}
