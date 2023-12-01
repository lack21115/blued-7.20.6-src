package com.tencent.thumbplayer.core.common;

import android.content.Context;
import com.tencent.thumbplayer.core.common.TPCodecCapability;
import java.util.HashMap;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/core/common/TPPlayerDecoderCapability.class */
public class TPPlayerDecoderCapability {
    private static String TAG = "TPPlayerDecoderCapability";
    private static boolean mIsLibLoaded;
    private long mNativeContext = 0;

    static {
        try {
            TPNativeLibraryLoader.loadLibIfNeeded(null);
            mIsLibLoaded = true;
        } catch (UnsupportedOperationException e) {
            TPNativeLog.printLog(4, e.getMessage());
            mIsLibLoaded = false;
        }
    }

    private static native boolean _addACodecBlacklist(int i, int i2, TPCodecCapability.TPACodecPropertyRange tPACodecPropertyRange);

    private static native boolean _addACodecWhitelist(int i, int i2, TPCodecCapability.TPACodecPropertyRange tPACodecPropertyRange);

    private static native boolean _addVCodecBlacklist(int i, int i2, TPCodecCapability.TPVCodecPropertyRange tPVCodecPropertyRange);

    private static native boolean _addVCodecWhitelist(int i, int i2, TPCodecCapability.TPVCodecPropertyRange tPVCodecPropertyRange);

    private static native HashMap<Integer, TPCodecCapability.TPCodecMaxCapability> _getDecoderMaxCapabilityMap(int i);

    private static native boolean _isACodecCapabilitySupport(int i, int i2, int i3, int i4, int i5, int i6, int i7);

    private static native boolean _isVCodecCapabilitySupport(int i, int i2, int i3, int i4, int i5, int i6, int i7);

    public static boolean addACodecBlacklist(int i, int i2, TPCodecCapability.TPACodecPropertyRange tPACodecPropertyRange) {
        if (isLibLoaded()) {
            try {
                return _addACodecBlacklist(i, i2, tPACodecPropertyRange);
            } catch (Throwable th) {
                TPNativeLog.printLog(4, th.getMessage());
                throw new TPNativeLibraryException("Failed to call _addACodecBlacklist.");
            }
        }
        throw new TPNativeLibraryException("addACodecBlacklist: Failed to load native library.");
    }

    public static boolean addACodecWhitelist(int i, int i2, TPCodecCapability.TPACodecPropertyRange tPACodecPropertyRange) {
        if (isLibLoaded()) {
            try {
                return _addACodecWhitelist(i, i2, tPACodecPropertyRange);
            } catch (Throwable th) {
                TPNativeLog.printLog(4, th.getMessage());
                throw new TPNativeLibraryException("Failed to call _addVCodecWhitelist.");
            }
        }
        throw new TPNativeLibraryException("addACodecWhitelist: Failed to load native library.");
    }

    public static boolean addDRMLevel1Blacklist(int i) {
        return TPCodecUtils.addDRMLevel1Blacklist(i);
    }

    public static boolean addHDRBlackList(int i, TPCodecCapability.TPHdrSupportVersionRange tPHdrSupportVersionRange) {
        return TPCodecUtils.addHDRBlackList(i, TPSystemInfo.getDeviceName(), tPHdrSupportVersionRange);
    }

    public static boolean addHDRVideoDecoderTypeWhiteList(int i, int i2, TPCodecCapability.TPHdrSupportVersionRange tPHdrSupportVersionRange) {
        return TPCodecUtils.addHDRVideoDecoderTypeWhiteList(i, i2, tPHdrSupportVersionRange);
    }

    public static boolean addHDRWhiteList(int i, TPCodecCapability.TPHdrSupportVersionRange tPHdrSupportVersionRange) {
        return TPCodecUtils.addHDRWhiteList(i, TPSystemInfo.getDeviceName(), tPHdrSupportVersionRange);
    }

    public static boolean addVCodecBlacklist(int i, int i2, TPCodecCapability.TPVCodecPropertyRange tPVCodecPropertyRange) {
        if (isLibLoaded()) {
            try {
                return _addVCodecBlacklist(i, i2, tPVCodecPropertyRange);
            } catch (Throwable th) {
                TPNativeLog.printLog(4, th.getMessage());
                throw new TPNativeLibraryException("Failed to call _addVCodecBlacklist.");
            }
        }
        throw new TPNativeLibraryException("addVCodecBlacklist: Failed to load native library.");
    }

    public static boolean addVCodecWhitelist(int i, int i2, TPCodecCapability.TPVCodecPropertyRange tPVCodecPropertyRange) {
        if (isLibLoaded()) {
            try {
                return _addVCodecWhitelist(i, i2, tPVCodecPropertyRange);
            } catch (Throwable th) {
                TPNativeLog.printLog(4, th.getMessage());
                throw new TPNativeLibraryException("Failed to call _addVCodecWhitelist.");
            }
        }
        throw new TPNativeLibraryException("addVCodecWhitelist :Failed to load native library.");
    }

    public static HashMap<Integer, TPCodecCapability.TPCodecMaxCapability> getVCodecDecoderMaxCapabilityMap(int i) {
        if (isLibLoaded()) {
            try {
                return _getDecoderMaxCapabilityMap(i);
            } catch (Throwable th) {
                TPNativeLog.printLog(4, th.getMessage());
                throw new TPNativeLibraryException("Failed to call _getDecoderMaxCapabilityMap.");
            }
        }
        throw new TPNativeLibraryException("Failed to load native library.");
    }

    public static void init(Context context, boolean z) {
        synchronized (TPPlayerDecoderCapability.class) {
            try {
                TPCodecUtils.init(context, z);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static boolean isACodecCapabilitySupport(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        String str;
        if (2 == i) {
            if (i2 == 5012) {
                str = "audio/flac";
            } else if (i2 != 5040) {
                switch (i2) {
                    case 5002:
                        str = "audio/aac";
                        break;
                    case 5003:
                        str = "audio/ac3";
                        break;
                    case 5004:
                        str = "audio/dts";
                        break;
                    default:
                        str = "";
                        break;
                }
            } else {
                str = "audio/eac3";
            }
            if (TPCodecUtils.isInMediaCodecWhiteList(str)) {
                return true;
            }
            if (TPCodecUtils.isAMediaCodecBlackListModel() || TPCodecUtils.isBlackListType(str)) {
                return false;
            }
        }
        if (isLibLoaded()) {
            try {
                return _isACodecCapabilitySupport(i, i2, i3, i4, i5, i6, i7);
            } catch (Throwable th) {
                TPNativeLog.printLog(4, th.getMessage());
                throw new TPNativeLibraryException("Failed to call _isACodecCapabilitySupport.");
            }
        }
        throw new TPNativeLibraryException("Failed to load native library.");
    }

    public static boolean isDDPlusSupported() {
        return TPCodecUtils.isMediaCodecDDPlusSupported();
    }

    public static boolean isDolbyDSSupported() {
        return TPCodecUtils.isMediaCodecDolbyDSSupported();
    }

    public static boolean isHDRsupport(int i, int i2, int i3) {
        return TPCodecUtils.isHDRsupport(i, i2, i3);
    }

    private static boolean isLibLoaded() {
        return mIsLibLoaded;
    }

    public static boolean isVCodecCapabilitySupport(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        if (102 == i) {
            String str = i2 != 26 ? i2 != 138 ? i2 != 166 ? i2 != 172 ? i2 != 1029 ? "" : TPDecoderType.TP_CODEC_MIMETYPE_AV1 : "video/hevc" : "video/x-vnd.on2.vp9" : "video/x-vnd.on2.vp8" : "video/avc";
            if (TPCodecUtils.isInMediaCodecWhiteList(str)) {
                return true;
            }
            if (TPCodecUtils.isVMediaCodecBlackListModel() || TPCodecUtils.isBlackListType(str)) {
                return false;
            }
        }
        if (isLibLoaded()) {
            try {
                return _isVCodecCapabilitySupport(i, i2, i3, i4, i5, i6, i7);
            } catch (Throwable th) {
                TPNativeLog.printLog(4, th.getMessage());
                throw new TPNativeLibraryException("Failed to call _isVCodecCapabilitySupport.");
            }
        }
        throw new TPNativeLibraryException("Failed to load native library.");
    }

    public static void setMediaCodecPreferredSoftwareComponent(boolean z) {
        TPCodecUtils.setMediaCodecPreferredSoftwareComponent(z);
    }
}
