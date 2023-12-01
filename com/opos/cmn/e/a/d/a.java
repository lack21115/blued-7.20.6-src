package com.opos.cmn.e.a.d;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import android.view.WindowManager;

/* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/e/a/d/a.class */
public final class a {
    public static Drawable a(Context context, int i) {
        Drawable drawable = null;
        if (context != null) {
            int i2 = Build.VERSION.SDK_INT;
            Resources resources = context.getResources();
            if (i2 > 21) {
                return resources.getDrawable(i, null);
            }
            drawable = resources.getDrawable(i);
        }
        return drawable;
    }

    public static void a(Activity activity, Dialog dialog) {
        if (dialog == null || activity == null) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 28) {
            WindowManager.LayoutParams attributes = dialog.getWindow().getAttributes();
            attributes.layoutInDisplayCutoutMode = 1;
            dialog.getWindow().setAttributes(attributes);
        }
        if (Build.VERSION.SDK_INT >= 16) {
            int i = 0;
            int systemUiVisibility = activity.getWindow().getDecorView().getSystemUiVisibility();
            if ((systemUiVisibility & 1024) == 1024) {
                i = 1280;
            }
            int i2 = i;
            if ((systemUiVisibility & 4) == 4) {
                i2 = i | 4 | 4096;
            }
            dialog.getWindow().getDecorView().setSystemUiVisibility(i2);
        }
    }

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

    public static boolean a() {
        return Build.VERSION.SDK_INT <= 29;
    }
}
