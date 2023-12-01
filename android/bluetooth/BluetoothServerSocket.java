package android.bluetooth;

import android.os.Handler;
import android.os.ParcelUuid;
import java.io.Closeable;
import java.io.IOException;

/* loaded from: source-9557208-dex2jar.jar:android/bluetooth/BluetoothServerSocket.class */
public final class BluetoothServerSocket implements Closeable {
    private final int mChannel;
    private Handler mHandler;
    private int mMessage;
    final BluetoothSocket mSocket;

    /* JADX INFO: Access modifiers changed from: package-private */
    public BluetoothServerSocket(int i, boolean z, boolean z2, int i2) throws IOException {
        this.mChannel = i2;
        this.mSocket = new BluetoothSocket(i, -1, z, z2, null, i2, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public BluetoothServerSocket(int i, boolean z, boolean z2, ParcelUuid parcelUuid) throws IOException {
        this.mSocket = new BluetoothSocket(i, -1, z, z2, null, -1, parcelUuid);
        this.mChannel = this.mSocket.getPort();
    }

    public BluetoothSocket accept() throws IOException {
        return accept(-1);
    }

    public BluetoothSocket accept(int i) throws IOException {
        return this.mSocket.accept(i);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        synchronized (this) {
            if (this.mHandler != null) {
                this.mHandler.obtainMessage(this.mMessage).sendToTarget();
            }
        }
        this.mSocket.close();
    }

    public int getChannel() {
        return this.mChannel;
    }

    void setCloseHandler(Handler handler, int i) {
        synchronized (this) {
            this.mHandler = handler;
            this.mMessage = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setServiceName(String str) {
        this.mSocket.setServiceName(str);
    }
}
