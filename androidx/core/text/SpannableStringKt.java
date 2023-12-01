package androidx.core.text;

import android.text.Spannable;
import android.text.SpannableString;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

@Metadata
/* loaded from: source-8756600-dex2jar.jar:androidx/core/text/SpannableStringKt.class */
public final class SpannableStringKt {
    public static final void clearSpans(Spannable spannable) {
        Intrinsics.e(spannable, "<this>");
        Spannable spannable2 = spannable;
        Object[] spans = spannable2.getSpans(0, spannable2.length(), Object.class);
        Intrinsics.c(spans, "getSpans(start, end, T::class.java)");
        for (Object obj : spans) {
            spannable.removeSpan(obj);
        }
    }

    public static final void set(Spannable spannable, int i, int i2, Object span) {
        Intrinsics.e(spannable, "<this>");
        Intrinsics.e(span, "span");
        spannable.setSpan(span, i, i2, 17);
    }

    public static final void set(Spannable spannable, IntRange range, Object span) {
        Intrinsics.e(spannable, "<this>");
        Intrinsics.e(range, "range");
        Intrinsics.e(span, "span");
        spannable.setSpan(span, range.getStart().intValue(), range.getEndInclusive().intValue(), 17);
    }

    public static final Spannable toSpannable(CharSequence charSequence) {
        Intrinsics.e(charSequence, "<this>");
        SpannableString valueOf = SpannableString.valueOf(charSequence);
        Intrinsics.c(valueOf, "valueOf(this)");
        return valueOf;
    }
}
