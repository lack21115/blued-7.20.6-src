package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import java.util.Map;

/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/push/ay.class */
public class ay implements as {

    /* renamed from: a  reason: collision with root package name */
    private static volatile ay f41266a;

    /* renamed from: a  reason: collision with other field name */
    private int f204a = ax.f41265a;

    /* renamed from: a  reason: collision with other field name */
    private as f205a;

    private ay(Context context) {
        this.f205a = ax.a(context);
        com.xiaomi.channel.commonutils.logger.b.m11394a("create id manager is: " + this.f204a);
    }

    public static ay a(Context context) {
        if (f41266a == null) {
            synchronized (ay.class) {
                try {
                    if (f41266a == null) {
                        f41266a = new ay(context.getApplicationContext());
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f41266a;
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
    public String mo11508a() {
        return a(this.f205a.mo11508a());
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
        String mo11508a = mo11508a();
        if (!TextUtils.isEmpty(mo11508a)) {
            map.put("oaid", mo11508a);
        }
        String c2 = c();
        if (!TextUtils.isEmpty(c2)) {
            map.put("vaid", c2);
        }
        String d = d();
        if (!TextUtils.isEmpty(d)) {
            map.put("aaid", d);
        }
        map.put("oaid_type", String.valueOf(this.f204a));
    }

    @Override // com.xiaomi.push.as
    /* renamed from: a */
    public boolean mo11509a() {
        return this.f205a.mo11509a();
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
