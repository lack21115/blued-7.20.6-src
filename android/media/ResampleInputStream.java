package android.media;

import java.io.IOException;
import java.io.InputStream;

/* loaded from: source-9557208-dex2jar.jar:android/media/ResampleInputStream.class */
public final class ResampleInputStream extends InputStream {
    private static final String TAG = "ResampleInputStream";
    private static final int mFirLength = 29;
    private byte[] mBuf;
    private int mBufCount;
    private InputStream mInputStream;
    private final byte[] mOneByte = new byte[1];
    private final int mRateIn;
    private final int mRateOut;

    static {
        System.loadLibrary("media_jni");
    }

    public ResampleInputStream(InputStream inputStream, int i, int i2) {
        if (i != i2 * 2) {
            throw new IllegalArgumentException("only support 2:1 at the moment");
        }
        this.mInputStream = inputStream;
        this.mRateIn = 2;
        this.mRateOut = 1;
    }

    private static native void fir21(byte[] bArr, int i, byte[] bArr2, int i2, int i3);

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        try {
            if (this.mInputStream != null) {
                this.mInputStream.close();
            }
        } finally {
            this.mInputStream = null;
        }
    }

    protected void finalize() throws Throwable {
        if (this.mInputStream != null) {
            close();
            throw new IllegalStateException("someone forgot to close ResampleInputStream");
        }
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        if (read(this.mOneByte, 0, 1) == 1) {
            return this.mOneByte[0] & 255;
        }
        return -1;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        int i3;
        if (this.mInputStream == null) {
            throw new IllegalStateException("not open");
        }
        int i4 = ((((i2 / 2) * this.mRateIn) / this.mRateOut) + 29) * 2;
        if (this.mBuf == null) {
            this.mBuf = new byte[i4];
        } else if (i4 > this.mBuf.length) {
            byte[] bArr2 = new byte[i4];
            System.arraycopy(this.mBuf, 0, bArr2, 0, this.mBufCount);
            this.mBuf = bArr2;
        }
        while (true) {
            int i5 = ((((this.mBufCount / 2) - 29) * this.mRateOut) / this.mRateIn) * 2;
            if (i5 <= 0) {
                int read = this.mInputStream.read(this.mBuf, this.mBufCount, this.mBuf.length - this.mBufCount);
                i3 = -1;
                if (read == -1) {
                    break;
                }
                this.mBufCount += read;
            } else {
                int i6 = i5 < i2 ? i5 : (i2 / 2) * 2;
                fir21(this.mBuf, 0, bArr, i, i6 / 2);
                int i7 = (this.mRateIn * i6) / this.mRateOut;
                this.mBufCount -= i7;
                if (this.mBufCount > 0) {
                    System.arraycopy(this.mBuf, i7, this.mBuf, 0, this.mBufCount);
                }
                i3 = i6;
            }
        }
        return i3;
    }
}
