package kotlin.text;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/text/StringsKt__IndentKt.class */
public class StringsKt__IndentKt extends StringsKt__AppendableKt {
    public static final String a(String str) {
        Intrinsics.e(str, "<this>");
        return StringsKt.a(str, "");
    }

    public static final String a(String str, String newIndent) {
        String str2;
        Intrinsics.e(str, "<this>");
        Intrinsics.e(newIndent, "newIndent");
        List<String> g = StringsKt.g(str);
        List<String> list = g;
        ArrayList arrayList = new ArrayList();
        for (String str3 : list) {
            if (!StringsKt.a((CharSequence) str3)) {
                arrayList.add(str3);
            }
        }
        ArrayList<String> arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList(CollectionsKt.a((Iterable) arrayList2, 10));
        for (String str4 : arrayList2) {
            arrayList3.add(Integer.valueOf(b(str4)));
        }
        Integer num = (Integer) CollectionsKt.l((Iterable<? extends Comparable>) arrayList3);
        int i = 0;
        int intValue = num != null ? num.intValue() : 0;
        int length = str.length();
        int length2 = newIndent.length();
        int size = g.size();
        Function1<String, String> c2 = c(newIndent);
        int b = CollectionsKt.b((List) g);
        ArrayList arrayList4 = new ArrayList();
        for (String str5 : list) {
            if (i < 0) {
                CollectionsKt.c();
            }
            String str6 = str5;
            if ((i == 0 || i == b) && StringsKt.a((CharSequence) str6)) {
                str2 = null;
            } else {
                String c3 = StringsKt.c(str6, intValue);
                str2 = str6;
                if (c3 != null) {
                    str2 = c2.invoke(c3);
                    if (str2 == null) {
                        str2 = str6;
                    }
                }
            }
            if (str2 != null) {
                arrayList4.add(str2);
            }
            i++;
        }
        String sb = ((StringBuilder) CollectionsKt.a(arrayList4, new StringBuilder(length + (length2 * size)), "\n", null, null, 0, null, null, 124, null)).toString();
        Intrinsics.c(sb, "mapIndexedNotNull { inde…\"\\n\")\n        .toString()");
        return sb;
    }

    private static final int b(String str) {
        String str2;
        int i;
        int length = str.length();
        int i2 = 0;
        while (true) {
            i = i2;
            if (i >= length) {
                i = -1;
                break;
            } else if (!CharsKt.a(str2.charAt(i))) {
                break;
            } else {
                i2 = i + 1;
            }
        }
        int i3 = i;
        if (i == -1) {
            i3 = str.length();
        }
        return i3;
    }

    private static final Function1<String, String> c(final String str) {
        return str.length() == 0 ? new Function1<String, String>() { // from class: kotlin.text.StringsKt__IndentKt$getIndentFunction$1
            @Override // kotlin.jvm.functions.Function1
            /* renamed from: a */
            public final String invoke(String line) {
                Intrinsics.e(line, "line");
                return line;
            }
        } : new Function1<String, String>() { // from class: kotlin.text.StringsKt__IndentKt$getIndentFunction$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* renamed from: a */
            public final String invoke(String line) {
                Intrinsics.e(line, "line");
                return String.this + line;
            }
        };
    }
}
