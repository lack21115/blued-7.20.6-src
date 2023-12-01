package com.tencent.thumbplayer.api.capability;

import com.tencent.thumbplayer.adapter.a.b.a;
import com.tencent.thumbplayer.adapter.strategy.utils.TPNativeKeyMap;
import com.tencent.thumbplayer.adapter.strategy.utils.TPNativeKeyMapUtil;
import com.tencent.thumbplayer.api.TPCommonEnum;
import com.tencent.thumbplayer.api.TPNativeException;
import com.tencent.thumbplayer.api.TPPlayerMgr;
import com.tencent.thumbplayer.core.common.TPCodecCapability;
import com.tencent.thumbplayer.core.common.TPNativeLibraryException;
import com.tencent.thumbplayer.core.common.TPNativeLibraryLoader;
import com.tencent.thumbplayer.core.common.TPThumbplayerCapabilityHelper;
import java.util.HashMap;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/api/capability/TPCapability.class */
public class TPCapability {
    public static boolean addACodecBlacklist(@TPCommonEnum.TP_AUDIO_DECODER_TYPE int i, @TPCommonEnum.TP_AUDIO_CODEC_TYPE int i2, TPACodecCapabilityForSet tPACodecCapabilityForSet) {
        TPCodecCapability.TPACodecPropertyRange tPACodecPropertyRange = new TPCodecCapability.TPACodecPropertyRange();
        tPACodecPropertyRange.set(tPACodecCapabilityForSet.getUpperboundSamplerate(), tPACodecCapabilityForSet.getUpperboundChannels(), tPACodecCapabilityForSet.getUpperboundBitrate(), tPACodecCapabilityForSet.getLowerboundSamplerate(), tPACodecCapabilityForSet.getLowerboundChannels(), tPACodecCapabilityForSet.getLowerboundBitrate(), tPACodecCapabilityForSet.getProfileForSet(), tPACodecCapabilityForSet.getLevelForSet());
        try {
            return TPThumbplayerCapabilityHelper.addACodecBlacklist(TPNativeKeyMapUtil.toNativeIntValue(TPNativeKeyMap.MapAudioDecoderType.class, i), TPNativeKeyMapUtil.toNativeIntValue(TPNativeKeyMap.MapAudioCodecType.class, i2), tPACodecPropertyRange);
        } catch (TPNativeLibraryException e) {
            throw new TPNativeException(e);
        }
    }

    public static boolean addACodecWhitelist(@TPCommonEnum.TP_AUDIO_DECODER_TYPE int i, @TPCommonEnum.TP_AUDIO_CODEC_TYPE int i2, TPACodecCapabilityForSet tPACodecCapabilityForSet) {
        TPCodecCapability.TPACodecPropertyRange tPACodecPropertyRange = new TPCodecCapability.TPACodecPropertyRange();
        tPACodecPropertyRange.set(tPACodecCapabilityForSet.getUpperboundSamplerate(), tPACodecCapabilityForSet.getUpperboundChannels(), tPACodecCapabilityForSet.getUpperboundBitrate(), tPACodecCapabilityForSet.getLowerboundSamplerate(), tPACodecCapabilityForSet.getLowerboundChannels(), tPACodecCapabilityForSet.getLowerboundBitrate(), tPACodecCapabilityForSet.getProfileForSet(), tPACodecCapabilityForSet.getLevelForSet());
        try {
            return TPThumbplayerCapabilityHelper.addACodecWhitelist(TPNativeKeyMapUtil.toNativeIntValue(TPNativeKeyMap.MapAudioDecoderType.class, i), TPNativeKeyMapUtil.toNativeIntValue(TPNativeKeyMap.MapAudioCodecType.class, i2), tPACodecPropertyRange);
        } catch (TPNativeLibraryException e) {
            throw new TPNativeException(e);
        }
    }

    public static boolean addDRMLevel1Blacklist(@TPCommonEnum.TP_DRM_TYPE int i) {
        return TPThumbplayerCapabilityHelper.addDRMLevel1Blacklist(i);
    }

    public static boolean addHDRBlackList(@TPCommonEnum.TP_HDR_TYPE int i, TPHDRVersionRange tPHDRVersionRange) {
        return TPThumbplayerCapabilityHelper.addHDRBlackList(TPNativeKeyMapUtil.toNativeIntValue(TPNativeKeyMap.MapHdrType.class, i), new TPCodecCapability.TPHdrSupportVersionRange(tPHDRVersionRange.upperboundSystemVersion, tPHDRVersionRange.lowerboundSystemVersion, tPHDRVersionRange.upperboundPatchVersion, tPHDRVersionRange.lowerboundPatchVersion));
    }

    public static boolean addHDRVideoDecoderTypeWhiteList(@TPCommonEnum.TP_HDR_TYPE int i, @TPCommonEnum.TP_VIDEO_DECODER_TYPE int i2, TPHDRVersionRange tPHDRVersionRange) {
        TPCodecCapability.TPHdrSupportVersionRange tPHdrSupportVersionRange = new TPCodecCapability.TPHdrSupportVersionRange(tPHDRVersionRange.upperboundSystemVersion, tPHDRVersionRange.lowerboundSystemVersion, tPHDRVersionRange.upperboundPatchVersion, tPHDRVersionRange.lowerboundPatchVersion);
        tPHdrSupportVersionRange.lowerboundAndroidAPILevel = 0;
        tPHdrSupportVersionRange.upperboundAndroidAPILevel = 999;
        return TPThumbplayerCapabilityHelper.addHDRVideoDecoderTypeWhiteList(TPNativeKeyMapUtil.toNativeIntValue(TPNativeKeyMap.MapHdrType.class, i), TPNativeKeyMapUtil.toNativeIntValue(TPNativeKeyMap.MapVideoDecoderType.class, i2), tPHdrSupportVersionRange);
    }

    public static boolean addHDRWhiteList(@TPCommonEnum.TP_HDR_TYPE int i, TPHDRVersionRange tPHDRVersionRange) {
        return TPThumbplayerCapabilityHelper.addHDRWhiteList(TPNativeKeyMapUtil.toNativeIntValue(TPNativeKeyMap.MapHdrType.class, i), new TPCodecCapability.TPHdrSupportVersionRange(tPHDRVersionRange.upperboundSystemVersion, tPHDRVersionRange.lowerboundSystemVersion, tPHDRVersionRange.upperboundPatchVersion, tPHDRVersionRange.lowerboundPatchVersion));
    }

    public static boolean addVCodecBlacklist(@TPCommonEnum.TP_VIDEO_DECODER_TYPE int i, @TPCommonEnum.TP_VIDEO_CODEC_TYPE int i2, TPVCodecCapabilityForSet tPVCodecCapabilityForSet) {
        TPCodecCapability.TPVCodecPropertyRange tPVCodecPropertyRange = new TPCodecCapability.TPVCodecPropertyRange();
        tPVCodecPropertyRange.set(tPVCodecCapabilityForSet.getUpperboundWidth(), tPVCodecCapabilityForSet.getUpperboundHeight(), tPVCodecCapabilityForSet.getLowerboundWidth(), tPVCodecCapabilityForSet.getLowerboundHeight(), tPVCodecCapabilityForSet.getProfile(), tPVCodecCapabilityForSet.getLevel());
        try {
            return TPThumbplayerCapabilityHelper.addVCodecBlacklist(TPNativeKeyMapUtil.toNativeIntValue(TPNativeKeyMap.MapVideoDecoderType.class, i), TPNativeKeyMapUtil.toNativeIntValue(TPNativeKeyMap.MapCodecType.class, i2), tPVCodecPropertyRange);
        } catch (TPNativeLibraryException e) {
            throw new TPNativeException(e);
        }
    }

    public static boolean addVCodecWhitelist(@TPCommonEnum.TP_VIDEO_DECODER_TYPE int i, @TPCommonEnum.TP_VIDEO_CODEC_TYPE int i2, TPVCodecCapabilityForSet tPVCodecCapabilityForSet) {
        TPCodecCapability.TPVCodecPropertyRange tPVCodecPropertyRange = new TPCodecCapability.TPVCodecPropertyRange();
        tPVCodecPropertyRange.set(tPVCodecCapabilityForSet.getUpperboundWidth(), tPVCodecCapabilityForSet.getUpperboundHeight(), tPVCodecCapabilityForSet.getLowerboundWidth(), tPVCodecCapabilityForSet.getLowerboundHeight(), tPVCodecCapabilityForSet.getProfile(), tPVCodecCapabilityForSet.getLevel());
        try {
            return TPThumbplayerCapabilityHelper.addVCodecWhitelist(TPNativeKeyMapUtil.toNativeIntValue(TPNativeKeyMap.MapVideoDecoderType.class, i), TPNativeKeyMapUtil.toNativeIntValue(TPNativeKeyMap.MapCodecType.class, i2), tPVCodecPropertyRange);
        } catch (TPNativeLibraryException e) {
            throw new TPNativeException(e);
        }
    }

    public static int[] getDRMCapabilities() {
        return a.a();
    }

    public static TPVCodecCapabilityForGet getThumbPlayerVCodecMaxCapability(@TPCommonEnum.TP_VIDEO_CODEC_TYPE int i) {
        if (TPPlayerMgr.isThumbPlayerEnable()) {
            try {
                TPCodecCapability.TPCodecMaxCapability vCodecMaxCapability = TPThumbplayerCapabilityHelper.getVCodecMaxCapability(TPNativeKeyMapUtil.toNativeIntValue(TPNativeKeyMap.MapCodecType.class, i));
                return vCodecMaxCapability == null ? TPVCodecCapabilityForGet.mDefaultVCodecCapability : new TPVCodecCapabilityForGet(vCodecMaxCapability.maxLumaSamples, vCodecMaxCapability.maxProfile, vCodecMaxCapability.maxLevel, vCodecMaxCapability.maxFramerateFormaxLumaSamples);
            } catch (TPNativeLibraryException e) {
                throw new TPNativeException(e);
            }
        }
        return TPVCodecCapabilityForGet.mDefaultVCodecCapability;
    }

    public static TPVCodecCapabilityForGet getThumbPlayerVCodecTypeMaxCapability(@TPCommonEnum.TP_VIDEO_CODEC_TYPE int i, @TPCommonEnum.TP_VIDEO_DECODER_TYPE int i2) {
        if (TPNativeLibraryLoader.isLibLoaded()) {
            try {
                HashMap<Integer, TPCodecCapability.TPCodecMaxCapability> vCodecDecoderMaxCapabilityMap = TPThumbplayerCapabilityHelper.getVCodecDecoderMaxCapabilityMap(TPNativeKeyMapUtil.toNativeIntValue(TPNativeKeyMap.MapVideoDecoderType.class, i2));
                int nativeIntValue = TPNativeKeyMapUtil.toNativeIntValue(TPNativeKeyMap.MapCodecType.class, i);
                if (vCodecDecoderMaxCapabilityMap == null || vCodecDecoderMaxCapabilityMap.isEmpty()) {
                    return TPVCodecCapabilityForGet.mDefaultVCodecCapability;
                }
                TPCodecCapability.TPCodecMaxCapability tPCodecMaxCapability = vCodecDecoderMaxCapabilityMap.get(Integer.valueOf(nativeIntValue));
                return tPCodecMaxCapability == null ? TPVCodecCapabilityForGet.mDefaultVCodecCapability : new TPVCodecCapabilityForGet(tPCodecMaxCapability.maxLumaSamples, tPCodecMaxCapability.maxProfile, tPCodecMaxCapability.maxLevel, tPCodecMaxCapability.maxFramerateFormaxLumaSamples);
            } catch (TPNativeLibraryException e) {
                throw new TPNativeException(e);
            }
        }
        return TPVCodecCapabilityForGet.mDefaultVCodecCapability;
    }

    public static boolean isACodecCapabilityCanSupport(@TPCommonEnum.TP_AUDIO_CODEC_TYPE int i, int i2, int i3, int i4, int i5, int i6) {
        if (TPPlayerMgr.isThumbPlayerEnable()) {
            try {
                return TPThumbplayerCapabilityHelper.isACodecCapabilityCanSupport(i, i2, i3, i4, i5, i6);
            } catch (TPNativeLibraryException e) {
                throw new TPNativeException(e);
            }
        }
        return false;
    }

    public static boolean isDDPlusSupported() {
        if (TPPlayerMgr.isThumbPlayerEnable()) {
            return TPThumbplayerCapabilityHelper.isDDPlusSupported();
        }
        return false;
    }

    public static boolean isDDSupported() {
        if (TPPlayerMgr.isThumbPlayerEnable()) {
            return TPThumbplayerCapabilityHelper.isDDSupported();
        }
        return false;
    }

    public static boolean isDRMsupport(@TPCommonEnum.TP_DRM_TYPE int i) {
        return a.a(i);
    }

    public static boolean isDolbyDSSupported() {
        if (TPPlayerMgr.isThumbPlayerEnable()) {
            return TPThumbplayerCapabilityHelper.isDolbyDSSupported();
        }
        return false;
    }

    public static boolean isDolbyVisionSupported() {
        return false;
    }

    public static boolean isFeatureSupport(@TPCommonEnum.InnerFeatureType int i) {
        if (TPPlayerMgr.isThumbPlayerEnable()) {
            try {
                return TPThumbplayerCapabilityHelper.isFeatureSupport(TPNativeKeyMapUtil.toNativeIntValue(TPNativeKeyMap.MapFeatureType.class, i));
            } catch (TPNativeLibraryException e) {
                throw new TPNativeException(e);
            }
        }
        return false;
    }

    public static boolean isHDRsupport(@TPCommonEnum.TP_HDR_TYPE int i, int i2, int i3) {
        if (TPPlayerMgr.isThumbPlayerEnable()) {
            return TPThumbplayerCapabilityHelper.isHDRsupport(TPNativeKeyMapUtil.toNativeIntValue(TPNativeKeyMap.MapHdrType.class, i), i2, i3);
        }
        return false;
    }

    public static boolean isVCodecCapabilityCanSupport(@TPCommonEnum.TP_VIDEO_CODEC_TYPE int i, int i2, int i3, int i4, int i5, int i6) {
        if (TPPlayerMgr.isThumbPlayerEnable()) {
            try {
                return TPThumbplayerCapabilityHelper.isVCodecCapabilityCanSupport(i, i2, i3, 0, 0, i6);
            } catch (TPNativeLibraryException e) {
                throw new TPNativeException(e);
            }
        }
        return false;
    }

    public static boolean isVCodecCapabilityCanSupport(@TPCommonEnum.TP_VIDEO_CODEC_TYPE int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        if (TPPlayerMgr.isThumbPlayerEnable()) {
            try {
                return TPThumbplayerCapabilityHelper.isVCodecCapabilitySupport(i2, i, i3, i4, 0, 0, i7);
            } catch (TPNativeLibraryException e) {
                throw new TPNativeException(e);
            }
        }
        return false;
    }

    public static void setMediaCodecPreferredSoftwareComponent(boolean z) {
        if (TPPlayerMgr.isThumbPlayerEnable()) {
            TPThumbplayerCapabilityHelper.setMediaCodecPreferredSoftwareComponent(z);
        }
    }
}
