package com.youzan.androidsdk.tool;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

/* loaded from: source-8829756-dex2jar.jar:com/youzan/androidsdk/tool/Preference.class */
public final class Preference {

    /* renamed from: ˊ  reason: contains not printable characters */
    private static Preference f1092;

    /* renamed from: ˋ  reason: contains not printable characters */
    private final Bundle f1093 = new Bundle();

    /* renamed from: ˎ  reason: contains not printable characters */
    private SharedPreferences f1094;

    /* renamed from: ˏ  reason: contains not printable characters */
    private SharedPreferences.Editor f1095;

    private Preference() {
    }

    public static Preference instance() {
        if (f1092 == null) {
            synchronized (Preference.class) {
                try {
                    if (f1092 == null) {
                        f1092 = new Preference();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f1092;
    }

    public static void renew(Context context) {
        if (instance().m9197() || context == null) {
            return;
        }
        instance().init(context);
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private boolean m9197() {
        return (this.f1094 == null || this.f1095 == null) ? false : true;
    }

    public final int getInt(String str, int i) {
        int i2 = this.f1093.getInt(str, Integer.MIN_VALUE);
        if (i2 != Integer.MIN_VALUE) {
            return i2;
        }
        if (m9197()) {
            int i3 = this.f1094.getInt(str, i);
            this.f1093.putInt(str, i3);
            return i3;
        }
        return 0;
    }

    public final long getLong(String str, long j) {
        long j2 = this.f1093.getLong(str, Long.MIN_VALUE);
        if (j2 != Long.MIN_VALUE) {
            return j2;
        }
        if (m9197()) {
            long j3 = this.f1094.getLong(str, j);
            this.f1093.putLong(str, j3);
            return j3;
        }
        return 0L;
    }

    public final String getString(String str, String str2) {
        String string = this.f1093.getString(str, "!@INVALID!@");
        if ("!@INVALID!@".equals(string)) {
            if (m9197()) {
                String string2 = this.f1094.getString(str, str2);
                this.f1093.putString(str, string2);
                return string2;
            }
            return null;
        }
        return string;
    }

    public final void init(Context context) {
        Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            context = applicationContext;
        }
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.youzan.open.sdk.preferences", 0);
        this.f1094 = sharedPreferences;
        this.f1095 = sharedPreferences.edit();
    }

    public final void remove(String str) {
        this.f1093.remove(str);
        if (m9197()) {
            this.f1095.remove(str).commit();
        }
    }

    public final void setInt(String str, int i) {
        if (i == Integer.MIN_VALUE) {
            remove(str);
            return;
        }
        if (m9197()) {
            this.f1095.putInt(str, i);
            this.f1095.commit();
        }
        this.f1093.putInt(str, i);
    }

    public final void setLong(String str, long j) {
        if (j == Long.MIN_VALUE) {
            remove(str);
            return;
        }
        if (m9197()) {
            this.f1095.putLong(str, j);
            this.f1095.commit();
        }
        this.f1093.putLong(str, j);
    }

    public final void setString(String str, String str2) {
        if (str2 == null) {
            remove(str);
            return;
        }
        if (m9197()) {
            this.f1095.putString(str, str2);
            this.f1095.commit();
        }
        this.f1093.putString(str, str2);
    }
}
