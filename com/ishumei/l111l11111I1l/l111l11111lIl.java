package com.ishumei.l111l11111I1l;

/* loaded from: source-7994992-dex2jar.jar:com/ishumei/l111l11111I1l/l111l11111lIl.class */
public abstract class l111l11111lIl<T> implements Runnable {
    public T l1111l111111Il = null;
    private boolean l111l11111I1l;
    private boolean l111l11111Il;
    private int l111l11111lIl;
    private long l111l1111l1Il;
    private boolean l111l1111llIl;

    public l111l11111lIl(boolean z, int i) {
        this.l111l11111lIl = -1;
        this.l111l11111I1l = false;
        this.l111l11111Il = false;
        this.l111l1111l1Il = 0L;
        this.l111l1111llIl = false;
        this.l111l11111I1l = z;
        this.l111l11111lIl = i;
        this.l111l11111Il = false;
        this.l111l1111l1Il = 0L;
        this.l111l1111llIl = false;
    }

    public l111l11111lIl(boolean z, int i, boolean z2) {
        this.l111l11111lIl = -1;
        this.l111l11111I1l = false;
        this.l111l11111Il = false;
        this.l111l1111l1Il = 0L;
        this.l111l1111llIl = false;
        this.l111l11111I1l = z;
        this.l111l11111lIl = i;
        this.l111l11111Il = z2;
        this.l111l1111l1Il = 0L;
        this.l111l1111llIl = false;
    }

    public l111l11111lIl(boolean z, int i, boolean z2, long j, boolean z3) {
        this.l111l11111lIl = -1;
        this.l111l11111I1l = false;
        this.l111l11111Il = false;
        this.l111l1111l1Il = 0L;
        this.l111l1111llIl = false;
        this.l111l11111I1l = z;
        this.l111l11111lIl = i;
        this.l111l11111Il = z2;
        this.l111l1111l1Il = j;
        this.l111l1111llIl = z3;
    }

    public final void l1111l111111Il() {
        if (this.l111l11111I1l) {
            l1111l111111Il.l111l11111lIl().l1111l111111Il(this, this.l111l11111lIl, this.l111l11111Il, this.l111l1111l1Il, this.l111l1111llIl);
        } else {
            run();
        }
    }

    public final void l1111l111111Il(T t) {
        this.l1111l111111Il = t;
    }
}
