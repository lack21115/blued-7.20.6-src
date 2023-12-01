package com.tencent.thumbplayer.adapter.strategy.utils;

import com.huawei.hms.ads.ContentClassification;
import com.tencent.thumbplayer.api.ITPPlayer;
import com.tencent.thumbplayer.api.TPAudioAttributes;
import com.tencent.thumbplayer.api.TPCommonEnum;
import com.tencent.thumbplayer.api.TPDrmInfo;
import com.tencent.thumbplayer.api.TPErrorCode;
import com.tencent.thumbplayer.api.TPFeatureType;
import com.tencent.thumbplayer.api.TPPlayerDetailInfo;
import com.tencent.thumbplayer.api.TPPlayerMsg;
import com.tencent.thumbplayer.api.TPPropertyID;
import com.tencent.thumbplayer.api.TPSubtitleFrameBuffer;
import com.tencent.thumbplayer.api.TPSubtitleRenderModel;
import com.tencent.thumbplayer.api.TPThreadPriority;
import com.tencent.thumbplayer.api.TPVideoSeiH264Type;
import com.tencent.thumbplayer.api.TPVideoSeiHevcType;
import com.tencent.thumbplayer.api.connection.TPPlayerConnectionConstant;
import com.tencent.thumbplayer.core.common.TPDetailInfo;
import com.tencent.thumbplayer.core.common.TPNativeAudioAttributes;
import com.tencent.thumbplayer.core.player.TPGeneralPlayFlowParams;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/adapter/strategy/utils/TPNativeKeyMap.class */
public class TPNativeKeyMap {
    public static final int INVALID_VALUE = -1;

    @Target({ElementType.FIELD})
    @Retention(RetentionPolicy.RUNTIME)
    @SearchConfig(nativeDefValue = -1, searchClass = TPCommonEnum.class, tpDefValue = -1, valueClass = int.class)
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/adapter/strategy/utils/TPNativeKeyMap$MapAudioCodecType.class */
    public @interface MapAudioCodecType {
        @TPCommonEnum.InnerAudioCodecType
        int value();
    }

    @Target({ElementType.FIELD})
    @Retention(RetentionPolicy.RUNTIME)
    @SearchConfig(nativeDefValue = -1, searchClass = TPCommonEnum.class, tpDefValue = -1, valueClass = int.class)
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/adapter/strategy/utils/TPNativeKeyMap$MapAudioDecoderType.class */
    public @interface MapAudioDecoderType {
        @TPCommonEnum.InnerAudioDecoderType
        int value();
    }

    @Target({ElementType.FIELD})
    @Retention(RetentionPolicy.RUNTIME)
    @SearchConfig(nativeDefValue = -1, searchClass = TPCommonEnum.class, tpDefValue = -1, valueClass = int.class)
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/adapter/strategy/utils/TPNativeKeyMap$MapAudioSampleFormat.class */
    public @interface MapAudioSampleFormat {
        @TPCommonEnum.InnerAudioSampleFormat
        int value();
    }

    @Target({ElementType.FIELD})
    @Retention(RetentionPolicy.RUNTIME)
    @SearchConfig(nativeDefValue = 1, searchClass = TPCommonEnum.class, tpDefValue = 1, valueClass = int.class)
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/adapter/strategy/utils/TPNativeKeyMap$MapBufferStrategy.class */
    public @interface MapBufferStrategy {
        @TPCommonEnum.InnerBufferStrategy
        int value();
    }

    @Target({ElementType.FIELD})
    @Retention(RetentionPolicy.RUNTIME)
    @SearchConfig(nativeDefValue = -1, searchClass = TPCommonEnum.class, tpDefValue = 0, valueClass = int.class)
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/adapter/strategy/utils/TPNativeKeyMap$MapCodecType.class */
    public @interface MapCodecType {
        @TPCommonEnum.InnerVideoCodecType
        int value();
    }

    @Target({ElementType.FIELD})
    @Retention(RetentionPolicy.RUNTIME)
    @SearchConfig(nativeDefValue = -1, searchClass = TPPlayerConnectionConstant.class, tpDefValue = -1, valueClass = int.class)
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/adapter/strategy/utils/TPNativeKeyMap$MapConnectionAction.class */
    public @interface MapConnectionAction {
        @TPCommonEnum.NativeConnectionAction
        int value();
    }

    @Target({ElementType.FIELD})
    @Retention(RetentionPolicy.RUNTIME)
    @SearchConfig(nativeDefValue = -1, searchClass = TPPlayerConnectionConstant.class, tpDefValue = -1, valueClass = int.class)
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/adapter/strategy/utils/TPNativeKeyMap$MapConnectionConfig.class */
    public @interface MapConnectionConfig {
        @TPCommonEnum.NativeConnectionConfig
        int value();
    }

    @Target({ElementType.FIELD})
    @Retention(RetentionPolicy.RUNTIME)
    @SearchConfig(nativeDefValue = -1, searchClass = TPCommonEnum.class, tpDefValue = -1, valueClass = int.class)
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/adapter/strategy/utils/TPNativeKeyMap$MapDemuxerType.class */
    public @interface MapDemuxerType {
        @TPCommonEnum.InnerDemuxerType
        int value();
    }

    @Target({ElementType.FIELD})
    @Retention(RetentionPolicy.RUNTIME)
    @SearchConfig(nativeDefValue = -1, searchClass = TPPlayerDetailInfo.class, tpDefValue = -1, valueClass = int.class)
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/adapter/strategy/utils/TPNativeKeyMap$MapDetailInfoType.class */
    public @interface MapDetailInfoType {
        @TPDetailInfo.TPDetailInfoType
        int value();
    }

    @Target({ElementType.FIELD})
    @Retention(RetentionPolicy.RUNTIME)
    @SearchConfig(nativeDefValue = -1, searchClass = TPCommonEnum.class, tpDefValue = -1, valueClass = int.class)
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/adapter/strategy/utils/TPNativeKeyMap$MapDrmType.class */
    public @interface MapDrmType {
        @TPCommonEnum.InnerDrmType
        int value();
    }

    @Target({ElementType.FIELD})
    @Retention(RetentionPolicy.RUNTIME)
    @SearchConfig(nativeDefValue = 1001, searchClass = TPErrorCode.class, tpDefValue = 1001, valueClass = int.class)
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/adapter/strategy/utils/TPNativeKeyMap$MapErrorType.class */
    public @interface MapErrorType {
        @TPCommonEnum.NativeErrorType
        int value();
    }

    @Target({ElementType.FIELD})
    @Retention(RetentionPolicy.RUNTIME)
    @SearchConfig(nativeDefValue = -1, searchClass = TPFeatureType.class, tpDefValue = -1, valueClass = int.class)
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/adapter/strategy/utils/TPNativeKeyMap$MapFeatureType.class */
    public @interface MapFeatureType {
        @TPCommonEnum.InnerFeatureType
        int value();
    }

    @Target({ElementType.FIELD})
    @Retention(RetentionPolicy.RUNTIME)
    @SearchConfig(nativeDefValue = 0, searchClass = TPCommonEnum.class, tpDefValue = 0, valueClass = int.class)
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/adapter/strategy/utils/TPNativeKeyMap$MapHdrType.class */
    public @interface MapHdrType {
        @TPCommonEnum.InnerHDRType
        int value();
    }

    @Target({ElementType.FIELD})
    @Retention(RetentionPolicy.RUNTIME)
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/adapter/strategy/utils/TPNativeKeyMap$MapInitConfig.class */
    public @interface MapInitConfig {
        String keyName();

        @TPCommonEnum.OptionalIdType
        int type();

        @TPCommonEnum.NativeInitConfig
        int value();
    }

    @Target({ElementType.FIELD})
    @Retention(RetentionPolicy.RUNTIME)
    @SearchConfig(nativeDefValue = -1, searchClass = TPCommonEnum.class, tpDefValue = -1, valueClass = int.class)
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/adapter/strategy/utils/TPNativeKeyMap$MapMediaType.class */
    public @interface MapMediaType {
        @TPCommonEnum.InnerMediaType
        int value();
    }

    @Target({ElementType.FIELD})
    @Retention(RetentionPolicy.RUNTIME)
    @SearchConfig(nativeDefValue = -1, searchClass = TPPlayerMsg.class, tpDefValue = -1, valueClass = int.class)
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/adapter/strategy/utils/TPNativeKeyMap$MapMsgInfo.class */
    public @interface MapMsgInfo {
        @TPCommonEnum.NativeMsgInfo
        int value();
    }

    @Target({ElementType.FIELD})
    @Retention(RetentionPolicy.RUNTIME)
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/adapter/strategy/utils/TPNativeKeyMap$MapOptionalId.class */
    public @interface MapOptionalId {
        String keyName();

        @TPCommonEnum.OptionalIdType
        int type();

        @TPCommonEnum.NativeOptionalId
        int value();
    }

    @Target({ElementType.FIELD})
    @Retention(RetentionPolicy.RUNTIME)
    @SearchConfig(nativeDefValue = -1, searchClass = TPCommonEnum.class, tpDefValue = -1, valueClass = int.class)
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/adapter/strategy/utils/TPNativeKeyMap$MapPixelFormat.class */
    public @interface MapPixelFormat {
        @TPCommonEnum.InnerPixelFormat
        int value();
    }

    @Target({ElementType.FIELD})
    @Retention(RetentionPolicy.RUNTIME)
    @SearchConfig(nativeDefValue = -1, searchClass = TPPropertyID.class, tpDefValue = -1, valueClass = int.class)
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/adapter/strategy/utils/TPNativeKeyMap$MapPropertyId.class */
    public @interface MapPropertyId {
        @TPCommonEnum.NativePropertyId
        int value();
    }

    @Target({ElementType.FIELD})
    @Retention(RetentionPolicy.RUNTIME)
    @SearchConfig(nativeDefValue = 0, searchClass = TPCommonEnum.class, tpDefValue = 0, valueClass = int.class)
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/adapter/strategy/utils/TPNativeKeyMap$MapReduceLantencyType.class */
    public @interface MapReduceLantencyType {
        @TPCommonEnum.InnerReduceLantencyType
        int value();
    }

    @Target({ElementType.FIELD})
    @Retention(RetentionPolicy.RUNTIME)
    @SearchConfig(nativeDefValue = -1, searchClass = TPDrmInfo.class, tpDefValue = -1, valueClass = int.class)
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/adapter/strategy/utils/TPNativeKeyMap$MapReportDrmType.class */
    public @interface MapReportDrmType {
        @TPGeneralPlayFlowParams.TPDrmType
        int value();
    }

    @Target({ElementType.FIELD})
    @Retention(RetentionPolicy.RUNTIME)
    @SearchConfig(nativeDefValue = 2, searchClass = ITPPlayer.class, tpDefValue = 2, valueClass = int.class)
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/adapter/strategy/utils/TPNativeKeyMap$MapSeekMode.class */
    public @interface MapSeekMode {
        @TPCommonEnum.NativeSeekMode
        int value();
    }

    @Target({ElementType.FIELD})
    @Retention(RetentionPolicy.RUNTIME)
    @SearchConfig(nativeDefValue = -1, searchClass = TPSubtitleRenderModel.class, tpDefValue = -1, valueClass = int.class)
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/adapter/strategy/utils/TPNativeKeyMap$MapSubtitleFontStyle.class */
    public @interface MapSubtitleFontStyle {
        int value();
    }

    @Target({ElementType.FIELD})
    @Retention(RetentionPolicy.RUNTIME)
    @SearchConfig(nativeDefValue = -1, searchClass = TPSubtitleFrameBuffer.class, tpDefValue = -1, valueClass = int.class)
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/adapter/strategy/utils/TPNativeKeyMap$MapSubtitleFormat.class */
    public @interface MapSubtitleFormat {
        @TPCommonEnum.InnerSubtitleFormat
        int value();
    }

    @Target({ElementType.FIELD})
    @Retention(RetentionPolicy.RUNTIME)
    @SearchConfig(nativeDefValue = -1, searchClass = TPSubtitleRenderModel.class, tpDefValue = -1, valueClass = ContentClassification.AD_CONTENT_CLASSIFICATION_J)
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/adapter/strategy/utils/TPNativeKeyMap$MapSubtitleRenderParams.class */
    public @interface MapSubtitleRenderParams {
        long value();
    }

    @Target({ElementType.FIELD})
    @Retention(RetentionPolicy.RUNTIME)
    @SearchConfig(nativeDefValue = 0, searchClass = ITPPlayer.class, tpDefValue = 1, valueClass = int.class)
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/adapter/strategy/utils/TPNativeKeyMap$MapSwitchDefMode.class */
    public @interface MapSwitchDefMode {
        @TPCommonEnum.NativeSwitchDefMode
        int value();
    }

    @Target({ElementType.FIELD})
    @Retention(RetentionPolicy.RUNTIME)
    @SearchConfig(nativeDefValue = 0, searchClass = TPAudioAttributes.class, tpDefValue = 0, valueClass = int.class)
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/adapter/strategy/utils/TPNativeKeyMap$MapTPAudioAttributeContentType.class */
    public @interface MapTPAudioAttributeContentType {
        @TPNativeAudioAttributes.TPNativeAudioAttributeContentType
        int value();
    }

    @Target({ElementType.FIELD})
    @Retention(RetentionPolicy.RUNTIME)
    @SearchConfig(nativeDefValue = 0, searchClass = TPAudioAttributes.class, tpDefValue = 0, valueClass = int.class)
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/adapter/strategy/utils/TPNativeKeyMap$MapTPAudioAttributeFlag.class */
    public @interface MapTPAudioAttributeFlag {
        @TPNativeAudioAttributes.TPNativeAudioAttributeFlag
        int value();
    }

    @Target({ElementType.FIELD})
    @Retention(RetentionPolicy.RUNTIME)
    @SearchConfig(nativeDefValue = -1, searchClass = TPAudioAttributes.class, tpDefValue = -1, valueClass = int.class)
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/adapter/strategy/utils/TPNativeKeyMap$MapTPAudioAttributeStreamType.class */
    public @interface MapTPAudioAttributeStreamType {
        @TPNativeAudioAttributes.TPNativeAudioAttributeStreamType
        int value();
    }

    @Target({ElementType.FIELD})
    @Retention(RetentionPolicy.RUNTIME)
    @SearchConfig(nativeDefValue = 0, searchClass = TPAudioAttributes.class, tpDefValue = 0, valueClass = int.class)
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/adapter/strategy/utils/TPNativeKeyMap$MapTPAudioAttributeUsage.class */
    public @interface MapTPAudioAttributeUsage {
        @TPNativeAudioAttributes.TPNativeAudioAttributeUsage
        int value();
    }

    @Target({ElementType.FIELD})
    @Retention(RetentionPolicy.RUNTIME)
    @SearchConfig(nativeDefValue = -1, searchClass = TPThreadPriority.class, tpDefValue = -1, valueClass = int.class)
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/adapter/strategy/utils/TPNativeKeyMap$MapThreadPriorityType.class */
    public @interface MapThreadPriorityType {
        @TPCommonEnum.InnerThreadPriority
        int value();
    }

    @Target({ElementType.FIELD})
    @Retention(RetentionPolicy.RUNTIME)
    @SearchConfig(nativeDefValue = 2, searchClass = TPCommonEnum.class, tpDefValue = 2, valueClass = int.class)
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/adapter/strategy/utils/TPNativeKeyMap$MapVideoColorSpace.class */
    public @interface MapVideoColorSpace {
        @TPCommonEnum.InnerVideoColorSpace
        int value();
    }

    @Target({ElementType.FIELD})
    @Retention(RetentionPolicy.RUNTIME)
    @SearchConfig(nativeDefValue = -1, searchClass = TPCommonEnum.class, tpDefValue = -1, valueClass = int.class)
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/adapter/strategy/utils/TPNativeKeyMap$MapVideoDecoderType.class */
    public @interface MapVideoDecoderType {
        @TPCommonEnum.InnerVideoDecoderType
        int value();
    }

    @Target({ElementType.FIELD})
    @Retention(RetentionPolicy.RUNTIME)
    @SearchConfig(nativeDefValue = -1, searchClass = TPVideoSeiH264Type.class, tpDefValue = -1, valueClass = int.class)
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/adapter/strategy/utils/TPNativeKeyMap$MapVideoH264SeiType.class */
    public @interface MapVideoH264SeiType {
        @TPCommonEnum.InnerVideoH264SeiType
        int value();
    }

    @Target({ElementType.FIELD})
    @Retention(RetentionPolicy.RUNTIME)
    @SearchConfig(nativeDefValue = -1, searchClass = TPVideoSeiHevcType.class, tpDefValue = -1, valueClass = int.class)
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/adapter/strategy/utils/TPNativeKeyMap$MapVideoHevcSeiType.class */
    public @interface MapVideoHevcSeiType {
        @TPCommonEnum.InnerVideoHevcSeiType
        int value();
    }

    @Target({ElementType.ANNOTATION_TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/adapter/strategy/utils/TPNativeKeyMap$SearchConfig.class */
    @interface SearchConfig {
        long nativeDefValue();

        Class<?> searchClass();

        long tpDefValue();

        Class<? extends Number> valueClass();
    }
}
