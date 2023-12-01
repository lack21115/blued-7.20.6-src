package android.service.voice;

import android.content.Intent;
import android.hardware.soundtrigger.IRecognitionStatusCallback;
import android.hardware.soundtrigger.KeyphraseEnrollmentInfo;
import android.hardware.soundtrigger.KeyphraseMetadata;
import android.hardware.soundtrigger.SoundTrigger;
import android.media.AudioFormat;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;
import android.os.RemoteException;
import android.util.Slog;
import com.android.internal.app.IVoiceInteractionManagerService;
import java.io.PrintWriter;
import java.util.Locale;

/* loaded from: source-9557208-dex2jar.jar:android/service/voice/AlwaysOnHotwordDetector.class */
public class AlwaysOnHotwordDetector {
    static final boolean DBG = false;
    public static final int MANAGE_ACTION_ENROLL = 0;
    public static final int MANAGE_ACTION_RE_ENROLL = 1;
    public static final int MANAGE_ACTION_UN_ENROLL = 2;
    private static final int MSG_AVAILABILITY_CHANGED = 1;
    private static final int MSG_DETECTION_ERROR = 3;
    private static final int MSG_DETECTION_PAUSE = 4;
    private static final int MSG_DETECTION_RESUME = 5;
    private static final int MSG_HOTWORD_DETECTED = 2;
    public static final int RECOGNITION_FLAG_ALLOW_MULTIPLE_TRIGGERS = 2;
    public static final int RECOGNITION_FLAG_CAPTURE_TRIGGER_AUDIO = 1;
    public static final int RECOGNITION_FLAG_NONE = 0;
    public static final int RECOGNITION_MODE_USER_IDENTIFICATION = 2;
    public static final int RECOGNITION_MODE_VOICE_TRIGGER = 1;
    public static final int STATE_HARDWARE_UNAVAILABLE = -2;
    private static final int STATE_INVALID = -3;
    public static final int STATE_KEYPHRASE_ENROLLED = 2;
    public static final int STATE_KEYPHRASE_UNENROLLED = 1;
    public static final int STATE_KEYPHRASE_UNSUPPORTED = -1;
    private static final int STATE_NOT_READY = 0;
    private static final int STATUS_ERROR = Integer.MIN_VALUE;
    private static final int STATUS_OK = 0;
    static final String TAG = "AlwaysOnHotwordDetector";
    private final Callback mExternalCallback;
    private final KeyphraseEnrollmentInfo mKeyphraseEnrollmentInfo;
    private final KeyphraseMetadata mKeyphraseMetadata;
    private final Locale mLocale;
    private final IVoiceInteractionManagerService mModelManagementService;
    private final String mText;
    private final IVoiceInteractionService mVoiceInteractionService;
    private final Object mLock = new Object();
    private int mAvailability = 0;
    private final Handler mHandler = new MyHandler();
    private final SoundTriggerListener mInternalCallback = new SoundTriggerListener(this.mHandler);

    /* loaded from: source-9557208-dex2jar.jar:android/service/voice/AlwaysOnHotwordDetector$Callback.class */
    public static abstract class Callback {
        public abstract void onAvailabilityChanged(int i);

        public abstract void onDetected(EventPayload eventPayload);

        public abstract void onError();

        public abstract void onRecognitionPaused();

        public abstract void onRecognitionResumed();
    }

    /* loaded from: source-9557208-dex2jar.jar:android/service/voice/AlwaysOnHotwordDetector$EventPayload.class */
    public static class EventPayload {
        private final AudioFormat mAudioFormat;
        private final boolean mCaptureAvailable;
        private final int mCaptureSession;
        private final byte[] mData;
        private final boolean mTriggerAvailable;

        private EventPayload(boolean z, boolean z2, AudioFormat audioFormat, int i, byte[] bArr) {
            this.mTriggerAvailable = z;
            this.mCaptureAvailable = z2;
            this.mCaptureSession = i;
            this.mAudioFormat = audioFormat;
            this.mData = bArr;
        }

        public AudioFormat getCaptureAudioFormat() {
            return this.mAudioFormat;
        }

        public Integer getCaptureSession() {
            if (this.mCaptureAvailable) {
                return Integer.valueOf(this.mCaptureSession);
            }
            return null;
        }

        public byte[] getTriggerAudio() {
            if (this.mTriggerAvailable) {
                return this.mData;
            }
            return null;
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/service/voice/AlwaysOnHotwordDetector$MyHandler.class */
    class MyHandler extends Handler {
        MyHandler() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            synchronized (AlwaysOnHotwordDetector.this.mLock) {
                if (AlwaysOnHotwordDetector.this.mAvailability == -3) {
                    Slog.w(AlwaysOnHotwordDetector.TAG, "Received message: " + message.what + " for an invalid detector");
                    return;
                }
                switch (message.what) {
                    case 1:
                        AlwaysOnHotwordDetector.this.mExternalCallback.onAvailabilityChanged(message.arg1);
                        return;
                    case 2:
                        AlwaysOnHotwordDetector.this.mExternalCallback.onDetected((EventPayload) message.obj);
                        return;
                    case 3:
                        AlwaysOnHotwordDetector.this.mExternalCallback.onError();
                        return;
                    case 4:
                        AlwaysOnHotwordDetector.this.mExternalCallback.onRecognitionPaused();
                        return;
                    case 5:
                        AlwaysOnHotwordDetector.this.mExternalCallback.onRecognitionResumed();
                        return;
                    default:
                        super.handleMessage(message);
                        return;
                }
            }
        }
    }

    /* loaded from: source-9557208-dex2jar.jar:android/service/voice/AlwaysOnHotwordDetector$RefreshAvailabiltyTask.class */
    class RefreshAvailabiltyTask extends AsyncTask<Void, Void, Void> {
        RefreshAvailabiltyTask() {
        }

        private int internalGetInitialAvailability() {
            synchronized (AlwaysOnHotwordDetector.this.mLock) {
                if (AlwaysOnHotwordDetector.this.mAvailability == -3) {
                    return -3;
                }
                SoundTrigger.ModuleProperties moduleProperties = null;
                try {
                    moduleProperties = AlwaysOnHotwordDetector.this.mModelManagementService.getDspModuleProperties(AlwaysOnHotwordDetector.this.mVoiceInteractionService);
                } catch (RemoteException e) {
                    Slog.w(AlwaysOnHotwordDetector.TAG, "RemoteException in getDspProperties!", e);
                }
                if (moduleProperties == null) {
                    return -2;
                }
                return AlwaysOnHotwordDetector.this.mKeyphraseMetadata == null ? -1 : 0;
            }
        }

        private boolean internalGetIsEnrolled(int i, Locale locale) {
            try {
                return AlwaysOnHotwordDetector.this.mModelManagementService.isEnrolledForKeyphrase(AlwaysOnHotwordDetector.this.mVoiceInteractionService, i, locale.toLanguageTag());
            } catch (RemoteException e) {
                Slog.w(AlwaysOnHotwordDetector.TAG, "RemoteException in listRegisteredKeyphraseSoundModels!", e);
                return false;
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:7:0x0012, code lost:
            if (r0 == 2) goto L20;
         */
        @Override // android.os.AsyncTask
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public java.lang.Void doInBackground(java.lang.Void... r5) {
            /*
                r4 = this;
                r0 = r4
                int r0 = r0.internalGetInitialAvailability()
                r7 = r0
                r0 = r7
                if (r0 == 0) goto L15
                r0 = r7
                r1 = 1
                if (r0 == r1) goto L15
                r0 = r7
                r6 = r0
                r0 = r7
                r1 = 2
                if (r0 != r1) goto L2f
            L15:
                r0 = r4
                r1 = r4
                android.service.voice.AlwaysOnHotwordDetector r1 = android.service.voice.AlwaysOnHotwordDetector.this
                android.hardware.soundtrigger.KeyphraseMetadata r1 = android.service.voice.AlwaysOnHotwordDetector.access$400(r1)
                int r1 = r1.id
                r2 = r4
                android.service.voice.AlwaysOnHotwordDetector r2 = android.service.voice.AlwaysOnHotwordDetector.this
                java.util.Locale r2 = android.service.voice.AlwaysOnHotwordDetector.access$500(r2)
                boolean r0 = r0.internalGetIsEnrolled(r1, r2)
                if (r0 != 0) goto L54
                r0 = 1
                r6 = r0
            L2f:
                r0 = r4
                android.service.voice.AlwaysOnHotwordDetector r0 = android.service.voice.AlwaysOnHotwordDetector.this
                java.lang.Object r0 = android.service.voice.AlwaysOnHotwordDetector.access$100(r0)
                r5 = r0
                r0 = r5
                monitor-enter(r0)
                r0 = r4
                android.service.voice.AlwaysOnHotwordDetector r0 = android.service.voice.AlwaysOnHotwordDetector.this     // Catch: java.lang.Throwable -> L4d
                r1 = r6
                int r0 = android.service.voice.AlwaysOnHotwordDetector.access$202(r0, r1)     // Catch: java.lang.Throwable -> L4d
                r0 = r4
                android.service.voice.AlwaysOnHotwordDetector r0 = android.service.voice.AlwaysOnHotwordDetector.this     // Catch: java.lang.Throwable -> L4d
                android.service.voice.AlwaysOnHotwordDetector.access$600(r0)     // Catch: java.lang.Throwable -> L4d
                r0 = r5
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L4d
                r0 = 0
                return r0
            L4d:
                r8 = move-exception
                r0 = r5
                monitor-exit(r0)     // Catch: java.lang.Throwable -> L4d
                r0 = r8
                throw r0
            L54:
                r0 = 2
                r6 = r0
                goto L2f
            */
            throw new UnsupportedOperationException("Method not decompiled: android.service.voice.AlwaysOnHotwordDetector.RefreshAvailabiltyTask.doInBackground(java.lang.Void[]):java.lang.Void");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-9557208-dex2jar.jar:android/service/voice/AlwaysOnHotwordDetector$SoundTriggerListener.class */
    public static final class SoundTriggerListener extends IRecognitionStatusCallback.Stub {
        private final Handler mHandler;

        public SoundTriggerListener(Handler handler) {
            this.mHandler = handler;
        }

        @Override // android.hardware.soundtrigger.IRecognitionStatusCallback
        public void onDetected(SoundTrigger.KeyphraseRecognitionEvent keyphraseRecognitionEvent) {
            Slog.i(AlwaysOnHotwordDetector.TAG, "onDetected");
            Message.obtain(this.mHandler, 2, new EventPayload(keyphraseRecognitionEvent.triggerInData, keyphraseRecognitionEvent.captureAvailable, keyphraseRecognitionEvent.captureFormat, keyphraseRecognitionEvent.captureSession, keyphraseRecognitionEvent.data)).sendToTarget();
        }

        @Override // android.hardware.soundtrigger.IRecognitionStatusCallback
        public void onError(int i) {
            Slog.i(AlwaysOnHotwordDetector.TAG, "onError: " + i);
            this.mHandler.sendEmptyMessage(3);
        }

        @Override // android.hardware.soundtrigger.IRecognitionStatusCallback
        public void onRecognitionPaused() {
            Slog.i(AlwaysOnHotwordDetector.TAG, "onRecognitionPaused");
            this.mHandler.sendEmptyMessage(4);
        }

        @Override // android.hardware.soundtrigger.IRecognitionStatusCallback
        public void onRecognitionResumed() {
            Slog.i(AlwaysOnHotwordDetector.TAG, "onRecognitionResumed");
            this.mHandler.sendEmptyMessage(5);
        }
    }

    public AlwaysOnHotwordDetector(String str, Locale locale, Callback callback, KeyphraseEnrollmentInfo keyphraseEnrollmentInfo, IVoiceInteractionService iVoiceInteractionService, IVoiceInteractionManagerService iVoiceInteractionManagerService) {
        this.mText = str;
        this.mLocale = locale;
        this.mKeyphraseEnrollmentInfo = keyphraseEnrollmentInfo;
        this.mKeyphraseMetadata = this.mKeyphraseEnrollmentInfo.getKeyphraseMetadata(str, locale);
        this.mExternalCallback = callback;
        this.mVoiceInteractionService = iVoiceInteractionService;
        this.mModelManagementService = iVoiceInteractionManagerService;
        new RefreshAvailabiltyTask().execute(new Void[0]);
    }

    private Intent getManageIntentLocked(int i) {
        if (this.mAvailability == -3) {
            throw new IllegalStateException("getManageIntent called on an invalid detector");
        }
        if (this.mAvailability == 2 || this.mAvailability == 1) {
            return this.mKeyphraseEnrollmentInfo.getManageKeyphraseIntent(i, this.mText, this.mLocale);
        }
        throw new UnsupportedOperationException("Managing the given keyphrase is not supported");
    }

    private int getSupportedRecognitionModesLocked() {
        if (this.mAvailability == -3) {
            throw new IllegalStateException("getSupportedRecognitionModes called on an invalid detector");
        }
        if (this.mAvailability == 2 || this.mAvailability == 1) {
            return this.mKeyphraseMetadata.recognitionModeFlags;
        }
        throw new UnsupportedOperationException("Getting supported recognition modes for the keyphrase is not supported");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyStateChangedLocked() {
        Message obtain = Message.obtain(this.mHandler, 1);
        obtain.arg1 = this.mAvailability;
        obtain.sendToTarget();
    }

    private int startRecognitionLocked(int i) {
        boolean z = true;
        SoundTrigger.KeyphraseRecognitionExtra keyphraseRecognitionExtra = new SoundTrigger.KeyphraseRecognitionExtra(this.mKeyphraseMetadata.id, this.mKeyphraseMetadata.recognitionModeFlags, 0, new SoundTrigger.ConfidenceLevel[0]);
        boolean z2 = (i & 1) != 0;
        if ((i & 2) == 0) {
            z = false;
        }
        int i2 = Integer.MIN_VALUE;
        try {
            i2 = this.mModelManagementService.startRecognition(this.mVoiceInteractionService, this.mKeyphraseMetadata.id, this.mLocale.toLanguageTag(), this.mInternalCallback, new SoundTrigger.RecognitionConfig(z2, z, new SoundTrigger.KeyphraseRecognitionExtra[]{keyphraseRecognitionExtra}, null));
        } catch (RemoteException e) {
            Slog.w(TAG, "RemoteException in startRecognition!", e);
        }
        if (i2 != 0) {
            Slog.w(TAG, "startRecognition() failed with error code " + i2);
        }
        return i2;
    }

    private int stopRecognitionLocked() {
        int i = Integer.MIN_VALUE;
        try {
            i = this.mModelManagementService.stopRecognition(this.mVoiceInteractionService, this.mKeyphraseMetadata.id, this.mInternalCallback);
        } catch (RemoteException e) {
            Slog.w(TAG, "RemoteException in stopRecognition!", e);
        }
        if (i != 0) {
            Slog.w(TAG, "stopRecognition() failed with error code " + i);
        }
        return i;
    }

    public Intent createEnrollIntent() {
        Intent manageIntentLocked;
        synchronized (this.mLock) {
            manageIntentLocked = getManageIntentLocked(0);
        }
        return manageIntentLocked;
    }

    public Intent createReEnrollIntent() {
        Intent manageIntentLocked;
        synchronized (this.mLock) {
            manageIntentLocked = getManageIntentLocked(1);
        }
        return manageIntentLocked;
    }

    public Intent createUnEnrollIntent() {
        Intent manageIntentLocked;
        synchronized (this.mLock) {
            manageIntentLocked = getManageIntentLocked(2);
        }
        return manageIntentLocked;
    }

    public void dump(String str, PrintWriter printWriter) {
        synchronized (this.mLock) {
            printWriter.print(str);
            printWriter.print("Text=");
            printWriter.println(this.mText);
            printWriter.print(str);
            printWriter.print("Locale=");
            printWriter.println(this.mLocale);
            printWriter.print(str);
            printWriter.print("Availability=");
            printWriter.println(this.mAvailability);
            printWriter.print(str);
            printWriter.print("KeyphraseMetadata=");
            printWriter.println(this.mKeyphraseMetadata);
            printWriter.print(str);
            printWriter.print("EnrollmentInfo=");
            printWriter.println(this.mKeyphraseEnrollmentInfo);
        }
    }

    public int getSupportedRecognitionModes() {
        int supportedRecognitionModesLocked;
        synchronized (this.mLock) {
            supportedRecognitionModesLocked = getSupportedRecognitionModesLocked();
        }
        return supportedRecognitionModesLocked;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void invalidate() {
        synchronized (this.mLock) {
            this.mAvailability = -3;
            notifyStateChangedLocked();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onSoundModelsChanged() {
        synchronized (this.mLock) {
            if (this.mAvailability == -3 || this.mAvailability == -2 || this.mAvailability == -1) {
                Slog.w(TAG, "Received onSoundModelsChanged for an unsupported keyphrase/config");
                return;
            }
            stopRecognitionLocked();
            new RefreshAvailabiltyTask().execute(new Void[0]);
        }
    }

    public boolean startRecognition(int i) {
        boolean z;
        synchronized (this.mLock) {
            if (this.mAvailability == -3) {
                throw new IllegalStateException("startRecognition called on an invalid detector");
            }
            if (this.mAvailability != 2) {
                throw new UnsupportedOperationException("Recognition for the given keyphrase is not supported");
            }
            z = startRecognitionLocked(i) == 0;
        }
        return z;
    }

    public boolean stopRecognition() {
        boolean z;
        synchronized (this.mLock) {
            if (this.mAvailability == -3) {
                throw new IllegalStateException("stopRecognition called on an invalid detector");
            }
            if (this.mAvailability != 2) {
                throw new UnsupportedOperationException("Recognition for the given keyphrase is not supported");
            }
            z = stopRecognitionLocked() == 0;
        }
        return z;
    }
}
