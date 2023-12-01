package com.bytedance.bdtracker;

import android.content.Context;
import android.content.SharedPreferences;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/bdtracker/u2.class */
public class u2 {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f21322a;
    public static j2<SharedPreferences> b = new a();

    /* loaded from: source-7206380-dex2jar.jar:com/bytedance/bdtracker/u2$a.class */
    public static final class a extends j2<SharedPreferences> {
        @Override // com.bytedance.bdtracker.j2
        public SharedPreferences a(Object[] objArr) {
            return e2.a((Context) objArr[0], "ug_install_settings_pref", 0);
        }
    }

    public static boolean a(Context context) {
        if (context == null) {
            return false;
        }
        if (f21322a) {
            return true;
        }
        return b.b(context).getBoolean("_install_started_v2", false);
    }

    public static void c(final Context context) {
        f21322a = true;
        p.f21279a.submit(new Runnable() { // from class: com.bytedance.bdtracker.-$$Lambda$ollyFADSgX4drvciTJ4BwX9GYL8
            @Override // java.lang.Runnable
            public final void run() {
                u2.b.b(Context.this).edit().putBoolean("_install_started_v2", true).apply();
            }
        });
    }
}
