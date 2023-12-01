package androidx.core.text;

import android.text.TextUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-8756600-dex2jar.jar:androidx/core/text/StringKt.class */
public final class StringKt {
    public static final String htmlEncode(String str) {
        Intrinsics.e(str, "<this>");
        String htmlEncode = TextUtils.htmlEncode(str);
        Intrinsics.c(htmlEncode, "htmlEncode(this)");
        return htmlEncode;
    }
}
