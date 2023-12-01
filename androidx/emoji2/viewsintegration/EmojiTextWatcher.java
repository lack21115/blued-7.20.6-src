package androidx.emoji2.viewsintegration;

import android.text.Editable;
import android.text.Selection;
import android.text.Spannable;
import android.text.TextWatcher;
import android.widget.EditText;
import androidx.emoji2.text.EmojiCompat;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

/* loaded from: source-8756600-dex2jar.jar:androidx/emoji2/viewsintegration/EmojiTextWatcher.class */
final class EmojiTextWatcher implements TextWatcher {

    /* renamed from: a  reason: collision with root package name */
    private final EditText f2843a;
    private final boolean b;

    /* renamed from: c  reason: collision with root package name */
    private EmojiCompat.InitCallback f2844c;
    private int d = Integer.MAX_VALUE;
    private int e = 0;
    private boolean f = true;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:androidx/emoji2/viewsintegration/EmojiTextWatcher$InitCallbackImpl.class */
    public static class InitCallbackImpl extends EmojiCompat.InitCallback {

        /* renamed from: a  reason: collision with root package name */
        private final Reference<EditText> f2845a;

        InitCallbackImpl(EditText editText) {
            this.f2845a = new WeakReference(editText);
        }

        @Override // androidx.emoji2.text.EmojiCompat.InitCallback
        public void onInitialized() {
            super.onInitialized();
            EmojiTextWatcher.a(this.f2845a.get(), 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public EmojiTextWatcher(EditText editText, boolean z) {
        this.f2843a = editText;
        this.b = z;
    }

    static void a(EditText editText, int i) {
        if (i == 1 && editText != null && editText.isAttachedToWindow()) {
            Editable editableText = editText.getEditableText();
            int selectionStart = Selection.getSelectionStart(editableText);
            int selectionEnd = Selection.getSelectionEnd(editableText);
            EmojiCompat.get().process(editableText);
            EmojiInputFilter.a(editableText, selectionStart, selectionEnd);
        }
    }

    private boolean a() {
        if (this.f) {
            return (this.b || EmojiCompat.isConfigured()) ? false : true;
        }
        return true;
    }

    private EmojiCompat.InitCallback b() {
        if (this.f2844c == null) {
            this.f2844c = new InitCallbackImpl(this.f2843a);
        }
        return this.f2844c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i) {
        this.d = i;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(int i) {
        this.e = i;
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public boolean isEnabled() {
        return this.f;
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        if (this.f2843a.isInEditMode() || a() || i2 > i3 || !(charSequence instanceof Spannable)) {
            return;
        }
        int loadState = EmojiCompat.get().getLoadState();
        if (loadState != 0) {
            if (loadState == 1) {
                EmojiCompat.get().process((Spannable) charSequence, i, i + i3, this.d, this.e);
                return;
            } else if (loadState != 3) {
                return;
            }
        }
        EmojiCompat.get().registerInitCallback(b());
    }

    public void setEnabled(boolean z) {
        if (this.f != z) {
            if (this.f2844c != null) {
                EmojiCompat.get().unregisterInitCallback(this.f2844c);
            }
            this.f = z;
            if (z) {
                a(this.f2843a, EmojiCompat.get().getLoadState());
            }
        }
    }
}
