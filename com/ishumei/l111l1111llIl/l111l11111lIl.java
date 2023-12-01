package com.ishumei.l111l1111llIl;

/* loaded from: source-7994992-dex2jar.jar:com/ishumei/l111l1111llIl/l111l11111lIl.class */
public final class l111l11111lIl {
    private long l1111l111111Il;
    private volatile boolean l111l11111I1l;
    private long l111l11111lIl;

    /* loaded from: source-7994992-dex2jar.jar:com/ishumei/l111l1111llIl/l111l11111lIl$l1111l111111Il.class */
    static final class l1111l111111Il {
        private static final l111l11111lIl l1111l111111Il = new l111l11111lIl((byte) 0);

        private l1111l111111Il() {
        }
    }

    private l111l11111lIl() {
        this.l111l11111I1l = false;
    }

    /* synthetic */ l111l11111lIl(byte b) {
        this();
    }

    public static l111l11111lIl l1111l111111Il() {
        return l1111l111111Il.l1111l111111Il;
    }

    public final void l111l11111I1l() {
        if (this.l111l11111lIl == 0) {
            this.l111l11111lIl = System.currentTimeMillis();
        }
    }

    public final long l111l11111Il() {
        if (this.l111l11111I1l) {
            return -1L;
        }
        this.l111l11111I1l = true;
        return this.l111l11111lIl - this.l1111l111111Il;
    }

    public final void l111l11111lIl() {
        if (this.l1111l111111Il == 0) {
            this.l1111l111111Il = System.currentTimeMillis();
        }
    }
}
