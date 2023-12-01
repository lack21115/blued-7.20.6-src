package com.anythink.basead.f.a;

import android.content.Context;
import android.text.TextUtils;
import com.anythink.basead.c.c;
import com.anythink.core.c.d;
import com.anythink.core.c.e;
import com.anythink.core.common.e.s;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/basead/f/a/b.class */
public final class b {

    /* renamed from: a  reason: collision with root package name */
    private static b f5987a;
    private Context b;
    private ConcurrentHashMap<String, c> d = new ConcurrentHashMap<>();

    /* renamed from: c  reason: collision with root package name */
    private SimpleDateFormat f5988c = new SimpleDateFormat("yyyyMMdd");

    private b(Context context) {
        this.b = context.getApplicationContext();
    }

    public static b a(Context context) {
        if (f5987a == null) {
            f5987a = new b(context);
        }
        return f5987a;
    }

    public final String a() {
        List<c> b = com.anythink.basead.b.c.a(this.b).b(this.f5988c.format(new Date(System.currentTimeMillis())));
        JSONArray jSONArray = new JSONArray();
        if (b != null) {
            for (c cVar : b) {
                jSONArray.put(cVar.f5893a);
            }
        }
        return jSONArray.toString();
    }

    public final void a(s sVar) {
        long currentTimeMillis = System.currentTimeMillis();
        String format = this.f5988c.format(new Date(currentTimeMillis));
        final c d = d(sVar);
        if (d.f.equals(format)) {
            d.d++;
        } else {
            d.d = 1;
            d.f = format;
        }
        d.e = currentTimeMillis;
        com.anythink.core.common.k.b.a.a().a(new Runnable() { // from class: com.anythink.basead.f.a.b.1
            @Override // java.lang.Runnable
            public final void run() {
                com.anythink.basead.b.c.a(b.this.b).c(d.f);
                com.anythink.basead.b.c.a(b.this.b).a(d);
            }
        });
    }

    public final boolean a(String str) {
        d a2 = e.a(this.b).a(str);
        boolean z = false;
        if (a2 == null) {
            return false;
        }
        List<s> E = a2.E();
        if (E != null) {
            if (E.size() <= 0) {
                return false;
            }
            for (s sVar : E) {
                if (!b(sVar)) {
                    return false;
                }
            }
            z = true;
        }
        return z;
    }

    public final boolean b(s sVar) {
        return sVar.R != -1 && d(sVar).d >= sVar.R;
    }

    public final boolean c(s sVar) {
        return System.currentTimeMillis() - d(sVar).e <= sVar.S;
    }

    public final c d(s sVar) {
        String format = this.f5988c.format(new Date(System.currentTimeMillis()));
        c cVar = this.d.get(sVar.p());
        c cVar2 = cVar;
        if (cVar == null) {
            c a2 = com.anythink.basead.b.c.a(this.b).a(sVar.p());
            cVar2 = a2;
            if (a2 == null) {
                cVar2 = new c();
                cVar2.f5893a = sVar.p();
                cVar2.b = sVar.R;
                cVar2.f5894c = sVar.S;
                cVar2.e = 0L;
                cVar2.d = 0;
                cVar2.f = format;
            }
            this.d.put(sVar.p(), cVar2);
        }
        if (!TextUtils.equals(format, cVar2.f)) {
            cVar2.f = format;
            cVar2.d = 0;
        }
        return cVar2;
    }
}
