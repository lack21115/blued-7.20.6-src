package androidx.constraintlayout.core.motion.key;

import androidx.constraintlayout.core.motion.MotionWidget;
import androidx.constraintlayout.core.motion.utils.FloatRect;
import androidx.constraintlayout.core.motion.utils.SplineSet;
import java.util.HashMap;
import java.util.HashSet;

/* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/core/motion/key/MotionKeyTrigger.class */
public class MotionKeyTrigger extends MotionKey {
    public static final String CROSS = "CROSS";
    public static final int KEY_TYPE = 5;
    public static final String NEGATIVE_CROSS = "negativeCross";
    public static final String POSITIVE_CROSS = "positiveCross";
    public static final String POST_LAYOUT = "postLayout";
    public static final String TRIGGER_COLLISION_ID = "triggerCollisionId";
    public static final String TRIGGER_COLLISION_VIEW = "triggerCollisionView";
    public static final String TRIGGER_ID = "triggerID";
    public static final String TRIGGER_RECEIVER = "triggerReceiver";
    public static final String TRIGGER_SLACK = "triggerSlack";
    public static final int TYPE_CROSS = 312;
    public static final int TYPE_NEGATIVE_CROSS = 310;
    public static final int TYPE_POSITIVE_CROSS = 309;
    public static final int TYPE_POST_LAYOUT = 304;
    public static final int TYPE_TRIGGER_COLLISION_ID = 307;
    public static final int TYPE_TRIGGER_COLLISION_VIEW = 306;
    public static final int TYPE_TRIGGER_ID = 308;
    public static final int TYPE_TRIGGER_RECEIVER = 311;
    public static final int TYPE_TRIGGER_SLACK = 305;
    public static final int TYPE_VIEW_TRANSITION_ON_CROSS = 301;
    public static final int TYPE_VIEW_TRANSITION_ON_NEGATIVE_CROSS = 303;
    public static final int TYPE_VIEW_TRANSITION_ON_POSITIVE_CROSS = 302;
    public static final String VIEW_TRANSITION_ON_CROSS = "viewTransitionOnCross";
    public static final String VIEW_TRANSITION_ON_NEGATIVE_CROSS = "viewTransitionOnNegativeCross";
    public static final String VIEW_TRANSITION_ON_POSITIVE_CROSS = "viewTransitionOnPositiveCross";
    private float t;
    private int i = -1;
    private String j = null;
    private int k = UNSET;
    private String l = null;
    private String m = null;
    private int n = UNSET;
    private int o = UNSET;

    /* renamed from: c  reason: collision with root package name */
    float f2022c = 0.1f;
    private boolean p = true;
    private boolean q = true;
    private boolean r = true;
    private float s = Float.NaN;
    private boolean u = false;
    int d = UNSET;
    int e = UNSET;
    int f = UNSET;
    FloatRect g = new FloatRect();
    FloatRect h = new FloatRect();

    public MotionKeyTrigger() {
        this.mType = 5;
        this.mCustom = new HashMap<>();
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey
    public void addValues(HashMap<String, SplineSet> hashMap) {
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey
    /* renamed from: clone */
    public MotionKey mo1293clone() {
        return new MotionKeyTrigger().copy((MotionKey) this);
    }

    public void conditionallyFire(float f, MotionWidget motionWidget) {
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey
    public MotionKeyTrigger copy(MotionKey motionKey) {
        super.copy(motionKey);
        MotionKeyTrigger motionKeyTrigger = (MotionKeyTrigger) motionKey;
        this.i = motionKeyTrigger.i;
        this.j = motionKeyTrigger.j;
        this.k = motionKeyTrigger.k;
        this.l = motionKeyTrigger.l;
        this.m = motionKeyTrigger.m;
        this.n = motionKeyTrigger.n;
        this.o = motionKeyTrigger.o;
        this.f2022c = motionKeyTrigger.f2022c;
        this.p = motionKeyTrigger.p;
        this.q = motionKeyTrigger.q;
        this.r = motionKeyTrigger.r;
        this.s = motionKeyTrigger.s;
        this.t = motionKeyTrigger.t;
        this.u = motionKeyTrigger.u;
        this.g = motionKeyTrigger.g;
        this.h = motionKeyTrigger.h;
        return this;
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey
    public void getAttributeNames(HashSet<String> hashSet) {
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // androidx.constraintlayout.core.motion.utils.TypedValues
    public int getId(String str) {
        boolean z;
        switch (str.hashCode()) {
            case -1594793529:
                if (str.equals("positiveCross")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case -966421266:
                if (str.equals("viewTransitionOnPositiveCross")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case -786670827:
                if (str.equals("triggerCollisionId")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case -648752941:
                if (str.equals("triggerID")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case -638126837:
                if (str.equals("negativeCross")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case -76025313:
                if (str.equals("triggerCollisionView")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case -9754574:
                if (str.equals("viewTransitionOnNegativeCross")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case 364489912:
                if (str.equals("triggerSlack")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case 1301930599:
                if (str.equals("viewTransitionOnCross")) {
                    z = false;
                    break;
                }
                z = true;
                break;
            case 1401391082:
                if (str.equals("postLayout")) {
                    z = true;
                    break;
                }
                z = true;
                break;
            case 1535404999:
                if (str.equals("triggerReceiver")) {
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
                return 301;
            case true:
                return 302;
            case true:
                return 303;
            case true:
                return 304;
            case true:
                return 305;
            case true:
                return 306;
            case true:
                return 307;
            case true:
                return 308;
            case true:
                return 309;
            case true:
                return 310;
            case true:
                return 311;
            default:
                return -1;
        }
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey, androidx.constraintlayout.core.motion.utils.TypedValues
    public boolean setValue(int i, float f) {
        if (i != 305) {
            return super.setValue(i, f);
        }
        this.f2022c = f;
        return true;
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey, androidx.constraintlayout.core.motion.utils.TypedValues
    public boolean setValue(int i, int i2) {
        if (i == 307) {
            this.o = i2;
            return true;
        } else if (i == 308) {
            this.n = b(Integer.valueOf(i2));
            return true;
        } else if (i == 311) {
            this.k = i2;
            return true;
        } else {
            switch (i) {
                case 301:
                    this.f = i2;
                    return true;
                case 302:
                    this.e = i2;
                    return true;
                case 303:
                    this.d = i2;
                    return true;
                default:
                    return super.setValue(i, i2);
            }
        }
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey, androidx.constraintlayout.core.motion.utils.TypedValues
    public boolean setValue(int i, String str) {
        if (i == 309) {
            this.m = str;
            return true;
        } else if (i == 310) {
            this.l = str;
            return true;
        } else if (i != 312) {
            return super.setValue(i, str);
        } else {
            this.j = str;
            return true;
        }
    }

    @Override // androidx.constraintlayout.core.motion.key.MotionKey, androidx.constraintlayout.core.motion.utils.TypedValues
    public boolean setValue(int i, boolean z) {
        if (i != 304) {
            return super.setValue(i, z);
        }
        this.u = z;
        return true;
    }
}
