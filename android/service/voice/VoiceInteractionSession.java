package android.service.voice;

import android.R;
import android.app.Dialog;
import android.app.Instrumentation;
import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.Region;
import android.inputmethodservice.SoftInputWindow;
import android.os.Binder;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.RemoteException;
import android.service.voice.IVoiceInteractionSession;
import android.util.ArrayMap;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import com.android.internal.app.IVoiceInteractionManagerService;
import com.android.internal.app.IVoiceInteractor;
import com.android.internal.app.IVoiceInteractorCallback;
import com.android.internal.app.IVoiceInteractorRequest;
import com.android.internal.os.HandlerCaller;
import com.android.internal.os.SomeArgs;
import java.lang.ref.WeakReference;

/* loaded from: source-9557208-dex2jar.jar:android/service/voice/VoiceInteractionSession.class */
public abstract class VoiceInteractionSession implements KeyEvent.Callback {
    static final boolean DEBUG = true;
    static final int MSG_CANCEL = 6;
    static final int MSG_CLOSE_SYSTEM_DIALOGS = 102;
    static final int MSG_DESTROY = 103;
    static final int MSG_START_ABORT_VOICE = 3;
    static final int MSG_START_COMMAND = 4;
    static final int MSG_START_COMPLETE_VOICE = 2;
    static final int MSG_START_CONFIRMATION = 1;
    static final int MSG_SUPPORTS_COMMANDS = 5;
    static final int MSG_TASK_FINISHED = 101;
    static final int MSG_TASK_STARTED = 100;
    static final String TAG = "VoiceInteractionSession";
    final ArrayMap<IBinder, Request> mActiveRequests;
    final MyCallbacks mCallbacks;
    FrameLayout mContentFrame;
    final Context mContext;
    final KeyEvent.DispatcherState mDispatcherState;
    final HandlerCaller mHandlerCaller;
    boolean mInShowWindow;
    LayoutInflater mInflater;
    boolean mInitialized;
    final ViewTreeObserver.OnComputeInternalInsetsListener mInsetsComputer;
    final IVoiceInteractor mInteractor;
    View mRootView;
    final IVoiceInteractionSession mSession;
    IVoiceInteractionManagerService mSystemService;
    int mTheme;
    TypedArray mThemeAttrs;
    final Insets mTmpInsets;
    final int[] mTmpLocation;
    IBinder mToken;
    final WeakReference<VoiceInteractionSession> mWeakRef;
    SoftInputWindow mWindow;
    boolean mWindowAdded;
    boolean mWindowVisible;
    boolean mWindowWasVisible;

    /* loaded from: source-9557208-dex2jar.jar:android/service/voice/VoiceInteractionSession$Caller.class */
    public static class Caller {
        final String packageName;
        final int uid;

        Caller(String str, int i) {
            this.packageName = str;
            this.uid = i;
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/service/voice/VoiceInteractionSession$Insets.class */
    public static final class Insets {
        public static final int TOUCHABLE_INSETS_CONTENT = 1;
        public static final int TOUCHABLE_INSETS_FRAME = 0;
        public static final int TOUCHABLE_INSETS_REGION = 3;
        public int touchableInsets;
        public final Rect contentInsets = new Rect();
        public final Region touchableRegion = new Region();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-9557208-dex2jar.jar:android/service/voice/VoiceInteractionSession$MyCallbacks.class */
    public class MyCallbacks implements HandlerCaller.Callback, SoftInputWindow.Callback {
        MyCallbacks() {
        }

        @Override // com.android.internal.os.HandlerCaller.Callback
        public void executeMessage(Message message) {
            switch (message.what) {
                case 1:
                    SomeArgs someArgs = (SomeArgs) message.obj;
                    Log.d(VoiceInteractionSession.TAG, "onConfirm: req=" + ((Request) someArgs.arg2).mInterface + " prompt=" + someArgs.arg3 + " extras=" + someArgs.arg4);
                    VoiceInteractionSession.this.onConfirm((Caller) someArgs.arg1, (Request) someArgs.arg2, (CharSequence) someArgs.arg3, (Bundle) someArgs.arg4);
                    return;
                case 2:
                    SomeArgs someArgs2 = (SomeArgs) message.obj;
                    Log.d(VoiceInteractionSession.TAG, "onCompleteVoice: req=" + ((Request) someArgs2.arg2).mInterface + " message=" + someArgs2.arg3 + " extras=" + someArgs2.arg4);
                    VoiceInteractionSession.this.onCompleteVoice((Caller) someArgs2.arg1, (Request) someArgs2.arg2, (CharSequence) someArgs2.arg3, (Bundle) someArgs2.arg4);
                    return;
                case 3:
                    SomeArgs someArgs3 = (SomeArgs) message.obj;
                    Log.d(VoiceInteractionSession.TAG, "onAbortVoice: req=" + ((Request) someArgs3.arg2).mInterface + " message=" + someArgs3.arg3 + " extras=" + someArgs3.arg4);
                    VoiceInteractionSession.this.onAbortVoice((Caller) someArgs3.arg1, (Request) someArgs3.arg2, (CharSequence) someArgs3.arg3, (Bundle) someArgs3.arg4);
                    return;
                case 4:
                    SomeArgs someArgs4 = (SomeArgs) message.obj;
                    Log.d(VoiceInteractionSession.TAG, "onCommand: req=" + ((Request) someArgs4.arg2).mInterface + " command=" + someArgs4.arg3 + " extras=" + someArgs4.arg4);
                    VoiceInteractionSession.this.onCommand((Caller) someArgs4.arg1, (Request) someArgs4.arg2, (String) someArgs4.arg3, (Bundle) someArgs4.arg4);
                    return;
                case 5:
                    SomeArgs someArgs5 = (SomeArgs) message.obj;
                    Log.d(VoiceInteractionSession.TAG, "onGetSupportedCommands: cmds=" + someArgs5.arg2);
                    someArgs5.arg1 = VoiceInteractionSession.this.onGetSupportedCommands((Caller) someArgs5.arg1, (String[]) someArgs5.arg2);
                    return;
                case 6:
                    SomeArgs someArgs6 = (SomeArgs) message.obj;
                    Log.d(VoiceInteractionSession.TAG, "onCancel: req=" + ((Request) someArgs6.arg1).mInterface);
                    VoiceInteractionSession.this.onCancel((Request) someArgs6.arg1);
                    return;
                case 100:
                    Log.d(VoiceInteractionSession.TAG, "onTaskStarted: intent=" + message.obj + " taskId=" + message.arg1);
                    VoiceInteractionSession.this.onTaskStarted((Intent) message.obj, message.arg1);
                    return;
                case 101:
                    Log.d(VoiceInteractionSession.TAG, "onTaskFinished: intent=" + message.obj + " taskId=" + message.arg1);
                    VoiceInteractionSession.this.onTaskFinished((Intent) message.obj, message.arg1);
                    return;
                case 102:
                    Log.d(VoiceInteractionSession.TAG, "onCloseSystemDialogs");
                    VoiceInteractionSession.this.onCloseSystemDialogs();
                    return;
                case 103:
                    Log.d(VoiceInteractionSession.TAG, "doDestroy");
                    VoiceInteractionSession.this.doDestroy();
                    return;
                default:
                    return;
            }
        }

        @Override // android.inputmethodservice.SoftInputWindow.Callback
        public void onBackPressed() {
            VoiceInteractionSession.this.onBackPressed();
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/service/voice/VoiceInteractionSession$Request.class */
    public static class Request {
        final IVoiceInteractorCallback mCallback;
        final IVoiceInteractorRequest mInterface = new IVoiceInteractorRequest.Stub() { // from class: android.service.voice.VoiceInteractionSession.Request.1
            @Override // com.android.internal.app.IVoiceInteractorRequest
            public void cancel() throws RemoteException {
                VoiceInteractionSession voiceInteractionSession = Request.this.mSession.get();
                if (voiceInteractionSession != null) {
                    voiceInteractionSession.mHandlerCaller.sendMessage(voiceInteractionSession.mHandlerCaller.obtainMessageO(6, Request.this));
                }
            }
        };
        final WeakReference<VoiceInteractionSession> mSession;

        Request(IVoiceInteractorCallback iVoiceInteractorCallback, VoiceInteractionSession voiceInteractionSession) {
            this.mCallback = iVoiceInteractorCallback;
            this.mSession = voiceInteractionSession.mWeakRef;
        }

        void finishRequest() {
            VoiceInteractionSession voiceInteractionSession = this.mSession.get();
            if (voiceInteractionSession == null) {
                throw new IllegalStateException("VoiceInteractionSession has been destroyed");
            }
            Request removeRequest = voiceInteractionSession.removeRequest(this.mInterface.asBinder());
            if (removeRequest == null) {
                throw new IllegalStateException("Request not active: " + this);
            }
            if (removeRequest != this) {
                throw new IllegalStateException("Current active request " + removeRequest + " not same as calling request " + this);
            }
        }

        public void sendAbortVoiceResult(Bundle bundle) {
            try {
                Log.d(VoiceInteractionSession.TAG, "sendConfirmResult: req=" + this.mInterface + " result=" + bundle);
                finishRequest();
                this.mCallback.deliverAbortVoiceResult(this.mInterface, bundle);
            } catch (RemoteException e) {
            }
        }

        public void sendCancelResult() {
            try {
                Log.d(VoiceInteractionSession.TAG, "sendCancelResult: req=" + this.mInterface);
                finishRequest();
                this.mCallback.deliverCancel(this.mInterface);
            } catch (RemoteException e) {
            }
        }

        public void sendCommandResult(boolean z, Bundle bundle) {
            try {
                Log.d(VoiceInteractionSession.TAG, "sendCommandResult: req=" + this.mInterface + " result=" + bundle);
                finishRequest();
                this.mCallback.deliverCommandResult(this.mInterface, z, bundle);
            } catch (RemoteException e) {
            }
        }

        public void sendCompleteVoiceResult(Bundle bundle) {
            try {
                Log.d(VoiceInteractionSession.TAG, "sendCompleteVoiceResult: req=" + this.mInterface + " result=" + bundle);
                finishRequest();
                this.mCallback.deliverCompleteVoiceResult(this.mInterface, bundle);
            } catch (RemoteException e) {
            }
        }

        public void sendConfirmResult(boolean z, Bundle bundle) {
            try {
                Log.d(VoiceInteractionSession.TAG, "sendConfirmResult: req=" + this.mInterface + " confirmed=" + z + " result=" + bundle);
                finishRequest();
                this.mCallback.deliverConfirmationResult(this.mInterface, z, bundle);
            } catch (RemoteException e) {
            }
        }
    }

    public VoiceInteractionSession(Context context) {
        this(context, new Handler());
    }

    public VoiceInteractionSession(Context context, Handler handler) {
        this.mDispatcherState = new KeyEvent.DispatcherState();
        this.mTheme = 0;
        this.mActiveRequests = new ArrayMap<>();
        this.mTmpInsets = new Insets();
        this.mTmpLocation = new int[2];
        this.mWeakRef = new WeakReference<>(this);
        this.mInteractor = new IVoiceInteractor.Stub() { // from class: android.service.voice.VoiceInteractionSession.1
            @Override // com.android.internal.app.IVoiceInteractor
            public IVoiceInteractorRequest startAbortVoice(String str, IVoiceInteractorCallback iVoiceInteractorCallback, CharSequence charSequence, Bundle bundle) {
                Request newRequest = VoiceInteractionSession.this.newRequest(iVoiceInteractorCallback);
                VoiceInteractionSession.this.mHandlerCaller.sendMessage(VoiceInteractionSession.this.mHandlerCaller.obtainMessageOOOO(3, new Caller(str, Binder.getCallingUid()), newRequest, charSequence, bundle));
                return newRequest.mInterface;
            }

            @Override // com.android.internal.app.IVoiceInteractor
            public IVoiceInteractorRequest startCommand(String str, IVoiceInteractorCallback iVoiceInteractorCallback, String str2, Bundle bundle) {
                Request newRequest = VoiceInteractionSession.this.newRequest(iVoiceInteractorCallback);
                VoiceInteractionSession.this.mHandlerCaller.sendMessage(VoiceInteractionSession.this.mHandlerCaller.obtainMessageOOOO(4, new Caller(str, Binder.getCallingUid()), newRequest, str2, bundle));
                return newRequest.mInterface;
            }

            @Override // com.android.internal.app.IVoiceInteractor
            public IVoiceInteractorRequest startCompleteVoice(String str, IVoiceInteractorCallback iVoiceInteractorCallback, CharSequence charSequence, Bundle bundle) {
                Request newRequest = VoiceInteractionSession.this.newRequest(iVoiceInteractorCallback);
                VoiceInteractionSession.this.mHandlerCaller.sendMessage(VoiceInteractionSession.this.mHandlerCaller.obtainMessageOOOO(2, new Caller(str, Binder.getCallingUid()), newRequest, charSequence, bundle));
                return newRequest.mInterface;
            }

            @Override // com.android.internal.app.IVoiceInteractor
            public IVoiceInteractorRequest startConfirmation(String str, IVoiceInteractorCallback iVoiceInteractorCallback, CharSequence charSequence, Bundle bundle) {
                Request newRequest = VoiceInteractionSession.this.newRequest(iVoiceInteractorCallback);
                VoiceInteractionSession.this.mHandlerCaller.sendMessage(VoiceInteractionSession.this.mHandlerCaller.obtainMessageOOOO(1, new Caller(str, Binder.getCallingUid()), newRequest, charSequence, bundle));
                return newRequest.mInterface;
            }

            @Override // com.android.internal.app.IVoiceInteractor
            public boolean[] supportsCommands(String str, String[] strArr) {
                SomeArgs sendMessageAndWait = VoiceInteractionSession.this.mHandlerCaller.sendMessageAndWait(VoiceInteractionSession.this.mHandlerCaller.obtainMessageIOO(5, 0, new Caller(str, Binder.getCallingUid()), strArr));
                if (sendMessageAndWait != null) {
                    boolean[] zArr = (boolean[]) sendMessageAndWait.arg1;
                    sendMessageAndWait.recycle();
                    return zArr;
                }
                return new boolean[strArr.length];
            }
        };
        this.mSession = new IVoiceInteractionSession.Stub() { // from class: android.service.voice.VoiceInteractionSession.2
            @Override // android.service.voice.IVoiceInteractionSession
            public void closeSystemDialogs() {
                VoiceInteractionSession.this.mHandlerCaller.sendMessage(VoiceInteractionSession.this.mHandlerCaller.obtainMessage(102));
            }

            @Override // android.service.voice.IVoiceInteractionSession
            public void destroy() {
                VoiceInteractionSession.this.mHandlerCaller.sendMessage(VoiceInteractionSession.this.mHandlerCaller.obtainMessage(103));
            }

            @Override // android.service.voice.IVoiceInteractionSession
            public void taskFinished(Intent intent, int i) {
                VoiceInteractionSession.this.mHandlerCaller.sendMessage(VoiceInteractionSession.this.mHandlerCaller.obtainMessageIO(101, i, intent));
            }

            @Override // android.service.voice.IVoiceInteractionSession
            public void taskStarted(Intent intent, int i) {
                VoiceInteractionSession.this.mHandlerCaller.sendMessage(VoiceInteractionSession.this.mHandlerCaller.obtainMessageIO(100, i, intent));
            }
        };
        this.mCallbacks = new MyCallbacks();
        this.mInsetsComputer = new ViewTreeObserver.OnComputeInternalInsetsListener() { // from class: android.service.voice.VoiceInteractionSession.3
            @Override // android.view.ViewTreeObserver.OnComputeInternalInsetsListener
            public void onComputeInternalInsets(ViewTreeObserver.InternalInsetsInfo internalInsetsInfo) {
                VoiceInteractionSession.this.onComputeInsets(VoiceInteractionSession.this.mTmpInsets);
                internalInsetsInfo.contentInsets.set(VoiceInteractionSession.this.mTmpInsets.contentInsets);
                internalInsetsInfo.visibleInsets.set(VoiceInteractionSession.this.mTmpInsets.contentInsets);
                internalInsetsInfo.touchableRegion.set(VoiceInteractionSession.this.mTmpInsets.touchableRegion);
                internalInsetsInfo.setTouchableInsets(VoiceInteractionSession.this.mTmpInsets.touchableInsets);
            }
        };
        this.mContext = context;
        this.mHandlerCaller = new HandlerCaller(context, handler.getLooper(), this.mCallbacks, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void doCreate(IVoiceInteractionManagerService iVoiceInteractionManagerService, IBinder iBinder, Bundle bundle) {
        this.mSystemService = iVoiceInteractionManagerService;
        this.mToken = iBinder;
        onCreate(bundle);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void doDestroy() {
        onDestroy();
        if (this.mInitialized) {
            this.mRootView.getViewTreeObserver().removeOnComputeInternalInsetsListener(this.mInsetsComputer);
            if (this.mWindowAdded) {
                this.mWindow.dismiss();
                this.mWindowAdded = false;
            }
            this.mInitialized = false;
        }
    }

    public void finish() {
        if (this.mToken == null) {
            throw new IllegalStateException("Can't call before onCreate()");
        }
        hideWindow();
        try {
            this.mSystemService.finish(this.mToken);
        } catch (RemoteException e) {
        }
    }

    public LayoutInflater getLayoutInflater() {
        return this.mInflater;
    }

    public Dialog getWindow() {
        return this.mWindow;
    }

    public void hideWindow() {
        if (this.mWindowVisible) {
            this.mWindow.hide();
            this.mWindowVisible = false;
        }
    }

    void initViews() {
        this.mInitialized = true;
        this.mThemeAttrs = this.mContext.obtainStyledAttributes(R.styleable.VoiceInteractionSession);
        this.mRootView = this.mInflater.inflate(com.android.internal.R.layout.voice_interaction_session, (ViewGroup) null);
        this.mRootView.setSystemUiVisibility(768);
        this.mWindow.setContentView(this.mRootView);
        this.mRootView.getViewTreeObserver().addOnComputeInternalInsetsListener(this.mInsetsComputer);
        this.mContentFrame = (FrameLayout) this.mRootView.findViewById(16908290);
    }

    Request newRequest(IVoiceInteractorCallback iVoiceInteractorCallback) {
        Request request;
        synchronized (this) {
            request = new Request(iVoiceInteractorCallback, this);
            this.mActiveRequests.put(request.mInterface.asBinder(), request);
        }
        return request;
    }

    public void onAbortVoice(Caller caller, Request request, CharSequence charSequence, Bundle bundle) {
        request.sendAbortVoiceResult(null);
    }

    public void onBackPressed() {
        finish();
    }

    public abstract void onCancel(Request request);

    public void onCloseSystemDialogs() {
        finish();
    }

    public abstract void onCommand(Caller caller, Request request, String str, Bundle bundle);

    public void onCompleteVoice(Caller caller, Request request, CharSequence charSequence, Bundle bundle) {
        request.sendCompleteVoiceResult(null);
    }

    public void onComputeInsets(Insets insets) {
        getWindow().getWindow().getDecorView().getLocationInWindow(this.mTmpLocation);
        insets.contentInsets.top = 0;
        insets.contentInsets.left = 0;
        insets.contentInsets.right = 0;
        insets.contentInsets.bottom = 0;
        insets.touchableInsets = 0;
        insets.touchableRegion.setEmpty();
    }

    public abstract void onConfirm(Caller caller, Request request, CharSequence charSequence, Bundle bundle);

    public void onCreate(Bundle bundle) {
        this.mTheme = this.mTheme != 0 ? this.mTheme : 16974989;
        this.mInflater = (LayoutInflater) this.mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.mWindow = new SoftInputWindow(this.mContext, TAG, this.mTheme, this.mCallbacks, this, this.mDispatcherState, 2031, 48, true);
        this.mWindow.getWindow().addFlags(16777216);
        initViews();
        this.mWindow.getWindow().setLayout(-1, -2);
        this.mWindow.setToken(this.mToken);
    }

    public View onCreateContentView() {
        return null;
    }

    public void onDestroy() {
    }

    public boolean[] onGetSupportedCommands(Caller caller, String[] strArr) {
        return new boolean[strArr.length];
    }

    @Override // android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return false;
    }

    @Override // android.view.KeyEvent.Callback
    public boolean onKeyLongPress(int i, KeyEvent keyEvent) {
        return false;
    }

    @Override // android.view.KeyEvent.Callback
    public boolean onKeyMultiple(int i, int i2, KeyEvent keyEvent) {
        return false;
    }

    @Override // android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        return false;
    }

    public void onTaskFinished(Intent intent, int i) {
        finish();
    }

    public void onTaskStarted(Intent intent, int i) {
    }

    Request removeRequest(IBinder iBinder) {
        Request request;
        synchronized (this) {
            request = this.mActiveRequests.get(iBinder);
            if (request != null) {
                this.mActiveRequests.remove(request);
            }
        }
        return request;
    }

    public void setContentView(View view) {
        this.mContentFrame.removeAllViews();
        this.mContentFrame.addView(view, new FrameLayout.LayoutParams(-1, -2));
    }

    public void setTheme(int i) {
        if (this.mWindow != null) {
            throw new IllegalStateException("Must be called before onCreate()");
        }
        this.mTheme = i;
    }

    public void showWindow() {
        Log.v(TAG, "Showing window: mWindowAdded=" + this.mWindowAdded + " mWindowVisible=" + this.mWindowVisible);
        if (this.mInShowWindow) {
            Log.w(TAG, "Re-entrance in to showWindow");
            return;
        }
        try {
            this.mInShowWindow = true;
            if (!this.mWindowVisible) {
                this.mWindowVisible = true;
                if (!this.mWindowAdded) {
                    this.mWindowAdded = true;
                    View onCreateContentView = onCreateContentView();
                    if (onCreateContentView != null) {
                        setContentView(onCreateContentView);
                    }
                }
                this.mWindow.show();
            }
        } finally {
            this.mWindowWasVisible = true;
            this.mInShowWindow = false;
        }
    }

    public void startVoiceActivity(Intent intent) {
        if (this.mToken == null) {
            throw new IllegalStateException("Can't call before onCreate()");
        }
        try {
            intent.migrateExtraStreamToClipData();
            intent.prepareToLeaveProcess();
            Instrumentation.checkStartActivityResult(this.mSystemService.startVoiceActivity(this.mToken, intent, intent.resolveType(this.mContext.getContentResolver())), intent);
        } catch (RemoteException e) {
        }
    }
}
