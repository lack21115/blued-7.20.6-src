package com.anythink.expressad.video.module.a.a;

import android.content.Context;
import android.text.TextUtils;
import com.anythink.expressad.foundation.d.r;
import com.anythink.expressad.foundation.h.w;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/video/module/a/a/k.class */
public class k extends f {
    public static final int V = 2;

    /* renamed from: a  reason: collision with root package name */
    public static final int f5670a = 1;
    private static final String ag = "camp_position";
    protected boolean W;
    protected com.anythink.expressad.foundation.d.c X;
    protected List<com.anythink.expressad.foundation.d.c> Y;
    protected boolean Z;
    protected com.anythink.expressad.videocommon.b.c aa;
    protected com.anythink.expressad.videocommon.c.c ab;
    protected String ac;
    protected String ad;
    protected com.anythink.expressad.video.module.a.a ae;
    protected int af;
    private boolean ah = false;
    private boolean ai = false;
    private boolean aj = false;

    public k(com.anythink.expressad.foundation.d.c cVar, com.anythink.expressad.videocommon.b.c cVar2, com.anythink.expressad.videocommon.c.c cVar3, String str, String str2, com.anythink.expressad.video.module.a.a aVar, int i, boolean z) {
        this.Z = false;
        this.ae = new f();
        this.af = 1;
        if (!z && cVar != null && w.b(str2) && cVar2 != null && aVar != null) {
            this.X = cVar;
            this.ad = str;
            this.ac = str2;
            this.aa = cVar2;
            this.ab = cVar3;
            this.ae = aVar;
            this.W = true;
            this.af = i;
            this.Z = false;
        } else if (!z || cVar == null || !w.b(str2) || aVar == null) {
        } else {
            this.X = cVar;
            this.ad = str;
            this.ac = str2;
            this.aa = cVar2;
            this.ab = cVar3;
            this.ae = aVar;
            this.W = true;
            this.af = i;
            this.Z = true;
        }
    }

    private static void g() {
    }

    private static void h() {
    }

    private static void i() {
        com.anythink.expressad.videocommon.b.e.a().a(false);
    }

    private static void j() {
    }

    private void k() {
        if (!this.W || com.anythink.expressad.foundation.g.a.f.k == null || TextUtils.isEmpty(this.X.aZ())) {
            return;
        }
        com.anythink.expressad.foundation.g.a.f.a(this.ac, this.X, "reward");
    }

    private static void l() {
    }

    private static void m() {
    }

    private static void n() {
    }

    public final void a() {
        if (!this.W || this.X == null) {
            return;
        }
        com.anythink.core.common.b.n.a().g();
        new r(r.q, this.X.aZ(), this.X.Z(), this.X.aa(), this.ac, com.anythink.expressad.foundation.h.k.a()).a(this.X.H() ? r.aQ : r.aR);
    }

    public final void a(int i) {
        if (this.X != null) {
            if (i == 1 || i == 2) {
                com.anythink.expressad.video.module.b.a.a(com.anythink.core.common.b.n.a().g(), this.X, i, this.af);
            }
        }
    }

    @Override // com.anythink.expressad.video.module.a.a.f, com.anythink.expressad.video.module.a.a
    public void a(int i, Object obj) {
        super.a(i, obj);
        this.ae.a(i, obj);
    }

    public final void a(int i, String str) {
        if (this.X != null) {
            com.anythink.core.common.b.n.a().g();
            new r(r.r, this.X.aZ(), this.X.Z(), this.X.aa(), this.ac, com.anythink.expressad.foundation.h.k.a(), i, str);
        }
    }

    public final void a(com.anythink.expressad.foundation.d.c cVar) {
        this.X = cVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(String str) {
        List<com.anythink.expressad.foundation.d.c> list;
        if (this.X == null || (list = this.Y) == null || list.size() == 0) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has(ag)) {
                this.X = this.Y.get(jSONObject.getInt(ag));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public final void a(List<com.anythink.expressad.foundation.d.c> list) {
        this.Y = list;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void b() {
        com.anythink.expressad.videocommon.b.c cVar = this.aa;
        if (cVar != null) {
            cVar.b(true);
        }
    }

    public final void b(int i) {
        String sb;
        com.anythink.expressad.foundation.d.c cVar = this.X;
        if (cVar != null) {
            String ah = cVar.ah();
            if (TextUtils.isEmpty(ah)) {
                return;
            }
            if (i == 1 || i == 2) {
                if (!ah.contains("endscreen_type")) {
                    StringBuilder sb2 = new StringBuilder(ah);
                    if (ah.contains("?")) {
                        sb2.append("&endscreen_type=");
                        sb2.append(i);
                    } else {
                        sb2.append("?endscreen_type=");
                        sb2.append(i);
                    }
                    sb = sb2.toString();
                } else if (i == 2) {
                    sb = ah;
                    if (ah.contains("endscreen_type=1")) {
                        sb = ah.replace("endscreen_type=1", "endscreen_type=2");
                    }
                } else {
                    sb = ah;
                    if (ah.contains("endscreen_type=2")) {
                        sb = ah.replace("endscreen_type=2", "endscreen_type=1");
                    }
                }
                this.X.q(sb);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void c() {
        String str;
        try {
            if (this.X != null && this.X.j() && this.Z && !this.X.l()) {
                this.ai = true;
            } else if (!this.W || TextUtils.isEmpty(this.X.ai()) || com.anythink.expressad.foundation.g.a.f.h == null || com.anythink.expressad.foundation.g.a.f.h.containsKey(this.X.ai()) || this.ai) {
            } else {
                com.anythink.expressad.foundation.g.a.f.h.put(this.X.ai(), Long.valueOf(System.currentTimeMillis()));
                String ai = this.X.ai();
                if (this.X.n() == 1) {
                    str = ai + "&to=1&cbt=" + this.X.az() + "&tmorl=" + this.af;
                } else {
                    str = ai + "&to=0&cbt=" + this.X.az() + "&tmorl=" + this.af;
                }
                if (!this.Z) {
                    com.anythink.expressad.a.a.a(com.anythink.core.common.b.n.a().g(), this.X, this.ac, str, true);
                } else if (this.X.l()) {
                    com.anythink.expressad.a.a.a(com.anythink.core.common.b.n.a().g(), this.X, this.ac, str, false, true, com.anythink.expressad.a.a.a.j);
                }
                this.ai = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void d() {
        String str;
        try {
            if (!this.W || this.ah || TextUtils.isEmpty(this.X.ag())) {
                return;
            }
            this.ah = true;
            this.X.A();
            String ag2 = this.X.ag();
            if (this.X.n() == 1) {
                str = ag2 + "&to=1&cbt=" + this.X.az() + "&tmorl=" + this.af;
            } else {
                str = ag2 + "&to=0&cbt=" + this.X.az() + "&tmorl=" + this.af;
            }
            com.anythink.expressad.a.a.a(com.anythink.core.common.b.n.a().g(), this.X, this.ac, str, false, true, com.anythink.expressad.a.a.a.i);
            com.anythink.expressad.video.module.b.a.a(com.anythink.core.common.b.n.a().g(), this.X);
            if (!this.W || com.anythink.expressad.foundation.g.a.f.k == null || TextUtils.isEmpty(this.X.aZ())) {
                return;
            }
            com.anythink.expressad.foundation.g.a.f.a(this.ac, this.X, "reward");
        } catch (Throwable th) {
            com.anythink.expressad.foundation.h.o.b("NotifyListener", th.getMessage(), th);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void e() {
        List<String> e;
        try {
            if (!this.W || this.aj || this.X == null) {
                return;
            }
            this.aj = true;
            if ((this.X.j() && this.Z && !this.X.l()) || this.Z || (e = this.X.e()) == null || e.size() <= 0) {
                return;
            }
            for (String str : e) {
                com.anythink.expressad.a.a.a(com.anythink.core.common.b.n.a().g(), this.X, this.ac, str, true);
            }
        } catch (Throwable th) {
            com.anythink.expressad.foundation.h.o.d("NotifyListener", th.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void f() {
        com.anythink.expressad.foundation.d.c cVar = this.X;
        if (cVar == null || TextUtils.isEmpty(cVar.K()) || this.X.L() == null || this.X.L().n() == null) {
            return;
        }
        Context g = com.anythink.core.common.b.n.a().g();
        com.anythink.expressad.foundation.d.c cVar2 = this.X;
        com.anythink.expressad.a.a.a(g, cVar2, cVar2.K(), this.X.L().n(), false);
    }
}
