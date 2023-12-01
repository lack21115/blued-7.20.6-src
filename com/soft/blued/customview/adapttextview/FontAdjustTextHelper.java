package com.soft.blued.customview.adapttextview;

import android.content.Context;
import com.blued.android.framework.utils.AppUtils;
import com.soft.blued.R;
import com.soft.blued.utils.BluedPreferences;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/customview/adapttextview/FontAdjustTextHelper.class */
public class FontAdjustTextHelper {

    /* renamed from: a  reason: collision with root package name */
    private static String[] f28548a = {"A", "标准", "", "", "A"};
    private static int[] b = {13, 14, 16, 18, 24};

    public static int a() {
        return a(BluedPreferences.ce());
    }

    public static int a(int i) {
        int[] iArr = b;
        if (iArr == null || iArr.length <= i) {
            return 14;
        }
        return iArr[i];
    }

    public static int a(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static int b() {
        return BluedPreferences.ce();
    }

    public static void b(int i) {
        BluedPreferences.p(i);
    }

    public static String[] c() {
        f28548a[1] = AppUtils.a((int) R.string.setting_text_size_standard);
        return f28548a;
    }

    public static int[] d() {
        return b;
    }
}
