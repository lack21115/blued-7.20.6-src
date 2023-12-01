package com.huawei.secure.android.common.ssl.util;

import android.content.Context;
import android.content.pm.PackageManager;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/secure/android/common/ssl/util/h.class */
public class h {

    /* renamed from: a  reason: collision with root package name */
    private static final String f23133a = "h";

    public static String a(String str) {
        Context a2 = c.a();
        if (a2 == null) {
            return "";
        }
        try {
            return a2.getPackageManager().getPackageInfo(str, 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            String str2 = f23133a;
            g.b(str2, "getVersion NameNotFoundException : " + e.getMessage());
            return "";
        } catch (Exception e2) {
            String str3 = f23133a;
            g.b(str3, "getVersion: " + e2.getMessage());
            return "";
        } catch (Throwable th) {
            g.b(f23133a, "throwable");
            return "";
        }
    }

    public static int b(String str) {
        Context a2 = c.a();
        if (a2 == null) {
            return 0;
        }
        try {
            return a2.getPackageManager().getPackageInfo(str, 0).versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            g.b(f23133a, "getVersion NameNotFoundException");
            return 0;
        } catch (Exception e2) {
            String str2 = f23133a;
            g.b(str2, "getVersion: " + e2.getMessage());
            return 0;
        }
    }
}
