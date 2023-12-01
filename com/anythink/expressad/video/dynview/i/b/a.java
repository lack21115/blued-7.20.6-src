package com.anythink.expressad.video.dynview.i.b;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import com.anythink.expressad.foundation.h.t;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/video/dynview/i/b/a.class */
public final class a {
    public static void a(View view, float f, float f2, String str, String[] strArr, GradientDrawable.Orientation orientation) {
        if (view == null) {
            return;
        }
        int[] iArr = new int[2];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= 2) {
                GradientDrawable gradientDrawable = new GradientDrawable(orientation, iArr);
                gradientDrawable.setCornerRadius(t.b(view.getContext(), f2));
                gradientDrawable.setStroke(t.b(view.getContext(), f), Color.parseColor(str));
                view.setBackgroundDrawable(gradientDrawable);
                return;
            }
            iArr[i2] = Color.parseColor(strArr[i2]);
            i = i2 + 1;
        }
    }

    private static void a(View view, String str, String str2) {
        if (view != null) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColor(Color.parseColor(str2));
            gradientDrawable.setCornerRadius(t.b(view.getContext(), 12.0f));
            gradientDrawable.setStroke(t.b(view.getContext(), 1.0f), Color.parseColor(str));
            view.setBackgroundDrawable(gradientDrawable);
        }
    }
}
