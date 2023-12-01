package com.tencent.cloud.huiyansdkface.a.f;

import android.content.Context;
import android.view.Display;
import android.view.WindowManager;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/a/f/a.class */
public class a {
    public static int a(int i) {
        if (i != 1) {
            if (i != 2) {
                return i != 3 ? 0 : 270;
            }
            return 180;
        }
        return 90;
    }

    public static int a(Context context) {
        return a(b(context).getOrientation());
    }

    public static int a(com.tencent.cloud.huiyansdkface.a.a.a.a aVar, int i, int i2) {
        return aVar.b() ? (360 - ((i2 + i) % 360)) % 360 : ((i2 - i) + 360) % 360;
    }

    private static Display b(Context context) {
        return ((WindowManager) context.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay();
    }
}
