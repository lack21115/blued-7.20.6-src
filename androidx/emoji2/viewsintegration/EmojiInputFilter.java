package androidx.emoji2.viewsintegration;

import android.text.InputFilter;
import android.text.Selection;
import android.text.Spannable;
import android.text.Spanned;
import android.widget.TextView;
import androidx.emoji2.text.EmojiCompat;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8756600-dex2jar.jar:androidx/emoji2/viewsintegration/EmojiInputFilter.class */
public final class EmojiInputFilter implements InputFilter {

    /* renamed from: a  reason: collision with root package name */
    private final TextView f2884a;
    private EmojiCompat.InitCallback b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:androidx/emoji2/viewsintegration/EmojiInputFilter$InitCallbackImpl.class */
    public static class InitCallbackImpl extends EmojiCompat.InitCallback {

        /* renamed from: a  reason: collision with root package name */
        private final Reference<TextView> f2885a;
        private final Reference<EmojiInputFilter> b;

        InitCallbackImpl(TextView textView, EmojiInputFilter emojiInputFilter) {
            this.f2885a = new WeakReference(textView);
            this.b = new WeakReference(emojiInputFilter);
        }

        private boolean a(TextView textView, InputFilter inputFilter) {
            InputFilter[] filters;
            if (inputFilter == null || textView == null || (filters = textView.getFilters()) == null) {
                return false;
            }
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= filters.length) {
                    return false;
                }
                if (filters[i2] == inputFilter) {
                    return true;
                }
                i = i2 + 1;
            }
        }

        @Override // androidx.emoji2.text.EmojiCompat.InitCallback
        public void onInitialized() {
            super.onInitialized();
            TextView textView = this.f2885a.get();
            if (a(textView, this.b.get()) && textView.isAttachedToWindow()) {
                CharSequence process = EmojiCompat.get().process(textView.getText());
                int selectionStart = Selection.getSelectionStart(process);
                int selectionEnd = Selection.getSelectionEnd(process);
                textView.setText(process);
                if (process instanceof Spannable) {
                    EmojiInputFilter.a((Spannable) process, selectionStart, selectionEnd);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public EmojiInputFilter(TextView textView) {
        this.f2884a = textView;
    }

    private EmojiCompat.InitCallback a() {
        if (this.b == null) {
            this.b = new InitCallbackImpl(this.f2884a, this);
        }
        return this.b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(Spannable spannable, int i, int i2) {
        if (i >= 0 && i2 >= 0) {
            Selection.setSelection(spannable, i, i2);
        } else if (i >= 0) {
            Selection.setSelection(spannable, i);
        } else if (i2 >= 0) {
            Selection.setSelection(spannable, i2);
        }
    }

    @Override // android.text.InputFilter
    public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
        if (this.f2884a.isInEditMode()) {
            return charSequence;
        }
        int loadState = EmojiCompat.get().getLoadState();
        if (loadState != 0) {
            if (loadState == 1) {
                boolean z = true;
                if (i4 == 0) {
                    z = true;
                    if (i3 == 0) {
                        z = true;
                        if (spanned.length() == 0) {
                            z = true;
                            if (charSequence == this.f2884a.getText()) {
                                z = false;
                            }
                        }
                    }
                }
                CharSequence charSequence2 = charSequence;
                if (z) {
                    charSequence2 = charSequence;
                    if (charSequence != null) {
                        if (i != 0 || i2 != charSequence.length()) {
                            charSequence = charSequence.subSequence(i, i2);
                        }
                        charSequence2 = EmojiCompat.get().process(charSequence, 0, charSequence.length());
                    }
                }
                return charSequence2;
            } else if (loadState != 3) {
                return charSequence;
            }
        }
        EmojiCompat.get().registerInitCallback(a());
        return charSequence;
    }
}
