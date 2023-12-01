package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.res.TypedArrayUtils;
import androidx.transition.AnimatorUtils;
import androidx.transition.Transition;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: source-8756600-dex2jar.jar:androidx/transition/Visibility.class */
public abstract class Visibility extends Transition {
    public static final int MODE_IN = 1;
    public static final int MODE_OUT = 2;
    private static final String PROPNAME_SCREEN_LOCATION = "android:visibility:screenLocation";
    private int mMode;
    static final String PROPNAME_VISIBILITY = "android:visibility:visibility";
    private static final String PROPNAME_PARENT = "android:visibility:parent";
    private static final String[] sTransitionProperties = {PROPNAME_VISIBILITY, PROPNAME_PARENT};

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:androidx/transition/Visibility$DisappearListener.class */
    public static class DisappearListener extends AnimatorListenerAdapter implements AnimatorUtils.AnimatorPauseListenerCompat, Transition.TransitionListener {

        /* renamed from: a  reason: collision with root package name */
        boolean f3512a = false;
        private final View b;

        /* renamed from: c  reason: collision with root package name */
        private final int f3513c;
        private final ViewGroup d;
        private final boolean e;
        private boolean f;

        DisappearListener(View view, int i, boolean z) {
            this.b = view;
            this.f3513c = i;
            this.d = (ViewGroup) view.getParent();
            this.e = z;
            a(true);
        }

        private void a() {
            if (!this.f3512a) {
                ViewUtils.a(this.b, this.f3513c);
                ViewGroup viewGroup = this.d;
                if (viewGroup != null) {
                    viewGroup.invalidate();
                }
            }
            a(false);
        }

        private void a(boolean z) {
            ViewGroup viewGroup;
            if (!this.e || this.f == z || (viewGroup = this.d) == null) {
                return;
            }
            this.f = z;
            ViewGroupUtils.a(viewGroup, z);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f3512a = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            a();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
        public void onAnimationPause(Animator animator) {
            if (this.f3512a) {
                return;
            }
            ViewUtils.a(this.b, this.f3513c);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
        public void onAnimationResume(Animator animator) {
            if (this.f3512a) {
                return;
            }
            ViewUtils.a(this.b, 0);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }

        @Override // androidx.transition.Transition.TransitionListener
        public void onTransitionCancel(Transition transition) {
        }

        @Override // androidx.transition.Transition.TransitionListener
        public void onTransitionEnd(Transition transition) {
            a();
            transition.removeListener(this);
        }

        @Override // androidx.transition.Transition.TransitionListener
        public void onTransitionPause(Transition transition) {
            a(false);
        }

        @Override // androidx.transition.Transition.TransitionListener
        public void onTransitionResume(Transition transition) {
            a(true);
        }

        @Override // androidx.transition.Transition.TransitionListener
        public void onTransitionStart(Transition transition) {
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: source-8756600-dex2jar.jar:androidx/transition/Visibility$Mode.class */
    public @interface Mode {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:androidx/transition/Visibility$VisibilityInfo.class */
    public static class VisibilityInfo {

        /* renamed from: a  reason: collision with root package name */
        boolean f3514a;
        boolean b;

        /* renamed from: c  reason: collision with root package name */
        int f3515c;
        int d;
        ViewGroup e;
        ViewGroup f;

        VisibilityInfo() {
        }
    }

    public Visibility() {
        this.mMode = 3;
    }

    public Visibility(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mMode = 3;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, Styleable.e);
        int namedInt = TypedArrayUtils.getNamedInt(obtainStyledAttributes, (XmlResourceParser) attributeSet, "transitionVisibilityMode", 0, 0);
        obtainStyledAttributes.recycle();
        if (namedInt != 0) {
            setMode(namedInt);
        }
    }

    private void captureValues(TransitionValues transitionValues) {
        transitionValues.values.put(PROPNAME_VISIBILITY, Integer.valueOf(transitionValues.view.getVisibility()));
        transitionValues.values.put(PROPNAME_PARENT, transitionValues.view.getParent());
        int[] iArr = new int[2];
        transitionValues.view.getLocationOnScreen(iArr);
        transitionValues.values.put(PROPNAME_SCREEN_LOCATION, iArr);
    }

    private VisibilityInfo getVisibilityChangeInfo(TransitionValues transitionValues, TransitionValues transitionValues2) {
        VisibilityInfo visibilityInfo = new VisibilityInfo();
        visibilityInfo.f3514a = false;
        visibilityInfo.b = false;
        if (transitionValues == null || !transitionValues.values.containsKey(PROPNAME_VISIBILITY)) {
            visibilityInfo.f3515c = -1;
            visibilityInfo.e = null;
        } else {
            visibilityInfo.f3515c = ((Integer) transitionValues.values.get(PROPNAME_VISIBILITY)).intValue();
            visibilityInfo.e = (ViewGroup) transitionValues.values.get(PROPNAME_PARENT);
        }
        if (transitionValues2 == null || !transitionValues2.values.containsKey(PROPNAME_VISIBILITY)) {
            visibilityInfo.d = -1;
            visibilityInfo.f = null;
        } else {
            visibilityInfo.d = ((Integer) transitionValues2.values.get(PROPNAME_VISIBILITY)).intValue();
            visibilityInfo.f = (ViewGroup) transitionValues2.values.get(PROPNAME_PARENT);
        }
        if (transitionValues == null || transitionValues2 == null) {
            if (transitionValues == null && visibilityInfo.d == 0) {
                visibilityInfo.b = true;
                visibilityInfo.f3514a = true;
                return visibilityInfo;
            } else if (transitionValues2 == null && visibilityInfo.f3515c == 0) {
                visibilityInfo.b = false;
                visibilityInfo.f3514a = true;
            }
        } else if (visibilityInfo.f3515c == visibilityInfo.d && visibilityInfo.e == visibilityInfo.f) {
            return visibilityInfo;
        } else {
            if (visibilityInfo.f3515c != visibilityInfo.d) {
                if (visibilityInfo.f3515c == 0) {
                    visibilityInfo.b = false;
                    visibilityInfo.f3514a = true;
                    return visibilityInfo;
                } else if (visibilityInfo.d == 0) {
                    visibilityInfo.b = true;
                    visibilityInfo.f3514a = true;
                    return visibilityInfo;
                }
            } else if (visibilityInfo.f == null) {
                visibilityInfo.b = false;
                visibilityInfo.f3514a = true;
                return visibilityInfo;
            } else if (visibilityInfo.e == null) {
                visibilityInfo.b = true;
                visibilityInfo.f3514a = true;
                return visibilityInfo;
            }
        }
        return visibilityInfo;
    }

    @Override // androidx.transition.Transition
    public void captureEndValues(TransitionValues transitionValues) {
        captureValues(transitionValues);
    }

    @Override // androidx.transition.Transition
    public void captureStartValues(TransitionValues transitionValues) {
        captureValues(transitionValues);
    }

    @Override // androidx.transition.Transition
    public Animator createAnimator(ViewGroup viewGroup, TransitionValues transitionValues, TransitionValues transitionValues2) {
        VisibilityInfo visibilityChangeInfo = getVisibilityChangeInfo(transitionValues, transitionValues2);
        if (visibilityChangeInfo.f3514a) {
            if (visibilityChangeInfo.e == null && visibilityChangeInfo.f == null) {
                return null;
            }
            return visibilityChangeInfo.b ? onAppear(viewGroup, transitionValues, visibilityChangeInfo.f3515c, transitionValues2, visibilityChangeInfo.d) : onDisappear(viewGroup, transitionValues, visibilityChangeInfo.f3515c, transitionValues2, visibilityChangeInfo.d);
        }
        return null;
    }

    public int getMode() {
        return this.mMode;
    }

    @Override // androidx.transition.Transition
    public String[] getTransitionProperties() {
        return sTransitionProperties;
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x004f, code lost:
        if (r0.d == 0) goto L20;
     */
    @Override // androidx.transition.Transition
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean isTransitionRequired(androidx.transition.TransitionValues r5, androidx.transition.TransitionValues r6) {
        /*
            r4 = this;
            r0 = 0
            r8 = r0
            r0 = r5
            if (r0 != 0) goto Ld
            r0 = r6
            if (r0 != 0) goto Ld
            r0 = 0
            return r0
        Ld:
            r0 = r5
            if (r0 == 0) goto L30
            r0 = r6
            if (r0 == 0) goto L30
            r0 = r6
            java.util.Map<java.lang.String, java.lang.Object> r0 = r0.values
            java.lang.String r1 = "android:visibility:visibility"
            boolean r0 = r0.containsKey(r1)
            r1 = r5
            java.util.Map<java.lang.String, java.lang.Object> r1 = r1.values
            java.lang.String r2 = "android:visibility:visibility"
            boolean r1 = r1.containsKey(r2)
            if (r0 == r1) goto L30
            r0 = 0
            return r0
        L30:
            r0 = r4
            r1 = r5
            r2 = r6
            androidx.transition.Visibility$VisibilityInfo r0 = r0.getVisibilityChangeInfo(r1, r2)
            r5 = r0
            r0 = r8
            r7 = r0
            r0 = r5
            boolean r0 = r0.f3514a
            if (r0 == 0) goto L54
            r0 = r5
            int r0 = r0.f3515c
            if (r0 == 0) goto L52
            r0 = r8
            r7 = r0
            r0 = r5
            int r0 = r0.d
            if (r0 != 0) goto L54
        L52:
            r0 = 1
            r7 = r0
        L54:
            r0 = r7
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.transition.Visibility.isTransitionRequired(androidx.transition.TransitionValues, androidx.transition.TransitionValues):boolean");
    }

    public boolean isVisible(TransitionValues transitionValues) {
        if (transitionValues == null) {
            return false;
        }
        int intValue = ((Integer) transitionValues.values.get(PROPNAME_VISIBILITY)).intValue();
        View view = (View) transitionValues.values.get(PROPNAME_PARENT);
        boolean z = false;
        if (intValue == 0) {
            z = false;
            if (view != null) {
                z = true;
            }
        }
        return z;
    }

    public Animator onAppear(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        return null;
    }

    public Animator onAppear(ViewGroup viewGroup, TransitionValues transitionValues, int i, TransitionValues transitionValues2, int i2) {
        if ((this.mMode & 1) != 1 || transitionValues2 == null) {
            return null;
        }
        if (transitionValues == null) {
            View view = (View) transitionValues2.view.getParent();
            if (getVisibilityChangeInfo(getMatchedTransitionValues(view, false), getTransitionValues(view, false)).f3514a) {
                return null;
            }
        }
        return onAppear(viewGroup, transitionValues2.view, transitionValues, transitionValues2);
    }

    public Animator onDisappear(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:49:0x0106, code lost:
        if (r8.mCanRemoveViews != false) goto L63;
     */
    /* JADX WARN: Removed duplicated region for block: B:34:0x008e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.animation.Animator onDisappear(final android.view.ViewGroup r9, androidx.transition.TransitionValues r10, int r11, androidx.transition.TransitionValues r12, int r13) {
        /*
            Method dump skipped, instructions count: 521
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.transition.Visibility.onDisappear(android.view.ViewGroup, androidx.transition.TransitionValues, int, androidx.transition.TransitionValues, int):android.animation.Animator");
    }

    public void setMode(int i) {
        if ((i & (-4)) != 0) {
            throw new IllegalArgumentException("Only MODE_IN and MODE_OUT flags are allowed");
        }
        this.mMode = i;
    }
}
