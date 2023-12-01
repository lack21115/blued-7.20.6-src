package com.huawei.hms.base.log;

import android.content.Context;
import android.util.Log;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/base/log/a.class */
public class a {
    public String b;

    /* renamed from: a  reason: collision with root package name */
    public int f22611a = 4;

    /* renamed from: c  reason: collision with root package name */
    public b f22612c = new e();

    public b a() {
        return this.f22612c;
    }

    public final c a(int i, String str, String str2, Throwable th) {
        c cVar = new c(8, this.b, i, str);
        cVar.a((c) str2);
        cVar.a(th);
        return cVar;
    }

    public void a(int i, String str, String str2) {
        if (a(i)) {
            c a2 = a(i, str, str2, null);
            this.f22612c.a(a2.c() + a2.a(), i, str, str2);
        }
    }

    public void a(Context context, int i, String str) {
        this.f22611a = i;
        this.b = str;
        this.f22612c.a(context, "HMSCore");
    }

    public void a(b bVar) {
        this.f22612c = bVar;
    }

    public void a(String str, String str2) {
        c a2 = a(4, str, str2, null);
        this.f22612c.a(a2.c() + '\n' + a2.a(), 4, str, str2);
    }

    public boolean a(int i) {
        return i >= this.f22611a;
    }

    public void b(int i, String str, String str2, Throwable th) {
        if (a(i)) {
            c a2 = a(i, str, str2, th);
            String str3 = a2.c() + a2.a();
            this.f22612c.a(str3, i, str, str2 + '\n' + Log.getStackTraceString(th));
        }
    }
}
