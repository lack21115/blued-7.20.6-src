package androidx.transition;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;

/* loaded from: source-8756600-dex2jar.jar:androidx/transition/Explode.class */
public class Explode extends Visibility {

    /* renamed from: a  reason: collision with root package name */
    private static final TimeInterpolator f3437a = new DecelerateInterpolator();
    private static final TimeInterpolator b = new AccelerateInterpolator();

    /* renamed from: c  reason: collision with root package name */
    private int[] f3438c;

    public Explode() {
        this.f3438c = new int[2];
        setPropagation(new CircularPropagation());
    }

    public Explode(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f3438c = new int[2];
        setPropagation(new CircularPropagation());
    }

    private static float a(float f, float f2) {
        return (float) Math.sqrt((f * f) + (f2 * f2));
    }

    private static float a(View view, int i, int i2) {
        return a(Math.max(i, view.getWidth() - i), Math.max(i2, view.getHeight() - i2));
    }

    private void a(View view, Rect rect, int[] iArr) {
        int centerX;
        int centerY;
        view.getLocationOnScreen(this.f3438c);
        int[] iArr2 = this.f3438c;
        int i = iArr2[0];
        int i2 = iArr2[1];
        Rect epicenter = getEpicenter();
        if (epicenter == null) {
            centerX = (view.getWidth() / 2) + i + Math.round(view.getTranslationX());
            centerY = (view.getHeight() / 2) + i2 + Math.round(view.getTranslationY());
        } else {
            centerX = epicenter.centerX();
            centerY = epicenter.centerY();
        }
        float centerX2 = rect.centerX() - centerX;
        float centerY2 = rect.centerY() - centerY;
        float f = centerX2;
        float f2 = centerY2;
        if (centerX2 == 0.0f) {
            f = centerX2;
            f2 = centerY2;
            if (centerY2 == 0.0f) {
                f = ((float) (Math.random() * 2.0d)) - 1.0f;
                f2 = ((float) (Math.random() * 2.0d)) - 1.0f;
            }
        }
        float a2 = a(f, f2);
        float f3 = f / a2;
        float f4 = f2 / a2;
        float a3 = a(view, centerX - i, centerY - i2);
        iArr[0] = Math.round(f3 * a3);
        iArr[1] = Math.round(a3 * f4);
    }

    private void a(TransitionValues transitionValues) {
        View view = transitionValues.view;
        view.getLocationOnScreen(this.f3438c);
        int[] iArr = this.f3438c;
        int i = iArr[0];
        int i2 = iArr[1];
        transitionValues.values.put("android:explode:screenBounds", new Rect(i, i2, view.getWidth() + i, view.getHeight() + i2));
    }

    @Override // androidx.transition.Visibility, androidx.transition.Transition
    public void captureEndValues(TransitionValues transitionValues) {
        super.captureEndValues(transitionValues);
        a(transitionValues);
    }

    @Override // androidx.transition.Visibility, androidx.transition.Transition
    public void captureStartValues(TransitionValues transitionValues) {
        super.captureStartValues(transitionValues);
        a(transitionValues);
    }

    @Override // androidx.transition.Visibility
    public Animator onAppear(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        if (transitionValues2 == null) {
            return null;
        }
        Rect rect = (Rect) transitionValues2.values.get("android:explode:screenBounds");
        float translationX = view.getTranslationX();
        float translationY = view.getTranslationY();
        a(viewGroup, rect, this.f3438c);
        int[] iArr = this.f3438c;
        return TranslationAnimationCreator.a(view, transitionValues2, rect.left, rect.top, translationX + iArr[0], translationY + iArr[1], translationX, translationY, f3437a, this);
    }

    @Override // androidx.transition.Visibility
    public Animator onDisappear(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        float f;
        float f2;
        if (transitionValues == null) {
            return null;
        }
        Rect rect = (Rect) transitionValues.values.get("android:explode:screenBounds");
        int i = rect.left;
        int i2 = rect.top;
        float translationX = view.getTranslationX();
        float translationY = view.getTranslationY();
        int[] iArr = (int[]) transitionValues.view.getTag(R.id.transition_position);
        if (iArr != null) {
            f = (iArr[0] - rect.left) + translationX;
            f2 = (iArr[1] - rect.top) + translationY;
            rect.offsetTo(iArr[0], iArr[1]);
        } else {
            f = translationX;
            f2 = translationY;
        }
        a(viewGroup, rect, this.f3438c);
        int[] iArr2 = this.f3438c;
        return TranslationAnimationCreator.a(view, transitionValues, i, i2, translationX, translationY, f + iArr2[0], f2 + iArr2[1], b, this);
    }
}
