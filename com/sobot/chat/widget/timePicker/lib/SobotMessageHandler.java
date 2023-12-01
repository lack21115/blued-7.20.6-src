package com.sobot.chat.widget.timePicker.lib;

import android.os.Handler;
import android.os.Message;
import com.sobot.chat.widget.timePicker.lib.SobotWheelView;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/widget/timePicker/lib/SobotMessageHandler.class */
final class SobotMessageHandler extends Handler {
    public static final int WHAT_INVALIDATE_LOOP_VIEW = 1000;
    public static final int WHAT_ITEM_SELECTED = 3000;
    public static final int WHAT_SMOOTH_SCROLL = 2000;
    final SobotWheelView loopview;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SobotMessageHandler(SobotWheelView sobotWheelView) {
        this.loopview = sobotWheelView;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        int i = message.what;
        if (i == 1000) {
            this.loopview.invalidate();
        } else if (i == 2000) {
            this.loopview.smoothScroll(SobotWheelView.ACTION.FLING);
        } else if (i != 3000) {
        } else {
            this.loopview.onItemSelected();
        }
    }
}
