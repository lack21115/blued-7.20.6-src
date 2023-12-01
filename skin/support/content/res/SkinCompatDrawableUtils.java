package skin.support.content.res;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ScaleDrawable;
import android.os.Build;
import skin.support.utils.SkinCompatVersionUtils;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-3503164-dex2jar.jar:skin/support/content/res/SkinCompatDrawableUtils.class */
public class SkinCompatDrawableUtils {
    SkinCompatDrawableUtils() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Drawable drawable) {
        if (Build.VERSION.SDK_INT == 21 && "android.graphics.drawable.VectorDrawable".equals(drawable.getClass().getName())) {
            c(drawable);
        }
    }

    public static boolean b(Drawable drawable) {
        Drawable drawable2;
        if (Build.VERSION.SDK_INT < 15 && (drawable instanceof InsetDrawable)) {
            return false;
        }
        if (Build.VERSION.SDK_INT < 15 && (drawable instanceof GradientDrawable)) {
            return false;
        }
        if (Build.VERSION.SDK_INT < 17 && (drawable instanceof LayerDrawable)) {
            return false;
        }
        if (!(drawable instanceof DrawableContainer)) {
            if (SkinCompatVersionUtils.c(drawable)) {
                return b(SkinCompatVersionUtils.d(drawable));
            }
            if (SkinCompatVersionUtils.a(drawable)) {
                return b(SkinCompatVersionUtils.b(drawable));
            }
            if (SkinCompatVersionUtils.e(drawable)) {
                return b(SkinCompatVersionUtils.f(drawable));
            }
            if (!(drawable instanceof ScaleDrawable) || (drawable2 = ((ScaleDrawable) drawable).getDrawable()) == null) {
                return true;
            }
            return b(drawable2);
        }
        Drawable.ConstantState constantState = drawable.getConstantState();
        if (!(constantState instanceof DrawableContainer.DrawableContainerState)) {
            return true;
        }
        Drawable[] children = ((DrawableContainer.DrawableContainerState) constantState).getChildren();
        int length = children.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return true;
            }
            if (!b(children[i2])) {
                return false;
            }
            i = i2 + 1;
        }
    }

    private static void c(Drawable drawable) {
        int[] state = drawable.getState();
        if (state == null || state.length == 0) {
            drawable.setState(SkinCompatThemeUtils.k);
        } else {
            drawable.setState(SkinCompatThemeUtils.n);
        }
        drawable.setState(state);
    }
}
