package com.blued.android.framework.view.stickylistheaders;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/view/stickylistheaders/WrapperView.class */
public class WrapperView extends ViewGroup {
    View a;
    Drawable b;
    int c;
    View d;
    int e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public WrapperView(Context context) {
        super(context);
    }

    public boolean a() {
        return this.d != null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.d != null || this.b == null || this.a.getVisibility() == 8) {
            return;
        }
        if (Build.VERSION.SDK_INT < 11) {
            canvas.clipRect(0, 0, getWidth(), this.c);
        }
        this.b.draw(canvas);
    }

    public View getHeader() {
        return this.d;
    }

    public View getItem() {
        return this.a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int width = getWidth();
        int height = getHeight();
        View view = this.d;
        if (view != null) {
            int measuredHeight = view.getMeasuredHeight();
            this.d.layout(0, 0, width, measuredHeight);
            this.e = measuredHeight;
            this.a.layout(0, measuredHeight, width, height);
            return;
        }
        Drawable drawable = this.b;
        if (drawable == null) {
            this.e = 0;
            this.a.layout(0, 0, width, height);
            return;
        }
        drawable.setBounds(0, 0, width, this.c);
        int i5 = this.c;
        this.e = i5;
        this.a.layout(0, i5, width, height);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        int i3;
        int measuredHeight;
        int size = View.MeasureSpec.getSize(i);
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(size, 1073741824);
        View view = this.d;
        if (view != null) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams == null || layoutParams.height <= 0) {
                this.d.measure(makeMeasureSpec, View.MeasureSpec.makeMeasureSpec(0, 0));
            } else {
                this.d.measure(makeMeasureSpec, View.MeasureSpec.makeMeasureSpec(layoutParams.height, 1073741824));
            }
            i3 = this.d.getMeasuredHeight() + 0;
        } else {
            i3 = (this.b == null || this.a.getVisibility() == 8) ? 0 : this.c + 0;
        }
        ViewGroup.LayoutParams layoutParams2 = this.a.getLayoutParams();
        if (this.a.getVisibility() == 8) {
            this.a.measure(makeMeasureSpec, View.MeasureSpec.makeMeasureSpec(0, 1073741824));
        } else {
            if (layoutParams2 == null || layoutParams2.height < 0) {
                this.a.measure(makeMeasureSpec, View.MeasureSpec.makeMeasureSpec(0, 0));
                measuredHeight = this.a.getMeasuredHeight();
            } else {
                this.a.measure(makeMeasureSpec, View.MeasureSpec.makeMeasureSpec(layoutParams2.height, 1073741824));
                measuredHeight = this.a.getMeasuredHeight();
            }
            i3 += measuredHeight;
        }
        setMeasuredDimension(size, i3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void update(View view, View view2, Drawable drawable, int i) {
        if (view == null) {
            throw new NullPointerException("List view item must not be null.");
        }
        View view3 = this.a;
        if (view3 != view) {
            removeView(view3);
            this.a = view;
            ViewParent parent = view.getParent();
            if (parent != null && parent != this && (parent instanceof ViewGroup)) {
                ((ViewGroup) parent).removeView(view);
            }
            addView(view);
        }
        View view4 = this.d;
        if (view4 != view2) {
            if (view4 != null) {
                removeView(view4);
            }
            this.d = view2;
            if (view2 != null) {
                addView(view2);
            }
        }
        if (this.b != drawable) {
            this.b = drawable;
            this.c = i;
            invalidate();
        }
    }
}
