package android.text.method;

import android.text.InputFilter;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.view.KeyEvent;

/* loaded from: source-9557208-dex2jar.jar:android/text/method/NumberKeyListener.class */
public abstract class NumberKeyListener extends BaseKeyListener implements InputFilter {
    /* JADX INFO: Access modifiers changed from: protected */
    public static boolean ok(char[] cArr, char c2) {
        int length = cArr.length;
        while (true) {
            int i = length - 1;
            if (i < 0) {
                return false;
            }
            if (cArr[i] == c2) {
                return true;
            }
            length = i;
        }
    }

    public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
        int i5;
        SpannableStringBuilder spannableStringBuilder;
        char[] acceptedChars = getAcceptedChars();
        int i6 = i;
        while (true) {
            i5 = i6;
            if (i5 >= i2 || !ok(acceptedChars, charSequence.charAt(i5))) {
                break;
            }
            i6 = i5 + 1;
        }
        if (i5 != i2) {
            if (i2 - i != 1) {
                SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(charSequence, i, i2);
                int i7 = i2 - i;
                while (true) {
                    i7--;
                    spannableStringBuilder = spannableStringBuilder2;
                    if (i7 < i5 - i) {
                        break;
                    } else if (!ok(acceptedChars, charSequence.charAt(i7))) {
                        spannableStringBuilder2.delete(i7, i7 + 1);
                    }
                }
            } else {
                return "";
            }
        } else {
            spannableStringBuilder = null;
        }
        return spannableStringBuilder;
    }

    protected abstract char[] getAcceptedChars();

    /* JADX INFO: Access modifiers changed from: protected */
    public int lookup(KeyEvent keyEvent, Spannable spannable) {
        return keyEvent.getMatch(getAcceptedChars(), getMetaState(spannable, keyEvent));
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x002c, code lost:
        if (r0 < 0) goto L36;
     */
    @Override // android.text.method.BaseKeyListener, android.text.method.MetaKeyKeyListener, android.text.method.KeyListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onKeyDown(android.view.View r7, android.text.Editable r8, int r9, android.view.KeyEvent r10) {
        /*
            Method dump skipped, instructions count: 214
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: android.text.method.NumberKeyListener.onKeyDown(android.view.View, android.text.Editable, int, android.view.KeyEvent):boolean");
    }
}
