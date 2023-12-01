package com.ss.android.socialbase.appdownloader.u.mb;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.monitor.IDownloadMonitorListener;
import com.ss.android.socialbase.downloader.utils.DownloadExpSwitchCode;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8457232-dex2jar.jar:com/ss/android/socialbase/appdownloader/u/mb/h.class */
public class h {
    public static PackageInfo mb(Context context, File file, int i) {
        if (!DownloadExpSwitchCode.isSwitchEnable(268435456) || Build.VERSION.SDK_INT < 21 || Build.VERSION.SDK_INT >= 26) {
            return ox(context, file, i);
        }
        try {
            return mb(file);
        } catch (Throwable th) {
            mb("getPackageInfo::unzip_getpackagearchiveinfo", th.getMessage());
            return ox(context, file, i);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x00cc, code lost:
        r14 = r5;
        r5 = r0.getInputStream(r5);
     */
    /* JADX WARN: Finally extract failed */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v12 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.content.pm.PackageInfo mb(java.io.File r5) {
        /*
            Method dump skipped, instructions count: 812
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.appdownloader.u.mb.h.mb(java.io.File):android.content.pm.PackageInfo");
    }

    private static String mb(int i) {
        return (i >>> 24) == 1 ? "android:" : "";
    }

    public static String mb(Context context, PackageInfo packageInfo, String str) {
        if (packageInfo == null || packageInfo.applicationInfo == null) {
            return null;
        }
        ApplicationInfo applicationInfo = packageInfo.applicationInfo;
        applicationInfo.sourceDir = str;
        applicationInfo.publicSourceDir = str;
        try {
            return applicationInfo.loadLabel(context.getPackageManager()).toString();
        } catch (OutOfMemoryError e) {
            mb("getPackageInfo::fail_load_label", e.getMessage());
            return null;
        }
    }

    private static String mb(mb mbVar, int i) {
        int ox = mbVar.ox(i);
        int b = mbVar.b(i);
        return ox == 3 ? mbVar.hj(i) : ox == 2 ? String.format("?%s%08X", mb(b), Integer.valueOf(b)) : (ox < 16 || ox > 31) ? String.format("<0x%X, type 0x%02X>", Integer.valueOf(b), Integer.valueOf(ox)) : String.valueOf(b);
    }

    private static void mb(String str, String str2) {
        IDownloadMonitorListener downloadMonitorListener = DownloadComponentManager.getDownloadMonitorListener();
        if (downloadMonitorListener == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("message", str2);
        } catch (JSONException e) {
        }
        downloadMonitorListener.monitorEvent(str, jSONObject, null, null);
    }

    private static PackageInfo ox(Context context, File file, int i) {
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            mb("unzip_getpackagearchiveinfo", "packageManager == null");
            return null;
        }
        try {
            return packageManager.getPackageArchiveInfo(file.getPath(), i);
        } catch (Throwable th) {
            mb("unzip_getpackagearchiveinfo", "pm.getPackageArchiveInfo failed: " + th.getMessage());
            return null;
        }
    }
}
