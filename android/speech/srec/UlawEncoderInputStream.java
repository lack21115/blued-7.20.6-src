package android.speech.srec;

import com.blued.das.live.LiveProtos;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: source-9557208-dex2jar.jar:android/speech/srec/UlawEncoderInputStream.class */
public final class UlawEncoderInputStream extends InputStream {
    private static final int MAX_ULAW = 8192;
    private static final int SCALE_BITS = 16;
    private static final String TAG = "UlawEncoderInputStream";
    private InputStream mIn;
    private int mMax;
    private final byte[] mBuf = new byte[1024];
    private int mBufCount = 0;
    private final byte[] mOneByte = new byte[1];

    public UlawEncoderInputStream(InputStream inputStream, int i) {
        this.mMax = 0;
        this.mIn = inputStream;
        this.mMax = i;
    }

    public static void encode(byte[] bArr, int i, byte[] bArr2, int i2, int i3, int i4) {
        int i5 = i4;
        if (i4 <= 0) {
            i5 = 8192;
        }
        int i6 = 536870912 / i5;
        int i7 = 0;
        while (i7 < i3) {
            int i8 = i + 1;
            int i9 = i8 + 1;
            int i10 = (((bArr[i] & 255) + (bArr[i8] << 8)) * i6) >> 16;
            bArr2[i2] = (byte) (i10 >= 0 ? i10 <= 0 ? 255 : i10 <= 30 ? ((30 - i10) >> 1) + 240 : i10 <= 94 ? ((94 - i10) >> 2) + 224 : i10 <= 222 ? ((222 - i10) >> 3) + 208 : i10 <= 478 ? ((LiveProtos.Event.LIVE_DOWN_COLLECTION_CLICK_VALUE - i10) >> 4) + 192 : i10 <= 990 ? ((990 - i10) >> 5) + 176 : i10 <= 2014 ? ((2014 - i10) >> 6) + 160 : i10 <= 4062 ? ((4062 - i10) >> 7) + 144 : i10 <= 8158 ? ((8158 - i10) >> 8) + 128 : 128 : -1 <= i10 ? 127 : -31 <= i10 ? ((i10 + 31) >> 1) + 112 : -95 <= i10 ? ((i10 + 95) >> 2) + 96 : -223 <= i10 ? ((i10 + 223) >> 3) + 80 : -479 <= i10 ? ((i10 + LiveProtos.Event.LIVE_DOWN_COLLECTION_FEATURE_CLICK_VALUE) >> 4) + 64 : -991 <= i10 ? ((i10 + 991) >> 5) + 48 : -2015 <= i10 ? ((i10 + 2015) >> 6) + 32 : -4063 <= i10 ? ((i10 + 4063) >> 7) + 16 : -8159 <= i10 ? ((i10 + 8159) >> 8) + 0 : 0);
            i7++;
            i2++;
            i = i9;
        }
    }

    public static int maxAbsPcm(byte[] bArr, int i, int i2) {
        int i3 = 0;
        int i4 = 0;
        while (i4 < i2) {
            int i5 = i + 1;
            int i6 = i5 + 1;
            int i7 = (bArr[i] & 255) + (bArr[i5] << 8);
            int i8 = i7;
            if (i7 < 0) {
                i8 = -i7;
            }
            int i9 = i3;
            if (i8 > i3) {
                i9 = i8;
            }
            i4++;
            i3 = i9;
            i = i6;
        }
        return i3;
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        return (this.mIn.available() + this.mBufCount) / 2;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.mIn != null) {
            InputStream inputStream = this.mIn;
            this.mIn = null;
            inputStream.close();
        }
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        if (read(this.mOneByte, 0, 1) == -1) {
            return -1;
        }
        return this.mOneByte[0] & 255;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        if (this.mIn == null) {
            throw new IllegalStateException("not open");
        }
        while (this.mBufCount < 2) {
            int read = this.mIn.read(this.mBuf, this.mBufCount, Math.min(i2 * 2, this.mBuf.length - this.mBufCount));
            if (read == -1) {
                return -1;
            }
            this.mBufCount += read;
        }
        int min = Math.min(this.mBufCount / 2, i2);
        encode(this.mBuf, 0, bArr, i, min, this.mMax);
        this.mBufCount -= min * 2;
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= this.mBufCount) {
                return min;
            }
            this.mBuf[i4] = this.mBuf[(min * 2) + i4];
            i3 = i4 + 1;
        }
    }
}
