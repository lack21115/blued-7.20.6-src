package com.sobot.chat.widget.statusbar;

import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/widget/statusbar/StatusBarKitkatImpl.class */
class StatusBarKitkatImpl implements IStatusBar {
    private static final String STATUS_BAR_VIEW_TAG = "ghStatusBarView";

    @Override // com.sobot.chat.widget.statusbar.IStatusBar
    public void setStatusBarColor(Window window, int i) {
        window.addFlags(67108864);
        ViewGroup viewGroup = (ViewGroup) window.getDecorView();
        View findViewWithTag = viewGroup.findViewWithTag(STATUS_BAR_VIEW_TAG);
        StatusBarView statusBarView = findViewWithTag;
        if (findViewWithTag == null) {
            statusBarView = new StatusBarView(window.getContext());
            statusBarView.setTag(STATUS_BAR_VIEW_TAG);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
            layoutParams.gravity = 48;
            statusBarView.setLayoutParams(layoutParams);
            viewGroup.addView(statusBarView);
        }
        statusBarView.setBackgroundColor(i);
        StatusBarCompat.internalSetFitsSystemWindows(window, true);
    }
}
