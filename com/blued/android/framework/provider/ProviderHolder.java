package com.blued.android.framework.provider;

import com.blued.android.core.AppInfo;
import com.blued.android.framework.ui.CorePageCallback;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/framework/provider/ProviderHolder.class */
public class ProviderHolder {

    /* renamed from: a  reason: collision with root package name */
    private static ProviderHolder f9841a;
    private IAppInfoProvider b;

    /* renamed from: c  reason: collision with root package name */
    private IUserInfoProvider f9842c;
    private IStringResourceProvider d;
    private IPageLifecycleProvider e;

    private ProviderHolder() {
    }

    public static ProviderHolder a() {
        if (f9841a == null) {
            synchronized (ProviderHolder.class) {
                try {
                    if (f9841a == null) {
                        f9841a = new ProviderHolder();
                        AppInfo.a(new CorePageCallback());
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f9841a;
    }

    public void a(IAppInfoProvider iAppInfoProvider) {
        this.b = iAppInfoProvider;
    }

    public void a(IPageLifecycleProvider iPageLifecycleProvider) {
        this.e = iPageLifecycleProvider;
    }

    public void a(IStringResourceProvider iStringResourceProvider) {
        this.d = iStringResourceProvider;
    }

    public void a(IUserInfoProvider iUserInfoProvider) {
        this.f9842c = iUserInfoProvider;
    }

    public IUserInfoProvider b() {
        IUserInfoProvider iUserInfoProvider = this.f9842c;
        return iUserInfoProvider != null ? iUserInfoProvider : IUserInfoProvider.f9840a;
    }

    public IStringResourceProvider c() {
        IStringResourceProvider iStringResourceProvider = this.d;
        return iStringResourceProvider != null ? iStringResourceProvider : IStringResourceProvider.f9839a;
    }

    public IPageLifecycleProvider d() {
        IPageLifecycleProvider iPageLifecycleProvider = this.e;
        return iPageLifecycleProvider != null ? iPageLifecycleProvider : IPageLifecycleProvider.f9838a;
    }

    public IAppInfoProvider e() {
        IAppInfoProvider iAppInfoProvider = this.b;
        return iAppInfoProvider != null ? iAppInfoProvider : IAppInfoProvider.f9837a;
    }
}
