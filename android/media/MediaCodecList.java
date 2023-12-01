package android.media;

import android.media.MediaCodecInfo;
import android.util.Log;
import java.util.ArrayList;
import java.util.Arrays;

/* loaded from: source-9557208-dex2jar.jar:android/media/MediaCodecList.class */
public final class MediaCodecList {
    public static final int ALL_CODECS = 1;
    public static final int REGULAR_CODECS = 0;
    private static final String TAG = "MediaCodecList";
    private static MediaCodecInfo[] sAllCodecInfos;
    private static Object sInitLock = new Object();
    private static MediaCodecInfo[] sRegularCodecInfos;
    private MediaCodecInfo[] mCodecInfos;

    static {
        System.loadLibrary("media_jni");
        native_init();
    }

    private MediaCodecList() {
        this(0);
    }

    public MediaCodecList(int i) {
        initCodecList();
        if (i == 0) {
            this.mCodecInfos = sRegularCodecInfos;
        } else {
            this.mCodecInfos = sAllCodecInfos;
        }
    }

    static final native int findCodecByName(String str);

    private String findCodecForFormat(boolean z, MediaFormat mediaFormat) {
        String string = mediaFormat.getString(MediaFormat.KEY_MIME);
        MediaCodecInfo[] mediaCodecInfoArr = this.mCodecInfos;
        int length = mediaCodecInfoArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return null;
            }
            MediaCodecInfo mediaCodecInfo = mediaCodecInfoArr[i2];
            if (mediaCodecInfo.isEncoder() == z) {
                try {
                    MediaCodecInfo.CodecCapabilities capabilitiesForType = mediaCodecInfo.getCapabilitiesForType(string);
                    if (capabilitiesForType != null && capabilitiesForType.isFormatSupported(mediaFormat)) {
                        return mediaCodecInfo.getName();
                    }
                } catch (IllegalArgumentException e) {
                }
            }
            i = i2 + 1;
        }
    }

    static final native MediaCodecInfo.CodecCapabilities getCodecCapabilities(int i, String str);

    public static final int getCodecCount() {
        initCodecList();
        return sRegularCodecInfos.length;
    }

    public static final MediaCodecInfo getCodecInfoAt(int i) {
        initCodecList();
        if (i < 0 || i > sRegularCodecInfos.length) {
            throw new IllegalArgumentException();
        }
        return sRegularCodecInfos[i];
    }

    static final native String getCodecName(int i);

    public static MediaCodecInfo getInfoFor(String str) {
        initCodecList();
        return sAllCodecInfos[findCodecByName(str)];
    }

    private static MediaCodecInfo getNewCodecInfoAt(int i) {
        String[] supportedTypes = getSupportedTypes(i);
        MediaCodecInfo.CodecCapabilities[] codecCapabilitiesArr = new MediaCodecInfo.CodecCapabilities[supportedTypes.length];
        int length = supportedTypes.length;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i2 >= length) {
                return new MediaCodecInfo(getCodecName(i), isEncoder(i), codecCapabilitiesArr);
            }
            codecCapabilitiesArr[i4] = getCodecCapabilities(i, supportedTypes[i2]);
            i2++;
            i3 = i4 + 1;
        }
    }

    static final native String[] getSupportedTypes(int i);

    private static final void initCodecList() {
        synchronized (sInitLock) {
            if (sRegularCodecInfos == null) {
                int native_getCodecCount = native_getCodecCount();
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= native_getCodecCount) {
                        break;
                    }
                    try {
                        MediaCodecInfo newCodecInfoAt = getNewCodecInfoAt(i2);
                        arrayList2.add(newCodecInfoAt);
                        MediaCodecInfo makeRegular = newCodecInfoAt.makeRegular();
                        if (makeRegular != null) {
                            arrayList.add(makeRegular);
                        }
                    } catch (Exception e) {
                        Log.e(TAG, "Could not get codec capabilities", e);
                    }
                    i = i2 + 1;
                }
                sRegularCodecInfos = (MediaCodecInfo[]) arrayList.toArray(new MediaCodecInfo[arrayList.size()]);
                sAllCodecInfos = (MediaCodecInfo[]) arrayList2.toArray(new MediaCodecInfo[arrayList2.size()]);
            }
        }
    }

    static final native boolean isEncoder(int i);

    private static final native int native_getCodecCount();

    private static final native void native_init();

    public final String findDecoderForFormat(MediaFormat mediaFormat) {
        return findCodecForFormat(false, mediaFormat);
    }

    public final String findEncoderForFormat(MediaFormat mediaFormat) {
        return findCodecForFormat(true, mediaFormat);
    }

    public final MediaCodecInfo[] getCodecInfos() {
        return (MediaCodecInfo[]) Arrays.copyOf(this.mCodecInfos, this.mCodecInfos.length);
    }
}
