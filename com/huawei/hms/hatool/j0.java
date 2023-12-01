package com.huawei.hms.hatool;

import java.util.List;
import java.util.Map;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/hatool/j0.class */
public class j0 implements o0 {

    /* renamed from: a  reason: collision with root package name */
    public byte[] f22754a;
    public String b;

    /* renamed from: c  reason: collision with root package name */
    public String f22755c;
    public String d;
    public String e;
    public List<q> f;

    public j0(byte[] bArr, String str, String str2, String str3, String str4, List<q> list) {
        this.f22754a = (byte[]) bArr.clone();
        this.b = str;
        this.f22755c = str2;
        this.e = str3;
        this.d = str4;
        this.f = list;
    }

    public final c0 a(Map<String, String> map) {
        return b0.a(this.b, this.f22754a, map);
    }

    public final Map<String, String> a() {
        return e1.b(this.f22755c, this.e, this.d);
    }

    public final void b() {
        p0.c().a(new m0(this.f, this.f22755c, this.d, this.e));
    }

    @Override // java.lang.Runnable
    public void run() {
        z.c("hmsSdk", "send data running");
        int b = a(a()).b();
        if (b != 200) {
            b();
            return;
        }
        z.b("hmsSdk", "events PostRequest sendevent TYPE : %s, TAG : %s, resultCode: %d ,reqID:" + this.d, this.e, this.f22755c, Integer.valueOf(b));
    }
}
