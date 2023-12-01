package java.net;

import libcore.icu.NativeIDN;

/* loaded from: source-2895416-dex2jar.jar:java/net/IDN.class */
public final class IDN {
    public static final int ALLOW_UNASSIGNED = 1;
    public static final int USE_STD3_ASCII_RULES = 2;

    private IDN() {
    }

    public static String toASCII(String str) {
        return toASCII(str, 0);
    }

    public static String toASCII(String str, int i) {
        return NativeIDN.toASCII(str, i);
    }

    public static String toUnicode(String str) {
        return NativeIDN.toUnicode(str, 0);
    }

    public static String toUnicode(String str, int i) {
        return NativeIDN.toUnicode(str, i);
    }
}
