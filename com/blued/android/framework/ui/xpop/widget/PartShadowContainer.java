package com.blued.android.framework.ui.xpop.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.FrameLayout;
import com.blued.android.framework.ui.xpop.interfaces.OnClickOutsideListener;
import com.blued.android.framework.ui.xpop.util.XPopupUtils;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/ui/xpop/widget/PartShadowContainer.class */
public class PartShadowContainer extends FrameLayout {
    public boolean a;
    private float b;
    private float c;
    private OnClickOutsideListener d;

    public PartShadowContainer(Context context) {
        super(context);
        this.a = true;
    }

    public PartShadowContainer(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PartShadowContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = true;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        OnClickOutsideListener onClickOutsideListener;
        View childAt = getChildAt(0);
        int[] iArr = new int[2];
        childAt.getLocationInWindow(iArr);
        if (XPopupUtils.a(motionEvent.getRawX(), motionEvent.getRawY(), new Rect(iArr[0], iArr[1], iArr[0] + childAt.getMeasuredWidth(), iArr[1] + childAt.getMeasuredHeight()))) {
            return true;
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            this.b = motionEvent.getX();
            this.c = motionEvent.getY();
            return true;
        } else if (action != 1) {
            return true;
        } else {
            if (((float) Math.sqrt(Math.pow(motionEvent.getX() - this.b, 2.0d) + Math.pow(motionEvent.getY() - this.c, 2.0d))) < ViewConfiguration.get(getContext()).getScaledTouchSlop() && this.a && (onClickOutsideListener = this.d) != null) {
                onClickOutsideListener.a();
            }
            this.b = 0.0f;
            this.c = 0.0f;
            return true;
        }
    }

    public void setOnClickOutsideListener(OnClickOutsideListener onClickOutsideListener) {
        this.d = onClickOutsideListener;
    }
}
