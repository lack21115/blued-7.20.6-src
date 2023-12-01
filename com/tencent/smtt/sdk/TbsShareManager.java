package com.tencent.smtt.sdk;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import com.qiniu.android.http.ResponseInfo;
import com.tencent.smtt.utils.FileUtil;
import com.tencent.smtt.utils.TbsLog;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/smtt/sdk/TbsShareManager.class */
public class TbsShareManager {

    /* renamed from: a  reason: collision with root package name */
    private static Context f38789a;
    private static boolean b = false;

    /* renamed from: c  reason: collision with root package name */
    private static String f38790c;
    private static String d;
    private static int e = 0;
    private static String f;
    private static boolean g = false;
    private static boolean h = false;
    private static boolean i = false;
    private static String j;
    private static boolean k = false;
    private static boolean l = false;
    public static boolean mHasQueryed = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(Context context, boolean z) {
        b(context, z);
        return e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a() {
        return d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Context context) {
        TbsLog.i("TbsShareManager", "shareTbsCore #1");
        try {
            TbsLinuxToolsJni tbsLinuxToolsJni = new TbsLinuxToolsJni(context);
            a(context, tbsLinuxToolsJni, o.a().q(context));
            File r = o.a().r(context);
            TbsLog.i("TbsShareManager", "shareTbsCore tbsShareDir is " + r.getAbsolutePath());
            tbsLinuxToolsJni.a(r.getAbsolutePath(), "755");
        } catch (Throwable th) {
            TbsLog.i("TbsShareManager", "shareTbsCore tbsShareDir error is " + th.getMessage() + " ## " + th.getCause());
            th.printStackTrace();
        }
    }

    private static void a(Context context, int i2) {
        String str;
        File backupDecoupleCoreFile;
        StringBuilder sb;
        String str2;
        if (TbsPVConfig.getInstance(f38789a).isDisableHostBackupCore() || !o.a().t(context)) {
            return;
        }
        String packageName = context.getPackageName();
        TbsLog.i("TbsShareManager", "find host backup core to unzip #1" + Log.getStackTraceString(new Throwable()));
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= 5) {
                break;
            }
            str = new String[]{TbsConfig.APP_DEMO, "com.tencent.mm", "com.tencent.mobileqq", "com.qzone", packageName}[i4];
            if (i2 == getBackupCoreVersion(context, str)) {
                if (o.a().f(getPackageContext(context, str, false))) {
                    backupDecoupleCoreFile = getBackupCoreFile(context, str);
                    if (com.tencent.smtt.utils.a.a(context, backupDecoupleCoreFile, 0L, i2)) {
                        sb = new StringBuilder();
                        str2 = "find host backup core to unzip normal coreVersion is ";
                        break;
                    }
                } else {
                    continue;
                }
                i3 = i4 + 1;
            } else {
                if (i2 == getBackupDecoupleCoreVersion(context, str) && o.a().f(getPackageContext(context, str, false))) {
                    backupDecoupleCoreFile = getBackupDecoupleCoreFile(context, str);
                    if (com.tencent.smtt.utils.a.a(context, backupDecoupleCoreFile, 0L, i2)) {
                        sb = new StringBuilder();
                        str2 = "find host backup core to unzip decouple coreVersion is ";
                        break;
                    }
                }
                i3 = i4 + 1;
            }
        }
        sb.append(str2);
        sb.append(i2);
        sb.append(" packageName is ");
        sb.append(str);
        TbsLog.i("TbsShareManager", sb.toString());
        o.a().b(context, backupDecoupleCoreFile, i2);
        o.a().b();
    }

    private static void a(Context context, TbsLinuxToolsJni tbsLinuxToolsJni, File file) {
        TbsLog.i("TbsShareManager", "shareAllDirsAndFiles #1");
        if (file == null || !file.exists() || !file.isDirectory()) {
            return;
        }
        TbsLog.i("TbsShareManager", "shareAllDirsAndFiles dir is " + file.getAbsolutePath());
        tbsLinuxToolsJni.a(file.getAbsolutePath(), "755");
        File[] listFiles = file.listFiles();
        int length = listFiles.length;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= length) {
                return;
            }
            File file2 = listFiles[i3];
            if (file2.isFile()) {
                int indexOf = file2.getAbsolutePath().indexOf(".so");
                String absolutePath = file2.getAbsolutePath();
                if (indexOf > 0) {
                    tbsLinuxToolsJni.a(absolutePath, "755");
                } else {
                    tbsLinuxToolsJni.a(absolutePath, "644");
                }
            } else if (file2.isDirectory()) {
                a(context, tbsLinuxToolsJni, file2);
            } else {
                TbsLog.e("TbsShareManager", "unknown file type.", true);
            }
            i2 = i3 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(Context context) {
        try {
            a(context, new TbsLinuxToolsJni(context), o.a().p(context));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    static boolean b(Context context, boolean z) {
        if (i(context)) {
            return true;
        }
        if (z) {
            QbSdk.a(context, "TbsShareManager::isShareTbsCoreAvailable forceSysWebViewInner!");
            return false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String c(Context context) {
        j(context);
        return d;
    }

    private static void c(Context context, boolean z) {
        BufferedOutputStream bufferedOutputStream;
        BufferedInputStream bufferedInputStream;
        File tbsShareFile;
        try {
            tbsShareFile = getTbsShareFile(context, "core_info");
        } catch (Throwable th) {
            th = th;
            bufferedOutputStream = null;
            bufferedInputStream = null;
        }
        if (tbsShareFile == null) {
            return;
        }
        bufferedInputStream = new BufferedInputStream(new FileInputStream(tbsShareFile));
        try {
            Properties properties = new Properties();
            properties.load(bufferedInputStream);
            properties.setProperty("core_disabled", String.valueOf(false));
            if (z) {
                String absolutePath = o.a().q(context).getAbsolutePath();
                String packageName = context.getApplicationContext().getPackageName();
                int d2 = com.tencent.smtt.utils.b.d(context);
                properties.setProperty("core_packagename", packageName);
                properties.setProperty("core_path", absolutePath);
                properties.setProperty("app_version", String.valueOf(d2));
            }
            bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(tbsShareFile));
            try {
                properties.store(bufferedOutputStream, (String) null);
                try {
                    bufferedInputStream.close();
                } catch (Exception e2) {
                }
            } catch (Throwable th2) {
                th = th2;
                try {
                    th.printStackTrace();
                    if (bufferedInputStream != null) {
                        try {
                            bufferedInputStream.close();
                        } catch (Exception e3) {
                        }
                    }
                    if (bufferedOutputStream == null) {
                        return;
                    }
                    bufferedOutputStream.close();
                } catch (Throwable th3) {
                    if (bufferedInputStream != null) {
                        try {
                            bufferedInputStream.close();
                        } catch (Exception e4) {
                        }
                    }
                    if (bufferedOutputStream != null) {
                        try {
                            bufferedOutputStream.close();
                        } catch (Exception e5) {
                        }
                    }
                    throw th3;
                }
            }
        } catch (Throwable th4) {
            th = th4;
            bufferedOutputStream = null;
        }
        try {
            bufferedOutputStream.close();
        } catch (Exception e6) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int d(Context context) {
        return a(context, true);
    }

    private static String[] d(Context context, boolean z) {
        if (QbSdk.getOnlyDownload()) {
            return new String[]{context.getApplicationContext().getPackageName()};
        }
        return z ? new String[]{context.getApplicationContext().getPackageName()} : getCoreProviderAppList();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Context e(Context context) {
        j(context);
        String str = f;
        Context context2 = null;
        if (str != null) {
            context2 = getPackageContext(context, str, true);
            if (!o.a().f(context2)) {
                context2 = null;
            }
        }
        return f38790c != null ? f38789a : context2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String f(Context context) {
        BufferedInputStream bufferedInputStream;
        synchronized (TbsShareManager.class) {
            try {
                try {
                    File tbsShareFile = getTbsShareFile(context, "core_info");
                    if (tbsShareFile == null) {
                        return null;
                    }
                    bufferedInputStream = new BufferedInputStream(new FileInputStream(tbsShareFile));
                    try {
                        Properties properties = new Properties();
                        properties.load(bufferedInputStream);
                        String property = properties.getProperty("core_packagename", "");
                        if ("".equals(property)) {
                            try {
                                bufferedInputStream.close();
                            } catch (Exception e2) {
                            }
                            return null;
                        }
                        try {
                            bufferedInputStream.close();
                        } catch (Exception e3) {
                        }
                        return property;
                    } catch (Throwable th) {
                        th = th;
                        th.printStackTrace();
                        if (bufferedInputStream != null) {
                            try {
                                bufferedInputStream.close();
                            } catch (Exception e4) {
                            }
                        }
                        return null;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    bufferedInputStream = null;
                }
            } catch (Throwable th3) {
                throw th3;
            }
        }
    }

    public static int findCoreForThirdPartyApp(Context context) {
        String str;
        n(context);
        TbsLog.i("TbsShareManager", "core_info mAvailableCoreVersion is " + e + " mAvailableCorePath is " + d + " mSrcPackageName is " + f);
        if (f == null) {
            TbsLog.e("TbsShareManager", "mSrcPackageName is null !!!");
        }
        String str2 = f;
        if (str2 == null || !str2.equals("AppDefined")) {
            if (!k(context) && !l(context)) {
                e = 0;
                d = null;
                f = null;
                str = "core_info error checkCoreInfo is false and checkCoreInOthers is false ";
                TbsLog.i("TbsShareManager", str);
            }
        } else if (e != o.a().a(f38790c)) {
            e = 0;
            d = null;
            f = null;
            str = "check AppDefined core is error src is " + e + " dest is " + o.a().a(f38790c);
            TbsLog.i("TbsShareManager", str);
        }
        if (e > 0) {
            ApplicationInfo applicationInfo = context.getApplicationInfo();
            if ((!("com.tencent.android.qqdownloader".equals(applicationInfo.packageName) || "com.jd.jrapp".equals(applicationInfo.packageName)) ? QbSdk.a(context, e) : false) || g) {
                e = 0;
                d = null;
                f = null;
                TbsLog.i("TbsShareManager", "core_info error QbSdk.isX5Disabled ");
            }
        }
        return e;
    }

    public static boolean forceLoadX5FromTBSDemo(Context context) {
        boolean z = false;
        if (context != null) {
            if (o.a().a(context, (File[]) null)) {
                return false;
            }
            int sharedTbsCoreVersion = getSharedTbsCoreVersion(context, TbsConfig.APP_DEMO);
            z = false;
            if (sharedTbsCoreVersion > 0) {
                z = true;
                writeProperties(context, Integer.toString(sharedTbsCoreVersion), TbsConfig.APP_DEMO, o.a().q(getPackageContext(context, TbsConfig.APP_DEMO, true)).getAbsolutePath(), "1");
            }
        }
        return z;
    }

    public static void forceToLoadX5ForThirdApp(Context context, boolean z) {
        File r;
        int a2;
        try {
            if (!QbSdk.isNeedInitX5FirstTime() || !isThirdPartyApp(context) || QbSdk.getOnlyDownload() || (r = o.a().r(context)) == null) {
                return;
            }
            if (z && new File(r, "core_info").exists()) {
                return;
            }
            if (f38790c != null && (a2 = o.a().a(f38790c)) > 0) {
                d = f38790c;
                f = "AppDefined";
                e = a2;
                TbsLog.i("TbsShareManager", "forceToLoadX5ForThirdApp #1 -- mAvailableCoreVersion: " + e + " " + Log.getStackTraceString(new Throwable("#")));
                writeProperties(context, Integer.toString(e), f, d, Integer.toString(1));
                return;
            }
            TbsLog.i("TbsShareManager", "forceToLoadX5ForThirdApp #1");
            int h2 = h(context);
            int i2 = o.a().i(context);
            TbsLog.i("TbsShareManager", "forceToLoadX5ForThirdApp coreVersionFromConfig is " + h2);
            TbsLog.i("TbsShareManager", "forceToLoadX5ForThirdApp coreVersionFromCoreShare is " + i2);
            String[] coreProviderAppList = getCoreProviderAppList();
            int length = coreProviderAppList.length;
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 < length) {
                    String str = coreProviderAppList[i4];
                    int coreShareDecoupleCoreVersion = getCoreShareDecoupleCoreVersion(context, str);
                    if (coreShareDecoupleCoreVersion >= h2 && coreShareDecoupleCoreVersion >= i2 && coreShareDecoupleCoreVersion > 0) {
                        d = o.a().c(context, getPackageContext(context, str, true)).getAbsolutePath();
                        f = str;
                        e = coreShareDecoupleCoreVersion;
                        TbsLog.i("TbsShareManager", "forceToLoadX5ForThirdApp #2 -- mAvailableCoreVersion: " + e + " " + Log.getStackTraceString(new Throwable("#")));
                        if (QbSdk.canLoadX5FirstTimeThirdApp(context)) {
                            int d2 = com.tencent.smtt.utils.b.d(context);
                            TbsLog.i("TbsShareManager", "forceToLoadX5ForThirdApp #2");
                            writeProperties(context, Integer.toString(e), f, d, Integer.toString(d2));
                            return;
                        }
                        e = 0;
                        d = null;
                        f = null;
                    }
                    i3 = i4 + 1;
                } else {
                    int length2 = coreProviderAppList.length;
                    int i5 = 0;
                    while (true) {
                        int i6 = i5;
                        if (i6 < length2) {
                            String str2 = coreProviderAppList[i6];
                            int sharedTbsCoreVersion = getSharedTbsCoreVersion(context, str2);
                            if (sharedTbsCoreVersion >= h2 && sharedTbsCoreVersion >= i2 && sharedTbsCoreVersion > 0) {
                                d = o.a().b(context, getPackageContext(context, str2, true)).getAbsolutePath();
                                f = str2;
                                e = sharedTbsCoreVersion;
                                TbsLog.i("TbsShareManager", "forceToLoadX5ForThirdApp #3 -- mAvailableCoreVersion: " + e + " " + Log.getStackTraceString(new Throwable("#")));
                                if (QbSdk.canLoadX5FirstTimeThirdApp(context)) {
                                    writeProperties(context, Integer.toString(e), f, d, Integer.toString(com.tencent.smtt.utils.b.d(context)));
                                    return;
                                }
                                e = 0;
                                d = null;
                                f = null;
                            }
                            i5 = i6 + 1;
                        } else if (TbsPVConfig.getInstance(f38789a).isDisableHostBackupCore()) {
                            return;
                        } else {
                            if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
                                TbsLog.i("TbsShareManager", "in mainthread so do not find host backup core to install ");
                                return;
                            }
                            int length3 = coreProviderAppList.length;
                            int i7 = 0;
                            while (true) {
                                int i8 = i7;
                                if (i8 >= length3) {
                                    return;
                                }
                                String str3 = coreProviderAppList[i8];
                                int backupCoreVersion = getBackupCoreVersion(context, str3);
                                if (backupCoreVersion >= h2 && backupCoreVersion >= i2 && backupCoreVersion > 0) {
                                    TbsLog.i("TbsShareManager", "find host backup core to unzip forceload coreVersion is " + backupCoreVersion + " packageName is " + str3);
                                    o.a().a(context, getBackupCoreFile(context, str3), backupCoreVersion);
                                    TbsLog.i("TbsShareManager", "find host backup core to unzip forceload after unzip ");
                                    return;
                                }
                                int backupDecoupleCoreVersion = getBackupDecoupleCoreVersion(context, str3);
                                if (backupDecoupleCoreVersion >= h2 && backupDecoupleCoreVersion >= i2 && backupDecoupleCoreVersion > 0) {
                                    TbsLog.i("TbsShareManager", "find host backup core to unzip forceload decouple coreVersion is " + backupDecoupleCoreVersion + " packageName is " + str3);
                                    o.a().a(context, getBackupCoreFile(context, str3), backupDecoupleCoreVersion);
                                    TbsLog.i("TbsShareManager", "find host backup decouple core to unzip forceload after unzip ");
                                    return;
                                }
                                i7 = i8 + 1;
                            }
                        }
                    }
                }
            }
        } catch (Exception e2) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String g(Context context) {
        try {
            n(context);
            if (d == null || TextUtils.isEmpty(d)) {
                return null;
            }
            return d + File.separator + "res.apk";
        } catch (Throwable th) {
            Log.e("", "getTbsResourcesPath exception: " + Log.getStackTraceString(th));
            return null;
        }
    }

    public static File getBackupCoreFile(Context context, String str) {
        try {
            File file = new File(new File(FileUtil.a(getPackageContext(context, str, false), 4)), TbsDownloader.getBackupFileName(false));
            if (file.exists()) {
                return file;
            }
            return null;
        } catch (Throwable th) {
            return null;
        }
    }

    public static int getBackupCoreVersion(Context context, String str) {
        try {
            File file = new File(new File(FileUtil.a(getPackageContext(context, str, false), 4)), TbsDownloader.getBackupFileName(false));
            if (file.exists()) {
                return com.tencent.smtt.utils.a.b(file);
            }
            return 0;
        } catch (Throwable th) {
            return 0;
        }
    }

    public static File getBackupDecoupleCoreFile(Context context, String str) {
        try {
            File file = new File(new File(FileUtil.a(getPackageContext(context, str, true), 4)), TbsDownloader.getBackupFileName(true));
            if (file.exists()) {
                return file;
            }
            return null;
        } catch (Throwable th) {
            return null;
        }
    }

    public static int getBackupDecoupleCoreVersion(Context context, String str) {
        try {
            File file = new File(new File(FileUtil.a(getPackageContext(context, str, false), 4)), TbsDownloader.getBackupFileName(true));
            if (file.exists()) {
                return com.tencent.smtt.utils.a.b(file);
            }
            return 0;
        } catch (Throwable th) {
            return 0;
        }
    }

    public static boolean getCoreDisabled() {
        return g;
    }

    public static boolean getCoreFormOwn() {
        return k;
    }

    public static String[] getCoreProviderAppList() {
        return new String[]{TbsConfig.APP_DEMO, "com.tencent.mm", "com.tencent.mobileqq", "com.qzone", "com.tencent.qqlite"};
    }

    public static int getCoreShareDecoupleCoreVersion(Context context, String str) {
        Context packageContext = getPackageContext(context, str, true);
        if (packageContext != null) {
            return o.a().h(packageContext);
        }
        return 0;
    }

    public static String getHostCorePathAppDefined() {
        return f38790c;
    }

    public static long getHostCoreVersions(Context context) {
        long j2;
        long sharedTbsCoreVersion;
        long sharedTbsCoreVersion2;
        long j3;
        String[] coreProviderAppList = getCoreProviderAppList();
        int length = coreProviderAppList.length;
        long j4 = 0;
        int i2 = 0;
        while (i2 < length) {
            String str = coreProviderAppList[i2];
            if (str.equalsIgnoreCase("com.tencent.mm")) {
                sharedTbsCoreVersion2 = getSharedTbsCoreVersion(context, str);
                j3 = 10000000000L;
            } else if (str.equalsIgnoreCase("com.tencent.mobileqq")) {
                sharedTbsCoreVersion2 = getSharedTbsCoreVersion(context, str);
                j3 = 100000;
            } else {
                j2 = j4;
                if (str.equalsIgnoreCase("com.qzone")) {
                    sharedTbsCoreVersion = getSharedTbsCoreVersion(context, str);
                    j2 = j4 + sharedTbsCoreVersion;
                    i2++;
                    j4 = j2;
                } else {
                    i2++;
                    j4 = j2;
                }
            }
            sharedTbsCoreVersion = sharedTbsCoreVersion2 * j3;
            j2 = j4 + sharedTbsCoreVersion;
            i2++;
            j4 = j2;
        }
        return j4;
    }

    public static Context getPackageContext(Context context, String str, boolean z) {
        if (z) {
            try {
                if (!context.getPackageName().equals(str)) {
                    TbsLog.i("TbsShareManager", "gray no core app,skip get context");
                    if (TbsPVConfig.getInstance(context).isEnableNoCoreGray() || Build.VERSION.SDK_INT >= 29) {
                        return null;
                    }
                }
            } catch (PackageManager.NameNotFoundException e2) {
                return null;
            } catch (Exception e3) {
                e3.printStackTrace();
                return null;
            }
        }
        return context.createPackageContext(str, 2);
    }

    public static int getSharedTbsCoreVersion(Context context, String str) {
        Context packageContext = getPackageContext(context, str, true);
        if (packageContext != null) {
            return o.a().i(packageContext);
        }
        return 0;
    }

    public static File getTbsShareFile(Context context, String str) {
        File r = o.a().r(context);
        if (r == null) {
            return null;
        }
        File file = new File(r, str);
        if (file.exists()) {
            return file;
        }
        try {
            file.createNewFile();
            return file;
        } catch (IOException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    static int h(Context context) {
        BufferedInputStream bufferedInputStream;
        synchronized (TbsShareManager.class) {
            try {
                TbsLog.i("TbsShareManager", "readCoreVersionFromConfig #1");
            } catch (Throwable th) {
                throw th;
            }
            try {
                File tbsShareFile = getTbsShareFile(context, "core_info");
                if (tbsShareFile == null) {
                    TbsLog.i("TbsShareManager", "readCoreVersionFromConfig #2");
                    return 0;
                }
                bufferedInputStream = new BufferedInputStream(new FileInputStream(tbsShareFile));
                try {
                    Properties properties = new Properties();
                    properties.load(bufferedInputStream);
                    String property = properties.getProperty("core_version", "");
                    if ("".equals(property)) {
                        TbsLog.i("TbsShareManager", "readCoreVersionFromConfig #4");
                        try {
                            bufferedInputStream.close();
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                        return 0;
                    }
                    TbsLog.i("TbsShareManager", "readCoreVersionFromConfig #3");
                    int max = Math.max(Integer.parseInt(property), 0);
                    try {
                        bufferedInputStream.close();
                    } catch (Exception e3) {
                        e3.printStackTrace();
                    }
                    return max;
                } catch (Throwable th2) {
                    th = th2;
                    th.printStackTrace();
                    if (bufferedInputStream != null) {
                        try {
                            bufferedInputStream.close();
                        } catch (Exception e4) {
                            e4.printStackTrace();
                        }
                    }
                    TbsLog.i("TbsShareManager", "readCoreVersionFromConfig #5");
                    return -2;
                }
                throw th;
            } catch (Throwable th3) {
                th = th3;
                bufferedInputStream = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean i(Context context) {
        try {
            if (e == 0) {
                findCoreForThirdPartyApp(context);
            }
            if (e == 0) {
                TbsLog.addLog(TbsLog.TBSLOG_CODE_SDK_NO_SHARE_X5CORE, null, new Object[0]);
                return false;
            }
            if (f38790c == null) {
                if (e != 0 && getSharedTbsCoreVersion(context, f) == e) {
                    return true;
                }
            } else if (e != 0 && o.a().a(f38790c) == e) {
                return true;
            }
            if (l(context)) {
                return true;
            }
            TbsCoreLoadStat tbsCoreLoadStat = TbsCoreLoadStat.getInstance();
            tbsCoreLoadStat.a(context, 418, new Throwable("mAvailableCoreVersion=" + e + "; mSrcPackageName=" + f + "; getSharedTbsCoreVersion(ctx, mSrcPackageName) is " + getSharedTbsCoreVersion(context, f) + "; getHostCoreVersions is " + getHostCoreVersions(context)));
            d = null;
            e = 0;
            TbsLog.addLog(TbsLog.TBSLOG_CODE_SDK_CONFLICT_X5CORE, null, new Object[0]);
            QbSdk.a(context, "TbsShareManager::isShareTbsCoreAvailableInner forceSysWebViewInner!");
            return false;
        } catch (Throwable th) {
            th.printStackTrace();
            TbsLog.addLog(TbsLog.TBSLOG_CODE_SDK_UNAVAIL_X5CORE, null, new Object[0]);
            return false;
        }
    }

    public static boolean isThirdPartyApp(Context context) {
        try {
            if (f38789a != null && f38789a.equals(context.getApplicationContext())) {
                return b;
            }
            Context applicationContext = context.getApplicationContext();
            f38789a = applicationContext;
            String packageName = applicationContext.getPackageName();
            String[] coreProviderAppList = getCoreProviderAppList();
            int length = coreProviderAppList.length;
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= length) {
                    break;
                } else if (packageName.equals(coreProviderAppList[i3])) {
                    b = false;
                    return false;
                } else {
                    i2 = i3 + 1;
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        b = true;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean j(Context context) {
        return b(context, true);
    }

    private static boolean k(Context context) {
        String str = f;
        if (str == null) {
            return false;
        }
        return e == getSharedTbsCoreVersion(context, str) || e == getCoreShareDecoupleCoreVersion(context, f);
    }

    private static boolean l(Context context) {
        String str;
        File file;
        if (QbSdk.getOnlyDownload()) {
            return false;
        }
        String[] coreProviderAppList = getCoreProviderAppList();
        int length = coreProviderAppList.length;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < length) {
                String str2 = coreProviderAppList[i3];
                int i4 = e;
                if (i4 > 0 && i4 == getSharedTbsCoreVersion(context, str2)) {
                    Context packageContext = getPackageContext(context, str2, true);
                    if (o.a().f(context)) {
                        file = o.a().b(context, packageContext);
                        str = str2;
                        break;
                    }
                }
                i2 = i3 + 1;
            } else {
                int length2 = coreProviderAppList.length;
                int i5 = 0;
                while (true) {
                    int i6 = i5;
                    if (i6 >= length2) {
                        return false;
                    }
                    String str3 = coreProviderAppList[i6];
                    int i7 = e;
                    if (i7 > 0 && i7 == getCoreShareDecoupleCoreVersion(context, str3)) {
                        Context packageContext2 = getPackageContext(context, str3, true);
                        if (o.a().f(context)) {
                            File c2 = o.a().c(context, packageContext2);
                            str = str3;
                            file = c2;
                            break;
                        }
                    }
                    i5 = i6 + 1;
                }
            }
        }
        d = file.getAbsolutePath();
        f = str;
        return true;
    }

    private static boolean m(Context context) {
        if (context == null) {
            return false;
        }
        writeProperties(context, Integer.toString(0), "", "", Integer.toString(0));
        return true;
    }

    private static void n(Context context) {
        BufferedInputStream bufferedInputStream;
        File tbsShareFile;
        if (l) {
            return;
        }
        synchronized (TbsShareManager.class) {
            try {
                if (l) {
                    return;
                }
                try {
                    tbsShareFile = getTbsShareFile(context, "core_info");
                } catch (Throwable th) {
                    th = th;
                    bufferedInputStream = null;
                }
                if (tbsShareFile == null) {
                    return;
                }
                bufferedInputStream = new BufferedInputStream(new FileInputStream(tbsShareFile));
                try {
                    Properties properties = new Properties();
                    properties.load(bufferedInputStream);
                    String property = properties.getProperty("core_version", "");
                    if (!"".equals(property)) {
                        e = Math.max(Integer.parseInt(property), 0);
                        TbsLog.i("TbsShareManager", "loadProperties -- mAvailableCoreVersion: " + e + " " + Log.getStackTraceString(new Throwable("#")));
                    }
                    String property2 = properties.getProperty("core_packagename", "");
                    if (!"".equals(property2)) {
                        f = property2;
                    }
                    if (f != null && f38789a != null) {
                        if (f.equals(f38789a.getPackageName())) {
                            k = true;
                        } else {
                            k = false;
                        }
                    }
                    String property3 = properties.getProperty("core_path", "");
                    if (!"".equals(property3)) {
                        d = property3;
                    }
                    String property4 = properties.getProperty("app_version", "");
                    if (!"".equals(property4)) {
                        j = property4;
                    }
                    g = Boolean.parseBoolean(properties.getProperty("core_disabled", "false"));
                    l = true;
                } catch (Throwable th2) {
                    th = th2;
                    th.printStackTrace();
                    if (bufferedInputStream != null) {
                        try {
                            bufferedInputStream.close();
                        } catch (Exception e2) {
                            e = e2;
                            e.printStackTrace();
                        }
                    }
                }
                try {
                    bufferedInputStream.close();
                } catch (Exception e3) {
                    e = e3;
                    e.printStackTrace();
                }
            } finally {
            }
        }
    }

    public static void setHostCorePathAppDefined(String str) {
        f38790c = str;
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x031c, code lost:
        if (r0 == null) goto L106;
     */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x031f, code lost:
        r0 = new com.tencent.smtt.sdk.TbsLinuxToolsJni(com.tencent.smtt.sdk.TbsShareManager.f38789a);
        r0.a(r0.getAbsolutePath(), "644");
        r0.a(com.tencent.smtt.sdk.o.a().r(r6).getAbsolutePath(), "755");
        com.tencent.smtt.sdk.TbsShareManager.i = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x0351, code lost:
        r13 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:110:0x039b, code lost:
        if (r0.equals(r6.getApplicationContext().getPackageName()) != false) goto L134;
     */
    /* JADX WARN: Code restructure failed: missing block: B:111:0x039e, code lost:
        com.tencent.smtt.utils.TbsLog.i("TbsShareManager", "thirdAPP pre--> delete old core_share Directory:" + r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:113:0x03cc, code lost:
        com.tencent.smtt.utils.FileUtil.b(com.tencent.smtt.sdk.o.a().q(r6));
        com.tencent.smtt.utils.TbsLog.i("TbsShareManager", "thirdAPP success--> delete old core_share Directory");
     */
    /* JADX WARN: Code restructure failed: missing block: B:114:0x03da, code lost:
        r16 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x03dc, code lost:
        r16.printStackTrace();
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x02c8, code lost:
        if (r0.equals(r6.getApplicationContext().getPackageName()) != false) goto L96;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x02cb, code lost:
        com.tencent.smtt.utils.TbsLog.i("TbsShareManager", "thirdAPP pre--> delete old core_share Directory:" + r7);
        com.tencent.smtt.sdk.m.a(com.tencent.smtt.sdk.TbsShareManager.f38789a).a("remove_old_core", 1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x02fc, code lost:
        writeProperties(r6, java.lang.Integer.toString(r7), r0, r0, java.lang.Integer.toString(r0));
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x030d, code lost:
        r0 = getTbsShareFile(r6, "core_info");
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x0317, code lost:
        if (com.tencent.smtt.sdk.TbsShareManager.i != false) goto L106;
     */
    /* JADX WARN: Removed duplicated region for block: B:130:0x044b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void writeCoreInfoForThirdPartyApp(android.content.Context r6, int r7, boolean r8) {
        /*
            Method dump skipped, instructions count: 1131
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.TbsShareManager.writeCoreInfoForThirdPartyApp(android.content.Context, int, boolean):void");
    }

    public static void writeProperties(Context context, String str, String str2, String str3, String str4) {
        BufferedOutputStream bufferedOutputStream;
        BufferedInputStream bufferedInputStream;
        int i2;
        TbsLog.i("TbsShareManager", "writeProperties coreVersion is " + str + " corePackageName is " + str2 + " corePath is " + str3);
        StringBuilder sb = new StringBuilder();
        sb.append("writeProperties -- stack: ");
        sb.append(Log.getStackTraceString(new Throwable("#")));
        TbsLog.i("TbsShareManager", sb.toString());
        try {
            try {
                File tbsShareFile = getTbsShareFile(context, "core_info");
                if (tbsShareFile == null) {
                    TbsDownloadConfig.getInstance(f38789a).setDownloadInterruptCode(-405);
                    return;
                }
                bufferedInputStream = new BufferedInputStream(new FileInputStream(tbsShareFile));
                try {
                    Properties properties = new Properties();
                    properties.load(bufferedInputStream);
                    try {
                        i2 = Integer.parseInt(str);
                    } catch (Exception e2) {
                        i2 = 0;
                    }
                    if (i2 != 0) {
                        properties.setProperty("core_version", str);
                        properties.setProperty("core_disabled", String.valueOf(false));
                        properties.setProperty("core_packagename", str2);
                        properties.setProperty("core_path", str3);
                        properties.setProperty("app_version", str4);
                    } else {
                        properties.setProperty("core_disabled", String.valueOf(true));
                    }
                    bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(tbsShareFile));
                    try {
                        properties.store(bufferedOutputStream, (String) null);
                        l = false;
                        TbsDownloadConfig.getInstance(f38789a).setDownloadInterruptCode(ResponseInfo.Crc32NotMatch);
                        try {
                            bufferedInputStream.close();
                        } catch (Exception e3) {
                            e3.printStackTrace();
                        }
                        bufferedOutputStream.close();
                    } catch (Throwable th) {
                        th = th;
                        try {
                            th.printStackTrace();
                            if (bufferedInputStream != null) {
                                try {
                                    bufferedInputStream.close();
                                } catch (Exception e4) {
                                    e4.printStackTrace();
                                }
                            }
                            if (bufferedOutputStream != null) {
                                bufferedOutputStream.close();
                            }
                        } catch (Throwable th2) {
                            if (bufferedInputStream != null) {
                                try {
                                    bufferedInputStream.close();
                                } catch (Exception e5) {
                                    e5.printStackTrace();
                                }
                            }
                            if (bufferedOutputStream != null) {
                                try {
                                    bufferedOutputStream.close();
                                } catch (Exception e6) {
                                    e6.printStackTrace();
                                }
                            }
                            throw th2;
                        }
                    }
                } catch (Throwable th3) {
                    th = th3;
                    bufferedOutputStream = null;
                }
            } catch (Throwable th4) {
                th = th4;
                bufferedOutputStream = null;
                bufferedInputStream = null;
            }
        } catch (Exception e7) {
            e7.printStackTrace();
        }
    }
}
