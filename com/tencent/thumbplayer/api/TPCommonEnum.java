package com.tencent.thumbplayer.api;

import com.tencent.thumbplayer.adapter.strategy.utils.TPNativeKeyMap;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/api/TPCommonEnum.class */
public class TPCommonEnum {
    @TPNativeKeyMap.MapMediaType(4)
    public static final int MEDIA_TYPE_ATTACHMENT = 4;
    @TPNativeKeyMap.MapMediaType(1)
    public static final int MEDIA_TYPE_AUDIO = 1;
    @TPNativeKeyMap.MapMediaType(2)
    public static final int MEDIA_TYPE_DATA = 2;
    @TPNativeKeyMap.MapMediaType(3)
    public static final int MEDIA_TYPE_SUBTITLE = 3;
    @TPNativeKeyMap.MapMediaType(-1)
    public static final int MEDIA_TYPE_UNKNOWN = -1;
    @TPNativeKeyMap.MapMediaType(0)
    public static final int MEDIA_TYPE_VIDEO = 0;
    public static final int PLAYER_DESC_ID_ANDROIDPLAYER = 1;
    public static final int PLAYER_DESC_ID_THUMBPLAYER = 2;
    public static final int PLAYER_DESC_ID_THUMBPLAYER_SOFT = 3;
    public static final int PLAYER_DESC_ID_UNKNOWN = 0;
    @TPNativeKeyMap.MapAudioCodecType(5002)
    public static final int TP_ACODEC_TYPE_AAC = 5002;
    @TPNativeKeyMap.MapAudioCodecType(5003)
    public static final int TP_ACODEC_TYPE_AC3 = 5003;
    @TPNativeKeyMap.MapAudioCodecType(5004)
    public static final int TP_ACODEC_TYPE_DTS = 5004;
    @TPNativeKeyMap.MapAudioCodecType(5040)
    public static final int TP_ACODEC_TYPE_EAC3 = 5040;
    @TPNativeKeyMap.MapAudioCodecType(5012)
    public static final int TP_ACODEC_TYPE_FLAC = 5012;
    public static final int TP_ACODEC_TYPE_UNKNOWN = -1;
    @TPNativeKeyMap.MapAudioDecoderType(4)
    public static final int TP_AUDIO_DECODER_DOLBY = 4;
    @TPNativeKeyMap.MapAudioDecoderType(1)
    public static final int TP_AUDIO_DECODER_FFMPEG = 1;
    @TPNativeKeyMap.MapAudioDecoderType(2)
    public static final int TP_AUDIO_DECODER_MEDIACODEC = 2;
    @TPNativeKeyMap.MapAudioDecoderType(5)
    public static final int TP_AUDIO_DECODER_STANDALONE = 5;
    public static final int TP_AUDIO_RENDERER_TYPE_AAUDIO = 2;
    public static final int TP_AUDIO_RENDERER_TYPE_AUDIOTRACK = 1;
    public static final int TP_AUDIO_RENDERER_TYPE_OBOE = 3;
    public static final int TP_AUDIO_RENDERER_TYPE_OPENAL = 5;
    public static final int TP_AUDIO_RENDERER_TYPE_OPENSL = 4;
    @TPNativeKeyMap.MapAudioSampleFormat(4)
    public static final int TP_AUDIO_SAMPLE_FORMAT_DBL = 4;
    @TPNativeKeyMap.MapAudioSampleFormat(9)
    public static final int TP_AUDIO_SAMPLE_FORMAT_DBLP = 9;
    @TPNativeKeyMap.MapAudioSampleFormat(3)
    public static final int TP_AUDIO_SAMPLE_FORMAT_FLT = 3;
    @TPNativeKeyMap.MapAudioSampleFormat(8)
    public static final int TP_AUDIO_SAMPLE_FORMAT_FLTP = 8;
    @TPNativeKeyMap.MapAudioSampleFormat(-1)
    public static final int TP_AUDIO_SAMPLE_FORMAT_NONE = -1;
    @TPNativeKeyMap.MapAudioSampleFormat(1)
    public static final int TP_AUDIO_SAMPLE_FORMAT_S16 = 1;
    @TPNativeKeyMap.MapAudioSampleFormat(6)
    public static final int TP_AUDIO_SAMPLE_FORMAT_S16P = 6;
    @TPNativeKeyMap.MapAudioSampleFormat(2)
    public static final int TP_AUDIO_SAMPLE_FORMAT_S32 = 2;
    @TPNativeKeyMap.MapAudioSampleFormat(7)
    public static final int TP_AUDIO_SAMPLE_FORMAT_S32P = 7;
    @TPNativeKeyMap.MapAudioSampleFormat(10)
    public static final int TP_AUDIO_SAMPLE_FORMAT_S64 = 10;
    @TPNativeKeyMap.MapAudioSampleFormat(11)
    public static final int TP_AUDIO_SAMPLE_FORMAT_S64P = 11;
    @TPNativeKeyMap.MapAudioSampleFormat(0)
    public static final int TP_AUDIO_SAMPLE_FORMAT_U8 = 0;
    @TPNativeKeyMap.MapAudioSampleFormat(5)
    public static final int TP_AUDIO_SAMPLE_FORMAT_U8P = 5;
    @TPNativeKeyMap.MapBufferStrategy(-1)
    public static final int TP_BUFFER_STRATEGY_AUTO = -1;
    @TPNativeKeyMap.MapBufferStrategy(2)
    public static final int TP_BUFFER_STRATEGY_JITTER = 2;
    @TPNativeKeyMap.MapBufferStrategy(3)
    public static final int TP_BUFFER_STRATEGY_MIN = 3;
    @TPNativeKeyMap.MapBufferStrategy(1)
    public static final int TP_BUFFER_STRATEGY_NORMAL = 1;
    @TPNativeKeyMap.MapBufferStrategy(0)
    public static final int TP_BUFFER_STRATEGY_UNABLE = 0;
    public static final int TP_DECODER_UNKNOWN = -1;
    @TPNativeKeyMap.MapDemuxerType(0)
    public static final int TP_DEMUXER_FFMPEG = 0;
    @TPNativeKeyMap.MapDemuxerType(1)
    public static final int TP_DEMUXER_STANDALONE = 1;
    @TPNativeKeyMap.MapDemuxerType(-1)
    public static final int TP_DEMUXER_UNKNOWN = -1;
    @Deprecated
    public static final int TP_DRM_TYPE_CHINADRM_HW = 2;
    @TPNativeKeyMap.MapDrmType(-1)
    public static final int TP_DRM_TYPE_NONE = -1;
    @TPNativeKeyMap.MapDrmType(2)
    public static final int TP_DRM_TYPE_UNITEND = 2;
    @TPNativeKeyMap.MapDrmType(0)
    public static final int TP_DRM_TYPE_WIDEVINE_HW = 0;
    @TPNativeKeyMap.MapHdrType(0)
    public static final int TP_HDR_TYPE_HDR10 = 0;
    @TPNativeKeyMap.MapHdrType(1)
    public static final int TP_HDR_TYPE_HDR10PLUS = 1;
    @TPNativeKeyMap.MapHdrType(2)
    public static final int TP_HDR_TYPE_HDRDOLBYVISION = 2;
    @TPNativeKeyMap.MapHdrType(3)
    public static final int TP_HDR_TYPE_HDRHLG = 3;
    @TPNativeKeyMap.MapHdrType(4)
    public static final int TP_HDR_TYPE_HDRVIVID = 4;
    @TPNativeKeyMap.MapReduceLantencyType(0)
    public static final int TP_REDUCE_LIVE_LATENCY_ACTION_NONE = 0;
    @TPNativeKeyMap.MapReduceLantencyType(2)
    public static final int TP_REDUCE_LIVE_LATENCY_ACTION_SKIP_FRAME = 2;
    @TPNativeKeyMap.MapReduceLantencyType(1)
    public static final int TP_REDUCE_LIVE_LATENCY_ACTION_SPEED_UP = 1;
    public static final int TP_RENDERER_TYPE_NONE = -1;
    public static final int TP_SUBTITLE_OUTPUT_RGBA = 1;
    public static final int TP_SUBTITLE_OUTPUT_TEXT = 0;
    @TPNativeKeyMap.MapCodecType(1029)
    public static final int TP_VCODEC_TYPE_AV1 = 1029;
    @TPNativeKeyMap.MapCodecType(192)
    public static final int TP_VCODEC_TYPE_AVS3 = 192;
    @TPNativeKeyMap.MapCodecType(26)
    public static final int TP_VCODEC_TYPE_H264 = 26;
    @TPNativeKeyMap.MapCodecType(172)
    public static final int TP_VCODEC_TYPE_HEVC = 172;
    @TPNativeKeyMap.MapCodecType(-1)
    public static final int TP_VCODEC_TYPE_UNKNOWN = 0;
    @TPNativeKeyMap.MapCodecType(138)
    public static final int TP_VCODEC_TYPE_VP8 = 138;
    @TPNativeKeyMap.MapCodecType(166)
    public static final int TP_VCODEC_TYPE_VP9 = 166;
    @TPNativeKeyMap.MapCodecType(193)
    public static final int TP_VCODEC_TYPE_VVC = 193;
    @TPNativeKeyMap.MapVideoColorSpace(10)
    public static final int TP_VIDEO_COLOR_SPACE_BT2020_CL = 10;
    @TPNativeKeyMap.MapVideoColorSpace(9)
    public static final int TP_VIDEO_COLOR_SPACE_BT2020_NCL = 9;
    @TPNativeKeyMap.MapVideoColorSpace(5)
    public static final int TP_VIDEO_COLOR_SPACE_BT470BG = 5;
    @TPNativeKeyMap.MapVideoColorSpace(1)
    public static final int TP_VIDEO_COLOR_SPACE_BT709 = 1;
    @TPNativeKeyMap.MapVideoColorSpace(13)
    public static final int TP_VIDEO_COLOR_SPACE_CHROMA_DERIVED_CL = 13;
    @TPNativeKeyMap.MapVideoColorSpace(12)
    public static final int TP_VIDEO_COLOR_SPACE_CHROMA_DERIVED_NCL = 12;
    @TPNativeKeyMap.MapVideoColorSpace(4)
    public static final int TP_VIDEO_COLOR_SPACE_FCC = 4;
    @TPNativeKeyMap.MapVideoColorSpace(14)
    public static final int TP_VIDEO_COLOR_SPACE_ICTCP = 14;
    @TPNativeKeyMap.MapVideoColorSpace(3)
    public static final int TP_VIDEO_COLOR_SPACE_RESERVED = 3;
    @TPNativeKeyMap.MapVideoColorSpace(0)
    public static final int TP_VIDEO_COLOR_SPACE_RGB = 0;
    @TPNativeKeyMap.MapVideoColorSpace(6)
    public static final int TP_VIDEO_COLOR_SPACE_SMPTE170M = 6;
    @TPNativeKeyMap.MapVideoColorSpace(11)
    public static final int TP_VIDEO_COLOR_SPACE_SMPTE2085 = 11;
    @TPNativeKeyMap.MapVideoColorSpace(7)
    public static final int TP_VIDEO_COLOR_SPACE_SMPTE240M = 7;
    @TPNativeKeyMap.MapVideoColorSpace(2)
    public static final int TP_VIDEO_COLOR_SPACE_UNSPECIFIED = 2;
    @TPNativeKeyMap.MapVideoColorSpace(8)
    public static final int TP_VIDEO_COLOR_SPACE_YCGCO = 8;
    @TPNativeKeyMap.MapVideoDecoderType(101)
    public static final int TP_VIDEO_DECODER_FFMPEG = 101;
    @TPNativeKeyMap.MapVideoDecoderType(102)
    public static final int TP_VIDEO_DECODER_MEDIACODEC = 102;
    @TPNativeKeyMap.MapVideoDecoderType(104)
    public static final int TP_VIDEO_DECODER_STANDALONE = 104;
    @TPNativeKeyMap.MapPixelFormat(-1)
    public static final int TP_VIDEO_OUTPUT_FORMAT_NONE = -1;
    @TPNativeKeyMap.MapPixelFormat(37)
    public static final int TP_VIDEO_OUTPUT_FORMAT_RGB565 = 37;
    @TPNativeKeyMap.MapPixelFormat(26)
    public static final int TP_VIDEO_OUTPUT_FORMAT_RGBA = 26;
    @TPNativeKeyMap.MapPixelFormat(0)
    public static final int TP_VIDEO_OUTPUT_FORMAT_YUV420P = 0;
    @TPNativeKeyMap.MapPixelFormat(12)
    public static final int TP_VIDEO_OUTPUT_FORMAT_YUVJ420P = 12;
    public static final int TP_VIDEO_RENDERER_TYPE_OPENGL = 101;

    @Target({ElementType.METHOD, ElementType.LOCAL_VARIABLE, ElementType.PARAMETER})
    @Retention(RetentionPolicy.RUNTIME)
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/api/TPCommonEnum$InnerAudioCodecType.class */
    public @interface InnerAudioCodecType {
    }

    @Target({ElementType.METHOD, ElementType.LOCAL_VARIABLE, ElementType.PARAMETER})
    @Retention(RetentionPolicy.RUNTIME)
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/api/TPCommonEnum$InnerAudioDecoderType.class */
    public @interface InnerAudioDecoderType {
    }

    @Target({ElementType.METHOD, ElementType.LOCAL_VARIABLE, ElementType.PARAMETER})
    @Retention(RetentionPolicy.RUNTIME)
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/api/TPCommonEnum$InnerAudioSampleFormat.class */
    public @interface InnerAudioSampleFormat {
    }

    @Target({ElementType.METHOD, ElementType.LOCAL_VARIABLE, ElementType.PARAMETER})
    @Retention(RetentionPolicy.RUNTIME)
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/api/TPCommonEnum$InnerBufferStrategy.class */
    public @interface InnerBufferStrategy {
    }

    @Target({ElementType.METHOD, ElementType.LOCAL_VARIABLE, ElementType.PARAMETER})
    @Retention(RetentionPolicy.RUNTIME)
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/api/TPCommonEnum$InnerDemuxerType.class */
    public @interface InnerDemuxerType {
    }

    @Target({ElementType.METHOD, ElementType.LOCAL_VARIABLE, ElementType.PARAMETER})
    @Retention(RetentionPolicy.RUNTIME)
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/api/TPCommonEnum$InnerDrmType.class */
    public @interface InnerDrmType {
    }

    @Target({ElementType.METHOD, ElementType.LOCAL_VARIABLE, ElementType.PARAMETER})
    @Retention(RetentionPolicy.RUNTIME)
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/api/TPCommonEnum$InnerFeatureType.class */
    public @interface InnerFeatureType {
    }

    @Target({ElementType.METHOD, ElementType.LOCAL_VARIABLE})
    @Retention(RetentionPolicy.RUNTIME)
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/api/TPCommonEnum$InnerHDRType.class */
    public @interface InnerHDRType {
    }

    @Target({ElementType.METHOD, ElementType.LOCAL_VARIABLE, ElementType.PARAMETER})
    @Retention(RetentionPolicy.RUNTIME)
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/api/TPCommonEnum$InnerMediaType.class */
    public @interface InnerMediaType {
    }

    @Target({ElementType.METHOD, ElementType.LOCAL_VARIABLE, ElementType.PARAMETER})
    @Retention(RetentionPolicy.RUNTIME)
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/api/TPCommonEnum$InnerPixelFormat.class */
    public @interface InnerPixelFormat {
    }

    @Target({ElementType.METHOD, ElementType.LOCAL_VARIABLE, ElementType.PARAMETER})
    @Retention(RetentionPolicy.RUNTIME)
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/api/TPCommonEnum$InnerReduceLantencyType.class */
    public @interface InnerReduceLantencyType {
    }

    @Target({ElementType.METHOD, ElementType.LOCAL_VARIABLE, ElementType.PARAMETER})
    @Retention(RetentionPolicy.RUNTIME)
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/api/TPCommonEnum$InnerSubtitleFormat.class */
    public @interface InnerSubtitleFormat {
    }

    @Target({ElementType.METHOD, ElementType.LOCAL_VARIABLE, ElementType.PARAMETER})
    @Retention(RetentionPolicy.RUNTIME)
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/api/TPCommonEnum$InnerThreadPriority.class */
    public @interface InnerThreadPriority {
    }

    @Target({ElementType.METHOD, ElementType.LOCAL_VARIABLE, ElementType.PARAMETER})
    @Retention(RetentionPolicy.RUNTIME)
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/api/TPCommonEnum$InnerVideoCodecType.class */
    public @interface InnerVideoCodecType {
    }

    @Target({ElementType.METHOD, ElementType.LOCAL_VARIABLE, ElementType.PARAMETER})
    @Retention(RetentionPolicy.RUNTIME)
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/api/TPCommonEnum$InnerVideoColorSpace.class */
    public @interface InnerVideoColorSpace {
    }

    @Target({ElementType.METHOD, ElementType.LOCAL_VARIABLE, ElementType.PARAMETER})
    @Retention(RetentionPolicy.RUNTIME)
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/api/TPCommonEnum$InnerVideoDecoderType.class */
    public @interface InnerVideoDecoderType {
    }

    @Target({ElementType.METHOD, ElementType.LOCAL_VARIABLE, ElementType.PARAMETER})
    @Retention(RetentionPolicy.RUNTIME)
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/api/TPCommonEnum$InnerVideoH264SeiType.class */
    public @interface InnerVideoH264SeiType {
    }

    @Target({ElementType.METHOD, ElementType.LOCAL_VARIABLE, ElementType.PARAMETER})
    @Retention(RetentionPolicy.RUNTIME)
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/api/TPCommonEnum$InnerVideoHevcSeiType.class */
    public @interface InnerVideoHevcSeiType {
    }

    @Retention(RetentionPolicy.RUNTIME)
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/api/TPCommonEnum$MEDIA_TYPE.class */
    public @interface MEDIA_TYPE {
    }

    @Target({ElementType.METHOD})
    @Retention(RetentionPolicy.RUNTIME)
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/api/TPCommonEnum$NativeConnectionAction.class */
    public @interface NativeConnectionAction {
    }

    @Target({ElementType.METHOD})
    @Retention(RetentionPolicy.RUNTIME)
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/api/TPCommonEnum$NativeConnectionConfig.class */
    public @interface NativeConnectionConfig {
    }

    @Target({ElementType.PARAMETER, ElementType.METHOD})
    @Retention(RetentionPolicy.RUNTIME)
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/api/TPCommonEnum$NativeErrorType.class */
    public @interface NativeErrorType {
    }

    @Target({ElementType.PARAMETER, ElementType.METHOD})
    @Retention(RetentionPolicy.RUNTIME)
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/api/TPCommonEnum$NativeInitConfig.class */
    public @interface NativeInitConfig {
    }

    @Target({ElementType.PARAMETER, ElementType.METHOD, ElementType.FIELD})
    @Retention(RetentionPolicy.RUNTIME)
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/api/TPCommonEnum$NativeMsgInfo.class */
    public @interface NativeMsgInfo {
    }

    @Target({ElementType.PARAMETER, ElementType.METHOD})
    @Retention(RetentionPolicy.RUNTIME)
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/api/TPCommonEnum$NativeOptionalId.class */
    public @interface NativeOptionalId {
    }

    @Target({ElementType.METHOD, ElementType.LOCAL_VARIABLE})
    @Retention(RetentionPolicy.RUNTIME)
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/api/TPCommonEnum$NativePropertyId.class */
    public @interface NativePropertyId {
    }

    @Target({ElementType.PARAMETER, ElementType.METHOD})
    @Retention(RetentionPolicy.RUNTIME)
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/api/TPCommonEnum$NativeSeekMode.class */
    public @interface NativeSeekMode {
    }

    @Target({ElementType.PARAMETER, ElementType.METHOD})
    @Retention(RetentionPolicy.RUNTIME)
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/api/TPCommonEnum$NativeSwitchDefMode.class */
    public @interface NativeSwitchDefMode {
    }

    @Target({ElementType.PARAMETER, ElementType.METHOD})
    @Retention(RetentionPolicy.RUNTIME)
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/api/TPCommonEnum$OptionalIdType.class */
    public @interface OptionalIdType {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/api/TPCommonEnum$PlayerType.class */
    public @interface PlayerType {
    }

    @Target({ElementType.PARAMETER, ElementType.METHOD})
    @Retention(RetentionPolicy.RUNTIME)
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/api/TPCommonEnum$TPErrorType.class */
    public @interface TPErrorType {
    }

    @Target({ElementType.PARAMETER, ElementType.METHOD})
    @Retention(RetentionPolicy.RUNTIME)
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/api/TPCommonEnum$TPMsgInfo.class */
    public @interface TPMsgInfo {
    }

    @Target({ElementType.PARAMETER, ElementType.METHOD, ElementType.FIELD})
    @Retention(RetentionPolicy.RUNTIME)
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/api/TPCommonEnum$TPOptionalId.class */
    public @interface TPOptionalId {
    }

    @Target({ElementType.PARAMETER})
    @Retention(RetentionPolicy.RUNTIME)
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/api/TPCommonEnum$TPSeekMode.class */
    public @interface TPSeekMode {
    }

    @Target({ElementType.PARAMETER})
    @Retention(RetentionPolicy.RUNTIME)
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/api/TPCommonEnum$TPSwitchDefMode.class */
    public @interface TPSwitchDefMode {
    }

    @Retention(RetentionPolicy.RUNTIME)
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/api/TPCommonEnum$TP_AUDIO_CODEC_TYPE.class */
    public @interface TP_AUDIO_CODEC_TYPE {
    }

    @Retention(RetentionPolicy.RUNTIME)
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/api/TPCommonEnum$TP_AUDIO_DECODER_TYPE.class */
    public @interface TP_AUDIO_DECODER_TYPE {
    }

    @Retention(RetentionPolicy.RUNTIME)
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/api/TPCommonEnum$TP_AUDIO_SAMPLE_FORMAT.class */
    public @interface TP_AUDIO_SAMPLE_FORMAT {
    }

    @Retention(RetentionPolicy.RUNTIME)
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/api/TPCommonEnum$TP_DRM_TYPE.class */
    public @interface TP_DRM_TYPE {
    }

    @Retention(RetentionPolicy.RUNTIME)
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/api/TPCommonEnum$TP_HDR_TYPE.class */
    public @interface TP_HDR_TYPE {
    }

    @Retention(RetentionPolicy.RUNTIME)
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/api/TPCommonEnum$TP_SUBTITLE_OUTPUT_TYPE.class */
    public @interface TP_SUBTITLE_OUTPUT_TYPE {
    }

    @Retention(RetentionPolicy.RUNTIME)
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/api/TPCommonEnum$TP_VIDEO_CODEC_TYPE.class */
    public @interface TP_VIDEO_CODEC_TYPE {
    }

    @Retention(RetentionPolicy.RUNTIME)
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/api/TPCommonEnum$TP_VIDEO_COLOR_SPACE.class */
    public @interface TP_VIDEO_COLOR_SPACE {
    }

    @Retention(RetentionPolicy.RUNTIME)
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/api/TPCommonEnum$TP_VIDEO_DECODER_TYPE.class */
    public @interface TP_VIDEO_DECODER_TYPE {
    }

    @Retention(RetentionPolicy.RUNTIME)
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/api/TPCommonEnum$TP_VIDEO_PIXEL_FORMAT.class */
    public @interface TP_VIDEO_PIXEL_FORMAT {
    }
}
