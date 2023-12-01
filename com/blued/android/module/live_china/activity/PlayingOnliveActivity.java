package com.blued.android.module.live_china.activity;

import android.content.Context;
import android.os.Bundle;
import android.view.MotionEvent;
import androidx.fragment.app.Fragment;
import com.blued.android.core.ui.BaseDialogFragment;
import com.blued.android.core.ui.BaseFragment;
import com.blued.android.core.ui.TerminalActivity;
import com.blued.android.framework.utils.LogUtils;
import com.blued.android.module.live_china.live_interface.IDispatchTouchEvent;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/activity/PlayingOnliveActivity.class */
public class PlayingOnliveActivity extends TerminalActivity {
    private List<IDispatchTouchEvent> d = new ArrayList();

    public static TerminalActivity.WrapIntent a(Context context, Class<? extends Fragment> cls, Bundle bundle) {
        return new TerminalActivity.WrapIntent(context, cls, bundle, PlayingOnliveActivity.class);
    }

    public static void b(Context context, Class<? extends Fragment> cls, Bundle bundle) {
        a(context, cls, bundle).b();
    }

    public void a(IDispatchTouchEvent iDispatchTouchEvent) {
        this.d.add(iDispatchTouchEvent);
    }

    public void b(IDispatchTouchEvent iDispatchTouchEvent) {
        this.d.remove(iDispatchTouchEvent);
    }

    @Override // androidx.core.app.ComponentActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        List<IDispatchTouchEvent> list = this.d;
        if (list != null) {
            for (IDispatchTouchEvent iDispatchTouchEvent : list) {
                iDispatchTouchEvent.a(motionEvent);
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // com.blued.android.core.ui.TerminalActivity, com.blued.android.core.ui.BaseFragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        boolean z;
        int size = getSupportFragmentManager().getFragments().size() - 1;
        boolean z2 = false;
        while (true) {
            z = z2;
            if (size < 0) {
                break;
            }
            Fragment fragment = getSupportFragmentManager().getFragments().get(size);
            LogUtils.c(fragment.getClass().getSimpleName());
            if (fragment instanceof BaseFragment) {
                z2 = ((BaseFragment) fragment).onBackPressed();
            } else if (fragment instanceof BaseDialogFragment) {
                z2 = ((BaseDialogFragment) fragment).onBackPressed();
            }
            if (z2) {
                z = z2;
                break;
            }
            size--;
        }
        if (z) {
            return;
        }
        super.onBackPressed();
    }
}
