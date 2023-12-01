package com.opos.mobad.q.a;

import android.content.Context;
import android.view.View;
import com.opos.mobad.model.data.AdItemData;
import com.opos.mobad.model.data.MaterialData;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/q/a/j.class */
public class j {

    /* renamed from: a  reason: collision with root package name */
    private a f27217a;
    private Context b;

    /* renamed from: c  reason: collision with root package name */
    private String f27218c;
    private AdItemData d;
    private MaterialData e;
    private long h;
    private int k;
    private long f = -1;
    private boolean g = false;
    private boolean i = false;
    private boolean j = false;

    /* loaded from: source-8303388-dex2jar.jar:com/opos/mobad/q/a/j$a.class */
    public interface a {
        void b();

        void b(long j);

        void b(String str);

        void c();
    }

    public j(Context context, String str, a aVar) {
        this.f27217a = aVar;
        this.b = context;
        this.f27218c = str;
    }

    private Map<String, String> a(String str, long j, long j2) {
        HashMap hashMap = new HashMap();
        try {
            if (!com.opos.cmn.an.c.a.a(str)) {
                return com.opos.mobad.cmn.a.b.d.a(str, j, j2);
            }
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("VideoPlayPresenter", "", (Throwable) e);
        }
        return hashMap;
    }

    private void a(List<String> list, long j) {
        if (list == null || list.size() <= 0) {
            return;
        }
        com.opos.mobad.service.g.b.a().a(list).a(j).a(this.b);
    }

    private void a(boolean z, String str, int i, long j) {
        com.opos.mobad.cmn.a.b.d.b(this.b, this.f27218c, this.d, this.e, z, a(str, i, j));
    }

    private boolean a(long j, long j2, float f) {
        boolean z;
        if (0 != j) {
            try {
            } catch (Exception e) {
                com.opos.cmn.an.f.a.a("VideoPlayPresenter", "", (Throwable) e);
            }
            if (b(j, this.f) < f) {
                if (b(j, j2) >= f) {
                    z = true;
                    com.opos.cmn.an.f.a.b("VideoPlayPresenter", "meetVideoPercent percent=" + f + ",result=" + z);
                    return z;
                }
            }
        }
        z = false;
        com.opos.cmn.an.f.a.b("VideoPlayPresenter", "meetVideoPercent percent=" + f + ",result=" + z);
        return z;
    }

    private float b(long j, long j2) {
        float f = 0 != j ? ((float) j2) / (((float) j) * 1.0f) : 0.0f;
        com.opos.cmn.an.f.a.b("VideoPlayPresenter", "getVideoPercent=" + f);
        return f;
    }

    private void b() {
        com.opos.mobad.service.c.a(new Runnable() { // from class: com.opos.mobad.q.a.j.1
            @Override // java.lang.Runnable
            public void run() {
                if (j.this.f27217a != null) {
                    j.this.f27217a.b();
                }
            }
        });
    }

    private void b(long j) {
        try {
            if (this.g) {
                return;
            }
            a(true, "0", 0, j);
            e(0L);
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("VideoPlayPresenter", "", (Throwable) e);
        }
    }

    private long c(long j) {
        return j > 0 ? j : this.h;
    }

    private void d(long j) {
        if (this.e.B() == null || this.e.B().size() <= 0) {
            return;
        }
        com.opos.mobad.service.g.b.a().a(this.e.B()).a(j).a(this.b);
    }

    private void e(long j) {
        if (this.e.x() == null || this.e.x().size() <= 0) {
            return;
        }
        com.opos.mobad.service.g.b.a().a(this.e.x()).a(j).a(this.b);
    }

    public void a() {
        this.g = true;
    }

    public void a(final int i, String str) {
        com.opos.cmn.an.f.a.b("VideoPlayPresenter", "code=" + i);
        try {
            if (this.g) {
                return;
            }
            com.opos.mobad.cmn.a.b.d.a(this.b, this.f27218c, this.d, this.e, true, String.valueOf(this.k), i);
            final String a2 = com.opos.mobad.cmn.a.b.f.a(i);
            com.opos.mobad.service.c.a(new Runnable() { // from class: com.opos.mobad.q.a.j.3
                @Override // java.lang.Runnable
                public void run() {
                    if (j.this.g || j.this.f27217a == null) {
                        return;
                    }
                    a aVar = j.this.f27217a;
                    StringBuilder sb = new StringBuilder();
                    sb.append("code=");
                    sb.append(i);
                    sb.append(",msg=");
                    String str2 = a2;
                    if (str2 == null) {
                        str2 = "";
                    }
                    sb.append(str2);
                    aVar.b(sb.toString());
                }
            });
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("VideoPlayPresenter", "", (Throwable) e);
        }
    }

    public void a(long j) {
        try {
            if (this.g) {
                return;
            }
            if (this.i) {
                com.opos.cmn.an.f.a.b("VideoPlayPresenter", "video has complete");
                return;
            }
            long c2 = c(j);
            a(true, "100", (int) c2, c2);
            d(c2);
            com.opos.mobad.service.c.a(new Runnable() { // from class: com.opos.mobad.q.a.j.2
                @Override // java.lang.Runnable
                public void run() {
                    if (j.this.f27217a != null) {
                        j.this.f27217a.c();
                    }
                }
            });
            this.i = true;
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("VideoPlayPresenter", "", (Throwable) e);
        }
    }

    public void a(long j, long j2) {
        long j3;
        List<String> A;
        try {
            if (this.g) {
                return;
            }
            if (this.i) {
                com.opos.cmn.an.f.a.b("VideoPlayPresenter", "onProcess but has completed");
                return;
            }
            if (j2 <= 0) {
                j3 = this.h;
            } else {
                j3 = j2;
                if (!this.j) {
                    j3 = j2;
                    if (this.e != null) {
                        j3 = j2;
                        if (this.e.F() != null) {
                            j3 = j2;
                            if (this.e.F().size() > 0) {
                                j3 = j2;
                                if (Math.abs(this.e.u() - j2) >= 2000) {
                                    this.j = true;
                                    com.opos.mobad.service.i.d.a().c().a(this.e.aa(), this.e.F().get(0).a(), this.e.u(), j2);
                                    j3 = j2;
                                }
                            }
                        }
                    }
                }
            }
            if (this.f == -1) {
                b();
            }
            if (a(j3, j, 0.25f)) {
                a(true, "25", (int) j, j3);
                A = this.e.y();
            } else if (a(j3, j, 0.5f)) {
                a(true, "50", (int) j, j3);
                A = this.e.z();
            } else if (!a(j3, j, 0.75f)) {
                if (this.f == -1) {
                    b(j3);
                }
                this.f = j;
            } else {
                a(true, "75", (int) j, j3);
                A = this.e.A();
            }
            a(A, j);
            this.f = j;
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("VideoPlayPresenter", "", (Throwable) e);
        }
    }

    public void a(View view, int[] iArr, final long j) {
        try {
            if (this.g) {
                return;
            }
            com.opos.mobad.service.c.a(new Runnable() { // from class: com.opos.mobad.q.a.j.4
                @Override // java.lang.Runnable
                public void run() {
                    if (j.this.g || j.this.f27217a == null) {
                        return;
                    }
                    j.this.f27217a.b(j);
                }
            });
        } catch (Exception e) {
            com.opos.cmn.an.f.a.a("VideoPlayPresenter", "", (Throwable) e);
        }
    }

    public void a(AdItemData adItemData, MaterialData materialData, long j, int i) {
        this.d = adItemData;
        this.e = materialData;
        this.f = -1L;
        this.i = false;
        if (j <= 0) {
            this.h = materialData.u();
        } else {
            this.h = j;
        }
        this.j = false;
        this.k = i;
    }
}
