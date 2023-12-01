package com.tencent.thumbplayer.core.decoder;

import android.media.Image;
import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaFormat;
import android.os.BatteryManager;
import android.os.Build;
import android.view.Surface;
import com.tencent.thumbplayer.core.common.TPCodecUtils;
import com.tencent.thumbplayer.core.common.TPDecoderType;
import com.tencent.thumbplayer.core.common.TPNativeLog;
import com.tencent.thumbplayer.core.common.TPSystemInfo;
import com.tencent.thumbplayer.g.b;
import java.nio.ByteBuffer;
import java.util.ArrayList;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/core/decoder/TPMediaCodecVideoDecoder.class */
public class TPMediaCodecVideoDecoder extends TPBaseMediaCodecDecoder {
    private static final String DEVICE_NAME_VIVO_X5L = "vivo X5L";
    private static final String KEY_CROP_BOTTOM = "crop-bottom";
    private static final String KEY_CROP_LEFT = "crop-left";
    private static final String KEY_CROP_RIGHT = "crop-right";
    private static final String KEY_CROP_TOP = "crop-top";
    private static final int PIXEL_STRIDE_CONTINUOUS = 1;
    private static final String TAG = "TPMediaCodecVideoDecode";
    private static final int YUV420P_PLANAR_COUNT = 3;
    private int mCropBottom;
    private int mCropLeft;
    private int mCropRight;
    private int mCropTop;
    private byte[] mCsd0Data;
    private byte[] mCsd1Data;
    private byte[] mCsd2Data;
    private int mDolbyVisionLevel;
    private int mDolbyVisionProfile;
    private boolean mEnableMediaCodecOutputData;
    private ArrayList<String> mMimeCandidates;
    private int mRotation;
    private int mVideoHeight;
    private int mVideoWidth;

    public TPMediaCodecVideoDecoder(int i) {
        super(i);
        this.mEnableMediaCodecOutputData = false;
        this.mMimeCandidates = new ArrayList<>();
        this.mVideoWidth = 0;
        this.mVideoHeight = 0;
        this.mCropLeft = 0;
        this.mCropRight = 0;
        this.mCropTop = 0;
        this.mCropBottom = 0;
        this.mRotation = 0;
        this.mDolbyVisionProfile = 0;
        this.mDolbyVisionLevel = 0;
        this.mCsd0Data = null;
        this.mCsd1Data = null;
        this.mCsd2Data = null;
    }

    /* JADX WARN: Type inference failed for: r1v5, types: [byte[], byte[][]] */
    private void copyVideoDataFromImage(Image image, TPFrameInfo tPFrameInfo) {
        if (image.getFormat() != 35) {
            tPFrameInfo.format = -1;
            tPFrameInfo.errCode = 3;
            TPNativeLog.printLog(4, TAG, "copyVideoDataFromImage: image format not support!");
            return;
        }
        tPFrameInfo.format = 0;
        int width = image.getWidth();
        int height = image.getHeight();
        Image.Plane[] planes = image.getPlanes();
        if (tPFrameInfo.lineSize == null || tPFrameInfo.lineSize.length < 3) {
            tPFrameInfo.lineSize = new int[3];
        }
        if (tPFrameInfo.videoData == null || tPFrameInfo.videoData.length < 3) {
            tPFrameInfo.videoData = new byte[3];
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= 3) {
                return;
            }
            int i3 = i2 == 0 ? 0 : 1;
            copyVideoDataFromPlane(planes[i2], width >> i3, height >> i3, i2, tPFrameInfo);
            i = i2 + 1;
        }
    }

    private void copyVideoDataFromPlane(Image.Plane plane, int i, int i2, int i3, TPFrameInfo tPFrameInfo) {
        ByteBuffer buffer = plane.getBuffer();
        tPFrameInfo.lineSize[i3] = i;
        int i4 = i * i2;
        if (tPFrameInfo.videoData[i3] == null || tPFrameInfo.videoData[i3].length < i4) {
            tPFrameInfo.videoData[i3] = new byte[i4];
        }
        if (plane.getPixelStride() == 1) {
            buffer.get(tPFrameInfo.videoData[i3], 0, i4);
            return;
        }
        for (int i5 = 0; i5 < i4; i5++) {
            tPFrameInfo.videoData[i3][i5] = buffer.get(plane.getPixelStride() * i5);
        }
    }

    private void processOutputData(b bVar, int i, MediaCodec.BufferInfo bufferInfo, TPFrameInfo tPFrameInfo) {
        if (bufferInfo.flags == 4 && bufferInfo.size <= 0) {
            TPNativeLog.printLog(2, TAG, "processOutputBuffer: bufferInfo.flags is BUFFER_FLAG_END_OF_STREAM, return EOS!");
            tPFrameInfo.format = -1;
            tPFrameInfo.errCode = 2;
            bVar.a(i, false);
            return;
        }
        Image b = bVar.b(i);
        if (b != null) {
            copyVideoDataFromImage(b, tPFrameInfo);
            bVar.a(i, false);
            return;
        }
        tPFrameInfo.format = -1;
        tPFrameInfo.errCode = 3;
        bVar.a(i, false);
        TPNativeLog.printLog(4, TAG, "processOutputBuffer: getOutputImage return null");
    }

    @Override // com.tencent.thumbplayer.core.decoder.TPBaseMediaCodecDecoder
    void configCodec(b bVar, String str) {
        Surface surface;
        MediaFormat createVideoFormat = MediaFormat.createVideoFormat(str, this.mVideoWidth, this.mVideoHeight);
        if (Build.VERSION.SDK_INT > 22) {
            createVideoFormat.setInteger("rotation-degrees", this.mRotation);
        }
        if (TPSystemInfo.getDeviceName().equalsIgnoreCase(DEVICE_NAME_VIVO_X5L)) {
            createVideoFormat.setInteger(MediaFormat.KEY_MAX_INPUT_SIZE, this.mVideoWidth * this.mVideoHeight);
        }
        byte[] bArr = this.mCsd0Data;
        if (bArr != null) {
            createVideoFormat.setByteBuffer("csd-0", ByteBuffer.wrap(bArr));
        }
        byte[] bArr2 = this.mCsd1Data;
        if (bArr2 != null) {
            createVideoFormat.setByteBuffer("csd-1", ByteBuffer.wrap(bArr2));
        }
        byte[] bArr3 = this.mCsd2Data;
        if (bArr3 != null) {
            createVideoFormat.setByteBuffer("csd-2", ByteBuffer.wrap(bArr3));
        }
        if (TPDecoderType.TP_CODEC_MIMETYPE_DOLBYVISION.equals(str)) {
            createVideoFormat.setInteger(MediaFormat.KEY_PROFILE, TPCodecUtils.convertDolbyVisionToOmxProfile(this.mDolbyVisionProfile));
            createVideoFormat.setInteger(BatteryManager.EXTRA_LEVEL, TPCodecUtils.convertDolbyVisionToOmxLevel(this.mDolbyVisionLevel));
        }
        if (!this.mEnableMediaCodecOutputData || Build.VERSION.SDK_INT < 21) {
            surface = this.mSurface;
        } else {
            createVideoFormat.setInteger(MediaFormat.KEY_COLOR_FORMAT, MediaCodecInfo.CodecCapabilities.COLOR_FormatYUV420Flexible);
            surface = null;
        }
        bVar.a(createVideoFormat, surface, this.mMediaCrypto, 0);
        bVar.d(1);
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x001b, code lost:
        if (r0 == null) goto L8;
     */
    @Override // com.tencent.thumbplayer.core.decoder.TPBaseMediaCodecDecoder
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    java.lang.String getCodecName(java.lang.String r6, boolean r7) {
        /*
            r5 = this;
            r0 = r5
            int r0 = r0.mDolbyVisionProfile
            r8 = r0
            r0 = r8
            if (r0 <= 0) goto L1e
            r0 = r6
            r1 = r8
            r2 = r5
            int r2 = r2.mDolbyVisionLevel
            r3 = r7
            java.lang.String r0 = com.tencent.thumbplayer.core.common.TPCodecUtils.getDolbyVisionDecoderName(r0, r1, r2, r3)
            r10 = r0
            r0 = r10
            r9 = r0
            r0 = r10
            if (r0 != 0) goto L25
        L1e:
            r0 = r6
            r1 = r7
            java.lang.String r0 = com.tencent.thumbplayer.core.common.TPCodecUtils.getDecoderName(r0, r1)
            r9 = r0
        L25:
            r0 = r9
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.thumbplayer.core.decoder.TPMediaCodecVideoDecoder.getCodecName(java.lang.String, boolean):java.lang.String");
    }

    @Override // com.tencent.thumbplayer.core.decoder.TPBaseMediaCodecDecoder
    String getLogTag() {
        return TAG;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.tencent.thumbplayer.core.decoder.TPBaseMediaCodecDecoder
    public ArrayList<String> getMimeCandidates() {
        return this.mMimeCandidates;
    }

    @Override // com.tencent.thumbplayer.core.decoder.ITPMediaCodecDecoder
    public boolean initDecoder(String str, int i, int i2, int i3, int i4) {
        return false;
    }

    @Override // com.tencent.thumbplayer.core.decoder.ITPMediaCodecDecoder
    public boolean initDecoder(String str, int i, int i2, int i3, Surface surface, int i4, int i5, int i6) {
        int convertDolbyVisionToOmxProfile;
        TPNativeLog.printLog(2, TAG, "initDecoder, mimeType:" + str + " width:" + i + " height:" + i2 + " rotation:" + i3 + " dvProfile:" + i5 + " dvLevel:" + i6);
        this.mVideoWidth = i;
        this.mVideoHeight = i2;
        this.mRotation = i3;
        this.mSurface = surface;
        this.mDrmType = i4;
        this.mDolbyVisionProfile = i5;
        this.mDolbyVisionLevel = i6;
        this.mMimeCandidates.clear();
        this.mMimeCandidates.add(str);
        if (!TPDecoderType.TP_CODEC_MIMETYPE_DOLBYVISION.equals(str) || (convertDolbyVisionToOmxProfile = TPCodecUtils.convertDolbyVisionToOmxProfile(this.mDolbyVisionProfile)) < 4 || convertDolbyVisionToOmxProfile > 256) {
            return true;
        }
        this.mMimeCandidates.add("video/hevc");
        return true;
    }

    @Override // com.tencent.thumbplayer.core.decoder.TPBaseMediaCodecDecoder
    void processMediaCodecException(Exception exc) {
    }

    @Override // com.tencent.thumbplayer.core.decoder.TPBaseMediaCodecDecoder
    void processOutputBuffer(b bVar, int i, MediaCodec.BufferInfo bufferInfo, TPFrameInfo tPFrameInfo) {
        tPFrameInfo.width = this.mVideoWidth;
        tPFrameInfo.height = this.mVideoHeight;
        tPFrameInfo.cropLeft = this.mCropLeft;
        tPFrameInfo.cropRight = this.mCropRight;
        tPFrameInfo.cropTop = this.mCropTop;
        tPFrameInfo.cropBottom = this.mCropBottom;
        tPFrameInfo.format = 167;
        if (this.mEnableMediaCodecOutputData) {
            processOutputData(bVar, i, bufferInfo, tPFrameInfo);
        }
    }

    @Override // com.tencent.thumbplayer.core.decoder.TPBaseMediaCodecDecoder
    void processOutputConfigData(b bVar, int i, MediaCodec.BufferInfo bufferInfo, TPFrameInfo tPFrameInfo) {
        tPFrameInfo.errCode = 0;
        processOutputBuffer(bVar, i, bufferInfo, tPFrameInfo);
    }

    @Override // com.tencent.thumbplayer.core.decoder.TPBaseMediaCodecDecoder
    void processOutputFormatChanged(MediaFormat mediaFormat) {
        boolean z = mediaFormat.containsKey(KEY_CROP_RIGHT) && mediaFormat.containsKey(KEY_CROP_LEFT) && mediaFormat.containsKey(KEY_CROP_BOTTOM) && mediaFormat.containsKey(KEY_CROP_TOP);
        this.mVideoWidth = mediaFormat.getInteger("width");
        this.mVideoHeight = mediaFormat.getInteger("height");
        if (z) {
            this.mCropLeft = mediaFormat.getInteger(KEY_CROP_LEFT);
            this.mCropRight = mediaFormat.getInteger(KEY_CROP_RIGHT);
            this.mCropTop = mediaFormat.getInteger(KEY_CROP_TOP);
            this.mCropBottom = mediaFormat.getInteger(KEY_CROP_BOTTOM);
        }
        TPNativeLog.printLog(2, TAG, "processOutputFormatChanged: mVideoWidth: " + this.mVideoWidth + ", mVideoHeight: " + this.mVideoHeight + ", mCropLeft: " + this.mCropLeft + ", mCropRight: " + this.mCropRight + ", mCropTop: " + this.mCropTop + ", mCropBottom: " + this.mCropBottom);
    }

    @Override // com.tencent.thumbplayer.core.decoder.TPBaseMediaCodecDecoder, com.tencent.thumbplayer.core.decoder.ITPMediaCodecDecoder
    public int setOperateRate(float f) {
        return super.setOperateRate(f);
    }

    @Override // com.tencent.thumbplayer.core.decoder.TPBaseMediaCodecDecoder, com.tencent.thumbplayer.core.decoder.ITPMediaCodecDecoder
    public int setOutputSurface(Surface surface) {
        if (this.mEnableMediaCodecOutputData) {
            return 3;
        }
        return super.setOutputSurface(surface);
    }

    @Override // com.tencent.thumbplayer.core.decoder.TPBaseMediaCodecDecoder, com.tencent.thumbplayer.core.decoder.ITPMediaCodecDecoder
    public boolean setParamBool(int i, boolean z) {
        if (i == 5) {
            if (this.mStarted || Build.VERSION.SDK_INT < 21) {
                String logTag = getLogTag();
                TPNativeLog.printLog(3, logTag, "BOOL_ENABLE_MEDIACODEC_OUTPUT_DATA failed. need set before start, mStart=" + this.mStarted + ", api level is " + Build.VERSION.SDK_INT + ", support api level = 21");
            } else {
                this.mEnableMediaCodecOutputData = z;
            }
        }
        return super.setParamBool(i, z);
    }

    @Override // com.tencent.thumbplayer.core.decoder.TPBaseMediaCodecDecoder, com.tencent.thumbplayer.core.decoder.ITPMediaCodecDecoder
    public boolean setParamBytes(int i, byte[] bArr) {
        if (i == 200) {
            this.mCsd0Data = bArr;
        } else if (i == 201) {
            this.mCsd1Data = bArr;
        } else if (i == 202) {
            this.mCsd2Data = bArr;
        }
        return super.setParamBytes(i, bArr);
    }

    @Override // com.tencent.thumbplayer.core.decoder.TPBaseMediaCodecDecoder, com.tencent.thumbplayer.core.decoder.ITPMediaCodecDecoder
    public boolean setParamObject(int i, Object obj) {
        return super.setParamObject(i, obj);
    }
}
