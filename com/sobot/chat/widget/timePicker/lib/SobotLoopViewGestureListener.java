package com.sobot.chat.widget.timePicker.lib;

import android.view.GestureDetector;
import android.view.MotionEvent;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/widget/timePicker/lib/SobotLoopViewGestureListener.class */
final class SobotLoopViewGestureListener extends GestureDetector.SimpleOnGestureListener {
    final SobotWheelView loopView;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SobotLoopViewGestureListener(SobotWheelView sobotWheelView) {
        this.loopView = sobotWheelView;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        this.loopView.scrollBy(f2);
        return true;
    }
}
