package com.bytedance.bdtracker;

import android.content.SharedPreferences;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/bdtracker/a.class */
public class a {
    public static String a(StringBuilder sb, String str, String str2) {
        sb.append(str);
        sb.append(str2);
        return sb.toString();
    }

    public static StringBuilder a(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        return sb;
    }

    public static void a(SharedPreferences sharedPreferences, String str, String str2) {
        sharedPreferences.edit().putString(str, str2).apply();
    }
}
