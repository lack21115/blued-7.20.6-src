package com.tencent.beacon.base.net.call;

import android.text.TextUtils;
import com.tencent.beacon.base.net.BodyType;
import com.tencent.beacon.base.net.HttpMethod;
import java.util.HashMap;
import java.util.Map;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/beacon/base/net/call/e.class */
public class e {

    /* renamed from: a  reason: collision with root package name */
    private final String f21293a;
    private final HttpMethod b;

    /* renamed from: c  reason: collision with root package name */
    private final Map<String, String> f21294c;
    private final Map<String, String> d;
    private final String e;
    private BodyType f;
    private String g;
    private byte[] h;

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/beacon/base/net/call/e$a.class */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private HttpMethod f21295a;
        private String b;

        /* renamed from: c  reason: collision with root package name */
        private String f21296c;
        private Map<String, String> d = new HashMap(3);
        private Map<String, String> e = new HashMap(3);
        private String f;
        private BodyType g;
        private byte[] h;

        private void a(BodyType bodyType) {
            if (this.g == null) {
                this.g = bodyType;
            }
            if (this.g != bodyType) {
                throw new IllegalStateException("bodyType already set!");
            }
        }

        public a a(HttpMethod httpMethod) {
            this.f21295a = httpMethod;
            return this;
        }

        public a a(String str) {
            this.f21296c = str;
            return this;
        }

        public a a(Map<String, String> map) {
            a(BodyType.FORM);
            this.d.putAll(map);
            return this;
        }

        public e a() {
            if (this.f21295a != null) {
                if (TextUtils.isEmpty(this.b)) {
                    throw new NullPointerException("request url == null!");
                }
                BodyType bodyType = this.g;
                if (bodyType != null) {
                    int i = d.f21292a[bodyType.ordinal()];
                    if (i != 1) {
                        if (i != 2) {
                            if (i == 3 && this.h == null) {
                                throw new NullPointerException("data request body == null");
                            }
                        } else if (this.d.isEmpty()) {
                            throw new NullPointerException("form request body == null");
                        }
                    } else if (TextUtils.isEmpty(this.f)) {
                        throw new NullPointerException("json request body == null");
                    }
                    return new e(this.f21295a, this.b, this.e, this.g, this.f, this.d, this.h, this.f21296c, null);
                }
                throw new NullPointerException("bodyType == null");
            }
            throw new NullPointerException("request method == null");
        }

        public a b(String str) {
            this.b = str;
            return this;
        }
    }

    private e(HttpMethod httpMethod, String str, Map<String, String> map, BodyType bodyType, String str2, Map<String, String> map2, byte[] bArr, String str3) {
        this.b = httpMethod;
        this.f21293a = str;
        this.f21294c = map;
        this.f = bodyType;
        this.g = str2;
        this.d = map2;
        this.h = bArr;
        this.e = str3;
    }

    /* synthetic */ e(HttpMethod httpMethod, String str, Map map, BodyType bodyType, String str2, Map map2, byte[] bArr, String str3, d dVar) {
        this(httpMethod, str, map, bodyType, str2, map2, bArr, str3);
    }

    public static a b() {
        return new a();
    }

    public BodyType a() {
        return this.f;
    }

    public byte[] c() {
        return this.h;
    }

    public Map<String, String> d() {
        return this.d;
    }

    public Map<String, String> e() {
        return this.f21294c;
    }

    public String f() {
        return this.g;
    }

    public HttpMethod g() {
        return this.b;
    }

    public String h() {
        return this.e;
    }

    public String i() {
        return this.f21293a;
    }

    public String toString() {
        return "HttpRequestEntity{url='" + this.f21293a + "', method=" + this.b + ", headers=" + this.f21294c + ", formParams=" + this.d + ", bodyType=" + this.f + ", json='" + this.g + "', tag='" + this.e + "'}";
    }
}
