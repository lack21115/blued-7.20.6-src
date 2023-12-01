package android.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.android.internal.R;

/* loaded from: source-9557208-dex2jar.jar:android/transition/Visibility.class */
public abstract class Visibility extends Transition {
    public static final int MODE_IN = 1;
    public static final int MODE_OUT = 2;
    private static final String PROPNAME_SCREEN_LOCATION = "android:visibility:screenLocation";
    private int mForcedEndVisibility;
    private int mForcedStartVisibility;
    private int mMode;
    static final String PROPNAME_VISIBILITY = "android:visibility:visibility";
    private static final String PROPNAME_PARENT = "android:visibility:parent";
    private static final String[] sTransitionProperties = {PROPNAME_VISIBILITY, PROPNAME_PARENT};

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-9557208-dex2jar.jar:android/transition/Visibility$VisibilityInfo.class */
    public static class VisibilityInfo {
        ViewGroup endParent;
        int endVisibility;
        boolean fadeIn;
        ViewGroup startParent;
        int startVisibility;
        boolean visibilityChange;

        private VisibilityInfo() {
        }
    }

    public Visibility() {
        this.mMode = 3;
        this.mForcedStartVisibility = -1;
        this.mForcedEndVisibility = -1;
    }

    public Visibility(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mMode = 3;
        this.mForcedStartVisibility = -1;
        this.mForcedEndVisibility = -1;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.VisibilityTransition);
        int i = obtainStyledAttributes.getInt(0, 0);
        obtainStyledAttributes.recycle();
        if (i != 0) {
            setMode(i);
        }
    }

    private void captureValues(TransitionValues transitionValues, int i) {
        if (i == -1) {
            i = transitionValues.view.getVisibility();
        }
        transitionValues.values.put(PROPNAME_VISIBILITY, Integer.valueOf(i));
        transitionValues.values.put(PROPNAME_PARENT, transitionValues.view.getParent());
        int[] iArr = new int[2];
        transitionValues.view.getLocationOnScreen(iArr);
        transitionValues.values.put(PROPNAME_SCREEN_LOCATION, iArr);
    }

    private VisibilityInfo getVisibilityChangeInfo(TransitionValues transitionValues, TransitionValues transitionValues2) {
        VisibilityInfo visibilityInfo = new VisibilityInfo();
        visibilityInfo.visibilityChange = false;
        visibilityInfo.fadeIn = false;
        if (transitionValues == null || !transitionValues.values.containsKey(PROPNAME_VISIBILITY)) {
            visibilityInfo.startVisibility = -1;
            visibilityInfo.startParent = null;
        } else {
            visibilityInfo.startVisibility = ((Integer) transitionValues.values.get(PROPNAME_VISIBILITY)).intValue();
            visibilityInfo.startParent = (ViewGroup) transitionValues.values.get(PROPNAME_PARENT);
        }
        if (transitionValues2 == null || !transitionValues2.values.containsKey(PROPNAME_VISIBILITY)) {
            visibilityInfo.endVisibility = -1;
            visibilityInfo.endParent = null;
        } else {
            visibilityInfo.endVisibility = ((Integer) transitionValues2.values.get(PROPNAME_VISIBILITY)).intValue();
            visibilityInfo.endParent = (ViewGroup) transitionValues2.values.get(PROPNAME_PARENT);
        }
        if (transitionValues == null || transitionValues2 == null) {
            if (transitionValues == null && visibilityInfo.endVisibility == 0) {
                visibilityInfo.fadeIn = true;
                visibilityInfo.visibilityChange = true;
                return visibilityInfo;
            } else if (transitionValues2 == null && visibilityInfo.startVisibility == 0) {
                visibilityInfo.fadeIn = false;
                visibilityInfo.visibilityChange = true;
                return visibilityInfo;
            }
        } else if (visibilityInfo.startVisibility != visibilityInfo.endVisibility || visibilityInfo.startParent != visibilityInfo.endParent) {
            if (visibilityInfo.startVisibility != visibilityInfo.endVisibility) {
                if (visibilityInfo.startVisibility == 0) {
                    visibilityInfo.fadeIn = false;
                    visibilityInfo.visibilityChange = true;
                    return visibilityInfo;
                } else if (visibilityInfo.endVisibility == 0) {
                    visibilityInfo.fadeIn = true;
                    visibilityInfo.visibilityChange = true;
                    return visibilityInfo;
                }
            } else if (visibilityInfo.startParent != visibilityInfo.endParent) {
                if (visibilityInfo.endParent == null) {
                    visibilityInfo.fadeIn = false;
                    visibilityInfo.visibilityChange = true;
                    return visibilityInfo;
                } else if (visibilityInfo.startParent == null) {
                    visibilityInfo.fadeIn = true;
                    visibilityInfo.visibilityChange = true;
                    return visibilityInfo;
                }
            }
        }
        return visibilityInfo;
    }

    @Override // android.transition.Transition
    boolean areValuesChanged(TransitionValues transitionValues, TransitionValues transitionValues2) {
        if (transitionValues == null && transitionValues2 == null) {
            return false;
        }
        if (transitionValues == null || transitionValues2 == null || transitionValues2.values.containsKey(PROPNAME_VISIBILITY) == transitionValues.values.containsKey(PROPNAME_VISIBILITY)) {
            VisibilityInfo visibilityChangeInfo = getVisibilityChangeInfo(transitionValues, transitionValues2);
            if (visibilityChangeInfo.visibilityChange) {
                return visibilityChangeInfo.startVisibility == 0 || visibilityChangeInfo.endVisibility == 0;
            }
            return false;
        }
        return false;
    }

    @Override // android.transition.Transition
    public void captureEndValues(TransitionValues transitionValues) {
        captureValues(transitionValues, this.mForcedEndVisibility);
    }

    @Override // android.transition.Transition
    public void captureStartValues(TransitionValues transitionValues) {
        captureValues(transitionValues, this.mForcedStartVisibility);
    }

    @Override // android.transition.Transition
    public Animator createAnimator(ViewGroup viewGroup, TransitionValues transitionValues, TransitionValues transitionValues2) {
        VisibilityInfo visibilityChangeInfo = getVisibilityChangeInfo(transitionValues, transitionValues2);
        if (visibilityChangeInfo.visibilityChange) {
            if (visibilityChangeInfo.startParent == null && visibilityChangeInfo.endParent == null) {
                return null;
            }
            return visibilityChangeInfo.fadeIn ? onAppear(viewGroup, transitionValues, visibilityChangeInfo.startVisibility, transitionValues2, visibilityChangeInfo.endVisibility) : onDisappear(viewGroup, transitionValues, visibilityChangeInfo.startVisibility, transitionValues2, visibilityChangeInfo.endVisibility);
        }
        return null;
    }

    @Override // android.transition.Transition
    public void forceVisibility(int i, boolean z) {
        if (z) {
            this.mForcedStartVisibility = i;
        } else {
            this.mForcedEndVisibility = i;
        }
    }

    public int getMode() {
        return this.mMode;
    }

    @Override // android.transition.Transition
    public String[] getTransitionProperties() {
        return sTransitionProperties;
    }

    public boolean isVisible(TransitionValues transitionValues) {
        if (transitionValues == null) {
            return false;
        }
        return ((Integer) transitionValues.values.get(PROPNAME_VISIBILITY)).intValue() == 0 && ((View) transitionValues.values.get(PROPNAME_PARENT)) != null;
    }

    public Animator onAppear(ViewGroup viewGroup, TransitionValues transitionValues, int i, TransitionValues transitionValues2, int i2) {
        if ((this.mMode & 1) != 1 || transitionValues2 == null) {
            return null;
        }
        if (transitionValues == null) {
            View view = (View) transitionValues2.view.getParent();
            if (getVisibilityChangeInfo(getMatchedTransitionValues(view, false), getTransitionValues(view, false)).visibilityChange) {
                return null;
            }
        }
        return onAppear(viewGroup, transitionValues2.view, transitionValues, transitionValues2);
    }

    public Animator onAppear(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        return null;
    }

    public Animator onDisappear(final ViewGroup viewGroup, TransitionValues transitionValues, int i, TransitionValues transitionValues2, final int i2) {
        View view;
        Animator animator;
        if ((this.mMode & 2) != 2) {
            animator = null;
        } else {
            View view2 = transitionValues != null ? transitionValues.view : null;
            View view3 = transitionValues2 != null ? transitionValues2.view : null;
            if (view3 == null || view3.getParent() == null) {
                if (view3 != null) {
                    view = null;
                } else {
                    view3 = null;
                    view = null;
                    if (view2 != null) {
                        if (view2.getParent() == null) {
                            view3 = view2;
                            view = null;
                        } else {
                            view3 = null;
                            view = null;
                            if (view2.getParent() instanceof View) {
                                View view4 = (View) view2.getParent();
                                if (getVisibilityChangeInfo(getTransitionValues(view4, true), getMatchedTransitionValues(view4, true)).visibilityChange) {
                                    view3 = null;
                                    view = null;
                                    if (view4.getParent() == null) {
                                        int id = view4.getId();
                                        view3 = null;
                                        view = null;
                                        if (id != -1) {
                                            view3 = null;
                                            view = null;
                                            if (viewGroup.findViewById(id) != null) {
                                                view3 = null;
                                                view = null;
                                                if (this.mCanRemoveViews) {
                                                    view3 = view2;
                                                    view = null;
                                                }
                                            }
                                        }
                                    }
                                } else {
                                    view3 = TransitionUtils.copyViewImage(viewGroup, view2, view4);
                                    view = null;
                                }
                            }
                        }
                    }
                }
            } else if (i2 == 4) {
                view = view3;
                view3 = null;
            } else if (view2 == view3) {
                view = view3;
                view3 = null;
            } else {
                view3 = view2;
                view = null;
            }
            if (view3 != null) {
                int[] iArr = (int[]) transitionValues.values.get(PROPNAME_SCREEN_LOCATION);
                int i3 = iArr[0];
                int i4 = iArr[1];
                int[] iArr2 = new int[2];
                viewGroup.getLocationOnScreen(iArr2);
                view3.offsetLeftAndRight((i3 - iArr2[0]) - view3.getLeft());
                view3.offsetTopAndBottom((i4 - iArr2[1]) - view3.getTop());
                viewGroup.getOverlay().add(view3);
                Animator onDisappear = onDisappear(viewGroup, view3, transitionValues, transitionValues2);
                if (onDisappear == null) {
                    viewGroup.getOverlay().remove(view3);
                    return onDisappear;
                }
                final View view5 = view3;
                onDisappear.addListener(new AnimatorListenerAdapter() { // from class: android.transition.Visibility.1
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator2) {
                        viewGroup.getOverlay().remove(view5);
                    }
                });
                return onDisappear;
            } else if (view == null) {
                return null;
            } else {
                int i5 = -1;
                boolean z = (this.mForcedStartVisibility == -1 && this.mForcedEndVisibility == -1) ? false : true;
                if (!z) {
                    i5 = view.getVisibility();
                    view.setVisibility(0);
                }
                Animator onDisappear2 = onDisappear(viewGroup, view, transitionValues, transitionValues2);
                if (onDisappear2 != null) {
                    final boolean z2 = z;
                    final View view6 = view;
                    onDisappear2.addListener(new AnimatorListenerAdapter() { // from class: android.transition.Visibility.2
                        boolean mCanceled = false;

                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationCancel(Animator animator2) {
                            this.mCanceled = true;
                        }

                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator2) {
                            if (this.mCanceled) {
                                return;
                            }
                            if (z2) {
                                view6.setTransitionAlpha(0.0f);
                            } else {
                                view6.setVisibility(i2);
                            }
                        }

                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
                        public void onAnimationPause(Animator animator2) {
                            if (this.mCanceled || z2) {
                                return;
                            }
                            view6.setVisibility(i2);
                        }

                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
                        public void onAnimationResume(Animator animator2) {
                            if (this.mCanceled || z2) {
                                return;
                            }
                            view6.setVisibility(0);
                        }
                    });
                    return onDisappear2;
                }
                animator = onDisappear2;
                if (!z) {
                    view.setVisibility(i5);
                    return onDisappear2;
                }
            }
        }
        return animator;
    }

    public Animator onDisappear(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        return null;
    }

    public void setMode(int i) {
        if ((i & (-4)) != 0) {
            throw new IllegalArgumentException("Only MODE_IN and MODE_OUT flags are allowed");
        }
        this.mMode = i;
    }
}
