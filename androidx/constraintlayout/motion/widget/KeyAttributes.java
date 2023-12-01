package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import androidx.constraintlayout.widget.R;
import java.util.HashMap;
import java.util.HashSet;

/* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/motion/widget/KeyAttributes.class */
public class KeyAttributes extends Key {
    public static final int KEY_TYPE = 1;
    private String f;
    private int g = -1;
    private boolean h = false;
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
    private float t = Float.NaN;
    private float u = Float.NaN;
    private float v = Float.NaN;

    /* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/motion/widget/KeyAttributes$Loader.class */
    static class Loader {

        /* renamed from: a  reason: collision with root package name */
        private static SparseIntArray f2171a;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            f2171a = sparseIntArray;
            sparseIntArray.append(R.styleable.KeyAttribute_android_alpha, 1);
            f2171a.append(R.styleable.KeyAttribute_android_elevation, 2);
            f2171a.append(R.styleable.KeyAttribute_android_rotation, 4);
            f2171a.append(R.styleable.KeyAttribute_android_rotationX, 5);
            f2171a.append(R.styleable.KeyAttribute_android_rotationY, 6);
            f2171a.append(R.styleable.KeyAttribute_android_transformPivotX, 19);
            f2171a.append(R.styleable.KeyAttribute_android_transformPivotY, 20);
            f2171a.append(R.styleable.KeyAttribute_android_scaleX, 7);
            f2171a.append(R.styleable.KeyAttribute_transitionPathRotate, 8);
            f2171a.append(R.styleable.KeyAttribute_transitionEasing, 9);
            f2171a.append(R.styleable.KeyAttribute_motionTarget, 10);
            f2171a.append(R.styleable.KeyAttribute_framePosition, 12);
            f2171a.append(R.styleable.KeyAttribute_curveFit, 13);
            f2171a.append(R.styleable.KeyAttribute_android_scaleY, 14);
            f2171a.append(R.styleable.KeyAttribute_android_translationX, 15);
            f2171a.append(R.styleable.KeyAttribute_android_translationY, 16);
            f2171a.append(R.styleable.KeyAttribute_android_translationZ, 17);
            f2171a.append(R.styleable.KeyAttribute_motionProgress, 18);
        }

        private Loader() {
        }

        public static void read(KeyAttributes keyAttributes, TypedArray typedArray) {
            int indexCount = typedArray.getIndexCount();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= indexCount) {
                    return;
                }
                int index = typedArray.getIndex(i2);
                switch (f2171a.get(index)) {
                    case 1:
                        keyAttributes.i = typedArray.getFloat(index, keyAttributes.i);
                        break;
                    case 2:
                        keyAttributes.j = typedArray.getDimension(index, keyAttributes.j);
                        break;
                    case 3:
                    case 11:
                    default:
                        Log.e("KeyAttribute", "unused attribute 0x" + Integer.toHexString(index) + "   " + f2171a.get(index));
                        break;
                    case 4:
                        keyAttributes.k = typedArray.getFloat(index, keyAttributes.k);
                        break;
                    case 5:
                        keyAttributes.l = typedArray.getFloat(index, keyAttributes.l);
                        break;
                    case 6:
                        keyAttributes.m = typedArray.getFloat(index, keyAttributes.m);
                        break;
                    case 7:
                        keyAttributes.q = typedArray.getFloat(index, keyAttributes.q);
                        break;
                    case 8:
                        keyAttributes.p = typedArray.getFloat(index, keyAttributes.p);
                        break;
                    case 9:
                        keyAttributes.f = typedArray.getString(index);
                        break;
                    case 10:
                        if (!MotionLayout.IS_IN_EDIT_MODE) {
                            if (typedArray.peekValue(index).type != 3) {
                                keyAttributes.b = typedArray.getResourceId(index, keyAttributes.b);
                                break;
                            } else {
                                keyAttributes.f2170c = typedArray.getString(index);
                                break;
                            }
                        } else {
                            keyAttributes.b = typedArray.getResourceId(index, keyAttributes.b);
                            if (keyAttributes.b != -1) {
                                break;
                            } else {
                                keyAttributes.f2170c = typedArray.getString(index);
                                break;
                            }
                        }
                    case 12:
                        keyAttributes.f2169a = typedArray.getInt(index, keyAttributes.f2169a);
                        break;
                    case 13:
                        keyAttributes.g = typedArray.getInteger(index, keyAttributes.g);
                        break;
                    case 14:
                        keyAttributes.r = typedArray.getFloat(index, keyAttributes.r);
                        break;
                    case 15:
                        keyAttributes.s = typedArray.getDimension(index, keyAttributes.s);
                        break;
                    case 16:
                        keyAttributes.t = typedArray.getDimension(index, keyAttributes.t);
                        break;
                    case 17:
                        if (Build.VERSION.SDK_INT < 21) {
                            break;
                        } else {
                            keyAttributes.u = typedArray.getDimension(index, keyAttributes.u);
                            break;
                        }
                    case 18:
                        keyAttributes.v = typedArray.getFloat(index, keyAttributes.v);
                        break;
                    case 19:
                        keyAttributes.n = typedArray.getDimension(index, keyAttributes.n);
                        break;
                    case 20:
                        keyAttributes.o = typedArray.getDimension(index, keyAttributes.o);
                        break;
                }
                i = i2 + 1;
            }
        }
    }

    public KeyAttributes() {
        this.d = 1;
        this.e = new HashMap<>();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0109, code lost:
        if (r0.equals("transitionPathRotate") != false) goto L15;
     */
    @Override // androidx.constraintlayout.motion.widget.Key
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void addValues(java.util.HashMap<java.lang.String, androidx.constraintlayout.motion.utils.ViewSpline> r5) {
        /*
            Method dump skipped, instructions count: 900
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.KeyAttributes.addValues(java.util.HashMap):void");
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    /* renamed from: clone */
    public Key mo1365clone() {
        return new KeyAttributes().copy(this);
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public Key copy(Key key) {
        super.copy(key);
        KeyAttributes keyAttributes = (KeyAttributes) key;
        this.g = keyAttributes.g;
        this.h = keyAttributes.h;
        this.i = keyAttributes.i;
        this.j = keyAttributes.j;
        this.k = keyAttributes.k;
        this.l = keyAttributes.l;
        this.m = keyAttributes.m;
        this.n = keyAttributes.n;
        this.o = keyAttributes.o;
        this.p = keyAttributes.p;
        this.q = keyAttributes.q;
        this.r = keyAttributes.r;
        this.s = keyAttributes.s;
        this.t = keyAttributes.t;
        this.u = keyAttributes.u;
        this.v = keyAttributes.v;
        return this;
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public void getAttributeNames(HashSet<String> hashSet) {
        if (!Float.isNaN(this.i)) {
            hashSet.add("alpha");
        }
        if (!Float.isNaN(this.j)) {
            hashSet.add("elevation");
        }
        if (!Float.isNaN(this.k)) {
            hashSet.add("rotation");
        }
        if (!Float.isNaN(this.l)) {
            hashSet.add("rotationX");
        }
        if (!Float.isNaN(this.m)) {
            hashSet.add("rotationY");
        }
        if (!Float.isNaN(this.n)) {
            hashSet.add(Key.PIVOT_X);
        }
        if (!Float.isNaN(this.o)) {
            hashSet.add(Key.PIVOT_Y);
        }
        if (!Float.isNaN(this.s)) {
            hashSet.add("translationX");
        }
        if (!Float.isNaN(this.t)) {
            hashSet.add("translationY");
        }
        if (!Float.isNaN(this.u)) {
            hashSet.add("translationZ");
        }
        if (!Float.isNaN(this.p)) {
            hashSet.add("transitionPathRotate");
        }
        if (!Float.isNaN(this.q)) {
            hashSet.add("scaleX");
        }
        if (!Float.isNaN(this.r)) {
            hashSet.add("scaleY");
        }
        if (!Float.isNaN(this.v)) {
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
        Loader.read(this, context.obtainStyledAttributes(attributeSet, R.styleable.KeyAttribute));
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public void setInterpolation(HashMap<String, Integer> hashMap) {
        if (this.g == -1) {
            return;
        }
        if (!Float.isNaN(this.i)) {
            hashMap.put("alpha", Integer.valueOf(this.g));
        }
        if (!Float.isNaN(this.j)) {
            hashMap.put("elevation", Integer.valueOf(this.g));
        }
        if (!Float.isNaN(this.k)) {
            hashMap.put("rotation", Integer.valueOf(this.g));
        }
        if (!Float.isNaN(this.l)) {
            hashMap.put("rotationX", Integer.valueOf(this.g));
        }
        if (!Float.isNaN(this.m)) {
            hashMap.put("rotationY", Integer.valueOf(this.g));
        }
        if (!Float.isNaN(this.n)) {
            hashMap.put(Key.PIVOT_X, Integer.valueOf(this.g));
        }
        if (!Float.isNaN(this.o)) {
            hashMap.put(Key.PIVOT_Y, Integer.valueOf(this.g));
        }
        if (!Float.isNaN(this.s)) {
            hashMap.put("translationX", Integer.valueOf(this.g));
        }
        if (!Float.isNaN(this.t)) {
            hashMap.put("translationY", Integer.valueOf(this.g));
        }
        if (!Float.isNaN(this.u)) {
            hashMap.put("translationZ", Integer.valueOf(this.g));
        }
        if (!Float.isNaN(this.p)) {
            hashMap.put("transitionPathRotate", Integer.valueOf(this.g));
        }
        if (!Float.isNaN(this.q)) {
            hashMap.put("scaleX", Integer.valueOf(this.g));
        }
        if (!Float.isNaN(this.r)) {
            hashMap.put("scaleY", Integer.valueOf(this.g));
        }
        if (!Float.isNaN(this.v)) {
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
            case -760884510:
                if (str.equals(Key.PIVOT_X)) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case -760884509:
                if (str.equals(Key.PIVOT_Y)) {
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
            case 579057826:
                if (str.equals("curveFit")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case 1941332754:
                if (str.equals("visibility")) {
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
                this.i = a(obj);
                return;
            case true:
                this.g = b(obj);
                return;
            case true:
                this.j = a(obj);
                return;
            case true:
                this.v = a(obj);
                return;
            case true:
                this.k = a(obj);
                return;
            case true:
                this.l = a(obj);
                return;
            case true:
                this.m = a(obj);
                return;
            case true:
                this.n = a(obj);
                return;
            case true:
                this.o = a(obj);
                return;
            case true:
                this.q = a(obj);
                return;
            case true:
                this.r = a(obj);
                return;
            case true:
                this.f = obj.toString();
                return;
            case true:
                this.h = c(obj);
                return;
            case true:
                this.p = a(obj);
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
            default:
                return;
        }
    }
}
