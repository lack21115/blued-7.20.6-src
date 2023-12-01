package com.kwad.components.core.p;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/components/core/p/a.class */
public class a {
    private static volatile a Pp;
    private int LY;
    private int Pq;
    private boolean Pr;
    private boolean Ps;
    private int Pt;
    private boolean Pu;

    private a() {
    }

    public static a pt() {
        if (Pp == null) {
            synchronized (a.class) {
                try {
                    if (Pp == null) {
                        Pp = new a();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return Pp;
    }

    public final void aF(int i) {
        this.Pq = i;
    }

    public final void aG(int i) {
        this.Pt = i;
    }

    public final void aH(int i) {
        this.LY = i;
    }

    public final void aI(boolean z) {
        this.Pr = true;
    }

    public final void aJ(boolean z) {
        this.Ps = z;
    }

    public final void aK(boolean z) {
        this.Pu = z;
    }

    public final void clear() {
        this.Ps = false;
        this.Pr = false;
        this.Pt = 0;
        this.Pu = false;
        this.Pq = -1;
        this.LY = 0;
    }

    public final int pA() {
        return this.LY;
    }

    public final int pu() {
        return this.Pq;
    }

    public final boolean pv() {
        return this.Pr;
    }

    public final boolean pw() {
        return this.Ps;
    }

    public final boolean px() {
        int i = this.Pt;
        return i == 1 || i == 3;
    }

    public final int py() {
        return this.Pt;
    }

    public final boolean pz() {
        return this.Pu;
    }
}
