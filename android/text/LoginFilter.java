package android.text;

/* loaded from: source-9557208-dex2jar.jar:android/text/LoginFilter.class */
public abstract class LoginFilter implements InputFilter {
    private boolean mAppendInvalid;

    /* loaded from: source-9557208-dex2jar.jar:android/text/LoginFilter$PasswordFilterGMail.class */
    public static class PasswordFilterGMail extends LoginFilter {
        public PasswordFilterGMail() {
            super(false);
        }

        public PasswordFilterGMail(boolean z) {
            super(z);
        }

        @Override // android.text.LoginFilter
        public boolean isAllowed(char c2) {
            if (' ' > c2 || c2 > 127) {
                return 160 <= c2 && c2 <= 255;
            }
            return true;
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/text/LoginFilter$UsernameFilterGMail.class */
    public static class UsernameFilterGMail extends LoginFilter {
        public UsernameFilterGMail() {
            super(false);
        }

        public UsernameFilterGMail(boolean z) {
            super(z);
        }

        @Override // android.text.LoginFilter
        public boolean isAllowed(char c2) {
            if ('0' > c2 || c2 > '9') {
                if ('a' > c2 || c2 > 'z') {
                    return ('A' <= c2 && c2 <= 'Z') || '.' == c2;
                }
                return true;
            }
            return true;
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/text/LoginFilter$UsernameFilterGeneric.class */
    public static class UsernameFilterGeneric extends LoginFilter {
        private static final String mAllowed = "@_-+.";

        public UsernameFilterGeneric() {
            super(false);
        }

        public UsernameFilterGeneric(boolean z) {
            super(z);
        }

        @Override // android.text.LoginFilter
        public boolean isAllowed(char c2) {
            if ('0' > c2 || c2 > '9') {
                if ('a' > c2 || c2 > 'z') {
                    return ('A' <= c2 && c2 <= 'Z') || mAllowed.indexOf(c2) != -1;
                }
                return true;
            }
            return true;
        }
    }

    LoginFilter() {
        this.mAppendInvalid = false;
    }

    LoginFilter(boolean z) {
        this.mAppendInvalid = z;
    }

    @Override // android.text.InputFilter
    public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
        onStart();
        int i5 = 0;
        while (true) {
            int i6 = i5;
            if (i6 >= i3) {
                break;
            }
            char charAt = spanned.charAt(i6);
            if (!isAllowed(charAt)) {
                onInvalidCharacter(charAt);
            }
            i5 = i6 + 1;
        }
        SpannableStringBuilder spannableStringBuilder = null;
        int i7 = 0;
        int i8 = i;
        while (true) {
            int i9 = i8;
            if (i9 >= i2) {
                break;
            }
            char charAt2 = charSequence.charAt(i9);
            if (isAllowed(charAt2)) {
                i7++;
            } else {
                if (this.mAppendInvalid) {
                    i7++;
                } else {
                    SpannableStringBuilder spannableStringBuilder2 = spannableStringBuilder;
                    if (spannableStringBuilder == null) {
                        spannableStringBuilder2 = new SpannableStringBuilder(charSequence, i, i2);
                        i7 = i9 - i;
                    }
                    spannableStringBuilder2.delete(i7, i7 + 1);
                    spannableStringBuilder = spannableStringBuilder2;
                }
                onInvalidCharacter(charAt2);
            }
            i8 = i9 + 1;
        }
        while (i4 < spanned.length()) {
            char charAt3 = spanned.charAt(i4);
            if (!isAllowed(charAt3)) {
                onInvalidCharacter(charAt3);
            }
            i4++;
        }
        onStop();
        return spannableStringBuilder;
    }

    public abstract boolean isAllowed(char c2);

    public void onInvalidCharacter(char c2) {
    }

    public void onStart() {
    }

    public void onStop() {
    }
}
