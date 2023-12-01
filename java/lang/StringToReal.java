package java.lang;

import androidx.constraintlayout.core.motion.utils.TypedValues;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-2895416-dex2jar.jar:java/lang/StringToReal.class */
public final class StringToReal {

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-2895416-dex2jar.jar:java/lang/StringToReal$StringExponentPair.class */
    public static final class StringExponentPair {
        long e;
        boolean infinity;
        boolean negative;
        String s;
        boolean zero;

        private StringExponentPair() {
        }

        public float specialValue() {
            return this.infinity ? this.negative ? Float.NEGATIVE_INFINITY : Float.POSITIVE_INFINITY : this.negative ? 0.0f : 0.0f;
        }
    }

    StringToReal() {
    }

    /* JADX WARN: Code restructure failed: missing block: B:118:0x0284, code lost:
        if (r9 != 0) goto L124;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x004c, code lost:
        if (r0 == 'f') goto L144;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00a9, code lost:
        if (r0 == '-') goto L138;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x01d4, code lost:
        throw invalidReal(r6, r8);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.lang.StringToReal.StringExponentPair initialParse(java.lang.String r6, int r7, boolean r8) {
        /*
            Method dump skipped, instructions count: 792
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: java.lang.StringToReal.initialParse(java.lang.String, int, boolean):java.lang.StringToReal$StringExponentPair");
    }

    private static NumberFormatException invalidReal(String str, boolean z) {
        throw new NumberFormatException("Invalid " + (z ? "double" : TypedValues.Custom.S_FLOAT) + ": \"" + str + "\"");
    }

    private static native double parseDblImpl(String str, int i);

    public static double parseDouble(String str) {
        double parseName;
        String trim = str.trim();
        int length = trim.length();
        if (length == 0) {
            throw invalidReal(trim, true);
        }
        char charAt = trim.charAt(length - 1);
        if (charAt == 'y' || charAt == 'N') {
            parseName = parseName(trim, true);
        } else if (trim.indexOf("0x") != -1 || trim.indexOf("0X") != -1) {
            return HexStringParser.parseDouble(trim);
        } else {
            StringExponentPair initialParse = initialParse(trim, length, true);
            if (initialParse.infinity || initialParse.zero) {
                return initialParse.specialValue();
            }
            double parseDblImpl = parseDblImpl(initialParse.s, (int) initialParse.e);
            if (Double.doubleToRawLongBits(parseDblImpl) == -1) {
                throw invalidReal(trim, true);
            }
            parseName = parseDblImpl;
            if (initialParse.negative) {
                return -parseDblImpl;
            }
        }
        return parseName;
    }

    public static float parseFloat(String str) {
        float parseName;
        String trim = str.trim();
        int length = trim.length();
        if (length == 0) {
            throw invalidReal(trim, false);
        }
        char charAt = trim.charAt(length - 1);
        if (charAt == 'y' || charAt == 'N') {
            parseName = parseName(trim, false);
        } else if (trim.indexOf("0x") != -1 || trim.indexOf("0X") != -1) {
            return HexStringParser.parseFloat(trim);
        } else {
            StringExponentPair initialParse = initialParse(trim, length, false);
            if (initialParse.infinity || initialParse.zero) {
                return initialParse.specialValue();
            }
            float parseFltImpl = parseFltImpl(initialParse.s, (int) initialParse.e);
            if (Float.floatToRawIntBits(parseFltImpl) == -1) {
                throw invalidReal(trim, false);
            }
            parseName = parseFltImpl;
            if (initialParse.negative) {
                return -parseFltImpl;
            }
        }
        return parseName;
    }

    private static native float parseFltImpl(String str, int i);

    private static float parseName(String str, boolean z) {
        int i;
        boolean z2;
        int i2 = 0;
        int length = str.length();
        char charAt = str.charAt(0);
        if (charAt == '-') {
            z2 = true;
            i2 = 0 + 1;
            i = length - 1;
        } else {
            i = length;
            z2 = false;
            if (charAt == '+') {
                i2 = 0 + 1;
                i = length - 1;
                z2 = false;
            }
        }
        if (i == 8 && str.regionMatches(false, i2, "Infinity", 0, 8)) {
            return z2 ? Float.NEGATIVE_INFINITY : Float.POSITIVE_INFINITY;
        } else if (i == 3 && str.regionMatches(false, i2, "NaN", 0, 3)) {
            return Float.NaN;
        } else {
            throw invalidReal(str, z);
        }
    }
}
