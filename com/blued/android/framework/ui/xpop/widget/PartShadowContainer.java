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

    /* renamed from: a  reason: collision with root package name */
    public boolean f10036a;
    private float b;

    /* renamed from: c  reason: collision with root package name */
    private float f10037c;
    private OnClickOutsideListener d;

    public PartShadowContainer(Context context) {
        super(context);
        this.f10036a = true;
    }

    public PartShadowContainer(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PartShadowContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f10036a = true;
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
            this.f10037c = motionEvent.getY();
            return true;
        } else if (action != 1) {
            return true;
        } else {
            if (((float) Math.sqrt(Math.pow(motionEvent.getX() - this.b, 2.0d) + Math.pow(motionEvent.getY() - this.f10037c, 2.0d))) < ViewConfiguration.get(getContext()).getScaledTouchSlop() && this.f10036a && (onClickOutsideListener = this.d) != null) {
                onClickOutsideListener.a();
            }
            this.b = 0.0f;
            this.f10037c = 0.0f;
            return true;
        }
    }

    public void setOnClickOutsideListener(OnClickOutsideListener onClickOutsideListener) {
        this.d = onClickOutsideListener;
    }
}
