package com.blued.android.module.shortvideo.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.appcompat.widget.AppCompatSeekBar;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/shortvideo/view/TrimSeekBar.class */
public class TrimSeekBar extends AppCompatSeekBar {
    private static int a = 150;

    public TrimSeekBar(Context context) {
        super(context);
    }

    public TrimSeekBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public TrimSeekBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int i = getThumb().getBounds().left - a;
        int i2 = i;
        if (i < 0) {
            i2 = 0;
        }
        int i3 = getThumb().getBounds().right;
        int i4 = a;
        int x = (int) motionEvent.getX();
        if (motionEvent.getAction() != 0 || (x > i2 && x < i3 + i4)) {
            return super.onTouchEvent(motionEvent);
        }
        return false;
    }
}
