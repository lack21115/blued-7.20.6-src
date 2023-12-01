package skin.support.widget;

/* loaded from: source-3503164-dex2jar.jar:skin/support/widget/SkinCompatHelper.class */
public abstract class SkinCompatHelper {
    public static final int b(int i) {
        int i2 = i;
        if (Integer.toHexString(i).startsWith("1")) {
            i2 = 0;
        }
        return i2;
    }
}
