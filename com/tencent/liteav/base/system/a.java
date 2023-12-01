package com.tencent.liteav.base.system;

import android.content.Context;
import android.content.pm.PackageInfo;
import com.tencent.liteav.base.ContextUtils;
import com.tencent.liteav.base.util.p;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/liteav/base/system/a.class */
final class a {

    /* renamed from: a  reason: collision with root package name */
    private static final p<PackageInfo> f22614a = new p<>(b.a());

    public static String a() {
        PackageInfo a2 = f22614a.a();
        return a2 == null ? "" : a2.packageName;
    }

    public static String b() {
        PackageInfo a2;
        Context applicationContext = ContextUtils.getApplicationContext();
        return (applicationContext == null || (a2 = f22614a.a()) == null) ? "" : applicationContext.getPackageManager().getApplicationLabel(a2.applicationInfo).toString();
    }

    public static String c() {
        PackageInfo a2 = f22614a.a();
        return a2 == null ? "" : a2.versionName;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ PackageInfo d() throws Exception {
        Context applicationContext = ContextUtils.getApplicationContext();
        if (applicationContext == null) {
            return null;
        }
        return applicationContext.getPackageManager().getPackageInfo(applicationContext.getPackageName(), 0);
    }
}
