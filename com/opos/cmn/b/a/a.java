package com.opos.cmn.b.a;

import java.text.SimpleDateFormat;
import java.util.Date;

/* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/b/a/a.class */
public final class a {
    public static String a(Date date) {
        if (date != null) {
            try {
                return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS").format(date);
            } catch (Exception e) {
                com.opos.cmn.an.f.a.c("DateTool", "getTimeToMil", e);
                return "";
            }
        }
        return "";
    }

    public static Date a() {
        return new Date();
    }

    public static String b() {
        try {
            return a(a());
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c("DateTool", "getNowTimeToMil", e);
            return "";
        }
    }

    public static long c() {
        return System.currentTimeMillis();
    }
}
