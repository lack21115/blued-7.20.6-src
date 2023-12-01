package com.opos.mobad.e.a.a.b;

import android.content.Context;
import android.provider.Downloads;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.opos.acs.st.STManager;
import com.opos.mobad.e.a.j;
import com.opos.mobad.e.a.l;
import com.opos.mobad.e.a.m;
import java.util.HashMap;
import java.util.Map;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/e/a/a/b/a.class */
public final class a implements j {
    private static volatile a b;

    /* renamed from: a  reason: collision with root package name */
    public m f25993a;

    /* renamed from: c  reason: collision with root package name */
    private j f25994c;

    /* renamed from: com.opos.mobad.e.a.a.b.a$a  reason: collision with other inner class name */
    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/e/a/a/b/a$a.class */
    public static class C0691a<T extends C0691a<T>> {

        /* renamed from: a  reason: collision with root package name */
        protected Map<String, String> f25995a = new HashMap();

        public final T a(C0691a c0691a) {
            Map<String, String> map;
            if (c0691a != null && (map = c0691a.f25995a) != null) {
                this.f25995a.putAll(map);
            }
            return this;
        }

        public final T a(String str) {
            this.f25995a.put("matId", str);
            return this;
        }

        public final T a(Map<String, String> map) {
            if (map != null) {
                this.f25995a.putAll(map);
            }
            return this;
        }

        public final void a(Context context) {
            Map<String, String> map = this.f25995a;
            StringBuilder sb = new StringBuilder();
            sb.append(System.currentTimeMillis());
            map.put("eventTime", sb.toString());
            this.f25995a.put("appPkg", context != null ? context.getPackageName() : "");
            a.a().a(context, this.f25995a);
        }

        public final T b(String str) {
            this.f25995a.put("adId", str);
            return this;
        }

        public final T c(String str) {
            this.f25995a.put("loadId", str);
            return this;
        }
    }

    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/e/a/a/b/a$b.class */
    public static final class b extends C0691a<b> {
        public b() {
            this.f25995a.put(STManager.KEY_DATA_TYPE, "dy-mat-click");
        }

        public final b a(int i) {
            this.f25995a.put("sceneType", String.valueOf(i));
            return this;
        }

        public final b a(l lVar) {
            if (lVar != null) {
                Map<String, String> map = this.f25995a;
                StringBuilder sb = new StringBuilder();
                sb.append(lVar.f25999c);
                map.put(STManager.KEY_DOWN_X, sb.toString());
                Map<String, String> map2 = this.f25995a;
                StringBuilder sb2 = new StringBuilder();
                sb2.append(lVar.d);
                map2.put(STManager.KEY_DOWN_Y, sb2.toString());
                Map<String, String> map3 = this.f25995a;
                StringBuilder sb3 = new StringBuilder();
                sb3.append(lVar.f);
                map3.put(STManager.KEY_UP_X, sb3.toString());
                Map<String, String> map4 = this.f25995a;
                StringBuilder sb4 = new StringBuilder();
                sb4.append(lVar.g);
                map4.put(STManager.KEY_UP_Y, sb4.toString());
            }
            return this;
        }

        public final b d(String str) {
            this.f25995a.put(PushConstants.CLICK_TYPE, str);
            return this;
        }

        public final b e(String str) {
            this.f25995a.put("adAreaType", str);
            return this;
        }

        public final b f(String str) {
            this.f25995a.put("sceneId", str);
            return this;
        }
    }

    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/e/a/a/b/a$c.class */
    public static final class c extends C0691a<c> {
        public c() {
            this.f25995a.put(STManager.KEY_DATA_TYPE, "dy-mat-error");
        }

        public final c d(String str) {
            this.f25995a.put("errorType", str);
            return this;
        }

        public final c e(String str) {
            this.f25995a.put(Downloads.Impl.COLUMN_ERROR_MSG, str);
            return this;
        }
    }

    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/e/a/a/b/a$d.class */
    public static final class d extends C0691a<d> {
        public d() {
            this.f25995a.put(STManager.KEY_DATA_TYPE, "dy-mat-expose");
        }

        public final d a(int i) {
            this.f25995a.put("sceneType", String.valueOf(i));
            return this;
        }

        public final d a(long j) {
            this.f25995a.put("loadTime", String.valueOf(j));
            return this;
        }

        public final d d(String str) {
            this.f25995a.put("lastScene", str);
            return this;
        }

        public final d e(String str) {
            this.f25995a.put("curScene", str);
            return this;
        }
    }

    private a() {
    }

    public static C0691a a(String str, String str2, String str3, Map map) {
        return new C0691a().c(str).b(str2).a(str3).a(map);
    }

    public static a a() {
        if (b == null) {
            synchronized (j.class) {
                try {
                    if (b == null) {
                        b = new a();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return b;
    }

    public static d b() {
        return new d();
    }

    public static b c() {
        return new b();
    }

    public static c d() {
        return new c();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v14, types: [com.opos.mobad.e.a.j] */
    private j e() {
        j jVar;
        synchronized (this) {
            if (this.f25994c == null) {
                this.f25994c = (this.f25993a == null || this.f25993a.f26000a == null) ? new com.opos.mobad.e.a.a.b.b() : this.f25993a.f26000a;
            }
            jVar = this.f25994c;
        }
        return jVar;
    }

    @Override // com.opos.mobad.e.a.j
    public final void a(Context context, String str, String str2, String str3) {
        try {
            e().a(context, str, str2, str3);
        } catch (Throwable th) {
            com.opos.cmn.an.f.a.d("MatReporter", "MatReporter init error!", th);
        }
    }

    @Override // com.opos.mobad.e.a.j
    public final void a(Context context, Map<String, String> map) {
        try {
            e().a(context, map);
        } catch (Throwable th) {
            com.opos.cmn.an.f.a.d("MatReporter", "MatReporter report error!", th);
        }
    }
}
