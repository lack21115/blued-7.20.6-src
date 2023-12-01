package android.text.method;

import android.text.SpannableStringBuilder;
import android.text.Spanned;

/* loaded from: source-9557208-dex2jar.jar:android/text/method/DigitsKeyListener.class */
public class DigitsKeyListener extends NumberKeyListener {
    private static final int DECIMAL = 2;
    private static final int SIGN = 1;
    private char[] mAccepted;
    private boolean mDecimal;
    private boolean mSign;
    private static final char[][] CHARACTERS = {new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'}, new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '-', '+'}, new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '.'}, new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '-', '+', '.'}};
    private static DigitsKeyListener[] sInstance = new DigitsKeyListener[4];

    public DigitsKeyListener() {
        this(false, false);
    }

    public DigitsKeyListener(boolean z, boolean z2) {
        int i = 0;
        this.mSign = z;
        this.mDecimal = z2;
        this.mAccepted = CHARACTERS[(z ? 1 : 0) | (z2 ? 2 : i)];
    }

    public static DigitsKeyListener getInstance() {
        return getInstance(false, false);
    }

    public static DigitsKeyListener getInstance(String str) {
        DigitsKeyListener digitsKeyListener = new DigitsKeyListener();
        digitsKeyListener.mAccepted = new char[str.length()];
        str.getChars(0, str.length(), digitsKeyListener.mAccepted, 0);
        return digitsKeyListener;
    }

    public static DigitsKeyListener getInstance(boolean z, boolean z2) {
        int i = 0;
        int i2 = z ? 1 : 0;
        if (z2) {
            i = 2;
        }
        int i3 = i2 | i;
        if (sInstance[i3] != null) {
            return sInstance[i3];
        }
        sInstance[i3] = new DigitsKeyListener(z, z2);
        return sInstance[i3];
    }

    private static boolean isDecimalPointChar(char c2) {
        return c2 == '.';
    }

    private static boolean isSignChar(char c2) {
        return c2 == '-' || c2 == '+';
    }

    @Override // android.text.method.NumberKeyListener, android.text.InputFilter
    public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
        int i5;
        int i6;
        boolean z;
        int i7;
        CharSequence filter = super.filter(charSequence, i, i2, spanned, i3, i4);
        if (this.mSign || this.mDecimal) {
            CharSequence charSequence2 = charSequence;
            int i8 = i;
            int i9 = i2;
            if (filter != null) {
                charSequence2 = filter;
                i8 = 0;
                i9 = filter.length();
            }
            int i10 = -1;
            int i11 = -1;
            int length = spanned.length();
            int i12 = 0;
            while (i12 < i3) {
                char charAt = spanned.charAt(i12);
                if (isSignChar(charAt)) {
                    i7 = i12;
                } else {
                    i7 = i10;
                    if (isDecimalPointChar(charAt)) {
                        i11 = i12;
                        i7 = i10;
                    }
                }
                i12++;
                i10 = i7;
            }
            int i13 = i4;
            while (true) {
                int i14 = i13;
                if (i14 < length) {
                    char charAt2 = spanned.charAt(i14);
                    if (isSignChar(charAt2)) {
                        return "";
                    }
                    if (isDecimalPointChar(charAt2)) {
                        i11 = i14;
                    }
                    i13 = i14 + 1;
                } else {
                    SpannableStringBuilder spannableStringBuilder = null;
                    int i15 = i9 - 1;
                    int i16 = i10;
                    while (i15 >= i8) {
                        char charAt3 = charSequence2.charAt(i15);
                        if (!isSignChar(charAt3)) {
                            i5 = i11;
                            i6 = i16;
                            z = false;
                            if (isDecimalPointChar(charAt3)) {
                                if (i11 >= 0) {
                                    z = true;
                                    i5 = i11;
                                    i6 = i16;
                                } else {
                                    i5 = i15;
                                    i6 = i16;
                                    z = false;
                                }
                            }
                        } else if (i15 != i8 || i3 != 0) {
                            z = true;
                            i6 = i16;
                            i5 = i11;
                        } else if (i16 >= 0) {
                            z = true;
                            i5 = i11;
                            i6 = i16;
                        } else {
                            i6 = i15;
                            i5 = i11;
                            z = false;
                        }
                        SpannableStringBuilder spannableStringBuilder2 = spannableStringBuilder;
                        if (z) {
                            if (i9 == i8 + 1) {
                                return "";
                            }
                            spannableStringBuilder2 = spannableStringBuilder;
                            if (spannableStringBuilder == null) {
                                spannableStringBuilder2 = new SpannableStringBuilder(charSequence2, i8, i9);
                            }
                            spannableStringBuilder2.delete(i15 - i8, (i15 + 1) - i8);
                        }
                        i15--;
                        i11 = i5;
                        i16 = i6;
                        spannableStringBuilder = spannableStringBuilder2;
                    }
                    if (spannableStringBuilder != null) {
                        return spannableStringBuilder;
                    }
                    if (filter == null) {
                        return null;
                    }
                }
            }
        }
        return filter;
    }

    @Override // android.text.method.NumberKeyListener
    protected char[] getAcceptedChars() {
        return this.mAccepted;
    }

    @Override // android.text.method.KeyListener
    public int getInputType() {
        int i = 2;
        if (this.mSign) {
            i = 2 | 4096;
        }
        int i2 = i;
        if (this.mDecimal) {
            i2 = i | 8192;
        }
        return i2;
    }
}
