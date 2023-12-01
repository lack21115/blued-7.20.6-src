package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.R;
import androidx.core.widget.NestedScrollView;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/motion/widget/TouchResponse.class */
public class TouchResponse {
    public static final int COMPLETE_MODE_CONTINUOUS_VELOCITY = 0;
    public static final int COMPLETE_MODE_SPRING = 1;
    private static final float[][] u = {new float[]{0.5f, 0.0f}, new float[]{0.0f, 0.5f}, new float[]{1.0f, 0.5f}, new float[]{0.5f, 1.0f}, new float[]{0.5f, 0.5f}, new float[]{0.0f, 0.5f}, new float[]{1.0f, 0.5f}};
    private static final float[][] v = {new float[]{0.0f, -1.0f}, new float[]{0.0f, 1.0f}, new float[]{-1.0f, 0.0f}, new float[]{1.0f, 0.0f}, new float[]{-1.0f, 0.0f}, new float[]{1.0f, 0.0f}};
    private int A;
    private float B;
    private float C;
    private float D;
    private float E;
    private float F;
    private int G;
    private int H;

    /* renamed from: a  reason: collision with root package name */
    float f2213a;
    float b;

    /* renamed from: c  reason: collision with root package name */
    boolean f2214c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;
    private int i;
    private float j;
    private float k;
    private int l;
    private float m;
    private float n;
    private boolean o;
    private float[] p;
    private int[] q;
    private float r;
    private float s;
    private final MotionLayout t;
    private float w;
    private float x;
    private boolean y;
    private float z;

    /* JADX INFO: Access modifiers changed from: package-private */
    public TouchResponse(Context context, MotionLayout motionLayout, XmlPullParser xmlPullParser) {
        this.d = 0;
        this.e = 0;
        this.f = 0;
        this.g = -1;
        this.h = -1;
        this.i = -1;
        this.j = 0.5f;
        this.k = 0.5f;
        this.f2213a = 0.5f;
        this.b = 0.5f;
        this.l = -1;
        this.f2214c = false;
        this.m = 0.0f;
        this.n = 1.0f;
        this.o = false;
        this.p = new float[2];
        this.q = new int[2];
        this.w = 4.0f;
        this.x = 1.2f;
        this.y = true;
        this.z = 1.0f;
        this.A = 0;
        this.B = 10.0f;
        this.C = 10.0f;
        this.D = 1.0f;
        this.E = Float.NaN;
        this.F = Float.NaN;
        this.G = 0;
        this.H = 0;
        this.t = motionLayout;
        a(context, Xml.asAttributeSet(xmlPullParser));
    }

    public TouchResponse(MotionLayout motionLayout, OnSwipe onSwipe) {
        this.d = 0;
        this.e = 0;
        this.f = 0;
        this.g = -1;
        this.h = -1;
        this.i = -1;
        this.j = 0.5f;
        this.k = 0.5f;
        this.f2213a = 0.5f;
        this.b = 0.5f;
        this.l = -1;
        this.f2214c = false;
        this.m = 0.0f;
        this.n = 1.0f;
        this.o = false;
        this.p = new float[2];
        this.q = new int[2];
        this.w = 4.0f;
        this.x = 1.2f;
        this.y = true;
        this.z = 1.0f;
        this.A = 0;
        this.B = 10.0f;
        this.C = 10.0f;
        this.D = 1.0f;
        this.E = Float.NaN;
        this.F = Float.NaN;
        this.G = 0;
        this.H = 0;
        this.t = motionLayout;
        this.g = onSwipe.getTouchAnchorId();
        int touchAnchorSide = onSwipe.getTouchAnchorSide();
        this.d = touchAnchorSide;
        if (touchAnchorSide != -1) {
            float[][] fArr = u;
            this.k = fArr[touchAnchorSide][0];
            this.j = fArr[touchAnchorSide][1];
        }
        int dragDirection = onSwipe.getDragDirection();
        this.e = dragDirection;
        float[][] fArr2 = v;
        if (dragDirection < fArr2.length) {
            this.m = fArr2[dragDirection][0];
            this.n = fArr2[dragDirection][1];
        } else {
            this.n = Float.NaN;
            this.m = Float.NaN;
            this.f2214c = true;
        }
        this.w = onSwipe.getMaxVelocity();
        this.x = onSwipe.getMaxAcceleration();
        this.y = onSwipe.getMoveWhenScrollAtTop();
        this.z = onSwipe.getDragScale();
        this.B = onSwipe.getDragThreshold();
        this.h = onSwipe.getTouchRegionId();
        this.f = onSwipe.getOnTouchUp();
        this.A = onSwipe.getNestedScrollFlags();
        this.i = onSwipe.getLimitBoundsTo();
        this.l = onSwipe.getRotationCenterId();
        this.G = onSwipe.getSpringBoundary();
        this.C = onSwipe.getSpringDamping();
        this.D = onSwipe.getSpringMass();
        this.E = onSwipe.getSpringStiffness();
        this.F = onSwipe.getSpringStopThreshold();
        this.H = onSwipe.getAutoCompleteMode();
    }

    private void a(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.OnSwipe);
        a(obtainStyledAttributes);
        obtainStyledAttributes.recycle();
    }

    private void a(TypedArray typedArray) {
        int indexCount = typedArray.getIndexCount();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= indexCount) {
                return;
            }
            int index = typedArray.getIndex(i2);
            if (index == R.styleable.OnSwipe_touchAnchorId) {
                this.g = typedArray.getResourceId(index, this.g);
            } else if (index == R.styleable.OnSwipe_touchAnchorSide) {
                int i3 = typedArray.getInt(index, this.d);
                this.d = i3;
                float[][] fArr = u;
                this.k = fArr[i3][0];
                this.j = fArr[i3][1];
            } else if (index == R.styleable.OnSwipe_dragDirection) {
                int i4 = typedArray.getInt(index, this.e);
                this.e = i4;
                float[][] fArr2 = v;
                if (i4 < fArr2.length) {
                    this.m = fArr2[i4][0];
                    this.n = fArr2[i4][1];
                } else {
                    this.n = Float.NaN;
                    this.m = Float.NaN;
                    this.f2214c = true;
                }
            } else if (index == R.styleable.OnSwipe_maxVelocity) {
                this.w = typedArray.getFloat(index, this.w);
            } else if (index == R.styleable.OnSwipe_maxAcceleration) {
                this.x = typedArray.getFloat(index, this.x);
            } else if (index == R.styleable.OnSwipe_moveWhenScrollAtTop) {
                this.y = typedArray.getBoolean(index, this.y);
            } else if (index == R.styleable.OnSwipe_dragScale) {
                this.z = typedArray.getFloat(index, this.z);
            } else if (index == R.styleable.OnSwipe_dragThreshold) {
                this.B = typedArray.getFloat(index, this.B);
            } else if (index == R.styleable.OnSwipe_touchRegionId) {
                this.h = typedArray.getResourceId(index, this.h);
            } else if (index == R.styleable.OnSwipe_onTouchUp) {
                this.f = typedArray.getInt(index, this.f);
            } else if (index == R.styleable.OnSwipe_nestedScrollFlags) {
                this.A = typedArray.getInteger(index, 0);
            } else if (index == R.styleable.OnSwipe_limitBoundsTo) {
                this.i = typedArray.getResourceId(index, 0);
            } else if (index == R.styleable.OnSwipe_rotationCenterId) {
                this.l = typedArray.getResourceId(index, this.l);
            } else if (index == R.styleable.OnSwipe_springDamping) {
                this.C = typedArray.getFloat(index, this.C);
            } else if (index == R.styleable.OnSwipe_springMass) {
                this.D = typedArray.getFloat(index, this.D);
            } else if (index == R.styleable.OnSwipe_springStiffness) {
                this.E = typedArray.getFloat(index, this.E);
            } else if (index == R.styleable.OnSwipe_springStopThreshold) {
                this.F = typedArray.getFloat(index, this.F);
            } else if (index == R.styleable.OnSwipe_springBoundary) {
                this.G = typedArray.getInt(index, this.G);
            } else if (index == R.styleable.OnSwipe_autoCompleteMode) {
                this.H = typedArray.getInt(index, this.H);
            }
            i = i2 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public RectF a(ViewGroup viewGroup, RectF rectF) {
        View findViewById;
        int i = this.h;
        if (i == -1 || (findViewById = viewGroup.findViewById(i)) == null) {
            return null;
        }
        rectF.set(findViewById.getLeft(), findViewById.getTop(), findViewById.getRight(), findViewById.getBottom());
        return rectF;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        NestedScrollView nestedScrollView;
        int i = this.g;
        if (i != -1) {
            View findViewById = this.t.findViewById(i);
            nestedScrollView = findViewById;
            if (findViewById == 0) {
                Log.e("TouchResponse", "cannot find TouchAnchorId @id/" + Debug.getName(this.t.getContext(), this.g));
                nestedScrollView = findViewById;
            }
        } else {
            nestedScrollView = null;
        }
        if (nestedScrollView instanceof NestedScrollView) {
            NestedScrollView nestedScrollView2 = nestedScrollView;
            nestedScrollView2.setOnTouchListener(new View.OnTouchListener() { // from class: androidx.constraintlayout.motion.widget.TouchResponse.1
                @Override // android.view.View.OnTouchListener
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    return false;
                }
            });
            nestedScrollView2.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() { // from class: androidx.constraintlayout.motion.widget.TouchResponse.2
                @Override // androidx.core.widget.NestedScrollView.OnScrollChangeListener
                public void onScrollChange(NestedScrollView nestedScrollView3, int i2, int i3, int i4, int i5) {
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(float f, float f2) {
        this.r = f;
        this.s = f2;
        this.o = false;
    }

    /* JADX WARN: Removed duplicated region for block: B:58:0x03d9  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0402  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x042f  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0449  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    void a(android.view.MotionEvent r8, androidx.constraintlayout.motion.widget.MotionLayout.MotionTracker r9, int r10, androidx.constraintlayout.motion.widget.MotionScene r11) {
        /*
            Method dump skipped, instructions count: 1332
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.TouchResponse.a(android.view.MotionEvent, androidx.constraintlayout.motion.widget.MotionLayout$MotionTracker, int, androidx.constraintlayout.motion.widget.MotionScene):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float b() {
        return this.x;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public RectF b(ViewGroup viewGroup, RectF rectF) {
        View findViewById;
        int i = this.i;
        if (i == -1 || (findViewById = viewGroup.findViewById(i)) == null) {
            return null;
        }
        rectF.set(findViewById.getLeft(), findViewById.getTop(), findViewById.getRight(), findViewById.getBottom());
        return rectF;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(float f, float f2) {
        this.r = f;
        this.s = f2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(MotionEvent motionEvent, MotionLayout.MotionTracker motionTracker, int i, MotionScene motionScene) {
        if (this.f2214c) {
            a(motionEvent, motionTracker, i, motionScene);
            return;
        }
        motionTracker.addMovement(motionEvent);
        int action = motionEvent.getAction();
        if (action == 0) {
            this.r = motionEvent.getRawX();
            this.s = motionEvent.getRawY();
            this.o = false;
        } else if (action != 1) {
            if (action != 2) {
                return;
            }
            float rawY = motionEvent.getRawY() - this.s;
            float rawX = motionEvent.getRawX() - this.r;
            if (Math.abs((this.m * rawX) + (this.n * rawY)) > this.B || this.o) {
                float progress = this.t.getProgress();
                if (!this.o) {
                    this.o = true;
                    this.t.setProgress(progress);
                }
                int i2 = this.g;
                if (i2 != -1) {
                    this.t.a(i2, progress, this.k, this.j, this.p);
                } else {
                    float min = Math.min(this.t.getWidth(), this.t.getHeight());
                    float[] fArr = this.p;
                    fArr[1] = this.n * min;
                    fArr[0] = min * this.m;
                }
                float f = this.m;
                float[] fArr2 = this.p;
                if (Math.abs(((f * fArr2[0]) + (this.n * fArr2[1])) * this.z) < 0.01d) {
                    float[] fArr3 = this.p;
                    fArr3[0] = 0.01f;
                    fArr3[1] = 0.01f;
                }
                float max = Math.max(Math.min(progress + (this.m != 0.0f ? rawX / this.p[0] : rawY / this.p[1]), 1.0f), 0.0f);
                float f2 = max;
                if (this.f == 6) {
                    f2 = Math.max(max, 0.01f);
                }
                float f3 = f2;
                if (this.f == 7) {
                    f3 = Math.min(f2, 0.99f);
                }
                float progress2 = this.t.getProgress();
                if (f3 != progress2) {
                    int i3 = (progress2 > 0.0f ? 1 : (progress2 == 0.0f ? 0 : -1));
                    if (i3 == 0 || progress2 == 1.0f) {
                        this.t.a(i3 == 0);
                    }
                    this.t.setProgress(f3);
                    motionTracker.computeCurrentVelocity(1000);
                    this.t.d = this.m != 0.0f ? motionTracker.getXVelocity() / this.p[0] : motionTracker.getYVelocity() / this.p[1];
                } else {
                    this.t.d = 0.0f;
                }
                this.r = motionEvent.getRawX();
                this.s = motionEvent.getRawY();
            }
        } else {
            this.o = false;
            motionTracker.computeCurrentVelocity(1000);
            float xVelocity = motionTracker.getXVelocity();
            float yVelocity = motionTracker.getYVelocity();
            float progress3 = this.t.getProgress();
            int i4 = this.g;
            if (i4 != -1) {
                this.t.a(i4, progress3, this.k, this.j, this.p);
            } else {
                float min2 = Math.min(this.t.getWidth(), this.t.getHeight());
                float[] fArr4 = this.p;
                fArr4[1] = this.n * min2;
                fArr4[0] = min2 * this.m;
            }
            float f4 = this.m;
            float[] fArr5 = this.p;
            float f5 = fArr5[0];
            float f6 = fArr5[1];
            float f7 = f4 != 0.0f ? xVelocity / fArr5[0] : yVelocity / fArr5[1];
            float f8 = !Float.isNaN(f7) ? (f7 / 3.0f) + progress3 : progress3;
            if (f8 == 0.0f || f8 == 1.0f || this.f == 3) {
                if (0.0f >= f8 || 1.0f <= f8) {
                    this.t.setState(MotionLayout.TransitionState.FINISHED);
                    return;
                }
                return;
            }
            float f9 = ((double) f8) < 0.5d ? 0.0f : 1.0f;
            float f10 = f7;
            if (this.f == 6) {
                f10 = f7;
                if (progress3 + f7 < 0.0f) {
                    f10 = Math.abs(f7);
                }
                f9 = 1.0f;
            }
            float f11 = f10;
            if (this.f == 7) {
                f11 = f10;
                if (progress3 + f10 > 1.0f) {
                    f11 = -Math.abs(f10);
                }
                f9 = 0.0f;
            }
            this.t.touchAnimateTo(this.f, f9, f11);
            if (0.0f >= progress3 || 1.0f <= progress3) {
                this.t.setState(MotionLayout.TransitionState.FINISHED);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float c(float f, float f2) {
        this.t.a(this.g, this.t.getProgress(), this.k, this.j, this.p);
        if (this.m != 0.0f) {
            float[] fArr = this.p;
            if (fArr[0] == 0.0f) {
                fArr[0] = 1.0E-7f;
            }
            return (f * this.m) / this.p[0];
        }
        float[] fArr2 = this.p;
        if (fArr2[1] == 0.0f) {
            fArr2[1] = 1.0E-7f;
        }
        return (f2 * this.n) / this.p[1];
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean c() {
        return this.y;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int d() {
        return this.h;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(float f, float f2) {
        boolean z = false;
        this.o = false;
        float progress = this.t.getProgress();
        this.t.a(this.g, progress, this.k, this.j, this.p);
        float f3 = this.m;
        float[] fArr = this.p;
        float f4 = fArr[0];
        float f5 = this.n;
        float f6 = fArr[1];
        float f7 = f3 != 0.0f ? (f * f3) / fArr[0] : (f2 * f5) / fArr[1];
        float f8 = progress;
        if (!Float.isNaN(f7)) {
            f8 = progress + (f7 / 3.0f);
        }
        if (f8 != 0.0f) {
            boolean z2 = f8 != 1.0f;
            if (this.f != 3) {
                z = true;
            }
            if (z && z2) {
                this.t.touchAnimateTo(this.f, ((double) f8) < 0.5d ? 0.0f : 1.0f, f7);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void e(float f, float f2) {
        float progress = this.t.getProgress();
        if (!this.o) {
            this.o = true;
            this.t.setProgress(progress);
        }
        this.t.a(this.g, progress, this.k, this.j, this.p);
        float f3 = this.m;
        float[] fArr = this.p;
        if (Math.abs((f3 * fArr[0]) + (this.n * fArr[1])) < 0.01d) {
            float[] fArr2 = this.p;
            fArr2[0] = 0.01f;
            fArr2[1] = 0.01f;
        }
        float f4 = this.m;
        float max = Math.max(Math.min(progress + (f4 != 0.0f ? (f * f4) / this.p[0] : (f2 * this.n) / this.p[1]), 1.0f), 0.0f);
        if (max != this.t.getProgress()) {
            this.t.setProgress(max);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean e() {
        return this.o;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float f(float f, float f2) {
        return (f * this.m) + (f2 * this.n);
    }

    public int getAnchorId() {
        return this.g;
    }

    public int getAutoCompleteMode() {
        return this.H;
    }

    public int getFlags() {
        return this.A;
    }

    public float getMaxVelocity() {
        return this.w;
    }

    public int getSpringBoundary() {
        return this.G;
    }

    public float getSpringDamping() {
        return this.C;
    }

    public float getSpringMass() {
        return this.D;
    }

    public float getSpringStiffness() {
        return this.E;
    }

    public float getSpringStopThreshold() {
        return this.F;
    }

    public void setAnchorId(int i) {
        this.g = i;
    }

    public void setMaxAcceleration(float f) {
        this.x = f;
    }

    public void setMaxVelocity(float f) {
        this.w = f;
    }

    public void setRTL(boolean z) {
        if (z) {
            float[][] fArr = v;
            fArr[4] = fArr[3];
            fArr[5] = fArr[2];
            float[][] fArr2 = u;
            fArr2[5] = fArr2[2];
            fArr2[6] = fArr2[1];
        } else {
            float[][] fArr3 = v;
            fArr3[4] = fArr3[2];
            fArr3[5] = fArr3[3];
            float[][] fArr4 = u;
            fArr4[5] = fArr4[1];
            fArr4[6] = fArr4[2];
        }
        float[][] fArr5 = u;
        int i = this.d;
        this.k = fArr5[i][0];
        this.j = fArr5[i][1];
        int i2 = this.e;
        float[][] fArr6 = v;
        if (i2 >= fArr6.length) {
            return;
        }
        this.m = fArr6[i2][0];
        this.n = fArr6[i2][1];
    }

    public void setTouchAnchorLocation(float f, float f2) {
        this.k = f;
        this.j = f2;
    }

    public void setTouchUpMode(int i) {
        this.f = i;
    }

    public String toString() {
        if (Float.isNaN(this.m)) {
            return "rotation";
        }
        return this.m + " , " + this.n;
    }
}
