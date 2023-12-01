package android.media;

import android.media.MediaCodec;
import dalvik.system.CloseGuard;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.util.Map;

/* loaded from: source-9557208-dex2jar.jar:android/media/MediaMuxer.class */
public final class MediaMuxer {
    private static final int MUXER_STATE_INITIALIZED = 0;
    private static final int MUXER_STATE_STARTED = 1;
    private static final int MUXER_STATE_STOPPED = 2;
    private static final int MUXER_STATE_UNINITIALIZED = -1;
    private final CloseGuard mCloseGuard = CloseGuard.get();
    private int mLastTrackIndex = -1;
    private long mNativeObject;
    private int mState;

    /* loaded from: source-9557208-dex2jar.jar:android/media/MediaMuxer$OutputFormat.class */
    public static final class OutputFormat {
        public static final int MUXER_OUTPUT_MPEG_4 = 0;
        public static final int MUXER_OUTPUT_WEBM = 1;

        private OutputFormat() {
        }
    }

    static {
        System.loadLibrary("media_jni");
    }

    public MediaMuxer(String str, int i) throws IOException {
        RandomAccessFile randomAccessFile;
        this.mState = -1;
        if (str == null) {
            throw new IllegalArgumentException("path must not be null");
        }
        if (i != 0 && i != 1) {
            throw new IllegalArgumentException("format is invalid");
        }
        try {
            randomAccessFile = new RandomAccessFile(str, "rws");
        } catch (Throwable th) {
            th = th;
            randomAccessFile = null;
        }
        try {
            this.mNativeObject = nativeSetup(randomAccessFile.getFD(), i);
            this.mState = 0;
            this.mCloseGuard.open("release");
            if (randomAccessFile != null) {
                randomAccessFile.close();
            }
        } catch (Throwable th2) {
            th = th2;
            if (randomAccessFile != null) {
                randomAccessFile.close();
            }
            throw th;
        }
    }

    private static native int nativeAddTrack(long j, String[] strArr, Object[] objArr);

    private static native void nativeRelease(long j);

    private static native void nativeSetLocation(long j, int i, int i2);

    private static native void nativeSetOrientationHint(long j, int i);

    private static native long nativeSetup(FileDescriptor fileDescriptor, int i);

    private static native void nativeStart(long j);

    private static native void nativeStop(long j);

    private static native void nativeWriteSampleData(long j, int i, ByteBuffer byteBuffer, int i2, int i3, long j2, int i4);

    public int addTrack(MediaFormat mediaFormat) {
        if (mediaFormat == null) {
            throw new IllegalArgumentException("format must not be null.");
        }
        if (this.mState != 0) {
            throw new IllegalStateException("Muxer is not initialized.");
        }
        if (this.mNativeObject == 0) {
            throw new IllegalStateException("Muxer has been released!");
        }
        Map<String, Object> map = mediaFormat.getMap();
        int size = map.size();
        if (size > 0) {
            String[] strArr = new String[size];
            Object[] objArr = new Object[size];
            int i = 0;
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                strArr[i] = entry.getKey();
                objArr[i] = entry.getValue();
                i++;
            }
            int nativeAddTrack = nativeAddTrack(this.mNativeObject, strArr, objArr);
            if (this.mLastTrackIndex >= nativeAddTrack) {
                throw new IllegalArgumentException("Invalid format.");
            }
            this.mLastTrackIndex = nativeAddTrack;
            return nativeAddTrack;
        }
        throw new IllegalArgumentException("format must not be empty.");
    }

    protected void finalize() throws Throwable {
        try {
            if (this.mCloseGuard != null) {
                this.mCloseGuard.warnIfOpen();
            }
            if (this.mNativeObject != 0) {
                nativeRelease(this.mNativeObject);
                this.mNativeObject = 0L;
            }
        } finally {
            super.finalize();
        }
    }

    public void release() {
        if (this.mState == 1) {
            stop();
        }
        if (this.mNativeObject != 0) {
            nativeRelease(this.mNativeObject);
            this.mNativeObject = 0L;
            this.mCloseGuard.close();
        }
        this.mState = -1;
    }

    public void setLocation(float f, float f2) {
        int i = (int) ((f * 10000.0f) + 0.5d);
        int i2 = (int) ((f2 * 10000.0f) + 0.5d);
        if (i > 900000 || i < -900000) {
            throw new IllegalArgumentException("Latitude: " + f + " out of range.");
        }
        if (i2 > 1800000 || i2 < -1800000) {
            throw new IllegalArgumentException("Longitude: " + f2 + " out of range");
        }
        if (this.mState != 0 || this.mNativeObject == 0) {
            throw new IllegalStateException("Can't set location due to wrong state.");
        }
        nativeSetLocation(this.mNativeObject, i, i2);
    }

    public void setOrientationHint(int i) {
        if (i != 0 && i != 90 && i != 180 && i != 270) {
            throw new IllegalArgumentException("Unsupported angle: " + i);
        }
        if (this.mState != 0) {
            throw new IllegalStateException("Can't set rotation degrees due to wrong state.");
        }
        nativeSetOrientationHint(this.mNativeObject, i);
    }

    public void start() {
        if (this.mNativeObject == 0) {
            throw new IllegalStateException("Muxer has been released!");
        }
        if (this.mState != 0) {
            throw new IllegalStateException("Can't start due to wrong state.");
        }
        nativeStart(this.mNativeObject);
        this.mState = 1;
    }

    public void stop() {
        if (this.mState != 1) {
            throw new IllegalStateException("Can't stop due to wrong state.");
        }
        nativeStop(this.mNativeObject);
        this.mState = 2;
    }

    public void writeSampleData(int i, ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
        if (i < 0 || i > this.mLastTrackIndex) {
            throw new IllegalArgumentException("trackIndex is invalid");
        }
        if (byteBuffer == null) {
            throw new IllegalArgumentException("byteBuffer must not be null");
        }
        if (bufferInfo == null) {
            throw new IllegalArgumentException("bufferInfo must not be null");
        }
        if (bufferInfo.size < 0 || bufferInfo.offset < 0 || bufferInfo.offset + bufferInfo.size > byteBuffer.capacity() || bufferInfo.presentationTimeUs < 0) {
            throw new IllegalArgumentException("bufferInfo must specify a valid buffer offset, size and presentation time");
        }
        if (this.mNativeObject == 0) {
            throw new IllegalStateException("Muxer has been released!");
        }
        if (this.mState != 1) {
            throw new IllegalStateException("Can't write, muxer is not started");
        }
        nativeWriteSampleData(this.mNativeObject, i, byteBuffer, bufferInfo.offset, bufferInfo.size, bufferInfo.presentationTimeUs, bufferInfo.flags);
    }
}
