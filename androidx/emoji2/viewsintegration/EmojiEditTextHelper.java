package androidx.emoji2.viewsintegration;

import android.os.Build;
import android.text.method.KeyListener;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.EditText;
import androidx.core.util.Preconditions;

/* loaded from: source-8756600-dex2jar.jar:androidx/emoji2/viewsintegration/EmojiEditTextHelper.class */
public final class EmojiEditTextHelper {

    /* renamed from: a  reason: collision with root package name */
    private final HelperInternal f2878a;
    private int b;

    /* renamed from: c  reason: collision with root package name */
    private int f2879c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8756600-dex2jar.jar:androidx/emoji2/viewsintegration/EmojiEditTextHelper$HelperInternal.class */
    public static class HelperInternal {
        HelperInternal() {
        }

        KeyListener a(KeyListener keyListener) {
            return keyListener;
        }

        InputConnection a(InputConnection inputConnection, EditorInfo editorInfo) {
            return inputConnection;
        }

        void a(int i) {
        }

        void a(boolean z) {
        }

        boolean a() {
            return false;
        }

        void b(int i) {
        }
    }

    /* loaded from: source-8756600-dex2jar.jar:androidx/emoji2/viewsintegration/EmojiEditTextHelper$HelperInternal19.class */
    static class HelperInternal19 extends HelperInternal {

        /* renamed from: a  reason: collision with root package name */
        private final EditText f2880a;
        private final EmojiTextWatcher b;

        HelperInternal19(EditText editText, boolean z) {
            this.f2880a = editText;
            EmojiTextWatcher emojiTextWatcher = new EmojiTextWatcher(editText, z);
            this.b = emojiTextWatcher;
            this.f2880a.addTextChangedListener(emojiTextWatcher);
            this.f2880a.setEditableFactory(EmojiEditableFactory.getInstance());
        }

        @Override // androidx.emoji2.viewsintegration.EmojiEditTextHelper.HelperInternal
        KeyListener a(KeyListener keyListener) {
            if (keyListener instanceof EmojiKeyListener) {
                return keyListener;
            }
            if (keyListener == null) {
                return null;
            }
            return new EmojiKeyListener(keyListener);
        }

        @Override // androidx.emoji2.viewsintegration.EmojiEditTextHelper.HelperInternal
        InputConnection a(InputConnection inputConnection, EditorInfo editorInfo) {
            return inputConnection instanceof EmojiInputConnection ? inputConnection : new EmojiInputConnection(this.f2880a, inputConnection, editorInfo);
        }

        @Override // androidx.emoji2.viewsintegration.EmojiEditTextHelper.HelperInternal
        void a(int i) {
            this.b.a(i);
        }

        @Override // androidx.emoji2.viewsintegration.EmojiEditTextHelper.HelperInternal
        void a(boolean z) {
            this.b.setEnabled(z);
        }

        @Override // androidx.emoji2.viewsintegration.EmojiEditTextHelper.HelperInternal
        boolean a() {
            return this.b.isEnabled();
        }

        @Override // androidx.emoji2.viewsintegration.EmojiEditTextHelper.HelperInternal
        void b(int i) {
            this.b.b(i);
        }
    }

    public EmojiEditTextHelper(EditText editText) {
        this(editText, true);
    }

    public EmojiEditTextHelper(EditText editText, boolean z) {
        this.b = Integer.MAX_VALUE;
        this.f2879c = 0;
        Preconditions.checkNotNull(editText, "editText cannot be null");
        if (Build.VERSION.SDK_INT < 19) {
            this.f2878a = new HelperInternal();
        } else {
            this.f2878a = new HelperInternal19(editText, z);
        }
    }

    public int getEmojiReplaceStrategy() {
        return this.f2879c;
    }

    public KeyListener getKeyListener(KeyListener keyListener) {
        return this.f2878a.a(keyListener);
    }

    public int getMaxEmojiCount() {
        return this.b;
    }

    public boolean isEnabled() {
        return this.f2878a.a();
    }

    public InputConnection onCreateInputConnection(InputConnection inputConnection, EditorInfo editorInfo) {
        if (inputConnection == null) {
            return null;
        }
        return this.f2878a.a(inputConnection, editorInfo);
    }

    public void setEmojiReplaceStrategy(int i) {
        this.f2879c = i;
        this.f2878a.b(i);
    }

    public void setEnabled(boolean z) {
        this.f2878a.a(z);
    }

    public void setMaxEmojiCount(int i) {
        Preconditions.checkArgumentNonnegative(i, "maxEmojiCount should be greater than 0");
        this.b = i;
        this.f2878a.a(i);
    }
}
