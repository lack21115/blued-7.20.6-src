package androidx.constraintlayout.core.motion;

import android.provider.BrowserContract;
import androidx.constraintlayout.core.motion.key.MotionKeyPosition;
import androidx.constraintlayout.core.motion.utils.Easing;
import java.util.Arrays;
import java.util.HashMap;

/* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/core/motion/MotionPaths.class */
public class MotionPaths implements Comparable<MotionPaths> {
    public static final int CARTESIAN = 0;
    public static final boolean DEBUG = false;
    public static final boolean OLD_WAY = false;
    public static final int PERPENDICULAR = 1;
    public static final int SCREEN = 2;
    public static final String TAG = "MotionPaths";

    /* renamed from: a  reason: collision with root package name */
    static String[] f1965a = {BrowserContract.Bookmarks.POSITION, "x", "y", "width", "height", "pathRotate"};
    Easing b;

    /* renamed from: c  reason: collision with root package name */
    int f1966c;
    float d;
    float e;
    float f;
    float g;
    float h;
    float i;
    float j;
    float k;
    int l;
    int m;
    float n;
    Motion o;
    HashMap<String, CustomVariable> p;
    int q;
    int r;
    double[] s;
    double[] t;

    public MotionPaths() {
        this.f1966c = 0;
        this.j = Float.NaN;
        this.k = Float.NaN;
        this.l = -1;
        this.m = -1;
        this.n = Float.NaN;
        this.o = null;
        this.p = new HashMap<>();
        this.q = 0;
        this.s = new double[18];
        this.t = new double[18];
    }

    public MotionPaths(int i, int i2, MotionKeyPosition motionKeyPosition, MotionPaths motionPaths, MotionPaths motionPaths2) {
        this.f1966c = 0;
        this.j = Float.NaN;
        this.k = Float.NaN;
        this.l = -1;
        this.m = -1;
        this.n = Float.NaN;
        this.o = null;
        this.p = new HashMap<>();
        this.q = 0;
        this.s = new double[18];
        this.t = new double[18];
        if (motionPaths.m != -1) {
            a(i, i2, motionKeyPosition, motionPaths, motionPaths2);
            return;
        }
        int i3 = motionKeyPosition.mPositionType;
        if (i3 == 1) {
            b(motionKeyPosition, motionPaths, motionPaths2);
        } else if (i3 != 2) {
            a(motionKeyPosition, motionPaths, motionPaths2);
        } else {
            b(i, i2, motionKeyPosition, motionPaths, motionPaths2);
        }
    }

    private static final float a(float f, float f2, float f3, float f4, float f5, float f6) {
        return (((f5 - f3) * f2) - ((f6 - f4) * f)) + f3;
    }

    private boolean a(float f, float f2) {
        return (Float.isNaN(f) || Float.isNaN(f2)) ? Float.isNaN(f) != Float.isNaN(f2) : Math.abs(f - f2) > 1.0E-6f;
    }

    private static final float b(float f, float f2, float f3, float f4, float f5, float f6) {
        return ((f5 - f3) * f) + ((f6 - f4) * f2) + f4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int a(String str, double[] dArr, int i) {
        float[] fArr;
        CustomVariable customVariable = this.p.get(str);
        int i2 = 0;
        if (customVariable == null) {
            return 0;
        }
        if (customVariable.numberOfInterpolatedValues() == 1) {
            dArr[i] = customVariable.getValueToInterpolate();
            return 1;
        }
        int numberOfInterpolatedValues = customVariable.numberOfInterpolatedValues();
        customVariable.getValuesToInterpolate(new float[numberOfInterpolatedValues]);
        while (i2 < numberOfInterpolatedValues) {
            dArr[i] = fArr[i2];
            i2++;
            i++;
        }
        return numberOfInterpolatedValues;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(double d, int[] iArr, double[] dArr, float[] fArr, int i) {
        float f = this.f;
        float f2 = this.g;
        float f3 = this.h;
        float f4 = this.i;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= iArr.length) {
                break;
            }
            float f5 = (float) dArr[i3];
            int i4 = iArr[i3];
            if (i4 == 1) {
                f = f5;
            } else if (i4 == 2) {
                f2 = f5;
            } else if (i4 == 3) {
                f3 = f5;
            } else if (i4 == 4) {
                f4 = f5;
            }
            i2 = i3 + 1;
        }
        Motion motion = this.o;
        float f6 = f;
        float f7 = f2;
        if (motion != null) {
            float[] fArr2 = new float[2];
            motion.getCenter(d, fArr2, new float[2]);
            float f8 = fArr2[0];
            float f9 = fArr2[1];
            double d2 = f8;
            double d3 = f;
            double d4 = f2;
            float sin = (float) ((d2 + (Math.sin(d4) * d3)) - (f3 / 2.0f));
            f7 = (float) ((f9 - (d3 * Math.cos(d4))) - (f4 / 2.0f));
            f6 = sin;
        }
        fArr[i] = f6 + (f3 / 2.0f) + 0.0f;
        fArr[i + 1] = f7 + (f4 / 2.0f) + 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(double d, int[] iArr, double[] dArr, float[] fArr, double[] dArr2, float[] fArr2) {
        float f = this.f;
        float f2 = this.g;
        float f3 = this.h;
        float f4 = this.i;
        float f5 = 0.0f;
        float f6 = 0.0f;
        float f7 = 0.0f;
        float f8 = 0.0f;
        for (int i = 0; i < iArr.length; i++) {
            float f9 = (float) dArr[i];
            float f10 = (float) dArr2[i];
            int i2 = iArr[i];
            if (i2 == 1) {
                f5 = f10;
                f = f9;
            } else if (i2 == 2) {
                f2 = f9;
                f7 = f10;
            } else if (i2 == 3) {
                f3 = f9;
                f6 = f10;
            } else if (i2 == 4) {
                f4 = f9;
                f8 = f10;
            }
        }
        float f11 = (f6 / 2.0f) + f5;
        float f12 = (f8 / 2.0f) + f7;
        Motion motion = this.o;
        if (motion != null) {
            float[] fArr3 = new float[2];
            float[] fArr4 = new float[2];
            motion.getCenter(d, fArr3, fArr4);
            float f13 = fArr3[0];
            float f14 = fArr3[1];
            float f15 = fArr4[0];
            float f16 = fArr4[1];
            double d2 = f13;
            double d3 = f;
            double d4 = f2;
            f = (float) ((d2 + (Math.sin(d4) * d3)) - (f3 / 2.0f));
            f2 = (float) ((f14 - (d3 * Math.cos(d4))) - (f4 / 2.0f));
            double d5 = f15;
            double d6 = f5;
            double sin = Math.sin(d4);
            double cos = Math.cos(d4);
            double d7 = f7;
            f11 = (float) (d5 + (sin * d6) + (cos * d7));
            f12 = (float) ((f16 - (d6 * Math.cos(d4))) + (Math.sin(d4) * d7));
        }
        fArr[0] = f + (f3 / 2.0f) + 0.0f;
        fArr[1] = f2 + (f4 / 2.0f) + 0.0f;
        fArr2[0] = f11;
        fArr2[1] = f12;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(float f, float f2, float f3, float f4) {
        this.f = f;
        this.g = f2;
        this.h = f3;
        this.i = f4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(float f, MotionWidget motionWidget, int[] iArr, double[] dArr, double[] dArr2, double[] dArr3) {
        float f2;
        float f3;
        float f4;
        float f5 = this.f;
        float f6 = this.g;
        float f7 = this.h;
        float f8 = this.i;
        if (iArr.length != 0 && this.s.length <= iArr[iArr.length - 1]) {
            int i = iArr[iArr.length - 1] + 1;
            this.s = new double[i];
            this.t = new double[i];
        }
        Arrays.fill(this.s, Double.NaN);
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= iArr.length) {
                break;
            }
            this.s[iArr[i3]] = dArr[i3];
            this.t[iArr[i3]] = dArr2[i3];
            i2 = i3 + 1;
        }
        float f9 = Float.NaN;
        int i4 = 0;
        float f10 = 0.0f;
        float f11 = 0.0f;
        float f12 = 0.0f;
        float f13 = 0.0f;
        while (true) {
            double[] dArr4 = this.s;
            if (i4 >= dArr4.length) {
                break;
            }
            double d = 0.0d;
            if (!Double.isNaN(dArr4[i4]) || (dArr3 != null && dArr3[i4] != 0.0d)) {
                if (dArr3 != null) {
                    d = dArr3[i4];
                }
                if (!Double.isNaN(this.s[i4])) {
                    d = this.s[i4] + d;
                }
                float f14 = f9;
                f4 = (float) d;
                float f15 = (float) this.t[i4];
                if (i4 == 1) {
                    f5 = f4;
                    f10 = f15;
                    f4 = f14;
                } else if (i4 == 2) {
                    f6 = f4;
                    f4 = f14;
                    f11 = f15;
                } else if (i4 == 3) {
                    f7 = f4;
                    f4 = f14;
                    f12 = f15;
                } else if (i4 == 4) {
                    f8 = f4;
                    f4 = f14;
                    f13 = f15;
                } else if (i4 == 5) {
                }
                i4++;
                f9 = f4;
            }
            f4 = f9;
            i4++;
            f9 = f4;
        }
        Motion motion = this.o;
        if (motion != null) {
            float[] fArr = new float[2];
            float[] fArr2 = new float[2];
            motion.getCenter(f, fArr, fArr2);
            float f16 = fArr[0];
            float f17 = fArr[1];
            float f18 = fArr2[0];
            float f19 = fArr2[1];
            double d2 = f16;
            double d3 = f5;
            double d4 = f6;
            f2 = (float) ((d2 + (Math.sin(d4) * d3)) - (f7 / 2.0f));
            f3 = (float) ((f17 - (Math.cos(d4) * d3)) - (f8 / 2.0f));
            double d5 = f18;
            double d6 = f10;
            double sin = Math.sin(d4);
            double cos = Math.cos(d4);
            double d7 = f11;
            float f20 = (float) (d5 + (sin * d6) + (cos * d3 * d7));
            float cos2 = (float) ((f19 - (d6 * Math.cos(d4))) + (d3 * Math.sin(d4) * d7));
            if (dArr2.length >= 2) {
                dArr2[0] = f20;
                dArr2[1] = cos2;
            }
            if (!Float.isNaN(f9)) {
                motionWidget.setRotationZ((float) (f9 + Math.toDegrees(Math.atan2(cos2, f20))));
            }
        } else {
            f2 = f5;
            f3 = f6;
            if (!Float.isNaN(f9)) {
                float f21 = f11;
                motionWidget.setRotationZ((float) (0.0f + f9 + Math.toDegrees(Math.atan2(f21 + (f13 / 2.0f), f10 + (f12 / 2.0f)))));
                f3 = f6;
                f2 = f5;
            }
        }
        float f22 = f2 + 0.5f;
        int i5 = (int) f22;
        float f23 = f3 + 0.5f;
        motionWidget.layout(i5, (int) f23, (int) (f22 + f7), (int) (f23 + f8));
    }

    void a(int i, int i2, MotionKeyPosition motionKeyPosition, MotionPaths motionPaths, MotionPaths motionPaths2) {
        float min;
        float f;
        float f2 = motionKeyPosition.mFramePosition / 100.0f;
        this.d = f2;
        this.f1966c = motionKeyPosition.mDrawPath;
        this.q = motionKeyPosition.mPositionType;
        float f3 = Float.isNaN(motionKeyPosition.mPercentWidth) ? f2 : motionKeyPosition.mPercentWidth;
        float f4 = Float.isNaN(motionKeyPosition.mPercentHeight) ? f2 : motionKeyPosition.mPercentHeight;
        float f5 = motionPaths2.h;
        float f6 = motionPaths.h;
        float f7 = motionPaths2.i;
        float f8 = motionPaths.i;
        this.e = this.d;
        this.h = (int) (f6 + ((f5 - f6) * f3));
        this.i = (int) (f8 + ((f7 - f8) * f4));
        int i3 = motionKeyPosition.mPositionType;
        if (i3 == 1) {
            float f9 = Float.isNaN(motionKeyPosition.mPercentX) ? f2 : motionKeyPosition.mPercentX;
            float f10 = motionPaths2.f;
            float f11 = motionPaths.f;
            this.f = (f9 * (f10 - f11)) + f11;
            if (!Float.isNaN(motionKeyPosition.mPercentY)) {
                f2 = motionKeyPosition.mPercentY;
            }
            float f12 = motionPaths2.g;
            float f13 = motionPaths.g;
            this.g = (f2 * (f12 - f13)) + f13;
        } else if (i3 != 2) {
            float f14 = Float.isNaN(motionKeyPosition.mPercentX) ? f2 : motionKeyPosition.mPercentX;
            float f15 = motionPaths2.f;
            float f16 = motionPaths.f;
            this.f = (f14 * (f15 - f16)) + f16;
            if (!Float.isNaN(motionKeyPosition.mPercentY)) {
                f2 = motionKeyPosition.mPercentY;
            }
            float f17 = motionPaths2.g;
            float f18 = motionPaths.g;
            this.g = (f2 * (f17 - f18)) + f18;
        } else {
            if (Float.isNaN(motionKeyPosition.mPercentX)) {
                float f19 = motionPaths2.f;
                float f20 = motionPaths.f;
                min = ((f19 - f20) * f2) + f20;
            } else {
                min = Math.min(f4, f3) * motionKeyPosition.mPercentX;
            }
            this.f = min;
            if (Float.isNaN(motionKeyPosition.mPercentY)) {
                float f21 = motionPaths2.g;
                float f22 = motionPaths.g;
                f = (f2 * (f21 - f22)) + f22;
            } else {
                f = motionKeyPosition.mPercentY;
            }
            this.g = f;
        }
        this.m = motionPaths.m;
        this.b = Easing.getInterpolator(motionKeyPosition.mTransitionEasing);
        this.l = motionKeyPosition.mPathMotionArc;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(MotionPaths motionPaths, boolean[] zArr, String[] strArr, boolean z) {
        boolean a2 = a(this.f, motionPaths.f);
        boolean a3 = a(this.g, motionPaths.g);
        zArr[0] = zArr[0] | a(this.e, motionPaths.e);
        boolean z2 = a2 | a3 | z;
        zArr[1] = zArr[1] | z2;
        zArr[2] = z2 | zArr[2];
        zArr[3] = zArr[3] | a(this.h, motionPaths.h);
        zArr[4] = a(this.i, motionPaths.i) | zArr[4];
    }

    void a(MotionKeyPosition motionKeyPosition, MotionPaths motionPaths, MotionPaths motionPaths2) {
        float f;
        float f2;
        float f3 = motionKeyPosition.mFramePosition / 100.0f;
        this.d = f3;
        this.f1966c = motionKeyPosition.mDrawPath;
        float f4 = Float.isNaN(motionKeyPosition.mPercentWidth) ? f3 : motionKeyPosition.mPercentWidth;
        float f5 = Float.isNaN(motionKeyPosition.mPercentHeight) ? f3 : motionKeyPosition.mPercentHeight;
        float f6 = motionPaths2.h;
        float f7 = motionPaths.h;
        float f8 = motionPaths2.i;
        float f9 = motionPaths.i;
        this.e = this.d;
        float f10 = motionPaths.f;
        float f11 = f7 / 2.0f;
        float f12 = motionPaths.g;
        float f13 = f9 / 2.0f;
        float f14 = f6 / 2.0f;
        float f15 = f8 / 2.0f;
        float f16 = (motionPaths2.f + f14) - (f11 + f10);
        float f17 = (motionPaths2.g + f15) - (f12 + f13);
        float f18 = ((f6 - f7) * f4) / 2.0f;
        this.f = (int) ((f10 + (f16 * f3)) - f18);
        float f19 = ((f8 - f9) * f5) / 2.0f;
        this.g = (int) ((f12 + (f17 * f3)) - f19);
        this.h = (int) (f7 + f);
        this.i = (int) (f9 + f2);
        float f20 = Float.isNaN(motionKeyPosition.mPercentX) ? f3 : motionKeyPosition.mPercentX;
        float f21 = 0.0f;
        float f22 = Float.isNaN(motionKeyPosition.mAltPercentY) ? 0.0f : motionKeyPosition.mAltPercentY;
        if (!Float.isNaN(motionKeyPosition.mPercentY)) {
            f3 = motionKeyPosition.mPercentY;
        }
        if (!Float.isNaN(motionKeyPosition.mAltPercentX)) {
            f21 = motionKeyPosition.mAltPercentX;
        }
        this.q = 0;
        this.f = (int) (((motionPaths.f + (f20 * f16)) + (f21 * f17)) - f18);
        this.g = (int) (((motionPaths.g + (f16 * f22)) + (f17 * f3)) - f19);
        this.b = Easing.getInterpolator(motionKeyPosition.mTransitionEasing);
        this.l = motionKeyPosition.mPathMotionArc;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(double[] dArr, int[] iArr) {
        float f = this.e;
        int i = 0;
        float f2 = this.f;
        float f3 = this.g;
        float f4 = this.h;
        float f5 = this.i;
        float f6 = this.j;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i >= iArr.length) {
                return;
            }
            int i4 = i3;
            if (iArr[i] < 6) {
                dArr[i3] = new float[]{f, f2, f3, f4, f5, f6}[iArr[i]];
                i4 = i3 + 1;
            }
            i++;
            i2 = i4;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int[] iArr, double[] dArr, float[] fArr, int i) {
        float f = this.f;
        float f2 = this.g;
        float f3 = this.h;
        float f4 = this.i;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= iArr.length) {
                break;
            }
            float f5 = (float) dArr[i3];
            int i4 = iArr[i3];
            if (i4 == 1) {
                f = f5;
            } else if (i4 == 2) {
                f2 = f5;
            } else if (i4 == 3) {
                f3 = f5;
            } else if (i4 == 4) {
                f4 = f5;
            }
            i2 = i3 + 1;
        }
        Motion motion = this.o;
        float f6 = f;
        float f7 = f2;
        if (motion != null) {
            float centerX = motion.getCenterX();
            float centerY = this.o.getCenterY();
            double d = centerX;
            double d2 = f;
            double d3 = f2;
            f6 = (float) ((d + (Math.sin(d3) * d2)) - (f3 / 2.0f));
            f7 = (float) ((centerY - (d2 * Math.cos(d3))) - (f4 / 2.0f));
        }
        float f8 = f3 + f6;
        float f9 = f4 + f7;
        Float.isNaN(Float.NaN);
        Float.isNaN(Float.NaN);
        int i5 = i + 1;
        fArr[i] = f6 + 0.0f;
        int i6 = i5 + 1;
        fArr[i5] = f7 + 0.0f;
        int i7 = i6 + 1;
        fArr[i6] = f8 + 0.0f;
        int i8 = i7 + 1;
        fArr[i7] = f7 + 0.0f;
        int i9 = i8 + 1;
        fArr[i8] = f8 + 0.0f;
        int i10 = i9 + 1;
        fArr[i9] = f9 + 0.0f;
        fArr[i10] = f6 + 0.0f;
        fArr[i10 + 1] = f9 + 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(String str) {
        return this.p.containsKey(str);
    }

    public void applyParameters(MotionWidget motionWidget) {
        this.b = Easing.getInterpolator(motionWidget.b.mTransitionEasing);
        this.l = motionWidget.b.mPathMotionArc;
        this.m = motionWidget.b.mAnimateRelativeTo;
        this.j = motionWidget.b.mPathRotate;
        this.f1966c = motionWidget.b.mDrawPath;
        this.r = motionWidget.b.mAnimateCircleAngleTo;
        this.k = motionWidget.f1968c.mProgress;
        this.n = 0.0f;
        for (String str : motionWidget.getCustomAttributeNames()) {
            CustomVariable customAttribute = motionWidget.getCustomAttribute(str);
            if (customAttribute != null && customAttribute.isContinuous()) {
                this.p.put(str, customAttribute);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int b(String str) {
        CustomVariable customVariable = this.p.get(str);
        if (customVariable == null) {
            return 0;
        }
        return customVariable.numberOfInterpolatedValues();
    }

    void b(int i, int i2, MotionKeyPosition motionKeyPosition, MotionPaths motionPaths, MotionPaths motionPaths2) {
        float f = motionKeyPosition.mFramePosition / 100.0f;
        this.d = f;
        this.f1966c = motionKeyPosition.mDrawPath;
        float f2 = Float.isNaN(motionKeyPosition.mPercentWidth) ? f : motionKeyPosition.mPercentWidth;
        float f3 = Float.isNaN(motionKeyPosition.mPercentHeight) ? f : motionKeyPosition.mPercentHeight;
        float f4 = motionPaths2.h;
        float f5 = motionPaths.h;
        float f6 = motionPaths2.i;
        float f7 = motionPaths.i;
        this.e = this.d;
        float f8 = motionPaths.f;
        float f9 = f5 / 2.0f;
        float f10 = motionPaths.g;
        float f11 = f7 / 2.0f;
        float f12 = motionPaths2.f;
        float f13 = f4 / 2.0f;
        float f14 = motionPaths2.g;
        float f15 = f6 / 2.0f;
        float f16 = (f4 - f5) * f2;
        this.f = (int) ((f8 + (((f12 + f13) - (f9 + f8)) * f)) - (f16 / 2.0f));
        float f17 = (f6 - f7) * f3;
        this.g = (int) ((f10 + (((f14 + f15) - (f10 + f11)) * f)) - (f17 / 2.0f));
        this.h = (int) (f5 + f16);
        this.i = (int) (f7 + f17);
        this.q = 2;
        if (!Float.isNaN(motionKeyPosition.mPercentX)) {
            this.f = (int) (motionKeyPosition.mPercentX * ((int) (i - this.h)));
        }
        if (!Float.isNaN(motionKeyPosition.mPercentY)) {
            this.g = (int) (motionKeyPosition.mPercentY * ((int) (i2 - this.i)));
        }
        this.m = this.m;
        this.b = Easing.getInterpolator(motionKeyPosition.mTransitionEasing);
        this.l = motionKeyPosition.mPathMotionArc;
    }

    void b(MotionKeyPosition motionKeyPosition, MotionPaths motionPaths, MotionPaths motionPaths2) {
        float f;
        float f2;
        float f3;
        float f4;
        float f5 = motionKeyPosition.mFramePosition / 100.0f;
        this.d = f5;
        this.f1966c = motionKeyPosition.mDrawPath;
        float f6 = Float.isNaN(motionKeyPosition.mPercentWidth) ? f5 : motionKeyPosition.mPercentWidth;
        float f7 = Float.isNaN(motionKeyPosition.mPercentHeight) ? f5 : motionKeyPosition.mPercentHeight;
        float f8 = motionPaths2.h;
        float f9 = motionPaths.h;
        float f10 = motionPaths2.i;
        float f11 = motionPaths.i;
        this.e = this.d;
        if (!Float.isNaN(motionKeyPosition.mPercentX)) {
            f5 = motionKeyPosition.mPercentX;
        }
        float f12 = motionPaths.f;
        float f13 = motionPaths.h / 2.0f;
        float f14 = motionPaths.g;
        float f15 = motionPaths.i / 2.0f;
        float f16 = (motionPaths2.f + (motionPaths2.h / 2.0f)) - (f13 + f12);
        float f17 = (motionPaths2.g + (motionPaths2.i / 2.0f)) - (f15 + f14);
        float f18 = f16 * f5;
        float f19 = ((f8 - f9) * f6) / 2.0f;
        this.f = (int) ((f12 + f18) - f19);
        float f20 = f5 * f17;
        float f21 = ((f10 - f11) * f7) / 2.0f;
        this.g = (int) ((f14 + f20) - f21);
        this.h = (int) (f + f3);
        this.i = (int) (f2 + f4);
        float f22 = Float.isNaN(motionKeyPosition.mPercentY) ? 0.0f : motionKeyPosition.mPercentY;
        float f23 = -f17;
        this.q = 1;
        float f24 = (int) ((motionPaths.f + f18) - f19);
        this.f = f24;
        float f25 = (int) ((motionPaths.g + f20) - f21);
        this.g = f25;
        this.f = f24 + (f23 * f22);
        this.g = f25 + (f16 * f22);
        this.m = this.m;
        this.b = Easing.getInterpolator(motionKeyPosition.mTransitionEasing);
        this.l = motionKeyPosition.mPathMotionArc;
    }

    @Override // java.lang.Comparable
    public int compareTo(MotionPaths motionPaths) {
        return Float.compare(this.e, motionPaths.e);
    }

    public void configureRelativeTo(Motion motion) {
        motion.a(this.k);
    }

    public void setupRelative(Motion motion, MotionPaths motionPaths) {
        double d = ((this.f + (this.h / 2.0f)) - motionPaths.f) - (motionPaths.h / 2.0f);
        double d2 = ((this.g + (this.i / 2.0f)) - motionPaths.g) - (motionPaths.i / 2.0f);
        this.o = motion;
        this.f = (float) Math.hypot(d2, d);
        if (Float.isNaN(this.n)) {
            this.g = (float) (Math.atan2(d2, d) + 1.5707963267948966d);
        } else {
            this.g = (float) Math.toRadians(this.n);
        }
    }
}
