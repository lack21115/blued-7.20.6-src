package com.tencent.cloud.huiyansdkface.record.h264;

import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.util.Log;
import java.util.ArrayList;
import java.util.HashSet;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/record/h264/CodecManager.class */
public class CodecManager {
    public static final String TAG = "CodecManager";
    public static final int[] SUPPORTED_COLOR_FORMATS = {21, 39, 19, 20, MediaCodecInfo.CodecCapabilities.COLOR_TI_FormatYUV420PackedSemiPlanar};

    /* renamed from: a  reason: collision with root package name */
    private static a[] f22368a = null;

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/record/h264/CodecManager$a.class */
    static class a {

        /* renamed from: a  reason: collision with root package name */
        public String f22369a;
        public Integer[] b;

        public a(String str, Integer[] numArr) {
            this.f22369a = str;
            this.b = numArr;
        }
    }

    public static a[] findEncodersForMimeType(String str) {
        synchronized (CodecManager.class) {
            try {
                if (f22368a != null) {
                    return f22368a;
                }
                ArrayList arrayList = new ArrayList();
                int codecCount = MediaCodecList.getCodecCount();
                while (true) {
                    int i = codecCount - 1;
                    if (i < 0) {
                        break;
                    }
                    MediaCodecInfo codecInfoAt = MediaCodecList.getCodecInfoAt(i);
                    if (codecInfoAt.isEncoder()) {
                        String[] supportedTypes = codecInfoAt.getSupportedTypes();
                        int i2 = 0;
                        while (true) {
                            int i3 = i2;
                            if (i3 < supportedTypes.length) {
                                if (supportedTypes[i3].equalsIgnoreCase(str)) {
                                    try {
                                        MediaCodecInfo.CodecCapabilities capabilitiesForType = codecInfoAt.getCapabilitiesForType(str);
                                        HashSet hashSet = new HashSet();
                                        int i4 = 0;
                                        while (true) {
                                            int i5 = i4;
                                            if (i5 >= capabilitiesForType.colorFormats.length) {
                                                break;
                                            }
                                            int i6 = capabilitiesForType.colorFormats[i5];
                                            int i7 = 0;
                                            while (true) {
                                                int i8 = i7;
                                                if (i8 >= SUPPORTED_COLOR_FORMATS.length) {
                                                    break;
                                                } else if (i6 == SUPPORTED_COLOR_FORMATS[i8]) {
                                                    hashSet.add(Integer.valueOf(i6));
                                                    break;
                                                } else {
                                                    i7 = i8 + 1;
                                                }
                                            }
                                            i4 = i5 + 1;
                                        }
                                        arrayList.add(new a(codecInfoAt.getName(), (Integer[]) hashSet.toArray(new Integer[hashSet.size()])));
                                    } catch (Exception e) {
                                        Log.wtf(TAG, e);
                                    }
                                }
                                i2 = i3 + 1;
                            }
                        }
                    }
                    codecCount = i;
                }
                a[] aVarArr = (a[]) arrayList.toArray(new a[arrayList.size()]);
                f22368a = aVarArr;
                if (aVarArr.length == 0) {
                    f22368a = new a[]{new a(null, new Integer[]{0})};
                }
                return f22368a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
