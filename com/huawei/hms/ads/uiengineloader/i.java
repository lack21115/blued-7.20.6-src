package com.huawei.hms.ads.uiengineloader;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.os.Build;
import android.text.TextUtils;
import java.io.File;
import java.util.HashSet;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/uiengineloader/i.class */
public final class i implements f {

    /* renamed from: a  reason: collision with root package name */
    private static final String f22553a = "HMSClassLoaderStrategy";
    private static final String b = "com.huawei.hwid";

    /* renamed from: c  reason: collision with root package name */
    private static final String f22554c = "com.huawei.hms.core.service.HMSCoreService";
    private static final String d = "lib";
    private static final String e = "arm64";
    private static final HashSet<String> f = new HashSet<String>() { // from class: com.huawei.hms.ads.uiengineloader.i.1
        {
            add("com.huawei.hwid");
            add("com.huawei.hms");
            add("com.huawei.hwid.tv");
        }
    };

    public static boolean a(Context context) {
        String str;
        String packageName = context.getPackageName();
        aa.b(f22553a, "The pkg name of clientContext is:".concat(String.valueOf(packageName)));
        if (!a(context, packageName)) {
            if (context instanceof ContextWrapper) {
                Context baseContext = ((ContextWrapper) context).getBaseContext();
                String packageName2 = baseContext.getPackageName();
                aa.b(f22553a, "The pkg name of baseContext is:".concat(String.valueOf(packageName2)));
                str = a(baseContext, packageName2) ? "The base context is HMS context, cp is HMS." : "The base context is HMS context, cp is HMS.";
            }
            aa.b(f22553a, "The cp is not HMS.");
            return false;
        }
        str = "The context is HMS context, cp is HMS.";
        aa.b(f22553a, str);
        return true;
    }

    private static boolean a(Context context, String str) {
        String str2;
        if (TextUtils.isEmpty(str)) {
            aa.b(f22553a, "Get pkg name failed: null.");
            return false;
        }
        if (f.contains(str)) {
            str2 = "The pkgName belongs to HMS pkg names, the cp is HMS.";
        } else if (!str.startsWith("com.huawei.hwid")) {
            aa.b(f22553a, "The pkg does not start with HMS prefix.");
            return false;
        } else {
            try {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 4);
                if (packageInfo == null) {
                    aa.c(f22553a, "Get callPackage packageInfo failed: null.");
                    return false;
                }
                ServiceInfo[] serviceInfoArr = packageInfo.services;
                if (serviceInfoArr == null) {
                    aa.c(f22553a, "Get service Info failed: null.");
                    return false;
                }
                int length = serviceInfoArr.length;
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= length) {
                        aa.b(f22553a, "The calling package is not HMS.");
                        return false;
                    } else if (TextUtils.equals(serviceInfoArr[i2].name, f22554c)) {
                        str2 = "Check Service name: The calling package is HMS.";
                        break;
                    } else {
                        i = i2 + 1;
                    }
                }
            } catch (PackageManager.NameNotFoundException e2) {
                aa.c(f22553a, "Get callPackage packageInfo NameNotFoundException.");
                return false;
            }
        }
        aa.b(f22553a, str2);
        return true;
    }

    @Override // com.huawei.hms.ads.uiengineloader.f
    public final ClassLoader a(Context context, String str, int i, PackageInfo packageInfo) {
        String str2 = new File(context.getPackageResourcePath()).getParent() + File.separator + "lib" + File.separator + e;
        aa.b(f22553a, "The api version is:" + Build.VERSION.SDK_INT + ", callingPkg is HMS, use the hmsNativePath.");
        return new com.huawei.hms.ads.dynamicloader.d(str, str2, context.getClassLoader());
    }
}
