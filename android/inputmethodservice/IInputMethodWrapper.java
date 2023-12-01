package android.inputmethodservice;

import android.Manifest;
import android.content.Context;
import android.os.Binder;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.util.Log;
import android.view.InputChannel;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputBinding;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethod;
import android.view.inputmethod.InputMethodSession;
import android.view.inputmethod.InputMethodSubtype;
import com.android.internal.os.HandlerCaller;
import com.android.internal.os.SomeArgs;
import com.android.internal.view.IInputContext;
import com.android.internal.view.IInputMethod;
import com.android.internal.view.IInputMethodSession;
import com.android.internal.view.IInputSessionCallback;
import com.android.internal.view.InputConnectionWrapper;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.ref.WeakReference;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* loaded from: source-9557208-dex2jar.jar:android/inputmethodservice/IInputMethodWrapper.class */
class IInputMethodWrapper extends IInputMethod.Stub implements HandlerCaller.Callback {
    private static final int DO_ATTACH_TOKEN = 10;
    private static final int DO_CHANGE_INPUTMETHOD_SUBTYPE = 80;
    private static final int DO_CREATE_SESSION = 40;
    private static final int DO_DUMP = 1;
    private static final int DO_HIDE_SOFT_INPUT = 70;
    private static final int DO_RESTART_INPUT = 34;
    private static final int DO_REVOKE_SESSION = 50;
    private static final int DO_SET_INPUT_CONTEXT = 20;
    private static final int DO_SET_SESSION_ENABLED = 45;
    private static final int DO_SHOW_SOFT_INPUT = 60;
    private static final int DO_START_INPUT = 32;
    private static final int DO_UNSET_INPUT_CONTEXT = 30;
    private static final String TAG = "InputMethodWrapper";
    final HandlerCaller mCaller;
    final Context mContext;
    final WeakReference<InputMethod> mInputMethod;
    final WeakReference<AbstractInputMethodService> mTarget;
    final int mTargetSdkVersion;

    /* loaded from: source-9557208-dex2jar.jar:android/inputmethodservice/IInputMethodWrapper$InputMethodSessionCallbackWrapper.class */
    static final class InputMethodSessionCallbackWrapper implements InputMethod.SessionCallback {
        final IInputSessionCallback mCb;
        final InputChannel mChannel;
        final Context mContext;

        InputMethodSessionCallbackWrapper(Context context, InputChannel inputChannel, IInputSessionCallback iInputSessionCallback) {
            this.mContext = context;
            this.mChannel = inputChannel;
            this.mCb = iInputSessionCallback;
        }

        @Override // android.view.inputmethod.InputMethod.SessionCallback
        public void sessionCreated(InputMethodSession inputMethodSession) {
            try {
                if (inputMethodSession != null) {
                    this.mCb.sessionCreated(new IInputMethodSessionWrapper(this.mContext, inputMethodSession, this.mChannel));
                    return;
                }
                if (this.mChannel != null) {
                    this.mChannel.dispose();
                }
                this.mCb.sessionCreated((IInputMethodSession) null);
            } catch (RemoteException e) {
            }
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/inputmethodservice/IInputMethodWrapper$Notifier.class */
    static class Notifier {
        boolean notified;

        Notifier() {
        }
    }

    public IInputMethodWrapper(AbstractInputMethodService abstractInputMethodService, InputMethod inputMethod) {
        this.mTarget = new WeakReference<>(abstractInputMethodService);
        this.mContext = abstractInputMethodService.getApplicationContext();
        this.mCaller = new HandlerCaller(this.mContext, (Looper) null, this, true);
        this.mInputMethod = new WeakReference<>(inputMethod);
        this.mTargetSdkVersion = abstractInputMethodService.getApplicationInfo().targetSdkVersion;
    }

    public void attachToken(IBinder iBinder) {
        this.mCaller.executeOrSendMessage(this.mCaller.obtainMessageO(10, iBinder));
    }

    public void bindInput(InputBinding inputBinding) {
        this.mCaller.executeOrSendMessage(this.mCaller.obtainMessageO(20, new InputBinding(new InputConnectionWrapper(IInputContext.Stub.asInterface(inputBinding.getConnectionToken())), inputBinding)));
    }

    public void changeInputMethodSubtype(InputMethodSubtype inputMethodSubtype) {
        this.mCaller.executeOrSendMessage(this.mCaller.obtainMessageO(80, inputMethodSubtype));
    }

    public void createSession(InputChannel inputChannel, IInputSessionCallback iInputSessionCallback) {
        this.mCaller.executeOrSendMessage(this.mCaller.obtainMessageOO(40, inputChannel, iInputSessionCallback));
    }

    protected void dump(FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        AbstractInputMethodService abstractInputMethodService = this.mTarget.get();
        if (abstractInputMethodService == null) {
            return;
        }
        if (abstractInputMethodService.checkCallingOrSelfPermission(Manifest.permission.DUMP) != 0) {
            printWriter.println("Permission Denial: can't dump InputMethodManager from from pid=" + Binder.getCallingPid() + ", uid=" + Binder.getCallingUid());
            return;
        }
        CountDownLatch countDownLatch = new CountDownLatch(1);
        this.mCaller.executeOrSendMessage(this.mCaller.obtainMessageOOOO(1, fileDescriptor, printWriter, strArr, countDownLatch));
        try {
            if (countDownLatch.await(5L, TimeUnit.SECONDS)) {
                return;
            }
            printWriter.println("Timeout waiting for dump");
        } catch (InterruptedException e) {
            printWriter.println("Interrupted waiting for dump");
        }
    }

    public void executeMessage(Message message) {
        boolean z = true;
        InputMethod inputMethod = this.mInputMethod.get();
        if (inputMethod == null && message.what != 1) {
            Log.w(TAG, "Input method reference was null, ignoring message: " + message.what);
            return;
        }
        switch (message.what) {
            case 1:
                AbstractInputMethodService abstractInputMethodService = this.mTarget.get();
                if (abstractInputMethodService != null) {
                    SomeArgs someArgs = (SomeArgs) message.obj;
                    try {
                        abstractInputMethodService.dump((FileDescriptor) someArgs.arg1, (PrintWriter) someArgs.arg2, (String[]) someArgs.arg3);
                    } catch (RuntimeException e) {
                        ((PrintWriter) someArgs.arg2).println("Exception: " + e);
                    }
                    synchronized (someArgs.arg4) {
                        ((CountDownLatch) someArgs.arg4).countDown();
                    }
                    someArgs.recycle();
                    return;
                }
                return;
            case 10:
                inputMethod.attachToken((IBinder) message.obj);
                return;
            case 20:
                inputMethod.bindInput((InputBinding) message.obj);
                return;
            case 30:
                inputMethod.unbindInput();
                return;
            case 32:
                SomeArgs someArgs2 = (SomeArgs) message.obj;
                IInputContext iInputContext = (IInputContext) someArgs2.arg1;
                InputConnection inputConnection = null;
                if (iInputContext != null) {
                    inputConnection = new InputConnectionWrapper(iInputContext);
                }
                EditorInfo editorInfo = (EditorInfo) someArgs2.arg2;
                editorInfo.makeCompatible(this.mTargetSdkVersion);
                inputMethod.startInput(inputConnection, editorInfo);
                someArgs2.recycle();
                return;
            case 34:
                SomeArgs someArgs3 = (SomeArgs) message.obj;
                IInputContext iInputContext2 = (IInputContext) someArgs3.arg1;
                InputConnection inputConnection2 = null;
                if (iInputContext2 != null) {
                    inputConnection2 = new InputConnectionWrapper(iInputContext2);
                }
                EditorInfo editorInfo2 = (EditorInfo) someArgs3.arg2;
                editorInfo2.makeCompatible(this.mTargetSdkVersion);
                inputMethod.restartInput(inputConnection2, editorInfo2);
                someArgs3.recycle();
                return;
            case 40:
                SomeArgs someArgs4 = (SomeArgs) message.obj;
                inputMethod.createSession(new InputMethodSessionCallbackWrapper(this.mContext, (InputChannel) someArgs4.arg1, (IInputSessionCallback) someArgs4.arg2));
                someArgs4.recycle();
                return;
            case 45:
                InputMethodSession inputMethodSession = (InputMethodSession) message.obj;
                if (message.arg1 == 0) {
                    z = false;
                }
                inputMethod.setSessionEnabled(inputMethodSession, z);
                return;
            case 50:
                inputMethod.revokeSession((InputMethodSession) message.obj);
                return;
            case 60:
                inputMethod.showSoftInput(message.arg1, (ResultReceiver) message.obj);
                return;
            case 70:
                inputMethod.hideSoftInput(message.arg1, (ResultReceiver) message.obj);
                return;
            case 80:
                inputMethod.changeInputMethodSubtype((InputMethodSubtype) message.obj);
                return;
            default:
                Log.w(TAG, "Unhandled message code: " + message.what);
                return;
        }
    }

    public InputMethod getInternalInputMethod() {
        return this.mInputMethod.get();
    }

    public void hideSoftInput(int i, ResultReceiver resultReceiver) {
        this.mCaller.executeOrSendMessage(this.mCaller.obtainMessageIO(70, i, resultReceiver));
    }

    public void restartInput(IInputContext iInputContext, EditorInfo editorInfo) {
        this.mCaller.executeOrSendMessage(this.mCaller.obtainMessageOO(34, iInputContext, editorInfo));
    }

    public void revokeSession(IInputMethodSession iInputMethodSession) {
        try {
            InputMethodSession internalInputMethodSession = ((IInputMethodSessionWrapper) iInputMethodSession).getInternalInputMethodSession();
            if (internalInputMethodSession == null) {
                Log.w(TAG, "Session is already finished: " + iInputMethodSession);
            } else {
                this.mCaller.executeOrSendMessage(this.mCaller.obtainMessageO(50, internalInputMethodSession));
            }
        } catch (ClassCastException e) {
            Log.w(TAG, "Incoming session not of correct type: " + iInputMethodSession, e);
        }
    }

    public void setSessionEnabled(IInputMethodSession iInputMethodSession, boolean z) {
        try {
            InputMethodSession internalInputMethodSession = ((IInputMethodSessionWrapper) iInputMethodSession).getInternalInputMethodSession();
            if (internalInputMethodSession == null) {
                Log.w(TAG, "Session is already finished: " + iInputMethodSession);
            } else {
                this.mCaller.executeOrSendMessage(this.mCaller.obtainMessageIO(45, z ? 1 : 0, internalInputMethodSession));
            }
        } catch (ClassCastException e) {
            Log.w(TAG, "Incoming session not of correct type: " + iInputMethodSession, e);
        }
    }

    public void showSoftInput(int i, ResultReceiver resultReceiver) {
        this.mCaller.executeOrSendMessage(this.mCaller.obtainMessageIO(60, i, resultReceiver));
    }

    public void startInput(IInputContext iInputContext, EditorInfo editorInfo) {
        this.mCaller.executeOrSendMessage(this.mCaller.obtainMessageOO(32, iInputContext, editorInfo));
    }

    public void unbindInput() {
        this.mCaller.executeOrSendMessage(this.mCaller.obtainMessage(30));
    }
}
