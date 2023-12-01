package androidx.appcompat.widget;

import android.content.res.TypedArray;
import android.text.method.KeyListener;
import android.text.method.NumberKeyListener;
import android.util.AttributeSet;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.EditText;
import androidx.appcompat.R;
import androidx.emoji2.viewsintegration.EmojiEditTextHelper;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: source-8756600-dex2jar.jar:androidx/appcompat/widget/AppCompatEmojiEditTextHelper.class */
public class AppCompatEmojiEditTextHelper {

    /* renamed from: a  reason: collision with root package name */
    private final EditText f1759a;
    private final EmojiEditTextHelper b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AppCompatEmojiEditTextHelper(EditText editText) {
        this.f1759a = editText;
        this.b = new EmojiEditTextHelper(editText, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public InputConnection a(InputConnection inputConnection, EditorInfo editorInfo) {
        return this.b.onCreateInputConnection(inputConnection, editorInfo);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(AttributeSet attributeSet, int i) {
        TypedArray obtainStyledAttributes = this.f1759a.getContext().obtainStyledAttributes(attributeSet, R.styleable.AppCompatTextView, i, 0);
        try {
            boolean z = true;
            if (obtainStyledAttributes.hasValue(R.styleable.AppCompatTextView_emojiCompatEnabled)) {
                z = obtainStyledAttributes.getBoolean(R.styleable.AppCompatTextView_emojiCompatEnabled, true);
            }
            obtainStyledAttributes.recycle();
            a(z);
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(boolean z) {
        this.b.setEnabled(z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a() {
        return this.b.isEnabled();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(KeyListener keyListener) {
        return !(keyListener instanceof NumberKeyListener);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public KeyListener b(KeyListener keyListener) {
        KeyListener keyListener2 = keyListener;
        if (a(keyListener)) {
            keyListener2 = this.b.getKeyListener(keyListener);
        }
        return keyListener2;
    }
}
