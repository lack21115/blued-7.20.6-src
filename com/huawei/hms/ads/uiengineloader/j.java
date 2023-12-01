package com.huawei.hms.ads.uiengineloader;

import android.content.Context;
import android.content.pm.PackageInfo;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/uiengineloader/j.class */
public final class j implements f {

    /* renamed from: a  reason: collision with root package name */
    private static final String f8947a = "PathClassLoaderStrategy";

    @Override // com.huawei.hms.ads.uiengineloader.f
    public final ClassLoader a(Context context, String str, int i, PackageInfo packageInfo) {
        aa.b(f8947a, "begin to new classloader, armeabiType:".concat(String.valueOf(i)));
        return new com.huawei.hms.ads.dynamicloader.d(e.a(context, str, packageInfo), e.b(context, str, packageInfo), context.getClassLoader());
    }
}
