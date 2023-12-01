package kotlin.text;

import java.util.Locale;
import kotlin.Deprecated;
import kotlin.DeprecatedSinceKotlin;
import kotlin.Metadata;
import kotlin.collections.AbstractList;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/text/StringsKt__StringsJVMKt.class */
public class StringsKt__StringsJVMKt extends StringsKt__StringNumberConversionsKt {
    public static final String a(CharSequence charSequence, int i) {
        Intrinsics.e(charSequence, "<this>");
        if (!(i >= 0)) {
            throw new IllegalArgumentException(("Count 'n' must be non-negative, but was " + i + '.').toString());
        }
        String str = "";
        if (i != 0) {
            if (i != 1) {
                int length = charSequence.length();
                str = "";
                if (length != 0) {
                    if (length != 1) {
                        StringBuilder sb = new StringBuilder(charSequence.length() * i);
                        if (1 <= i) {
                            int i2 = 1;
                            while (true) {
                                int i3 = i2;
                                sb.append(charSequence);
                                if (i3 == i) {
                                    break;
                                }
                                i2 = i3 + 1;
                            }
                        }
                        String sb2 = sb.toString();
                        Intrinsics.c(sb2, "{\n                    va…tring()\n                }");
                        return sb2;
                    }
                    char charAt = charSequence.charAt(0);
                    char[] cArr = new char[i];
                    int i4 = 0;
                    while (true) {
                        int i5 = i4;
                        if (i5 >= i) {
                            return new String(cArr);
                        }
                        cArr[i5] = charAt;
                        i4 = i5 + 1;
                    }
                }
            } else {
                str = charSequence.toString();
            }
        }
        return str;
    }

    public static final String a(String str, char c2, char c3, boolean z) {
        Intrinsics.e(str, "<this>");
        if (!z) {
            String replace = str.replace(c2, c3);
            Intrinsics.c(replace, "this as java.lang.String…replace(oldChar, newChar)");
            return replace;
        }
        StringBuilder sb = new StringBuilder(str.length());
        String str2 = str;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= str2.length()) {
                String sb2 = sb.toString();
                Intrinsics.c(sb2, "StringBuilder(capacity).…builderAction).toString()");
                return sb2;
            }
            char charAt = str2.charAt(i2);
            char c4 = charAt;
            if (CharsKt.a(charAt, c2, z)) {
                c4 = c3;
            }
            sb.append(c4);
            i = i2 + 1;
        }
    }

    public static /* synthetic */ String a(String str, char c2, char c3, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        return StringsKt.a(str, c2, c3, z);
    }

    public static final String a(String str, String oldValue, String newValue, boolean z) {
        int i;
        int a2;
        Intrinsics.e(str, "<this>");
        Intrinsics.e(oldValue, "oldValue");
        Intrinsics.e(newValue, "newValue");
        String str2 = str;
        int i2 = 0;
        int a3 = StringsKt.a(str2, oldValue, 0, z);
        if (a3 < 0) {
            return str;
        }
        int length = oldValue.length();
        int c2 = RangesKt.c(length, 1);
        int length2 = (str.length() - length) + newValue.length();
        if (length2 >= 0) {
            StringBuilder sb = new StringBuilder(length2);
            do {
                sb.append((CharSequence) str2, i2, a3);
                sb.append(newValue);
                i = a3 + length;
                if (a3 >= str.length()) {
                    break;
                }
                a2 = StringsKt.a(str2, oldValue, a3 + c2, z);
                i2 = i;
                a3 = a2;
            } while (a2 > 0);
            sb.append((CharSequence) str2, i, str.length());
            String sb2 = sb.toString();
            Intrinsics.c(sb2, "stringBuilder.append(this, i, length).toString()");
            return sb2;
        }
        throw new OutOfMemoryError();
    }

    public static /* synthetic */ String a(String str, String str2, String str3, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        return StringsKt.a(str, str2, str3, z);
    }

    @Deprecated
    @DeprecatedSinceKotlin
    public static final String a(String str, Locale locale) {
        Intrinsics.e(str, "<this>");
        Intrinsics.e(locale, "locale");
        String str2 = str;
        if (str.length() > 0) {
            char charAt = str.charAt(0);
            str2 = str;
            if (Character.isLowerCase(charAt)) {
                StringBuilder sb = new StringBuilder();
                char titleCase = Character.toTitleCase(charAt);
                if (titleCase != Character.toUpperCase(charAt)) {
                    sb.append(titleCase);
                } else {
                    String substring = str.substring(0, 1);
                    Intrinsics.c(substring, "this as java.lang.String…ing(startIndex, endIndex)");
                    String upperCase = substring.toUpperCase(locale);
                    Intrinsics.c(upperCase, "this as java.lang.String).toUpperCase(locale)");
                    sb.append(upperCase);
                }
                String substring2 = str.substring(1);
                Intrinsics.c(substring2, "this as java.lang.String).substring(startIndex)");
                sb.append(substring2);
                str2 = sb.toString();
                Intrinsics.c(str2, "StringBuilder().apply(builderAction).toString()");
            }
        }
        return str2;
    }

    public static final String a(char[] cArr) {
        Intrinsics.e(cArr, "<this>");
        return new String(cArr);
    }

    public static final String a(char[] cArr, int i, int i2) {
        Intrinsics.e(cArr, "<this>");
        AbstractList.Companion.b(i, i2, cArr.length);
        return new String(cArr, i, i2 - i);
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x0059, code lost:
        if (r4 != false) goto L21;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final boolean a(java.lang.CharSequence r3) {
        /*
            r0 = r3
            java.lang.String r1 = "<this>"
            kotlin.jvm.internal.Intrinsics.e(r0, r1)
            r0 = r3
            int r0 = r0.length()
            r4 = r0
            r0 = 0
            r5 = r0
            r0 = r4
            if (r0 == 0) goto L5c
            r0 = r3
            kotlin.ranges.IntRange r0 = kotlin.text.StringsKt.d(r0)
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            r6 = r0
            r0 = r6
            boolean r0 = r0 instanceof java.util.Collection
            if (r0 == 0) goto L33
            r0 = r6
            java.util.Collection r0 = (java.util.Collection) r0
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L33
        L2e:
            r0 = 1
            r4 = r0
            goto L58
        L33:
            r0 = r6
            java.util.Iterator r0 = r0.iterator()
            r6 = r0
        L3a:
            r0 = r6
            boolean r0 = r0.hasNext()
            if (r0 == 0) goto L2e
            r0 = r3
            r1 = r6
            kotlin.collections.IntIterator r1 = (kotlin.collections.IntIterator) r1
            int r1 = r1.nextInt()
            char r0 = r0.charAt(r1)
            boolean r0 = kotlin.text.CharsKt.a(r0)
            if (r0 != 0) goto L3a
            r0 = 0
            r4 = r0
        L58:
            r0 = r4
            if (r0 == 0) goto L5e
        L5c:
            r0 = 1
            r5 = r0
        L5e:
            r0 = r5
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.text.StringsKt__StringsJVMKt.a(java.lang.CharSequence):boolean");
    }

    public static final boolean a(CharSequence charSequence, CharSequence charSequence2) {
        return (!(charSequence instanceof String) || charSequence2 == null) ? StringsKt.b(charSequence, charSequence2) : ((String) charSequence).contentEquals(charSequence2);
    }

    public static final boolean a(String str, int i, String other, int i2, int i3, boolean z) {
        Intrinsics.e(str, "<this>");
        Intrinsics.e(other, "other");
        return !z ? str.regionMatches(i, other, i2, i3) : str.regionMatches(z, i, other, i2, i3);
    }

    public static final boolean a(String str, String str2, boolean z) {
        return str == null ? str2 == null : !z ? str.equals(str2) : str.equalsIgnoreCase(str2);
    }

    public static /* synthetic */ boolean a(String str, String str2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return StringsKt.b(str, str2, z);
    }

    public static final String b(String str, String oldValue, String newValue, boolean z) {
        Intrinsics.e(str, "<this>");
        Intrinsics.e(oldValue, "oldValue");
        Intrinsics.e(newValue, "newValue");
        String str2 = str;
        int a2 = StringsKt.a(str2, oldValue, 0, z, 2, (Object) null);
        return a2 < 0 ? str : StringsKt.a(str2, a2, oldValue.length() + a2, newValue).toString();
    }

    public static /* synthetic */ String b(String str, String str2, String str3, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        return StringsKt.b(str, str2, str3, z);
    }

    public static final boolean b(String str, String prefix, boolean z) {
        Intrinsics.e(str, "<this>");
        Intrinsics.e(prefix, "prefix");
        return !z ? str.startsWith(prefix) : StringsKt.a(str, 0, prefix, 0, prefix.length(), z);
    }

    public static /* synthetic */ boolean b(String str, String str2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return StringsKt.c(str, str2, z);
    }

    public static final boolean c(String str, String suffix, boolean z) {
        Intrinsics.e(str, "<this>");
        Intrinsics.e(suffix, "suffix");
        return !z ? str.endsWith(suffix) : StringsKt.a(str, str.length() - suffix.length(), suffix, 0, suffix.length(), true);
    }

    @Deprecated
    @DeprecatedSinceKotlin
    public static final String d(String str) {
        Intrinsics.e(str, "<this>");
        Locale locale = Locale.getDefault();
        Intrinsics.c(locale, "getDefault()");
        return StringsKt.a(str, locale);
    }
}
