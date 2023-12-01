package com.anythink.expressad.foundation.h;

import android.content.Context;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/foundation/h/d.class */
public class d {
    private static void a() {
    }

    public static void a(Context context) {
        if (context == null) {
            return;
        }
        try {
            Class<?> cls = Class.forName("com.anythink.expressad.atsignalcommon.webEnvCheck.WebEnvCheckEntry");
            cls.getMethod("check", Context.class).invoke(cls.newInstance(), context);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
