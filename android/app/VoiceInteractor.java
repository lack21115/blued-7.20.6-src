package android.app;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.ArrayMap;
import android.util.Log;
import com.android.internal.app.IVoiceInteractor;
import com.android.internal.app.IVoiceInteractorCallback;
import com.android.internal.app.IVoiceInteractorRequest;
import com.android.internal.os.HandlerCaller;
import com.android.internal.os.SomeArgs;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import java.util.ArrayList;

/* loaded from: source-9557208-dex2jar.jar:android/app/VoiceInteractor.class */
public class VoiceInteractor {
    static final boolean DEBUG = true;
    static final int MSG_ABORT_VOICE_RESULT = 3;
    static final int MSG_CANCEL_RESULT = 5;
    static final int MSG_COMMAND_RESULT = 4;
    static final int MSG_COMPLETE_VOICE_RESULT = 2;
    static final int MSG_CONFIRMATION_RESULT = 1;
    static final String TAG = "VoiceInteractor";
    Activity mActivity;
    Context mContext;
    final HandlerCaller mHandlerCaller;
    final IVoiceInteractor mInteractor;
    final HandlerCaller.Callback mHandlerCallerCallback = new HandlerCaller.Callback() { // from class: android.app.VoiceInteractor.1
        @Override // com.android.internal.os.HandlerCaller.Callback
        public void executeMessage(Message message) {
            boolean z = false;
            SomeArgs someArgs = (SomeArgs) message.obj;
            switch (message.what) {
                case 1:
                    Request pullRequest = VoiceInteractor.this.pullRequest((IVoiceInteractorRequest) someArgs.arg1, true);
                    Log.d(VoiceInteractor.TAG, "onConfirmResult: req=" + ((IVoiceInteractorRequest) someArgs.arg1).asBinder() + BridgeUtil.SPLIT_MARK + pullRequest + " confirmed=" + message.arg1 + " result=" + someArgs.arg2);
                    if (pullRequest != null) {
                        ConfirmationRequest confirmationRequest = (ConfirmationRequest) pullRequest;
                        if (message.arg1 != 0) {
                            z = true;
                        }
                        confirmationRequest.onConfirmationResult(z, (Bundle) someArgs.arg2);
                        pullRequest.clear();
                        return;
                    }
                    return;
                case 2:
                    Request pullRequest2 = VoiceInteractor.this.pullRequest((IVoiceInteractorRequest) someArgs.arg1, true);
                    Log.d(VoiceInteractor.TAG, "onCompleteVoice: req=" + ((IVoiceInteractorRequest) someArgs.arg1).asBinder() + BridgeUtil.SPLIT_MARK + pullRequest2 + " result=" + someArgs.arg1);
                    if (pullRequest2 != null) {
                        ((CompleteVoiceRequest) pullRequest2).onCompleteResult((Bundle) someArgs.arg2);
                        pullRequest2.clear();
                        return;
                    }
                    return;
                case 3:
                    Request pullRequest3 = VoiceInteractor.this.pullRequest((IVoiceInteractorRequest) someArgs.arg1, true);
                    Log.d(VoiceInteractor.TAG, "onAbortVoice: req=" + ((IVoiceInteractorRequest) someArgs.arg1).asBinder() + BridgeUtil.SPLIT_MARK + pullRequest3 + " result=" + someArgs.arg1);
                    if (pullRequest3 != null) {
                        ((AbortVoiceRequest) pullRequest3).onAbortResult((Bundle) someArgs.arg2);
                        pullRequest3.clear();
                        return;
                    }
                    return;
                case 4:
                    Request pullRequest4 = VoiceInteractor.this.pullRequest((IVoiceInteractorRequest) someArgs.arg1, message.arg1 != 0);
                    Log.d(VoiceInteractor.TAG, "onCommandResult: req=" + ((IVoiceInteractorRequest) someArgs.arg1).asBinder() + BridgeUtil.SPLIT_MARK + pullRequest4 + " result=" + someArgs.arg2);
                    if (pullRequest4 != null) {
                        ((CommandRequest) pullRequest4).onCommandResult((Bundle) someArgs.arg2);
                        if (message.arg1 != 0) {
                            pullRequest4.clear();
                            return;
                        }
                        return;
                    }
                    return;
                case 5:
                    Request pullRequest5 = VoiceInteractor.this.pullRequest((IVoiceInteractorRequest) someArgs.arg1, true);
                    Log.d(VoiceInteractor.TAG, "onCancelResult: req=" + ((IVoiceInteractorRequest) someArgs.arg1).asBinder() + BridgeUtil.SPLIT_MARK + pullRequest5);
                    if (pullRequest5 != null) {
                        pullRequest5.onCancel();
                        pullRequest5.clear();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    };
    final IVoiceInteractorCallback.Stub mCallback = new IVoiceInteractorCallback.Stub() { // from class: android.app.VoiceInteractor.2
        @Override // com.android.internal.app.IVoiceInteractorCallback
        public void deliverAbortVoiceResult(IVoiceInteractorRequest iVoiceInteractorRequest, Bundle bundle) {
            VoiceInteractor.this.mHandlerCaller.sendMessage(VoiceInteractor.this.mHandlerCaller.obtainMessageOO(3, iVoiceInteractorRequest, bundle));
        }

        @Override // com.android.internal.app.IVoiceInteractorCallback
        public void deliverCancel(IVoiceInteractorRequest iVoiceInteractorRequest) throws RemoteException {
            VoiceInteractor.this.mHandlerCaller.sendMessage(VoiceInteractor.this.mHandlerCaller.obtainMessageO(5, iVoiceInteractorRequest));
        }

        @Override // com.android.internal.app.IVoiceInteractorCallback
        public void deliverCommandResult(IVoiceInteractorRequest iVoiceInteractorRequest, boolean z, Bundle bundle) {
            VoiceInteractor.this.mHandlerCaller.sendMessage(VoiceInteractor.this.mHandlerCaller.obtainMessageIOO(4, z ? 1 : 0, iVoiceInteractorRequest, bundle));
        }

        @Override // com.android.internal.app.IVoiceInteractorCallback
        public void deliverCompleteVoiceResult(IVoiceInteractorRequest iVoiceInteractorRequest, Bundle bundle) {
            VoiceInteractor.this.mHandlerCaller.sendMessage(VoiceInteractor.this.mHandlerCaller.obtainMessageOO(2, iVoiceInteractorRequest, bundle));
        }

        @Override // com.android.internal.app.IVoiceInteractorCallback
        public void deliverConfirmationResult(IVoiceInteractorRequest iVoiceInteractorRequest, boolean z, Bundle bundle) {
            VoiceInteractor.this.mHandlerCaller.sendMessage(VoiceInteractor.this.mHandlerCaller.obtainMessageIOO(1, z ? 1 : 0, iVoiceInteractorRequest, bundle));
        }
    };
    final ArrayMap<IBinder, Request> mActiveRequests = new ArrayMap<>();

    /* loaded from: source-9557208-dex2jar.jar:android/app/VoiceInteractor$AbortVoiceRequest.class */
    public static class AbortVoiceRequest extends Request {
        final Bundle mExtras;
        final CharSequence mMessage;

        public AbortVoiceRequest(CharSequence charSequence, Bundle bundle) {
            this.mMessage = charSequence;
            this.mExtras = bundle;
        }

        public void onAbortResult(Bundle bundle) {
        }

        @Override // android.app.VoiceInteractor.Request
        IVoiceInteractorRequest submit(IVoiceInteractor iVoiceInteractor, String str, IVoiceInteractorCallback iVoiceInteractorCallback) throws RemoteException {
            return iVoiceInteractor.startAbortVoice(str, iVoiceInteractorCallback, this.mMessage, this.mExtras);
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/app/VoiceInteractor$CommandRequest.class */
    public static class CommandRequest extends Request {
        final Bundle mArgs;
        final String mCommand;

        public CommandRequest(String str, Bundle bundle) {
            this.mCommand = str;
            this.mArgs = bundle;
        }

        public void onCommandResult(Bundle bundle) {
        }

        @Override // android.app.VoiceInteractor.Request
        IVoiceInteractorRequest submit(IVoiceInteractor iVoiceInteractor, String str, IVoiceInteractorCallback iVoiceInteractorCallback) throws RemoteException {
            return iVoiceInteractor.startCommand(str, iVoiceInteractorCallback, this.mCommand, this.mArgs);
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/app/VoiceInteractor$CompleteVoiceRequest.class */
    public static class CompleteVoiceRequest extends Request {
        final Bundle mExtras;
        final CharSequence mMessage;

        public CompleteVoiceRequest(CharSequence charSequence, Bundle bundle) {
            this.mMessage = charSequence;
            this.mExtras = bundle;
        }

        public void onCompleteResult(Bundle bundle) {
        }

        @Override // android.app.VoiceInteractor.Request
        IVoiceInteractorRequest submit(IVoiceInteractor iVoiceInteractor, String str, IVoiceInteractorCallback iVoiceInteractorCallback) throws RemoteException {
            return iVoiceInteractor.startCompleteVoice(str, iVoiceInteractorCallback, this.mMessage, this.mExtras);
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/app/VoiceInteractor$ConfirmationRequest.class */
    public static class ConfirmationRequest extends Request {
        final Bundle mExtras;
        final CharSequence mPrompt;

        public ConfirmationRequest(CharSequence charSequence, Bundle bundle) {
            this.mPrompt = charSequence;
            this.mExtras = bundle;
        }

        public void onConfirmationResult(boolean z, Bundle bundle) {
        }

        @Override // android.app.VoiceInteractor.Request
        IVoiceInteractorRequest submit(IVoiceInteractor iVoiceInteractor, String str, IVoiceInteractorCallback iVoiceInteractorCallback) throws RemoteException {
            return iVoiceInteractor.startConfirmation(str, iVoiceInteractorCallback, this.mPrompt, this.mExtras);
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/app/VoiceInteractor$Request.class */
    public static abstract class Request {
        Activity mActivity;
        Context mContext;
        IVoiceInteractorRequest mRequestInterface;

        public void cancel() {
            try {
                this.mRequestInterface.cancel();
            } catch (RemoteException e) {
                Log.w(VoiceInteractor.TAG, "Voice interactor has died", e);
            }
        }

        void clear() {
            this.mRequestInterface = null;
            this.mContext = null;
            this.mActivity = null;
        }

        public Activity getActivity() {
            return this.mActivity;
        }

        public Context getContext() {
            return this.mContext;
        }

        public void onAttached(Activity activity) {
        }

        public void onCancel() {
        }

        public void onDetached() {
        }

        abstract IVoiceInteractorRequest submit(IVoiceInteractor iVoiceInteractor, String str, IVoiceInteractorCallback iVoiceInteractorCallback) throws RemoteException;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public VoiceInteractor(IVoiceInteractor iVoiceInteractor, Context context, Activity activity, Looper looper) {
        this.mInteractor = iVoiceInteractor;
        this.mContext = context;
        this.mActivity = activity;
        this.mHandlerCaller = new HandlerCaller(context, looper, this.mHandlerCallerCallback, true);
    }

    private ArrayList<Request> makeRequestList() {
        ArrayList<Request> arrayList;
        int size = this.mActiveRequests.size();
        if (size >= 1) {
            ArrayList<Request> arrayList2 = new ArrayList<>(size);
            int i = 0;
            while (true) {
                int i2 = i;
                arrayList = arrayList2;
                if (i2 >= size) {
                    break;
                }
                arrayList2.add(this.mActiveRequests.valueAt(i2));
                i = i2 + 1;
            }
        } else {
            arrayList = null;
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void attachActivity(Activity activity) {
        if (this.mActivity == activity) {
            return;
        }
        this.mContext = activity;
        this.mActivity = activity;
        ArrayList<Request> makeRequestList = makeRequestList();
        if (makeRequestList == null) {
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= makeRequestList.size()) {
                return;
            }
            Request request = makeRequestList.get(i2);
            request.mContext = activity;
            request.mActivity = activity;
            request.onAttached(activity);
            i = i2 + 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void detachActivity() {
        ArrayList<Request> makeRequestList = makeRequestList();
        if (makeRequestList != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= makeRequestList.size()) {
                    break;
                }
                Request request = makeRequestList.get(i2);
                request.onDetached();
                request.mActivity = null;
                request.mContext = null;
                i = i2 + 1;
            }
        }
        this.mContext = null;
        this.mActivity = null;
    }

    Request pullRequest(IVoiceInteractorRequest iVoiceInteractorRequest, boolean z) {
        Request request;
        synchronized (this.mActiveRequests) {
            request = this.mActiveRequests.get(iVoiceInteractorRequest.asBinder());
            if (request != null && z) {
                this.mActiveRequests.remove(iVoiceInteractorRequest.asBinder());
            }
        }
        return request;
    }

    public boolean submitRequest(Request request) {
        try {
            IVoiceInteractorRequest submit = request.submit(this.mInteractor, this.mContext.getOpPackageName(), this.mCallback);
            request.mRequestInterface = submit;
            request.mContext = this.mContext;
            request.mActivity = this.mActivity;
            synchronized (this.mActiveRequests) {
                this.mActiveRequests.put(submit.asBinder(), request);
            }
            return true;
        } catch (RemoteException e) {
            Log.w(TAG, "Remove voice interactor service died", e);
            return false;
        }
    }

    public boolean[] supportsCommands(String[] strArr) {
        try {
            boolean[] supportsCommands = this.mInteractor.supportsCommands(this.mContext.getOpPackageName(), strArr);
            Log.d(TAG, "supportsCommands: cmds=" + strArr + " res=" + supportsCommands);
            return supportsCommands;
        } catch (RemoteException e) {
            throw new RuntimeException("Voice interactor has died", e);
        }
    }
}
