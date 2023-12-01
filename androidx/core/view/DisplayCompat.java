package androidx.core.view;

import android.app.UiModeManager;
import android.content.Context;
import android.graphics.Point;
import android.os.Build;
import android.text.TextUtils;
import android.view.Display;
import androidx.core.util.Preconditions;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;

/* loaded from: source-8756600-dex2jar.jar:androidx/core/view/DisplayCompat.class */
public final class DisplayCompat {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:androidx/core/view/DisplayCompat$Api17Impl.class */
    public static class Api17Impl {
        private Api17Impl() {
        }

        static void a(Display display, Point point) {
            display.getRealSize(point);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:androidx/core/view/DisplayCompat$Api23Impl.class */
    public static class Api23Impl {
        private Api23Impl() {
        }

        static ModeCompat a(Context context, Display display) {
            Display.Mode mode = display.getMode();
            Point a2 = DisplayCompat.a(context, display);
            return (a2 == null || a(mode, a2)) ? new ModeCompat(mode, true) : new ModeCompat(mode, a2);
        }

        static boolean a(Display.Mode mode, Point point) {
            if (mode.getPhysicalWidth() == point.x && mode.getPhysicalHeight() == point.y) {
                return true;
            }
            return mode.getPhysicalWidth() == point.y && mode.getPhysicalHeight() == point.x;
        }

        static boolean a(Display.Mode mode, Display.Mode mode2) {
            return mode.getPhysicalWidth() == mode2.getPhysicalWidth() && mode.getPhysicalHeight() == mode2.getPhysicalHeight();
        }

        static boolean a(Display display) {
            Display.Mode mode = display.getMode();
            Display.Mode[] supportedModes = display.getSupportedModes();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= supportedModes.length) {
                    return true;
                }
                if (mode.getPhysicalHeight() < supportedModes[i2].getPhysicalHeight() || mode.getPhysicalWidth() < supportedModes[i2].getPhysicalWidth()) {
                    return false;
                }
                i = i2 + 1;
            }
        }

        public static ModeCompat[] getSupportedModes(Context context, Display display) {
            Display.Mode[] supportedModes = display.getSupportedModes();
            ModeCompat[] modeCompatArr = new ModeCompat[supportedModes.length];
            Display.Mode mode = display.getMode();
            Point a2 = DisplayCompat.a(context, display);
            int i = 0;
            if (a2 != null) {
                if (!a(mode, a2)) {
                    int i2 = 0;
                    while (true) {
                        int i3 = i2;
                        if (i3 >= supportedModes.length) {
                            break;
                        }
                        modeCompatArr[i3] = a(supportedModes[i3], mode) ? new ModeCompat(supportedModes[i3], a2) : new ModeCompat(supportedModes[i3], false);
                        i2 = i3 + 1;
                    }
                    return modeCompatArr;
                }
                i = 0;
            }
            while (i < supportedModes.length) {
                modeCompatArr[i] = new ModeCompat(supportedModes[i], a(supportedModes[i], mode));
                i++;
            }
            return modeCompatArr;
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:androidx/core/view/DisplayCompat$ModeCompat.class */
    public static final class ModeCompat {

        /* renamed from: a  reason: collision with root package name */
        private final Display.Mode f2578a;
        private final Point b;

        /* renamed from: c  reason: collision with root package name */
        private final boolean f2579c;

        ModeCompat(Point point) {
            Preconditions.checkNotNull(point, "physicalSize == null");
            this.b = point;
            this.f2578a = null;
            this.f2579c = true;
        }

        ModeCompat(Display.Mode mode, Point point) {
            Preconditions.checkNotNull(mode, "mode == null, can't wrap a null reference");
            Preconditions.checkNotNull(point, "physicalSize == null");
            this.b = point;
            this.f2578a = mode;
            this.f2579c = true;
        }

        ModeCompat(Display.Mode mode, boolean z) {
            Preconditions.checkNotNull(mode, "mode == null, can't wrap a null reference");
            this.b = new Point(mode.getPhysicalWidth(), mode.getPhysicalHeight());
            this.f2578a = mode;
            this.f2579c = z;
        }

        public int getPhysicalHeight() {
            return this.b.y;
        }

        public int getPhysicalWidth() {
            return this.b.x;
        }

        @Deprecated
        public boolean isNative() {
            return this.f2579c;
        }

        public Display.Mode toMode() {
            return this.f2578a;
        }
    }

    private DisplayCompat() {
    }

    static Point a(Context context, Display display) {
        Point a2 = Build.VERSION.SDK_INT < 28 ? a("sys.display-size", display) : a("vendor.display-size", display);
        if (a2 != null) {
            return a2;
        }
        boolean b = b(context);
        Point point = null;
        if (b) {
            point = null;
            if (a(display)) {
                point = new Point(3840, 2160);
            }
        }
        return point;
    }

    private static Point a(String str) throws NumberFormatException {
        String[] split = str.trim().split("x", -1);
        if (split.length == 2) {
            int parseInt = Integer.parseInt(split[0]);
            int parseInt2 = Integer.parseInt(split[1]);
            if (parseInt > 0 && parseInt2 > 0) {
                return new Point(parseInt, parseInt2);
            }
        }
        throw new NumberFormatException();
    }

    private static Point a(String str, Display display) {
        if (display.getDisplayId() != 0) {
            return null;
        }
        String b = b(str);
        if (TextUtils.isEmpty(b)) {
            return null;
        }
        try {
            return a(b);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    private static boolean a(Context context) {
        UiModeManager uiModeManager = (UiModeManager) context.getSystemService(Context.UI_MODE_SERVICE);
        return uiModeManager != null && uiModeManager.getCurrentModeType() == 4;
    }

    static boolean a(Display display) {
        if (Build.VERSION.SDK_INT >= 23) {
            return Api23Impl.a(display);
        }
        return true;
    }

    private static Point b(Context context, Display display) {
        Point a2 = a(context, display);
        if (a2 != null) {
            return a2;
        }
        Point point = new Point();
        if (Build.VERSION.SDK_INT >= 17) {
            Api17Impl.a(display, point);
            return point;
        }
        display.getSize(point);
        return point;
    }

    private static String b(String str) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod(MonitorConstants.CONNECT_TYPE_GET, String.class).invoke(cls, str);
        } catch (Exception e) {
            return null;
        }
    }

    private static boolean b(Context context) {
        return a(context) && "Sony".equals(Build.MANUFACTURER) && Build.MODEL.startsWith("BRAVIA") && context.getPackageManager().hasSystemFeature("com.sony.dtv.hardware.panel.qfhd");
    }

    public static ModeCompat getMode(Context context, Display display) {
        return Build.VERSION.SDK_INT >= 23 ? Api23Impl.a(context, display) : new ModeCompat(b(context, display));
    }

    public static ModeCompat[] getSupportedModes(Context context, Display display) {
        return Build.VERSION.SDK_INT >= 23 ? Api23Impl.getSupportedModes(context, display) : new ModeCompat[]{getMode(context, display)};
    }
}
