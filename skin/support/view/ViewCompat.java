package skin.support.view;

import android.os.Build;
import android.view.View;

/* loaded from: source-3503164-dex2jar.jar:skin/support/view/ViewCompat.class */
public class ViewCompat {
    public static boolean a(View view) {
        if (Build.VERSION.SDK_INT >= 15) {
            return view.hasOnClickListeners();
        }
        return false;
    }
}
