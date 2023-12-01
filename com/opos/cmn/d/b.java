package com.opos.cmn.d;

/* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/d/b.class */
public class b {
    public static String a(String str) {
        return !com.opos.cmn.an.c.a.a(str) ? com.opos.cmn.an.a.c.a(str) : "";
    }

    public static boolean a(String str, String str2) {
        boolean z = com.opos.cmn.an.d.b.a.a(str) && (com.opos.cmn.an.c.a.a(str2) || com.opos.cmn.an.a.c.b(str).equals(str2));
        StringBuilder sb = new StringBuilder();
        sb.append("verifyFileIntegrity filePath=");
        if (str == null) {
            str = com.igexin.push.core.b.l;
        }
        sb.append(str);
        sb.append(",md5=");
        if (str2 == null) {
            str2 = com.igexin.push.core.b.l;
        }
        sb.append(str2);
        sb.append(",result=");
        sb.append(z);
        com.opos.cmn.an.f.a.b("FileVerifier", sb.toString());
        return z;
    }
}
