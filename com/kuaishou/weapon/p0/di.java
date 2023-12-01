package com.kuaishou.weapon.p0;

import org.json.JSONArray;

/* loaded from: source-7994992-dex2jar.jar:com/kuaishou/weapon/p0/di.class */
public class di {

    /* renamed from: a  reason: collision with root package name */
    private static final String f23824a = "bGlidmErKw==";
    private static final String b = "WnBvc2VkQnJpZGdlLmphcg==";

    /* renamed from: c  reason: collision with root package name */
    private static final String f23825c = "bGlienBvc2VkX2FydC5zbw==";

    public static Integer a(JSONArray jSONArray) {
        if (jSONArray != null) {
            try {
                if (jSONArray.length() > 0) {
                    String str = new String(c.a(b.getBytes(), 2));
                    byte[] a2 = c.a(f23825c.getBytes(), 2);
                    String str2 = new String(a2);
                    if (a2 != null) {
                        return a(jSONArray, str, str2) ? 1 : null;
                    }
                    return null;
                }
                return null;
            } catch (Exception e) {
                return null;
            }
        }
        return null;
    }

    private static boolean a(JSONArray jSONArray, String str) {
        try {
            if (jSONArray.length() <= 0) {
                return false;
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= jSONArray.length()) {
                    return false;
                }
                if (((String) jSONArray.get(i2)).contains(str)) {
                    return true;
                }
                i = i2 + 1;
            }
        } catch (Exception e) {
            return false;
        }
    }

    private static boolean a(JSONArray jSONArray, String str, String str2) {
        try {
            if (jSONArray.length() <= 0) {
                return false;
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= jSONArray.length()) {
                    return false;
                }
                String str3 = (String) jSONArray.get(i2);
                if (str3.contains(str) || str3.contains(str2)) {
                    return true;
                }
                i = i2 + 1;
            }
        } catch (Exception e) {
            return false;
        }
    }

    public static Integer b(JSONArray jSONArray) {
        if (jSONArray != null) {
            try {
                if (jSONArray.length() > 0) {
                    String str = new String(c.a(f23824a.getBytes(), 2));
                    if (str.length() > 1) {
                        return a(jSONArray, str) ? 1 : null;
                    }
                    return null;
                }
                return null;
            } catch (Exception e) {
                return null;
            }
        }
        return null;
    }
}
