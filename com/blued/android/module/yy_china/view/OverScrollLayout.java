package com.blued.android.module.yy_china.view;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.TranslateAnimation;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/OverScrollLayout.class */
public class OverScrollLayout extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    private RecyclerView f17964a;
    private Rect b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f17965c;
    private float d;
    private boolean e;
    private ScrollListener f;

    /* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/view/OverScrollLayout$ScrollListener.class */
    public interface ScrollListener {
        void a();
    }

    public OverScrollLayout(Context context) {
        this(context, null);
    }

    public OverScrollLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public OverScrollLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.b = new Rect();
        this.f17965c = false;
        this.e = false;
    }

    private void a() {
        TranslateAnimation translateAnimation = new TranslateAnimation(this.f17964a.getLeft() - this.b.left, 0.0f, 0.0f, 0.0f);
        translateAnimation.setDuration(400L);
        this.f17964a.startAnimation(translateAnimation);
        this.f17964a.layout(this.b.left, this.b.top, this.b.right, this.b.bottom);
        this.f17965c = false;
    }

    private void a(MotionEvent motionEvent) {
        motionEvent.setAction(3);
        super.dispatchTouchEvent(motionEvent);
    }

    private boolean b() {
        boolean z = false;
        if (((LinearLayoutManager) this.f17964a.getLayoutManager()).findFirstVisibleItemPosition() == 0 || this.f17964a.getAdapter().getItemCount() == 0) {
            if ((this.f17964a.getChildCount() > 0 ? this.f17964a.getChildAt(0).getLeft() : 0) >= 0) {
                z = true;
            }
            return z;
        }
        return false;
    }

    private boolean c() {
        int itemCount = this.f17964a.getAdapter().getItemCount();
        int findLastVisibleItemPosition = ((LinearLayoutManager) this.f17964a.getLayoutManager()).findLastVisibleItemPosition();
        if (findLastVisibleItemPosition >= itemCount - 1) {
            View childAt = this.f17964a.getChildAt(Math.min(findLastVisibleItemPosition - ((LinearLayoutManager) this.f17964a.getLayoutManager()).findFirstVisibleItemPosition(), this.f17964a.getChildCount() - 1));
            return childAt != null && childAt.getRight() <= this.f17964a.getRight() - this.f17964a.getLeft();
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        float x = motionEvent.getX();
        boolean z = true;
        if (x >= this.b.right || x <= this.b.left) {
            if (this.f17965c) {
                a();
                return true;
            }
            return true;
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            this.d = motionEvent.getX();
        } else if (action == 1) {
            if (this.f17965c) {
                a();
            }
            if (this.e) {
                if (super.dispatchTouchEvent(motionEvent)) {
                    return true;
                }
                z = false;
            }
            return z;
        } else if (action != 2) {
            return true;
        }
        int x2 = (int) (motionEvent.getX() - this.d);
        boolean z2 = x2 > 0 && b();
        boolean z3 = x2 < 0 && c();
        if (!z2 && !z3) {
            this.d = motionEvent.getX();
            this.f17965c = false;
            this.e = true;
            return super.dispatchTouchEvent(motionEvent);
        }
        a(motionEvent);
        int i = (int) (x2 * 0.3f);
        this.f17964a.layout(this.b.left + i, this.b.top, this.b.right + i, this.b.bottom);
        ScrollListener scrollListener = this.f;
        if (scrollListener != null) {
            scrollListener.a();
        }
        this.f17965c = true;
        this.e = false;
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        this.f17964a = (RecyclerView) getChildAt(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.b.set(this.f17964a.getLeft(), this.f17964a.getTop(), this.f17964a.getRight(), this.f17964a.getBottom());
    }

    public void setScrollListener(ScrollListener scrollListener) {
        this.f = scrollListener;
    }
}
