package com.sobot.chat.utils;

import android.app.ActivityManager;
import android.app.KeyguardManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.media.ExifInterface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Environment;
import android.os.Looper;
import android.text.TextUtils;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.anythink.expressad.foundation.h.i;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/utils/CommonUtils.class */
public class CommonUtils {
    private static final String CACHE_DIR = "cache";
    private static final String ROOT_DIR = "sobot";

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static String GetNetworkType(Context context) {
        String str;
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE)).getActiveNetworkInfo();
        if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
            if (activeNetworkInfo.getType() == 1) {
                return "WIFI";
            }
            if (activeNetworkInfo.getType() == 0) {
                String subtypeName = activeNetworkInfo.getSubtypeName();
                str = "3G";
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
                        break;
                    case 13:
                        return "4G";
                    default:
                        str = "3G";
                        if (!subtypeName.equalsIgnoreCase("TD-SCDMA")) {
                            str = "3G";
                            if (!subtypeName.equalsIgnoreCase("WCDMA")) {
                                return subtypeName.equalsIgnoreCase("CDMA2000") ? "3G" : subtypeName;
                            }
                        }
                        break;
                }
                return str;
            }
        }
        str = "无网络";
        return str;
    }

    public static String encode(String str) {
        String str2 = str;
        if (str != null) {
            Matcher matcher = Pattern.compile("[\\u4e00-\\u9fa5]").matcher(str);
            while (true) {
                str2 = str;
                if (!matcher.find()) {
                    break;
                }
                String group = matcher.group();
                try {
                    str = str.replaceAll(group, URLEncoder.encode(group, "UTF-8"));
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
        }
        return str2;
    }

    public static String encodeStr(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                return URLEncoder.encode(str, "UTF-8");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return str;
    }

    public static String formetFileSize(long j) {
        DecimalFormat decimalFormat = new DecimalFormat("#.00");
        if (j < 1024) {
            return decimalFormat.format(j) + "B";
        } else if (j < 1048576) {
            return decimalFormat.format(j / 1024.0d) + "K";
        } else if (j < 1073741824) {
            return decimalFormat.format(j / 1048576.0d) + "M";
        } else {
            return decimalFormat.format(j / 1.073741824E9d) + "G";
        }
    }

    public static String getAppName(Context context) {
        Class cls;
        synchronized (CommonUtils.class) {
            try {
                String string = context.getResources().getString(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).applicationInfo.labelRes);
                if (TextUtils.isEmpty(string)) {
                    ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(getPackageName(context), 128);
                    return ((Object) applicationInfo.loadLabel(context.getPackageManager())) + "";
                }
                return string;
            } catch (Exception e) {
                e.printStackTrace();
                return "";
            } catch (Exception e2) {
                e2.printStackTrace();
                ApplicationInfo applicationInfo2 = context.getPackageManager().getApplicationInfo(getPackageName(context), 128);
                String str = ((Object) applicationInfo2.loadLabel(context.getPackageManager())) + "";
                return str;
            } finally {
            }
        }
    }

    public static String getApplicationName(Context context) {
        PackageManager packageManager;
        ApplicationInfo applicationInfo;
        try {
            packageManager = context.getPackageManager();
            try {
                applicationInfo = packageManager.getApplicationInfo(context.getPackageName(), 0);
            } catch (PackageManager.NameNotFoundException e) {
                applicationInfo = null;
            }
        } catch (PackageManager.NameNotFoundException e2) {
            packageManager = null;
            applicationInfo = null;
        }
        return applicationInfo != null ? (String) packageManager.getApplicationLabel(applicationInfo) : "";
    }

    public static int getBitmapDegree(String str) {
        try {
            int attributeInt = new ExifInterface(str).getAttributeInt("Orientation", 1);
            if (attributeInt != 3) {
                if (attributeInt != 6) {
                    return attributeInt != 8 ? 0 : 270;
                }
                return 90;
            }
            return 180;
        } catch (IOException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static String getCurrentDateTime() {
        return new SimpleDateFormat("HH:mm").format(new Date());
    }

    public static String getDeviceId(Context context) {
        StringBuilder sb = new StringBuilder();
        String stringData = SharedPreferencesUtil.getStringData(context, "deviceId", "");
        if (!TextUtils.isEmpty(stringData)) {
            sb.append(stringData);
            LogUtils.i("deviceId:" + sb.toString());
            return sb.toString();
        }
        String str = UUID.randomUUID().toString() + System.currentTimeMillis();
        sb.append(str);
        SharedPreferencesUtil.saveStringData(context, "deviceId", str);
        LogUtils.i("deviceId:" + sb.toString());
        return sb.toString();
    }

    public static int getDimenId(Context context, String str) {
        return ResourceUtils.getIdByName(context, "dimen", str);
    }

    public static float getDimensPix(Context context, String str) {
        return context.getResources().getDimension(getDimenId(context, str));
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x0081 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static long getFileSize(java.lang.String r4) {
        /*
            java.io.File r0 = new java.io.File
            r1 = r0
            r2 = r4
            r1.<init>(r2)
            r4 = r0
            r0 = 0
            r6 = r0
            r0 = 0
            r8 = r0
            r0 = r4
            boolean r0 = r0.exists()     // Catch: java.lang.Throwable -> L54 java.lang.Exception -> L5b
            if (r0 == 0) goto L33
            java.io.FileInputStream r0 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L54 java.lang.Exception -> L5b
            r1 = r0
            r2 = r4
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L54 java.lang.Exception -> L5b
            r8 = r0
            r0 = r8
            r4 = r0
            r0 = r8
            int r0 = r0.available()     // Catch: java.lang.Exception -> L2e java.lang.Throwable -> L7b
            r5 = r0
            r0 = r5
            long r0 = (long) r0
            r6 = r0
            goto L41
        L2e:
            r9 = move-exception
            goto L60
        L33:
            r0 = r4
            boolean r0 = r0.createNewFile()     // Catch: java.lang.Throwable -> L54 java.lang.Exception -> L5b
            java.io.PrintStream r0 = java.lang.System.out     // Catch: java.lang.Throwable -> L54 java.lang.Exception -> L5b
            java.lang.String r1 = "文件不存在"
            r0.println(r1)     // Catch: java.lang.Throwable -> L54 java.lang.Exception -> L5b
        L41:
            r0 = r8
            if (r0 == 0) goto L52
            r0 = r8
            r0.close()     // Catch: java.io.IOException -> L4d
            r0 = r6
            return r0
        L4d:
            r4 = move-exception
            r0 = r4
            r0.printStackTrace()
        L52:
            r0 = r6
            return r0
        L54:
            r8 = move-exception
            r0 = 0
            r4 = r0
            goto L7d
        L5b:
            r9 = move-exception
            r0 = 0
            r8 = r0
        L60:
            r0 = r8
            r4 = r0
            r0 = r9
            r0.printStackTrace()     // Catch: java.lang.Throwable -> L7b
            r0 = r8
            if (r0 == 0) goto L79
            r0 = r8
            r0.close()     // Catch: java.io.IOException -> L74
            r0 = 0
            return r0
        L74:
            r4 = move-exception
            r0 = r4
            r0.printStackTrace()
        L79:
            r0 = 0
            return r0
        L7b:
            r8 = move-exception
        L7d:
            r0 = r4
            if (r0 == 0) goto L8d
            r0 = r4
            r0.close()     // Catch: java.io.IOException -> L88
            goto L8d
        L88:
            r4 = move-exception
            r0 = r4
            r0.printStackTrace()
        L8d:
            r0 = r8
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sobot.chat.utils.CommonUtils.getFileSize(java.lang.String):long");
    }

    public static String getPackageName(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).packageName;
        } catch (PackageManager.NameNotFoundException e) {
            return null;
        }
    }

    public static String getPartnerId(Context context) {
        return getDeviceId(context);
    }

    public static String getPlatformUserId(Context context) {
        String stringData = SharedPreferencesUtil.getStringData(context, ZhiChiConstant.SOBOT_PLATFORM_UNIONCODE, "");
        String stringData2 = SharedPreferencesUtil.getStringData(context, ZhiChiConstant.SOBOT_PLATFORM_UID, "");
        if (!TextUtils.isEmpty(stringData2)) {
            return stringData + stringData2;
        }
        StringBuilder sb = new StringBuilder();
        String stringData3 = SharedPreferencesUtil.getStringData(context, ZhiChiConstant.SOBOT_PLATFORM_USERID, "");
        if (!TextUtils.isEmpty(stringData3)) {
            sb.append(stringData3);
            return sb.toString();
        }
        String str = stringData + UUID.randomUUID().toString() + System.currentTimeMillis();
        sb.append(str);
        SharedPreferencesUtil.saveStringData(context, ZhiChiConstant.SOBOT_PLATFORM_USERID, str);
        return sb.toString();
    }

    public static String getPrivatePath(Context context) {
        return context.getFilesDir().getPath();
    }

    public static int getResDrawableId(Context context, String str) {
        return ResourceUtils.getIdByName(context, i.f7952c, str);
    }

    public static int getResId(Context context, String str) {
        return ResourceUtils.getIdByName(context, "id", str);
    }

    public static String getResString(Context context, int i) {
        return context.getResources().getString(i);
    }

    public static String getResString(Context context, String str) {
        return ResourceUtils.getResString(context, str);
    }

    public static int getResStringId(Context context, String str) {
        return ResourceUtils.getIdByName(context, "string", str);
    }

    public static String getRootDir(Context context) {
        String packageName = context != null ? context.getPackageName() : "";
        return Environment.getExternalStorageDirectory().getPath() + File.separator + ROOT_DIR + File.separator + encode(packageName + File.separator + CACHE_DIR);
    }

    public static String getSDCardRootPath(Context context) {
        String str;
        if (!isExitsSdcard()) {
            String str2 = context.getFilesDir().getPath() + File.separator + ROOT_DIR;
            LogUtils.i("外部存储不可用 存储路径：" + str2);
            return str2;
        }
        if (Build.VERSION.SDK_INT < 19) {
            str = getRootDir(context) + File.separator;
        } else {
            str = context.getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS).getPath() + File.separator + CACHE_DIR + File.separator;
        }
        LogUtils.i("SD卡已装入 存储路径：" + str);
        return str;
    }

    public static String getSobotCloudChatAppKey(Context context) {
        return getPackageName(context) + ".SobotCloudChatAppKey";
    }

    public static int getTargetSdkVersion(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).applicationInfo.targetSdkVersion;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static int getVersion(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            return 0;
        }
    }

    public static String getVersionName(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (Exception e) {
            return "";
        }
    }

    public static boolean inMainProcess(Context context) {
        boolean z = false;
        try {
            if (Looper.getMainLooper().getThread() == Thread.currentThread()) {
                z = true;
            }
            return z;
        } catch (Exception e) {
            return false;
        }
    }

    public static final boolean isClassExists(String str) {
        try {
            Class.forName(str);
            return true;
        } catch (ClassNotFoundException e) {
            return false;
        }
    }

    public static boolean isEmail(String str) {
        return Pattern.compile("^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$").matcher(str).matches();
    }

    public static boolean isExitsSdcard() {
        return Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED);
    }

    public static boolean isMobileNO(String str) {
        return Pattern.compile("^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$").matcher(str).matches();
    }

    public static boolean isNetWorkConnected(Context context) {
        NetworkInfo activeNetworkInfo;
        if (context == null || (activeNetworkInfo = ((ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE)).getActiveNetworkInfo()) == null) {
            return false;
        }
        return activeNetworkInfo.isAvailable();
    }

    public static boolean isScreenLock(Context context) {
        return ((KeyguardManager) context.getSystemService(Context.KEYGUARD_SERVICE)).inKeyguardRestrictedInputMode();
    }

    public static boolean isServiceWork(Context context, String str) {
        List<ActivityManager.RunningServiceInfo> runningServices = ((ActivityManager) context.getSystemService("activity")).getRunningServices(40);
        if (runningServices.size() <= 0) {
            return false;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= runningServices.size()) {
                return false;
            }
            if (runningServices.get(i2).service.getClassName().toString().equals(str)) {
                return true;
            }
            i = i2 + 1;
        }
    }

    public static Bitmap rotaingImageView(int i, Bitmap bitmap) {
        Matrix matrix = new Matrix();
        matrix.postRotate(i);
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
    }

    public static void sendBroadcast(Context context, Intent intent) {
        String packageName = context.getPackageName();
        if (!TextUtils.isEmpty(packageName)) {
            intent.setPackage(packageName);
        }
        context.sendBroadcast(intent);
    }

    public static void sendLocalBroadcast(Context context, Intent intent) {
        LocalBroadcastManager.getInstance(context).sendBroadcast(intent);
    }
}
