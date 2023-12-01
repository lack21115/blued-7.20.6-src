package com.tencent.cloud.huiyansdkface.facelight.c;

import android.app.Activity;
import android.content.Context;
import android.content.res.AssetManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import com.meizu.cloud.pushsdk.notification.model.AdvanceSetting;
import com.tencent.cloud.huiyansdkface.facelight.api.WbCloudFaceContant;
import com.tencent.cloud.huiyansdkface.facelight.common.KycWaSDK;
import com.tencent.cloud.huiyansdkface.normal.tools.WLogger;
import com.tencent.cloud.huiyansdkface.normal.tools.secure.AESEncrypt;
import com.tencent.cloud.huiyansdkface.normal.tools.secure.GetEncryptKeyException;
import com.tencent.cloud.huiyansdkface.normal.tools.secure.RSAEncrypt;
import java.io.IOException;
import java.util.Random;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/facelight/c/f.class */
public class f {
    public static double a(String str, double d, String str2) {
        return a(str, d, str2, 0.0d);
    }

    public static double a(String str, double d, String str2, double d2) {
        if (TextUtils.isEmpty(str)) {
            WLogger.d("Utils", "cdn拉取的" + str2 + "为空！use DEFAULT!");
            return d;
        }
        try {
            double parseDouble = Double.parseDouble(str);
            WLogger.d("Utils", "cdn拉取的" + str2 + "=" + parseDouble);
            if (parseDouble < d2) {
                WLogger.w("Utils", "cdn拉取的" + str2 + "小于阈值" + d2 + ",use DEFAULT!");
                return d;
            }
            return parseDouble;
        } catch (Exception e) {
            e.printStackTrace();
            WLogger.w("Utils", "cdn拉取的" + str2 + "不合法！use DEFAULT!");
            return d;
        }
    }

    public static float a(String str, float f, String str2) {
        return a(str, f, str2, 0.0f);
    }

    public static float a(String str, float f, String str2, float f2) {
        if (TextUtils.isEmpty(str)) {
            WLogger.d("Utils", "cdn拉取的" + str2 + "为空！use DEFAULT!");
            return f;
        }
        try {
            float parseFloat = Float.parseFloat(str);
            WLogger.d("Utils", "cdn拉取的" + str2 + "=" + parseFloat);
            if (parseFloat < f2) {
                WLogger.w("Utils", "cdn拉取的" + str2 + "小于阈值" + f2 + ",use DEFAULT!");
                return f;
            }
            return parseFloat;
        } catch (Exception e) {
            e.printStackTrace();
            WLogger.w("Utils", "cdn拉取的" + str2 + "不合法！use DEFAULT!");
            return f;
        }
    }

    public static int a(Activity activity, int i, int i2) {
        if (activity != null) {
            int rotation = activity.getWindowManager().getDefaultDisplay().getRotation();
            int i3 = 0;
            if (rotation != 0) {
                i3 = rotation != 1 ? rotation != 2 ? rotation != 3 ? 0 : 270 : 180 : 90;
            }
            WLogger.d("Utils", "degrees: " + i3 + ", orientation: " + i2 + ", mCameraFacing: " + i);
            return (i == 1 ? i2 + i3 : i2 - i3) % 360;
        }
        return -1;
    }

    public static int a(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static int a(String str, int i, String str2) {
        return a(str, i, str2, 0);
    }

    public static int a(String str, int i, String str2, int i2) {
        if (TextUtils.isEmpty(str)) {
            WLogger.d("Utils", "cdn拉取的" + str2 + "为空！use DEFAULT!");
            return i;
        }
        try {
            int parseInt = Integer.parseInt(str);
            WLogger.d("Utils", "cdn拉取的" + str2 + "=" + parseInt);
            if (parseInt < i2) {
                WLogger.w("Utils", "cdn拉取的" + str2 + "小于阈值" + i2 + ",use DEFAULT!");
                return i;
            }
            return parseInt;
        } catch (Exception e) {
            e.printStackTrace();
            WLogger.w("Utils", "cdn拉取的" + str2 + "不合法！use DEFAULT!");
            return i;
        }
    }

    public static long a(String str, long j, String str2) {
        return a(str, j, str2, 0L);
    }

    public static long a(String str, long j, String str2, long j2) {
        if (TextUtils.isEmpty(str)) {
            WLogger.d("Utils", "cdn拉取的" + str2 + "为空！use DEFAULT!");
            return j;
        }
        try {
            long parseLong = Long.parseLong(str);
            WLogger.d("Utils", "cdn拉取的" + str2 + ":" + parseLong);
            if (parseLong < j2) {
                WLogger.w("Utils", "cdn拉取的" + str2 + "小于阈值" + j2 + ",use DEFAULT!");
                return j;
            }
            return parseLong;
        } catch (Exception e) {
            e.printStackTrace();
            WLogger.w("Utils", "cdn拉取的" + str2 + "不合法！use DEFAULT!");
            return j;
        }
    }

    public static String a(int i) {
        int parseInt = Integer.parseInt("4e00", 16);
        int parseInt2 = Integer.parseInt("9fa5", 16);
        String str = "";
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= i) {
                return str;
            }
            str = str + new String(new char[]{(char) (new Random().nextInt((parseInt2 - parseInt) + 1) + parseInt)});
            i2 = i3 + 1;
        }
    }

    public static String a(Context context) {
        NetworkInfo activeNetworkInfo;
        NetworkInfo.State state;
        if (context == null) {
            WLogger.e("Utils", "传入的context为空！");
            return "";
        }
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            if (connectivityManager == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null || !activeNetworkInfo.isAvailable()) {
                return "NONE";
            }
            NetworkInfo networkInfo = connectivityManager.getNetworkInfo(1);
            if (networkInfo == null || (state = networkInfo.getState()) == null || (state != NetworkInfo.State.CONNECTED && state != NetworkInfo.State.CONNECTING)) {
                NetworkInfo networkInfo2 = connectivityManager.getNetworkInfo(0);
                if (networkInfo2 != null) {
                    NetworkInfo.State state2 = networkInfo2.getState();
                    String subtypeName = networkInfo2.getSubtypeName();
                    if (state2 != null) {
                        if (state2 == NetworkInfo.State.CONNECTED || state2 == NetworkInfo.State.CONNECTING) {
                            switch (activeNetworkInfo.getSubtype()) {
                                case 1:
                                case 2:
                                case 4:
                                case 7:
                                case 11:
                                    return "2G";
                                case 3:
                                case 5:
                                case 6:
                                case 8:
                                case 9:
                                case 10:
                                case 12:
                                case 14:
                                case 15:
                                    return "3G";
                                case 13:
                                    return "4G";
                                default:
                                    return (subtypeName.equalsIgnoreCase("TD-SCDMA") || subtypeName.equalsIgnoreCase("WCDMA")) ? "3G" : subtypeName.equalsIgnoreCase("CDMA2000") ? "3G" : "MOBILE";
                            }
                        }
                        return "NONE";
                    }
                    return "NONE";
                }
                return "NONE";
            }
            return "WIFI";
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String a(Context context, AESEncrypt aESEncrypt, String str, byte[] bArr) {
        try {
            return Base64.encodeToString(aESEncrypt.encrypt(bArr, str.getBytes("utf8")), 0);
        } catch (Exception e) {
            e.printStackTrace();
            WLogger.w("Utils", "加密本地返回视频失败：" + e.toString());
            KycWaSDK kycWaSDK = KycWaSDK.getInstance();
            kycWaSDK.trackCustomKVEvent(context, "facepage_encrypt_error", "userVideo 加密本地返回视频失败：" + e.toString(), null);
            return null;
        }
    }

    public static String a(Context context, String str, String str2) {
        String str3;
        try {
            str3 = a(str.getBytes("utf8"), str2);
            try {
                WLogger.d("Utils", "enAESKey=" + str3);
                return str3;
            } catch (Exception e) {
                e = e;
                e.printStackTrace();
                WLogger.w("Utils", "加密本地视频AES失败：" + e.toString());
                KycWaSDK.getInstance().trackCustomKVEvent(context, "facepage_encrypt_error", "加密本地视频AES失败：" + e.toString(), null);
                return str3;
            }
        } catch (Exception e2) {
            e = e2;
            str3 = null;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static String a(String str) {
        boolean z;
        switch (str.hashCode()) {
            case -1179248177:
                if (str.equals(WbCloudFaceContant.LANGUAGE_EN)) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case -1179248063:
                if (str.equals(WbCloudFaceContant.LANGUAGE_ID)) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case -1179248035:
                if (str.equals(WbCloudFaceContant.LANGUAGE_JA)) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case -1179247990:
                if (str.equals(WbCloudFaceContant.LANGUAGE_KO)) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case -1179247718:
                if (str.equals(WbCloudFaceContant.LANGUAGE_TH)) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case 1869349942:
                if (str.equals(WbCloudFaceContant.LANGUAGE_ZH_CN)) {
                    z = false;
                    break;
                }
                z = true;
                break;
            case 1869350094:
                if (str.equals(WbCloudFaceContant.LANGUAGE_ZH_HK)) {
                    z = true;
                    break;
                }
                z = true;
                break;
            default:
                z = true;
                break;
        }
        String str2 = AdvanceSetting.CLEAR_NOTIFICATION;
        switch (z) {
            case false:
                break;
            case true:
                str2 = "hk";
                break;
            case true:
                return "en";
            case true:
                return "id";
            case true:
                return com.anythink.expressad.video.dynview.a.a.W;
            case true:
                return com.anythink.expressad.video.dynview.a.a.Y;
            case true:
                return "th";
            default:
                return AdvanceSetting.CLEAR_NOTIFICATION;
        }
        return str2;
    }

    public static String a(Throwable th) {
        return Log.getStackTraceString(th);
    }

    private static String a(byte[] bArr, String str) throws GetEncryptKeyException {
        try {
            RSAEncrypt rSAEncrypt = new RSAEncrypt();
            rSAEncrypt.loadPublicKey(str);
            return Base64.encodeToString(rSAEncrypt.encrypt(bArr), 2);
        } catch (Exception e) {
            e.printStackTrace();
            throw new GetEncryptKeyException();
        }
    }

    public static boolean a(AssetManager assetManager, String str, String str2) {
        StringBuilder sb;
        try {
            String[] list = assetManager.list(str);
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= list.length) {
                    sb = new StringBuilder();
                    break;
                } else if (list[i2].equals(str2.trim())) {
                    WLogger.i("Utils", str2 + "存在");
                    return true;
                } else {
                    i = i2 + 1;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            sb = new StringBuilder();
        }
        sb.append(str2);
        sb.append("不存在");
        WLogger.w("Utils", sb.toString());
        return false;
    }

    public static float b(String str, float f, String str2) {
        if (TextUtils.isEmpty(str)) {
            WLogger.d("Utils", "cdn拉取的" + str2 + "为空！use DEFAULT!");
            return f;
        }
        try {
            float parseFloat = Float.parseFloat(str);
            WLogger.d("Utils", "cdn拉取的" + str2 + "=" + parseFloat);
            return parseFloat;
        } catch (Exception e) {
            e.printStackTrace();
            WLogger.w("Utils", "cdn拉取的" + str2 + "不合法！use DEFAULT!");
            return f;
        }
    }
}
