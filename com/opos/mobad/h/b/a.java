package com.opos.mobad.h.b;

import android.content.Context;
import android.os.SystemClock;
import android.view.View;
import com.opos.mobad.ad.c.l;
import com.opos.mobad.ad.c.q;
import com.opos.mobad.cmn.a.b.g;
import com.opos.mobad.model.data.AdItemData;
import com.opos.mobad.model.data.AppPrivacyData;
import com.opos.mobad.model.data.MaterialData;
import com.opos.mobad.model.data.MaterialFileData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/h/b/a.class */
public class a implements com.opos.mobad.ad.c.d {

    /* renamed from: a  reason: collision with root package name */
    protected Context f12473a;
    private com.opos.mobad.h.c b;

    /* renamed from: c  reason: collision with root package name */
    private AdItemData f12474c;
    private MaterialData d;
    private List<com.opos.mobad.ad.c.e> e = null;
    private List<com.opos.mobad.ad.c.e> f = null;
    private long g = SystemClock.elapsedRealtime();
    private boolean h = false;
    private boolean i = false;
    private boolean j = false;
    private l k;

    /* renamed from: com.opos.mobad.h.b.a$a  reason: collision with other inner class name */
    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/h/b/a$a.class */
    static class C0527a implements l {

        /* renamed from: a  reason: collision with root package name */
        private AppPrivacyData f12475a;

        public C0527a(AppPrivacyData appPrivacyData) {
            this.f12475a = appPrivacyData;
        }

        @Override // com.opos.mobad.ad.c.b
        public String a() {
            AppPrivacyData appPrivacyData = this.f12475a;
            if (appPrivacyData == null) {
                return null;
            }
            return appPrivacyData.d;
        }

        @Override // com.opos.mobad.ad.c.b
        public String b() {
            AppPrivacyData appPrivacyData = this.f12475a;
            if (appPrivacyData == null) {
                return null;
            }
            return appPrivacyData.f12781c;
        }

        @Override // com.opos.mobad.ad.c.l
        public String c() {
            AppPrivacyData appPrivacyData = this.f12475a;
            if (appPrivacyData == null) {
                return null;
            }
            return appPrivacyData.b;
        }

        @Override // com.opos.mobad.ad.c.l
        public String d() {
            AppPrivacyData appPrivacyData = this.f12475a;
            if (appPrivacyData == null) {
                return null;
            }
            return appPrivacyData.f12780a;
        }
    }

    public a(Context context, com.opos.mobad.h.c cVar, AdItemData adItemData) {
        this.f12473a = context;
        this.b = cVar;
        this.f12474c = adItemData;
        this.d = adItemData.i().get(0);
        if (this.f12474c.O() != null) {
            this.k = new C0527a(this.f12474c.O());
        }
    }

    private String a(int i) {
        switch (i) {
            case 10200:
                return "ad repeat exposure.";
            case 10201:
                return "ad exposure expired.";
            case 10202:
                return "ad hasn't exposed.";
            case 10203:
                return "ad repeat click.";
            case 10204:
                return "ad click expired.";
            default:
                return "";
        }
    }

    private int m() {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        com.opos.cmn.an.f.a.b("NativeAdDataImpl", "mReqAdTime=" + this.g + ",mHasAdShow=" + this.h + ",nowTime=" + elapsedRealtime + ",getShowInterval=" + this.f12474c.p());
        int i = this.h ? 10200 : elapsedRealtime - this.g > ((long) ((this.f12474c.p() * 60) * 1000)) ? 10201 : 0;
        com.opos.cmn.an.f.a.b("NativeAdDataImpl", "getAdShowStatus =" + i);
        return i;
    }

    private int n() {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        com.opos.cmn.an.f.a.b("NativeAdDataImpl", "mReqAdTime=" + this.g + ",mHasAdShow=" + this.h + ",mHasAdClick=" + this.i + ",nowTime=" + elapsedRealtime + ",getClickInterval=" + this.f12474c.q());
        int i = !this.h ? 10202 : this.i ? 10203 : elapsedRealtime - this.g > ((long) ((this.f12474c.q() * 60) * 1000)) ? 10204 : 0;
        com.opos.cmn.an.f.a.b("NativeAdDataImpl", "getAdClickStatus =" + i);
        return i;
    }

    @Override // com.opos.mobad.ad.c.d
    public String a() {
        return this.d.h();
    }

    @Override // com.opos.mobad.ad.c.d
    public void a(View view) {
        synchronized (this) {
            if (!this.b.d()) {
                this.f12474c.k(com.opos.mobad.service.f.a.a().x());
                int m = m();
                if (m == 0) {
                    this.b.b(this.f12474c);
                    this.b.a(this.f12474c, true, null);
                    this.h = true;
                } else {
                    this.b.a(this.f12474c, false, null);
                    this.b.b().a(new q(m, a(m)), this);
                }
                this.b.a(this.f12474c);
            }
        }
    }

    @Override // com.opos.mobad.ad.c.d
    public boolean a(String str) {
        boolean z = false;
        if (!this.b.d()) {
            boolean z2 = false;
            z = false;
            try {
                if (!com.opos.cmn.an.c.a.a(str)) {
                    z = false;
                    if (this.f12474c != null) {
                        z = false;
                        if (this.d != null) {
                            z = str.equals(this.d.k());
                            StringBuilder sb = new StringBuilder();
                            sb.append("isCurrentApp downloadPkgName=");
                            sb.append(this.d.k());
                            z2 = z;
                            com.opos.cmn.an.f.a.b("NativeAdDataImpl", sb.toString());
                        }
                    }
                }
            } catch (Exception e) {
                com.opos.cmn.an.f.a.a("NativeAdDataImpl", "", (Throwable) e);
                z = z2;
            }
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("isCurrentApp pkgName=");
        if (str == null) {
            str = com.igexin.push.core.b.l;
        }
        sb2.append(str);
        sb2.append(",result=");
        sb2.append(z);
        com.opos.cmn.an.f.a.b("NativeAdDataImpl", sb2.toString());
        return z;
    }

    @Override // com.opos.mobad.ad.c.d
    public String b() {
        return this.d.i();
    }

    @Override // com.opos.mobad.ad.c.d
    public void b(View view) {
        boolean z;
        synchronized (this) {
            if (!this.b.d()) {
                HashMap hashMap = new HashMap();
                if (this.j) {
                    z = "2";
                } else {
                    this.j = true;
                    z = "1";
                }
                hashMap.put("clickState", z);
                int n = n();
                if (n == 0) {
                    this.i = true;
                    this.b.a(this.f12474c, true, null, hashMap, com.opos.mobad.cmn.a.b.a.ClickBt, view);
                } else {
                    this.b.a(this.f12474c, false, null, hashMap, com.opos.mobad.cmn.a.b.a.ClickBt, view);
                    this.b.b().a(new q(n, a(n)), this);
                }
            }
        }
    }

    @Override // com.opos.mobad.ad.c.d
    public List<com.opos.mobad.ad.c.e> c() {
        List<MaterialData> i;
        List<MaterialFileData> j;
        if (this.e == null && (i = this.f12474c.i()) != null && i.size() > 0) {
            for (MaterialData materialData : i) {
                if (materialData != null && (j = materialData.j()) != null && j.size() > 0) {
                    this.e = new ArrayList();
                    for (MaterialFileData materialFileData : j) {
                        if (materialFileData != null) {
                            this.e.add(new b(materialFileData));
                        }
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("getIconFiles =");
        List<com.opos.mobad.ad.c.e> list = this.e;
        sb.append(list != null ? Integer.valueOf(list.size()) : com.igexin.push.core.b.l);
        com.opos.cmn.an.f.a.b("NativeAdDataImpl", sb.toString());
        return this.e;
    }

    @Override // com.opos.mobad.ad.c.d
    public List<com.opos.mobad.ad.c.e> d() {
        List<MaterialData> i;
        List<MaterialFileData> f;
        if (this.f == null && (i = this.f12474c.i()) != null && i.size() > 0) {
            for (MaterialData materialData : i) {
                if (materialData != null && (f = materialData.f()) != null && f.size() > 0) {
                    this.f = new ArrayList();
                    for (MaterialFileData materialFileData : f) {
                        if (materialFileData != null) {
                            this.f.add(new b(materialFileData));
                        }
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("getImgFiles =");
        List<com.opos.mobad.ad.c.e> list = this.f;
        sb.append(list != null ? Integer.valueOf(list.size()) : com.igexin.push.core.b.l);
        com.opos.cmn.an.f.a.b("NativeAdDataImpl", sb.toString());
        return this.f;
    }

    @Override // com.opos.mobad.ad.c.d
    public int e() {
        return this.d.d();
    }

    @Override // com.opos.mobad.ad.c.d
    public int f() {
        return this.d.e();
    }

    @Override // com.opos.mobad.ad.c.d
    public com.opos.mobad.ad.c.e g() {
        MaterialFileData l = this.f12474c.l();
        b bVar = l != null ? new b(l) : null;
        StringBuilder sb = new StringBuilder();
        sb.append("getLogoFile=");
        sb.append(bVar != null ? bVar : com.igexin.push.core.b.l);
        com.opos.cmn.an.f.a.b("NativeAdDataImpl", sb.toString());
        return bVar;
    }

    @Override // com.opos.mobad.ad.c.d
    public boolean h() {
        boolean z = m() == 0;
        com.opos.cmn.an.f.a.b("NativeAdDataImpl", "isAdValid=" + z);
        return z;
    }

    @Override // com.opos.mobad.ad.c.d
    public String i() {
        return this.f12474c.n();
    }

    @Override // com.opos.mobad.ad.c.d
    public String j() {
        String a2 = g.a(this.f12473a, this.f12474c, false);
        com.opos.cmn.an.f.a.b("NativeAdDataImpl", "getClickBnText=" + a2);
        return a2;
    }

    @Override // com.opos.mobad.ad.c.d
    public boolean k() {
        boolean a2;
        if (!this.b.d()) {
            try {
            } catch (Exception e) {
                com.opos.cmn.an.f.a.a("NativeAdDataImpl", "", (Throwable) e);
            }
            if (this.f12474c != null && this.d != null) {
                a2 = this.b.a(this.f12474c, this.d);
                com.opos.cmn.an.f.a.b("NativeAdDataImpl", "launchApp=" + a2);
                return a2;
            }
        }
        a2 = false;
        com.opos.cmn.an.f.a.b("NativeAdDataImpl", "launchApp=" + a2);
        return a2;
    }

    @Override // com.opos.mobad.ad.c.d
    public l l() {
        return this.k;
    }
}
