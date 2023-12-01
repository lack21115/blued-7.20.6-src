package com.blued.android.module.yy_china.view.ban;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/ban/BGAGuideLinkageLayout.class */
public class BGAGuideLinkageLayout extends FrameLayout {
    public BGAGuideLinkageLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public BGAGuideLinkageLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= getChildCount()) {
                return true;
            }
            try {
                getChildAt(i2).dispatchTouchEvent(motionEvent);
            } catch (Exception e) {
                e.printStackTrace();
            }
            i = i2 + 1;
        }
    }
}
