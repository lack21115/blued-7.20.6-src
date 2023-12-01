package com.efs.sdk.net.a.a;

import android.text.TextUtils;
import com.efs.sdk.base.core.util.Log;
import com.efs.sdk.net.a.a.f;
import java.io.InputStream;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: source-8110460-dex2jar.jar:com/efs/sdk/net/a/a/g.class */
public final class g implements f {

    /* renamed from: a  reason: collision with root package name */
    private static AtomicInteger f21838a = new AtomicInteger(0);

    /* renamed from: c  reason: collision with root package name */
    private static g f21839c;
    private b b = new b();

    private g() {
    }

    public static g c() {
        if (f21839c == null) {
            f21839c = new g();
        }
        return f21839c;
    }

    @Override // com.efs.sdk.net.a.a.f
    public final InputStream a(String str, String str2, String str3, InputStream inputStream) {
        Log.d("NetTrace-Interceptor", "interpret response stream");
        return b.a(str, str2, str3, inputStream);
    }

    @Override // com.efs.sdk.net.a.a.f
    public final void a() {
        Log.d("NetTrace-Interceptor", "data sent");
    }

    @Override // com.efs.sdk.net.a.a.f
    public final void a(f.a aVar) {
        Log.d("NetTrace-Interceptor", "request will be sent");
        b bVar = this.b;
        try {
            String a2 = aVar.a();
            bVar.f21833a.put(aVar.a(), Long.valueOf(System.currentTimeMillis()));
            Log.i("NetTrace-Interceptor", "save request");
            com.efs.sdk.net.a.b a3 = com.efs.sdk.net.a.a.a().a(a2);
            String b = aVar.b();
            if (!TextUtils.isEmpty(b)) {
                a3.d = b;
            }
            a3.e = aVar.c();
            a3.f = b.a(aVar);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.efs.sdk.net.a.a.f
    public final void a(f.c cVar) {
        Log.d("NetTrace-Interceptor", "response headers received");
        b bVar = this.b;
        Log.i("NetTrace-Interceptor", "save response");
        String a2 = cVar.a();
        if (bVar.f21833a != null) {
            com.efs.sdk.net.a.a.a().a(a2).g = cVar.b();
        }
    }

    @Override // com.efs.sdk.net.a.a.f
    public final String b() {
        Log.d("NetTrace-Interceptor", "next request id");
        return String.valueOf(f21838a.getAndIncrement());
    }
}
