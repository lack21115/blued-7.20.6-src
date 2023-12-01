package com.tencent.beacon.base.net.adapter;

import okhttp3.Callback;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/beacon/base/net/adapter/d.class */
class d implements Callback {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ com.tencent.beacon.base.net.call.Callback f21275a;
    final /* synthetic */ String b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ OkHttpAdapter f21276c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(OkHttpAdapter okHttpAdapter, com.tencent.beacon.base.net.call.Callback callback, String str) {
        this.f21276c = okHttpAdapter;
        this.f21275a = callback;
        this.b = str;
    }
}
