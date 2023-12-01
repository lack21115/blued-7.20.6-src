package kotlin.text;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CharIterator;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/text/StringsKt__StringsKt.class */
public class StringsKt__StringsKt extends StringsKt__StringsJVMKt {
    public static final int a(CharSequence charSequence, char c, int i, boolean z) {
        Intrinsics.e(charSequence, "<this>");
        return (z || !(charSequence instanceof String)) ? StringsKt.a(charSequence, new char[]{c}, i, z) : ((String) charSequence).indexOf(c, i);
    }

    public static /* synthetic */ int a(CharSequence charSequence, char c, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return StringsKt.a(charSequence, c, i, z);
    }

    /* JADX WARN: Code restructure failed: missing block: B:68:0x0061, code lost:
        if (r0 > r0) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x00b7, code lost:
        if (r0 > r0) goto L46;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static final int a(java.lang.CharSequence r7, java.lang.CharSequence r8, int r9, int r10, boolean r11, boolean r12) {
        /*
            Method dump skipped, instructions count: 235
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.text.StringsKt__StringsKt.a(java.lang.CharSequence, java.lang.CharSequence, int, int, boolean, boolean):int");
    }

    static /* synthetic */ int a(CharSequence charSequence, CharSequence charSequence2, int i, int i2, boolean z, boolean z2, int i3, Object obj) {
        if ((i3 & 16) != 0) {
            z2 = false;
        }
        return a(charSequence, charSequence2, i, i2, z, z2);
    }

    public static final int a(CharSequence charSequence, String string, int i, boolean z) {
        Intrinsics.e(charSequence, "<this>");
        Intrinsics.e(string, "string");
        return (z || !(charSequence instanceof String)) ? a(charSequence, string, i, charSequence.length(), z, false, 16, null) : ((String) charSequence).indexOf(string, i);
    }

    public static /* synthetic */ int a(CharSequence charSequence, String str, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return StringsKt.a(charSequence, str, i, z);
    }

    public static final int a(CharSequence charSequence, char[] chars, int i, boolean z) {
        boolean z2;
        Intrinsics.e(charSequence, "<this>");
        Intrinsics.e(chars, "chars");
        if (!z && chars.length == 1 && (charSequence instanceof String)) {
            return ((String) charSequence).indexOf(ArraysKt.a(chars), i);
        }
        int c = RangesKt.c(i, 0);
        int e = StringsKt.e(charSequence);
        if (c > e) {
            return -1;
        }
        while (true) {
            char charAt = charSequence.charAt(c);
            int length = chars.length;
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= length) {
                    z2 = false;
                    break;
                } else if (CharsKt.a(chars[i3], charAt, z)) {
                    z2 = true;
                    break;
                } else {
                    i2 = i3 + 1;
                }
            }
            if (z2) {
                return c;
            }
            if (c == e) {
                return -1;
            }
            c++;
        }
    }

    public static final CharSequence a(CharSequence charSequence, int i, char c) {
        Intrinsics.e(charSequence, "<this>");
        if (i < 0) {
            throw new IllegalArgumentException("Desired length " + i + " is less than zero.");
        } else if (i <= charSequence.length()) {
            return charSequence.subSequence(0, charSequence.length());
        } else {
            StringBuilder sb = new StringBuilder(i);
            int length = i - charSequence.length();
            int i2 = 1;
            if (1 <= length) {
                while (true) {
                    sb.append(c);
                    if (i2 == length) {
                        break;
                    }
                    i2++;
                }
            }
            sb.append(charSequence);
            return sb;
        }
    }

    public static final CharSequence a(CharSequence charSequence, int i, int i2, CharSequence replacement) {
        Intrinsics.e(charSequence, "<this>");
        Intrinsics.e(replacement, "replacement");
        if (i2 >= i) {
            StringBuilder sb = new StringBuilder();
            sb.append(charSequence, 0, i);
            Intrinsics.c(sb, "this.append(value, startIndex, endIndex)");
            sb.append(replacement);
            sb.append(charSequence, i2, charSequence.length());
            Intrinsics.c(sb, "this.append(value, startIndex, endIndex)");
            return sb;
        }
        throw new IndexOutOfBoundsException("End index (" + i2 + ") is less than start index (" + i + ").");
    }

    public static final String a(CharSequence charSequence, IntRange range) {
        Intrinsics.e(charSequence, "<this>");
        Intrinsics.e(range, "range");
        return charSequence.subSequence(range.getStart().intValue(), range.getEndInclusive().intValue() + 1).toString();
    }

    public static final String a(String str, char c, String missingDelimiterValue) {
        Intrinsics.e(str, "<this>");
        Intrinsics.e(missingDelimiterValue, "missingDelimiterValue");
        int a = StringsKt.a((CharSequence) str, c, 0, false, 6, (Object) null);
        if (a == -1) {
            return missingDelimiterValue;
        }
        String substring = str.substring(0, a);
        Intrinsics.c(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }

    public static /* synthetic */ String a(String str, char c, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = str;
        }
        return StringsKt.a(str, c, str2);
    }

    public static final String a(String str, int i, char c) {
        Intrinsics.e(str, "<this>");
        return StringsKt.a((CharSequence) str, i, c).toString();
    }

    public static final String a(String str, CharSequence prefix) {
        Intrinsics.e(str, "<this>");
        Intrinsics.e(prefix, "prefix");
        String str2 = str;
        if (StringsKt.a((CharSequence) str, prefix, false, 2, (Object) null)) {
            str2 = str.substring(prefix.length());
            Intrinsics.c(str2, "this as java.lang.String).substring(startIndex)");
        }
        return str2;
    }

    public static final String a(String str, String delimiter, String missingDelimiterValue) {
        Intrinsics.e(str, "<this>");
        Intrinsics.e(delimiter, "delimiter");
        Intrinsics.e(missingDelimiterValue, "missingDelimiterValue");
        int a = StringsKt.a((CharSequence) str, delimiter, 0, false, 6, (Object) null);
        if (a == -1) {
            return missingDelimiterValue;
        }
        String substring = str.substring(0, a);
        Intrinsics.c(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }

    public static /* synthetic */ String a(String str, String str2, String str3, int i, Object obj) {
        if ((i & 2) != 0) {
            str3 = str;
        }
        return StringsKt.a(str, str2, str3);
    }

    private static final List<String> a(CharSequence charSequence, String str, boolean z, int i) {
        int length;
        int a;
        StringsKt.a(i);
        int i2 = 0;
        int a2 = StringsKt.a(charSequence, str, 0, z);
        if (a2 == -1 || i == 1) {
            return CollectionsKt.a(charSequence.toString());
        }
        boolean z2 = i > 0;
        int i3 = 10;
        if (z2) {
            i3 = RangesKt.d(i, 10);
        }
        ArrayList arrayList = new ArrayList(i3);
        int i4 = a2;
        do {
            arrayList.add(charSequence.subSequence(i2, i4).toString());
            length = str.length() + i4;
            if (z2 && arrayList.size() == i - 1) {
                break;
            }
            a = StringsKt.a(charSequence, str, length, z);
            i2 = length;
            i4 = a;
        } while (a != -1);
        arrayList.add(charSequence.subSequence(length, charSequence.length()).toString());
        return arrayList;
    }

    private static final Sequence<IntRange> a(CharSequence charSequence, String[] strArr, int i, final boolean z, int i2) {
        StringsKt.a(i2);
        final List a = ArraysKt.a(strArr);
        return new DelimitedRangesSequence(charSequence, i, i2, new Function2<CharSequence, Integer, Pair<? extends Integer, ? extends Integer>>() { // from class: kotlin.text.StringsKt__StringsKt$rangesDelimitedBy$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            public final Pair<Integer, Integer> a(CharSequence $receiver, int i3) {
                Pair b;
                Intrinsics.e($receiver, "$this$$receiver");
                b = StringsKt__StringsKt.b($receiver, (Collection<String>) a, i3, z, false);
                if (b != null) {
                    return TuplesKt.a(b.a(), Integer.valueOf(((String) b.b()).length()));
                }
                return null;
            }

            @Override // kotlin.jvm.functions.Function2
            public /* synthetic */ Pair<? extends Integer, ? extends Integer> invoke(CharSequence charSequence2, Integer num) {
                return a(charSequence2, num.intValue());
            }
        });
    }

    static /* synthetic */ Sequence a(CharSequence charSequence, String[] strArr, int i, boolean z, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            z = false;
        }
        if ((i3 & 8) != 0) {
            i2 = 0;
        }
        return a(charSequence, strArr, i, z, i2);
    }

    public static final Sequence<String> a(final CharSequence charSequence, String[] delimiters, boolean z, int i) {
        Intrinsics.e(charSequence, "<this>");
        Intrinsics.e(delimiters, "delimiters");
        return SequencesKt.c(a(charSequence, delimiters, 0, z, i, 2, null), new Function1<IntRange, String>() { // from class: kotlin.text.StringsKt__StringsKt$splitToSequence$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: a */
            public final String invoke(IntRange it) {
                Intrinsics.e(it, "it");
                return StringsKt.a(CharSequence.this, it);
            }
        });
    }

    public static /* synthetic */ Sequence a(CharSequence charSequence, String[] strArr, boolean z, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        if ((i2 & 4) != 0) {
            i = 0;
        }
        return StringsKt.a(charSequence, strArr, z, i);
    }

    public static final void a(int i) {
        if (i >= 0) {
            return;
        }
        throw new IllegalArgumentException(("Limit must be non-negative, but was " + i).toString());
    }

    public static final boolean a(CharSequence charSequence, char c, boolean z) {
        Intrinsics.e(charSequence, "<this>");
        return StringsKt.a(charSequence, c, 0, z, 2, (Object) null) >= 0;
    }

    public static /* synthetic */ boolean a(CharSequence charSequence, char c, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return StringsKt.a(charSequence, c, z);
    }

    public static final boolean a(CharSequence charSequence, int i, CharSequence other, int i2, int i3, boolean z) {
        Intrinsics.e(charSequence, "<this>");
        Intrinsics.e(other, "other");
        if (i2 < 0 || i < 0 || i > charSequence.length() - i3 || i2 > other.length() - i3) {
            return false;
        }
        int i4 = 0;
        while (true) {
            int i5 = i4;
            if (i5 >= i3) {
                return true;
            }
            if (!CharsKt.a(charSequence.charAt(i + i5), other.charAt(i2 + i5), z)) {
                return false;
            }
            i4 = i5 + 1;
        }
    }

    public static final boolean a(CharSequence charSequence, CharSequence prefix, boolean z) {
        Intrinsics.e(charSequence, "<this>");
        Intrinsics.e(prefix, "prefix");
        return (!z && (charSequence instanceof String) && (prefix instanceof String)) ? StringsKt.a((String) charSequence, (String) prefix, false, 2, (Object) null) : StringsKt.a(charSequence, 0, prefix, 0, prefix.length(), z);
    }

    public static /* synthetic */ boolean a(CharSequence charSequence, CharSequence charSequence2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return StringsKt.a(charSequence, charSequence2, z);
    }

    public static final int b(CharSequence charSequence, char c, int i, boolean z) {
        Intrinsics.e(charSequence, "<this>");
        return (z || !(charSequence instanceof String)) ? StringsKt.b(charSequence, new char[]{c}, i, z) : ((String) charSequence).lastIndexOf(c, i);
    }

    public static /* synthetic */ int b(CharSequence charSequence, char c, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = StringsKt.e(charSequence);
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return StringsKt.b(charSequence, c, i, z);
    }

    public static final int b(CharSequence charSequence, String string, int i, boolean z) {
        Intrinsics.e(charSequence, "<this>");
        Intrinsics.e(string, "string");
        return (z || !(charSequence instanceof String)) ? a(charSequence, (CharSequence) string, i, 0, z, true) : ((String) charSequence).lastIndexOf(string, i);
    }

    public static /* synthetic */ int b(CharSequence charSequence, String str, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = StringsKt.e(charSequence);
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return StringsKt.b(charSequence, str, i, z);
    }

    public static final int b(CharSequence charSequence, char[] chars, int i, boolean z) {
        boolean z2;
        Intrinsics.e(charSequence, "<this>");
        Intrinsics.e(chars, "chars");
        if (!z && chars.length == 1 && (charSequence instanceof String)) {
            return ((String) charSequence).lastIndexOf(ArraysKt.a(chars), i);
        }
        int d = RangesKt.d(i, StringsKt.e(charSequence));
        while (true) {
            int i2 = d;
            if (-1 >= i2) {
                return -1;
            }
            char charAt = charSequence.charAt(i2);
            int length = chars.length;
            int i3 = 0;
            while (true) {
                int i4 = i3;
                z2 = false;
                if (i4 >= length) {
                    break;
                } else if (CharsKt.a(chars[i4], charAt, z)) {
                    z2 = true;
                    break;
                } else {
                    i3 = i4 + 1;
                }
            }
            if (z2) {
                return i2;
            }
            d = i2 - 1;
        }
    }

    public static final CharSequence b(CharSequence charSequence) {
        Intrinsics.e(charSequence, "<this>");
        int length = charSequence.length() - 1;
        int i = 0;
        boolean z = false;
        while (i <= length) {
            boolean a = CharsKt.a(charSequence.charAt(!z ? i : length));
            if (z) {
                if (!a) {
                    break;
                }
                length--;
            } else if (a) {
                i++;
            } else {
                z = true;
            }
        }
        return charSequence.subSequence(i, length + 1);
    }

    public static final String b(String str, char c, String missingDelimiterValue) {
        Intrinsics.e(str, "<this>");
        Intrinsics.e(missingDelimiterValue, "missingDelimiterValue");
        int a = StringsKt.a((CharSequence) str, c, 0, false, 6, (Object) null);
        if (a == -1) {
            return missingDelimiterValue;
        }
        String substring = str.substring(a + 1, str.length());
        Intrinsics.c(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }

    public static /* synthetic */ String b(String str, char c, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = str;
        }
        return StringsKt.b(str, c, str2);
    }

    public static final String b(String str, String delimiter, String missingDelimiterValue) {
        Intrinsics.e(str, "<this>");
        Intrinsics.e(delimiter, "delimiter");
        Intrinsics.e(missingDelimiterValue, "missingDelimiterValue");
        int a = StringsKt.a((CharSequence) str, delimiter, 0, false, 6, (Object) null);
        if (a == -1) {
            return missingDelimiterValue;
        }
        String substring = str.substring(a + delimiter.length(), str.length());
        Intrinsics.c(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }

    public static /* synthetic */ String b(String str, String str2, String str3, int i, Object obj) {
        if ((i & 2) != 0) {
            str3 = str;
        }
        return StringsKt.b(str, str2, str3);
    }

    public static final List<String> b(CharSequence charSequence, String[] delimiters, boolean z, int i) {
        Intrinsics.e(charSequence, "<this>");
        Intrinsics.e(delimiters, "delimiters");
        if (delimiters.length == 1) {
            String str = delimiters[0];
            if (!(str.length() == 0)) {
                return a(charSequence, str, z, i);
            }
        }
        Iterable<IntRange> g = SequencesKt.g(a(charSequence, delimiters, 0, z, i, 2, null));
        ArrayList arrayList = new ArrayList(CollectionsKt.a(g, 10));
        for (IntRange intRange : g) {
            arrayList.add(StringsKt.a(charSequence, intRange));
        }
        return arrayList;
    }

    public static /* synthetic */ List b(CharSequence charSequence, String[] strArr, boolean z, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        if ((i2 & 4) != 0) {
            i = 0;
        }
        return StringsKt.b(charSequence, strArr, z, i);
    }

    /* JADX WARN: Code restructure failed: missing block: B:110:0x0099, code lost:
        if (r0 > r0) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:133:0x012f, code lost:
        if (r0 > r0) goto L73;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final kotlin.Pair<java.lang.Integer, java.lang.String> b(java.lang.CharSequence r7, java.util.Collection<java.lang.String> r8, int r9, boolean r10, boolean r11) {
        /*
            Method dump skipped, instructions count: 422
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.text.StringsKt__StringsKt.b(java.lang.CharSequence, java.util.Collection, int, boolean, boolean):kotlin.Pair");
    }

    public static final boolean b(CharSequence charSequence, CharSequence charSequence2) {
        if ((charSequence instanceof String) && (charSequence2 instanceof String)) {
            return Intrinsics.a(charSequence, charSequence2);
        }
        if (charSequence == charSequence2) {
            return true;
        }
        if (charSequence == null || charSequence2 == null || charSequence.length() != charSequence2.length()) {
            return false;
        }
        int length = charSequence.length();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return true;
            }
            if (charSequence.charAt(i2) != charSequence2.charAt(i2)) {
                return false;
            }
            i = i2 + 1;
        }
    }

    public static final boolean b(CharSequence charSequence, CharSequence suffix, boolean z) {
        Intrinsics.e(charSequence, "<this>");
        Intrinsics.e(suffix, "suffix");
        return (!z && (charSequence instanceof String) && (suffix instanceof String)) ? StringsKt.b((String) charSequence, (String) suffix, false, 2, (Object) null) : StringsKt.a(charSequence, charSequence.length() - suffix.length(), suffix, 0, suffix.length(), z);
    }

    public static /* synthetic */ boolean b(CharSequence charSequence, CharSequence charSequence2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return StringsKt.b(charSequence, charSequence2, z);
    }

    public static final String c(String str, char c, String missingDelimiterValue) {
        Intrinsics.e(str, "<this>");
        Intrinsics.e(missingDelimiterValue, "missingDelimiterValue");
        int b = StringsKt.b((CharSequence) str, c, 0, false, 6, (Object) null);
        if (b == -1) {
            return missingDelimiterValue;
        }
        String substring = str.substring(b + 1, str.length());
        Intrinsics.c(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }

    public static /* synthetic */ String c(String str, char c, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = str;
        }
        return StringsKt.c(str, c, str2);
    }

    public static final CharIterator c(final CharSequence charSequence) {
        Intrinsics.e(charSequence, "<this>");
        return new CharIterator() { // from class: kotlin.text.StringsKt__StringsKt$iterator$1
            private int b;

            @Override // kotlin.collections.CharIterator
            public char a() {
                CharSequence charSequence2 = CharSequence.this;
                int i = this.b;
                this.b = i + 1;
                return charSequence2.charAt(i);
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.b < CharSequence.this.length();
            }
        };
    }

    public static final boolean c(CharSequence charSequence, CharSequence other, boolean z) {
        Intrinsics.e(charSequence, "<this>");
        Intrinsics.e(other, "other");
        return other instanceof String ? StringsKt.a(charSequence, (String) other, 0, z, 2, (Object) null) >= 0 : a(charSequence, other, 0, charSequence.length(), z, false, 16, null) >= 0;
    }

    public static /* synthetic */ boolean c(CharSequence charSequence, CharSequence charSequence2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return StringsKt.c(charSequence, charSequence2, z);
    }

    public static final IntRange d(CharSequence charSequence) {
        Intrinsics.e(charSequence, "<this>");
        return new IntRange(0, charSequence.length() - 1);
    }

    public static final int e(CharSequence charSequence) {
        Intrinsics.e(charSequence, "<this>");
        return charSequence.length() - 1;
    }

    public static final Sequence<String> f(CharSequence charSequence) {
        Intrinsics.e(charSequence, "<this>");
        return StringsKt.a(charSequence, new String[]{"\r\n", "\n", "\r"}, false, 0, 6, (Object) null);
    }

    public static final List<String> g(CharSequence charSequence) {
        Intrinsics.e(charSequence, "<this>");
        return SequencesKt.d(StringsKt.f(charSequence));
    }
}
