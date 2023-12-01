package com.kwad.sdk.pngencrypt;

import com.kwad.sdk.pngencrypt.ChunkReader;
import com.kwad.sdk.pngencrypt.chunk.ChunkLoadBehaviour;
import java.util.HashSet;
import java.util.Set;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/pngencrypt/c.class */
public final class c extends b {
    protected k auQ;
    protected k auR;
    protected e auS;
    protected int auT = -1;
    protected com.kwad.sdk.pngencrypt.chunk.e auU = null;
    private long auW = 0;
    private boolean auX = true;
    private boolean auY = false;
    private Set<String> auZ = new HashSet();
    private long ava = 0;
    private long avb = 0;
    private long avc = 0;
    private ChunkLoadBehaviour ave = ChunkLoadBehaviour.LOAD_CHUNK_ALWAYS;
    protected final boolean auV = false;
    private g avd = new com.kwad.sdk.pngencrypt.chunk.a();

    /* renamed from: com.kwad.sdk.pngencrypt.c$1  reason: invalid class name */
    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/pngencrypt/c$1.class */
    static final /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] avf;

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:7:0x0020 -> B:11:0x0014). Please submit an issue!!! */
        static {
            int[] iArr = new int[ChunkLoadBehaviour.values().length];
            avf = iArr;
            try {
                iArr[ChunkLoadBehaviour.LOAD_CHUNK_IF_SAFE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                avf[ChunkLoadBehaviour.LOAD_CHUNK_NEVER.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
        }
    }

    public c(boolean z) {
    }

    private int Bq() {
        return this.auT;
    }

    private k Bv() {
        return this.auR;
    }

    private void ei(String str) {
        if (str.equals("IHDR")) {
            if (this.auT < 0) {
                this.auT = 0;
                return;
            }
            com.kwad.sdk.core.d.b.printStackTrace(new PngjException("unexpected chunk " + str));
        } else if (str.equals("PLTE")) {
            int i = this.auT;
            if (i == 0 || i == 1) {
                this.auT = 2;
                return;
            }
            com.kwad.sdk.core.d.b.printStackTrace(new PngjException("unexpected chunk here " + str));
        } else if (str.equals("IDAT")) {
            int i2 = this.auT;
            if (i2 >= 0 && i2 <= 4) {
                this.auT = 4;
                return;
            }
            com.kwad.sdk.core.d.b.printStackTrace(new PngjException("unexpected chunk " + str));
        } else if (str.equals("IEND")) {
            if (this.auT >= 4) {
                this.auT = 6;
                return;
            }
            com.kwad.sdk.core.d.b.printStackTrace(new PngjException("unexpected chunk " + str));
        } else {
            int i3 = this.auT;
            if (i3 <= 1) {
                this.auT = 1;
            } else if (i3 <= 3) {
                this.auT = 3;
            } else {
                this.auT = 5;
            }
        }
    }

    private static boolean ej(String str) {
        return !com.kwad.sdk.pngencrypt.chunk.b.em(str);
    }

    @Override // com.kwad.sdk.pngencrypt.b
    protected final boolean Bl() {
        return this.auX;
    }

    public final boolean Br() {
        return Bq() < 4;
    }

    public final j Bs() {
        DeflatedChunksSet Bn = Bn();
        if (Bn instanceof j) {
            return (j) Bn;
        }
        return null;
    }

    public final k Bt() {
        return this.auQ;
    }

    public final e Bu() {
        return this.auS;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.pngencrypt.b
    public final void a(ChunkReader chunkReader) {
        super.a(chunkReader);
        if (chunkReader.Bj().awG.equals("IHDR")) {
            com.kwad.sdk.pngencrypt.chunk.i iVar = new com.kwad.sdk.pngencrypt.chunk.i(null);
            iVar.a(chunkReader.Bj());
            k Ce = iVar.Ce();
            this.auQ = Ce;
            this.auR = Ce;
            if (iVar.Cc()) {
                this.auS = new e(this.auR);
            }
            this.auU = new com.kwad.sdk.pngencrypt.chunk.e(this.auQ);
        }
        if (chunkReader.aux == ChunkReader.ChunkReaderMode.BUFFER && ej(chunkReader.Bj().awG)) {
            this.auW += chunkReader.Bj().len;
        }
        if (chunkReader.aux == ChunkReader.ChunkReaderMode.BUFFER || this.auY) {
            try {
                this.auU.a(this.avd.a(chunkReader.Bj(), Bt()), this.auT);
            } catch (PngjException e) {
                throw e;
            }
        }
    }

    public final void ab(long j) {
        this.ava = j;
    }

    public final void ac(long j) {
        this.avb = j;
    }

    public final void ad(long j) {
        this.avc = j;
    }

    @Override // com.kwad.sdk.pngencrypt.b, com.kwad.sdk.pngencrypt.f
    public final int b(byte[] bArr, int i, int i2) {
        return super.b(bArr, i, i2);
    }

    public final void bn(boolean z) {
        this.auX = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.pngencrypt.b
    public final void c(int i, String str, long j) {
        ei(str);
        super.c(i, str, j);
    }

    @Override // com.kwad.sdk.pngencrypt.b, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        if (this.auT != 6) {
            this.auT = 6;
        }
        super.close();
    }

    @Override // com.kwad.sdk.pngencrypt.b
    protected final DeflatedChunksSet eg(String str) {
        return new j(str, this.auV, Bv(), this.auS);
    }

    @Override // com.kwad.sdk.pngencrypt.b
    protected final boolean eh(String str) {
        return str.equals("IDAT");
    }

    @Override // com.kwad.sdk.pngencrypt.b
    public final boolean l(int i, String str) {
        if (super.l(i, str)) {
            return true;
        }
        if (this.ava > 0 && i + Bm() > this.ava) {
            com.kwad.sdk.core.d.b.printStackTrace(new PngjException("Maximum total bytes to read exceeeded: " + this.ava + " offset:" + Bm() + " len=" + i));
        }
        if (this.auZ.contains(str)) {
            return true;
        }
        if (com.kwad.sdk.pngencrypt.chunk.b.em(str)) {
            return false;
        }
        long j = this.avb;
        if (j <= 0 || i <= j) {
            long j2 = this.avc;
            if (j2 <= 0 || i <= j2 - this.auW) {
                int i2 = AnonymousClass1.avf[this.ave.ordinal()];
                return i2 != 1 ? i2 == 2 : !com.kwad.sdk.pngencrypt.chunk.b.eo(str);
            }
            return true;
        }
        return true;
    }
}
