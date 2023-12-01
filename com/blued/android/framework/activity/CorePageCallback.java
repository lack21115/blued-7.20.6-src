package com.blued.android.framework.activity;

import android.content.Context;
import android.content.ContextWrapper;
import android.os.Bundle;
import com.blued.android.core.AppInfo;
import com.blued.android.core.ui.UIPageCallback;
import com.blued.android.framework.activity.wrapper.BluedContextWrapper;
import com.blued.android.framework.provider.ProviderHolder;
import io.github.inflationx.viewpump.ViewPumpContextWrapper;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/framework/activity/CorePageCallback.class */
public class CorePageCallback extends UIPageCallback {
    @Override // com.blued.android.core.ui.UIPageCallback
    public Context a(Context context) {
        ContextWrapper a = BluedContextWrapper.a(context);
        return AppInfo.o() ? ViewPumpContextWrapper.wrap(a) : super.a(a);
    }

    @Override // com.blued.android.core.ui.UIPageCallback
    public void a(Context context, int i, String[] strArr, int[] iArr) {
    }

    @Override // com.blued.android.core.ui.UIPageCallback
    public void a(Context context, Bundle bundle) {
        ProviderHolder.a().d().a(context, bundle);
    }

    @Override // com.blued.android.core.ui.UIPageCallback
    public void a(Bundle bundle) {
        ProviderHolder.a().d().a(bundle);
    }

    @Override // com.blued.android.core.ui.UIPageCallback
    public void a(String str) {
        ProviderHolder.a().d().a(str);
    }

    @Override // com.blued.android.core.ui.UIPageCallback
    public void b(String str) {
        ProviderHolder.a().d().b(str);
    }
}
