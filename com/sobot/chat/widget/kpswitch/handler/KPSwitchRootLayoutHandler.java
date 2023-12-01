package com.sobot.chat.widget.kpswitch.handler;

import android.app.Activity;
import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import com.sobot.chat.widget.kpswitch.IPanelConflictLayout;
import com.sobot.chat.widget.kpswitch.util.KeyboardUtil;
import com.sobot.chat.widget.kpswitch.util.StatusBarHeightUtil;
import com.sobot.chat.widget.kpswitch.util.ViewUtil;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/widget/kpswitch/handler/KPSwitchRootLayoutHandler.class */
public class KPSwitchRootLayoutHandler {
    private static final String TAG = "KPSRootLayoutHandler";
    private final boolean mIsTranslucentStatus;
    private int mOldHeight = -1;
    private IPanelConflictLayout mPanelLayout;
    private final int mStatusBarHeight;
    private final View mTargetRootView;

    public KPSwitchRootLayoutHandler(View view) {
        this.mTargetRootView = view;
        this.mStatusBarHeight = StatusBarHeightUtil.getStatusBarHeight(view.getContext());
        this.mIsTranslucentStatus = ViewUtil.isTranslucentStatus((Activity) view.getContext());
    }

    private IPanelConflictLayout getPanelLayout(View view) {
        IPanelConflictLayout iPanelConflictLayout = this.mPanelLayout;
        if (iPanelConflictLayout != null) {
            return iPanelConflictLayout;
        }
        if (view instanceof IPanelConflictLayout) {
            IPanelConflictLayout iPanelConflictLayout2 = (IPanelConflictLayout) view;
            this.mPanelLayout = iPanelConflictLayout2;
            return iPanelConflictLayout2;
        } else if (!(view instanceof ViewGroup)) {
            return null;
        } else {
            int i = 0;
            while (true) {
                int i2 = i;
                ViewGroup viewGroup = (ViewGroup) view;
                if (i2 >= viewGroup.getChildCount()) {
                    return null;
                }
                IPanelConflictLayout panelLayout = getPanelLayout(viewGroup.getChildAt(i2));
                if (panelLayout != null) {
                    this.mPanelLayout = panelLayout;
                    return panelLayout;
                }
                i = i2 + 1;
            }
        }
    }

    public void handleBeforeMeasure(int i, int i2) {
        int i3 = i2;
        if (this.mIsTranslucentStatus) {
            i3 = i2;
            if (Build.VERSION.SDK_INT >= 16) {
                i3 = i2;
                if (this.mTargetRootView.getFitsSystemWindows()) {
                    Rect rect = new Rect();
                    this.mTargetRootView.getWindowVisibleDisplayFrame(rect);
                    i3 = rect.bottom - rect.top;
                }
            }
        }
        if (i3 < 0) {
            return;
        }
        int i4 = this.mOldHeight;
        if (i4 < 0) {
            this.mOldHeight = i3;
            return;
        }
        int i5 = i4 - i3;
        if (i5 == 0 || Math.abs(i5) == this.mStatusBarHeight) {
            return;
        }
        this.mOldHeight = i3;
        IPanelConflictLayout panelLayout = getPanelLayout(this.mTargetRootView);
        if (panelLayout != null && Math.abs(i5) >= KeyboardUtil.getMinKeyboardHeight(this.mTargetRootView.getContext())) {
            if (i5 > 0) {
                panelLayout.handleHide();
            } else if (panelLayout.isKeyboardShowing() && panelLayout.isVisible()) {
                panelLayout.handleShow();
            }
        }
    }
}
