package android.hardware.hdmi;

import android.hardware.hdmi.HdmiControlManager;
import android.hardware.hdmi.IHdmiVendorCommandListener;
import android.os.RemoteException;
import android.util.Log;

/* loaded from: source-9557208-dex2jar.jar:android/hardware/hdmi/HdmiClient.class */
public abstract class HdmiClient {
    private static final String TAG = "HdmiClient";
    private IHdmiVendorCommandListener mIHdmiVendorCommandListener;
    final IHdmiControlService mService;

    /* JADX INFO: Access modifiers changed from: package-private */
    public HdmiClient(IHdmiControlService iHdmiControlService) {
        this.mService = iHdmiControlService;
    }

    private static IHdmiVendorCommandListener getListenerWrapper(final HdmiControlManager.VendorCommandListener vendorCommandListener) {
        return new IHdmiVendorCommandListener.Stub() { // from class: android.hardware.hdmi.HdmiClient.1
            @Override // android.hardware.hdmi.IHdmiVendorCommandListener
            public void onControlStateChanged(boolean z, int i) {
                HdmiControlManager.VendorCommandListener.this.onControlStateChanged(z, i);
            }

            @Override // android.hardware.hdmi.IHdmiVendorCommandListener
            public void onReceived(int i, int i2, byte[] bArr, boolean z) {
                HdmiControlManager.VendorCommandListener.this.onReceived(i, i2, bArr, z);
            }
        };
    }

    public HdmiDeviceInfo getActiveSource() {
        try {
            return this.mService.getActiveSource();
        } catch (RemoteException e) {
            Log.e(TAG, "getActiveSource threw exception ", e);
            return null;
        }
    }

    abstract int getDeviceType();

    public void sendKeyEvent(int i, boolean z) {
        try {
            this.mService.sendKeyEvent(getDeviceType(), i, z);
        } catch (RemoteException e) {
            Log.e(TAG, "sendKeyEvent threw exception ", e);
        }
    }

    public void sendVendorCommand(int i, byte[] bArr, boolean z) {
        try {
            this.mService.sendVendorCommand(getDeviceType(), i, bArr, z);
        } catch (RemoteException e) {
            Log.e(TAG, "failed to send vendor command: ", e);
        }
    }

    public void setVendorCommandListener(HdmiControlManager.VendorCommandListener vendorCommandListener) {
        if (vendorCommandListener == null) {
            throw new IllegalArgumentException("listener cannot be null");
        }
        if (this.mIHdmiVendorCommandListener != null) {
            throw new IllegalStateException("listener was already set");
        }
        try {
            IHdmiVendorCommandListener listenerWrapper = getListenerWrapper(vendorCommandListener);
            this.mService.addVendorCommandListener(listenerWrapper, getDeviceType());
            this.mIHdmiVendorCommandListener = listenerWrapper;
        } catch (RemoteException e) {
            Log.e(TAG, "failed to set vendor command listener: ", e);
        }
    }
}
