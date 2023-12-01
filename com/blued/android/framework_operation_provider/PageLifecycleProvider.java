package com.blued.android.framework_operation_provider;

import android.content.Context;
import android.os.Bundle;
import com.blued.android.core.imagecache.RecyclingImageLoader;
import com.blued.android.framework.provider.IPageLifecycleProvider;
import com.soft.blued.ui.live.view.VideoChatHintToast;
import com.umeng.analytics.MobclickAgent;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework_operation_provider/PageLifecycleProvider.class */
public class PageLifecycleProvider implements IPageLifecycleProvider {
    @Override // com.blued.android.framework.provider.IPageLifecycleProvider
    public Context a(Context context) {
        return context;
    }

    @Override // com.blued.android.framework.provider.IPageLifecycleProvider
    public void a(Context context, Bundle bundle) {
        VideoChatHintToast.b(context, bundle);
    }

    @Override // com.blued.android.framework.provider.IPageLifecycleProvider
    public void a(Bundle bundle) {
        VideoChatHintToast.b(bundle);
    }

    @Override // com.blued.android.framework.provider.IPageLifecycleProvider
    public void a(String str) {
        RecyclingImageLoader.c();
        MobclickAgent.onPageStart(str);
    }

    @Override // com.blued.android.framework.provider.IPageLifecycleProvider
    public void b(String str) {
        MobclickAgent.onPageEnd(str);
    }
}
