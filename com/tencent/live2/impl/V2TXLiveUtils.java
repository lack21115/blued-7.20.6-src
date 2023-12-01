package com.tencent.live2.impl;

import android.text.TextUtils;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.live2.V2TXLiveDef;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/live2/impl/V2TXLiveUtils.class */
public class V2TXLiveUtils {
    private static final String TAG = "V2TXLiveUtils";
    public static final String TRTC_ADDRESS1 = "room://cloud.tencent.com/rtc";
    public static final String TRTC_ADDRESS2 = "room://rtc.tencent.com";

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.tencent.live2.impl.V2TXLiveUtils$1  reason: invalid class name */
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/live2/impl/V2TXLiveUtils$1.class */
    public static final /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f37188a;

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x0095 -> B:61:0x0014). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x0099 -> B:55:0x001f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x009d -> B:73:0x002a). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:33:0x00a1 -> B:65:0x0035). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:35:0x00a5 -> B:59:0x0040). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:37:0x00a9 -> B:53:0x004c). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:39:0x00ad -> B:71:0x0058). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:41:0x00b1 -> B:63:0x0064). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:43:0x00b5 -> B:57:0x0070). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:45:0x00b9 -> B:51:0x007c). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:47:0x00bd -> B:69:0x0088). Please submit an issue!!! */
        static {
            int[] iArr = new int[V2TXLiveDef.V2TXLiveVideoResolution.values().length];
            f37188a = iArr;
            try {
                iArr[V2TXLiveDef.V2TXLiveVideoResolution.V2TXLiveVideoResolution160x160.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f37188a[V2TXLiveDef.V2TXLiveVideoResolution.V2TXLiveVideoResolution270x270.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f37188a[V2TXLiveDef.V2TXLiveVideoResolution.V2TXLiveVideoResolution480x480.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f37188a[V2TXLiveDef.V2TXLiveVideoResolution.V2TXLiveVideoResolution320x240.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f37188a[V2TXLiveDef.V2TXLiveVideoResolution.V2TXLiveVideoResolution480x360.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f37188a[V2TXLiveDef.V2TXLiveVideoResolution.V2TXLiveVideoResolution640x480.ordinal()] = 6;
            } catch (NoSuchFieldError e6) {
            }
            try {
                f37188a[V2TXLiveDef.V2TXLiveVideoResolution.V2TXLiveVideoResolution320x180.ordinal()] = 7;
            } catch (NoSuchFieldError e7) {
            }
            try {
                f37188a[V2TXLiveDef.V2TXLiveVideoResolution.V2TXLiveVideoResolution480x270.ordinal()] = 8;
            } catch (NoSuchFieldError e8) {
            }
            try {
                f37188a[V2TXLiveDef.V2TXLiveVideoResolution.V2TXLiveVideoResolution640x360.ordinal()] = 9;
            } catch (NoSuchFieldError e9) {
            }
            try {
                f37188a[V2TXLiveDef.V2TXLiveVideoResolution.V2TXLiveVideoResolution960x540.ordinal()] = 10;
            } catch (NoSuchFieldError e10) {
            }
            try {
                f37188a[V2TXLiveDef.V2TXLiveVideoResolution.V2TXLiveVideoResolution1280x720.ordinal()] = 11;
            } catch (NoSuchFieldError e11) {
            }
            try {
                f37188a[V2TXLiveDef.V2TXLiveVideoResolution.V2TXLiveVideoResolution1920x1080.ordinal()] = 12;
            } catch (NoSuchFieldError e12) {
            }
        }
    }

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/live2/impl/V2TXLiveUtils$a.class */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public int f37189a;
        public int b;

        public a(int i, int i2) {
            this.f37189a = i;
            this.b = i2;
        }
    }

    public static a getBitrateByResolution(V2TXLiveDef.V2TXLiveVideoResolution v2TXLiveVideoResolution) {
        int i = 600;
        int i2 = 900;
        switch (AnonymousClass1.f37188a[v2TXLiveVideoResolution.ordinal()]) {
            case 1:
                i = 100;
                i2 = 150;
                break;
            case 2:
                i = 200;
                i2 = 300;
                break;
            case 3:
                i2 = 525;
                i = 350;
                break;
            case 4:
                i2 = 375;
                i = 250;
                break;
            case 5:
                i2 = 600;
                i = 400;
                break;
            case 6:
                break;
            case 7:
                i2 = 400;
                i = 250;
                break;
            case 8:
                i2 = 550;
                i = 350;
                break;
            case 9:
                i = 500;
                i2 = 900;
                break;
            case 10:
            default:
                i2 = 1500;
                i = 800;
                break;
            case 11:
                i = 1000;
                i2 = 1800;
                break;
            case 12:
                i = 2500;
                i2 = 3000;
                break;
        }
        return new a(i, i2);
    }

    public static V2TXLiveDef.V2TXLiveMode parseLiveMode(String str) {
        if (str.startsWith("trtc://") || str.startsWith(TRTC_ADDRESS1) || str.startsWith(TRTC_ADDRESS2)) {
            TXCLog.i(TAG, "parseLiveMode: rtc.");
            return V2TXLiveDef.V2TXLiveMode.TXLiveMode_RTC;
        }
        TXCLog.i(TAG, "parseLiveMode: rtmp.");
        return V2TXLiveDef.V2TXLiveMode.TXLiveMode_RTMP;
    }

    public static String removeURLSensitiveInfo(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        String str2 = str;
        try {
            String[] strArr = new String[3];
            strArr[0] = "roomsig";
            strArr[1] = "privatemapkey";
            strArr[2] = "usersig";
            int i = 0;
            while (true) {
                str2 = str;
                if (i >= 3) {
                    break;
                }
                String str3 = str;
                str2 = str;
                if (str.contains(strArr[i])) {
                    String str4 = str;
                    int indexOf = str.indexOf(strArr[i]);
                    str3 = str;
                    if (indexOf != -1) {
                        int indexOf2 = str.indexOf("&", indexOf);
                        if (indexOf2 == -1) {
                            str3 = str.substring(0, indexOf);
                        } else {
                            StringBuilder sb = new StringBuilder();
                            String str5 = str;
                            sb.append(str.substring(0, indexOf));
                            String str6 = str;
                            sb.append(str.substring(indexOf2));
                            String str7 = str;
                            str3 = sb.toString();
                        }
                    }
                }
                i++;
                str = str3;
            }
        } catch (Exception e) {
            TXCLog.e(TAG, "remove url sensitive info failed.", e);
        }
        return str2;
    }
}
