package com.meizu.cloud.pushsdk.d.b;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import com.meizu.cloud.pushsdk.c.c.i;
import com.meizu.cloud.pushsdk.c.c.j;
import com.meizu.cloud.pushsdk.c.c.k;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;

/* loaded from: source-8110460-dex2jar.jar:com/meizu/cloud/pushsdk/d/b/a.class */
public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    protected final Context f24083a;
    protected final f b;

    /* renamed from: c  reason: collision with root package name */
    protected final int f24084c;
    protected final int d;
    protected final int e;
    protected final TimeUnit f;
    private Uri.Builder j;
    private d k;
    private b l;
    private h m;
    private final SSLSocketFactory n;
    private final HostnameVerifier o;
    private String p;
    private final long q;
    private final long r;
    private final com.meizu.cloud.pushsdk.c.c.a s;
    private final String h = a.class.getSimpleName();
    private final com.meizu.cloud.pushsdk.c.c.g i = com.meizu.cloud.pushsdk.c.c.g.a("application/json; charset=utf-8");
    public final AtomicBoolean g = new AtomicBoolean(false);

    /* renamed from: com.meizu.cloud.pushsdk.d.b.a$a  reason: collision with other inner class name */
    /* loaded from: source-8110460-dex2jar.jar:com/meizu/cloud/pushsdk/d/b/a$a.class */
    public static class C0608a {

        /* renamed from: a  reason: collision with root package name */
        protected final String f24085a;
        protected final Context b;
        protected SSLSocketFactory m;
        protected HostnameVerifier n;

        /* renamed from: c  reason: collision with root package name */
        protected f f24086c = null;
        protected d d = d.POST;
        protected b e = b.Single;
        protected h f = h.HTTPS;
        protected int g = 5;
        protected int h = 250;
        protected int i = 5;
        protected long j = 40000;
        protected long k = 40000;
        protected TimeUnit l = TimeUnit.SECONDS;
        protected com.meizu.cloud.pushsdk.c.c.a o = new com.meizu.cloud.pushsdk.c.c.e();

        public C0608a(String str, Context context, Class<? extends a> cls) {
            this.f24085a = str;
            this.b = context;
        }

        public C0608a a(int i) {
            this.g = i;
            return this;
        }

        public C0608a a(com.meizu.cloud.pushsdk.c.c.a aVar) {
            if (aVar != null) {
                this.o = aVar;
                String simpleName = C0608a.class.getSimpleName();
                com.meizu.cloud.pushsdk.d.f.c.c(simpleName, "set new call " + aVar, new Object[0]);
            }
            return this;
        }

        public C0608a a(b bVar) {
            this.e = bVar;
            return this;
        }

        public C0608a a(f fVar) {
            this.f24086c = fVar;
            return this;
        }

        public C0608a b(int i) {
            this.h = i;
            return this;
        }

        public C0608a c(int i) {
            this.i = i;
            return this;
        }
    }

    public a(C0608a c0608a) {
        this.k = c0608a.d;
        this.b = c0608a.f24086c;
        this.f24083a = c0608a.b;
        this.l = c0608a.e;
        this.m = c0608a.f;
        this.n = c0608a.m;
        this.o = c0608a.n;
        this.f24084c = c0608a.g;
        this.d = c0608a.i;
        this.e = c0608a.h;
        this.q = c0608a.j;
        this.r = c0608a.k;
        this.p = c0608a.f24085a;
        this.f = c0608a.l;
        this.s = c0608a.o;
        c();
        com.meizu.cloud.pushsdk.d.f.c.c(this.h, "Emitter created successfully!", new Object[0]);
    }

    private i a(com.meizu.cloud.pushsdk.d.a.a aVar) {
        a(aVar, "");
        this.j.clearQuery();
        HashMap hashMap = (HashMap) aVar.a();
        for (String str : hashMap.keySet()) {
            this.j.appendQueryParameter(str, (String) hashMap.get(str));
        }
        return new i.a().a(this.j.build().toString()).a().c();
    }

    private i a(ArrayList<com.meizu.cloud.pushsdk.d.a.a> arrayList) {
        ArrayList arrayList2 = new ArrayList();
        Iterator<com.meizu.cloud.pushsdk.d.a.a> it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(it.next().a());
        }
        com.meizu.cloud.pushsdk.d.a.b bVar = new com.meizu.cloud.pushsdk.d.a.b("push_group_data", arrayList2);
        String str = this.h;
        com.meizu.cloud.pushsdk.d.f.c.b(str, "final SelfDescribingJson " + bVar, new Object[0]);
        String uri = this.j.build().toString();
        return new i.a().a(uri).a(j.a(this.i, bVar.toString())).c();
    }

    private void a(k kVar) {
        if (kVar != null) {
            try {
                if (kVar.b() != null) {
                    kVar.b().close();
                }
            } catch (Exception e) {
                com.meizu.cloud.pushsdk.d.f.c.b(this.h, "Unable to close source data", new Object[0]);
            }
        }
    }

    private void a(com.meizu.cloud.pushsdk.d.a.a aVar, String str) {
        String str2 = str;
        if ("".equals(str)) {
            str2 = com.meizu.cloud.pushsdk.d.f.e.a();
        }
        aVar.a("stm", str2);
    }

    private void c() {
        StringBuilder sb;
        String str;
        String str2 = this.h;
        com.meizu.cloud.pushsdk.d.f.c.a(str2, "security " + this.m, new Object[0]);
        if (this.m == h.HTTP) {
            sb = new StringBuilder();
            str = "http://";
        } else {
            sb = new StringBuilder();
            str = "https://";
        }
        sb.append(str);
        sb.append(this.p);
        this.j = Uri.parse(sb.toString()).buildUpon();
        if (this.k == d.GET) {
            this.j.appendPath("i");
        } else {
            this.j.appendEncodedPath("push_data_report/mobile");
        }
    }

    public int a(i iVar) {
        k kVar = null;
        k kVar2 = null;
        try {
            try {
                com.meizu.cloud.pushsdk.d.f.c.b(this.h, "Sending request: %s", iVar);
                k a2 = this.s.a(iVar);
                kVar = a2;
                kVar2 = a2;
                int a3 = a2.a();
                a(a2);
                return a3;
            } catch (IOException e) {
                com.meizu.cloud.pushsdk.d.f.c.a(this.h, "Request sending failed: %s", Log.getStackTraceString(e));
                a(kVar2);
                return -1;
            }
        } catch (Throwable th) {
            a(kVar);
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public LinkedList<e> a(c cVar) {
        int size = cVar.a().size();
        LinkedList<Long> b = cVar.b();
        LinkedList<e> linkedList = new LinkedList<>();
        if (this.k != d.GET) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= size) {
                    break;
                }
                LinkedList linkedList2 = new LinkedList();
                ArrayList<com.meizu.cloud.pushsdk.d.a.a> arrayList = new ArrayList<>();
                long j = 0;
                int i3 = i2;
                while (true) {
                    int i4 = i3;
                    if (i4 >= this.l.a() + i2 || i4 >= size) {
                        break;
                    }
                    com.meizu.cloud.pushsdk.d.a.a aVar = cVar.a().get(i4);
                    long b2 = aVar.b() + 22;
                    if (b2 + 88 > this.r) {
                        ArrayList<com.meizu.cloud.pushsdk.d.a.a> arrayList2 = new ArrayList<>();
                        LinkedList linkedList3 = new LinkedList();
                        arrayList2.add(aVar);
                        linkedList3.add(b.get(i4));
                        linkedList.add(new e(true, a(arrayList2), linkedList3));
                    } else {
                        j += b2;
                        if (j + 88 + (arrayList.size() - 1) > this.r) {
                            linkedList.add(new e(false, a(arrayList), linkedList2));
                            arrayList = new ArrayList<>();
                            linkedList2 = new LinkedList();
                            arrayList.add(aVar);
                            linkedList2.add(b.get(i4));
                            j = b2;
                        } else {
                            arrayList.add(aVar);
                            linkedList2.add(b.get(i4));
                        }
                    }
                    i3 = i4 + 1;
                }
                if (!arrayList.isEmpty()) {
                    linkedList.add(new e(false, a(arrayList), linkedList2));
                }
                i = i2 + this.l.a();
            }
        } else {
            int i5 = 0;
            while (true) {
                int i6 = i5;
                if (i6 >= size) {
                    break;
                }
                LinkedList linkedList4 = new LinkedList();
                linkedList4.add(b.get(i6));
                com.meizu.cloud.pushsdk.d.a.a aVar2 = cVar.a().get(i6);
                linkedList.add(new e(aVar2.b() + 22 > this.q, a(aVar2), linkedList4));
                i5 = i6 + 1;
            }
        }
        return linkedList;
    }

    public abstract void a();

    public abstract void a(com.meizu.cloud.pushsdk.d.a.a aVar, boolean z);

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean a(int i) {
        return i >= 200 && i < 300;
    }

    public String b() {
        return this.j.clearQuery().build().toString();
    }
}
