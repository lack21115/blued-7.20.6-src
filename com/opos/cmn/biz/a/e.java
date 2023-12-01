package com.opos.cmn.biz.a;

import android.content.Context;

/* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/biz/a/e.class */
public class e {
    public static String a(Context context) {
        String str;
        try {
            str = com.heytap.lib.a.a.a(String.valueOf(com.opos.cmn.an.h.d.a.b(context, context.getPackageName())), d.a(context), b(context), "");
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c("RouteDataTool", "", e);
            str = "";
        }
        com.opos.cmn.an.f.a.b("RouteDataTool", "getRouteDataValue=" + str);
        return str;
    }

    private static String b(Context context) {
        String str;
        try {
            String b = com.opos.cmn.g.a.b.b(context);
            String str2 = b;
            if (com.opos.cmn.an.c.a.a(b)) {
                str2 = com.opos.cmn.g.a.c.a(context);
            }
            str = (Math.abs(str2.hashCode()) % 100000) + "";
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c("RouteDataTool", "", e);
            str = "";
        }
        com.opos.cmn.an.f.a.b("RouteDataTool", "getAdgValue=" + str);
        return str;
    }
}
