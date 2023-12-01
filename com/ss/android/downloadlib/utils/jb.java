package com.ss.android.downloadlib.utils;

import android.Manifest;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.Signature;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Environment;
import android.os.Looper;
import android.os.StatFs;
import android.text.TextUtils;
import com.ss.android.download.api.config.lc;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.logger.Logger;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8457232-dex2jar.jar:com/ss/android/downloadlib/utils/jb.class */
public class jb {
    private static Object[] ox = new Object[0];
    private static Object[] b = new Object[73];
    static final char[] mb = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    private static String hj = null;

    public static Drawable b(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            return packageManager.getApplicationInfo(str, 0).loadIcon(packageManager);
        } catch (PackageManager.NameNotFoundException e) {
            return null;
        }
    }

    public static boolean b(String str) {
        File file;
        Context context = com.ss.android.downloadlib.addownload.x.getContext();
        if (!TextUtils.isEmpty(str) && hj(context, str)) {
            int i = context.getApplicationInfo().targetSdkVersion;
            if (com.ss.android.downloadlib.addownload.x.lz().optInt("get_ext_dir_mode") != 0 || Build.VERSION.SDK_INT < 29 || ((i != 29 || Environment.isExternalStorageLegacy()) && i <= 29)) {
                try {
                    if (Build.VERSION.SDK_INT < 29 || context.getApplicationInfo().targetSdkVersion < 29 || com.ss.android.downloadlib.addownload.x.lz().optInt("get_ext_dir_mode") != 1) {
                        String path = Environment.getExternalStorageDirectory().getPath();
                        file = new File(path, "android/data/" + str);
                    } else {
                        file = lz(context, str);
                    }
                    if (file.exists()) {
                        long mb2 = u.mb(file);
                        PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 0);
                        if (packageInfo != null) {
                            return packageInfo.lastUpdateTime < mb2;
                        }
                        return false;
                    }
                    return false;
                } catch (Exception e) {
                    e.printStackTrace();
                    return true;
                }
            }
            return true;
        }
        return false;
    }

    public static boolean h(Context context, String str) {
        PackageInfo packageArchiveInfo;
        PackageInfo packageInfo;
        if (context == null || str == null || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            File file = new File(str);
            if (!file.exists() || (packageArchiveInfo = context.getPackageManager().getPackageArchiveInfo(file.getAbsolutePath(), 0)) == null) {
                return false;
            }
            String str2 = packageArchiveInfo.packageName;
            int i = packageArchiveInfo.versionCode;
            try {
                packageInfo = context.getPackageManager().getPackageInfo(str2, 0);
            } catch (PackageManager.NameNotFoundException e) {
                packageInfo = null;
            }
            if (packageInfo == null) {
                return false;
            }
            return i <= packageInfo.versionCode;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public static boolean hj(Context context, String str) {
        Context context2 = context;
        if (context == null) {
            context2 = com.ss.android.downloadlib.addownload.x.getContext();
        }
        boolean z = false;
        if (context2 != null) {
            z = false;
            if (!TextUtils.isEmpty(str)) {
                try {
                    z = false;
                    if (context2.getPackageManager().getPackageInfo(str, 0) != null) {
                        z = true;
                    }
                } catch (Exception e) {
                    return false;
                }
            }
        }
        return z;
    }

    public static Signature[] ko(Context context, String str) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 64);
            if (packageInfo != null) {
                return packageInfo.signatures;
            }
            return null;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public static File lz(Context context, String str) {
        File parentFile = context.getExternalFilesDir(null).getParentFile();
        String str2 = null;
        if (parentFile != null) {
            str2 = parentFile.getParent();
        }
        File file = new File(str2 + File.separator + str);
        StringBuilder sb = new StringBuilder();
        sb.append("getExtDir: file.toString()-->");
        sb.append(file.toString());
        Logger.d("ToolUtils", sb.toString());
        return file;
    }

    public static int mb(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0075, code lost:
        if (r7 >= r0.length) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0080, code lost:
        if (java.lang.Integer.parseInt(r0[r7]) <= 0) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0083, code lost:
        return -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0085, code lost:
        r7 = r7 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x008c, code lost:
        return 0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int mb(java.lang.String r4, java.lang.String r5) {
        /*
            Method dump skipped, instructions count: 182
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.downloadlib.utils.jb.mb(java.lang.String, java.lang.String):int");
    }

    public static long mb(long j) {
        try {
            return mb(Environment.getExternalStorageDirectory(), j);
        } catch (Exception e) {
            e.printStackTrace();
            return j;
        }
    }

    public static long mb(File file) {
        if (file == null) {
            return -1L;
        }
        try {
            StatFs statFs = new StatFs(file.getAbsolutePath());
            if (Build.VERSION.SDK_INT >= 18) {
                return statFs.getTotalBytes();
            }
            return -1L;
        } catch (Throwable th) {
            th.printStackTrace();
            return -1L;
        }
    }

    public static long mb(File file, long j) {
        if (file == null) {
            return j;
        }
        try {
            return DownloadUtils.getAvailableSpaceBytes(file.getAbsolutePath());
        } catch (Exception e) {
            e.printStackTrace();
            return j;
        }
    }

    public static long mb(JSONObject jSONObject, String str) {
        return com.ss.android.download.api.b.ox.mb(jSONObject, str);
    }

    public static PackageInfo mb(com.ss.android.downloadad.api.mb.ox oxVar) {
        DownloadInfo downloadInfo;
        if (oxVar == null || (downloadInfo = Downloader.getInstance(com.ss.android.downloadlib.addownload.x.getContext()).getDownloadInfo(oxVar.m())) == null) {
            return null;
        }
        try {
            return com.ss.android.socialbase.appdownloader.b.mb(com.ss.android.downloadlib.addownload.x.getContext(), downloadInfo, downloadInfo.getSavePath(), downloadInfo.getName());
        } catch (Throwable th) {
            return null;
        }
    }

    public static Drawable mb(Context context, String str) {
        PackageManager packageManager;
        PackageInfo packageArchiveInfo;
        if (context == null || TextUtils.isEmpty(str) || (packageArchiveInfo = (packageManager = context.getPackageManager()).getPackageArchiveInfo(str, 0)) == null) {
            return null;
        }
        ApplicationInfo applicationInfo = packageArchiveInfo.applicationInfo;
        applicationInfo.sourceDir = str;
        applicationInfo.publicSourceDir = str;
        try {
            return applicationInfo.loadIcon(packageManager);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static com.ss.android.downloadlib.addownload.model.b mb(String str, int i, String str2) {
        com.ss.android.downloadlib.addownload.model.b bVar = new com.ss.android.downloadlib.addownload.model.b();
        if (TextUtils.isEmpty(str)) {
            return bVar;
        }
        try {
            PackageInfo packageInfo = com.ss.android.downloadlib.addownload.x.getContext().getPackageManager().getPackageInfo(str, 0);
            if (packageInfo != null) {
                bVar.ox(packageInfo.versionCode);
                bVar.mb(com.ss.android.downloadlib.addownload.model.b.ox);
                lc ko = com.ss.android.downloadlib.addownload.x.ko();
                if (ko != null && ko.mb() && !mb(packageInfo.versionCode, i, packageInfo.versionName, str2)) {
                    bVar.mb(com.ss.android.downloadlib.addownload.model.b.b);
                    return bVar;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bVar;
    }

    public static <T> T mb(T... tArr) {
        if (tArr == null) {
            throw new IllegalArgumentException("args is null");
        }
        int length = tArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                throw new IllegalArgumentException("args is null");
            }
            T t = tArr[i2];
            if (t != null) {
                return t;
            }
            i = i2 + 1;
        }
    }

    public static String mb(String str, int i) {
        if (i == 0) {
            return "";
        }
        String str2 = str;
        if (!TextUtils.isEmpty(str)) {
            if (str.length() <= i) {
                return str;
            }
            str2 = str.substring(0, i);
        }
        return str2;
    }

    public static String mb(String... strArr) {
        return com.ss.android.download.api.b.ox.mb(strArr);
    }

    public static JSONObject mb(JSONObject jSONObject) {
        return com.ss.android.download.api.b.ox.mb(jSONObject);
    }

    public static JSONObject mb(JSONObject jSONObject, JSONObject jSONObject2) {
        return com.ss.android.download.api.b.ox.mb(jSONObject, jSONObject2);
    }

    public static JSONObject mb(JSONObject... jSONObjectArr) {
        return com.ss.android.download.api.b.ox.mb(jSONObjectArr);
    }

    public static void mb(JSONObject jSONObject, String str, Object obj) {
        if (jSONObject == null || TextUtils.isEmpty(str)) {
            return;
        }
        try {
            jSONObject.putOpt(str, obj);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public static boolean mb() {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    private static boolean mb(int i, int i2, String str, String str2) {
        if (i2 == 0 && TextUtils.isEmpty(str2)) {
            return true;
        }
        return (i2 > 0 && i >= i2) || mb(str, str2) >= 0;
    }

    public static boolean mb(Context context, Intent intent) {
        try {
            List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(intent, 65536);
            boolean z = false;
            if (queryIntentActivities != null) {
                z = false;
                if (!queryIntentActivities.isEmpty()) {
                    z = true;
                }
            }
            return z;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean mb(Context context, String str, String str2) {
        PackageInfo packageArchiveInfo;
        PackageInfo packageInfo;
        if (context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        try {
            File file = new File(str);
            if (file.exists() && (packageArchiveInfo = context.getPackageManager().getPackageArchiveInfo(file.getAbsolutePath(), 0)) != null && packageArchiveInfo.packageName.equals(str2)) {
                int i = packageArchiveInfo.versionCode;
                try {
                    packageInfo = context.getPackageManager().getPackageInfo(str2, 0);
                } catch (PackageManager.NameNotFoundException e) {
                    packageInfo = null;
                }
                if (packageInfo == null) {
                    return false;
                }
                return i == packageInfo.versionCode;
            }
            return false;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public static boolean mb(DownloadModel downloadModel) {
        if (downloadModel == null) {
            return false;
        }
        return mb(downloadModel.getPackageName(), downloadModel.getVersionCode(), downloadModel.getVersionName()).mb();
    }

    public static boolean mb(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return new File(str).exists();
    }

    public static boolean mb(Signature[] signatureArr, Signature[] signatureArr2) {
        if (signatureArr == signatureArr2) {
            return true;
        }
        if (signatureArr == null || signatureArr2 == null || signatureArr.length != signatureArr2.length) {
            return false;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= signatureArr.length) {
                return true;
            }
            if (signatureArr[i2] == null && signatureArr2[i2] != null) {
                return false;
            }
            if (signatureArr[i2] != null && !signatureArr[i2].equals(signatureArr2[i2])) {
                return false;
            }
            i = i2 + 1;
        }
    }

    public static int ox(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return -1;
        }
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 0);
            if (packageInfo != null) {
                return packageInfo.versionCode;
            }
            return -1;
        } catch (PackageManager.NameNotFoundException e) {
            return -1;
        }
    }

    public static HashMap<String, String> ox(JSONObject jSONObject) {
        HashMap<String, String> hashMap = new HashMap<>();
        if (jSONObject != null) {
            try {
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    hashMap.put(next, jSONObject.optString(next));
                }
                return hashMap;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return hashMap;
    }

    public static void ox() {
        ActivityManager.RunningTaskInfo next;
        try {
            if (com.ss.android.downloadlib.addownload.x.h().mb(com.ss.android.downloadlib.addownload.x.getContext(), Manifest.permission.REORDER_TASKS)) {
                ActivityManager activityManager = (ActivityManager) com.ss.android.downloadlib.addownload.x.getContext().getSystemService("activity");
                Iterator<ActivityManager.RunningTaskInfo> it = activityManager.getRunningTasks(20).iterator();
                do {
                    if (!it.hasNext()) {
                        return;
                    }
                    next = it.next();
                } while (!com.ss.android.downloadlib.addownload.x.getContext().getPackageName().equals(next.topActivity.getPackageName()));
                activityManager.moveTaskToFront(next.id, 1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean ox(Context context, Intent intent) {
        if (intent == null) {
            return false;
        }
        Context context2 = context;
        if (context == null) {
            context2 = com.ss.android.downloadlib.addownload.x.getContext();
        }
        List<ResolveInfo> queryIntentActivities = context2.getPackageManager().queryIntentActivities(intent, 65536);
        boolean z = false;
        if (queryIntentActivities != null) {
            z = false;
            if (queryIntentActivities.size() > 0) {
                z = true;
            }
        }
        return z;
    }

    public static boolean ox(com.ss.android.downloadad.api.mb.ox oxVar) {
        if (oxVar == null) {
            return false;
        }
        return mb(oxVar.h(), oxVar.q(), oxVar.bv()).mb();
    }

    public static boolean ox(String str) {
        return !TextUtils.isEmpty(str) && new File(str).exists();
    }

    public static Intent u(Context context, String str) {
        Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(str);
        if (launchIntentForPackage == null) {
            return null;
        }
        if (!launchIntentForPackage.hasCategory(Intent.CATEGORY_LAUNCHER)) {
            launchIntentForPackage.addCategory(Intent.CATEGORY_LAUNCHER);
        }
        launchIntentForPackage.setPackage(null);
        launchIntentForPackage.addFlags(2097152);
        launchIntentForPackage.addFlags(268435456);
        return launchIntentForPackage;
    }

    public static Signature[] ww(Context context, String str) {
        try {
            PackageInfo packageArchiveInfo = context.getPackageManager().getPackageArchiveInfo(str, 64);
            if (packageArchiveInfo != null) {
                return packageArchiveInfo.signatures;
            }
            return null;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }
}
