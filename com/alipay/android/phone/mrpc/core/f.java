package com.alipay.android.phone.mrpc.core;

import org.apache.http.HttpResponse;
import org.apache.http.conn.ConnectionKeepAliveStrategy;
import org.apache.http.protocol.HttpContext;

/* loaded from: source-6737240-dex2jar.jar:com/alipay/android/phone/mrpc/core/f.class */
final class f implements ConnectionKeepAliveStrategy {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ d f4523a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(d dVar) {
        this.f4523a = dVar;
    }

    public final long getKeepAliveDuration(HttpResponse httpResponse, HttpContext httpContext) {
        return 180000L;
    }
}
