package com.amap.api.col.p0003sl;

import android.os.SystemClock;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.amap.api.col.3sl.lj  reason: invalid package */
/* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/lj.class */
public final class lj {
    private mj a;
    private mj b;
    private mp c;
    private a d = new a();
    private final List<mj> e = new ArrayList(3);

    /* renamed from: com.amap.api.col.3sl.lj$a */
    /* loaded from: source-6737240-dex2jar.jar:com/amap/api/col/3sl/lj$a.class */
    public static final class a {
        public byte a;
        public String b;
        public mj c;
        public mj d;
        public mj e;
        public List<mj> f = new ArrayList();
        public List<mj> g = new ArrayList();

        public static boolean a(mj mjVar, mj mjVar2) {
            if (mjVar == null || mjVar2 == null) {
                return (mjVar == null) == (mjVar2 == null);
            } else if ((mjVar instanceof ml) && (mjVar2 instanceof ml)) {
                ml mlVar = (ml) mjVar;
                ml mlVar2 = (ml) mjVar2;
                return mlVar.j == mlVar2.j && mlVar.k == mlVar2.k;
            } else if ((mjVar instanceof mk) && (mjVar2 instanceof mk)) {
                mk mkVar = (mk) mjVar;
                mk mkVar2 = (mk) mjVar2;
                return mkVar.l == mkVar2.l && mkVar.k == mkVar2.k && mkVar.j == mkVar2.j;
            } else if ((mjVar instanceof mm) && (mjVar2 instanceof mm)) {
                mm mmVar = (mm) mjVar;
                mm mmVar2 = (mm) mjVar2;
                return mmVar.j == mmVar2.j && mmVar.k == mmVar2.k;
            } else if ((mjVar instanceof mn) && (mjVar2 instanceof mn)) {
                mn mnVar = (mn) mjVar;
                mn mnVar2 = (mn) mjVar2;
                return mnVar.j == mnVar2.j && mnVar.k == mnVar2.k;
            } else {
                return false;
            }
        }

        public final void a() {
            this.a = (byte) 0;
            this.b = "";
            this.c = null;
            this.d = null;
            this.e = null;
            this.f.clear();
            this.g.clear();
        }

        public final void a(byte b, String str, List<mj> list) {
            a();
            this.a = b;
            this.b = str;
            if (list != null) {
                this.f.addAll(list);
                for (mj mjVar : this.f) {
                    if (!mjVar.i && mjVar.h) {
                        this.d = mjVar;
                    } else if (mjVar.i && mjVar.h) {
                        this.e = mjVar;
                    }
                }
            }
            mj mjVar2 = this.d;
            mj mjVar3 = mjVar2;
            if (mjVar2 == null) {
                mjVar3 = this.e;
            }
            this.c = mjVar3;
        }

        public final String toString() {
            return "CellInfo{radio=" + ((int) this.a) + ", operator='" + this.b + "', mainCell=" + this.c + ", mainOldInterCell=" + this.d + ", mainNewInterCell=" + this.e + ", cells=" + this.f + ", historyMainCellList=" + this.g + '}';
        }
    }

    private void a(a aVar) {
        synchronized (this.e) {
            for (mj mjVar : aVar.f) {
                if (mjVar != null && mjVar.h) {
                    mj clone = mjVar.clone();
                    clone.e = SystemClock.elapsedRealtime();
                    a(clone);
                }
            }
            this.d.g.clear();
            this.d.g.addAll(this.e);
        }
    }

    private void a(mj mjVar) {
        int i;
        if (mjVar == null) {
            return;
        }
        int size = this.e.size();
        if (size == 0) {
            this.e.add(mjVar);
            return;
        }
        long j = Long.MAX_VALUE;
        int i2 = 0;
        int i3 = -1;
        while (true) {
            if (i2 >= size) {
                i = i3;
                break;
            }
            mj mjVar2 = this.e.get(i2);
            if (mjVar.equals(mjVar2)) {
                i = -1;
                if (mjVar.c != mjVar2.c) {
                    mjVar2.e = mjVar.c;
                    mjVar2.c = mjVar.c;
                    i = -1;
                }
            } else {
                j = Math.min(j, mjVar2.e);
                if (j == mjVar2.e) {
                    i3 = i2;
                }
                i2++;
            }
        }
        if (i >= 0) {
            if (size < 3) {
                this.e.add(mjVar);
            } else if (mjVar.e <= j || i >= size) {
            } else {
                this.e.remove(i);
                this.e.add(mjVar);
            }
        }
    }

    private boolean a(mp mpVar) {
        return mpVar.a(this.c) > ((double) ((mpVar.g > 10.0f ? 1 : (mpVar.g == 10.0f ? 0 : -1)) > 0 ? 2000.0f : (mpVar.g > 2.0f ? 1 : (mpVar.g == 2.0f ? 0 : -1)) > 0 ? 500.0f : 100.0f));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final a a(mp mpVar, boolean z, byte b, String str, List<mj> list) {
        if (z) {
            this.d.a();
            return null;
        }
        this.d.a(b, str, list);
        if (this.d.c == null) {
            return null;
        }
        if (this.c == null || a(mpVar) || !a.a(this.d.d, this.a) || !a.a(this.d.e, this.b)) {
            this.a = this.d.d;
            this.b = this.d.e;
            this.c = mpVar;
            mf.a(this.d.f);
            a(this.d);
            return this.d;
        }
        return null;
    }
}
