package com.soft.blued.customview.selectabletextview;

import android.content.Context;
import android.text.Layout;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/customview/selectabletextview/TextLayoutUtil.class */
public class TextLayoutUtil {
    public static int a(Context context) {
        return context.getResources().getDisplayMetrics().widthPixels;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0094, code lost:
        if ((r0 - r7) < r0) goto L14;
     */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00fd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int a(android.widget.TextView r5, int r6, int r7, int r8) {
        /*
            Method dump skipped, instructions count: 265
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.soft.blued.customview.selectabletextview.TextLayoutUtil.a(android.widget.TextView, int, int, int):int");
    }

    private static boolean a(Layout layout, int i) {
        return i > 0 && layout.getLineForOffset(i) == layout.getLineForOffset(i - 1) + 1;
    }
}
