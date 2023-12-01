package com.tencent.liteav.base.http;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/base/http/b.class */
final /* synthetic */ class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final HttpClientAndroid f22606a;

    private b(HttpClientAndroid httpClientAndroid) {
        this.f22606a = httpClientAndroid;
    }

    public static Runnable a(HttpClientAndroid httpClientAndroid) {
        return new b(httpClientAndroid);
    }

    @Override // java.lang.Runnable
    public final void run() {
        HttpClientAndroid.lambda$cancelAll$1(this.f22606a);
    }
}
