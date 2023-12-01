package com.kwad.sdk.pngencrypt;

import com.kwad.sdk.pngencrypt.chunk.w;
import java.io.Closeable;
import java.io.InputStream;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/pngencrypt/o.class */
public final class o implements Closeable {
    protected ErrorBehaviour auO = ErrorBehaviour.STRICT;
    public final k avO;
    public final boolean awk;
    protected final c awl;
    protected final a awm;
    protected final w awn;
    protected int awo;
    private i<? extends Object> awp;

    public o(InputStream inputStream, boolean z) {
        this.awo = -1;
        a aVar = new a(inputStream);
        this.awm = aVar;
        boolean z2 = true;
        aVar.bl(true);
        c BT = BT();
        this.awl = BT;
        try {
            if (this.awm.b(BT, 36) != 36) {
                com.kwad.sdk.core.d.b.printStackTrace(new PngjException("Could not read first 36 bytes (PNG signature+IHDR chunk)"));
            }
            this.avO = this.awl.Bt();
            if (this.awl.Bu() == null) {
                z2 = false;
            }
            this.awk = z2;
            ad(5024024L);
            ab(901001001L);
            ac(2024024L);
            this.awn = new w(this.awl.auU);
            a(m.BM());
            this.awo = -1;
        } catch (RuntimeException e) {
            this.awm.close();
            this.awl.close();
            throw e;
        }
    }

    private void BP() {
        while (this.awl.auT < 4) {
            if (this.awm.a(this.awl) <= 0) {
                com.kwad.sdk.core.d.b.printStackTrace(new PngjException("Premature ending reading first chunks"));
            }
        }
    }

    private void BS() {
        this.awl.bn(false);
    }

    private static c BT() {
        return new c(false);
    }

    private void a(i<? extends Object> iVar) {
        this.awp = iVar;
    }

    private void ab(long j) {
        this.awl.ab(901001001L);
    }

    private void ac(long j) {
        this.awl.ac(2024024L);
    }

    private void ad(long j) {
        this.awl.ad(5024024L);
    }

    public final w BQ() {
        if (this.awl.Br()) {
            BP();
        }
        return this.awn;
    }

    public final void BR() {
        BS();
        if (this.awl.Br()) {
            BP();
        }
        end();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        com.kwad.sdk.crash.utils.b.closeQuietly(this.awl);
        com.kwad.sdk.crash.utils.b.closeQuietly(this.awm);
    }

    public final void end() {
        try {
            if (this.awl.Br()) {
                BP();
            }
            if (this.awl.Bs() != null && !this.awl.Bs().isDone()) {
                this.awl.Bs().Bz();
            }
            do {
                if (this.awl.isDone()) {
                    break;
                }
            } while (this.awm.a(this.awl) > 0);
        } finally {
            close();
        }
    }

    public final String toString() {
        return this.avO.toString() + " interlaced=" + this.awk;
    }
}
