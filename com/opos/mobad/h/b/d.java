package com.opos.mobad.h.b;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.opos.cmn.d.e;
import com.opos.cmn.j.b;
import com.opos.mobad.ad.c.h;
import com.opos.mobad.ad.c.i;
import com.opos.mobad.ad.c.k;
import com.opos.mobad.ad.privacy.ComplianceInfo;
import com.opos.mobad.cmn.a.a;
import com.opos.mobad.cmn.a.b;
import com.opos.mobad.cmn.a.e;
import com.opos.mobad.cmn.service.pkginstall.b;
import com.opos.mobad.model.data.AdItemData;
import com.opos.mobad.model.data.MaterialData;
import com.opos.mobad.model.data.MaterialFileData;
import com.opos.mobad.service.event.EventDescription;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/h/b/d.class */
public class d {
    private MaterialData A;
    private MaterialFileData B;
    private String C;
    private a.b D;
    private ComplianceInfo E;
    private com.opos.mobad.ad.privacy.b F;
    private int G;
    private com.opos.mobad.service.event.c H;

    /* renamed from: a  reason: collision with root package name */
    private com.opos.mobad.cmn.a.a f12480a;
    private Context b;
    private boolean k;
    private com.opos.cmn.j.b p;
    private FrameLayout q;
    private FrameLayout r;
    private i w;
    private k x;
    private com.opos.mobad.h.c.a.a y;
    private AdItemData z;

    /* renamed from: c  reason: collision with root package name */
    private boolean f12481c = false;
    private boolean d = false;
    private boolean e = false;
    private boolean f = false;
    private boolean g = false;
    private int h = 0;
    private String i = "";
    private boolean j = false;
    private boolean l = false;
    private int m = 0;
    private long n = 0;
    private long o = 0;
    private boolean s = false;
    private boolean t = false;
    private boolean u = false;
    private boolean v = false;
    private b.a I = new b.a() { // from class: com.opos.mobad.h.b.d.5
        @Override // com.opos.cmn.j.b.a
        public void a(boolean z) {
            if (!z) {
                d.this.s = false;
                return;
            }
            d.this.s = true;
            if (d.this.t || d.this.v) {
                return;
            }
            d.this.t = true;
            d.this.z.k(com.opos.mobad.service.f.a.a().x());
            d.this.f12480a.b(d.this.z);
            d.this.f12480a.a(d.this.z);
            d.this.a(true);
            d.this.i();
            if (d.this.w != null) {
                d.this.w.b();
            }
        }
    };
    private com.opos.mobad.h.a.a J = new com.opos.mobad.h.a.a() { // from class: com.opos.mobad.h.b.d.6
        @Override // com.opos.mobad.h.a.a
        public void a(int i, String str) {
            com.opos.cmn.an.f.a.b("NativeAdvancePresenter", "video status onVideoPlayError");
            d.this.b(i, str);
        }

        @Override // com.opos.mobad.h.a.a
        public void a(View view, AdItemData adItemData) {
            com.opos.cmn.an.f.a.b("NativeAdvancePresenter", "video status onVideoPlayStart");
            d.this.e();
        }

        @Override // com.opos.mobad.h.a.a
        public void a(View view, AdItemData adItemData, long j) {
            d.this.h = 2;
            d.this.n = j;
            com.opos.cmn.an.f.a.b("NativeAdvancePresenter", "video status onVideoPlayPause:" + j);
        }

        @Override // com.opos.mobad.h.a.a
        public void a(View view, int[] iArr, long j, com.opos.mobad.cmn.a.b.a aVar) {
            com.opos.cmn.an.f.a.b("NativeAdvancePresenter", "onVideoClick ");
            if (!com.opos.mobad.h.f.a(d.this.z, aVar) || d.this.v || d.this.f12480a == null) {
                return;
            }
            com.opos.mobad.service.event.b.a().b(d.this.H);
            final EventDescription eventDescription = new EventDescription(d.this.b());
            d.this.f12480a.a(d.this.z, !d.this.u, iArr, (Map<String, String>) null, aVar, view, (b.InterfaceC0517b) null, new b.a().a(eventDescription).a(d.this.k).a(d.this.n).a(d.this.i).a(), new a.c() { // from class: com.opos.mobad.h.b.d.6.1
                @Override // com.opos.mobad.cmn.a.a.c
                public void a(int i) {
                    if (!d.this.v && i == 3) {
                        d.this.H = com.opos.mobad.activity.webview.b.e.a(eventDescription, d.this.K);
                    }
                }

                @Override // com.opos.mobad.cmn.a.a.c
                public void a(int i, int i2) {
                }
            });
            d.this.d();
            if (d.this.u) {
                return;
            }
            if (d.this.w != null) {
                d.this.w.a();
            }
            d.this.u = true;
        }

        @Override // com.opos.mobad.h.a.a
        public void b(View view, AdItemData adItemData) {
            com.opos.cmn.an.f.a.b("NativeAdvancePresenter", "video status onVideoPlayComplete");
            d.this.f();
        }

        @Override // com.opos.mobad.h.a.a
        public void b(View view, AdItemData adItemData, long j) {
            d.this.h = 1;
            d.this.n = j;
            com.opos.cmn.an.f.a.b("NativeAdvancePresenter", "video status onVideoPlayResume:" + j);
        }

        @Override // com.opos.mobad.h.a.a
        public void c(View view, AdItemData adItemData, long j) {
            com.opos.cmn.an.f.a.b("NativeAdvancePresenter", "video status onVideoPlayProgress :" + j);
            d dVar = d.this;
            dVar.a(j, dVar.o, d.this.g());
            d.this.n = j;
        }
    };
    private com.opos.mobad.activity.webview.b.d K = new com.opos.mobad.activity.webview.b.c() { // from class: com.opos.mobad.h.b.d.7
        private void f() {
            d.this.n = 0L;
            d.this.h = -2;
            if (!d.this.g) {
                d.this.f12481c = false;
                d.this.d = false;
                d.this.e = false;
                d.this.f = false;
            }
            if (d.this.y != null) {
                d.this.y.a(d.this.z);
            }
        }

        @Override // com.opos.mobad.activity.webview.b.c
        public void a(int i, String str) {
            com.opos.cmn.an.f.a.b("NativeAdvancePresenter", "video status onWebViewVideoError :" + str);
            d.this.b(i, str);
        }

        @Override // com.opos.mobad.activity.webview.b.c
        public void a(long j) {
            if (d.this.h != 1) {
                d.this.h = 1;
            }
            d.this.n = j;
            com.opos.cmn.an.f.a.b("NativeAdvancePresenter", "video status onWebViewVideoProgress :" + j);
            d dVar = d.this;
            dVar.a(j, dVar.o, d.this.g());
        }

        @Override // com.opos.mobad.activity.webview.b.c
        public void b() {
            com.opos.cmn.an.f.a.b("NativeAdvancePresenter", "video status onWebViewVideoStart ");
            d.this.e();
        }

        @Override // com.opos.mobad.activity.webview.b.c
        public void b(long j) {
            com.opos.cmn.an.f.a.b("NativeAdvancePresenter", "video status onWebViewVideoPause " + j);
            d.this.h = 2;
            d.this.n = j;
        }

        @Override // com.opos.mobad.activity.webview.b.c
        public void c() {
            com.opos.cmn.an.f.a.b("NativeAdvancePresenter", "video status onWebViewVideoComplete ");
            d.this.f();
            f();
        }

        @Override // com.opos.mobad.activity.webview.b.c
        public void c(long j) {
            com.opos.cmn.an.f.a.b("NativeAdvancePresenter", "video status onWebViewVideoUserPause ");
            d.this.h = 4;
            d.this.n = j;
        }

        @Override // com.opos.mobad.activity.webview.b.d
        public void d() {
        }

        @Override // com.opos.mobad.activity.webview.b.d
        public void e() {
            if (d.this.H != null) {
                com.opos.mobad.service.event.b.a().b(d.this.H);
            }
        }

        @Override // com.opos.mobad.activity.webview.b.c
        public void f_() {
            com.opos.cmn.an.f.a.b("NativeAdvancePresenter", "video status onWebViewVideoClose mCurrentState:" + d.this.h);
            if (!com.opos.cmn.an.h.c.a.e(d.this.b) && !d.this.A.X()) {
                if (!com.opos.cmn.an.h.c.a.d(d.this.b) || d.this.y == null) {
                    return;
                }
                d.this.y.a(d.this.z);
                return;
            }
            int i = d.this.h;
            if (i != -1) {
                if (i == 2) {
                    d dVar = d.this;
                    dVar.b(dVar.z, d.this.i);
                    return;
                } else if (i != 3 && i != 4) {
                    return;
                }
            }
            f();
        }
    };
    private b.a L = new b.a() { // from class: com.opos.mobad.h.b.d.8
        @Override // com.opos.cmn.j.b.a
        public void a(boolean z) {
            com.opos.cmn.an.f.a.b("NativeAdvancePresenter", "onViewVisibile isViewVisible:" + z + ",mCurrentState:" + d.this.h + ",url:" + d.this.i);
            d.this.j = z;
            if (!z) {
                d.this.d();
                if (d.this.h == -2) {
                    d.this.h = -3;
                }
            } else if (d.this.h == -2 || d.this.h == 4) {
            } else {
                if (com.opos.cmn.an.h.c.a.e(d.this.b) || d.this.A.X()) {
                    d.this.c();
                }
            }
        }
    };

    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/h/b/d$a.class */
    public static class a implements e.a {

        /* renamed from: a  reason: collision with root package name */
        private h.a f12492a;

        public a(h.a aVar) {
            this.f12492a = aVar;
        }

        @Override // com.opos.mobad.cmn.a.e.a
        public void a() {
            h.a aVar = this.f12492a;
            if (aVar == null) {
                return;
            }
            aVar.a();
        }

        @Override // com.opos.mobad.cmn.a.e.a
        public void a(View view) {
            h.a aVar = this.f12492a;
            if (aVar == null) {
                return;
            }
            aVar.a(view);
        }
    }

    public d(Context context, com.opos.mobad.cmn.a.a aVar, AdItemData adItemData, String str, com.opos.mobad.ad.privacy.b bVar) {
        boolean z = false;
        this.k = false;
        this.b = context;
        this.C = str;
        this.z = adItemData;
        MaterialData materialData = adItemData.i().get(0);
        this.A = materialData;
        this.k = materialData.d() == 13 ? true : z;
        this.f12480a = aVar;
        this.p = new com.opos.cmn.j.b(this.b);
        this.q = new FrameLayout(this.b);
        a.b a2 = com.opos.mobad.cmn.a.b.f.a(context, this.p);
        this.D = a2;
        this.f12480a.a(a2);
        if (this.k) {
            this.B = com.opos.mobad.cmn.a.b.f.a(adItemData);
            a(this.z);
        }
        if (this.z.O() != null) {
            this.E = new ComplianceInfo(this.z.O().b, this.z.O().f12780a);
        }
        this.F = bVar;
    }

    private float a(long j, long j2) {
        if (0 != j) {
            return ((float) j2) / (((float) j) * 1.0f);
        }
        return 0.0f;
    }

    private Map<String, String> a(String str, AdItemData adItemData, long j) {
        HashMap hashMap = new HashMap();
        try {
            if (!com.opos.cmn.an.c.a.a(str) && adItemData != null) {
                return com.opos.mobad.cmn.a.b.d.a(str, j, b(adItemData));
            }
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("NativeAdvancePresenter", "", (Throwable) e);
        }
        return hashMap;
    }

    private void a(final int i, final String str) {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("notifyOnAdFailed code=");
            sb.append(i);
            sb.append(",msg=");
            sb.append(str != null ? str : com.igexin.push.core.b.l);
            com.opos.cmn.an.f.a.b("NativeAdvancePresenter", sb.toString());
            com.opos.mobad.service.c.a(new Runnable() { // from class: com.opos.mobad.h.b.d.4
                @Override // java.lang.Runnable
                public void run() {
                    if (d.this.x != null) {
                        k kVar = d.this.x;
                        int i2 = i;
                        String str2 = str;
                        if (str2 == null) {
                            str2 = "";
                        }
                        kVar.a(i2, str2);
                    }
                }
            });
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("NativeAdvancePresenter", "", (Throwable) e);
        }
    }

    private void a(int i, String str, boolean z) {
        com.opos.cmn.an.f.a.b("NativeAdvancePresenter", "code=" + i);
        if (this.v) {
            return;
        }
        com.opos.mobad.cmn.a.b.d.a(this.b, this.C, this.z, this.A, z, "", i);
    }

    private void a(long j) {
        if (this.A.x() == null || this.A.x().size() <= 0) {
            return;
        }
        a(this.b, this.A.x(), j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j, long j2, boolean z) {
        try {
            long b = b(this.z);
            this.o = j;
            if (!this.d && a(b, j, j2, 0.25f)) {
                a(z, j);
                this.d = true;
            } else if (!this.e && a(b, j, j2, 0.5f)) {
                b(z, j);
                this.e = true;
            } else if (this.f || !a(b, j, j2, 0.75f)) {
            } else {
                c(z, j);
                this.f = true;
            }
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("NativeAdvancePresenter", "", (Throwable) e);
        }
    }

    private void a(Context context, FrameLayout frameLayout) {
        if (frameLayout.getChildCount() > 0) {
            frameLayout.removeAllViews();
        }
        if (this.q.getParent() != null) {
            ((ViewGroup) this.q.getParent()).removeView(this.q);
        }
        frameLayout.addView(this.q, new FrameLayout.LayoutParams(-1, -1));
        if (this.y == null) {
            this.q.addView(this.p, 0, 0);
            this.y = new com.opos.mobad.h.c.a.b(context, this.J, this.q);
        }
        this.y.a(this.z);
        this.p.a(this.L);
    }

    private void a(Context context, List<String> list, long j) {
        try {
            com.opos.mobad.service.g.b.a().a(list).a(j).a(this.b);
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("NativeAdvancePresenter", "", (Throwable) e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(View view, int[] iArr) {
        i iVar;
        if (!this.s) {
            com.opos.cmn.an.f.a.b("NativeAdvancePresenter", "click but not attach");
            i iVar2 = this.w;
            if (iVar2 != null) {
                iVar2.a(10202, "ad hasn't exposed.");
            }
        } else if (!com.opos.mobad.h.f.a(this.z, com.opos.mobad.cmn.a.b.a.ClickBt) || this.v) {
        } else {
            HashMap hashMap = new HashMap();
            hashMap.put("clickState", this.u ? "2" : "1");
            com.opos.mobad.service.event.b.a().b(this.H);
            final EventDescription eventDescription = new EventDescription(b());
            this.f12480a.a(this.z, !this.u, iArr, hashMap, com.opos.mobad.cmn.a.b.a.ClickBt, view, (b.InterfaceC0517b) null, new b.a().a(eventDescription).a(this.k).a(this.n).a(this.i).a(), new a.c() { // from class: com.opos.mobad.h.b.d.2
                @Override // com.opos.mobad.cmn.a.a.c
                public void a(int i) {
                    if (!d.this.v && i == 3) {
                        d dVar = d.this;
                        dVar.H = com.opos.mobad.activity.webview.b.e.a(eventDescription, dVar.K);
                    }
                }

                @Override // com.opos.mobad.cmn.a.a.c
                public void a(int i, int i2) {
                }
            });
            d();
            if (!this.u && (iVar = this.w) != null) {
                iVar.a();
            }
            this.u = true;
        }
    }

    private void a(AdItemData adItemData) {
        MaterialFileData materialFileData;
        if (adItemData == null || 2 != adItemData.r() || (materialFileData = this.B) == null) {
            return;
        }
        com.opos.cmn.d.e.a(this.b, materialFileData.a(), new e.a() { // from class: com.opos.mobad.h.b.d.3
            @Override // com.opos.cmn.d.e.a
            public void a(String str) {
                com.opos.cmn.an.f.a.b("NativeAdvancePresenter", "ping success url =" + str);
                d.this.i = str;
                d dVar = d.this;
                dVar.a(dVar.z, d.this.i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AdItemData adItemData, String str) {
        if (TextUtils.isEmpty(str) || !this.j) {
            return;
        }
        c(adItemData, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z) {
        try {
            HashMap hashMap = new HashMap();
            if (this.r != null) {
                com.opos.mobad.cmn.a.b.d.a(this.r, hashMap);
            }
            com.opos.mobad.cmn.a.b.d.a(this.b, this.C, this.z, this.A, z, this.G, hashMap);
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("NativeAdvancePresenter", "", (Throwable) e);
        }
    }

    private void a(boolean z, long j) {
        com.opos.cmn.an.f.a.b("NativeAdvancePresenter", "onVideoPlayProgress25Report  currentPosition=" + j);
        if (this.v) {
            return;
        }
        a(z, a("25", this.z, j));
        b(j);
    }

    private void a(boolean z, Map<String, String> map) {
        try {
            com.opos.mobad.cmn.a.b.d.b(this.b, this.C, this.z, this.A, z, map);
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("NativeAdvancePresenter", "", (Throwable) e);
        }
    }

    private boolean a(long j, long j2, long j3, float f) {
        boolean z = false;
        if (0 != j) {
            z = false;
            try {
                if (a(j, j3) < f) {
                    z = false;
                    if (a(j, j2) >= f) {
                        try {
                            com.opos.cmn.an.f.a.b("NativeAdvancePresenter", "getVideoPercent videoDuration =" + j + ",lastPostion=" + j3 + ",currentPosition" + j2);
                            StringBuilder sb = new StringBuilder();
                            sb.append("meetVideoPercent percent=");
                            sb.append(f);
                            sb.append(",result=");
                            sb.append(true);
                            com.opos.cmn.an.f.a.b("NativeAdvancePresenter", sb.toString());
                            return true;
                        } catch (Exception e) {
                            e = e;
                            z = true;
                            com.opos.cmn.an.f.a.a("NativeAdvancePresenter", "", (Throwable) e);
                            return z;
                        }
                    }
                }
            } catch (Exception e2) {
                e = e2;
                z = false;
            }
        }
        return z;
    }

    private long b(AdItemData adItemData) {
        if (adItemData != null) {
            try {
                return adItemData.i().get(0).u();
            } catch (Exception e) {
                com.opos.cmn.an.f.a.a("NativeAdvancePresenter", "", (Throwable) e);
                return 0L;
            }
        }
        return 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String b() {
        return this.C + "_" + System.currentTimeMillis();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(int i, String str) {
        this.h = -1;
        a(i, str, g());
        k kVar = this.x;
        if (kVar != null) {
            kVar.a(i, str);
        }
    }

    private void b(long j) {
        if (this.A.y() == null || this.A.y().size() <= 0) {
            return;
        }
        a(this.b, this.A.y(), j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(AdItemData adItemData, String str) {
        com.opos.mobad.h.c.a.a aVar;
        if (adItemData == null || TextUtils.isEmpty(str) || (aVar = this.y) == null) {
            return;
        }
        aVar.b(adItemData, str);
        this.l = true;
    }

    private void b(boolean z) {
        com.opos.cmn.an.f.a.b("NativeAdvancePresenter", "onVideoPlayStartReport isValid=" + z);
        try {
            if (this.v) {
                return;
            }
            a(z, a("0", this.z, 0L));
            a(0L);
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("NativeAdvancePresenter", "", (Throwable) e);
        }
    }

    private void b(boolean z, long j) {
        com.opos.cmn.an.f.a.b("NativeAdvancePresenter", "onVideoPlayProgress50Report  currentPosition=" + j);
        if (this.v) {
            return;
        }
        a(z, a("50", this.z, j));
        c(j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        int i;
        String str;
        com.opos.cmn.an.f.a.b("NativeAdvancePresenter", "playVideo");
        if (this.z == null) {
            com.opos.cmn.an.f.a.b("NativeAdvancePresenter", "empty adItemData");
            i = 10402;
            str = "no video to play.";
        } else if (com.opos.cmn.an.h.c.a.d(this.b)) {
            int r = this.z.r();
            if (r != 1 && r != 2) {
                com.opos.cmn.an.f.a.b("NativeAdvancePresenter", "error playMode");
                i = 10407;
                str = "暂时没有视频了，稍后再试试吧";
            } else if (!TextUtils.isEmpty(this.B.a())) {
                if (r == 1) {
                    if (TextUtils.isEmpty(this.i)) {
                        this.i = com.opos.cmn.d.d.a(this.b, this.B.a(), this.B.b());
                    }
                    c(this.z, this.i);
                    return;
                } else if (r == 2) {
                    a(this.z, this.i);
                    return;
                } else {
                    return;
                }
            } else if (r == 1) {
                i = 10401;
                str = "no local cached video to play.";
            } else if (r != 2) {
                return;
            } else {
                i = 10400;
                str = "no stream video to play.";
            }
        } else {
            com.opos.cmn.an.f.a.b("NativeAdvancePresenter", "not net");
            i = 10403;
            str = "no net,can't play video.";
        }
        a(i, str);
    }

    private void c(long j) {
        if (this.A.z() == null || this.A.z().size() <= 0) {
            return;
        }
        a(this.b, this.A.z(), j);
    }

    private void c(AdItemData adItemData, String str) {
        com.opos.mobad.h.c.a.a aVar;
        if (adItemData == null || TextUtils.isEmpty(str) || (aVar = this.y) == null) {
            return;
        }
        aVar.a(adItemData, str);
        this.l = true;
    }

    private void c(boolean z, long j) {
        com.opos.cmn.an.f.a.b("NativeAdvancePresenter", "onVideoPlayProgress75Report  currentPosition=" + j);
        if (this.v) {
            return;
        }
        a(z, a("75", this.z, j));
        d(j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        com.opos.mobad.h.c.a.a aVar;
        if (!this.l || (aVar = this.y) == null) {
            return;
        }
        aVar.b();
        this.l = false;
    }

    private void d(long j) {
        if (this.A.A() == null || this.A.A().size() <= 0) {
            return;
        }
        a(this.b, this.A.A(), j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        this.h = 1;
        this.m++;
        this.n = 0L;
        this.o = 0L;
        if (!this.g) {
            this.f12481c = false;
            this.d = false;
            this.e = false;
            this.f = false;
        }
        if (!this.f12481c) {
            b(g());
            this.f12481c = true;
        }
        k kVar = this.x;
        if (kVar != null) {
            kVar.a();
        }
    }

    private void e(long j) {
        if (this.A.B() == null || this.A.B().size() <= 0) {
            return;
        }
        a(this.b, this.A.B(), j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        this.h = 3;
        this.n = b(this.z);
        if (!this.g) {
            this.g = true;
            h();
        }
        k kVar = this.x;
        if (kVar != null) {
            kVar.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean g() {
        return this.m <= 1;
    }

    private void h() {
        com.opos.cmn.an.f.a.b("NativeAdvancePresenter", "onVideoPlayCompleteReport ");
        if (this.v) {
            return;
        }
        AdItemData adItemData = this.z;
        a(true, a("100", adItemData, b(adItemData)));
        e(b(this.z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        try {
            if (this.A.n() == null || this.A.n().size() <= 0) {
                return;
            }
            com.opos.mobad.service.g.b.a(this.b, this.A.n());
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("NativeAdvancePresenter", "", (Throwable) e);
        }
    }

    public void a() {
        com.opos.cmn.an.f.a.b("NativeAdvancePresenter", "release");
        this.w = null;
        this.x = null;
        com.opos.mobad.h.c.a.a aVar = this.y;
        if (aVar != null) {
            aVar.a();
            this.y = null;
        }
        a.b bVar = this.D;
        if (bVar != null) {
            bVar.a();
        }
        com.opos.mobad.ad.privacy.b bVar2 = this.F;
        if (bVar2 != null) {
            bVar2.a();
        }
        if (this.H != null) {
            com.opos.mobad.service.event.b.a().b(this.H);
        }
        this.r = null;
        this.f12480a.a();
        this.v = true;
    }

    public void a(int i) {
        this.G = i;
    }

    public void a(Context context, FrameLayout frameLayout, List<View> list) {
        com.opos.cmn.j.b bVar;
        if (context == null || frameLayout == null || list == null || list.size() <= 0) {
            return;
        }
        this.r = frameLayout;
        com.opos.cmn.an.f.a.b("NativeAdvancePresenter", "bind to view");
        int childCount = frameLayout.getChildCount();
        while (true) {
            int i = childCount - 1;
            if (i < 0) {
                bVar = null;
                break;
            }
            View childAt = frameLayout.getChildAt(i);
            if (childAt instanceof com.opos.cmn.j.b) {
                bVar = (com.opos.cmn.j.b) childAt;
                com.opos.cmn.an.f.a.b("", "empty not null");
                break;
            }
            childCount = i;
        }
        com.opos.cmn.j.b bVar2 = bVar;
        if (bVar == null) {
            bVar2 = new com.opos.cmn.j.b(context);
            frameLayout.addView(bVar2, 0, 0);
            com.opos.cmn.an.f.a.b("", "empty is null, new one");
        }
        bVar2.a(this.I);
        for (View view : list) {
            com.opos.cmn.e.a.a aVar = new com.opos.cmn.e.a.a() { // from class: com.opos.mobad.h.b.d.1
                @Override // com.opos.cmn.e.a.a
                public void a(View view2, int[] iArr) {
                    d.this.a(view2, iArr);
                }
            };
            com.opos.cmn.an.f.a.b("NativeAdvancePresenter", "set listener " + view);
            if (view != null) {
                view.setOnTouchListener(aVar);
                view.setOnClickListener(aVar);
            }
        }
    }

    public void a(Context context, List<View> list, h.a aVar, List<View> list2, h.a aVar2) {
        String str;
        if (context == null || list == null || list.size() <= 0 || list2 == null || list2.size() <= 0) {
            str = "bind to Compliance view but null params " + context + "," + list + "," + list2;
        } else if (this.E != null) {
            com.opos.cmn.an.f.a.b("NativeAdvancePresenter", "bind to Compliance view");
            com.opos.mobad.cmn.a.e.a(context, list, new a(aVar), list2, new a(aVar2), this.F, this.E);
            return;
        } else {
            str = "bind to Compliance view but without complianceInfo";
        }
        com.opos.cmn.an.f.a.b("NativeAdvancePresenter", str);
    }

    public void a(FrameLayout frameLayout, k kVar) {
        int i;
        String str;
        com.opos.cmn.an.f.a.b("NativeAdvancePresenter", "bindMediaView nativeMediaView: " + frameLayout + ",listener: " + kVar);
        if (!this.k) {
            com.opos.cmn.an.f.a.d("NativeAdvancePresenter", "native data is not video data");
            return;
        }
        if (kVar != null) {
            this.x = kVar;
        }
        if (frameLayout == null) {
            com.opos.cmn.an.f.a.c("NativeAdvancePresenter", "bindMediaView but bindMediaView is null");
            i = 10210;
            str = "MediaView constainer is null";
        } else if (com.opos.mobad.h.f.a(this.r, frameLayout)) {
            a(this.b, frameLayout);
            return;
        } else {
            com.opos.cmn.an.f.a.c("NativeAdvancePresenter", "bindMediaView but nativeMediaView is not contained");
            i = 10211;
            str = "NativeAdvanceContainer is not contain MediaView";
        }
        a(i, str);
    }

    public void a(i iVar) {
        this.w = iVar;
    }
}
