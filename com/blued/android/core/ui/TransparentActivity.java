package com.blued.android.core.ui;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import androidx.fragment.app.Fragment;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.core.utils.Log;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/core/ui/TransparentActivity.class */
public class TransparentActivity extends TerminalActivity {
    private Handler d = new Handler();
    private ILoadFinishedListener e;

    /* loaded from: source-6737240-dex2jar.jar:com/blued/android/core/ui/TransparentActivity$ILoadFinishedListener.class */
    public interface ILoadFinishedListener {
        void a();
    }

    public static TerminalActivity.WrapIntent a(Context context, Class<? extends Fragment> cls, Bundle bundle) {
        return new TerminalActivity.WrapIntent(context, cls, bundle, TransparentActivity.class);
    }

    public static void b(Context context, Class<? extends Fragment> cls, Bundle bundle) {
        a(context, cls, bundle).b();
    }

    public static void b(Context context, Class<? extends Fragment> cls, Bundle bundle, int i) {
        a(context, cls, bundle).a(i);
    }

    public static void b(Fragment fragment, Class<? extends Fragment> cls, Bundle bundle, int i) {
        a((Context) fragment.getActivity(), cls, bundle).a(i, fragment);
    }

    @Override // com.blued.android.core.ui.TerminalActivity, com.blued.android.core.ui.BaseFragmentActivity
    public void onCreate(Bundle bundle) {
        Log.c("PendingActivity", "onCreate");
        super.onCreate(bundle);
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
    }

    @Override // com.blued.android.core.ui.BaseFragmentActivity
    public void onDestroy() {
        Log.c("PendingActivity", "onDestory");
        super.onDestroy();
    }

    @Override // com.blued.android.core.ui.TerminalActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        ILoadFinishedListener iLoadFinishedListener = this.e;
        if (iLoadFinishedListener != null) {
            iLoadFinishedListener.a();
        }
    }
}
