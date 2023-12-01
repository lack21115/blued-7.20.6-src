package com.kwad.components.ad.splashscreen.e;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import com.kwad.components.ad.splashscreen.h;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/ad/splashscreen/e/c.class */
public final class c {
    public static void a(View view, int i, int i2, int i3, int i4) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            if (i2 >= 0) {
                marginLayoutParams.bottomMargin = com.kwad.sdk.c.kwai.a.a(view.getContext(), i2);
            }
            if (i3 >= 0) {
                marginLayoutParams.leftMargin = com.kwad.sdk.c.kwai.a.a(view.getContext(), i3);
            }
            if (i4 >= 0) {
                marginLayoutParams.rightMargin = com.kwad.sdk.c.kwai.a.a(view.getContext(), i4);
            }
        }
    }

    public static boolean a(Context context, int i, int i2) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        int i3 = displayMetrics.widthPixels;
        int i4 = displayMetrics.heightPixels;
        int a2 = com.kwad.sdk.c.kwai.a.a(context, 10.0f);
        return Math.abs(i - i3) <= a2 && Math.abs(i2 - i4) <= a2;
    }

    public static boolean c(h hVar) {
        return hVar.Bz == 2 || hVar.Bz == 3;
    }

    public static int d(h hVar) {
        if (hVar.Bz == 0) {
            return 1;
        }
        if (hVar.Bz == 3 || hVar.Bz == 1) {
            return 2;
        }
        return hVar.Bz == 2 ? 3 : 1;
    }
}
