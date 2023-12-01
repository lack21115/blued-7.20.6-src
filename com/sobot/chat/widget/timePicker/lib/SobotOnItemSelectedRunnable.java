package com.sobot.chat.widget.timePicker.lib;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/widget/timePicker/lib/SobotOnItemSelectedRunnable.class */
public final class SobotOnItemSelectedRunnable implements Runnable {
    final SobotWheelView loopView;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SobotOnItemSelectedRunnable(SobotWheelView sobotWheelView) {
        this.loopView = sobotWheelView;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.loopView.onItemSelectedListener.onItemSelected(this.loopView.getCurrentItem());
    }
}
