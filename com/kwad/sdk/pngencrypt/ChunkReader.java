package com.kwad.sdk.pngencrypt;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/pngencrypt/ChunkReader.class */
public abstract class ChunkReader implements f {
    private boolean auB;
    public final ChunkReaderMode aux;
    private final com.kwad.sdk.pngencrypt.chunk.d auy;
    protected int auz = 0;
    private int auA = 0;
    protected ErrorBehaviour auC = ErrorBehaviour.STRICT;

    /* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/pngencrypt/ChunkReader$ChunkReaderMode.class */
    public enum ChunkReaderMode {
        BUFFER,
        PROCESS,
        SKIP
    }

    public ChunkReader(int i, String str, long j, ChunkReaderMode chunkReaderMode) {
        if (chunkReaderMode == null || str.length() != 4 || i < 0) {
            com.kwad.sdk.core.d.b.printStackTrace(new PngjException("Bad chunk paramenters: " + chunkReaderMode));
        }
        this.aux = chunkReaderMode;
        com.kwad.sdk.pngencrypt.chunk.d dVar = new com.kwad.sdk.pngencrypt.chunk.d(i, str, chunkReaderMode == ChunkReaderMode.BUFFER);
        this.auy = dVar;
        dVar.ae(j);
        this.auB = chunkReaderMode != ChunkReaderMode.SKIP;
    }

    public final com.kwad.sdk.pngencrypt.chunk.d Bj() {
        return this.auy;
    }

    protected abstract void Bk();

    protected abstract void a(int i, byte[] bArr, int i2, int i3);

    /* JADX WARN: Code restructure failed: missing block: B:22:0x006d, code lost:
        if (r6.auA == 0) goto L52;
     */
    @Override // com.kwad.sdk.pngencrypt.f
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int b(byte[] r7, int r8, int r9) {
        /*
            Method dump skipped, instructions count: 421
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.pngencrypt.ChunkReader.b(byte[], int, int):int");
    }

    public final void bm(boolean z) {
        this.auB = false;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            com.kwad.sdk.pngencrypt.chunk.d dVar = this.auy;
            com.kwad.sdk.pngencrypt.chunk.d dVar2 = ((ChunkReader) obj).auy;
            return dVar == null ? dVar2 == null : dVar.equals(dVar2);
        }
        return false;
    }

    public int hashCode() {
        com.kwad.sdk.pngencrypt.chunk.d dVar = this.auy;
        return (dVar == null ? 0 : dVar.hashCode()) + 31;
    }

    @Override // com.kwad.sdk.pngencrypt.f
    public final boolean isDone() {
        return this.auA == 4;
    }

    public String toString() {
        return this.auy.toString();
    }
}
