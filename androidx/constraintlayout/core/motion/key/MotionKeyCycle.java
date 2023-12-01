package androidx.constraintlayout.core.motion.key;

import androidx.constraintlayout.core.motion.CustomVariable;
import androidx.constraintlayout.core.motion.utils.KeyCycleOscillator;
import androidx.constraintlayout.core.motion.utils.SplineSet;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.core.motion.utils.Utils;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.HashSet;

/* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/core/motion/key/MotionKeyCycle.class */
public class MotionKeyCycle extends MotionKey {
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

    /* renamed from: c  reason: collision with root package name */
    private String f1971c = null;
    private int d = 0;
    private int e = -1;
    private String f = null;
    private float g = Float.NaN;
    private float h = 0.0f;
    private float i = 0.0f;
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

    public MotionKeyCycle() {
        this.mType = 4;
        this.mCustom = new HashMap<>();
    }

    public void addCycleValues(HashMap<String, KeyCycleOscillator> hashMap) {
        KeyCycleOscillator keyCycleOscillator;
        KeyCycleOscillator keyCycleOscillator2;
        for (String str : hashMap.keySet()) {
            if (str.startsWith("CUSTOM")) {
                CustomVariable customVariable = this.mCustom.get(str.substring(7));
                if (customVariable != null && customVariable.getType() == 901 && (keyCycleOscillator = hashMap.get(str)) != null) {
                    keyCycleOscillator.setPoint(this.mFramePosition, this.e, this.f, -1, this.g, this.h, this.i, customVariable.getValueToInterpolate(), customVariable);
                }
            } else {
                float value = getValue(str);
                if (!Float.isNaN(value) && (keyCycleOscillator2 = hashMap.get(str)) != null) {
                    keyCycleOscillator2.setPoint(this.mFramePosition, this.e, this.f, -1, this.g, this.h, this.i, value);
                }
            }
        }
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey
    public void addValues(HashMap<String, SplineSet> hashMap) {
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey
    /* renamed from: clone */
    public MotionKey mo1156clone() {
        return null;
    }

    public void dump() {
        PrintStream printStream = System.out;
        printStream.println("MotionKeyCycle{mWaveShape=" + this.e + ", mWavePeriod=" + this.g + ", mWaveOffset=" + this.h + ", mWavePhase=" + this.i + ", mRotation=" + this.m + '}');
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey
    public void getAttributeNames(HashSet<String> hashSet) {
        if (!Float.isNaN(this.k)) {
            hashSet.add("alpha");
        }
        if (!Float.isNaN(this.l)) {
            hashSet.add("elevation");
        }
        if (!Float.isNaN(this.m)) {
            hashSet.add("rotationZ");
        }
        if (!Float.isNaN(this.o)) {
            hashSet.add("rotationX");
        }
        if (!Float.isNaN(this.p)) {
            hashSet.add("rotationY");
        }
        if (!Float.isNaN(this.q)) {
            hashSet.add("scaleX");
        }
        if (!Float.isNaN(this.r)) {
            hashSet.add("scaleY");
        }
        if (!Float.isNaN(this.n)) {
            hashSet.add("pathRotate");
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
        if (this.mCustom.size() > 0) {
            for (String str : this.mCustom.keySet()) {
                hashSet.add("CUSTOM," + str);
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // androidx.constraintlayout.core.motion.utils.TypedValues
    public int getId(String str) {
        boolean z;
        switch (str.hashCode()) {
            case -1581616630:
                if (str.equals(TypedValues.CycleType.S_CUSTOM_WAVE_SHAPE)) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case -1310311125:
                if (str.equals("easing")) {
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
            case -1249320804:
                if (str.equals("rotationZ")) {
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
            case -1019779949:
                if (str.equals("offset")) {
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
            case -991726143:
                if (str.equals("period")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case -987906986:
                if (str.equals("pivotX")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case -987906985:
                if (str.equals("pivotY")) {
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
            case 92909918:
                if (str.equals("alpha")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case 106629499:
                if (str.equals(TypedValues.CycleType.S_WAVE_PHASE)) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case 579057826:
                if (str.equals("curveFit")) {
                    z = false;
                    break;
                }
                z = true;
                break;
            case 803192288:
                if (str.equals("pathRotate")) {
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
                return 401;
            case true:
                return 402;
            case true:
                return 403;
            case true:
                return 304;
            case true:
                return 305;
            case true:
                return 306;
            case true:
                return 308;
            case true:
                return 309;
            case true:
                return 310;
            case true:
                return 311;
            case true:
                return 312;
            case true:
                return 313;
            case true:
                return 314;
            case true:
                return 315;
            case true:
                return 416;
            case true:
                return 420;
            case true:
                return 423;
            case true:
                return 421;
            case true:
                return 425;
            case true:
                return 424;
            case true:
                return 422;
            default:
                return -1;
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
            case -1249320804:
                if (str.equals("rotationZ")) {
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
            case -1019779949:
                if (str.equals("offset")) {
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
            case -4379043:
                if (str.equals("elevation")) {
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
            case 106629499:
                if (str.equals(TypedValues.CycleType.S_WAVE_PHASE)) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case 803192288:
                if (str.equals("pathRotate")) {
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
                return this.k;
            case true:
                return this.l;
            case true:
                return this.m;
            case true:
                return this.o;
            case true:
                return this.p;
            case true:
                return this.n;
            case true:
                return this.q;
            case true:
                return this.r;
            case true:
                return this.s;
            case true:
                return this.t;
            case true:
                return this.u;
            case true:
                return this.h;
            case true:
                return this.i;
            case true:
                return this.j;
            default:
                return Float.NaN;
        }
    }

    public void printAttributes() {
        HashSet<String> hashSet = new HashSet<>();
        getAttributeNames(hashSet);
        Utils.log(" ------------- " + this.mFramePosition + " -------------");
        Utils.log("MotionKeyCycle{Shape=" + this.e + ", Period=" + this.g + ", Offset=" + this.h + ", Phase=" + this.i + '}');
        String[] strArr = (String[]) hashSet.toArray(new String[0]);
        for (int i = 0; i < strArr.length; i++) {
            TypedValues.AttributesType.CC.getId(strArr[i]);
            Utils.log(strArr[i] + ":" + getValue(strArr[i]));
        }
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey, androidx.constraintlayout.core.motion.utils.TypedValues
    public boolean setValue(int i, float f) {
        if (i == 315) {
            this.j = f;
            return true;
        } else if (i == 403) {
            this.k = f;
            return true;
        } else if (i == 416) {
            this.n = f;
            return true;
        } else {
            switch (i) {
                case 304:
                    this.s = f;
                    return true;
                case 305:
                    this.t = f;
                    return true;
                case 306:
                    this.u = f;
                    return true;
                case 307:
                    this.l = f;
                    return true;
                case 308:
                    this.o = f;
                    return true;
                case 309:
                    this.p = f;
                    return true;
                case 310:
                    this.m = f;
                    return true;
                case 311:
                    this.q = f;
                    return true;
                case 312:
                    this.r = f;
                    return true;
                default:
                    switch (i) {
                        case 423:
                            this.g = f;
                            return true;
                        case 424:
                            this.h = f;
                            return true;
                        case 425:
                            this.i = f;
                            return true;
                        default:
                            return super.setValue(i, f);
                    }
            }
        }
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey, androidx.constraintlayout.core.motion.utils.TypedValues
    public boolean setValue(int i, int i2) {
        if (i == 401) {
            this.d = i2;
            return true;
        } else if (i == 421) {
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
        if (i == 420) {
            this.f1971c = str;
            return true;
        } else if (i != 422) {
            return super.setValue(i, str);
        } else {
            this.f = str;
            return true;
        }
    }
}
