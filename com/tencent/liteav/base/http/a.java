package com.tencent.liteav.base.http;

import com.tencent.liteav.base.http.HttpClientAndroid;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/base/http/a.class */
final /* synthetic */ class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final HttpClientAndroid f36296a;
    private final HttpClientAndroid.d b;

    private a(HttpClientAndroid httpClientAndroid, HttpClientAndroid.d dVar) {
        this.f36296a = httpClientAndroid;
        this.b = dVar;
    }

    public static Runnable a(HttpClientAndroid httpClientAndroid, HttpClientAndroid.d dVar) {
        return new a(httpClientAndroid, dVar);
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f36296a.doRequest(this.b);
    }
}
