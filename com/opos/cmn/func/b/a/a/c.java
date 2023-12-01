package com.opos.cmn.func.b.a.a;

/* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/func/b/a/a/c.class */
public class c {
    public static String a() {
        try {
            return System.getProperty("http.agent");
        } catch (Exception e) {
            com.opos.cmn.an.f.a.c("Utils", "getUA", e);
            return "";
        }
    }
}
