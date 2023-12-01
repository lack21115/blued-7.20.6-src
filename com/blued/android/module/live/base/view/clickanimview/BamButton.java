package com.blued.android.module.live.base.view.clickanimview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.Button;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/live/base/view/clickanimview/BamButton.class */
public class BamButton extends Button {
    public BamButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setClickable(true);
    }

    public BamButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setClickable(true);
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            BamAnim.a(this);
        } else if (action == 1 || action == 3) {
            BamAnim.b(this);
        }
        return super.onTouchEvent(motionEvent);
    }
}
