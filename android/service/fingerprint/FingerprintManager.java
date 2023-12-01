package android.service.fingerprint;

import android.content.Context;
import android.hardware.fingerprint.Fingerprint;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Process;
import android.os.RemoteException;
import android.service.fingerprint.IFingerprintServiceReceiver;
import android.util.Log;
import android.util.Slog;
import java.util.Collections;
import java.util.List;

/* loaded from: source-9557208-dex2jar.jar:android/service/fingerprint/FingerprintManager.class */
public class FingerprintManager {
    private static final boolean DEBUG = true;
    public static final int FINGERPRINT_ACQUIRED = 1;
    public static final int FINGERPRINT_ACQUIRED_GOOD = 0;
    public static final int FINGERPRINT_ACQUIRED_IMAGER_DIRTY = 4;
    public static final int FINGERPRINT_ACQUIRED_INSUFFICIENT = 2;
    public static final int FINGERPRINT_ACQUIRED_PARTIAL = 1;
    public static final int FINGERPRINT_ACQUIRED_TOO_FAST = 16;
    public static final int FINGERPRINT_ACQUIRED_TOO_SLOW = 8;
    public static final int FINGERPRINT_ERROR = -1;
    public static final int FINGERPRINT_ERROR_CANCELED = 5;
    public static final int FINGERPRINT_ERROR_HW_UNAVAILABLE = 1;
    public static final int FINGERPRINT_ERROR_NO_RECEIVER = -10;
    public static final int FINGERPRINT_ERROR_NO_SPACE = 4;
    public static final int FINGERPRINT_ERROR_TIMEOUT = 3;
    public static final int FINGERPRINT_ERROR_UNABLE_TO_PROCESS = 2;
    public static final int FINGERPRINT_ERROR_UNABLE_TO_REMOVE = 6;
    public static final long FINGERPRINT_EVENT_VIBRATE_DURATION = 100;
    public static final int FINGERPRINT_PROCESSED = 2;
    public static final int FINGERPRINT_TEMPLATE_ENROLLING = 3;
    public static final int FINGERPRINT_TEMPLATE_REMOVED = 4;
    private static final int MSG_ACQUIRED = 101;
    private static final int MSG_ENROLL_RESULT = 100;
    private static final int MSG_ERROR = 103;
    private static final int MSG_PROCESSED = 102;
    private static final int MSG_REMOVED = 104;
    private static final int MSG_STATE_CHANGE = 105;
    public static final int STATE_AUTHENTICATING = 1;
    public static final int STATE_ENROLLING = 2;
    public static final int STATE_IDLE = 0;
    public static final int STATE_UNKNOWN = -1;
    private static final String TAG = "FingerprintManager";
    private FingerprintManagerReceiver mClientReceiver;
    private Context mContext;
    private IFingerprintService mService;
    private IBinder mToken = new Binder();
    private Handler mHandler = new Handler() { // from class: android.service.fingerprint.FingerprintManager.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (FingerprintManager.this.mClientReceiver != null) {
                switch (message.what) {
                    case 100:
                        FingerprintManager.this.mClientReceiver.onEnrollResult(message.arg1, message.arg2);
                        return;
                    case 101:
                        FingerprintManager.this.mClientReceiver.onAcquired(message.arg1);
                        return;
                    case 102:
                        FingerprintManager.this.mClientReceiver.onProcessed(message.arg1);
                        return;
                    case 103:
                        FingerprintManager.this.mClientReceiver.onError(message.arg1);
                        return;
                    case 104:
                        FingerprintManager.this.mClientReceiver.onRemoved(message.arg1);
                        return;
                    case 105:
                        FingerprintManager.this.mClientReceiver.onStateChanged(message.arg1);
                        return;
                    default:
                        return;
                }
            }
        }
    };
    private IFingerprintServiceReceiver mServiceReceiver = new IFingerprintServiceReceiver.Stub() { // from class: android.service.fingerprint.FingerprintManager.2
        @Override // android.service.fingerprint.IFingerprintServiceReceiver
        public void onAcquired(int i) {
            FingerprintManager.this.mHandler.obtainMessage(101, i, 0).sendToTarget();
        }

        @Override // android.service.fingerprint.IFingerprintServiceReceiver
        public void onEnrollResult(int i, int i2) {
            FingerprintManager.this.mHandler.obtainMessage(100, i, i2).sendToTarget();
        }

        @Override // android.service.fingerprint.IFingerprintServiceReceiver
        public void onError(int i) {
            FingerprintManager.this.mHandler.obtainMessage(103, i, 0).sendToTarget();
        }

        @Override // android.service.fingerprint.IFingerprintServiceReceiver
        public void onProcessed(int i) {
            FingerprintManager.this.mHandler.obtainMessage(102, i, 0).sendToTarget();
        }

        @Override // android.service.fingerprint.IFingerprintServiceReceiver
        public void onRemoved(int i) {
            FingerprintManager.this.mHandler.obtainMessage(104, i, 0).sendToTarget();
        }

        @Override // android.service.fingerprint.IFingerprintServiceReceiver
        public void onStateChanged(int i) {
            FingerprintManager.this.mHandler.obtainMessage(105, i, 0).sendToTarget();
        }
    };

    public FingerprintManager(Context context, IFingerprintService iFingerprintService) {
        this.mContext = context;
        this.mService = iFingerprintService;
        if (this.mService == null) {
            Slog.v(TAG, "FingerprintManagerService was null");
        }
    }

    private int getCurrentUserId() {
        return Process.myUserHandle().getIdentifier();
    }

    private void sendError(int i, int i2, int i3) {
        this.mHandler.obtainMessage(i, i2, i3);
    }

    public void authenticate() {
        authenticate(false);
    }

    public void authenticate(boolean z) {
        if (this.mServiceReceiver == null) {
            sendError(-10, 0, 0);
        } else if (this.mService != null) {
            try {
                this.mService.authenticate(this.mToken, getCurrentUserId(), z);
            } catch (RemoteException e) {
                Log.v(TAG, "Remote exception while enrolling: ", e);
                sendError(1, 0, 0);
            }
        }
    }

    public void cancel() {
        if (this.mServiceReceiver == null) {
            sendError(-10, 0, 0);
        } else if (this.mService == null) {
            Log.w(TAG, "cancel(): Service not connected!");
        } else {
            try {
                this.mService.cancel(this.mToken, getCurrentUserId());
            } catch (RemoteException e) {
                Log.v(TAG, "Remote exception in enrollCancel(): ", e);
                sendError(1, 0, 0);
            }
        }
    }

    public void enroll(long j) {
        if (this.mServiceReceiver == null) {
            sendError(-10, 0, 0);
        } else if (this.mService != null) {
            try {
                this.mService.enroll(this.mToken, j, getCurrentUserId());
            } catch (RemoteException e) {
                Log.v(TAG, "Remote exception while enrolling: ", e);
                sendError(1, 0, 0);
            }
        }
    }

    public List<Fingerprint> getEnrolledFingerprints() {
        if (this.mService != null) {
            try {
                return this.mService.getEnrolledFingerprints(this.mToken, getCurrentUserId());
            } catch (RemoteException e) {
                Log.v(TAG, "Remote exception in getEnrolledFingerprints(): ", e);
            }
        } else {
            Log.w(TAG, "getEnrolledFingerprints(): Service not connected!");
        }
        return Collections.emptyList();
    }

    public int getNumEnrollmentSteps() {
        if (this.mService == null) {
            Log.w(TAG, "getNumEnrollmentSteps(): Service not connected!");
            return -1;
        }
        try {
            return this.mService.getNumEnrollmentSteps(this.mToken);
        } catch (RemoteException e) {
            Log.v(TAG, "Remote exception in getNumEnrollmentSteps(): ", e);
            return -1;
        }
    }

    public int getState() {
        if (this.mService == null) {
            Log.w(TAG, "getState(): Service not connected!");
            sendError(1, 0, 0);
            return -1;
        }
        try {
            return this.mService.getState();
        } catch (RemoteException e) {
            Log.v(TAG, "Remote exception in getState(): ", e);
            return -1;
        }
    }

    public void remove(int i) {
        if (this.mServiceReceiver == null) {
            sendError(-10, 0, 0);
        } else if (this.mService == null) {
            Log.w(TAG, "remove(): Service not connected!");
            sendError(1, 0, 0);
        } else {
            try {
                this.mService.remove(this.mToken, i, getCurrentUserId());
            } catch (RemoteException e) {
                Log.v(TAG, "Remote exception during remove of fingerprintId: " + i, e);
            }
        }
    }

    public void setFingerprintName(int i, String str) {
        if (this.mServiceReceiver == null) {
            sendError(-10, 0, 0);
        } else if (this.mService == null) {
            Log.w(TAG, "setFingerprintName(): Service not connected!");
            sendError(1, 0, 0);
        } else {
            try {
                this.mService.setFingerprintName(this.mToken, i, str, getCurrentUserId());
            } catch (RemoteException e) {
                Log.v(TAG, "Remote exception renaming fingerprintId: " + i, e);
            }
        }
    }

    public void setWakeup(boolean z) {
        if (this.mService == null) {
            Log.w(TAG, "setWakeup(): Service not connected!");
            return;
        }
        try {
            this.mService.setWakeup(this.mToken, getCurrentUserId(), z);
        } catch (RemoteException e) {
            Log.v(TAG, "Remote exception in setWakeup(): ", e);
        }
    }

    public void startListening(FingerprintManagerReceiver fingerprintManagerReceiver) {
        this.mClientReceiver = fingerprintManagerReceiver;
        if (this.mService == null) {
            Log.w(TAG, "startListening(): Service not connected!");
            sendError(1, 0, 0);
            return;
        }
        try {
            this.mService.startListening(this.mToken, this.mServiceReceiver, getCurrentUserId());
        } catch (RemoteException e) {
            Log.v(TAG, "Remote exception in startListening(): ", e);
        }
    }

    public void stopListening() {
        if (this.mService == null) {
            Log.w(TAG, "stopListening(): Service not connected!");
            sendError(1, 0, 0);
            return;
        }
        try {
            this.mService.stopListening(this.mToken, getCurrentUserId());
            this.mClientReceiver = null;
        } catch (RemoteException e) {
            Log.v(TAG, "Remote exception in stopListening(): ", e);
        }
    }

    public boolean userEnrolled() {
        return FingerprintUtils.getFingerprintsForUser(this.mContext.getContentResolver(), getCurrentUserId()).size() > 0;
    }
}
