package android.hardware.usb;

import android.os.ParcelFileDescriptor;
import java.io.FileDescriptor;

/* loaded from: source-9557208-dex2jar.jar:android/hardware/usb/UsbDeviceConnection.class */
public class UsbDeviceConnection {
    private static final String TAG = "UsbDeviceConnection";
    private final UsbDevice mDevice;
    private long mNativeContext;

    public UsbDeviceConnection(UsbDevice usbDevice) {
        this.mDevice = usbDevice;
    }

    private static void checkBounds(byte[] bArr, int i, int i2) {
        int length = bArr != null ? bArr.length : 0;
        if (i < 0 || i + i2 > length) {
            throw new IllegalArgumentException("Buffer start or length out of bounds.");
        }
    }

    private native int native_bulk_request(int i, byte[] bArr, int i2, int i3, int i4);

    private native boolean native_claim_interface(int i, boolean z);

    private native void native_close();

    private native int native_control_request(int i, int i2, int i3, int i4, byte[] bArr, int i5, int i6, int i7);

    private native byte[] native_get_desc();

    private native int native_get_fd();

    private native String native_get_serial();

    private native boolean native_open(String str, FileDescriptor fileDescriptor);

    private native boolean native_release_interface(int i);

    private native UsbRequest native_request_wait();

    private native boolean native_set_configuration(int i);

    private native boolean native_set_interface(int i, int i2);

    public int bulkTransfer(UsbEndpoint usbEndpoint, byte[] bArr, int i, int i2) {
        return bulkTransfer(usbEndpoint, bArr, 0, i, i2);
    }

    public int bulkTransfer(UsbEndpoint usbEndpoint, byte[] bArr, int i, int i2, int i3) {
        checkBounds(bArr, i, i2);
        return native_bulk_request(usbEndpoint.getAddress(), bArr, i, i2, i3);
    }

    public boolean claimInterface(UsbInterface usbInterface, boolean z) {
        return native_claim_interface(usbInterface.getId(), z);
    }

    public void close() {
        native_close();
    }

    public int controlTransfer(int i, int i2, int i3, int i4, byte[] bArr, int i5, int i6) {
        return controlTransfer(i, i2, i3, i4, bArr, 0, i5, i6);
    }

    public int controlTransfer(int i, int i2, int i3, int i4, byte[] bArr, int i5, int i6, int i7) {
        checkBounds(bArr, i5, i6);
        return native_control_request(i, i2, i3, i4, bArr, i5, i6, i7);
    }

    public int getFileDescriptor() {
        return native_get_fd();
    }

    public byte[] getRawDescriptors() {
        return native_get_desc();
    }

    public String getSerial() {
        return native_get_serial();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean open(String str, ParcelFileDescriptor parcelFileDescriptor) {
        return native_open(str, parcelFileDescriptor.getFileDescriptor());
    }

    public boolean releaseInterface(UsbInterface usbInterface) {
        return native_release_interface(usbInterface.getId());
    }

    public UsbRequest requestWait() {
        UsbRequest native_request_wait = native_request_wait();
        if (native_request_wait != null) {
            native_request_wait.dequeue();
        }
        return native_request_wait;
    }

    public boolean setConfiguration(UsbConfiguration usbConfiguration) {
        return native_set_configuration(usbConfiguration.getId());
    }

    public boolean setInterface(UsbInterface usbInterface) {
        return native_set_interface(usbInterface.getId(), usbInterface.getAlternateSetting());
    }
}
