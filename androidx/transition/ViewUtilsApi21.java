package androidx.transition;

import android.graphics.Matrix;
import android.view.View;

/* loaded from: source-8756600-dex2jar.jar:androidx/transition/ViewUtilsApi21.class */
class ViewUtilsApi21 extends ViewUtilsApi19 {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f3504a = true;
    private static boolean b = true;

    /* renamed from: c  reason: collision with root package name */
    private static boolean f3505c = true;

    @Override // androidx.transition.ViewUtilsBase
    public void setAnimationMatrix(View view, Matrix matrix) {
        if (f3504a) {
            try {
                view.setAnimationMatrix(matrix);
            } catch (NoSuchMethodError e) {
                f3504a = false;
            }
        }
    }

    @Override // androidx.transition.ViewUtilsBase
    public void transformMatrixToGlobal(View view, Matrix matrix) {
        if (b) {
            try {
                view.transformMatrixToGlobal(matrix);
            } catch (NoSuchMethodError e) {
                b = false;
            }
        }
    }

    @Override // androidx.transition.ViewUtilsBase
    public void transformMatrixToLocal(View view, Matrix matrix) {
        if (f3505c) {
            try {
                view.transformMatrixToLocal(matrix);
            } catch (NoSuchMethodError e) {
                f3505c = false;
            }
        }
    }
}
