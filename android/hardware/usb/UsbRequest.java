package android.hardware.usb;

import android.util.Log;
import java.nio.ByteBuffer;

/* loaded from: source-9557208-dex2jar.jar:android/hardware/usb/UsbRequest.class */
public class UsbRequest {
    private static final String TAG = "UsbRequest";
    private ByteBuffer mBuffer;
    private Object mClientData;
    private UsbEndpoint mEndpoint;
    private int mLength;
    private long mNativeContext;

    private native boolean native_cancel();

    private native void native_close();

    private native int native_dequeue_array(byte[] bArr, int i, boolean z);

    private native int native_dequeue_direct();

    private native boolean native_init(UsbDeviceConnection usbDeviceConnection, int i, int i2, int i3, int i4);

    private native boolean native_queue_array(byte[] bArr, int i, boolean z);

    private native boolean native_queue_direct(ByteBuffer byteBuffer, int i, boolean z);

    public boolean cancel() {
        return native_cancel();
    }

    public void close() {
        this.mEndpoint = null;
        native_close();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void dequeue() {
        int native_dequeue_direct = this.mBuffer.isDirect() ? native_dequeue_direct() : native_dequeue_array(this.mBuffer.array(), this.mLength, this.mEndpoint.getDirection() == 0);
        if (native_dequeue_direct >= 0) {
            this.mBuffer.position(Math.min(native_dequeue_direct, this.mLength));
        }
        this.mBuffer = null;
        this.mLength = 0;
    }

    protected void finalize() throws Throwable {
        try {
            if (this.mEndpoint != null) {
                Log.v(TAG, "endpoint still open in finalize(): " + this);
                close();
            }
        } finally {
            super.finalize();
        }
    }

    public Object getClientData() {
        return this.mClientData;
    }

    public UsbEndpoint getEndpoint() {
        return this.mEndpoint;
    }

    public boolean initialize(UsbDeviceConnection usbDeviceConnection, UsbEndpoint usbEndpoint) {
        this.mEndpoint = usbEndpoint;
        return native_init(usbDeviceConnection, usbEndpoint.getAddress(), usbEndpoint.getAttributes(), usbEndpoint.getMaxPacketSize(), usbEndpoint.getInterval());
    }

    public boolean queue(ByteBuffer byteBuffer, int i) {
        boolean native_queue_array;
        boolean z = this.mEndpoint.getDirection() == 0;
        if (byteBuffer.isDirect()) {
            native_queue_array = native_queue_direct(byteBuffer, i, z);
        } else if (!byteBuffer.hasArray()) {
            throw new IllegalArgumentException("buffer is not direct and has no array");
        } else {
            native_queue_array = native_queue_array(byteBuffer.array(), i, z);
        }
        if (native_queue_array) {
            this.mBuffer = byteBuffer;
            this.mLength = i;
        }
        return native_queue_array;
    }

    public void setClientData(Object obj) {
        this.mClientData = obj;
    }
}
