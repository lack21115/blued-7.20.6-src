package android.util;

import android.graphics.Bitmap;
import android.os.SystemProperties;
import com.alipay.sdk.util.i;

/* loaded from: source-9557208-dex2jar.jar:android/util/DisplayMetrics.class */
public class DisplayMetrics {
    public static final int DENSITY_280 = 280;
    public static final int DENSITY_400 = 400;
    public static final int DENSITY_560 = 560;
    public static final int DENSITY_DEFAULT = 160;
    public static final float DENSITY_DEFAULT_SCALE = 0.00625f;
    public static final int DENSITY_HIGH = 240;
    public static final int DENSITY_LOW = 120;
    public static final int DENSITY_MEDIUM = 160;
    public static final int DENSITY_TV = 213;
    public static final int DENSITY_XHIGH = 320;
    public static final int DENSITY_XXHIGH = 480;
    public static final int DENSITY_XXXHIGH = 640;
    public float density;
    public int densityDpi;
    public int heightPixels;
    public float noncompatDensity;
    public int noncompatDensityDpi;
    public int noncompatHeightPixels;
    public float noncompatScaledDensity;
    public int noncompatWidthPixels;
    public float noncompatXdpi;
    public float noncompatYdpi;
    public float scaledDensity;
    public int widthPixels;
    public float xdpi;
    public float ydpi;
    @Deprecated
    public static int DENSITY_DEVICE = SystemProperties.getInt("qemu.sf.lcd_density", SystemProperties.getInt("ro.sf.lcd_density", 160));
    public static int DENSITY_DEVICE_DEFAULT = DENSITY_DEVICE;
    public static int DENSITY_PREFERRED = SystemProperties.getInt("persist.sys.lcd_density", DENSITY_DEVICE);

    public boolean equals(DisplayMetrics displayMetrics) {
        return equalsPhysical(displayMetrics) && this.scaledDensity == displayMetrics.scaledDensity && this.noncompatScaledDensity == displayMetrics.noncompatScaledDensity;
    }

    public boolean equals(Object obj) {
        return (obj instanceof DisplayMetrics) && equals((DisplayMetrics) obj);
    }

    public boolean equalsPhysical(DisplayMetrics displayMetrics) {
        return displayMetrics != null && this.widthPixels == displayMetrics.widthPixels && this.heightPixels == displayMetrics.heightPixels && this.density == displayMetrics.density && this.densityDpi == displayMetrics.densityDpi && this.xdpi == displayMetrics.xdpi && this.ydpi == displayMetrics.ydpi && this.noncompatWidthPixels == displayMetrics.noncompatWidthPixels && this.noncompatHeightPixels == displayMetrics.noncompatHeightPixels && this.noncompatDensity == displayMetrics.noncompatDensity && this.noncompatDensityDpi == displayMetrics.noncompatDensityDpi && this.noncompatXdpi == displayMetrics.noncompatXdpi && this.noncompatYdpi == displayMetrics.noncompatYdpi;
    }

    public int hashCode() {
        return this.widthPixels * this.heightPixels * this.densityDpi;
    }

    public void setDensity(int i) {
        this.density = i / 160.0f;
        this.densityDpi = i;
        this.scaledDensity = this.density;
        this.xdpi = i;
        this.ydpi = i;
        DENSITY_DEVICE = i;
        Bitmap.setDefaultDensity(i);
    }

    public void setTo(DisplayMetrics displayMetrics) {
        this.widthPixels = displayMetrics.widthPixels;
        this.heightPixels = displayMetrics.heightPixels;
        this.density = displayMetrics.density;
        this.densityDpi = displayMetrics.densityDpi;
        this.scaledDensity = displayMetrics.scaledDensity;
        this.xdpi = displayMetrics.xdpi;
        this.ydpi = displayMetrics.ydpi;
        this.noncompatWidthPixels = displayMetrics.noncompatWidthPixels;
        this.noncompatHeightPixels = displayMetrics.noncompatHeightPixels;
        this.noncompatDensity = displayMetrics.noncompatDensity;
        this.noncompatDensityDpi = displayMetrics.noncompatDensityDpi;
        this.noncompatScaledDensity = displayMetrics.noncompatScaledDensity;
        this.noncompatXdpi = displayMetrics.noncompatXdpi;
        this.noncompatYdpi = displayMetrics.noncompatYdpi;
    }

    public void setToDefaults() {
        this.widthPixels = 0;
        this.heightPixels = 0;
        this.density = DENSITY_DEVICE / 160.0f;
        this.densityDpi = DENSITY_DEVICE;
        this.scaledDensity = this.density;
        this.xdpi = DENSITY_DEVICE;
        this.ydpi = DENSITY_DEVICE;
        this.noncompatWidthPixels = this.widthPixels;
        this.noncompatHeightPixels = this.heightPixels;
        this.noncompatDensity = this.density;
        this.noncompatDensityDpi = this.densityDpi;
        this.noncompatScaledDensity = this.scaledDensity;
        this.noncompatXdpi = this.xdpi;
        this.noncompatYdpi = this.ydpi;
    }

    public String toString() {
        return "DisplayMetrics{density=" + this.density + ", width=" + this.widthPixels + ", height=" + this.heightPixels + ", scaledDensity=" + this.scaledDensity + ", xdpi=" + this.xdpi + ", ydpi=" + this.ydpi + i.d;
    }
}
