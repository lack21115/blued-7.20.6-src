package com.xiaomi.mipush.sdk;

import com.xiaomi.mipush.sdk.MiTinyDataClient;
import com.xiaomi.push.hk;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/mipush/sdk/aa.class */
public class aa implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MiTinyDataClient.a.C0923a f27504a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ hk f75a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(MiTinyDataClient.a.C0923a c0923a, hk hkVar) {
        this.f27504a = c0923a;
        this.f75a = hkVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f27504a.f70a.add(this.f75a);
        this.f27504a.a();
    }
}
