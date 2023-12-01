package com.sobot.chat.widget.timePicker.lib;

import java.util.TimerTask;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/widget/timePicker/lib/SobotSmoothScrollTimerTask.class */
public final class SobotSmoothScrollTimerTask extends TimerTask {
    final SobotWheelView loopView;
    int offset;
    int realTotalOffset = Integer.MAX_VALUE;
    int realOffset = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SobotSmoothScrollTimerTask(SobotWheelView sobotWheelView, int i) {
        this.loopView = sobotWheelView;
        this.offset = i;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        if (this.realTotalOffset == Integer.MAX_VALUE) {
            this.realTotalOffset = this.offset;
        }
        int i = this.realTotalOffset;
        int i2 = (int) (i * 0.1f);
        this.realOffset = i2;
        if (i2 == 0) {
            if (i < 0) {
                this.realOffset = -1;
            } else {
                this.realOffset = 1;
            }
        }
        if (Math.abs(this.realTotalOffset) <= 1) {
            this.loopView.cancelFuture();
            this.loopView.handler.sendEmptyMessage(3000);
            return;
        }
        this.loopView.totalScrollY += this.realOffset;
        if (!this.loopView.isLoop) {
            float f = this.loopView.itemHeight;
            float f2 = -this.loopView.initPosition;
            float itemsCount = (this.loopView.getItemsCount() - 1) - this.loopView.initPosition;
            if (this.loopView.totalScrollY <= f2 * f || this.loopView.totalScrollY >= itemsCount * f) {
                this.loopView.totalScrollY -= this.realOffset;
                this.loopView.cancelFuture();
                this.loopView.handler.sendEmptyMessage(3000);
                return;
            }
        }
        this.loopView.handler.sendEmptyMessage(1000);
        this.realTotalOffset -= this.realOffset;
    }
}
