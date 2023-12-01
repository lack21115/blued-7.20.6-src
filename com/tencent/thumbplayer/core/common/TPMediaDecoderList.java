package com.tencent.thumbplayer.core.common;

import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.os.Build;
import android.text.TextUtils;
import com.tencent.thumbplayer.core.thirdparties.LocalCache;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/core/common/TPMediaDecoderList.class */
public final class TPMediaDecoderList {
    private static final String MEDIA_DECODER_INFO_KEY = "DecoderInfos_Key";
    private static String MEDIA_DECODER_VERSION = "2.31.0.127.min";
    private static final String MEDIA_DECODER_VERSION_KEY = "Version_Key";
    private static final String TAG = "TPMediaDecoderList";
    private static TPMediaDecoderInfo[] sDecoderInfos;

    private static String buildCacheDecoderVersion() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(MEDIA_DECODER_VERSION);
        stringBuffer.append("_");
        stringBuffer.append(TPSystemInfo.getDeviceName());
        stringBuffer.append("_");
        stringBuffer.append(TPSystemInfo.getProductBoard());
        stringBuffer.append("_");
        stringBuffer.append(TPSystemInfo.getProductDevice());
        stringBuffer.append("_");
        stringBuffer.append(TPSystemInfo.getApiLevel());
        return stringBuffer.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static void cacheDecoderInfos(LocalCache localCache, TPMediaDecoderInfo[] tPMediaDecoderInfoArr) {
        try {
            localCache.put(MEDIA_DECODER_INFO_KEY, (Serializable) tPMediaDecoderInfoArr);
        } catch (Throwable th) {
            TPNativeLog.printLog(4, TAG, "cache decode infos failed");
        }
    }

    private static void cacheVersion(LocalCache localCache, String str) {
        try {
            localCache.put(MEDIA_DECODER_VERSION_KEY, str);
        } catch (Throwable th) {
            TPNativeLog.printLog(4, TAG, "cache version failed");
        }
    }

    private static TPMediaDecoderInfo[] getCachedDecoderInfos(LocalCache localCache) {
        try {
            return (TPMediaDecoderInfo[]) localCache.getAsObject(MEDIA_DECODER_INFO_KEY);
        } catch (Throwable th) {
            TPNativeLog.printLog(4, TAG, "get decoder info failed");
            return null;
        }
    }

    private static String getCachedVersion(LocalCache localCache) {
        try {
            String asString = localCache.getAsString(MEDIA_DECODER_VERSION_KEY);
            TPNativeLog.printLog(2, TAG, "version:".concat(String.valueOf(asString)));
            return asString;
        } catch (Throwable th) {
            TPNativeLog.printLog(4, TAG, "get version failed");
            return null;
        }
    }

    private static final MediaCodecInfo[] getCodecInfos() {
        if (Build.VERSION.SDK_INT < 16) {
            return new MediaCodecInfo[0];
        }
        if (Build.VERSION.SDK_INT < 21) {
            int codecCount = MediaCodecList.getCodecCount();
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < codecCount; i++) {
                arrayList.add(MediaCodecList.getCodecInfoAt(i));
            }
            return (MediaCodecInfo[]) arrayList.toArray(new MediaCodecInfo[arrayList.size()]);
        }
        try {
            return new MediaCodecList(1).getCodecInfos();
        } catch (Exception e) {
            TPNativeLog.printLog(4, "getCodecInfos MediaCodecList " + e.getMessage());
            return new MediaCodecInfo[0];
        }
    }

    private static final TPMediaDecoderInfo[] getLocalCacheMediaCodecList(LocalCache localCache) {
        TPMediaDecoderInfo[] cachedDecoderInfos;
        TPNativeLog.printLog(2, "getLocalCacheMediaCodecList");
        if (!TextUtils.equals(getCachedVersion(localCache), buildCacheDecoderVersion()) || (cachedDecoderInfos = getCachedDecoderInfos(localCache)) == null) {
            return null;
        }
        TPNativeLog.printLog(2, "getCachedDecoderInfos length " + cachedDecoderInfos.length);
        return cachedDecoderInfos;
    }

    private static final TPMediaDecoderInfo[] getSystemMediaCodecList() {
        TPNativeLog.printLog(2, "getSystemMediaCodecList");
        MediaCodecInfo[] codecInfos = getCodecInfos();
        if (codecInfos == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int length = codecInfos.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return (TPMediaDecoderInfo[]) arrayList.toArray(new TPMediaDecoderInfo[arrayList.size()]);
            }
            MediaCodecInfo mediaCodecInfo = codecInfos[i2];
            if (!mediaCodecInfo.isEncoder()) {
                String[] supportedTypes = mediaCodecInfo.getSupportedTypes();
                int length2 = supportedTypes.length;
                int i3 = 0;
                while (true) {
                    int i4 = i3;
                    if (i4 < length2) {
                        String str = supportedTypes[i4];
                        TPMediaDecoderInfo tPMediaDecoderInfo = new TPMediaDecoderInfo(str, mediaCodecInfo.getName(), mediaCodecInfo.getCapabilitiesForType(str));
                        if (tPMediaDecoderInfo.isValidDecoder()) {
                            TPNativeLog.printLog(2, "MediaCodecList codecName " + mediaCodecInfo.getName() + " supportedType " + str);
                            arrayList.add(tPMediaDecoderInfo);
                        }
                        i3 = i4 + 1;
                    }
                }
            }
            i = i2 + 1;
        }
    }

    public static final TPMediaDecoderInfo[] getTPMediaDecoderInfos(LocalCache localCache) {
        synchronized (TPMediaDecoderList.class) {
            try {
                if (sDecoderInfos == null) {
                    sDecoderInfos = initCodecList(localCache);
                }
                if (sDecoderInfos == null) {
                    return new TPMediaDecoderInfo[0];
                }
                TPMediaDecoderInfo[] tPMediaDecoderInfoArr = sDecoderInfos;
                return (TPMediaDecoderInfo[]) Arrays.copyOf(tPMediaDecoderInfoArr, tPMediaDecoderInfoArr.length);
            } finally {
            }
        }
    }

    private static final TPMediaDecoderInfo[] initCodecList(LocalCache localCache) {
        TPMediaDecoderInfo[] localCacheMediaCodecList = getLocalCacheMediaCodecList(localCache);
        TPMediaDecoderInfo[] tPMediaDecoderInfoArr = localCacheMediaCodecList;
        if (localCacheMediaCodecList == null) {
            tPMediaDecoderInfoArr = getSystemMediaCodecList();
            storeLocalCacheMediaCodecList(localCache, tPMediaDecoderInfoArr);
        }
        return tPMediaDecoderInfoArr;
    }

    private static final void storeLocalCacheMediaCodecList(LocalCache localCache, TPMediaDecoderInfo[] tPMediaDecoderInfoArr) {
        TPNativeLog.printLog(2, "storeLocalCacheMediaCodecList");
        cacheDecoderInfos(localCache, tPMediaDecoderInfoArr);
        cacheVersion(localCache, buildCacheDecoderVersion());
    }
}
