package com.opos.cmn.an.a;

import java.io.File;
import java.security.MessageDigest;

/* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/an/a/c.class */
public final class c {
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:79:0x017e  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0186  */
    /* JADX WARN: Type inference failed for: r0v32, types: [java.io.FileInputStream] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:54:0x0107 -> B:83:0x016b). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String a(java.io.File r5) {
        /*
            Method dump skipped, instructions count: 425
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.cmn.an.a.c.a(java.io.File):java.lang.String");
    }

    public static String a(String str) {
        String a2 = !com.opos.cmn.an.c.a.a(str) ? a(str.getBytes()) : "";
        StringBuilder sb = new StringBuilder();
        sb.append("md5 before=");
        if (str == null) {
            str = com.igexin.push.core.b.l;
        }
        sb.append(str);
        sb.append(",md5 after=");
        sb.append(a2);
        com.opos.cmn.an.f.a.b("Md5Tool", sb.toString());
        return a2;
    }

    public static String a(byte[] bArr) {
        String str = "";
        String str2 = str;
        if (bArr != null) {
            str2 = str;
            try {
                byte[] digest = MessageDigest.getInstance("MD5").digest(bArr);
                int length = digest.length;
                int i = 0;
                while (true) {
                    int i2 = i;
                    str2 = str;
                    if (i2 >= length) {
                        break;
                    }
                    str2 = str;
                    String hexString = Integer.toHexString(digest[i2] & 255);
                    String str3 = hexString;
                    if (hexString.length() == 1) {
                        String str4 = str;
                        StringBuilder sb = new StringBuilder();
                        String str5 = str;
                        sb.append("0");
                        String str6 = str;
                        sb.append(hexString);
                        String str7 = str;
                        str3 = sb.toString();
                    }
                    String str8 = str;
                    StringBuilder sb2 = new StringBuilder();
                    String str9 = str;
                    sb2.append(str);
                    String str10 = str;
                    sb2.append(str3);
                    String str11 = str;
                    str = sb2.toString();
                    i = i2 + 1;
                }
            } catch (Exception e) {
                com.opos.cmn.an.f.a.c("Md5Tool", "md5", e);
            }
        }
        StringBuilder sb3 = new StringBuilder();
        sb3.append("md5 before=");
        sb3.append(bArr != null ? new String(bArr) : com.igexin.push.core.b.l);
        sb3.append(",md5 after=");
        sb3.append(str2);
        com.opos.cmn.an.f.a.b("Md5Tool", sb3.toString());
        return str2;
    }

    public static String b(String str) {
        String a2 = !com.opos.cmn.an.c.a.a(str) ? a(new File(str)) : "";
        StringBuilder sb = new StringBuilder();
        sb.append("md5File file=");
        if (str == null) {
            str = com.igexin.push.core.b.l;
        }
        sb.append(str);
        sb.append(",md5=");
        sb.append(a2);
        com.opos.cmn.an.f.a.b("Md5Tool", sb.toString());
        return a2;
    }
}
