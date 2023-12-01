package libcore.icu;

/* loaded from: source-2895416-dex2jar.jar:libcore/icu/NativeIDN.class */
public final class NativeIDN {
    private NativeIDN() {
    }

    private static String convert(String str, int i, boolean z) {
        if (str == null) {
            throw new NullPointerException("s == null");
        }
        return convertImpl(str, i, z);
    }

    private static native String convertImpl(String str, int i, boolean z);

    public static String toASCII(String str, int i) {
        return convert(str, i, true);
    }

    public static String toUnicode(String str, int i) {
        try {
            return convert(str, i, false);
        } catch (IllegalArgumentException e) {
            return str;
        }
    }
}
