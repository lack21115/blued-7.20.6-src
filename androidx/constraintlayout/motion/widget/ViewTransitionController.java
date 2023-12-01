package androidx.constraintlayout.motion.widget;

import android.graphics.Rect;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import androidx.constraintlayout.motion.widget.ViewTransition;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.constraintlayout.widget.SharedValues;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/* loaded from: source-8756600-dex2jar.jar:androidx/constraintlayout/motion/widget/ViewTransitionController.class */
public class ViewTransitionController {

    /* renamed from: a  reason: collision with root package name */
    ArrayList<ViewTransition.Animate> f2222a;

    /* renamed from: c  reason: collision with root package name */
    private final MotionLayout f2223c;
    private HashSet<View> e;
    private ArrayList<ViewTransition> d = new ArrayList<>();
    private String f = "ViewTransitionController";
    ArrayList<ViewTransition.Animate> b = new ArrayList<>();

    public ViewTransitionController(MotionLayout motionLayout) {
        this.f2223c = motionLayout;
    }

    private void a(final ViewTransition viewTransition, final boolean z) {
        final int sharedValueID = viewTransition.getSharedValueID();
        final int sharedValue = viewTransition.getSharedValue();
        ConstraintLayout.getSharedValues().addListener(viewTransition.getSharedValueID(), new SharedValues.SharedValuesListener() { // from class: androidx.constraintlayout.motion.widget.ViewTransitionController.1
            @Override // androidx.constraintlayout.widget.SharedValues.SharedValuesListener
            public void onNewValue(int i, int i2, int i3) {
                int sharedValueCurrent = viewTransition.getSharedValueCurrent();
                viewTransition.setSharedValueCurrent(i2);
                if (sharedValueID != i || sharedValueCurrent == i2) {
                    return;
                }
                if (z) {
                    if (sharedValue != i2) {
                        return;
                    }
                    int childCount = ViewTransitionController.this.f2223c.getChildCount();
                    int i4 = 0;
                    while (true) {
                        int i5 = i4;
                        if (i5 >= childCount) {
                            return;
                        }
                        View childAt = ViewTransitionController.this.f2223c.getChildAt(i5);
                        if (viewTransition.a(childAt)) {
                            int currentState = ViewTransitionController.this.f2223c.getCurrentState();
                            ConstraintSet constraintSet = ViewTransitionController.this.f2223c.getConstraintSet(currentState);
                            ViewTransition viewTransition2 = viewTransition;
                            ViewTransitionController viewTransitionController = ViewTransitionController.this;
                            viewTransition2.a(viewTransitionController, viewTransitionController.f2223c, currentState, constraintSet, childAt);
                        }
                        i4 = i5 + 1;
                    }
                } else if (sharedValue == i2) {
                } else {
                    int childCount2 = ViewTransitionController.this.f2223c.getChildCount();
                    int i6 = 0;
                    while (true) {
                        int i7 = i6;
                        if (i7 >= childCount2) {
                            return;
                        }
                        View childAt2 = ViewTransitionController.this.f2223c.getChildAt(i7);
                        if (viewTransition.a(childAt2)) {
                            int currentState2 = ViewTransitionController.this.f2223c.getCurrentState();
                            ConstraintSet constraintSet2 = ViewTransitionController.this.f2223c.getConstraintSet(currentState2);
                            ViewTransition viewTransition3 = viewTransition;
                            ViewTransitionController viewTransitionController2 = ViewTransitionController.this;
                            viewTransition3.a(viewTransitionController2, viewTransitionController2.f2223c, currentState2, constraintSet2, childAt2);
                        }
                        i6 = i7 + 1;
                    }
                }
            }
        });
    }

    private void a(ViewTransition viewTransition, View... viewArr) {
        int currentState = this.f2223c.getCurrentState();
        if (viewTransition.f2217a == 2) {
            viewTransition.a(this, this.f2223c, currentState, null, viewArr);
        } else if (currentState != -1) {
            ConstraintSet constraintSet = this.f2223c.getConstraintSet(currentState);
            if (constraintSet == null) {
                return;
            }
            viewTransition.a(this, this.f2223c, currentState, constraintSet, viewArr);
        } else {
            String str = this.f;
            Log.w(str, "No support for ViewTransition within transition yet. Currently: " + this.f2223c.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        ArrayList<ViewTransition.Animate> arrayList = this.f2222a;
        if (arrayList == null) {
            return;
        }
        Iterator<ViewTransition.Animate> it = arrayList.iterator();
        while (it.hasNext()) {
            it.next().a();
        }
        this.f2222a.removeAll(this.b);
        this.b.clear();
        if (this.f2222a.isEmpty()) {
            this.f2222a = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i, boolean z) {
        Iterator<ViewTransition> it = this.d.iterator();
        while (it.hasNext()) {
            ViewTransition next = it.next();
            if (next.a() == i) {
                next.a(z);
                return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i, View... viewArr) {
        ArrayList arrayList = new ArrayList();
        Iterator<ViewTransition> it = this.d.iterator();
        ViewTransition viewTransition = null;
        while (it.hasNext()) {
            ViewTransition next = it.next();
            if (next.a() == i) {
                int length = viewArr.length;
                int i2 = 0;
                while (true) {
                    int i3 = i2;
                    if (i3 >= length) {
                        break;
                    }
                    View view = viewArr[i3];
                    if (next.b(view)) {
                        arrayList.add(view);
                    }
                    i2 = i3 + 1;
                }
                if (!arrayList.isEmpty()) {
                    a(next, (View[]) arrayList.toArray(new View[0]));
                    arrayList.clear();
                }
                viewTransition = next;
            }
        }
        if (viewTransition == null) {
            Log.e(this.f, " Could not find ViewTransition");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(MotionEvent motionEvent) {
        int currentState = this.f2223c.getCurrentState();
        if (currentState == -1) {
            return;
        }
        if (this.e == null) {
            this.e = new HashSet<>();
            Iterator<ViewTransition> it = this.d.iterator();
            while (it.hasNext()) {
                ViewTransition next = it.next();
                int childCount = this.f2223c.getChildCount();
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < childCount) {
                        View childAt = this.f2223c.getChildAt(i2);
                        if (next.a(childAt)) {
                            childAt.getId();
                            this.e.add(childAt);
                        }
                        i = i2 + 1;
                    }
                }
            }
        }
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        Rect rect = new Rect();
        int action = motionEvent.getAction();
        ArrayList<ViewTransition.Animate> arrayList = this.f2222a;
        if (arrayList != null && !arrayList.isEmpty()) {
            Iterator<ViewTransition.Animate> it2 = this.f2222a.iterator();
            while (it2.hasNext()) {
                it2.next().reactTo(action, x, y);
            }
        }
        if (action == 0 || action == 1) {
            ConstraintSet constraintSet = this.f2223c.getConstraintSet(currentState);
            Iterator<ViewTransition> it3 = this.d.iterator();
            while (it3.hasNext()) {
                ViewTransition next2 = it3.next();
                if (next2.a(action)) {
                    Iterator<View> it4 = this.e.iterator();
                    while (it4.hasNext()) {
                        View next3 = it4.next();
                        if (next2.a(next3)) {
                            next3.getHitRect(rect);
                            if (rect.contains((int) x, (int) y)) {
                                next2.a(this, this.f2223c, currentState, constraintSet, next3);
                            }
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(ViewTransition.Animate animate) {
        if (this.f2222a == null) {
            this.f2222a = new ArrayList<>();
        }
        this.f2222a.add(animate);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(int i) {
        Iterator<ViewTransition> it = this.d.iterator();
        while (it.hasNext()) {
            ViewTransition next = it.next();
            if (next.a() == i) {
                return next.b();
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(int i, MotionController motionController) {
        Iterator<ViewTransition> it = this.d.iterator();
        while (it.hasNext()) {
            ViewTransition next = it.next();
            if (next.a() == i) {
                next.b.addAllFrames(motionController);
                return true;
            }
        }
        return false;
    }

    public void add(ViewTransition viewTransition) {
        this.d.add(viewTransition);
        this.e = null;
        if (viewTransition.getStateTransition() == 4) {
            a(viewTransition, true);
        } else if (viewTransition.getStateTransition() == 5) {
            a(viewTransition, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        this.f2223c.invalidate();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(ViewTransition.Animate animate) {
        this.b.add(animate);
    }
}
