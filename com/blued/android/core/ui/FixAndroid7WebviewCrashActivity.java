package com.blued.android.core.ui;

import android.content.Context;
import android.content.res.AssetManager;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.blued.android.core.ui.TerminalActivity;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/core/ui/FixAndroid7WebviewCrashActivity.class */
public class FixAndroid7WebviewCrashActivity extends TerminalActivity {
    public static TerminalActivity.WrapIntent a(Context context, Class<? extends Fragment> cls, Bundle bundle) {
        return new TerminalActivity.WrapIntent(context, cls, bundle, FixAndroid7WebviewCrashActivity.class);
    }

    public static void b(Context context, Class<? extends Fragment> cls, Bundle bundle) {
        a(context, cls, bundle).b();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public AssetManager getAssets() {
        return getResources().getAssets();
    }
}
