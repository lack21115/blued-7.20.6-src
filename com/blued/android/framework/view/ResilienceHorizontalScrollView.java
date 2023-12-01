package com.blued.android.framework.view;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.widget.HorizontalScrollView;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/view/ResilienceHorizontalScrollView.class */
public class ResilienceHorizontalScrollView extends HorizontalScrollView {

    /* renamed from: a  reason: collision with root package name */
    private Rect f10184a;
    private View b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f10185c;
    private boolean d;
    private boolean e;
    private float f;

    public ResilienceHorizontalScrollView(Context context) {
        super(context);
        this.f10184a = new Rect();
        this.f10185c = false;
        this.d = false;
        this.e = false;
    }

    public ResilienceHorizontalScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f10184a = new Rect();
        this.f10185c = false;
        this.d = false;
        this.e = false;
    }

    private boolean a() {
        return this.b.getWidth() <= getWidth() + getScrollX();
    }

    private boolean b() {
        return getScrollX() == 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x0081, code lost:
        if (r6.e != false) goto L21;
     */
    /* JADX WARN: Removed duplicated region for block: B:33:0x008a  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean dispatchTouchEvent(android.view.MotionEvent r7) {
        /*
            Method dump skipped, instructions count: 325
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blued.android.framework.view.ResilienceHorizontalScrollView.dispatchTouchEvent(android.view.MotionEvent):boolean");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        if (getChildCount() > 0) {
            this.b = getChildAt(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        View view = this.b;
        if (view == null) {
            return;
        }
        this.f10184a.set(view.getLeft(), this.b.getTop(), this.b.getRight(), this.b.getBottom());
    }
}
