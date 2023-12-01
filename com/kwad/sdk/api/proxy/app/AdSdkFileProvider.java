package com.kwad.sdk.api.proxy.app;

import androidx.core.content.FileProvider;
import com.kwad.sdk.api.core.KSLifecycleObserver;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/api/proxy/app/AdSdkFileProvider.class */
public class AdSdkFileProvider extends FileProvider {
    public static long sLaunchTime;

    @Override // androidx.core.content.FileProvider, android.content.ContentProvider
    public boolean onCreate() {
        sLaunchTime = System.currentTimeMillis();
        try {
            KSLifecycleObserver.getInstance().init(getContext().getApplicationContext());
        } catch (Throwable th) {
        }
        return super.onCreate();
    }
}
