package com.sobot.chat.widget.kpswitch.util;

import android.app.Activity;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/widget/kpswitch/util/ViewUtil.class */
public class ViewUtil {
    private static final String TAG = "ViewUtil";

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean isFitsSystemWindows(Activity activity) {
        if (Build.VERSION.SDK_INT >= 16) {
            return ((ViewGroup) activity.findViewById(16908290)).getChildAt(0).getFitsSystemWindows();
        }
        return false;
    }

    public static boolean isFullScreen(Activity activity) {
        return (activity.getWindow().getAttributes().flags & 1024) != 0;
    }

    public static boolean isTranslucentStatus(Activity activity) {
        boolean z = false;
        if (Build.VERSION.SDK_INT >= 19) {
            z = false;
            if ((activity.getWindow().getAttributes().flags & 67108864) != 0) {
                z = true;
            }
        }
        return z;
    }

    public static boolean refreshHeight(View view, int i) {
        if (view.isInEditMode()) {
            return false;
        }
        Log.d(TAG, String.format("refresh Height %d %d", Integer.valueOf(view.getHeight()), Integer.valueOf(i)));
        if (view.getHeight() == i || Math.abs(view.getHeight() - i) == StatusBarHeightUtil.getStatusBarHeight(view.getContext())) {
            return false;
        }
        int validPanelHeight = KeyboardUtil.getValidPanelHeight(view.getContext());
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            view.setLayoutParams(new ViewGroup.LayoutParams(-1, validPanelHeight));
            return true;
        }
        layoutParams.height = validPanelHeight;
        view.requestLayout();
        return true;
    }
}
