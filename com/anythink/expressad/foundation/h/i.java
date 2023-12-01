package com.anythink.expressad.foundation.h;

import android.content.Context;
import android.content.res.Resources;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/foundation/h/i.class */
public final class i {

    /* renamed from: a  reason: collision with root package name */
    public static final String f5111a = "layout";
    public static final String b = "id";

    /* renamed from: c  reason: collision with root package name */
    public static final String f5112c = "drawable";
    public static final String d = "color";
    public static final String e = "style";
    public static final String f = "anim";
    public static final String g = "string";
    public static final int h = -1;
    private static final String i = "ResourceUtil";

    public static int a(Context context, String str, String str2) {
        String str3 = "";
        try {
            try {
                str3 = com.anythink.expressad.foundation.b.a.b().a();
            } catch (Exception e2) {
                o.d(i, "ATSDKContext.getInstance() is null resName:".concat(String.valueOf(str)));
            }
            String str4 = str3;
            if (w.a(str3)) {
                str4 = str3;
                if (context != null) {
                    str4 = context.getPackageName();
                }
            }
            if (w.a(str4) || context == null) {
                return -1;
            }
            return context.getResources().getIdentifier(str, str2, str4);
        } catch (Exception e3) {
            o.d(i, "Resource not found resName:".concat(String.valueOf(str)));
            return -1;
        }
    }

    public static Resources a(Context context) {
        if (context != null) {
            try {
                return context.getResources();
            } catch (Exception e2) {
                o.d(i, "Resource error:" + e2.getMessage());
                return null;
            }
        }
        return null;
    }
}
