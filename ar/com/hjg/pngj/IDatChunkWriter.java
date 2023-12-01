package ar.com.hjg.pngj;

import ar.com.hjg.pngj.chunks.ChunkHelper;
import ar.com.hjg.pngj.chunks.ChunkRaw;
import java.io.OutputStream;

/* loaded from: source-8756600-dex2jar.jar:ar/com/hjg/pngj/IDatChunkWriter.class */
public class IDatChunkWriter {

    /* renamed from: a  reason: collision with root package name */
    private final OutputStream f3587a;
    private final int b;

    /* renamed from: c  reason: collision with root package name */
    private byte[] f3588c;
    private int d;
    private int e;
    private long f;
    private int g;

    public void a(int i) {
        this.d += i;
        int i2 = this.e - i;
        this.e = i2;
        if (i2 < 0) {
            throw new PngjOutputException("Anomalous situation");
        }
        if (i2 == 0) {
            b();
        }
    }

    protected byte[] a() {
        return ChunkHelper.f3607c;
    }

    public final void b() {
        int i = this.d;
        if (i <= 0 || i < f()) {
            return;
        }
        ChunkRaw chunkRaw = new ChunkRaw(this.d, a(), false);
        chunkRaw.d = this.f3588c;
        chunkRaw.a(this.f3587a);
        this.f += chunkRaw.f3611a + 12;
        this.g++;
        this.d = 0;
        this.e = this.b;
        e();
    }

    public int c() {
        return this.d;
    }

    public int d() {
        return this.e;
    }

    protected void e() {
    }

    protected int f() {
        return 1;
    }

    public void g() {
        b();
        this.d = 0;
        this.f3588c = null;
    }

    public byte[] h() {
        return this.f3588c;
    }
}
