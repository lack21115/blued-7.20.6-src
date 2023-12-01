package com.oplus.log.d;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import android.view.View;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import java.io.File;
import java.lang.reflect.Method;

/* loaded from: source-8303388-dex2jar.jar:com/oplus/log/d/c.class */
public final class c {
    public static long a(File file) {
        if (file == null) {
            return -1L;
        }
        return file.getUsableSpace();
    }

    public static Bitmap a(Activity activity) {
        Bitmap bitmap;
        View rootView = activity.getWindow().getDecorView().getRootView();
        try {
            Method declaredMethod = View.class.getDeclaredMethod("createSnapshot", Bitmap.Config.class, Integer.TYPE, Boolean.TYPE);
            declaredMethod.setAccessible(true);
            bitmap = (Bitmap) declaredMethod.invoke(rootView, Bitmap.Config.RGB_565, -1, Boolean.FALSE);
        } catch (Throwable th) {
            if (com.oplus.log.b.a()) {
                th.printStackTrace();
            }
            bitmap = null;
        }
        if (bitmap != null) {
            return bitmap;
        }
        Bitmap bitmap2 = bitmap;
        try {
            rootView.setDrawingCacheEnabled(true);
            Bitmap bitmap3 = bitmap;
            rootView.buildDrawingCache(true);
            Bitmap bitmap4 = bitmap;
            Bitmap createBitmap = Bitmap.createBitmap(rootView.getDrawingCache());
            bitmap2 = createBitmap;
            rootView.setDrawingCacheEnabled(false);
            return createBitmap;
        } catch (Throwable th2) {
            if (com.oplus.log.b.a()) {
                th2.printStackTrace();
            }
            return bitmap2;
        }
    }

    public static String a() {
        return a(b.a());
    }

    private static String a(Context context) {
        NetworkInfo activeNetworkInfo;
        String str;
        StringBuilder sb = new StringBuilder();
        try {
            activeNetworkInfo = ((ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE)).getActiveNetworkInfo();
        } catch (Throwable th) {
            if (com.oplus.log.b.a()) {
                th.printStackTrace();
            }
        }
        if (activeNetworkInfo != null && activeNetworkInfo.isAvailable() && activeNetworkInfo.isConnected()) {
            if (activeNetworkInfo.getType() == 1) {
                sb.append("wifi");
                return sb.toString();
            }
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            sb.append(telephonyManager.getNetworkOperatorName());
            sb.append(BridgeUtil.UNDERLINE_STR);
            int networkType = telephonyManager.getNetworkType();
            switch (networkType) {
                case 1:
                case 2:
                case 4:
                case 7:
                case 11:
                    str = "2G";
                    sb.append(str);
                    break;
                case 3:
                case 5:
                case 6:
                case 8:
                case 9:
                case 10:
                case 12:
                case 14:
                case 15:
                    str = "3G";
                    sb.append(str);
                    break;
                case 13:
                    str = "4G";
                    sb.append(str);
                    break;
                default:
                    sb.append("unknown:");
                    sb.append(networkType);
                    break;
            }
            return sb.toString();
        }
        sb.append("disconnected");
        return sb.toString();
    }

    public static boolean b() {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) b.a().getSystemService(Context.CONNECTIVITY_SERVICE);
            if (connectivityManager != null) {
                return NetworkInfo.State.CONNECTED == connectivityManager.getNetworkInfo(1).getState();
            }
            return false;
        } catch (Throwable th) {
            if (com.oplus.log.b.a()) {
                th.printStackTrace();
                return false;
            }
            return false;
        }
    }
}
