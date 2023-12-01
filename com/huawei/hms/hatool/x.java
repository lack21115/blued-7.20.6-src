package com.huawei.hms.hatool;

import java.util.ArrayList;
import java.util.UUID;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/hatool/x.class */
public class x {

    /* renamed from: a  reason: collision with root package name */
    public String f22797a;
    public String b;

    /* renamed from: c  reason: collision with root package name */
    public String f22798c;
    public String d;
    public long e;

    public x(String str, String str2, String str3, String str4, long j) {
        this.f22797a = str;
        this.b = str2;
        this.f22798c = str3;
        this.d = str4;
        this.e = j;
    }

    public void a() {
        z.c("StreamEventHandler", "Begin to handle stream events...");
        q qVar = new q();
        qVar.b(this.f22798c);
        qVar.d(this.b);
        qVar.a(this.d);
        qVar.c(String.valueOf(this.e));
        if ("oper".equals(this.b) && a.i(this.f22797a, "oper")) {
            g0 a2 = f0.a().a(this.f22797a, this.e);
            String a3 = a2.a();
            boolean b = a2.b();
            qVar.f(a3);
            qVar.e(String.valueOf(Boolean.valueOf(b)));
        }
        String replace = UUID.randomUUID().toString().replace("-", "");
        ArrayList arrayList = new ArrayList();
        arrayList.add(qVar);
        new u(this.f22797a, this.b, b.g(), arrayList, replace).a();
    }
}
