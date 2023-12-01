package android.hardware.hdmi;

import android.hardware.hdmi.IHdmiControlCallback;
import android.os.RemoteException;
import android.util.Log;

/* loaded from: source-9557208-dex2jar.jar:android/hardware/hdmi/HdmiPlaybackClient.class */
public final class HdmiPlaybackClient extends HdmiClient {
    private static final String TAG = "HdmiPlaybackClient";

    /* loaded from: source-9557208-dex2jar.jar:android/hardware/hdmi/HdmiPlaybackClient$DisplayStatusCallback.class */
    public interface DisplayStatusCallback {
        void onComplete(int i);
    }

    /* loaded from: source-9557208-dex2jar.jar:android/hardware/hdmi/HdmiPlaybackClient$OneTouchPlayCallback.class */
    public interface OneTouchPlayCallback {
        void onComplete(int i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public HdmiPlaybackClient(IHdmiControlService iHdmiControlService) {
        super(iHdmiControlService);
    }

    private IHdmiControlCallback getCallbackWrapper(final DisplayStatusCallback displayStatusCallback) {
        return new IHdmiControlCallback.Stub() { // from class: android.hardware.hdmi.HdmiPlaybackClient.2
            @Override // android.hardware.hdmi.IHdmiControlCallback
            public void onComplete(int i) {
                displayStatusCallback.onComplete(i);
            }
        };
    }

    private IHdmiControlCallback getCallbackWrapper(final OneTouchPlayCallback oneTouchPlayCallback) {
        return new IHdmiControlCallback.Stub() { // from class: android.hardware.hdmi.HdmiPlaybackClient.1
            @Override // android.hardware.hdmi.IHdmiControlCallback
            public void onComplete(int i) {
                oneTouchPlayCallback.onComplete(i);
            }
        };
    }

    @Override // android.hardware.hdmi.HdmiClient
    public int getDeviceType() {
        return 4;
    }

    public void oneTouchPlay(OneTouchPlayCallback oneTouchPlayCallback) {
        try {
            this.mService.oneTouchPlay(getCallbackWrapper(oneTouchPlayCallback));
        } catch (RemoteException e) {
            Log.e(TAG, "oneTouchPlay threw exception ", e);
        }
    }

    public void queryDisplayStatus(DisplayStatusCallback displayStatusCallback) {
        try {
            this.mService.queryDisplayStatus(getCallbackWrapper(displayStatusCallback));
        } catch (RemoteException e) {
            Log.e(TAG, "queryDisplayStatus threw exception ", e);
        }
    }
}
