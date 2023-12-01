package androidx.transition;

import android.graphics.Matrix;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;

/* loaded from: source-8756600-dex2jar.jar:androidx/transition/GhostViewUtils.class */
class GhostViewUtils {
    private GhostViewUtils() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static GhostView a(View view, ViewGroup viewGroup, Matrix matrix) {
        return Build.VERSION.SDK_INT == 28 ? GhostViewPlatform.a(view, viewGroup, matrix) : GhostViewPort.b(view, viewGroup, matrix);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(View view) {
        if (Build.VERSION.SDK_INT == 28) {
            GhostViewPlatform.a(view);
        } else {
            GhostViewPort.b(view);
        }
    }
}
