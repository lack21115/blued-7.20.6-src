package com.meizu.cloud.pushsdk.c.c;

import com.sobot.network.http.SobotOkHttpUtils;

/* loaded from: source-7994992-dex2jar.jar:com/meizu/cloud/pushsdk/c/c/d.class */
public class d {
    public static boolean a(String str) {
        return "POST".equals(str) || "PUT".equals(str) || SobotOkHttpUtils.METHOD.PATCH.equals(str) || "PROPPATCH".equals(str) || "REPORT".equals(str);
    }

    public static boolean b(String str) {
        return a(str) || "OPTIONS".equals(str) || "DELETE".equals(str) || "PROPFIND".equals(str) || "MKCOL".equals(str) || "LOCK".equals(str);
    }
}
