package android.media;

import java.io.IOException;
import java.io.InputStream;

/* loaded from: source-9557208-dex2jar.jar:android/media/AmrInputStream.class */
public final class AmrInputStream extends InputStream {
    private static final int SAMPLES_PER_FRAME = 160;
    private static final String TAG = "AmrInputStream";
    private InputStream mInputStream;
    private final byte[] mBuf = new byte[320];
    private int mBufIn = 0;
    private int mBufOut = 0;
    private byte[] mOneByte = new byte[1];
    private long mGae = GsmAmrEncoderNew();

    static {
        System.loadLibrary("media_jni");
    }

    public AmrInputStream(InputStream inputStream) {
        this.mInputStream = inputStream;
        GsmAmrEncoderInitialize(this.mGae);
    }

    private static native void GsmAmrEncoderCleanup(long j);

    private static native void GsmAmrEncoderDelete(long j);

    private static native int GsmAmrEncoderEncode(long j, byte[] bArr, int i, byte[] bArr2, int i2) throws IOException;

    private static native void GsmAmrEncoderInitialize(long j);

    private static native long GsmAmrEncoderNew();

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        try {
            if (this.mInputStream != null) {
                this.mInputStream.close();
            }
            this.mInputStream = null;
            try {
                if (this.mGae != 0) {
                    GsmAmrEncoderCleanup(this.mGae);
                }
                try {
                    if (this.mGae != 0) {
                        GsmAmrEncoderDelete(this.mGae);
                    }
                } finally {
                }
            } catch (Throwable th) {
                try {
                    if (this.mGae != 0) {
                        GsmAmrEncoderDelete(this.mGae);
                    }
                    throw th;
                } finally {
                }
            }
        } catch (Throwable th2) {
            this.mInputStream = null;
            try {
                if (this.mGae != 0) {
                    GsmAmrEncoderCleanup(this.mGae);
                }
                try {
                    if (this.mGae != 0) {
                        GsmAmrEncoderDelete(this.mGae);
                    }
                    throw th2;
                } finally {
                }
            } catch (Throwable th3) {
                try {
                    if (this.mGae != 0) {
                        GsmAmrEncoderDelete(this.mGae);
                    }
                    throw th3;
                } finally {
                }
            }
        }
    }

    protected void finalize() throws Throwable {
        if (this.mGae != 0) {
            close();
            throw new IllegalStateException("someone forgot to close AmrInputStream");
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
        if (this.mGae == 0) {
            throw new IllegalStateException("not open");
        }
        if (this.mBufOut >= this.mBufIn) {
            this.mBufOut = 0;
            this.mBufIn = 0;
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 >= 320) {
                    this.mBufIn = GsmAmrEncoderEncode(this.mGae, this.mBuf, 0, this.mBuf, 0);
                    break;
                }
                int read = this.mInputStream.read(this.mBuf, i4, 320 - i4);
                if (read == -1) {
                    return -1;
                }
                i3 = i4 + read;
            }
        }
        int i5 = i2;
        if (i2 > this.mBufIn - this.mBufOut) {
            i5 = this.mBufIn - this.mBufOut;
        }
        System.arraycopy(this.mBuf, this.mBufOut, bArr, i, i5);
        this.mBufOut += i5;
        return i5;
    }
}
