package android.text;

/* loaded from: source-9557208-dex2jar.jar:android/text/SpannedString.class */
public final class SpannedString extends SpannableStringInternal implements CharSequence, GetChars, Spanned {
    public SpannedString(CharSequence charSequence) {
        super(charSequence, 0, charSequence.length());
    }

    private SpannedString(CharSequence charSequence, int i, int i2) {
        super(charSequence, i, i2);
    }

    public static SpannedString valueOf(CharSequence charSequence) {
        return charSequence instanceof SpannedString ? (SpannedString) charSequence : new SpannedString(charSequence);
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

    @Override // java.lang.CharSequence
    public CharSequence subSequence(int i, int i2) {
        return new SpannedString(this, i, i2);
    }
}
