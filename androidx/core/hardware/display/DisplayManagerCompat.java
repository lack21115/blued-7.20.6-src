package androidx.core.hardware.display;

import android.content.Context;
import android.hardware.display.DisplayManager;
import android.os.Build;
import android.view.Display;
import android.view.WindowManager;
import java.util.WeakHashMap;

/* loaded from: source-8756600-dex2jar.jar:androidx/core/hardware/display/DisplayManagerCompat.class */
public final class DisplayManagerCompat {
    public static final String DISPLAY_CATEGORY_PRESENTATION = "android.hardware.display.category.PRESENTATION";

    /* renamed from: a  reason: collision with root package name */
    private static final WeakHashMap<Context, DisplayManagerCompat> f2477a = new WeakHashMap<>();
    private final Context b;

    private DisplayManagerCompat(Context context) {
        this.b = context;
    }

    public static DisplayManagerCompat getInstance(Context context) {
        DisplayManagerCompat displayManagerCompat;
        synchronized (f2477a) {
            DisplayManagerCompat displayManagerCompat2 = f2477a.get(context);
            displayManagerCompat = displayManagerCompat2;
            if (displayManagerCompat2 == null) {
                displayManagerCompat = new DisplayManagerCompat(context);
                f2477a.put(context, displayManagerCompat);
            }
        }
        return displayManagerCompat;
    }

    public Display getDisplay(int i) {
        if (Build.VERSION.SDK_INT >= 17) {
            return ((DisplayManager) this.b.getSystemService("display")).getDisplay(i);
        }
        Display defaultDisplay = ((WindowManager) this.b.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay();
        if (defaultDisplay.getDisplayId() == i) {
            return defaultDisplay;
        }
        return null;
    }

    public Display[] getDisplays() {
        return Build.VERSION.SDK_INT >= 17 ? ((DisplayManager) this.b.getSystemService("display")).getDisplays() : new Display[]{((WindowManager) this.b.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay()};
    }

    public Display[] getDisplays(String str) {
        return Build.VERSION.SDK_INT >= 17 ? ((DisplayManager) this.b.getSystemService("display")).getDisplays(str) : str == null ? new Display[0] : new Display[]{((WindowManager) this.b.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay()};
    }
}
