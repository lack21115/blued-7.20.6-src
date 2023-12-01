package android.speech.srec;

import java.io.IOException;
import java.io.InputStream;

/* loaded from: source-9557208-dex2jar.jar:android/speech/srec/MicrophoneInputStream.class */
public final class MicrophoneInputStream extends InputStream {
    private static final String TAG = "MicrophoneInputStream";
    private long mAudioRecord;
    private byte[] mOneByte = new byte[1];

    static {
        System.loadLibrary("srec_jni");
    }

    public MicrophoneInputStream(int i, int i2) throws IOException {
        this.mAudioRecord = 0L;
        this.mAudioRecord = AudioRecordNew(i, i2);
        if (this.mAudioRecord == 0) {
            throw new IOException("AudioRecord constructor failed - busy?");
        }
        int AudioRecordStart = AudioRecordStart(this.mAudioRecord);
        if (AudioRecordStart != 0) {
            close();
            throw new IOException("AudioRecord start failed: " + AudioRecordStart);
        }
    }

    private static native void AudioRecordDelete(long j) throws IOException;

    private static native long AudioRecordNew(int i, int i2);

    private static native int AudioRecordRead(long j, byte[] bArr, int i, int i2) throws IOException;

    private static native int AudioRecordStart(long j);

    private static native void AudioRecordStop(long j) throws IOException;

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.mAudioRecord != 0) {
            try {
                AudioRecordStop(this.mAudioRecord);
                try {
                    AudioRecordDelete(this.mAudioRecord);
                } finally {
                }
            } catch (Throwable th) {
                try {
                    AudioRecordDelete(this.mAudioRecord);
                    throw th;
                } finally {
                }
            }
        }
    }

    protected void finalize() throws Throwable {
        if (this.mAudioRecord != 0) {
            close();
            throw new IOException("someone forgot to close MicrophoneInputStream");
        }
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        if (this.mAudioRecord == 0) {
            throw new IllegalStateException("not open");
        }
        if (AudioRecordRead(this.mAudioRecord, this.mOneByte, 0, 1) == 1) {
            return this.mOneByte[0] & 255;
        }
        return -1;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        if (this.mAudioRecord == 0) {
            throw new IllegalStateException("not open");
        }
        return AudioRecordRead(this.mAudioRecord, bArr, 0, bArr.length);
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        if (this.mAudioRecord == 0) {
            throw new IllegalStateException("not open");
        }
        return AudioRecordRead(this.mAudioRecord, bArr, i, i2);
    }
}
