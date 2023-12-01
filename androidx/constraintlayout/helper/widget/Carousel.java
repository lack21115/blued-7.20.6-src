package androidx.constraintlayout.helper.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import androidx.constraintlayout.motion.widget.MotionHelper;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.motion.widget.MotionScene;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.constraintlayout.widget.R;
import java.util.ArrayList;

/* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/helper/widget/Carousel.class */
public class Carousel extends MotionHelper {
    public static final int TOUCH_UP_CARRY_ON = 2;
    public static final int TOUCH_UP_IMMEDIATE_STOP = 1;
    private float A;
    private int B;
    private int C;

    /* renamed from: a  reason: collision with root package name */
    int f2105a;
    Runnable b;
    private Adapter d;
    private final ArrayList<View> e;
    private int f;
    private int g;
    private MotionLayout h;
    private int i;
    private boolean r;
    private int s;
    private int t;
    private int u;
    private int v;
    private float w;
    private int x;
    private int y;
    private int z;

    /* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/helper/widget/Carousel$Adapter.class */
    public interface Adapter {
        int count();

        void onNewItem(int i);

        void populate(View view, int i);
    }

    public Carousel(Context context) {
        super(context);
        this.d = null;
        this.e = new ArrayList<>();
        this.f = 0;
        this.g = 0;
        this.i = -1;
        this.r = false;
        this.s = -1;
        this.t = -1;
        this.u = -1;
        this.v = -1;
        this.w = 0.9f;
        this.x = 0;
        this.y = 4;
        this.z = 1;
        this.A = 2.0f;
        this.B = -1;
        this.C = 200;
        this.f2105a = -1;
        this.b = new Runnable() { // from class: androidx.constraintlayout.helper.widget.Carousel.1
            @Override // java.lang.Runnable
            public void run() {
                Carousel.this.h.setProgress(0.0f);
                Carousel.this.a();
                Carousel.this.d.onNewItem(Carousel.this.g);
                float velocity = Carousel.this.h.getVelocity();
                if (Carousel.this.z != 2 || velocity <= Carousel.this.A || Carousel.this.g >= Carousel.this.d.count() - 1) {
                    return;
                }
                float f = Carousel.this.w;
                if (Carousel.this.g != 0 || Carousel.this.f <= Carousel.this.g) {
                    if (Carousel.this.g != Carousel.this.d.count() - 1 || Carousel.this.f >= Carousel.this.g) {
                        final float f2 = velocity * f;
                        Carousel.this.h.post(new Runnable() { // from class: androidx.constraintlayout.helper.widget.Carousel.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                Carousel.this.h.touchAnimateTo(5, 1.0f, f2);
                            }
                        });
                    }
                }
            }
        };
    }

    public Carousel(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.d = null;
        this.e = new ArrayList<>();
        this.f = 0;
        this.g = 0;
        this.i = -1;
        this.r = false;
        this.s = -1;
        this.t = -1;
        this.u = -1;
        this.v = -1;
        this.w = 0.9f;
        this.x = 0;
        this.y = 4;
        this.z = 1;
        this.A = 2.0f;
        this.B = -1;
        this.C = 200;
        this.f2105a = -1;
        this.b = new Runnable() { // from class: androidx.constraintlayout.helper.widget.Carousel.1
            @Override // java.lang.Runnable
            public void run() {
                Carousel.this.h.setProgress(0.0f);
                Carousel.this.a();
                Carousel.this.d.onNewItem(Carousel.this.g);
                float velocity = Carousel.this.h.getVelocity();
                if (Carousel.this.z != 2 || velocity <= Carousel.this.A || Carousel.this.g >= Carousel.this.d.count() - 1) {
                    return;
                }
                float f = Carousel.this.w;
                if (Carousel.this.g != 0 || Carousel.this.f <= Carousel.this.g) {
                    if (Carousel.this.g != Carousel.this.d.count() - 1 || Carousel.this.f >= Carousel.this.g) {
                        final float f2 = velocity * f;
                        Carousel.this.h.post(new Runnable() { // from class: androidx.constraintlayout.helper.widget.Carousel.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                Carousel.this.h.touchAnimateTo(5, 1.0f, f2);
                            }
                        });
                    }
                }
            }
        };
        a(context, attributeSet);
    }

    public Carousel(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.d = null;
        this.e = new ArrayList<>();
        this.f = 0;
        this.g = 0;
        this.i = -1;
        this.r = false;
        this.s = -1;
        this.t = -1;
        this.u = -1;
        this.v = -1;
        this.w = 0.9f;
        this.x = 0;
        this.y = 4;
        this.z = 1;
        this.A = 2.0f;
        this.B = -1;
        this.C = 200;
        this.f2105a = -1;
        this.b = new Runnable() { // from class: androidx.constraintlayout.helper.widget.Carousel.1
            @Override // java.lang.Runnable
            public void run() {
                Carousel.this.h.setProgress(0.0f);
                Carousel.this.a();
                Carousel.this.d.onNewItem(Carousel.this.g);
                float velocity = Carousel.this.h.getVelocity();
                if (Carousel.this.z != 2 || velocity <= Carousel.this.A || Carousel.this.g >= Carousel.this.d.count() - 1) {
                    return;
                }
                float f = Carousel.this.w;
                if (Carousel.this.g != 0 || Carousel.this.f <= Carousel.this.g) {
                    if (Carousel.this.g != Carousel.this.d.count() - 1 || Carousel.this.f >= Carousel.this.g) {
                        final float f2 = velocity * f;
                        Carousel.this.h.post(new Runnable() { // from class: androidx.constraintlayout.helper.widget.Carousel.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                Carousel.this.h.touchAnimateTo(5, 1.0f, f2);
                            }
                        });
                    }
                }
            }
        };
        a(context, attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        int i;
        Adapter adapter = this.d;
        if (adapter == null || this.h == null || adapter.count() == 0) {
            return;
        }
        int size = this.e.size();
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= size) {
                break;
            }
            View view = this.e.get(i3);
            int i4 = (this.g + i3) - this.x;
            if (this.r) {
                if (i4 < 0) {
                    int i5 = this.y;
                    if (i5 != 4) {
                        a(view, i5);
                    } else {
                        a(view, 0);
                    }
                    if (i4 % this.d.count() == 0) {
                        this.d.populate(view, 0);
                    } else {
                        Adapter adapter2 = this.d;
                        adapter2.populate(view, adapter2.count() + (i4 % this.d.count()));
                    }
                } else if (i4 >= this.d.count()) {
                    if (i4 == this.d.count()) {
                        i = 0;
                    } else {
                        i = i4;
                        if (i4 > this.d.count()) {
                            i = i4 % this.d.count();
                        }
                    }
                    int i6 = this.y;
                    if (i6 != 4) {
                        a(view, i6);
                    } else {
                        a(view, 0);
                    }
                    this.d.populate(view, i);
                } else {
                    a(view, 0);
                    this.d.populate(view, i4);
                }
            } else if (i4 < 0) {
                a(view, this.y);
            } else if (i4 >= this.d.count()) {
                a(view, this.y);
            } else {
                a(view, 0);
                this.d.populate(view, i4);
            }
            i2 = i3 + 1;
        }
        int i7 = this.B;
        if (i7 != -1 && i7 != this.g) {
            this.h.post(new Runnable() { // from class: androidx.constraintlayout.helper.widget.-$$Lambda$Carousel$_3o_OWty8wtSNIRXPvHkD7rdPPY
                @Override // java.lang.Runnable
                public final void run() {
                    Carousel.this.c();
                }
            });
        } else if (this.B == this.g) {
            this.B = -1;
        }
        if (this.s == -1 || this.t == -1) {
            Log.w("Carousel", "No backward or forward transitions defined for Carousel!");
        } else if (this.r) {
        } else {
            int count = this.d.count();
            if (this.g == 0) {
                a(this.s, false);
            } else {
                a(this.s, true);
                this.h.setTransition(this.s);
            }
            if (this.g == count - 1) {
                a(this.t, false);
                return;
            }
            a(this.t, true);
            this.h.setTransition(this.t);
        }
    }

    private void a(Context context, AttributeSet attributeSet) {
        if (attributeSet == null) {
            return;
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.Carousel);
        int indexCount = obtainStyledAttributes.getIndexCount();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= indexCount) {
                obtainStyledAttributes.recycle();
                return;
            }
            int index = obtainStyledAttributes.getIndex(i2);
            if (index == R.styleable.Carousel_carousel_firstView) {
                this.i = obtainStyledAttributes.getResourceId(index, this.i);
            } else if (index == R.styleable.Carousel_carousel_backwardTransition) {
                this.s = obtainStyledAttributes.getResourceId(index, this.s);
            } else if (index == R.styleable.Carousel_carousel_forwardTransition) {
                this.t = obtainStyledAttributes.getResourceId(index, this.t);
            } else if (index == R.styleable.Carousel_carousel_emptyViewsBehavior) {
                this.y = obtainStyledAttributes.getInt(index, this.y);
            } else if (index == R.styleable.Carousel_carousel_previousState) {
                this.u = obtainStyledAttributes.getResourceId(index, this.u);
            } else if (index == R.styleable.Carousel_carousel_nextState) {
                this.v = obtainStyledAttributes.getResourceId(index, this.v);
            } else if (index == R.styleable.Carousel_carousel_touchUp_dampeningFactor) {
                this.w = obtainStyledAttributes.getFloat(index, this.w);
            } else if (index == R.styleable.Carousel_carousel_touchUpMode) {
                this.z = obtainStyledAttributes.getInt(index, this.z);
            } else if (index == R.styleable.Carousel_carousel_touchUp_velocityThreshold) {
                this.A = obtainStyledAttributes.getFloat(index, this.A);
            } else if (index == R.styleable.Carousel_carousel_infinite) {
                this.r = obtainStyledAttributes.getBoolean(index, this.r);
            }
            i = i2 + 1;
        }
    }

    private boolean a(int i, View view, int i2) {
        ConstraintSet.Constraint constraint;
        ConstraintSet constraintSet = this.h.getConstraintSet(i);
        if (constraintSet == null || (constraint = constraintSet.getConstraint(view.getId())) == null) {
            return false;
        }
        constraint.propertySet.mVisibilityMode = 1;
        view.setVisibility(i2);
        return true;
    }

    private boolean a(int i, boolean z) {
        MotionLayout motionLayout;
        MotionScene.Transition transition;
        if (i == -1 || (motionLayout = this.h) == null || (transition = motionLayout.getTransition(i)) == null || z == transition.isEnabled()) {
            return false;
        }
        transition.setEnabled(z);
        return true;
    }

    private boolean a(View view, int i) {
        MotionLayout motionLayout = this.h;
        if (motionLayout == null) {
            return false;
        }
        boolean z = false;
        for (int i2 : motionLayout.getConstraintSetIds()) {
            z |= a(i2, view, i);
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void c() {
        this.h.setTransitionDuration(this.C);
        if (this.B < this.g) {
            this.h.transitionToState(this.u, this.C);
        } else {
            this.h.transitionToState(this.v, this.C);
        }
    }

    public int getCount() {
        Adapter adapter = this.d;
        if (adapter != null) {
            return adapter.count();
        }
        return 0;
    }

    public int getCurrentIndex() {
        return this.g;
    }

    public void jumpToIndex(int i) {
        this.g = Math.max(0, Math.min(getCount() - 1, i));
        refresh();
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (getParent() instanceof MotionLayout) {
            MotionLayout motionLayout = (MotionLayout) getParent();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= this.k) {
                    break;
                }
                int i3 = this.j[i2];
                View viewById = motionLayout.getViewById(i3);
                if (this.i == i3) {
                    this.x = i2;
                }
                this.e.add(viewById);
                i = i2 + 1;
            }
            this.h = motionLayout;
            if (this.z == 2) {
                MotionScene.Transition transition = motionLayout.getTransition(this.t);
                if (transition != null) {
                    transition.setOnTouchUp(5);
                }
                MotionScene.Transition transition2 = this.h.getTransition(this.s);
                if (transition2 != null) {
                    transition2.setOnTouchUp(5);
                }
            }
            a();
        }
    }

    @Override // androidx.constraintlayout.motion.widget.MotionHelper, androidx.constraintlayout.motion.widget.MotionLayout.TransitionListener
    public void onTransitionChange(MotionLayout motionLayout, int i, int i2, float f) {
        this.f2105a = i;
    }

    @Override // androidx.constraintlayout.motion.widget.MotionHelper, androidx.constraintlayout.motion.widget.MotionLayout.TransitionListener
    public void onTransitionCompleted(MotionLayout motionLayout, int i) {
        int i2 = this.g;
        this.f = i2;
        if (i == this.v) {
            this.g = i2 + 1;
        } else if (i == this.u) {
            this.g = i2 - 1;
        }
        if (this.r) {
            if (this.g >= this.d.count()) {
                this.g = 0;
            }
            if (this.g < 0) {
                this.g = this.d.count() - 1;
            }
        } else {
            if (this.g >= this.d.count()) {
                this.g = this.d.count() - 1;
            }
            if (this.g < 0) {
                this.g = 0;
            }
        }
        if (this.f != this.g) {
            this.h.post(this.b);
        }
    }

    public void refresh() {
        int size = this.e.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                this.h.rebuildScene();
                a();
                return;
            }
            View view = this.e.get(i2);
            if (this.d.count() == 0) {
                a(view, this.y);
            } else {
                a(view, 0);
            }
            i = i2 + 1;
        }
    }

    public void setAdapter(Adapter adapter) {
        this.d = adapter;
    }

    public void transitionToIndex(int i, int i2) {
        this.B = Math.max(0, Math.min(getCount() - 1, i));
        int max = Math.max(0, i2);
        this.C = max;
        this.h.setTransitionDuration(max);
        if (i < this.g) {
            this.h.transitionToState(this.u, this.C);
        } else {
            this.h.transitionToState(this.v, this.C);
        }
    }
}
