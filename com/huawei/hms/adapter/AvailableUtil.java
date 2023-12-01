package com.huawei.hms.adapter;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import com.huawei.hms.support.log.HMSLog;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/adapter/AvailableUtil.class */
public class AvailableUtil {

    /* renamed from: a  reason: collision with root package name */
    public static final Object f8804a = new Object();
    public static boolean b = false;

    /* renamed from: c  reason: collision with root package name */
    public static boolean f8805c = false;

    public static boolean isInstallerLibExist(Context context) {
        boolean z;
        if (b) {
            HMSLog.i("AvailableUtil", "installerInit exist: " + f8805c);
            return f8805c;
        }
        synchronized (f8804a) {
            if (!b) {
                PackageManager packageManager = context.getPackageManager();
                if (packageManager == null) {
                    HMSLog.e("AvailableUtil", "In isAvailableLibExist, Failed to get 'PackageManager' instance.");
                    try {
                        Class.forName("com.huawei.hms.update.manager.UpdateManager");
                        z = true;
                    } catch (ClassNotFoundException e) {
                        HMSLog.e("AvailableUtil", "In isInstallerLibExist, Failed to find class UpdateManager.");
                        z = false;
                    }
                    f8805c = z;
                    b = true;
                } else {
                    try {
                        ApplicationInfo applicationInfo = packageManager.getPackageInfo(context.getPackageName(), 128).applicationInfo;
                        z = false;
                        if (applicationInfo != null) {
                            z = false;
                            if (applicationInfo.metaData != null) {
                                Object obj = applicationInfo.metaData.get("availableHMSCoreInstaller");
                                z = false;
                                if (obj != null) {
                                    z = false;
                                    if (String.valueOf(obj).equalsIgnoreCase("yes")) {
                                        HMSLog.i("AvailableUtil", "available exist: true");
                                        z = true;
                                    }
                                }
                            }
                        }
                    } catch (PackageManager.NameNotFoundException e2) {
                        HMSLog.e("AvailableUtil", "In isInstallerLibExist, Failed to read meta data for the availableHMSCoreInstaller.");
                        z = false;
                    } catch (RuntimeException e3) {
                        HMSLog.e("AvailableUtil", "In isInstallerLibExist, Failed to read meta data for the availableHMSCoreInstaller.", e3);
                        z = false;
                    }
                    f8805c = z;
                    b = true;
                }
            }
        }
        HMSLog.i("AvailableUtil", "available exist: " + f8805c);
        return f8805c;
    }
}
