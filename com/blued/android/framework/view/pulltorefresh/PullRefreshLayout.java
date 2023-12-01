package com.blued.android.framework.view.pulltorefresh;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.Transformation;
import android.widget.ImageView;
import androidx.core.view.MotionEventCompat;
import com.blued.android.framework.R;
import java.security.InvalidParameterException;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/view/pulltorefresh/PullRefreshLayout.class */
public class PullRefreshLayout extends ViewGroup {
    private View a;
    private ImageView b;
    private Interpolator c;
    private int d;
    private int e;
    private int f;
    private int g;
    private RefreshDrawable h;
    private int i;
    private boolean j;
    private int k;
    private boolean l;
    private float m;
    private int n;
    private boolean o;
    private OnRefreshListener p;
    private int[] q;
    private final Animation r;
    private final Animation s;
    private Animation.AnimationListener t;
    private Animation.AnimationListener u;

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/framework/view/pulltorefresh/PullRefreshLayout$OnRefreshListener.class */
    public interface OnRefreshListener {
        void a();
    }

    public PullRefreshLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.r = new Animation() { // from class: com.blued.android.framework.view.pulltorefresh.PullRefreshLayout.1
            @Override // android.view.animation.Animation
            public void applyTransformation(float f, Transformation transformation) {
                PullRefreshLayout.this.a(f);
            }
        };
        this.s = new Animation() { // from class: com.blued.android.framework.view.pulltorefresh.PullRefreshLayout.2
            @Override // android.view.animation.Animation
            public void applyTransformation(float f, Transformation transformation) {
                int i = PullRefreshLayout.this.f;
                int i2 = PullRefreshLayout.this.n;
                int i3 = (int) ((i - PullRefreshLayout.this.n) * f);
                PullRefreshLayout.this.a((i2 + i3) - PullRefreshLayout.this.a.getTop(), false);
            }
        };
        this.t = new Animation.AnimationListener() { // from class: com.blued.android.framework.view.pulltorefresh.PullRefreshLayout.3
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                if (!PullRefreshLayout.this.j) {
                    PullRefreshLayout.this.h.stop();
                    PullRefreshLayout.this.b.setVisibility(8);
                    PullRefreshLayout.this.b();
                }
                PullRefreshLayout pullRefreshLayout = PullRefreshLayout.this;
                pullRefreshLayout.i = pullRefreshLayout.a.getTop();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                if (PullRefreshLayout.this.j) {
                    PullRefreshLayout.this.h.start();
                    if (!PullRefreshLayout.this.o || PullRefreshLayout.this.p == null) {
                        return;
                    }
                    PullRefreshLayout.this.p.a();
                }
            }
        };
        this.u = new Animation.AnimationListener() { // from class: com.blued.android.framework.view.pulltorefresh.PullRefreshLayout.4
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                PullRefreshLayout.this.h.stop();
                PullRefreshLayout.this.b.setVisibility(8);
                PullRefreshLayout pullRefreshLayout = PullRefreshLayout.this;
                pullRefreshLayout.i = pullRefreshLayout.a.getTop();
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }
        };
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.PullRefreshLayout);
        int integer = obtainStyledAttributes.getInteger(R.styleable.PullRefreshLayout_type, 0);
        int resourceId = obtainStyledAttributes.getResourceId(R.styleable.PullRefreshLayout_colors, R.array.progress_wheel_colors);
        obtainStyledAttributes.recycle();
        this.c = new DecelerateInterpolator(2.0f);
        this.d = ViewConfiguration.get(context).getScaledTouchSlop();
        this.e = getResources().getInteger(com.android.internal.R.integer.config_mediumAnimTime);
        int a = a(64);
        this.g = a;
        this.f = a;
        this.b = new ImageView(context);
        this.q = context.getResources().getIntArray(resourceId);
        setRefreshStyle(integer);
        this.b.setVisibility(8);
        addView(this.b);
        setWillNotDraw(false);
    }

    private float a(MotionEvent motionEvent, int i) {
        int findPointerIndex = MotionEventCompat.findPointerIndex(motionEvent, i);
        if (findPointerIndex < 0) {
            return -1.0f;
        }
        return MotionEventCompat.getY(motionEvent, findPointerIndex);
    }

    private int a(int i) {
        return (int) TypedValue.applyDimension(1, i, getContext().getResources().getDisplayMetrics());
    }

    private void a() {
        if (this.a != null || getChildCount() <= 0) {
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= getChildCount()) {
                return;
            }
            View childAt = getChildAt(i2);
            if (childAt != this.b) {
                this.a = childAt;
            }
            i = i2 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(float f) {
        int i = this.n;
        a((i - ((int) (i * f))) - this.a.getTop(), false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, boolean z) {
        this.b.bringToFront();
        this.a.offsetTopAndBottom(i);
        this.h.c(i);
        this.i = this.a.getTop();
    }

    private void a(MotionEvent motionEvent) {
        int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
        if (MotionEventCompat.getPointerId(motionEvent, actionIndex) == this.k) {
            this.k = MotionEventCompat.getPointerId(motionEvent, actionIndex == 0 ? 1 : 0);
        }
    }

    private void a(boolean z, boolean z2) {
        if (this.j != z) {
            this.o = z2;
            a();
            this.j = z;
            if (!z) {
                b();
                return;
            }
            this.h.c(1.0f);
            c();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        this.n = this.i;
        this.r.reset();
        this.r.setDuration(this.e);
        this.r.setInterpolator(this.c);
        this.r.setAnimationListener(this.u);
        this.b.clearAnimation();
        this.b.startAnimation(this.r);
    }

    private void c() {
        this.n = this.i;
        this.s.reset();
        this.s.setDuration(this.e);
        this.s.setInterpolator(this.c);
        this.s.setAnimationListener(this.t);
        this.b.clearAnimation();
        this.b.startAnimation(this.s);
    }

    private boolean d() {
        return androidx.core.view.ViewCompat.canScrollVertically(this.a, -1);
    }

    public int getFinalOffset() {
        return this.f;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (!isEnabled() || d() || this.j) {
            return false;
        }
        int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
        if (actionMasked != 0) {
            if (actionMasked != 1) {
                if (actionMasked == 2) {
                    int i = this.k;
                    if (i == -1) {
                        return false;
                    }
                    float a = a(motionEvent, i);
                    if (a == -1.0f) {
                        return false;
                    }
                    if (a - this.m > this.d && !this.l) {
                        this.l = true;
                    }
                } else if (actionMasked != 3) {
                    if (actionMasked == 6) {
                        a(motionEvent);
                    }
                }
            }
            this.l = false;
            this.k = -1;
        } else {
            a(0, true);
            int pointerId = MotionEventCompat.getPointerId(motionEvent, 0);
            this.k = pointerId;
            this.l = false;
            float a2 = a(motionEvent, pointerId);
            if (a2 == -1.0f) {
                return false;
            }
            this.m = a2;
        }
        return this.l;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        a();
        if (this.a == null) {
            return;
        }
        int measuredHeight = getMeasuredHeight();
        int measuredWidth = getMeasuredWidth();
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();
        View view = this.a;
        int i5 = this.i;
        int i6 = (measuredWidth + paddingLeft) - paddingRight;
        int i7 = (measuredHeight + paddingTop) - paddingBottom;
        view.layout(paddingLeft, paddingTop + i5, i6, i5 + i7);
        this.b.layout(paddingLeft, paddingTop, i6, i7);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        a();
        if (this.a == null) {
            return;
        }
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec((getMeasuredWidth() - getPaddingRight()) - getPaddingLeft(), 1073741824);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), 1073741824);
        this.a.measure(makeMeasureSpec, makeMeasureSpec2);
        this.b.measure(makeMeasureSpec, makeMeasureSpec2);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.l) {
            int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
            if (actionMasked != 1) {
                if (actionMasked == 2) {
                    int findPointerIndex = MotionEventCompat.findPointerIndex(motionEvent, this.k);
                    if (findPointerIndex < 0) {
                        return false;
                    }
                    float y = (MotionEventCompat.getY(motionEvent, findPointerIndex) - this.m) * 0.5f;
                    float f = y / this.g;
                    if (f < 0.0f) {
                        return false;
                    }
                    float min = Math.min(1.0f, Math.abs(f));
                    float abs = Math.abs(y);
                    float f2 = this.g;
                    float f3 = this.f;
                    double max = Math.max(0.0f, Math.min(abs - f2, f3 * 2.0f) / f3) / 4.0f;
                    int pow = (int) ((f3 * min) + (((float) (max - Math.pow(max, 2.0d))) * 2.0f * f3 * 2.0f));
                    if (this.b.getVisibility() != 0) {
                        this.b.setVisibility(0);
                    }
                    if (y < this.g) {
                        this.h.c(min);
                    }
                    a(pow - this.i, true);
                    return true;
                } else if (actionMasked != 3) {
                    if (actionMasked == 5) {
                        this.k = MotionEventCompat.getPointerId(motionEvent, MotionEventCompat.getActionIndex(motionEvent));
                        return true;
                    } else if (actionMasked != 6) {
                        return true;
                    } else {
                        a(motionEvent);
                        return true;
                    }
                }
            }
            int i = this.k;
            if (i == -1) {
                return false;
            }
            float y2 = MotionEventCompat.getY(motionEvent, MotionEventCompat.findPointerIndex(motionEvent, i));
            float f4 = this.m;
            this.l = false;
            if ((y2 - f4) * 0.5f > this.g) {
                a(true, true);
            } else {
                this.j = false;
                b();
            }
            this.k = -1;
            return false;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setColorSchemeColors(int[] iArr) {
        this.q = iArr;
        this.h.a(iArr);
    }

    public void setOnRefreshListener(OnRefreshListener onRefreshListener) {
        this.p = onRefreshListener;
    }

    public void setRefreshDrawable(RefreshDrawable refreshDrawable) {
        setRefreshing(false);
        this.h = refreshDrawable;
        refreshDrawable.a(this.q);
        this.b.setImageDrawable(this.h);
    }

    public void setRefreshStyle(int i) {
        setRefreshing(false);
        if (i != 0) {
            throw new InvalidParameterException("Type does not exist");
        }
        MaterialDrawable materialDrawable = new MaterialDrawable(getContext(), this);
        this.h = materialDrawable;
        materialDrawable.a(this.q);
        this.b.setImageDrawable(this.h);
    }

    public void setRefreshing(boolean z) {
        if (this.j != z) {
            a(z, false);
        }
    }
}
