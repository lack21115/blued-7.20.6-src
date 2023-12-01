package io.noties.markwon.utils;

import android.text.Spanned;

/* loaded from: source-3503164-dex2jar.jar:io/noties/markwon/utils/LeadingMarginUtils.class */
public abstract class LeadingMarginUtils {
    private LeadingMarginUtils() {
    }

    public static boolean selfEnd(int i, CharSequence charSequence, Object obj) {
        return (charSequence instanceof Spanned) && ((Spanned) charSequence).getSpanEnd(obj) == i;
    }

    public static boolean selfStart(int i, CharSequence charSequence, Object obj) {
        return (charSequence instanceof Spanned) && ((Spanned) charSequence).getSpanStart(obj) == i;
    }
}
