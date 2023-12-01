package android.graphics;

/* loaded from: source-9557208-dex2jar.jar:android/graphics/PixelFormat.class */
public class PixelFormat {
    @Deprecated
    public static final int A_8 = 8;
    @Deprecated
    public static final int JPEG = 256;
    @Deprecated
    public static final int LA_88 = 10;
    @Deprecated
    public static final int L_8 = 9;
    public static final int OPAQUE = -1;
    @Deprecated
    public static final int RGBA_4444 = 7;
    @Deprecated
    public static final int RGBA_5551 = 6;
    public static final int RGBA_8888 = 1;
    public static final int RGBX_8888 = 2;
    @Deprecated
    public static final int RGB_332 = 11;
    public static final int RGB_565 = 4;
    public static final int RGB_888 = 3;
    public static final int TRANSLUCENT = -3;
    public static final int TRANSPARENT = -2;
    public static final int UNKNOWN = 0;
    @Deprecated
    public static final int YCbCr_420_SP = 17;
    @Deprecated
    public static final int YCbCr_422_I = 20;
    @Deprecated
    public static final int YCbCr_422_SP = 16;
    public int bitsPerPixel;
    public int bytesPerPixel;

    public static boolean formatHasAlpha(int i) {
        switch (i) {
            case -3:
            case -2:
            case 1:
            case 6:
            case 7:
            case 8:
            case 10:
                return true;
            case -1:
            case 0:
            case 2:
            case 3:
            case 4:
            case 5:
            case 9:
            default:
                return false;
        }
    }

    public static void getPixelFormatInfo(int i, PixelFormat pixelFormat) {
        switch (i) {
            case 1:
            case 2:
                pixelFormat.bitsPerPixel = 32;
                pixelFormat.bytesPerPixel = 4;
                return;
            case 3:
                pixelFormat.bitsPerPixel = 24;
                pixelFormat.bytesPerPixel = 3;
                return;
            case 4:
            case 6:
            case 7:
            case 10:
                pixelFormat.bitsPerPixel = 16;
                pixelFormat.bytesPerPixel = 2;
                return;
            case 5:
            case 12:
            case 13:
            case 14:
            case 15:
            case 18:
            case 19:
            default:
                throw new IllegalArgumentException("unknown pixel format " + i);
            case 8:
            case 9:
            case 11:
                pixelFormat.bitsPerPixel = 8;
                pixelFormat.bytesPerPixel = 1;
                return;
            case 16:
            case 20:
                pixelFormat.bitsPerPixel = 16;
                pixelFormat.bytesPerPixel = 1;
                return;
            case 17:
                pixelFormat.bitsPerPixel = 12;
                pixelFormat.bytesPerPixel = 1;
                return;
        }
    }

    public static boolean isPublicFormat(int i) {
        switch (i) {
            case 1:
            case 2:
            case 3:
            case 4:
                return true;
            default:
                return false;
        }
    }
}
