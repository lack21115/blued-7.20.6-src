package android.text.method;

import android.text.Spannable;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;

/* loaded from: source-9557208-dex2jar.jar:android/text/method/DialerKeyListener.class */
public class DialerKeyListener extends NumberKeyListener {
    public static final char[] CHARACTERS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '#', '*', '+', '-', '(', ')', ',', '/', 'N', '.', ' ', ';'};
    private static DialerKeyListener sInstance;

    public static DialerKeyListener getInstance() {
        if (sInstance != null) {
            return sInstance;
        }
        sInstance = new DialerKeyListener();
        return sInstance;
    }

    @Override // android.text.method.NumberKeyListener
    protected char[] getAcceptedChars() {
        return CHARACTERS;
    }

    @Override // android.text.method.KeyListener
    public int getInputType() {
        return 3;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.text.method.NumberKeyListener
    public int lookup(KeyEvent keyEvent, Spannable spannable) {
        int metaState = getMetaState(spannable, keyEvent);
        char number = keyEvent.getNumber();
        if ((metaState & 3) != 0 || number == 0) {
            int lookup = super.lookup(keyEvent, spannable);
            if (lookup != 0) {
                return lookup;
            }
            if (metaState != 0) {
                KeyCharacterMap.KeyData keyData = new KeyCharacterMap.KeyData();
                char[] acceptedChars = getAcceptedChars();
                if (keyEvent.getKeyData(keyData)) {
                    int i = 1;
                    while (true) {
                        int i2 = i;
                        if (i2 >= keyData.meta.length) {
                            break;
                        } else if (ok(acceptedChars, keyData.meta[i2])) {
                            return keyData.meta[i2];
                        } else {
                            i = i2 + 1;
                        }
                    }
                }
            }
        }
        return number;
    }
}
