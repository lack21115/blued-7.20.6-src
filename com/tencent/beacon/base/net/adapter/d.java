package com.tencent.beacon.base.net.adapter;

import okhttp3.Callback;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/beacon/base/net/adapter/d.class */
class d implements Callback {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ com.tencent.beacon.base.net.call.Callback f34966a;
    final /* synthetic */ String b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ OkHttpAdapter f34967c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(OkHttpAdapter okHttpAdapter, com.tencent.beacon.base.net.call.Callback callback, String str) {
        this.f34967c = okHttpAdapter;
        this.f34966a = callback;
        this.b = str;
    }
}
