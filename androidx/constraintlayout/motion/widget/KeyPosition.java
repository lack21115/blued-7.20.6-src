package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.core.motion.utils.Easing;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.motion.utils.ViewSpline;
import androidx.constraintlayout.widget.R;
import java.util.HashMap;

/* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/motion/widget/KeyPosition.class */
public class KeyPosition extends KeyPositionBase {
    public static final String DRAWPATH = "drawPath";
    public static final String PERCENT_HEIGHT = "percentHeight";
    public static final String PERCENT_WIDTH = "percentWidth";
    public static final String PERCENT_X = "percentX";
    public static final String PERCENT_Y = "percentY";
    public static final String SIZE_PERCENT = "sizePercent";
    public static final String TRANSITION_EASING = "transitionEasing";
    public static final int TYPE_CARTESIAN = 0;
    public static final int TYPE_PATH = 1;
    public static final int TYPE_SCREEN = 2;
    String f = null;
    int g = UNSET;
    int h = 0;
    float i = Float.NaN;
    float j = Float.NaN;
    float k = Float.NaN;
    float l = Float.NaN;
    float m = Float.NaN;
    float n = Float.NaN;
    int o = 0;
    private float q = Float.NaN;
    private float r = Float.NaN;

    /* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/motion/widget/KeyPosition$Loader.class */
    static class Loader {

        /* renamed from: a  reason: collision with root package name */
        private static SparseIntArray f2126a;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            f2126a = sparseIntArray;
            sparseIntArray.append(R.styleable.KeyPosition_motionTarget, 1);
            f2126a.append(R.styleable.KeyPosition_framePosition, 2);
            f2126a.append(R.styleable.KeyPosition_transitionEasing, 3);
            f2126a.append(R.styleable.KeyPosition_curveFit, 4);
            f2126a.append(R.styleable.KeyPosition_drawPath, 5);
            f2126a.append(R.styleable.KeyPosition_percentX, 6);
            f2126a.append(R.styleable.KeyPosition_percentY, 7);
            f2126a.append(R.styleable.KeyPosition_keyPositionType, 9);
            f2126a.append(R.styleable.KeyPosition_sizePercent, 8);
            f2126a.append(R.styleable.KeyPosition_percentWidth, 11);
            f2126a.append(R.styleable.KeyPosition_percentHeight, 12);
            f2126a.append(R.styleable.KeyPosition_pathMotionArc, 10);
        }

        private Loader() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void b(KeyPosition keyPosition, TypedArray typedArray) {
            int indexCount = typedArray.getIndexCount();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= indexCount) {
                    if (keyPosition.f2121a == -1) {
                        Log.e(TypedValues.PositionType.NAME, "no frame position");
                        return;
                    }
                    return;
                }
                int index = typedArray.getIndex(i2);
                switch (f2126a.get(index)) {
                    case 1:
                        if (!MotionLayout.IS_IN_EDIT_MODE) {
                            if (typedArray.peekValue(index).type != 3) {
                                keyPosition.b = typedArray.getResourceId(index, keyPosition.b);
                                break;
                            } else {
                                keyPosition.f2122c = typedArray.getString(index);
                                break;
                            }
                        } else {
                            keyPosition.b = typedArray.getResourceId(index, keyPosition.b);
                            if (keyPosition.b != -1) {
                                break;
                            } else {
                                keyPosition.f2122c = typedArray.getString(index);
                                break;
                            }
                        }
                    case 2:
                        keyPosition.f2121a = typedArray.getInt(index, keyPosition.f2121a);
                        break;
                    case 3:
                        if (typedArray.peekValue(index).type != 3) {
                            keyPosition.f = Easing.NAMED_EASING[typedArray.getInteger(index, 0)];
                            break;
                        } else {
                            keyPosition.f = typedArray.getString(index);
                            break;
                        }
                    case 4:
                        keyPosition.p = typedArray.getInteger(index, keyPosition.p);
                        break;
                    case 5:
                        keyPosition.h = typedArray.getInt(index, keyPosition.h);
                        break;
                    case 6:
                        keyPosition.k = typedArray.getFloat(index, keyPosition.k);
                        break;
                    case 7:
                        keyPosition.l = typedArray.getFloat(index, keyPosition.l);
                        break;
                    case 8:
                        float f = typedArray.getFloat(index, keyPosition.j);
                        keyPosition.i = f;
                        keyPosition.j = f;
                        break;
                    case 9:
                        keyPosition.o = typedArray.getInt(index, keyPosition.o);
                        break;
                    case 10:
                        keyPosition.g = typedArray.getInt(index, keyPosition.g);
                        break;
                    case 11:
                        keyPosition.i = typedArray.getFloat(index, keyPosition.i);
                        break;
                    case 12:
                        keyPosition.j = typedArray.getFloat(index, keyPosition.j);
                        break;
                    default:
                        Log.e(TypedValues.PositionType.NAME, "unused attribute 0x" + Integer.toHexString(index) + "   " + f2126a.get(index));
                        break;
                }
                i = i2 + 1;
            }
        }
    }

    public KeyPosition() {
        this.d = 2;
    }

    private void a(float f, float f2, float f3, float f4) {
        float f5 = f3 - f;
        float f6 = f4 - f2;
        float f7 = -f6;
        float f8 = this.k;
        float f9 = this.l;
        this.q = f + (f5 * f8) + (f7 * f9);
        this.r = f2 + (f6 * f8) + (f5 * f9);
    }

    private void a(int i, int i2) {
        float f = this.k;
        float f2 = 0;
        this.q = ((i - 0) * f) + f2;
        this.r = ((i2 - 0) * f) + f2;
    }

    private void b(float f, float f2, float f3, float f4) {
        float f5 = f3 - f;
        float f6 = f4 - f2;
        float f7 = 0.0f;
        float f8 = Float.isNaN(this.k) ? 0.0f : this.k;
        float f9 = Float.isNaN(this.n) ? 0.0f : this.n;
        float f10 = Float.isNaN(this.l) ? 0.0f : this.l;
        if (!Float.isNaN(this.m)) {
            f7 = this.m;
        }
        this.q = (int) (f + (f8 * f5) + (f7 * f6));
        this.r = (int) (f2 + (f5 * f9) + (f6 * f10));
    }

    @Override // androidx.constraintlayout.motion.widget.KeyPositionBase
    void a(int i, int i2, float f, float f2, float f3, float f4) {
        int i3 = this.o;
        if (i3 == 1) {
            a(f, f2, f3, f4);
        } else if (i3 != 2) {
            b(f, f2, f3, f4);
        } else {
            a(i, i2);
        }
    }

    void a(RectF rectF, RectF rectF2, float f, float f2, String[] strArr, float[] fArr) {
        float centerX = rectF.centerX();
        float centerY = rectF.centerY();
        float centerX2 = rectF2.centerX() - centerX;
        float centerY2 = rectF2.centerY() - centerY;
        float hypot = (float) Math.hypot(centerX2, centerY2);
        if (hypot < 1.0E-4d) {
            System.out.println("distance ~ 0");
            fArr[0] = 0.0f;
            fArr[1] = 0.0f;
            return;
        }
        float f3 = centerX2 / hypot;
        float f4 = centerY2 / hypot;
        float f5 = f2 - centerY;
        float f6 = f - centerX;
        float f7 = ((f3 * f5) - (f6 * f4)) / hypot;
        float f8 = ((f3 * f6) + (f4 * f5)) / hypot;
        if (strArr[0] != null) {
            if ("percentX".equals(strArr[0])) {
                fArr[0] = f8;
                fArr[1] = f7;
                return;
            }
            return;
        }
        strArr[0] = "percentX";
        strArr[1] = "percentY";
        fArr[0] = f8;
        fArr[1] = f7;
    }

    void a(View view, RectF rectF, RectF rectF2, float f, float f2, String[] strArr, float[] fArr) {
        rectF.centerX();
        rectF.centerY();
        rectF2.centerX();
        rectF2.centerY();
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        int width = viewGroup.getWidth();
        int height = viewGroup.getHeight();
        if (strArr[0] == null) {
            strArr[0] = "percentX";
            fArr[0] = f / width;
            strArr[1] = "percentY";
            fArr[1] = f2 / height;
        } else if ("percentX".equals(strArr[0])) {
            fArr[0] = f / width;
            fArr[1] = f2 / height;
        } else {
            fArr[1] = f / width;
            fArr[0] = f2 / height;
        }
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public void addValues(HashMap<String, ViewSpline> hashMap) {
    }

    void b(RectF rectF, RectF rectF2, float f, float f2, String[] strArr, float[] fArr) {
        float centerX = rectF.centerX();
        float centerY = rectF.centerY();
        float centerX2 = rectF2.centerX() - centerX;
        float centerY2 = rectF2.centerY() - centerY;
        if (strArr[0] == null) {
            strArr[0] = "percentX";
            fArr[0] = (f - centerX) / centerX2;
            strArr[1] = "percentY";
            fArr[1] = (f2 - centerY) / centerY2;
        } else if ("percentX".equals(strArr[0])) {
            fArr[0] = (f - centerX) / centerX2;
            fArr[1] = (f2 - centerY) / centerY2;
        } else {
            fArr[1] = (f - centerX) / centerX2;
            fArr[0] = (f2 - centerY) / centerY2;
        }
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    /* renamed from: clone */
    public Key mo1228clone() {
        return new KeyPosition().copy(this);
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public Key copy(Key key) {
        super.copy(key);
        KeyPosition keyPosition = (KeyPosition) key;
        this.f = keyPosition.f;
        this.g = keyPosition.g;
        this.h = keyPosition.h;
        this.i = keyPosition.i;
        this.j = Float.NaN;
        this.k = keyPosition.k;
        this.l = keyPosition.l;
        this.m = keyPosition.m;
        this.n = keyPosition.n;
        this.q = keyPosition.q;
        this.r = keyPosition.r;
        return this;
    }

    @Override // androidx.constraintlayout.motion.widget.KeyPositionBase
    public boolean intersects(int i, int i2, RectF rectF, RectF rectF2, float f, float f2) {
        a(i, i2, rectF.centerX(), rectF.centerY(), rectF2.centerX(), rectF2.centerY());
        return Math.abs(f - this.q) < 20.0f && Math.abs(f2 - this.r) < 20.0f;
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public void load(Context context, AttributeSet attributeSet) {
        Loader.b(this, context.obtainStyledAttributes(attributeSet, R.styleable.KeyPosition));
    }

    @Override // androidx.constraintlayout.motion.widget.KeyPositionBase
    public void positionAttributes(View view, RectF rectF, RectF rectF2, float f, float f2, String[] strArr, float[] fArr) {
        int i = this.o;
        if (i == 1) {
            a(rectF, rectF2, f, f2, strArr, fArr);
        } else if (i != 2) {
            b(rectF, rectF2, f, f2, strArr, fArr);
        } else {
            a(view, rectF, rectF2, f, f2, strArr, fArr);
        }
    }

    public void setType(int i) {
        this.o = i;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // androidx.constraintlayout.motion.widget.Key
    public void setValue(String str, Object obj) {
        boolean z;
        switch (str.hashCode()) {
            case -1812823328:
                if (str.equals("transitionEasing")) {
                    z = false;
                    break;
                }
                z = true;
                break;
            case -1127236479:
                if (str.equals("percentWidth")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case -1017587252:
                if (str.equals("percentHeight")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case -827014263:
                if (str.equals("drawPath")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case -200259324:
                if (str.equals("sizePercent")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case 428090547:
                if (str.equals("percentX")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case 428090548:
                if (str.equals("percentY")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            default:
                z = true;
                break;
        }
        switch (z) {
            case false:
                this.f = obj.toString();
                return;
            case true:
                this.h = b(obj);
                return;
            case true:
                this.i = a(obj);
                return;
            case true:
                this.j = a(obj);
                return;
            case true:
                float a2 = a(obj);
                this.i = a2;
                this.j = a2;
                return;
            case true:
                this.k = a(obj);
                return;
            case true:
                this.l = a(obj);
                return;
            default:
                return;
        }
    }
}
