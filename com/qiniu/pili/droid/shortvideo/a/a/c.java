package com.qiniu.pili.droid.shortvideo.a.a;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.WindowManager;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/shortvideo/a/a/c.class */
public class c {
    public static int a(int i, int i2, int i3) {
        return i > i3 ? i3 : i < i2 ? i2 : i;
    }

    public static int a(Context context) {
        return ((WindowManager) context.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay().getRotation();
    }

    public static void a(Matrix matrix, boolean z, int i, int i2, int i3) {
        matrix.setScale(z ? -1.0f : 1.0f, 1.0f);
        matrix.postRotate(i);
        float f = i2;
        float f2 = f / 2000.0f;
        float f3 = i3;
        matrix.postScale(f2, f3 / 2000.0f);
        matrix.postTranslate(f / 2.0f, f3 / 2.0f);
    }

    public static void a(RectF rectF, Rect rect) {
        rect.left = Math.round(rectF.left);
        rect.top = Math.round(rectF.top);
        rect.right = Math.round(rectF.right);
        rect.bottom = Math.round(rectF.bottom);
    }

    public static boolean a(String str, List<String> list) {
        return list != null && list.indexOf(str) >= 0;
    }

    public static int b(Context context) {
        int a2 = a(context);
        if (a2 != 1) {
            if (a2 != 2) {
                return a2 != 3 ? 0 : 270;
            }
            return 180;
        }
        return 90;
    }
}
