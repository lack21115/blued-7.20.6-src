package ar.com.hjg.pngj;

import ar.com.hjg.pngj.chunks.ChunkRaw;

/* loaded from: source-8756600-dex2jar.jar:ar/com/hjg/pngj/ChunkReader.class */
public abstract class ChunkReader {

    /* renamed from: a  reason: collision with root package name */
    public final ChunkReaderMode f3612a;

    /* renamed from: c  reason: collision with root package name */
    private final ChunkRaw f3613c;
    private boolean d;
    protected int b = 0;
    private int e = 0;

    /* loaded from: source-8756600-dex2jar.jar:ar/com/hjg/pngj/ChunkReader$ChunkReaderMode.class */
    public enum ChunkReaderMode {
        BUFFER,
        PROCESS,
        SKIP
    }

    public ChunkReader(int i, String str, long j, ChunkReaderMode chunkReaderMode) {
        if (chunkReaderMode == null || str.length() != 4 || i < 0) {
            throw new PngjExceptionInternal("Bad chunk paramenters: " + chunkReaderMode);
        }
        this.f3612a = chunkReaderMode;
        ChunkRaw chunkRaw = new ChunkRaw(i, str, chunkReaderMode == ChunkReaderMode.BUFFER);
        this.f3613c = chunkRaw;
        chunkRaw.a(j);
        this.d = chunkReaderMode != ChunkReaderMode.SKIP;
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x005e, code lost:
        if (r6.e == 0) goto L43;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int a(byte[] r7, int r8, int r9) {
        /*
            Method dump skipped, instructions count: 378
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: ar.com.hjg.pngj.ChunkReader.a(byte[], int, int):int");
    }

    public ChunkRaw a() {
        return this.f3613c;
    }

    protected abstract void a(int i, byte[] bArr, int i2, int i3);

    public void a(boolean z) {
        if (this.b != 0 && z && !this.d) {
            throw new PngjException("too late!");
        }
        this.d = z;
    }

    public final boolean b() {
        return this.e == 4;
    }

    protected abstract void c();

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            ChunkReader chunkReader = (ChunkReader) obj;
            ChunkRaw chunkRaw = this.f3613c;
            return chunkRaw == null ? chunkReader.f3613c == null : chunkRaw.equals(chunkReader.f3613c);
        }
        return false;
    }

    public int hashCode() {
        ChunkRaw chunkRaw = this.f3613c;
        return 31 + (chunkRaw == null ? 0 : chunkRaw.hashCode());
    }

    public String toString() {
        return this.f3613c.toString();
    }
}
