package android.text.method;

import android.graphics.Rect;
import android.os.Handler;
import android.os.SystemClock;
import android.text.Editable;
import android.text.GetChars;
import android.text.NoCopySpan;
import android.text.Spannable;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.UpdateLayout;
import android.view.View;
import com.igexin.push.config.c;
import java.lang.ref.WeakReference;

/* loaded from: source-9557208-dex2jar.jar:android/text/method/PasswordTransformationMethod.class */
public class PasswordTransformationMethod implements TransformationMethod, TextWatcher {
    private static char DOT = 8226;
    private static PasswordTransformationMethod sInstance;

    /* loaded from: source-9557208-dex2jar.jar:android/text/method/PasswordTransformationMethod$PasswordCharSequence.class */
    private static class PasswordCharSequence implements CharSequence, GetChars {
        private CharSequence mSource;

        public PasswordCharSequence(CharSequence charSequence) {
            this.mSource = charSequence;
        }

        @Override // java.lang.CharSequence
        public char charAt(int i) {
            if (this.mSource instanceof Spanned) {
                Spanned spanned = (Spanned) this.mSource;
                int spanStart = spanned.getSpanStart(TextKeyListener.ACTIVE);
                int spanEnd = spanned.getSpanEnd(TextKeyListener.ACTIVE);
                if (i >= spanStart && i < spanEnd) {
                    return this.mSource.charAt(i);
                }
                Visible[] visibleArr = (Visible[]) spanned.getSpans(0, spanned.length(), Visible.class);
                int i2 = 0;
                while (true) {
                    int i3 = i2;
                    if (i3 >= visibleArr.length) {
                        break;
                    }
                    if (spanned.getSpanStart(visibleArr[i3].mTransformer) >= 0) {
                        int spanStart2 = spanned.getSpanStart(visibleArr[i3]);
                        int spanEnd2 = spanned.getSpanEnd(visibleArr[i3]);
                        if (i >= spanStart2 && i < spanEnd2) {
                            return this.mSource.charAt(i);
                        }
                    }
                    i2 = i3 + 1;
                }
            }
            return PasswordTransformationMethod.DOT;
        }

        @Override // android.text.GetChars
        public void getChars(int i, int i2, char[] cArr, int i3) {
            boolean z;
            TextUtils.getChars(this.mSource, i, i2, cArr, i3);
            int i4 = -1;
            int i5 = -1;
            int i6 = 0;
            int[] iArr = null;
            int[] iArr2 = null;
            if (this.mSource instanceof Spanned) {
                Spanned spanned = (Spanned) this.mSource;
                int spanStart = spanned.getSpanStart(TextKeyListener.ACTIVE);
                int spanEnd = spanned.getSpanEnd(TextKeyListener.ACTIVE);
                Visible[] visibleArr = (Visible[]) spanned.getSpans(0, spanned.length(), Visible.class);
                int length = visibleArr.length;
                int[] iArr3 = new int[length];
                int[] iArr4 = new int[length];
                int i7 = 0;
                while (true) {
                    int i8 = i7;
                    i5 = spanEnd;
                    iArr2 = iArr4;
                    i6 = length;
                    i4 = spanStart;
                    iArr = iArr3;
                    if (i8 >= length) {
                        break;
                    }
                    if (spanned.getSpanStart(visibleArr[i8].mTransformer) >= 0) {
                        iArr3[i8] = spanned.getSpanStart(visibleArr[i8]);
                        iArr4[i8] = spanned.getSpanEnd(visibleArr[i8]);
                    }
                    i7 = i8 + 1;
                }
            }
            int i9 = i;
            while (true) {
                int i10 = i9;
                if (i10 >= i2) {
                    return;
                }
                if (i10 < i4 || i10 >= i5) {
                    int i11 = 0;
                    while (true) {
                        int i12 = i11;
                        z = false;
                        if (i12 < i6) {
                            if (i10 >= iArr[i12] && i10 < iArr2[i12]) {
                                z = true;
                                break;
                            }
                            i11 = i12 + 1;
                        } else {
                            break;
                        }
                    }
                    if (!z) {
                        cArr[(i10 - i) + i3] = PasswordTransformationMethod.DOT;
                    }
                }
                i9 = i10 + 1;
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
            return subSequence(0, length()).toString();
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/text/method/PasswordTransformationMethod$ViewReference.class */
    private static class ViewReference extends WeakReference<View> implements NoCopySpan {
        public ViewReference(View view) {
            super(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-9557208-dex2jar.jar:android/text/method/PasswordTransformationMethod$Visible.class */
    public static class Visible extends Handler implements UpdateLayout, Runnable {
        private Spannable mText;
        private PasswordTransformationMethod mTransformer;

        public Visible(Spannable spannable, PasswordTransformationMethod passwordTransformationMethod) {
            this.mText = spannable;
            this.mTransformer = passwordTransformationMethod;
            postAtTime(this, SystemClock.uptimeMillis() + c.j);
        }

        @Override // java.lang.Runnable
        public void run() {
            this.mText.removeSpan(this);
        }
    }

    public static PasswordTransformationMethod getInstance() {
        if (sInstance != null) {
            return sInstance;
        }
        sInstance = new PasswordTransformationMethod();
        return sInstance;
    }

    private static void removeVisibleSpans(Spannable spannable) {
        Visible[] visibleArr = (Visible[]) spannable.getSpans(0, spannable.length(), Visible.class);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= visibleArr.length) {
                return;
            }
            spannable.removeSpan(visibleArr[i2]);
            i = i2 + 1;
        }
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // android.text.method.TransformationMethod
    public CharSequence getTransformation(CharSequence charSequence, View view) {
        if (charSequence instanceof Spannable) {
            Spannable spannable = (Spannable) charSequence;
            ViewReference[] viewReferenceArr = (ViewReference[]) spannable.getSpans(0, spannable.length(), ViewReference.class);
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= viewReferenceArr.length) {
                    break;
                }
                spannable.removeSpan(viewReferenceArr[i2]);
                i = i2 + 1;
            }
            removeVisibleSpans(spannable);
            spannable.setSpan(new ViewReference(view), 0, 0, 34);
        }
        return new PasswordCharSequence(charSequence);
    }

    @Override // android.text.method.TransformationMethod
    public void onFocusChanged(View view, CharSequence charSequence, boolean z, int i, Rect rect) {
        if (z || !(charSequence instanceof Spannable)) {
            return;
        }
        removeVisibleSpans((Spannable) charSequence);
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        if (charSequence instanceof Spannable) {
            Spannable spannable = (Spannable) charSequence;
            ViewReference[] viewReferenceArr = (ViewReference[]) spannable.getSpans(0, charSequence.length(), ViewReference.class);
            if (viewReferenceArr.length == 0) {
                return;
            }
            View view = null;
            int i4 = 0;
            while (true) {
                int i5 = i4;
                if (view != null || i5 >= viewReferenceArr.length) {
                    break;
                }
                view = viewReferenceArr[i5].get();
                i4 = i5 + 1;
            }
            if (view == null || (TextKeyListener.getInstance().getPrefs(view.getContext()) & 8) == 0 || i3 <= 0) {
                return;
            }
            removeVisibleSpans(spannable);
            if (i3 == 1) {
                spannable.setSpan(new Visible(spannable, this), i, i + i3, 33);
            }
        }
    }
}
