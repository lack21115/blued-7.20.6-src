package com.soft.blued.ui.feed.activity;

import android.content.Context;
import android.os.Bundle;
import android.view.MotionEvent;
import androidx.fragment.app.Fragment;
import com.blued.android.core.ui.TerminalActivity;
import com.soft.blued.ui.feed.manager.IDispatchTouchEvent;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/feed/activity/ClipBgActivity.class */
public class ClipBgActivity extends TerminalActivity {
    private List<IDispatchTouchEvent> d = new ArrayList();

    public static TerminalActivity.WrapIntent a(Context context, Class<? extends Fragment> cls, Bundle bundle) {
        return new TerminalActivity.WrapIntent(context, cls, bundle, ClipBgActivity.class);
    }

    public static void b(Fragment fragment, Class<? extends Fragment> cls, Bundle bundle, int i) {
        a(fragment.getActivity(), cls, bundle).a(i, fragment);
    }

    public void a(IDispatchTouchEvent iDispatchTouchEvent) {
        this.d.add(iDispatchTouchEvent);
    }

    public void b(IDispatchTouchEvent iDispatchTouchEvent) {
        this.d.remove(iDispatchTouchEvent);
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        List<IDispatchTouchEvent> list = this.d;
        if (list != null) {
            for (IDispatchTouchEvent iDispatchTouchEvent : list) {
                iDispatchTouchEvent.a(motionEvent);
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }
}
