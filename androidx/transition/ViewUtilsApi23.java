package androidx.transition;

import android.os.Build;
import android.view.View;

/* loaded from: source-8756600-dex2jar.jar:androidx/transition/ViewUtilsApi23.class */
class ViewUtilsApi23 extends ViewUtilsApi22 {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f3507a = true;

    @Override // androidx.transition.ViewUtilsBase
    public void setTransitionVisibility(View view, int i) {
        if (Build.VERSION.SDK_INT == 28) {
            super.setTransitionVisibility(view, i);
        } else if (f3507a) {
            try {
                view.setTransitionVisibility(i);
            } catch (NoSuchMethodError e) {
                f3507a = false;
            }
        }
    }
}
