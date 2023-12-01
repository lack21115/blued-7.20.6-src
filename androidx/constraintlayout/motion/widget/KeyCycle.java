package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.motion.utils.ViewOscillator;
import androidx.constraintlayout.motion.utils.ViewSpline;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.constraintlayout.widget.R;
import java.util.HashMap;
import java.util.HashSet;

/* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/motion/widget/KeyCycle.class */
public class KeyCycle extends Key {
    public static final int KEY_TYPE = 4;
    public static final int SHAPE_BOUNCE = 6;
    public static final int SHAPE_COS_WAVE = 5;
    public static final int SHAPE_REVERSE_SAW_WAVE = 4;
    public static final int SHAPE_SAW_WAVE = 3;
    public static final int SHAPE_SIN_WAVE = 0;
    public static final int SHAPE_SQUARE_WAVE = 1;
    public static final int SHAPE_TRIANGLE_WAVE = 2;
    public static final String WAVE_OFFSET = "waveOffset";
    public static final String WAVE_PERIOD = "wavePeriod";
    public static final String WAVE_PHASE = "wavePhase";
    public static final String WAVE_SHAPE = "waveShape";
    private String f = null;
    private int g = 0;
    private int h = -1;
    private String i = null;
    private float j = Float.NaN;
    private float k = 0.0f;
    private float l = 0.0f;
    private float m = Float.NaN;
    private int n = -1;
    private float o = Float.NaN;
    private float p = Float.NaN;
    private float q = Float.NaN;
    private float r = Float.NaN;
    private float s = Float.NaN;
    private float t = Float.NaN;
    private float u = Float.NaN;
    private float v = Float.NaN;
    private float w = Float.NaN;
    private float x = Float.NaN;
    private float y = Float.NaN;

    /* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/motion/widget/KeyCycle$Loader.class */
    static class Loader {

        /* renamed from: a  reason: collision with root package name */
        private static SparseIntArray f2172a;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            f2172a = sparseIntArray;
            sparseIntArray.append(R.styleable.KeyCycle_motionTarget, 1);
            f2172a.append(R.styleable.KeyCycle_framePosition, 2);
            f2172a.append(R.styleable.KeyCycle_transitionEasing, 3);
            f2172a.append(R.styleable.KeyCycle_curveFit, 4);
            f2172a.append(R.styleable.KeyCycle_waveShape, 5);
            f2172a.append(R.styleable.KeyCycle_wavePeriod, 6);
            f2172a.append(R.styleable.KeyCycle_waveOffset, 7);
            f2172a.append(R.styleable.KeyCycle_waveVariesBy, 8);
            f2172a.append(R.styleable.KeyCycle_android_alpha, 9);
            f2172a.append(R.styleable.KeyCycle_android_elevation, 10);
            f2172a.append(R.styleable.KeyCycle_android_rotation, 11);
            f2172a.append(R.styleable.KeyCycle_android_rotationX, 12);
            f2172a.append(R.styleable.KeyCycle_android_rotationY, 13);
            f2172a.append(R.styleable.KeyCycle_transitionPathRotate, 14);
            f2172a.append(R.styleable.KeyCycle_android_scaleX, 15);
            f2172a.append(R.styleable.KeyCycle_android_scaleY, 16);
            f2172a.append(R.styleable.KeyCycle_android_translationX, 17);
            f2172a.append(R.styleable.KeyCycle_android_translationY, 18);
            f2172a.append(R.styleable.KeyCycle_android_translationZ, 19);
            f2172a.append(R.styleable.KeyCycle_motionProgress, 20);
            f2172a.append(R.styleable.KeyCycle_wavePhase, 21);
        }

        private Loader() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static void b(KeyCycle keyCycle, TypedArray typedArray) {
            int indexCount = typedArray.getIndexCount();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= indexCount) {
                    return;
                }
                int index = typedArray.getIndex(i2);
                switch (f2172a.get(index)) {
                    case 1:
                        if (!MotionLayout.IS_IN_EDIT_MODE) {
                            if (typedArray.peekValue(index).type != 3) {
                                keyCycle.b = typedArray.getResourceId(index, keyCycle.b);
                                break;
                            } else {
                                keyCycle.f2170c = typedArray.getString(index);
                                break;
                            }
                        } else {
                            keyCycle.b = typedArray.getResourceId(index, keyCycle.b);
                            if (keyCycle.b != -1) {
                                break;
                            } else {
                                keyCycle.f2170c = typedArray.getString(index);
                                break;
                            }
                        }
                    case 2:
                        keyCycle.f2169a = typedArray.getInt(index, keyCycle.f2169a);
                        break;
                    case 3:
                        keyCycle.f = typedArray.getString(index);
                        break;
                    case 4:
                        keyCycle.g = typedArray.getInteger(index, keyCycle.g);
                        break;
                    case 5:
                        if (typedArray.peekValue(index).type != 3) {
                            keyCycle.h = typedArray.getInt(index, keyCycle.h);
                            break;
                        } else {
                            keyCycle.i = typedArray.getString(index);
                            keyCycle.h = 7;
                            break;
                        }
                    case 6:
                        keyCycle.j = typedArray.getFloat(index, keyCycle.j);
                        break;
                    case 7:
                        if (typedArray.peekValue(index).type != 5) {
                            keyCycle.k = typedArray.getFloat(index, keyCycle.k);
                            break;
                        } else {
                            keyCycle.k = typedArray.getDimension(index, keyCycle.k);
                            break;
                        }
                    case 8:
                        keyCycle.n = typedArray.getInt(index, keyCycle.n);
                        break;
                    case 9:
                        keyCycle.o = typedArray.getFloat(index, keyCycle.o);
                        break;
                    case 10:
                        keyCycle.p = typedArray.getDimension(index, keyCycle.p);
                        break;
                    case 11:
                        keyCycle.q = typedArray.getFloat(index, keyCycle.q);
                        break;
                    case 12:
                        keyCycle.s = typedArray.getFloat(index, keyCycle.s);
                        break;
                    case 13:
                        keyCycle.t = typedArray.getFloat(index, keyCycle.t);
                        break;
                    case 14:
                        keyCycle.r = typedArray.getFloat(index, keyCycle.r);
                        break;
                    case 15:
                        keyCycle.u = typedArray.getFloat(index, keyCycle.u);
                        break;
                    case 16:
                        keyCycle.v = typedArray.getFloat(index, keyCycle.v);
                        break;
                    case 17:
                        keyCycle.w = typedArray.getDimension(index, keyCycle.w);
                        break;
                    case 18:
                        keyCycle.x = typedArray.getDimension(index, keyCycle.x);
                        break;
                    case 19:
                        if (Build.VERSION.SDK_INT < 21) {
                            break;
                        } else {
                            keyCycle.y = typedArray.getDimension(index, keyCycle.y);
                            break;
                        }
                    case 20:
                        keyCycle.m = typedArray.getFloat(index, keyCycle.m);
                        break;
                    case 21:
                        keyCycle.l = typedArray.getFloat(index, keyCycle.l) / 360.0f;
                        break;
                    default:
                        Log.e(TypedValues.CycleType.NAME, "unused attribute 0x" + Integer.toHexString(index) + "   " + f2172a.get(index));
                        break;
                }
                i = i2 + 1;
            }
        }
    }

    public KeyCycle() {
        this.d = 4;
        this.e = new HashMap<>();
    }

    public void addCycleValues(HashMap<String, ViewOscillator> hashMap) {
        ViewOscillator viewOscillator;
        ViewOscillator viewOscillator2;
        for (String str : hashMap.keySet()) {
            if (str.startsWith("CUSTOM")) {
                ConstraintAttribute constraintAttribute = this.e.get(str.substring(7));
                if (constraintAttribute != null && constraintAttribute.getType() == ConstraintAttribute.AttributeType.FLOAT_TYPE && (viewOscillator = hashMap.get(str)) != null) {
                    viewOscillator.setPoint(this.f2169a, this.h, this.i, this.n, this.j, this.k, this.l, constraintAttribute.getValueToInterpolate(), constraintAttribute);
                }
            } else {
                float value = getValue(str);
                if (!Float.isNaN(value) && (viewOscillator2 = hashMap.get(str)) != null) {
                    viewOscillator2.setPoint(this.f2169a, this.h, this.i, this.n, this.j, this.k, this.l, value);
                }
            }
        }
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public void addValues(HashMap<String, ViewSpline> hashMap) {
        Debug.logStack(TypedValues.CycleType.NAME, "add " + hashMap.size() + " values", 2);
        for (String str : hashMap.keySet()) {
            ViewSpline viewSpline = hashMap.get(str);
            if (viewSpline != null) {
                boolean z = true;
                switch (str.hashCode()) {
                    case -1249320806:
                        if (str.equals("rotationX")) {
                            z = true;
                            break;
                        }
                        break;
                    case -1249320805:
                        if (str.equals("rotationY")) {
                            z = true;
                            break;
                        }
                        break;
                    case -1225497657:
                        if (str.equals("translationX")) {
                            z = true;
                            break;
                        }
                        break;
                    case -1225497656:
                        if (str.equals("translationY")) {
                            z = true;
                            break;
                        }
                        break;
                    case -1225497655:
                        if (str.equals("translationZ")) {
                            z = true;
                            break;
                        }
                        break;
                    case -1001078227:
                        if (str.equals("progress")) {
                            z = true;
                            break;
                        }
                        break;
                    case -908189618:
                        if (str.equals("scaleX")) {
                            z = true;
                            break;
                        }
                        break;
                    case -908189617:
                        if (str.equals("scaleY")) {
                            z = true;
                            break;
                        }
                        break;
                    case -40300674:
                        if (str.equals("rotation")) {
                            z = true;
                            break;
                        }
                        break;
                    case -4379043:
                        if (str.equals("elevation")) {
                            z = true;
                            break;
                        }
                        break;
                    case 37232917:
                        if (str.equals("transitionPathRotate")) {
                            z = true;
                            break;
                        }
                        break;
                    case 92909918:
                        if (str.equals("alpha")) {
                            z = false;
                            break;
                        }
                        break;
                    case 156108012:
                        if (str.equals("waveOffset")) {
                            z = true;
                            break;
                        }
                        break;
                    case 1530034690:
                        if (str.equals("wavePhase")) {
                            z = true;
                            break;
                        }
                        break;
                }
                switch (z) {
                    case false:
                        viewSpline.setPoint(this.f2169a, this.o);
                        continue;
                    case true:
                        viewSpline.setPoint(this.f2169a, this.p);
                        continue;
                    case true:
                        viewSpline.setPoint(this.f2169a, this.q);
                        continue;
                    case true:
                        viewSpline.setPoint(this.f2169a, this.s);
                        continue;
                    case true:
                        viewSpline.setPoint(this.f2169a, this.t);
                        continue;
                    case true:
                        viewSpline.setPoint(this.f2169a, this.r);
                        continue;
                    case true:
                        viewSpline.setPoint(this.f2169a, this.u);
                        continue;
                    case true:
                        viewSpline.setPoint(this.f2169a, this.v);
                        continue;
                    case true:
                        viewSpline.setPoint(this.f2169a, this.w);
                        continue;
                    case true:
                        viewSpline.setPoint(this.f2169a, this.x);
                        continue;
                    case true:
                        viewSpline.setPoint(this.f2169a, this.y);
                        continue;
                    case true:
                        viewSpline.setPoint(this.f2169a, this.k);
                        continue;
                    case true:
                        viewSpline.setPoint(this.f2169a, this.l);
                        continue;
                    case true:
                        viewSpline.setPoint(this.f2169a, this.m);
                        continue;
                    default:
                        if (!str.startsWith("CUSTOM")) {
                            Log.v("WARNING KeyCycle", "  UNKNOWN  " + str);
                            break;
                        } else {
                            continue;
                        }
                }
            }
        }
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    /* renamed from: clone */
    public Key mo1365clone() {
        return new KeyCycle().copy(this);
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public Key copy(Key key) {
        super.copy(key);
        KeyCycle keyCycle = (KeyCycle) key;
        this.f = keyCycle.f;
        this.g = keyCycle.g;
        this.h = keyCycle.h;
        this.i = keyCycle.i;
        this.j = keyCycle.j;
        this.k = keyCycle.k;
        this.l = keyCycle.l;
        this.m = keyCycle.m;
        this.n = keyCycle.n;
        this.o = keyCycle.o;
        this.p = keyCycle.p;
        this.q = keyCycle.q;
        this.r = keyCycle.r;
        this.s = keyCycle.s;
        this.t = keyCycle.t;
        this.u = keyCycle.u;
        this.v = keyCycle.v;
        this.w = keyCycle.w;
        this.x = keyCycle.x;
        this.y = keyCycle.y;
        return this;
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public void getAttributeNames(HashSet<String> hashSet) {
        if (!Float.isNaN(this.o)) {
            hashSet.add("alpha");
        }
        if (!Float.isNaN(this.p)) {
            hashSet.add("elevation");
        }
        if (!Float.isNaN(this.q)) {
            hashSet.add("rotation");
        }
        if (!Float.isNaN(this.s)) {
            hashSet.add("rotationX");
        }
        if (!Float.isNaN(this.t)) {
            hashSet.add("rotationY");
        }
        if (!Float.isNaN(this.u)) {
            hashSet.add("scaleX");
        }
        if (!Float.isNaN(this.v)) {
            hashSet.add("scaleY");
        }
        if (!Float.isNaN(this.r)) {
            hashSet.add("transitionPathRotate");
        }
        if (!Float.isNaN(this.w)) {
            hashSet.add("translationX");
        }
        if (!Float.isNaN(this.x)) {
            hashSet.add("translationY");
        }
        if (!Float.isNaN(this.y)) {
            hashSet.add("translationZ");
        }
        if (this.e.size() > 0) {
            for (String str : this.e.keySet()) {
                hashSet.add("CUSTOM," + str);
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public float getValue(String str) {
        boolean z;
        switch (str.hashCode()) {
            case -1249320806:
                if (str.equals("rotationX")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case -1249320805:
                if (str.equals("rotationY")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case -1225497657:
                if (str.equals("translationX")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case -1225497656:
                if (str.equals("translationY")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case -1225497655:
                if (str.equals("translationZ")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case -1001078227:
                if (str.equals("progress")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case -908189618:
                if (str.equals("scaleX")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case -908189617:
                if (str.equals("scaleY")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case -40300674:
                if (str.equals("rotation")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case -4379043:
                if (str.equals("elevation")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case 37232917:
                if (str.equals("transitionPathRotate")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case 92909918:
                if (str.equals("alpha")) {
                    z = false;
                    break;
                }
                z = true;
                break;
            case 156108012:
                if (str.equals("waveOffset")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case 1530034690:
                if (str.equals("wavePhase")) {
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
                return this.o;
            case true:
                return this.p;
            case true:
                return this.q;
            case true:
                return this.s;
            case true:
                return this.t;
            case true:
                return this.r;
            case true:
                return this.u;
            case true:
                return this.v;
            case true:
                return this.w;
            case true:
                return this.x;
            case true:
                return this.y;
            case true:
                return this.k;
            case true:
                return this.l;
            case true:
                return this.m;
            default:
                if (str.startsWith("CUSTOM")) {
                    return Float.NaN;
                }
                Log.v("WARNING! KeyCycle", "  UNKNOWN  " + str);
                return Float.NaN;
        }
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public void load(Context context, AttributeSet attributeSet) {
        Loader.b(this, context.obtainStyledAttributes(attributeSet, R.styleable.KeyCycle));
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // androidx.constraintlayout.motion.widget.Key
    public void setValue(String str, Object obj) {
        boolean z;
        switch (str.hashCode()) {
            case -1913008125:
                if (str.equals(Key.MOTIONPROGRESS)) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case -1812823328:
                if (str.equals("transitionEasing")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case -1249320806:
                if (str.equals("rotationX")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case -1249320805:
                if (str.equals("rotationY")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case -1225497657:
                if (str.equals("translationX")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case -1225497656:
                if (str.equals("translationY")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case -1225497655:
                if (str.equals("translationZ")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case -908189618:
                if (str.equals("scaleX")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case -908189617:
                if (str.equals("scaleY")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case -40300674:
                if (str.equals("rotation")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case -4379043:
                if (str.equals("elevation")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case 37232917:
                if (str.equals("transitionPathRotate")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case 92909918:
                if (str.equals("alpha")) {
                    z = false;
                    break;
                }
                z = true;
                break;
            case 156108012:
                if (str.equals("waveOffset")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case 184161818:
                if (str.equals("wavePeriod")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case 579057826:
                if (str.equals("curveFit")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case 1530034690:
                if (str.equals("wavePhase")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case 1532805160:
                if (str.equals("waveShape")) {
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
                this.o = a(obj);
                return;
            case true:
                this.g = b(obj);
                return;
            case true:
                this.p = a(obj);
                return;
            case true:
                this.m = a(obj);
                return;
            case true:
                this.q = a(obj);
                return;
            case true:
                this.s = a(obj);
                return;
            case true:
                this.t = a(obj);
                return;
            case true:
                this.u = a(obj);
                return;
            case true:
                this.v = a(obj);
                return;
            case true:
                this.f = obj.toString();
                return;
            case true:
                this.r = a(obj);
                return;
            case true:
                this.w = a(obj);
                return;
            case true:
                this.x = a(obj);
                return;
            case true:
                this.y = a(obj);
                return;
            case true:
                this.j = a(obj);
                return;
            case true:
                this.k = a(obj);
                return;
            case true:
                this.l = a(obj);
                return;
            case true:
                if (obj instanceof Integer) {
                    this.h = b(obj);
                    return;
                }
                this.h = 7;
                this.i = obj.toString();
                return;
            default:
                return;
        }
    }
}
