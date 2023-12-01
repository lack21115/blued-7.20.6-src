package com.blued.android.module.common.view.scrollpicker;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.animation.Interpolator;
import android.widget.Scroller;
import com.blued.android.module.common.R;
import java.util.ArrayList;
import java.util.List;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/view/scrollpicker/ScrollPickerView.class */
public abstract class ScrollPickerView<T> extends View {
    private static final SlotInterpolator G = new SlotInterpolator(null);
    private Drawable A;
    private boolean B;
    private boolean C;
    private boolean D;
    private boolean E;
    private ValueAnimator F;
    private int a;
    private boolean b;
    private boolean c;
    private boolean d;
    private int e;
    private List<T> f;
    private int g;
    private int h;
    private int i;
    private int j;
    private int k;
    private int l;
    private int m;
    private float n;
    private float o;
    private float p;
    private GestureDetector q;
    private OnSelectedListener r;
    private Scroller s;
    private boolean t;
    private boolean u;
    private boolean v;
    private int w;
    private int x;
    private boolean y;
    private Paint z;

    /* renamed from: com.blued.android.module.common.view.scrollpicker.ScrollPickerView$1  reason: invalid class name */
    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/view/scrollpicker/ScrollPickerView$1.class */
    class AnonymousClass1 implements ValueAnimator.AnimatorUpdateListener {
        final /* synthetic */ int a;
        final /* synthetic */ ScrollPickerView b;

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.b.a(((Integer) valueAnimator.getAnimatedValue()).intValue(), this.a, (((float) valueAnimator.getCurrentPlayTime()) * 1.0f) / ((float) valueAnimator.getDuration()));
        }
    }

    /* renamed from: com.blued.android.module.common.view.scrollpicker.ScrollPickerView$2  reason: invalid class name */
    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/view/scrollpicker/ScrollPickerView$2.class */
    class AnonymousClass2 extends AnimatorListenerAdapter {
        final /* synthetic */ ScrollPickerView a;

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            this.a.E = false;
        }
    }

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/view/scrollpicker/ScrollPickerView$FlingOnGestureListener.class */
    class FlingOnGestureListener extends GestureDetector.SimpleOnGestureListener {
        private boolean b;

        private FlingOnGestureListener() {
            this.b = false;
        }

        /* synthetic */ FlingOnGestureListener(ScrollPickerView scrollPickerView, AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            ViewParent parent;
            if (ScrollPickerView.this.d && (parent = ScrollPickerView.this.getParent()) != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
            this.b = ScrollPickerView.this.f();
            ScrollPickerView.this.a();
            ScrollPickerView.this.n = motionEvent.getY();
            ScrollPickerView.this.o = motionEvent.getX();
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            if (ScrollPickerView.this.b) {
                ScrollPickerView.this.a();
                if (ScrollPickerView.this.C) {
                    ScrollPickerView scrollPickerView = ScrollPickerView.this;
                    scrollPickerView.a(scrollPickerView.p, f);
                    return true;
                }
                ScrollPickerView scrollPickerView2 = ScrollPickerView.this;
                scrollPickerView2.a(scrollPickerView2.p, f2);
                return true;
            }
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onSingleTapUp(MotionEvent motionEvent) {
            float f;
            ScrollPickerView.this.n = motionEvent.getY();
            ScrollPickerView.this.o = motionEvent.getX();
            if (ScrollPickerView.this.g()) {
                ScrollPickerView scrollPickerView = ScrollPickerView.this;
                scrollPickerView.m = scrollPickerView.l;
                f = ScrollPickerView.this.o;
            } else {
                ScrollPickerView scrollPickerView2 = ScrollPickerView.this;
                scrollPickerView2.m = scrollPickerView2.k;
                f = ScrollPickerView.this.n;
            }
            if (!ScrollPickerView.this.B || ScrollPickerView.this.f() || this.b) {
                ScrollPickerView.this.k();
                return true;
            } else if (f >= ScrollPickerView.this.m && f <= ScrollPickerView.this.m + ScrollPickerView.this.i) {
                ScrollPickerView.this.performClick();
                return true;
            } else if (f < ScrollPickerView.this.m) {
                ScrollPickerView.this.a(ScrollPickerView.this.i, 150L, (Interpolator) ScrollPickerView.G, false);
                return true;
            } else if (f <= ScrollPickerView.this.m + ScrollPickerView.this.i) {
                ScrollPickerView.this.k();
                return true;
            } else {
                ScrollPickerView.this.a(-ScrollPickerView.this.i, 150L, (Interpolator) ScrollPickerView.G, false);
                return true;
            }
        }
    }

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/view/scrollpicker/ScrollPickerView$OnSelectedListener.class */
    public interface OnSelectedListener {
        void a(ScrollPickerView scrollPickerView, int i);

        void a(boolean z);
    }

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/view/scrollpicker/ScrollPickerView$SlotInterpolator.class */
    static class SlotInterpolator implements Interpolator {
        private SlotInterpolator() {
        }

        /* synthetic */ SlotInterpolator(AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            return ((float) (Math.cos((f + 1.0f) * 3.141592653589793d) / 2.0d)) + 0.5f;
        }
    }

    public ScrollPickerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ScrollPickerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = 3;
        this.b = true;
        this.c = true;
        this.d = false;
        this.g = 0;
        this.h = 0;
        this.j = -1;
        this.p = 0.0f;
        this.w = 0;
        this.x = 0;
        this.y = false;
        this.A = null;
        this.B = true;
        this.C = false;
        this.D = false;
        this.E = false;
        this.q = new GestureDetector(getContext(), new FlingOnGestureListener(this, null));
        this.s = new Scroller(getContext());
        this.F = ValueAnimator.ofInt(0, 0);
        Paint paint = new Paint(1);
        this.z = paint;
        paint.setStyle(Paint.Style.FILL);
        a(attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(float f, float f2) {
        if (this.C) {
            int i = (int) f;
            this.x = i;
            this.t = true;
            int i2 = this.h;
            this.s.fling(i, 0, (int) f2, 0, i2 * (-10), i2 * 10, 0, 0);
        } else {
            int i3 = (int) f;
            this.w = i3;
            this.t = true;
            int i4 = this.g;
            this.s.fling(0, i3, 0, (int) f2, 0, 0, i4 * (-10), i4 * 10);
        }
        invalidate();
    }

    private void a(float f, int i) {
        if (this.C) {
            int i2 = (int) f;
            this.x = i2;
            this.v = true;
            this.s.startScroll(i2, 0, 0, 0);
            this.s.setFinalX(i);
        } else {
            int i3 = (int) f;
            this.w = i3;
            this.v = true;
            this.s.startScroll(0, i3, 0, 0);
            this.s.setFinalY(i);
        }
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, int i2, float f) {
        if (f < 1.0f) {
            if (this.C) {
                this.p = (this.p + i) - this.x;
                this.x = i;
            } else {
                this.p = (this.p + i) - this.w;
                this.w = i;
            }
            j();
            invalidate();
            return;
        }
        this.v = false;
        this.w = 0;
        this.x = 0;
        float f2 = this.p;
        if (f2 > 0.0f) {
            int i3 = this.i;
            if (f2 < i3 / 2) {
                this.p = 0.0f;
            } else {
                this.p = i3;
            }
        } else {
            float f3 = -f2;
            int i4 = this.i;
            if (f3 < i4 / 2) {
                this.p = 0.0f;
            } else {
                this.p = -i4;
            }
        }
        j();
        this.p = 0.0f;
        this.w = 0;
        this.x = 0;
        l();
        invalidate();
    }

    private void a(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.ScrollPickerView);
            if (obtainStyledAttributes.hasValue(R.styleable.ScrollPickerView_spv_center_item_background)) {
                setCenterItemBackground(obtainStyledAttributes.getDrawable(R.styleable.ScrollPickerView_spv_center_item_background));
            }
            setVisibleItemCount(obtainStyledAttributes.getInt(R.styleable.ScrollPickerView_spv_visible_item_count, getVisibleItemCount()));
            setCenterPosition(obtainStyledAttributes.getInt(R.styleable.ScrollPickerView_spv_center_item_position, getCenterPosition()));
            setIsCirculation(obtainStyledAttributes.getBoolean(R.styleable.ScrollPickerView_spv_is_circulation, c()));
            setDisallowInterceptTouch(obtainStyledAttributes.getBoolean(R.styleable.ScrollPickerView_spv_disallow_intercept_touch, d()));
            boolean z = true;
            if (obtainStyledAttributes.getInt(R.styleable.ScrollPickerView_spv_orientation, this.C ? 1 : 2) != 1) {
                z = false;
            }
            setHorizontal(z);
            obtainStyledAttributes.recycle();
        }
    }

    private void i() {
        if (this.j < 0) {
            this.j = this.a / 2;
        }
        if (this.C) {
            this.g = getMeasuredHeight();
            int measuredWidth = getMeasuredWidth() / this.a;
            this.h = measuredWidth;
            this.k = 0;
            int i = this.j * measuredWidth;
            this.l = i;
            this.i = measuredWidth;
            this.m = i;
        } else {
            this.g = getMeasuredHeight() / this.a;
            this.h = getMeasuredWidth();
            int i2 = this.j;
            int i3 = this.g;
            int i4 = i2 * i3;
            this.k = i4;
            this.l = 0;
            this.i = i3;
            this.m = i4;
        }
        Drawable drawable = this.A;
        if (drawable != null) {
            int i5 = this.l;
            int i6 = this.k;
            drawable.setBounds(i5, i6, this.h + i5, this.g + i6);
        }
    }

    private void j() {
        int size;
        int size2;
        float f = this.p;
        int i = this.i;
        if (f >= i) {
            int i2 = this.e - ((int) (f / i));
            this.e = i2;
            if (i2 >= 0) {
                this.p = (f - i) % i;
            } else if (this.c) {
                do {
                    size2 = this.f.size() + this.e;
                    this.e = size2;
                } while (size2 < 0);
                float f2 = this.p;
                int i3 = this.i;
                this.p = (f2 - i3) % i3;
            } else {
                this.e = 0;
                this.p = i;
                if (this.t) {
                    this.s.forceFinished(true);
                }
                if (this.v) {
                    a(this.p, 0);
                }
            }
        } else if (f <= (-i)) {
            int i4 = this.e + ((int) ((-f) / i));
            this.e = i4;
            if (i4 < this.f.size()) {
                float f3 = this.p;
                int i5 = this.i;
                this.p = (f3 + i5) % i5;
            } else if (this.c) {
                do {
                    size = this.e - this.f.size();
                    this.e = size;
                } while (size >= this.f.size());
                float f4 = this.p;
                int i6 = this.i;
                this.p = (f4 + i6) % i6;
            } else {
                this.e = this.f.size() - 1;
                this.p = -this.i;
                if (this.t) {
                    this.s.forceFinished(true);
                }
                if (this.v) {
                    a(this.p, 0);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        if (!this.s.isFinished() || this.t || this.p == 0.0f) {
            return;
        }
        a();
        float f = this.p;
        if (f > 0.0f) {
            if (this.C) {
                int i = this.h;
                if (f < i / 2) {
                    a(f, 0);
                    return;
                } else {
                    a(f, i);
                    return;
                }
            }
            int i2 = this.g;
            if (f < i2 / 2) {
                a(f, 0);
            } else {
                a(f, i2);
            }
        } else if (this.C) {
            float f2 = -f;
            int i3 = this.h;
            if (f2 < i3 / 2) {
                a(f, 0);
            } else {
                a(f, -i3);
            }
        } else {
            float f3 = -f;
            int i4 = this.g;
            if (f3 < i4 / 2) {
                a(f, 0);
            } else {
                a(f, -i4);
            }
        }
    }

    private void l() {
        this.u = false;
        if (this.r != null) {
            post(new Runnable() { // from class: com.blued.android.module.common.view.scrollpicker.-$$Lambda$ScrollPickerView$NC_55JIQv-mSLgOGncthD41Ivf0
                @Override // java.lang.Runnable
                public final void run() {
                    ScrollPickerView.this.m();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void m() {
        this.r.a(this, this.e);
    }

    public void a() {
        this.w = 0;
        this.x = 0;
        this.v = false;
        this.t = false;
        this.s.abortAnimation();
        b();
    }

    public void a(final int i, long j, Interpolator interpolator, boolean z) {
        if (this.E) {
            return;
        }
        final boolean z2 = this.y;
        this.y = !z;
        this.E = true;
        this.F.cancel();
        this.F.setIntValues(0, i);
        this.F.setInterpolator(interpolator);
        this.F.setDuration(j);
        this.F.removeAllUpdateListeners();
        this.F.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.blued.android.module.common.view.scrollpicker.ScrollPickerView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                ScrollPickerView.this.a(((Integer) valueAnimator.getAnimatedValue()).intValue(), i, (((float) valueAnimator.getCurrentPlayTime()) * 1.0f) / ((float) valueAnimator.getDuration()));
            }
        });
        this.F.removeAllListeners();
        this.F.addListener(new AnimatorListenerAdapter() { // from class: com.blued.android.module.common.view.scrollpicker.ScrollPickerView.4
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                ScrollPickerView.this.E = false;
                ScrollPickerView.this.y = z2;
            }
        });
        this.F.start();
    }

    public void a(int i, boolean z) {
        if (i < 0 || i > this.f.size() - 1 || i == this.e) {
            return;
        }
        this.e = i;
        invalidate();
        if (!z || this.r == null) {
            return;
        }
        l();
    }

    public abstract void a(Canvas canvas, List<T> list, int i, int i2, float f, float f2);

    public void b() {
        this.E = false;
        this.F.cancel();
    }

    public boolean c() {
        return this.c;
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.s.computeScrollOffset()) {
            if (this.C) {
                this.p = (this.p + this.s.getCurrX()) - this.x;
            } else {
                this.p = (this.p + this.s.getCurrY()) - this.w;
            }
            this.w = this.s.getCurrY();
            this.x = this.s.getCurrX();
            j();
            invalidate();
            if (this.u) {
                return;
            }
            this.u = true;
            OnSelectedListener onSelectedListener = this.r;
            if (onSelectedListener != null) {
                onSelectedListener.a(true);
            }
        } else if (this.t) {
            this.t = false;
            k();
            if (this.p == 0.0f) {
                l();
            }
        } else if (this.v) {
            this.p = 0.0f;
            this.v = false;
            this.w = 0;
            this.x = 0;
            l();
        }
    }

    public boolean d() {
        return this.d;
    }

    public boolean e() {
        return this.y;
    }

    public boolean f() {
        return this.t || this.v || this.E;
    }

    public boolean g() {
        return this.C;
    }

    public Drawable getCenterItemBackground() {
        return this.A;
    }

    public int getCenterPoint() {
        return this.m;
    }

    public int getCenterPosition() {
        return this.j;
    }

    public int getCenterX() {
        return this.l;
    }

    public int getCenterY() {
        return this.k;
    }

    public List<T> getData() {
        return this.f;
    }

    public int getItemHeight() {
        return this.g;
    }

    public int getItemSize() {
        return this.i;
    }

    public int getItemWidth() {
        return this.h;
    }

    public OnSelectedListener getListener() {
        return this.r;
    }

    public T getSelectedItem() {
        return this.f.get(this.e);
    }

    public int getSelectedPosition() {
        return this.e;
    }

    public int getVisibleItemCount() {
        return this.a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        List<T> list = this.f;
        if (list == null || list.size() <= 0) {
            return;
        }
        Drawable drawable = this.A;
        if (drawable != null) {
            drawable.draw(canvas);
        }
        int i = this.j;
        int min = Math.min(Math.max(i + 1, this.a - i), this.f.size());
        if (this.D) {
            min = this.f.size();
        }
        while (min >= 1) {
            if (this.D || min <= this.j + 1) {
                int i2 = this.e;
                int i3 = i2;
                if (i2 - min < 0) {
                    i3 = this.f.size() + this.e;
                }
                int i4 = i3 - min;
                if (this.c) {
                    float f = this.p;
                    a(canvas, this.f, i4, -min, f, (this.m + f) - (this.i * min));
                } else if (this.e - min >= 0) {
                    float f2 = this.p;
                    a(canvas, this.f, i4, -min, f2, (this.m + f2) - (this.i * min));
                }
            }
            if (this.D || min <= this.a - this.j) {
                int size = this.e + min >= this.f.size() ? (this.e + min) - this.f.size() : this.e + min;
                if (this.c) {
                    List<T> list2 = this.f;
                    float f3 = this.p;
                    a(canvas, list2, size, min, f3, this.m + f3 + (this.i * min));
                } else if (this.e + min < this.f.size()) {
                    List<T> list3 = this.f;
                    float f4 = this.p;
                    a(canvas, list3, size, min, f4, this.m + f4 + (this.i * min));
                }
            }
            min--;
        }
        List<T> list4 = this.f;
        int i5 = this.e;
        float f5 = this.p;
        a(canvas, list4, i5, 0, f5, this.m + f5);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        i();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.y || this.q.onTouchEvent(motionEvent)) {
            return true;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 1) {
            this.n = motionEvent.getY();
            this.o = motionEvent.getX();
            k();
            return true;
        } else if (actionMasked != 2) {
            return true;
        } else {
            if (this.C) {
                if (Math.abs(motionEvent.getX() - this.o) < 0.1f) {
                    return true;
                }
                this.p += motionEvent.getX() - this.o;
            } else if (Math.abs(motionEvent.getY() - this.n) < 0.1f) {
                return true;
            } else {
                this.p += motionEvent.getY() - this.n;
            }
            this.n = motionEvent.getY();
            this.o = motionEvent.getX();
            j();
            invalidate();
            return true;
        }
    }

    public void setCanTap(boolean z) {
        this.B = z;
    }

    public void setCenterItemBackground(int i) {
        ColorDrawable colorDrawable = new ColorDrawable(i);
        this.A = colorDrawable;
        int i2 = this.l;
        int i3 = this.k;
        colorDrawable.setBounds(i2, i3, this.h + i2, this.g + i3);
        invalidate();
    }

    public void setCenterItemBackground(Drawable drawable) {
        this.A = drawable;
        int i = this.l;
        int i2 = this.k;
        drawable.setBounds(i, i2, this.h + i, this.g + i2);
        invalidate();
    }

    public void setCenterPosition(int i) {
        if (i < 0) {
            this.j = 0;
        } else {
            int i2 = this.a;
            if (i >= i2) {
                this.j = i2 - 1;
            } else {
                this.j = i;
            }
        }
        this.k = this.j * this.g;
        invalidate();
    }

    public void setData(List<T> list) {
        if (list == null) {
            this.f = new ArrayList();
        } else {
            this.f = list;
        }
        this.e = this.f.size() / 2;
        invalidate();
    }

    public void setDisallowInterceptTouch(boolean z) {
        this.d = z;
    }

    public void setDisallowTouch(boolean z) {
        this.y = z;
    }

    public void setDrawAllItem(boolean z) {
        this.D = z;
    }

    public void setHorizontal(boolean z) {
        if (this.C == z) {
            return;
        }
        this.C = z;
        i();
        if (this.C) {
            this.i = this.h;
        } else {
            this.i = this.g;
        }
        invalidate();
    }

    public void setInertiaScroll(boolean z) {
        this.b = z;
    }

    public void setIsCirculation(boolean z) {
        this.c = z;
    }

    public void setOnSelectedListener(OnSelectedListener onSelectedListener) {
        this.r = onSelectedListener;
    }

    public void setSelectedPosition(int i) {
        a(i, true);
    }

    public void setVertical(boolean z) {
        if (this.C == (!z)) {
            return;
        }
        this.C = !z;
        i();
        if (this.C) {
            this.i = this.h;
        } else {
            this.i = this.g;
        }
        invalidate();
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        if (i == 0) {
            k();
        }
    }

    public void setVisibleItemCount(int i) {
        this.a = i;
        i();
        invalidate();
    }
}
