package com.tencent.beacon.a.b;

import com.tencent.beacon.base.net.BResponse;
import com.tencent.beacon.base.net.call.Callback;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8457232-dex2jar.jar:com/tencent/beacon/a/b/b.class */
public class b implements Callback<BResponse> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f21232a;
    final /* synthetic */ String b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ Throwable f21233c;
    final /* synthetic */ e d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(e eVar, String str, String str2, Throwable th) {
        this.d = eVar;
        this.f21232a = str;
        this.b = str2;
        this.f21233c = th;
    }

    @Override // com.tencent.beacon.base.net.call.Callback
    /* renamed from: a */
    public void onResponse(BResponse bResponse) {
        com.tencent.beacon.base.util.c.a("AttaReport", "net ret: " + bResponse.toString(), new Object[0]);
    }

    @Override // com.tencent.beacon.base.net.call.Callback
    public void onFailure(com.tencent.beacon.base.net.d dVar) {
        this.d.b(this.f21232a, this.b, this.f21233c);
    }
}
