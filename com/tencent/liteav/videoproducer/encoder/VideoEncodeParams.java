package com.tencent.liteav.videoproducer.encoder;

import com.tencent.liteav.base.annotations.JNINamespace;
import com.tencent.liteav.base.util.CommonUtil;
import com.tencent.liteav.videobase.common.CodecType;
import com.tencent.liteav.videoproducer.encoder.VideoEncoderDef;
import java.lang.reflect.Field;
import org.json.JSONArray;
import org.json.JSONException;

@JNINamespace("liteav::video")
/* loaded from: source-8829756-dex2jar.jar:com/tencent/liteav/videoproducer/encoder/VideoEncodeParams.class */
public final class VideoEncodeParams implements Cloneable {
    public boolean annexb;
    public long baseFrameIndex;
    public long baseGopIndex;
    public int bitrate;
    public VideoEncoderDef.BitrateMode bitrateMode;
    public CodecType codecType;
    public boolean enableBFrame;
    public VideoEncoderDef.EncoderProfile encoderProfile;
    public int fps;
    public boolean fullIFrame;
    public int gop;
    public int height;
    public boolean isTranscodingMode;
    public JSONArray mediaCodecDeviceRelatedParams;
    public VideoEncoderDef.ReferenceStrategy referenceStrategy;
    public int width;

    public VideoEncodeParams() {
        this.width = 0;
        this.height = 0;
        this.fps = 20;
        this.gop = 3;
        this.bitrate = 0;
        this.annexb = true;
        this.encoderProfile = null;
        this.bitrateMode = VideoEncoderDef.BitrateMode.CBR;
        this.baseFrameIndex = 0L;
        this.baseGopIndex = 0L;
        this.fullIFrame = false;
        this.enableBFrame = false;
        this.referenceStrategy = VideoEncoderDef.ReferenceStrategy.FIX_GOP;
        this.codecType = CodecType.H264;
        this.isTranscodingMode = false;
        this.mediaCodecDeviceRelatedParams = null;
    }

    public VideoEncodeParams(VideoEncodeParams videoEncodeParams) {
        this.width = 0;
        this.height = 0;
        this.fps = 20;
        this.gop = 3;
        this.bitrate = 0;
        this.annexb = true;
        this.encoderProfile = null;
        this.bitrateMode = VideoEncoderDef.BitrateMode.CBR;
        this.baseFrameIndex = 0L;
        this.baseGopIndex = 0L;
        this.fullIFrame = false;
        this.enableBFrame = false;
        this.referenceStrategy = VideoEncoderDef.ReferenceStrategy.FIX_GOP;
        this.codecType = CodecType.H264;
        this.isTranscodingMode = false;
        this.mediaCodecDeviceRelatedParams = null;
        if (videoEncodeParams == null) {
            return;
        }
        this.width = videoEncodeParams.width;
        this.height = videoEncodeParams.height;
        this.fps = videoEncodeParams.fps;
        this.gop = videoEncodeParams.gop;
        this.bitrate = videoEncodeParams.bitrate;
        this.annexb = videoEncodeParams.annexb;
        this.encoderProfile = videoEncodeParams.encoderProfile;
        this.bitrateMode = videoEncodeParams.bitrateMode;
        this.baseFrameIndex = videoEncodeParams.baseFrameIndex;
        this.baseGopIndex = videoEncodeParams.baseGopIndex;
        this.fullIFrame = videoEncodeParams.fullIFrame;
        this.enableBFrame = videoEncodeParams.enableBFrame;
        this.codecType = videoEncodeParams.codecType;
        this.referenceStrategy = videoEncodeParams.referenceStrategy;
        this.isTranscodingMode = videoEncodeParams.isTranscodingMode;
        if (videoEncodeParams.mediaCodecDeviceRelatedParams != null) {
            try {
                this.mediaCodecDeviceRelatedParams = new JSONArray(videoEncodeParams.mediaCodecDeviceRelatedParams.toString());
            } catch (JSONException e) {
            }
        }
    }

    private int checkFieldDiffCounts(Object obj, Object obj2) {
        int i;
        Field[] declaredFields = VideoEncodeParams.class.getDeclaredFields();
        int length = declaredFields.length;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i2 >= length) {
                return i4;
            }
            Field field = declaredFields[i2];
            if (!field.isAccessible()) {
                field.setAccessible(true);
            }
            try {
                i = i4;
                if (!CommonUtil.equals(field.get(obj), field.get(obj2))) {
                    i = i4 + 1;
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
                i = i4;
            }
            i2++;
            i3 = i;
        }
    }

    public static VideoEncoderDef.BitrateMode createEncoderBitrateMode(int i) {
        return VideoEncoderDef.BitrateMode.a(i);
    }

    public static VideoEncoderDef.EncoderProfile createEncoderProfileType(int i) {
        return VideoEncoderDef.EncoderProfile.a(i);
    }

    public static CodecType createEncoderVideoCodec(int i) {
        return CodecType.a(i);
    }

    public static VideoEncoderDef.ReferenceStrategy createReferenceStrategy(int i) {
        return VideoEncoderDef.ReferenceStrategy.a(i);
    }

    public final boolean equals(Object obj) {
        return (obj instanceof VideoEncodeParams) && checkFieldDiffCounts(this, obj) == 0;
    }

    public final long getBaseFrameIndex() {
        return this.baseFrameIndex;
    }

    public final long getBaseGopIndex() {
        return this.baseGopIndex;
    }

    public final int getBitrate() {
        return this.bitrate;
    }

    public final int getBitrateMode() {
        return this.bitrateMode.mValue;
    }

    public final int getCodecType() {
        return this.codecType.mValue;
    }

    public final int getEncoderProfile() {
        return this.encoderProfile.mValue;
    }

    public final int getFps() {
        return this.fps;
    }

    public final int getGop() {
        return this.gop;
    }

    public final int getHeight() {
        return this.height;
    }

    public final JSONArray getMediaCodecDeviceRelatedParams() {
        return this.mediaCodecDeviceRelatedParams;
    }

    public final VideoEncoderDef.ReferenceStrategy getReferenceStrategy() {
        return this.referenceStrategy;
    }

    public final int getWidth() {
        return this.width;
    }

    public final boolean isAnnexb() {
        return this.annexb;
    }

    public final boolean isEnablesBframe() {
        return this.enableBFrame;
    }

    public final boolean isEnablesRps() {
        return this.referenceStrategy == VideoEncoderDef.ReferenceStrategy.RPS;
    }

    public final boolean isEnablesSvc() {
        return this.referenceStrategy == VideoEncoderDef.ReferenceStrategy.SVC;
    }

    public final boolean isFullIFrame() {
        return this.fullIFrame;
    }

    public final boolean isTranscodingMode() {
        return this.isTranscodingMode;
    }

    public final void setAnnexb(boolean z) {
        this.annexb = z;
    }

    public final void setBFrameEnabled(boolean z) {
        this.enableBFrame = z;
    }

    public final void setBaseFrameIndex(long j) {
        this.baseFrameIndex = j;
    }

    public final void setBaseGopIndex(long j) {
        this.baseGopIndex = j;
    }

    public final void setBitrate(int i) {
        this.bitrate = i;
    }

    public final void setBitrateMode(VideoEncoderDef.BitrateMode bitrateMode) {
        this.bitrateMode = bitrateMode;
    }

    public final void setCodecType(CodecType codecType) {
        this.codecType = codecType;
    }

    public final void setEncoderProfile(VideoEncoderDef.EncoderProfile encoderProfile) {
        this.encoderProfile = encoderProfile;
    }

    public final void setFps(int i) {
        this.fps = i;
    }

    public final void setFullIFrame(boolean z) {
        this.fullIFrame = z;
    }

    public final void setGop(int i) {
        this.gop = i;
    }

    public final void setHeight(int i) {
        this.height = i;
    }

    public final void setMediaCodecDeviceRelatedParams(JSONArray jSONArray) {
        this.mediaCodecDeviceRelatedParams = jSONArray;
    }

    public final void setReferenceStrategy(VideoEncoderDef.ReferenceStrategy referenceStrategy) {
        this.referenceStrategy = referenceStrategy;
    }

    public final void setTranscodingModeEnabled(boolean z) {
        this.isTranscodingMode = z;
    }

    public final void setWidth(int i) {
        this.width = i;
    }

    public final String toString() {
        return "width=" + this.width + ", height=" + this.height + ", fps=" + this.fps + ", gop=" + this.gop + ", bitrate=" + this.bitrate + ", annexb=" + this.annexb + ", encoderProfile=" + this.encoderProfile + ", bitrateMode=" + this.bitrateMode + ", baseFrameIndex=" + this.baseFrameIndex + ", baseGopIndex=" + this.baseGopIndex + ", fullIFrame=" + this.fullIFrame + ", enableBFrame=" + this.enableBFrame + ", referenceStrategy=" + this.referenceStrategy + ", codecType=" + this.codecType + ", isTransCodingMode=" + this.isTranscodingMode + ", mediaCodecDeviceRelatedParams=" + this.mediaCodecDeviceRelatedParams;
    }
}
