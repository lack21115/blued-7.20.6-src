package ar.com.hjg.pngj;

import ar.com.hjg.pngj.ChunkReader;
import ar.com.hjg.pngj.chunks.ChunkHelper;
import java.util.Arrays;

/* loaded from: source-8756600-dex2jar.jar:ar/com/hjg/pngj/ChunkSeqReader.class */
public class ChunkSeqReader implements IBytesConsumer {

    /* renamed from: a  reason: collision with root package name */
    private byte[] f3617a;
    protected final boolean b;

    /* renamed from: c  reason: collision with root package name */
    private int f3618c;
    private boolean d;
    private boolean e;
    private int f;
    private long g;
    private DeflatedChunksSet h;
    private ChunkReader i;
    private long j;

    public ChunkSeqReader() {
        this(true);
    }

    public ChunkSeqReader(boolean z) {
        this.f3617a = new byte[8];
        this.f3618c = 0;
        this.d = false;
        this.e = false;
        this.f = 0;
        this.g = 0L;
        this.b = z;
        this.d = !z;
    }

    @Override // ar.com.hjg.pngj.IBytesConsumer
    public int a(byte[] bArr, int i, int i2) {
        int i3;
        if (this.e) {
            return -1;
        }
        if (i2 == 0) {
            return 0;
        }
        if (i2 < 0) {
            throw new PngjInputException("Bad len: " + i2);
        }
        if (this.d) {
            ChunkReader chunkReader = this.i;
            if (chunkReader != null && !chunkReader.b()) {
                int a2 = this.i.a(bArr, i, i2);
                this.g += a2;
                return a2 + 0;
            }
            int i4 = 8 - this.f3618c;
            if (i4 <= i2) {
                i2 = i4;
            }
            System.arraycopy((Object) bArr, i, (Object) this.f3617a, this.f3618c, i2);
            int i5 = this.f3618c + i2;
            this.f3618c = i5;
            int i6 = 0 + i2;
            this.g += i2;
            i3 = i6;
            if (i5 == 8) {
                this.f++;
                a(PngHelperInternal.c(this.f3617a, 0), ChunkHelper.a(this.f3617a, 4, 4), this.g - 8);
                this.f3618c = 0;
                return i6;
            }
        } else {
            int i7 = 8 - this.f3618c;
            if (i7 <= i2) {
                i2 = i7;
            }
            System.arraycopy((Object) bArr, i, (Object) this.f3617a, this.f3618c, i2);
            int i8 = this.f3618c + i2;
            this.f3618c = i8;
            if (i8 == 8) {
                a(this.f3617a);
                this.f3618c = 0;
                this.d = true;
            }
            i3 = 0 + i2;
            this.g += i2;
        }
        return i3;
    }

    protected ChunkReader a(String str, int i, long j, boolean z) {
        return new ChunkReader(i, str, j, z ? ChunkReader.ChunkReaderMode.SKIP : ChunkReader.ChunkReaderMode.BUFFER) { // from class: ar.com.hjg.pngj.ChunkSeqReader.2
            @Override // ar.com.hjg.pngj.ChunkReader
            protected void a(int i2, byte[] bArr, int i3, int i4) {
                throw new PngjExceptionInternal("should never happen");
            }

            @Override // ar.com.hjg.pngj.ChunkReader
            protected void c() {
                ChunkSeqReader.this.a(this);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(int i, String str, long j) {
        if (str.equals("IDAT")) {
            this.j += i;
        }
        boolean a2 = a(i, str);
        boolean b = b(i, str);
        boolean a3 = a(str);
        DeflatedChunksSet deflatedChunksSet = this.h;
        boolean a4 = deflatedChunksSet != null ? deflatedChunksSet.a(str) : false;
        if (!a3 || b) {
            ChunkReader a5 = a(str, i, j, b);
            this.i = a5;
            if (a2) {
                return;
            }
            a5.a(false);
            return;
        }
        if (!a4) {
            DeflatedChunksSet deflatedChunksSet2 = this.h;
            if (deflatedChunksSet2 != null && !deflatedChunksSet2.d()) {
                throw new PngjInputException("new IDAT-like chunk when previous was not done");
            }
            this.h = b(str);
        }
        this.i = new DeflatedChunkReader(i, str, a2, j, this.h) { // from class: ar.com.hjg.pngj.ChunkSeqReader.1
            @Override // ar.com.hjg.pngj.DeflatedChunkReader, ar.com.hjg.pngj.ChunkReader
            protected void c() {
                super.c();
                ChunkSeqReader.this.a(this);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ChunkReader chunkReader) {
        String e;
        if (this.f != 1 || (e = e()) == null || e.equals(chunkReader.a().f3660c)) {
            if (chunkReader.a().f3660c.equals(f())) {
                this.e = true;
                return;
            }
            return;
        }
        throw new PngjInputException("Bad first chunk: " + chunkReader.a().f3660c + " expected: " + e());
    }

    protected void a(byte[] bArr) {
        if (!Arrays.equals(bArr, PngHelperInternal.a())) {
            throw new PngjInputException("Bad PNG signature");
        }
    }

    public boolean a() {
        return this.e;
    }

    protected boolean a(int i, String str) {
        return true;
    }

    protected boolean a(String str) {
        return false;
    }

    public long b() {
        return this.g;
    }

    protected DeflatedChunksSet b(String str) {
        return new DeflatedChunksSet(str, 1024, 1024);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean b(int i, String str) {
        return false;
    }

    public boolean b(byte[] bArr, int i, int i2) {
        while (i2 > 0) {
            int a2 = a(bArr, i, i2);
            if (a2 < 1) {
                return false;
            }
            i2 -= a2;
            i += a2;
        }
        return true;
    }

    public DeflatedChunksSet c() {
        return this.h;
    }

    public void d() {
        DeflatedChunksSet deflatedChunksSet = this.h;
        if (deflatedChunksSet != null) {
            deflatedChunksSet.g();
        }
        this.e = true;
    }

    protected String e() {
        return "IHDR";
    }

    protected String f() {
        return "IEND";
    }
}
