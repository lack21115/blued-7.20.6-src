package com.soft.blued.ui.find.view;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.RelativeLayout;
import com.blued.android.framework.utils.DensityUtils;
import com.blued.android.module.live_china.manager.LiveFloatManager;
import com.soft.blued.utils.Logger;

/* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/view/FlashDragLayout.class */
public class FlashDragLayout extends RelativeLayout implements GestureDetector.OnGestureListener {
    private static int e = 100;

    /* renamed from: a  reason: collision with root package name */
    GestureDetector f17001a;
    private View b;

    /* renamed from: c  reason: collision with root package name */
    private int f17002c;
    private int d;
    private boolean f;
    private boolean g;
    private int h;
    private float i;
    private int j;
    private OnDragChangedListener k;

    /* loaded from: source-8303388-dex2jar.jar:com/soft/blued/ui/find/view/FlashDragLayout$OnDragChangedListener.class */
    public interface OnDragChangedListener {
        void a(float f);

        void a(int i);
    }

    public FlashDragLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f = true;
        this.h = 0;
        this.i = 100.0f;
        this.f17001a = new GestureDetector(this);
        b();
    }

    private void a(int i) {
        synchronized (this) {
            if (this.b == null) {
                return;
            }
            int x = (int) this.b.getX();
            int i2 = i + x;
            if (i2 <= 0) {
                this.b.setX(0.0f);
            } else if (i2 >= this.f17002c) {
                this.b.setX(this.f17002c);
            } else {
                this.b.setX(i2);
                if (this.k != null) {
                    this.k.a(1.0f - ((x * (this.i / this.f17002c)) / this.i));
                }
            }
        }
    }

    private void b() {
        this.f17002c = LiveFloatManager.a().E();
        this.d = LiveFloatManager.a().F();
        this.j = DensityUtils.a(getContext(), 50.0f);
        setOnTouchListener(new View.OnTouchListener() { // from class: com.soft.blued.ui.find.view.FlashDragLayout.1
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                FlashDragLayout.this.f17001a.onTouchEvent(motionEvent);
                try {
                    if (motionEvent.getAction() == 1) {
                        if (motionEvent.getX() < FlashDragLayout.this.j && motionEvent.getY() < FlashDragLayout.this.j) {
                            FlashDragLayout.this.a();
                        } else if (FlashDragLayout.this.b.getX() > FlashDragLayout.this.f17002c / 2) {
                            FlashDragLayout.this.a(1, 300);
                        } else {
                            FlashDragLayout.this.a(0, 300);
                        }
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                return FlashDragLayout.this.f;
            }
        });
    }

    public void a() {
        int i = this.h;
        if (i == 0) {
            a(0, 300);
        } else if (i == 1) {
            a(1, 300);
        }
    }

    public void a(final int i, int i2) {
        synchronized (this) {
            if (this.g) {
                return;
            }
            this.g = true;
            final int x = (int) this.b.getX();
            int i3 = i == 0 ? 0 : this.f17002c;
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            ofFloat.setInterpolator(new DecelerateInterpolator());
            ofFloat.setDuration(i2);
            final int i4 = i3 - x;
            ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.soft.blued.ui.find.view.FlashDragLayout.2
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    if (FlashDragLayout.this.k != null) {
                        FlashDragLayout.this.k.a(1.0f - ((((i4 * floatValue) + x) * (FlashDragLayout.this.i / FlashDragLayout.this.f17002c)) / FlashDragLayout.this.i));
                    }
                    FlashDragLayout.this.b.setX(((int) (i4 * floatValue)) + x);
                }
            });
            ofFloat.addListener(new Animator.AnimatorListener() { // from class: com.soft.blued.ui.find.view.FlashDragLayout.3
                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    FlashDragLayout.this.b.setX(i == 0 ? 0.0f : FlashDragLayout.this.f17002c);
                    int i5 = 1;
                    int i6 = i == 0 ? 1 : 0;
                    if (FlashDragLayout.this.k != null) {
                        OnDragChangedListener onDragChangedListener = FlashDragLayout.this.k;
                        if (i != 0) {
                            i5 = 0;
                        }
                        onDragChangedListener.a(i5);
                        FlashDragLayout.this.k.a(i6);
                    }
                    FlashDragLayout.this.h = i6;
                    FlashDragLayout.this.g = false;
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animator) {
                }

                @Override // android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    FlashDragLayout.this.g = true;
                }
            });
            ofFloat.start();
        }
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onDown(MotionEvent motionEvent) {
        return false;
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        View childAt = getChildAt(0);
        this.b = childAt;
        if (childAt != null) {
            childAt.setX(LiveFloatManager.a().E());
        }
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        if (motionEvent.getX() - motionEvent2.getX() > e && Math.abs(f) > 200.0f) {
            Logger.b("xpz", "onFling down");
            a(0, 300);
            return false;
        } else if (motionEvent2.getX() - motionEvent.getX() <= e || Math.abs(f) <= 200.0f) {
            return false;
        } else {
            a(1, 300);
            return false;
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.f) {
            return true;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onLongPress(MotionEvent motionEvent) {
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        a(-((int) f));
        return false;
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public void onShowPress(MotionEvent motionEvent) {
    }

    @Override // android.view.GestureDetector.OnGestureListener
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        return false;
    }

    public void setOnDragChangedListener(OnDragChangedListener onDragChangedListener) {
        this.k = onDragChangedListener;
    }
}
