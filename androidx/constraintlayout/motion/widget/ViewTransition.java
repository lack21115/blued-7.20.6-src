package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.util.Log;
import android.util.TypedValue;
import android.util.Xml;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.OvershootInterpolator;
import androidx.constraintlayout.core.motion.utils.Easing;
import androidx.constraintlayout.core.motion.utils.KeyCache;
import androidx.constraintlayout.motion.widget.MotionScene;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.constraintlayout.widget.R;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/motion/widget/ViewTransition.class */
public class ViewTransition {
    public static final String CONSTRAINT_OVERRIDE = "ConstraintOverride";
    public static final String CUSTOM_ATTRIBUTE = "CustomAttribute";
    public static final String CUSTOM_METHOD = "CustomMethod";
    public static final String KEY_FRAME_SET_TAG = "KeyFrameSet";
    public static final int ONSTATE_ACTION_DOWN = 1;
    public static final int ONSTATE_ACTION_DOWN_UP = 3;
    public static final int ONSTATE_ACTION_UP = 2;
    public static final int ONSTATE_SHARED_VALUE_SET = 4;
    public static final int ONSTATE_SHARED_VALUE_UNSET = 5;
    public static final String VIEW_TRANSITION_TAG = "ViewTransition";
    private static String e = "ViewTransition";

    /* renamed from: a  reason: collision with root package name */
    int f2217a;
    KeyFrames b;

    /* renamed from: c  reason: collision with root package name */
    ConstraintSet.Constraint f2218c;
    Context d;
    private int f;
    private int l;
    private String m;
    private int g = -1;
    private boolean h = false;
    private int i = 0;
    private int j = -1;
    private int k = -1;
    private int n = 0;
    private String o = null;
    private int p = -1;
    private int q = -1;
    private int r = -1;
    private int s = -1;
    private int t = -1;
    private int u = -1;
    private int v = -1;
    private int w = -1;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/motion/widget/ViewTransition$Animate.class */
    public static class Animate {

        /* renamed from: a  reason: collision with root package name */
        long f2220a;
        MotionController b;

        /* renamed from: c  reason: collision with root package name */
        int f2221c;
        int d;
        ViewTransitionController f;
        Interpolator g;
        float i;
        float j;
        long k;
        boolean m;
        private final int n;
        private final int o;
        KeyCache e = new KeyCache();
        boolean h = false;
        Rect l = new Rect();

        Animate(ViewTransitionController viewTransitionController, MotionController motionController, int i, int i2, int i3, Interpolator interpolator, int i4, int i5) {
            this.m = false;
            this.f = viewTransitionController;
            this.b = motionController;
            this.f2221c = i;
            this.d = i2;
            long nanoTime = System.nanoTime();
            this.f2220a = nanoTime;
            this.k = nanoTime;
            this.f.a(this);
            this.g = interpolator;
            this.n = i4;
            this.o = i5;
            if (i3 == 3) {
                this.m = true;
            }
            this.j = i == 0 ? Float.MAX_VALUE : 1.0f / i;
            a();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void a() {
            if (this.h) {
                b();
            } else {
                c();
            }
        }

        void a(boolean z) {
            int i;
            this.h = z;
            if (z && (i = this.d) != -1) {
                this.j = i == 0 ? Float.MAX_VALUE : 1.0f / i;
            }
            this.f.b();
            this.k = System.nanoTime();
        }

        void b() {
            long nanoTime = System.nanoTime();
            long j = this.k;
            this.k = nanoTime;
            float f = this.i - (((float) ((nanoTime - j) * 1.0E-6d)) * this.j);
            this.i = f;
            if (f < 0.0f) {
                this.i = 0.0f;
            }
            Interpolator interpolator = this.g;
            float interpolation = interpolator == null ? this.i : interpolator.getInterpolation(this.i);
            MotionController motionController = this.b;
            boolean a2 = motionController.a(motionController.b, interpolation, nanoTime, this.e);
            if (this.i <= 0.0f) {
                if (this.n != -1) {
                    this.b.getView().setTag(this.n, Long.valueOf(System.nanoTime()));
                }
                if (this.o != -1) {
                    this.b.getView().setTag(this.o, null);
                }
                this.f.b(this);
            }
            if (this.i > 0.0f || a2) {
                this.f.b();
            }
        }

        void c() {
            long nanoTime = System.nanoTime();
            long j = this.k;
            this.k = nanoTime;
            float f = this.i + (((float) ((nanoTime - j) * 1.0E-6d)) * this.j);
            this.i = f;
            if (f >= 1.0f) {
                this.i = 1.0f;
            }
            Interpolator interpolator = this.g;
            float interpolation = interpolator == null ? this.i : interpolator.getInterpolation(this.i);
            MotionController motionController = this.b;
            boolean a2 = motionController.a(motionController.b, interpolation, nanoTime, this.e);
            if (this.i >= 1.0f) {
                if (this.n != -1) {
                    this.b.getView().setTag(this.n, Long.valueOf(System.nanoTime()));
                }
                if (this.o != -1) {
                    this.b.getView().setTag(this.o, null);
                }
                if (!this.m) {
                    this.f.b(this);
                }
            }
            if (this.i < 1.0f || a2) {
                this.f.b();
            }
        }

        public void reactTo(int i, float f, float f2) {
            if (i == 1) {
                if (this.h) {
                    return;
                }
                a(true);
            } else if (i != 2) {
            } else {
                this.b.getView().getHitRect(this.l);
                if (this.l.contains((int) f, (int) f2) || this.h) {
                    return;
                }
                a(true);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public ViewTransition(Context context, XmlPullParser xmlPullParser) {
        boolean z;
        this.d = context;
        try {
            int eventType = xmlPullParser.getEventType();
            while (eventType != 1) {
                if (eventType == 2) {
                    String name = xmlPullParser.getName();
                    switch (name.hashCode()) {
                        case -1962203927:
                            if (name.equals(CONSTRAINT_OVERRIDE)) {
                                z = true;
                                break;
                            }
                            z = true;
                            break;
                        case -1239391468:
                            if (name.equals(KEY_FRAME_SET_TAG)) {
                                z = true;
                                break;
                            }
                            z = true;
                            break;
                        case 61998586:
                            if (name.equals(VIEW_TRANSITION_TAG)) {
                                z = false;
                                break;
                            }
                            z = true;
                            break;
                        case 366511058:
                            if (name.equals(CUSTOM_METHOD)) {
                                z = true;
                                break;
                            }
                            z = true;
                            break;
                        case 1791837707:
                            if (name.equals(CUSTOM_ATTRIBUTE)) {
                                z = true;
                                break;
                            }
                            z = true;
                            break;
                        default:
                            z = true;
                            break;
                    }
                    if (!z) {
                        a(context, xmlPullParser);
                    } else if (z) {
                        this.b = new KeyFrames(context, xmlPullParser);
                    } else if (z) {
                        this.f2218c = ConstraintSet.buildDelta(context, xmlPullParser);
                    } else if (z || z) {
                        ConstraintAttribute.parse(context, xmlPullParser, this.f2218c.mCustomConstraints);
                    } else {
                        Log.e(e, Debug.getLoc() + " unknown tag " + name);
                        Log.e(e, ".xml:" + xmlPullParser.getLineNumber());
                    }
                } else if (eventType == 3) {
                    if (VIEW_TRANSITION_TAG.equals(xmlPullParser.getName())) {
                        return;
                    }
                }
                eventType = xmlPullParser.next();
            }
        } catch (IOException e2) {
            e2.printStackTrace();
        } catch (XmlPullParserException e3) {
            e3.printStackTrace();
        }
    }

    private void a(Context context, XmlPullParser xmlPullParser) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), R.styleable.ViewTransition);
        int indexCount = obtainStyledAttributes.getIndexCount();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= indexCount) {
                obtainStyledAttributes.recycle();
                return;
            }
            int index = obtainStyledAttributes.getIndex(i2);
            if (index == R.styleable.ViewTransition_android_id) {
                this.f = obtainStyledAttributes.getResourceId(index, this.f);
            } else if (index == R.styleable.ViewTransition_motionTarget) {
                if (MotionLayout.IS_IN_EDIT_MODE) {
                    int resourceId = obtainStyledAttributes.getResourceId(index, this.l);
                    this.l = resourceId;
                    if (resourceId == -1) {
                        this.m = obtainStyledAttributes.getString(index);
                    }
                } else if (obtainStyledAttributes.peekValue(index).type == 3) {
                    this.m = obtainStyledAttributes.getString(index);
                } else {
                    this.l = obtainStyledAttributes.getResourceId(index, this.l);
                }
            } else if (index == R.styleable.ViewTransition_onStateTransition) {
                this.g = obtainStyledAttributes.getInt(index, this.g);
            } else if (index == R.styleable.ViewTransition_transitionDisable) {
                this.h = obtainStyledAttributes.getBoolean(index, this.h);
            } else if (index == R.styleable.ViewTransition_pathMotionArc) {
                this.i = obtainStyledAttributes.getInt(index, this.i);
            } else if (index == R.styleable.ViewTransition_duration) {
                this.j = obtainStyledAttributes.getInt(index, this.j);
            } else if (index == R.styleable.ViewTransition_upDuration) {
                this.k = obtainStyledAttributes.getInt(index, this.k);
            } else if (index == R.styleable.ViewTransition_viewTransitionMode) {
                this.f2217a = obtainStyledAttributes.getInt(index, this.f2217a);
            } else if (index == R.styleable.ViewTransition_motionInterpolator) {
                TypedValue peekValue = obtainStyledAttributes.peekValue(index);
                if (peekValue.type == 1) {
                    int resourceId2 = obtainStyledAttributes.getResourceId(index, -1);
                    this.p = resourceId2;
                    if (resourceId2 != -1) {
                        this.n = -2;
                    }
                } else if (peekValue.type == 3) {
                    String string = obtainStyledAttributes.getString(index);
                    this.o = string;
                    if (string == null || string.indexOf(BridgeUtil.SPLIT_MARK) <= 0) {
                        this.n = -1;
                    } else {
                        this.p = obtainStyledAttributes.getResourceId(index, -1);
                        this.n = -2;
                    }
                } else {
                    this.n = obtainStyledAttributes.getInteger(index, this.n);
                }
            } else if (index == R.styleable.ViewTransition_setsTag) {
                this.q = obtainStyledAttributes.getResourceId(index, this.q);
            } else if (index == R.styleable.ViewTransition_clearsTag) {
                this.r = obtainStyledAttributes.getResourceId(index, this.r);
            } else if (index == R.styleable.ViewTransition_ifTagSet) {
                this.s = obtainStyledAttributes.getResourceId(index, this.s);
            } else if (index == R.styleable.ViewTransition_ifTagNotSet) {
                this.t = obtainStyledAttributes.getResourceId(index, this.t);
            } else if (index == R.styleable.ViewTransition_SharedValueId) {
                this.v = obtainStyledAttributes.getResourceId(index, this.v);
            } else if (index == R.styleable.ViewTransition_SharedValue) {
                this.u = obtainStyledAttributes.getInteger(index, this.u);
            }
            i = i2 + 1;
        }
    }

    private void a(MotionScene.Transition transition, View view) {
        int i = this.j;
        if (i != -1) {
            transition.setDuration(i);
        }
        transition.setPathMotionArc(this.i);
        transition.setInterpolatorInfo(this.n, this.o, this.p);
        int id = view.getId();
        KeyFrames keyFrames = this.b;
        if (keyFrames != null) {
            ArrayList<Key> keyFramesForView = keyFrames.getKeyFramesForView(-1);
            KeyFrames keyFrames2 = new KeyFrames();
            Iterator<Key> it = keyFramesForView.iterator();
            while (it.hasNext()) {
                keyFrames2.addKey(it.next().mo1365clone().setViewId(id));
            }
            transition.addKeyFrame(keyFrames2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(View[] viewArr) {
        if (this.q != -1) {
            int length = viewArr.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    break;
                }
                viewArr[i2].setTag(this.q, Long.valueOf(System.nanoTime()));
                i = i2 + 1;
            }
        }
        if (this.r == -1) {
            return;
        }
        int length2 = viewArr.length;
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= length2) {
                return;
            }
            viewArr[i4].setTag(this.r, null);
            i3 = i4 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int a() {
        return this.f;
    }

    Interpolator a(Context context) {
        int i = this.n;
        if (i != -2) {
            if (i == -1) {
                final Easing interpolator = Easing.getInterpolator(this.o);
                return new Interpolator() { // from class: androidx.constraintlayout.motion.widget.ViewTransition.1
                    @Override // android.animation.TimeInterpolator
                    public float getInterpolation(float f) {
                        return (float) interpolator.get(f);
                    }
                };
            } else if (i != 0) {
                if (i != 1) {
                    if (i != 2) {
                        if (i != 4) {
                            if (i != 5) {
                                if (i != 6) {
                                    return null;
                                }
                                return new AnticipateInterpolator();
                            }
                            return new OvershootInterpolator();
                        }
                        return new BounceInterpolator();
                    }
                    return new DecelerateInterpolator();
                }
                return new AccelerateInterpolator();
            } else {
                return new AccelerateDecelerateInterpolator();
            }
        }
        return AnimationUtils.loadInterpolator(context, this.p);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(ViewTransitionController viewTransitionController, MotionLayout motionLayout, int i, ConstraintSet constraintSet, final View... viewArr) {
        if (this.h) {
            return;
        }
        int i2 = this.f2217a;
        if (i2 == 2) {
            a(viewTransitionController, motionLayout, viewArr[0]);
            return;
        }
        if (i2 == 1) {
            int[] constraintSetIds = motionLayout.getConstraintSetIds();
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 >= constraintSetIds.length) {
                    break;
                }
                int i5 = constraintSetIds[i4];
                if (i5 != i) {
                    ConstraintSet constraintSet2 = motionLayout.getConstraintSet(i5);
                    int length = viewArr.length;
                    int i6 = 0;
                    while (true) {
                        int i7 = i6;
                        if (i7 < length) {
                            ConstraintSet.Constraint constraint = constraintSet2.getConstraint(viewArr[i7].getId());
                            ConstraintSet.Constraint constraint2 = this.f2218c;
                            if (constraint2 != null) {
                                constraint2.applyDelta(constraint);
                                constraint.mCustomConstraints.putAll(this.f2218c.mCustomConstraints);
                            }
                            i6 = i7 + 1;
                        }
                    }
                }
                i3 = i4 + 1;
            }
        }
        ConstraintSet constraintSet3 = new ConstraintSet();
        constraintSet3.clone(constraintSet);
        int length2 = viewArr.length;
        int i8 = 0;
        while (true) {
            int i9 = i8;
            if (i9 >= length2) {
                break;
            }
            ConstraintSet.Constraint constraint3 = constraintSet3.getConstraint(viewArr[i9].getId());
            ConstraintSet.Constraint constraint4 = this.f2218c;
            if (constraint4 != null) {
                constraint4.applyDelta(constraint3);
                constraint3.mCustomConstraints.putAll(this.f2218c.mCustomConstraints);
            }
            i8 = i9 + 1;
        }
        motionLayout.updateState(i, constraintSet3);
        motionLayout.updateState(R.id.view_transition, constraintSet);
        motionLayout.setState(R.id.view_transition, -1, -1);
        MotionScene.Transition transition = new MotionScene.Transition(-1, motionLayout.f2184a, R.id.view_transition, i);
        int length3 = viewArr.length;
        int i10 = 0;
        while (true) {
            int i11 = i10;
            if (i11 >= length3) {
                motionLayout.setTransition(transition);
                motionLayout.transitionToEnd(new Runnable() { // from class: androidx.constraintlayout.motion.widget.-$$Lambda$ViewTransition$FPmFsqHB63ONC1FoC2-Icq2uS9w
                    @Override // java.lang.Runnable
                    public final void run() {
                        ViewTransition.this.a(viewArr);
                    }
                });
                return;
            }
            a(transition, viewArr[i11]);
            i10 = i11 + 1;
        }
    }

    void a(ViewTransitionController viewTransitionController, MotionLayout motionLayout, View view) {
        MotionController motionController = new MotionController(view);
        motionController.b(view);
        this.b.addAllFrames(motionController);
        motionController.setup(motionLayout.getWidth(), motionLayout.getHeight(), this.j, System.nanoTime());
        new Animate(viewTransitionController, motionController, this.j, this.k, this.g, a(motionLayout.getContext()), this.q, this.r);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(boolean z) {
        this.h = !z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(int i) {
        int i2 = this.g;
        boolean z = false;
        if (i2 == 1) {
            if (i == 0) {
                z = true;
            }
            return z;
        } else if (i2 == 2) {
            boolean z2 = false;
            if (i == 1) {
                z2 = true;
            }
            return z2;
        } else {
            boolean z3 = false;
            if (i2 == 3) {
                z3 = false;
                if (i == 0) {
                    z3 = true;
                }
            }
            return z3;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(View view) {
        String str;
        if (view == null) {
            return false;
        }
        if (!(this.l == -1 && this.m == null) && b(view)) {
            if (view.getId() == this.l) {
                return true;
            }
            return this.m != null && (view.getLayoutParams() instanceof ConstraintLayout.LayoutParams) && (str = ((ConstraintLayout.LayoutParams) view.getLayoutParams()).constraintTag) != null && str.matches(this.m);
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b() {
        return !this.h;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b(View view) {
        int i = this.s;
        boolean z = i == -1 || view.getTag(i) != null;
        int i2 = this.t;
        boolean z2 = i2 == -1 || view.getTag(i2) == null;
        boolean z3 = false;
        if (z) {
            z3 = false;
            if (z2) {
                z3 = true;
            }
        }
        return z3;
    }

    public int getSharedValue() {
        return this.u;
    }

    public int getSharedValueCurrent() {
        return this.w;
    }

    public int getSharedValueID() {
        return this.v;
    }

    public int getStateTransition() {
        return this.g;
    }

    public void setSharedValue(int i) {
        this.u = i;
    }

    public void setSharedValueCurrent(int i) {
        this.w = i;
    }

    public void setSharedValueID(int i) {
        this.v = i;
    }

    public void setStateTransition(int i) {
        this.g = i;
    }

    public String toString() {
        return "ViewTransition(" + Debug.getName(this.d, this.f) + ")";
    }
}
