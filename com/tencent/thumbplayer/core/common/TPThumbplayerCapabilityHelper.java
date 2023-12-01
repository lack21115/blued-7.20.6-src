package com.tencent.thumbplayer.core.common;

import android.content.Context;
import android.os.Build;
import com.tencent.thumbplayer.core.common.TPCodecCapability;
import java.util.HashMap;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/core/common/TPThumbplayerCapabilityHelper.class */
public class TPThumbplayerCapabilityHelper {
    public static boolean addACodecBlacklist(int i, int i2, TPCodecCapability.TPACodecPropertyRange tPACodecPropertyRange) {
        return TPPlayerDecoderCapability.addACodecBlacklist(i, i2, tPACodecPropertyRange);
    }

    public static boolean addACodecWhitelist(int i, int i2, TPCodecCapability.TPACodecPropertyRange tPACodecPropertyRange) {
        return TPPlayerDecoderCapability.addACodecWhitelist(i, i2, tPACodecPropertyRange);
    }

    public static boolean addDRMLevel1Blacklist(int i) {
        return TPPlayerDecoderCapability.addDRMLevel1Blacklist(i);
    }

    public static boolean addHDRBlackList(int i, TPCodecCapability.TPHdrSupportVersionRange tPHdrSupportVersionRange) {
        return TPPlayerDecoderCapability.addHDRBlackList(i, tPHdrSupportVersionRange);
    }

    public static boolean addHDRVideoDecoderTypeWhiteList(int i, int i2, TPCodecCapability.TPHdrSupportVersionRange tPHdrSupportVersionRange) {
        return TPPlayerDecoderCapability.addHDRVideoDecoderTypeWhiteList(i, i2, tPHdrSupportVersionRange);
    }

    public static boolean addHDRWhiteList(int i, TPCodecCapability.TPHdrSupportVersionRange tPHdrSupportVersionRange) {
        return TPPlayerDecoderCapability.addHDRWhiteList(i, tPHdrSupportVersionRange);
    }

    public static boolean addVCodecBlacklist(int i, int i2, TPCodecCapability.TPVCodecPropertyRange tPVCodecPropertyRange) {
        return TPPlayerDecoderCapability.addVCodecBlacklist(i, i2, tPVCodecPropertyRange);
    }

    public static boolean addVCodecWhitelist(int i, int i2, TPCodecCapability.TPVCodecPropertyRange tPVCodecPropertyRange) {
        return TPPlayerDecoderCapability.addVCodecWhitelist(i, i2, tPVCodecPropertyRange);
    }

    public static int[] getDRMCapabilities() {
        return TPDrm.getDRMCapabilities();
    }

    public static HashMap<Integer, TPCodecCapability.TPCodecMaxCapability> getVCodecDecoderMaxCapabilityMap(int i) {
        return TPPlayerDecoderCapability.getVCodecDecoderMaxCapabilityMap(i);
    }

    public static TPCodecCapability.TPCodecMaxCapability getVCodecMaxCapability(int i) {
        TPCodecCapability.TPCodecMaxCapability tPCodecMaxCapability = new TPCodecCapability.TPCodecMaxCapability(0, 0, 0, 30);
        HashMap<Integer, TPCodecCapability.TPCodecMaxCapability> vCodecDecoderMaxCapabilityMap = TPPlayerDecoderCapability.getVCodecDecoderMaxCapabilityMap(102);
        HashMap<Integer, TPCodecCapability.TPCodecMaxCapability> vCodecDecoderMaxCapabilityMap2 = TPPlayerDecoderCapability.getVCodecDecoderMaxCapabilityMap(101);
        TPCodecCapability.TPCodecMaxCapability tPCodecMaxCapability2 = tPCodecMaxCapability;
        if (vCodecDecoderMaxCapabilityMap != null) {
            TPCodecCapability.TPCodecMaxCapability tPCodecMaxCapability3 = vCodecDecoderMaxCapabilityMap.get(Integer.valueOf(i));
            tPCodecMaxCapability2 = tPCodecMaxCapability;
            if (tPCodecMaxCapability3 != null) {
                tPCodecMaxCapability2 = tPCodecMaxCapability3;
            }
        }
        TPCodecCapability.TPCodecMaxCapability tPCodecMaxCapability4 = tPCodecMaxCapability2;
        if (vCodecDecoderMaxCapabilityMap2 != null) {
            TPCodecCapability.TPCodecMaxCapability tPCodecMaxCapability5 = vCodecDecoderMaxCapabilityMap2.get(Integer.valueOf(i));
            tPCodecMaxCapability4 = tPCodecMaxCapability2;
            if (tPCodecMaxCapability5 != null) {
                tPCodecMaxCapability4 = tPCodecMaxCapability2;
                if (tPCodecMaxCapability5.maxLumaSamples > tPCodecMaxCapability2.maxLumaSamples) {
                    tPCodecMaxCapability4 = tPCodecMaxCapability5;
                }
            }
        }
        return tPCodecMaxCapability4;
    }

    public static void init(Context context, boolean z) {
        synchronized (TPThumbplayerCapabilityHelper.class) {
            try {
                TPPlayerDecoderCapability.init(context, z);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static boolean isACodecCapabilityCanSupport(int i, int i2, int i3, int i4, int i5, int i6) {
        if (isACodecCapabilitySupport(1, i, i2, i3, i4, i5, i6)) {
            return true;
        }
        return isACodecCapabilitySupport(102, i, i2, i3, i4, i5, i6);
    }

    public static boolean isACodecCapabilitySupport(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        return TPPlayerDecoderCapability.isACodecCapabilitySupport(i, i2, i3, i4, i5, i6, i7);
    }

    public static boolean isDDPlusSupported() {
        return TPPlayerDecoderCapability.isDDPlusSupported();
    }

    public static boolean isDDSupported() {
        return TPPlayerDecoderCapability.isDDPlusSupported();
    }

    public static boolean isDRMsupport(int i) {
        int[] dRMCapabilities = getDRMCapabilities();
        if (dRMCapabilities.length == 0) {
            return false;
        }
        int length = dRMCapabilities.length;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= length) {
                return false;
            }
            if (i == dRMCapabilities[i3]) {
                return true;
            }
            i2 = i3 + 1;
        }
    }

    public static boolean isDolbyDSSupported() {
        return TPPlayerDecoderCapability.isDolbyDSSupported();
    }

    public static boolean isFeatureSupport(int i) {
        return TPFeatureCapability.isFeatureSupport(i);
    }

    public static boolean isHDRsupport(int i, int i2, int i3) {
        return TPPlayerDecoderCapability.isHDRsupport(i, i2, i3);
    }

    public static boolean isSupportMediaCodecRotateInternal() {
        return Build.VERSION.SDK_INT >= 23;
    }

    public static boolean isSupportNativeMediaCodec() {
        return Build.VERSION.SDK_INT >= 23;
    }

    public static boolean isSupportSetOutputSurfaceApi() {
        return Build.VERSION.SDK_INT >= 23;
    }

    @Deprecated
    public static boolean isVCodecCapabilityCanSupport(int i, int i2, int i3, int i4, int i5) {
        return isVCodecCapabilityCanSupport(i, i2, i3, i4, i5, 30);
    }

    public static boolean isVCodecCapabilityCanSupport(int i, int i2, int i3, int i4, int i5, int i6) {
        if (isVCodecCapabilitySupport(101, i, i2, i3, i4, i5, i6)) {
            return true;
        }
        return isVCodecCapabilitySupport(102, i, i2, i3, i4, i5, i6);
    }

    @Deprecated
    public static boolean isVCodecCapabilitySupport(int i, int i2, int i3, int i4, int i5, int i6) {
        return isVCodecCapabilitySupport(i, i2, i3, i4, i5, i6, 30);
    }

    public static boolean isVCodecCapabilitySupport(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        return TPPlayerDecoderCapability.isVCodecCapabilitySupport(i, i2, i3, i4, i5, i6, i7);
    }

    public static void setMediaCodecPreferredSoftwareComponent(boolean z) {
        TPPlayerDecoderCapability.setMediaCodecPreferredSoftwareComponent(z);
    }
}
