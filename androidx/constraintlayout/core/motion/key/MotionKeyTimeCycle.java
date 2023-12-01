package androidx.constraintlayout.core.motion.key;

import androidx.constraintlayout.core.motion.utils.SplineSet;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.util.HashMap;
import java.util.HashSet;

/* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/core/motion/key/MotionKeyTimeCycle.class */
public class MotionKeyTimeCycle extends MotionKey {
    public static final int KEY_TYPE = 3;

    /* renamed from: c  reason: collision with root package name */
    private String f2021c;
    private int d = -1;
    private float e = Float.NaN;
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
    private int q = 0;
    private String r = null;
    private float s = Float.NaN;
    private float t = 0.0f;

    public MotionKeyTimeCycle() {
        this.mType = 3;
        this.mCustom = new HashMap<>();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0173, code lost:
        if (r0.equals("translationX") != false) goto L15;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void addTimeValues(java.util.HashMap<java.lang.String, androidx.constraintlayout.core.motion.utils.TimeCycleSplineSet> r8) {
        /*
            Method dump skipped, instructions count: 991
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.motion.key.MotionKeyTimeCycle.addTimeValues(java.util.HashMap):void");
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey
    public void addValues(HashMap<String, SplineSet> hashMap) {
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey
    /* renamed from: clone */
    public MotionKey mo1293clone() {
        return new MotionKeyTimeCycle().copy((MotionKey) this);
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey
    public MotionKeyTimeCycle copy(MotionKey motionKey) {
        super.copy(motionKey);
        MotionKeyTimeCycle motionKeyTimeCycle = (MotionKeyTimeCycle) motionKey;
        this.f2021c = motionKeyTimeCycle.f2021c;
        this.d = motionKeyTimeCycle.d;
        this.q = motionKeyTimeCycle.q;
        this.s = motionKeyTimeCycle.s;
        this.t = motionKeyTimeCycle.t;
        this.p = motionKeyTimeCycle.p;
        this.e = motionKeyTimeCycle.e;
        this.f = motionKeyTimeCycle.f;
        this.g = motionKeyTimeCycle.g;
        this.j = motionKeyTimeCycle.j;
        this.h = motionKeyTimeCycle.h;
        this.i = motionKeyTimeCycle.i;
        this.k = motionKeyTimeCycle.k;
        this.l = motionKeyTimeCycle.l;
        this.m = motionKeyTimeCycle.m;
        this.n = motionKeyTimeCycle.n;
        this.o = motionKeyTimeCycle.o;
        return this;
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey
    public void getAttributeNames(HashSet<String> hashSet) {
        if (!Float.isNaN(this.e)) {
            hashSet.add("alpha");
        }
        if (!Float.isNaN(this.f)) {
            hashSet.add("elevation");
        }
        if (!Float.isNaN(this.g)) {
            hashSet.add("rotationZ");
        }
        if (!Float.isNaN(this.h)) {
            hashSet.add("rotationX");
        }
        if (!Float.isNaN(this.i)) {
            hashSet.add("rotationY");
        }
        if (!Float.isNaN(this.k)) {
            hashSet.add("scaleX");
        }
        if (!Float.isNaN(this.l)) {
            hashSet.add("scaleY");
        }
        if (!Float.isNaN(this.j)) {
            hashSet.add("pathRotate");
        }
        if (!Float.isNaN(this.m)) {
            hashSet.add("translationX");
        }
        if (!Float.isNaN(this.n)) {
            hashSet.add("translationY");
        }
        if (!Float.isNaN(this.o)) {
            hashSet.add("translationZ");
        }
        if (this.mCustom.size() > 0) {
            for (String str : this.mCustom.keySet()) {
                hashSet.add("CUSTOM," + str);
            }
        }
    }

    @Override // androidx.constraintlayout.core.motion.utils.TypedValues
    public int getId(String str) {
        return TypedValues.CycleType.CC.getId(str);
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey, androidx.constraintlayout.core.motion.utils.TypedValues
    public boolean setValue(int i, float f) {
        if (i == 315) {
            this.p = a(Float.valueOf(f));
            return true;
        } else if (i == 401) {
            this.d = b(Float.valueOf(f));
            return true;
        } else if (i == 403) {
            this.e = f;
            return true;
        } else if (i == 416) {
            this.j = a(Float.valueOf(f));
            return true;
        } else if (i == 423) {
            this.s = a(Float.valueOf(f));
            return true;
        } else if (i == 424) {
            this.t = a(Float.valueOf(f));
            return true;
        } else {
            switch (i) {
                case 304:
                    this.m = a(Float.valueOf(f));
                    return true;
                case 305:
                    this.n = a(Float.valueOf(f));
                    return true;
                case 306:
                    this.o = a(Float.valueOf(f));
                    return true;
                case 307:
                    this.f = a(Float.valueOf(f));
                    return true;
                case 308:
                    this.h = a(Float.valueOf(f));
                    return true;
                case 309:
                    this.i = a(Float.valueOf(f));
                    return true;
                case 310:
                    this.g = a(Float.valueOf(f));
                    return true;
                case 311:
                    this.k = a(Float.valueOf(f));
                    return true;
                case 312:
                    this.l = a(Float.valueOf(f));
                    return true;
                default:
                    return super.setValue(i, f);
            }
        }
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey, androidx.constraintlayout.core.motion.utils.TypedValues
    public boolean setValue(int i, int i2) {
        if (i == 100) {
            this.mFramePosition = i2;
            return true;
        } else if (i != 421) {
            return super.setValue(i, i2);
        } else {
            this.q = i2;
            return true;
        }
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey, androidx.constraintlayout.core.motion.utils.TypedValues
    public boolean setValue(int i, String str) {
        if (i == 420) {
            this.f2021c = str;
            return true;
        } else if (i != 421) {
            return super.setValue(i, str);
        } else {
            this.q = 7;
            this.r = str;
            return true;
        }
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey, androidx.constraintlayout.core.motion.utils.TypedValues
    public boolean setValue(int i, boolean z) {
        return super.setValue(i, z);
    }
}
