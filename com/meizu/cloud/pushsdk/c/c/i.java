package com.meizu.cloud.pushsdk.c.c;

import com.meizu.cloud.pushsdk.c.c.c;
import com.sobot.network.http.SobotOkHttpUtils;

/* loaded from: source-7994992-dex2jar.jar:com/meizu/cloud/pushsdk/c/c/i.class */
public class i {

    /* renamed from: a  reason: collision with root package name */
    private final f f10427a;
    private final String b;

    /* renamed from: c  reason: collision with root package name */
    private final c f10428c;
    private final j d;
    private final Object e;

    /* loaded from: source-7994992-dex2jar.jar:com/meizu/cloud/pushsdk/c/c/i$a.class */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private f f10429a;
        private String b = "GET";

        /* renamed from: c  reason: collision with root package name */
        private c.a f10430c = new c.a();
        private j d;
        private Object e;

        public a a() {
            return a("GET", (j) null);
        }

        public a a(c cVar) {
            this.f10430c = cVar.c();
            return this;
        }

        public a a(f fVar) {
            if (fVar != null) {
                this.f10429a = fVar;
                return this;
            }
            throw new IllegalArgumentException("url == null");
        }

        public a a(j jVar) {
            return a("POST", jVar);
        }

        /* JADX WARN: Removed duplicated region for block: B:13:0x0060  */
        /* JADX WARN: Removed duplicated region for block: B:15:0x0066  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public com.meizu.cloud.pushsdk.c.c.i.a a(java.lang.String r8) {
            /*
                r7 = this;
                r0 = r8
                if (r0 == 0) goto L87
                r0 = r8
                r1 = 1
                r2 = 0
                java.lang.String r3 = "ws:"
                r4 = 0
                r5 = 3
                boolean r0 = r0.regionMatches(r1, r2, r3, r4, r5)
                if (r0 == 0) goto L34
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r1 = r0
                r1.<init>()
                r10 = r0
                r0 = r10
                java.lang.String r1 = "http:"
                java.lang.StringBuilder r0 = r0.append(r1)
                r0 = 3
                r9 = r0
            L22:
                r0 = r10
                r1 = r8
                r2 = r9
                java.lang.String r1 = r1.substring(r2)
                java.lang.StringBuilder r0 = r0.append(r1)
                r0 = r10
                java.lang.String r0 = r0.toString()
                r10 = r0
                goto L57
            L34:
                r0 = r8
                r10 = r0
                r0 = r8
                r1 = 1
                r2 = 0
                java.lang.String r3 = "wss:"
                r4 = 0
                r5 = 4
                boolean r0 = r0.regionMatches(r1, r2, r3, r4, r5)
                if (r0 == 0) goto L57
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r1 = r0
                r1.<init>()
                r10 = r0
                r0 = r10
                java.lang.String r1 = "https:"
                java.lang.StringBuilder r0 = r0.append(r1)
                r0 = 4
                r9 = r0
                goto L22
            L57:
                r0 = r10
                com.meizu.cloud.pushsdk.c.c.f r0 = com.meizu.cloud.pushsdk.c.c.f.c(r0)
                r8 = r0
                r0 = r8
                if (r0 == 0) goto L66
                r0 = r7
                r1 = r8
                com.meizu.cloud.pushsdk.c.c.i$a r0 = r0.a(r1)
                return r0
            L66:
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r1 = r0
                r1.<init>()
                r8 = r0
                r0 = r8
                java.lang.String r1 = "unexpected url: "
                java.lang.StringBuilder r0 = r0.append(r1)
                r0 = r8
                r1 = r10
                java.lang.StringBuilder r0 = r0.append(r1)
                java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
                r1 = r0
                r2 = r8
                java.lang.String r2 = r2.toString()
                r1.<init>(r2)
                throw r0
            L87:
                java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
                r1 = r0
                java.lang.String r2 = "url == null"
                r1.<init>(r2)
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.meizu.cloud.pushsdk.c.c.i.a.a(java.lang.String):com.meizu.cloud.pushsdk.c.c.i$a");
        }

        public a a(String str, j jVar) {
            if (str == null || str.length() == 0) {
                throw new IllegalArgumentException("method == null || method.length() == 0");
            }
            if (jVar != null && !d.b(str)) {
                throw new IllegalArgumentException("method " + str + " must not have a request body.");
            } else if (jVar != null || !d.a(str)) {
                this.b = str;
                this.d = jVar;
                return this;
            } else {
                throw new IllegalArgumentException("method " + str + " must have a request body.");
            }
        }

        public a a(String str, String str2) {
            this.f10430c.a(str, str2);
            return this;
        }

        public a b() {
            return a("HEAD", (j) null);
        }

        public a b(j jVar) {
            return a("DELETE", jVar);
        }

        public a c(j jVar) {
            return a("PUT", jVar);
        }

        public i c() {
            if (this.f10429a != null) {
                return new i(this);
            }
            throw new IllegalStateException("url == null");
        }

        public a d(j jVar) {
            return a(SobotOkHttpUtils.METHOD.PATCH, jVar);
        }
    }

    private i(a aVar) {
        this.f10427a = aVar.f10429a;
        this.b = aVar.b;
        this.f10428c = aVar.f10430c.a();
        this.d = aVar.d;
        this.e = aVar.e != null ? aVar.e : this;
    }

    public f a() {
        return this.f10427a;
    }

    public String a(String str) {
        return this.f10428c.a(str);
    }

    public String b() {
        return this.b;
    }

    public int c() {
        if ("POST".equals(b())) {
            return 1;
        }
        if ("PUT".equals(b())) {
            return 2;
        }
        if ("DELETE".equals(b())) {
            return 3;
        }
        if ("HEAD".equals(b())) {
            return 4;
        }
        return SobotOkHttpUtils.METHOD.PATCH.equals(b()) ? 5 : 0;
    }

    public c d() {
        return this.f10428c;
    }

    public j e() {
        return this.d;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Request{method=");
        sb.append(this.b);
        sb.append(", url=");
        sb.append(this.f10427a);
        sb.append(", tag=");
        Object obj = this.e;
        if (obj == this) {
            obj = null;
        }
        sb.append(obj);
        sb.append('}');
        return sb.toString();
    }
}
