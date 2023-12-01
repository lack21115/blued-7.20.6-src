package com.sobot.chat.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/widget/SobotEditTextLayout.class */
public class SobotEditTextLayout extends LinearLayout {
    private EditText editText;
    private ScrollView parentScrollview;
    private int showLineMax;

    public SobotEditTextLayout(Context context) {
        super(context);
        this.showLineMax = 0;
    }

    public SobotEditTextLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.showLineMax = 0;
    }

    private void setParentScrollAble(boolean z) {
        this.parentScrollview.requestDisallowInterceptTouchEvent(!z);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.parentScrollview == null) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        if (motionEvent.getAction() == 0 && this.editText.getLineCount() >= this.showLineMax) {
            setParentScrollAble(false);
        } else if (motionEvent.getAction() == 1) {
            setParentScrollAble(true);
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setEditeText(EditText editText) {
        this.editText = editText;
        this.showLineMax = ((LinearLayout.LayoutParams) editText.getLayoutParams()).height / editText.getLineHeight();
    }

    public void setParentScrollview(ScrollView scrollView) {
        this.parentScrollview = scrollView;
    }
}
