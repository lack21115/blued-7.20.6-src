package com.tencent.tmsbeacon.base.net.call;

import android.text.TextUtils;
import com.tencent.tmsbeacon.base.net.BodyType;
import com.tencent.tmsbeacon.base.net.HttpMethod;
import java.util.HashMap;
import java.util.Map;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tmsbeacon/base/net/call/e.class */
public class e {

    /* renamed from: a  reason: collision with root package name */
    private final String f25823a;
    private final HttpMethod b;

    /* renamed from: c  reason: collision with root package name */
    private final Map<String, String> f25824c;
    private final Map<String, String> d;
    private final String e;
    private BodyType f;
    private String g;
    private byte[] h;

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/tmsbeacon/base/net/call/e$a.class */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private HttpMethod f25825a;
        private String b;

        /* renamed from: c  reason: collision with root package name */
        private String f25826c;
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
            this.f25825a = httpMethod;
            return this;
        }

        public a a(String str) {
            this.f25826c = str;
            return this;
        }

        public a a(Map<String, String> map) {
            a(BodyType.FORM);
            this.d.putAll(map);
            return this;
        }

        public e a() {
            if (this.f25825a != null) {
                if (TextUtils.isEmpty(this.b)) {
                    throw new NullPointerException("request url == null!");
                }
                BodyType bodyType = this.g;
                if (bodyType != null) {
                    int i = b.f25827a[bodyType.ordinal()];
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
                    return new e(this.f25825a, this.b, this.e, this.g, this.f, this.d, this.h, this.f25826c, null);
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

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/tmsbeacon/base/net/call/e$b.class */
    public static /* synthetic */ class b {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f25827a;

        static {
            BodyType.values();
            int[] iArr = new int[3];
            f25827a = iArr;
            try {
                BodyType bodyType = BodyType.JSON;
                iArr[0] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                int[] iArr2 = f25827a;
                BodyType bodyType2 = BodyType.FORM;
                iArr2[1] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                int[] iArr3 = f25827a;
                BodyType bodyType3 = BodyType.DATA;
                iArr3[2] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    private e(HttpMethod httpMethod, String str, Map<String, String> map, BodyType bodyType, String str2, Map<String, String> map2, byte[] bArr, String str3) {
        this.b = httpMethod;
        this.f25823a = str;
        this.f25824c = map;
        this.f = bodyType;
        this.g = str2;
        this.d = map2;
        this.h = bArr;
        this.e = str3;
    }

    public /* synthetic */ e(HttpMethod httpMethod, String str, Map map, BodyType bodyType, String str2, Map map2, byte[] bArr, String str3, b bVar) {
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
        return this.f25824c;
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
        return this.f25823a;
    }

    public String toString() {
        return "HttpRequestEntity{url='" + this.f25823a + "', method=" + this.b + ", headers=" + this.f25824c + ", formParams=" + this.d + ", bodyType=" + this.f + ", json='" + this.g + "', tag='" + this.e + "'}";
    }
}
