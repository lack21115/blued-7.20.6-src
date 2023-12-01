package com.blued.android.module.live.base.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import com.blued.android.core.AppMethods;
import com.blued.android.module.live.base.R;
import java.lang.ref.WeakReference;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/live/base/view/LiveCircleProgressView.class */
public class LiveCircleProgressView extends View {
    private int A;
    private int B;
    private int[] C;
    private Paint.Cap D;
    private Paint.Cap E;
    private Paint F;
    private Paint G;
    private Paint H;
    private Paint I;
    private Paint J;
    private Paint K;
    private Paint L;
    private RectF M;
    private RectF N;
    private RectF O;
    private RectF P;
    private RectF Q;
    private RectF R;
    private float S;
    private double T;
    private int U;
    private boolean V;
    private Handler W;

    /* renamed from: a  reason: collision with root package name */
    private float f11477a;
    private AnimationState aa;
    private AccelerateDecelerateInterpolator ab;
    private String ac;
    private String ad;
    private int ae;
    private boolean af;
    private boolean ag;
    private boolean ah;
    private boolean ai;
    private boolean aj;
    private float ak;
    private float b;

    /* renamed from: c  reason: collision with root package name */
    private float f11478c;
    private float d;
    private float e;
    private float f;
    private float g;
    private int h;
    private int i;
    private int j;
    private int k;
    private int l;
    private int m;
    private int n;
    private float o;
    private float p;
    private float q;
    private int r;
    private int s;
    private int t;
    private int u;
    private final int v;
    private int w;
    private int x;
    private int y;
    private int z;

    /* renamed from: com.blued.android.module.live.base.view.LiveCircleProgressView$1  reason: invalid class name */
    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/live/base/view/LiveCircleProgressView$1.class */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f11479a;
        static final /* synthetic */ int[] b;

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x0081 -> B:56:0x0014). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x0085 -> B:50:0x001f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:28:0x0089 -> B:46:0x002a). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:30:0x008d -> B:60:0x0035). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:32:0x0091 -> B:12:0x0040). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x0095 -> B:48:0x0054). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:36:0x0099 -> B:44:0x005f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:38:0x009d -> B:58:0x006a). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:40:0x00a1 -> B:52:0x0075). Please submit an issue!!! */
        static {
            int[] iArr = new int[AnimationState.values().length];
            b = iArr;
            try {
                iArr[AnimationState.IDLE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                b[AnimationState.SPINNING.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                b[AnimationState.END_SPINNING.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                b[AnimationState.END_SPINNING_START_ANIMATING.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                b[AnimationState.ANIMATING.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            int[] iArr2 = new int[AnimationMsg.values().length];
            f11479a = iArr2;
            try {
                iArr2[AnimationMsg.START_SPINNING.ordinal()] = 1;
            } catch (NoSuchFieldError e6) {
            }
            try {
                f11479a[AnimationMsg.STOP_SPINNING.ordinal()] = 2;
            } catch (NoSuchFieldError e7) {
            }
            try {
                f11479a[AnimationMsg.SET_VALUE.ordinal()] = 3;
            } catch (NoSuchFieldError e8) {
            }
            try {
                f11479a[AnimationMsg.SET_VALUE_ANIMATED.ordinal()] = 4;
            } catch (NoSuchFieldError e9) {
            }
            try {
                f11479a[AnimationMsg.TICK.ordinal()] = 5;
            } catch (NoSuchFieldError e10) {
            }
        }
    }

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/live/base/view/LiveCircleProgressView$AnimationHandler.class */
    static class AnimationHandler extends Handler {

        /* renamed from: a  reason: collision with root package name */
        private final WeakReference<LiveCircleProgressView> f11480a;
        private float b;

        /* renamed from: c  reason: collision with root package name */
        private long f11481c;
        private long d;
        private DecelerateInterpolator e;
        private double f;

        AnimationHandler(LiveCircleProgressView liveCircleProgressView) {
            super(liveCircleProgressView.getContext().getMainLooper());
            this.e = new DecelerateInterpolator();
            this.f11480a = new WeakReference<>(liveCircleProgressView);
        }

        private void a(Message message, LiveCircleProgressView liveCircleProgressView) {
            liveCircleProgressView.f11478c = ((float[]) message.obj)[0];
            liveCircleProgressView.b = ((float[]) message.obj)[1];
            this.f11481c = System.currentTimeMillis();
            liveCircleProgressView.aa = AnimationState.ANIMATING;
            liveCircleProgressView.W.sendEmptyMessageDelayed(AnimationMsg.TICK.ordinal(), liveCircleProgressView.U);
        }

        private void a(LiveCircleProgressView liveCircleProgressView) {
            liveCircleProgressView.aa = AnimationState.END_SPINNING;
            b(liveCircleProgressView);
            liveCircleProgressView.W.sendEmptyMessageDelayed(AnimationMsg.TICK.ordinal(), liveCircleProgressView.U);
        }

        private void a(LiveCircleProgressView liveCircleProgressView, Message message) {
            liveCircleProgressView.aa = AnimationState.END_SPINNING_START_ANIMATING;
            liveCircleProgressView.f11478c = 0.0f;
            liveCircleProgressView.b = ((float[]) message.obj)[1];
            this.d = System.currentTimeMillis();
            this.b = liveCircleProgressView.e;
            liveCircleProgressView.W.sendEmptyMessageDelayed(AnimationMsg.TICK.ordinal(), liveCircleProgressView.U);
        }

        private void b(Message message, LiveCircleProgressView liveCircleProgressView) {
            liveCircleProgressView.f11478c = liveCircleProgressView.b;
            liveCircleProgressView.f11477a = liveCircleProgressView.b = ((float[]) message.obj)[0];
            liveCircleProgressView.aa = AnimationState.IDLE;
            liveCircleProgressView.invalidate();
        }

        private void b(LiveCircleProgressView liveCircleProgressView) {
            this.f = (liveCircleProgressView.e / liveCircleProgressView.S) * liveCircleProgressView.U * 2.0f;
            this.d = System.currentTimeMillis();
            this.b = liveCircleProgressView.e;
        }

        private void c(LiveCircleProgressView liveCircleProgressView) {
            liveCircleProgressView.aa = AnimationState.SPINNING;
            liveCircleProgressView.e = (360.0f / liveCircleProgressView.d) * liveCircleProgressView.f11477a;
            liveCircleProgressView.g = (360.0f / liveCircleProgressView.d) * liveCircleProgressView.f11477a;
            this.d = System.currentTimeMillis();
            this.b = liveCircleProgressView.e;
            this.f = (liveCircleProgressView.f / liveCircleProgressView.S) * liveCircleProgressView.U * 2.0f;
            liveCircleProgressView.W.sendEmptyMessageDelayed(AnimationMsg.TICK.ordinal(), liveCircleProgressView.U);
        }

        private boolean d(LiveCircleProgressView liveCircleProgressView) {
            float currentTimeMillis = (float) ((System.currentTimeMillis() - this.f11481c) / liveCircleProgressView.T);
            float f = currentTimeMillis;
            if (currentTimeMillis > 1.0f) {
                f = 1.0f;
            }
            liveCircleProgressView.f11477a = liveCircleProgressView.f11478c + ((liveCircleProgressView.b - liveCircleProgressView.f11478c) * liveCircleProgressView.ab.getInterpolation(f));
            return f >= 1.0f;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            LiveCircleProgressView liveCircleProgressView = this.f11480a.get();
            if (liveCircleProgressView == null) {
                return;
            }
            AnimationMsg animationMsg = AnimationMsg.values()[message.what];
            if (animationMsg == AnimationMsg.TICK) {
                removeMessages(AnimationMsg.TICK.ordinal());
            }
            int i = AnonymousClass1.b[liveCircleProgressView.aa.ordinal()];
            if (i == 1) {
                int i2 = AnonymousClass1.f11479a[animationMsg.ordinal()];
                if (i2 == 1) {
                    c(liveCircleProgressView);
                } else if (i2 == 3) {
                    b(message, liveCircleProgressView);
                } else if (i2 == 4) {
                    a(message, liveCircleProgressView);
                } else if (i2 != 5) {
                } else {
                    removeMessages(AnimationMsg.TICK.ordinal());
                }
            } else if (i == 2) {
                int i3 = AnonymousClass1.f11479a[animationMsg.ordinal()];
                if (i3 == 2) {
                    a(liveCircleProgressView);
                } else if (i3 == 3) {
                    b(message, liveCircleProgressView);
                } else if (i3 == 4) {
                    a(liveCircleProgressView, message);
                } else if (i3 != 5) {
                } else {
                    float f = liveCircleProgressView.e;
                    float f2 = liveCircleProgressView.f;
                    float currentTimeMillis = (float) ((System.currentTimeMillis() - this.d) / this.f);
                    float f3 = currentTimeMillis;
                    if (currentTimeMillis > 1.0f) {
                        f3 = 1.0f;
                    }
                    float interpolation = this.e.getInterpolation(f3);
                    if (Math.abs(f - f2) < 1.0f) {
                        liveCircleProgressView.e = liveCircleProgressView.f;
                    } else if (liveCircleProgressView.e < liveCircleProgressView.f) {
                        liveCircleProgressView.e = this.b + ((liveCircleProgressView.f - this.b) * interpolation);
                    } else {
                        float f4 = this.b;
                        liveCircleProgressView.e = f4 - ((f4 - liveCircleProgressView.f) * interpolation);
                    }
                    LiveCircleProgressView.b(liveCircleProgressView, liveCircleProgressView.S);
                    if (liveCircleProgressView.g > 360.0f) {
                        liveCircleProgressView.g = 0.0f;
                    }
                    liveCircleProgressView.W.sendEmptyMessageDelayed(AnimationMsg.TICK.ordinal(), liveCircleProgressView.U);
                    liveCircleProgressView.invalidate();
                }
            } else if (i == 3) {
                int i4 = AnonymousClass1.f11479a[animationMsg.ordinal()];
                if (i4 == 1) {
                    liveCircleProgressView.aa = AnimationState.SPINNING;
                    liveCircleProgressView.W.sendEmptyMessageDelayed(AnimationMsg.TICK.ordinal(), liveCircleProgressView.U);
                } else if (i4 == 3) {
                    b(message, liveCircleProgressView);
                } else if (i4 == 4) {
                    a(liveCircleProgressView, message);
                } else if (i4 != 5) {
                } else {
                    float currentTimeMillis2 = (float) ((System.currentTimeMillis() - this.d) / this.f);
                    float f5 = currentTimeMillis2;
                    if (currentTimeMillis2 > 1.0f) {
                        f5 = 1.0f;
                    }
                    liveCircleProgressView.e = this.b * (1.0f - this.e.getInterpolation(f5));
                    LiveCircleProgressView.b(liveCircleProgressView, liveCircleProgressView.S);
                    if (liveCircleProgressView.e < 0.01f) {
                        liveCircleProgressView.aa = AnimationState.IDLE;
                    }
                    liveCircleProgressView.W.sendEmptyMessageDelayed(AnimationMsg.TICK.ordinal(), liveCircleProgressView.U);
                    liveCircleProgressView.invalidate();
                }
            } else if (i != 4) {
                if (i != 5) {
                    return;
                }
                int i5 = AnonymousClass1.f11479a[animationMsg.ordinal()];
                if (i5 == 1) {
                    c(liveCircleProgressView);
                } else if (i5 == 3) {
                    b(message, liveCircleProgressView);
                } else if (i5 == 4) {
                    this.f11481c = System.currentTimeMillis();
                    liveCircleProgressView.f11478c = liveCircleProgressView.f11477a;
                    liveCircleProgressView.b = ((float[]) message.obj)[1];
                } else if (i5 != 5) {
                } else {
                    if (d(liveCircleProgressView)) {
                        liveCircleProgressView.aa = AnimationState.IDLE;
                        liveCircleProgressView.f11477a = liveCircleProgressView.b;
                    }
                    liveCircleProgressView.W.sendEmptyMessageDelayed(AnimationMsg.TICK.ordinal(), liveCircleProgressView.U);
                    liveCircleProgressView.invalidate();
                }
            } else {
                int i6 = AnonymousClass1.f11479a[animationMsg.ordinal()];
                if (i6 == 1) {
                    liveCircleProgressView.V = false;
                    c(liveCircleProgressView);
                } else if (i6 == 3) {
                    liveCircleProgressView.V = false;
                    b(message, liveCircleProgressView);
                } else if (i6 == 4) {
                    liveCircleProgressView.f11478c = 0.0f;
                    liveCircleProgressView.b = ((float[]) message.obj)[1];
                    liveCircleProgressView.W.sendEmptyMessageDelayed(AnimationMsg.TICK.ordinal(), liveCircleProgressView.U);
                } else if (i6 != 5) {
                } else {
                    if (liveCircleProgressView.e > liveCircleProgressView.f && !liveCircleProgressView.V) {
                        float currentTimeMillis3 = (float) ((System.currentTimeMillis() - this.d) / this.f);
                        float f6 = currentTimeMillis3;
                        if (currentTimeMillis3 > 1.0f) {
                            f6 = 1.0f;
                        }
                        liveCircleProgressView.e = this.b * (1.0f - this.e.getInterpolation(f6));
                    }
                    LiveCircleProgressView.b(liveCircleProgressView, liveCircleProgressView.S);
                    if (liveCircleProgressView.g > 360.0f && !liveCircleProgressView.V) {
                        this.f11481c = System.currentTimeMillis();
                        liveCircleProgressView.V = true;
                        b(liveCircleProgressView);
                    }
                    if (liveCircleProgressView.V) {
                        liveCircleProgressView.g = 360.0f;
                        LiveCircleProgressView.f(liveCircleProgressView, liveCircleProgressView.S);
                        d(liveCircleProgressView);
                        float currentTimeMillis4 = (float) ((System.currentTimeMillis() - this.d) / this.f);
                        float f7 = currentTimeMillis4;
                        if (currentTimeMillis4 > 1.0f) {
                            f7 = 1.0f;
                        }
                        liveCircleProgressView.e = this.b * (1.0f - this.e.getInterpolation(f7));
                    }
                    if (liveCircleProgressView.e < 0.1d) {
                        liveCircleProgressView.aa = AnimationState.ANIMATING;
                        liveCircleProgressView.invalidate();
                        liveCircleProgressView.V = false;
                        liveCircleProgressView.e = liveCircleProgressView.f;
                    } else {
                        liveCircleProgressView.invalidate();
                    }
                    liveCircleProgressView.W.sendEmptyMessageDelayed(AnimationMsg.TICK.ordinal(), liveCircleProgressView.U);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/live/base/view/LiveCircleProgressView$AnimationMsg.class */
    public enum AnimationMsg {
        START_SPINNING,
        STOP_SPINNING,
        SET_VALUE,
        SET_VALUE_ANIMATED,
        TICK
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/live/base/view/LiveCircleProgressView$AnimationState.class */
    public enum AnimationState {
        IDLE,
        SPINNING,
        END_SPINNING,
        END_SPINNING_START_ANIMATING,
        ANIMATING
    }

    public LiveCircleProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f11477a = 0.0f;
        this.b = 0.0f;
        this.f11478c = 0.0f;
        this.d = 100.0f;
        this.e = 0.0f;
        this.f = 42.0f;
        this.g = 0.0f;
        this.h = 0;
        this.i = 0;
        this.j = 100;
        this.k = 80;
        this.l = AppMethods.a(5);
        this.m = AppMethods.a(5);
        this.n = AppMethods.b(5);
        this.o = 0.0f;
        this.p = 1.0f;
        this.q = 1.0f;
        this.r = 0;
        this.s = 0;
        this.t = 0;
        this.u = 0;
        this.v = -1871679376;
        this.w = -1442840576;
        this.x = -1871679376;
        this.y = 0;
        this.z = -1342177281;
        this.A = -16777216;
        this.B = -16777216;
        this.C = new int[]{-1871679376, -1871679376};
        this.D = Paint.Cap.BUTT;
        this.E = Paint.Cap.BUTT;
        this.F = new Paint();
        this.G = new Paint();
        this.H = new Paint();
        this.I = new Paint();
        this.J = new Paint();
        this.K = new Paint();
        this.L = new Paint();
        this.M = new RectF();
        this.N = new RectF();
        this.O = new RectF();
        this.P = new RectF();
        this.Q = new RectF();
        this.R = new RectF();
        this.S = 2.8f;
        this.T = 900.0d;
        this.U = 15;
        this.W = new AnimationHandler(this);
        this.aa = AnimationState.IDLE;
        this.ab = new AccelerateDecelerateInterpolator();
        this.ac = "";
        this.ad = "";
        this.ah = true;
        this.ai = false;
        this.aj = false;
        this.ak = 0.3f;
        a(context.obtainStyledAttributes(attributeSet, R.styleable.LiveCircleProgressView));
    }

    private static float a(String str, Paint paint, RectF rectF) {
        Matrix matrix = new Matrix();
        Rect rect = new Rect();
        paint.getTextBounds(str, 0, str.length(), rect);
        matrix.setRectToRect(new RectF(rect), rectF, Matrix.ScaleToFit.CENTER);
        float[] fArr = new float[9];
        matrix.getValues(fArr);
        return paint.getTextSize() * fArr[0];
    }

    private RectF a(RectF rectF) {
        float f;
        float width = (rectF.width() - ((float) ((((rectF.width() - Math.max(this.l, this.m)) - (this.o * 2.0f)) / 2.0d) * Math.sqrt(2.0d)))) / 2.0f;
        float f2 = 1.0f;
        if (a()) {
            f2 = 0.77f;
            f = 1.33f;
        } else {
            f = 1.0f;
        }
        float f3 = f2 * width;
        float f4 = width * f;
        return new RectF(rectF.left + f3, rectF.top + f4, rectF.right - f3, rectF.bottom - f4);
    }

    private void a(TypedArray typedArray) {
        setBarWidth((int) typedArray.getDimension(R.styleable.LiveCircleProgressView_barWidth, this.l));
        setRimWidth((int) typedArray.getDimension(R.styleable.LiveCircleProgressView_rimWidth, this.m));
        setSpinSpeed((int) typedArray.getDimension(R.styleable.LiveCircleProgressView_spinSpeed, this.S));
        if (typedArray.hasValue(R.styleable.LiveCircleProgressView_barColor) && typedArray.hasValue(R.styleable.LiveCircleProgressView_barColor1) && typedArray.hasValue(R.styleable.LiveCircleProgressView_barColor2) && typedArray.hasValue(R.styleable.LiveCircleProgressView_barColor3)) {
            this.C = new int[]{typedArray.getColor(R.styleable.LiveCircleProgressView_barColor, -1871679376), typedArray.getColor(R.styleable.LiveCircleProgressView_barColor1, -1871679376), typedArray.getColor(R.styleable.LiveCircleProgressView_barColor2, -1871679376), typedArray.getColor(R.styleable.LiveCircleProgressView_barColor3, -1871679376)};
        } else if (typedArray.hasValue(R.styleable.LiveCircleProgressView_barColor) && typedArray.hasValue(R.styleable.LiveCircleProgressView_barColor1) && typedArray.hasValue(R.styleable.LiveCircleProgressView_barColor2)) {
            this.C = new int[]{typedArray.getColor(R.styleable.LiveCircleProgressView_barColor, -1871679376), typedArray.getColor(R.styleable.LiveCircleProgressView_barColor1, -1871679376), typedArray.getColor(R.styleable.LiveCircleProgressView_barColor2, -1871679376)};
        } else if (typedArray.hasValue(R.styleable.LiveCircleProgressView_barColor) && typedArray.hasValue(R.styleable.LiveCircleProgressView_barColor1)) {
            this.C = new int[]{typedArray.getColor(R.styleable.LiveCircleProgressView_barColor, -1871679376), typedArray.getColor(R.styleable.LiveCircleProgressView_barColor1, -1871679376)};
        } else {
            this.C = new int[]{typedArray.getColor(R.styleable.LiveCircleProgressView_barColor, -1871679376), typedArray.getColor(R.styleable.LiveCircleProgressView_barColor, -1871679376)};
        }
        setSpinBarColor(typedArray.getColor(R.styleable.LiveCircleProgressView_spinColor, this.x));
        float dimension = typedArray.getDimension(R.styleable.LiveCircleProgressView_spinBarLength, this.f);
        this.f = dimension;
        setSpinningBarLength(dimension);
        setTextSize((int) typedArray.getDimension(R.styleable.LiveCircleProgressView_textSize, -1.0f));
        setTextColor(typedArray.getColor(R.styleable.LiveCircleProgressView_textColor, -1));
        setUnitColor(typedArray.getColor(R.styleable.LiveCircleProgressView_unitColor, -1));
        setText(typedArray.getString(R.styleable.LiveCircleProgressView_text));
        setRimColor(typedArray.getColor(R.styleable.LiveCircleProgressView_rimColor, this.z));
        setFillColor(typedArray.getColor(R.styleable.LiveCircleProgressView_circleFillColor, this.y));
        setContourColor(typedArray.getColor(R.styleable.LiveCircleProgressView_contourColor, this.w));
        setContourSize(typedArray.getDimension(R.styleable.LiveCircleProgressView_contourSize, this.o));
        setMaxValue(typedArray.getDimension(R.styleable.LiveCircleProgressView_maxValue, this.d));
        setUnit(typedArray.getString(R.styleable.LiveCircleProgressView_unit));
        setShowUnit(typedArray.getBoolean(R.styleable.LiveCircleProgressView_showUnit, this.aj));
        setTextScale(typedArray.getDimension(R.styleable.LiveCircleProgressView_textScale, this.p));
        setUnitScale(typedArray.getDimension(R.styleable.LiveCircleProgressView_unitScale, this.q));
        typedArray.recycle();
    }

    private void a(Canvas canvas) {
        if (this.e < 0.0f) {
            this.e = 1.0f;
        }
        float f = this.g;
        float f2 = this.e;
        canvas.drawArc(this.M, (f - 90.0f) - f2, f2, false, this.G);
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x017d  */
    /* JADX WARN: Removed duplicated region for block: B:37:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(android.graphics.Canvas r10, float r11) {
        /*
            Method dump skipped, instructions count: 616
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blued.android.module.live.base.view.LiveCircleProgressView.a(android.graphics.Canvas, float):void");
    }

    static /* synthetic */ float b(LiveCircleProgressView liveCircleProgressView, float f) {
        float f2 = liveCircleProgressView.g + f;
        liveCircleProgressView.g = f2;
        return f2;
    }

    private RectF b(String str, Paint paint, RectF rectF) {
        Rect rect = new Rect();
        paint.getTextBounds(str, 0, str.length(), rect);
        RectF rectF2 = new RectF();
        rectF2.left = rectF.left + ((rectF.width() - rect.width()) / 2.0f);
        rectF2.top = rectF.top + ((rectF.height() - rect.height()) / 2.0f);
        rectF2.right = rectF2.left + rect.width();
        rectF2.bottom = rectF2.top + rect.height();
        return rectF2;
    }

    private void c() {
        int min = Math.min(this.i, this.h);
        int i = this.i;
        int i2 = (this.h - min) / 2;
        this.r = getPaddingTop() + i2;
        this.s = getPaddingBottom() + i2;
        int i3 = (i - min) / 2;
        this.t = getPaddingLeft() + i3;
        this.u = getPaddingRight() + i3;
        int width = getWidth();
        int height = getHeight();
        int i4 = this.t;
        int i5 = this.l;
        RectF rectF = new RectF(i4 + i5, this.r + i5, (width - this.u) - i5, (height - this.s) - i5);
        this.M = rectF;
        this.N = a(rectF);
        this.R = new RectF(this.M.left + (this.m / 2.0f) + (this.o / 2.0f), this.M.top + (this.m / 2.0f) + (this.o / 2.0f), (this.M.right - (this.m / 2.0f)) - (this.o / 2.0f), (this.M.bottom - (this.m / 2.0f)) - (this.o / 2.0f));
        this.Q = new RectF((this.M.left - (this.m / 2.0f)) - (this.o / 2.0f), (this.M.top - (this.m / 2.0f)) - (this.o / 2.0f), this.M.right + (this.m / 2.0f) + (this.o / 2.0f), this.M.bottom + (this.m / 2.0f) + (this.o / 2.0f));
        int i6 = this.u;
        int i7 = this.l;
        int i8 = ((width - i6) - i7) / 2;
        this.j = i8;
        this.k = (i8 - i7) + 1;
    }

    static /* synthetic */ float f(LiveCircleProgressView liveCircleProgressView, float f) {
        float f2 = liveCircleProgressView.e - f;
        liveCircleProgressView.e = f2;
        return f2;
    }

    public int a(double d) {
        int[] iArr = this.C;
        int length = (int) (iArr.length * (1.0d / getMaxValue()) * d);
        int i = length;
        if (length >= iArr.length) {
            i = iArr.length - 1;
        }
        return iArr[i];
    }

    public boolean a() {
        return this.aj;
    }

    public void b() {
        this.F.setShader(new SweepGradient(this.M.centerX(), this.M.centerY(), this.C, (float[]) null));
        Matrix matrix = new Matrix();
        this.F.getShader().getLocalMatrix(matrix);
        matrix.postTranslate(-this.M.centerX(), -this.M.centerY());
        matrix.postRotate(-90.0f);
        matrix.postTranslate(this.M.centerX(), this.M.centerY());
        this.F.getShader().setLocalMatrix(matrix);
        this.F.setAntiAlias(true);
        this.F.setStrokeCap(this.D);
        this.F.setStyle(Paint.Style.STROKE);
        this.F.setStrokeWidth(this.l);
        this.G.setAntiAlias(true);
        this.G.setStrokeCap(this.E);
        this.G.setStyle(Paint.Style.STROKE);
        this.G.setStrokeWidth(this.l);
        this.G.setColor(this.x);
        this.I.setColor(this.z);
        this.I.setAntiAlias(true);
        this.I.setStyle(Paint.Style.STROKE);
        this.I.setStrokeWidth(this.m);
        this.H.setColor(this.y);
        this.H.setAntiAlias(true);
        this.H.setStyle(Paint.Style.FILL);
        this.J.setColor(this.A);
        this.J.setStyle(Paint.Style.FILL);
        this.J.setAntiAlias(true);
        this.J.setTextSize(getTextSize());
        this.K.setColor(this.B);
        this.K.setStyle(Paint.Style.FILL);
        this.K.setAntiAlias(true);
        this.K.setTextSize(getTextSize());
        this.L.setColor(this.w);
        this.L.setAntiAlias(true);
        this.L.setStyle(Paint.Style.STROKE);
        this.L.setStrokeWidth(this.o);
    }

    public int[] getBarColors() {
        return this.C;
    }

    public Paint.Cap getBarStrokeCap() {
        return this.D;
    }

    public int getBarWidth() {
        return this.l;
    }

    public int getCircleRadius() {
        return this.k;
    }

    public int getContourColor() {
        return this.w;
    }

    public float getContourSize() {
        return this.o;
    }

    public int getDelayMillis() {
        return this.U;
    }

    public int getFillColor() {
        return this.y;
    }

    public double getMaxValue() {
        return this.d;
    }

    @Override // android.view.View
    public int getPaddingBottom() {
        return this.s;
    }

    @Override // android.view.View
    public int getPaddingLeft() {
        return this.t;
    }

    @Override // android.view.View
    public int getPaddingRight() {
        return this.u;
    }

    @Override // android.view.View
    public int getPaddingTop() {
        return this.r;
    }

    public int getRimColor() {
        return this.z;
    }

    public Shader getRimShader() {
        return this.I.getShader();
    }

    public int getRimWidth() {
        return this.m;
    }

    public float getSpinSpeed() {
        return this.S;
    }

    public Paint.Cap getSpinnerStrokeCap() {
        return this.E;
    }

    public int getTextColor() {
        return this.A;
    }

    public float getTextScale() {
        return this.p;
    }

    public int getTextSize() {
        return this.n;
    }

    public String getUnit() {
        return this.ad;
    }

    public float getUnitScale() {
        return this.q;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float f = (360.0f / this.d) * this.f11477a;
        canvas.drawArc(this.M, 360.0f, 360.0f, false, this.H);
        if (this.m > 0) {
            canvas.drawArc(this.M, 360.0f, 360.0f, false, this.I);
        }
        if (this.o > 0.0f) {
            canvas.drawArc(this.Q, 360.0f, 360.0f, false, this.L);
            canvas.drawArc(this.R, 360.0f, 360.0f, false, this.L);
        }
        if (this.aa == AnimationState.SPINNING || this.aa == AnimationState.END_SPINNING) {
            a(canvas);
        } else if (this.aa != AnimationState.END_SPINNING_START_ANIMATING) {
            a(canvas, f);
        } else {
            a(canvas);
            if (this.V) {
                a(canvas, f);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        int paddingLeft = (measuredWidth - getPaddingLeft()) - getPaddingRight();
        int paddingTop = (measuredHeight - getPaddingTop()) - getPaddingBottom();
        int i3 = paddingLeft;
        if (paddingLeft > paddingTop) {
            i3 = paddingTop;
        }
        setMeasuredDimension(getPaddingLeft() + i3 + getPaddingRight(), i3 + getPaddingTop() + getPaddingBottom());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.i = i;
        this.h = i2;
        c();
        b();
        invalidate();
    }

    public void setBarColor(int... iArr) {
        if (iArr.length == 1) {
            this.C = new int[]{iArr[0], iArr[0]};
        } else {
            this.C = iArr;
        }
    }

    public void setBarStrokeCap(Paint.Cap cap) {
        this.D = cap;
    }

    public void setBarWidth(int i) {
        this.l = i;
    }

    public void setContourColor(int i) {
        this.w = i;
    }

    public void setContourSize(float f) {
        this.o = f;
    }

    public void setDelayMillis(int i) {
        this.U = i;
    }

    public void setFillColor(int i) {
        this.y = i;
    }

    public void setMaxValue(float f) {
        this.d = f;
    }

    public void setPaddingBottom(int i) {
        this.s = i;
    }

    public void setPaddingLeft(int i) {
        this.t = i;
    }

    public void setPaddingRight(int i) {
        this.u = i;
    }

    public void setPaddingTop(int i) {
        this.r = i;
    }

    public void setRimColor(int i) {
        this.z = i;
    }

    public void setRimShader(Shader shader) {
        this.I.setShader(shader);
    }

    public void setRimWidth(int i) {
        this.m = i;
    }

    public void setShowPercentAsAutoValue(boolean z) {
        this.ah = z;
    }

    public void setShowUnit(boolean z) {
        this.aj = z;
        this.ae = 0;
        invalidate();
        this.N = a(this.M);
    }

    public void setSpinBarColor(int i) {
        this.x = i;
    }

    public void setSpinSpeed(float f) {
        this.S = f;
    }

    public void setSpinnerStrokeCap(Paint.Cap cap) {
        this.E = cap;
    }

    public void setSpinningBarLength(float f) {
        this.f = f;
        this.e = f;
    }

    public void setText(String str) {
        if (str == null || str.isEmpty()) {
            this.ac = "";
            this.af = true;
        } else {
            this.ac = str;
            this.af = false;
        }
        invalidate();
    }

    public void setTextColor(int i) {
        this.A = i;
    }

    public void setTextScale(float f) {
        this.p = f;
    }

    public void setTextSize(int i) {
        if (i <= 0) {
            this.ag = true;
            return;
        }
        this.n = i;
        this.ag = false;
    }

    public void setUnit(String str) {
        if (str == null) {
            this.ad = "";
        } else {
            this.ad = str;
        }
        invalidate();
    }

    public void setUnitColor(int i) {
        this.B = i;
    }

    public void setUnitScale(float f) {
        this.q = f;
    }

    public void setValue(float f) {
        Message obtain = Message.obtain();
        obtain.what = AnimationMsg.SET_VALUE.ordinal();
        obtain.obj = new float[]{f, f};
        this.W.sendMessage(obtain);
    }

    public void setValueAnimated(float f) {
        this.T = 1200.0d;
        Message obtain = Message.obtain();
        obtain.what = AnimationMsg.SET_VALUE_ANIMATED.ordinal();
        obtain.obj = new float[]{this.f11477a, f};
        this.W.sendMessage(obtain);
    }
}
