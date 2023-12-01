package com.kwad.sdk.pngencrypt.chunk;

import com.kwad.sdk.pngencrypt.PngjException;
import java.io.ByteArrayInputStream;
import java.util.zip.CRC32;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/pngencrypt/chunk/d.class */
public final class d {
    public final byte[] awF;
    public final String awG;
    private CRC32 awJ;
    public final int len;
    public byte[] data = null;
    private long awH = 0;
    public byte[] awI = new byte[4];

    public d(int i, String str, boolean z) {
        this.len = i;
        this.awG = str;
        this.awF = b.el(str);
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= 4) {
                break;
            }
            byte[] bArr = this.awF;
            if (bArr[i3] < 65 || bArr[i3] > 122 || (bArr[i3] > 90 && bArr[i3] < 97)) {
                com.kwad.sdk.core.d.b.printStackTrace(new PngjException("Bad id chunk: must be ascii letters " + str));
            }
            i2 = i3 + 1;
        }
        if (z) {
            BU();
        }
    }

    private void BU() {
        byte[] bArr = this.data;
        if (bArr == null || bArr.length < this.len) {
            this.data = new byte[this.len];
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final ByteArrayInputStream BV() {
        return new ByteArrayInputStream(this.data);
    }

    public final long BW() {
        return this.awH;
    }

    public final void ae(long j) {
        this.awH = j;
    }

    public final void bo(boolean z) {
        int value = (int) this.awJ.getValue();
        int g = com.kwad.sdk.pngencrypt.n.g(this.awI, 0);
        if (value != g) {
            String format = String.format("Bad CRC in chunk: %s (offset:%d). Expected:%x Got:%x", this.awG, Long.valueOf(this.awH), Integer.valueOf(g), Integer.valueOf(value));
            if (z) {
                com.kwad.sdk.core.d.b.printStackTrace(new PngjException(format));
            } else {
                com.kwad.sdk.core.d.b.d("PNG_ENCRYPT", format);
            }
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            d dVar = (d) obj;
            String str = this.awG;
            if (str == null) {
                if (dVar.awG != null) {
                    return false;
                }
            } else if (!str.equals(dVar.awG)) {
                return false;
            }
            return this.awH == dVar.awH;
        }
        return false;
    }

    public final void f(byte[] bArr, int i, int i2) {
        if (this.awJ == null) {
            this.awJ = new CRC32();
        }
        this.awJ.update(bArr, i, i2);
    }

    public final int hashCode() {
        String str = this.awG;
        int hashCode = str == null ? 0 : str.hashCode();
        long j = this.awH;
        return ((hashCode + 31) * 31) + ((int) (j ^ (j >>> 32)));
    }

    public final String toString() {
        return "chunkid=" + b.i(this.awF) + " len=" + this.len;
    }
}
