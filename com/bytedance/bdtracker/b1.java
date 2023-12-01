package com.bytedance.bdtracker;

import android.content.SharedPreferences;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/bdtracker/b1.class */
public class b1 {
    public static final long[][] h = {new long[]{com.igexin.push.config.c.l, 0, 12}, new long[]{com.igexin.push.config.c.l, 5, 1}, new long[]{240000, 5, 1}, new long[]{480000, 4, 1}, new long[]{960000, 2, 1}};

    /* renamed from: a  reason: collision with root package name */
    public String f7590a;
    public m0 b;

    /* renamed from: c  reason: collision with root package name */
    public int f7591c;
    public int d;
    public int e;
    public long f;
    public long g;

    public b1(String str, m0 m0Var) {
        this.b = m0Var;
        this.f7590a = str;
        this.f7591c = 0;
        if (System.currentTimeMillis() - m0Var.e.getLong(a.a(new StringBuilder(), this.f7590a, "downgrade_time"), 0L) < 10800000) {
            SharedPreferences sharedPreferences = this.b.e;
            this.f7591c = sharedPreferences.getInt(this.f7590a + "downgrade_index", 0);
            return;
        }
        SharedPreferences.Editor edit = this.b.e.edit();
        SharedPreferences.Editor remove = edit.remove(this.f7590a + "downgrade_time");
        remove.remove(this.f7590a + "downgrade_index").apply();
    }

    public final boolean a() {
        return this.b.b.isCongestionControlEnable();
    }
}
