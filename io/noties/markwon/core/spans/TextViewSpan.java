package io.noties.markwon.core.spans;

import android.text.Spannable;
import android.text.Spanned;
import android.widget.TextView;
import java.lang.ref.WeakReference;

/* loaded from: source-3503164-dex2jar.jar:io/noties/markwon/core/spans/TextViewSpan.class */
public class TextViewSpan {
    private final WeakReference<TextView> reference;

    public TextViewSpan(TextView textView) {
        this.reference = new WeakReference<>(textView);
    }

    public static void applyTo(Spannable spannable, TextView textView) {
        TextViewSpan[] textViewSpanArr = (TextViewSpan[]) spannable.getSpans(0, spannable.length(), TextViewSpan.class);
        if (textViewSpanArr != null) {
            int length = textViewSpanArr.length;
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= length) {
                    break;
                }
                spannable.removeSpan(textViewSpanArr[i2]);
                i = i2 + 1;
            }
        }
        spannable.setSpan(new TextViewSpan(textView), 0, spannable.length(), 18);
    }

    public static TextView textViewOf(Spanned spanned) {
        TextViewSpan[] textViewSpanArr = (TextViewSpan[]) spanned.getSpans(0, spanned.length(), TextViewSpan.class);
        if (textViewSpanArr == null || textViewSpanArr.length <= 0) {
            return null;
        }
        return textViewSpanArr[0].textView();
    }

    public static TextView textViewOf(CharSequence charSequence) {
        if (charSequence instanceof Spanned) {
            return textViewOf((Spanned) charSequence);
        }
        return null;
    }

    public TextView textView() {
        return this.reference.get();
    }
}
