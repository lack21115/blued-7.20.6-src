package com.kwad.sdk.pngencrypt.chunk;

import com.kwad.sdk.pngencrypt.PngjException;
import java.io.ByteArrayInputStream;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/pngencrypt/chunk/i.class */
public final class i extends p {
    private int avA;
    private int avz;
    private int awV;
    private int awW;
    private int awX;
    private int awY;
    private int awZ;

    public i(com.kwad.sdk.pngencrypt.k kVar) {
        super("IHDR", kVar);
        if (kVar != null) {
            Cd();
        }
    }

    private int BF() {
        return this.avz;
    }

    private int BG() {
        return this.avA;
    }

    private int BZ() {
        return this.awV;
    }

    private int Ca() {
        return this.awW;
    }

    private int Cb() {
        return this.awZ;
    }

    private void Cd() {
        bV(this.avO.avA);
        bW(this.avO.avz);
        bX(this.avO.avS);
        int i = this.avO.avU ? 4 : 0;
        int i2 = i;
        if (this.avO.avW) {
            i2 = i + 1;
        }
        int i3 = i2;
        if (!this.avO.avV) {
            i3 = i2 + 2;
        }
        bY(i3);
        bZ(0);
        ca(0);
        cb(0);
    }

    private void Cf() {
        if (this.avA <= 0 || this.avz <= 0 || this.awX != 0 || this.awY != 0) {
            throw new PngjException("bad IHDR: col/row/compmethod/filmethod invalid");
        }
        int i = this.awV;
        if (i != 1 && i != 2 && i != 4 && i != 8 && i != 16) {
            throw new PngjException("bad IHDR: bitdepth invalid");
        }
        int i2 = this.awZ;
        if (i2 < 0 || i2 > 1) {
            throw new PngjException("bad IHDR: interlace invalid");
        }
        int i3 = this.awW;
        if (i3 != 0) {
            if (i3 != 6 && i3 != 2) {
                if (i3 == 3) {
                    if (this.awV == 16) {
                        throw new PngjException("bad IHDR: bitdepth invalid");
                    }
                    return;
                } else if (i3 != 4) {
                    throw new PngjException("bad IHDR: invalid colormodel");
                }
            }
            int i4 = this.awV;
            if (i4 != 8 && i4 != 16) {
                throw new PngjException("bad IHDR: bitdepth invalid");
            }
        }
    }

    private void bV(int i) {
        this.avA = i;
    }

    private void bW(int i) {
        this.avz = i;
    }

    private void bX(int i) {
        this.awV = i;
    }

    private void bY(int i) {
        this.awW = i;
    }

    private void bZ(int i) {
        this.awX = 0;
    }

    private void ca(int i) {
        this.awY = 0;
    }

    private void cb(int i) {
        this.awZ = 0;
    }

    public final boolean Cc() {
        return Cb() == 1;
    }

    public final com.kwad.sdk.pngencrypt.k Ce() {
        Cf();
        return new com.kwad.sdk.pngencrypt.k(BG(), BF(), BZ(), (Ca() & 4) != 0, Ca() == 0 || Ca() == 4, (Ca() & 1) != 0);
    }

    @Override // com.kwad.sdk.pngencrypt.chunk.PngChunk
    public final void a(d dVar) {
        if (dVar.len != 13) {
            throw new PngjException("Bad IDHR len " + dVar.len);
        }
        ByteArrayInputStream BV = dVar.BV();
        this.avA = com.kwad.sdk.pngencrypt.n.f(BV);
        this.avz = com.kwad.sdk.pngencrypt.n.f(BV);
        this.awV = com.kwad.sdk.pngencrypt.n.e(BV);
        this.awW = com.kwad.sdk.pngencrypt.n.e(BV);
        this.awX = com.kwad.sdk.pngencrypt.n.e(BV);
        this.awY = com.kwad.sdk.pngencrypt.n.e(BV);
        this.awZ = com.kwad.sdk.pngencrypt.n.e(BV);
    }
}
