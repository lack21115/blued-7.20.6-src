package com.tencent.mapsdk.internal;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import com.tencent.mapsdk.internal.nf;
import com.tencent.mapsdk.internal.of;
import com.tencent.tencentmap.mapsdk.maps.TencentMapOptions;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/mf.class */
public class mf implements nf.d, of.a {
    public static final String j = "AUTH_MARKER";

    /* renamed from: a  reason: collision with root package name */
    private final l1 f37647a;
    private final wh b;

    /* renamed from: c  reason: collision with root package name */
    private final yg f37648c;
    private final tf d;
    private final rc e;
    private List<AsyncTask> f;
    private final rf g;
    private boolean h;
    private final yi i;

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/mf$a.class */
    public interface a {
        void a(Bitmap bitmap, int i, int i2);
    }

    public mf(h1 h1Var) {
        String str;
        Context j2 = h1Var.j();
        this.i = h1Var.l();
        this.b = h1Var.l().n0();
        l1 n = h1Var.n();
        this.f37647a = n;
        this.f37648c = h1Var.m();
        this.d = h1Var.k();
        this.e = h1Var.l().A();
        this.f = new ArrayList();
        String str2 = "";
        if (h1Var.l() == null || h1Var.l().l() == null) {
            str = "";
        } else {
            str2 = h1Var.l().l().getSubKey();
            str = h1Var.l().l().getSubId();
        }
        this.g = new rf(j2, h1Var, str2);
        this.f.add(new nf(n.p, str2, str, this));
        this.f.add(new of(h1Var, this));
    }

    public void a() {
        if (this.f != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.f.size()) {
                    break;
                }
                this.f.get(i2).cancel(true);
                i = i2 + 1;
            }
            this.f.clear();
        }
        this.f = null;
        this.h = true;
    }

    public void a(a aVar, TencentMapOptions tencentMapOptions) {
        this.f37647a.a(aVar, tencentMapOptions);
    }

    @Override // com.tencent.mapsdk.internal.nf.d
    public void a(nf.c cVar, JSONObject jSONObject) {
        s5 s5Var;
        if (this.h) {
            return;
        }
        JSONArray jSONArray = null;
        if (cVar != null) {
            JSONArray jSONArray2 = cVar.b;
            s5 s5Var2 = cVar.f37669a;
            sf sfVar = cVar.d;
            s5Var = s5Var2;
            jSONArray = jSONArray2;
            if (sfVar != null) {
                this.d.a(sfVar);
                s5Var = s5Var2;
                jSONArray = jSONArray2;
            }
        } else {
            s5Var = null;
        }
        a(jSONArray, s5Var);
        rc rcVar = this.e;
        if (rcVar != null && cVar != null) {
            int i = cVar.e;
            if (i == hh.s || i == hh.t) {
                rcVar.v(true);
            } else {
                rcVar.v(false);
            }
            z3 z3Var = (z3) this.e.getMapComponent(z3.class);
            if (z3Var != null) {
                z3Var.a(cVar.f37670c);
            }
        }
        ra.i(qa.U);
    }

    public void a(JSONArray jSONArray, s5 s5Var) {
        yg ygVar = this.f37648c;
        if (ygVar == null) {
            return;
        }
        ygVar.b(jSONArray);
        b0 i = this.i.i();
        if (i != null) {
            i.a(s5Var);
        }
        this.g.a(this.f37648c.a(), s5Var);
    }

    @Override // com.tencent.mapsdk.internal.of.a
    public void a(boolean z, vh vhVar) {
        yi yiVar = this.i;
        if (yiVar == null || vhVar == null) {
            return;
        }
        yiVar.a(z, vhVar.h());
        if (z) {
            this.b.h();
        }
        this.b.a(true);
    }

    public void b() {
        ra.h(qa.U);
        for (AsyncTask asyncTask : this.f) {
            asyncTask.execute(new Object[0]);
        }
    }
}
