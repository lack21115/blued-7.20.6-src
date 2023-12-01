package libcore.icu;

import java.util.Locale;

/* loaded from: source-2895416-dex2jar.jar:libcore/icu/NativePluralRules.class */
public final class NativePluralRules {
    public static final int FEW = 3;
    public static final int MANY = 4;
    public static final int ONE = 1;
    public static final int OTHER = 5;
    public static final int TWO = 2;
    public static final int ZERO = 0;
    private final long address;

    private NativePluralRules(long j) {
        this.address = j;
    }

    private static native void finalizeImpl(long j);

    public static NativePluralRules forLocale(Locale locale) {
        return new NativePluralRules(forLocaleImpl(locale.toString()));
    }

    private static native long forLocaleImpl(String str);

    private static native int quantityForIntImpl(long j, int i);

    protected void finalize() throws Throwable {
        try {
            finalizeImpl(this.address);
        } finally {
            super.finalize();
        }
    }

    public int quantityForInt(int i) {
        if (i < 0) {
            return 5;
        }
        return quantityForIntImpl(this.address, i);
    }
}
