package com.meizu.cloud.pushsdk.c.c;

import com.meizu.cloud.pushsdk.c.c.c;

/* loaded from: source-7994992-dex2jar.jar:com/meizu/cloud/pushsdk/c/c/k.class */
public class k {

    /* renamed from: a  reason: collision with root package name */
    private final i f10434a;
    private final int b;

    /* renamed from: c  reason: collision with root package name */
    private final String f10435c;
    private final c d;
    private final l e;
    private final k f;
    private final k g;
    private final k h;

    /* loaded from: source-7994992-dex2jar.jar:com/meizu/cloud/pushsdk/c/c/k$a.class */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private i f10436a;

        /* renamed from: c  reason: collision with root package name */
        private String f10437c;
        private l e;
        private k f;
        private k g;
        private k h;
        private int b = -1;
        private c.a d = new c.a();

        public a a(int i) {
            this.b = i;
            return this;
        }

        public a a(c cVar) {
            this.d = cVar.c();
            return this;
        }

        public a a(i iVar) {
            this.f10436a = iVar;
            return this;
        }

        public a a(l lVar) {
            this.e = lVar;
            return this;
        }

        public a a(String str) {
            this.f10437c = str;
            return this;
        }

        public k a() {
            if (this.f10436a != null) {
                if (this.b >= 0) {
                    return new k(this);
                }
                throw new IllegalStateException("code < 0: " + this.b);
            }
            throw new IllegalStateException("request == null");
        }
    }

    private k(a aVar) {
        this.f10434a = aVar.f10436a;
        this.b = aVar.b;
        this.f10435c = aVar.f10437c;
        this.d = aVar.d.a();
        this.e = aVar.e;
        this.f = aVar.f;
        this.g = aVar.g;
        this.h = aVar.h;
    }

    public int a() {
        return this.b;
    }

    public l b() {
        return this.e;
    }

    public String toString() {
        return "Response{protocol=, code=" + this.b + ", message=" + this.f10435c + ", url=" + this.f10434a.a() + '}';
    }
}
