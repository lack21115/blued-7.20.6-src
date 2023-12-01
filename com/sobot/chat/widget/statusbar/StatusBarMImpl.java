package com.sobot.chat.widget.statusbar;

import android.view.View;
import android.view.Window;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/widget/statusbar/StatusBarMImpl.class */
class StatusBarMImpl implements IStatusBar {
    @Override // com.sobot.chat.widget.statusbar.IStatusBar
    public void setStatusBarColor(Window window, int i) {
        window.clearFlags(67108864);
        window.addFlags(Integer.MIN_VALUE);
        window.setStatusBarColor(i);
        View findViewById = window.findViewById(16908290);
        if (findViewById != null) {
            findViewById.setForeground(null);
        }
    }
}
