package com.kwad.sdk.pngencrypt;

import com.kwad.sdk.pngencrypt.ChunkReader;
import java.io.Closeable;
import java.util.Arrays;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/pngencrypt/b.class */
public abstract class b implements f, Closeable {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final byte[] auD;
    private final int auE;
    private byte[] auF;
    private int auG;
    protected boolean auH;
    protected boolean auI;
    private int auJ;
    private long auK;
    private DeflatedChunksSet auL;
    private ChunkReader auM;
    private long auN;
    private ErrorBehaviour auO;
    protected boolean closed;

    public b() {
        this(n.BN());
    }

    private b(byte[] bArr) {
        this.auF = new byte[8];
        boolean z = false;
        this.auG = 0;
        this.auH = false;
        this.auI = false;
        this.closed = false;
        this.auJ = 0;
        this.auK = 0L;
        this.auO = ErrorBehaviour.STRICT;
        this.auD = bArr;
        int length = bArr == null ? 0 : bArr.length;
        this.auE = length;
        this.auH = length <= 0 ? true : z;
    }

    private static String Bo() {
        return "IHDR";
    }

    private static String Bp() {
        return "IEND";
    }

    private ChunkReader a(String str, int i, long j, boolean z) {
        return new ChunkReader(i, str, j, z ? ChunkReader.ChunkReaderMode.SKIP : ChunkReader.ChunkReaderMode.BUFFER) { // from class: com.kwad.sdk.pngencrypt.b.2
            @Override // com.kwad.sdk.pngencrypt.ChunkReader
            protected final void Bk() {
                b.this.a(this);
            }

            @Override // com.kwad.sdk.pngencrypt.ChunkReader
            protected final void a(int i2, byte[] bArr, int i3, int i4) {
                com.kwad.sdk.core.d.b.printStackTrace(new PngjException("should never happen"));
            }
        };
    }

    private static void h(byte[] bArr) {
        if (Arrays.equals(bArr, n.BN())) {
            return;
        }
        com.kwad.sdk.core.d.b.printStackTrace(new PngjException("Bad signature:" + Arrays.toString(bArr)));
    }

    protected boolean Bl() {
        return true;
    }

    public final long Bm() {
        return this.auK;
    }

    public final DeflatedChunksSet Bn() {
        return this.auL;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ChunkReader chunkReader) {
        if (this.auJ == 1 && !Bo().equals(chunkReader.Bj().awG)) {
            String str = "Bad first chunk: " + chunkReader.Bj().awG + " expected: " + Bo();
            if (this.auO.f10317c < ErrorBehaviour.SUPER_LENIENT.f10317c) {
                com.kwad.sdk.core.d.b.printStackTrace(new PngjException(str));
            } else {
                com.kwad.sdk.core.d.b.d("PNG_ENCRYPT", str);
            }
        }
        Bp();
        if (chunkReader.Bj().awG.equals(Bp())) {
            this.auI = true;
            close();
        }
    }

    @Override // com.kwad.sdk.pngencrypt.f
    public int b(byte[] bArr, int i, int i2) {
        int i3;
        long j;
        long j2;
        if (this.closed) {
            return -1;
        }
        if (i2 == 0) {
            return 0;
        }
        if (i2 < 0) {
            com.kwad.sdk.core.d.b.printStackTrace(new PngjException("This should not happen. Bad length: " + i2));
        }
        if (this.auH) {
            ChunkReader chunkReader = this.auM;
            if (chunkReader == null || chunkReader.isDone()) {
                int i4 = 8 - this.auG;
                if (i4 <= i2) {
                    i2 = i4;
                }
                System.arraycopy(bArr, i, this.auF, this.auG, i2);
                int i5 = this.auG + i2;
                this.auG = i5;
                int i6 = i2 + 0;
                this.auK += i2;
                i3 = i6;
                if (i5 == 8) {
                    this.auJ++;
                    c(n.g(this.auF, 0), com.kwad.sdk.pngencrypt.chunk.b.i(this.auF, 4), this.auK - 8);
                    this.auG = 0;
                    return i6;
                }
                return i3;
            }
            int b = this.auM.b(bArr, i, i2);
            if (b < 0) {
                return -1;
            }
            i3 = b + 0;
            j = this.auK;
            j2 = b;
        } else {
            int i7 = this.auE - this.auG;
            if (i7 <= i2) {
                i2 = i7;
            }
            System.arraycopy(bArr, i, this.auF, this.auG, i2);
            int i8 = this.auG + i2;
            this.auG = i8;
            if (i8 == this.auE) {
                h(this.auF);
                this.auG = 0;
                this.auH = true;
            }
            i3 = i2 + 0;
            j = this.auK;
            j2 = i2;
        }
        this.auK = j + j2;
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(int i, String str, long j) {
        com.kwad.sdk.core.d.b.d("PNG_ENCRYPT", "New chunk: " + str + " " + i + " off:" + j);
        if (str.length() != 4 || !com.kwad.sdk.pngencrypt.chunk.b.awE.matcher(str).matches()) {
            com.kwad.sdk.core.d.b.printStackTrace(new PngjException("Bad chunk id: " + str));
        }
        if (i < 0) {
            com.kwad.sdk.core.d.b.printStackTrace(new PngjException("Bad chunk len: " + i));
        }
        if (str.equals("IDAT")) {
            this.auN += i;
        }
        boolean Bl = Bl();
        boolean l = l(i, str);
        boolean eh = eh(str);
        DeflatedChunksSet deflatedChunksSet = this.auL;
        boolean ek = (deflatedChunksSet == null || deflatedChunksSet.isClosed()) ? false : this.auL.ek(str);
        if (!eh || l) {
            this.auM = a(str, i, j, l);
        } else {
            if (!ek) {
                DeflatedChunksSet deflatedChunksSet2 = this.auL;
                if (deflatedChunksSet2 != null && !deflatedChunksSet2.isDone()) {
                    com.kwad.sdk.core.d.b.printStackTrace(new PngjException("new IDAT-like chunk when previous was not done"));
                }
                this.auL = eg(str);
            }
            this.auM = new d(i, str, Bl, j, this.auL) { // from class: com.kwad.sdk.pngencrypt.b.1
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.kwad.sdk.pngencrypt.d, com.kwad.sdk.pngencrypt.ChunkReader
                public final void Bk() {
                    super.Bk();
                    b.this.a(this);
                }
            };
        }
        ChunkReader chunkReader = this.auM;
        if (chunkReader == null || Bl) {
            return;
        }
        chunkReader.bm(false);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        DeflatedChunksSet deflatedChunksSet = this.auL;
        if (deflatedChunksSet != null) {
            deflatedChunksSet.close();
        }
        this.closed = true;
    }

    protected abstract DeflatedChunksSet eg(String str);

    protected boolean eh(String str) {
        return false;
    }

    @Override // com.kwad.sdk.pngencrypt.f
    public final boolean isDone() {
        return this.auI;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean l(int i, String str) {
        return false;
    }
}
