package com.blued.android.core.net;

import android.content.Context;
import com.blued.android.core.net.HttpRequestWrapper;
import com.blued.android.core.net.http.OkHttpUtils;
import com.blued.android.core.net.http.ssl.HttpsIPAccessUtils;
import com.blued.android.core.utils.Log;
import com.qiniu.android.dns.DnsManager;
import java.util.List;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/core/net/HttpManager.class */
public class HttpManager {
    private static HttpManager b;

    /* renamed from: a  reason: collision with root package name */
    public final Builder f9662a;

    /* loaded from: source-6737240-dex2jar.jar:com/blued/android/core/net/HttpManager$Builder.class */
    public static class Builder {

        /* renamed from: a  reason: collision with root package name */
        private Context f9663a;
        private boolean b = false;

        /* renamed from: c  reason: collision with root package name */
        private DnsManager f9664c = null;
        private boolean d = true;
        private boolean e = false;
        private List<String> f = null;

        public Builder(Context context) {
            this.f9663a = context;
        }

        public Builder a(DnsManager dnsManager) {
            return a(dnsManager, false, false);
        }

        public Builder a(DnsManager dnsManager, boolean z, boolean z2) {
            this.f9664c = dnsManager;
            this.d = z;
            this.e = z2;
            return this;
        }

        public Builder a(boolean z) {
            this.b = z;
            return this;
        }

        public HttpManager a() {
            if (HttpManager.b == null) {
                HttpManager unused = HttpManager.b = new HttpManager(this);
                return HttpManager.b;
            }
            throw new RuntimeException("HttpManager has been inited");
        }
    }

    private HttpManager(Builder builder) {
        this.f9662a = builder;
        HttpsIPAccessUtils.a(builder.f);
        OkHttpUtils.a();
    }

    public static HttpRequestWrapper a(String str) {
        return a(str, null);
    }

    public static HttpRequestWrapper a(String str, HttpResponseHandler<?> httpResponseHandler) {
        return a(str, httpResponseHandler, null);
    }

    public static HttpRequestWrapper a(String str, HttpResponseHandler<?> httpResponseHandler, IRequestHost iRequestHost) {
        if (b.f9662a.b) {
            Log.a("HttpManager", "get(), url: " + str);
        }
        HttpRequestWrapper httpRequestWrapper = new HttpRequestWrapper(HttpRequestWrapper.HttpType.Get, str);
        httpRequestWrapper.a(httpResponseHandler).a(iRequestHost);
        return httpRequestWrapper;
    }

    public static HttpRequestWrapper a(String str, String str2, String str3, HttpResponseHandler<?> httpResponseHandler) {
        if (b.f9662a.b) {
            Log.a("HttpManager", "upload(), url: " + str + ", uploadFilePath: " + str2);
        }
        HttpRequestWrapper httpRequestWrapper = new HttpRequestWrapper(HttpRequestWrapper.HttpType.Post, str);
        httpRequestWrapper.a(httpResponseHandler).a(str2, str3);
        return httpRequestWrapper;
    }

    public static void a(IRequestHost iRequestHost) {
        if (iRequestHost != null) {
            if (b.f9662a.b) {
                Log.a("HttpManager", "cancelRequests(), activeHolder hashCode: ");
            }
            OkHttpUtils.a(iRequestHost);
        }
    }

    public static boolean a() {
        return b != null;
    }

    public static HttpManager b() {
        return b;
    }

    public static HttpRequestWrapper b(String str) {
        return b(str, null);
    }

    public static HttpRequestWrapper b(String str, HttpResponseHandler<?> httpResponseHandler) {
        return b(str, httpResponseHandler, null);
    }

    public static HttpRequestWrapper b(String str, HttpResponseHandler<?> httpResponseHandler, IRequestHost iRequestHost) {
        if (b.f9662a.b) {
            Log.a("HttpManager", "post(), url: " + str);
        }
        HttpRequestWrapper httpRequestWrapper = new HttpRequestWrapper(HttpRequestWrapper.HttpType.Post, str);
        httpRequestWrapper.a(httpResponseHandler).a(iRequestHost);
        return httpRequestWrapper;
    }

    public static boolean c() {
        return b.f9662a.b;
    }

    public static DnsManager d() {
        return b.f9662a.f9664c;
    }

    public static boolean e() {
        return b.f9662a.e;
    }

    public static Context getContext() {
        return b.f9662a.f9663a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(HttpRequestWrapper httpRequestWrapper) {
        if (httpRequestWrapper != null) {
            OkHttpUtils.a(httpRequestWrapper);
        }
    }
}
