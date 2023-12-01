package com.sdk.tencent.f;

import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/sdk/tencent/f/a.class */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public long f14356a = System.currentTimeMillis();
    public C0588a b = new C0588a();

    /* renamed from: c  reason: collision with root package name */
    public String f14357c = "";

    /* renamed from: com.sdk.tencent.f.a$a  reason: collision with other inner class name */
    /* loaded from: source-8303388-dex2jar.jar:com/sdk/tencent/f/a$a.class */
    public static class C0588a {

        /* renamed from: a  reason: collision with root package name */
        public List<C0589a> f14358a = new ArrayList();
        public List<String> b = new ArrayList();

        /* renamed from: c  reason: collision with root package name */
        public List<String> f14359c = new ArrayList();
        public String d = "";

        /* renamed from: com.sdk.tencent.f.a$a$a  reason: collision with other inner class name */
        /* loaded from: source-8303388-dex2jar.jar:com/sdk/tencent/f/a$a$a.class */
        public static class C0589a {

            /* renamed from: a  reason: collision with root package name */
            public String f14360a = "";
            public long b;

            public String toString() {
                return "_$101005Bean{url='" + this.f14360a + "', time=" + this.b + '}';
            }
        }

        public String toString() {
            return "StatusBean{_$101005=" + this.f14358a + ", _$302001=" + this.b + ", _$302002=" + this.f14359c + ", _$302003='" + this.d + "'}";
        }
    }

    public String toString() {
        return "MobileLog{time=" + this.f14356a + ", status=" + this.b + '}';
    }
}
