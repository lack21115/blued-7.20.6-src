package android.view.inputmethod;

import android.os.Bundle;
import android.view.KeyEvent;

/* loaded from: source-4181928-dex2jar.jar:android/view/inputmethod/InputConnection.class */
public interface InputConnection {
    public static final int CURSOR_UPDATE_IMMEDIATE = 1;
    public static final int CURSOR_UPDATE_MONITOR = 2;
    public static final int GET_EXTRACTED_TEXT_MONITOR = 1;
    public static final int GET_TEXT_WITH_STYLES = 1;

    boolean beginBatchEdit();

    boolean clearMetaKeyStates(int i);

    boolean commitCompletion(CompletionInfo completionInfo);

    boolean commitCorrection(CorrectionInfo correctionInfo);

    boolean commitText(CharSequence charSequence, int i);

    boolean deleteSurroundingText(int i, int i2);

    boolean endBatchEdit();

    boolean finishComposingText();

    int getCursorCapsMode(int i);

    ExtractedText getExtractedText(ExtractedTextRequest extractedTextRequest, int i);

    CharSequence getSelectedText(int i);

    CharSequence getTextAfterCursor(int i, int i2);

    CharSequence getTextBeforeCursor(int i, int i2);

    boolean performContextMenuAction(int i);

    boolean performEditorAction(int i);

    boolean performPrivateCommand(String str, Bundle bundle);

    boolean reportFullscreenMode(boolean z);

    boolean requestCursorUpdates(int i);

    boolean sendKeyEvent(KeyEvent keyEvent);

    boolean setComposingRegion(int i, int i2);

    boolean setComposingText(CharSequence charSequence, int i);

    boolean setSelection(int i, int i2);
}
