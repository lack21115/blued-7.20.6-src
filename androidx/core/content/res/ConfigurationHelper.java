package androidx.core.content.res;

import android.content.res.Resources;
import android.os.Build;

/* loaded from: source-8756600-dex2jar.jar:androidx/core/content/res/ConfigurationHelper.class */
public final class ConfigurationHelper {
    private ConfigurationHelper() {
    }

    public static int getDensityDpi(Resources resources) {
        return Build.VERSION.SDK_INT >= 17 ? resources.getConfiguration().densityDpi : resources.getDisplayMetrics().densityDpi;
    }
}
