package android.media;

import android.graphics.Rect;
import android.media.Image;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.Surface;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.NioUtils;
import java.nio.ReadOnlyBufferException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: source-9557208-dex2jar.jar:android/media/MediaCodec.class */
public final class MediaCodec {
    public static final int BUFFER_FLAG_CODEC_CONFIG = 2;
    public static final int BUFFER_FLAG_END_OF_STREAM = 4;
    public static final int BUFFER_FLAG_KEY_FRAME = 1;
    public static final int BUFFER_FLAG_SYNC_FRAME = 1;
    private static final int CB_ERROR = 3;
    private static final int CB_INPUT_AVAILABLE = 1;
    private static final int CB_OUTPUT_AVAILABLE = 2;
    private static final int CB_OUTPUT_FORMAT_CHANGE = 4;
    public static final int CONFIGURE_FLAG_ENCODE = 1;
    public static final int CRYPTO_MODE_AES_CTR = 1;
    public static final int CRYPTO_MODE_UNENCRYPTED = 0;
    private static final int EVENT_CALLBACK = 1;
    private static final int EVENT_SET_CALLBACK = 2;
    public static final int INFO_OUTPUT_BUFFERS_CHANGED = -3;
    public static final int INFO_OUTPUT_FORMAT_CHANGED = -2;
    public static final int INFO_TRY_AGAIN_LATER = -1;
    public static final String PARAMETER_KEY_REQUEST_SYNC_FRAME = "request-sync";
    public static final String PARAMETER_KEY_SUSPEND = "drop-input-frames";
    public static final String PARAMETER_KEY_VIDEO_BITRATE = "video-bitrate";
    public static final int VIDEO_SCALING_MODE_SCALE_TO_FIT = 1;
    public static final int VIDEO_SCALING_MODE_SCALE_TO_FIT_WITH_CROPPING = 2;
    private final Object mBufferLock;
    private ByteBuffer[] mCachedInputBuffers;
    private ByteBuffer[] mCachedOutputBuffers;
    private Callback mCallback;
    private final BufferMap mDequeuedInputBuffers = new BufferMap();
    private final BufferMap mDequeuedOutputBuffers = new BufferMap();
    private EventHandler mEventHandler;
    private long mNativeContext;

    /* loaded from: source-9557208-dex2jar.jar:android/media/MediaCodec$BufferInfo.class */
    public static final class BufferInfo {
        public int flags;
        public int offset;
        public long presentationTimeUs;
        public int size;

        public void set(int i, int i2, long j, int i3) {
            this.offset = i;
            this.size = i2;
            this.presentationTimeUs = j;
            this.flags = i3;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-9557208-dex2jar.jar:android/media/MediaCodec$BufferMap.class */
    public static class BufferMap {
        private final Map<Integer, CodecBuffer> mMap;

        /* JADX INFO: Access modifiers changed from: private */
        /* loaded from: source-9557208-dex2jar.jar:android/media/MediaCodec$BufferMap$CodecBuffer.class */
        public static class CodecBuffer {
            private ByteBuffer mByteBuffer;
            private Image mImage;

            private CodecBuffer() {
            }

            public void free() {
                if (this.mByteBuffer != null) {
                    NioUtils.freeDirectBuffer(this.mByteBuffer);
                    this.mByteBuffer = null;
                }
                if (this.mImage != null) {
                    this.mImage.close();
                    this.mImage = null;
                }
            }

            public void setByteBuffer(ByteBuffer byteBuffer) {
                free();
                this.mByteBuffer = byteBuffer;
            }

            public void setImage(Image image) {
                free();
                this.mImage = image;
            }
        }

        private BufferMap() {
            this.mMap = new HashMap();
        }

        public void clear() {
            for (CodecBuffer codecBuffer : this.mMap.values()) {
                codecBuffer.free();
            }
            this.mMap.clear();
        }

        public void put(int i, Image image) {
            CodecBuffer codecBuffer = this.mMap.get(Integer.valueOf(i));
            CodecBuffer codecBuffer2 = codecBuffer;
            if (codecBuffer == null) {
                codecBuffer2 = new CodecBuffer();
                this.mMap.put(Integer.valueOf(i), codecBuffer2);
            }
            codecBuffer2.setImage(image);
        }

        public void put(int i, ByteBuffer byteBuffer) {
            CodecBuffer codecBuffer = this.mMap.get(Integer.valueOf(i));
            CodecBuffer codecBuffer2 = codecBuffer;
            if (codecBuffer == null) {
                codecBuffer2 = new CodecBuffer();
                this.mMap.put(Integer.valueOf(i), codecBuffer2);
            }
            codecBuffer2.setByteBuffer(byteBuffer);
        }

        public void remove(int i) {
            CodecBuffer codecBuffer = this.mMap.get(Integer.valueOf(i));
            if (codecBuffer != null) {
                codecBuffer.free();
                this.mMap.remove(Integer.valueOf(i));
            }
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/media/MediaCodec$Callback.class */
    public static abstract class Callback {
        public abstract void onError(MediaCodec mediaCodec, CodecException codecException);

        public abstract void onInputBufferAvailable(MediaCodec mediaCodec, int i);

        public abstract void onOutputBufferAvailable(MediaCodec mediaCodec, int i, BufferInfo bufferInfo);

        public abstract void onOutputFormatChanged(MediaCodec mediaCodec, MediaFormat mediaFormat);
    }

    /* loaded from: source-9557208-dex2jar.jar:android/media/MediaCodec$CodecException.class */
    public static final class CodecException extends IllegalStateException {
        private static final int ACTION_RECOVERABLE = 2;
        private static final int ACTION_TRANSIENT = 1;
        private final int mActionCode;
        private final String mDiagnosticInfo;
        private final int mErrorCode;

        CodecException(int i, int i2, String str) {
            super(str);
            this.mErrorCode = i;
            this.mActionCode = i2;
            this.mDiagnosticInfo = "android.media.MediaCodec.error_" + (i < 0 ? "neg_" : "") + Math.abs(i);
        }

        public String getDiagnosticInfo() {
            return this.mDiagnosticInfo;
        }

        public int getErrorCode() {
            return this.mErrorCode;
        }

        public boolean isRecoverable() {
            return this.mActionCode == 2;
        }

        public boolean isTransient() {
            return this.mActionCode == 1;
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/media/MediaCodec$CryptoException.class */
    public static final class CryptoException extends RuntimeException {
        public static final int ERROR_INSUFFICIENT_OUTPUT_PROTECTION = 4;
        public static final int ERROR_KEY_EXPIRED = 2;
        public static final int ERROR_NO_KEY = 1;
        public static final int ERROR_RESOURCE_BUSY = 3;
        private int mErrorCode;

        public CryptoException(int i, String str) {
            super(str);
            this.mErrorCode = i;
        }

        public int getErrorCode() {
            return this.mErrorCode;
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/media/MediaCodec$CryptoInfo.class */
    public static final class CryptoInfo {
        public byte[] iv;
        public byte[] key;
        public int mode;
        public int[] numBytesOfClearData;
        public int[] numBytesOfEncryptedData;
        public int numSubSamples;

        public void set(int i, int[] iArr, int[] iArr2, byte[] bArr, byte[] bArr2, int i2) {
            this.numSubSamples = i;
            this.numBytesOfClearData = iArr;
            this.numBytesOfEncryptedData = iArr2;
            this.key = bArr;
            this.iv = bArr2;
            this.mode = i2;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(this.numSubSamples + " subsamples, key [");
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.key.length) {
                    break;
                }
                sb.append("0123456789abcdef".charAt((this.key[i2] & 240) >> 4));
                sb.append("0123456789abcdef".charAt(this.key[i2] & 15));
                i = i2 + 1;
            }
            sb.append("], iv [");
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 >= this.key.length) {
                    sb.append("], clear ");
                    sb.append(Arrays.toString(this.numBytesOfClearData));
                    sb.append(", encrypted ");
                    sb.append(Arrays.toString(this.numBytesOfEncryptedData));
                    return sb.toString();
                }
                sb.append("0123456789abcdef".charAt((this.iv[i4] & 240) >> 4));
                sb.append("0123456789abcdef".charAt(this.iv[i4] & 15));
                i3 = i4 + 1;
            }
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/media/MediaCodec$EventHandler.class */
    private class EventHandler extends Handler {
        private MediaCodec mCodec;

        public EventHandler(MediaCodec mediaCodec, Looper looper) {
            super(looper);
            this.mCodec = mediaCodec;
        }

        private void handleCallback(Message message) {
            if (MediaCodec.this.mCallback == null) {
                return;
            }
            switch (message.arg1) {
                case 1:
                    int i = message.arg2;
                    synchronized (MediaCodec.this.mBufferLock) {
                        MediaCodec.this.validateInputByteBuffer(MediaCodec.this.mCachedInputBuffers, i);
                    }
                    MediaCodec.this.mCallback.onInputBufferAvailable(this.mCodec, i);
                    return;
                case 2:
                    int i2 = message.arg2;
                    BufferInfo bufferInfo = (BufferInfo) message.obj;
                    synchronized (MediaCodec.this.mBufferLock) {
                        MediaCodec.this.validateOutputByteBuffer(MediaCodec.this.mCachedOutputBuffers, i2, bufferInfo);
                    }
                    MediaCodec.this.mCallback.onOutputBufferAvailable(this.mCodec, i2, bufferInfo);
                    return;
                case 3:
                    MediaCodec.this.mCallback.onError(this.mCodec, (CodecException) message.obj);
                    return;
                case 4:
                    synchronized (MediaCodec.this.mBufferLock) {
                        MediaCodec.this.cacheBuffers(false);
                    }
                    MediaCodec.this.mCallback.onOutputFormatChanged(this.mCodec, new MediaFormat((Map) message.obj));
                    return;
                default:
                    return;
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    handleCallback(message);
                    return;
                case 2:
                    MediaCodec.this.mCallback = (Callback) message.obj;
                    return;
                default:
                    return;
            }
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/media/MediaCodec$MediaImage.class */
    public static class MediaImage extends Image {
        private static final int TYPE_YUV = 1;
        private final ByteBuffer mBuffer;
        private final int mHeight;
        private final ByteBuffer mInfo;
        private final boolean mIsReadOnly;
        private final Image.Plane[] mPlanes;
        private long mTimestamp;
        private final int mWidth;
        private final int mXOffset;
        private final int mYOffset;
        private final int mFormat = 35;
        private boolean mIsValid = true;

        /* loaded from: source-9557208-dex2jar.jar:android/media/MediaCodec$MediaImage$MediaPlane.class */
        private class MediaPlane extends Image.Plane {
            private final int mColInc;
            private final ByteBuffer mData;
            private final int mRowInc;

            public MediaPlane(ByteBuffer byteBuffer, int i, int i2) {
                this.mData = byteBuffer;
                this.mRowInc = i;
                this.mColInc = i2;
            }

            @Override // android.media.Image.Plane
            public ByteBuffer getBuffer() {
                MediaImage.this.checkValid();
                return this.mData;
            }

            @Override // android.media.Image.Plane
            public int getPixelStride() {
                MediaImage.this.checkValid();
                return this.mColInc;
            }

            @Override // android.media.Image.Plane
            public int getRowStride() {
                MediaImage.this.checkValid();
                return this.mRowInc;
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:45:0x01c4, code lost:
            throw new java.lang.UnsupportedOperationException("unexpected subsampling: " + r0 + "x" + r0 + " on plane " + r18);
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public MediaImage(java.nio.ByteBuffer r10, java.nio.ByteBuffer r11, boolean r12, long r13, int r15, int r16, android.graphics.Rect r17) {
            /*
                Method dump skipped, instructions count: 644
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: android.media.MediaCodec.MediaImage.<init>(java.nio.ByteBuffer, java.nio.ByteBuffer, boolean, long, int, int, android.graphics.Rect):void");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void checkValid() {
            if (!this.mIsValid) {
                throw new IllegalStateException("Image is already released");
            }
        }

        private int readInt(ByteBuffer byteBuffer, boolean z) {
            return z ? (int) byteBuffer.getLong() : byteBuffer.getInt();
        }

        @Override // android.media.Image, java.lang.AutoCloseable
        public void close() {
            if (this.mIsValid) {
                NioUtils.freeDirectBuffer(this.mBuffer);
                this.mIsValid = false;
            }
        }

        @Override // android.media.Image
        public int getFormat() {
            checkValid();
            return this.mFormat;
        }

        @Override // android.media.Image
        public int getHeight() {
            checkValid();
            return this.mHeight;
        }

        @Override // android.media.Image
        public Image.Plane[] getPlanes() {
            checkValid();
            return (Image.Plane[]) Arrays.copyOf(this.mPlanes, this.mPlanes.length);
        }

        @Override // android.media.Image
        public long getTimestamp() {
            checkValid();
            return this.mTimestamp;
        }

        @Override // android.media.Image
        public int getWidth() {
            checkValid();
            return this.mWidth;
        }

        @Override // android.media.Image
        public void setCropRect(Rect rect) {
            if (this.mIsReadOnly) {
                throw new ReadOnlyBufferException();
            }
            super.setCropRect(rect);
        }
    }

    static {
        System.loadLibrary("media_jni");
        native_init();
    }

    private MediaCodec(String str, boolean z, boolean z2) {
        Looper myLooper = Looper.myLooper();
        if (myLooper != null) {
            this.mEventHandler = new EventHandler(this, myLooper);
        } else {
            Looper mainLooper = Looper.getMainLooper();
            if (mainLooper != null) {
                this.mEventHandler = new EventHandler(this, mainLooper);
            } else {
                this.mEventHandler = null;
            }
        }
        this.mBufferLock = new Object();
        native_setup(str, z, z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void cacheBuffers(boolean z) {
        ByteBuffer[] byteBufferArr = null;
        try {
            ByteBuffer[] buffers = getBuffers(z);
            byteBufferArr = buffers;
            invalidateByteBuffers(buffers);
            byteBufferArr = buffers;
        } catch (IllegalStateException e) {
        }
        if (z) {
            this.mCachedInputBuffers = byteBufferArr;
        } else {
            this.mCachedOutputBuffers = byteBufferArr;
        }
    }

    public static MediaCodec createByCodecName(String str) throws IOException {
        return new MediaCodec(str, false, false);
    }

    public static MediaCodec createDecoderByType(String str) throws IOException {
        return new MediaCodec(str, true, false);
    }

    public static MediaCodec createEncoderByType(String str) throws IOException {
        return new MediaCodec(str, true, true);
    }

    private final void freeAllTrackedBuffers() {
        synchronized (this.mBufferLock) {
            freeByteBuffers(this.mCachedInputBuffers);
            freeByteBuffers(this.mCachedOutputBuffers);
            this.mCachedInputBuffers = null;
            this.mCachedOutputBuffers = null;
            this.mDequeuedInputBuffers.clear();
            this.mDequeuedOutputBuffers.clear();
        }
    }

    private final void freeByteBuffer(ByteBuffer byteBuffer) {
        if (byteBuffer != null) {
            NioUtils.freeDirectBuffer(byteBuffer);
        }
    }

    private final void freeByteBuffers(ByteBuffer[] byteBufferArr) {
        if (byteBufferArr == null) {
            return;
        }
        int length = byteBufferArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return;
            }
            freeByteBuffer(byteBufferArr[i2]);
            i = i2 + 1;
        }
    }

    private final native ByteBuffer getBuffer(boolean z, int i);

    private final native ByteBuffer[] getBuffers(boolean z);

    private final native Map<String, Object> getFormatNative(boolean z);

    private final native Image getImage(boolean z, int i);

    private final native Map<String, Object> getOutputFormatNative(int i);

    private final void invalidateByteBuffer(ByteBuffer[] byteBufferArr, int i) {
        ByteBuffer byteBuffer;
        if (byteBufferArr == null || i < 0 || i >= byteBufferArr.length || (byteBuffer = byteBufferArr[i]) == null) {
            return;
        }
        byteBuffer.setAccessible(false);
    }

    private final void invalidateByteBuffers(ByteBuffer[] byteBufferArr) {
        if (byteBufferArr == null) {
            return;
        }
        int length = byteBufferArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return;
            }
            ByteBuffer byteBuffer = byteBufferArr[i2];
            if (byteBuffer != null) {
                byteBuffer.setAccessible(false);
            }
            i = i2 + 1;
        }
    }

    private final native void native_configure(String[] strArr, Object[] objArr, Surface surface, MediaCrypto mediaCrypto, int i);

    private final native int native_dequeueInputBuffer(long j);

    private final native int native_dequeueOutputBuffer(BufferInfo bufferInfo, long j);

    private final native void native_finalize();

    private final native void native_flush();

    private static final native void native_init();

    private final native void native_queueInputBuffer(int i, int i2, int i3, long j, int i4) throws CryptoException;

    private final native void native_queueSecureInputBuffer(int i, int i2, CryptoInfo cryptoInfo, long j, int i3) throws CryptoException;

    private final native void native_release();

    private final native void native_reset();

    private final native void native_setCallback(Callback callback);

    private final native void native_setup(String str, boolean z, boolean z2);

    private final native void native_start();

    private final native void native_stop();

    private void postEventFromNative(int i, int i2, int i3, Object obj) {
        if (this.mEventHandler != null) {
            this.mEventHandler.sendMessage(this.mEventHandler.obtainMessage(i, i2, i3, obj));
        }
    }

    private final native void releaseOutputBuffer(int i, boolean z, boolean z2, long j);

    private final void revalidateByteBuffer(ByteBuffer[] byteBufferArr, int i) {
        ByteBuffer byteBuffer;
        synchronized (this.mBufferLock) {
            if (byteBufferArr != null && i >= 0) {
                if (i < byteBufferArr.length && (byteBuffer = byteBufferArr[i]) != null) {
                    byteBuffer.setAccessible(true);
                }
            }
        }
    }

    private final native void setParameters(String[] strArr, Object[] objArr);

    /* JADX INFO: Access modifiers changed from: private */
    public final void validateInputByteBuffer(ByteBuffer[] byteBufferArr, int i) {
        ByteBuffer byteBuffer;
        if (byteBufferArr == null || i < 0 || i >= byteBufferArr.length || (byteBuffer = byteBufferArr[i]) == null) {
            return;
        }
        byteBuffer.setAccessible(true);
        byteBuffer.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void validateOutputByteBuffer(ByteBuffer[] byteBufferArr, int i, BufferInfo bufferInfo) {
        ByteBuffer byteBuffer;
        if (byteBufferArr == null || i < 0 || i >= byteBufferArr.length || (byteBuffer = byteBufferArr[i]) == null) {
            return;
        }
        byteBuffer.setAccessible(true);
        byteBuffer.limit(bufferInfo.offset + bufferInfo.size).position(bufferInfo.offset);
    }

    public void configure(MediaFormat mediaFormat, Surface surface, MediaCrypto mediaCrypto, int i) {
        Map<String, Object> map = mediaFormat.getMap();
        String[] strArr = null;
        Object[] objArr = null;
        if (mediaFormat != null) {
            String[] strArr2 = new String[map.size()];
            Object[] objArr2 = new Object[map.size()];
            int i2 = 0;
            Iterator<Map.Entry<String, Object>> it = map.entrySet().iterator();
            while (true) {
                strArr = strArr2;
                objArr = objArr2;
                if (!it.hasNext()) {
                    break;
                }
                Map.Entry<String, Object> next = it.next();
                if (next.getKey().equals(MediaFormat.KEY_AUDIO_SESSION_ID)) {
                    try {
                        int intValue = ((Integer) next.getValue()).intValue();
                        strArr2[i2] = "audio-hw-sync";
                        objArr2[i2] = Integer.valueOf(AudioSystem.getAudioHwSyncForSession(intValue));
                    } catch (Exception e) {
                        throw new IllegalArgumentException("Wrong Session ID Parameter!");
                    }
                } else {
                    strArr2[i2] = next.getKey();
                    objArr2[i2] = next.getValue();
                }
                i2++;
            }
        }
        native_configure(strArr, objArr, surface, mediaCrypto, i);
    }

    public final native Surface createInputSurface();

    public final int dequeueInputBuffer(long j) {
        int native_dequeueInputBuffer = native_dequeueInputBuffer(j);
        if (native_dequeueInputBuffer >= 0) {
            synchronized (this.mBufferLock) {
                validateInputByteBuffer(this.mCachedInputBuffers, native_dequeueInputBuffer);
            }
            return native_dequeueInputBuffer;
        }
        return native_dequeueInputBuffer;
    }

    public final int dequeueOutputBuffer(BufferInfo bufferInfo, long j) {
        int native_dequeueOutputBuffer = native_dequeueOutputBuffer(bufferInfo, j);
        synchronized (this.mBufferLock) {
            if (native_dequeueOutputBuffer == -3) {
                cacheBuffers(false);
            } else if (native_dequeueOutputBuffer >= 0) {
                validateOutputByteBuffer(this.mCachedOutputBuffers, native_dequeueOutputBuffer, bufferInfo);
            }
        }
        return native_dequeueOutputBuffer;
    }

    protected void finalize() {
        native_finalize();
    }

    public final void flush() {
        synchronized (this.mBufferLock) {
            invalidateByteBuffers(this.mCachedInputBuffers);
            invalidateByteBuffers(this.mCachedOutputBuffers);
            this.mDequeuedInputBuffers.clear();
            this.mDequeuedOutputBuffers.clear();
        }
        native_flush();
    }

    public MediaCodecInfo getCodecInfo() {
        return MediaCodecList.getInfoFor(getName());
    }

    public ByteBuffer getInputBuffer(int i) {
        ByteBuffer buffer = getBuffer(true, i);
        synchronized (this.mBufferLock) {
            invalidateByteBuffer(this.mCachedInputBuffers, i);
            this.mDequeuedInputBuffers.put(i, buffer);
        }
        return buffer;
    }

    public ByteBuffer[] getInputBuffers() {
        if (this.mCachedInputBuffers == null) {
            throw new IllegalStateException();
        }
        return this.mCachedInputBuffers;
    }

    public final MediaFormat getInputFormat() {
        return new MediaFormat(getFormatNative(true));
    }

    public Image getInputImage(int i) {
        Image image = getImage(true, i);
        synchronized (this.mBufferLock) {
            invalidateByteBuffer(this.mCachedInputBuffers, i);
            this.mDequeuedInputBuffers.put(i, image);
        }
        return image;
    }

    public final native String getName();

    public ByteBuffer getOutputBuffer(int i) {
        ByteBuffer buffer = getBuffer(false, i);
        synchronized (this.mBufferLock) {
            invalidateByteBuffer(this.mCachedOutputBuffers, i);
            this.mDequeuedOutputBuffers.put(i, buffer);
        }
        return buffer;
    }

    public ByteBuffer[] getOutputBuffers() {
        if (this.mCachedOutputBuffers == null) {
            throw new IllegalStateException();
        }
        return this.mCachedOutputBuffers;
    }

    public final MediaFormat getOutputFormat() {
        return new MediaFormat(getFormatNative(false));
    }

    public final MediaFormat getOutputFormat(int i) {
        return new MediaFormat(getOutputFormatNative(i));
    }

    public Image getOutputImage(int i) {
        Image image = getImage(false, i);
        synchronized (this.mBufferLock) {
            invalidateByteBuffer(this.mCachedOutputBuffers, i);
            this.mDequeuedOutputBuffers.put(i, image);
        }
        return image;
    }

    public final void queueInputBuffer(int i, int i2, int i3, long j, int i4) throws CryptoException {
        synchronized (this.mBufferLock) {
            invalidateByteBuffer(this.mCachedInputBuffers, i);
            this.mDequeuedInputBuffers.remove(i);
        }
        try {
            native_queueInputBuffer(i, i2, i3, j, i4);
        } catch (CryptoException | IllegalStateException e) {
            revalidateByteBuffer(this.mCachedInputBuffers, i);
            throw e;
        }
    }

    public final void queueSecureInputBuffer(int i, int i2, CryptoInfo cryptoInfo, long j, int i3) throws CryptoException {
        synchronized (this.mBufferLock) {
            invalidateByteBuffer(this.mCachedInputBuffers, i);
            this.mDequeuedInputBuffers.remove(i);
        }
        try {
            native_queueSecureInputBuffer(i, i2, cryptoInfo, j, i3);
        } catch (CryptoException | IllegalStateException e) {
            revalidateByteBuffer(this.mCachedInputBuffers, i);
            throw e;
        }
    }

    public final void release() {
        freeAllTrackedBuffers();
        native_release();
    }

    public final void releaseOutputBuffer(int i, long j) {
        synchronized (this.mBufferLock) {
            invalidateByteBuffer(this.mCachedOutputBuffers, i);
            this.mDequeuedOutputBuffers.remove(i);
        }
        releaseOutputBuffer(i, true, true, j);
    }

    public final void releaseOutputBuffer(int i, boolean z) {
        synchronized (this.mBufferLock) {
            invalidateByteBuffer(this.mCachedOutputBuffers, i);
            this.mDequeuedOutputBuffers.remove(i);
        }
        releaseOutputBuffer(i, z, false, 0L);
    }

    public final void reset() {
        freeAllTrackedBuffers();
        native_reset();
    }

    public void setCallback(Callback callback) {
        if (this.mEventHandler != null) {
            this.mEventHandler.sendMessage(this.mEventHandler.obtainMessage(2, 0, 0, callback));
            native_setCallback(callback);
        }
    }

    public final void setParameters(Bundle bundle) {
        if (bundle == null) {
            return;
        }
        String[] strArr = new String[bundle.size()];
        Object[] objArr = new Object[bundle.size()];
        int i = 0;
        for (String str : bundle.keySet()) {
            strArr[i] = str;
            objArr[i] = bundle.get(str);
            i++;
        }
        setParameters(strArr, objArr);
    }

    public final native void setVideoScalingMode(int i);

    public final native void signalEndOfInputStream();

    public final void start() {
        native_start();
        synchronized (this.mBufferLock) {
            cacheBuffers(true);
            cacheBuffers(false);
        }
    }

    public final void stop() {
        native_stop();
        freeAllTrackedBuffers();
        if (this.mEventHandler != null) {
            this.mEventHandler.removeMessages(1);
            this.mEventHandler.removeMessages(2);
        }
    }
}
