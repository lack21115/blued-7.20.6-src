package android.speech;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.provider.Settings;
import android.speech.IRecognitionListener;
import android.speech.IRecognitionService;
import android.text.TextUtils;
import android.util.Log;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/* loaded from: source-9557208-dex2jar.jar:android/speech/SpeechRecognizer.class */
public class SpeechRecognizer {
    public static final String CONFIDENCE_SCORES = "confidence_scores";
    private static final boolean DBG = false;
    public static final int ERROR_AUDIO = 3;
    public static final int ERROR_CLIENT = 5;
    public static final int ERROR_INSUFFICIENT_PERMISSIONS = 9;
    public static final int ERROR_NETWORK = 2;
    public static final int ERROR_NETWORK_TIMEOUT = 1;
    public static final int ERROR_NO_MATCH = 7;
    public static final int ERROR_RECOGNIZER_BUSY = 8;
    public static final int ERROR_SERVER = 4;
    public static final int ERROR_SPEECH_TIMEOUT = 6;
    private static final int MSG_CANCEL = 3;
    private static final int MSG_CHANGE_LISTENER = 4;
    private static final int MSG_START = 1;
    private static final int MSG_STOP = 2;
    public static final String RESULTS_RECOGNITION = "results_recognition";
    private static final String TAG = "SpeechRecognizer";
    private Connection mConnection;
    private final Context mContext;
    private IRecognitionService mService;
    private final ComponentName mServiceComponent;
    private Handler mHandler = new Handler() { // from class: android.speech.SpeechRecognizer.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    SpeechRecognizer.this.handleStartListening((Intent) message.obj);
                    return;
                case 2:
                    SpeechRecognizer.this.handleStopMessage();
                    return;
                case 3:
                    SpeechRecognizer.this.handleCancelMessage();
                    return;
                case 4:
                    SpeechRecognizer.this.handleChangeListener((RecognitionListener) message.obj);
                    return;
                default:
                    return;
            }
        }
    };
    private final Queue<Message> mPendingTasks = new LinkedList();
    private final InternalListener mListener = new InternalListener();

    /* loaded from: source-9557208-dex2jar.jar:android/speech/SpeechRecognizer$Connection.class */
    private class Connection implements ServiceConnection {
        private Connection() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            SpeechRecognizer.this.mService = IRecognitionService.Stub.asInterface(iBinder);
            while (!SpeechRecognizer.this.mPendingTasks.isEmpty()) {
                SpeechRecognizer.this.mHandler.sendMessage((Message) SpeechRecognizer.this.mPendingTasks.poll());
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            SpeechRecognizer.this.mService = null;
            SpeechRecognizer.this.mConnection = null;
            SpeechRecognizer.this.mPendingTasks.clear();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-9557208-dex2jar.jar:android/speech/SpeechRecognizer$InternalListener.class */
    public static class InternalListener extends IRecognitionListener.Stub {
        private static final int MSG_BEGINNING_OF_SPEECH = 1;
        private static final int MSG_BUFFER_RECEIVED = 2;
        private static final int MSG_END_OF_SPEECH = 3;
        private static final int MSG_ERROR = 4;
        private static final int MSG_ON_EVENT = 9;
        private static final int MSG_PARTIAL_RESULTS = 7;
        private static final int MSG_READY_FOR_SPEECH = 5;
        private static final int MSG_RESULTS = 6;
        private static final int MSG_RMS_CHANGED = 8;
        private final Handler mInternalHandler;
        private RecognitionListener mInternalListener;

        private InternalListener() {
            this.mInternalHandler = new Handler() { // from class: android.speech.SpeechRecognizer.InternalListener.1
                @Override // android.os.Handler
                public void handleMessage(Message message) {
                    if (InternalListener.this.mInternalListener == null) {
                        return;
                    }
                    switch (message.what) {
                        case 1:
                            InternalListener.this.mInternalListener.onBeginningOfSpeech();
                            return;
                        case 2:
                            InternalListener.this.mInternalListener.onBufferReceived((byte[]) message.obj);
                            return;
                        case 3:
                            InternalListener.this.mInternalListener.onEndOfSpeech();
                            return;
                        case 4:
                            InternalListener.this.mInternalListener.onError(((Integer) message.obj).intValue());
                            return;
                        case 5:
                            InternalListener.this.mInternalListener.onReadyForSpeech((Bundle) message.obj);
                            return;
                        case 6:
                            InternalListener.this.mInternalListener.onResults((Bundle) message.obj);
                            return;
                        case 7:
                            InternalListener.this.mInternalListener.onPartialResults((Bundle) message.obj);
                            return;
                        case 8:
                            InternalListener.this.mInternalListener.onRmsChanged(((Float) message.obj).floatValue());
                            return;
                        case 9:
                            InternalListener.this.mInternalListener.onEvent(message.arg1, (Bundle) message.obj);
                            return;
                        default:
                            return;
                    }
                }
            };
        }

        @Override // android.speech.IRecognitionListener
        public void onBeginningOfSpeech() {
            Message.obtain(this.mInternalHandler, 1).sendToTarget();
        }

        @Override // android.speech.IRecognitionListener
        public void onBufferReceived(byte[] bArr) {
            Message.obtain(this.mInternalHandler, 2, bArr).sendToTarget();
        }

        @Override // android.speech.IRecognitionListener
        public void onEndOfSpeech() {
            Message.obtain(this.mInternalHandler, 3).sendToTarget();
        }

        @Override // android.speech.IRecognitionListener
        public void onError(int i) {
            Message.obtain(this.mInternalHandler, 4, Integer.valueOf(i)).sendToTarget();
        }

        @Override // android.speech.IRecognitionListener
        public void onEvent(int i, Bundle bundle) {
            Message.obtain(this.mInternalHandler, 9, i, i, bundle).sendToTarget();
        }

        @Override // android.speech.IRecognitionListener
        public void onPartialResults(Bundle bundle) {
            Message.obtain(this.mInternalHandler, 7, bundle).sendToTarget();
        }

        @Override // android.speech.IRecognitionListener
        public void onReadyForSpeech(Bundle bundle) {
            Message.obtain(this.mInternalHandler, 5, bundle).sendToTarget();
        }

        @Override // android.speech.IRecognitionListener
        public void onResults(Bundle bundle) {
            Message.obtain(this.mInternalHandler, 6, bundle).sendToTarget();
        }

        @Override // android.speech.IRecognitionListener
        public void onRmsChanged(float f) {
            Message.obtain(this.mInternalHandler, 8, Float.valueOf(f)).sendToTarget();
        }
    }

    private SpeechRecognizer(Context context, ComponentName componentName) {
        this.mContext = context;
        this.mServiceComponent = componentName;
    }

    private static void checkIsCalledFromMainThread() {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            throw new RuntimeException("SpeechRecognizer should be used only from the application's main thread");
        }
    }

    private boolean checkOpenConnection() {
        if (this.mService != null) {
            return true;
        }
        this.mListener.onError(5);
        Log.e(TAG, "not connected to the recognition service");
        return false;
    }

    public static SpeechRecognizer createSpeechRecognizer(Context context) {
        return createSpeechRecognizer(context, null);
    }

    public static SpeechRecognizer createSpeechRecognizer(Context context, ComponentName componentName) {
        if (context == null) {
            throw new IllegalArgumentException("Context cannot be null)");
        }
        checkIsCalledFromMainThread();
        return new SpeechRecognizer(context, componentName);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleCancelMessage() {
        if (checkOpenConnection()) {
            try {
                this.mService.cancel(this.mListener);
            } catch (RemoteException e) {
                Log.e(TAG, "cancel() failed", e);
                this.mListener.onError(5);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleChangeListener(RecognitionListener recognitionListener) {
        this.mListener.mInternalListener = recognitionListener;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleStartListening(Intent intent) {
        if (checkOpenConnection()) {
            try {
                this.mService.startListening(intent, this.mListener);
            } catch (RemoteException e) {
                Log.e(TAG, "startListening() failed", e);
                this.mListener.onError(5);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleStopMessage() {
        if (checkOpenConnection()) {
            try {
                this.mService.stopListening(this.mListener);
            } catch (RemoteException e) {
                Log.e(TAG, "stopListening() failed", e);
                this.mListener.onError(5);
            }
        }
    }

    public static boolean isRecognitionAvailable(Context context) {
        List<ResolveInfo> queryIntentServices = context.getPackageManager().queryIntentServices(new Intent(RecognitionService.SERVICE_INTERFACE), 0);
        boolean z = false;
        if (queryIntentServices != null) {
            z = false;
            if (queryIntentServices.size() != 0) {
                z = true;
            }
        }
        return z;
    }

    private void putMessage(Message message) {
        if (this.mService == null) {
            this.mPendingTasks.offer(message);
        } else {
            this.mHandler.sendMessage(message);
        }
    }

    public void cancel() {
        checkIsCalledFromMainThread();
        putMessage(Message.obtain(this.mHandler, 3));
    }

    public void destroy() {
        if (this.mService != null) {
            try {
                this.mService.cancel(this.mListener);
            } catch (RemoteException e) {
            }
        }
        if (this.mConnection != null) {
            this.mContext.unbindService(this.mConnection);
        }
        this.mPendingTasks.clear();
        this.mService = null;
        this.mConnection = null;
        this.mListener.mInternalListener = null;
    }

    public void setRecognitionListener(RecognitionListener recognitionListener) {
        checkIsCalledFromMainThread();
        putMessage(Message.obtain(this.mHandler, 4, recognitionListener));
    }

    public void startListening(Intent intent) {
        if (intent == null) {
            throw new IllegalArgumentException("intent must not be null");
        }
        checkIsCalledFromMainThread();
        if (this.mConnection == null) {
            this.mConnection = new Connection();
            Intent intent2 = new Intent(RecognitionService.SERVICE_INTERFACE);
            if (this.mServiceComponent == null) {
                String string = Settings.Secure.getString(this.mContext.getContentResolver(), Settings.Secure.VOICE_RECOGNITION_SERVICE);
                if (TextUtils.isEmpty(string)) {
                    Log.e(TAG, "no selected voice recognition service");
                    this.mListener.onError(5);
                    return;
                }
                intent2.setComponent(ComponentName.unflattenFromString(string));
            } else {
                intent2.setComponent(this.mServiceComponent);
            }
            if (!this.mContext.bindService(intent2, this.mConnection, 1)) {
                Log.e(TAG, "bind to recognition service failed");
                this.mConnection = null;
                this.mService = null;
                this.mListener.onError(5);
                return;
            }
        }
        putMessage(Message.obtain(this.mHandler, 1, intent));
    }

    public void stopListening() {
        checkIsCalledFromMainThread();
        putMessage(Message.obtain(this.mHandler, 2));
    }
}
