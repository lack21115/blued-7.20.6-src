package com.ss.android.socialbase.appdownloader;

import android.app.Activity;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import com.huawei.openalliance.ad.constant.ao;
import com.ss.android.downloadad.api.constant.AdBaseConstants;
import com.ss.android.downloadlib.constants.EventConstants;
import com.ss.android.socialbase.appdownloader.b.x;
import com.ss.android.socialbase.downloader.constants.DownloadStatus;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventListener;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.notification.DownloadNotificationManager;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import com.ss.android.socialbase.downloader.utils.SystemUtils;
import java.io.File;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8457232-dex2jar.jar:com/ss/android/socialbase/appdownloader/b.class */
public class b {
    private static int mb;
    private static NotificationChannel ox;

    public static List<String> b() {
        ArrayList arrayList = new ArrayList(2);
        arrayList.add(AdBaseConstants.MIME_APK);
        arrayList.add("application/ttpatch");
        return arrayList;
    }

    public static boolean b(Context context, DownloadInfo downloadInfo) {
        if (context == null || downloadInfo == null || TextUtils.isEmpty(downloadInfo.getSavePath()) || TextUtils.isEmpty(downloadInfo.getName())) {
            return false;
        }
        return ox(context, downloadInfo, mb(context, downloadInfo, downloadInfo.getSavePath(), downloadInfo.getName()));
    }

    public static boolean b(String str) {
        return !TextUtils.isEmpty(str) && str.equals(AdBaseConstants.MIME_APK);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int hj(Context context, int i, boolean z) {
        boolean z2 = true;
        if (DownloadSetting.obtain(i).optInt("notification_opt_2") == 1) {
            DownloadNotificationManager.getInstance().cancelNotification(i);
        }
        mb((Activity) ww.mb().ox());
        if (DownloadSetting.obtain(i).optInt("install_queue_enable", 0) != 1) {
            z2 = false;
        }
        return z2 ? ww.mb().mb(context, i, z) : ox(context, i, z);
    }

    private static JSONObject hj(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return new JSONObject(str);
        } catch (Throwable th) {
            return null;
        }
    }

    public static int mb() {
        return hj.x().u() ? 16384 : 0;
    }

    public static int mb(int i) {
        if (i == 0) {
            return 0;
        }
        if (i == -2) {
            return 2;
        }
        if (i == 1) {
            return 4;
        }
        if (DownloadStatus.isDownloading(i) || i == 11) {
            return 1;
        }
        return DownloadStatus.isDownloadOver(i) ? 3 : 0;
    }

    public static int mb(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static int mb(final Context context, final int i, final boolean z) {
        x ko = hj.x().ko();
        if (ko == null) {
            return hj(context, i, z);
        }
        DownloadInfo downloadInfo = Downloader.getInstance(context).getDownloadInfo(i);
        mb = 1;
        ko.mb(downloadInfo, new com.ss.android.socialbase.appdownloader.b.lz() { // from class: com.ss.android.socialbase.appdownloader.b.1
            @Override // com.ss.android.socialbase.appdownloader.b.lz
            public void mb() {
                int unused = b.mb = b.hj(Context.this, i, z);
            }
        });
        return mb;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x005d, code lost:
        if (r11 == null) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0060, code lost:
        r11.destroy();
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0046, code lost:
        if (r11 != null) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int mb(android.content.Context r6, int r7, boolean r8, com.ss.android.socialbase.downloader.model.DownloadInfo r9, java.io.File r10) {
        /*
            Method dump skipped, instructions count: 458
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.appdownloader.b.mb(android.content.Context, int, boolean, com.ss.android.socialbase.downloader.model.DownloadInfo, java.io.File):int");
    }

    public static int mb(Context context, Intent intent) {
        try {
            if (hj.x().o() != null) {
                if (hj.x().o().installApp(intent)) {
                    return 1;
                }
            }
        } catch (Throwable th) {
        }
        try {
            context.startActivity(intent);
            return 1;
        } catch (Throwable th2) {
            return 0;
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Throwable, java.lang.Runtime] */
    private static Intent mb(Context context, DownloadInfo downloadInfo, File file, boolean z, int[] iArr) {
        throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge Z and I\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:244)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }

    public static PackageInfo mb(Context context, DownloadInfo downloadInfo, String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        File file = new File(str, str2);
        if (file.exists()) {
            Log.e("AppDownloadUtils", "isApkInstalled apkFileSize：fileName:" + file.getPath() + " apkFileSize" + file.length());
            return mb(downloadInfo, file);
        }
        return null;
    }

    public static PackageInfo mb(DownloadInfo downloadInfo, File file) {
        if (downloadInfo == null) {
            return com.ss.android.socialbase.appdownloader.u.mb.h.mb(DownloadComponentManager.getAppContext(), file, mb());
        }
        PackageInfo packageInfo = downloadInfo.getPackageInfo();
        PackageInfo packageInfo2 = packageInfo;
        if (packageInfo == null) {
            packageInfo2 = com.ss.android.socialbase.appdownloader.u.mb.h.mb(DownloadComponentManager.getAppContext(), file, mb());
            downloadInfo.setPackageInfo(packageInfo2);
        }
        return packageInfo2;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0036 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.net.Uri mb(int r5, com.ss.android.socialbase.downloader.depend.IDownloadFileUriProvider r6, android.content.Context r7, java.lang.String r8, java.io.File r9) {
        /*
            r0 = r6
            if (r0 == 0) goto L14
            r0 = r6
            r1 = r8
            r2 = r9
            java.lang.String r2 = r2.getAbsolutePath()     // Catch: java.lang.Throwable -> L5c
            android.net.Uri r0 = r0.getUriForFile(r1, r2)     // Catch: java.lang.Throwable -> L5c
            r6 = r0
            goto L32
        L14:
            com.ss.android.socialbase.appdownloader.hj r0 = com.ss.android.socialbase.appdownloader.hj.x()
            com.ss.android.socialbase.appdownloader.b.u r0 = r0.h()
            r6 = r0
            r0 = r6
            if (r0 == 0) goto L30
            r0 = r6
            r1 = r5
            r2 = r8
            r3 = r9
            java.lang.String r3 = r3.getAbsolutePath()     // Catch: java.lang.Throwable -> L5c
            android.net.Uri r0 = r0.mb(r1, r2, r3)     // Catch: java.lang.Throwable -> L5c
            r6 = r0
            goto L32
        L30:
            r0 = 0
            r6 = r0
        L32:
            r0 = r6
            if (r0 != 0) goto L5a
            int r0 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Throwable -> L55
            r1 = 24
            if (r0 < r1) goto L4d
            r0 = r8
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.Throwable -> L55
            if (r0 != 0) goto L4d
            r0 = r7
            r1 = r8
            r2 = r9
            android.net.Uri r0 = androidx.core.content.FileProvider.getUriForFile(r0, r1, r2)     // Catch: java.lang.Throwable -> L55
            return r0
        L4d:
            r0 = r9
            android.net.Uri r0 = android.net.Uri.fromFile(r0)     // Catch: java.lang.Throwable -> L55
            r7 = r0
            r0 = r7
            return r0
        L55:
            r7 = move-exception
            r0 = r7
            r0.printStackTrace()
        L5a:
            r0 = r6
            return r0
        L5c:
            r6 = move-exception
            goto L30
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.appdownloader.b.mb(int, com.ss.android.socialbase.downloader.depend.IDownloadFileUriProvider, android.content.Context, java.lang.String, java.io.File):android.net.Uri");
    }

    public static String mb(long j) {
        return mb(j, true);
    }

    private static String mb(long j, long j2, String str) {
        double d = j;
        double d2 = d;
        if (j2 > 1) {
            d2 = d / j2;
        }
        if ("MB".equals(str)) {
            return new DecimalFormat("#").format(d2) + str;
        }
        return new DecimalFormat("#.##").format(d2) + str;
    }

    private static String mb(long j, long j2, String str, boolean z) {
        double d = j;
        double d2 = d;
        if (j2 > 1) {
            d2 = d / j2;
        }
        if (z || "GB".equals(str) || "TB".equals(str)) {
            return new DecimalFormat("#.##").format(d2) + " " + str;
        }
        return new DecimalFormat("#").format(d2) + " " + str;
    }

    public static String mb(long j, boolean z) {
        String[] strArr = {"TB", "GB", "MB", "KB", "B"};
        if (j < 1) {
            return "0 " + strArr[4];
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= 5) {
                return null;
            }
            long j2 = new long[]{1099511627776L, 1073741824, 1048576, 1024, 1}[i2];
            if (j >= j2) {
                return mb(j, j2, strArr[i2], z);
            }
            i = i2 + 1;
        }
    }

    public static String mb(String str, DownloadSetting downloadSetting) {
        String str2;
        JSONObject optJSONObject;
        String format;
        if (downloadSetting == null || (optJSONObject = downloadSetting.optJSONObject(DownloadSettingKeys.KEY_ANTI_HIJACK_DIR)) == null) {
            str2 = "";
        } else {
            String optString = optJSONObject.optString(DownloadSettingKeys.AntiHijackDir.KEY_ANTI_HIJACK_DIR_NAME);
            String str3 = optString;
            if (!TextUtils.isEmpty(optString)) {
                str3 = optString;
                if (optString.startsWith(BridgeUtil.SPLIT_MARK)) {
                    str3 = optString.substring(1);
                }
            }
            str2 = str3;
            if (!TextUtils.isEmpty(str3)) {
                if (str3.contains("%s")) {
                    try {
                        format = String.format(str3, str);
                    } catch (Throwable th) {
                    }
                } else {
                    format = str3 + str;
                }
                str3 = format;
                str2 = str3;
                if (str3.length() > 255) {
                    return str3.substring(str3.length() - 255);
                }
            }
        }
        return str2;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x005b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String mb(java.lang.String r3, java.lang.String r4, java.lang.String r5, boolean r6) {
        /*
            r0 = r3
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto Lb
            java.lang.String r0 = ""
            return r0
        Lb:
            r0 = r3
            android.net.Uri r0 = android.net.Uri.parse(r0)
            r7 = r0
            r0 = r6
            if (r0 == 0) goto L32
            r0 = r4
            r3 = r0
            r0 = r4
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L52
            r0 = r7
            java.lang.String r0 = r0.getLastPathSegment()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L4b
            r0 = r7
            java.lang.String r0 = r0.getLastPathSegment()
            r3 = r0
            goto L52
        L32:
            r0 = r7
            java.lang.String r0 = r0.getLastPathSegment()
            r3 = r0
            r0 = r3
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L52
            r0 = r4
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L4b
            r0 = r4
            r3 = r0
            goto L52
        L4b:
            java.lang.String r0 = "default.apk"
            r3 = r0
            goto L52
        L52:
            r0 = r3
            r4 = r0
            r0 = r5
            boolean r0 = b(r0)
            if (r0 == 0) goto L82
            r0 = r3
            r4 = r0
            r0 = r3
            java.lang.String r1 = ".apk"
            boolean r0 = r0.endsWith(r1)
            if (r0 != 0) goto L82
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r1 = r0
            r1.<init>()
            r4 = r0
            r0 = r4
            r1 = r3
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r4
            java.lang.String r1 = ".apk"
            java.lang.StringBuilder r0 = r0.append(r1)
            r0 = r4
            java.lang.String r0 = r0.toString()
            r4 = r0
        L82:
            r0 = r4
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.appdownloader.b.mb(java.lang.String, java.lang.String, java.lang.String, boolean):java.lang.String");
    }

    public static void mb(Activity activity) {
        if (activity != null) {
            try {
                if (activity.isFinishing()) {
                    return;
                }
                activity.finish();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void mb(DownloadInfo downloadInfo, boolean z, boolean z2) {
        hj.x().mb(new u(DownloadComponentManager.getAppContext(), downloadInfo.getUrl()).mb(downloadInfo.getTitle()).ox(downloadInfo.getName()).b(downloadInfo.getSavePath()).mb(downloadInfo.isShowNotification()).ox(downloadInfo.isAutoInstallWithoutNotification()).b(downloadInfo.isOnlyWifi() || z2).hj(downloadInfo.getExtra()).h(downloadInfo.getMimeType()).mb(downloadInfo.getExtraHeaders()).h(true).ox(downloadInfo.getRetryCount()).b(downloadInfo.getBackUpUrlRetryCount()).ox(downloadInfo.getBackUpUrls()).hj(downloadInfo.getMinProgressTimeMsInterval()).h(downloadInfo.getMaxProgressCount()).u(z).hj(downloadInfo.isNeedHttpsToHttpRetry()).u(downloadInfo.getPackageName()).ko(downloadInfo.getMd5()).mb(downloadInfo.getExpectFileLength()).lz(downloadInfo.isNeedDefaultHttpServiceBackUp()).x(downloadInfo.isNeedReuseFirstConnection()).je(downloadInfo.isNeedIndependentProcess()).mb(downloadInfo.getEnqueueType()).o(downloadInfo.isForce()).nk(downloadInfo.isHeadConnectionAvailable()).ko(downloadInfo.isNeedRetryDelay()).ww(downloadInfo.getRetryDelayTimeArray()).mb(hj(downloadInfo.getDownloadSettingString())).x(downloadInfo.getIconUrl()).u(downloadInfo.getExecutorGroup()).io(downloadInfo.isAutoInstall()));
    }

    public static boolean mb(Context context) {
        TypedArray typedArray;
        int color;
        if (Build.VERSION.SDK_INT <= 20 || context == null) {
            return false;
        }
        TypedArray typedArray2 = null;
        try {
            color = context.getResources().getColor(h.ox());
            typedArray = context.obtainStyledAttributes(h.h(), new int[]{h.b(), h.hj()});
            typedArray2 = typedArray;
        } catch (Throwable th) {
            if (typedArray2 == null) {
                return false;
            }
            typedArray = typedArray2;
        }
        if (color == typedArray.getColor(0, 0)) {
            if (typedArray != null) {
                try {
                    typedArray.recycle();
                    return true;
                } catch (Throwable th2) {
                    return true;
                }
            }
            return true;
        }
        if (typedArray == null) {
            return false;
        }
        try {
            typedArray.recycle();
            return false;
        } catch (Throwable th3) {
            return false;
        }
    }

    public static boolean mb(Context context, int i, File file) {
        if (DownloadSetting.obtain(i).optInt("back_miui_silent_install", 1) == 1) {
            return false;
        }
        if ((com.ss.android.socialbase.appdownloader.u.hj.je() || com.ss.android.socialbase.appdownloader.u.hj.nk()) && SystemUtils.checkServiceExists(context, "com.miui.securitycore", "com.miui.enterprise.service.EntInstallService")) {
            Intent intent = new Intent();
            intent.setComponent(new ComponentName("com.miui.securitycore", "com.miui.enterprise.service.EntInstallService"));
            Bundle bundle = new Bundle();
            bundle.putInt(ao.q, 0);
            bundle.putInt("flag", 256);
            bundle.putString("apkPath", file.getPath());
            bundle.putString("installerPkg", "com.miui.securitycore");
            intent.putExtras(bundle);
            try {
                context.startService(intent);
                return true;
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
        return false;
    }

    public static boolean mb(Context context, DownloadInfo downloadInfo) {
        return mb(context, downloadInfo, true);
    }

    public static boolean mb(Context context, DownloadInfo downloadInfo, PackageInfo packageInfo) {
        if (packageInfo == null || packageInfo.packageName.equals(downloadInfo.getPackageName())) {
            return false;
        }
        com.ss.android.socialbase.appdownloader.b.hj ox2 = hj.x().ox();
        if (ox2 != null) {
            ox2.mb(downloadInfo.getId(), 8, downloadInfo.getPackageName(), packageInfo.packageName, "");
            if (ox2.mb()) {
                return true;
            }
        }
        IDownloadNotificationEventListener downloadNotificationEventListener = Downloader.getInstance(context).getDownloadNotificationEventListener(downloadInfo.getId());
        if (downloadNotificationEventListener != null) {
            downloadNotificationEventListener.onNotificationEvent(8, downloadInfo, packageInfo.packageName, "");
            com.ss.android.socialbase.appdownloader.b.b mb2 = hj.x().mb();
            return (mb2 instanceof com.ss.android.socialbase.appdownloader.b.mb) && ((com.ss.android.socialbase.appdownloader.b.mb) mb2).b();
        }
        return false;
    }

    public static boolean mb(Context context, DownloadInfo downloadInfo, PackageInfo packageInfo, boolean z) {
        PackageInfo packageInfo2;
        if (packageInfo == null) {
            return false;
        }
        String str = packageInfo.packageName;
        int i = packageInfo.versionCode;
        if (downloadInfo != null) {
            downloadInfo.setAppVersionCode(i);
        }
        try {
            packageInfo2 = context.getPackageManager().getPackageInfo(str, mb());
        } catch (PackageManager.NameNotFoundException e) {
            packageInfo2 = null;
        }
        if (packageInfo2 == null) {
            return false;
        }
        int i2 = packageInfo2.versionCode;
        if (z) {
            boolean z2 = false;
            if (i < i2) {
                z2 = true;
            }
            return z2;
        } else if (downloadInfo == null || DownloadSetting.obtain(downloadInfo.getId()).optInt("install_with_same_version_code", 0) != 1) {
            boolean z3 = false;
            if (i <= i2) {
                z3 = true;
            }
            return z3;
        } else {
            boolean z4 = false;
            if (i < i2) {
                z4 = true;
            }
            return z4;
        }
    }

    public static boolean mb(Context context, DownloadInfo downloadInfo, String str) {
        PackageInfo packageInfo;
        PackageInfo packageInfo2;
        if (context == null) {
            return false;
        }
        try {
            File file = new File(downloadInfo.getSavePath(), downloadInfo.getName());
            if (!file.exists()) {
                if (DownloadSetting.obtain(downloadInfo.getId()).optBugFix("install_callback_error")) {
                    String string = DownloadUtils.getString(downloadInfo.getTempCacheData().get("extra_apk_package_name"), null);
                    int i = DownloadUtils.getInt(downloadInfo.getTempCacheData().get("extra_apk_version_code"), 0);
                    if (string == null || TextUtils.isEmpty(string) || !string.equals(str)) {
                        return false;
                    }
                    try {
                        packageInfo = context.getPackageManager().getPackageInfo(str, mb());
                    } catch (PackageManager.NameNotFoundException e) {
                        packageInfo = null;
                    }
                    return packageInfo != null && i == packageInfo.versionCode;
                }
                return false;
            }
            Log.e("AppDownloadUtils", "isPackageNameEqualsWithApk fileName:" + downloadInfo.getName() + " apkFileSize：" + file.length() + " fileUrl：" + downloadInfo.getUrl());
            PackageInfo mb2 = mb(downloadInfo, file);
            if (mb2 != null && mb2.packageName.equals(str)) {
                int i2 = mb2.versionCode;
                try {
                    packageInfo2 = context.getPackageManager().getPackageInfo(str, mb());
                } catch (PackageManager.NameNotFoundException e2) {
                    packageInfo2 = null;
                }
                return packageInfo2 != null && i2 == packageInfo2.versionCode;
            }
            return false;
        } catch (Exception e3) {
            e3.printStackTrace();
            return false;
        }
    }

    public static boolean mb(Context context, DownloadInfo downloadInfo, boolean z) {
        PackageInfo packageInfo;
        if (downloadInfo == null) {
            return false;
        }
        String packageName = downloadInfo.getPackageName();
        int appVersionCode = downloadInfo.getAppVersionCode();
        if (appVersionCode > 0 || !z) {
            try {
                packageInfo = context.getPackageManager().getPackageInfo(packageName, mb());
            } catch (PackageManager.NameNotFoundException e) {
                packageInfo = null;
            }
            if (packageInfo == null) {
                return false;
            }
            if (DownloadSetting.obtain(downloadInfo.getId()).optInt("install_with_same_version_code", 0) == 1) {
                boolean z2 = false;
                if (appVersionCode < packageInfo.versionCode) {
                    z2 = true;
                }
                return z2;
            }
            boolean z3 = false;
            if (appVersionCode <= packageInfo.versionCode) {
                z3 = true;
            }
            return z3;
        }
        return b(context, downloadInfo);
    }

    public static boolean mb(DownloadInfo downloadInfo, String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (TextUtils.isEmpty(downloadInfo.getPackageName()) || !str.equals(downloadInfo.getPackageName())) {
            return !TextUtils.isEmpty(downloadInfo.getName()) && mb(DownloadComponentManager.getAppContext(), downloadInfo, str);
        }
        return true;
    }

    public static boolean mb(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return new JSONObject(str).optBoolean("bind_app", false);
        } catch (JSONException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static int ox(final Context context, final int i, final boolean z) {
        final DownloadInfo downloadInfo = Downloader.getInstance(context).getDownloadInfo(i);
        if (downloadInfo != null && AdBaseConstants.MIME_APK.equals(downloadInfo.getMimeType()) && !TextUtils.isEmpty(downloadInfo.getSavePath()) && !TextUtils.isEmpty(downloadInfo.getName())) {
            final File file = new File(downloadInfo.getSavePath(), downloadInfo.getName());
            if (file.exists()) {
                DownloadComponentManager.submitIOTask(new Runnable() { // from class: com.ss.android.socialbase.appdownloader.b.2
                    @Override // java.lang.Runnable
                    public void run() {
                        int mb2 = b.mb(Context.this, i, z, downloadInfo, file);
                        if (mb2 == 1 && hj.x().lc() != null) {
                            hj.x().lc().onOpenInstaller(downloadInfo, null);
                        }
                        b.ox(downloadInfo, z, mb2);
                    }
                });
                return 1;
            }
        }
        ox(downloadInfo, z, 2);
        return 2;
    }

    public static int ox(Context context, DownloadInfo downloadInfo) {
        if (context == null || downloadInfo == null || TextUtils.isEmpty(downloadInfo.getSavePath()) || TextUtils.isEmpty(downloadInfo.getName())) {
            return 0;
        }
        int appVersionCode = downloadInfo.getAppVersionCode();
        if (appVersionCode > 0) {
            return appVersionCode;
        }
        try {
            PackageInfo mb2 = mb(context, downloadInfo, downloadInfo.getSavePath(), downloadInfo.getName());
            if (mb2 != null) {
                int i = mb2.versionCode;
                downloadInfo.setAppVersionCode(i);
                return i;
            }
            return 0;
        } catch (Throwable th) {
            return 0;
        }
    }

    public static String ox() {
        return DownloadUtils.getDownloadPath();
    }

    public static String ox(long j) {
        String[] strArr = {"TB", "GB", "MB", "KB", "B"};
        if (j < 1) {
            return "0 " + strArr[4];
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= 5) {
                return null;
            }
            long j2 = new long[]{1099511627776L, 1073741824, 1048576, 1024, 1}[i2];
            if (j >= j2) {
                return mb(j, j2, strArr[i2]);
            }
            i = i2 + 1;
        }
    }

    public static String ox(Context context) {
        try {
            if (ox == null) {
                NotificationChannel notificationChannel = new NotificationChannel("111111", "channel_appdownloader", 3);
                ox = notificationChannel;
                notificationChannel.setSound(null, null);
                ox.setShowBadge(false);
                ((NotificationManager) context.getSystemService("notification")).createNotificationChannel(ox);
                return "111111";
            }
            return "111111";
        } catch (Throwable th) {
            th.printStackTrace();
            return "111111";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void ox(DownloadInfo downloadInfo, boolean z, int i) {
        if (downloadInfo == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("by_user", z ? 1 : 2);
            jSONObject.put("view_result", i);
            jSONObject.put(EventConstants.ExtraJson.REAL_PACKAGE_NAME, downloadInfo.getFilePackageName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        DownloadComponentManager.getEventListener().onEvent(downloadInfo.getId(), MonitorConstants.EventLabel.INSTALL_VIEW_RESULT, jSONObject);
    }

    public static boolean ox(Context context, DownloadInfo downloadInfo, PackageInfo packageInfo) {
        return mb(context, downloadInfo, packageInfo, false);
    }

    public static boolean ox(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.optBoolean("bind_app", false)) {
                return true;
            }
            return !jSONObject.optBoolean("auto_install_with_notification", true);
        } catch (JSONException e) {
            e.printStackTrace();
            return false;
        }
    }
}
