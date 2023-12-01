package android.mtp;

import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbDeviceConnection;

/* loaded from: source-9557208-dex2jar.jar:android/mtp/MtpDevice.class */
public final class MtpDevice {
    private static final String TAG = "MtpDevice";
    private final UsbDevice mDevice;
    private long mNativeContext;

    static {
        System.loadLibrary("media_jni");
    }

    public MtpDevice(UsbDevice usbDevice) {
        this.mDevice = usbDevice;
    }

    private native void native_close();

    private native boolean native_delete_object(int i);

    private native MtpDeviceInfo native_get_device_info();

    private native byte[] native_get_object(int i, int i2);

    private native int[] native_get_object_handles(int i, int i2, int i3);

    private native MtpObjectInfo native_get_object_info(int i);

    private native long native_get_parent(int i);

    private native long native_get_storage_id(int i);

    private native int[] native_get_storage_ids();

    private native MtpStorageInfo native_get_storage_info(int i);

    private native byte[] native_get_thumbnail(int i);

    private native boolean native_import_file(int i, String str);

    private native boolean native_open(String str, int i);

    public void close() {
        native_close();
    }

    public boolean deleteObject(int i) {
        return native_delete_object(i);
    }

    protected void finalize() throws Throwable {
        try {
            native_close();
        } finally {
            super.finalize();
        }
    }

    public int getDeviceId() {
        return this.mDevice.getDeviceId();
    }

    public MtpDeviceInfo getDeviceInfo() {
        return native_get_device_info();
    }

    public String getDeviceName() {
        return this.mDevice.getDeviceName();
    }

    public byte[] getObject(int i, int i2) {
        return native_get_object(i, i2);
    }

    public int[] getObjectHandles(int i, int i2, int i3) {
        return native_get_object_handles(i, i2, i3);
    }

    public MtpObjectInfo getObjectInfo(int i) {
        return native_get_object_info(i);
    }

    public long getParent(int i) {
        return native_get_parent(i);
    }

    public long getStorageId(int i) {
        return native_get_storage_id(i);
    }

    public int[] getStorageIds() {
        return native_get_storage_ids();
    }

    public MtpStorageInfo getStorageInfo(int i) {
        return native_get_storage_info(i);
    }

    public byte[] getThumbnail(int i) {
        return native_get_thumbnail(i);
    }

    public boolean importFile(int i, String str) {
        return native_import_file(i, str);
    }

    public boolean open(UsbDeviceConnection usbDeviceConnection) {
        boolean native_open = native_open(this.mDevice.getDeviceName(), usbDeviceConnection.getFileDescriptor());
        if (!native_open) {
            usbDeviceConnection.close();
        }
        return native_open;
    }

    public String toString() {
        return this.mDevice.getDeviceName();
    }
}
