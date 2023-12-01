package androidx.constraintlayout.motion.widget;

import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintSet;
import java.io.PrintStream;
import java.util.HashMap;

/* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/motion/widget/DesignTool.class */
public class DesignTool implements ProxyInterface {

    /* renamed from: a  reason: collision with root package name */
    static final HashMap<Pair<Integer, Integer>, String> f2119a = new HashMap<>();
    static final HashMap<String, String> b = new HashMap<>();

    /* renamed from: c  reason: collision with root package name */
    private final MotionLayout f2120c;
    private MotionScene d;
    private String e = null;
    private String f = null;
    private int g = -1;
    private int h = -1;

    static {
        f2119a.put(Pair.create(4, 4), "layout_constraintBottom_toBottomOf");
        f2119a.put(Pair.create(4, 3), "layout_constraintBottom_toTopOf");
        f2119a.put(Pair.create(3, 4), "layout_constraintTop_toBottomOf");
        f2119a.put(Pair.create(3, 3), "layout_constraintTop_toTopOf");
        f2119a.put(Pair.create(6, 6), "layout_constraintStart_toStartOf");
        f2119a.put(Pair.create(6, 7), "layout_constraintStart_toEndOf");
        f2119a.put(Pair.create(7, 6), "layout_constraintEnd_toStartOf");
        f2119a.put(Pair.create(7, 7), "layout_constraintEnd_toEndOf");
        f2119a.put(Pair.create(1, 1), "layout_constraintLeft_toLeftOf");
        f2119a.put(Pair.create(1, 2), "layout_constraintLeft_toRightOf");
        f2119a.put(Pair.create(2, 2), "layout_constraintRight_toRightOf");
        f2119a.put(Pair.create(2, 1), "layout_constraintRight_toLeftOf");
        f2119a.put(Pair.create(5, 5), "layout_constraintBaseline_toBaselineOf");
        b.put("layout_constraintBottom_toBottomOf", "layout_marginBottom");
        b.put("layout_constraintBottom_toTopOf", "layout_marginBottom");
        b.put("layout_constraintTop_toBottomOf", "layout_marginTop");
        b.put("layout_constraintTop_toTopOf", "layout_marginTop");
        b.put("layout_constraintStart_toStartOf", "layout_marginStart");
        b.put("layout_constraintStart_toEndOf", "layout_marginStart");
        b.put("layout_constraintEnd_toStartOf", "layout_marginEnd");
        b.put("layout_constraintEnd_toEndOf", "layout_marginEnd");
        b.put("layout_constraintLeft_toLeftOf", "layout_marginLeft");
        b.put("layout_constraintLeft_toRightOf", "layout_marginLeft");
        b.put("layout_constraintRight_toRightOf", "layout_marginRight");
        b.put("layout_constraintRight_toLeftOf", "layout_marginRight");
    }

    public DesignTool(MotionLayout motionLayout) {
        this.f2120c = motionLayout;
    }

    private static int a(int i, String str) {
        int indexOf;
        if (str == null || (indexOf = str.indexOf(100)) == -1) {
            return 0;
        }
        return (int) ((Integer.valueOf(str.substring(0, indexOf)).intValue() * i) / 160.0f);
    }

    private static void a(int i, ConstraintSet constraintSet, View view, HashMap<String, String> hashMap) {
        String str = hashMap.get("layout_editor_absoluteX");
        if (str != null) {
            constraintSet.setEditorAbsoluteX(view.getId(), a(i, str));
        }
        String str2 = hashMap.get("layout_editor_absoluteY");
        if (str2 != null) {
            constraintSet.setEditorAbsoluteY(view.getId(), a(i, str2));
        }
    }

    private static void a(int i, ConstraintSet constraintSet, View view, HashMap<String, String> hashMap, int i2) {
        String str = hashMap.get(i2 == 1 ? "layout_height" : "layout_width");
        if (str != null) {
            int i3 = -2;
            if (!str.equalsIgnoreCase("wrap_content")) {
                i3 = a(i, str);
            }
            if (i2 == 0) {
                constraintSet.constrainWidth(view.getId(), i3);
            } else {
                constraintSet.constrainHeight(view.getId(), i3);
            }
        }
    }

    private static void a(int i, ConstraintSet constraintSet, View view, HashMap<String, String> hashMap, int i2, int i3) {
        String str = f2119a.get(Pair.create(Integer.valueOf(i2), Integer.valueOf(i3)));
        String str2 = hashMap.get(str);
        if (str2 != null) {
            String str3 = b.get(str);
            constraintSet.connect(view.getId(), i2, Integer.parseInt(str2), i3, str3 != null ? a(i, hashMap.get(str3)) : 0);
        }
    }

    private static void a(ConstraintSet constraintSet, View view, HashMap<String, String> hashMap, int i) {
        String str = hashMap.get(i == 1 ? "layout_constraintVertical_bias" : "layout_constraintHorizontal_bias");
        if (str != null) {
            if (i == 0) {
                constraintSet.setHorizontalBias(view.getId(), Float.parseFloat(str));
            } else if (i == 1) {
                constraintSet.setVerticalBias(view.getId(), Float.parseFloat(str));
            }
        }
    }

    @Override // androidx.constraintlayout.motion.widget.ProxyInterface
    public int designAccess(int i, String str, Object obj, float[] fArr, int i2, float[] fArr2, int i3) {
        MotionController motionController;
        View view = (View) obj;
        if (i == 0) {
            motionController = null;
        } else if (this.f2120c.f2136a == null || view == null) {
            return -1;
        } else {
            MotionController motionController2 = this.f2120c.f.get(view);
            motionController = motionController2;
            if (motionController2 == null) {
                return -1;
            }
        }
        if (i != 0) {
            if (i == 1) {
                int duration = this.f2120c.f2136a.getDuration() / 16;
                motionController.a(fArr2, duration);
                return duration;
            } else if (i == 2) {
                int duration2 = this.f2120c.f2136a.getDuration() / 16;
                motionController.a(fArr2, (int[]) null);
                return duration2;
            } else if (i != 3) {
                return -1;
            } else {
                int duration3 = this.f2120c.f2136a.getDuration() / 16;
                return motionController.a(str, fArr2, i3);
            }
        }
        return 1;
    }

    public void disableAutoTransition(boolean z) {
        this.f2120c.c(z);
    }

    public void dumpConstraintSet(String str) {
        if (this.f2120c.f2136a == null) {
            this.f2120c.f2136a = this.d;
        }
        int a2 = this.f2120c.a(str);
        PrintStream printStream = System.out;
        printStream.println(" dumping  " + str + " (" + a2 + ")");
        try {
            this.f2120c.f2136a.a(a2).dump(this.f2120c.f2136a, new int[0]);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int getAnimationKeyFrames(Object obj, float[] fArr) {
        if (this.f2120c.f2136a == null) {
            return -1;
        }
        int duration = this.f2120c.f2136a.getDuration() / 16;
        MotionController motionController = this.f2120c.f.get(obj);
        if (motionController == null) {
            return 0;
        }
        motionController.a(fArr, (int[]) null);
        return duration;
    }

    public int getAnimationPath(Object obj, float[] fArr, int i) {
        if (this.f2120c.f2136a == null) {
            return -1;
        }
        MotionController motionController = this.f2120c.f.get(obj);
        if (motionController == null) {
            return 0;
        }
        motionController.a(fArr, i);
        return i;
    }

    public void getAnimationRectangles(Object obj, float[] fArr) {
        if (this.f2120c.f2136a == null) {
            return;
        }
        int duration = this.f2120c.f2136a.getDuration() / 16;
        MotionController motionController = this.f2120c.f.get(obj);
        if (motionController == null) {
            return;
        }
        motionController.b(fArr, duration);
    }

    public String getEndState() {
        int endState = this.f2120c.getEndState();
        if (this.h == endState) {
            return this.f;
        }
        String b2 = this.f2120c.b(endState);
        if (b2 != null) {
            this.f = b2;
            this.h = endState;
        }
        return b2;
    }

    public int getKeyFrameInfo(Object obj, int i, int[] iArr) {
        MotionController motionController = this.f2120c.f.get((View) obj);
        if (motionController == null) {
            return 0;
        }
        return motionController.getKeyFrameInfo(i, iArr);
    }

    @Override // androidx.constraintlayout.motion.widget.ProxyInterface
    public float getKeyFramePosition(Object obj, int i, float f, float f2) {
        MotionController motionController;
        if ((obj instanceof View) && (motionController = this.f2120c.f.get((View) obj)) != null) {
            return motionController.a(i, f, f2);
        }
        return 0.0f;
    }

    public int getKeyFramePositions(Object obj, int[] iArr, float[] fArr) {
        MotionController motionController = this.f2120c.f.get((View) obj);
        if (motionController == null) {
            return 0;
        }
        return motionController.getKeyFramePositions(iArr, fArr);
    }

    public Object getKeyframe(int i, int i2, int i3) {
        if (this.f2120c.f2136a == null) {
            return null;
        }
        return this.f2120c.f2136a.a(this.f2120c.getContext(), i, i2, i3);
    }

    public Object getKeyframe(Object obj, int i, int i2) {
        if (this.f2120c.f2136a == null) {
            return null;
        }
        return this.f2120c.f2136a.a(this.f2120c.getContext(), i, ((View) obj).getId(), i2);
    }

    @Override // androidx.constraintlayout.motion.widget.ProxyInterface
    public Object getKeyframeAtLocation(Object obj, float f, float f2) {
        MotionController motionController;
        View view = (View) obj;
        if (this.f2120c.f2136a == null) {
            return -1;
        }
        if (view == null || (motionController = this.f2120c.f.get(view)) == null) {
            return null;
        }
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        return motionController.a(viewGroup.getWidth(), viewGroup.getHeight(), f, f2);
    }

    @Override // androidx.constraintlayout.motion.widget.ProxyInterface
    public Boolean getPositionKeyframe(Object obj, Object obj2, float f, float f2, String[] strArr, float[] fArr) {
        if (obj instanceof KeyPositionBase) {
            View view = (View) obj2;
            this.f2120c.f.get(view).a(view, (KeyPositionBase) obj, f, f2, strArr, fArr);
            this.f2120c.rebuildScene();
            this.f2120c.j = true;
            return true;
        }
        return false;
    }

    public float getProgress() {
        return this.f2120c.getProgress();
    }

    public String getStartState() {
        int startState = this.f2120c.getStartState();
        if (this.g == startState) {
            return this.e;
        }
        String b2 = this.f2120c.b(startState);
        if (b2 != null) {
            this.e = b2;
            this.g = startState;
        }
        return this.f2120c.b(startState);
    }

    public String getState() {
        if (this.e != null && this.f != null) {
            float progress = getProgress();
            if (progress <= 0.01f) {
                return this.e;
            }
            if (progress >= 0.99f) {
                return this.f;
            }
        }
        return this.e;
    }

    @Override // androidx.constraintlayout.motion.widget.ProxyInterface
    public long getTransitionTimeMs() {
        return this.f2120c.getTransitionTimeMs();
    }

    public boolean isInTransition() {
        return (this.e == null || this.f == null) ? false : true;
    }

    @Override // androidx.constraintlayout.motion.widget.ProxyInterface
    public void setAttributes(int i, String str, Object obj, Object obj2) {
        View view = (View) obj;
        HashMap hashMap = (HashMap) obj2;
        int a2 = this.f2120c.a(str);
        ConstraintSet a3 = this.f2120c.f2136a.a(a2);
        if (a3 == null) {
            return;
        }
        a3.clear(view.getId());
        a(i, a3, view, hashMap, 0);
        a(i, a3, view, hashMap, 1);
        a(i, a3, view, hashMap, 6, 6);
        a(i, a3, view, hashMap, 6, 7);
        a(i, a3, view, hashMap, 7, 7);
        a(i, a3, view, hashMap, 7, 6);
        a(i, a3, view, hashMap, 1, 1);
        a(i, a3, view, hashMap, 1, 2);
        a(i, a3, view, hashMap, 2, 2);
        a(i, a3, view, hashMap, 2, 1);
        a(i, a3, view, hashMap, 3, 3);
        a(i, a3, view, hashMap, 3, 4);
        a(i, a3, view, hashMap, 4, 3);
        a(i, a3, view, hashMap, 4, 4);
        a(i, a3, view, hashMap, 5, 5);
        a(a3, view, hashMap, 0);
        a(a3, view, hashMap, 1);
        a(i, a3, view, hashMap);
        this.f2120c.updateState(a2, a3);
        this.f2120c.requestLayout();
    }

    @Override // androidx.constraintlayout.motion.widget.ProxyInterface
    public void setKeyFrame(Object obj, int i, String str, Object obj2) {
        if (this.f2120c.f2136a != null) {
            this.f2120c.f2136a.setKeyframe((View) obj, i, str, obj2);
            this.f2120c.i = i / 100.0f;
            this.f2120c.h = 0.0f;
            this.f2120c.rebuildScene();
            this.f2120c.b(true);
        }
    }

    @Override // androidx.constraintlayout.motion.widget.ProxyInterface
    public boolean setKeyFramePosition(Object obj, int i, int i2, float f, float f2) {
        if ((obj instanceof View) && this.f2120c.f2136a != null) {
            MotionController motionController = this.f2120c.f.get(obj);
            int i3 = (int) (this.f2120c.g * 100.0f);
            if (motionController != null) {
                View view = (View) obj;
                if (this.f2120c.f2136a.a(view, i3)) {
                    float a2 = motionController.a(2, f, f2);
                    float a3 = motionController.a(5, f, f2);
                    this.f2120c.f2136a.setKeyframe(view, i3, "motion:percentX", Float.valueOf(a2));
                    this.f2120c.f2136a.setKeyframe(view, i3, "motion:percentY", Float.valueOf(a3));
                    this.f2120c.rebuildScene();
                    this.f2120c.b(true);
                    this.f2120c.invalidate();
                    return true;
                }
                return false;
            }
            return false;
        }
        return false;
    }

    public void setKeyframe(Object obj, String str, Object obj2) {
        if (obj instanceof Key) {
            ((Key) obj).setValue(str, obj2);
            this.f2120c.rebuildScene();
            this.f2120c.j = true;
        }
    }

    public void setState(String str) {
        String str2 = str;
        if (str == null) {
            str2 = "motion_base";
        }
        if (this.e == str2) {
            return;
        }
        this.e = str2;
        this.f = null;
        if (this.f2120c.f2136a == null) {
            this.f2120c.f2136a = this.d;
        }
        int a2 = this.f2120c.a(str2);
        this.g = a2;
        if (a2 != 0) {
            if (a2 == this.f2120c.getStartState()) {
                this.f2120c.setProgress(0.0f);
            } else if (a2 == this.f2120c.getEndState()) {
                this.f2120c.setProgress(1.0f);
            } else {
                this.f2120c.transitionToState(a2);
                this.f2120c.setProgress(1.0f);
            }
        }
        this.f2120c.requestLayout();
    }

    @Override // androidx.constraintlayout.motion.widget.ProxyInterface
    public void setToolPosition(float f) {
        if (this.f2120c.f2136a == null) {
            this.f2120c.f2136a = this.d;
        }
        this.f2120c.setProgress(f);
        this.f2120c.b(true);
        this.f2120c.requestLayout();
        this.f2120c.invalidate();
    }

    public void setTransition(String str, String str2) {
        if (this.f2120c.f2136a == null) {
            this.f2120c.f2136a = this.d;
        }
        int a2 = this.f2120c.a(str);
        int a3 = this.f2120c.a(str2);
        this.f2120c.setTransition(a2, a3);
        this.g = a2;
        this.h = a3;
        this.e = str;
        this.f = str2;
    }

    public void setViewDebug(Object obj, int i) {
        MotionController motionController;
        if ((obj instanceof View) && (motionController = this.f2120c.f.get(obj)) != null) {
            motionController.setDrawPath(i);
            this.f2120c.invalidate();
        }
    }
}
