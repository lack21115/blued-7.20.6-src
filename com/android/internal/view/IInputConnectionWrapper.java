package com.android.internal.view;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import android.view.KeyEvent;
import android.view.inputmethod.CompletionInfo;
import android.view.inputmethod.CorrectionInfo;
import android.view.inputmethod.ExtractedTextRequest;
import android.view.inputmethod.InputConnection;
import com.android.internal.view.IInputContext;
import java.lang.ref.WeakReference;

/* loaded from: source-4181928-dex2jar.jar:com/android/internal/view/IInputConnectionWrapper.class */
public class IInputConnectionWrapper extends IInputContext.Stub {
    private static final int DO_BEGIN_BATCH_EDIT = 90;
    private static final int DO_CLEAR_META_KEY_STATES = 130;
    private static final int DO_COMMIT_COMPLETION = 55;
    private static final int DO_COMMIT_CORRECTION = 56;
    private static final int DO_COMMIT_TEXT = 50;
    private static final int DO_DELETE_SURROUNDING_TEXT = 80;
    private static final int DO_END_BATCH_EDIT = 95;
    private static final int DO_FINISH_COMPOSING_TEXT = 65;
    private static final int DO_GET_CURSOR_CAPS_MODE = 30;
    private static final int DO_GET_EXTRACTED_TEXT = 40;
    private static final int DO_GET_SELECTED_TEXT = 25;
    private static final int DO_GET_TEXT_AFTER_CURSOR = 10;
    private static final int DO_GET_TEXT_BEFORE_CURSOR = 20;
    private static final int DO_PERFORM_CONTEXT_MENU_ACTION = 59;
    private static final int DO_PERFORM_EDITOR_ACTION = 58;
    private static final int DO_PERFORM_PRIVATE_COMMAND = 120;
    private static final int DO_REPORT_FULLSCREEN_MODE = 100;
    private static final int DO_REQUEST_UPDATE_CURSOR_ANCHOR_INFO = 140;
    private static final int DO_SEND_KEY_EVENT = 70;
    private static final int DO_SET_COMPOSING_REGION = 63;
    private static final int DO_SET_COMPOSING_TEXT = 60;
    private static final int DO_SET_SELECTION = 57;
    static final String TAG = "IInputConnectionWrapper";
    private Handler mH;
    private WeakReference<InputConnection> mInputConnection;
    private Looper mMainLooper;

    /* loaded from: source-4181928-dex2jar.jar:com/android/internal/view/IInputConnectionWrapper$MyHandler.class */
    class MyHandler extends Handler {
        MyHandler(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            IInputConnectionWrapper.this.executeMessage(message);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-4181928-dex2jar.jar:com/android/internal/view/IInputConnectionWrapper$SomeArgs.class */
    public static class SomeArgs {
        Object arg1;
        Object arg2;
        IInputContextCallback callback;
        int seq;

        SomeArgs() {
        }
    }

    public IInputConnectionWrapper(Looper looper, InputConnection inputConnection) {
        this.mInputConnection = new WeakReference<>(inputConnection);
        this.mMainLooper = looper;
        this.mH = new MyHandler(this.mMainLooper);
    }

    @Override // com.android.internal.view.IInputContext
    public void beginBatchEdit() {
        dispatchMessage(obtainMessage(90));
    }

    @Override // com.android.internal.view.IInputContext
    public void clearMetaKeyStates(int i) {
        dispatchMessage(obtainMessageII(130, i, 0));
    }

    @Override // com.android.internal.view.IInputContext
    public void commitCompletion(CompletionInfo completionInfo) {
        dispatchMessage(obtainMessageO(55, completionInfo));
    }

    @Override // com.android.internal.view.IInputContext
    public void commitCorrection(CorrectionInfo correctionInfo) {
        dispatchMessage(obtainMessageO(56, correctionInfo));
    }

    @Override // com.android.internal.view.IInputContext
    public void commitText(CharSequence charSequence, int i) {
        dispatchMessage(obtainMessageIO(50, i, charSequence));
    }

    @Override // com.android.internal.view.IInputContext
    public void deleteSurroundingText(int i, int i2) {
        dispatchMessage(obtainMessageII(80, i, i2));
    }

    void dispatchMessage(Message message) {
        if (Looper.myLooper() != this.mMainLooper) {
            this.mH.sendMessage(message);
            return;
        }
        executeMessage(message);
        message.recycle();
    }

    @Override // com.android.internal.view.IInputContext
    public void endBatchEdit() {
        dispatchMessage(obtainMessage(95));
    }

    void executeMessage(Message message) {
        boolean z = true;
        switch (message.what) {
            case 10:
                SomeArgs someArgs = (SomeArgs) message.obj;
                try {
                    InputConnection inputConnection = this.mInputConnection.get();
                    if (inputConnection != null && isActive()) {
                        someArgs.callback.setTextAfterCursor(inputConnection.getTextAfterCursor(message.arg1, message.arg2), someArgs.seq);
                        return;
                    }
                    Log.w(TAG, "getTextAfterCursor on inactive InputConnection");
                    someArgs.callback.setTextAfterCursor(null, someArgs.seq);
                    return;
                } catch (RemoteException e) {
                    Log.w(TAG, "Got RemoteException calling setTextAfterCursor", e);
                    return;
                }
            case 20:
                SomeArgs someArgs2 = (SomeArgs) message.obj;
                try {
                    InputConnection inputConnection2 = this.mInputConnection.get();
                    if (inputConnection2 != null && isActive()) {
                        someArgs2.callback.setTextBeforeCursor(inputConnection2.getTextBeforeCursor(message.arg1, message.arg2), someArgs2.seq);
                        return;
                    }
                    Log.w(TAG, "getTextBeforeCursor on inactive InputConnection");
                    someArgs2.callback.setTextBeforeCursor(null, someArgs2.seq);
                    return;
                } catch (RemoteException e2) {
                    Log.w(TAG, "Got RemoteException calling setTextBeforeCursor", e2);
                    return;
                }
            case 25:
                SomeArgs someArgs3 = (SomeArgs) message.obj;
                try {
                    InputConnection inputConnection3 = this.mInputConnection.get();
                    if (inputConnection3 != null && isActive()) {
                        someArgs3.callback.setSelectedText(inputConnection3.getSelectedText(message.arg1), someArgs3.seq);
                        return;
                    }
                    Log.w(TAG, "getSelectedText on inactive InputConnection");
                    someArgs3.callback.setSelectedText(null, someArgs3.seq);
                    return;
                } catch (RemoteException e3) {
                    Log.w(TAG, "Got RemoteException calling setSelectedText", e3);
                    return;
                }
            case 30:
                SomeArgs someArgs4 = (SomeArgs) message.obj;
                try {
                    InputConnection inputConnection4 = this.mInputConnection.get();
                    if (inputConnection4 != null && isActive()) {
                        someArgs4.callback.setCursorCapsMode(inputConnection4.getCursorCapsMode(message.arg1), someArgs4.seq);
                        return;
                    }
                    Log.w(TAG, "getCursorCapsMode on inactive InputConnection");
                    someArgs4.callback.setCursorCapsMode(0, someArgs4.seq);
                    return;
                } catch (RemoteException e4) {
                    Log.w(TAG, "Got RemoteException calling setCursorCapsMode", e4);
                    return;
                }
            case 40:
                SomeArgs someArgs5 = (SomeArgs) message.obj;
                try {
                    InputConnection inputConnection5 = this.mInputConnection.get();
                    if (inputConnection5 != null && isActive()) {
                        someArgs5.callback.setExtractedText(inputConnection5.getExtractedText((ExtractedTextRequest) someArgs5.arg1, message.arg1), someArgs5.seq);
                        return;
                    }
                    Log.w(TAG, "getExtractedText on inactive InputConnection");
                    someArgs5.callback.setExtractedText(null, someArgs5.seq);
                    return;
                } catch (RemoteException e5) {
                    Log.w(TAG, "Got RemoteException calling setExtractedText", e5);
                    return;
                }
            case 50:
                InputConnection inputConnection6 = this.mInputConnection.get();
                if (inputConnection6 == null || !isActive()) {
                    Log.w(TAG, "commitText on inactive InputConnection");
                    return;
                } else {
                    inputConnection6.commitText((CharSequence) message.obj, message.arg1);
                    return;
                }
            case 55:
                InputConnection inputConnection7 = this.mInputConnection.get();
                if (inputConnection7 == null || !isActive()) {
                    Log.w(TAG, "commitCompletion on inactive InputConnection");
                    return;
                } else {
                    inputConnection7.commitCompletion((CompletionInfo) message.obj);
                    return;
                }
            case 56:
                InputConnection inputConnection8 = this.mInputConnection.get();
                if (inputConnection8 == null || !isActive()) {
                    Log.w(TAG, "commitCorrection on inactive InputConnection");
                    return;
                } else {
                    inputConnection8.commitCorrection((CorrectionInfo) message.obj);
                    return;
                }
            case 57:
                InputConnection inputConnection9 = this.mInputConnection.get();
                if (inputConnection9 == null || !isActive()) {
                    Log.w(TAG, "setSelection on inactive InputConnection");
                    return;
                } else {
                    inputConnection9.setSelection(message.arg1, message.arg2);
                    return;
                }
            case 58:
                InputConnection inputConnection10 = this.mInputConnection.get();
                if (inputConnection10 == null || !isActive()) {
                    Log.w(TAG, "performEditorAction on inactive InputConnection");
                    return;
                } else {
                    inputConnection10.performEditorAction(message.arg1);
                    return;
                }
            case 59:
                InputConnection inputConnection11 = this.mInputConnection.get();
                if (inputConnection11 == null || !isActive()) {
                    Log.w(TAG, "performContextMenuAction on inactive InputConnection");
                    return;
                } else {
                    inputConnection11.performContextMenuAction(message.arg1);
                    return;
                }
            case 60:
                InputConnection inputConnection12 = this.mInputConnection.get();
                if (inputConnection12 == null || !isActive()) {
                    Log.w(TAG, "setComposingText on inactive InputConnection");
                    return;
                } else {
                    inputConnection12.setComposingText((CharSequence) message.obj, message.arg1);
                    return;
                }
            case 63:
                InputConnection inputConnection13 = this.mInputConnection.get();
                if (inputConnection13 == null || !isActive()) {
                    Log.w(TAG, "setComposingRegion on inactive InputConnection");
                    return;
                } else {
                    inputConnection13.setComposingRegion(message.arg1, message.arg2);
                    return;
                }
            case 65:
                InputConnection inputConnection14 = this.mInputConnection.get();
                if (inputConnection14 == null) {
                    Log.w(TAG, "finishComposingText on inactive InputConnection");
                    return;
                } else {
                    inputConnection14.finishComposingText();
                    return;
                }
            case 70:
                InputConnection inputConnection15 = this.mInputConnection.get();
                if (inputConnection15 == null || !isActive()) {
                    Log.w(TAG, "sendKeyEvent on inactive InputConnection");
                    return;
                } else {
                    inputConnection15.sendKeyEvent((KeyEvent) message.obj);
                    return;
                }
            case 80:
                InputConnection inputConnection16 = this.mInputConnection.get();
                if (inputConnection16 == null || !isActive()) {
                    Log.w(TAG, "deleteSurroundingText on inactive InputConnection");
                    return;
                } else {
                    inputConnection16.deleteSurroundingText(message.arg1, message.arg2);
                    return;
                }
            case 90:
                InputConnection inputConnection17 = this.mInputConnection.get();
                if (inputConnection17 == null || !isActive()) {
                    Log.w(TAG, "beginBatchEdit on inactive InputConnection");
                    return;
                } else {
                    inputConnection17.beginBatchEdit();
                    return;
                }
            case 95:
                InputConnection inputConnection18 = this.mInputConnection.get();
                if (inputConnection18 == null || !isActive()) {
                    Log.w(TAG, "endBatchEdit on inactive InputConnection");
                    return;
                } else {
                    inputConnection18.endBatchEdit();
                    return;
                }
            case 100:
                InputConnection inputConnection19 = this.mInputConnection.get();
                if (inputConnection19 == null || !isActive()) {
                    Log.w(TAG, "showStatusIcon on inactive InputConnection");
                    return;
                }
                if (message.arg1 != 1) {
                    z = false;
                }
                inputConnection19.reportFullscreenMode(z);
                return;
            case 120:
                InputConnection inputConnection20 = this.mInputConnection.get();
                if (inputConnection20 == null || !isActive()) {
                    Log.w(TAG, "performPrivateCommand on inactive InputConnection");
                    return;
                }
                SomeArgs someArgs6 = (SomeArgs) message.obj;
                inputConnection20.performPrivateCommand((String) someArgs6.arg1, (Bundle) someArgs6.arg2);
                return;
            case 130:
                InputConnection inputConnection21 = this.mInputConnection.get();
                if (inputConnection21 == null || !isActive()) {
                    Log.w(TAG, "clearMetaKeyStates on inactive InputConnection");
                    return;
                } else {
                    inputConnection21.clearMetaKeyStates(message.arg1);
                    return;
                }
            case 140:
                SomeArgs someArgs7 = (SomeArgs) message.obj;
                try {
                    InputConnection inputConnection22 = this.mInputConnection.get();
                    if (inputConnection22 != null && isActive()) {
                        someArgs7.callback.setRequestUpdateCursorAnchorInfoResult(inputConnection22.requestCursorUpdates(message.arg1), someArgs7.seq);
                        return;
                    }
                    Log.w(TAG, "requestCursorAnchorInfo on inactive InputConnection");
                    someArgs7.callback.setRequestUpdateCursorAnchorInfoResult(false, someArgs7.seq);
                    return;
                } catch (RemoteException e6) {
                    Log.w(TAG, "Got RemoteException calling requestCursorAnchorInfo", e6);
                    return;
                }
            default:
                Log.w(TAG, "Unhandled message code: " + message.what);
                return;
        }
    }

    @Override // com.android.internal.view.IInputContext
    public void finishComposingText() {
        dispatchMessage(obtainMessage(65));
    }

    @Override // com.android.internal.view.IInputContext
    public void getCursorCapsMode(int i, int i2, IInputContextCallback iInputContextCallback) {
        dispatchMessage(obtainMessageISC(30, i, i2, iInputContextCallback));
    }

    @Override // com.android.internal.view.IInputContext
    public void getExtractedText(ExtractedTextRequest extractedTextRequest, int i, int i2, IInputContextCallback iInputContextCallback) {
        dispatchMessage(obtainMessageIOSC(40, i, extractedTextRequest, i2, iInputContextCallback));
    }

    @Override // com.android.internal.view.IInputContext
    public void getSelectedText(int i, int i2, IInputContextCallback iInputContextCallback) {
        dispatchMessage(obtainMessageISC(25, i, i2, iInputContextCallback));
    }

    @Override // com.android.internal.view.IInputContext
    public void getTextAfterCursor(int i, int i2, int i3, IInputContextCallback iInputContextCallback) {
        dispatchMessage(obtainMessageIISC(10, i, i2, i3, iInputContextCallback));
    }

    @Override // com.android.internal.view.IInputContext
    public void getTextBeforeCursor(int i, int i2, int i3, IInputContextCallback iInputContextCallback) {
        dispatchMessage(obtainMessageIISC(20, i, i2, i3, iInputContextCallback));
    }

    public boolean isActive() {
        return true;
    }

    Message obtainMessage(int i) {
        return this.mH.obtainMessage(i);
    }

    Message obtainMessageII(int i, int i2, int i3) {
        return this.mH.obtainMessage(i, i2, i3);
    }

    Message obtainMessageIISC(int i, int i2, int i3, int i4, IInputContextCallback iInputContextCallback) {
        SomeArgs someArgs = new SomeArgs();
        someArgs.callback = iInputContextCallback;
        someArgs.seq = i4;
        return this.mH.obtainMessage(i, i2, i3, someArgs);
    }

    Message obtainMessageIO(int i, int i2, Object obj) {
        return this.mH.obtainMessage(i, i2, 0, obj);
    }

    Message obtainMessageIOSC(int i, int i2, Object obj, int i3, IInputContextCallback iInputContextCallback) {
        SomeArgs someArgs = new SomeArgs();
        someArgs.arg1 = obj;
        someArgs.callback = iInputContextCallback;
        someArgs.seq = i3;
        return this.mH.obtainMessage(i, i2, 0, someArgs);
    }

    Message obtainMessageISC(int i, int i2, int i3, IInputContextCallback iInputContextCallback) {
        SomeArgs someArgs = new SomeArgs();
        someArgs.callback = iInputContextCallback;
        someArgs.seq = i3;
        return this.mH.obtainMessage(i, i2, 0, someArgs);
    }

    Message obtainMessageO(int i, Object obj) {
        return this.mH.obtainMessage(i, 0, 0, obj);
    }

    Message obtainMessageOO(int i, Object obj, Object obj2) {
        SomeArgs someArgs = new SomeArgs();
        someArgs.arg1 = obj;
        someArgs.arg2 = obj2;
        return this.mH.obtainMessage(i, 0, 0, someArgs);
    }

    Message obtainMessageOSC(int i, Object obj, int i2, IInputContextCallback iInputContextCallback) {
        SomeArgs someArgs = new SomeArgs();
        someArgs.arg1 = obj;
        someArgs.callback = iInputContextCallback;
        someArgs.seq = i2;
        return this.mH.obtainMessage(i, 0, 0, someArgs);
    }

    @Override // com.android.internal.view.IInputContext
    public void performContextMenuAction(int i) {
        dispatchMessage(obtainMessageII(59, i, 0));
    }

    @Override // com.android.internal.view.IInputContext
    public void performEditorAction(int i) {
        dispatchMessage(obtainMessageII(58, i, 0));
    }

    @Override // com.android.internal.view.IInputContext
    public void performPrivateCommand(String str, Bundle bundle) {
        dispatchMessage(obtainMessageOO(120, str, bundle));
    }

    @Override // com.android.internal.view.IInputContext
    public void reportFullscreenMode(boolean z) {
        dispatchMessage(obtainMessageII(100, z ? 1 : 0, 0));
    }

    @Override // com.android.internal.view.IInputContext
    public void requestUpdateCursorAnchorInfo(int i, int i2, IInputContextCallback iInputContextCallback) {
        dispatchMessage(obtainMessageISC(140, i, i2, iInputContextCallback));
    }

    @Override // com.android.internal.view.IInputContext
    public void sendKeyEvent(KeyEvent keyEvent) {
        dispatchMessage(obtainMessageO(70, keyEvent));
    }

    @Override // com.android.internal.view.IInputContext
    public void setComposingRegion(int i, int i2) {
        dispatchMessage(obtainMessageII(63, i, i2));
    }

    @Override // com.android.internal.view.IInputContext
    public void setComposingText(CharSequence charSequence, int i) {
        dispatchMessage(obtainMessageIO(60, i, charSequence));
    }

    @Override // com.android.internal.view.IInputContext
    public void setSelection(int i, int i2) {
        dispatchMessage(obtainMessageII(57, i, i2));
    }
}
