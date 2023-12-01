package com.xiaomi.mipush.sdk;

import com.xiaomi.mipush.sdk.MiTinyDataClient;
import com.xiaomi.push.hk;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8829756-dex2jar.jar:com/xiaomi/mipush/sdk/aa.class */
public class aa implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MiTinyDataClient.a.C1093a f41195a;

    /* renamed from: a  reason: collision with other field name */
    final /* synthetic */ hk f122a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(MiTinyDataClient.a.C1093a c1093a, hk hkVar) {
        this.f41195a = c1093a;
        this.f122a = hkVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f41195a.f117a.add(this.f122a);
        this.f41195a.a();
    }
}
