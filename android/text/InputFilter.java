package android.text;

/* loaded from: source-9557208-dex2jar.jar:android/text/InputFilter.class */
public interface InputFilter {

    /* loaded from: source-9557208-dex2jar.jar:android/text/InputFilter$AllCaps.class */
    public static class AllCaps implements InputFilter {
        @Override // android.text.InputFilter
        public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
            int i5 = i;
            while (true) {
                int i6 = i5;
                if (i6 >= i2) {
                    return null;
                }
                if (Character.isLowerCase(charSequence.charAt(i6))) {
                    char[] cArr = new char[i2 - i];
                    TextUtils.getChars(charSequence, i, i2, cArr, 0);
                    String upperCase = new String(cArr).toUpperCase();
                    if (charSequence instanceof Spanned) {
                        SpannableString spannableString = new SpannableString(upperCase);
                        TextUtils.copySpansFrom((Spanned) charSequence, i, i2, null, spannableString, 0);
                        return spannableString;
                    }
                    return upperCase;
                }
                i5 = i6 + 1;
            }
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/text/InputFilter$LengthFilter.class */
    public static class LengthFilter implements InputFilter {
        private final int mMax;

        public LengthFilter(int i) {
            this.mMax = i;
        }

        @Override // android.text.InputFilter
        public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
            int length = this.mMax - (spanned.length() - (i4 - i3));
            if (length <= 0) {
                return "";
            }
            if (length >= i2 - i) {
                return null;
            }
            int i5 = length + i;
            int i6 = i5;
            if (Character.isHighSurrogate(charSequence.charAt(i5 - 1))) {
                int i7 = i5 - 1;
                i6 = i7;
                if (i7 == i) {
                    return "";
                }
            }
            return charSequence.subSequence(i, i6);
        }

        public int getMax() {
            return this.mMax;
        }
    }

    CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4);
}
