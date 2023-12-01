package com.yxcorp.kuaishou.addfp.android.a;

import android.content.Context;
import android.content.SharedPreferences;

/* loaded from: source-8829756-dex2jar.jar:com/yxcorp/kuaishou/addfp/android/a/e.class */
public class e {

    /* renamed from: a  reason: collision with root package name */
    private SharedPreferences f41855a;
    private SharedPreferences.Editor b;

    public e(Context context) {
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences("kscfg_outdfp", 0);
            this.f41855a = sharedPreferences;
            this.b = sharedPreferences.edit();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void a(String str) {
        this.b.putString("kwtk", str);
        this.b.commit();
    }

    public boolean a() {
        return this.f41855a.getBoolean("xytk", true);
    }

    public String b() {
        return this.f41855a.getString("kwtk", "");
    }
}
