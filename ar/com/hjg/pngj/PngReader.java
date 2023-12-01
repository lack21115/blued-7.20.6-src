package ar.com.hjg.pngj;

import ar.com.hjg.pngj.chunks.ChunksList;
import ar.com.hjg.pngj.chunks.PngMetadata;
import java.io.File;
import java.io.InputStream;
import java.util.logging.Logger;

/* loaded from: source-8756600-dex2jar.jar:ar/com/hjg/pngj/PngReader.class */
public class PngReader {

    /* renamed from: a  reason: collision with root package name */
    public final ImageInfo f3647a;
    public final boolean b;

    /* renamed from: c  reason: collision with root package name */
    protected final ChunkSeqReaderPng f3648c;
    protected final BufferedStreamFeeder d;
    protected final PngMetadata e;
    protected int f;
    private IImageLineSetFactory<? extends IImageLine> g;

    public PngReader(File file) {
        this(PngHelperInternal.a(file), true);
    }

    public PngReader(InputStream inputStream, boolean z) {
        this.f = -1;
        BufferedStreamFeeder bufferedStreamFeeder = new BufferedStreamFeeder(inputStream);
        this.d = bufferedStreamFeeder;
        bufferedStreamFeeder.a(z);
        this.f3648c = f();
        try {
            boolean z2 = true;
            this.d.b(true);
            if (!this.d.b(this.f3648c, 36)) {
                throw new PngjInputException("error reading first 21 bytes");
            }
            this.f3647a = this.f3648c.k();
            if (this.f3648c.l() == null) {
                z2 = false;
            }
            this.b = z2;
            b(5024024L);
            a(901001001L);
            c(2024024L);
            this.f3648c.c("fdAT");
            this.f3648c.c("fcTL");
            this.e = new PngMetadata(this.f3648c.f);
            a(ImageLineSetDefault.a());
            this.f = -1;
        } catch (RuntimeException e) {
            this.d.b();
            this.f3648c.d();
            throw e;
        }
    }

    public ChunksList a(boolean z) {
        if (z && this.f3648c.h()) {
            a();
        }
        return this.f3648c.f;
    }

    protected void a() {
        while (this.f3648c.e < 4) {
            if (this.d.a(this.f3648c) <= 0) {
                throw new PngjInputException("premature ending reading first chunks");
            }
        }
    }

    public void a(long j) {
        this.f3648c.a(j);
    }

    public void a(IImageLineSetFactory<? extends IImageLine> iImageLineSetFactory) {
        this.g = iImageLineSetFactory;
    }

    public void a(String str) {
        this.f3648c.d(str);
    }

    public ChunksList b() {
        return a(true);
    }

    public void b(long j) {
        this.f3648c.c(j);
    }

    public void c() {
        try {
            if (this.f3648c.h()) {
                a();
            }
            if (this.f3648c.i() != null && !this.f3648c.i().d()) {
                this.f3648c.i().h();
            }
            do {
                if (this.f3648c.a()) {
                    break;
                }
            } while (this.d.a(this.f3648c) > 0);
        } finally {
            d();
        }
    }

    public void c(long j) {
        this.f3648c.b(j);
    }

    public void d() {
        try {
            if (this.f3648c != null) {
                this.f3648c.d();
            }
        } catch (Exception e) {
            Logger logger = PngHelperInternal.f3645a;
            logger.warning("error closing chunk sequence:" + e.getMessage());
        }
        BufferedStreamFeeder bufferedStreamFeeder = this.d;
        if (bufferedStreamFeeder != null) {
            bufferedStreamFeeder.b();
        }
    }

    public ChunkSeqReaderPng e() {
        return this.f3648c;
    }

    protected ChunkSeqReaderPng f() {
        return new ChunkSeqReaderPng(false);
    }

    public String toString() {
        return this.f3647a.toString() + " interlaced=" + this.b;
    }
}
