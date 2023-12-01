package io.noties.markwon.utils;

import android.text.Spannable;
import android.text.SpannableString;

/* loaded from: source-3503164-dex2jar.jar:io/noties/markwon/utils/NoCopySpannableFactory.class */
public class NoCopySpannableFactory extends Spannable.Factory {

    /* loaded from: source-3503164-dex2jar.jar:io/noties/markwon/utils/NoCopySpannableFactory$Holder.class */
    static class Holder {
        private static final NoCopySpannableFactory INSTANCE = new NoCopySpannableFactory();

        Holder() {
        }
    }

    public static NoCopySpannableFactory getInstance() {
        return Holder.INSTANCE;
    }

    @Override // android.text.Spannable.Factory
    public Spannable newSpannable(CharSequence charSequence) {
        return charSequence instanceof Spannable ? (Spannable) charSequence : new SpannableString(charSequence);
    }
}
