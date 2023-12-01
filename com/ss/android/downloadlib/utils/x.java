package com.ss.android.downloadlib.utils;

import org.json.JSONObject;

/* loaded from: source-8457232-dex2jar.jar:com/ss/android/downloadlib/utils/x.class */
public class x {
    public static void b(String str, String str2, JSONObject jSONObject) {
        com.ss.android.download.api.config.jb io2 = com.ss.android.downloadlib.addownload.x.io();
        if (io2 != null) {
            io2.mb(6, str, str2, jSONObject);
        }
    }

    public static void mb(String str) {
        b(null, str, null);
    }

    public static void mb(String str, String str2) {
        b(str, str2, null);
    }

    public static void mb(String str, String str2, JSONObject jSONObject) {
        com.ss.android.download.api.config.jb io2 = com.ss.android.downloadlib.addownload.x.io();
        if (io2 != null) {
            io2.mb(2, str, str2, jSONObject);
        }
    }

    public static void ox(String str, String str2, JSONObject jSONObject) {
        com.ss.android.download.api.config.jb io2 = com.ss.android.downloadlib.addownload.x.io();
        if (io2 != null) {
            io2.mb(3, str, str2, jSONObject);
        }
    }
}
