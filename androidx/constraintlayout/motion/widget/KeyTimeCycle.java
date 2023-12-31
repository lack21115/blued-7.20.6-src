package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import androidx.constraintlayout.motion.utils.ViewSpline;
import androidx.constraintlayout.widget.R;
import java.util.HashMap;
import java.util.HashSet;

/* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/motion/widget/KeyTimeCycle.class */
public class KeyTimeCycle extends Key {
    public static final int KEY_TYPE = 3;
    public static final int SHAPE_BOUNCE = 6;
    public static final int SHAPE_COS_WAVE = 5;
    public static final int SHAPE_REVERSE_SAW_WAVE = 4;
    public static final int SHAPE_SAW_WAVE = 3;
    public static final int SHAPE_SIN_WAVE = 0;
    public static final int SHAPE_SQUARE_WAVE = 1;
    public static final int SHAPE_TRIANGLE_WAVE = 2;
    public static final String WAVE_OFFSET = "waveOffset";
    public static final String WAVE_PERIOD = "wavePeriod";
    public static final String WAVE_SHAPE = "waveShape";
    private String f;
    private int g = -1;
    private float h = Float.NaN;
    private float i = Float.NaN;
    private float j = Float.NaN;
    private float k = Float.NaN;
    private float l = Float.NaN;
    private float m = Float.NaN;
    private float n = Float.NaN;
    private float o = Float.NaN;
    private float p = Float.NaN;
    private float q = Float.NaN;
    private float r = Float.NaN;
    private float s = Float.NaN;
    private int t = 0;
    private String u = null;
    private float v = Float.NaN;
    private float w = 0.0f;

    /* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/motion/widget/KeyTimeCycle$Loader.class */
    static class Loader {

        /* renamed from: a  reason: collision with root package name */
        private static SparseIntArray f2127a;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            f2127a = sparseIntArray;
            sparseIntArray.append(R.styleable.KeyTimeCycle_android_alpha, 1);
            f2127a.append(R.styleable.KeyTimeCycle_android_elevation, 2);
            f2127a.append(R.styleable.KeyTimeCycle_android_rotation, 4);
            f2127a.append(R.styleable.KeyTimeCycle_android_rotationX, 5);
            f2127a.append(R.styleable.KeyTimeCycle_android_rotationY, 6);
            f2127a.append(R.styleable.KeyTimeCycle_android_scaleX, 7);
            f2127a.append(R.styleable.KeyTimeCycle_transitionPathRotate, 8);
            f2127a.append(R.styleable.KeyTimeCycle_transitionEasing, 9);
            f2127a.append(R.styleable.KeyTimeCycle_motionTarget, 10);
            f2127a.append(R.styleable.KeyTimeCycle_framePosition, 12);
            f2127a.append(R.styleable.KeyTimeCycle_curveFit, 13);
            f2127a.append(R.styleable.KeyTimeCycle_android_scaleY, 14);
            f2127a.append(R.styleable.KeyTimeCycle_android_translationX, 15);
            f2127a.append(R.styleable.KeyTimeCycle_android_translationY, 16);
            f2127a.append(R.styleable.KeyTimeCycle_android_translationZ, 17);
            f2127a.append(R.styleable.KeyTimeCycle_motionProgress, 18);
            f2127a.append(R.styleable.KeyTimeCycle_wavePeriod, 20);
            f2127a.append(R.styleable.KeyTimeCycle_waveOffset, 21);
            f2127a.append(R.styleable.KeyTimeCycle_waveShape, 19);
        }

        private Loader() {
        }

        public static void read(KeyTimeCycle keyTimeCycle, TypedArray typedArray) {
            int indexCount = typedArray.getIndexCount();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= indexCount) {
                    return;
                }
                int index = typedArray.getIndex(i2);
                switch (f2127a.get(index)) {
                    case 1:
                        keyTimeCycle.h = typedArray.getFloat(index, keyTimeCycle.h);
                        break;
                    case 2:
                        keyTimeCycle.i = typedArray.getDimension(index, keyTimeCycle.i);
                        break;
                    case 3:
                    case 11:
                    default:
                        Log.e("KeyTimeCycle", "unused attribute 0x" + Integer.toHexString(index) + "   " + f2127a.get(index));
                        break;
                    case 4:
                        keyTimeCycle.j = typedArray.getFloat(index, keyTimeCycle.j);
                        break;
                    case 5:
                        keyTimeCycle.k = typedArray.getFloat(index, keyTimeCycle.k);
                        break;
                    case 6:
                        keyTimeCycle.l = typedArray.getFloat(index, keyTimeCycle.l);
                        break;
                    case 7:
                        keyTimeCycle.n = typedArray.getFloat(index, keyTimeCycle.n);
                        break;
                    case 8:
                        keyTimeCycle.m = typedArray.getFloat(index, keyTimeCycle.m);
                        break;
                    case 9:
                        keyTimeCycle.f = typedArray.getString(index);
                        break;
                    case 10:
                        if (!MotionLayout.IS_IN_EDIT_MODE) {
                            if (typedArray.peekValue(index).type != 3) {
                                keyTimeCycle.b = typedArray.getResourceId(index, keyTimeCycle.b);
                                break;
                            } else {
                                keyTimeCycle.f2122c = typedArray.getString(index);
                                break;
                            }
                        } else {
                            keyTimeCycle.b = typedArray.getResourceId(index, keyTimeCycle.b);
                            if (keyTimeCycle.b != -1) {
                                break;
                            } else {
                                keyTimeCycle.f2122c = typedArray.getString(index);
                                break;
                            }
                        }
                    case 12:
                        keyTimeCycle.f2121a = typedArray.getInt(index, keyTimeCycle.f2121a);
                        break;
                    case 13:
                        keyTimeCycle.g = typedArray.getInteger(index, keyTimeCycle.g);
                        break;
                    case 14:
                        keyTimeCycle.o = typedArray.getFloat(index, keyTimeCycle.o);
                        break;
                    case 15:
                        keyTimeCycle.p = typedArray.getDimension(index, keyTimeCycle.p);
                        break;
                    case 16:
                        keyTimeCycle.q = typedArray.getDimension(index, keyTimeCycle.q);
                        break;
                    case 17:
                        if (Build.VERSION.SDK_INT < 21) {
                            break;
                        } else {
                            keyTimeCycle.r = typedArray.getDimension(index, keyTimeCycle.r);
                            break;
                        }
                    case 18:
                        keyTimeCycle.s = typedArray.getFloat(index, keyTimeCycle.s);
                        break;
                    case 19:
                        if (typedArray.peekValue(index).type != 3) {
                            keyTimeCycle.t = typedArray.getInt(index, keyTimeCycle.t);
                            break;
                        } else {
                            keyTimeCycle.u = typedArray.getString(index);
                            keyTimeCycle.t = 7;
                            break;
                        }
                    case 20:
                        keyTimeCycle.v = typedArray.getFloat(index, keyTimeCycle.v);
                        break;
                    case 21:
                        if (typedArray.peekValue(index).type != 5) {
                            keyTimeCycle.w = typedArray.getFloat(index, keyTimeCycle.w);
                            break;
                        } else {
                            keyTimeCycle.w = typedArray.getDimension(index, keyTimeCycle.w);
                            break;
                        }
                }
                i = i2 + 1;
            }
        }
    }

    public KeyTimeCycle() {
        this.d = 3;
        this.e = new HashMap<>();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0132, code lost:
        if (r0.equals("scaleY") != false) goto L15;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void addTimeValues(java.util.HashMap<java.lang.String, androidx.constraintlayout.motion.utils.ViewTimeCycle> r8) {
        /*
            Method dump skipped, instructions count: 992
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.KeyTimeCycle.addTimeValues(java.util.HashMap):void");
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public void addValues(HashMap<String, ViewSpline> hashMap) {
        throw new IllegalArgumentException(" KeyTimeCycles do not support SplineSet");
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    /* renamed from: clone */
    public Key mo1228clone() {
        return new KeyTimeCycle().copy(this);
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public Key copy(Key key) {
        super.copy(key);
        KeyTimeCycle keyTimeCycle = (KeyTimeCycle) key;
        this.f = keyTimeCycle.f;
        this.g = keyTimeCycle.g;
        this.t = keyTimeCycle.t;
        this.v = keyTimeCycle.v;
        this.w = keyTimeCycle.w;
        this.s = keyTimeCycle.s;
        this.h = keyTimeCycle.h;
        this.i = keyTimeCycle.i;
        this.j = keyTimeCycle.j;
        this.m = keyTimeCycle.m;
        this.k = keyTimeCycle.k;
        this.l = keyTimeCycle.l;
        this.n = keyTimeCycle.n;
        this.o = keyTimeCycle.o;
        this.p = keyTimeCycle.p;
        this.q = keyTimeCycle.q;
        this.r = keyTimeCycle.r;
        return this;
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public void getAttributeNames(HashSet<String> hashSet) {
        if (!Float.isNaN(this.h)) {
            hashSet.add("alpha");
        }
        if (!Float.isNaN(this.i)) {
            hashSet.add("elevation");
        }
        if (!Float.isNaN(this.j)) {
            hashSet.add(Key.ROTATION);
        }
        if (!Float.isNaN(this.k)) {
            hashSet.add("rotationX");
        }
        if (!Float.isNaN(this.l)) {
            hashSet.add("rotationY");
        }
        if (!Float.isNaN(this.p)) {
            hashSet.add("translationX");
        }
        if (!Float.isNaN(this.q)) {
            hashSet.add("translationY");
        }
        if (!Float.isNaN(this.r)) {
            hashSet.add("translationZ");
        }
        if (!Float.isNaN(this.m)) {
            hashSet.add("transitionPathRotate");
        }
        if (!Float.isNaN(this.n)) {
            hashSet.add("scaleX");
        }
        if (!Float.isNaN(this.o)) {
            hashSet.add("scaleY");
        }
        if (!Float.isNaN(this.s)) {
            hashSet.add("progress");
        }
        if (this.e.size() > 0) {
            for (String str : this.e.keySet()) {
                hashSet.add("CUSTOM," + str);
            }
        }
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public void load(Context context, AttributeSet attributeSet) {
        Loader.read(this, context.obtainStyledAttributes(attributeSet, R.styleable.KeyTimeCycle));
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public void setInterpolation(HashMap<String, Integer> hashMap) {
        if (this.g == -1) {
            return;
        }
        if (!Float.isNaN(this.h)) {
            hashMap.put("alpha", Integer.valueOf(this.g));
        }
        if (!Float.isNaN(this.i)) {
            hashMap.put("elevation", Integer.valueOf(this.g));
        }
        if (!Float.isNaN(this.j)) {
            hashMap.put(Key.ROTATION, Integer.valueOf(this.g));
        }
        if (!Float.isNaN(this.k)) {
            hashMap.put("rotationX", Integer.valueOf(this.g));
        }
        if (!Float.isNaN(this.l)) {
            hashMap.put("rotationY", Integer.valueOf(this.g));
        }
        if (!Float.isNaN(this.p)) {
            hashMap.put("translationX", Integer.valueOf(this.g));
        }
        if (!Float.isNaN(this.q)) {
            hashMap.put("translationY", Integer.valueOf(this.g));
        }
        if (!Float.isNaN(this.r)) {
            hashMap.put("translationZ", Integer.valueOf(this.g));
        }
        if (!Float.isNaN(this.m)) {
            hashMap.put("transitionPathRotate", Integer.valueOf(this.g));
        }
        if (!Float.isNaN(this.n)) {
            hashMap.put("scaleX", Integer.valueOf(this.g));
        }
        if (!Float.isNaN(this.n)) {
            hashMap.put("scaleY", Integer.valueOf(this.g));
        }
        if (!Float.isNaN(this.s)) {
            hashMap.put("progress", Integer.valueOf(this.g));
        }
        if (this.e.size() > 0) {
            for (String str : this.e.keySet()) {
                hashMap.put("CUSTOM," + str, Integer.valueOf(this.g));
            }
        }
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
                if (str.equals(Key.ROTATION)) {
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
                this.h = a(obj);
                return;
            case true:
                this.g = b(obj);
                return;
            case true:
                this.i = a(obj);
                return;
            case true:
                this.s = a(obj);
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
                this.n = a(obj);
                return;
            case true:
                this.o = a(obj);
                return;
            case true:
                this.f = obj.toString();
                return;
            case true:
                this.m = a(obj);
                return;
            case true:
                this.p = a(obj);
                return;
            case true:
                this.q = a(obj);
                return;
            case true:
                this.r = a(obj);
                return;
            case true:
                this.v = a(obj);
                return;
            case true:
                this.w = a(obj);
                return;
            case true:
                if (obj instanceof Integer) {
                    this.t = b(obj);
                    return;
                }
                this.t = 7;
                this.u = obj.toString();
                return;
            default:
                return;
        }
    }
}
