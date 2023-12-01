package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.util.TypedValue;
import android.util.Xml;
import android.view.MotionEvent;
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
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.constraintlayout.widget.R;
import androidx.constraintlayout.widget.StateSet;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import com.bytedance.applog.tracker.Tracker;
import com.igexin.push.core.b;
import com.j256.ormlite.stmt.query.SimpleComparison;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.xml.XMLConstants;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/motion/widget/MotionScene.class */
public class MotionScene {
    public static final int LAYOUT_CALL_MEASURE = 2;
    public static final int LAYOUT_HONOR_REQUEST = 1;
    public static final int LAYOUT_IGNORE_REQUEST = 0;
    public static final int UNSET = -1;

    /* renamed from: c  reason: collision with root package name */
    final ViewTransitionController f2205c;
    float d;
    float e;
    private final MotionLayout f;
    private MotionEvent q;
    private MotionLayout.MotionTracker t;
    private boolean u;

    /* renamed from: a  reason: collision with root package name */
    StateSet f2204a = null;
    Transition b = null;
    private boolean g = false;
    private ArrayList<Transition> h = new ArrayList<>();
    private Transition i = null;
    private ArrayList<Transition> j = new ArrayList<>();
    private SparseArray<ConstraintSet> k = new SparseArray<>();
    private HashMap<String, Integer> l = new HashMap<>();
    private SparseIntArray m = new SparseIntArray();
    private boolean n = false;
    private int o = 400;
    private int p = 0;
    private boolean r = false;
    private boolean s = false;

    /* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/motion/widget/MotionScene$Transition.class */
    public static class Transition {
        public static final int AUTO_ANIMATE_TO_END = 4;
        public static final int AUTO_ANIMATE_TO_START = 3;
        public static final int AUTO_JUMP_TO_END = 2;
        public static final int AUTO_JUMP_TO_START = 1;
        public static final int AUTO_NONE = 0;

        /* renamed from: a  reason: collision with root package name */
        private int f2207a;
        private boolean b;

        /* renamed from: c  reason: collision with root package name */
        private int f2208c;
        private int d;
        private int e;
        private String f;
        private int g;
        private int h;
        private float i;
        private final MotionScene j;
        private ArrayList<KeyFrames> k;
        private TouchResponse l;
        private ArrayList<TransitionOnClick> m;
        private int n;
        private boolean o;
        private int p;
        private int q;
        private int r;

        /* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/motion/widget/MotionScene$Transition$TransitionOnClick.class */
        public static class TransitionOnClick implements View.OnClickListener {
            public static final int ANIM_TOGGLE = 17;
            public static final int ANIM_TO_END = 1;
            public static final int ANIM_TO_START = 16;
            public static final int JUMP_TO_END = 256;
            public static final int JUMP_TO_START = 4096;

            /* renamed from: a  reason: collision with root package name */
            int f2209a;
            int b;

            /* renamed from: c  reason: collision with root package name */
            private final Transition f2210c;

            public TransitionOnClick(Context context, Transition transition, XmlPullParser xmlPullParser) {
                this.f2209a = -1;
                this.b = 17;
                this.f2210c = transition;
                TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), R.styleable.OnClick);
                int indexCount = obtainStyledAttributes.getIndexCount();
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= indexCount) {
                        obtainStyledAttributes.recycle();
                        return;
                    }
                    int index = obtainStyledAttributes.getIndex(i2);
                    if (index == R.styleable.OnClick_targetId) {
                        this.f2209a = obtainStyledAttributes.getResourceId(index, this.f2209a);
                    } else if (index == R.styleable.OnClick_clickAction) {
                        this.b = obtainStyledAttributes.getInt(index, this.b);
                    }
                    i = i2 + 1;
                }
            }

            public TransitionOnClick(Transition transition, int i, int i2) {
                this.f2209a = -1;
                this.b = 17;
                this.f2210c = transition;
                this.f2209a = i;
                this.b = i2;
            }

            boolean a(Transition transition, MotionLayout motionLayout) {
                Transition transition2 = this.f2210c;
                boolean z = true;
                if (transition2 == transition) {
                    return true;
                }
                int i = transition2.f2208c;
                int i2 = this.f2210c.d;
                if (i2 == -1) {
                    return motionLayout.e != i;
                }
                if (motionLayout.e != i2) {
                    if (motionLayout.e == i) {
                        return true;
                    }
                    z = false;
                }
                return z;
            }

            public void addOnClickListeners(MotionLayout motionLayout, int i, Transition transition) {
                int i2 = this.f2209a;
                if (i2 != -1) {
                    motionLayout = motionLayout.findViewById(i2);
                }
                if (motionLayout == null) {
                    Log.e(TypedValues.MotionScene.NAME, "OnClick could not find id " + this.f2209a);
                    return;
                }
                int i3 = transition.d;
                int i4 = transition.f2208c;
                if (i3 == -1) {
                    motionLayout.setOnClickListener(this);
                    return;
                }
                boolean z = (this.b & 1) != 0 && i == i3;
                boolean z2 = (this.b & 256) != 0 && i == i3;
                boolean z3 = (this.b & 1) != 0 && i == i3;
                if ((z3 | z | z2 | ((this.b & 16) != 0 && i == i4)) || ((this.b & 4096) != 0 && i == i4)) {
                    motionLayout.setOnClickListener(this);
                }
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                boolean z;
                boolean z2;
                Tracker.onClick(view);
                MotionLayout motionLayout = this.f2210c.j.f;
                if (motionLayout.isInteractionEnabled()) {
                    if (this.f2210c.d == -1) {
                        int currentState = motionLayout.getCurrentState();
                        if (currentState == -1) {
                            motionLayout.transitionToState(this.f2210c.f2208c);
                            return;
                        }
                        Transition transition = new Transition(this.f2210c.j, this.f2210c);
                        transition.d = currentState;
                        transition.f2208c = this.f2210c.f2208c;
                        motionLayout.setTransition(transition);
                        motionLayout.transitionToEnd();
                        return;
                    }
                    Transition transition2 = this.f2210c.j.b;
                    int i = this.b;
                    boolean z3 = ((i & 1) == 0 && (i & 256) == 0) ? false : true;
                    int i2 = this.b;
                    boolean z4 = ((i2 & 16) == 0 && (i2 & 4096) == 0) ? false : true;
                    if (z3 && z4) {
                        Transition transition3 = this.f2210c.j.b;
                        Transition transition4 = this.f2210c;
                        if (transition3 != transition4) {
                            motionLayout.setTransition(transition4);
                        }
                        z2 = z4;
                        z = false;
                        if (motionLayout.getCurrentState() != motionLayout.getEndState()) {
                            if (motionLayout.getProgress() > 0.5f) {
                                z2 = z4;
                                z = false;
                            } else {
                                z2 = false;
                                z = z3;
                            }
                        }
                    } else {
                        z = z3;
                        z2 = z4;
                    }
                    if (a(transition2, motionLayout)) {
                        if (z && (this.b & 1) != 0) {
                            motionLayout.setTransition(this.f2210c);
                            motionLayout.transitionToEnd();
                        } else if (z2 && (this.b & 16) != 0) {
                            motionLayout.setTransition(this.f2210c);
                            motionLayout.transitionToStart();
                        } else if (z && (this.b & 256) != 0) {
                            motionLayout.setTransition(this.f2210c);
                            motionLayout.setProgress(1.0f);
                        } else if (!z2 || (this.b & 4096) == 0) {
                        } else {
                            motionLayout.setTransition(this.f2210c);
                            motionLayout.setProgress(0.0f);
                        }
                    }
                }
            }

            public void removeOnClickListeners(MotionLayout motionLayout) {
                int i = this.f2209a;
                if (i == -1) {
                    return;
                }
                View findViewById = motionLayout.findViewById(i);
                if (findViewById != null) {
                    findViewById.setOnClickListener(null);
                    return;
                }
                Log.e(TypedValues.MotionScene.NAME, " (*)  could not find id " + this.f2209a);
            }
        }

        public Transition(int i, MotionScene motionScene, int i2, int i3) {
            this.f2207a = -1;
            this.b = false;
            this.f2208c = -1;
            this.d = -1;
            this.e = 0;
            this.f = null;
            this.g = -1;
            this.h = 400;
            this.i = 0.0f;
            this.k = new ArrayList<>();
            this.l = null;
            this.m = new ArrayList<>();
            this.n = 0;
            this.o = false;
            this.p = -1;
            this.q = 0;
            this.r = 0;
            this.f2207a = i;
            this.j = motionScene;
            this.d = i2;
            this.f2208c = i3;
            this.h = motionScene.o;
            this.q = motionScene.p;
        }

        Transition(MotionScene motionScene, Context context, XmlPullParser xmlPullParser) {
            this.f2207a = -1;
            this.b = false;
            this.f2208c = -1;
            this.d = -1;
            this.e = 0;
            this.f = null;
            this.g = -1;
            this.h = 400;
            this.i = 0.0f;
            this.k = new ArrayList<>();
            this.l = null;
            this.m = new ArrayList<>();
            this.n = 0;
            this.o = false;
            this.p = -1;
            this.q = 0;
            this.r = 0;
            this.h = motionScene.o;
            this.q = motionScene.p;
            this.j = motionScene;
            a(motionScene, context, Xml.asAttributeSet(xmlPullParser));
        }

        Transition(MotionScene motionScene, Transition transition) {
            this.f2207a = -1;
            this.b = false;
            this.f2208c = -1;
            this.d = -1;
            this.e = 0;
            this.f = null;
            this.g = -1;
            this.h = 400;
            this.i = 0.0f;
            this.k = new ArrayList<>();
            this.l = null;
            this.m = new ArrayList<>();
            this.n = 0;
            this.o = false;
            this.p = -1;
            this.q = 0;
            this.r = 0;
            this.j = motionScene;
            this.h = motionScene.o;
            if (transition != null) {
                this.p = transition.p;
                this.e = transition.e;
                this.f = transition.f;
                this.g = transition.g;
                this.h = transition.h;
                this.k = transition.k;
                this.i = transition.i;
                this.q = transition.q;
            }
        }

        private void a(MotionScene motionScene, Context context, TypedArray typedArray) {
            int indexCount = typedArray.getIndexCount();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= indexCount) {
                    break;
                }
                int index = typedArray.getIndex(i2);
                if (index == R.styleable.Transition_constraintSetEnd) {
                    this.f2208c = typedArray.getResourceId(index, -1);
                    String resourceTypeName = context.getResources().getResourceTypeName(this.f2208c);
                    if ("layout".equals(resourceTypeName)) {
                        ConstraintSet constraintSet = new ConstraintSet();
                        constraintSet.load(context, this.f2208c);
                        motionScene.k.append(this.f2208c, constraintSet);
                    } else if (XMLConstants.XML_NS_PREFIX.equals(resourceTypeName)) {
                        this.f2208c = motionScene.b(context, this.f2208c);
                    }
                } else if (index == R.styleable.Transition_constraintSetStart) {
                    this.d = typedArray.getResourceId(index, this.d);
                    String resourceTypeName2 = context.getResources().getResourceTypeName(this.d);
                    if ("layout".equals(resourceTypeName2)) {
                        ConstraintSet constraintSet2 = new ConstraintSet();
                        constraintSet2.load(context, this.d);
                        motionScene.k.append(this.d, constraintSet2);
                    } else if (XMLConstants.XML_NS_PREFIX.equals(resourceTypeName2)) {
                        this.d = motionScene.b(context, this.d);
                    }
                } else if (index == R.styleable.Transition_motionInterpolator) {
                    TypedValue peekValue = typedArray.peekValue(index);
                    if (peekValue.type == 1) {
                        int resourceId = typedArray.getResourceId(index, -1);
                        this.g = resourceId;
                        if (resourceId != -1) {
                            this.e = -2;
                        }
                    } else if (peekValue.type == 3) {
                        String string = typedArray.getString(index);
                        this.f = string;
                        if (string != null) {
                            if (string.indexOf(BridgeUtil.SPLIT_MARK) > 0) {
                                this.g = typedArray.getResourceId(index, -1);
                                this.e = -2;
                            } else {
                                this.e = -1;
                            }
                        }
                    } else {
                        this.e = typedArray.getInteger(index, this.e);
                    }
                } else if (index == R.styleable.Transition_duration) {
                    int i3 = typedArray.getInt(index, this.h);
                    this.h = i3;
                    if (i3 < 8) {
                        this.h = 8;
                    }
                } else if (index == R.styleable.Transition_staggered) {
                    this.i = typedArray.getFloat(index, this.i);
                } else if (index == R.styleable.Transition_autoTransition) {
                    this.n = typedArray.getInteger(index, this.n);
                } else if (index == R.styleable.Transition_android_id) {
                    this.f2207a = typedArray.getResourceId(index, this.f2207a);
                } else if (index == R.styleable.Transition_transitionDisable) {
                    this.o = typedArray.getBoolean(index, this.o);
                } else if (index == R.styleable.Transition_pathMotionArc) {
                    this.p = typedArray.getInteger(index, -1);
                } else if (index == R.styleable.Transition_layoutDuringTransition) {
                    this.q = typedArray.getInteger(index, 0);
                } else if (index == R.styleable.Transition_transitionFlags) {
                    this.r = typedArray.getInteger(index, 0);
                }
                i = i2 + 1;
            }
            if (this.d == -1) {
                this.b = true;
            }
        }

        private void a(MotionScene motionScene, Context context, AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.Transition);
            a(motionScene, context, obtainStyledAttributes);
            obtainStyledAttributes.recycle();
        }

        public void addKeyFrame(KeyFrames keyFrames) {
            this.k.add(keyFrames);
        }

        public void addOnClick(int i, int i2) {
            Iterator<TransitionOnClick> it = this.m.iterator();
            while (it.hasNext()) {
                TransitionOnClick next = it.next();
                if (next.f2209a == i) {
                    next.b = i2;
                    return;
                }
            }
            this.m.add(new TransitionOnClick(this, i, i2));
        }

        public void addOnClick(Context context, XmlPullParser xmlPullParser) {
            this.m.add(new TransitionOnClick(context, this, xmlPullParser));
        }

        public String debugString(Context context) {
            String resourceEntryName = this.d == -1 ? b.l : context.getResources().getResourceEntryName(this.d);
            if (this.f2208c == -1) {
                return resourceEntryName + " -> null";
            }
            return resourceEntryName + " -> " + context.getResources().getResourceEntryName(this.f2208c);
        }

        public int getAutoTransition() {
            return this.n;
        }

        public int getDuration() {
            return this.h;
        }

        public int getEndConstraintSetId() {
            return this.f2208c;
        }

        public int getId() {
            return this.f2207a;
        }

        public List<KeyFrames> getKeyFrameList() {
            return this.k;
        }

        public int getLayoutDuringTransition() {
            return this.q;
        }

        public List<TransitionOnClick> getOnClickList() {
            return this.m;
        }

        public int getPathMotionArc() {
            return this.p;
        }

        public float getStagger() {
            return this.i;
        }

        public int getStartConstraintSetId() {
            return this.d;
        }

        public TouchResponse getTouchResponse() {
            return this.l;
        }

        public boolean isEnabled() {
            return !this.o;
        }

        public boolean isTransitionFlag(int i) {
            return (i & this.r) != 0;
        }

        public void removeOnClick(int i) {
            TransitionOnClick transitionOnClick;
            Iterator<TransitionOnClick> it = this.m.iterator();
            while (true) {
                if (!it.hasNext()) {
                    transitionOnClick = null;
                    break;
                }
                transitionOnClick = it.next();
                if (transitionOnClick.f2209a == i) {
                    break;
                }
            }
            if (transitionOnClick != null) {
                this.m.remove(transitionOnClick);
            }
        }

        public void setAutoTransition(int i) {
            this.n = i;
        }

        public void setDuration(int i) {
            this.h = Math.max(i, 8);
        }

        public void setEnable(boolean z) {
            setEnabled(z);
        }

        public void setEnabled(boolean z) {
            this.o = !z;
        }

        public void setInterpolatorInfo(int i, String str, int i2) {
            this.e = i;
            this.f = str;
            this.g = i2;
        }

        public void setLayoutDuringTransition(int i) {
            this.q = i;
        }

        public void setOnSwipe(OnSwipe onSwipe) {
            this.l = onSwipe == null ? null : new TouchResponse(this.j.f, onSwipe);
        }

        public void setOnTouchUp(int i) {
            TouchResponse touchResponse = getTouchResponse();
            if (touchResponse != null) {
                touchResponse.setTouchUpMode(i);
            }
        }

        public void setPathMotionArc(int i) {
            this.p = i;
        }

        public void setStagger(float f) {
            this.i = f;
        }

        public void setTransitionFlag(int i) {
            this.r = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MotionScene(Context context, MotionLayout motionLayout, int i) {
        this.f = motionLayout;
        this.f2205c = new ViewTransitionController(motionLayout);
        a(context, i);
        this.k.put(R.id.motion_base, new ConstraintSet());
        this.l.put("motion_base", Integer.valueOf(R.id.motion_base));
    }

    public MotionScene(MotionLayout motionLayout) {
        this.f = motionLayout;
        this.f2205c = new ViewTransitionController(motionLayout);
    }

    private int a(Context context, String str) {
        int i;
        if (str.contains(BridgeUtil.SPLIT_MARK)) {
            int identifier = context.getResources().getIdentifier(str.substring(str.indexOf(47) + 1), "id", context.getPackageName());
            i = identifier;
            if (this.n) {
                System.out.println("id getMap res = " + identifier);
                i = identifier;
            }
        } else {
            i = -1;
        }
        if (i == -1) {
            if (str != null && str.length() > 1) {
                return Integer.parseInt(str.substring(1));
            }
            Log.e(TypedValues.MotionScene.NAME, "error in parsing id");
        }
        return i;
    }

    private int a(Transition transition) {
        int i = transition.f2207a;
        if (i == -1) {
            throw new IllegalArgumentException("The transition must have an id");
        }
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= this.h.size()) {
                return -1;
            }
            if (this.h.get(i3).f2207a == i) {
                return i3;
            }
            i2 = i3 + 1;
        }
    }

    private void a(int i, MotionLayout motionLayout) {
        ConstraintSet constraintSet = this.k.get(i);
        constraintSet.derivedState = constraintSet.mIdString;
        int i2 = this.m.get(i);
        if (i2 > 0) {
            a(i2, motionLayout);
            ConstraintSet constraintSet2 = this.k.get(i2);
            if (constraintSet2 == null) {
                Log.e(TypedValues.MotionScene.NAME, "ERROR! invalid deriveConstraintsFrom: @id/" + Debug.getName(this.f.getContext(), i2));
                return;
            }
            constraintSet.derivedState += BridgeUtil.SPLIT_MARK + constraintSet2.derivedState;
            constraintSet.readFallback(constraintSet2);
        } else {
            constraintSet.derivedState += "  layout";
            constraintSet.readFallback(motionLayout);
        }
        constraintSet.applyDeltaFrom(constraintSet);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private void a(Context context, int i) {
        Transition transition;
        boolean z;
        XmlResourceParser xml = context.getResources().getXml(i);
        Transition transition2 = null;
        try {
            int eventType = xml.getEventType();
            while (eventType != 1) {
                if (eventType == 0) {
                    xml.getName();
                    transition = transition2;
                } else if (eventType == 2) {
                    String name = xml.getName();
                    if (this.n) {
                        System.out.println("parsing = " + name);
                    }
                    switch (name.hashCode()) {
                        case -1349929691:
                            if (name.equals("ConstraintSet")) {
                                z = true;
                                break;
                            }
                            z = true;
                            break;
                        case -1239391468:
                            if (name.equals(ViewTransition.KEY_FRAME_SET_TAG)) {
                                z = true;
                                break;
                            }
                            z = true;
                            break;
                        case -687739768:
                            if (name.equals("Include")) {
                                z = true;
                                break;
                            }
                            z = true;
                            break;
                        case 61998586:
                            if (name.equals(ViewTransition.VIEW_TRANSITION_TAG)) {
                                z = true;
                                break;
                            }
                            z = true;
                            break;
                        case 269306229:
                            if (name.equals("Transition")) {
                                z = true;
                                break;
                            }
                            z = true;
                            break;
                        case 312750793:
                            if (name.equals("OnClick")) {
                                z = true;
                                break;
                            }
                            z = true;
                            break;
                        case 327855227:
                            if (name.equals("OnSwipe")) {
                                z = true;
                                break;
                            }
                            z = true;
                            break;
                        case 793277014:
                            if (name.equals(TypedValues.MotionScene.NAME)) {
                                z = false;
                                break;
                            }
                            z = true;
                            break;
                        case 1382829617:
                            if (name.equals("StateSet")) {
                                z = true;
                                break;
                            }
                            z = true;
                            break;
                        case 1942574248:
                            if (name.equals("include")) {
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
                            a(context, xml);
                            transition = transition2;
                            break;
                        case true:
                            ArrayList<Transition> arrayList = this.h;
                            transition = new Transition(this, context, xml);
                            arrayList.add(transition);
                            if (this.b == null && !transition.b) {
                                this.b = transition;
                                if (transition != null && transition.l != null) {
                                    this.b.l.setRTL(this.u);
                                }
                            }
                            if (transition.b) {
                                if (transition.f2208c == -1) {
                                    this.i = transition;
                                } else {
                                    this.j.add(transition);
                                }
                                this.h.remove(transition);
                                break;
                            }
                            break;
                        case true:
                            if (transition2 == null) {
                                Log.v(TypedValues.MotionScene.NAME, " OnSwipe (" + context.getResources().getResourceEntryName(i) + ".xml:" + xml.getLineNumber() + ")");
                            }
                            transition = transition2;
                            if (transition2 != null) {
                                transition2.l = new TouchResponse(context, this.f, xml);
                                transition = transition2;
                                break;
                            }
                            break;
                        case true:
                            transition = transition2;
                            if (transition2 != null) {
                                transition2.addOnClick(context, xml);
                                transition = transition2;
                                break;
                            }
                            break;
                        case true:
                            this.f2204a = new StateSet(context, xml);
                            transition = transition2;
                            break;
                        case true:
                            c(context, xml);
                            transition = transition2;
                            break;
                        case true:
                        case true:
                            b(context, xml);
                            transition = transition2;
                            break;
                        case true:
                            KeyFrames keyFrames = new KeyFrames(context, xml);
                            transition = transition2;
                            if (transition2 != null) {
                                transition2.k.add(keyFrames);
                                transition = transition2;
                                break;
                            }
                            break;
                        case true:
                            this.f2205c.add(new ViewTransition(context, xml));
                            transition = transition2;
                            break;
                        default:
                            transition = transition2;
                            break;
                    }
                } else {
                    transition = transition2;
                }
                eventType = xml.next();
                transition2 = transition;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (XmlPullParserException e2) {
            e2.printStackTrace();
        }
    }

    private void a(Context context, XmlPullParser xmlPullParser) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), R.styleable.MotionScene);
        int indexCount = obtainStyledAttributes.getIndexCount();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= indexCount) {
                obtainStyledAttributes.recycle();
                return;
            }
            int index = obtainStyledAttributes.getIndex(i2);
            if (index == R.styleable.MotionScene_defaultDuration) {
                int i3 = obtainStyledAttributes.getInt(index, this.o);
                this.o = i3;
                if (i3 < 8) {
                    this.o = 8;
                }
            } else if (index == R.styleable.MotionScene_layoutDuringTransition) {
                this.p = obtainStyledAttributes.getInteger(index, 0);
            }
            i = i2 + 1;
        }
    }

    private int b(int i) {
        int stateGetConstraintID;
        StateSet stateSet = this.f2204a;
        return (stateSet == null || (stateGetConstraintID = stateSet.stateGetConstraintID(i, -1, -1)) == -1) ? i : stateGetConstraintID;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int b(Context context, int i) {
        XmlResourceParser xml = context.getResources().getXml(i);
        try {
            for (int eventType = xml.getEventType(); eventType != 1; eventType = xml.next()) {
                String name = xml.getName();
                if (2 == eventType && "ConstraintSet".equals(name)) {
                    return c(context, xml);
                }
            }
            return -1;
        } catch (IOException e) {
            e.printStackTrace();
            return -1;
        } catch (XmlPullParserException e2) {
            e2.printStackTrace();
            return -1;
        }
    }

    private void b(Context context, XmlPullParser xmlPullParser) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), R.styleable.include);
        int indexCount = obtainStyledAttributes.getIndexCount();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= indexCount) {
                obtainStyledAttributes.recycle();
                return;
            }
            int index = obtainStyledAttributes.getIndex(i2);
            if (index == R.styleable.include_constraintSet) {
                b(context, obtainStyledAttributes.getResourceId(index, -1));
            }
            i = i2 + 1;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private int c(Context context, XmlPullParser xmlPullParser) {
        boolean z;
        boolean z2;
        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.setForceId(false);
        int attributeCount = xmlPullParser.getAttributeCount();
        int i = -1;
        int i2 = -1;
        for (int i3 = 0; i3 < attributeCount; i3++) {
            String attributeName = xmlPullParser.getAttributeName(i3);
            String attributeValue = xmlPullParser.getAttributeValue(i3);
            if (this.n) {
                System.out.println("id string = " + attributeValue);
            }
            int hashCode = attributeName.hashCode();
            if (hashCode == -1496482599) {
                if (attributeName.equals("deriveConstraintsFrom")) {
                    z = true;
                }
                z = true;
            } else if (hashCode != -1153153640) {
                if (hashCode == 3355 && attributeName.equals("id")) {
                    z = false;
                }
                z = true;
            } else {
                if (attributeName.equals("constraintRotate")) {
                    z = true;
                }
                z = true;
            }
            if (!z) {
                i = a(context, attributeValue);
                this.l.put(stripID(attributeValue), Integer.valueOf(i));
                constraintSet.mIdString = Debug.getName(context, i);
            } else if (z) {
                i2 = a(context, attributeValue);
            } else if (z) {
                try {
                    constraintSet.mRotate = Integer.parseInt(attributeValue);
                } catch (NumberFormatException e) {
                    switch (attributeValue.hashCode()) {
                        case -768416914:
                            if (attributeValue.equals("x_left")) {
                                z2 = true;
                                break;
                            }
                            z2 = true;
                            break;
                        case 3317767:
                            if (attributeValue.equals("left")) {
                                z2 = true;
                                break;
                            }
                            z2 = true;
                            break;
                        case 3387192:
                            if (attributeValue.equals("none")) {
                                z2 = false;
                                break;
                            }
                            z2 = true;
                            break;
                        case 108511772:
                            if (attributeValue.equals("right")) {
                                z2 = true;
                                break;
                            }
                            z2 = true;
                            break;
                        case 1954540437:
                            if (attributeValue.equals("x_right")) {
                                z2 = true;
                                break;
                            }
                            z2 = true;
                            break;
                        default:
                            z2 = true;
                            break;
                    }
                    if (!z2) {
                        constraintSet.mRotate = 0;
                    } else if (z2) {
                        constraintSet.mRotate = 1;
                    } else if (z2) {
                        constraintSet.mRotate = 2;
                    } else if (z2) {
                        constraintSet.mRotate = 3;
                    } else if (z2) {
                        constraintSet.mRotate = 4;
                    }
                }
            }
        }
        if (i != -1) {
            if (this.f.l != 0) {
                constraintSet.setValidateOnParse(true);
            }
            constraintSet.load(context, xmlPullParser);
            if (i2 != -1) {
                this.m.put(i, i2);
            }
            this.k.put(i, constraintSet);
        }
        return i;
    }

    private boolean c(int i) {
        int i2 = this.m.get(i);
        int size = this.m.size();
        while (true) {
            int i3 = size;
            if (i2 <= 0) {
                return false;
            }
            if (i2 == i || i3 < 0) {
                return true;
            }
            i2 = this.m.get(i2);
            size = i3 - 1;
        }
    }

    private boolean n() {
        return this.t != null;
    }

    public static String stripID(String str) {
        if (str == null) {
            return "";
        }
        int indexOf = str.indexOf(47);
        return indexOf < 0 ? str : str.substring(indexOf + 1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Key a(Context context, int i, int i2, int i3) {
        Transition transition = this.b;
        if (transition == null) {
            return null;
        }
        Iterator it = transition.k.iterator();
        while (it.hasNext()) {
            KeyFrames keyFrames = (KeyFrames) it.next();
            for (Integer num : keyFrames.getKeys()) {
                if (i2 == num.intValue()) {
                    Iterator<Key> it2 = keyFrames.getKeyFramesForView(num.intValue()).iterator();
                    while (it2.hasNext()) {
                        Key next = it2.next();
                        if (next.f2169a == i3 && next.d == i) {
                            return next;
                        }
                    }
                    continue;
                }
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ConstraintSet a(int i) {
        return a(i, -1, -1);
    }

    ConstraintSet a(int i, int i2, int i3) {
        if (this.n) {
            PrintStream printStream = System.out;
            printStream.println("id " + i);
            PrintStream printStream2 = System.out;
            printStream2.println("size " + this.k.size());
        }
        StateSet stateSet = this.f2204a;
        int i4 = i;
        if (stateSet != null) {
            int stateGetConstraintID = stateSet.stateGetConstraintID(i, i2, i3);
            i4 = i;
            if (stateGetConstraintID != -1) {
                i4 = stateGetConstraintID;
            }
        }
        if (this.k.get(i4) == null) {
            Log.e(TypedValues.MotionScene.NAME, "Warning could not find ConstraintSet id/" + Debug.getName(this.f.getContext(), i4) + " In MotionScene");
            SparseArray<ConstraintSet> sparseArray = this.k;
            return sparseArray.get(sparseArray.keyAt(0));
        }
        return this.k.get(i4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(float f, float f2) {
        Transition transition = this.b;
        if (transition == null || transition.l == null) {
            return;
        }
        this.b.l.e(f, f2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0030, code lost:
        if (r10 != (-1)) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(int r6, int r7) {
        /*
            Method dump skipped, instructions count: 299
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.motion.widget.MotionScene.a(int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(MotionEvent motionEvent, int i, MotionLayout motionLayout) {
        MotionLayout.MotionTracker motionTracker;
        MotionEvent motionEvent2;
        RectF rectF = new RectF();
        if (this.t == null) {
            this.t = this.f.a();
        }
        this.t.addMovement(motionEvent);
        if (i != -1) {
            int action = motionEvent.getAction();
            if (action == 0) {
                this.d = motionEvent.getRawX();
                this.e = motionEvent.getRawY();
                this.q = motionEvent;
                this.r = false;
                if (this.b.l != null) {
                    RectF b = this.b.l.b(this.f, rectF);
                    if (b != null && !b.contains(this.q.getX(), this.q.getY())) {
                        this.q = null;
                        this.r = true;
                        return;
                    }
                    RectF a2 = this.b.l.a(this.f, rectF);
                    if (a2 == null || a2.contains(this.q.getX(), this.q.getY())) {
                        this.s = false;
                    } else {
                        this.s = true;
                    }
                    this.b.l.b(this.d, this.e);
                    return;
                }
                return;
            } else if (action == 2 && !this.r) {
                float rawY = motionEvent.getRawY() - this.e;
                float rawX = motionEvent.getRawX() - this.d;
                if ((rawX == 0.0d && rawY == 0.0d) || (motionEvent2 = this.q) == null) {
                    return;
                }
                Transition bestTransitionFor = bestTransitionFor(i, rawX, rawY, motionEvent2);
                if (bestTransitionFor != null) {
                    motionLayout.setTransition(bestTransitionFor);
                    RectF a3 = this.b.l.a(this.f, rectF);
                    boolean z = false;
                    if (a3 != null) {
                        z = false;
                        if (!a3.contains(this.q.getX(), this.q.getY())) {
                            z = true;
                        }
                    }
                    this.s = z;
                    this.b.l.a(this.d, this.e);
                }
            }
        }
        if (this.r) {
            return;
        }
        Transition transition = this.b;
        if (transition != null && transition.l != null && !this.s) {
            this.b.l.b(motionEvent, this.t, i, this);
        }
        this.d = motionEvent.getRawX();
        this.e = motionEvent.getRawY();
        if (motionEvent.getAction() != 1 || (motionTracker = this.t) == null) {
            return;
        }
        motionTracker.recycle();
        this.t = null;
        if (motionLayout.e != -1) {
            a(motionLayout, motionLayout.e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(MotionLayout motionLayout) {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.k.size()) {
                return;
            }
            int keyAt = this.k.keyAt(i2);
            if (c(keyAt)) {
                Log.e(TypedValues.MotionScene.NAME, "Cannot be derived from yourself");
                return;
            } else {
                a(keyAt, motionLayout);
                i = i2 + 1;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a() {
        Iterator<Transition> it = this.h.iterator();
        while (it.hasNext()) {
            if (it.next().l != null) {
                return true;
            }
        }
        Transition transition = this.b;
        return (transition == null || transition.l == null) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(View view, int i) {
        Transition transition = this.b;
        if (transition == null) {
            return false;
        }
        Iterator it = transition.k.iterator();
        while (it.hasNext()) {
            Iterator<Key> it2 = ((KeyFrames) it.next()).getKeyFramesForView(view.getId()).iterator();
            while (it2.hasNext()) {
                if (it2.next().f2169a == i) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(MotionLayout motionLayout, int i) {
        Transition transition;
        if (n() || this.g) {
            return false;
        }
        Iterator<Transition> it = this.h.iterator();
        while (it.hasNext()) {
            Transition next = it.next();
            if (next.n != 0 && ((transition = this.b) != next || !transition.isTransitionFlag(2))) {
                if (i == next.d && (next.n == 4 || next.n == 2)) {
                    motionLayout.setState(MotionLayout.TransitionState.FINISHED);
                    motionLayout.setTransition(next);
                    if (next.n == 4) {
                        motionLayout.transitionToEnd();
                        motionLayout.setState(MotionLayout.TransitionState.SETUP);
                        motionLayout.setState(MotionLayout.TransitionState.MOVING);
                        return true;
                    }
                    motionLayout.setProgress(1.0f);
                    motionLayout.b(true);
                    motionLayout.setState(MotionLayout.TransitionState.SETUP);
                    motionLayout.setState(MotionLayout.TransitionState.MOVING);
                    motionLayout.setState(MotionLayout.TransitionState.FINISHED);
                    motionLayout.b();
                    return true;
                } else if (i == next.f2208c && (next.n == 3 || next.n == 1)) {
                    motionLayout.setState(MotionLayout.TransitionState.FINISHED);
                    motionLayout.setTransition(next);
                    if (next.n == 3) {
                        motionLayout.transitionToStart();
                        motionLayout.setState(MotionLayout.TransitionState.SETUP);
                        motionLayout.setState(MotionLayout.TransitionState.MOVING);
                        return true;
                    }
                    motionLayout.setProgress(0.0f);
                    motionLayout.b(true);
                    motionLayout.setState(MotionLayout.TransitionState.SETUP);
                    motionLayout.setState(MotionLayout.TransitionState.MOVING);
                    motionLayout.setState(MotionLayout.TransitionState.FINISHED);
                    motionLayout.b();
                    return true;
                }
            }
        }
        return false;
    }

    public void addOnClickListeners(MotionLayout motionLayout, int i) {
        Iterator<Transition> it = this.h.iterator();
        while (it.hasNext()) {
            Transition next = it.next();
            if (next.m.size() > 0) {
                Iterator it2 = next.m.iterator();
                while (it2.hasNext()) {
                    ((Transition.TransitionOnClick) it2.next()).removeOnClickListeners(motionLayout);
                }
            }
        }
        Iterator<Transition> it3 = this.j.iterator();
        while (it3.hasNext()) {
            Transition next2 = it3.next();
            if (next2.m.size() > 0) {
                Iterator it4 = next2.m.iterator();
                while (it4.hasNext()) {
                    ((Transition.TransitionOnClick) it4.next()).removeOnClickListeners(motionLayout);
                }
            }
        }
        Iterator<Transition> it5 = this.h.iterator();
        while (it5.hasNext()) {
            Transition next3 = it5.next();
            if (next3.m.size() > 0) {
                Iterator it6 = next3.m.iterator();
                while (it6.hasNext()) {
                    ((Transition.TransitionOnClick) it6.next()).addOnClickListeners(motionLayout, i, next3);
                }
            }
        }
        Iterator<Transition> it7 = this.j.iterator();
        while (it7.hasNext()) {
            Transition next4 = it7.next();
            if (next4.m.size() > 0) {
                Iterator it8 = next4.m.iterator();
                while (it8.hasNext()) {
                    ((Transition.TransitionOnClick) it8.next()).addOnClickListeners(motionLayout, i, next4);
                }
            }
        }
    }

    public void addTransition(Transition transition) {
        int a2 = a(transition);
        if (a2 == -1) {
            this.h.add(transition);
        } else {
            this.h.set(a2, transition);
        }
    }

    public boolean applyViewTransition(int i, MotionController motionController) {
        return this.f2205c.a(i, motionController);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int b() {
        Transition transition = this.b;
        if (transition == null) {
            return -1;
        }
        return transition.d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(float f, float f2) {
        Transition transition = this.b;
        if (transition == null || transition.l == null) {
            return;
        }
        this.b.l.d(f, f2);
    }

    public Transition bestTransitionFor(int i, float f, float f2, MotionEvent motionEvent) {
        float x;
        float y;
        if (i != -1) {
            List<Transition> transitionsWithState = getTransitionsWithState(i);
            float f3 = 0.0f;
            Transition transition = null;
            RectF rectF = new RectF();
            for (Transition transition2 : transitionsWithState) {
                if (!transition2.o && transition2.l != null) {
                    transition2.l.setRTL(this.u);
                    RectF a2 = transition2.l.a(this.f, rectF);
                    if (a2 == null || motionEvent == null || a2.contains(motionEvent.getX(), motionEvent.getY())) {
                        RectF b = transition2.l.b(this.f, rectF);
                        if (b == null || motionEvent == null || b.contains(motionEvent.getX(), motionEvent.getY())) {
                            float f4 = transition2.l.f(f, f2);
                            float f5 = f4;
                            if (transition2.l.f2214c) {
                                f5 = f4;
                                if (motionEvent != null) {
                                    f5 = ((float) (Math.atan2(f2 + y, f + x) - Math.atan2(motionEvent.getX() - transition2.l.f2213a, motionEvent.getY() - transition2.l.b))) * 10.0f;
                                }
                            }
                            float f6 = f5 * (transition2.f2208c == i ? -1.0f : 1.1f);
                            if (f6 > f3) {
                                transition = transition2;
                                f3 = f6;
                            }
                        }
                    }
                }
            }
            return transition;
        }
        return this.b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float c(float f, float f2) {
        Transition transition = this.b;
        if (transition == null || transition.l == null) {
            return 0.0f;
        }
        return this.b.l.c(f, f2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int c() {
        Transition transition = this.b;
        if (transition == null) {
            return -1;
        }
        return transition.f2208c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float d() {
        Transition transition = this.b;
        if (transition == null || transition.l == null) {
            return 0.0f;
        }
        return this.b.l.b();
    }

    public void disableAutoTransition(boolean z) {
        this.g = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float e() {
        Transition transition = this.b;
        if (transition == null || transition.l == null) {
            return 0.0f;
        }
        return this.b.l.getMaxVelocity();
    }

    public void enableViewTransition(int i, boolean z) {
        this.f2205c.a(i, z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float f() {
        Transition transition = this.b;
        if (transition == null || transition.l == null) {
            return 0.0f;
        }
        return this.b.l.getSpringStiffness();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float g() {
        Transition transition = this.b;
        if (transition == null || transition.l == null) {
            return 0.0f;
        }
        return this.b.l.getSpringMass();
    }

    public int gatPathMotionArc() {
        Transition transition = this.b;
        if (transition != null) {
            return transition.p;
        }
        return -1;
    }

    public ConstraintSet getConstraintSet(Context context, String str) {
        if (this.n) {
            PrintStream printStream = System.out;
            printStream.println("id " + str);
            PrintStream printStream2 = System.out;
            printStream2.println("size " + this.k.size());
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.k.size()) {
                return null;
            }
            int keyAt = this.k.keyAt(i2);
            String resourceName = context.getResources().getResourceName(keyAt);
            if (this.n) {
                PrintStream printStream3 = System.out;
                printStream3.println("Id for <" + i2 + "> is <" + resourceName + "> looking for <" + str + SimpleComparison.GREATER_THAN_OPERATION);
            }
            if (str.equals(resourceName)) {
                return this.k.get(keyAt);
            }
            i = i2 + 1;
        }
    }

    public int[] getConstraintSetIds() {
        int size = this.k.size();
        int[] iArr = new int[size];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                return iArr;
            }
            iArr[i2] = this.k.keyAt(i2);
            i = i2 + 1;
        }
    }

    public ArrayList<Transition> getDefinedTransitions() {
        return this.h;
    }

    public int getDuration() {
        Transition transition = this.b;
        return transition != null ? transition.h : this.o;
    }

    public Interpolator getInterpolator() {
        int i = this.b.e;
        if (i != -2) {
            if (i == -1) {
                final Easing interpolator = Easing.getInterpolator(this.b.f);
                return new Interpolator() { // from class: androidx.constraintlayout.motion.widget.MotionScene.1
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
        return AnimationUtils.loadInterpolator(this.f.getContext(), this.b.g);
    }

    public void getKeyFrames(MotionController motionController) {
        Transition transition = this.b;
        if (transition != null) {
            Iterator it = transition.k.iterator();
            while (it.hasNext()) {
                ((KeyFrames) it.next()).addFrames(motionController);
            }
            return;
        }
        Transition transition2 = this.i;
        if (transition2 != null) {
            Iterator it2 = transition2.k.iterator();
            while (it2.hasNext()) {
                ((KeyFrames) it2.next()).addFrames(motionController);
            }
        }
    }

    public float getPathPercent(View view, int i) {
        return 0.0f;
    }

    public float getStaggered() {
        Transition transition = this.b;
        if (transition != null) {
            return transition.i;
        }
        return 0.0f;
    }

    public Transition getTransitionById(int i) {
        Iterator<Transition> it = this.h.iterator();
        while (it.hasNext()) {
            Transition next = it.next();
            if (next.f2207a == i) {
                return next;
            }
        }
        return null;
    }

    public List<Transition> getTransitionsWithState(int i) {
        int b = b(i);
        ArrayList arrayList = new ArrayList();
        Iterator<Transition> it = this.h.iterator();
        while (it.hasNext()) {
            Transition next = it.next();
            if (next.d == b || next.f2208c == b) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float h() {
        Transition transition = this.b;
        if (transition == null || transition.l == null) {
            return 0.0f;
        }
        return this.b.l.getSpringDamping();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float i() {
        Transition transition = this.b;
        if (transition == null || transition.l == null) {
            return 0.0f;
        }
        return this.b.l.getSpringStopThreshold();
    }

    public boolean isViewTransitionEnabled(int i) {
        return this.f2205c.a(i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int j() {
        Transition transition = this.b;
        if (transition == null || transition.l == null) {
            return 0;
        }
        return this.b.l.getSpringBoundary();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int k() {
        Transition transition = this.b;
        if (transition == null || transition.l == null) {
            return 0;
        }
        return this.b.l.getAutoCompleteMode();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void l() {
        Transition transition = this.b;
        if (transition == null || transition.l == null) {
            return;
        }
        this.b.l.a();
    }

    public int lookUpConstraintId(String str) {
        Integer num = this.l.get(str);
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public String lookUpConstraintName(int i) {
        for (Map.Entry<String, Integer> entry : this.l.entrySet()) {
            Integer value = entry.getValue();
            if (value != null && value.intValue() == i) {
                return entry.getKey();
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean m() {
        Transition transition = this.b;
        if (transition == null || transition.l == null) {
            return false;
        }
        return this.b.l.c();
    }

    public void removeTransition(Transition transition) {
        int a2 = a(transition);
        if (a2 != -1) {
            this.h.remove(a2);
        }
    }

    public void setConstraintSet(int i, ConstraintSet constraintSet) {
        this.k.put(i, constraintSet);
    }

    public void setDuration(int i) {
        Transition transition = this.b;
        if (transition != null) {
            transition.setDuration(i);
        } else {
            this.o = i;
        }
    }

    public void setKeyframe(View view, int i, String str, Object obj) {
        Transition transition = this.b;
        if (transition == null) {
            return;
        }
        Iterator it = transition.k.iterator();
        while (it.hasNext()) {
            Iterator<Key> it2 = ((KeyFrames) it.next()).getKeyFramesForView(view.getId()).iterator();
            while (it2.hasNext()) {
                if (it2.next().f2169a == i) {
                    float floatValue = obj != null ? ((Float) obj).floatValue() : 0.0f;
                    str.equalsIgnoreCase("app:PerpendicularPath_percent");
                }
            }
        }
    }

    public void setRtl(boolean z) {
        this.u = z;
        Transition transition = this.b;
        if (transition == null || transition.l == null) {
            return;
        }
        this.b.l.setRTL(this.u);
    }

    public void setTransition(Transition transition) {
        this.b = transition;
        if (transition == null || transition.l == null) {
            return;
        }
        this.b.l.setRTL(this.u);
    }

    public boolean validateLayout(MotionLayout motionLayout) {
        return motionLayout == this.f && motionLayout.f2184a == this;
    }

    public void viewTransition(int i, View... viewArr) {
        this.f2205c.a(i, viewArr);
    }
}
