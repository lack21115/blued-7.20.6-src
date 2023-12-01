package com.tencent.liteav.base.http;

import com.tencent.liteav.base.http.HttpClientAndroid;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/base/http/d.class */
public final /* synthetic */ class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final HttpClientAndroid f36299a;
    private final HttpClientAndroid.e b;

    /* renamed from: c  reason: collision with root package name */
    private final long f36300c;

    private d(HttpClientAndroid httpClientAndroid, HttpClientAndroid.e eVar, long j) {
        this.f36299a = httpClientAndroid;
        this.b = eVar;
        this.f36300c = j;
    }

    public static Runnable a(HttpClientAndroid httpClientAndroid, HttpClientAndroid.e eVar, long j) {
        return new d(httpClientAndroid, eVar, j);
    }

    @Override // java.lang.Runnable
    public final void run() {
        HttpClientAndroid.lambda$doReadData$3(this.f36299a, this.b, this.f36300c);
    }
}
