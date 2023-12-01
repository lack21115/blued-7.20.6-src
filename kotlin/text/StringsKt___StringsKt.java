package kotlin.text;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata
/* loaded from: source-3503164-dex2jar.jar:kotlin/text/StringsKt___StringsKt.class */
public class StringsKt___StringsKt extends StringsKt___StringsJvmKt {
    public static final String c(String str, int i) {
        Intrinsics.e(str, "<this>");
        if (i >= 0) {
            String substring = str.substring(RangesKt.d(i, str.length()));
            Intrinsics.c(substring, "this as java.lang.String).substring(startIndex)");
            return substring;
        }
        throw new IllegalArgumentException(("Requested character count " + i + " is less than zero.").toString());
    }
}
