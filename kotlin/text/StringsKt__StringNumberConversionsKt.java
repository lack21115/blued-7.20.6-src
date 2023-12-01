package kotlin.text;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/text/StringsKt__StringNumberConversionsKt.class */
public class StringsKt__StringNumberConversionsKt extends StringsKt__StringNumberConversionsJVMKt {
    public static final Integer a(String str, int i) {
        boolean z;
        Intrinsics.e(str, "<this>");
        CharsKt.a(i);
        int length = str.length();
        if (length == 0) {
            return null;
        }
        int i2 = 0;
        char charAt = str.charAt(0);
        int i3 = -2147483647;
        int i4 = 1;
        if (Intrinsics.a((int) charAt, 48) >= 0) {
            z = false;
            i4 = 0;
        } else if (length == 1) {
            return null;
        } else {
            if (charAt == '-') {
                i3 = Integer.MIN_VALUE;
                z = true;
            } else if (charAt != '+') {
                return null;
            } else {
                z = false;
            }
        }
        int i5 = -59652323;
        while (true) {
            int i6 = i5;
            if (i4 >= length) {
                return z ? Integer.valueOf(i2) : Integer.valueOf(-i2);
            }
            int a = CharsKt.a(str.charAt(i4), i);
            if (a < 0) {
                return null;
            }
            int i7 = i6;
            if (i2 < i6) {
                if (i6 != -59652323) {
                    return null;
                }
                int i8 = i3 / i;
                i7 = i8;
                if (i2 < i8) {
                    return null;
                }
            }
            int i9 = i2 * i;
            if (i9 < i3 + a) {
                return null;
            }
            i2 = i9 - a;
            i4++;
            i5 = i7;
        }
    }

    public static final Integer b(String str) {
        Intrinsics.e(str, "<this>");
        return StringsKt.a(str, 10);
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00d4 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Long b(java.lang.String r7, int r8) {
        /*
            Method dump skipped, instructions count: 229
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.text.StringsKt__StringNumberConversionsKt.b(java.lang.String, int):java.lang.Long");
    }

    public static final Long c(String str) {
        Intrinsics.e(str, "<this>");
        return StringsKt.b(str, 10);
    }
}
