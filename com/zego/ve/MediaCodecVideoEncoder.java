package com.zego.ve;

import android.media.Image;
import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaFormat;
import android.os.Build;
import android.os.Bundle;
import android.view.Surface;
import java.nio.ByteBuffer;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CountDownLatch;

/* loaded from: source-8829756-dex2jar.jar:com/zego/ve/MediaCodecVideoEncoder.class */
public class MediaCodecVideoEncoder extends MediaCodec.Callback {
    private static final double BITRATE_CORRECTION_MAX_SCALE = 2.0d;
    private static final double BITRATE_CORRECTION_SEC = 3.0d;
    private static final int BITRATE_CORRECTION_STEPS = 10;
    private static final int COLOR_FormatYUV420Flexible = 2135033992;
    private static final int COLOR_QCOM_FORMATYUV420PackedSemiPlanar32m = 2141391876;
    private static final int DEQUEUE_TIMEOUT = 0;
    private static final String[] H264_HW_EXCEPTION_MODELS;
    private static final String H264_MIME_TYPE = "video/avc";
    private static final String[] H265_HW_EXCEPTION_MODELS;
    private static final String HEVC_MIME_TYPE = "video/hevc";
    private static final String[] HW_BLACKLISTS;
    private static final int MAXIMUM_INITIAL_FPS = 60;
    private static final int MEDIA_CODEC_RELEASE_TIMEOUT_MS = 5000;
    private static final String TAG = "MediaCodecVideoEncoder";
    private static final int VIDEO_ControlRateCQ = 0;
    private static final int VIDEO_ControlRateConstant = 2;
    private static final int VIDEO_ControlRateVariable = 1;
    private static final String VP8_MIME_TYPE = "video/x-vnd.on2.vp8";
    private static final String VP9_MIME_TYPE = "video/x-vnd.on2.vp9";
    private static final MediaCodecProperties amlogicH264HwProperties;
    private static int codecErrors;
    private static boolean enableWhitelist;
    private static MediaCodecVideoEncoderErrorCallback errorCallback;
    private static final MediaCodecProperties exynosH264HwProperties;
    private static final MediaCodecProperties exynosHEVCHwProperties;
    private static final MediaCodecProperties freescaleH264HwProperties;
    private static final MediaCodecProperties[] h264HwList;
    private static final MediaCodecProperties[] hevcHwList;
    private static final MediaCodecProperties intelH264HwProperties;
    private static final MediaCodecProperties intelVp8HwProperties;
    private static final MediaCodecProperties kirin960H264HwProperties;
    private static final MediaCodecProperties kirin960HEVCHwProperties;
    private static final MediaCodecProperties kirinH264HwProperties;
    private static final MediaCodecProperties kirinHEVCHwProperties;
    private static final MediaCodecProperties mstarH264HwProperties;
    private static final MediaCodecProperties mtkH264HwProperties;
    private static final MediaCodecProperties mtkHEVCHwProperties;
    private static final MediaCodecProperties nvidiaH264HwProperties;
    private static final MediaCodecProperties qcomH264HwProperties;
    private static final MediaCodecProperties qcomHEVCHwProperties;
    private static final MediaCodecProperties rkH264HwProperties;
    private static MediaCodecVideoEncoder runningInstance;
    private static final MediaCodecProperties sprdH264HwProperties;
    private static final int[] supportedColorList;
    private static final int[] supportedSurfaceColorList;
    private static final MediaCodecProperties tiH264HwProperties;
    private static final MediaCodecProperties[] vp8HwList;
    private static final MediaCodecProperties winnerH264HwProperties;
    private double bitrateAccumulator;
    private double bitrateAccumulatorMax;
    private int bitrateAdjustmentScaleExp;
    private double bitrateObservationTimeMs;
    private int colorFormat;
    private long forcedKeyFrameMs;
    private int height;
    private ByteBuffer[] inputBuffers;
    private Surface inputSurface;
    private long lastKeyFrameMs;
    private MediaCodec mediaCodec;
    private Thread mediaCodecThread;
    private int originFps;
    private ByteBuffer[] outputBuffers;
    private int sliceHeight;
    private int stride;
    private int targetBitrateBps;
    private int targetFps;
    private VideoCodecType type;
    private int width;
    private static Set<String> hwEncoderDisabledTypes = new HashSet();
    private static final MediaCodecProperties qcomVp8HwProperties = new MediaCodecProperties("OMX.qcom.", 19, BitrateAdjustmentType.NO_ADJUSTMENT);
    private static final MediaCodecProperties exynosVp8HwProperties = new MediaCodecProperties("OMX.Exynos.", 23, BitrateAdjustmentType.NO_ADJUSTMENT);
    private BitrateAdjustmentType bitrateAdjustmentType = BitrateAdjustmentType.NO_ADJUSTMENT;
    private ByteBuffer configData = null;
    private VImage cacheImage = new VImage();
    private boolean isRunning = false;
    private long pthis = 0;

    /* loaded from: source-8829756-dex2jar.jar:com/zego/ve/MediaCodecVideoEncoder$BitrateAdjustmentType.class */
    public enum BitrateAdjustmentType {
        NO_ADJUSTMENT,
        FRAMERATE_ADJUSTMENT,
        DYNAMIC_ADJUSTMENT
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/zego/ve/MediaCodecVideoEncoder$EncoderProperties.class */
    public static class EncoderProperties {
        public final BitrateAdjustmentType bitrateAdjustmentType;
        public final String codecName;
        public final int colorFormat;
        public final int rcMode;
        public final boolean supportedHighProfile;
        public final boolean supportedProfile;

        public EncoderProperties(String str, int i, BitrateAdjustmentType bitrateAdjustmentType, int i2, boolean z, boolean z2) {
            this.codecName = str;
            this.colorFormat = i;
            this.bitrateAdjustmentType = bitrateAdjustmentType;
            this.rcMode = i2;
            this.supportedProfile = z;
            this.supportedHighProfile = z2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8829756-dex2jar.jar:com/zego/ve/MediaCodecVideoEncoder$MediaCodecProperties.class */
    public static class MediaCodecProperties {
        public final BitrateAdjustmentType bitrateAdjustmentType;
        public final String codecPrefix;
        public final int minSdk;

        MediaCodecProperties(String str, int i, BitrateAdjustmentType bitrateAdjustmentType) {
            this.codecPrefix = str;
            this.minSdk = i;
            this.bitrateAdjustmentType = bitrateAdjustmentType;
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/zego/ve/MediaCodecVideoEncoder$MediaCodecVideoEncoderErrorCallback.class */
    public interface MediaCodecVideoEncoderErrorCallback {
        void onMediaCodecVideoEncoderCriticalError(int i);
    }

    /* loaded from: source-8829756-dex2jar.jar:com/zego/ve/MediaCodecVideoEncoder$OutputBufferInfo.class */
    static class OutputBufferInfo {
        public final ByteBuffer buffer;
        public final int index;
        public final boolean isKeyFrame;
        public final long presentationTimestampUs;
        public final int size;

        public OutputBufferInfo(int i, ByteBuffer byteBuffer, int i2, boolean z, long j) {
            this.index = i;
            this.buffer = byteBuffer;
            this.size = i2;
            this.isKeyFrame = z;
            this.presentationTimestampUs = j;
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/zego/ve/MediaCodecVideoEncoder$VImage.class */
    static class VImage {
        private boolean isI420;
        private ByteBuffer uBuffer;
        private int uStride;
        private ByteBuffer vBuffer;
        private int vStride;
        private ByteBuffer yBuffer;
        private int yStride;

        private VImage() {
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/zego/ve/MediaCodecVideoEncoder$VideoCodecType.class */
    public enum VideoCodecType {
        VIDEO_CODEC_H264_AVC,
        VIDEO_CODEC_H264_AVC_MULTILAYER,
        VIDEO_CODEC_H265,
        VIDEO_CODEC_VP8
    }

    static {
        MediaCodecProperties mediaCodecProperties = new MediaCodecProperties("OMX.Intel.", 21, BitrateAdjustmentType.NO_ADJUSTMENT);
        intelVp8HwProperties = mediaCodecProperties;
        vp8HwList = new MediaCodecProperties[]{qcomVp8HwProperties, exynosVp8HwProperties, mediaCodecProperties};
        qcomH264HwProperties = new MediaCodecProperties("OMX.qcom.", 19, BitrateAdjustmentType.NO_ADJUSTMENT);
        exynosH264HwProperties = new MediaCodecProperties("OMX.Exynos.", 21, BitrateAdjustmentType.NO_ADJUSTMENT);
        mtkH264HwProperties = new MediaCodecProperties("OMX.MTK.", 19, BitrateAdjustmentType.NO_ADJUSTMENT);
        kirinH264HwProperties = new MediaCodecProperties("OMX.IMG.", 19, BitrateAdjustmentType.NO_ADJUSTMENT);
        rkH264HwProperties = new MediaCodecProperties("OMX.rk.", 19, BitrateAdjustmentType.NO_ADJUSTMENT);
        kirin960H264HwProperties = new MediaCodecProperties("OMX.hisi.", 19, BitrateAdjustmentType.NO_ADJUSTMENT);
        winnerH264HwProperties = new MediaCodecProperties("OMX.allwinner.", 19, BitrateAdjustmentType.NO_ADJUSTMENT);
        tiH264HwProperties = new MediaCodecProperties("OMX.TI.", 19, BitrateAdjustmentType.NO_ADJUSTMENT);
        mstarH264HwProperties = new MediaCodecProperties("OMX.MS.", 19, BitrateAdjustmentType.NO_ADJUSTMENT);
        freescaleH264HwProperties = new MediaCodecProperties("OMX.Freescale.", 19, BitrateAdjustmentType.NO_ADJUSTMENT);
        sprdH264HwProperties = new MediaCodecProperties("OMX.sprd.", 19, BitrateAdjustmentType.NO_ADJUSTMENT);
        amlogicH264HwProperties = new MediaCodecProperties("OMX.amlogic.", 19, BitrateAdjustmentType.NO_ADJUSTMENT);
        intelH264HwProperties = new MediaCodecProperties("OMX.Intel.", 19, BitrateAdjustmentType.NO_ADJUSTMENT);
        MediaCodecProperties mediaCodecProperties2 = new MediaCodecProperties("OMX.Nvidia.", 19, BitrateAdjustmentType.NO_ADJUSTMENT);
        nvidiaH264HwProperties = mediaCodecProperties2;
        h264HwList = new MediaCodecProperties[]{qcomH264HwProperties, exynosH264HwProperties, mtkH264HwProperties, kirinH264HwProperties, kirin960H264HwProperties, tiH264HwProperties, intelH264HwProperties, mediaCodecProperties2, rkH264HwProperties, winnerH264HwProperties, mstarH264HwProperties, freescaleH264HwProperties, sprdH264HwProperties, amlogicH264HwProperties};
        qcomHEVCHwProperties = new MediaCodecProperties("OMX.qcom.", 21, BitrateAdjustmentType.NO_ADJUSTMENT);
        kirin960HEVCHwProperties = new MediaCodecProperties("OMX.hisi.", 21, BitrateAdjustmentType.NO_ADJUSTMENT);
        kirinHEVCHwProperties = new MediaCodecProperties("OMX.IMG.", 21, BitrateAdjustmentType.NO_ADJUSTMENT);
        mtkHEVCHwProperties = new MediaCodecProperties("OMX.MTK.", 21, BitrateAdjustmentType.NO_ADJUSTMENT);
        MediaCodecProperties mediaCodecProperties3 = new MediaCodecProperties("OMX.Exynos.", 21, BitrateAdjustmentType.NO_ADJUSTMENT);
        exynosHEVCHwProperties = mediaCodecProperties3;
        hevcHwList = new MediaCodecProperties[]{qcomHEVCHwProperties, kirin960HEVCHwProperties, kirinHEVCHwProperties, mtkHEVCHwProperties, mediaCodecProperties3};
        H264_HW_EXCEPTION_MODELS = new String[]{"SAMSUNG-SGH-I337", "Nexus 7", "Nexus 4", "EML-AL00", "XT1079", "PACM00", "SM-G9250", "V1818CA"};
        H265_HW_EXCEPTION_MODELS = new String[]{"V1818CA", "X600"};
        enableWhitelist = true;
        HW_BLACKLISTS = new String[]{"omx.google.", "omx.ffmpeg.", "omx.pv", "omx.k3.ffmpeg.", "omx.avcodec.", "omx.ittiam.", "omx.sec.avc.sw.", "omx.marvell.video.h264encoder"};
        supportedColorList = new int[]{21, 2135033992, MediaCodecInfo.CodecCapabilities.COLOR_QCOM_FormatYUV420SemiPlanar, COLOR_QCOM_FORMATYUV420PackedSemiPlanar32m, 19, 20, MediaCodecInfo.CodecCapabilities.COLOR_TI_FormatYUV420PackedSemiPlanar, MediaCodecInfo.CodecCapabilities.COLOR_FormatSurface};
        supportedSurfaceColorList = new int[]{MediaCodecInfo.CodecCapabilities.COLOR_FormatSurface};
    }

    private void checkOnMediaCodecThread() {
        if (this.mediaCodecThread.getId() == Thread.currentThread().getId()) {
            return;
        }
        throw new RuntimeException("MediaCodecVideoEncoder previously operated on " + this.mediaCodecThread + " but is now called on " + Thread.currentThread());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static MediaCodec createByCodecName(String str) {
        try {
            return MediaCodec.createByCodecName(str);
        } catch (Exception e) {
            return null;
        }
    }

    public static void disableH264HwCodec() {
        android.util.Log.w(TAG, "H.264 encoding is disabled by application.");
        hwEncoderDisabledTypes.add("video/avc");
    }

    public static void disableHEVCHwCodec() {
        android.util.Log.w(TAG, "HEVC encoding is disabled by application.");
        hwEncoderDisabledTypes.add("video/hevc");
    }

    public static void disableVp8HwCodec() {
        android.util.Log.w(TAG, "VP8 encoding is disabled by application.");
        hwEncoderDisabledTypes.add("video/x-vnd.on2.vp8");
    }

    public static void disableVp9HwCodec() {
        android.util.Log.w(TAG, "VP9 encoding is disabled by application.");
        hwEncoderDisabledTypes.add("video/x-vnd.on2.vp9");
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x0361, code lost:
        if (r9.equals("video/avc") == false) goto L98;
     */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x0364, code lost:
        r0 = android.media.MediaFormat.createVideoFormat(r9, 640, 480);
        r0.setInteger(android.media.MediaFormat.KEY_PROFILE, 1);
        r20 = r0.isFormatSupported(r0);
        r0.setInteger(android.media.MediaFormat.KEY_PROFILE, 8);
        r21 = r0.isFormatSupported(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x03a5, code lost:
        return new com.zego.ve.MediaCodecVideoEncoder.EncoderProperties(r23, r0, r22, r12, r20, r21);
     */
    /* JADX WARN: Code restructure failed: missing block: B:122:0x03f0, code lost:
        r13 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:123:0x03f6, code lost:
        r20 = false;
        r21 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:125:0x03fe, code lost:
        if (r13 != false) goto L95;
     */
    /* JADX WARN: Code restructure failed: missing block: B:127:0x0403, code lost:
        if (r12 == (-1)) goto L95;
     */
    /* JADX WARN: Code restructure failed: missing block: B:128:0x0406, code lost:
        r12 = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x02be, code lost:
        android.util.Log.d(com.zego.ve.MediaCodecVideoEncoder.TAG, "Found target encoder for mime " + r9 + " : " + r23 + ". Color: 0x" + java.lang.Integer.toHexString(r0) + ". Bitrate adjustment: " + r22);
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x0313, code lost:
        if (android.os.Build.VERSION.SDK_INT < 21) goto L99;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x0316, code lost:
        r0 = r0.getEncoderCapabilities();
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x031d, code lost:
        if (r0 == null) goto L99;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x0322, code lost:
        if (r12 == (-1)) goto L99;
     */
    /* JADX WARN: Code restructure failed: missing block: B:94:0x032a, code lost:
        if (r0.isBitrateModeSupported(r12) == false) goto L99;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x032d, code lost:
        android.util.Log.d(com.zego.ve.MediaCodecVideoEncoder.TAG, r12 + "mode is supported");
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x034e, code lost:
        r13 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x0358, code lost:
        if (android.os.Build.VERSION.SDK_INT < 23) goto L98;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static com.zego.ve.MediaCodecVideoEncoder.EncoderProperties findHwEncoder(java.lang.String r9, com.zego.ve.MediaCodecVideoEncoder.MediaCodecProperties[] r10, int[] r11, int r12) {
        /*
            Method dump skipped, instructions count: 1056
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zego.ve.MediaCodecVideoEncoder.findHwEncoder(java.lang.String, com.zego.ve.MediaCodecVideoEncoder$MediaCodecProperties[], int[], int):com.zego.ve.MediaCodecVideoEncoder$EncoderProperties");
    }

    private double getBitrateScale(int i) {
        return Math.pow(BITRATE_CORRECTION_MAX_SCALE, i / 10.0d);
    }

    public static String getCodecName() {
        return findHwEncoder("video/avc", h264HwList, supportedColorList, -1).codecName;
    }

    private int getProfileType(String str, int i, int i2) {
        if (i != 0) {
            i2 = 8;
        }
        int i3 = str.equals("main") ? 2 : str.equals("high") ? 8 : str.equals("high10") ? 16 : str.equals("high422") ? 32 : str.equals("high444") ? 64 : str.equals("extended") ? 4 : i2;
        android.util.Log.d(TAG, "profile: " + str + ", " + i3);
        return i3;
    }

    public static boolean isH264HwSupported(boolean z) {
        enableWhitelist = z;
        return (hwEncoderDisabledTypes.contains("video/avc") || findHwEncoder("video/avc", h264HwList, supportedColorList, -1) == null) ? false : true;
    }

    public static boolean isH264HwSupportedUsingTextures() {
        return (hwEncoderDisabledTypes.contains("video/avc") || findHwEncoder("video/avc", h264HwList, supportedSurfaceColorList, -1) == null) ? false : true;
    }

    public static boolean isHEVCHwSupported(boolean z) {
        enableWhitelist = z;
        return (hwEncoderDisabledTypes.contains("video/hevc") || findHwEncoder("video/hevc", hevcHwList, supportedColorList, -1) == null) ? false : true;
    }

    public static boolean isVp8HwSupported(boolean z) {
        return false;
    }

    private static native int on_error(long j, int i);

    private static native int on_input_buffer_available(long j, int i);

    private static native int on_output_buffer_available(long j, OutputBufferInfo outputBufferInfo);

    public static void printStackTrace() {
        Thread thread;
        MediaCodecVideoEncoder mediaCodecVideoEncoder = runningInstance;
        if (mediaCodecVideoEncoder == null || (thread = mediaCodecVideoEncoder.mediaCodecThread) == null) {
            return;
        }
        StackTraceElement[] stackTrace = thread.getStackTrace();
        if (stackTrace.length <= 0) {
            return;
        }
        android.util.Log.d(TAG, "MediaCodecVideoEncoder stacks trace:");
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

    /* JADX WARN: Removed duplicated region for block: B:18:0x0123  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void reportEncodedFrame(int r9) {
        /*
            Method dump skipped, instructions count: 401
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zego.ve.MediaCodecVideoEncoder.reportEncodedFrame(int):void");
    }

    public static void setErrorCallback(MediaCodecVideoEncoderErrorCallback mediaCodecVideoEncoderErrorCallback) {
        android.util.Log.d(TAG, "Set error callback");
        errorCallback = mediaCodecVideoEncoderErrorCallback;
    }

    private boolean setRates(int i, int i2) {
        int i3;
        int i4;
        checkOnMediaCodecThread();
        if (this.bitrateAdjustmentType == BitrateAdjustmentType.DYNAMIC_ADJUSTMENT) {
            double d = i;
            this.bitrateAccumulatorMax = d / 8.0d;
            int i5 = this.targetBitrateBps;
            if (i5 > 0 && i < i5) {
                this.bitrateAccumulator = (this.bitrateAccumulator * d) / i5;
            }
        }
        this.targetBitrateBps = i;
        this.targetFps = i2;
        if (this.bitrateAdjustmentType == BitrateAdjustmentType.FRAMERATE_ADJUSTMENT && (i4 = this.targetFps) > 0) {
            i3 = (this.originFps * this.targetBitrateBps) / i4;
            android.util.Log.v(TAG, "setRates: " + (i / 1000) + " -> " + (i3 / 1000) + " kbps. Fps: " + this.targetFps);
        } else if (this.bitrateAdjustmentType == BitrateAdjustmentType.DYNAMIC_ADJUSTMENT) {
            android.util.Log.v(TAG, "setRates: " + (i / 1000) + " kbps. Fps: " + this.targetFps + ". ExpScale: " + this.bitrateAdjustmentScaleExp);
            int i6 = this.bitrateAdjustmentScaleExp;
            i3 = i;
            if (i6 != 0) {
                i3 = (int) (i * getBitrateScale(i6));
            }
        } else {
            android.util.Log.v(TAG, "setRates: " + (i / 1000) + " kbps. Fps: " + this.targetFps);
            i3 = i;
        }
        try {
            Bundle bundle = new Bundle();
            bundle.putInt(MediaCodec.PARAMETER_KEY_VIDEO_BITRATE, i3);
            this.mediaCodec.setParameters(bundle);
            return true;
        } catch (IllegalStateException e) {
            android.util.Log.e(TAG, "setRates failed", e);
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0057  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    void checkKeyFrameRequired(boolean r8, long r9) {
        /*
            r7 = this;
            r0 = r9
            r1 = 500(0x1f4, double:2.47E-321)
            long r0 = r0 + r1
            r1 = 1000(0x3e8, double:4.94E-321)
            long r0 = r0 / r1
            r9 = r0
            r0 = r7
            long r0 = r0.lastKeyFrameMs
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 >= 0) goto L18
            r0 = r7
            r1 = r9
            r0.lastKeyFrameMs = r1
        L18:
            r0 = r8
            if (r0 != 0) goto L3b
            r0 = r7
            long r0 = r0.forcedKeyFrameMs
            r12 = r0
            r0 = r12
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 <= 0) goto L3b
            r0 = r9
            r1 = r7
            long r1 = r1.lastKeyFrameMs
            r2 = r12
            long r1 = r1 + r2
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 <= 0) goto L3b
            r0 = 1
            r11 = r0
            goto L3e
        L3b:
            r0 = 0
            r11 = r0
        L3e:
            r0 = r8
            if (r0 != 0) goto L47
            r0 = r11
            if (r0 == 0) goto L80
        L47:
            r0 = r8
            if (r0 == 0) goto L57
            java.lang.String r0 = "MediaCodecVideoEncoder"
            java.lang.String r1 = "Sync frame request"
            int r0 = android.util.Log.d(r0, r1)
            goto L60
        L57:
            java.lang.String r0 = "MediaCodecVideoEncoder"
            java.lang.String r1 = "Sync frame forced"
            int r0 = android.util.Log.d(r0, r1)
        L60:
            android.os.Bundle r0 = new android.os.Bundle
            r1 = r0
            r1.<init>()
            r14 = r0
            r0 = r14
            java.lang.String r1 = "request-sync"
            r2 = 0
            r0.putInt(r1, r2)
            r0 = r7
            android.media.MediaCodec r0 = r0.mediaCodec
            r1 = r14
            r0.setParameters(r1)
            r0 = r7
            r1 = r9
            r0.lastKeyFrameMs = r1
        L80:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zego.ve.MediaCodecVideoEncoder.checkKeyFrameRequired(boolean, long):void");
    }

    int dequeueInputBuffer() {
        checkOnMediaCodecThread();
        try {
            return this.mediaCodec.dequeueInputBuffer(0L);
        } catch (IllegalStateException e) {
            android.util.Log.e(TAG, "dequeueIntputBuffer failed" + e.getMessage());
            return -2;
        }
    }

    OutputBufferInfo dequeueOutputBuffer() {
        checkOnMediaCodecThread();
        try {
            MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
            int dequeueOutputBuffer = this.mediaCodec.dequeueOutputBuffer(bufferInfo, 0L);
            boolean z = false;
            int i = dequeueOutputBuffer;
            if (dequeueOutputBuffer >= 0) {
                i = dequeueOutputBuffer;
                if ((bufferInfo.flags & 2) != 0) {
                    android.util.Log.d(TAG, "Config frame generated. Offset: " + bufferInfo.offset + ". Size: " + bufferInfo.size);
                    this.configData = ByteBuffer.allocateDirect(bufferInfo.size);
                    ByteBuffer byteBuffer = getByteBuffer(false, dequeueOutputBuffer);
                    byteBuffer.position(bufferInfo.offset);
                    byteBuffer.limit(bufferInfo.offset + bufferInfo.size);
                    this.configData.put(byteBuffer);
                    this.mediaCodec.releaseOutputBuffer(dequeueOutputBuffer, false);
                    i = this.mediaCodec.dequeueOutputBuffer(bufferInfo, 0L);
                }
            }
            if (i >= 0) {
                ByteBuffer duplicate = getByteBuffer(false, i).duplicate();
                duplicate.position(bufferInfo.offset);
                duplicate.limit(bufferInfo.offset + bufferInfo.size);
                reportEncodedFrame(bufferInfo.size);
                if ((bufferInfo.flags & 1) != 0) {
                    z = true;
                }
                return new OutputBufferInfo(i, duplicate.slice(), bufferInfo.size, z, bufferInfo.presentationTimeUs);
            } else if (i == -3) {
                if (Build.VERSION.SDK_INT < 21) {
                    this.outputBuffers = this.mediaCodec.getOutputBuffers();
                }
                return dequeueOutputBuffer();
            } else if (i == -2) {
                return dequeueOutputBuffer();
            } else {
                if (i == -1) {
                    return null;
                }
                throw new RuntimeException("dequeueOutputBuffer: " + i);
            }
        } catch (IllegalStateException e) {
            android.util.Log.e(TAG, "dequeueOutputBuffer failed", e);
            return new OutputBufferInfo(-1, null, -1, false, -1L);
        }
    }

    boolean encodeBuffer(boolean z, int i, int i2, long j) {
        checkOnMediaCodecThread();
        try {
            checkKeyFrameRequired(z, j);
            this.mediaCodec.queueInputBuffer(i, 0, i2, j, 0);
            return true;
        } catch (IllegalStateException e) {
            e.printStackTrace();
            android.util.Log.e(TAG, "encodeBuffer failed", e);
            return false;
        }
    }

    boolean encodeTexture(boolean z, int i, float[] fArr, long j) {
        checkOnMediaCodecThread();
        try {
            checkKeyFrameRequired(z, j);
            return true;
        } catch (RuntimeException e) {
            android.util.Log.e(TAG, "encodeTexture failed", e);
            return false;
        }
    }

    ByteBuffer getByteBuffer(boolean z, int i) {
        return Build.VERSION.SDK_INT >= 21 ? z ? this.mediaCodec.getInputBuffer(i) : this.mediaCodec.getOutputBuffer(i) : z ? this.inputBuffers[i] : this.outputBuffers[i];
    }

    VImage getImage(int i) {
        Image.Plane[] planes = this.mediaCodec.getInputImage(i).getPlanes();
        this.cacheImage.yBuffer = planes[0].getBuffer();
        this.cacheImage.yStride = planes[0].getRowStride();
        this.cacheImage.uBuffer = planes[1].getBuffer();
        this.cacheImage.uStride = planes[1].getRowStride();
        this.cacheImage.vBuffer = planes[2].getBuffer();
        this.cacheImage.vStride = planes[2].getRowStride();
        if (planes[1].getPixelStride() == 1 && planes[2].getPixelStride() == 1) {
            this.cacheImage.isI420 = true;
        } else {
            this.cacheImage.isI420 = false;
        }
        return this.cacheImage;
    }

    /* JADX WARN: Removed duplicated region for block: B:113:0x051b  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x020c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    boolean initEncode(int r7, int r8, int r9, int r10, int r11, boolean r12, int r13, int r14, java.lang.String r15, int r16, boolean r17) {
        /*
            Method dump skipped, instructions count: 1367
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zego.ve.MediaCodecVideoEncoder.initEncode(int, int, int, int, int, boolean, int, int, java.lang.String, int, boolean):boolean");
    }

    @Override // android.media.MediaCodec.Callback
    public void onError(MediaCodec mediaCodec, MediaCodec.CodecException codecException) {
        MediaCodec mediaCodec2;
        if (this.isRunning && (mediaCodec2 = this.mediaCodec) != null && mediaCodec.equals(mediaCodec2)) {
            printStackTrace();
            on_error(this.pthis, -1);
        }
    }

    @Override // android.media.MediaCodec.Callback
    public void onInputBufferAvailable(MediaCodec mediaCodec, int i) {
        MediaCodec mediaCodec2;
        if (this.isRunning && (mediaCodec2 = this.mediaCodec) != null && mediaCodec.equals(mediaCodec2)) {
            on_input_buffer_available(this.pthis, i);
        }
    }

    @Override // android.media.MediaCodec.Callback
    public void onOutputBufferAvailable(MediaCodec mediaCodec, int i, MediaCodec.BufferInfo bufferInfo) {
        MediaCodec mediaCodec2;
        if (this.isRunning && (mediaCodec2 = this.mediaCodec) != null && mediaCodec.equals(mediaCodec2)) {
            if (!((bufferInfo.flags & 2) != 0)) {
                ByteBuffer duplicate = getByteBuffer(false, i).duplicate();
                duplicate.position(bufferInfo.offset);
                duplicate.limit(bufferInfo.offset + bufferInfo.size);
                reportEncodedFrame(bufferInfo.size);
                on_output_buffer_available(this.pthis, new OutputBufferInfo(i, duplicate.slice(), bufferInfo.size, (bufferInfo.flags & 1) != 0, bufferInfo.presentationTimeUs));
                return;
            }
            android.util.Log.i(TAG, "Config frame generated. Offset: " + bufferInfo.offset + ". Size: " + bufferInfo.size);
            this.configData = ByteBuffer.allocateDirect(bufferInfo.size);
            ByteBuffer byteBuffer = getByteBuffer(false, i);
            byteBuffer.position(bufferInfo.offset);
            byteBuffer.limit(bufferInfo.offset + bufferInfo.size);
            this.configData.put(byteBuffer);
            this.mediaCodec.releaseOutputBuffer(i, false);
        }
    }

    @Override // android.media.MediaCodec.Callback
    public void onOutputFormatChanged(MediaCodec mediaCodec, MediaFormat mediaFormat) {
    }

    void release() {
        if (this.mediaCodecThread == null) {
            return;
        }
        android.util.Log.d(TAG, "Java releaseEncoder");
        checkOnMediaCodecThread();
        this.isRunning = false;
        if (this.mediaCodec != null) {
            Surface surface = this.inputSurface;
            if (surface != null) {
                surface.release();
                this.inputSurface = null;
            }
            final CountDownLatch countDownLatch = new CountDownLatch(1);
            new Thread(new Runnable() { // from class: com.zego.ve.MediaCodecVideoEncoder.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        android.util.Log.d(MediaCodecVideoEncoder.TAG, "Java releaseEncoder on release thread");
                        MediaCodecVideoEncoder.this.mediaCodec.stop();
                        MediaCodecVideoEncoder.this.mediaCodec.release();
                        MediaCodecVideoEncoder.this.mediaCodec = null;
                        android.util.Log.d(MediaCodecVideoEncoder.TAG, "Java releaseEncoder on release thread done");
                    } catch (Exception e) {
                        android.util.Log.e(MediaCodecVideoEncoder.TAG, "Media encoder release failed", e);
                    }
                    countDownLatch.countDown();
                }
            }).start();
            if (!ThreadUtils.awaitUninterruptibly(countDownLatch, 5000L)) {
                android.util.Log.e(TAG, "Media encoder release timeout");
                codecErrors++;
                if (errorCallback != null) {
                    android.util.Log.e(TAG, "Invoke codec error callback. Errors: " + codecErrors);
                    errorCallback.onMediaCodecVideoEncoderCriticalError(codecErrors);
                }
            }
        }
        this.mediaCodecThread = null;
        runningInstance = null;
        android.util.Log.d(TAG, "Java releaseEncoder done");
    }

    boolean releaseOutputBuffer(int i) {
        checkOnMediaCodecThread();
        try {
            this.mediaCodec.releaseOutputBuffer(i, false);
            return true;
        } catch (IllegalStateException e) {
            android.util.Log.e(TAG, "releaseOutputBuffer failed", e);
            return false;
        }
    }

    public int setThis(long j) {
        this.pthis = j;
        return 0;
    }

    void signalEOS() {
        MediaCodec mediaCodec = this.mediaCodec;
        if (mediaCodec == null) {
            return;
        }
        if (this.inputSurface != null) {
            mediaCodec.signalEndOfInputStream();
            return;
        }
        int dequeueInputBuffer = dequeueInputBuffer();
        while (dequeueInputBuffer == -1) {
            try {
                Thread.sleep(100L);
                dequeueInputBuffer = dequeueInputBuffer();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        if (dequeueInputBuffer >= 0) {
            this.mediaCodec.queueInputBuffer(dequeueInputBuffer, 0, 0, 0L, 4);
        }
    }
}
