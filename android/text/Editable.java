package android.text;

/* loaded from: source-9557208-dex2jar.jar:android/text/Editable.class */
public interface Editable extends CharSequence, GetChars, Spannable, Appendable {

    /* loaded from: source-9557208-dex2jar.jar:android/text/Editable$Factory.class */
    public static class Factory {
        private static Factory sInstance = new Factory();

        public static Factory getInstance() {
            return sInstance;
        }

        public Editable newEditable(CharSequence charSequence) {
            return new SpannableStringBuilder(charSequence);
        }
    }

    @Override // java.lang.Appendable
    Editable append(char c2);

    @Override // java.lang.Appendable
    Editable append(CharSequence charSequence);

    @Override // java.lang.Appendable
    Editable append(CharSequence charSequence, int i, int i2);

    void clear();

    void clearSpans();

    Editable delete(int i, int i2);

    InputFilter[] getFilters();

    Editable insert(int i, CharSequence charSequence);

    Editable insert(int i, CharSequence charSequence, int i2, int i3);

    Editable replace(int i, int i2, CharSequence charSequence);

    Editable replace(int i, int i2, CharSequence charSequence, int i3, int i4);

    void setFilters(InputFilter[] inputFilterArr);
}
