package com.soft.blued.customview;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.TranslateAnimation;
import androidx.viewpager.widget.ViewPager;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/customview/BounceBackViewPager.class */
public class BounceBackViewPager extends ViewPager {

    /* renamed from: a  reason: collision with root package name */
    private int f14673a;
    private Rect b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f14674c;
    private float d;

    public BounceBackViewPager(Context context) {
        super(context);
        this.f14673a = 0;
        this.b = new Rect();
        this.f14674c = true;
        this.d = 0.0f;
    }

    public BounceBackViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f14673a = 0;
        this.b = new Rect();
        this.f14674c = true;
        this.d = 0.0f;
    }

    private void a() {
        if (this.b.isEmpty()) {
            return;
        }
        b();
    }

    private void a(float f) {
        if (this.b.isEmpty()) {
            this.b.set(getLeft(), getTop(), getRight(), getBottom());
        }
        this.f14674c = false;
        int i = (int) (f * 0.5f);
        layout(getLeft() + i, getTop(), getRight() + i, getBottom());
    }

    private void b() {
        TranslateAnimation translateAnimation = new TranslateAnimation(getLeft(), this.b.left, 0.0f, 0.0f);
        translateAnimation.setDuration(300L);
        startAnimation(translateAnimation);
        layout(this.b.left, this.b.top, this.b.right, this.b.bottom);
        this.b.setEmpty();
        this.f14674c = true;
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.d = motionEvent.getX();
            this.f14673a = getCurrentItem();
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public void onMeasure(int i, int i2) {
        int i3 = 0;
        int i4 = 0;
        while (true) {
            int i5 = i4;
            if (i3 >= getChildCount()) {
                super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(i5, 1073741824));
                return;
            }
            View childAt = getChildAt(i3);
            childAt.measure(i, View.MeasureSpec.makeMeasureSpec(0, 0));
            int measuredHeight = childAt.getMeasuredHeight();
            int i6 = i5;
            if (measuredHeight > i5) {
                i6 = measuredHeight;
            }
            i3++;
            i4 = i6;
        }
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 1) {
            a();
        } else if (action == 2) {
            if (getAdapter().getCount() == 1) {
                float x = motionEvent.getX();
                float f = x - this.d;
                this.d = x;
                if (f > 10.0f) {
                    a(f);
                } else if (f < -10.0f) {
                    a(f);
                } else if (!this.f14674c) {
                    int i = (int) (f * 0.5f);
                    if (getLeft() + i != this.b.left) {
                        layout(getLeft() + i, getTop(), getRight() + i, getBottom());
                    }
                }
            } else {
                int i2 = this.f14673a;
                if (i2 == 0 || i2 == getAdapter().getCount() - 1) {
                    float x2 = motionEvent.getX();
                    float f2 = x2 - this.d;
                    this.d = x2;
                    if (this.f14673a == 0) {
                        if (f2 > 10.0f) {
                            a(f2);
                        } else if (!this.f14674c) {
                            int i3 = (int) (f2 * 0.5f);
                            if (getLeft() + i3 >= this.b.left) {
                                layout(getLeft() + i3, getTop(), getRight() + i3, getBottom());
                            }
                        }
                    } else if (f2 < -10.0f) {
                        a(f2);
                    } else if (!this.f14674c) {
                        int i4 = (int) (f2 * 0.5f);
                        if (getRight() + i4 <= this.b.right) {
                            layout(getLeft() + i4, getTop(), getRight() + i4, getBottom());
                        }
                    }
                } else {
                    this.f14674c = true;
                }
            }
            if (!this.f14674c) {
                return true;
            }
        }
        return super.onTouchEvent(motionEvent);
    }
}
