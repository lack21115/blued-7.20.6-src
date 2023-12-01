package com.soft.blued.customview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.blued.android.framework.activity.keyboardpage.KeyboardListenLinearLayout;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/customview/TouchEnableKeyboardLinearLayout.class */
public class TouchEnableKeyboardLinearLayout extends KeyboardListenLinearLayout {

    /* renamed from: a  reason: collision with root package name */
    private boolean f28532a;

    public TouchEnableKeyboardLinearLayout(Context context) {
        super(context);
    }

    public TouchEnableKeyboardLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public TouchEnableKeyboardLinearLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.f28532a) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.f28532a) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setIntercept(boolean z) {
        this.f28532a = z;
    }
}
