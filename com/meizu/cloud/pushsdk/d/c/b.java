package com.meizu.cloud.pushsdk.d.c;

import com.meizu.cloud.pushsdk.d.a.c;
import com.meizu.cloud.pushsdk.d.c.a;
import com.meizu.cloud.pushsdk.notification.model.AppIconSetting;

/* loaded from: source-8303388-dex2jar.jar:com/meizu/cloud/pushsdk/d/c/b.class */
public class b extends com.meizu.cloud.pushsdk.d.c.a {

    /* renamed from: a  reason: collision with root package name */
    private final String f10490a;
    private final String b;

    /* renamed from: c  reason: collision with root package name */
    private final String f10491c;
    private final String d;
    private final String e;
    private final String f;
    private final String g;
    private final String h;
    private final int i;

    /* loaded from: source-8303388-dex2jar.jar:com/meizu/cloud/pushsdk/d/c/b$a.class */
    public static abstract class a<T extends a<T>> extends a.AbstractC0439a<T> {

        /* renamed from: a  reason: collision with root package name */
        private String f10492a;
        private String b;

        /* renamed from: c  reason: collision with root package name */
        private String f10493c;
        private String d;
        private String e;
        private String f;
        private String g;
        private String h;
        private int i = 0;

        public T a(int i) {
            this.i = i;
            return (T) a();
        }

        public T a(String str) {
            this.f10492a = str;
            return (T) a();
        }

        public T b(String str) {
            this.b = str;
            return (T) a();
        }

        public b b() {
            return new b(this);
        }

        public T c(String str) {
            this.f10493c = str;
            return (T) a();
        }

        public T d(String str) {
            this.d = str;
            return (T) a();
        }

        public T e(String str) {
            this.e = str;
            return (T) a();
        }

        public T f(String str) {
            this.f = str;
            return (T) a();
        }

        public T g(String str) {
            this.g = str;
            return (T) a();
        }

        public T h(String str) {
            this.h = str;
            return (T) a();
        }
    }

    /* renamed from: com.meizu.cloud.pushsdk.d.c.b$b  reason: collision with other inner class name */
    /* loaded from: source-8303388-dex2jar.jar:com/meizu/cloud/pushsdk/d/c/b$b.class */
    static class C0440b extends a<C0440b> {
        private C0440b() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.meizu.cloud.pushsdk.d.c.a.AbstractC0439a
        /* renamed from: c */
        public C0440b a() {
            return this;
        }
    }

    protected b(a<?> aVar) {
        super(aVar);
        this.b = ((a) aVar).b;
        this.f10491c = ((a) aVar).f10493c;
        this.f10490a = ((a) aVar).f10492a;
        this.d = ((a) aVar).d;
        this.e = ((a) aVar).e;
        this.f = ((a) aVar).f;
        this.g = ((a) aVar).g;
        this.h = ((a) aVar).h;
        this.i = ((a) aVar).i;
    }

    public static a<?> d() {
        return new C0440b();
    }

    public c e() {
        c cVar = new c();
        cVar.a("en", this.f10490a);
        cVar.a("ti", this.b);
        cVar.a(AppIconSetting.DEFAULT_LARGE_ICON, this.f10491c);
        cVar.a("pv", this.d);
        cVar.a("pn", this.e);
        cVar.a("si", this.f);
        cVar.a("ms", this.g);
        cVar.a("ect", this.h);
        cVar.a("br", Integer.valueOf(this.i));
        return a(cVar);
    }
}
