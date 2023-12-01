package com.tencent.beacon.base.net.adapter;

import okhttp3.Callback;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/beacon/base/net/adapter/c.class */
class c implements Callback {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ com.tencent.beacon.base.net.call.Callback f21273a;
    final /* synthetic */ String b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ OkHttpAdapter f21274c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(OkHttpAdapter okHttpAdapter, com.tencent.beacon.base.net.call.Callback callback, String str) {
        this.f21274c = okHttpAdapter;
        this.f21273a = callback;
        this.b = str;
    }
}
