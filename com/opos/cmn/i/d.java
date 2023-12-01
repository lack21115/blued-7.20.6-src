package com.opos.cmn.i;

/* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/i/d.class */
public class d {
    public static String a() {
        String str = "";
        try {
            str = System.getProperty("http.agent");
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("DeviceUtils", "", (Throwable) e);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("getUserAgent=");
        sb.append(str != null ? str : com.igexin.push.core.b.l);
        com.opos.cmn.an.f.a.b("DeviceUtils", sb.toString());
        return str;
    }
}
