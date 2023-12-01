package com.ishumei.l111l1111llIl;

import android.content.SharedPreferences;
import java.util.Set;

/* loaded from: source-7994992-dex2jar.jar:com/ishumei/l111l1111llIl/l111l1111llIl.class */
public final class l111l1111llIl {
    public static void l1111l111111Il(SharedPreferences sharedPreferences, String str, int i) {
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putInt(str, i);
        edit.apply();
    }

    public static void l1111l111111Il(SharedPreferences sharedPreferences, String str, long j) {
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putLong(str, j);
        edit.apply();
    }

    private static void l1111l111111Il(SharedPreferences sharedPreferences, String str, String str2) {
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putString(str, str2);
        edit.apply();
    }

    public static void l1111l111111Il(SharedPreferences sharedPreferences, String str, Set<String> set) {
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putStringSet(str, set);
        edit.apply();
    }
}
