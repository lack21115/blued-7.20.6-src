package com.youzan.androidsdk.tool;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

/* loaded from: source-8829756-dex2jar.jar:com/youzan/androidsdk/tool/Preference.class */
public final class Preference {

    /* renamed from: ˊ  reason: contains not printable characters */
    private static Preference f1139;

    /* renamed from: ˋ  reason: contains not printable characters */
    private final Bundle f1140 = new Bundle();

    /* renamed from: ˎ  reason: contains not printable characters */
    private SharedPreferences f1141;

    /* renamed from: ˏ  reason: contains not printable characters */
    private SharedPreferences.Editor f1142;

    private Preference() {
    }

    public static Preference instance() {
        if (f1139 == null) {
            synchronized (Preference.class) {
                try {
                    if (f1139 == null) {
                        f1139 = new Preference();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f1139;
    }

    public static void renew(Context context) {
        if (instance().m12247() || context == null) {
            return;
        }
        instance().init(context);
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    private boolean m12247() {
        return (this.f1141 == null || this.f1142 == null) ? false : true;
    }

    public final int getInt(String str, int i) {
        int i2 = this.f1140.getInt(str, Integer.MIN_VALUE);
        if (i2 != Integer.MIN_VALUE) {
            return i2;
        }
        if (m12247()) {
            int i3 = this.f1141.getInt(str, i);
            this.f1140.putInt(str, i3);
            return i3;
        }
        return 0;
    }

    public final long getLong(String str, long j) {
        long j2 = this.f1140.getLong(str, Long.MIN_VALUE);
        if (j2 != Long.MIN_VALUE) {
            return j2;
        }
        if (m12247()) {
            long j3 = this.f1141.getLong(str, j);
            this.f1140.putLong(str, j3);
            return j3;
        }
        return 0L;
    }

    public final String getString(String str, String str2) {
        String string = this.f1140.getString(str, "!@INVALID!@");
        if ("!@INVALID!@".equals(string)) {
            if (m12247()) {
                String string2 = this.f1141.getString(str, str2);
                this.f1140.putString(str, string2);
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
        this.f1141 = sharedPreferences;
        this.f1142 = sharedPreferences.edit();
    }

    public final void remove(String str) {
        this.f1140.remove(str);
        if (m12247()) {
            this.f1142.remove(str).commit();
        }
    }

    public final void setInt(String str, int i) {
        if (i == Integer.MIN_VALUE) {
            remove(str);
            return;
        }
        if (m12247()) {
            this.f1142.putInt(str, i);
            this.f1142.commit();
        }
        this.f1140.putInt(str, i);
    }

    public final void setLong(String str, long j) {
        if (j == Long.MIN_VALUE) {
            remove(str);
            return;
        }
        if (m12247()) {
            this.f1142.putLong(str, j);
            this.f1142.commit();
        }
        this.f1140.putLong(str, j);
    }

    public final void setString(String str, String str2) {
        if (str2 == null) {
            remove(str);
            return;
        }
        if (m12247()) {
            this.f1142.putString(str, str2);
            this.f1142.commit();
        }
        this.f1140.putString(str, str2);
    }
}
