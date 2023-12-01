package com.opos.cmn.biz.web.b.b.a;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;

/* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/biz/web/b/b/a/a.class */
public final class a {
    public static void a(View view, Drawable drawable) {
        if (view == null || drawable == null) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 16) {
            view.setBackground(drawable);
        } else {
            view.setBackgroundDrawable(drawable);
        }
    }

    public static void a(Object obj, String str, Object obj2) {
        com.opos.cmn.b.b.a aVar = new com.opos.cmn.b.b.a(obj.getClass());
        aVar.a(aVar.a(str), obj, obj2);
    }

    public static boolean a(Context context) {
        return context != null && 32 == (context.getResources().getConfiguration().uiMode & 48);
    }

    public static boolean b(Context context) {
        return c(context) && a(context);
    }

    private static boolean c(Context context) {
        boolean z;
        boolean z2;
        try {
            if (Build.VERSION.SDK_INT >= 29) {
                TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{16844176, 16844172});
                z = obtainStyledAttributes.getBoolean(0, false);
                z2 = obtainStyledAttributes.getBoolean(1, false);
                obtainStyledAttributes.recycle();
            } else {
                z = false;
                z2 = false;
            }
            return z && z2;
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c("ReportUtils", "", e);
            return false;
        }
    }
}
