package ar.com.hjg.pngj.chunks;

import ar.com.hjg.pngj.ImageInfo;
import ar.com.hjg.pngj.PngHelperInternal;
import ar.com.hjg.pngj.PngjException;
import ar.com.hjg.pngj.PngjInputException;
import java.io.ByteArrayInputStream;

/* loaded from: source-8756600-dex2jar.jar:ar/com/hjg/pngj/chunks/PngChunkIHDR.class */
public class PngChunkIHDR extends PngChunkSingle {
    private int h;
    private int i;
    private int j;
    private int k;
    private int l;
    private int m;
    private int n;

    public PngChunkIHDR(ImageInfo imageInfo) {
        super("IHDR", imageInfo);
        if (imageInfo != null) {
            a(imageInfo);
        }
    }

    public void a(ImageInfo imageInfo) {
        b(this.e.f3638a);
        c(this.e.b);
        d(this.e.f3639c);
        int i = this.e.e ? 4 : 0;
        int i2 = i;
        if (this.e.g) {
            i2 = i + 1;
        }
        int i3 = i2;
        if (!this.e.f) {
            i3 = i2 + 2;
        }
        e(i3);
        f(0);
        g(0);
        h(0);
    }

    @Override // ar.com.hjg.pngj.chunks.PngChunk
    public void a(ChunkRaw chunkRaw) {
        if (chunkRaw.f3659a != 13) {
            throw new PngjException("Bad IDHR len " + chunkRaw.f3659a);
        }
        ByteArrayInputStream c2 = chunkRaw.c();
        this.h = PngHelperInternal.b(c2);
        this.i = PngHelperInternal.b(c2);
        this.j = PngHelperInternal.a(c2);
        this.k = PngHelperInternal.a(c2);
        this.l = PngHelperInternal.a(c2);
        this.m = PngHelperInternal.a(c2);
        this.n = PngHelperInternal.a(c2);
    }

    public void b(int i) {
        this.h = i;
    }

    public void c(int i) {
        this.i = i;
    }

    public void d(int i) {
        this.j = i;
    }

    public ChunkRaw e() {
        ChunkRaw chunkRaw = new ChunkRaw(13, ChunkHelper.f3654a, true);
        PngHelperInternal.a(this.h, chunkRaw.d, 0);
        PngHelperInternal.a(this.i, chunkRaw.d, 4);
        chunkRaw.d[8] = (byte) this.j;
        chunkRaw.d[9] = (byte) this.k;
        chunkRaw.d[10] = (byte) this.l;
        chunkRaw.d[11] = (byte) this.m;
        chunkRaw.d[12] = (byte) this.n;
        return chunkRaw;
    }

    public void e(int i) {
        this.k = i;
    }

    public int f() {
        return this.h;
    }

    public void f(int i) {
        this.l = i;
    }

    public int g() {
        return this.i;
    }

    public void g(int i) {
        this.m = i;
    }

    public int h() {
        return this.j;
    }

    public void h(int i) {
        this.n = i;
    }

    public int i() {
        return this.k;
    }

    public int j() {
        return this.n;
    }

    public boolean k() {
        return j() == 1;
    }

    public ImageInfo l() {
        m();
        return new ImageInfo(f(), g(), h(), (i() & 4) != 0, i() == 0 || i() == 4, (i() & 1) != 0);
    }

    public void m() {
        if (this.h < 1 || this.i < 1 || this.l != 0 || this.m != 0) {
            throw new PngjInputException("bad IHDR: col/row/compmethod/filmethod invalid");
        }
        int i = this.j;
        if (i != 1 && i != 2 && i != 4 && i != 8 && i != 16) {
            throw new PngjInputException("bad IHDR: bitdepth invalid");
        }
        int i2 = this.n;
        if (i2 < 0 || i2 > 1) {
            throw new PngjInputException("bad IHDR: interlace invalid");
        }
        int i3 = this.k;
        if (i3 != 0) {
            if (i3 != 6 && i3 != 2) {
                if (i3 == 3) {
                    if (this.j == 16) {
                        throw new PngjInputException("bad IHDR: bitdepth invalid");
                    }
                    return;
                } else if (i3 != 4) {
                    throw new PngjInputException("bad IHDR: invalid colormodel");
                }
            }
            int i4 = this.j;
            if (i4 != 8 && i4 != 16) {
                throw new PngjInputException("bad IHDR: bitdepth invalid");
            }
        }
    }
}
