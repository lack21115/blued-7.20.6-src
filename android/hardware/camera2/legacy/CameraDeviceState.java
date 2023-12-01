package android.hardware.camera2.legacy;

import android.hardware.camera2.impl.CameraMetadataNative;
import android.os.Handler;
import android.util.Log;
import com.baidu.mobads.sdk.internal.bw;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;

/* loaded from: source-9557208-dex2jar.jar:android/hardware/camera2/legacy/CameraDeviceState.class */
public class CameraDeviceState {
    public static final int NO_CAPTURE_ERROR = -1;
    private static final int STATE_CAPTURING = 4;
    private static final int STATE_CONFIGURING = 2;
    private static final int STATE_ERROR = 0;
    private static final int STATE_IDLE = 3;
    private static final int STATE_UNCONFIGURED = 1;
    private static final String TAG = "CameraDeviceState";
    private static final boolean DEBUG = Log.isLoggable(LegacyCameraDevice.DEBUG_PROP, 3);
    private static final String[] sStateNames = {bw.l, "UNCONFIGURED", "CONFIGURING", "IDLE", "CAPTURING"};
    private int mCurrentState = 1;
    private int mCurrentError = -1;
    private RequestHolder mCurrentRequest = null;
    private Handler mCurrentHandler = null;
    private CameraDeviceStateListener mCurrentListener = null;

    /* loaded from: source-9557208-dex2jar.jar:android/hardware/camera2/legacy/CameraDeviceState$CameraDeviceStateListener.class */
    public interface CameraDeviceStateListener {
        void onBusy();

        void onCaptureResult(CameraMetadataNative cameraMetadataNative, RequestHolder requestHolder);

        void onCaptureStarted(RequestHolder requestHolder, long j);

        void onConfiguring();

        void onError(int i, RequestHolder requestHolder);

        void onIdle();
    }

    private void doStateTransition(int i) {
        doStateTransition(i, 0L, -1);
    }

    private void doStateTransition(int i, final long j, final int i2) {
        if (i != this.mCurrentState) {
            String str = GrsBaseInfo.CountryCodeSource.UNKNOWN;
            if (i >= 0) {
                str = GrsBaseInfo.CountryCodeSource.UNKNOWN;
                if (i < sStateNames.length) {
                    str = sStateNames[i];
                }
            }
            Log.i(TAG, "Legacy camera service transitioning to state " + str);
        }
        if (i != 0 && i != 3 && this.mCurrentState != i && this.mCurrentHandler != null && this.mCurrentListener != null) {
            this.mCurrentHandler.post(new Runnable() { // from class: android.hardware.camera2.legacy.CameraDeviceState.3
                @Override // java.lang.Runnable
                public void run() {
                    CameraDeviceState.this.mCurrentListener.onBusy();
                }
            });
        }
        switch (i) {
            case 0:
                if (this.mCurrentState != 0 && this.mCurrentHandler != null && this.mCurrentListener != null) {
                    this.mCurrentHandler.post(new Runnable() { // from class: android.hardware.camera2.legacy.CameraDeviceState.4
                        @Override // java.lang.Runnable
                        public void run() {
                            CameraDeviceState.this.mCurrentListener.onError(CameraDeviceState.this.mCurrentError, CameraDeviceState.this.mCurrentRequest);
                        }
                    });
                }
                this.mCurrentState = 0;
                return;
            case 1:
            default:
                throw new IllegalStateException("Transition to unknown state: " + i);
            case 2:
                if (this.mCurrentState != 1 && this.mCurrentState != 3) {
                    Log.e(TAG, "Cannot call configure while in state: " + this.mCurrentState);
                    this.mCurrentError = 1;
                    doStateTransition(0);
                    return;
                }
                if (this.mCurrentState != 2 && this.mCurrentHandler != null && this.mCurrentListener != null) {
                    this.mCurrentHandler.post(new Runnable() { // from class: android.hardware.camera2.legacy.CameraDeviceState.5
                        @Override // java.lang.Runnable
                        public void run() {
                            CameraDeviceState.this.mCurrentListener.onConfiguring();
                        }
                    });
                }
                this.mCurrentState = 2;
                return;
            case 3:
                if (this.mCurrentState != 3) {
                    if (this.mCurrentState != 2 && this.mCurrentState != 4) {
                        Log.e(TAG, "Cannot call idle while in state: " + this.mCurrentState);
                        this.mCurrentError = 1;
                        doStateTransition(0);
                        return;
                    }
                    if (this.mCurrentState != 3 && this.mCurrentHandler != null && this.mCurrentListener != null) {
                        this.mCurrentHandler.post(new Runnable() { // from class: android.hardware.camera2.legacy.CameraDeviceState.6
                            @Override // java.lang.Runnable
                            public void run() {
                                CameraDeviceState.this.mCurrentListener.onIdle();
                            }
                        });
                    }
                    this.mCurrentState = 3;
                    return;
                }
                return;
            case 4:
                if (this.mCurrentState != 3 && this.mCurrentState != 4) {
                    Log.e(TAG, "Cannot call capture while in state: " + this.mCurrentState);
                    this.mCurrentError = 1;
                    doStateTransition(0);
                    return;
                }
                if (this.mCurrentHandler != null && this.mCurrentListener != null) {
                    if (i2 != -1) {
                        this.mCurrentHandler.post(new Runnable() { // from class: android.hardware.camera2.legacy.CameraDeviceState.7
                            @Override // java.lang.Runnable
                            public void run() {
                                CameraDeviceState.this.mCurrentListener.onError(i2, CameraDeviceState.this.mCurrentRequest);
                            }
                        });
                    } else {
                        this.mCurrentHandler.post(new Runnable() { // from class: android.hardware.camera2.legacy.CameraDeviceState.8
                            @Override // java.lang.Runnable
                            public void run() {
                                CameraDeviceState.this.mCurrentListener.onCaptureStarted(CameraDeviceState.this.mCurrentRequest, j);
                            }
                        });
                    }
                }
                this.mCurrentState = 4;
                return;
        }
    }

    public void setCameraDeviceCallbacks(Handler handler, CameraDeviceStateListener cameraDeviceStateListener) {
        synchronized (this) {
            this.mCurrentHandler = handler;
            this.mCurrentListener = cameraDeviceStateListener;
        }
    }

    public boolean setCaptureResult(final RequestHolder requestHolder, final CameraMetadataNative cameraMetadataNative, final int i) {
        boolean z = true;
        synchronized (this) {
            if (this.mCurrentState != 4) {
                Log.e(TAG, "Cannot receive result while in state: " + this.mCurrentState);
                this.mCurrentError = 1;
                doStateTransition(0);
                if (this.mCurrentError != -1) {
                    z = false;
                }
            } else {
                if (this.mCurrentHandler != null && this.mCurrentListener != null) {
                    if (i != -1) {
                        this.mCurrentHandler.post(new Runnable() { // from class: android.hardware.camera2.legacy.CameraDeviceState.1
                            @Override // java.lang.Runnable
                            public void run() {
                                CameraDeviceState.this.mCurrentListener.onError(i, requestHolder);
                            }
                        });
                    } else {
                        this.mCurrentHandler.post(new Runnable() { // from class: android.hardware.camera2.legacy.CameraDeviceState.2
                            @Override // java.lang.Runnable
                            public void run() {
                                CameraDeviceState.this.mCurrentListener.onCaptureResult(cameraMetadataNative, requestHolder);
                            }
                        });
                    }
                }
                if (this.mCurrentError != -1) {
                    z = false;
                }
            }
        }
        return z;
    }

    public boolean setCaptureStart(RequestHolder requestHolder, long j, int i) {
        boolean z;
        synchronized (this) {
            this.mCurrentRequest = requestHolder;
            doStateTransition(4, j, i);
            z = this.mCurrentError == -1;
        }
        return z;
    }

    public boolean setConfiguring() {
        boolean z;
        synchronized (this) {
            doStateTransition(2);
            z = this.mCurrentError == -1;
        }
        return z;
    }

    public void setError(int i) {
        synchronized (this) {
            this.mCurrentError = i;
            doStateTransition(0);
        }
    }

    public boolean setIdle() {
        boolean z;
        synchronized (this) {
            doStateTransition(3);
            z = this.mCurrentError == -1;
        }
        return z;
    }
}
