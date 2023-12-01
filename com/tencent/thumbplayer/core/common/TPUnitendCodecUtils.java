package com.tencent.thumbplayer.core.common;

import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.text.TextUtils;
import java.util.HashMap;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/core/common/TPUnitendCodecUtils.class */
public class TPUnitendCodecUtils {
    private static int DolbyVisionProfileDvavPen = 1;
    private static int DolbyVisionProfileDvavPer = 0;
    private static int DolbyVisionProfileDvavSe = 9;
    private static int DolbyVisionProfileDvheDen = 3;
    private static int DolbyVisionProfileDvheDer = 2;
    private static int DolbyVisionProfileDvheDtb = 7;
    private static int DolbyVisionProfileDvheDth = 6;
    private static int DolbyVisionProfileDvheDtr = 4;
    private static int DolbyVisionProfileDvheSt = 8;
    private static int DolbyVisionProfileDvheStn = 5;
    private static HashMap<String, String> mSecureDecoderNameMaps;

    public static int convertOmxProfileToDolbyVision(int i) {
        int i2 = i != 1 ? i != 2 ? i != 4 ? i != 8 ? i != 16 ? i != 32 ? i != 64 ? i != 128 ? i != 256 ? i != 512 ? 0 : DolbyVisionProfileDvavSe : DolbyVisionProfileDvheSt : DolbyVisionProfileDvheDtb : DolbyVisionProfileDvheDth : DolbyVisionProfileDvheStn : DolbyVisionProfileDvheDtr : DolbyVisionProfileDvheDen : DolbyVisionProfileDvheDer : DolbyVisionProfileDvavPen : DolbyVisionProfileDvavPer;
        TPNativeLog.printLog(2, "TPUnitendCodecUtils", "convertOmxProfileToDolbyVision omxProfile:" + i + " dolbyVisionProfile:" + i2);
        return i2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:51:0x0146, code lost:
        com.tencent.thumbplayer.core.common.TPNativeLog.printLog(2, "TPUnitendCodecUtils", "getDolbyVisionDecoderName name:".concat(java.lang.String.valueOf(r14)));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String getDolbyVisionDecoderName(java.lang.String r5, int r6, int r7, boolean r8) {
        /*
            Method dump skipped, instructions count: 382
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.thumbplayer.core.common.TPUnitendCodecUtils.getDolbyVisionDecoderName(java.lang.String, int, int, boolean):java.lang.String");
    }

    public static String getSecureDecoderName(String str) {
        String str2;
        MediaCodecInfo.CodecCapabilities codecCapabilities;
        synchronized (TPUnitendCodecUtils.class) {
            try {
                if (TextUtils.equals("video/avc", str) || TextUtils.equals("video/hevc", str) || TextUtils.equals(TPDecoderType.TP_CODEC_MIMETYPE_DOLBYVISION, str)) {
                    if (mSecureDecoderNameMaps == null) {
                        mSecureDecoderNameMaps = new HashMap<>();
                    }
                    if (mSecureDecoderNameMaps.containsKey(str)) {
                        return mSecureDecoderNameMaps.get(str);
                    }
                    MediaCodecInfo[] codecInfos = new MediaCodecList(1).getCodecInfos();
                    if (codecInfos == null) {
                        return null;
                    }
                    int length = codecInfos.length;
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        str2 = null;
                        if (i2 >= length) {
                            break;
                        }
                        MediaCodecInfo mediaCodecInfo = codecInfos[i2];
                        if (!mediaCodecInfo.isEncoder()) {
                            try {
                                codecCapabilities = mediaCodecInfo.getCapabilitiesForType(str);
                            } catch (Exception e) {
                                codecCapabilities = null;
                            }
                            if (codecCapabilities != null && codecCapabilities.isFeatureSupported(MediaCodecInfo.CodecCapabilities.FEATURE_SecurePlayback)) {
                                str2 = mediaCodecInfo.getName();
                                break;
                            }
                        }
                        i = i2 + 1;
                    }
                    mSecureDecoderNameMaps.put(str, str2);
                    return str2;
                }
                return null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
