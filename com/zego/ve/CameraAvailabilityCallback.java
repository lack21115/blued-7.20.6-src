package com.zego.ve;

import android.hardware.camera2.CameraManager;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: source-8829756-dex2jar.jar:com/zego/ve/CameraAvailabilityCallback.class */
public class CameraAvailabilityCallback extends CameraManager.AvailabilityCallback {
    private String mCameraId;
    private boolean mIsFirstTime;
    private Listener mListener;
    private final AtomicLong mThis;

    /* loaded from: source-8829756-dex2jar.jar:com/zego/ve/CameraAvailabilityCallback$Listener.class */
    public interface Listener {
        void onCameraAvailable(long j, String str);

        void onCameraUnavailable(long j, String str);
    }

    public CameraAvailabilityCallback(long j, int i, Listener listener) {
        AtomicLong atomicLong = new AtomicLong();
        this.mThis = atomicLong;
        this.mCameraId = null;
        this.mIsFirstTime = false;
        atomicLong.set(j);
        this.mListener = listener;
        this.mCameraId = String.valueOf(i);
        this.mIsFirstTime = true;
    }

    @Override // android.hardware.camera2.CameraManager.AvailabilityCallback
    public void onCameraAvailable(String str) {
        long j = this.mThis.get();
        if (j == 0 || !str.equals(this.mCameraId)) {
            return;
        }
        if (this.mIsFirstTime) {
            this.mIsFirstTime = false;
        } else {
            this.mListener.onCameraAvailable(j, str);
        }
    }

    @Override // android.hardware.camera2.CameraManager.AvailabilityCallback
    public void onCameraUnavailable(String str) {
        long j = this.mThis.get();
        if (j == 0 || !str.equals(this.mCameraId)) {
            return;
        }
        if (this.mIsFirstTime) {
            this.mIsFirstTime = false;
        } else {
            this.mListener.onCameraUnavailable(j, str);
        }
    }

    public void uninit() {
        this.mThis.set(0L);
    }
}
