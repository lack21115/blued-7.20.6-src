package com.opos.cmn.func.b.a;

import android.content.Context;
import com.opos.cmn.an.g.f;
import com.opos.cmn.an.g.h;
import com.opos.cmn.func.b.b.a.g;
import com.opos.cmn.func.b.b.e;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/func/b/a/a.class */
public class a implements f {
    private g b;

    /* renamed from: a  reason: collision with root package name */
    private HashMap<Long, Long> f11125a = new HashMap<>();

    /* renamed from: c  reason: collision with root package name */
    private Object f11126c = new Object();
    private Object d = new Object();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.opos.cmn.func.b.a.a$1  reason: invalid class name */
    /* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/func/b/a/a$1.class */
    public class AnonymousClass1 implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ com.opos.cmn.func.b.b.d f11127a;
        final /* synthetic */ Context b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ com.opos.cmn.an.g.f f11128c;
        final /* synthetic */ com.opos.cmn.func.b.b.c d;
        final /* synthetic */ a e;

        @Override // java.lang.Runnable
        public void run() {
            long a2 = h.a();
            this.e.a(this.f11127a.e, a2);
            try {
                try {
                    com.opos.cmn.func.b.b.e a3 = this.e.a(h.a(this.b, a2, this.f11128c), a2);
                    StringBuilder sb = new StringBuilder();
                    sb.append("onResponse,");
                    sb.append(a3 == null ? com.igexin.push.core.b.l : a3.toString());
                    com.opos.cmn.an.f.a.b("AdNetHttpImpl", sb.toString());
                    if (this.d != null) {
                        if (a3 == null) {
                            this.d.a(new Exception("response is null"));
                        }
                        this.d.a(a3);
                    }
                } catch (Exception e) {
                    com.opos.cmn.an.f.a.b("AdNetHttpImpl", "", e);
                }
            } finally {
                this.e.a(this.f11127a.e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.opos.cmn.func.b.a.a$a  reason: collision with other inner class name */
    /* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/func/b/a/a$a.class */
    public static class C0466a<K, V> extends HashMap<K, V> {
        private C0466a() {
        }

        /* synthetic */ C0466a(AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public V get(Object obj) {
            String str;
            String str2 = null;
            if (obj == null) {
                return null;
            }
            String str3 = (String) obj;
            Iterator<Map.Entry<K, V>> it = entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    str = null;
                    break;
                }
                Map.Entry<K, V> next = it.next();
                if (str3.equalsIgnoreCase((String) next.getKey())) {
                    str = (String) next.getValue();
                    break;
                }
            }
            com.opos.cmn.an.f.a.b("AdNetHttpImpl", "HeaderMap name:" + str3 + " value:" + str);
            if (str != null) {
                str2 = str;
            }
            return str2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8303388-dex2jar.jar:com/opos/cmn/func/b/a/a$b.class */
    public static class b implements com.opos.cmn.func.b.b.a {

        /* renamed from: a  reason: collision with root package name */
        private Map<String, String> f11129a;

        public b(Map<String, String> map) {
            this.f11129a = map;
        }

        @Override // com.opos.cmn.func.b.b.a
        public String a(String str) {
            if (str == null) {
                return null;
            }
            Map<String, String> map = this.f11129a;
            String str2 = null;
            if (map != null) {
                str2 = null;
                if (map.size() != 0) {
                    Iterator<Map.Entry<String, String>> it = this.f11129a.entrySet().iterator();
                    while (true) {
                        str2 = null;
                        if (!it.hasNext()) {
                            break;
                        }
                        Map.Entry<String, String> next = it.next();
                        if (str.equalsIgnoreCase(next.getKey())) {
                            str2 = next.getValue();
                            break;
                        }
                    }
                }
            }
            return str2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.opos.cmn.func.b.b.e a(com.opos.cmn.an.g.g gVar, long j) {
        if (gVar == null) {
            return null;
        }
        C0466a c0466a = null;
        if (gVar.e != null) {
            try {
                gVar.e.remove(null);
                c0466a = new C0466a(null);
                try {
                    for (Map.Entry<String, String> entry : gVar.e.entrySet()) {
                        c0466a.put(entry.getKey(), entry.getValue());
                    }
                } catch (Exception e) {
                }
            } catch (Exception e2) {
                c0466a = null;
            }
        }
        return new e.a().a(gVar.f10866a).a(gVar.b).a(gVar.d).a(c0466a).a(new b(gVar.e)).a(gVar.f10867c).b(j).a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Long a(long j) {
        try {
            synchronized (this.f11126c) {
                Long l = this.f11125a.get(Long.valueOf(j));
                if (l != null) {
                    this.f11125a.remove(Long.valueOf(j));
                    return l;
                }
                return null;
            }
        } catch (Exception e) {
            com.opos.cmn.an.f.a.b("AdNetHttpImpl", "removeRequestFromMap fail", e);
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j, long j2) {
        com.opos.cmn.an.f.a.b("AdNetHttpImpl", "putCall requestId=" + j + " taskCode=" + j2);
        synchronized (this.f11126c) {
            this.f11125a.put(Long.valueOf(j), Long.valueOf(j2));
            com.opos.cmn.an.f.a.b("AdNetHttpImpl", "putCall mCallsMap.size()=" + this.f11125a.size());
        }
    }

    private void a(Context context, g gVar) {
        if (this.b == null) {
            synchronized (this.d) {
                if (this.b == null) {
                    if (gVar == null) {
                        this.b = com.opos.cmn.func.b.a.a.b.a(context);
                    } else {
                        this.b = gVar;
                    }
                }
            }
        }
    }

    private com.opos.cmn.an.g.f b(Context context, com.opos.cmn.func.b.b.d dVar) {
        if (dVar == null) {
            return null;
        }
        com.opos.cmn.func.b.b.d a2 = com.opos.cmn.func.b.a.a.b.a(context, dVar);
        f.a aVar = new f.a();
        aVar.b(a2.b);
        if (a2.f11171c != null) {
            aVar.a(a2.f11171c);
        }
        if (a2.f11170a == "GET") {
            aVar.a("GET");
        }
        if (a2.f11170a == "POST") {
            aVar.a("POST");
        }
        if (a2.d != null) {
            aVar.a(a2.d);
        }
        aVar.b(this.b.f11165a);
        aVar.c(this.b.b);
        aVar.a(this.b.d);
        aVar.a(this.b.f11166c);
        return aVar.a();
    }

    @Override // com.opos.cmn.func.b.a.e
    public com.opos.cmn.func.b.b.e a(Context context, com.opos.cmn.func.b.b.d dVar) {
        com.opos.cmn.an.f.a.b("AdNetHttpImpl", "execSync");
        if (dVar == null || context == null) {
            return null;
        }
        try {
            try {
                Context applicationContext = context.getApplicationContext();
                a(applicationContext, (g) null);
                com.opos.cmn.an.g.f b2 = b(applicationContext, dVar);
                if (b2 != null) {
                    com.opos.cmn.an.f.a.b("AdNetHttpImpl", b2.toString());
                    long a2 = h.a();
                    a(dVar.e, a2);
                    com.opos.cmn.func.b.b.e a3 = a(h.a(applicationContext, a2, b2), a2);
                    StringBuilder sb = new StringBuilder();
                    sb.append("onResponse,");
                    sb.append(a3 == null ? com.igexin.push.core.b.l : a3.toString());
                    com.opos.cmn.an.f.a.b("AdNetHttpImpl", sb.toString());
                    return a3;
                }
            } catch (Exception e) {
                com.opos.cmn.an.f.a.b("AdNetHttpImpl", "execSync fail", e);
            }
            a(dVar.e);
            return null;
        } finally {
            a(dVar.e);
        }
    }

    @Override // com.opos.cmn.func.b.a.d
    public void a(Context context) {
        a(context, (g) null);
    }
}
