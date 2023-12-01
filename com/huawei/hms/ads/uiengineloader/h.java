package com.huawei.hms.ads.uiengineloader;

import android.content.Context;
import android.content.pm.PackageInfo;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/uiengineloader/h.class */
public final class h implements f {

    /* renamed from: a  reason: collision with root package name */
    private static final String f22552a = "DexClassLoaderStrategy";

    @Override // com.huawei.hms.ads.uiengineloader.f
    public final ClassLoader a(Context context, String str, int i, PackageInfo packageInfo) {
        aa.b(f22552a, "The android version is below android 5, use dexClassLoader.");
        return new com.huawei.hms.ads.dynamicloader.c(e.a(context, str, packageInfo), context.getFilesDir().getAbsolutePath(), e.b(context, str, packageInfo), context.getClassLoader());
    }
}
