package androidx.transition;

import android.view.View;

/* loaded from: source-8756600-dex2jar.jar:androidx/transition/ViewUtilsApi19.class */
class ViewUtilsApi19 extends ViewUtilsBase {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f3455a = true;

    @Override // androidx.transition.ViewUtilsBase
    public void clearNonTransitionAlpha(View view) {
    }

    @Override // androidx.transition.ViewUtilsBase
    public float getTransitionAlpha(View view) {
        if (f3455a) {
            try {
                return view.getTransitionAlpha();
            } catch (NoSuchMethodError e) {
                f3455a = false;
            }
        }
        return view.getAlpha();
    }

    @Override // androidx.transition.ViewUtilsBase
    public void saveNonTransitionAlpha(View view) {
    }

    @Override // androidx.transition.ViewUtilsBase
    public void setTransitionAlpha(View view, float f) {
        if (f3455a) {
            try {
                view.setTransitionAlpha(f);
                return;
            } catch (NoSuchMethodError e) {
                f3455a = false;
            }
        }
        view.setAlpha(f);
    }
}
