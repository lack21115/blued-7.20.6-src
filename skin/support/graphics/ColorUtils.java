package skin.support.graphics;

/* loaded from: source-3503164-dex2jar.jar:skin/support/graphics/ColorUtils.class */
public final class ColorUtils {
    public static int a(int i, int i2) {
        if (i2 < 0 || i2 > 255) {
            throw new IllegalArgumentException("alpha must be between 0 and 255.");
        }
        return (i & 16777215) | (i2 << 24);
    }
}
