package com.zx.a.I8b7;

import com.zx.sdk.api.SAIDCallback;

/* loaded from: source-8829756-dex2jar.jar:com/zx/a/I8b7/f2.class */
public class f2 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f28438a;
    public final /* synthetic */ String b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f28439c;
    public final /* synthetic */ String d;
    public final /* synthetic */ String e;
    public final /* synthetic */ String f;
    public final /* synthetic */ SAIDCallback g;

    public f2(e2 e2Var, String str, String str2, String str3, String str4, String str5, String str6, SAIDCallback sAIDCallback) {
        this.f28438a = str;
        this.b = str2;
        this.f28439c = str3;
        this.d = str4;
        this.e = str5;
        this.f = str6;
        this.g = sAIDCallback;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            e2.a().a(this.f28438a, this.b, this.f28439c, this.d, this.e, this.f, this.g);
        } catch (Throwable th) {
            SAIDCallback sAIDCallback = this.g;
            if (sAIDCallback != null) {
                sAIDCallback.onFailed(10000, th.getMessage());
            }
            n2.a(th, m2.a("ZXManager.getSAID() failed: "));
        }
    }
}
