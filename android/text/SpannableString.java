package android.text;

/* loaded from: source-9557208-dex2jar.jar:android/text/SpannableString.class */
public class SpannableString extends SpannableStringInternal implements CharSequence, GetChars, Spannable {
    public SpannableString(CharSequence charSequence) {
        super(charSequence, 0, charSequence.length());
    }

    private SpannableString(CharSequence charSequence, int i, int i2) {
        super(charSequence, i, i2);
    }

    public static SpannableString valueOf(CharSequence charSequence) {
        return charSequence instanceof SpannableString ? (SpannableString) charSequence : new SpannableString(charSequence);
    }

    @Override // android.text.SpannableStringInternal
    public /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override // android.text.SpannableStringInternal, android.text.Spanned
    public /* bridge */ /* synthetic */ int getSpanEnd(Object obj) {
        return super.getSpanEnd(obj);
    }

    @Override // android.text.SpannableStringInternal, android.text.Spanned
    public /* bridge */ /* synthetic */ int getSpanFlags(Object obj) {
        return super.getSpanFlags(obj);
    }

    @Override // android.text.SpannableStringInternal, android.text.Spanned
    public /* bridge */ /* synthetic */ int getSpanStart(Object obj) {
        return super.getSpanStart(obj);
    }

    @Override // android.text.SpannableStringInternal, android.text.Spanned
    public /* bridge */ /* synthetic */ Object[] getSpans(int i, int i2, Class cls) {
        return super.getSpans(i, i2, cls);
    }

    @Override // android.text.SpannableStringInternal
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // android.text.SpannableStringInternal, android.text.Spanned
    public /* bridge */ /* synthetic */ int nextSpanTransition(int i, int i2, Class cls) {
        return super.nextSpanTransition(i, i2, cls);
    }

    @Override // android.text.SpannableStringInternal, android.text.Spannable
    public void removeSpan(Object obj) {
        super.removeSpan(obj);
    }

    @Override // android.text.SpannableStringInternal, android.text.Spannable
    public void setSpan(Object obj, int i, int i2, int i3) {
        super.setSpan(obj, i, i2, i3);
    }

    @Override // java.lang.CharSequence
    public final CharSequence subSequence(int i, int i2) {
        return new SpannableString(this, i, i2);
    }
}
