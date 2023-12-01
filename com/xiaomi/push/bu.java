package com.xiaomi.push;

import android.content.Context;
import android.content.SharedPreferences;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/bu.class */
public class bu {

    /* renamed from: a  reason: collision with root package name */
    private static volatile bu f27599a;

    /* renamed from: a  reason: collision with other field name */
    private Context f179a;

    private bu(Context context) {
        this.f179a = context;
    }

    public static bu a(Context context) {
        if (f27599a == null) {
            synchronized (bu.class) {
                try {
                    if (f27599a == null) {
                        f27599a = new bu(context);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f27599a;
    }

    public long a(String str, String str2, long j) {
        long j2;
        synchronized (this) {
            try {
                j2 = this.f179a.getSharedPreferences(str, 4).getLong(str2, j);
            } catch (Throwable th) {
                return j;
            }
        }
        return j2;
    }

    public String a(String str, String str2, String str3) {
        String string;
        synchronized (this) {
            try {
                string = this.f179a.getSharedPreferences(str, 4).getString(str2, str3);
            } catch (Throwable th) {
                return str3;
            }
        }
        return string;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m8504a(String str, String str2, long j) {
        synchronized (this) {
            SharedPreferences.Editor edit = this.f179a.getSharedPreferences(str, 4).edit();
            edit.putLong(str2, j);
            edit.commit();
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m8505a(String str, String str2, String str3) {
        synchronized (this) {
            SharedPreferences.Editor edit = this.f179a.getSharedPreferences(str, 4).edit();
            edit.putString(str2, str3);
            edit.commit();
        }
    }
}
