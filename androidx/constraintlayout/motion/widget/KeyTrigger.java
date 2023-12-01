package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.View;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.motion.utils.ViewSpline;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.constraintlayout.widget.R;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;

/* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/motion/widget/KeyTrigger.class */
public class KeyTrigger extends Key {
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
    public static final String VIEW_TRANSITION_ON_CROSS = "viewTransitionOnCross";
    public static final String VIEW_TRANSITION_ON_NEGATIVE_CROSS = "viewTransitionOnNegativeCross";
    public static final String VIEW_TRANSITION_ON_POSITIVE_CROSS = "viewTransitionOnPositiveCross";
    private float y;
    private int m = -1;
    private String n = null;
    private int o = UNSET;
    private String p = null;
    private String q = null;
    private int r = UNSET;
    private int s = UNSET;
    private View t = null;
    float f = 0.1f;
    private boolean u = true;
    private boolean v = true;
    private boolean w = true;
    private float x = Float.NaN;
    private boolean z = false;
    int g = UNSET;
    int h = UNSET;
    int i = UNSET;
    RectF j = new RectF();
    RectF k = new RectF();
    HashMap<String, Method> l = new HashMap<>();

    /* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/motion/widget/KeyTrigger$Loader.class */
    static class Loader {

        /* renamed from: a  reason: collision with root package name */
        private static SparseIntArray f2128a;

        static {
            SparseIntArray sparseIntArray = new SparseIntArray();
            f2128a = sparseIntArray;
            sparseIntArray.append(R.styleable.KeyTrigger_framePosition, 8);
            f2128a.append(R.styleable.KeyTrigger_onCross, 4);
            f2128a.append(R.styleable.KeyTrigger_onNegativeCross, 1);
            f2128a.append(R.styleable.KeyTrigger_onPositiveCross, 2);
            f2128a.append(R.styleable.KeyTrigger_motionTarget, 7);
            f2128a.append(R.styleable.KeyTrigger_triggerId, 6);
            f2128a.append(R.styleable.KeyTrigger_triggerSlack, 5);
            f2128a.append(R.styleable.KeyTrigger_motion_triggerOnCollision, 9);
            f2128a.append(R.styleable.KeyTrigger_motion_postLayoutCollision, 10);
            f2128a.append(R.styleable.KeyTrigger_triggerReceiver, 11);
            f2128a.append(R.styleable.KeyTrigger_viewTransitionOnCross, 12);
            f2128a.append(R.styleable.KeyTrigger_viewTransitionOnNegativeCross, 13);
            f2128a.append(R.styleable.KeyTrigger_viewTransitionOnPositiveCross, 14);
        }

        private Loader() {
        }

        public static void read(KeyTrigger keyTrigger, TypedArray typedArray, Context context) {
            int indexCount = typedArray.getIndexCount();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= indexCount) {
                    return;
                }
                int index = typedArray.getIndex(i2);
                switch (f2128a.get(index)) {
                    case 1:
                        keyTrigger.p = typedArray.getString(index);
                        break;
                    case 2:
                        keyTrigger.q = typedArray.getString(index);
                        break;
                    case 3:
                    default:
                        Log.e(TypedValues.TriggerType.NAME, "unused attribute 0x" + Integer.toHexString(index) + "   " + f2128a.get(index));
                        break;
                    case 4:
                        keyTrigger.n = typedArray.getString(index);
                        break;
                    case 5:
                        keyTrigger.f = typedArray.getFloat(index, keyTrigger.f);
                        break;
                    case 6:
                        keyTrigger.r = typedArray.getResourceId(index, keyTrigger.r);
                        break;
                    case 7:
                        if (!MotionLayout.IS_IN_EDIT_MODE) {
                            if (typedArray.peekValue(index).type != 3) {
                                keyTrigger.b = typedArray.getResourceId(index, keyTrigger.b);
                                break;
                            } else {
                                keyTrigger.f2122c = typedArray.getString(index);
                                break;
                            }
                        } else {
                            keyTrigger.b = typedArray.getResourceId(index, keyTrigger.b);
                            if (keyTrigger.b != -1) {
                                break;
                            } else {
                                keyTrigger.f2122c = typedArray.getString(index);
                                break;
                            }
                        }
                    case 8:
                        keyTrigger.f2121a = typedArray.getInteger(index, keyTrigger.f2121a);
                        keyTrigger.x = (keyTrigger.f2121a + 0.5f) / 100.0f;
                        break;
                    case 9:
                        keyTrigger.s = typedArray.getResourceId(index, keyTrigger.s);
                        break;
                    case 10:
                        keyTrigger.z = typedArray.getBoolean(index, keyTrigger.z);
                        break;
                    case 11:
                        keyTrigger.o = typedArray.getResourceId(index, keyTrigger.o);
                        break;
                    case 12:
                        keyTrigger.i = typedArray.getResourceId(index, keyTrigger.i);
                        break;
                    case 13:
                        keyTrigger.g = typedArray.getResourceId(index, keyTrigger.g);
                        break;
                    case 14:
                        keyTrigger.h = typedArray.getResourceId(index, keyTrigger.h);
                        break;
                }
                i = i2 + 1;
            }
        }
    }

    public KeyTrigger() {
        this.d = 5;
        this.e = new HashMap<>();
    }

    private void a(RectF rectF, View view, boolean z) {
        rectF.top = view.getTop();
        rectF.bottom = view.getBottom();
        rectF.left = view.getLeft();
        rectF.right = view.getRight();
        if (z) {
            view.getMatrix().mapRect(rectF);
        }
    }

    private void a(String str, View view) {
        Method method;
        if (str == null) {
            return;
        }
        if (str.startsWith(".")) {
            b(str, view);
            return;
        }
        if (this.l.containsKey(str)) {
            Method method2 = this.l.get(str);
            method = method2;
            if (method2 == null) {
                return;
            }
        } else {
            method = null;
        }
        Method method3 = method;
        if (method == null) {
            try {
                method3 = view.getClass().getMethod(str, new Class[0]);
                this.l.put(str, method3);
            } catch (NoSuchMethodException e) {
                this.l.put(str, null);
                Log.e(TypedValues.TriggerType.NAME, "Could not find method \"" + str + "\"on class " + view.getClass().getSimpleName() + " " + Debug.getName(view));
                return;
            }
        }
        try {
            method3.invoke(view, new Object[0]);
        } catch (Exception e2) {
            Log.e(TypedValues.TriggerType.NAME, "Exception in call \"" + this.n + "\"on class " + view.getClass().getSimpleName() + " " + Debug.getName(view));
        }
    }

    private void b(String str, View view) {
        boolean z = str.length() == 1;
        String str2 = str;
        if (!z) {
            str2 = str.substring(1).toLowerCase(Locale.ROOT);
        }
        for (String str3 : this.e.keySet()) {
            String lowerCase = str3.toLowerCase(Locale.ROOT);
            if (z || lowerCase.matches(str2)) {
                ConstraintAttribute constraintAttribute = this.e.get(str3);
                if (constraintAttribute != null) {
                    constraintAttribute.applyCustom(view);
                }
            }
        }
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public void addValues(HashMap<String, ViewSpline> hashMap) {
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    /* renamed from: clone */
    public Key mo1228clone() {
        return new KeyTrigger().copy(this);
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0145  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0175  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void conditionallyFire(float r8, android.view.View r9) {
        /*
            Method dump skipped, instructions count: 639
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.KeyTrigger.conditionallyFire(float, android.view.View):void");
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public Key copy(Key key) {
        super.copy(key);
        KeyTrigger keyTrigger = (KeyTrigger) key;
        this.m = keyTrigger.m;
        this.n = keyTrigger.n;
        this.o = keyTrigger.o;
        this.p = keyTrigger.p;
        this.q = keyTrigger.q;
        this.r = keyTrigger.r;
        this.s = keyTrigger.s;
        this.t = keyTrigger.t;
        this.f = keyTrigger.f;
        this.u = keyTrigger.u;
        this.v = keyTrigger.v;
        this.w = keyTrigger.w;
        this.x = keyTrigger.x;
        this.y = keyTrigger.y;
        this.z = keyTrigger.z;
        this.j = keyTrigger.j;
        this.k = keyTrigger.k;
        this.l = keyTrigger.l;
        return this;
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public void getAttributeNames(HashSet<String> hashSet) {
    }

    @Override // androidx.constraintlayout.motion.widget.Key
    public void load(Context context, AttributeSet attributeSet) {
        Loader.read(this, context.obtainStyledAttributes(attributeSet, R.styleable.KeyTrigger), context);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // androidx.constraintlayout.motion.widget.Key
    public void setValue(String str, Object obj) {
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
            case 64397344:
                if (str.equals("CROSS")) {
                    z = false;
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
                    z = true;
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
                this.n = obj.toString();
                return;
            case true:
                this.o = b(obj);
                return;
            case true:
                this.p = obj.toString();
                return;
            case true:
                this.q = obj.toString();
                return;
            case true:
                this.r = b(obj);
                return;
            case true:
                this.s = b(obj);
                return;
            case true:
                this.t = (View) obj;
                return;
            case true:
                this.f = a(obj);
                return;
            case true:
                this.z = c(obj);
                return;
            case true:
                this.g = b(obj);
                return;
            case true:
                this.h = b(obj);
                return;
            case true:
                this.i = b(obj);
                return;
            default:
                return;
        }
    }
}
