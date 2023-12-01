package io.noties.markwon.core.spans;

import android.text.Layout;
import android.text.Spannable;
import android.text.Spanned;
import java.lang.ref.WeakReference;

/* loaded from: source-3503164-dex2jar.jar:io/noties/markwon/core/spans/TextLayoutSpan.class */
public class TextLayoutSpan {
    private final WeakReference<Layout> reference;

    TextLayoutSpan(Layout layout) {
        this.reference = new WeakReference<>(layout);
    }

    public static void applyTo(Spannable spannable, Layout layout) {
        TextLayoutSpan[] textLayoutSpanArr = (TextLayoutSpan[]) spannable.getSpans(0, spannable.length(), TextLayoutSpan.class);
        if (textLayoutSpanArr != null) {
            int length = textLayoutSpanArr.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    break;
                }
                spannable.removeSpan(textLayoutSpanArr[i2]);
                i = i2 + 1;
            }
        }
        spannable.setSpan(new TextLayoutSpan(layout), 0, spannable.length(), 18);
    }

    public static Layout layoutOf(Spanned spanned) {
        TextLayoutSpan[] textLayoutSpanArr = (TextLayoutSpan[]) spanned.getSpans(0, spanned.length(), TextLayoutSpan.class);
        if (textLayoutSpanArr == null || textLayoutSpanArr.length <= 0) {
            return null;
        }
        return textLayoutSpanArr[0].layout();
    }

    public static Layout layoutOf(CharSequence charSequence) {
        if (charSequence instanceof Spanned) {
            return layoutOf((Spanned) charSequence);
        }
        return null;
    }

    public Layout layout() {
        return this.reference.get();
    }
}
