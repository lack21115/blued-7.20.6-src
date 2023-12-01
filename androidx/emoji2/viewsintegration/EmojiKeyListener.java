package androidx.emoji2.viewsintegration;

import android.text.Editable;
import android.text.method.KeyListener;
import android.view.KeyEvent;
import android.view.View;
import androidx.emoji2.text.EmojiCompat;

/* loaded from: source-8756600-dex2jar.jar:androidx/emoji2/viewsintegration/EmojiKeyListener.class */
final class EmojiKeyListener implements KeyListener {

    /* renamed from: a  reason: collision with root package name */
    private final KeyListener f2886a;
    private final EmojiCompatHandleKeyDownHelper b;

    /* loaded from: source-8756600-dex2jar.jar:androidx/emoji2/viewsintegration/EmojiKeyListener$EmojiCompatHandleKeyDownHelper.class */
    public static class EmojiCompatHandleKeyDownHelper {
        public boolean handleKeyDown(Editable editable, int i, KeyEvent keyEvent) {
            return EmojiCompat.handleOnKeyDown(editable, i, keyEvent);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public EmojiKeyListener(KeyListener keyListener) {
        this(keyListener, new EmojiCompatHandleKeyDownHelper());
    }

    EmojiKeyListener(KeyListener keyListener, EmojiCompatHandleKeyDownHelper emojiCompatHandleKeyDownHelper) {
        this.f2886a = keyListener;
        this.b = emojiCompatHandleKeyDownHelper;
    }

    @Override // android.text.method.KeyListener
    public void clearMetaKeyState(View view, Editable editable, int i) {
        this.f2886a.clearMetaKeyState(view, editable, i);
    }

    @Override // android.text.method.KeyListener
    public int getInputType() {
        return this.f2886a.getInputType();
    }

    @Override // android.text.method.KeyListener
    public boolean onKeyDown(View view, Editable editable, int i, KeyEvent keyEvent) {
        return this.b.handleKeyDown(editable, i, keyEvent) || this.f2886a.onKeyDown(view, editable, i, keyEvent);
    }

    @Override // android.text.method.KeyListener
    public boolean onKeyOther(View view, Editable editable, KeyEvent keyEvent) {
        return this.f2886a.onKeyOther(view, editable, keyEvent);
    }

    @Override // android.text.method.KeyListener
    public boolean onKeyUp(View view, Editable editable, int i, KeyEvent keyEvent) {
        return this.f2886a.onKeyUp(view, editable, i, keyEvent);
    }
}
