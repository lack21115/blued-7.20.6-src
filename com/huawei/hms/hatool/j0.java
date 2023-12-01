package com.huawei.hms.hatool;

import java.util.List;
import java.util.Map;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/hatool/j0.class */
public class j0 implements o0 {

    /* renamed from: a  reason: collision with root package name */
    public byte[] f9146a;
    public String b;

    /* renamed from: c  reason: collision with root package name */
    public String f9147c;
    public String d;
    public String e;
    public List<q> f;

    public j0(byte[] bArr, String str, String str2, String str3, String str4, List<q> list) {
        this.f9146a = (byte[]) bArr.clone();
        this.b = str;
        this.f9147c = str2;
        this.e = str3;
        this.d = str4;
        this.f = list;
    }

    public final c0 a(Map<String, String> map) {
        return b0.a(this.b, this.f9146a, map);
    }

    public final Map<String, String> a() {
        return e1.b(this.f9147c, this.e, this.d);
    }

    public final void b() {
        p0.c().a(new m0(this.f, this.f9147c, this.d, this.e));
    }

    @Override // java.lang.Runnable
    public void run() {
        z.c("hmsSdk", "send data running");
        int b = a(a()).b();
        if (b != 200) {
            b();
            return;
        }
        z.b("hmsSdk", "events PostRequest sendevent TYPE : %s, TAG : %s, resultCode: %d ,reqID:" + this.d, this.e, this.f9147c, Integer.valueOf(b));
    }
}
