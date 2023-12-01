package com.huawei.hms.ads.uiengineloader;

import android.content.Context;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/uiengineloader/l.class */
public class l extends k {

    /* renamed from: a  reason: collision with root package name */
    public static final String f22556a = l.class.getSimpleName();

    @Override // com.huawei.hms.ads.uiengineloader.k
    public final void a() {
    }

    @Override // com.huawei.hms.ads.uiengineloader.k
    public final void a(Context context) {
        try {
            context.getClassLoader().loadClass("com.huawei.hms.ads.DynamicModuleInitializer").getDeclaredMethod("initializeModule", Context.class).invoke(null, context);
        } catch (Exception e) {
            aa.b(f22556a, "failed to init Module ".concat(String.valueOf(e)));
        }
    }
}
