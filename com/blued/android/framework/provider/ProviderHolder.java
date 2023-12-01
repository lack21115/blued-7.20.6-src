package com.blued.android.framework.provider;

import com.blued.android.core.AppInfo;
import com.blued.android.core.ui.UIPageCallback;
import com.blued.android.framework.ui.CorePageCallback;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/framework/provider/ProviderHolder.class */
public class ProviderHolder {
    private static ProviderHolder a;
    private IAppInfoProvider b;
    private IUserInfoProvider c;
    private IStringResourceProvider d;
    private IPageLifecycleProvider e;

    private ProviderHolder() {
    }

    public static ProviderHolder a() {
        if (a == null) {
            synchronized (ProviderHolder.class) {
                try {
                    if (a == null) {
                        a = new ProviderHolder();
                        AppInfo.a((UIPageCallback) new CorePageCallback());
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return a;
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
        this.c = iUserInfoProvider;
    }

    public IUserInfoProvider b() {
        IUserInfoProvider iUserInfoProvider = this.c;
        return iUserInfoProvider != null ? iUserInfoProvider : IUserInfoProvider.a;
    }

    public IStringResourceProvider c() {
        IStringResourceProvider iStringResourceProvider = this.d;
        return iStringResourceProvider != null ? iStringResourceProvider : IStringResourceProvider.a;
    }

    public IPageLifecycleProvider d() {
        IPageLifecycleProvider iPageLifecycleProvider = this.e;
        return iPageLifecycleProvider != null ? iPageLifecycleProvider : IPageLifecycleProvider.a;
    }

    public IAppInfoProvider e() {
        IAppInfoProvider iAppInfoProvider = this.b;
        return iAppInfoProvider != null ? iAppInfoProvider : IAppInfoProvider.a;
    }
}
