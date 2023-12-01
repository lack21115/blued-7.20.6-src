package com.huawei.hms.hatool;

import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.UUID;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/hatool/x.class */
public class x {

    /* renamed from: a  reason: collision with root package name */
    public String f9189a;
    public String b;

    /* renamed from: c  reason: collision with root package name */
    public String f9190c;
    public String d;
    public long e;

    public x(String str, String str2, String str3, String str4, long j) {
        this.f9189a = str;
        this.b = str2;
        this.f9190c = str3;
        this.d = str4;
        this.e = j;
    }

    public void a() {
        z.c("StreamEventHandler", "Begin to handle stream events...");
        q qVar = new q();
        qVar.b(this.f9190c);
        qVar.d(this.b);
        qVar.a(this.d);
        qVar.c(String.valueOf(this.e));
        if ("oper".equals(this.b) && a.i(this.f9189a, "oper")) {
            g0 a2 = f0.a().a(this.f9189a, this.e);
            String a3 = a2.a();
            boolean b = a2.b();
            qVar.f(a3);
            qVar.e(String.valueOf(Boolean.valueOf(b)));
        }
        String replace = UUID.randomUUID().toString().replace(Constants.ACCEPT_TIME_SEPARATOR_SERVER, "");
        ArrayList arrayList = new ArrayList();
        arrayList.add(qVar);
        new u(this.f9189a, this.b, b.g(), arrayList, replace).a();
    }
}
