package com.kwad.sdk.pngencrypt;

import java.util.zip.Inflater;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/pngencrypt/DeflatedChunksSet.class */
public class DeflatedChunksSet {
    protected final boolean auV;
    protected byte[] avl;
    private int avm;
    private int avn;
    private int avo;
    State avp;
    private final boolean avq;
    private d avr;
    private long avs = 0;
    private long avt = 0;
    int avu = -1;
    int avv = -1;
    public final String avw;
    private Inflater inf;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/pngencrypt/DeflatedChunksSet$State.class */
    public enum State {
        WAITING_FOR_INPUT,
        ROW_READY,
        DONE,
        CLOSED;

        public final boolean isClosed() {
            return this == CLOSED;
        }

        public final boolean isDone() {
            return this == DONE || this == CLOSED;
        }
    }

    public DeflatedChunksSet(String str, boolean z, int i, int i2, Inflater inflater, byte[] bArr) {
        boolean z2;
        this.avp = State.WAITING_FOR_INPUT;
        this.avw = str;
        this.auV = z;
        this.avn = i;
        if (i <= 0 || i2 < i) {
            throw new PngjException("bad inital row len " + i);
        }
        if (inflater != null) {
            this.inf = inflater;
            z2 = false;
        } else {
            this.inf = new Inflater();
            z2 = true;
        }
        this.avq = z2;
        this.avl = (bArr == null || bArr.length < i) ? new byte[i2] : bArr;
        this.avo = -1;
        this.avp = State.WAITING_FOR_INPUT;
        try {
            bK(i);
        } catch (RuntimeException e) {
            close();
            throw e;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x00d4 A[Catch: RuntimeException -> 0x00dc, TRY_LEAVE, TryCatch #0 {RuntimeException -> 0x00dc, blocks: (B:2:0x0000, B:4:0x000a, B:6:0x0017, B:10:0x0022, B:12:0x0029, B:17:0x0040, B:19:0x004a, B:21:0x0056, B:25:0x0082, B:23:0x0073, B:27:0x0098, B:29:0x00a2, B:39:0x00c9, B:41:0x00d4, B:31:0x00a9, B:33:0x00b3, B:34:0x00ba, B:37:0x00c4, B:15:0x0036), top: B:48:0x0000, inners: #1 }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00da A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean Bw() {
        /*
            Method dump skipped, instructions count: 227
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.pngencrypt.DeflatedChunksSet.Bw():boolean");
    }

    public final int BA() {
        return this.avo;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Bx() {
    }

    protected int By() {
        throw new PngjException("not implemented");
    }

    public final void Bz() {
        if (isDone()) {
            return;
        }
        this.avp = State.DONE;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(d dVar) {
        if (!this.avw.equals(dVar.Bj().awG)) {
            com.kwad.sdk.core.d.b.printStackTrace(new PngjException("Bad chunk inside IdatSet, id:" + dVar.Bj().awG + ", expected:" + this.avw));
        }
        this.avr = dVar;
        int i = this.avu + 1;
        this.avu = i;
        int i2 = this.avv;
        if (i2 >= 0) {
            dVar.bJ(i + i2);
        }
    }

    public final void bK(int i) {
        this.avm = 0;
        this.avo++;
        if (i <= 0 || this.inf.finished()) {
            this.avn = 0;
            Bz();
            return;
        }
        this.avp = State.WAITING_FOR_INPUT;
        this.avn = i;
        if (this.auV) {
            return;
        }
        Bw();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void c(byte[] bArr, int i, int i2) {
        this.avs += i2;
        if (i2 <= 0 || this.avp.isDone()) {
            return;
        }
        if (this.avp == State.ROW_READY) {
            com.kwad.sdk.core.d.b.printStackTrace(new PngjException("this should only be called if waitingForMoreInput"));
        }
        if (this.inf.needsDictionary() || !this.inf.needsInput()) {
            throw new RuntimeException("should not happen");
        }
        this.inf.setInput(bArr, i, i2);
        if (!this.auV) {
            Bw();
            return;
        }
        while (Bw()) {
            bK(By());
            isDone();
        }
    }

    public void close() {
        try {
            if (!this.avp.isClosed()) {
                this.avp = State.CLOSED;
            }
            if (!this.avq || this.inf == null) {
                return;
            }
            this.inf.end();
            this.inf = null;
        } catch (Exception e) {
        }
    }

    public final boolean ek(String str) {
        if (this.avp.isClosed()) {
            return false;
        }
        if (str.equals(this.avw)) {
            return true;
        }
        if (this.avp.isDone()) {
            if (this.avp.isClosed()) {
                return false;
            }
            close();
            return false;
        }
        throw new PngjException("Unexpected chunk " + str + " while " + this.avw + " set is not done");
    }

    public final boolean isClosed() {
        return this.avp.isClosed();
    }

    public final boolean isDone() {
        return this.avp.isDone();
    }

    public String toString() {
        return new StringBuilder("idatSet : " + this.avr.Bj().awG + " state=" + this.avp + " rows=" + this.avo + " bytes=" + this.avs + "/" + this.avt).toString();
    }
}
