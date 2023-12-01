package androidx.core.graphics;

import android.graphics.BlendMode;
import android.graphics.BlendModeColorFilter;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.os.Build;

/* loaded from: source-8756600-dex2jar.jar:androidx/core/graphics/BlendModeColorFilterCompat.class */
public class BlendModeColorFilterCompat {
    private BlendModeColorFilterCompat() {
    }

    public static ColorFilter createBlendModeColorFilterCompat(int i, BlendModeCompat blendModeCompat) {
        if (Build.VERSION.SDK_INT >= 29) {
            BlendMode a2 = BlendModeUtils.a(blendModeCompat);
            BlendModeColorFilter blendModeColorFilter = null;
            if (a2 != null) {
                blendModeColorFilter = new BlendModeColorFilter(i, a2);
            }
            return blendModeColorFilter;
        }
        PorterDuff.Mode b = BlendModeUtils.b(blendModeCompat);
        PorterDuffColorFilter porterDuffColorFilter = null;
        if (b != null) {
            porterDuffColorFilter = new PorterDuffColorFilter(i, b);
        }
        return porterDuffColorFilter;
    }
}
