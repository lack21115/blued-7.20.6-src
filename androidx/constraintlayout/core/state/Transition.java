package androidx.constraintlayout.core.state;

import androidx.constraintlayout.core.motion.Motion;
import androidx.constraintlayout.core.motion.MotionWidget;
import androidx.constraintlayout.core.motion.key.MotionKeyAttributes;
import androidx.constraintlayout.core.motion.key.MotionKeyCycle;
import androidx.constraintlayout.core.motion.key.MotionKeyPosition;
import androidx.constraintlayout.core.motion.utils.Easing;
import androidx.constraintlayout.core.motion.utils.KeyCache;
import androidx.constraintlayout.core.motion.utils.TypedBundle;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.ConstraintWidgetContainer;
import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/core/state/Transition.class */
public class Transition implements TypedValues {
    public static final int END = 1;
    public static final int INTERPOLATED = 2;
    public static final int START = 0;

    /* renamed from: a  reason: collision with root package name */
    HashMap<Integer, HashMap<String, KeyPosition>> f2101a = new HashMap<>();

    /* renamed from: c  reason: collision with root package name */
    private HashMap<String, WidgetState> f2102c = new HashMap<>();
    TypedBundle b = new TypedBundle();
    private int d = 0;
    private String e = null;
    private Easing f = null;
    private int g = 0;
    private int h = 400;
    private float i = 0.0f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/core/state/Transition$KeyPosition.class */
    public static class KeyPosition {

        /* renamed from: a  reason: collision with root package name */
        int f2103a;
        String b;

        /* renamed from: c  reason: collision with root package name */
        int f2104c;
        float d;
        float e;

        public KeyPosition(String str, int i, int i2, float f, float f2) {
            this.b = str;
            this.f2103a = i;
            this.f2104c = i2;
            this.d = f;
            this.e = f2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/core/state/Transition$WidgetState.class */
    public static class WidgetState {
        Motion d;
        KeyCache h = new KeyCache();
        int i = -1;
        int j = -1;

        /* renamed from: a  reason: collision with root package name */
        WidgetFrame f2105a = new WidgetFrame();
        WidgetFrame b = new WidgetFrame();

        /* renamed from: c  reason: collision with root package name */
        WidgetFrame f2106c = new WidgetFrame();
        MotionWidget e = new MotionWidget(this.f2105a);
        MotionWidget f = new MotionWidget(this.b);
        MotionWidget g = new MotionWidget(this.f2106c);

        public WidgetState() {
            Motion motion = new Motion(this.e);
            this.d = motion;
            motion.setStart(this.e);
            this.d.setEnd(this.f);
        }

        public WidgetFrame getFrame(int i) {
            return i == 0 ? this.f2105a : i == 1 ? this.b : this.f2106c;
        }

        public void interpolate(int i, int i2, float f, Transition transition) {
            this.i = i2;
            this.j = i;
            this.d.setup(i, i2, 1.0f, System.nanoTime());
            WidgetFrame.interpolate(i, i2, this.f2106c, this.f2105a, this.b, transition, f);
            this.f2106c.interpolatedPos = f;
            this.d.interpolate(this.g, f, System.nanoTime(), this.h);
        }

        public void setKeyAttribute(TypedBundle typedBundle) {
            MotionKeyAttributes motionKeyAttributes = new MotionKeyAttributes();
            typedBundle.applyDelta(motionKeyAttributes);
            this.d.addKey(motionKeyAttributes);
        }

        public void setKeyCycle(TypedBundle typedBundle) {
            MotionKeyCycle motionKeyCycle = new MotionKeyCycle();
            typedBundle.applyDelta(motionKeyCycle);
            this.d.addKey(motionKeyCycle);
        }

        public void setKeyPosition(TypedBundle typedBundle) {
            MotionKeyPosition motionKeyPosition = new MotionKeyPosition();
            typedBundle.applyDelta(motionKeyPosition);
            this.d.addKey(motionKeyPosition);
        }

        public void update(ConstraintWidget constraintWidget, int i) {
            if (i == 0) {
                this.f2105a.update(constraintWidget);
                this.d.setStart(this.e);
            } else if (i == 1) {
                this.b.update(constraintWidget);
                this.d.setEnd(this.f);
            }
            this.j = -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ float a(float f) {
        return (float) Easing.getInterpolator("spline(0.0, 0.2, 0.4, 0.6, 0.8 ,1.0, 0.8, 1.0, 0.9, 1.0)").get(f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ float a(String str, float f) {
        return (float) Easing.getInterpolator(str).get(f);
    }

    private WidgetState a(String str, ConstraintWidget constraintWidget, int i) {
        WidgetState widgetState = this.f2102c.get(str);
        WidgetState widgetState2 = widgetState;
        if (widgetState == null) {
            WidgetState widgetState3 = new WidgetState();
            this.b.applyDelta(widgetState3.d);
            this.f2102c.put(str, widgetState3);
            widgetState2 = widgetState3;
            if (constraintWidget != null) {
                widgetState3.update(constraintWidget, i);
                widgetState2 = widgetState3;
            }
        }
        return widgetState2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ float b(float f) {
        return (float) Easing.getInterpolator("overshoot").get(f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ float c(float f) {
        return (float) Easing.getInterpolator("anticipate").get(f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ float d(float f) {
        return (float) Easing.getInterpolator("linear").get(f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ float e(float f) {
        return (float) Easing.getInterpolator("decelerate").get(f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ float f(float f) {
        return (float) Easing.getInterpolator("accelerate").get(f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ float g(float f) {
        return (float) Easing.getInterpolator("standard").get(f);
    }

    public static Interpolator getInterpolator(int i, final String str) {
        switch (i) {
            case -1:
                return new Interpolator() { // from class: androidx.constraintlayout.core.state.-$$Lambda$Transition$wu1BNSsB2UHSDW6Psh-R5PC-XJo
                    @Override // androidx.constraintlayout.core.state.Interpolator
                    public final float getInterpolation(float f) {
                        float a2;
                        a2 = Transition.a(String.this, f);
                        return a2;
                    }
                };
            case 0:
                return new Interpolator() { // from class: androidx.constraintlayout.core.state.-$$Lambda$Transition$AvFmUZ93isvSevYgmPuGO_cbDp8
                    @Override // androidx.constraintlayout.core.state.Interpolator
                    public final float getInterpolation(float f) {
                        float g;
                        g = Transition.g(f);
                        return g;
                    }
                };
            case 1:
                return new Interpolator() { // from class: androidx.constraintlayout.core.state.-$$Lambda$Transition$9rPrNyyEVWlY-osQ1P8Hxr_L6EA
                    @Override // androidx.constraintlayout.core.state.Interpolator
                    public final float getInterpolation(float f) {
                        float f2;
                        f2 = Transition.f(f);
                        return f2;
                    }
                };
            case 2:
                return new Interpolator() { // from class: androidx.constraintlayout.core.state.-$$Lambda$Transition$zX8g7QXzYB53q-aBm3xUNXUWD1o
                    @Override // androidx.constraintlayout.core.state.Interpolator
                    public final float getInterpolation(float f) {
                        float e;
                        e = Transition.e(f);
                        return e;
                    }
                };
            case 3:
                return new Interpolator() { // from class: androidx.constraintlayout.core.state.-$$Lambda$Transition$PE6dGn9tp9lBqsgjVP1uDJ3T_iw
                    @Override // androidx.constraintlayout.core.state.Interpolator
                    public final float getInterpolation(float f) {
                        float d;
                        d = Transition.d(f);
                        return d;
                    }
                };
            case 4:
                return new Interpolator() { // from class: androidx.constraintlayout.core.state.-$$Lambda$Transition$FUbxOijb-PKNRTrxSHOl6TdXFus
                    @Override // androidx.constraintlayout.core.state.Interpolator
                    public final float getInterpolation(float f) {
                        float a2;
                        a2 = Transition.a(f);
                        return a2;
                    }
                };
            case 5:
                return new Interpolator() { // from class: androidx.constraintlayout.core.state.-$$Lambda$Transition$a_nluF8GlLCGKZTXHif2wS1ByoE
                    @Override // androidx.constraintlayout.core.state.Interpolator
                    public final float getInterpolation(float f) {
                        float b;
                        b = Transition.b(f);
                        return b;
                    }
                };
            case 6:
                return new Interpolator() { // from class: androidx.constraintlayout.core.state.-$$Lambda$Transition$4_NTMrFJm_-hWprVWZnPraa_9-M
                    @Override // androidx.constraintlayout.core.state.Interpolator
                    public final float getInterpolation(float f) {
                        float c2;
                        c2 = Transition.c(f);
                        return c2;
                    }
                };
            default:
                return null;
        }
    }

    public void addCustomColor(int i, String str, String str2, int i2) {
        a(str, null, i).getFrame(i).addCustomColor(str2, i2);
    }

    public void addCustomFloat(int i, String str, String str2, float f) {
        a(str, null, i).getFrame(i).addCustomFloat(str2, f);
    }

    public void addKeyAttribute(String str, TypedBundle typedBundle) {
        a(str, null, 0).setKeyAttribute(typedBundle);
    }

    public void addKeyCycle(String str, TypedBundle typedBundle) {
        a(str, null, 0).setKeyCycle(typedBundle);
    }

    public void addKeyPosition(String str, int i, int i2, float f, float f2) {
        TypedBundle typedBundle = new TypedBundle();
        typedBundle.add(510, 2);
        typedBundle.add(100, i);
        typedBundle.add(506, f);
        typedBundle.add(507, f2);
        a(str, null, 0).setKeyPosition(typedBundle);
        KeyPosition keyPosition = new KeyPosition(str, i, i2, f, f2);
        HashMap<String, KeyPosition> hashMap = this.f2101a.get(Integer.valueOf(i));
        HashMap<String, KeyPosition> hashMap2 = hashMap;
        if (hashMap == null) {
            hashMap2 = new HashMap<>();
            this.f2101a.put(Integer.valueOf(i), hashMap2);
        }
        hashMap2.put(str, keyPosition);
    }

    public void addKeyPosition(String str, TypedBundle typedBundle) {
        a(str, null, 0).setKeyPosition(typedBundle);
    }

    public void clear() {
        this.f2102c.clear();
    }

    public boolean contains(String str) {
        return this.f2102c.containsKey(str);
    }

    public void fillKeyPositions(WidgetFrame widgetFrame, float[] fArr, float[] fArr2, float[] fArr3) {
        int i = 0;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i > 100) {
                return;
            }
            HashMap<String, KeyPosition> hashMap = this.f2101a.get(Integer.valueOf(i));
            int i4 = i3;
            if (hashMap != null) {
                KeyPosition keyPosition = hashMap.get(widgetFrame.widget.stringId);
                i4 = i3;
                if (keyPosition != null) {
                    fArr[i3] = keyPosition.d;
                    fArr2[i3] = keyPosition.e;
                    fArr3[i3] = keyPosition.f2103a;
                    i4 = i3 + 1;
                }
            }
            i++;
            i2 = i4;
        }
    }

    public KeyPosition findNextPosition(String str, int i) {
        KeyPosition keyPosition;
        while (i <= 100) {
            HashMap<String, KeyPosition> hashMap = this.f2101a.get(Integer.valueOf(i));
            if (hashMap != null && (keyPosition = hashMap.get(str)) != null) {
                return keyPosition;
            }
            i++;
        }
        return null;
    }

    public KeyPosition findPreviousPosition(String str, int i) {
        KeyPosition keyPosition;
        while (i >= 0) {
            HashMap<String, KeyPosition> hashMap = this.f2101a.get(Integer.valueOf(i));
            if (hashMap != null && (keyPosition = hashMap.get(str)) != null) {
                return keyPosition;
            }
            i--;
        }
        return null;
    }

    public int getAutoTransition() {
        return this.g;
    }

    public WidgetFrame getEnd(ConstraintWidget constraintWidget) {
        return a(constraintWidget.stringId, null, 1).b;
    }

    public WidgetFrame getEnd(String str) {
        WidgetState widgetState = this.f2102c.get(str);
        if (widgetState == null) {
            return null;
        }
        return widgetState.b;
    }

    @Override // androidx.constraintlayout.core.motion.utils.TypedValues
    public int getId(String str) {
        return 0;
    }

    public WidgetFrame getInterpolated(ConstraintWidget constraintWidget) {
        return a(constraintWidget.stringId, null, 2).f2106c;
    }

    public WidgetFrame getInterpolated(String str) {
        WidgetState widgetState = this.f2102c.get(str);
        if (widgetState == null) {
            return null;
        }
        return widgetState.f2106c;
    }

    public Interpolator getInterpolator() {
        return getInterpolator(this.d, this.e);
    }

    public int getKeyFrames(String str, float[] fArr, int[] iArr, int[] iArr2) {
        return this.f2102c.get(str).d.buildKeyFrames(fArr, iArr, iArr2);
    }

    public Motion getMotion(String str) {
        return a(str, null, 0).d;
    }

    public int getNumberKeyPositions(WidgetFrame widgetFrame) {
        int i = 0;
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i > 100) {
                return i3;
            }
            HashMap<String, KeyPosition> hashMap = this.f2101a.get(Integer.valueOf(i));
            int i4 = i3;
            if (hashMap != null) {
                i4 = i3;
                if (hashMap.get(widgetFrame.widget.stringId) != null) {
                    i4 = i3 + 1;
                }
            }
            i++;
            i2 = i4;
        }
    }

    public float[] getPath(String str) {
        float[] fArr = new float[124];
        this.f2102c.get(str).d.buildPath(fArr, 62);
        return fArr;
    }

    public WidgetFrame getStart(ConstraintWidget constraintWidget) {
        return a(constraintWidget.stringId, null, 0).f2105a;
    }

    public WidgetFrame getStart(String str) {
        WidgetState widgetState = this.f2102c.get(str);
        if (widgetState == null) {
            return null;
        }
        return widgetState.f2105a;
    }

    public boolean hasPositionKeyframes() {
        return this.f2101a.size() > 0;
    }

    public void interpolate(int i, int i2, float f) {
        Easing easing = this.f;
        float f2 = f;
        if (easing != null) {
            f2 = (float) easing.get(f);
        }
        for (String str : this.f2102c.keySet()) {
            this.f2102c.get(str).interpolate(i, i2, f2, this);
        }
    }

    public boolean isEmpty() {
        return this.f2102c.isEmpty();
    }

    public void setTransitionProperties(TypedBundle typedBundle) {
        typedBundle.applyDelta(this.b);
        typedBundle.applyDelta(this);
    }

    @Override // androidx.constraintlayout.core.motion.utils.TypedValues
    public boolean setValue(int i, float f) {
        if (i == 706) {
            this.i = f;
            return false;
        }
        return false;
    }

    @Override // androidx.constraintlayout.core.motion.utils.TypedValues
    public boolean setValue(int i, int i2) {
        return false;
    }

    @Override // androidx.constraintlayout.core.motion.utils.TypedValues
    public boolean setValue(int i, String str) {
        if (i == 705) {
            this.e = str;
            this.f = Easing.getInterpolator(str);
            return false;
        }
        return false;
    }

    @Override // androidx.constraintlayout.core.motion.utils.TypedValues
    public boolean setValue(int i, boolean z) {
        return false;
    }

    public void updateFrom(ConstraintWidgetContainer constraintWidgetContainer, int i) {
        ArrayList<ConstraintWidget> children = constraintWidgetContainer.getChildren();
        int size = children.size();
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 >= size) {
                return;
            }
            ConstraintWidget constraintWidget = children.get(i3);
            a(constraintWidget.stringId, null, i).update(constraintWidget, i);
            i2 = i3 + 1;
        }
    }
}
