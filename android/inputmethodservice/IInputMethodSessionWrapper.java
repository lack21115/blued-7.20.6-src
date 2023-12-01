package android.inputmethodservice;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.util.SparseArray;
import android.view.InputChannel;
import android.view.InputEvent;
import android.view.InputEventReceiver;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.inputmethod.CompletionInfo;
import android.view.inputmethod.CursorAnchorInfo;
import android.view.inputmethod.ExtractedText;
import android.view.inputmethod.InputMethodSession;
import com.android.internal.os.HandlerCaller;
import com.android.internal.os.SomeArgs;
import com.android.internal.view.IInputMethodSession;

/* loaded from: source-9557208-dex2jar.jar:android/inputmethodservice/IInputMethodSessionWrapper.class */
class IInputMethodSessionWrapper extends IInputMethodSession.Stub implements HandlerCaller.Callback {
    private static final int DO_APP_PRIVATE_COMMAND = 100;
    private static final int DO_DISPLAY_COMPLETIONS = 65;
    private static final int DO_FINISH_INPUT = 60;
    private static final int DO_FINISH_SESSION = 110;
    private static final int DO_TOGGLE_SOFT_INPUT = 105;
    private static final int DO_UPDATE_CURSOR = 95;
    private static final int DO_UPDATE_CURSOR_ANCHOR_INFO = 99;
    private static final int DO_UPDATE_EXTRACTED_TEXT = 67;
    private static final int DO_UPDATE_SELECTION = 90;
    private static final int DO_VIEW_CLICKED = 115;
    private static final String TAG = "InputMethodWrapper";
    HandlerCaller mCaller;
    InputChannel mChannel;
    InputMethodSession mInputMethodSession;
    ImeInputEventReceiver mReceiver;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-9557208-dex2jar.jar:android/inputmethodservice/IInputMethodSessionWrapper$ImeInputEventReceiver.class */
    public final class ImeInputEventReceiver extends InputEventReceiver implements InputMethodSession.EventCallback {
        private final SparseArray<InputEvent> mPendingEvents;

        public ImeInputEventReceiver(InputChannel inputChannel, Looper looper) {
            super(inputChannel, looper);
            this.mPendingEvents = new SparseArray<>();
        }

        @Override // android.view.inputmethod.InputMethodSession.EventCallback
        public void finishedEvent(int i, boolean z) {
            int indexOfKey = this.mPendingEvents.indexOfKey(i);
            if (indexOfKey >= 0) {
                InputEvent valueAt = this.mPendingEvents.valueAt(indexOfKey);
                this.mPendingEvents.removeAt(indexOfKey);
                finishInputEvent(valueAt, z);
            }
        }

        @Override // android.view.InputEventReceiver
        public void onInputEvent(InputEvent inputEvent) {
            if (IInputMethodSessionWrapper.this.mInputMethodSession == null) {
                finishInputEvent(inputEvent, false);
                return;
            }
            int sequenceNumber = inputEvent.getSequenceNumber();
            this.mPendingEvents.put(sequenceNumber, inputEvent);
            if (inputEvent instanceof KeyEvent) {
                IInputMethodSessionWrapper.this.mInputMethodSession.dispatchKeyEvent(sequenceNumber, (KeyEvent) inputEvent, this);
                return;
            }
            MotionEvent motionEvent = (MotionEvent) inputEvent;
            if (motionEvent.isFromSource(4)) {
                IInputMethodSessionWrapper.this.mInputMethodSession.dispatchTrackballEvent(sequenceNumber, motionEvent, this);
            } else {
                IInputMethodSessionWrapper.this.mInputMethodSession.dispatchGenericMotionEvent(sequenceNumber, motionEvent, this);
            }
        }
    }

    public IInputMethodSessionWrapper(Context context, InputMethodSession inputMethodSession, InputChannel inputChannel) {
        this.mCaller = new HandlerCaller(context, (Looper) null, this, true);
        this.mInputMethodSession = inputMethodSession;
        this.mChannel = inputChannel;
        if (inputChannel != null) {
            this.mReceiver = new ImeInputEventReceiver(inputChannel, context.getMainLooper());
        }
    }

    private void doFinishSession() {
        this.mInputMethodSession = null;
        if (this.mReceiver != null) {
            this.mReceiver.dispose();
            this.mReceiver = null;
        }
        if (this.mChannel != null) {
            this.mChannel.dispose();
            this.mChannel = null;
        }
    }

    public void appPrivateCommand(String str, Bundle bundle) {
        this.mCaller.executeOrSendMessage(this.mCaller.obtainMessageOO(100, str, bundle));
    }

    public void displayCompletions(CompletionInfo[] completionInfoArr) {
        this.mCaller.executeOrSendMessage(this.mCaller.obtainMessageO(65, completionInfoArr));
    }

    public void executeMessage(Message message) {
        boolean z = true;
        if (this.mInputMethodSession == null) {
            switch (message.what) {
                case 90:
                case 100:
                    ((SomeArgs) message.obj).recycle();
                    return;
                default:
                    return;
            }
        }
        switch (message.what) {
            case 60:
                this.mInputMethodSession.finishInput();
                return;
            case 65:
                this.mInputMethodSession.displayCompletions((CompletionInfo[]) message.obj);
                return;
            case 67:
                this.mInputMethodSession.updateExtractedText(message.arg1, (ExtractedText) message.obj);
                return;
            case 90:
                SomeArgs someArgs = (SomeArgs) message.obj;
                this.mInputMethodSession.updateSelection(someArgs.argi1, someArgs.argi2, someArgs.argi3, someArgs.argi4, someArgs.argi5, someArgs.argi6);
                someArgs.recycle();
                return;
            case 95:
                this.mInputMethodSession.updateCursor((Rect) message.obj);
                return;
            case 99:
                this.mInputMethodSession.updateCursorAnchorInfo((CursorAnchorInfo) message.obj);
                return;
            case 100:
                SomeArgs someArgs2 = (SomeArgs) message.obj;
                this.mInputMethodSession.appPrivateCommand((String) someArgs2.arg1, (Bundle) someArgs2.arg2);
                someArgs2.recycle();
                return;
            case 105:
                this.mInputMethodSession.toggleSoftInput(message.arg1, message.arg2);
                return;
            case 110:
                doFinishSession();
                return;
            case 115:
                InputMethodSession inputMethodSession = this.mInputMethodSession;
                if (message.arg1 != 1) {
                    z = false;
                }
                inputMethodSession.viewClicked(z);
                return;
            default:
                Log.w(TAG, "Unhandled message code: " + message.what);
                return;
        }
    }

    public void finishInput() {
        this.mCaller.executeOrSendMessage(this.mCaller.obtainMessage(60));
    }

    public void finishSession() {
        this.mCaller.executeOrSendMessage(this.mCaller.obtainMessage(110));
    }

    public InputMethodSession getInternalInputMethodSession() {
        return this.mInputMethodSession;
    }

    public void toggleSoftInput(int i, int i2) {
        this.mCaller.executeOrSendMessage(this.mCaller.obtainMessageII(105, i, i2));
    }

    public void updateCursor(Rect rect) {
        this.mCaller.executeOrSendMessage(this.mCaller.obtainMessageO(95, rect));
    }

    public void updateCursorAnchorInfo(CursorAnchorInfo cursorAnchorInfo) {
        this.mCaller.executeOrSendMessage(this.mCaller.obtainMessageO(99, cursorAnchorInfo));
    }

    public void updateExtractedText(int i, ExtractedText extractedText) {
        this.mCaller.executeOrSendMessage(this.mCaller.obtainMessageIO(67, i, extractedText));
    }

    public void updateSelection(int i, int i2, int i3, int i4, int i5, int i6) {
        this.mCaller.executeOrSendMessage(this.mCaller.obtainMessageIIIIII(90, i, i2, i3, i4, i5, i6));
    }

    public void viewClicked(boolean z) {
        this.mCaller.executeOrSendMessage(this.mCaller.obtainMessageI(115, z ? 1 : 0));
    }
}
