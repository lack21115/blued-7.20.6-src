package com.blued.android.framework.ui;

import android.content.Context;
import android.os.Bundle;
import com.blued.android.core.ui.UIPageCallback;
import com.blued.android.framework.provider.ProviderHolder;
import com.blued.android.framework.ui.wrapper.BluedContextWrapper;

/* loaded from: source-8756600-dex2jar.jar:com/blued/android/framework/ui/CorePageCallback.class */
public class CorePageCallback extends UIPageCallback {
    public Context a(Context context) {
        return ProviderHolder.a().d().a(BluedContextWrapper.a(context));
    }

    public void a(Context context, Bundle bundle) {
        ProviderHolder.a().d().a(context, bundle);
    }

    public void a(Bundle bundle) {
        ProviderHolder.a().d().a(bundle);
    }

    public void a(String str) {
        ProviderHolder.a().d().a(str);
    }

    public void b(String str) {
        ProviderHolder.a().d().b(str);
    }
}
