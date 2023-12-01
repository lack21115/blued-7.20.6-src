package com.tencent.open.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.view.MotionEvent;
import com.tencent.connect.common.Constants;
import com.tencent.open.a.f;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.security.MessageDigest;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/open/utils/SystemUtils.class */
public class SystemUtils {
    public static final String ACTION_LOGIN = "action_login";
    public static final String ACTION_REQUEST_API = "action_request";
    public static final String ACTION_SHARE = "action_share";
    public static final String H5_SHARE_DATA = "h5_share_data";
    public static final String IS_LOGIN = "is_login";
    public static final String IS_QQ_MOBILE_SHARE = "is_qq_mobile_share";
    public static final String QQDATALINE_CALLBACK_ACTION = "sendToMyComputer";
    public static final String QQFAVORITES_CALLBACK_ACTION = "addToQQFavorites";
    public static final String QQ_SHARE_CALLBACK_ACTION = "shareToQQ";
    public static final String QQ_VERSION_NAME_4_2_0 = "4.2.0";
    public static final String QQ_VERSION_NAME_4_3_0 = "4.3.0";
    public static final String QQ_VERSION_NAME_4_5_0 = "4.5.0";
    public static final String QQ_VERSION_NAME_4_6_0 = "4.6.0";
    public static final String QQ_VERSION_NAME_5_0_0 = "5.0.0";
    public static final String QQ_VERSION_NAME_5_1_0 = "5.1.0";
    public static final String QQ_VERSION_NAME_5_2_0 = "5.2.0";
    public static final String QQ_VERSION_NAME_5_3_0 = "5.3.0";
    public static final String QQ_VERSION_NAME_5_9_5 = "5.9.5";
    public static final String QZONE_SHARE_CALLBACK_ACTION = "shareToQzone";
    public static final String TROOPBAR_CALLBACK_ACTION = "shareToTroopBar";

    private static long a(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[8192];
        long j = 0;
        while (true) {
            long j2 = j;
            int read = inputStream.read(bArr, 0, 8192);
            if (read == -1) {
                f.c("openSDK_LOG.SystemUtils", "-->copy, copyed size is: " + j2);
                return j2;
            }
            outputStream.write(bArr, 0, read);
            j = j2 + read;
        }
    }

    public static boolean checkMobileQQ(Context context) {
        PackageInfo packageInfo;
        try {
            packageInfo = context.getPackageManager().getPackageInfo("com.tencent.mobileqq", 0);
        } catch (PackageManager.NameNotFoundException e) {
            f.b("openSDK_LOG.SystemUtils", "checkMobileQQ NameNotFoundException", e);
            e.printStackTrace();
            packageInfo = null;
        }
        if (packageInfo != null) {
            String str = packageInfo.versionName;
            try {
                f.b("MobileQQ verson", str);
                String[] split = str.split("\\.");
                int parseInt = Integer.parseInt(split[0]);
                int parseInt2 = Integer.parseInt(split[1]);
                if (parseInt <= 4) {
                    return parseInt == 4 && parseInt2 >= 1;
                }
                return true;
            } catch (Exception e2) {
                f.b("openSDK_LOG.SystemUtils", "checkMobileQQ Exception", e2);
                e2.printStackTrace();
                return false;
            }
        }
        return false;
    }

    public static int compareQQVersion(Context context, String str) {
        return compareVersion(getAppVersionName(context, "com.tencent.mobileqq"), str);
    }

    public static int compareVersion(String str, String str2) {
        int i;
        if (str == null && str2 == null) {
            return 0;
        }
        if (str == null || str2 != null) {
            if (str != null || str2 == null) {
                String[] split = str.split("\\.");
                String[] split2 = str2.split("\\.");
                int i2 = 0;
                while (true) {
                    try {
                        i = i2;
                        if (i >= split.length || i >= split2.length) {
                            break;
                        }
                        int parseInt = Integer.parseInt(split[i]);
                        int parseInt2 = Integer.parseInt(split2[i]);
                        if (parseInt < parseInt2) {
                            return -1;
                        }
                        if (parseInt > parseInt2) {
                            return 1;
                        }
                        i2 = i + 1;
                    } catch (NumberFormatException e) {
                        return str.compareTo(str2);
                    }
                }
                if (split.length > i) {
                    return 1;
                }
                return split2.length > i ? -1 : 0;
            }
            return -1;
        }
        return 1;
    }

    /* JADX WARN: Removed duplicated region for block: B:81:0x0187 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0192 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean extractSecureLib(java.lang.String r5, java.lang.String r6, int r7) {
        /*
            Method dump skipped, instructions count: 431
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.open.utils.SystemUtils.extractSecureLib(java.lang.String, java.lang.String, int):boolean");
    }

    public static String getActionFromRequestcode(int i) {
        if (i == 10103) {
            return QQ_SHARE_CALLBACK_ACTION;
        }
        if (i == 10104) {
            return QZONE_SHARE_CALLBACK_ACTION;
        }
        if (i == 10105) {
            return QQFAVORITES_CALLBACK_ACTION;
        }
        if (i == 10106) {
            return QQDATALINE_CALLBACK_ACTION;
        }
        if (i == 10107) {
            return TROOPBAR_CALLBACK_ACTION;
        }
        if (i == 11101) {
            return ACTION_LOGIN;
        }
        if (i == 10100) {
            return ACTION_REQUEST_API;
        }
        return null;
    }

    public static int getAndroidSDKVersion() {
        try {
            return Integer.valueOf(Build.VERSION.SDK).intValue();
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    public static String getAppName(Context context) {
        return context.getApplicationInfo().loadLabel(context.getPackageManager()).toString();
    }

    public static String getAppSignatureMD5(Context context, String str) {
        f.a("openSDK_LOG.SystemUtils", "OpenUi, getSignValidString");
        String str2 = "";
        try {
            String packageName = context.getPackageName();
            Signature[] signatureArr = context.getPackageManager().getPackageInfo(packageName, 64).signatures;
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(signatureArr[0].toByteArray());
            String hexString = Util.toHexString(messageDigest.digest());
            messageDigest.reset();
            StringBuilder sb = new StringBuilder();
            sb.append("-->sign: ");
            sb.append(hexString);
            f.a("openSDK_LOG.SystemUtils", sb.toString());
            StringBuilder sb2 = new StringBuilder();
            sb2.append(packageName);
            sb2.append("_");
            sb2.append(hexString);
            sb2.append("_");
            sb2.append(str);
            sb2.append("");
            messageDigest.update(Util.getBytesUTF8(sb2.toString()));
            String hexString2 = Util.toHexString(messageDigest.digest());
            messageDigest.reset();
            StringBuilder sb3 = new StringBuilder();
            sb3.append("-->signEncryped: ");
            sb3.append(hexString2);
            str2 = hexString2;
            f.a("openSDK_LOG.SystemUtils", sb3.toString());
            return hexString2;
        } catch (Exception e) {
            e.printStackTrace();
            f.b("openSDK_LOG.SystemUtils", "OpenUi, getSignValidString error", e);
            return str2;
        }
    }

    public static String getAppVersionName(Context context, String str) {
        try {
            return context.getPackageManager().getPackageInfo(str, 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            return null;
        }
    }

    public static String getRealPathFromUri(Activity activity, Uri uri) {
        Cursor managedQuery = activity.managedQuery(uri, new String[]{"_data"}, null, null, null);
        if (managedQuery != null) {
            int columnIndexOrThrow = managedQuery.getColumnIndexOrThrow("_data");
            managedQuery.moveToFirst();
            return managedQuery.getString(columnIndexOrThrow);
        }
        return null;
    }

    public static int getRequestCodeFromCallback(String str) {
        if (QQ_SHARE_CALLBACK_ACTION.equals(str)) {
            return Constants.REQUEST_QQ_SHARE;
        }
        if (QZONE_SHARE_CALLBACK_ACTION.equals(str)) {
            return Constants.REQUEST_QZONE_SHARE;
        }
        if (QQFAVORITES_CALLBACK_ACTION.equals(str)) {
            return Constants.REQUEST_QQ_FAVORITES;
        }
        if (QQDATALINE_CALLBACK_ACTION.equals(str)) {
            return Constants.REQUEST_SEND_TO_MY_COMPUTER;
        }
        if (TROOPBAR_CALLBACK_ACTION.equals(str)) {
            return Constants.REQUEST_SHARE_TO_TROOP_BAR;
        }
        if (ACTION_LOGIN.equals(str)) {
            return Constants.REQUEST_LOGIN;
        }
        if (ACTION_REQUEST_API.equals(str)) {
            return Constants.REQUEST_API;
        }
        return -1;
    }

    public static boolean isActivityExist(Context context, Intent intent) {
        boolean z = false;
        if (context != null) {
            if (intent == null) {
                return false;
            }
            z = false;
            if (context.getPackageManager().queryIntentActivities(intent, 0).size() != 0) {
                z = true;
            }
        }
        return z;
    }

    public static boolean isAppSignatureValid(Context context, String str, String str2) {
        f.a("openSDK_LOG.SystemUtils", "OpenUi, validateAppSignatureForPackage");
        try {
            Signature[] signatureArr = context.getPackageManager().getPackageInfo(str, 64).signatures;
            int length = signatureArr.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    return false;
                }
                if (Util.encrypt(signatureArr[i2].toCharsString()).equals(str2)) {
                    return true;
                }
                i = i2 + 1;
            }
        } catch (PackageManager.NameNotFoundException e) {
            return false;
        }
    }

    public static boolean isLibExtracted(String str, int i) {
        Context context = Global.getContext();
        if (context == null) {
            f.c("openSDK_LOG.SystemUtils", "-->isSecureLibExtracted, global context is null. ");
            return false;
        }
        File file = new File(context.getFilesDir(), str);
        SharedPreferences sharedPreferences = context.getSharedPreferences("secure_lib", 0);
        if (file.exists()) {
            int i2 = sharedPreferences.getInt("version", 0);
            f.c("openSDK_LOG.SystemUtils", "-->extractSecureLib, libVersion: " + i + " | oldVersion: " + i2);
            if (i == i2) {
                return true;
            }
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putInt("version", i);
            edit.commit();
            return false;
        }
        return false;
    }

    public static boolean isSupportMultiTouch() {
        Method[] declaredMethods;
        boolean z = false;
        boolean z2 = false;
        for (Method method : MotionEvent.class.getDeclaredMethods()) {
            if (method.getName().equals("getPointerCount")) {
                z = true;
            }
            if (method.getName().equals("getPointerId")) {
                z2 = true;
            }
        }
        if (getAndroidSDKVersion() < 7) {
            return z && z2;
        }
        return true;
    }
}
