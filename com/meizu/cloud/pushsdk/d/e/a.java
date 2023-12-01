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
    protected c f10500c;
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
    protected final String f10499a = PushManager.TAG;
    protected final AtomicBoolean m = new AtomicBoolean(true);

    /* renamed from: com.meizu.cloud.pushsdk.d.e.a$a  reason: collision with other inner class name */
    /* loaded from: source-8303388-dex2jar.jar:com/meizu/cloud/pushsdk/d/e/a$a.class */
    public static class C0441a {

        /* renamed from: a  reason: collision with root package name */
        protected final com.meizu.cloud.pushsdk.d.b.a f10501a;
        protected final String b;

        /* renamed from: c  reason: collision with root package name */
        protected final String f10502c;
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

        public C0441a(com.meizu.cloud.pushsdk.d.b.a aVar, String str, String str2, Context context, Class<? extends a> cls) {
            this.f10501a = aVar;
            this.b = str;
            this.f10502c = str2;
            this.d = context;
        }

        public C0441a a(int i) {
            this.l = i;
            return this;
        }

        public C0441a a(c cVar) {
            this.e = cVar;
            return this;
        }

        public C0441a a(com.meizu.cloud.pushsdk.d.f.b bVar) {
            this.g = bVar;
            return this;
        }

        public C0441a a(Boolean bool) {
            this.f = bool.booleanValue();
            return this;
        }
    }

    public a(C0441a c0441a) {
        this.b = c0441a.f10501a;
        this.f = c0441a.f10502c;
        this.g = c0441a.f;
        this.e = c0441a.b;
        this.f10500c = c0441a.e;
        this.h = c0441a.g;
        this.i = c0441a.h;
        this.j = c0441a.k;
        this.k = c0441a.l >= 2 ? c0441a.l : 2;
        this.l = c0441a.m;
        if (this.i) {
            this.d = new b(c0441a.i, c0441a.j, c0441a.m, c0441a.d);
        }
        com.meizu.cloud.pushsdk.d.f.c.a(c0441a.g);
        com.meizu.cloud.pushsdk.d.f.c.c(n, "Tracker created successfully.", new Object[0]);
    }

    private com.meizu.cloud.pushsdk.d.a.b a(List<com.meizu.cloud.pushsdk.d.a.b> list) {
        if (this.i) {
            list.add(this.d.a());
        }
        c cVar = this.f10500c;
        if (cVar != null) {
            if (!cVar.a().isEmpty()) {
                list.add(new com.meizu.cloud.pushsdk.d.a.b("geolocation", this.f10500c.a()));
            }
            if (!this.f10500c.b().isEmpty()) {
                list.add(new com.meizu.cloud.pushsdk.d.a.b("mobileinfo", this.f10500c.b()));
            }
        }
        LinkedList linkedList = new LinkedList();
        for (com.meizu.cloud.pushsdk.d.a.b bVar : list) {
            linkedList.add(bVar.a());
        }
        return new com.meizu.cloud.pushsdk.d.a.b("push_extra_info", linkedList);
    }

    private void a(com.meizu.cloud.pushsdk.d.a.c cVar, List<com.meizu.cloud.pushsdk.d.a.b> list, boolean z) {
        if (this.f10500c != null) {
            cVar.a(new HashMap(this.f10500c.c()));
            cVar.a("et", a(list).a());
        }
        com.meizu.cloud.pushsdk.d.f.c.c(n, "Adding new payload to event storage: %s", cVar);
        this.b.a((com.meizu.cloud.pushsdk.d.a.a) cVar, z);
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
        this.f10500c = cVar;
    }

    public com.meizu.cloud.pushsdk.d.b.a b() {
        return this.b;
    }
}
