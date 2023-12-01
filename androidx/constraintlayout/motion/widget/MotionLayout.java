package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import android.view.Display;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import androidx.constraintlayout.core.motion.utils.KeyCache;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.core.widgets.Flow;
import androidx.constraintlayout.core.widgets.Guideline;
import androidx.constraintlayout.core.widgets.Helper;
import androidx.constraintlayout.core.widgets.HelperWidget;
import androidx.constraintlayout.core.widgets.Placeholder;
import androidx.constraintlayout.core.widgets.VirtualLayout;
import androidx.constraintlayout.motion.utils.StopLogic;
import androidx.constraintlayout.motion.utils.ViewState;
import androidx.constraintlayout.motion.widget.MotionScene;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintHelper;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.constraintlayout.widget.Constraints;
import androidx.constraintlayout.widget.R;
import androidx.core.view.NestedScrollingParent3;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/motion/widget/MotionLayout.class */
public class MotionLayout extends ConstraintLayout implements NestedScrollingParent3 {
    public static final int DEBUG_SHOW_NONE = 0;
    public static final int DEBUG_SHOW_PATH = 2;
    public static final int DEBUG_SHOW_PROGRESS = 1;
    public static boolean IS_IN_EDIT_MODE = false;
    public static final int TOUCH_UP_COMPLETE = 0;
    public static final int TOUCH_UP_COMPLETE_TO_END = 2;
    public static final int TOUCH_UP_COMPLETE_TO_START = 1;
    public static final int TOUCH_UP_DECELERATE = 4;
    public static final int TOUCH_UP_DECELERATE_AND_COMPLETE = 5;
    public static final int TOUCH_UP_NEVER_TO_END = 7;
    public static final int TOUCH_UP_NEVER_TO_START = 6;
    public static final int TOUCH_UP_STOP = 3;
    public static final int VELOCITY_LAYOUT = 1;
    public static final int VELOCITY_POST_LAYOUT = 0;
    public static final int VELOCITY_STATIC_LAYOUT = 3;
    public static final int VELOCITY_STATIC_POST_LAYOUT = 2;
    int A;
    int B;
    int C;
    int D;
    int E;
    float F;
    int G;
    int H;
    HashMap<View, ViewState> I;
    Rect J;
    TransitionState K;
    Model L;
    ArrayList<Integer> M;
    private int N;
    private int O;
    private int P;
    private int Q;
    private boolean R;
    private long S;
    private float T;
    private long U;
    private boolean V;
    private TransitionListener W;

    /* renamed from: a  reason: collision with root package name */
    MotionScene f2184a;
    private boolean aA;
    private RectF aB;
    private View aC;
    private Matrix aD;
    private float aa;
    private float ab;
    private boolean ac;
    private StopLogic ad;
    private DecelerateInterpolator ae;
    private DesignTool af;
    private boolean ag;
    private ArrayList<MotionHelper> ah;
    private ArrayList<MotionHelper> ai;
    private ArrayList<MotionHelper> aj;
    private CopyOnWriteArrayList<TransitionListener> ak;
    private int al;
    private long am;
    private float an;
    private int ao;
    private float ap;
    private KeyCache aq;

    /* renamed from: ar  reason: collision with root package name */
    private boolean f2185ar;
    private StateCache as;
    private Runnable at;
    private int[] au;
    private boolean av;
    private int aw;
    private int ax;
    private int ay;
    private boolean az;
    Interpolator b;

    /* renamed from: c  reason: collision with root package name */
    Interpolator f2186c;
    float d;
    int e;
    HashMap<View, MotionController> f;
    float g;
    float h;
    float i;
    boolean j;
    boolean k;
    int l;
    DevModeDraw m;
    boolean n;
    int o;
    int p;
    int q;
    int r;
    boolean s;
    float t;
    float u;
    long v;
    float w;
    boolean x;
    protected boolean y;
    int z;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: androidx.constraintlayout.motion.widget.MotionLayout$5  reason: invalid class name */
    /* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/motion/widget/MotionLayout$5.class */
    public static /* synthetic */ class AnonymousClass5 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f2191a;

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x0036 -> B:21:0x0014). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x003a -> B:19:0x001f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x003e -> B:25:0x002a). Please submit an issue!!! */
        static {
            int[] iArr = new int[TransitionState.values().length];
            f2191a = iArr;
            try {
                iArr[TransitionState.UNDEFINED.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f2191a[TransitionState.SETUP.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f2191a[TransitionState.MOVING.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f2191a[TransitionState.FINISHED.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/motion/widget/MotionLayout$DecelerateInterpolator.class */
    public class DecelerateInterpolator extends MotionInterpolator {

        /* renamed from: a  reason: collision with root package name */
        float f2192a = 0.0f;
        float b = 0.0f;

        /* renamed from: c  reason: collision with root package name */
        float f2193c;

        DecelerateInterpolator() {
        }

        public void config(float f, float f2, float f3) {
            this.f2192a = f;
            this.b = f2;
            this.f2193c = f3;
        }

        @Override // androidx.constraintlayout.motion.widget.MotionInterpolator, android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            float f2;
            float f3;
            float f4 = this.f2192a;
            if (f4 > 0.0f) {
                float f5 = this.f2193c;
                float f6 = f;
                if (f4 / f5 < f) {
                    f6 = f4 / f5;
                }
                MotionLayout.this.d = this.f2192a - (this.f2193c * f6);
                f2 = (this.f2192a * f6) - (((this.f2193c * f6) * f6) / 2.0f);
                f3 = this.b;
            } else {
                float f7 = -f4;
                float f8 = this.f2193c;
                float f9 = f;
                if (f7 / f8 < f) {
                    f9 = (-f4) / f8;
                }
                MotionLayout.this.d = this.f2192a + (this.f2193c * f9);
                f2 = (this.f2192a * f9) + (((this.f2193c * f9) * f9) / 2.0f);
                f3 = this.b;
            }
            return f2 + f3;
        }

        @Override // androidx.constraintlayout.motion.widget.MotionInterpolator
        public float getVelocity() {
            return MotionLayout.this.d;
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/motion/widget/MotionLayout$DevModeDraw.class */
    class DevModeDraw {

        /* renamed from: a  reason: collision with root package name */
        float[] f2194a;
        int[] b;

        /* renamed from: c  reason: collision with root package name */
        float[] f2195c;
        Path d;
        Paint e;
        Paint f;
        Paint g;
        Paint h;
        Paint i;
        DashPathEffect o;
        int p;
        int s;
        private float[] u;
        final int j = -21965;
        final int k = -2067046;
        final int l = -13391360;
        final int m = 1996488704;
        final int n = 10;
        Rect q = new Rect();
        boolean r = false;

        public DevModeDraw() {
            this.s = 1;
            Paint paint = new Paint();
            this.e = paint;
            paint.setAntiAlias(true);
            this.e.setColor(-21965);
            this.e.setStrokeWidth(2.0f);
            this.e.setStyle(Paint.Style.STROKE);
            Paint paint2 = new Paint();
            this.f = paint2;
            paint2.setAntiAlias(true);
            this.f.setColor(-2067046);
            this.f.setStrokeWidth(2.0f);
            this.f.setStyle(Paint.Style.STROKE);
            Paint paint3 = new Paint();
            this.g = paint3;
            paint3.setAntiAlias(true);
            this.g.setColor(-13391360);
            this.g.setStrokeWidth(2.0f);
            this.g.setStyle(Paint.Style.STROKE);
            Paint paint4 = new Paint();
            this.h = paint4;
            paint4.setAntiAlias(true);
            this.h.setColor(-13391360);
            this.h.setTextSize(MotionLayout.this.getContext().getResources().getDisplayMetrics().density * 12.0f);
            this.u = new float[8];
            Paint paint5 = new Paint();
            this.i = paint5;
            paint5.setAntiAlias(true);
            DashPathEffect dashPathEffect = new DashPathEffect(new float[]{4.0f, 8.0f}, 0.0f);
            this.o = dashPathEffect;
            this.g.setPathEffect(dashPathEffect);
            this.f2195c = new float[100];
            this.b = new int[50];
            if (this.r) {
                this.e.setStrokeWidth(8.0f);
                this.i.setStrokeWidth(8.0f);
                this.f.setStrokeWidth(8.0f);
                this.s = 4;
            }
        }

        private void a(Canvas canvas) {
            canvas.drawLines(this.f2194a, this.e);
        }

        private void a(Canvas canvas, float f, float f2) {
            float[] fArr = this.f2194a;
            float f3 = fArr[0];
            float f4 = fArr[1];
            float f5 = fArr[fArr.length - 2];
            float f6 = fArr[fArr.length - 1];
            float hypot = (float) Math.hypot(f3 - f5, f4 - f6);
            float f7 = f5 - f3;
            float f8 = f6 - f4;
            float f9 = (((f - f3) * f7) + ((f2 - f4) * f8)) / (hypot * hypot);
            float f10 = f3 + (f7 * f9);
            float f11 = f4 + (f9 * f8);
            Path path = new Path();
            path.moveTo(f, f2);
            path.lineTo(f10, f11);
            float hypot2 = (float) Math.hypot(f10 - f, f11 - f2);
            String str = "" + (((int) ((hypot2 * 100.0f) / hypot)) / 100.0f);
            a(str, this.h);
            canvas.drawTextOnPath(str, path, (hypot2 / 2.0f) - (this.q.width() / 2), -20.0f, this.h);
            canvas.drawLine(f, f2, f10, f11, this.g);
        }

        private void a(Canvas canvas, float f, float f2, float f3, float f4) {
            canvas.drawRect(f, f2, f3, f4, this.g);
            canvas.drawLine(f, f2, f3, f4, this.g);
        }

        private void a(Canvas canvas, float f, float f2, int i, int i2) {
            String str = "" + (((int) ((((f - (i / 2)) * 100.0f) / (MotionLayout.this.getWidth() - i)) + 0.5d)) / 100.0f);
            a(str, this.h);
            canvas.drawText(str, ((f / 2.0f) - (this.q.width() / 2)) + 0.0f, f2 - 20.0f, this.h);
            canvas.drawLine(f, f2, Math.min(0.0f, 1.0f), f2, this.g);
            String str2 = "" + (((int) ((((f2 - (i2 / 2)) * 100.0f) / (MotionLayout.this.getHeight() - i2)) + 0.5d)) / 100.0f);
            a(str2, this.h);
            canvas.drawText(str2, f + 5.0f, 0.0f - ((f2 / 2.0f) - (this.q.height() / 2)), this.h);
            canvas.drawLine(f, f2, f, Math.max(0.0f, 1.0f), this.g);
        }

        private void a(Canvas canvas, int i, int i2, MotionController motionController) {
            int i3;
            int i4;
            if (motionController.b != null) {
                i3 = motionController.b.getWidth();
                i4 = motionController.b.getHeight();
            } else {
                i3 = 0;
                i4 = 0;
            }
            int i5 = 1;
            while (true) {
                int i6 = i5;
                if (i6 >= i2 - 1) {
                    break;
                }
                if (i != 4 || this.b[i6 - 1] != 0) {
                    float[] fArr = this.f2195c;
                    int i7 = i6 * 2;
                    float f = fArr[i7];
                    float f2 = fArr[i7 + 1];
                    this.d.reset();
                    this.d.moveTo(f, f2 + 10.0f);
                    this.d.lineTo(f + 10.0f, f2);
                    this.d.lineTo(f, f2 - 10.0f);
                    this.d.lineTo(f - 10.0f, f2);
                    this.d.close();
                    int i8 = i6 - 1;
                    motionController.a(i8);
                    if (i == 4) {
                        int[] iArr = this.b;
                        if (iArr[i8] == 1) {
                            a(canvas, f - 0.0f, f2 - 0.0f);
                        } else if (iArr[i8] == 0) {
                            b(canvas, f - 0.0f, f2 - 0.0f);
                        } else if (iArr[i8] == 2) {
                            a(canvas, f - 0.0f, f2 - 0.0f, i3, i4);
                        }
                        canvas.drawPath(this.d, this.i);
                    }
                    if (i == 2) {
                        a(canvas, f - 0.0f, f2 - 0.0f);
                    }
                    if (i == 3) {
                        b(canvas, f - 0.0f, f2 - 0.0f);
                    }
                    if (i == 6) {
                        a(canvas, f - 0.0f, f2 - 0.0f, i3, i4);
                    }
                    canvas.drawPath(this.d, this.i);
                }
                i5 = i6 + 1;
            }
            float[] fArr2 = this.f2194a;
            if (fArr2.length > 1) {
                canvas.drawCircle(fArr2[0], fArr2[1], 8.0f, this.f);
                float[] fArr3 = this.f2194a;
                canvas.drawCircle(fArr3[fArr3.length - 2], fArr3[fArr3.length - 1], 8.0f, this.f);
            }
        }

        private void a(Canvas canvas, MotionController motionController) {
            this.d.reset();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 > 50) {
                    this.e.setColor(1140850688);
                    canvas.translate(2.0f, 2.0f);
                    canvas.drawPath(this.d, this.e);
                    canvas.translate(-2.0f, -2.0f);
                    this.e.setColor(-65536);
                    canvas.drawPath(this.d, this.e);
                    return;
                }
                motionController.a(i2 / 50, this.u, 0);
                Path path = this.d;
                float[] fArr = this.u;
                path.moveTo(fArr[0], fArr[1]);
                Path path2 = this.d;
                float[] fArr2 = this.u;
                path2.lineTo(fArr2[2], fArr2[3]);
                Path path3 = this.d;
                float[] fArr3 = this.u;
                path3.lineTo(fArr3[4], fArr3[5]);
                Path path4 = this.d;
                float[] fArr4 = this.u;
                path4.lineTo(fArr4[6], fArr4[7]);
                this.d.close();
                i = i2 + 1;
            }
        }

        private void b(Canvas canvas) {
            float[] fArr = this.f2194a;
            canvas.drawLine(fArr[0], fArr[1], fArr[fArr.length - 2], fArr[fArr.length - 1], this.g);
        }

        private void b(Canvas canvas, float f, float f2) {
            float[] fArr = this.f2194a;
            float f3 = fArr[0];
            float f4 = fArr[1];
            float f5 = fArr[fArr.length - 2];
            float f6 = fArr[fArr.length - 1];
            float min = Math.min(f3, f5);
            float max = Math.max(f4, f6);
            float min2 = f - Math.min(f3, f5);
            float max2 = Math.max(f4, f6) - f2;
            String str = "" + (((int) (((min2 * 100.0f) / Math.abs(f5 - f3)) + 0.5d)) / 100.0f);
            a(str, this.h);
            canvas.drawText(str, ((min2 / 2.0f) - (this.q.width() / 2)) + min, f2 - 20.0f, this.h);
            canvas.drawLine(f, f2, Math.min(f3, f5), f2, this.g);
            String str2 = "" + (((int) (((max2 * 100.0f) / Math.abs(f6 - f4)) + 0.5d)) / 100.0f);
            a(str2, this.h);
            canvas.drawText(str2, f + 5.0f, max - ((max2 / 2.0f) - (this.q.height() / 2)), this.h);
            canvas.drawLine(f, f2, f, Math.max(f4, f6), this.g);
        }

        private void c(Canvas canvas) {
            boolean z = false;
            boolean z2 = false;
            for (int i = 0; i < this.p; i++) {
                if (this.b[i] == 1) {
                    z = true;
                }
                if (this.b[i] == 0) {
                    z2 = true;
                }
            }
            if (z) {
                b(canvas);
            }
            if (z2) {
                d(canvas);
            }
        }

        private void d(Canvas canvas) {
            float[] fArr = this.f2194a;
            float f = fArr[0];
            float f2 = fArr[1];
            float f3 = fArr[fArr.length - 2];
            float f4 = fArr[fArr.length - 1];
            canvas.drawLine(Math.min(f, f3), Math.max(f2, f4), Math.max(f, f3), Math.max(f2, f4), this.g);
            canvas.drawLine(Math.min(f, f3), Math.min(f2, f4), Math.min(f, f3), Math.max(f2, f4), this.g);
        }

        void a(String str, Paint paint) {
            paint.getTextBounds(str, 0, str.length(), this.q);
        }

        public void draw(Canvas canvas, HashMap<View, MotionController> hashMap, int i, int i2) {
            if (hashMap == null || hashMap.size() == 0) {
                return;
            }
            canvas.save();
            if (!MotionLayout.this.isInEditMode() && (i2 & 1) == 2) {
                String str = MotionLayout.this.getContext().getResources().getResourceName(MotionLayout.this.O) + ":" + MotionLayout.this.getProgress();
                canvas.drawText(str, 10.0f, MotionLayout.this.getHeight() - 30, this.h);
                canvas.drawText(str, 11.0f, MotionLayout.this.getHeight() - 29, this.e);
            }
            for (MotionController motionController : hashMap.values()) {
                int drawPath = motionController.getDrawPath();
                int i3 = drawPath;
                if (i2 > 0) {
                    i3 = drawPath;
                    if (drawPath == 0) {
                        i3 = 1;
                    }
                }
                if (i3 != 0) {
                    this.p = motionController.a(this.f2195c, this.b);
                    if (i3 >= 1) {
                        int i4 = i / 16;
                        float[] fArr = this.f2194a;
                        if (fArr == null || fArr.length != i4 * 2) {
                            this.f2194a = new float[i4 * 2];
                            this.d = new Path();
                        }
                        int i5 = this.s;
                        canvas.translate(i5, i5);
                        this.e.setColor(1996488704);
                        this.i.setColor(1996488704);
                        this.f.setColor(1996488704);
                        this.g.setColor(1996488704);
                        motionController.a(this.f2194a, i4);
                        drawAll(canvas, i3, this.p, motionController);
                        this.e.setColor(-21965);
                        this.f.setColor(-2067046);
                        this.i.setColor(-2067046);
                        this.g.setColor(-13391360);
                        int i6 = this.s;
                        canvas.translate(-i6, -i6);
                        drawAll(canvas, i3, this.p, motionController);
                        if (i3 == 5) {
                            a(canvas, motionController);
                        }
                    }
                }
            }
            canvas.restore();
        }

        public void drawAll(Canvas canvas, int i, int i2, MotionController motionController) {
            if (i == 4) {
                c(canvas);
            }
            if (i == 2) {
                b(canvas);
            }
            if (i == 3) {
                d(canvas);
            }
            a(canvas);
            a(canvas, i, i2, motionController);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/motion/widget/MotionLayout$Model.class */
    public class Model {

        /* renamed from: a  reason: collision with root package name */
        ConstraintWidgetContainer f2196a = new ConstraintWidgetContainer();
        ConstraintWidgetContainer b = new ConstraintWidgetContainer();

        /* renamed from: c  reason: collision with root package name */
        ConstraintSet f2197c = null;
        ConstraintSet d = null;
        int e;
        int f;

        Model() {
        }

        private void a(int i, int i2) {
            int optimizationLevel = MotionLayout.this.getOptimizationLevel();
            if (MotionLayout.this.e != MotionLayout.this.getStartState()) {
                ConstraintSet constraintSet = this.f2197c;
                if (constraintSet != null) {
                    MotionLayout.this.resolveSystem(this.f2196a, optimizationLevel, constraintSet.mRotate == 0 ? i : i2, this.f2197c.mRotate == 0 ? i2 : i);
                }
                MotionLayout motionLayout = MotionLayout.this;
                ConstraintWidgetContainer constraintWidgetContainer = this.b;
                ConstraintSet constraintSet2 = this.d;
                int i3 = (constraintSet2 == null || constraintSet2.mRotate == 0) ? i : i2;
                ConstraintSet constraintSet3 = this.d;
                if (constraintSet3 == null || constraintSet3.mRotate == 0) {
                    i = i2;
                }
                motionLayout.resolveSystem(constraintWidgetContainer, optimizationLevel, i3, i);
                return;
            }
            MotionLayout motionLayout2 = MotionLayout.this;
            ConstraintWidgetContainer constraintWidgetContainer2 = this.b;
            ConstraintSet constraintSet4 = this.d;
            int i4 = (constraintSet4 == null || constraintSet4.mRotate == 0) ? i : i2;
            ConstraintSet constraintSet5 = this.d;
            motionLayout2.resolveSystem(constraintWidgetContainer2, optimizationLevel, i4, (constraintSet5 == null || constraintSet5.mRotate == 0) ? i2 : i);
            ConstraintSet constraintSet6 = this.f2197c;
            if (constraintSet6 != null) {
                MotionLayout motionLayout3 = MotionLayout.this;
                ConstraintWidgetContainer constraintWidgetContainer3 = this.f2196a;
                int i5 = constraintSet6.mRotate == 0 ? i : i2;
                if (this.f2197c.mRotate == 0) {
                    i = i2;
                }
                motionLayout3.resolveSystem(constraintWidgetContainer3, optimizationLevel, i5, i);
            }
        }

        private void a(ConstraintWidgetContainer constraintWidgetContainer, ConstraintSet constraintSet) {
            SparseArray<ConstraintWidget> sparseArray = new SparseArray<>();
            Constraints.LayoutParams layoutParams = new Constraints.LayoutParams(-2, -2);
            sparseArray.clear();
            sparseArray.put(0, constraintWidgetContainer);
            sparseArray.put(MotionLayout.this.getId(), constraintWidgetContainer);
            if (constraintSet != null && constraintSet.mRotate != 0) {
                MotionLayout motionLayout = MotionLayout.this;
                motionLayout.resolveSystem(this.b, motionLayout.getOptimizationLevel(), View.MeasureSpec.makeMeasureSpec(MotionLayout.this.getHeight(), 1073741824), View.MeasureSpec.makeMeasureSpec(MotionLayout.this.getWidth(), 1073741824));
            }
            Iterator<ConstraintWidget> it = constraintWidgetContainer.getChildren().iterator();
            while (it.hasNext()) {
                ConstraintWidget next = it.next();
                sparseArray.put(((View) next.getCompanionWidget()).getId(), next);
            }
            Iterator<ConstraintWidget> it2 = constraintWidgetContainer.getChildren().iterator();
            while (it2.hasNext()) {
                ConstraintWidget next2 = it2.next();
                View view = (View) next2.getCompanionWidget();
                constraintSet.applyToLayoutParams(view.getId(), layoutParams);
                next2.setWidth(constraintSet.getWidth(view.getId()));
                next2.setHeight(constraintSet.getHeight(view.getId()));
                if (view instanceof ConstraintHelper) {
                    constraintSet.applyToHelper((ConstraintHelper) view, next2, layoutParams, sparseArray);
                    if (view instanceof Barrier) {
                        ((Barrier) view).validateParams();
                    }
                }
                if (Build.VERSION.SDK_INT >= 17) {
                    layoutParams.resolveLayoutDirection(MotionLayout.this.getLayoutDirection());
                } else {
                    layoutParams.resolveLayoutDirection(0);
                }
                MotionLayout.this.applyConstraintsFromLayoutParams(false, view, next2, layoutParams, sparseArray);
                if (constraintSet.getVisibilityMode(view.getId()) == 1) {
                    next2.setVisibility(view.getVisibility());
                } else {
                    next2.setVisibility(constraintSet.getVisibility(view.getId()));
                }
            }
            Iterator<ConstraintWidget> it3 = constraintWidgetContainer.getChildren().iterator();
            while (it3.hasNext()) {
                ConstraintWidget next3 = it3.next();
                if (next3 instanceof VirtualLayout) {
                    ConstraintHelper constraintHelper = (ConstraintHelper) next3.getCompanionWidget();
                    Helper helper = (Helper) next3;
                    constraintHelper.updatePreLayout(constraintWidgetContainer, helper, sparseArray);
                    ((VirtualLayout) helper).captureWidgets();
                }
            }
        }

        ConstraintWidget a(ConstraintWidgetContainer constraintWidgetContainer, View view) {
            if (constraintWidgetContainer.getCompanionWidget() == view) {
                return constraintWidgetContainer;
            }
            ArrayList<ConstraintWidget> children = constraintWidgetContainer.getChildren();
            int size = children.size();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= size) {
                    return null;
                }
                ConstraintWidget constraintWidget = children.get(i2);
                if (constraintWidget.getCompanionWidget() == view) {
                    return constraintWidget;
                }
                i = i2 + 1;
            }
        }

        void a(ConstraintWidgetContainer constraintWidgetContainer, ConstraintWidgetContainer constraintWidgetContainer2) {
            ArrayList<ConstraintWidget> children = constraintWidgetContainer.getChildren();
            HashMap<ConstraintWidget, ConstraintWidget> hashMap = new HashMap<>();
            hashMap.put(constraintWidgetContainer, constraintWidgetContainer2);
            constraintWidgetContainer2.getChildren().clear();
            constraintWidgetContainer2.copy(constraintWidgetContainer, hashMap);
            Iterator<ConstraintWidget> it = children.iterator();
            while (it.hasNext()) {
                ConstraintWidget next = it.next();
                ConstraintWidget barrier = next instanceof androidx.constraintlayout.core.widgets.Barrier ? new androidx.constraintlayout.core.widgets.Barrier() : next instanceof Guideline ? new Guideline() : next instanceof Flow ? new Flow() : next instanceof Placeholder ? new Placeholder() : next instanceof Helper ? new HelperWidget() : new ConstraintWidget();
                constraintWidgetContainer2.add(barrier);
                hashMap.put(next, barrier);
            }
            Iterator<ConstraintWidget> it2 = children.iterator();
            while (it2.hasNext()) {
                ConstraintWidget next2 = it2.next();
                hashMap.get(next2).copy(next2, hashMap);
            }
        }

        void a(ConstraintWidgetContainer constraintWidgetContainer, ConstraintSet constraintSet, ConstraintSet constraintSet2) {
            this.f2197c = constraintSet;
            this.d = constraintSet2;
            this.f2196a = new ConstraintWidgetContainer();
            this.b = new ConstraintWidgetContainer();
            this.f2196a.setMeasurer(MotionLayout.this.mLayoutWidget.getMeasurer());
            this.b.setMeasurer(MotionLayout.this.mLayoutWidget.getMeasurer());
            this.f2196a.removeAllChildren();
            this.b.removeAllChildren();
            a(MotionLayout.this.mLayoutWidget, this.f2196a);
            a(MotionLayout.this.mLayoutWidget, this.b);
            if (MotionLayout.this.h > 0.5d) {
                if (constraintSet != null) {
                    a(this.f2196a, constraintSet);
                }
                a(this.b, constraintSet2);
            } else {
                a(this.b, constraintSet2);
                if (constraintSet != null) {
                    a(this.f2196a, constraintSet);
                }
            }
            this.f2196a.setRtl(MotionLayout.this.isRtl());
            this.f2196a.updateHierarchy();
            this.b.setRtl(MotionLayout.this.isRtl());
            this.b.updateHierarchy();
            ViewGroup.LayoutParams layoutParams = MotionLayout.this.getLayoutParams();
            if (layoutParams != null) {
                if (layoutParams.width == -2) {
                    this.f2196a.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.WRAP_CONTENT);
                    this.b.setHorizontalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.WRAP_CONTENT);
                }
                if (layoutParams.height == -2) {
                    this.f2196a.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.WRAP_CONTENT);
                    this.b.setVerticalDimensionBehaviour(ConstraintWidget.DimensionBehaviour.WRAP_CONTENT);
                }
            }
        }

        public void build() {
            int childCount = MotionLayout.this.getChildCount();
            MotionLayout.this.f.clear();
            SparseArray sparseArray = new SparseArray();
            int[] iArr = new int[childCount];
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= childCount) {
                    break;
                }
                View childAt = MotionLayout.this.getChildAt(i2);
                MotionController motionController = new MotionController(childAt);
                int id = childAt.getId();
                iArr[i2] = id;
                sparseArray.put(id, motionController);
                MotionLayout.this.f.put(childAt, motionController);
                i = i2 + 1;
            }
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 >= childCount) {
                    break;
                }
                View childAt2 = MotionLayout.this.getChildAt(i4);
                MotionController motionController2 = MotionLayout.this.f.get(childAt2);
                if (motionController2 != null) {
                    if (this.f2197c != null) {
                        ConstraintWidget a2 = a(this.f2196a, childAt2);
                        if (a2 != null) {
                            motionController2.a(MotionLayout.this.a(a2), this.f2197c, MotionLayout.this.getWidth(), MotionLayout.this.getHeight());
                        } else if (MotionLayout.this.l != 0) {
                            Log.e("MotionLayout", Debug.getLocation() + "no widget for  " + Debug.getName(childAt2) + " (" + childAt2.getClass().getName() + ")");
                        }
                    } else if (MotionLayout.this.av) {
                        motionController2.setStartState(MotionLayout.this.I.get(childAt2), childAt2, MotionLayout.this.H, MotionLayout.this.aw, MotionLayout.this.ax);
                    }
                    if (this.d != null) {
                        ConstraintWidget a3 = a(this.b, childAt2);
                        if (a3 != null) {
                            motionController2.b(MotionLayout.this.a(a3), this.d, MotionLayout.this.getWidth(), MotionLayout.this.getHeight());
                        } else if (MotionLayout.this.l != 0) {
                            Log.e("MotionLayout", Debug.getLocation() + "no widget for  " + Debug.getName(childAt2) + " (" + childAt2.getClass().getName() + ")");
                        }
                    }
                }
                i3 = i4 + 1;
            }
            int i5 = 0;
            while (true) {
                int i6 = i5;
                if (i6 >= childCount) {
                    return;
                }
                MotionController motionController3 = (MotionController) sparseArray.get(iArr[i6]);
                int animateRelativeTo = motionController3.getAnimateRelativeTo();
                if (animateRelativeTo != -1) {
                    motionController3.setupRelative((MotionController) sparseArray.get(animateRelativeTo));
                }
                i5 = i6 + 1;
            }
        }

        public boolean isNotConfiguredWith(int i, int i2) {
            return (i == this.e && i2 == this.f) ? false : true;
        }

        public void measure(int i, int i2) {
            int mode = View.MeasureSpec.getMode(i);
            int mode2 = View.MeasureSpec.getMode(i2);
            MotionLayout.this.D = mode;
            MotionLayout.this.E = mode2;
            MotionLayout.this.getOptimizationLevel();
            a(i, i2);
            if (((MotionLayout.this.getParent() instanceof MotionLayout) && mode == 1073741824 && mode2 == 1073741824) ? false : true) {
                a(i, i2);
                MotionLayout.this.z = this.f2196a.getWidth();
                MotionLayout.this.A = this.f2196a.getHeight();
                MotionLayout.this.B = this.b.getWidth();
                MotionLayout.this.C = this.b.getHeight();
                MotionLayout motionLayout = MotionLayout.this;
                motionLayout.y = (motionLayout.z == MotionLayout.this.B && MotionLayout.this.A == MotionLayout.this.C) ? false : true;
            }
            int i3 = MotionLayout.this.z;
            int i4 = MotionLayout.this.A;
            if (MotionLayout.this.D == Integer.MIN_VALUE || MotionLayout.this.D == 0) {
                i3 = (int) (MotionLayout.this.z + (MotionLayout.this.F * (MotionLayout.this.B - MotionLayout.this.z)));
            }
            if (MotionLayout.this.E == Integer.MIN_VALUE || MotionLayout.this.E == 0) {
                i4 = (int) (MotionLayout.this.A + (MotionLayout.this.F * (MotionLayout.this.C - MotionLayout.this.A)));
            }
            MotionLayout.this.resolveMeasuredDimension(i, i2, i3, i4, this.f2196a.isWidthMeasuredTooSmall() || this.b.isWidthMeasuredTooSmall(), this.f2196a.isHeightMeasuredTooSmall() || this.b.isHeightMeasuredTooSmall());
        }

        public void reEvaluateState() {
            measure(MotionLayout.this.P, MotionLayout.this.Q);
            MotionLayout.this.d();
        }

        public void setMeasuredId(int i, int i2) {
            this.e = i;
            this.f = i2;
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/motion/widget/MotionLayout$MotionTracker.class */
    public interface MotionTracker {
        void addMovement(MotionEvent motionEvent);

        void clear();

        void computeCurrentVelocity(int i);

        void computeCurrentVelocity(int i, float f);

        float getXVelocity();

        float getXVelocity(int i);

        float getYVelocity();

        float getYVelocity(int i);

        void recycle();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/motion/widget/MotionLayout$MyTracker.class */
    public static class MyTracker implements MotionTracker {
        private static MyTracker b = new MyTracker();

        /* renamed from: a  reason: collision with root package name */
        VelocityTracker f2198a;

        private MyTracker() {
        }

        public static MyTracker obtain() {
            b.f2198a = VelocityTracker.obtain();
            return b;
        }

        @Override // androidx.constraintlayout.motion.widget.MotionLayout.MotionTracker
        public void addMovement(MotionEvent motionEvent) {
            VelocityTracker velocityTracker = this.f2198a;
            if (velocityTracker != null) {
                velocityTracker.addMovement(motionEvent);
            }
        }

        @Override // androidx.constraintlayout.motion.widget.MotionLayout.MotionTracker
        public void clear() {
            VelocityTracker velocityTracker = this.f2198a;
            if (velocityTracker != null) {
                velocityTracker.clear();
            }
        }

        @Override // androidx.constraintlayout.motion.widget.MotionLayout.MotionTracker
        public void computeCurrentVelocity(int i) {
            VelocityTracker velocityTracker = this.f2198a;
            if (velocityTracker != null) {
                velocityTracker.computeCurrentVelocity(i);
            }
        }

        @Override // androidx.constraintlayout.motion.widget.MotionLayout.MotionTracker
        public void computeCurrentVelocity(int i, float f) {
            VelocityTracker velocityTracker = this.f2198a;
            if (velocityTracker != null) {
                velocityTracker.computeCurrentVelocity(i, f);
            }
        }

        @Override // androidx.constraintlayout.motion.widget.MotionLayout.MotionTracker
        public float getXVelocity() {
            VelocityTracker velocityTracker = this.f2198a;
            if (velocityTracker != null) {
                return velocityTracker.getXVelocity();
            }
            return 0.0f;
        }

        @Override // androidx.constraintlayout.motion.widget.MotionLayout.MotionTracker
        public float getXVelocity(int i) {
            VelocityTracker velocityTracker = this.f2198a;
            if (velocityTracker != null) {
                return velocityTracker.getXVelocity(i);
            }
            return 0.0f;
        }

        @Override // androidx.constraintlayout.motion.widget.MotionLayout.MotionTracker
        public float getYVelocity() {
            VelocityTracker velocityTracker = this.f2198a;
            if (velocityTracker != null) {
                return velocityTracker.getYVelocity();
            }
            return 0.0f;
        }

        @Override // androidx.constraintlayout.motion.widget.MotionLayout.MotionTracker
        public float getYVelocity(int i) {
            if (this.f2198a != null) {
                return getYVelocity(i);
            }
            return 0.0f;
        }

        @Override // androidx.constraintlayout.motion.widget.MotionLayout.MotionTracker
        public void recycle() {
            VelocityTracker velocityTracker = this.f2198a;
            if (velocityTracker != null) {
                velocityTracker.recycle();
                this.f2198a = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/motion/widget/MotionLayout$StateCache.class */
    public class StateCache {

        /* renamed from: a  reason: collision with root package name */
        float f2199a = Float.NaN;
        float b = Float.NaN;

        /* renamed from: c  reason: collision with root package name */
        int f2200c = -1;
        int d = -1;
        final String e = "motion.progress";
        final String f = "motion.velocity";
        final String g = "motion.StartState";
        final String h = "motion.EndState";

        StateCache() {
        }

        void a() {
            if (this.f2200c != -1 || this.d != -1) {
                int i = this.f2200c;
                if (i == -1) {
                    MotionLayout.this.transitionToState(this.d);
                } else {
                    int i2 = this.d;
                    if (i2 == -1) {
                        MotionLayout.this.setState(i, -1, -1);
                    } else {
                        MotionLayout.this.setTransition(i, i2);
                    }
                }
                MotionLayout.this.setState(TransitionState.SETUP);
            }
            if (Float.isNaN(this.b)) {
                if (Float.isNaN(this.f2199a)) {
                    return;
                }
                MotionLayout.this.setProgress(this.f2199a);
                return;
            }
            MotionLayout.this.setProgress(this.f2199a, this.b);
            this.f2199a = Float.NaN;
            this.b = Float.NaN;
            this.f2200c = -1;
            this.d = -1;
        }

        public Bundle getTransitionState() {
            Bundle bundle = new Bundle();
            bundle.putFloat("motion.progress", this.f2199a);
            bundle.putFloat("motion.velocity", this.b);
            bundle.putInt("motion.StartState", this.f2200c);
            bundle.putInt("motion.EndState", this.d);
            return bundle;
        }

        public void recordState() {
            this.d = MotionLayout.this.O;
            this.f2200c = MotionLayout.this.N;
            this.b = MotionLayout.this.getVelocity();
            this.f2199a = MotionLayout.this.getProgress();
        }

        public void setEndState(int i) {
            this.d = i;
        }

        public void setProgress(float f) {
            this.f2199a = f;
        }

        public void setStartState(int i) {
            this.f2200c = i;
        }

        public void setTransitionState(Bundle bundle) {
            this.f2199a = bundle.getFloat("motion.progress");
            this.b = bundle.getFloat("motion.velocity");
            this.f2200c = bundle.getInt("motion.StartState");
            this.d = bundle.getInt("motion.EndState");
        }

        public void setVelocity(float f) {
            this.b = f;
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/motion/widget/MotionLayout$TransitionListener.class */
    public interface TransitionListener {
        void onTransitionChange(MotionLayout motionLayout, int i, int i2, float f);

        void onTransitionCompleted(MotionLayout motionLayout, int i);

        void onTransitionStarted(MotionLayout motionLayout, int i, int i2);

        void onTransitionTrigger(MotionLayout motionLayout, int i, boolean z, float f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/motion/widget/MotionLayout$TransitionState.class */
    public enum TransitionState {
        UNDEFINED,
        SETUP,
        MOVING,
        FINISHED
    }

    public MotionLayout(Context context) {
        super(context);
        this.f2186c = null;
        this.d = 0.0f;
        this.N = -1;
        this.e = -1;
        this.O = -1;
        this.P = 0;
        this.Q = 0;
        this.R = true;
        this.f = new HashMap<>();
        this.S = 0L;
        this.T = 1.0f;
        this.g = 0.0f;
        this.h = 0.0f;
        this.i = 0.0f;
        this.j = false;
        this.k = false;
        this.l = 0;
        this.ac = false;
        this.ad = new StopLogic();
        this.ae = new DecelerateInterpolator();
        this.n = true;
        this.s = false;
        this.ag = false;
        this.ah = null;
        this.ai = null;
        this.aj = null;
        this.ak = null;
        this.al = 0;
        this.am = -1L;
        this.an = 0.0f;
        this.ao = 0;
        this.ap = 0.0f;
        this.x = false;
        this.y = false;
        this.aq = new KeyCache();
        this.f2185ar = false;
        this.at = null;
        this.au = null;
        this.G = 0;
        this.av = false;
        this.H = 0;
        this.I = new HashMap<>();
        this.J = new Rect();
        this.az = false;
        this.K = TransitionState.UNDEFINED;
        this.L = new Model();
        this.aA = false;
        this.aB = new RectF();
        this.aC = null;
        this.aD = null;
        this.M = new ArrayList<>();
        a((AttributeSet) null);
    }

    public MotionLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2186c = null;
        this.d = 0.0f;
        this.N = -1;
        this.e = -1;
        this.O = -1;
        this.P = 0;
        this.Q = 0;
        this.R = true;
        this.f = new HashMap<>();
        this.S = 0L;
        this.T = 1.0f;
        this.g = 0.0f;
        this.h = 0.0f;
        this.i = 0.0f;
        this.j = false;
        this.k = false;
        this.l = 0;
        this.ac = false;
        this.ad = new StopLogic();
        this.ae = new DecelerateInterpolator();
        this.n = true;
        this.s = false;
        this.ag = false;
        this.ah = null;
        this.ai = null;
        this.aj = null;
        this.ak = null;
        this.al = 0;
        this.am = -1L;
        this.an = 0.0f;
        this.ao = 0;
        this.ap = 0.0f;
        this.x = false;
        this.y = false;
        this.aq = new KeyCache();
        this.f2185ar = false;
        this.at = null;
        this.au = null;
        this.G = 0;
        this.av = false;
        this.H = 0;
        this.I = new HashMap<>();
        this.J = new Rect();
        this.az = false;
        this.K = TransitionState.UNDEFINED;
        this.L = new Model();
        this.aA = false;
        this.aB = new RectF();
        this.aC = null;
        this.aD = null;
        this.M = new ArrayList<>();
        a(attributeSet);
    }

    public MotionLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f2186c = null;
        this.d = 0.0f;
        this.N = -1;
        this.e = -1;
        this.O = -1;
        this.P = 0;
        this.Q = 0;
        this.R = true;
        this.f = new HashMap<>();
        this.S = 0L;
        this.T = 1.0f;
        this.g = 0.0f;
        this.h = 0.0f;
        this.i = 0.0f;
        this.j = false;
        this.k = false;
        this.l = 0;
        this.ac = false;
        this.ad = new StopLogic();
        this.ae = new DecelerateInterpolator();
        this.n = true;
        this.s = false;
        this.ag = false;
        this.ah = null;
        this.ai = null;
        this.aj = null;
        this.ak = null;
        this.al = 0;
        this.am = -1L;
        this.an = 0.0f;
        this.ao = 0;
        this.ap = 0.0f;
        this.x = false;
        this.y = false;
        this.aq = new KeyCache();
        this.f2185ar = false;
        this.at = null;
        this.au = null;
        this.G = 0;
        this.av = false;
        this.H = 0;
        this.I = new HashMap<>();
        this.J = new Rect();
        this.az = false;
        this.K = TransitionState.UNDEFINED;
        this.L = new Model();
        this.aA = false;
        this.aB = new RectF();
        this.aC = null;
        this.aD = null;
        this.M = new ArrayList<>();
        a(attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Rect a(ConstraintWidget constraintWidget) {
        this.J.top = constraintWidget.getY();
        this.J.left = constraintWidget.getX();
        this.J.right = constraintWidget.getWidth() + this.J.left;
        this.J.bottom = constraintWidget.getHeight() + this.J.top;
        return this.J;
    }

    private void a(int i, ConstraintSet constraintSet) {
        View childAt;
        String name = Debug.getName(getContext(), i);
        int childCount = getChildCount();
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= childCount) {
                break;
            }
            int id = getChildAt(i3).getId();
            if (id == -1) {
                Log.w("MotionLayout", "CHECK: " + name + " ALL VIEWS SHOULD HAVE ID's " + childAt.getClass().getName() + " does not!");
            }
            if (constraintSet.getConstraint(id) == null) {
                Log.w("MotionLayout", "CHECK: " + name + " NO CONSTRAINTS for " + Debug.getName(childAt));
            }
            i2 = i3 + 1;
        }
        int[] knownIds = constraintSet.getKnownIds();
        int i4 = 0;
        while (true) {
            int i5 = i4;
            if (i5 >= knownIds.length) {
                return;
            }
            int i6 = knownIds[i5];
            String name2 = Debug.getName(getContext(), i6);
            if (findViewById(knownIds[i5]) == null) {
                Log.w("MotionLayout", "CHECK: " + name + " NO View matches id " + name2);
            }
            if (constraintSet.getHeight(i6) == -1) {
                Log.w("MotionLayout", "CHECK: " + name + "(" + name2 + ") no LAYOUT_HEIGHT");
            }
            if (constraintSet.getWidth(i6) == -1) {
                Log.w("MotionLayout", "CHECK: " + name + "(" + name2 + ") no LAYOUT_HEIGHT");
            }
            i4 = i5 + 1;
        }
    }

    private void a(AttributeSet attributeSet) {
        MotionScene motionScene;
        boolean z;
        boolean z2;
        IS_IN_EDIT_MODE = isInEditMode();
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.MotionLayout);
            int indexCount = obtainStyledAttributes.getIndexCount();
            int i = 0;
            boolean z3 = true;
            while (true) {
                z = z3;
                if (i >= indexCount) {
                    break;
                }
                int index = obtainStyledAttributes.getIndex(i);
                if (index == R.styleable.MotionLayout_layoutDescription) {
                    this.f2184a = new MotionScene(getContext(), this, obtainStyledAttributes.getResourceId(index, -1));
                    z2 = z;
                } else if (index == R.styleable.MotionLayout_currentState) {
                    this.e = obtainStyledAttributes.getResourceId(index, -1);
                    z2 = z;
                } else if (index == R.styleable.MotionLayout_motionProgress) {
                    this.i = obtainStyledAttributes.getFloat(index, 0.0f);
                    this.j = true;
                    z2 = z;
                } else if (index == R.styleable.MotionLayout_applyMotionScene) {
                    z2 = obtainStyledAttributes.getBoolean(index, z);
                } else if (index == R.styleable.MotionLayout_showPaths) {
                    z2 = z;
                    if (this.l == 0) {
                        this.l = obtainStyledAttributes.getBoolean(index, false) ? 2 : 0;
                        z2 = z;
                    }
                } else {
                    z2 = z;
                    if (index == R.styleable.MotionLayout_motionDebug) {
                        this.l = obtainStyledAttributes.getInt(index, 0);
                        z2 = z;
                    }
                }
                i++;
                z3 = z2;
            }
            obtainStyledAttributes.recycle();
            if (this.f2184a == null) {
                Log.e("MotionLayout", "WARNING NO app:layoutDescription tag");
            }
            if (!z) {
                this.f2184a = null;
            }
        }
        if (this.l != 0) {
            g();
        }
        if (this.e != -1 || (motionScene = this.f2184a) == null) {
            return;
        }
        this.e = motionScene.b();
        this.N = this.f2184a.b();
        this.O = this.f2184a.c();
    }

    private void a(MotionScene.Transition transition) {
        if (transition.getStartConstraintSetId() == transition.getEndConstraintSetId()) {
            Log.e("MotionLayout", "CHECK: start and end constraint set should not be the same!");
        }
    }

    private static boolean a(float f, float f2, float f3) {
        if (f > 0.0f) {
            float f4 = f / f3;
            return f2 + ((f * f4) - (((f3 * f4) * f4) / 2.0f)) > 1.0f;
        }
        float f5 = (-f) / f3;
        return f2 + ((f * f5) + (((f3 * f5) * f5) / 2.0f)) < 0.0f;
    }

    private boolean a(float f, float f2, View view, MotionEvent motionEvent) {
        boolean z;
        View childAt;
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            while (true) {
                int i = childCount - 1;
                if (i < 0) {
                    break;
                }
                if (a((childAt.getLeft() + f) - view.getScrollX(), (childAt.getTop() + f2) - view.getScrollY(), viewGroup.getChildAt(i), motionEvent)) {
                    z = true;
                    break;
                }
                childCount = i;
            }
        }
        z = false;
        if (!z) {
            this.aB.set(f, f2, (view.getRight() + f) - view.getLeft(), (view.getBottom() + f2) - view.getTop());
            if ((motionEvent.getAction() != 0 || this.aB.contains(motionEvent.getX(), motionEvent.getY())) && a(view, motionEvent, -f, -f2)) {
                return true;
            }
        }
        return z;
    }

    private boolean a(View view, MotionEvent motionEvent, float f, float f2) {
        Matrix matrix = view.getMatrix();
        if (matrix.isIdentity()) {
            motionEvent.offsetLocation(f, f2);
            boolean onTouchEvent = view.onTouchEvent(motionEvent);
            motionEvent.offsetLocation(-f, -f2);
            return onTouchEvent;
        }
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        obtain.offsetLocation(f, f2);
        if (this.aD == null) {
            this.aD = new Matrix();
        }
        matrix.invert(this.aD);
        obtain.transform(this.aD);
        boolean onTouchEvent2 = view.onTouchEvent(obtain);
        obtain.recycle();
        return onTouchEvent2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        int i;
        boolean z;
        int i2;
        int childCount = getChildCount();
        this.L.build();
        this.j = true;
        SparseArray sparseArray = new SparseArray();
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= childCount) {
                break;
            }
            View childAt = getChildAt(i4);
            sparseArray.put(childAt.getId(), this.f.get(childAt));
            i3 = i4 + 1;
        }
        int width = getWidth();
        int height = getHeight();
        int gatPathMotionArc = this.f2184a.gatPathMotionArc();
        if (gatPathMotionArc != -1) {
            int i5 = 0;
            while (true) {
                int i6 = i5;
                if (i6 >= childCount) {
                    break;
                }
                MotionController motionController = this.f.get(getChildAt(i6));
                if (motionController != null) {
                    motionController.setPathMotionArc(gatPathMotionArc);
                }
                i5 = i6 + 1;
            }
        }
        SparseBooleanArray sparseBooleanArray = new SparseBooleanArray();
        int[] iArr = new int[this.f.size()];
        int i7 = 0;
        int i8 = 0;
        while (true) {
            i = i8;
            if (i7 >= childCount) {
                break;
            }
            MotionController motionController2 = this.f.get(getChildAt(i7));
            int i9 = i;
            if (motionController2.getAnimateRelativeTo() != -1) {
                sparseBooleanArray.put(motionController2.getAnimateRelativeTo(), true);
                iArr[i] = motionController2.getAnimateRelativeTo();
                i9 = i + 1;
            }
            i7++;
            i8 = i9;
        }
        if (this.aj == null) {
            int i10 = 0;
            while (true) {
                int i11 = i10;
                if (i11 >= i) {
                    break;
                }
                MotionController motionController3 = this.f.get(findViewById(iArr[i11]));
                if (motionController3 != null) {
                    this.f2184a.getKeyFrames(motionController3);
                    motionController3.setup(width, height, this.T, getNanoTime());
                }
                i10 = i11 + 1;
            }
        } else {
            int i12 = 0;
            while (true) {
                int i13 = i12;
                if (i13 >= i) {
                    break;
                }
                MotionController motionController4 = this.f.get(findViewById(iArr[i13]));
                if (motionController4 != null) {
                    this.f2184a.getKeyFrames(motionController4);
                }
                i12 = i13 + 1;
            }
            Iterator<MotionHelper> it = this.aj.iterator();
            while (it.hasNext()) {
                it.next().onPreSetup(this, this.f);
            }
            int i14 = 0;
            while (true) {
                int i15 = i14;
                if (i15 >= i) {
                    break;
                }
                MotionController motionController5 = this.f.get(findViewById(iArr[i15]));
                if (motionController5 != null) {
                    motionController5.setup(width, height, this.T, getNanoTime());
                }
                i14 = i15 + 1;
            }
        }
        int i16 = 0;
        while (true) {
            int i17 = i16;
            if (i17 >= childCount) {
                break;
            }
            View childAt2 = getChildAt(i17);
            MotionController motionController6 = this.f.get(childAt2);
            if (!sparseBooleanArray.get(childAt2.getId()) && motionController6 != null) {
                this.f2184a.getKeyFrames(motionController6);
                motionController6.setup(width, height, this.T, getNanoTime());
            }
            i16 = i17 + 1;
        }
        float staggered = this.f2184a.getStaggered();
        if (staggered != 0.0f) {
            boolean z2 = ((double) staggered) < 0.0d;
            float abs = Math.abs(staggered);
            int i18 = 0;
            float f = Float.MAX_VALUE;
            float f2 = -3.4028235E38f;
            while (true) {
                if (i18 >= childCount) {
                    z = false;
                    break;
                }
                MotionController motionController7 = this.f.get(getChildAt(i18));
                if (!Float.isNaN(motionController7.f)) {
                    z = true;
                    break;
                }
                float finalX = motionController7.getFinalX();
                float finalY = motionController7.getFinalY();
                float f3 = z2 ? finalY - finalX : finalY + finalX;
                f = Math.min(f, f3);
                f2 = Math.max(f2, f3);
                i18++;
            }
            if (!z) {
                for (int i19 = 0; i19 < childCount; i19++) {
                    MotionController motionController8 = this.f.get(getChildAt(i19));
                    float finalX2 = motionController8.getFinalX();
                    float finalY2 = motionController8.getFinalY();
                    float f4 = z2 ? finalY2 - finalX2 : finalY2 + finalX2;
                    motionController8.h = 1.0f / (1.0f - abs);
                    motionController8.g = abs - (((f4 - f) * abs) / (f2 - f));
                }
                return;
            }
            int i20 = 0;
            float f5 = Float.MAX_VALUE;
            float f6 = -3.4028235E38f;
            while (true) {
                if (i20 >= childCount) {
                    break;
                }
                MotionController motionController9 = this.f.get(getChildAt(i20));
                float f7 = f6;
                float f8 = f5;
                if (!Float.isNaN(motionController9.f)) {
                    f8 = Math.min(f5, motionController9.f);
                    f7 = Math.max(f6, motionController9.f);
                }
                i20++;
                f6 = f7;
                f5 = f8;
            }
            for (i2 = 0; i2 < childCount; i2++) {
                MotionController motionController10 = this.f.get(getChildAt(i2));
                if (!Float.isNaN(motionController10.f)) {
                    motionController10.h = 1.0f / (1.0f - abs);
                    if (z2) {
                        motionController10.g = abs - (((f6 - motionController10.f) / (f6 - f5)) * abs);
                    } else {
                        motionController10.g = abs - (((motionController10.f - f5) * abs) / (f6 - f5));
                    }
                }
            }
        }
    }

    private void e() {
        int childCount = getChildCount();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= childCount) {
                return;
            }
            View childAt = getChildAt(i2);
            MotionController motionController = this.f.get(childAt);
            if (motionController != null) {
                motionController.a(childAt);
            }
            i = i2 + 1;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x00d5, code lost:
        if (r8 <= r7.i) goto L24;
     */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x014e  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0147 A[EDGE_INSN: B:50:0x0147->B:46:0x0147 ?: BREAK  , SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:54:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void f() {
        /*
            Method dump skipped, instructions count: 339
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.MotionLayout.f():void");
    }

    private void g() {
        MotionScene motionScene = this.f2184a;
        if (motionScene == null) {
            Log.e("MotionLayout", "CHECK: motion scene not set! set \"app:layoutDescription=\"@xml/file\"");
            return;
        }
        int b = motionScene.b();
        MotionScene motionScene2 = this.f2184a;
        a(b, motionScene2.a(motionScene2.b()));
        SparseIntArray sparseIntArray = new SparseIntArray();
        SparseIntArray sparseIntArray2 = new SparseIntArray();
        Iterator<MotionScene.Transition> it = this.f2184a.getDefinedTransitions().iterator();
        while (it.hasNext()) {
            MotionScene.Transition next = it.next();
            if (next == this.f2184a.b) {
                Log.v("MotionLayout", "CHECK: CURRENT");
            }
            a(next);
            int startConstraintSetId = next.getStartConstraintSetId();
            int endConstraintSetId = next.getEndConstraintSetId();
            String name = Debug.getName(getContext(), startConstraintSetId);
            String name2 = Debug.getName(getContext(), endConstraintSetId);
            if (sparseIntArray.get(startConstraintSetId) == endConstraintSetId) {
                Log.e("MotionLayout", "CHECK: two transitions with the same start and end " + name + "->" + name2);
            }
            if (sparseIntArray2.get(endConstraintSetId) == startConstraintSetId) {
                Log.e("MotionLayout", "CHECK: you can't have reverse transitions" + name + "->" + name2);
            }
            sparseIntArray.put(startConstraintSetId, endConstraintSetId);
            sparseIntArray2.put(endConstraintSetId, startConstraintSetId);
            if (this.f2184a.a(startConstraintSetId) == null) {
                Log.e("MotionLayout", " no such constraintSetStart " + name);
            }
            if (this.f2184a.a(endConstraintSetId) == null) {
                Log.e("MotionLayout", " no such constraintSetEnd " + name);
            }
        }
    }

    private void h() {
        CopyOnWriteArrayList<TransitionListener> copyOnWriteArrayList;
        if ((this.W == null && ((copyOnWriteArrayList = this.ak) == null || copyOnWriteArrayList.isEmpty())) || this.ap == this.g) {
            return;
        }
        if (this.ao != -1) {
            TransitionListener transitionListener = this.W;
            if (transitionListener != null) {
                transitionListener.onTransitionStarted(this, this.N, this.O);
            }
            CopyOnWriteArrayList<TransitionListener> copyOnWriteArrayList2 = this.ak;
            if (copyOnWriteArrayList2 != null) {
                Iterator<TransitionListener> it = copyOnWriteArrayList2.iterator();
                while (it.hasNext()) {
                    it.next().onTransitionStarted(this, this.N, this.O);
                }
            }
            this.x = true;
        }
        this.ao = -1;
        float f = this.g;
        this.ap = f;
        TransitionListener transitionListener2 = this.W;
        if (transitionListener2 != null) {
            transitionListener2.onTransitionChange(this, this.N, this.O, f);
        }
        CopyOnWriteArrayList<TransitionListener> copyOnWriteArrayList3 = this.ak;
        if (copyOnWriteArrayList3 != null) {
            Iterator<TransitionListener> it2 = copyOnWriteArrayList3.iterator();
            while (it2.hasNext()) {
                it2.next().onTransitionChange(this, this.N, this.O, this.g);
            }
        }
        this.x = true;
    }

    private void i() {
        CopyOnWriteArrayList<TransitionListener> copyOnWriteArrayList;
        if (this.W == null && ((copyOnWriteArrayList = this.ak) == null || copyOnWriteArrayList.isEmpty())) {
            return;
        }
        this.x = false;
        Iterator<Integer> it = this.M.iterator();
        while (it.hasNext()) {
            Integer next = it.next();
            TransitionListener transitionListener = this.W;
            if (transitionListener != null) {
                transitionListener.onTransitionCompleted(this, next.intValue());
            }
            CopyOnWriteArrayList<TransitionListener> copyOnWriteArrayList2 = this.ak;
            if (copyOnWriteArrayList2 != null) {
                Iterator<TransitionListener> it2 = copyOnWriteArrayList2.iterator();
                while (it2.hasNext()) {
                    it2.next().onTransitionCompleted(this, next.intValue());
                }
            }
        }
        this.M.clear();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int a(String str) {
        MotionScene motionScene = this.f2184a;
        if (motionScene == null) {
            return 0;
        }
        return motionScene.lookUpConstraintId(str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MotionController a(int i) {
        return this.f.get(findViewById(i));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public MotionTracker a() {
        return MyTracker.obtain();
    }

    void a(float f) {
        if (this.f2184a == null) {
            return;
        }
        float f2 = this.h;
        float f3 = this.g;
        if (f2 != f3 && this.V) {
            this.h = f3;
        }
        float f4 = this.h;
        if (f4 == f) {
            return;
        }
        this.ac = false;
        this.i = f;
        this.T = this.f2184a.getDuration() / 1000.0f;
        setProgress(this.i);
        this.b = null;
        this.f2186c = this.f2184a.getInterpolator();
        this.V = false;
        this.S = getNanoTime();
        this.j = true;
        this.g = f4;
        this.h = f4;
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i, float f, float f2, float f3, float[] fArr) {
        String resourceName;
        HashMap<View, MotionController> hashMap = this.f;
        View viewById = getViewById(i);
        MotionController motionController = hashMap.get(viewById);
        if (motionController != null) {
            motionController.a(f, f2, f3, fArr);
            float y = viewById.getY();
            float f4 = this.aa;
            this.aa = f;
            this.ab = y;
            return;
        }
        if (viewById == null) {
            resourceName = "" + i;
        } else {
            resourceName = viewById.getContext().getResources().getResourceName(i);
        }
        Log.w("MotionLayout", "WARNING could not find view id " + resourceName);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(boolean z) {
        int childCount = getChildCount();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= childCount) {
                return;
            }
            MotionController motionController = this.f.get(getChildAt(i2));
            if (motionController != null) {
                motionController.a(z);
            }
            i = i2 + 1;
        }
    }

    public void addTransitionListener(TransitionListener transitionListener) {
        if (this.ak == null) {
            this.ak = new CopyOnWriteArrayList<>();
        }
        this.ak.add(transitionListener);
    }

    public boolean applyViewTransition(int i, MotionController motionController) {
        MotionScene motionScene = this.f2184a;
        if (motionScene != null) {
            return motionScene.applyViewTransition(i, motionController);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String b(int i) {
        MotionScene motionScene = this.f2184a;
        if (motionScene == null) {
            return null;
        }
        return motionScene.lookUpConstraintName(i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        MotionScene motionScene = this.f2184a;
        if (motionScene == null) {
            return;
        }
        if (motionScene.a(this, this.e)) {
            requestLayout();
            return;
        }
        int i = this.e;
        if (i != -1) {
            this.f2184a.addOnClickListeners(this, i);
        }
        if (this.f2184a.a()) {
            this.f2184a.l();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:164:0x047c, code lost:
        if (r11 == 0.0f) goto L156;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x005c, code lost:
        if (r8.i != r8.h) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x025e, code lost:
        if (r10 <= r8.i) goto L86;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x027a, code lost:
        if (r12 <= 0.0f) goto L91;
     */
    /* JADX WARN: Removed duplicated region for block: B:102:0x02f9  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x033b  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0364  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x037e  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0399  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x03de  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x0419  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x0454  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x0492  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x04b3  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x04ea  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x0336 A[EDGE_INSN: B:186:0x0336->B:106:0x0336 ?: BREAK  , SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x022e  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x023d  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0273  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x02ad  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x02b2  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x02c6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void b(boolean r9) {
        /*
            Method dump skipped, instructions count: 1278
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.MotionLayout.b(boolean):void");
    }

    protected void c() {
        int i;
        CopyOnWriteArrayList<TransitionListener> copyOnWriteArrayList;
        if ((this.W != null || ((copyOnWriteArrayList = this.ak) != null && !copyOnWriteArrayList.isEmpty())) && this.ao == -1) {
            this.ao = this.e;
            if (this.M.isEmpty()) {
                i = -1;
            } else {
                ArrayList<Integer> arrayList = this.M;
                i = arrayList.get(arrayList.size() - 1).intValue();
            }
            int i2 = this.e;
            if (i != i2 && i2 != -1) {
                this.M.add(Integer.valueOf(i2));
            }
        }
        i();
        Runnable runnable = this.at;
        if (runnable != null) {
            runnable.run();
        }
        int[] iArr = this.au;
        if (iArr == null || this.G <= 0) {
            return;
        }
        transitionToState(iArr[0]);
        int[] iArr2 = this.au;
        System.arraycopy((Object) iArr2, 1, (Object) iArr2, 0, iArr2.length - 1);
        this.G--;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(boolean z) {
        MotionScene motionScene = this.f2184a;
        if (motionScene == null) {
            return;
        }
        motionScene.disableAutoTransition(z);
    }

    public ConstraintSet cloneConstraintSet(int i) {
        MotionScene motionScene = this.f2184a;
        if (motionScene == null) {
            return null;
        }
        ConstraintSet a2 = motionScene.a(i);
        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.clone(a2);
        return constraintSet;
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        long j;
        ArrayList<MotionHelper> arrayList = this.aj;
        if (arrayList != null) {
            Iterator<MotionHelper> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().onPreDraw(canvas);
            }
        }
        b(false);
        MotionScene motionScene = this.f2184a;
        if (motionScene != null && motionScene.f2205c != null) {
            this.f2184a.f2205c.a();
        }
        super.dispatchDraw(canvas);
        if (this.f2184a == null) {
            return;
        }
        if ((this.l & 1) == 1 && !isInEditMode()) {
            this.al++;
            long nanoTime = getNanoTime();
            long j2 = this.am;
            if (j2 != -1) {
                if (nanoTime - j2 > 200000000) {
                    this.an = ((int) ((this.al / (((float) j) * 1.0E-9f)) * 100.0f)) / 100.0f;
                    this.al = 0;
                    this.am = nanoTime;
                }
            } else {
                this.am = nanoTime;
            }
            Paint paint = new Paint();
            paint.setTextSize(42.0f);
            StringBuilder sb = new StringBuilder();
            sb.append(this.an + " fps " + Debug.getState(this, this.N) + " -> ");
            sb.append(Debug.getState(this, this.O));
            sb.append(" (progress: ");
            sb.append(((int) (getProgress() * 1000.0f)) / 10.0f);
            sb.append(" ) state=");
            int i = this.e;
            sb.append(i == -1 ? "undefined" : Debug.getState(this, i));
            String sb2 = sb.toString();
            paint.setColor(-16777216);
            canvas.drawText(sb2, 11.0f, getHeight() - 29, paint);
            paint.setColor(-7864184);
            canvas.drawText(sb2, 10.0f, getHeight() - 30, paint);
        }
        if (this.l > 1) {
            if (this.m == null) {
                this.m = new DevModeDraw();
            }
            this.m.draw(canvas, this.f, this.f2184a.getDuration(), this.l);
        }
        ArrayList<MotionHelper> arrayList2 = this.aj;
        if (arrayList2 != null) {
            Iterator<MotionHelper> it2 = arrayList2.iterator();
            while (it2.hasNext()) {
                it2.next().onPostDraw(canvas);
            }
        }
    }

    public void enableTransition(int i, boolean z) {
        MotionScene.Transition transition = getTransition(i);
        if (z) {
            transition.setEnabled(true);
            return;
        }
        if (transition == this.f2184a.b) {
            Iterator<MotionScene.Transition> it = this.f2184a.getTransitionsWithState(this.e).iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                MotionScene.Transition next = it.next();
                if (next.isEnabled()) {
                    this.f2184a.b = next;
                    break;
                }
            }
        }
        transition.setEnabled(false);
    }

    public void enableViewTransition(int i, boolean z) {
        MotionScene motionScene = this.f2184a;
        if (motionScene != null) {
            motionScene.enableViewTransition(i, z);
        }
    }

    public void fireTrigger(int i, boolean z, float f) {
        TransitionListener transitionListener = this.W;
        if (transitionListener != null) {
            transitionListener.onTransitionTrigger(this, i, z, f);
        }
        CopyOnWriteArrayList<TransitionListener> copyOnWriteArrayList = this.ak;
        if (copyOnWriteArrayList != null) {
            Iterator<TransitionListener> it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                it.next().onTransitionTrigger(this, i, z, f);
            }
        }
    }

    public ConstraintSet getConstraintSet(int i) {
        MotionScene motionScene = this.f2184a;
        if (motionScene == null) {
            return null;
        }
        return motionScene.a(i);
    }

    public int[] getConstraintSetIds() {
        MotionScene motionScene = this.f2184a;
        if (motionScene == null) {
            return null;
        }
        return motionScene.getConstraintSetIds();
    }

    public int getCurrentState() {
        return this.e;
    }

    public void getDebugMode(boolean z) {
        this.l = z ? 2 : 1;
        invalidate();
    }

    public ArrayList<MotionScene.Transition> getDefinedTransitions() {
        MotionScene motionScene = this.f2184a;
        if (motionScene == null) {
            return null;
        }
        return motionScene.getDefinedTransitions();
    }

    public DesignTool getDesignTool() {
        if (this.af == null) {
            this.af = new DesignTool(this);
        }
        return this.af;
    }

    public int getEndState() {
        return this.O;
    }

    protected long getNanoTime() {
        return System.nanoTime();
    }

    public float getProgress() {
        return this.h;
    }

    public MotionScene getScene() {
        return this.f2184a;
    }

    public int getStartState() {
        return this.N;
    }

    public float getTargetPosition() {
        return this.i;
    }

    public MotionScene.Transition getTransition(int i) {
        return this.f2184a.getTransitionById(i);
    }

    public Bundle getTransitionState() {
        if (this.as == null) {
            this.as = new StateCache();
        }
        this.as.recordState();
        return this.as.getTransitionState();
    }

    public long getTransitionTimeMs() {
        MotionScene motionScene = this.f2184a;
        if (motionScene != null) {
            this.T = motionScene.getDuration() / 1000.0f;
        }
        return this.T * 1000.0f;
    }

    public float getVelocity() {
        return this.d;
    }

    public void getViewVelocity(View view, float f, float f2, float[] fArr, int i) {
        float f3 = this.d;
        float f4 = this.h;
        if (this.b != null) {
            float signum = Math.signum(this.i - f4);
            float interpolation = this.b.getInterpolation(this.h + 1.0E-5f);
            f4 = this.b.getInterpolation(this.h);
            f3 = (signum * ((interpolation - f4) / 1.0E-5f)) / this.T;
        }
        Interpolator interpolator = this.b;
        if (interpolator instanceof MotionInterpolator) {
            f3 = ((MotionInterpolator) interpolator).getVelocity();
        }
        MotionController motionController = this.f.get(view);
        if ((i & 1) == 0) {
            motionController.a(f4, view.getWidth(), view.getHeight(), f, f2, fArr);
        } else {
            motionController.a(f4, f, f2, fArr);
        }
        if (i < 2) {
            fArr[0] = fArr[0] * f3;
            fArr[1] = fArr[1] * f3;
        }
    }

    @Override // android.view.View
    public boolean isAttachedToWindow() {
        return Build.VERSION.SDK_INT >= 19 ? super.isAttachedToWindow() : getWindowToken() != null;
    }

    public boolean isDelayedApplicationOfInitialState() {
        return this.az;
    }

    public boolean isInRotation() {
        return this.av;
    }

    public boolean isInteractionEnabled() {
        return this.R;
    }

    public boolean isViewTransitionEnabled(int i) {
        MotionScene motionScene = this.f2184a;
        if (motionScene != null) {
            return motionScene.isViewTransitionEnabled(i);
        }
        return false;
    }

    public void jumpToState(int i) {
        if (!isAttachedToWindow()) {
            this.e = i;
        }
        if (this.N == i) {
            setProgress(0.0f);
        } else if (this.O == i) {
            setProgress(1.0f);
        } else {
            setTransition(i, i);
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout
    public void loadLayoutDescription(int i) {
        if (i == 0) {
            this.f2184a = null;
            return;
        }
        try {
            MotionScene motionScene = new MotionScene(getContext(), this, i);
            this.f2184a = motionScene;
            if (this.e == -1 && motionScene != null) {
                this.e = motionScene.b();
                this.N = this.f2184a.b();
                this.O = this.f2184a.c();
            }
            if (Build.VERSION.SDK_INT >= 19 && !isAttachedToWindow()) {
                this.f2184a = null;
                return;
            }
            try {
                if (Build.VERSION.SDK_INT >= 17) {
                    Display display = getDisplay();
                    this.ay = display == null ? 0 : display.getRotation();
                }
                if (this.f2184a != null) {
                    ConstraintSet a2 = this.f2184a.a(this.e);
                    this.f2184a.a(this);
                    if (this.aj != null) {
                        Iterator<MotionHelper> it = this.aj.iterator();
                        while (it.hasNext()) {
                            it.next().onFinishedMotionScene(this);
                        }
                    }
                    if (a2 != null) {
                        a2.applyTo(this);
                    }
                    this.N = this.e;
                }
                b();
                if (this.as != null) {
                    if (this.az) {
                        post(new Runnable() { // from class: androidx.constraintlayout.motion.widget.MotionLayout.1
                            @Override // java.lang.Runnable
                            public void run() {
                                MotionLayout.this.as.a();
                            }
                        });
                    } else {
                        this.as.a();
                    }
                } else if (this.f2184a == null || this.f2184a.b == null || this.f2184a.b.getAutoTransition() != 4) {
                } else {
                    transitionToEnd();
                    setState(TransitionState.SETUP);
                    setState(TransitionState.MOVING);
                }
            } catch (Exception e) {
                throw new IllegalArgumentException("unable to parse MotionScene file", e);
            }
        } catch (Exception e2) {
            throw new IllegalArgumentException("unable to parse MotionScene file", e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        int i;
        Display display;
        super.onAttachedToWindow();
        if (Build.VERSION.SDK_INT >= 17 && (display = getDisplay()) != null) {
            this.ay = display.getRotation();
        }
        MotionScene motionScene = this.f2184a;
        if (motionScene != null && (i = this.e) != -1) {
            ConstraintSet a2 = motionScene.a(i);
            this.f2184a.a(this);
            ArrayList<MotionHelper> arrayList = this.aj;
            if (arrayList != null) {
                Iterator<MotionHelper> it = arrayList.iterator();
                while (it.hasNext()) {
                    it.next().onFinishedMotionScene(this);
                }
            }
            if (a2 != null) {
                a2.applyTo(this);
            }
            this.N = this.e;
        }
        b();
        StateCache stateCache = this.as;
        if (stateCache != null) {
            if (this.az) {
                post(new Runnable() { // from class: androidx.constraintlayout.motion.widget.MotionLayout.4
                    @Override // java.lang.Runnable
                    public void run() {
                        MotionLayout.this.as.a();
                    }
                });
                return;
            } else {
                stateCache.a();
                return;
            }
        }
        MotionScene motionScene2 = this.f2184a;
        if (motionScene2 == null || motionScene2.b == null || this.f2184a.b.getAutoTransition() != 4) {
            return;
        }
        transitionToEnd();
        setState(TransitionState.SETUP);
        setState(TransitionState.MOVING);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        TouchResponse touchResponse;
        int d;
        RectF a2;
        MotionScene motionScene = this.f2184a;
        if (motionScene == null || !this.R) {
            return false;
        }
        if (motionScene.f2205c != null) {
            this.f2184a.f2205c.a(motionEvent);
        }
        MotionScene.Transition transition = this.f2184a.b;
        if (transition == null || !transition.isEnabled() || (touchResponse = transition.getTouchResponse()) == null) {
            return false;
        }
        if ((motionEvent.getAction() != 0 || (a2 = touchResponse.a(this, new RectF())) == null || a2.contains(motionEvent.getX(), motionEvent.getY())) && (d = touchResponse.d()) != -1) {
            View view = this.aC;
            if (view == null || view.getId() != d) {
                this.aC = findViewById(d);
            }
            View view2 = this.aC;
            if (view2 != null) {
                this.aB.set(view2.getLeft(), this.aC.getTop(), this.aC.getRight(), this.aC.getBottom());
                if (!this.aB.contains(motionEvent.getX(), motionEvent.getY()) || a(this.aC.getLeft(), this.aC.getTop(), this.aC, motionEvent)) {
                    return false;
                }
                return onTouchEvent(motionEvent);
            }
            return false;
        }
        return false;
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.f2185ar = true;
        try {
            if (this.f2184a == null) {
                super.onLayout(z, i, i2, i3, i4);
                return;
            }
            int i5 = i3 - i;
            int i6 = i4 - i2;
            if (this.q != i5 || this.r != i6) {
                rebuildScene();
                b(true);
            }
            this.q = i5;
            this.r = i6;
            this.o = i5;
            this.p = i6;
        } finally {
            this.f2185ar = false;
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.View
    public void onMeasure(int i, int i2) {
        boolean z;
        int i3;
        int i4;
        if (this.f2184a == null) {
            super.onMeasure(i, i2);
            return;
        }
        boolean z2 = (this.P == i && this.Q == i2) ? false : true;
        if (this.aA) {
            this.aA = false;
            b();
            i();
            z2 = true;
        }
        if (this.mDirtyHierarchy) {
            z2 = true;
        }
        this.P = i;
        this.Q = i2;
        int b = this.f2184a.b();
        int c2 = this.f2184a.c();
        if ((z2 || this.L.isNotConfiguredWith(b, c2)) && this.N != -1) {
            super.onMeasure(i, i2);
            this.L.a(this.mLayoutWidget, this.f2184a.a(b), this.f2184a.a(c2));
            this.L.reEvaluateState();
            this.L.setMeasuredId(b, c2);
            z = false;
        } else {
            if (z2) {
                super.onMeasure(i, i2);
            }
            z = true;
        }
        if (this.y || z) {
            int paddingTop = getPaddingTop();
            int paddingBottom = getPaddingBottom();
            int width = this.mLayoutWidget.getWidth() + getPaddingLeft() + getPaddingRight();
            int height = this.mLayoutWidget.getHeight() + paddingTop + paddingBottom;
            int i5 = this.D;
            if (i5 == Integer.MIN_VALUE || i5 == 0) {
                width = (int) (this.z + (this.F * (this.B - i3)));
                requestLayout();
            }
            int i6 = this.E;
            if (i6 == Integer.MIN_VALUE || i6 == 0) {
                height = (int) (this.A + (this.F * (this.C - i4)));
                requestLayout();
            }
            setMeasuredDimension(width, height);
        }
        f();
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedFling(View view, float f, float f2, boolean z) {
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public boolean onNestedPreFling(View view, float f, float f2) {
        return false;
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedPreScroll(final View view, int i, int i2, int[] iArr, int i3) {
        MotionScene.Transition transition;
        TouchResponse touchResponse;
        int d;
        MotionScene motionScene = this.f2184a;
        if (motionScene == null || (transition = motionScene.b) == null || !transition.isEnabled()) {
            return;
        }
        if (!transition.isEnabled() || (touchResponse = transition.getTouchResponse()) == null || (d = touchResponse.d()) == -1 || view.getId() == d) {
            if (motionScene.m()) {
                TouchResponse touchResponse2 = transition.getTouchResponse();
                int i4 = -1;
                if (touchResponse2 != null) {
                    i4 = -1;
                    if ((touchResponse2.getFlags() & 4) != 0) {
                        i4 = i2;
                    }
                }
                float f = this.g;
                if ((f == 1.0f || f == 0.0f) && view.canScrollVertically(i4)) {
                    return;
                }
            }
            if (transition.getTouchResponse() != null && (transition.getTouchResponse().getFlags() & 1) != 0) {
                float c2 = motionScene.c(i, i2);
                if ((this.h <= 0.0f && c2 < 0.0f) || (this.h >= 1.0f && c2 > 0.0f)) {
                    if (Build.VERSION.SDK_INT >= 21) {
                        view.setNestedScrollingEnabled(false);
                        view.post(new Runnable() { // from class: androidx.constraintlayout.motion.widget.MotionLayout.3
                            @Override // java.lang.Runnable
                            public void run() {
                                view.setNestedScrollingEnabled(true);
                            }
                        });
                        return;
                    }
                    return;
                }
            }
            float f2 = this.g;
            long nanoTime = getNanoTime();
            float f3 = i;
            this.t = f3;
            float f4 = i2;
            this.u = f4;
            this.w = (float) ((nanoTime - this.v) * 1.0E-9d);
            this.v = nanoTime;
            motionScene.a(f3, f4);
            if (f2 != this.g) {
                iArr[0] = i;
                iArr[1] = i2;
            }
            b(false);
            if (iArr[0] == 0 && iArr[1] == 0) {
                return;
            }
            this.s = true;
        }
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedScroll(View view, int i, int i2, int i3, int i4, int i5) {
    }

    @Override // androidx.core.view.NestedScrollingParent3
    public void onNestedScroll(View view, int i, int i2, int i3, int i4, int i5, int[] iArr) {
        if (this.s || i != 0 || i2 != 0) {
            iArr[0] = iArr[0] + i3;
            iArr[1] = iArr[1] + i4;
        }
        this.s = false;
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onNestedScrollAccepted(View view, View view2, int i, int i2) {
        this.v = getNanoTime();
        this.w = 0.0f;
        this.t = 0.0f;
        this.u = 0.0f;
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int i) {
        MotionScene motionScene = this.f2184a;
        if (motionScene != null) {
            motionScene.setRtl(isRtl());
        }
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public boolean onStartNestedScroll(View view, View view2, int i, int i2) {
        MotionScene motionScene = this.f2184a;
        return (motionScene == null || motionScene.b == null || this.f2184a.b.getTouchResponse() == null || (this.f2184a.b.getTouchResponse().getFlags() & 2) != 0) ? false : true;
    }

    @Override // androidx.core.view.NestedScrollingParent2
    public void onStopNestedScroll(View view, int i) {
        MotionScene motionScene = this.f2184a;
        if (motionScene != null) {
            float f = this.w;
            if (f == 0.0f) {
                return;
            }
            motionScene.b(this.t / f, this.u / f);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        MotionScene motionScene = this.f2184a;
        if (motionScene != null && this.R && motionScene.a()) {
            MotionScene.Transition transition = this.f2184a.b;
            if (transition == null || transition.isEnabled()) {
                this.f2184a.a(motionEvent, getCurrentState(), this);
                if (this.f2184a.b.isTransitionFlag(4)) {
                    return this.f2184a.b.getTouchResponse().e();
                }
                return true;
            }
            return super.onTouchEvent(motionEvent);
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup
    public void onViewAdded(View view) {
        super.onViewAdded(view);
        if (view instanceof MotionHelper) {
            MotionHelper motionHelper = (MotionHelper) view;
            if (this.ak == null) {
                this.ak = new CopyOnWriteArrayList<>();
            }
            this.ak.add(motionHelper);
            if (motionHelper.isUsedOnShow()) {
                if (this.ah == null) {
                    this.ah = new ArrayList<>();
                }
                this.ah.add(motionHelper);
            }
            if (motionHelper.isUseOnHide()) {
                if (this.ai == null) {
                    this.ai = new ArrayList<>();
                }
                this.ai.add(motionHelper);
            }
            if (motionHelper.isDecorator()) {
                if (this.aj == null) {
                    this.aj = new ArrayList<>();
                }
                this.aj.add(motionHelper);
            }
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup
    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        ArrayList<MotionHelper> arrayList = this.ah;
        if (arrayList != null) {
            arrayList.remove(view);
        }
        ArrayList<MotionHelper> arrayList2 = this.ai;
        if (arrayList2 != null) {
            arrayList2.remove(view);
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout
    public void parseLayoutDescription(int i) {
        this.mConstraintLayoutSpec = null;
    }

    @Deprecated
    public void rebuildMotion() {
        Log.e("MotionLayout", "This method is deprecated. Please call rebuildScene() instead.");
        rebuildScene();
    }

    public void rebuildScene() {
        this.L.reEvaluateState();
        invalidate();
    }

    public boolean removeTransitionListener(TransitionListener transitionListener) {
        CopyOnWriteArrayList<TransitionListener> copyOnWriteArrayList = this.ak;
        if (copyOnWriteArrayList == null) {
            return false;
        }
        return copyOnWriteArrayList.remove(transitionListener);
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.View, android.view.ViewParent
    public void requestLayout() {
        MotionScene motionScene;
        if (!this.y && this.e == -1 && (motionScene = this.f2184a) != null && motionScene.b != null) {
            int layoutDuringTransition = this.f2184a.b.getLayoutDuringTransition();
            if (layoutDuringTransition == 0) {
                return;
            }
            if (layoutDuringTransition == 2) {
                int childCount = getChildCount();
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= childCount) {
                        return;
                    }
                    this.f.get(getChildAt(i2)).remeasure();
                    i = i2 + 1;
                }
            }
        }
        super.requestLayout();
    }

    public void rotateTo(int i, int i2) {
        int i3 = 1;
        this.av = true;
        this.aw = getWidth();
        this.ax = getHeight();
        int rotation = getDisplay().getRotation();
        if ((rotation + 1) % 4 <= (this.ay + 1) % 4) {
            i3 = 2;
        }
        this.H = i3;
        this.ay = rotation;
        int childCount = getChildCount();
        int i4 = 0;
        while (true) {
            int i5 = i4;
            if (i5 >= childCount) {
                break;
            }
            View childAt = getChildAt(i5);
            ViewState viewState = this.I.get(childAt);
            ViewState viewState2 = viewState;
            if (viewState == null) {
                viewState2 = new ViewState();
                this.I.put(childAt, viewState2);
            }
            viewState2.getState(childAt);
            i4 = i5 + 1;
        }
        this.N = -1;
        this.O = i;
        this.f2184a.a(-1, i);
        this.L.a(this.mLayoutWidget, null, this.f2184a.a(this.O));
        this.g = 0.0f;
        this.h = 0.0f;
        invalidate();
        transitionToEnd(new Runnable() { // from class: androidx.constraintlayout.motion.widget.MotionLayout.2
            @Override // java.lang.Runnable
            public void run() {
                MotionLayout.this.av = false;
            }
        });
        if (i2 > 0) {
            this.T = i2 / 1000.0f;
        }
    }

    public void scheduleTransitionTo(int i) {
        if (getCurrentState() == -1) {
            transitionToState(i);
            return;
        }
        int[] iArr = this.au;
        if (iArr == null) {
            this.au = new int[4];
        } else if (iArr.length <= this.G) {
            this.au = Arrays.copyOf(iArr, iArr.length * 2);
        }
        int[] iArr2 = this.au;
        int i2 = this.G;
        this.G = i2 + 1;
        iArr2[i2] = i;
    }

    public void setDebugMode(int i) {
        this.l = i;
        invalidate();
    }

    public void setDelayedApplicationOfInitialState(boolean z) {
        this.az = z;
    }

    public void setInteractionEnabled(boolean z) {
        this.R = z;
    }

    public void setInterpolatedProgress(float f) {
        if (this.f2184a != null) {
            setState(TransitionState.MOVING);
            Interpolator interpolator = this.f2184a.getInterpolator();
            if (interpolator != null) {
                setProgress(interpolator.getInterpolation(f));
                return;
            }
        }
        setProgress(f);
    }

    public void setOnHide(float f) {
        ArrayList<MotionHelper> arrayList = this.ai;
        if (arrayList == null) {
            return;
        }
        int size = arrayList.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                return;
            }
            this.ai.get(i2).setProgress(f);
            i = i2 + 1;
        }
    }

    public void setOnShow(float f) {
        ArrayList<MotionHelper> arrayList = this.ah;
        if (arrayList == null) {
            return;
        }
        int size = arrayList.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                return;
            }
            this.ah.get(i2).setProgress(f);
            i = i2 + 1;
        }
    }

    public void setProgress(float f) {
        int i = (f > 0.0f ? 1 : (f == 0.0f ? 0 : -1));
        if (i < 0 || f > 1.0f) {
            Log.w("MotionLayout", "Warning! Progress is defined for values between 0.0 and 1.0 inclusive");
        }
        if (!isAttachedToWindow()) {
            if (this.as == null) {
                this.as = new StateCache();
            }
            this.as.setProgress(f);
            return;
        }
        if (i <= 0) {
            if (this.h == 1.0f && this.e == this.O) {
                setState(TransitionState.MOVING);
            }
            this.e = this.N;
            if (this.h == 0.0f) {
                setState(TransitionState.FINISHED);
            }
        } else if (f >= 1.0f) {
            if (this.h == 0.0f && this.e == this.N) {
                setState(TransitionState.MOVING);
            }
            this.e = this.O;
            if (this.h == 1.0f) {
                setState(TransitionState.FINISHED);
            }
        } else {
            this.e = -1;
            setState(TransitionState.MOVING);
        }
        if (this.f2184a == null) {
            return;
        }
        this.V = true;
        this.i = f;
        this.g = f;
        this.U = -1L;
        this.S = -1L;
        this.b = null;
        this.j = true;
        invalidate();
    }

    public void setProgress(float f, float f2) {
        if (!isAttachedToWindow()) {
            if (this.as == null) {
                this.as = new StateCache();
            }
            this.as.setProgress(f);
            this.as.setVelocity(f2);
            return;
        }
        setProgress(f);
        setState(TransitionState.MOVING);
        this.d = f2;
        float f3 = 1.0f;
        int i = (f2 > 0.0f ? 1 : (f2 == 0.0f ? 0 : -1));
        if (i != 0) {
            if (i <= 0) {
                f3 = 0.0f;
            }
            a(f3);
        } else if (f == 0.0f || f == 1.0f) {
        } else {
            if (f <= 0.5f) {
                f3 = 0.0f;
            }
            a(f3);
        }
    }

    public void setScene(MotionScene motionScene) {
        this.f2184a = motionScene;
        motionScene.setRtl(isRtl());
        rebuildScene();
    }

    void setStartState(int i) {
        if (isAttachedToWindow()) {
            this.e = i;
            return;
        }
        if (this.as == null) {
            this.as = new StateCache();
        }
        this.as.setStartState(i);
        this.as.setEndState(i);
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout
    public void setState(int i, int i2, int i3) {
        setState(TransitionState.SETUP);
        this.e = i;
        this.N = -1;
        this.O = -1;
        if (this.mConstraintLayoutSpec != null) {
            this.mConstraintLayoutSpec.updateConstraints(i, i2, i3);
            return;
        }
        MotionScene motionScene = this.f2184a;
        if (motionScene != null) {
            motionScene.a(i).applyTo(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setState(TransitionState transitionState) {
        if (transitionState == TransitionState.FINISHED && this.e == -1) {
            return;
        }
        TransitionState transitionState2 = this.K;
        this.K = transitionState;
        if (transitionState2 == TransitionState.MOVING && transitionState == TransitionState.MOVING) {
            h();
        }
        int i = AnonymousClass5.f2191a[transitionState2.ordinal()];
        if (i != 1 && i != 2) {
            if (i == 3 && transitionState == TransitionState.FINISHED) {
                c();
                return;
            }
            return;
        }
        if (transitionState == TransitionState.MOVING) {
            h();
        }
        if (transitionState == TransitionState.FINISHED) {
            c();
        }
    }

    public void setTransition(int i) {
        if (this.f2184a != null) {
            MotionScene.Transition transition = getTransition(i);
            this.N = transition.getStartConstraintSetId();
            this.O = transition.getEndConstraintSetId();
            if (!isAttachedToWindow()) {
                if (this.as == null) {
                    this.as = new StateCache();
                }
                this.as.setStartState(this.N);
                this.as.setEndState(this.O);
                return;
            }
            float f = Float.NaN;
            int i2 = this.e;
            float f2 = 0.0f;
            if (i2 == this.N) {
                f = 0.0f;
            } else if (i2 == this.O) {
                f = 1.0f;
            }
            this.f2184a.setTransition(transition);
            this.L.a(this.mLayoutWidget, this.f2184a.a(this.N), this.f2184a.a(this.O));
            rebuildScene();
            if (this.h != f) {
                if (f == 0.0f) {
                    a(true);
                    this.f2184a.a(this.N).applyTo(this);
                } else if (f == 1.0f) {
                    a(false);
                    this.f2184a.a(this.O).applyTo(this);
                }
            }
            if (!Float.isNaN(f)) {
                f2 = f;
            }
            this.h = f2;
            if (!Float.isNaN(f)) {
                setProgress(f);
                return;
            }
            Log.v("MotionLayout", Debug.getLocation() + " transitionToStart ");
            transitionToStart();
        }
    }

    public void setTransition(int i, int i2) {
        if (!isAttachedToWindow()) {
            if (this.as == null) {
                this.as = new StateCache();
            }
            this.as.setStartState(i);
            this.as.setEndState(i2);
            return;
        }
        MotionScene motionScene = this.f2184a;
        if (motionScene != null) {
            this.N = i;
            this.O = i2;
            motionScene.a(i, i2);
            this.L.a(this.mLayoutWidget, this.f2184a.a(i), this.f2184a.a(i2));
            rebuildScene();
            this.h = 0.0f;
            transitionToStart();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setTransition(MotionScene.Transition transition) {
        this.f2184a.setTransition(transition);
        setState(TransitionState.SETUP);
        if (this.e == this.f2184a.c()) {
            this.h = 1.0f;
            this.g = 1.0f;
            this.i = 1.0f;
        } else {
            this.h = 0.0f;
            this.g = 0.0f;
            this.i = 0.0f;
        }
        this.U = transition.isTransitionFlag(1) ? -1L : getNanoTime();
        int b = this.f2184a.b();
        int c2 = this.f2184a.c();
        if (b == this.N && c2 == this.O) {
            return;
        }
        this.N = b;
        this.O = c2;
        this.f2184a.a(b, c2);
        this.L.a(this.mLayoutWidget, this.f2184a.a(this.N), this.f2184a.a(this.O));
        this.L.setMeasuredId(this.N, this.O);
        this.L.reEvaluateState();
        rebuildScene();
    }

    public void setTransitionDuration(int i) {
        MotionScene motionScene = this.f2184a;
        if (motionScene == null) {
            Log.e("MotionLayout", "MotionScene not defined");
        } else {
            motionScene.setDuration(i);
        }
    }

    public void setTransitionListener(TransitionListener transitionListener) {
        this.W = transitionListener;
    }

    public void setTransitionState(Bundle bundle) {
        if (this.as == null) {
            this.as = new StateCache();
        }
        this.as.setTransitionState(bundle);
        if (isAttachedToWindow()) {
            this.as.a();
        }
    }

    @Override // android.view.View
    public String toString() {
        Context context = getContext();
        return Debug.getName(context, this.N) + "->" + Debug.getName(context, this.O) + " (pos:" + this.h + " Dpos/Dt:" + this.d;
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x005a, code lost:
        if (r11 != 7) goto L22;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void touchAnimateTo(int r11, float r12, float r13) {
        /*
            Method dump skipped, instructions count: 401
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.MotionLayout.touchAnimateTo(int, float, float):void");
    }

    public void touchSpringTo(float f, float f2) {
        if (this.f2184a == null || this.h == f) {
            return;
        }
        this.ac = true;
        this.S = getNanoTime();
        this.T = this.f2184a.getDuration() / 1000.0f;
        this.i = f;
        this.j = true;
        this.ad.springConfig(this.h, f, f2, this.f2184a.g(), this.f2184a.f(), this.f2184a.h(), this.f2184a.i(), this.f2184a.j());
        int i = this.e;
        this.i = f;
        this.e = i;
        this.b = this.ad;
        this.V = false;
        this.S = getNanoTime();
        invalidate();
    }

    public void transitionToEnd() {
        a(1.0f);
        this.at = null;
    }

    public void transitionToEnd(Runnable runnable) {
        a(1.0f);
        this.at = runnable;
    }

    public void transitionToStart() {
        a(0.0f);
    }

    public void transitionToState(int i) {
        if (isAttachedToWindow()) {
            transitionToState(i, -1, -1);
            return;
        }
        if (this.as == null) {
            this.as = new StateCache();
        }
        this.as.setEndState(i);
    }

    public void transitionToState(int i, int i2) {
        if (isAttachedToWindow()) {
            transitionToState(i, -1, -1, i2);
            return;
        }
        if (this.as == null) {
            this.as = new StateCache();
        }
        this.as.setEndState(i);
    }

    public void transitionToState(int i, int i2, int i3) {
        transitionToState(i, i2, i3, -1);
    }

    public void transitionToState(int i, int i2, int i3, int i4) {
        int i5;
        MotionScene motionScene = this.f2184a;
        int i6 = i;
        if (motionScene != null) {
            i6 = i;
            if (motionScene.f2204a != null) {
                int convertToConstraintSet = this.f2184a.f2204a.convertToConstraintSet(this.e, i, i2, i3);
                i6 = i;
                if (convertToConstraintSet != -1) {
                    i6 = convertToConstraintSet;
                }
            }
        }
        int i7 = this.e;
        if (i7 == i6) {
            return;
        }
        if (this.N == i6) {
            a(0.0f);
            if (i4 > 0) {
                this.T = i4 / 1000.0f;
            }
        } else if (this.O == i6) {
            a(1.0f);
            if (i4 > 0) {
                this.T = i4 / 1000.0f;
            }
        } else {
            this.O = i6;
            if (i7 != -1) {
                setTransition(i7, i6);
                a(1.0f);
                this.h = 0.0f;
                transitionToEnd();
                if (i4 > 0) {
                    this.T = i4 / 1000.0f;
                    return;
                }
                return;
            }
            this.ac = false;
            this.i = 1.0f;
            this.g = 0.0f;
            this.h = 0.0f;
            this.U = getNanoTime();
            this.S = getNanoTime();
            this.V = false;
            this.b = null;
            if (i4 == -1) {
                this.T = this.f2184a.getDuration() / 1000.0f;
            }
            this.N = -1;
            this.f2184a.a(-1, this.O);
            SparseArray sparseArray = new SparseArray();
            if (i4 == 0) {
                this.T = this.f2184a.getDuration() / 1000.0f;
            } else if (i4 > 0) {
                this.T = i4 / 1000.0f;
            }
            int childCount = getChildCount();
            this.f.clear();
            int i8 = 0;
            while (true) {
                int i9 = i8;
                if (i9 >= childCount) {
                    break;
                }
                View childAt = getChildAt(i9);
                this.f.put(childAt, new MotionController(childAt));
                sparseArray.put(childAt.getId(), this.f.get(childAt));
                i8 = i9 + 1;
            }
            this.j = true;
            this.L.a(this.mLayoutWidget, null, this.f2184a.a(i6));
            rebuildScene();
            this.L.build();
            e();
            int width = getWidth();
            int height = getHeight();
            if (this.aj == null) {
                int i10 = 0;
                while (true) {
                    int i11 = i10;
                    if (i11 >= childCount) {
                        break;
                    }
                    MotionController motionController = this.f.get(getChildAt(i11));
                    if (motionController != null) {
                        this.f2184a.getKeyFrames(motionController);
                        motionController.setup(width, height, this.T, getNanoTime());
                    }
                    i10 = i11 + 1;
                }
            } else {
                int i12 = 0;
                while (true) {
                    int i13 = i12;
                    if (i13 >= childCount) {
                        break;
                    }
                    MotionController motionController2 = this.f.get(getChildAt(i13));
                    if (motionController2 != null) {
                        this.f2184a.getKeyFrames(motionController2);
                    }
                    i12 = i13 + 1;
                }
                Iterator<MotionHelper> it = this.aj.iterator();
                while (it.hasNext()) {
                    it.next().onPreSetup(this, this.f);
                }
                int i14 = 0;
                while (true) {
                    int i15 = i14;
                    if (i15 >= childCount) {
                        break;
                    }
                    MotionController motionController3 = this.f.get(getChildAt(i15));
                    if (motionController3 != null) {
                        motionController3.setup(width, height, this.T, getNanoTime());
                    }
                    i14 = i15 + 1;
                }
            }
            float staggered = this.f2184a.getStaggered();
            if (staggered != 0.0f) {
                float f = Float.MAX_VALUE;
                float f2 = -3.4028235E38f;
                int i16 = 0;
                while (true) {
                    int i17 = i16;
                    if (i17 >= childCount) {
                        break;
                    }
                    MotionController motionController4 = this.f.get(getChildAt(i17));
                    float finalY = motionController4.getFinalY() + motionController4.getFinalX();
                    f = Math.min(f, finalY);
                    f2 = Math.max(f2, finalY);
                    i16 = i17 + 1;
                }
                for (i5 = 0; i5 < childCount; i5++) {
                    MotionController motionController5 = this.f.get(getChildAt(i5));
                    float finalX = motionController5.getFinalX();
                    float finalY2 = motionController5.getFinalY();
                    motionController5.h = 1.0f / (1.0f - staggered);
                    motionController5.g = staggered - ((((finalX + finalY2) - f) * staggered) / (f2 - f));
                }
            }
            this.g = 0.0f;
            this.h = 0.0f;
            this.j = true;
            invalidate();
        }
    }

    public void updateState() {
        this.L.a(this.mLayoutWidget, this.f2184a.a(this.N), this.f2184a.a(this.O));
        rebuildScene();
    }

    public void updateState(int i, ConstraintSet constraintSet) {
        MotionScene motionScene = this.f2184a;
        if (motionScene != null) {
            motionScene.setConstraintSet(i, constraintSet);
        }
        updateState();
        if (this.e == i) {
            constraintSet.applyTo(this);
        }
    }

    public void updateStateAnimate(int i, ConstraintSet constraintSet, int i2) {
        if (this.f2184a != null && this.e == i) {
            updateState(R.id.view_transition, getConstraintSet(i));
            setState(R.id.view_transition, -1, -1);
            updateState(i, constraintSet);
            MotionScene.Transition transition = new MotionScene.Transition(-1, this.f2184a, R.id.view_transition, i);
            transition.setDuration(i2);
            setTransition(transition);
            transitionToEnd();
        }
    }

    public void viewTransition(int i, View... viewArr) {
        MotionScene motionScene = this.f2184a;
        if (motionScene != null) {
            motionScene.viewTransition(i, viewArr);
        } else {
            Log.e("MotionLayout", " no motionScene");
        }
    }
}
