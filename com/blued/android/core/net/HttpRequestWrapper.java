package com.blued.android.core.net;

import com.alibaba.fastjson.support.spring.FastJsonJsonView;
import com.blued.android.core.net.http.RequestParams;
import java.util.HashMap;
import java.util.Map;
import okhttp3.Call;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/core/net/HttpRequestWrapper.class */
public class HttpRequestWrapper {
    private HttpType a;
    private String b;
    private String c;
    private RequestParams d;
    private HttpResponseHandler<?> f;
    private boolean k;
    private Map<String, String> e = new HashMap();
    private IRequestHost g = null;
    private Call h = null;
    private Object i = null;
    private boolean j = false;

    /* loaded from: source-6737240-dex2jar.jar:com/blued/android/core/net/HttpRequestWrapper$HttpType.class */
    public enum HttpType {
        Get,
        Post,
        Put,
        Delete
    }

    public HttpRequestWrapper(HttpType httpType, String str) {
        this.a = HttpType.Get;
        boolean z = false;
        this.k = HttpManager.d() != null ? true : z;
        this.a = httpType;
        this.b = str;
    }

    private RequestParams k() {
        if (this.d == null) {
            this.d = new RequestParams();
        }
        return this.d;
    }

    public HttpRequestWrapper a(HttpResponseHandler<?> httpResponseHandler) {
        this.f = httpResponseHandler;
        if (httpResponseHandler == null) {
            this.f = new StringHttpResponseHandler() { // from class: com.blued.android.core.net.HttpRequestWrapper.1
                @Override // com.blued.android.core.net.HttpResponseHandler, com.blued.android.core.net.http.AbstractHttpResponseHandler
                /* renamed from: a */
                public void onSuccess(String str) {
                }
            };
        }
        HttpResponseHandler<?> httpResponseHandler2 = this.f;
        if (httpResponseHandler2 != null) {
            httpResponseHandler2.setHttpRequestWrapper(this);
        }
        return this;
    }

    public HttpRequestWrapper a(IRequestHost iRequestHost) {
        this.g = iRequestHost;
        return this;
    }

    public HttpRequestWrapper a(String str) {
        k().a(str);
        this.c = FastJsonJsonView.DEFAULT_CONTENT_TYPE;
        return this;
    }

    public HttpRequestWrapper a(String str, String str2) {
        k().b(str, str2);
        return this;
    }

    public HttpRequestWrapper a(Map<String, String> map) {
        if (map != null) {
            if (map.size() <= 0) {
                return this;
            }
            for (Map.Entry<String, String> entry : map.entrySet()) {
                b(entry.getKey(), entry.getValue());
            }
        }
        return this;
    }

    public HttpRequestWrapper a(Call call) {
        this.h = call;
        return this;
    }

    public HttpRequestWrapper a(boolean z) {
        this.k = z;
        return this;
    }

    public String a() {
        return this.b;
    }

    public HttpRequestWrapper b(String str, String str2) {
        k().a(str, str2);
        return this;
    }

    public HttpRequestWrapper b(Map<String, String> map) {
        if (map != null) {
            if (map.size() <= 0) {
                return this;
            }
            this.e.putAll(map);
        }
        return this;
    }

    public RequestParams b() {
        return this.d;
    }

    public HttpResponseHandler<?> c() {
        return this.f;
    }

    public IRequestHost d() {
        return this.g;
    }

    public Map<String, String> e() {
        return this.e;
    }

    public HttpRequestWrapper f() {
        this.j = true;
        return this;
    }

    public boolean g() {
        return this.j;
    }

    public HttpType getType() {
        return this.a;
    }

    public HttpRequestWrapper h() {
        HttpManager.b().a(this);
        return this;
    }

    public void i() {
        synchronized (this) {
            if (this.h != null) {
                this.h.cancel();
                this.h = null;
            }
        }
    }

    public String j() {
        String a = a();
        String str = a;
        if (getType() == HttpType.Get) {
            str = a;
            if (b() != null) {
                str = RequestParams.a(a, b());
            }
        }
        return str;
    }
}
