package ar.com.hjg.pngj;

import ar.com.hjg.pngj.ChunkReader;
import ar.com.hjg.pngj.chunks.ChunkFactory;
import ar.com.hjg.pngj.chunks.ChunkHelper;
import ar.com.hjg.pngj.chunks.ChunkLoadBehaviour;
import ar.com.hjg.pngj.chunks.ChunksList;
import ar.com.hjg.pngj.chunks.PngChunk;
import ar.com.hjg.pngj.chunks.PngChunkIHDR;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* loaded from: source-8756600-dex2jar.jar:ar/com/hjg/pngj/ChunkSeqReaderPng.class */
public class ChunkSeqReaderPng extends ChunkSeqReader {

    /* renamed from: a  reason: collision with root package name */
    protected ImageInfo f3573a;

    /* renamed from: c  reason: collision with root package name */
    protected ImageInfo f3574c;
    protected Deinterlacer d;
    protected final boolean g;
    protected int e = -1;
    protected ChunksList f = null;
    private long h = 0;
    private boolean i = true;
    private boolean j = false;
    private Set<String> k = new HashSet();
    private long l = 0;
    private long m = 0;
    private long n = 0;
    private ChunkLoadBehaviour p = ChunkLoadBehaviour.LOAD_CHUNK_ALWAYS;
    private IChunkFactory o = new ChunkFactory();

    /* renamed from: ar.com.hjg.pngj.ChunkSeqReaderPng$1  reason: invalid class name */
    /* loaded from: source-8756600-dex2jar.jar:ar/com/hjg/pngj/ChunkSeqReaderPng$1.class */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f3575a;

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:7:0x0020 -> B:11:0x0014). Please submit an issue!!! */
        static {
            int[] iArr = new int[ChunkLoadBehaviour.values().length];
            f3575a = iArr;
            try {
                iArr[ChunkLoadBehaviour.LOAD_CHUNK_IF_SAFE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f3575a[ChunkLoadBehaviour.LOAD_CHUNK_NEVER.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    public ChunkSeqReaderPng(boolean z) {
        this.g = z;
    }

    private void f(String str) {
        if (str.equals("IHDR")) {
            if (this.e < 0) {
                this.e = 0;
                return;
            }
            throw new PngjInputException("unexpected chunk " + str);
        } else if (str.equals("PLTE")) {
            int i = this.e;
            if (i == 0 || i == 1) {
                this.e = 2;
                return;
            }
            throw new PngjInputException("unexpected chunk " + str);
        } else if (str.equals("IDAT")) {
            int i2 = this.e;
            if (i2 >= 0 && i2 <= 4) {
                this.e = 4;
                return;
            }
            throw new PngjInputException("unexpected chunk " + str);
        } else if (str.equals("IEND")) {
            if (this.e >= 4) {
                this.e = 6;
                return;
            }
            throw new PngjInputException("unexpected chunk " + str);
        } else {
            int i3 = this.e;
            if (i3 <= 1) {
                this.e = 1;
            } else if (i3 <= 3) {
                this.e = 3;
            } else {
                this.e = 5;
            }
        }
    }

    @Override // ar.com.hjg.pngj.ChunkSeqReader, ar.com.hjg.pngj.IBytesConsumer
    public int a(byte[] bArr, int i, int i2) {
        return super.a(bArr, i, i2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // ar.com.hjg.pngj.ChunkSeqReader
    public void a(int i, String str, long j) {
        f(str);
        super.a(i, str, j);
    }

    public void a(long j) {
        this.l = j;
    }

    @Override // ar.com.hjg.pngj.ChunkSeqReader
    public void a(ChunkReader chunkReader) {
        super.a(chunkReader);
        if (chunkReader.a().f3612c.equals("IHDR")) {
            PngChunkIHDR pngChunkIHDR = new PngChunkIHDR(null);
            pngChunkIHDR.a(chunkReader.a());
            ImageInfo l = pngChunkIHDR.l();
            this.f3573a = l;
            this.f3574c = l;
            if (pngChunkIHDR.k()) {
                this.d = new Deinterlacer(this.f3574c);
            }
            this.f = new ChunksList(this.f3573a);
        }
        if (chunkReader.f3564a == ChunkReader.ChunkReaderMode.BUFFER && e(chunkReader.a().f3612c)) {
            this.h += chunkReader.a().f3611a;
        }
        if (chunkReader.f3564a == ChunkReader.ChunkReaderMode.BUFFER || this.j) {
            this.f.a(this.o.a(chunkReader.a(), k()), this.e);
        }
        if (a()) {
            j();
        }
    }

    public void a(ImageInfo imageInfo) {
        if (!imageInfo.equals(this.f3574c)) {
            this.f3574c = imageInfo;
        }
        if (this.d != null) {
            this.d = new Deinterlacer(this.f3574c);
        }
    }

    @Override // ar.com.hjg.pngj.ChunkSeqReader
    protected boolean a(int i, String str) {
        return this.i;
    }

    @Override // ar.com.hjg.pngj.ChunkSeqReader
    protected boolean a(String str) {
        return str.equals("IDAT");
    }

    @Override // ar.com.hjg.pngj.ChunkSeqReader
    protected DeflatedChunksSet b(String str) {
        IdatSet idatSet = new IdatSet(str, n(), this.d);
        idatSet.a(this.g);
        return idatSet;
    }

    public void b(long j) {
        this.m = j;
    }

    @Override // ar.com.hjg.pngj.ChunkSeqReader
    public boolean b(int i, String str) {
        if (super.b(i, str)) {
            return true;
        }
        if (ChunkHelper.b(str)) {
            return false;
        }
        if (this.l > 0 && i + b() > this.l) {
            throw new PngjInputException("Maximum total bytes to read exceeeded: " + this.l + " offset:" + b() + " len=" + i);
        } else if (this.k.contains(str)) {
            return true;
        } else {
            long j = this.m;
            if (j <= 0 || i <= j) {
                long j2 = this.n;
                if (j2 <= 0 || i <= j2 - this.h) {
                    int i2 = AnonymousClass1.f3575a[this.p.ordinal()];
                    return i2 != 1 ? i2 == 2 : !ChunkHelper.d(str);
                }
                return true;
            }
            return true;
        }
    }

    public void c(long j) {
        this.n = j;
    }

    public void c(String str) {
        this.k.add(str);
    }

    @Override // ar.com.hjg.pngj.ChunkSeqReader
    public void d() {
        if (this.e != 6) {
            this.e = 6;
        }
        super.d();
    }

    public void d(String str) {
        this.k.remove(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean e(String str) {
        return !ChunkHelper.b(str);
    }

    public int g() {
        return this.e;
    }

    public boolean h() {
        return g() < 4;
    }

    public IdatSet i() {
        DeflatedChunksSet c2 = c();
        if (c2 instanceof IdatSet) {
            return (IdatSet) c2;
        }
        return null;
    }

    protected void j() {
    }

    public ImageInfo k() {
        return this.f3573a;
    }

    public Deinterlacer l() {
        return this.d;
    }

    public List<PngChunk> m() {
        return this.f.a();
    }

    public ImageInfo n() {
        return this.f3574c;
    }
}
