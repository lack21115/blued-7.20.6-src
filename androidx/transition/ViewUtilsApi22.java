package androidx.transition;

import android.view.View;

/* loaded from: source-8756600-dex2jar.jar:androidx/transition/ViewUtilsApi22.class */
class ViewUtilsApi22 extends ViewUtilsApi21 {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f3506a = true;

    @Override // androidx.transition.ViewUtilsBase
    public void setLeftTopRightBottom(View view, int i, int i2, int i3, int i4) {
        if (f3506a) {
            try {
                view.setLeftTopRightBottom(i, i2, i3, i4);
            } catch (NoSuchMethodError e) {
                f3506a = false;
            }
        }
    }
}
