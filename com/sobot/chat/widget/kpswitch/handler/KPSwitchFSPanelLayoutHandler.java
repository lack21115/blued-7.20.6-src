package com.sobot.chat.widget.kpswitch.handler;

import android.view.View;
import android.view.Window;
import com.sobot.chat.widget.kpswitch.IFSPanelConflictLayout;
import com.sobot.chat.widget.kpswitch.util.KeyboardUtil;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/widget/kpswitch/handler/KPSwitchFSPanelLayoutHandler.class */
public class KPSwitchFSPanelLayoutHandler implements IFSPanelConflictLayout {
    private boolean isKeyboardShowing;
    private final View panelLayout;
    private View recordedFocusView;

    public KPSwitchFSPanelLayoutHandler(View view) {
        this.panelLayout = view;
    }

    private void restoreFocusView() {
        this.panelLayout.setVisibility(4);
        KeyboardUtil.showKeyboard(this.recordedFocusView);
    }

    private void saveFocusView(View view) {
        this.recordedFocusView = view;
        view.clearFocus();
        this.panelLayout.setVisibility(8);
    }

    public void onKeyboardShowing(boolean z) {
        this.isKeyboardShowing = z;
        if (!z && this.panelLayout.getVisibility() == 4) {
            this.panelLayout.setVisibility(8);
        }
        if (z || this.recordedFocusView == null) {
            return;
        }
        restoreFocusView();
        this.recordedFocusView = null;
    }

    @Override // com.sobot.chat.widget.kpswitch.IFSPanelConflictLayout
    public void recordKeyboardStatus(Window window) {
        View currentFocus = window.getCurrentFocus();
        if (currentFocus == null) {
            return;
        }
        if (this.isKeyboardShowing) {
            saveFocusView(currentFocus);
        } else {
            currentFocus.clearFocus();
        }
    }
}
