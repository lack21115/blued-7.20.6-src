package com.zego.ve;

import android.graphics.SurfaceTexture;
import android.media.Image;
import android.media.ImageReader;
import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaFormat;
import android.os.Build;
import android.view.Surface;
import com.android.internal.telephony.PhoneConstants;
import java.nio.ByteBuffer;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* loaded from: source-8829756-dex2jar.jar:com/zego/ve/MediaCodecVideoDecoder.class */
public class MediaCodecVideoDecoder {
    private static final int COLOR_FormatYUV420Flexible = 2135033992;
    private static final int DEQUEUE_INPUT_TIMEOUT = 500000;
    private static final String FORMAT_KEY_CROP_BOTTOM = "crop-bottom";
    private static final String FORMAT_KEY_CROP_LEFT = "crop-left";
    private static final String FORMAT_KEY_CROP_RIGHT = "crop-right";
    private static final String FORMAT_KEY_CROP_TOP = "crop-top";
    private static final String FORMAT_KEY_SLICE_HEIGHT = "slice-height";
    private static final String FORMAT_KEY_STRIDE = "stride";
    private static final String H264_MIME_TYPE = "video/avc";
    private static final String HEVC_MIME_TYPE = "video/hevc";
    private static final int MAX_QUEUED_OUTPUTBUFFERS = 3;
    private static final int MEDIA_CODEC_RELEASE_TIMEOUT_MS = 5000;
    private static final String TAG = "MediaCodecVideoDecoder";
    private static final int VIDEO_CODEC_H264 = 2;
    private static final int VIDEO_CODEC_HEVC = 3;
    private static final int VIDEO_CODEC_VP8 = 0;
    private static final int VIDEO_CODEC_VP9 = 1;
    private static final String VP8_MIME_TYPE = "video/x-vnd.on2.vp8";
    private static final String VP9_MIME_TYPE = "video/x-vnd.on2.vp9";
    private static int codecErrors;
    private static MediaCodecVideoDecoderErrorCallback errorCallback;
    private static MediaCodecVideoDecoder runningInstance;
    private int colorFormat;
    private int cropLeft;
    private int cropTop;
    private boolean hasDecodedFirstFrame;
    private int height;
    private ByteBuffer[] inputBuffers;
    private boolean isImageReader;
    private ByteBuffer[] outputBuffers;
    private int sliceHeight;
    private int stride;
    private int width;
    private static Set<String> hwDecoderDisabledTypes = new HashSet();
    private static final String[] supportedVp8HwCodecPrefixes = {"OMX.qcom.", "OMX.hisi.", "OMX.IMG.", "OMX.Nvidia.", "OMX.Exynos.", "OMX.Intel."};
    private static final String[] supportedVp9HwCodecPrefixes = {"OMX.qcom.", "OMX.Exynos."};
    private static final String[] supportedH264HwCodecPrefixes = {"OMX.qcom.", "OMX.Exynos.", "OMX.MTK.", "OMX.hisi.", "OMX.IMG.", "OMX.k3.", "OMX.TI.", "OMX.rk.", "OMX.amlogic.", "OMX.Intel.", "OMX.Nvidia.", "OMX.allwinner.", "OMX.MS.", "OMX.realtek.", "OMX.Freescale.", "OMX.sprd.", "c2.qti."};
    private static final String[] supportedHEVCHwCodecPrefixes = {"OMX.qcom.", "OMX.hisi.", "OMX.IMG.", "OMX.Intel.", "OMX.MTK", "OMX.Exynos.", "c2.qti."};
    private static final int COLOR_QCOM_FORMATYUV420PackedSemiPlanar32m = 2141391876;
    private static final int COLOR_QCOM_FormatYUV420PackedSemiPlanar64x32Tile2m8ka = 2141391875;
    private static final int[] supportedColorList = {19, 2135033992, 21, MediaCodecInfo.CodecCapabilities.COLOR_QCOM_FormatYUV420SemiPlanar, COLOR_QCOM_FORMATYUV420PackedSemiPlanar32m, COLOR_QCOM_FormatYUV420PackedSemiPlanar64x32Tile2m8ka, MediaCodecInfo.CodecCapabilities.COLOR_TI_FormatYUV420PackedSemiPlanar, MediaCodecInfo.CodecCapabilities.COLOR_FormatSurface};
    private static final int[] supportedSurfaceColorList = {MediaCodecInfo.CodecCapabilities.COLOR_FormatSurface, 2135033992};
    private static boolean enableWhitelist = true;
    private static final String[] HW_BLACKLISTS = {"omx.google.", "omx.ffmpeg.", "omx.pv", "omx.k3.ffmpeg.", "omx.avcodec.", "omx.ittiam.", "omx.sec.avc.sw.", "omx.marvell.video.h264decoder"};
    private static final String[] HW_SURFACE_BLACKLISTS = {"OMX.MS.", "OMX.MTK"};
    private static final String[] H264_HW_EXCEPTION_MODELS = {"V1818CA"};
    private static final String[] H265_HW_EXCEPTION_MODELS = {"V1818CA"};
    private Thread mediaCodecThread = null;
    private MediaCodec mediaCodec = null;
    private String codecName = null;
    private Surface surface = null;

    /* loaded from: source-8829756-dex2jar.jar:com/zego/ve/MediaCodecVideoDecoder$DecodedOutputBuffer.class */
    static class DecodedOutputBuffer {
        private ByteBuffer buffer;
        private final boolean eos;
        public final boolean formatChanged;
        private final int index;
        private boolean isI420;
        private final long presentationTimeStampUs;
        private ByteBuffer uBuffer;
        private int uStride;
        private ByteBuffer vBuffer;
        private int vStride;
        private ByteBuffer yBuffer;
        private int yStride;

        public DecodedOutputBuffer(int i, ByteBuffer byteBuffer, long j, boolean z, boolean z2) {
            this.index = i;
            this.buffer = byteBuffer;
            this.presentationTimeStampUs = j;
            this.formatChanged = z;
            this.eos = z2;
        }

        public DecodedOutputBuffer(int i, ByteBuffer byteBuffer, ByteBuffer byteBuffer2, ByteBuffer byteBuffer3, int i2, int i3, int i4, boolean z, long j, boolean z2, boolean z3) {
            this.index = i;
            this.yBuffer = byteBuffer;
            this.uBuffer = byteBuffer2;
            this.vBuffer = byteBuffer3;
            this.yStride = i2;
            this.uStride = i3;
            this.vStride = i4;
            this.presentationTimeStampUs = j;
            this.formatChanged = z2;
            this.eos = z3;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/zego/ve/MediaCodecVideoDecoder$DecoderProperties.class */
    public static class DecoderProperties {
        public final String codecName;
        public final int colorFormat;

        public DecoderProperties(String str, int i) {
            this.codecName = str;
            this.colorFormat = i;
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/zego/ve/MediaCodecVideoDecoder$MediaCodecVideoDecoderErrorCallback.class */
    public interface MediaCodecVideoDecoderErrorCallback {
        void onMediaCodecVideoDecoderCriticalError(int i);
    }

    private void checkOnMediaCodecThread() throws IllegalStateException {
        if (this.mediaCodecThread.getId() == Thread.currentThread().getId()) {
            return;
        }
        throw new IllegalStateException("MediaCodecVideoDecoder previously operated on " + this.mediaCodecThread + " but is now called on " + Thread.currentThread());
    }

    private int dequeueInputBuffer() {
        checkOnMediaCodecThread();
        try {
            return this.mediaCodec.dequeueInputBuffer(500000L);
        } catch (IllegalStateException e) {
            android.util.Log.e(TAG, "dequeueIntputBuffer failed", e);
            return -2;
        }
    }

    private DecodedOutputBuffer dequeueOutputBuffer(int i) {
        int i2;
        int i3;
        int i4;
        int i5;
        checkOnMediaCodecThread();
        MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
        while (true) {
            int dequeueOutputBuffer = this.mediaCodec.dequeueOutputBuffer(bufferInfo, TimeUnit.MILLISECONDS.toMicros(i));
            if (dequeueOutputBuffer != -3) {
                if (dequeueOutputBuffer != -2) {
                    if (dequeueOutputBuffer != -1) {
                        boolean z = !this.hasDecodedFirstFrame;
                        this.hasDecodedFirstFrame = true;
                        boolean z2 = (bufferInfo.flags & 4) != 0;
                        if (z2) {
                            android.util.Log.d(TAG, "output EOS");
                        }
                        if (this.colorFormat != 2135033992) {
                            ByteBuffer byteBuffer = getByteBuffer(false, dequeueOutputBuffer);
                            byteBuffer.position(bufferInfo.offset);
                            byteBuffer.limit(bufferInfo.offset + bufferInfo.size);
                            return new DecodedOutputBuffer(dequeueOutputBuffer, byteBuffer, bufferInfo.presentationTimeUs, z, z2);
                        } else if (Build.VERSION.SDK_INT >= 21) {
                            Image.Plane[] planes = this.mediaCodec.getOutputImage(dequeueOutputBuffer).getPlanes();
                            return new DecodedOutputBuffer(dequeueOutputBuffer, planes[0].getBuffer(), planes[1].getBuffer(), planes[2].getBuffer(), planes[0].getRowStride(), planes[1].getRowStride(), planes[2].getRowStride(), planes[1].getPixelStride() == 1 && planes[2].getPixelStride() == 1, bufferInfo.presentationTimeUs, z, z2);
                        } else {
                            return null;
                        }
                    }
                    return null;
                }
                MediaFormat outputFormat = this.mediaCodec.getOutputFormat();
                android.util.Log.d(TAG, "Decoder format changed: " + outputFormat.toString());
                if (outputFormat.containsKey(FORMAT_KEY_CROP_LEFT) && outputFormat.containsKey(FORMAT_KEY_CROP_RIGHT) && outputFormat.containsKey(FORMAT_KEY_CROP_BOTTOM) && outputFormat.containsKey(FORMAT_KEY_CROP_TOP)) {
                    this.cropTop = outputFormat.getInteger(FORMAT_KEY_CROP_TOP);
                    this.cropLeft = outputFormat.getInteger(FORMAT_KEY_CROP_LEFT);
                    i2 = (outputFormat.getInteger(FORMAT_KEY_CROP_RIGHT) - this.cropLeft) + 1;
                    i3 = (outputFormat.getInteger(FORMAT_KEY_CROP_BOTTOM) - this.cropTop) + 1;
                } else {
                    this.cropTop = 0;
                    this.cropLeft = 0;
                    i2 = 0;
                    i3 = 0;
                }
                if (outputFormat.containsKey("width") && outputFormat.containsKey("height")) {
                    i4 = outputFormat.getInteger("width");
                    i5 = outputFormat.getInteger("height");
                } else {
                    i4 = 0;
                    i5 = 0;
                }
                if (!this.hasDecodedFirstFrame) {
                    if (i4 != 0 && i5 != 0 && i4 <= this.width && i5 <= this.height) {
                        this.width = i4;
                        this.height = i5;
                    }
                    if (i2 != 0 && i3 != 0 && i2 <= this.width && i3 <= this.height) {
                        this.width = i2;
                        this.height = i3;
                    }
                } else if (i4 != this.width || i5 != this.height) {
                    break;
                }
                if (i5 != 0) {
                    this.sliceHeight = i5;
                }
                if (this.codecName.startsWith("OMX.rk") && this.colorFormat == 21) {
                    this.colorFormat = 21;
                } else if (outputFormat.containsKey(MediaFormat.KEY_COLOR_FORMAT)) {
                    this.colorFormat = outputFormat.getInteger(MediaFormat.KEY_COLOR_FORMAT);
                    android.util.Log.d(TAG, "Color: 0x" + Integer.toHexString(this.colorFormat));
                }
                if (outputFormat.containsKey("stride")) {
                    this.stride = outputFormat.getInteger("stride");
                } else {
                    this.stride = i4;
                }
                if (outputFormat.containsKey("slice-height")) {
                    this.sliceHeight = outputFormat.getInteger("slice-height");
                }
                android.util.Log.d(TAG, "Output frame stride and slice height: " + this.stride + " x " + this.sliceHeight);
                this.stride = Math.max(this.width, this.stride);
                int i6 = this.colorFormat;
                if ((19 == i6 || 21 == i6) && i5 != this.sliceHeight) {
                    this.sliceHeight = this.height;
                } else {
                    this.sliceHeight = Math.max(this.height, this.sliceHeight);
                }
                this.hasDecodedFirstFrame = false;
            } else if (Build.VERSION.SDK_INT < 21) {
                this.outputBuffers = this.mediaCodec.getOutputBuffers();
                android.util.Log.d(TAG, "Decoder output buffers changed: " + this.outputBuffers.length);
                if (this.hasDecodedFirstFrame) {
                    throw new RuntimeException("Unexpected output buffer change event.");
                }
            } else {
                continue;
            }
        }
        throw new RuntimeException("Unexpected size change. Configured " + this.width + PhoneConstants.APN_TYPE_ALL + this.height + ". New " + i4 + PhoneConstants.APN_TYPE_ALL + i5);
    }

    public static void disableH264HwCodec() {
        android.util.Log.w(TAG, "H.264 decoding is disabled by application.");
        hwDecoderDisabledTypes.add("video/avc");
    }

    public static void disableHEVCHwCodec() {
        android.util.Log.w(TAG, "HEVC decoding is disabled by application.");
        hwDecoderDisabledTypes.add("video/hevc");
    }

    public static void disableVp8HwCodec() {
        android.util.Log.w(TAG, "VP8 decoding is disabled by application.");
        hwDecoderDisabledTypes.add("video/x-vnd.on2.vp8");
    }

    public static void disableVp9HwCodec() {
        android.util.Log.w(TAG, "VP9 decoding is disabled by application.");
        hwDecoderDisabledTypes.add("video/x-vnd.on2.vp9");
    }

    /* JADX WARN: Code restructure failed: missing block: B:95:0x0250, code lost:
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static com.zego.ve.MediaCodecVideoDecoder.DecoderProperties findDecoder(java.lang.String r5, java.lang.String[] r6, int[] r7) {
        /*
            Method dump skipped, instructions count: 690
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zego.ve.MediaCodecVideoDecoder.findDecoder(java.lang.String, java.lang.String[], int[]):com.zego.ve.MediaCodecVideoDecoder$DecoderProperties");
    }

    private void flush() {
        android.util.Log.d(TAG, "Java flushDecoder");
        if (this.mediaCodecThread == null || this.mediaCodec == null) {
            android.util.Log.d(TAG, "Java decoder flush already release");
            return;
        }
        checkOnMediaCodecThread();
        try {
            this.mediaCodec.flush();
        } catch (Exception e) {
            android.util.Log.e(TAG, "Media decoder flush failed", e);
        }
    }

    public static String getCodecName() {
        return findDecoder("video/avc", supportedH264HwCodecPrefixes, supportedColorList).codecName;
    }

    private boolean initDecode(int i, int i2, int i3, ByteBuffer byteBuffer, Object obj) {
        String str;
        DecoderProperties findDecoder;
        String str2;
        if (this.mediaCodecThread != null) {
            return false;
        }
        if (i == 0) {
            str = "video/x-vnd.on2.vp8";
            findDecoder = findDecoder("video/x-vnd.on2.vp8", supportedVp8HwCodecPrefixes, supportedColorList);
            str2 = "vp8";
        } else if (i == 2) {
            str = "video/avc";
            findDecoder = findDecoder("video/avc", supportedH264HwCodecPrefixes, supportedColorList);
            str2 = "h264";
        } else if (i != 3) {
            str = "";
            str2 = "h264";
            findDecoder = null;
        } else {
            str = "video/hevc";
            findDecoder = findDecoder("video/hevc", supportedHEVCHwCodecPrefixes, supportedColorList);
            str2 = "hevc";
        }
        if (findDecoder == null) {
            return false;
        }
        android.util.Log.d(TAG, "Java initDecode, codec: " + str2 + " Color: 0x" + Integer.toHexString(findDecoder.colorFormat));
        runningInstance = this;
        this.mediaCodecThread = Thread.currentThread();
        try {
            MediaFormat createVideoFormat = MediaFormat.createVideoFormat(str, i2, i3);
            if (obj == null) {
                createVideoFormat.setInteger(MediaFormat.KEY_COLOR_FORMAT, findDecoder.colorFormat);
            } else if (SurfaceTexture.class.isInstance(obj)) {
                this.isImageReader = false;
                SurfaceTexture surfaceTexture = (SurfaceTexture) obj;
                if (Build.VERSION.SDK_INT >= 24) {
                    surfaceTexture.setDefaultBufferSize(i2, i3);
                }
                this.surface = new Surface(surfaceTexture);
            } else if (ImageReader.class.isInstance(obj)) {
                this.isImageReader = true;
                this.surface = ((ImageReader) obj).getSurface();
                createVideoFormat.setInteger(MediaFormat.KEY_COLOR_FORMAT, (Build.VERSION.SDK_INT < 21 || !findDecoder.codecName.startsWith("OMX")) ? findDecoder.colorFormat : 2135033992);
            }
            if (byteBuffer != null) {
                createVideoFormat.setByteBuffer("csd-0", byteBuffer);
            }
            android.util.Log.d(TAG, "  Format: " + createVideoFormat);
            MediaCodec createByCodecName = MediaCodecVideoEncoder.createByCodecName(findDecoder.codecName);
            this.mediaCodec = createByCodecName;
            if (createByCodecName == null) {
                android.util.Log.e(TAG, "Can not create media decoder: " + str2);
                return false;
            }
            createByCodecName.configure(createVideoFormat, this.surface, null, 0);
            this.mediaCodec.start();
            this.codecName = findDecoder.codecName;
            this.colorFormat = findDecoder.colorFormat;
            this.hasDecodedFirstFrame = false;
            if (Build.VERSION.SDK_INT < 21) {
                this.outputBuffers = this.mediaCodec.getOutputBuffers();
                this.inputBuffers = this.mediaCodec.getInputBuffers();
                android.util.Log.d(TAG, "Input buffers: " + this.inputBuffers.length + ". Output buffers: " + this.outputBuffers.length);
            }
            this.width = i2;
            this.height = i3;
            return true;
        } catch (Error e) {
            android.util.Log.e(TAG, "initDecode failed", e);
            printStackTrace();
            return false;
        } catch (Exception e2) {
            android.util.Log.e(TAG, "initDecode failed", e2);
            return false;
        }
    }

    public static boolean isH264HwSupported(boolean z) {
        enableWhitelist = z;
        return (hwDecoderDisabledTypes.contains("video/avc") || findDecoder("video/avc", supportedH264HwCodecPrefixes, supportedColorList) == null) ? false : true;
    }

    public static boolean isH264HwSupportedUsingTextures() {
        boolean z;
        DecoderProperties findDecoder = findDecoder("video/avc", supportedH264HwCodecPrefixes, supportedSurfaceColorList);
        if (findDecoder != null) {
            String[] strArr = HW_SURFACE_BLACKLISTS;
            int length = strArr.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    z = true;
                    break;
                }
                if (findDecoder.codecName.startsWith(strArr[i2])) {
                    break;
                }
                i = i2 + 1;
            }
        }
        z = false;
        return (hwDecoderDisabledTypes.contains("video/avc") || findDecoder == null || !z) ? false : true;
    }

    public static boolean isHEVCHwSupported(boolean z) {
        enableWhitelist = z;
        return (hwDecoderDisabledTypes.contains("video/hevc") || findDecoder("video/hevc", supportedHEVCHwCodecPrefixes, supportedColorList) == null) ? false : true;
    }

    public static boolean isVp8HwSupported(boolean z) {
        return (hwDecoderDisabledTypes.contains("video/x-vnd.on2.vp8") || findDecoder("video/x-vnd.on2.vp8", supportedVp8HwCodecPrefixes, supportedColorList) == null) ? false : true;
    }

    public static boolean isVp9HwSupported(boolean z) {
        return (hwDecoderDisabledTypes.contains("video/x-vnd.on2.vp9") || findDecoder("video/x-vnd.on2.vp9", supportedVp9HwCodecPrefixes, supportedColorList) == null) ? false : true;
    }

    public static void printStackTrace() {
        Thread thread;
        MediaCodecVideoDecoder mediaCodecVideoDecoder = runningInstance;
        if (mediaCodecVideoDecoder == null || (thread = mediaCodecVideoDecoder.mediaCodecThread) == null) {
            return;
        }
        StackTraceElement[] stackTrace = thread.getStackTrace();
        if (stackTrace.length <= 0) {
            return;
        }
        android.util.Log.d(TAG, "MediaCodecVideoDecoder stacks trace:");
        int length = stackTrace.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return;
            }
            android.util.Log.d(TAG, stackTrace[i2].toString());
            i = i2 + 1;
        }
    }

    private boolean queueConfig(int i, int i2) {
        checkOnMediaCodecThread();
        try {
            ByteBuffer byteBuffer = getByteBuffer(true, i);
            byteBuffer.position(0);
            byteBuffer.limit(i2);
            this.mediaCodec.queueInputBuffer(i, 0, i2, 0L, 2);
            return true;
        } catch (IllegalStateException e) {
            android.util.Log.e(TAG, "decode failed", e);
            return false;
        }
    }

    private boolean queueEOS(int i) {
        checkOnMediaCodecThread();
        try {
            ByteBuffer byteBuffer = getByteBuffer(true, i);
            byteBuffer.position(0);
            byteBuffer.limit(0);
            this.mediaCodec.queueInputBuffer(i, 0, 0, 0L, 4);
            return true;
        } catch (IllegalStateException e) {
            android.util.Log.e(TAG, "decode failed", e);
            return false;
        }
    }

    private boolean queueInputBuffer(int i, int i2, long j) {
        checkOnMediaCodecThread();
        try {
            ByteBuffer byteBuffer = getByteBuffer(true, i);
            byteBuffer.position(0);
            byteBuffer.limit(i2);
            this.mediaCodec.queueInputBuffer(i, 0, i2, j, 0);
            return true;
        } catch (IllegalStateException e) {
            android.util.Log.e(TAG, "decode failed", e);
            return false;
        }
    }

    private void release() {
        android.util.Log.d(TAG, "Java releaseDecoder");
        if (this.mediaCodecThread == null || this.mediaCodec == null) {
            android.util.Log.d(TAG, "Java decoder already release");
            return;
        }
        checkOnMediaCodecThread();
        if (this.mediaCodec != null) {
            final CountDownLatch countDownLatch = new CountDownLatch(1);
            new Thread(new Runnable() { // from class: com.zego.ve.MediaCodecVideoDecoder.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        try {
                            android.util.Log.d(MediaCodecVideoDecoder.TAG, "Java releaseDecoder on release thread");
                            MediaCodecVideoDecoder.this.mediaCodec.stop();
                        } catch (Exception e) {
                            android.util.Log.e(MediaCodecVideoDecoder.TAG, "Media decoder stop failed", e);
                        }
                        MediaCodecVideoDecoder.this.mediaCodec.release();
                        MediaCodecVideoDecoder.this.mediaCodec = null;
                        android.util.Log.d(MediaCodecVideoDecoder.TAG, "Java releaseDecoder on release thread done");
                        if (!MediaCodecVideoDecoder.this.isImageReader && MediaCodecVideoDecoder.this.surface != null) {
                            MediaCodecVideoDecoder.this.surface.release();
                            MediaCodecVideoDecoder.this.surface = null;
                        }
                        countDownLatch.countDown();
                    } catch (Throwable th) {
                        MediaCodecVideoDecoder.this.mediaCodec.release();
                        MediaCodecVideoDecoder.this.mediaCodec = null;
                        android.util.Log.d(MediaCodecVideoDecoder.TAG, "Java releaseDecoder on release thread done");
                        throw th;
                    }
                }
            }).start();
            if (!ThreadUtils.awaitUninterruptibly(countDownLatch, 5000L)) {
                android.util.Log.e(TAG, "Media decoder release timeout");
                codecErrors++;
                if (errorCallback != null) {
                    android.util.Log.e(TAG, "Invoke codec error callback. Errors: " + codecErrors);
                    errorCallback.onMediaCodecVideoDecoderCriticalError(codecErrors);
                }
            }
        }
        this.mediaCodecThread = null;
        runningInstance = null;
        android.util.Log.d(TAG, "Java releaseDecoder done");
    }

    public static void setErrorCallback(MediaCodecVideoDecoderErrorCallback mediaCodecVideoDecoderErrorCallback) {
        android.util.Log.d(TAG, "Set error callback");
        errorCallback = mediaCodecVideoDecoderErrorCallback;
    }

    private boolean surfaceIsImageReader(Object obj) {
        return ImageReader.class.isInstance(obj);
    }

    ByteBuffer getByteBuffer(boolean z, int i) {
        return Build.VERSION.SDK_INT >= 21 ? z ? this.mediaCodec.getInputBuffer(i) : this.mediaCodec.getOutputBuffer(i) : z ? this.inputBuffers[i] : this.outputBuffers[i];
    }

    public boolean returnDecodedOutputBuffer(int i) {
        checkOnMediaCodecThread();
        try {
            this.mediaCodec.releaseOutputBuffer(i, this.surface != null);
            return true;
        } catch (IllegalStateException e) {
            android.util.Log.e(TAG, "releaseOutputBuffer failed", e);
            return false;
        }
    }
}
