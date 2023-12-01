package android.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.RectEvaluator;
import android.animation.ValueAnimator;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroupOverlay;
import java.util.Map;

/* loaded from: source-9557208-dex2jar.jar:android/transition/Crossfade.class */
public class Crossfade extends Transition {
    public static final int FADE_BEHAVIOR_CROSSFADE = 0;
    public static final int FADE_BEHAVIOR_OUT_IN = 2;
    public static final int FADE_BEHAVIOR_REVEAL = 1;
    private static final String LOG_TAG = "Crossfade";
    private static final String PROPNAME_BITMAP = "android:crossfade:bitmap";
    private static final String PROPNAME_BOUNDS = "android:crossfade:bounds";
    private static final String PROPNAME_DRAWABLE = "android:crossfade:drawable";
    public static final int RESIZE_BEHAVIOR_NONE = 0;
    public static final int RESIZE_BEHAVIOR_SCALE = 1;
    private static RectEvaluator sRectEvaluator = new RectEvaluator();
    private int mFadeBehavior = 1;
    private int mResizeBehavior = 1;

    private void captureValues(TransitionValues transitionValues) {
        View view = transitionValues.view;
        Rect rect = new Rect(0, 0, view.getWidth(), view.getHeight());
        if (this.mFadeBehavior != 1) {
            rect.offset(view.getLeft(), view.getTop());
        }
        transitionValues.values.put(PROPNAME_BOUNDS, rect);
        Bitmap createBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.ARGB_8888);
        if (view instanceof TextureView) {
            createBitmap = ((TextureView) view).getBitmap();
        } else {
            view.draw(new Canvas(createBitmap));
        }
        transitionValues.values.put(PROPNAME_BITMAP, createBitmap);
        BitmapDrawable bitmapDrawable = new BitmapDrawable(createBitmap);
        bitmapDrawable.setBounds(rect);
        transitionValues.values.put(PROPNAME_DRAWABLE, bitmapDrawable);
    }

    @Override // android.transition.Transition
    public void captureEndValues(TransitionValues transitionValues) {
        captureValues(transitionValues);
    }

    @Override // android.transition.Transition
    public void captureStartValues(TransitionValues transitionValues) {
        captureValues(transitionValues);
    }

    @Override // android.transition.Transition
    public Animator createAnimator(ViewGroup viewGroup, TransitionValues transitionValues, TransitionValues transitionValues2) {
        AnimatorSet animatorSet;
        if (transitionValues == null || transitionValues2 == null) {
            animatorSet = null;
        } else {
            boolean z = this.mFadeBehavior != 1;
            final View view = transitionValues2.view;
            Map<String, Object> map = transitionValues.values;
            Map<String, Object> map2 = transitionValues2.values;
            Rect rect = (Rect) map.get(PROPNAME_BOUNDS);
            Rect rect2 = (Rect) map2.get(PROPNAME_BOUNDS);
            Bitmap bitmap = (Bitmap) map.get(PROPNAME_BITMAP);
            Bitmap bitmap2 = (Bitmap) map2.get(PROPNAME_BITMAP);
            final BitmapDrawable bitmapDrawable = (BitmapDrawable) map.get(PROPNAME_DRAWABLE);
            final BitmapDrawable bitmapDrawable2 = (BitmapDrawable) map2.get(PROPNAME_DRAWABLE);
            if (bitmapDrawable == null || bitmapDrawable2 == null || bitmap.sameAs(bitmap2)) {
                return null;
            }
            ViewGroupOverlay overlay = z ? ((ViewGroup) view.getParent()).getOverlay() : view.getOverlay();
            if (this.mFadeBehavior == 1) {
                overlay.add(bitmapDrawable2);
            }
            overlay.add(bitmapDrawable);
            ObjectAnimator ofInt = this.mFadeBehavior == 2 ? ObjectAnimator.ofInt(bitmapDrawable, "alpha", 255, 0, 0) : ObjectAnimator.ofInt(bitmapDrawable, "alpha", 0);
            ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: android.transition.Crossfade.1
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    view.invalidate(bitmapDrawable.getBounds());
                }
            });
            ObjectAnimator objectAnimator = null;
            if (this.mFadeBehavior == 2) {
                objectAnimator = ObjectAnimator.ofFloat(view, View.ALPHA, 0.0f, 0.0f, 1.0f);
            } else if (this.mFadeBehavior == 0) {
                objectAnimator = ObjectAnimator.ofFloat(view, View.ALPHA, 0.0f, 1.0f);
            }
            final boolean z2 = z;
            ofInt.addListener(new AnimatorListenerAdapter() { // from class: android.transition.Crossfade.2
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    ViewGroupOverlay overlay2 = z2 ? ((ViewGroup) view.getParent()).getOverlay() : view.getOverlay();
                    overlay2.remove(bitmapDrawable);
                    if (Crossfade.this.mFadeBehavior == 1) {
                        overlay2.remove(bitmapDrawable2);
                    }
                }
            });
            AnimatorSet animatorSet2 = new AnimatorSet();
            animatorSet2.playTogether(ofInt);
            if (objectAnimator != null) {
                animatorSet2.playTogether(objectAnimator);
            }
            animatorSet = animatorSet2;
            if (this.mResizeBehavior == 1) {
                animatorSet = animatorSet2;
                if (!rect.equals(rect2)) {
                    animatorSet2.playTogether(ObjectAnimator.ofObject(bitmapDrawable, "bounds", sRectEvaluator, rect, rect2));
                    animatorSet = animatorSet2;
                    if (this.mResizeBehavior == 1) {
                        animatorSet2.playTogether(ObjectAnimator.ofObject(bitmapDrawable2, "bounds", sRectEvaluator, rect, rect2));
                        return animatorSet2;
                    }
                }
            }
        }
        return animatorSet;
    }

    public int getFadeBehavior() {
        return this.mFadeBehavior;
    }

    public int getResizeBehavior() {
        return this.mResizeBehavior;
    }

    public Crossfade setFadeBehavior(int i) {
        if (i >= 0 && i <= 2) {
            this.mFadeBehavior = i;
        }
        return this;
    }

    public Crossfade setResizeBehavior(int i) {
        if (i >= 0 && i <= 1) {
            this.mResizeBehavior = i;
        }
        return this;
    }
}
