package android.speech;

import android.Manifest;
import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.RemoteException;
import android.speech.IRecognitionService;
import android.util.Log;
import java.lang.ref.WeakReference;

/* loaded from: source-9557208-dex2jar.jar:android/speech/RecognitionService.class */
public abstract class RecognitionService extends Service {
    private static final boolean DBG = false;
    private static final int MSG_CANCEL = 3;
    private static final int MSG_RESET = 4;
    private static final int MSG_START_LISTENING = 1;
    private static final int MSG_STOP_LISTENING = 2;
    public static final String SERVICE_INTERFACE = "android.speech.RecognitionService";
    public static final String SERVICE_META_DATA = "android.speech";
    private static final String TAG = "RecognitionService";
    private RecognitionServiceBinder mBinder = new RecognitionServiceBinder(this);
    private Callback mCurrentCallback = null;
    private final Handler mHandler = new Handler() { // from class: android.speech.RecognitionService.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    StartListeningArgs startListeningArgs = (StartListeningArgs) message.obj;
                    RecognitionService.this.dispatchStartListening(startListeningArgs.mIntent, startListeningArgs.mListener);
                    return;
                case 2:
                    RecognitionService.this.dispatchStopListening((IRecognitionListener) message.obj);
                    return;
                case 3:
                    RecognitionService.this.dispatchCancel((IRecognitionListener) message.obj);
                    return;
                case 4:
                    RecognitionService.this.dispatchClearCallback();
                    return;
                default:
                    return;
            }
        }
    };

    /* loaded from: source-9557208-dex2jar.jar:android/speech/RecognitionService$Callback.class */
    public class Callback {
        private final IRecognitionListener mListener;

        private Callback(IRecognitionListener iRecognitionListener) {
            this.mListener = iRecognitionListener;
        }

        public void beginningOfSpeech() throws RemoteException {
            this.mListener.onBeginningOfSpeech();
        }

        public void bufferReceived(byte[] bArr) throws RemoteException {
            this.mListener.onBufferReceived(bArr);
        }

        public void endOfSpeech() throws RemoteException {
            this.mListener.onEndOfSpeech();
        }

        public void error(int i) throws RemoteException {
            Message.obtain(RecognitionService.this.mHandler, 4).sendToTarget();
            this.mListener.onError(i);
        }

        public void partialResults(Bundle bundle) throws RemoteException {
            this.mListener.onPartialResults(bundle);
        }

        public void readyForSpeech(Bundle bundle) throws RemoteException {
            this.mListener.onReadyForSpeech(bundle);
        }

        public void results(Bundle bundle) throws RemoteException {
            Message.obtain(RecognitionService.this.mHandler, 4).sendToTarget();
            this.mListener.onResults(bundle);
        }

        public void rmsChanged(float f) throws RemoteException {
            this.mListener.onRmsChanged(f);
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/speech/RecognitionService$RecognitionServiceBinder.class */
    private static final class RecognitionServiceBinder extends IRecognitionService.Stub {
        private final WeakReference<RecognitionService> mServiceRef;

        public RecognitionServiceBinder(RecognitionService recognitionService) {
            this.mServiceRef = new WeakReference<>(recognitionService);
        }

        @Override // android.speech.IRecognitionService
        public void cancel(IRecognitionListener iRecognitionListener) {
            RecognitionService recognitionService = this.mServiceRef.get();
            if (recognitionService == null || !recognitionService.checkPermissions(iRecognitionListener)) {
                return;
            }
            recognitionService.mHandler.sendMessage(Message.obtain(recognitionService.mHandler, 3, iRecognitionListener));
        }

        public void clearReference() {
            this.mServiceRef.clear();
        }

        @Override // android.speech.IRecognitionService
        public void startListening(Intent intent, IRecognitionListener iRecognitionListener) {
            RecognitionService recognitionService = this.mServiceRef.get();
            if (recognitionService == null || !recognitionService.checkPermissions(iRecognitionListener)) {
                return;
            }
            Handler handler = recognitionService.mHandler;
            Handler handler2 = recognitionService.mHandler;
            recognitionService.getClass();
            handler.sendMessage(Message.obtain(handler2, 1, new StartListeningArgs(intent, iRecognitionListener)));
        }

        @Override // android.speech.IRecognitionService
        public void stopListening(IRecognitionListener iRecognitionListener) {
            RecognitionService recognitionService = this.mServiceRef.get();
            if (recognitionService == null || !recognitionService.checkPermissions(iRecognitionListener)) {
                return;
            }
            recognitionService.mHandler.sendMessage(Message.obtain(recognitionService.mHandler, 2, iRecognitionListener));
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/speech/RecognitionService$StartListeningArgs.class */
    private class StartListeningArgs {
        public final Intent mIntent;
        public final IRecognitionListener mListener;

        public StartListeningArgs(Intent intent, IRecognitionListener iRecognitionListener) {
            this.mIntent = intent;
            this.mListener = iRecognitionListener;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean checkPermissions(IRecognitionListener iRecognitionListener) {
        if (checkCallingOrSelfPermission(Manifest.permission.RECORD_AUDIO) == 0) {
            return true;
        }
        try {
            Log.e(TAG, "call for recognition service without RECORD_AUDIO permissions");
            iRecognitionListener.onError(9);
            return false;
        } catch (RemoteException e) {
            Log.e(TAG, "sending ERROR_INSUFFICIENT_PERMISSIONS message failed", e);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatchCancel(IRecognitionListener iRecognitionListener) {
        if (this.mCurrentCallback == null) {
            return;
        }
        if (this.mCurrentCallback.mListener.asBinder() != iRecognitionListener.asBinder()) {
            Log.w(TAG, "cancel called by client who did not call startListening - ignoring");
            return;
        }
        onCancel(this.mCurrentCallback);
        this.mCurrentCallback = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatchClearCallback() {
        this.mCurrentCallback = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatchStartListening(Intent intent, final IRecognitionListener iRecognitionListener) {
        if (this.mCurrentCallback != null) {
            try {
                iRecognitionListener.onError(8);
            } catch (RemoteException e) {
                Log.d(TAG, "onError call from startListening failed");
            }
            Log.i(TAG, "concurrent startListening received - ignoring this call");
            return;
        }
        try {
            iRecognitionListener.asBinder().linkToDeath(new IBinder.DeathRecipient() { // from class: android.speech.RecognitionService.2
                @Override // android.os.IBinder.DeathRecipient
                public void binderDied() {
                    RecognitionService.this.mHandler.sendMessage(RecognitionService.this.mHandler.obtainMessage(3, iRecognitionListener));
                }
            }, 0);
            this.mCurrentCallback = new Callback(iRecognitionListener);
            onStartListening(intent, this.mCurrentCallback);
        } catch (RemoteException e2) {
            Log.e(TAG, "dead listener on startListening");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatchStopListening(IRecognitionListener iRecognitionListener) {
        try {
            if (this.mCurrentCallback == null) {
                iRecognitionListener.onError(5);
                Log.w(TAG, "stopListening called with no preceding startListening - ignoring");
            } else if (this.mCurrentCallback.mListener.asBinder() == iRecognitionListener.asBinder()) {
                onStopListening(this.mCurrentCallback);
            } else {
                iRecognitionListener.onError(8);
                Log.w(TAG, "stopListening called by other caller than startListening - ignoring");
            }
        } catch (RemoteException e) {
            Log.d(TAG, "onError call from stopListening failed");
        }
    }

    @Override // android.app.Service
    public final IBinder onBind(Intent intent) {
        return this.mBinder;
    }

    protected abstract void onCancel(Callback callback);

    @Override // android.app.Service
    public void onDestroy() {
        this.mCurrentCallback = null;
        this.mBinder.clearReference();
        super.onDestroy();
    }

    protected abstract void onStartListening(Intent intent, Callback callback);

    protected abstract void onStopListening(Callback callback);
}
