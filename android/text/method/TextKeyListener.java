package android.text.method;

import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.os.Handler;
import android.provider.Settings;
import android.text.Editable;
import android.text.NoCopySpan;
import android.text.Selection;
import android.text.SpanWatcher;
import android.text.Spannable;
import android.text.TextUtils;
import android.text.method.QwertyKeyListener;
import android.view.KeyEvent;
import android.view.View;
import java.lang.ref.WeakReference;

/* loaded from: source-9557208-dex2jar.jar:android/text/method/TextKeyListener.class */
public class TextKeyListener extends BaseKeyListener implements SpanWatcher {
    static final int AUTO_CAP = 1;
    static final int AUTO_PERIOD = 4;
    static final int AUTO_TEXT = 2;
    static final int SHOW_PASSWORD = 8;
    private Capitalize mAutoCap;
    private boolean mAutoText;
    private SettingsObserver mObserver;
    private int mPrefs;
    private boolean mPrefsInited;
    private WeakReference<ContentResolver> mResolver;
    private static TextKeyListener[] sInstance = new TextKeyListener[Capitalize.values().length * 2];
    static final Object ACTIVE = new NoCopySpan.Concrete();
    static final Object CAPPED = new NoCopySpan.Concrete();
    static final Object INHIBIT_REPLACEMENT = new NoCopySpan.Concrete();
    static final Object LAST_TYPED = new NoCopySpan.Concrete();

    /* loaded from: source-9557208-dex2jar.jar:android/text/method/TextKeyListener$Capitalize.class */
    public enum Capitalize {
        NONE,
        SENTENCES,
        WORDS,
        CHARACTERS
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-9557208-dex2jar.jar:android/text/method/TextKeyListener$NullKeyListener.class */
    public static class NullKeyListener implements KeyListener {
        private static NullKeyListener sInstance;

        private NullKeyListener() {
        }

        public static NullKeyListener getInstance() {
            if (sInstance != null) {
                return sInstance;
            }
            sInstance = new NullKeyListener();
            return sInstance;
        }

        @Override // android.text.method.KeyListener
        public void clearMetaKeyState(View view, Editable editable, int i) {
        }

        @Override // android.text.method.KeyListener
        public int getInputType() {
            return 0;
        }

        @Override // android.text.method.KeyListener
        public boolean onKeyDown(View view, Editable editable, int i, KeyEvent keyEvent) {
            return false;
        }

        @Override // android.text.method.KeyListener
        public boolean onKeyOther(View view, Editable editable, KeyEvent keyEvent) {
            return false;
        }

        @Override // android.text.method.KeyListener
        public boolean onKeyUp(View view, Editable editable, int i, KeyEvent keyEvent) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-9557208-dex2jar.jar:android/text/method/TextKeyListener$SettingsObserver.class */
    public class SettingsObserver extends ContentObserver {
        public SettingsObserver() {
            super(new Handler());
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z) {
            if (TextKeyListener.this.mResolver == null) {
                TextKeyListener.this.mPrefsInited = false;
                return;
            }
            ContentResolver contentResolver = (ContentResolver) TextKeyListener.this.mResolver.get();
            if (contentResolver == null) {
                TextKeyListener.this.mPrefsInited = false;
            } else {
                TextKeyListener.this.updatePrefs(contentResolver);
            }
        }
    }

    public TextKeyListener(Capitalize capitalize, boolean z) {
        this.mAutoCap = capitalize;
        this.mAutoText = z;
    }

    public static void clear(Editable editable) {
        editable.clear();
        editable.removeSpan(ACTIVE);
        editable.removeSpan(CAPPED);
        editable.removeSpan(INHIBIT_REPLACEMENT);
        editable.removeSpan(LAST_TYPED);
        QwertyKeyListener.Replaced[] replacedArr = (QwertyKeyListener.Replaced[]) editable.getSpans(0, editable.length(), QwertyKeyListener.Replaced.class);
        int length = replacedArr.length;
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= length) {
                return;
            }
            editable.removeSpan(replacedArr[i2]);
            i = i2 + 1;
        }
    }

    public static TextKeyListener getInstance() {
        return getInstance(false, Capitalize.NONE);
    }

    public static TextKeyListener getInstance(boolean z, Capitalize capitalize) {
        int ordinal = (capitalize.ordinal() * 2) + (z ? 1 : 0);
        if (sInstance[ordinal] == null) {
            sInstance[ordinal] = new TextKeyListener(capitalize, z);
        }
        return sInstance[ordinal];
    }

    private KeyListener getKeyListener(KeyEvent keyEvent) {
        int keyboardType = keyEvent.getKeyCharacterMap().getKeyboardType();
        return keyboardType == 3 ? QwertyKeyListener.getInstance(this.mAutoText, this.mAutoCap) : keyboardType == 1 ? MultiTapKeyListener.getInstance(this.mAutoText, this.mAutoCap) : (keyboardType == 4 || keyboardType == 5) ? QwertyKeyListener.getInstanceForFullKeyboard() : NullKeyListener.getInstance();
    }

    private void initPrefs(Context context) {
        ContentResolver contentResolver = context.getContentResolver();
        this.mResolver = new WeakReference<>(contentResolver);
        if (this.mObserver == null) {
            this.mObserver = new SettingsObserver();
            contentResolver.registerContentObserver(Settings.System.CONTENT_URI, true, this.mObserver);
        }
        updatePrefs(contentResolver);
        this.mPrefsInited = true;
    }

    public static boolean shouldCap(Capitalize capitalize, CharSequence charSequence, int i) {
        if (capitalize == Capitalize.NONE) {
            return false;
        }
        if (capitalize == Capitalize.CHARACTERS) {
            return true;
        }
        return TextUtils.getCapsMode(charSequence, i, capitalize == Capitalize.WORDS ? 8192 : 16384) != 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updatePrefs(ContentResolver contentResolver) {
        int i = 0;
        boolean z = Settings.System.getInt(contentResolver, Settings.System.TEXT_AUTO_CAPS, 1) > 0;
        boolean z2 = Settings.System.getInt(contentResolver, Settings.System.TEXT_AUTO_REPLACE, 1) > 0;
        boolean z3 = Settings.System.getInt(contentResolver, Settings.System.TEXT_AUTO_PUNCTUATE, 1) > 0;
        boolean z4 = Settings.System.getInt(contentResolver, Settings.System.TEXT_SHOW_PASSWORD, 1) > 0;
        int i2 = z ? 1 : 0;
        int i3 = z2 ? 2 : 0;
        int i4 = z3 ? 4 : 0;
        if (z4) {
            i = 8;
        }
        this.mPrefs = i4 | i2 | i3 | i;
    }

    @Override // android.text.method.KeyListener
    public int getInputType() {
        return makeTextContentType(this.mAutoCap, this.mAutoText);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getPrefs(Context context) {
        synchronized (this) {
            if (!this.mPrefsInited || this.mResolver.get() == null) {
                initPrefs(context);
            }
        }
        return this.mPrefs;
    }

    @Override // android.text.method.BaseKeyListener, android.text.method.MetaKeyKeyListener, android.text.method.KeyListener
    public boolean onKeyDown(View view, Editable editable, int i, KeyEvent keyEvent) {
        return getKeyListener(keyEvent).onKeyDown(view, editable, i, keyEvent);
    }

    @Override // android.text.method.BaseKeyListener, android.text.method.KeyListener
    public boolean onKeyOther(View view, Editable editable, KeyEvent keyEvent) {
        return getKeyListener(keyEvent).onKeyOther(view, editable, keyEvent);
    }

    @Override // android.text.method.MetaKeyKeyListener, android.text.method.KeyListener
    public boolean onKeyUp(View view, Editable editable, int i, KeyEvent keyEvent) {
        return getKeyListener(keyEvent).onKeyUp(view, editable, i, keyEvent);
    }

    @Override // android.text.SpanWatcher
    public void onSpanAdded(Spannable spannable, Object obj, int i, int i2) {
    }

    @Override // android.text.SpanWatcher
    public void onSpanChanged(Spannable spannable, Object obj, int i, int i2, int i3, int i4) {
        if (obj == Selection.SELECTION_END) {
            spannable.removeSpan(ACTIVE);
        }
    }

    @Override // android.text.SpanWatcher
    public void onSpanRemoved(Spannable spannable, Object obj, int i, int i2) {
    }

    public void release() {
        if (this.mResolver != null) {
            ContentResolver contentResolver = this.mResolver.get();
            if (contentResolver != null) {
                contentResolver.unregisterContentObserver(this.mObserver);
                this.mResolver.clear();
            }
            this.mObserver = null;
            this.mResolver = null;
            this.mPrefsInited = false;
        }
    }
}
