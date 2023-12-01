package com.tramini.plugin.a.g;

import java.security.MessageDigest;

/* loaded from: source-8829756-dex2jar.jar:com/tramini/plugin/a/g/f.class */
public final class f {

    /* renamed from: a  reason: collision with root package name */
    private static char[] f40548a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public static String a(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(str.getBytes());
            byte[] digest = messageDigest.digest();
            StringBuilder sb = new StringBuilder(digest.length * 2);
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= digest.length) {
                    return sb.toString().toLowerCase();
                }
                sb.append(f40548a[(digest[i2] & 240) >>> 4]);
                sb.append(f40548a[digest[i2] & 15]);
                i = i2 + 1;
            }
        } catch (Exception e) {
            return "";
        }
    }
}
