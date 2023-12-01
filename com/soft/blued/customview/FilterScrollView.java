package com.soft.blued.customview;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.widget.NestedScrollView;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/customview/FilterScrollView.class */
public class FilterScrollView extends NestedScrollView {

    /* renamed from: a  reason: collision with root package name */
    Rect f14726a;
    int[] b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f14727c;
    private View d;
    private boolean e;

    public FilterScrollView(Context context) {
        super(context);
        this.f14727c = true;
        this.d = null;
        this.e = true;
        this.f14726a = new Rect();
        this.b = new int[2];
    }

    public FilterScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f14727c = true;
        this.d = null;
        this.e = true;
        this.f14726a = new Rect();
        this.b = new int[2];
    }

    public FilterScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f14727c = true;
        this.d = null;
        this.e = true;
        this.f14726a = new Rect();
        this.b = new int[2];
    }

    private boolean a(View view, int i, int i2) {
        view.getDrawingRect(this.f14726a);
        view.getLocationOnScreen(this.b);
        Rect rect = this.f14726a;
        int[] iArr = this.b;
        rect.offset(iArr[0], iArr[1]);
        return this.f14726a.contains(i, i2);
    }

    @Override // androidx.core.widget.NestedScrollView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        setFilterScrollViewTouchEvent(motionEvent);
        if (this.f14727c) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        return false;
    }

    @Override // androidx.core.widget.NestedScrollView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        setFilterScrollViewTouchEvent(motionEvent);
        if (this.f14727c) {
            return super.onTouchEvent(motionEvent);
        }
        return false;
    }

    public void setFilterScrollViewTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 2 && this.e && this.d != null) {
            if (a(this.d, (int) motionEvent.getRawX(), (int) motionEvent.getRawY())) {
                this.f14727c = false;
            }
            this.e = false;
        }
        if ((motionEvent.getAction() == 1 || motionEvent.getAction() == 3) && !this.e) {
            this.f14727c = true;
            this.e = true;
        }
    }

    public void setOnTouchView(View view) {
        this.d = view;
    }

    public void setScrollEnable(boolean z) {
        this.f14727c = z;
    }
}
