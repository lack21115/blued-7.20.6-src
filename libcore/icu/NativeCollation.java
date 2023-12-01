package libcore.icu;

import java.util.Locale;

/* loaded from: source-2895416-dex2jar.jar:libcore/icu/NativeCollation.class */
public final class NativeCollation {
    private NativeCollation() {
    }

    public static native void closeCollator(long j);

    public static native void closeElements(long j);

    public static native int compare(long j, String str, String str2);

    public static native int getAttribute(long j, int i);

    public static native long getCollationElementIterator(long j, String str);

    public static native int getMaxExpansion(long j, int i);

    public static native int getOffset(long j);

    public static native String getRules(long j);

    public static native byte[] getSortKey(long j, String str);

    public static native int next(long j);

    private static native long openCollator(String str);

    public static long openCollator(Locale locale) {
        return openCollator(locale.toLanguageTag());
    }

    public static native long openCollatorFromRules(String str, int i, int i2);

    public static native int previous(long j);

    public static native void reset(long j);

    public static native long safeClone(long j);

    public static native void setAttribute(long j, int i, int i2);

    public static native void setOffset(long j, int i);

    public static native void setText(long j, String str);
}
