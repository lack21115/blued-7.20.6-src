package android.view.inputmethod;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.Editable;
import android.text.Selection;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.method.MetaKeyKeyListener;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewRootImpl;

/* loaded from: source-4181928-dex2jar.jar:android/view/inputmethod/BaseInputConnection.class */
public class BaseInputConnection implements InputConnection {
    static final Object COMPOSING = new ComposingText();
    private static final boolean DEBUG = false;
    private static final String TAG = "BaseInputConnection";
    private Object[] mDefaultComposingSpans;
    final boolean mDummyMode;
    Editable mEditable;
    protected final InputMethodManager mIMM;
    KeyCharacterMap mKeyCharacterMap;
    final View mTargetView;

    public BaseInputConnection(View view, boolean z) {
        this.mIMM = (InputMethodManager) view.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        this.mTargetView = view;
        this.mDummyMode = !z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public BaseInputConnection(InputMethodManager inputMethodManager, boolean z) {
        this.mIMM = inputMethodManager;
        this.mTargetView = null;
        this.mDummyMode = !z;
    }

    private void ensureDefaultComposingSpans() {
        if (this.mDefaultComposingSpans == null) {
            Context context = this.mTargetView != null ? this.mTargetView.getContext() : this.mIMM.mServedView != null ? this.mIMM.mServedView.getContext() : null;
            if (context != null) {
                TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{16843312});
                CharSequence text = obtainStyledAttributes.getText(0);
                obtainStyledAttributes.recycle();
                if (text == null || !(text instanceof Spanned)) {
                    return;
                }
                this.mDefaultComposingSpans = ((Spanned) text).getSpans(0, text.length(), Object.class);
            }
        }
    }

    public static int getComposingSpanEnd(Spannable spannable) {
        return spannable.getSpanEnd(COMPOSING);
    }

    public static int getComposingSpanStart(Spannable spannable) {
        return spannable.getSpanStart(COMPOSING);
    }

    public static final void removeComposingSpans(Spannable spannable) {
        spannable.removeSpan(COMPOSING);
        Object[] spans = spannable.getSpans(0, spannable.length(), Object.class);
        if (spans == null) {
            return;
        }
        int length = spans.length;
        while (true) {
            int i = length - 1;
            if (i < 0) {
                return;
            }
            Object obj = spans[i];
            if ((spannable.getSpanFlags(obj) & 256) != 0) {
                spannable.removeSpan(obj);
            }
            length = i;
        }
    }

    private void replaceText(CharSequence charSequence, int i, boolean z) {
        SpannableStringBuilder spannableStringBuilder;
        Editable editable = getEditable();
        if (editable == null) {
            return;
        }
        beginBatchEdit();
        int composingSpanStart = getComposingSpanStart(editable);
        int composingSpanEnd = getComposingSpanEnd(editable);
        int i2 = composingSpanStart;
        int i3 = composingSpanEnd;
        if (composingSpanEnd < composingSpanStart) {
            i3 = composingSpanStart;
            i2 = composingSpanEnd;
        }
        if (i2 == -1 || i3 == -1) {
            int selectionStart = Selection.getSelectionStart(editable);
            int selectionEnd = Selection.getSelectionEnd(editable);
            int i4 = selectionStart;
            if (selectionStart < 0) {
                i4 = 0;
            }
            int i5 = selectionEnd;
            if (selectionEnd < 0) {
                i5 = 0;
            }
            i2 = i4;
            i3 = i5;
            if (i5 < i4) {
                i2 = i5;
                i3 = i4;
            }
        } else {
            removeComposingSpans(editable);
        }
        CharSequence charSequence2 = charSequence;
        if (z) {
            if (charSequence instanceof Spannable) {
                spannableStringBuilder = (Spannable) charSequence;
            } else {
                SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(charSequence);
                ensureDefaultComposingSpans();
                spannableStringBuilder = spannableStringBuilder2;
                charSequence = spannableStringBuilder2;
                if (this.mDefaultComposingSpans != null) {
                    int i6 = 0;
                    while (true) {
                        int i7 = i6;
                        spannableStringBuilder = spannableStringBuilder2;
                        charSequence = spannableStringBuilder2;
                        if (i7 >= this.mDefaultComposingSpans.length) {
                            break;
                        }
                        spannableStringBuilder2.setSpan(this.mDefaultComposingSpans[i7], 0, spannableStringBuilder2.length(), 289);
                        i6 = i7 + 1;
                    }
                }
            }
            setComposingSpans(spannableStringBuilder);
            charSequence2 = charSequence;
        }
        int i8 = i > 0 ? i + (i3 - 1) : i + i2;
        int i9 = i8;
        if (i8 < 0) {
            i9 = 0;
        }
        int i10 = i9;
        if (i9 > editable.length()) {
            i10 = editable.length();
        }
        Selection.setSelection(editable, i10);
        editable.replace(i2, i3, charSequence2);
        endBatchEdit();
    }

    private void sendCurrentText() {
        Editable editable;
        int length;
        if (!this.mDummyMode || (editable = getEditable()) == null || (length = editable.length()) == 0) {
            return;
        }
        if (length == 1) {
            if (this.mKeyCharacterMap == null) {
                this.mKeyCharacterMap = KeyCharacterMap.load(-1);
            }
            char[] cArr = new char[1];
            editable.getChars(0, 1, cArr, 0);
            KeyEvent[] events = this.mKeyCharacterMap.getEvents(cArr);
            if (events != null) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= events.length) {
                        editable.clear();
                        return;
                    } else {
                        sendKeyEvent(events[i2]);
                        i = i2 + 1;
                    }
                }
            }
        }
        sendKeyEvent(new KeyEvent(SystemClock.uptimeMillis(), editable.toString(), -1, 0));
        editable.clear();
    }

    public static void setComposingSpans(Spannable spannable) {
        setComposingSpans(spannable, 0, spannable.length());
    }

    public static void setComposingSpans(Spannable spannable, int i, int i2) {
        Object[] spans = spannable.getSpans(i, i2, Object.class);
        if (spans != null) {
            int length = spans.length;
            while (true) {
                int i3 = length - 1;
                if (i3 < 0) {
                    break;
                }
                Object obj = spans[i3];
                if (obj == COMPOSING) {
                    spannable.removeSpan(obj);
                } else {
                    int spanFlags = spannable.getSpanFlags(obj);
                    if ((spanFlags & 307) != 289) {
                        spannable.setSpan(obj, spannable.getSpanStart(obj), spannable.getSpanEnd(obj), (spanFlags & (-52)) | 256 | 33);
                    }
                }
                length = i3;
            }
        }
        spannable.setSpan(COMPOSING, i, i2, 289);
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean beginBatchEdit() {
        return false;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean clearMetaKeyStates(int i) {
        Editable editable = getEditable();
        if (editable == null) {
            return false;
        }
        MetaKeyKeyListener.clearMetaKeyState(editable, i);
        return true;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean commitCompletion(CompletionInfo completionInfo) {
        return false;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean commitCorrection(CorrectionInfo correctionInfo) {
        return false;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean commitText(CharSequence charSequence, int i) {
        replaceText(charSequence, i, false);
        this.mIMM.notifyUserAction();
        sendCurrentText();
        return true;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean deleteSurroundingText(int i, int i2) {
        Editable editable = getEditable();
        if (editable == null) {
            return false;
        }
        beginBatchEdit();
        int selectionStart = Selection.getSelectionStart(editable);
        int selectionEnd = Selection.getSelectionEnd(editable);
        int i3 = selectionStart;
        int i4 = selectionEnd;
        if (selectionStart > selectionEnd) {
            i3 = selectionEnd;
            i4 = selectionStart;
        }
        int composingSpanStart = getComposingSpanStart(editable);
        int composingSpanEnd = getComposingSpanEnd(editable);
        int i5 = composingSpanStart;
        int i6 = composingSpanEnd;
        if (composingSpanEnd < composingSpanStart) {
            i5 = composingSpanEnd;
            i6 = composingSpanStart;
        }
        int i7 = i3;
        int i8 = i4;
        if (i5 != -1) {
            i7 = i3;
            i8 = i4;
            if (i6 != -1) {
                int i9 = i3;
                if (i5 < i3) {
                    i9 = i5;
                }
                i7 = i9;
                i8 = i4;
                if (i6 > i4) {
                    i8 = i6;
                    i7 = i9;
                }
            }
        }
        int i10 = 0;
        if (i > 0) {
            int i11 = i7 - i;
            int i12 = i11;
            if (i11 < 0) {
                i12 = 0;
            }
            editable.delete(i12, i7);
            i10 = i7 - i12;
        }
        if (i2 > 0) {
            int i13 = i8 - i10;
            int i14 = i13 + i2;
            int i15 = i14;
            if (i14 > editable.length()) {
                i15 = editable.length();
            }
            editable.delete(i13, i15);
        }
        endBatchEdit();
        return true;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean endBatchEdit() {
        return false;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean finishComposingText() {
        Editable editable = getEditable();
        if (editable != null) {
            beginBatchEdit();
            removeComposingSpans(editable);
            sendCurrentText();
            endBatchEdit();
            return true;
        }
        return true;
    }

    @Override // android.view.inputmethod.InputConnection
    public int getCursorCapsMode(int i) {
        Editable editable;
        if (this.mDummyMode || (editable = getEditable()) == null) {
            return 0;
        }
        int selectionStart = Selection.getSelectionStart(editable);
        int selectionEnd = Selection.getSelectionEnd(editable);
        int i2 = selectionStart;
        if (selectionStart > selectionEnd) {
            i2 = selectionEnd;
        }
        return TextUtils.getCapsMode(editable, i2, i);
    }

    public Editable getEditable() {
        if (this.mEditable == null) {
            this.mEditable = Editable.Factory.getInstance().newEditable("");
            Selection.setSelection(this.mEditable, 0);
        }
        return this.mEditable;
    }

    @Override // android.view.inputmethod.InputConnection
    public ExtractedText getExtractedText(ExtractedTextRequest extractedTextRequest, int i) {
        return null;
    }

    @Override // android.view.inputmethod.InputConnection
    public CharSequence getSelectedText(int i) {
        Editable editable = getEditable();
        if (editable == null) {
            return null;
        }
        int selectionStart = Selection.getSelectionStart(editable);
        int selectionEnd = Selection.getSelectionEnd(editable);
        int i2 = selectionStart;
        int i3 = selectionEnd;
        if (selectionStart > selectionEnd) {
            i3 = selectionStart;
            i2 = selectionEnd;
        }
        if (i2 != i3) {
            return (i & 1) != 0 ? editable.subSequence(i2, i3) : TextUtils.substring(editable, i2, i3);
        }
        return null;
    }

    @Override // android.view.inputmethod.InputConnection
    public CharSequence getTextAfterCursor(int i, int i2) {
        Editable editable = getEditable();
        if (editable == null) {
            return null;
        }
        int selectionStart = Selection.getSelectionStart(editable);
        int selectionEnd = Selection.getSelectionEnd(editable);
        int i3 = selectionEnd;
        if (selectionStart > selectionEnd) {
            i3 = selectionStart;
        }
        int i4 = i3;
        if (i3 < 0) {
            i4 = 0;
        }
        int i5 = i;
        if (i4 + i > editable.length()) {
            i5 = editable.length() - i4;
        }
        return (i2 & 1) != 0 ? editable.subSequence(i4, i4 + i5) : TextUtils.substring(editable, i4, i4 + i5);
    }

    @Override // android.view.inputmethod.InputConnection
    public CharSequence getTextBeforeCursor(int i, int i2) {
        Editable editable = getEditable();
        if (editable == null) {
            return null;
        }
        int selectionStart = Selection.getSelectionStart(editable);
        int selectionEnd = Selection.getSelectionEnd(editable);
        int i3 = selectionStart;
        if (selectionStart > selectionEnd) {
            i3 = selectionEnd;
        }
        if (i3 <= 0) {
            return "";
        }
        int i4 = i;
        if (i > i3) {
            i4 = i3;
        }
        return (i2 & 1) != 0 ? editable.subSequence(i3 - i4, i3) : TextUtils.substring(editable, i3 - i4, i3);
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean performContextMenuAction(int i) {
        return false;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean performEditorAction(int i) {
        long uptimeMillis = SystemClock.uptimeMillis();
        sendKeyEvent(new KeyEvent(uptimeMillis, uptimeMillis, 0, 66, 0, 0, -1, 0, 22));
        sendKeyEvent(new KeyEvent(SystemClock.uptimeMillis(), uptimeMillis, 1, 66, 0, 0, -1, 0, 22));
        return true;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean performPrivateCommand(String str, Bundle bundle) {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void reportFinish() {
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean reportFullscreenMode(boolean z) {
        this.mIMM.setFullscreenMode(z);
        return true;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean requestCursorUpdates(int i) {
        return false;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean sendKeyEvent(KeyEvent keyEvent) {
        synchronized (this.mIMM.mH) {
            ViewRootImpl viewRootImpl = this.mTargetView != null ? this.mTargetView.getViewRootImpl() : null;
            ViewRootImpl viewRootImpl2 = viewRootImpl;
            if (viewRootImpl == null) {
                viewRootImpl2 = viewRootImpl;
                if (this.mIMM.mServedView != null) {
                    viewRootImpl2 = this.mIMM.mServedView.getViewRootImpl();
                }
            }
            if (viewRootImpl2 != null) {
                viewRootImpl2.dispatchKeyFromIme(keyEvent);
            }
        }
        this.mIMM.notifyUserAction();
        return false;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean setComposingRegion(int i, int i2) {
        Editable editable = getEditable();
        if (editable != null) {
            beginBatchEdit();
            removeComposingSpans(editable);
            int i3 = i;
            int i4 = i2;
            if (i > i2) {
                i4 = i;
                i3 = i2;
            }
            int length = editable.length();
            int i5 = i3;
            if (i3 < 0) {
                i5 = 0;
            }
            int i6 = i4;
            if (i4 < 0) {
                i6 = 0;
            }
            int i7 = i5;
            if (i5 > length) {
                i7 = length;
            }
            int i8 = i6;
            if (i6 > length) {
                i8 = length;
            }
            ensureDefaultComposingSpans();
            if (this.mDefaultComposingSpans != null) {
                int i9 = 0;
                while (true) {
                    int i10 = i9;
                    if (i10 >= this.mDefaultComposingSpans.length) {
                        break;
                    }
                    editable.setSpan(this.mDefaultComposingSpans[i10], i7, i8, 289);
                    i9 = i10 + 1;
                }
            }
            editable.setSpan(COMPOSING, i7, i8, 289);
            sendCurrentText();
            endBatchEdit();
            return true;
        }
        return true;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean setComposingText(CharSequence charSequence, int i) {
        replaceText(charSequence, i, true);
        this.mIMM.notifyUserAction();
        return true;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean setSelection(int i, int i2) {
        boolean z;
        Editable editable = getEditable();
        if (editable == null) {
            z = false;
        } else {
            int length = editable.length();
            z = true;
            if (i <= length) {
                z = true;
                if (i2 <= length) {
                    z = true;
                    if (i >= 0) {
                        z = true;
                        if (i2 >= 0) {
                            if (i != i2 || MetaKeyKeyListener.getMetaState(editable, 2048) == 0) {
                                Selection.setSelection(editable, i, i2);
                                return true;
                            }
                            Selection.extendSelection(editable, i);
                            return true;
                        }
                    }
                }
            }
        }
        return z;
    }
}
