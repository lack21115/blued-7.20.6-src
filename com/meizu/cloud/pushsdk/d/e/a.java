package com.meizu.cloud.pushsdk.d.e;

import android.content.Context;
import com.meizu.cloud.pushsdk.PushManager;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: source-8303388-dex2jar.jar:com/meizu/cloud/pushsdk/d/e/a.class */
public abstract class a {
    private static final String n = a.class.getSimpleName();
    protected com.meizu.cloud.pushsdk.d.b.a b;

    /* renamed from: c  reason: collision with root package name */
    protected c f24115c;
    protected b d;
    protected final String e;
    protected final String f;
    protected final boolean g;
    protected final com.meizu.cloud.pushsdk.d.f.b h;
    protected final boolean i;
    protected final long j;
    protected final int k;
    protected final TimeUnit l;

    /* renamed from: a  reason: collision with root package name */
    protected final String f24114a = PushManager.TAG;
    protected final AtomicBoolean m = new AtomicBoolean(true);

    /* renamed from: com.meizu.cloud.pushsdk.d.e.a$a  reason: collision with other inner class name */
    /* loaded from: source-8303388-dex2jar.jar:com/meizu/cloud/pushsdk/d/e/a$a.class */
    public static class C0611a {

        /* renamed from: a  reason: collision with root package name */
        protected final com.meizu.cloud.pushsdk.d.b.a f24116a;
        protected final String b;

        /* renamed from: c  reason: collision with root package name */
        protected final String f24117c;
        protected final Context d;
        protected c e = null;
        protected boolean f = false;
        protected com.meizu.cloud.pushsdk.d.f.b g = com.meizu.cloud.pushsdk.d.f.b.OFF;
        protected boolean h = false;
        protected long i = 600;
        protected long j = 300;
        protected long k = 15;
        protected int l = 10;
        protected TimeUnit m = TimeUnit.SECONDS;

        public C0611a(com.meizu.cloud.pushsdk.d.b.a aVar, String str, String str2, Context context, Class<? extends a> cls) {
            this.f24116a = aVar;
            this.b = str;
            this.f24117c = str2;
            this.d = context;
        }

        public C0611a a(int i) {
            this.l = i;
            return this;
        }

        public C0611a a(c cVar) {
            this.e = cVar;
            return this;
        }

        public C0611a a(com.meizu.cloud.pushsdk.d.f.b bVar) {
            this.g = bVar;
            return this;
        }

        public C0611a a(Boolean bool) {
            this.f = bool.booleanValue();
            return this;
        }
    }

    public a(C0611a c0611a) {
        this.b = c0611a.f24116a;
        this.f = c0611a.f24117c;
        this.g = c0611a.f;
        this.e = c0611a.b;
        this.f24115c = c0611a.e;
        this.h = c0611a.g;
        this.i = c0611a.h;
        this.j = c0611a.k;
        this.k = c0611a.l >= 2 ? c0611a.l : 2;
        this.l = c0611a.m;
        if (this.i) {
            this.d = new b(c0611a.i, c0611a.j, c0611a.m, c0611a.d);
        }
        com.meizu.cloud.pushsdk.d.f.c.a(c0611a.g);
        com.meizu.cloud.pushsdk.d.f.c.c(n, "Tracker created successfully.", new Object[0]);
    }

    private com.meizu.cloud.pushsdk.d.a.b a(List<com.meizu.cloud.pushsdk.d.a.b> list) {
        if (this.i) {
            list.add(this.d.a());
        }
        c cVar = this.f24115c;
        if (cVar != null) {
            if (!cVar.a().isEmpty()) {
                list.add(new com.meizu.cloud.pushsdk.d.a.b("geolocation", this.f24115c.a()));
            }
            if (!this.f24115c.b().isEmpty()) {
                list.add(new com.meizu.cloud.pushsdk.d.a.b("mobileinfo", this.f24115c.b()));
            }
        }
        LinkedList linkedList = new LinkedList();
        for (com.meizu.cloud.pushsdk.d.a.b bVar : list) {
            linkedList.add(bVar.a());
        }
        return new com.meizu.cloud.pushsdk.d.a.b("push_extra_info", linkedList);
    }

    private void a(com.meizu.cloud.pushsdk.d.a.c cVar, List<com.meizu.cloud.pushsdk.d.a.b> list, boolean z) {
        if (this.f24115c != null) {
            cVar.a(new HashMap(this.f24115c.c()));
            cVar.a("et", a(list).a());
        }
        com.meizu.cloud.pushsdk.d.f.c.c(n, "Adding new payload to event storage: %s", cVar);
        this.b.a(cVar, z);
    }

    public void a() {
        if (this.m.get()) {
            b().a();
        }
    }

    public void a(com.meizu.cloud.pushsdk.d.c.b bVar, boolean z) {
        if (this.m.get()) {
            a(bVar.e(), bVar.a(), z);
        }
    }

    public void a(c cVar) {
        this.f24115c = cVar;
    }

    public com.meizu.cloud.pushsdk.d.b.a b() {
        return this.b;
    }
}
