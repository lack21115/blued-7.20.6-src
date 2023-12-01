package com.tencent.liteav.base.http;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/base/http/c.class */
final /* synthetic */ class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final HttpClientAndroid f22607a;

    private c(HttpClientAndroid httpClientAndroid) {
        this.f22607a = httpClientAndroid;
    }

    public static Runnable a(HttpClientAndroid httpClientAndroid) {
        return new c(httpClientAndroid);
    }

    @Override // java.lang.Runnable
    public final void run() {
        HttpClientAndroid.lambda$destroy$2(this.f22607a);
    }
}
