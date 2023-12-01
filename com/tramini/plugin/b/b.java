package com.tramini.plugin.b;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tramini.plugin.a.d.d;
import com.tramini.plugin.a.g.c;
import com.tramini.plugin.a.g.g;
import com.tramini.plugin.a.g.i;

/* loaded from: source-8829756-dex2jar.jar:com/tramini/plugin/b/b.class */
public class b {
    private static volatile b b;
    private Context d;
    private boolean e = false;

    /* renamed from: a  reason: collision with root package name */
    public static final String f26863a = b.class.getSimpleName();

    /* renamed from: c  reason: collision with root package name */
    private static a f26864c = null;

    private b(Context context) {
        this.d = context;
    }

    public static b a(Context context) {
        if (b == null) {
            synchronized (b.class) {
                try {
                    if (b == null) {
                        b = new b(context);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return b;
    }

    public static a b(Context context) {
        String b2 = i.b(context, "tramini", "P_SY", "");
        if (TextUtils.isEmpty(b2)) {
            return null;
        }
        return a.a(c.a(b2));
    }

    public final void a(final com.tramini.plugin.a.d.c cVar) {
        com.tramini.plugin.a.d.b bVar = new com.tramini.plugin.a.d.b() { // from class: com.tramini.plugin.b.b.1
            @Override // com.tramini.plugin.a.d.b
            public final void a() {
                b.this.e = true;
            }

            @Override // com.tramini.plugin.a.d.b
            public final void a(int i, Object obj) {
                b.this.e = false;
                if (obj != null) {
                    String obj2 = obj.toString();
                    i.a(b.this.d, "tramini", "P_SY", obj2);
                    Context context = b.this.d;
                    long currentTimeMillis = System.currentTimeMillis();
                    if (context != null) {
                        try {
                            SharedPreferences.Editor edit = context.getSharedPreferences("tramini", 0).edit();
                            edit.putLong("P_UD_TE", currentTimeMillis);
                            edit.apply();
                        } catch (Error | Exception e) {
                        }
                    }
                    a a2 = a.a(c.a(obj2));
                    if (a2 != null) {
                        com.tramini.plugin.a.f.a.a().a(g.a(a2), a2.b());
                        com.tramini.plugin.a.a.c.a().a(a2);
                        com.tramini.plugin.a.d.c cVar2 = cVar;
                        if (cVar2 != null) {
                            cVar2.a(a2);
                        }
                    }
                }
            }

            @Override // com.tramini.plugin.a.d.b
            public final void b() {
                b.this.e = false;
            }
        };
        if (this.e || TextUtils.isEmpty(c.f26852a)) {
            return;
        }
        new d().a(0, bVar);
    }

    public final boolean a() {
        long longValue = i.a(this.d, "tramini", "P_UD_TE", (Long) 0L).longValue();
        a b2 = b();
        return b2 == null || longValue + b2.c() <= System.currentTimeMillis();
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x003b -> B:11:0x0025). Please submit an issue!!! */
    public final a b() {
        a aVar;
        synchronized (this) {
            if (f26864c == null) {
                try {
                    if (this.d == null) {
                        this.d = com.tramini.plugin.a.a.c.a().b();
                    }
                    f26864c = b(this.d);
                } catch (Exception e) {
                }
                com.tramini.plugin.a.a.c.a().a(f26864c);
            }
            aVar = f26864c;
        }
        return aVar;
    }
}
