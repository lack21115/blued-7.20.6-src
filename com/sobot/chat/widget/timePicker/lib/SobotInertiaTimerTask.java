package com.sobot.chat.widget.timePicker.lib;

import java.util.TimerTask;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/widget/timePicker/lib/SobotInertiaTimerTask.class */
final class SobotInertiaTimerTask extends TimerTask {

    /* renamed from: a  reason: collision with root package name */
    float f28237a = 2.14748365E9f;
    final SobotWheelView loopView;
    final float velocityY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SobotInertiaTimerTask(SobotWheelView sobotWheelView, float f) {
        this.loopView = sobotWheelView;
        this.velocityY = f;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        float f;
        float f2;
        if (this.f28237a == 2.14748365E9f) {
            if (Math.abs(this.velocityY) <= 2000.0f) {
                this.f28237a = this.velocityY;
            } else if (this.velocityY > 0.0f) {
                this.f28237a = 2000.0f;
            } else {
                this.f28237a = -2000.0f;
            }
        }
        if (Math.abs(this.f28237a) >= 0.0f && Math.abs(this.f28237a) <= 20.0f) {
            this.loopView.cancelFuture();
            this.loopView.handler.sendEmptyMessage(2000);
            return;
        }
        int i = (int) ((this.f28237a * 10.0f) / 1000.0f);
        SobotWheelView sobotWheelView = this.loopView;
        float f3 = sobotWheelView.totalScrollY;
        float f4 = i;
        sobotWheelView.totalScrollY = f3 - f4;
        if (!this.loopView.isLoop) {
            float f5 = this.loopView.itemHeight;
            float f6 = (-this.loopView.initPosition) * f5;
            float itemsCount = ((this.loopView.getItemsCount() - 1) - this.loopView.initPosition) * f5;
            double d = f5 * 0.25d;
            if (this.loopView.totalScrollY - d < f6) {
                f = this.loopView.totalScrollY + f4;
                f2 = itemsCount;
            } else {
                f = f6;
                f2 = itemsCount;
                if (this.loopView.totalScrollY + d > itemsCount) {
                    f2 = this.loopView.totalScrollY + f4;
                    f = f6;
                }
            }
            if (this.loopView.totalScrollY <= f) {
                this.f28237a = 40.0f;
                this.loopView.totalScrollY = (int) f;
            } else if (this.loopView.totalScrollY >= f2) {
                this.loopView.totalScrollY = (int) f2;
                this.f28237a = -40.0f;
            }
        }
        float f7 = this.f28237a;
        if (f7 < 0.0f) {
            this.f28237a = f7 + 20.0f;
        } else {
            this.f28237a = f7 - 20.0f;
        }
        this.loopView.handler.sendEmptyMessage(1000);
    }
}
