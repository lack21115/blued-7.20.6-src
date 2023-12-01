package com.sdk.tencent.f;

import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/sdk/tencent/f/a.class */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public long f28044a = System.currentTimeMillis();
    public C0758a b = new C0758a();

    /* renamed from: c  reason: collision with root package name */
    public String f28045c = "";

    /* renamed from: com.sdk.tencent.f.a$a  reason: collision with other inner class name */
    /* loaded from: source-8303388-dex2jar.jar:com/sdk/tencent/f/a$a.class */
    public static class C0758a {

        /* renamed from: a  reason: collision with root package name */
        public List<C0759a> f28046a = new ArrayList();
        public List<String> b = new ArrayList();

        /* renamed from: c  reason: collision with root package name */
        public List<String> f28047c = new ArrayList();
        public String d = "";

        /* renamed from: com.sdk.tencent.f.a$a$a  reason: collision with other inner class name */
        /* loaded from: source-8303388-dex2jar.jar:com/sdk/tencent/f/a$a$a.class */
        public static class C0759a {

            /* renamed from: a  reason: collision with root package name */
            public String f28048a = "";
            public long b;

            public String toString() {
                return "_$101005Bean{url='" + this.f28048a + "', time=" + this.b + '}';
            }
        }

        public String toString() {
            return "StatusBean{_$101005=" + this.f28046a + ", _$302001=" + this.b + ", _$302002=" + this.f28047c + ", _$302003='" + this.d + "'}";
        }
    }

    public String toString() {
        return "MobileLog{time=" + this.f28044a + ", status=" + this.b + '}';
    }
}
