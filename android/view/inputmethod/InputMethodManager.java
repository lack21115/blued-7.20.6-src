package android.view.inputmethod;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.os.ServiceManager;
import android.os.Trace;
import android.text.style.SuggestionSpan;
import android.util.Log;
import android.util.Pools;
import android.util.PrintWriterPrinter;
import android.util.SparseArray;
import android.view.InputChannel;
import android.view.InputEvent;
import android.view.InputEventSender;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewRootImpl;
import com.android.internal.os.SomeArgs;
import com.android.internal.view.IInputConnectionWrapper;
import com.android.internal.view.IInputContext;
import com.android.internal.view.IInputMethodClient;
import com.android.internal.view.IInputMethodManager;
import com.android.internal.view.IInputMethodSession;
import com.android.internal.view.InputBindResult;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* loaded from: source-4181928-dex2jar.jar:android/view/inputmethod/InputMethodManager.class */
public final class InputMethodManager {
    public static final int CONTROL_START_INITIAL = 256;
    public static final int CONTROL_WINDOW_FIRST = 4;
    public static final int CONTROL_WINDOW_IS_TEXT_EDITOR = 2;
    public static final int CONTROL_WINDOW_VIEW_HAS_FOCUS = 1;
    static final boolean DEBUG = false;
    public static final int DISPATCH_HANDLED = 1;
    public static final int DISPATCH_IN_PROGRESS = -1;
    public static final int DISPATCH_NOT_HANDLED = 0;
    public static final int HIDE_IMPLICIT_ONLY = 1;
    public static final int HIDE_NOT_ALWAYS = 2;
    static final long INPUT_METHOD_NOT_RESPONDING_TIMEOUT = 2500;
    static final int MSG_BIND = 2;
    static final int MSG_DUMP = 1;
    static final int MSG_FLUSH_INPUT_EVENT = 7;
    static final int MSG_SEND_INPUT_EVENT = 5;
    static final int MSG_SET_ACTIVE = 4;
    static final int MSG_SET_USER_ACTION_NOTIFICATION_SEQUENCE_NUMBER = 9;
    static final int MSG_TIMEOUT_INPUT_EVENT = 6;
    static final int MSG_UNBIND = 3;
    private static final int NOT_AN_ACTION_NOTIFICATION_SEQUENCE_NUMBER = -1;
    static final String PENDING_EVENT_COUNTER = "aq:imm";
    private static final int REQUEST_UPDATE_CURSOR_ANCHOR_INFO_NONE = 0;
    public static final int RESULT_HIDDEN = 3;
    public static final int RESULT_SHOWN = 2;
    public static final int RESULT_UNCHANGED_HIDDEN = 1;
    public static final int RESULT_UNCHANGED_SHOWN = 0;
    public static final int SHOW_FORCED = 2;
    public static final int SHOW_IMPLICIT = 1;
    static final String TAG = "InputMethodManager";
    static InputMethodManager sInstance;
    CompletionInfo[] mCompletions;
    InputChannel mCurChannel;
    String mCurId;
    IInputMethodSession mCurMethod;
    View mCurRootView;
    ImeInputEventSender mCurSender;
    EditorInfo mCurrentTextBoxAttribute;
    int mCursorCandEnd;
    int mCursorCandStart;
    int mCursorSelEnd;
    int mCursorSelStart;
    boolean mFullscreenMode;
    final H mH;
    final IInputContext mIInputContext;
    final Looper mMainLooper;
    View mNextServedView;
    boolean mServedConnecting;
    InputConnection mServedInputConnection;
    ControlledInputConnectionWrapper mServedInputConnectionWrapper;
    View mServedView;
    final IInputMethodManager mService;
    boolean mActive = false;
    boolean mHasBeenInactive = true;
    Rect mTmpCursorRect = new Rect();
    Rect mCursorRect = new Rect();
    private int mNextUserActionNotificationSequenceNumber = -1;
    private int mLastSentUserActionNotificationSequenceNumber = -1;
    private CursorAnchorInfo mCursorAnchorInfo = null;
    private final int[] mViewTopLeft = new int[2];
    private final Matrix mViewToScreenMatrix = new Matrix();
    int mBindSequence = -1;
    private int mRequestUpdateCursorAnchorInfoMonitorMode = 0;
    final Pools.Pool<PendingEvent> mPendingEventPool = new Pools.SimplePool(20);
    final SparseArray<PendingEvent> mPendingEvents = new SparseArray<>(20);
    final IInputMethodClient.Stub mClient = new IInputMethodClient.Stub() { // from class: android.view.inputmethod.InputMethodManager.1
        @Override // android.os.Binder
        protected void dump(FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            CountDownLatch countDownLatch = new CountDownLatch(1);
            SomeArgs obtain = SomeArgs.obtain();
            obtain.arg1 = fileDescriptor;
            obtain.arg2 = printWriter;
            obtain.arg3 = strArr;
            obtain.arg4 = countDownLatch;
            InputMethodManager.this.mH.sendMessage(InputMethodManager.this.mH.obtainMessage(1, obtain));
            try {
                if (countDownLatch.await(5L, TimeUnit.SECONDS)) {
                    return;
                }
                printWriter.println("Timeout waiting for dump");
            } catch (InterruptedException e) {
                printWriter.println("Interrupted waiting for dump");
            }
        }

        @Override // com.android.internal.view.IInputMethodClient
        public void onBindMethod(InputBindResult inputBindResult) {
            InputMethodManager.this.mH.sendMessage(InputMethodManager.this.mH.obtainMessage(2, inputBindResult));
        }

        @Override // com.android.internal.view.IInputMethodClient
        public void onUnbindMethod(int i) {
            InputMethodManager.this.mH.sendMessage(InputMethodManager.this.mH.obtainMessage(3, i, 0));
        }

        @Override // com.android.internal.view.IInputMethodClient
        public void setActive(boolean z) {
            InputMethodManager.this.mH.sendMessage(InputMethodManager.this.mH.obtainMessage(4, z ? 1 : 0, 0));
        }

        @Override // com.android.internal.view.IInputMethodClient
        public void setUserActionNotificationSequenceNumber(int i) {
            InputMethodManager.this.mH.sendMessage(InputMethodManager.this.mH.obtainMessage(9, i, 0));
        }

        @Override // com.android.internal.view.IInputMethodClient
        public void setUsingInputMethod(boolean z) {
        }
    };
    final InputConnection mDummyInputConnection = new BaseInputConnection(this, false);

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-4181928-dex2jar.jar:android/view/inputmethod/InputMethodManager$ControlledInputConnectionWrapper.class */
    public static class ControlledInputConnectionWrapper extends IInputConnectionWrapper {
        private boolean mActive;
        private final InputMethodManager mParentInputMethodManager;

        public ControlledInputConnectionWrapper(Looper looper, InputConnection inputConnection, InputMethodManager inputMethodManager) {
            super(looper, inputConnection);
            this.mParentInputMethodManager = inputMethodManager;
            this.mActive = true;
        }

        void deactivate() {
            this.mActive = false;
        }

        @Override // com.android.internal.view.IInputConnectionWrapper
        public boolean isActive() {
            return this.mParentInputMethodManager.mActive && this.mActive;
        }
    }

    /* loaded from: source-4181928-dex2jar.jar:android/view/inputmethod/InputMethodManager$FinishedInputEventCallback.class */
    public interface FinishedInputEventCallback {
        void onFinishedInputEvent(Object obj, boolean z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-4181928-dex2jar.jar:android/view/inputmethod/InputMethodManager$H.class */
    public class H extends Handler {
        H(Looper looper) {
            super(looper, null, true);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            boolean z;
            boolean z2 = true;
            switch (message.what) {
                case 1:
                    SomeArgs someArgs = (SomeArgs) message.obj;
                    try {
                        InputMethodManager.this.doDump((FileDescriptor) someArgs.arg1, (PrintWriter) someArgs.arg2, (String[]) someArgs.arg3);
                    } catch (RuntimeException e) {
                        ((PrintWriter) someArgs.arg2).println("Exception: " + e);
                    }
                    synchronized (someArgs.arg4) {
                        ((CountDownLatch) someArgs.arg4).countDown();
                    }
                    someArgs.recycle();
                    return;
                case 2:
                    InputBindResult inputBindResult = (InputBindResult) message.obj;
                    synchronized (InputMethodManager.this.mH) {
                        if (InputMethodManager.this.mBindSequence < 0 || InputMethodManager.this.mBindSequence != inputBindResult.sequence) {
                            Log.w(InputMethodManager.TAG, "Ignoring onBind: cur seq=" + InputMethodManager.this.mBindSequence + ", given seq=" + inputBindResult.sequence);
                            if (inputBindResult.channel != null && inputBindResult.channel != InputMethodManager.this.mCurChannel) {
                                inputBindResult.channel.dispose();
                            }
                            return;
                        }
                        InputMethodManager.this.mRequestUpdateCursorAnchorInfoMonitorMode = 0;
                        InputMethodManager.this.setInputChannelLocked(inputBindResult.channel);
                        InputMethodManager.this.mCurMethod = inputBindResult.method;
                        InputMethodManager.this.mCurId = inputBindResult.id;
                        InputMethodManager.this.mBindSequence = inputBindResult.sequence;
                        InputMethodManager.this.startInputInner(null, 0, 0, 0);
                        return;
                    }
                case 3:
                    int i = message.arg1;
                    synchronized (InputMethodManager.this.mH) {
                        z = false;
                        if (InputMethodManager.this.mBindSequence == i) {
                            InputMethodManager.this.clearBindingLocked();
                            if (InputMethodManager.this.mServedView != null && InputMethodManager.this.mServedView.isFocused()) {
                                InputMethodManager.this.mServedConnecting = true;
                            }
                            z = false;
                            if (InputMethodManager.this.mActive) {
                                z = true;
                            }
                        }
                    }
                    if (z) {
                        InputMethodManager.this.startInputInner(null, 0, 0, 0);
                        return;
                    }
                    return;
                case 4:
                    if (message.arg1 == 0) {
                        z2 = false;
                    }
                    synchronized (InputMethodManager.this.mH) {
                        InputMethodManager.this.mActive = z2;
                        InputMethodManager.this.mFullscreenMode = false;
                        if (!z2) {
                            InputMethodManager.this.mHasBeenInactive = true;
                            try {
                                InputMethodManager.this.mIInputContext.finishComposingText();
                            } catch (RemoteException e2) {
                            }
                            if (InputMethodManager.this.mServedView != null && InputMethodManager.this.mServedView.hasWindowFocus() && InputMethodManager.this.checkFocusNoStartInput(InputMethodManager.this.mHasBeenInactive, false)) {
                                InputMethodManager.this.startInputInner(null, 0, 0, 0);
                            }
                        }
                    }
                    return;
                case 5:
                    InputMethodManager.this.sendInputEventAndReportResultOnMainLooper((PendingEvent) message.obj);
                    return;
                case 6:
                    InputMethodManager.this.finishedInputEvent(message.arg1, false, true);
                    return;
                case 7:
                    InputMethodManager.this.finishedInputEvent(message.arg1, false, false);
                    return;
                case 8:
                default:
                    return;
                case 9:
                    synchronized (InputMethodManager.this.mH) {
                        InputMethodManager.this.mNextUserActionNotificationSequenceNumber = message.arg1;
                    }
                    return;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-4181928-dex2jar.jar:android/view/inputmethod/InputMethodManager$ImeInputEventSender.class */
    public final class ImeInputEventSender extends InputEventSender {
        public ImeInputEventSender(InputChannel inputChannel, Looper looper) {
            super(inputChannel, looper);
        }

        @Override // android.view.InputEventSender
        public void onInputEventFinished(int i, boolean z) {
            InputMethodManager.this.finishedInputEvent(i, z, false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-4181928-dex2jar.jar:android/view/inputmethod/InputMethodManager$PendingEvent.class */
    public final class PendingEvent implements Runnable {
        public FinishedInputEventCallback mCallback;
        public InputEvent mEvent;
        public boolean mHandled;
        public Handler mHandler;
        public String mInputMethodId;
        public Object mToken;

        private PendingEvent() {
        }

        public void recycle() {
            this.mEvent = null;
            this.mToken = null;
            this.mInputMethodId = null;
            this.mCallback = null;
            this.mHandler = null;
            this.mHandled = false;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.mCallback.onFinishedInputEvent(this.mToken, this.mHandled);
            synchronized (InputMethodManager.this.mH) {
                InputMethodManager.this.recyclePendingEventLocked(this);
            }
        }
    }

    InputMethodManager(IInputMethodManager iInputMethodManager, Looper looper) {
        this.mService = iInputMethodManager;
        this.mMainLooper = looper;
        this.mH = new H(looper);
        this.mIInputContext = new ControlledInputConnectionWrapper(looper, this.mDummyInputConnection, this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean checkFocusNoStartInput(boolean z, boolean z2) {
        if (this.mServedView != this.mNextServedView || z) {
            synchronized (this.mH) {
                if (this.mServedView != this.mNextServedView || z) {
                    if (this.mNextServedView == null) {
                        finishInputLocked();
                        closeCurrentInput();
                        return false;
                    }
                    InputConnection inputConnection = this.mServedInputConnection;
                    this.mServedView = this.mNextServedView;
                    this.mCurrentTextBoxAttribute = null;
                    this.mCompletions = null;
                    this.mServedConnecting = true;
                    if (!z2 || inputConnection == null) {
                        return true;
                    }
                    inputConnection.finishComposingText();
                    return true;
                }
                return false;
            }
        }
        return false;
    }

    private void flushPendingEventsLocked() {
        this.mH.removeMessages(7);
        int size = this.mPendingEvents.size();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                return;
            }
            Message obtainMessage = this.mH.obtainMessage(7, this.mPendingEvents.keyAt(i2), 0);
            obtainMessage.setAsynchronous(true);
            obtainMessage.sendToTarget();
            i = i2 + 1;
        }
    }

    public static InputMethodManager getInstance() {
        InputMethodManager inputMethodManager;
        synchronized (InputMethodManager.class) {
            try {
                if (sInstance == null) {
                    sInstance = new InputMethodManager(IInputMethodManager.Stub.asInterface(ServiceManager.getService(Context.INPUT_METHOD_SERVICE)), Looper.getMainLooper());
                }
                inputMethodManager = sInstance;
            } catch (Throwable th) {
                throw th;
            }
        }
        return inputMethodManager;
    }

    private void notifyInputConnectionFinished() {
        ViewRootImpl viewRootImpl;
        if (this.mServedView == null || this.mServedInputConnection == null || (viewRootImpl = this.mServedView.getViewRootImpl()) == null) {
            return;
        }
        viewRootImpl.dispatchFinishInputConnection(this.mServedInputConnection);
    }

    private PendingEvent obtainPendingEventLocked(InputEvent inputEvent, Object obj, String str, FinishedInputEventCallback finishedInputEventCallback, Handler handler) {
        PendingEvent acquire = this.mPendingEventPool.acquire();
        PendingEvent pendingEvent = acquire;
        if (acquire == null) {
            pendingEvent = new PendingEvent();
        }
        pendingEvent.mEvent = inputEvent;
        pendingEvent.mToken = obj;
        pendingEvent.mInputMethodId = str;
        pendingEvent.mCallback = finishedInputEventCallback;
        pendingEvent.mHandler = handler;
        return pendingEvent;
    }

    public static InputMethodManager peekInstance() {
        return sInstance;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void recyclePendingEventLocked(PendingEvent pendingEvent) {
        pendingEvent.recycle();
        this.mPendingEventPool.release(pendingEvent);
    }

    static void scheduleCheckFocusLocked(View view) {
        ViewRootImpl viewRootImpl = view.getViewRootImpl();
        if (viewRootImpl != null) {
            viewRootImpl.dispatchCheckFocus();
        }
    }

    private void showInputMethodPickerLocked() {
        try {
            this.mService.showInputMethodPickerFromClient(this.mClient);
        } catch (RemoteException e) {
            Log.w(TAG, "IME died: " + this.mCurId, e);
        }
    }

    public void checkFocus() {
        if (checkFocusNoStartInput(false, true)) {
            startInputInner(null, 0, 0, 0);
        }
    }

    void clearBindingLocked() {
        clearConnectionLocked();
        setInputChannelLocked(null);
        this.mBindSequence = -1;
        this.mCurId = null;
        this.mCurMethod = null;
    }

    void clearConnectionLocked() {
        this.mCurrentTextBoxAttribute = null;
        this.mServedInputConnection = null;
        if (this.mServedInputConnectionWrapper != null) {
            this.mServedInputConnectionWrapper.deactivate();
            this.mServedInputConnectionWrapper = null;
        }
    }

    void closeCurrentInput() {
        try {
            this.mService.hideSoftInput(this.mClient, 2, null);
        } catch (RemoteException e) {
        }
    }

    public int dispatchInputEvent(InputEvent inputEvent, Object obj, FinishedInputEventCallback finishedInputEventCallback, Handler handler) {
        synchronized (this.mH) {
            if (this.mCurMethod != null) {
                if (inputEvent instanceof KeyEvent) {
                    KeyEvent keyEvent = (KeyEvent) inputEvent;
                    if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 63 && keyEvent.getRepeatCount() == 0) {
                        showInputMethodPickerLocked();
                        return 1;
                    }
                }
                PendingEvent obtainPendingEventLocked = obtainPendingEventLocked(inputEvent, obj, this.mCurId, finishedInputEventCallback, handler);
                if (this.mMainLooper.isCurrentThread()) {
                    return sendInputEventOnMainLooperLocked(obtainPendingEventLocked);
                }
                Message obtainMessage = this.mH.obtainMessage(5, obtainPendingEventLocked);
                obtainMessage.setAsynchronous(true);
                this.mH.sendMessage(obtainMessage);
                return -1;
            }
            return 0;
        }
    }

    public void displayCompletions(View view, CompletionInfo[] completionInfoArr) {
        checkFocus();
        synchronized (this.mH) {
            if (this.mServedView == view || (this.mServedView != null && this.mServedView.checkInputConnectionProxy(view))) {
                this.mCompletions = completionInfoArr;
                if (this.mCurMethod != null) {
                    try {
                        this.mCurMethod.displayCompletions(this.mCompletions);
                    } catch (RemoteException e) {
                    }
                }
            }
        }
    }

    void doDump(FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        PrintWriterPrinter printWriterPrinter = new PrintWriterPrinter(printWriter);
        printWriterPrinter.println("Input method client state for " + this + ":");
        printWriterPrinter.println("  mService=" + this.mService);
        printWriterPrinter.println("  mMainLooper=" + this.mMainLooper);
        printWriterPrinter.println("  mIInputContext=" + this.mIInputContext);
        printWriterPrinter.println("  mActive=" + this.mActive + " mHasBeenInactive=" + this.mHasBeenInactive + " mBindSequence=" + this.mBindSequence + " mCurId=" + this.mCurId);
        printWriterPrinter.println("  mCurMethod=" + this.mCurMethod);
        printWriterPrinter.println("  mCurRootView=" + this.mCurRootView);
        printWriterPrinter.println("  mServedView=" + this.mServedView);
        printWriterPrinter.println("  mNextServedView=" + this.mNextServedView);
        printWriterPrinter.println("  mServedConnecting=" + this.mServedConnecting);
        if (this.mCurrentTextBoxAttribute != null) {
            printWriterPrinter.println("  mCurrentTextBoxAttribute:");
            this.mCurrentTextBoxAttribute.dump(printWriterPrinter, "    ");
        } else {
            printWriterPrinter.println("  mCurrentTextBoxAttribute: null");
        }
        printWriterPrinter.println("  mServedInputConnection=" + this.mServedInputConnection);
        printWriterPrinter.println("  mCompletions=" + this.mCompletions);
        printWriterPrinter.println("  mCursorRect=" + this.mCursorRect);
        printWriterPrinter.println("  mCursorSelStart=" + this.mCursorSelStart + " mCursorSelEnd=" + this.mCursorSelEnd + " mCursorCandStart=" + this.mCursorCandStart + " mCursorCandEnd=" + this.mCursorCandEnd);
        printWriterPrinter.println("  mNextUserActionNotificationSequenceNumber=" + this.mNextUserActionNotificationSequenceNumber + " mLastSentUserActionNotificationSequenceNumber=" + this.mLastSentUserActionNotificationSequenceNumber);
    }

    void finishInputLocked() {
        this.mCurRootView = null;
        this.mNextServedView = null;
        if (this.mServedView != null) {
            if (this.mCurrentTextBoxAttribute != null) {
                try {
                    this.mService.finishInput(this.mClient);
                } catch (RemoteException e) {
                }
            }
            notifyInputConnectionFinished();
            this.mServedView = null;
            this.mCompletions = null;
            this.mServedConnecting = false;
            clearConnectionLocked();
        }
    }

    void finishedInputEvent(int i, boolean z, boolean z2) {
        synchronized (this.mH) {
            int indexOfKey = this.mPendingEvents.indexOfKey(i);
            if (indexOfKey < 0) {
                return;
            }
            PendingEvent valueAt = this.mPendingEvents.valueAt(indexOfKey);
            this.mPendingEvents.removeAt(indexOfKey);
            Trace.traceCounter(4L, PENDING_EVENT_COUNTER, this.mPendingEvents.size());
            if (z2) {
                Log.w(TAG, "Timeout waiting for IME to handle input event after 2500 ms: " + valueAt.mInputMethodId);
            } else {
                this.mH.removeMessages(6, valueAt);
            }
            invokeFinishedInputEventCallback(valueAt, z);
        }
    }

    public void focusIn(View view) {
        synchronized (this.mH) {
            focusInLocked(view);
        }
    }

    void focusInLocked(View view) {
        if (this.mCurRootView != view.getRootView()) {
            return;
        }
        this.mNextServedView = view;
        scheduleCheckFocusLocked(view);
    }

    public void focusOut(View view) {
        synchronized (this.mH) {
            if (this.mServedView != view) {
            }
        }
    }

    public IInputMethodClient getClient() {
        return this.mClient;
    }

    public InputMethodSubtype getCurrentInputMethodSubtype() {
        InputMethodSubtype currentInputMethodSubtype;
        synchronized (this.mH) {
            try {
                currentInputMethodSubtype = this.mService.getCurrentInputMethodSubtype();
            } catch (RemoteException e) {
                Log.w(TAG, "IME died: " + this.mCurId, e);
                return null;
            }
        }
        return currentInputMethodSubtype;
    }

    public List<InputMethodInfo> getEnabledInputMethodList() {
        try {
            return this.mService.getEnabledInputMethodList();
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }

    public List<InputMethodSubtype> getEnabledInputMethodSubtypeList(InputMethodInfo inputMethodInfo, boolean z) {
        try {
            return this.mService.getEnabledInputMethodSubtypeList(inputMethodInfo == null ? null : inputMethodInfo.getId(), z);
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }

    public IInputContext getInputContext() {
        return this.mIInputContext;
    }

    public List<InputMethodInfo> getInputMethodList() {
        try {
            return this.mService.getInputMethodList();
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }

    public int getInputMethodWindowVisibleHeight() {
        int inputMethodWindowVisibleHeight;
        synchronized (this.mH) {
            try {
                inputMethodWindowVisibleHeight = this.mService.getInputMethodWindowVisibleHeight();
            } catch (RemoteException e) {
                Log.w(TAG, "IME died: " + this.mCurId, e);
                return 0;
            }
        }
        return inputMethodWindowVisibleHeight;
    }

    public InputMethodSubtype getLastInputMethodSubtype() {
        InputMethodSubtype lastInputMethodSubtype;
        synchronized (this.mH) {
            try {
                lastInputMethodSubtype = this.mService.getLastInputMethodSubtype();
            } catch (RemoteException e) {
                Log.w(TAG, "IME died: " + this.mCurId, e);
                return null;
            }
        }
        return lastInputMethodSubtype;
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x0053, code lost:
        android.util.Log.e(android.view.inputmethod.InputMethodManager.TAG, "IMI list already contains the same InputMethod.");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.util.Map<android.view.inputmethod.InputMethodInfo, java.util.List<android.view.inputmethod.InputMethodSubtype>> getShortcutInputMethodsAndSubtypes() {
        /*
            r4 = this;
            r0 = r4
            android.view.inputmethod.InputMethodManager$H r0 = r0.mH
            r9 = r0
            r0 = r9
            monitor-enter(r0)
            java.util.HashMap r0 = new java.util.HashMap     // Catch: java.lang.Throwable -> Lbf
            r1 = r0
            r1.<init>()     // Catch: java.lang.Throwable -> Lbf
            r10 = r0
            r0 = r4
            com.android.internal.view.IInputMethodManager r0 = r0.mService     // Catch: android.os.RemoteException -> L9d java.lang.Throwable -> Lbf
            java.util.List r0 = r0.getShortcutInputMethodsAndSubtypes()     // Catch: android.os.RemoteException -> L9d java.lang.Throwable -> Lbf
            r11 = r0
            r0 = 0
            r7 = r0
            r0 = r11
            int r0 = r0.size()     // Catch: android.os.RemoteException -> L9d java.lang.Throwable -> Lbf
            r6 = r0
            r0 = r11
            if (r0 == 0) goto L5c
            r0 = r6
            if (r0 <= 0) goto L5c
            r0 = 0
            r5 = r0
        L32:
            r0 = r5
            r1 = r6
            if (r0 >= r1) goto L5c
            r0 = r11
            r1 = r5
            java.lang.Object r0 = r0.get(r1)     // Catch: android.os.RemoteException -> L9d java.lang.Throwable -> Lbf
            r12 = r0
            r0 = r12
            boolean r0 = r0 instanceof android.view.inputmethod.InputMethodInfo     // Catch: android.os.RemoteException -> L9d java.lang.Throwable -> Lbf
            if (r0 == 0) goto L7b
            r0 = r10
            r1 = r12
            boolean r0 = r0.containsKey(r1)     // Catch: android.os.RemoteException -> L9d java.lang.Throwable -> Lbf
            if (r0 == 0) goto L62
            java.lang.String r0 = "InputMethodManager"
            java.lang.String r1 = "IMI list already contains the same InputMethod."
            int r0 = android.util.Log.e(r0, r1)     // Catch: android.os.RemoteException -> L9d java.lang.Throwable -> Lbf
        L5c:
            r0 = r9
            monitor-exit(r0)     // Catch: java.lang.Throwable -> Lbf
            r0 = r10
            return r0
        L62:
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch: android.os.RemoteException -> L9d java.lang.Throwable -> Lbf
            r1 = r0
            r1.<init>()     // Catch: android.os.RemoteException -> L9d java.lang.Throwable -> Lbf
            r8 = r0
            r0 = r10
            r1 = r12
            android.view.inputmethod.InputMethodInfo r1 = (android.view.inputmethod.InputMethodInfo) r1     // Catch: android.os.RemoteException -> L9d java.lang.Throwable -> Lbf
            r2 = r8
            java.lang.Object r0 = r0.put(r1, r2)     // Catch: android.os.RemoteException -> L9d java.lang.Throwable -> Lbf
            goto Lc5
        L7b:
            r0 = r7
            r8 = r0
            r0 = r7
            if (r0 == 0) goto Lc5
            r0 = r7
            r8 = r0
            r0 = r12
            boolean r0 = r0 instanceof android.view.inputmethod.InputMethodSubtype     // Catch: android.os.RemoteException -> L9d java.lang.Throwable -> Lbf
            if (r0 == 0) goto Lc5
            r0 = r7
            r1 = r12
            android.view.inputmethod.InputMethodSubtype r1 = (android.view.inputmethod.InputMethodSubtype) r1     // Catch: android.os.RemoteException -> L9d java.lang.Throwable -> Lbf
            boolean r0 = r0.add(r1)     // Catch: android.os.RemoteException -> L9d java.lang.Throwable -> Lbf
            r0 = r7
            r8 = r0
            goto Lc5
        L9d:
            r7 = move-exception
            java.lang.String r0 = "InputMethodManager"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lbf
            r2 = r1
            r2.<init>()     // Catch: java.lang.Throwable -> Lbf
            java.lang.String r2 = "IME died: "
            java.lang.StringBuilder r1 = r1.append(r2)     // Catch: java.lang.Throwable -> Lbf
            r2 = r4
            java.lang.String r2 = r2.mCurId     // Catch: java.lang.Throwable -> Lbf
            java.lang.StringBuilder r1 = r1.append(r2)     // Catch: java.lang.Throwable -> Lbf
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> Lbf
            r2 = r7
            int r0 = android.util.Log.w(r0, r1, r2)     // Catch: java.lang.Throwable -> Lbf
            goto L5c
        Lbf:
            r7 = move-exception
            r0 = r9
            monitor-exit(r0)     // Catch: java.lang.Throwable -> Lbf
            r0 = r7
            throw r0
        Lc5:
            r0 = r5
            r1 = 1
            int r0 = r0 + r1
            r5 = r0
            r0 = r8
            r7 = r0
            goto L32
        */
        throw new UnsupportedOperationException("Method not decompiled: android.view.inputmethod.InputMethodManager.getShortcutInputMethodsAndSubtypes():java.util.Map");
    }

    public void hideSoftInputFromInputMethod(IBinder iBinder, int i) {
        try {
            this.mService.hideMySoftInput(iBinder, i);
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean hideSoftInputFromWindow(IBinder iBinder, int i) {
        return hideSoftInputFromWindow(iBinder, i, null);
    }

    public boolean hideSoftInputFromWindow(IBinder iBinder, int i, ResultReceiver resultReceiver) {
        checkFocus();
        synchronized (this.mH) {
            if (this.mServedView == null || this.mServedView.getWindowToken() != iBinder) {
                return false;
            }
            try {
                return this.mService.hideSoftInput(this.mClient, i, resultReceiver);
            } catch (RemoteException e) {
                return false;
            }
        }
    }

    public void hideStatusIcon(IBinder iBinder) {
        try {
            this.mService.updateStatusIcon(iBinder, null, 0);
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }

    void invokeFinishedInputEventCallback(PendingEvent pendingEvent, boolean z) {
        pendingEvent.mHandled = z;
        if (pendingEvent.mHandler.getLooper().isCurrentThread()) {
            pendingEvent.run();
            return;
        }
        Message obtain = Message.obtain(pendingEvent.mHandler, pendingEvent);
        obtain.setAsynchronous(true);
        obtain.sendToTarget();
    }

    public boolean isAcceptingText() {
        checkFocus();
        return this.mServedInputConnection != null;
    }

    public boolean isActive() {
        boolean z;
        checkFocus();
        synchronized (this.mH) {
            z = (this.mServedView == null || this.mCurrentTextBoxAttribute == null) ? false : true;
        }
        return z;
    }

    public boolean isActive(View view) {
        boolean z;
        checkFocus();
        synchronized (this.mH) {
            z = (this.mServedView == view || (this.mServedView != null && this.mServedView.checkInputConnectionProxy(view))) && this.mCurrentTextBoxAttribute != null;
        }
        return z;
    }

    public boolean isCursorAnchorInfoEnabled() {
        boolean z = false;
        synchronized (this.mH) {
            boolean z2 = (this.mRequestUpdateCursorAnchorInfoMonitorMode & 1) != 0;
            boolean z3 = (this.mRequestUpdateCursorAnchorInfoMonitorMode & 2) != 0;
            if (z2 || z3) {
                z = true;
            }
        }
        return z;
    }

    public boolean isFullscreenMode() {
        return this.mFullscreenMode;
    }

    @Deprecated
    public boolean isWatchingCursor(View view) {
        return false;
    }

    public void notifySuggestionPicked(SuggestionSpan suggestionSpan, String str, int i) {
        try {
            this.mService.notifySuggestionPicked(suggestionSpan, str, i);
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }

    public void notifyUserAction() {
        synchronized (this.mH) {
            if (this.mLastSentUserActionNotificationSequenceNumber == this.mNextUserActionNotificationSequenceNumber) {
                return;
            }
            try {
                this.mService.notifyUserAction(this.mNextUserActionNotificationSequenceNumber);
                this.mLastSentUserActionNotificationSequenceNumber = this.mNextUserActionNotificationSequenceNumber;
            } catch (RemoteException e) {
                Log.w(TAG, "IME died: " + this.mCurId, e);
            }
        }
    }

    public void onWindowFocus(View view, View view2, int i, boolean z, int i2) {
        boolean z2 = false;
        synchronized (this.mH) {
            if (this.mHasBeenInactive) {
                this.mHasBeenInactive = false;
                z2 = true;
            }
            focusInLocked(view2 != null ? view2 : view);
        }
        int i3 = 0;
        if (view2 != null) {
            int i4 = 0 | 1;
            i3 = i4;
            if (view2.onCheckIsTextEditor()) {
                i3 = i4 | 2;
            }
        }
        int i5 = i3;
        if (z) {
            i5 = i3 | 4;
        }
        if (checkFocusNoStartInput(z2, true) && startInputInner(view.getWindowToken(), i5, i, i2)) {
            return;
        }
        synchronized (this.mH) {
            try {
                this.mService.windowGainedFocus(this.mClient, view.getWindowToken(), i5, i, i2, null, null);
            } catch (RemoteException e) {
            }
        }
    }

    public void registerSuggestionSpansForNotification(SuggestionSpan[] suggestionSpanArr) {
        try {
            this.mService.registerSuggestionSpansForNotification(suggestionSpanArr);
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }

    public void reportFinishInputConnection(InputConnection inputConnection) {
        if (this.mServedInputConnection != inputConnection) {
            inputConnection.finishComposingText();
            if (inputConnection instanceof BaseInputConnection) {
                ((BaseInputConnection) inputConnection).reportFinish();
            }
        }
    }

    public void restartInput(View view) {
        checkFocus();
        synchronized (this.mH) {
            if (this.mServedView == view || (this.mServedView != null && this.mServedView.checkInputConnectionProxy(view))) {
                this.mServedConnecting = true;
                startInputInner(null, 0, 0, 0);
            }
        }
    }

    public void sendAppPrivateCommand(View view, String str, Bundle bundle) {
        checkFocus();
        synchronized (this.mH) {
            if ((this.mServedView != view && (this.mServedView == null || !this.mServedView.checkInputConnectionProxy(view))) || this.mCurrentTextBoxAttribute == null || this.mCurMethod == null) {
                return;
            }
            try {
                this.mCurMethod.appPrivateCommand(str, bundle);
            } catch (RemoteException e) {
                Log.w(TAG, "IME died: " + this.mCurId, e);
            }
        }
    }

    void sendInputEventAndReportResultOnMainLooper(PendingEvent pendingEvent) {
        boolean z = true;
        synchronized (this.mH) {
            int sendInputEventOnMainLooperLocked = sendInputEventOnMainLooperLocked(pendingEvent);
            if (sendInputEventOnMainLooperLocked == -1) {
                return;
            }
            if (sendInputEventOnMainLooperLocked != 1) {
                z = false;
            }
            invokeFinishedInputEventCallback(pendingEvent, z);
        }
    }

    int sendInputEventOnMainLooperLocked(PendingEvent pendingEvent) {
        if (this.mCurChannel != null) {
            if (this.mCurSender == null) {
                this.mCurSender = new ImeInputEventSender(this.mCurChannel, this.mH.getLooper());
            }
            InputEvent inputEvent = pendingEvent.mEvent;
            int sequenceNumber = inputEvent.getSequenceNumber();
            if (!this.mCurSender.sendInputEvent(sequenceNumber, inputEvent)) {
                Log.w(TAG, "Unable to send input event to IME: " + this.mCurId + " dropping: " + inputEvent);
                return 0;
            }
            this.mPendingEvents.put(sequenceNumber, pendingEvent);
            Trace.traceCounter(4L, PENDING_EVENT_COUNTER, this.mPendingEvents.size());
            Message obtainMessage = this.mH.obtainMessage(6, pendingEvent);
            obtainMessage.setAsynchronous(true);
            this.mH.sendMessageDelayed(obtainMessage, INPUT_METHOD_NOT_RESPONDING_TIMEOUT);
            return -1;
        }
        return 0;
    }

    public void setAdditionalInputMethodSubtypes(String str, InputMethodSubtype[] inputMethodSubtypeArr) {
        synchronized (this.mH) {
            try {
                this.mService.setAdditionalInputMethodSubtypes(str, inputMethodSubtypeArr);
            } catch (RemoteException e) {
                Log.w(TAG, "IME died: " + this.mCurId, e);
            }
        }
    }

    public boolean setCurrentInputMethodSubtype(InputMethodSubtype inputMethodSubtype) {
        boolean currentInputMethodSubtype;
        synchronized (this.mH) {
            try {
                currentInputMethodSubtype = this.mService.setCurrentInputMethodSubtype(inputMethodSubtype);
            } catch (RemoteException e) {
                Log.w(TAG, "IME died: " + this.mCurId, e);
                return false;
            }
        }
        return currentInputMethodSubtype;
    }

    public void setFullscreenMode(boolean z) {
        this.mFullscreenMode = z;
    }

    public void setImeWindowStatus(IBinder iBinder, int i, int i2) {
        try {
            this.mService.setImeWindowStatus(iBinder, i, i2);
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }

    void setInputChannelLocked(InputChannel inputChannel) {
        if (this.mCurChannel != inputChannel) {
            if (this.mCurSender != null) {
                flushPendingEventsLocked();
                this.mCurSender.dispose();
                this.mCurSender = null;
            }
            if (this.mCurChannel != null) {
                this.mCurChannel.dispose();
            }
            this.mCurChannel = inputChannel;
        }
    }

    public void setInputMethod(IBinder iBinder, String str) {
        try {
            this.mService.setInputMethod(iBinder, str);
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }

    public void setInputMethodAndSubtype(IBinder iBinder, String str, InputMethodSubtype inputMethodSubtype) {
        try {
            this.mService.setInputMethodAndSubtype(iBinder, str, inputMethodSubtype);
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }

    public void setUpdateCursorAnchorInfoMode(int i) {
        synchronized (this.mH) {
            this.mRequestUpdateCursorAnchorInfoMonitorMode = i;
        }
    }

    public boolean shouldOfferSwitchingToNextInputMethod(IBinder iBinder) {
        boolean shouldOfferSwitchingToNextInputMethod;
        synchronized (this.mH) {
            try {
                shouldOfferSwitchingToNextInputMethod = this.mService.shouldOfferSwitchingToNextInputMethod(iBinder);
            } catch (RemoteException e) {
                Log.w(TAG, "IME died: " + this.mCurId, e);
                return false;
            }
        }
        return shouldOfferSwitchingToNextInputMethod;
    }

    public void showInputMethodAndSubtypeEnabler(String str) {
        synchronized (this.mH) {
            try {
                this.mService.showInputMethodAndSubtypeEnablerFromClient(this.mClient, str);
            } catch (RemoteException e) {
                Log.w(TAG, "IME died: " + this.mCurId, e);
            }
        }
    }

    public void showInputMethodPicker() {
        synchronized (this.mH) {
            showInputMethodPickerLocked();
        }
    }

    public boolean showSoftInput(View view, int i) {
        return showSoftInput(view, i, null);
    }

    public boolean showSoftInput(View view, int i, ResultReceiver resultReceiver) {
        checkFocus();
        synchronized (this.mH) {
            if (this.mServedView == view || (this.mServedView != null && this.mServedView.checkInputConnectionProxy(view))) {
                try {
                    return this.mService.showSoftInput(this.mClient, i, resultReceiver);
                } catch (RemoteException e) {
                    return false;
                }
            }
            return false;
        }
    }

    public void showSoftInputFromInputMethod(IBinder iBinder, int i) {
        try {
            this.mService.showMySoftInput(iBinder, i);
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }

    public void showSoftInputUnchecked(int i, ResultReceiver resultReceiver) {
        try {
            this.mService.showSoftInput(this.mClient, i, resultReceiver);
        } catch (RemoteException e) {
        }
    }

    public void showStatusIcon(IBinder iBinder, String str, int i) {
        try {
            this.mService.updateStatusIcon(iBinder, str, i);
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }

    public void startGettingWindowFocus(View view) {
        synchronized (this.mH) {
            this.mCurRootView = view;
        }
    }

    boolean startInputInner(IBinder iBinder, int i, int i2, int i3) {
        ControlledInputConnectionWrapper controlledInputConnectionWrapper;
        synchronized (this.mH) {
            View view = this.mServedView;
            if (view == null) {
                return false;
            }
            Handler handler = view.getHandler();
            if (handler == null) {
                closeCurrentInput();
                return false;
            } else if (handler.getLooper() != Looper.myLooper()) {
                handler.post(new Runnable() { // from class: android.view.inputmethod.InputMethodManager.2
                    @Override // java.lang.Runnable
                    public void run() {
                        InputMethodManager.this.startInputInner(null, 0, 0, 0);
                    }
                });
                return false;
            } else {
                EditorInfo editorInfo = new EditorInfo();
                editorInfo.packageName = view.getContext().getPackageName();
                editorInfo.fieldId = view.getId();
                InputConnection onCreateInputConnection = view.onCreateInputConnection(editorInfo);
                synchronized (this.mH) {
                    if (this.mServedView == view && this.mServedConnecting) {
                        int i4 = i;
                        if (this.mCurrentTextBoxAttribute == null) {
                            i4 = i | 256;
                        }
                        this.mCurrentTextBoxAttribute = editorInfo;
                        this.mServedConnecting = false;
                        notifyInputConnectionFinished();
                        this.mServedInputConnection = onCreateInputConnection;
                        if (onCreateInputConnection != null) {
                            this.mCursorSelStart = editorInfo.initialSelStart;
                            this.mCursorSelEnd = editorInfo.initialSelEnd;
                            this.mCursorCandStart = -1;
                            this.mCursorCandEnd = -1;
                            this.mCursorRect.setEmpty();
                            this.mCursorAnchorInfo = null;
                            controlledInputConnectionWrapper = new ControlledInputConnectionWrapper(handler.getLooper(), onCreateInputConnection, this);
                        } else {
                            controlledInputConnectionWrapper = null;
                        }
                        if (this.mServedInputConnectionWrapper != null) {
                            this.mServedInputConnectionWrapper.deactivate();
                        }
                        this.mServedInputConnectionWrapper = controlledInputConnectionWrapper;
                        try {
                            InputBindResult windowGainedFocus = iBinder != null ? this.mService.windowGainedFocus(this.mClient, iBinder, i4, i2, i3, editorInfo, controlledInputConnectionWrapper) : this.mService.startInput(this.mClient, controlledInputConnectionWrapper, editorInfo, i4);
                            if (windowGainedFocus != null) {
                                if (windowGainedFocus.id != null) {
                                    setInputChannelLocked(windowGainedFocus.channel);
                                    this.mBindSequence = windowGainedFocus.sequence;
                                    this.mCurMethod = windowGainedFocus.method;
                                    this.mCurId = windowGainedFocus.id;
                                    this.mNextUserActionNotificationSequenceNumber = windowGainedFocus.userActionNotificationSequenceNumber;
                                } else {
                                    if (windowGainedFocus.channel != null && windowGainedFocus.channel != this.mCurChannel) {
                                        windowGainedFocus.channel.dispose();
                                    }
                                    if (this.mCurMethod == null) {
                                        return true;
                                    }
                                }
                            }
                            if (this.mCurMethod != null) {
                                if (this.mCompletions != null) {
                                    try {
                                        this.mCurMethod.displayCompletions(this.mCompletions);
                                    } catch (RemoteException e) {
                                    }
                                }
                            }
                        } catch (RemoteException e2) {
                            Log.w(TAG, "IME died: " + this.mCurId, e2);
                        }
                        return true;
                    }
                    return false;
                }
            }
        }
    }

    public boolean switchToLastInputMethod(IBinder iBinder) {
        boolean switchToLastInputMethod;
        synchronized (this.mH) {
            try {
                switchToLastInputMethod = this.mService.switchToLastInputMethod(iBinder);
            } catch (RemoteException e) {
                Log.w(TAG, "IME died: " + this.mCurId, e);
                return false;
            }
        }
        return switchToLastInputMethod;
    }

    public boolean switchToNextInputMethod(IBinder iBinder, boolean z) {
        boolean switchToNextInputMethod;
        synchronized (this.mH) {
            try {
                switchToNextInputMethod = this.mService.switchToNextInputMethod(iBinder, z);
            } catch (RemoteException e) {
                Log.w(TAG, "IME died: " + this.mCurId, e);
                return false;
            }
        }
        return switchToNextInputMethod;
    }

    public void toggleSoftInput(int i, int i2) {
        if (this.mCurMethod != null) {
            try {
                this.mCurMethod.toggleSoftInput(i, i2);
            } catch (RemoteException e) {
            }
        }
    }

    public void toggleSoftInputFromWindow(IBinder iBinder, int i, int i2) {
        synchronized (this.mH) {
            if (this.mServedView == null || this.mServedView.getWindowToken() != iBinder) {
                return;
            }
            if (this.mCurMethod != null) {
                try {
                    this.mCurMethod.toggleSoftInput(i, i2);
                } catch (RemoteException e) {
                }
            }
        }
    }

    @Deprecated
    public void updateCursor(View view, int i, int i2, int i3, int i4) {
        checkFocus();
        synchronized (this.mH) {
            if ((this.mServedView != view && (this.mServedView == null || !this.mServedView.checkInputConnectionProxy(view))) || this.mCurrentTextBoxAttribute == null || this.mCurMethod == null) {
                return;
            }
            this.mTmpCursorRect.set(i, i2, i3, i4);
            if (!this.mCursorRect.equals(this.mTmpCursorRect)) {
                try {
                    this.mCurMethod.updateCursor(this.mTmpCursorRect);
                    this.mCursorRect.set(this.mTmpCursorRect);
                } catch (RemoteException e) {
                    Log.w(TAG, "IME died: " + this.mCurId, e);
                }
            }
        }
    }

    public void updateCursorAnchorInfo(View view, CursorAnchorInfo cursorAnchorInfo) {
        if (view == null || cursorAnchorInfo == null) {
            return;
        }
        checkFocus();
        synchronized (this.mH) {
            if ((this.mServedView != view && (this.mServedView == null || !this.mServedView.checkInputConnectionProxy(view))) || this.mCurrentTextBoxAttribute == null || this.mCurMethod == null) {
                return;
            }
            if (((this.mRequestUpdateCursorAnchorInfoMonitorMode & 1) != 0) || !Objects.equals(this.mCursorAnchorInfo, cursorAnchorInfo)) {
                try {
                    this.mCurMethod.updateCursorAnchorInfo(cursorAnchorInfo);
                    this.mCursorAnchorInfo = cursorAnchorInfo;
                    this.mRequestUpdateCursorAnchorInfoMonitorMode &= -2;
                } catch (RemoteException e) {
                    Log.w(TAG, "IME died: " + this.mCurId, e);
                }
            }
        }
    }

    public void updateExtractedText(View view, int i, ExtractedText extractedText) {
        checkFocus();
        synchronized (this.mH) {
            if (this.mServedView == view || (this.mServedView != null && this.mServedView.checkInputConnectionProxy(view))) {
                if (this.mCurMethod != null) {
                    try {
                        this.mCurMethod.updateExtractedText(i, extractedText);
                    } catch (RemoteException e) {
                    }
                }
            }
        }
    }

    public void updateSelection(View view, int i, int i2, int i3, int i4) {
        checkFocus();
        synchronized (this.mH) {
            if ((this.mServedView != view && (this.mServedView == null || !this.mServedView.checkInputConnectionProxy(view))) || this.mCurrentTextBoxAttribute == null || this.mCurMethod == null) {
                return;
            }
            if (this.mCursorSelStart != i || this.mCursorSelEnd != i2 || this.mCursorCandStart != i3 || this.mCursorCandEnd != i4) {
                try {
                    int i5 = this.mCursorSelStart;
                    int i6 = this.mCursorSelEnd;
                    this.mCursorSelStart = i;
                    this.mCursorSelEnd = i2;
                    this.mCursorCandStart = i3;
                    this.mCursorCandEnd = i4;
                    this.mCurMethod.updateSelection(i5, i6, i, i2, i3, i4);
                } catch (RemoteException e) {
                    Log.w(TAG, "IME died: " + this.mCurId, e);
                }
            }
        }
    }

    public void viewClicked(View view) {
        boolean z = this.mServedView != this.mNextServedView;
        checkFocus();
        synchronized (this.mH) {
            if ((this.mServedView != view && (this.mServedView == null || !this.mServedView.checkInputConnectionProxy(view))) || this.mCurrentTextBoxAttribute == null || this.mCurMethod == null) {
                return;
            }
            try {
                this.mCurMethod.viewClicked(z);
            } catch (RemoteException e) {
                Log.w(TAG, "IME died: " + this.mCurId, e);
            }
        }
    }

    public void windowDismissed(IBinder iBinder) {
        checkFocus();
        synchronized (this.mH) {
            if (this.mServedView != null && this.mServedView.getWindowToken() == iBinder) {
                finishInputLocked();
            }
        }
    }
}
