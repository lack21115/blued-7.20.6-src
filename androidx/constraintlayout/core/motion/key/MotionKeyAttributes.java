package androidx.constraintlayout.core.motion.key;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.HashSet;

/* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/core/motion/key/MotionKeyAttributes.class */
public class MotionKeyAttributes extends MotionKey {
    public static final int KEY_TYPE = 1;

    /* renamed from: c  reason: collision with root package name */
    private String f2018c;
    private int d = -1;
    private int e = 0;
    private float f = Float.NaN;
    private float g = Float.NaN;
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

    public MotionKeyAttributes() {
        this.mType = 1;
        this.mCustom = new HashMap<>();
    }

    private float a(int i) {
        if (i != 100) {
            switch (i) {
                case 303:
                    return this.f;
                case 304:
                    return this.p;
                case 305:
                    return this.q;
                case 306:
                    return this.r;
                case 307:
                    return this.g;
                case 308:
                    return this.i;
                case 309:
                    return this.j;
                case 310:
                    return this.h;
                case 311:
                    return this.n;
                case 312:
                    return this.o;
                case 313:
                    return this.k;
                case 314:
                    return this.l;
                case 315:
                    return this.s;
                case 316:
                    return this.m;
                default:
                    return Float.NaN;
            }
        }
        return this.mFramePosition;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x00fa, code lost:
        if (r0.equals("pathRotate") != false) goto L14;
     */
    @Override // androidx.constraintlayout.core.motion.key.MotionKey
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void addValues(java.util.HashMap<java.lang.String, androidx.constraintlayout.core.motion.utils.SplineSet> r5) {
        /*
            Method dump skipped, instructions count: 940
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.motion.key.MotionKeyAttributes.addValues(java.util.HashMap):void");
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey
    /* renamed from: clone */
    public MotionKey mo1293clone() {
        return null;
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey
    public void getAttributeNames(HashSet<String> hashSet) {
        if (!Float.isNaN(this.f)) {
            hashSet.add("alpha");
        }
        if (!Float.isNaN(this.g)) {
            hashSet.add("elevation");
        }
        if (!Float.isNaN(this.h)) {
            hashSet.add("rotationZ");
        }
        if (!Float.isNaN(this.i)) {
            hashSet.add("rotationX");
        }
        if (!Float.isNaN(this.j)) {
            hashSet.add("rotationY");
        }
        if (!Float.isNaN(this.k)) {
            hashSet.add("pivotX");
        }
        if (!Float.isNaN(this.l)) {
            hashSet.add("pivotY");
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
            hashSet.add("pathRotate");
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
        if (this.mCustom.size() > 0) {
            for (String str : this.mCustom.keySet()) {
                hashSet.add("CUSTOM," + str);
            }
        }
    }

    public int getCurveFit() {
        return this.d;
    }

    @Override // androidx.constraintlayout.core.motion.utils.TypedValues
    public int getId(String str) {
        return TypedValues.AttributesType.CC.getId(str);
    }

    public void printAttributes() {
        HashSet<String> hashSet = new HashSet<>();
        getAttributeNames(hashSet);
        PrintStream printStream = System.out;
        printStream.println(" ------------- " + this.mFramePosition + " -------------");
        String[] strArr = (String[]) hashSet.toArray(new String[0]);
        for (int i = 0; i < strArr.length; i++) {
            int id = TypedValues.AttributesType.CC.getId(strArr[i]);
            PrintStream printStream2 = System.out;
            printStream2.println(strArr[i] + ":" + a(id));
        }
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey
    public void setInterpolation(HashMap<String, Integer> hashMap) {
        if (!Float.isNaN(this.f)) {
            hashMap.put("alpha", Integer.valueOf(this.d));
        }
        if (!Float.isNaN(this.g)) {
            hashMap.put("elevation", Integer.valueOf(this.d));
        }
        if (!Float.isNaN(this.h)) {
            hashMap.put("rotationZ", Integer.valueOf(this.d));
        }
        if (!Float.isNaN(this.i)) {
            hashMap.put("rotationX", Integer.valueOf(this.d));
        }
        if (!Float.isNaN(this.j)) {
            hashMap.put("rotationY", Integer.valueOf(this.d));
        }
        if (!Float.isNaN(this.k)) {
            hashMap.put("pivotX", Integer.valueOf(this.d));
        }
        if (!Float.isNaN(this.l)) {
            hashMap.put("pivotY", Integer.valueOf(this.d));
        }
        if (!Float.isNaN(this.p)) {
            hashMap.put("translationX", Integer.valueOf(this.d));
        }
        if (!Float.isNaN(this.q)) {
            hashMap.put("translationY", Integer.valueOf(this.d));
        }
        if (!Float.isNaN(this.r)) {
            hashMap.put("translationZ", Integer.valueOf(this.d));
        }
        if (!Float.isNaN(this.m)) {
            hashMap.put("pathRotate", Integer.valueOf(this.d));
        }
        if (!Float.isNaN(this.n)) {
            hashMap.put("scaleX", Integer.valueOf(this.d));
        }
        if (!Float.isNaN(this.o)) {
            hashMap.put("scaleY", Integer.valueOf(this.d));
        }
        if (!Float.isNaN(this.s)) {
            hashMap.put("progress", Integer.valueOf(this.d));
        }
        if (this.mCustom.size() > 0) {
            for (String str : this.mCustom.keySet()) {
                hashMap.put("CUSTOM," + str, Integer.valueOf(this.d));
            }
        }
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey, androidx.constraintlayout.core.motion.utils.TypedValues
    public boolean setValue(int i, float f) {
        if (i == 100) {
            this.m = f;
            return true;
        }
        switch (i) {
            case 303:
                this.f = f;
                return true;
            case 304:
                this.p = f;
                return true;
            case 305:
                this.q = f;
                return true;
            case 306:
                this.r = f;
                return true;
            case 307:
                this.g = f;
                return true;
            case 308:
                this.i = f;
                return true;
            case 309:
                this.j = f;
                return true;
            case 310:
                this.h = f;
                return true;
            case 311:
                this.n = f;
                return true;
            case 312:
                this.o = f;
                return true;
            case 313:
                this.k = f;
                return true;
            case 314:
                this.l = f;
                return true;
            case 315:
                this.s = f;
                return true;
            case 316:
                this.m = f;
                return true;
            default:
                return super.setValue(i, f);
        }
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey, androidx.constraintlayout.core.motion.utils.TypedValues
    public boolean setValue(int i, int i2) {
        if (i == 100) {
            this.mFramePosition = i2;
            return true;
        } else if (i == 301) {
            this.d = i2;
            return true;
        } else if (i == 302) {
            this.e = i2;
            return true;
        } else if (setValue(i, i2)) {
            return true;
        } else {
            return super.setValue(i, i2);
        }
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey, androidx.constraintlayout.core.motion.utils.TypedValues
    public boolean setValue(int i, String str) {
        if (i == 101) {
            this.b = str;
            return true;
        } else if (i != 317) {
            return super.setValue(i, str);
        } else {
            this.f2018c = str;
            return true;
        }
    }
}
