package android.text.method;

import android.graphics.Rect;
import android.text.Editable;
import android.text.GetChars;
import android.text.Spannable;
import android.text.Spanned;
import android.text.SpannedString;
import android.text.TextUtils;
import android.view.View;

/* loaded from: source-9557208-dex2jar.jar:android/text/method/ReplacementTransformationMethod.class */
public abstract class ReplacementTransformationMethod implements TransformationMethod {

    /* loaded from: source-9557208-dex2jar.jar:android/text/method/ReplacementTransformationMethod$ReplacementCharSequence.class */
    private static class ReplacementCharSequence implements CharSequence, GetChars {
        private char[] mOriginal;
        private char[] mReplacement;
        private CharSequence mSource;

        public ReplacementCharSequence(CharSequence charSequence, char[] cArr, char[] cArr2) {
            this.mSource = charSequence;
            this.mOriginal = cArr;
            this.mReplacement = cArr2;
        }

        @Override // java.lang.CharSequence
        public char charAt(int i) {
            char charAt = this.mSource.charAt(i);
            int length = this.mOriginal.length;
            int i2 = 0;
            while (i2 < length) {
                char c2 = charAt;
                if (charAt == this.mOriginal[i2]) {
                    c2 = this.mReplacement[i2];
                }
                i2++;
                charAt = c2;
            }
            return charAt;
        }

        @Override // android.text.GetChars
        public void getChars(int i, int i2, char[] cArr, int i3) {
            TextUtils.getChars(this.mSource, i, i2, cArr, i3);
            int length = this.mOriginal.length;
            int i4 = i3;
            while (true) {
                int i5 = i4;
                if (i5 >= (i2 - i) + i3) {
                    return;
                }
                char c2 = cArr[i5];
                int i6 = 0;
                while (true) {
                    int i7 = i6;
                    if (i7 < length) {
                        if (c2 == this.mOriginal[i7]) {
                            cArr[i5] = this.mReplacement[i7];
                        }
                        i6 = i7 + 1;
                    }
                }
                i4 = i5 + 1;
            }
        }

        @Override // java.lang.CharSequence
        public int length() {
            return this.mSource.length();
        }

        @Override // java.lang.CharSequence
        public CharSequence subSequence(int i, int i2) {
            char[] cArr = new char[i2 - i];
            getChars(i, i2, cArr, 0);
            return new String(cArr);
        }

        @Override // java.lang.CharSequence
        public String toString() {
            char[] cArr = new char[length()];
            getChars(0, length(), cArr, 0);
            return new String(cArr);
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/text/method/ReplacementTransformationMethod$SpannedReplacementCharSequence.class */
    private static class SpannedReplacementCharSequence extends ReplacementCharSequence implements Spanned {
        private Spanned mSpanned;

        public SpannedReplacementCharSequence(Spanned spanned, char[] cArr, char[] cArr2) {
            super(spanned, cArr, cArr2);
            this.mSpanned = spanned;
        }

        @Override // android.text.Spanned
        public int getSpanEnd(Object obj) {
            return this.mSpanned.getSpanEnd(obj);
        }

        @Override // android.text.Spanned
        public int getSpanFlags(Object obj) {
            return this.mSpanned.getSpanFlags(obj);
        }

        @Override // android.text.Spanned
        public int getSpanStart(Object obj) {
            return this.mSpanned.getSpanStart(obj);
        }

        @Override // android.text.Spanned
        public <T> T[] getSpans(int i, int i2, Class<T> cls) {
            return (T[]) this.mSpanned.getSpans(i, i2, cls);
        }

        @Override // android.text.Spanned
        public int nextSpanTransition(int i, int i2, Class cls) {
            return this.mSpanned.nextSpanTransition(i, i2, cls);
        }

        @Override // android.text.method.ReplacementTransformationMethod.ReplacementCharSequence, java.lang.CharSequence
        public CharSequence subSequence(int i, int i2) {
            return new SpannedString(this).subSequence(i, i2);
        }
    }

    protected abstract char[] getOriginal();

    protected abstract char[] getReplacement();

    @Override // android.text.method.TransformationMethod
    public CharSequence getTransformation(CharSequence charSequence, View view) {
        boolean z;
        char[] original = getOriginal();
        char[] replacement = getReplacement();
        if (!(charSequence instanceof Editable)) {
            int length = original.length;
            int i = 0;
            while (true) {
                int i2 = i;
                z = true;
                if (i2 >= length) {
                    break;
                } else if (TextUtils.indexOf(charSequence, original[i2]) >= 0) {
                    z = false;
                    break;
                } else {
                    i = i2 + 1;
                }
            }
            if (z) {
                return charSequence;
            }
            if (!(charSequence instanceof Spannable)) {
                return charSequence instanceof Spanned ? new SpannedString(new SpannedReplacementCharSequence((Spanned) charSequence, original, replacement)) : new ReplacementCharSequence(charSequence, original, replacement).toString();
            }
        }
        return charSequence instanceof Spanned ? new SpannedReplacementCharSequence((Spanned) charSequence, original, replacement) : new ReplacementCharSequence(charSequence, original, replacement);
    }

    @Override // android.text.method.TransformationMethod
    public void onFocusChanged(View view, CharSequence charSequence, boolean z, int i, Rect rect) {
    }
}
