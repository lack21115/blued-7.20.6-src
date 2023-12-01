package android.graphics;

import android.hardware.Camera;
import android.util.MathUtils;
import com.android.internal.util.XmlUtils;
import com.tencent.cloud.huiyansdkface.facelight.api.WbCloudFaceContant;
import java.util.HashMap;
import java.util.Locale;

/* loaded from: source-9557208-dex2jar.jar:android/graphics/Color.class */
public class Color {
    public static final int BLACK = -16777216;
    public static final int BLUE = -16776961;
    public static final int CYAN = -16711681;
    public static final int DKGRAY = -12303292;
    public static final int GRAY = -7829368;
    public static final int GREEN = -16711936;
    public static final int LTGRAY = -3355444;
    public static final int MAGENTA = -65281;
    public static final int RED = -65536;
    public static final int TRANSPARENT = 0;
    public static final int WHITE = -1;
    public static final int YELLOW = -256;
    private static final HashMap<String, Integer> sColorNameMap = new HashMap<>();

    static {
        sColorNameMap.put(WbCloudFaceContant.BLACK, -16777216);
        sColorNameMap.put("darkgray", Integer.valueOf((int) DKGRAY));
        sColorNameMap.put("gray", Integer.valueOf((int) GRAY));
        sColorNameMap.put("lightgray", Integer.valueOf((int) LTGRAY));
        sColorNameMap.put(WbCloudFaceContant.WHITE, -1);
        sColorNameMap.put("red", -65536);
        sColorNameMap.put("green", Integer.valueOf((int) GREEN));
        sColorNameMap.put("blue", Integer.valueOf((int) BLUE));
        sColorNameMap.put("yellow", -256);
        sColorNameMap.put("cyan", Integer.valueOf((int) CYAN));
        sColorNameMap.put("magenta", Integer.valueOf((int) MAGENTA));
        sColorNameMap.put(Camera.Parameters.EFFECT_AQUA, Integer.valueOf((int) CYAN));
        sColorNameMap.put("fuchsia", Integer.valueOf((int) MAGENTA));
        sColorNameMap.put("darkgrey", Integer.valueOf((int) DKGRAY));
        sColorNameMap.put("grey", Integer.valueOf((int) GRAY));
        sColorNameMap.put("lightgrey", Integer.valueOf((int) LTGRAY));
        sColorNameMap.put("lime", Integer.valueOf((int) GREEN));
        sColorNameMap.put("maroon", -8388608);
        sColorNameMap.put("navy", -16777088);
        sColorNameMap.put("olive", -8355840);
        sColorNameMap.put("purple", -8388480);
        sColorNameMap.put("silver", -4144960);
        sColorNameMap.put("teal", -16744320);
    }

    public static int HSBtoColor(float f, float f2, float f3) {
        float constrain = MathUtils.constrain(f, 0.0f, 1.0f);
        float constrain2 = MathUtils.constrain(f2, 0.0f, 1.0f);
        float constrain3 = MathUtils.constrain(f3, 0.0f, 1.0f);
        float f4 = (constrain - ((int) constrain)) * 6.0f;
        int i = (int) f4;
        float f5 = f4 - i;
        float f6 = constrain3 * (1.0f - constrain2);
        float f7 = constrain3 * (1.0f - (constrain2 * f5));
        float f8 = constrain3 * (1.0f - ((1.0f - f5) * constrain2));
        switch (i) {
            case 0:
                f7 = constrain3;
                constrain3 = f6;
                f6 = f8;
                break;
            case 1:
                constrain3 = f6;
                f6 = constrain3;
                break;
            case 2:
                f7 = f6;
                f6 = constrain3;
                constrain3 = f8;
                break;
            case 3:
                f6 = f7;
                f7 = f6;
                break;
            case 4:
                f7 = f8;
                break;
            case 5:
                constrain3 = f7;
                f7 = constrain3;
                break;
            default:
                f7 = 0.0f;
                f6 = 0.0f;
                constrain3 = 0.0f;
                break;
        }
        return (-16777216) | (((int) (f7 * 255.0f)) << 16) | (((int) (f6 * 255.0f)) << 8) | ((int) (constrain3 * 255.0f));
    }

    public static int HSBtoColor(float[] fArr) {
        return HSBtoColor(fArr[0], fArr[1], fArr[2]);
    }

    public static int HSVToColor(int i, float[] fArr) {
        if (fArr.length < 3) {
            throw new RuntimeException("3 components required for hsv");
        }
        return nativeHSVToColor(i, fArr);
    }

    public static int HSVToColor(float[] fArr) {
        return HSVToColor(255, fArr);
    }

    public static void RGBToHSV(int i, int i2, int i3, float[] fArr) {
        if (fArr.length < 3) {
            throw new RuntimeException("3 components required for hsv");
        }
        nativeRGBToHSV(i, i2, i3, fArr);
    }

    public static int alpha(int i) {
        return i >>> 24;
    }

    public static int argb(int i, int i2, int i3, int i4) {
        return (i << 24) | (i2 << 16) | (i3 << 8) | i4;
    }

    public static int blue(int i) {
        return i & 255;
    }

    public static float brightness(int i) {
        return Math.max(i & 255, Math.max((i >> 16) & 255, (i >> 8) & 255)) / 255.0f;
    }

    public static void colorToHSV(int i, float[] fArr) {
        RGBToHSV((i >> 16) & 255, (i >> 8) & 255, i & 255, fArr);
    }

    public static int getHtmlColor(String str) {
        Integer num = sColorNameMap.get(str.toLowerCase(Locale.ROOT));
        if (num != null) {
            return num.intValue();
        }
        try {
            return XmlUtils.convertValueToInt(str, -1);
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    public static int green(int i) {
        return (i >> 8) & 255;
    }

    public static float hue(int i) {
        float f;
        int i2 = (i >> 16) & 255;
        int i3 = (i >> 8) & 255;
        int i4 = i & 255;
        int max = Math.max(i4, Math.max(i2, i3));
        int min = Math.min(i4, Math.min(i2, i3));
        if (max == min) {
            f = 0.0f;
        } else {
            float f2 = max - min;
            float f3 = (max - i2) / f2;
            float f4 = (max - i3) / f2;
            float f5 = (max - i4) / f2;
            float f6 = (i2 == max ? f5 - f4 : i3 == max ? (2.0f + f3) - f5 : (4.0f + f4) - f3) / 6.0f;
            f = f6;
            if (f6 < 0.0f) {
                return f6 + 1.0f;
            }
        }
        return f;
    }

    private static native int nativeHSVToColor(int i, float[] fArr);

    private static native void nativeRGBToHSV(int i, int i2, int i3, float[] fArr);

    public static int parseColor(String str) {
        if (str.charAt(0) != '#') {
            Integer num = sColorNameMap.get(str.toLowerCase(Locale.ROOT));
            if (num != null) {
                return num.intValue();
            }
            throw new IllegalArgumentException("Unknown color");
        }
        long parseLong = Long.parseLong(str.substring(1), 16);
        if (str.length() == 7) {
            parseLong |= -16777216;
        } else if (str.length() != 9) {
            throw new IllegalArgumentException("Unknown color");
        }
        return (int) parseLong;
    }

    public static int red(int i) {
        return (i >> 16) & 255;
    }

    public static int rgb(int i, int i2, int i3) {
        return (-16777216) | (i << 16) | (i2 << 8) | i3;
    }

    public static float saturation(int i) {
        int i2 = (i >> 16) & 255;
        int i3 = (i >> 8) & 255;
        int i4 = i & 255;
        int max = Math.max(i4, Math.max(i2, i3));
        int min = Math.min(i4, Math.min(i2, i3));
        if (max == min) {
            return 0.0f;
        }
        return (max - min) / max;
    }
}
