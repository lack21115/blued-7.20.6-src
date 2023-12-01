package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import java.util.Map;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/ay.class */
public class ay implements as {

    /* renamed from: a  reason: collision with root package name */
    private static volatile ay f27575a;

    /* renamed from: a  reason: collision with other field name */
    private int f157a = ax.f27574a;

    /* renamed from: a  reason: collision with other field name */
    private as f158a;

    private ay(Context context) {
        this.f158a = ax.a(context);
        com.xiaomi.channel.commonutils.logger.b.m8344a("create id manager is: " + this.f157a);
    }

    public static ay a(Context context) {
        if (f27575a == null) {
            synchronized (ay.class) {
                try {
                    if (f27575a == null) {
                        f27575a = new ay(context.getApplicationContext());
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f27575a;
    }

    private String a(String str) {
        String str2 = str;
        if (str == null) {
            str2 = "";
        }
        return str2;
    }

    @Override // com.xiaomi.push.as
    /* renamed from: a */
    public String mo8458a() {
        return a(this.f158a.mo8458a());
    }

    public void a() {
    }

    public void a(Map<String, String> map) {
        if (map == null) {
            return;
        }
        String b = b();
        if (!TextUtils.isEmpty(b)) {
            map.put("udid", b);
        }
        String mo8458a = mo8458a();
        if (!TextUtils.isEmpty(mo8458a)) {
            map.put("oaid", mo8458a);
        }
        String c2 = c();
        if (!TextUtils.isEmpty(c2)) {
            map.put("vaid", c2);
        }
        String d = d();
        if (!TextUtils.isEmpty(d)) {
            map.put("aaid", d);
        }
        map.put("oaid_type", String.valueOf(this.f157a));
    }

    @Override // com.xiaomi.push.as
    /* renamed from: a */
    public boolean mo8459a() {
        return this.f158a.mo8459a();
    }

    public String b() {
        return null;
    }

    public String c() {
        return null;
    }

    public String d() {
        return null;
    }
}
