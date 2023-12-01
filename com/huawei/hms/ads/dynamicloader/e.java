package com.huawei.hms.ads.dynamicloader;

import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Build;
import android.text.TextUtils;
import com.huawei.hms.ads.uiengineloader.aa;
import com.huawei.hms.ads.uiengineloader.w;
import java.util.Arrays;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/hms/ads/dynamicloader/e.class */
public class e extends a {

    /* renamed from: c  reason: collision with root package name */
    private static final String f22470c = "DynamicContext";
    private static final ThreadLocal<ApplicationInfo> d = new ThreadLocal<>();

    /* renamed from: a  reason: collision with root package name */
    final PackageInfo f22471a;
    final String b;
    private final ClassLoader e;
    private final Resources f;
    private final Resources g;

    public e(Context context, String str, int i) {
        super(context);
        this.f22471a = getBaseContext().getPackageManager().getPackageArchiveInfo(str, 128);
        this.e = (Build.VERSION.SDK_INT < 21 ? new com.huawei.hms.ads.uiengineloader.h() : (w.a() && com.huawei.hms.ads.uiengineloader.i.a(context)) ? new com.huawei.hms.ads.uiengineloader.i() : new com.huawei.hms.ads.uiengineloader.j()).a(context, str, i, this.f22471a);
        this.g = a(str);
        this.f = context.getResources();
        this.b = str;
        aa.b(f22470c, "Create dynamicContext success.");
    }

    private PackageInfo a() {
        return this.f22471a;
    }

    private Resources a(String str) {
        this.f22471a.applicationInfo.publicSourceDir = str;
        this.f22471a.applicationInfo.sourceDir = str;
        try {
            return getBaseContext().getPackageManager().getResourcesForApplication(this.f22471a.applicationInfo);
        } catch (PackageManager.NameNotFoundException e) {
            aa.c(f22470c, "NameNotFoundException:" + e.getLocalizedMessage());
            return null;
        }
    }

    private String b() {
        return this.b;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final Context getApplicationContext() {
        return this;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public ApplicationInfo getApplicationInfo() {
        return d.get() != null ? d.get() : super.getApplicationInfo();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final ClassLoader getClassLoader() {
        return this.e;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public String getPackageName() {
        PackageInfo packageInfo = this.f22471a;
        if (packageInfo != null) {
            String str = packageInfo.packageName;
            if (!TextUtils.isEmpty(str)) {
                return str;
            }
        }
        return super.getPackageName();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final Resources getResources() {
        Resources resources = this.g;
        Resources resources2 = resources;
        if (resources == null) {
            resources2 = this.f;
        }
        return resources2;
    }

    @Override // com.huawei.hms.ads.dynamicloader.a, android.content.ContextWrapper, android.content.Context
    public final Object getSystemService(String str) {
        if (Arrays.asList(Context.CONNECTIVITY_SERVICE, "location", "wifi", "user").contains(str)) {
            return getBaseContext().getSystemService(str);
        }
        Arrays.asList("sensor").contains(str);
        return super.getSystemService(str);
    }

    @Override // android.content.Context
    public final void registerComponentCallbacks(ComponentCallbacks componentCallbacks) {
        super.getApplicationContext().registerComponentCallbacks(componentCallbacks);
    }

    @Override // android.content.Context
    public final void unregisterComponentCallbacks(ComponentCallbacks componentCallbacks) {
        super.getApplicationContext().unregisterComponentCallbacks(componentCallbacks);
    }
}
