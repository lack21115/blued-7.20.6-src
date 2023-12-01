package ar.com.hjg.pngj.chunks;

import ar.com.hjg.pngj.PngHelperInternal;
import ar.com.hjg.pngj.PngjBadCrcException;
import ar.com.hjg.pngj.PngjException;
import ar.com.hjg.pngj.PngjOutputException;
import java.io.ByteArrayInputStream;
import java.io.OutputStream;
import java.util.zip.CRC32;

/* loaded from: source-8756600-dex2jar.jar:ar/com/hjg/pngj/chunks/ChunkRaw.class */
public class ChunkRaw {

    /* renamed from: a  reason: collision with root package name */
    public final int f3611a;
    public final byte[] b;

    /* renamed from: c  reason: collision with root package name */
    public final String f3612c;
    public byte[] d;
    public byte[] e;
    private long f;
    private CRC32 g;

    public ChunkRaw(int i, String str, boolean z) {
        this.d = null;
        this.f = 0L;
        this.e = new byte[4];
        this.f3611a = i;
        this.f3612c = str;
        this.b = ChunkHelper.a(str);
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= 4) {
                if (z) {
                    a();
                    return;
                }
                return;
            }
            byte[] bArr = this.b;
            if (bArr[i3] < 65 || bArr[i3] > 122 || (bArr[i3] > 90 && bArr[i3] < 97)) {
                break;
            }
            i2 = i3 + 1;
        }
        throw new PngjException("Bad id chunk: must be ascii letters " + str);
    }

    public ChunkRaw(int i, byte[] bArr, boolean z) {
        this(i, ChunkHelper.a(bArr), z);
    }

    private void e() {
        CRC32 crc32 = new CRC32();
        this.g = crc32;
        crc32.update(this.b, 0, 4);
        int i = this.f3611a;
        if (i > 0) {
            this.g.update(this.d, 0, i);
        }
        PngHelperInternal.a((int) this.g.getValue(), this.e, 0);
    }

    public void a() {
        byte[] bArr = this.d;
        if (bArr == null || bArr.length < this.f3611a) {
            this.d = new byte[this.f3611a];
        }
    }

    public void a(long j) {
        this.f = j;
    }

    public void a(OutputStream outputStream) {
        b(outputStream);
        int i = this.f3611a;
        if (i > 0) {
            byte[] bArr = this.d;
            if (bArr == null) {
                throw new PngjOutputException("cannot write chunk, raw chunk data is null [" + this.f3612c + "]");
            }
            PngHelperInternal.a(outputStream, bArr, 0, i);
        }
        e();
        c(outputStream);
    }

    public void a(byte[] bArr, int i, int i2) {
        if (this.g == null) {
            this.g = new CRC32();
        }
        this.g.update(bArr, i, i2);
    }

    public void b() {
        int value = (int) this.g.getValue();
        int c2 = PngHelperInternal.c(this.e, 0);
        if (value == c2) {
            return;
        }
        throw new PngjBadCrcException("chunk: " + toString() + " expected=" + c2 + " read=" + value);
    }

    public void b(OutputStream outputStream) {
        if (this.b.length == 4) {
            PngHelperInternal.a(outputStream, this.f3611a);
            PngHelperInternal.a(outputStream, this.b);
            return;
        }
        throw new PngjOutputException("bad chunkid [" + this.f3612c + "]");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ByteArrayInputStream c() {
        return new ByteArrayInputStream(this.d);
    }

    public void c(OutputStream outputStream) {
        PngHelperInternal.a(outputStream, this.e, 0, 4);
    }

    public long d() {
        return this.f;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            ChunkRaw chunkRaw = (ChunkRaw) obj;
            String str = this.f3612c;
            if (str == null) {
                if (chunkRaw.f3612c != null) {
                    return false;
                }
            } else if (!str.equals(chunkRaw.f3612c)) {
                return false;
            }
            return this.f == chunkRaw.f;
        }
        return false;
    }

    public int hashCode() {
        String str = this.f3612c;
        int hashCode = str == null ? 0 : str.hashCode();
        long j = this.f;
        return ((hashCode + 31) * 31) + ((int) (j ^ (j >>> 32)));
    }

    public String toString() {
        return "chunkid=" + ChunkHelper.a(this.b) + " len=" + this.f3611a;
    }
}
