package com.android.internal.view;

import android.os.Bundle;
import android.os.RemoteException;
import android.os.SystemClock;
import android.util.Log;
import android.view.KeyEvent;
import android.view.inputmethod.CompletionInfo;
import android.view.inputmethod.CorrectionInfo;
import android.view.inputmethod.ExtractedText;
import android.view.inputmethod.ExtractedTextRequest;
import android.view.inputmethod.InputConnection;
import com.android.internal.view.IInputContextCallback;

/* loaded from: source-4181928-dex2jar.jar:com/android/internal/view/InputConnectionWrapper.class */
public class InputConnectionWrapper implements InputConnection {
    private static final int MAX_WAIT_TIME_MILLIS = 2000;
    private final IInputContext mIInputContext;

    /* loaded from: source-4181928-dex2jar.jar:com/android/internal/view/InputConnectionWrapper$InputContextCallback.class */
    static class InputContextCallback extends IInputContextCallback.Stub {
        private static final String TAG = "InputConnectionWrapper.ICC";
        private static InputContextCallback sInstance = new InputContextCallback();
        private static int sSequenceNumber = 1;
        public int mCursorCapsMode;
        public ExtractedText mExtractedText;
        public boolean mHaveValue;
        public boolean mRequestUpdateCursorAnchorInfoResult;
        public CharSequence mSelectedText;
        public int mSeq;
        public CharSequence mTextAfterCursor;
        public CharSequence mTextBeforeCursor;

        InputContextCallback() {
        }

        static /* synthetic */ InputContextCallback access$000() {
            return getInstance();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void dispose() {
            synchronized (InputContextCallback.class) {
                try {
                    if (sInstance == null) {
                        this.mTextAfterCursor = null;
                        this.mTextBeforeCursor = null;
                        this.mExtractedText = null;
                        sInstance = this;
                    }
                } finally {
                }
            }
        }

        private static InputContextCallback getInstance() {
            InputContextCallback inputContextCallback;
            synchronized (InputContextCallback.class) {
                try {
                    if (sInstance != null) {
                        inputContextCallback = sInstance;
                        sInstance = null;
                        inputContextCallback.mHaveValue = false;
                    } else {
                        inputContextCallback = new InputContextCallback();
                    }
                    int i = sSequenceNumber;
                    sSequenceNumber = i + 1;
                    inputContextCallback.mSeq = i;
                } catch (Throwable th) {
                    throw th;
                }
            }
            return inputContextCallback;
        }

        @Override // com.android.internal.view.IInputContextCallback
        public void setCursorCapsMode(int i, int i2) {
            synchronized (this) {
                if (i2 == this.mSeq) {
                    this.mCursorCapsMode = i;
                    this.mHaveValue = true;
                    notifyAll();
                } else {
                    Log.i(TAG, "Got out-of-sequence callback " + i2 + " (expected " + this.mSeq + ") in setCursorCapsMode, ignoring.");
                }
            }
        }

        @Override // com.android.internal.view.IInputContextCallback
        public void setExtractedText(ExtractedText extractedText, int i) {
            synchronized (this) {
                if (i == this.mSeq) {
                    this.mExtractedText = extractedText;
                    this.mHaveValue = true;
                    notifyAll();
                } else {
                    Log.i(TAG, "Got out-of-sequence callback " + i + " (expected " + this.mSeq + ") in setExtractedText, ignoring.");
                }
            }
        }

        @Override // com.android.internal.view.IInputContextCallback
        public void setRequestUpdateCursorAnchorInfoResult(boolean z, int i) {
            synchronized (this) {
                if (i == this.mSeq) {
                    this.mRequestUpdateCursorAnchorInfoResult = z;
                    this.mHaveValue = true;
                    notifyAll();
                } else {
                    Log.i(TAG, "Got out-of-sequence callback " + i + " (expected " + this.mSeq + ") in setCursorAnchorInfoRequestResult, ignoring.");
                }
            }
        }

        @Override // com.android.internal.view.IInputContextCallback
        public void setSelectedText(CharSequence charSequence, int i) {
            synchronized (this) {
                if (i == this.mSeq) {
                    this.mSelectedText = charSequence;
                    this.mHaveValue = true;
                    notifyAll();
                } else {
                    Log.i(TAG, "Got out-of-sequence callback " + i + " (expected " + this.mSeq + ") in setSelectedText, ignoring.");
                }
            }
        }

        @Override // com.android.internal.view.IInputContextCallback
        public void setTextAfterCursor(CharSequence charSequence, int i) {
            synchronized (this) {
                if (i == this.mSeq) {
                    this.mTextAfterCursor = charSequence;
                    this.mHaveValue = true;
                    notifyAll();
                } else {
                    Log.i(TAG, "Got out-of-sequence callback " + i + " (expected " + this.mSeq + ") in setTextAfterCursor, ignoring.");
                }
            }
        }

        @Override // com.android.internal.view.IInputContextCallback
        public void setTextBeforeCursor(CharSequence charSequence, int i) {
            synchronized (this) {
                if (i == this.mSeq) {
                    this.mTextBeforeCursor = charSequence;
                    this.mHaveValue = true;
                    notifyAll();
                } else {
                    Log.i(TAG, "Got out-of-sequence callback " + i + " (expected " + this.mSeq + ") in setTextBeforeCursor, ignoring.");
                }
            }
        }

        void waitForResultLocked() {
            long uptimeMillis = SystemClock.uptimeMillis();
            while (!this.mHaveValue) {
                long uptimeMillis2 = (uptimeMillis + 2000) - SystemClock.uptimeMillis();
                if (uptimeMillis2 <= 0) {
                    Log.w(TAG, "Timed out waiting on IInputContextCallback");
                    return;
                }
                try {
                    wait(uptimeMillis2);
                } catch (InterruptedException e) {
                }
            }
        }
    }

    public InputConnectionWrapper(IInputContext iInputContext) {
        this.mIInputContext = iInputContext;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean beginBatchEdit() {
        try {
            this.mIInputContext.beginBatchEdit();
            return true;
        } catch (RemoteException e) {
            return false;
        }
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean clearMetaKeyStates(int i) {
        try {
            this.mIInputContext.clearMetaKeyStates(i);
            return true;
        } catch (RemoteException e) {
            return false;
        }
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean commitCompletion(CompletionInfo completionInfo) {
        try {
            this.mIInputContext.commitCompletion(completionInfo);
            return true;
        } catch (RemoteException e) {
            return false;
        }
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean commitCorrection(CorrectionInfo correctionInfo) {
        try {
            this.mIInputContext.commitCorrection(correctionInfo);
            return true;
        } catch (RemoteException e) {
            return false;
        }
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean commitText(CharSequence charSequence, int i) {
        try {
            this.mIInputContext.commitText(charSequence, i);
            return true;
        } catch (RemoteException e) {
            return false;
        }
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean deleteSurroundingText(int i, int i2) {
        try {
            this.mIInputContext.deleteSurroundingText(i, i2);
            return true;
        } catch (RemoteException e) {
            return false;
        }
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean endBatchEdit() {
        try {
            this.mIInputContext.endBatchEdit();
            return true;
        } catch (RemoteException e) {
            return false;
        }
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean finishComposingText() {
        try {
            this.mIInputContext.finishComposingText();
            return true;
        } catch (RemoteException e) {
            return false;
        }
    }

    @Override // android.view.inputmethod.InputConnection
    public int getCursorCapsMode(int i) {
        int i2;
        try {
            InputContextCallback access$000 = InputContextCallback.access$000();
            this.mIInputContext.getCursorCapsMode(i, access$000.mSeq, access$000);
            synchronized (access$000) {
                access$000.waitForResultLocked();
                i2 = 0;
                if (access$000.mHaveValue) {
                    i2 = access$000.mCursorCapsMode;
                }
            }
            access$000.dispose();
            return i2;
        } catch (RemoteException e) {
            return 0;
        }
    }

    @Override // android.view.inputmethod.InputConnection
    public ExtractedText getExtractedText(ExtractedTextRequest extractedTextRequest, int i) {
        ExtractedText extractedText;
        try {
            InputContextCallback access$000 = InputContextCallback.access$000();
            this.mIInputContext.getExtractedText(extractedTextRequest, i, access$000.mSeq, access$000);
            synchronized (access$000) {
                access$000.waitForResultLocked();
                extractedText = null;
                if (access$000.mHaveValue) {
                    extractedText = access$000.mExtractedText;
                }
            }
            access$000.dispose();
            return extractedText;
        } catch (RemoteException e) {
            return null;
        }
    }

    @Override // android.view.inputmethod.InputConnection
    public CharSequence getSelectedText(int i) {
        CharSequence charSequence = null;
        try {
            InputContextCallback access$000 = InputContextCallback.access$000();
            this.mIInputContext.getSelectedText(i, access$000.mSeq, access$000);
            synchronized (access$000) {
                access$000.waitForResultLocked();
                if (access$000.mHaveValue) {
                    charSequence = access$000.mSelectedText;
                }
            }
            access$000.dispose();
            return charSequence;
        } catch (RemoteException e) {
            return null;
        }
    }

    @Override // android.view.inputmethod.InputConnection
    public CharSequence getTextAfterCursor(int i, int i2) {
        CharSequence charSequence = null;
        try {
            InputContextCallback access$000 = InputContextCallback.access$000();
            this.mIInputContext.getTextAfterCursor(i, i2, access$000.mSeq, access$000);
            synchronized (access$000) {
                access$000.waitForResultLocked();
                if (access$000.mHaveValue) {
                    charSequence = access$000.mTextAfterCursor;
                }
            }
            access$000.dispose();
            return charSequence;
        } catch (RemoteException e) {
            return null;
        }
    }

    @Override // android.view.inputmethod.InputConnection
    public CharSequence getTextBeforeCursor(int i, int i2) {
        CharSequence charSequence = null;
        try {
            InputContextCallback access$000 = InputContextCallback.access$000();
            this.mIInputContext.getTextBeforeCursor(i, i2, access$000.mSeq, access$000);
            synchronized (access$000) {
                access$000.waitForResultLocked();
                if (access$000.mHaveValue) {
                    charSequence = access$000.mTextBeforeCursor;
                }
            }
            access$000.dispose();
            return charSequence;
        } catch (RemoteException e) {
            return null;
        }
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean performContextMenuAction(int i) {
        try {
            this.mIInputContext.performContextMenuAction(i);
            return true;
        } catch (RemoteException e) {
            return false;
        }
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean performEditorAction(int i) {
        try {
            this.mIInputContext.performEditorAction(i);
            return true;
        } catch (RemoteException e) {
            return false;
        }
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean performPrivateCommand(String str, Bundle bundle) {
        try {
            this.mIInputContext.performPrivateCommand(str, bundle);
            return true;
        } catch (RemoteException e) {
            return false;
        }
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean reportFullscreenMode(boolean z) {
        try {
            this.mIInputContext.reportFullscreenMode(z);
            return true;
        } catch (RemoteException e) {
            return false;
        }
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean requestCursorUpdates(int i) {
        boolean z = false;
        try {
            InputContextCallback access$000 = InputContextCallback.access$000();
            this.mIInputContext.requestUpdateCursorAnchorInfo(i, access$000.mSeq, access$000);
            synchronized (access$000) {
                access$000.waitForResultLocked();
                if (access$000.mHaveValue) {
                    z = access$000.mRequestUpdateCursorAnchorInfoResult;
                }
            }
            access$000.dispose();
            return z;
        } catch (RemoteException e) {
            return false;
        }
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean sendKeyEvent(KeyEvent keyEvent) {
        try {
            this.mIInputContext.sendKeyEvent(keyEvent);
            return true;
        } catch (RemoteException e) {
            return false;
        }
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean setComposingRegion(int i, int i2) {
        try {
            this.mIInputContext.setComposingRegion(i, i2);
            return true;
        } catch (RemoteException e) {
            return false;
        }
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean setComposingText(CharSequence charSequence, int i) {
        try {
            this.mIInputContext.setComposingText(charSequence, i);
            return true;
        } catch (RemoteException e) {
            return false;
        }
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean setSelection(int i, int i2) {
        try {
            this.mIInputContext.setSelection(i, i2);
            return true;
        } catch (RemoteException e) {
            return false;
        }
    }
}
