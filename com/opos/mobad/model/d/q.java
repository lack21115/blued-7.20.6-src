package com.opos.mobad.model.d;

import android.text.TextUtils;
import com.opos.mobad.b.a.x;
import com.opos.mobad.b.a.y;
import java.net.URLEncoder;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/model/d/q.class */
public class q {

    /* renamed from: a  reason: collision with root package name */
    private p f26443a = new p();
    private Map<String, r> b = new ConcurrentHashMap();

    private q a(int i, y yVar) {
        if (yVar == null) {
            return this;
        }
        this.f26443a.a(yVar.aU, String.valueOf(i));
        return this;
    }

    public q a(y yVar) {
        return a(9, yVar);
    }

    public q a(y yVar, x xVar) {
        if (yVar == null) {
            return this;
        }
        this.b.put(yVar.aU, new r(yVar, xVar));
        return this;
    }

    public void a(String str, int i) {
        Map<String, r> map = this.b;
        if (map == null || map.size() <= 0) {
            return;
        }
        for (r rVar : this.b.values()) {
            if (rVar != null) {
                rVar.a(str, i);
            }
        }
    }

    public q b(y yVar) {
        return a(2, yVar);
    }

    public q c(y yVar) {
        return a(11, yVar);
    }

    public q d(y yVar) {
        return a(3, yVar);
    }

    public q e(y yVar) {
        return a(4, yVar);
    }

    public q f(y yVar) {
        return a(6, yVar);
    }

    public q g(y yVar) {
        return a(7, yVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String g() {
        String valueOf;
        for (String str : this.b.keySet()) {
            String a2 = this.b.get(str).a();
            if (TextUtils.isEmpty(a2)) {
                this.f26443a.a(str, String.valueOf(0));
            } else {
                try {
                    valueOf = URLEncoder.encode("0-" + a2);
                } catch (Exception e) {
                    valueOf = String.valueOf(0);
                }
                this.f26443a.a(str, valueOf);
            }
        }
        String a3 = this.f26443a.a();
        String str2 = a3;
        if (!TextUtils.isEmpty(a3)) {
            try {
                return URLEncoder.encode(a3);
            } catch (Exception e2) {
                str2 = "";
            }
        }
        return str2;
    }

    public q h(y yVar) {
        return a(10, yVar);
    }

    public q i(y yVar) {
        a(yVar, (x) null);
        return this;
    }
}
