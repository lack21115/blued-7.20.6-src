package android.hardware;

import android.content.Context;
import android.os.ParcelFileDescriptor;
import android.os.RemoteException;
import android.util.Log;
import java.io.IOException;

/* loaded from: source-9557208-dex2jar.jar:android/hardware/SerialManager.class */
public class SerialManager {
    private static final String TAG = "SerialManager";
    private final Context mContext;
    private final ISerialManager mService;

    public SerialManager(Context context, ISerialManager iSerialManager) {
        this.mContext = context;
        this.mService = iSerialManager;
    }

    public String[] getSerialPorts() {
        try {
            return this.mService.getSerialPorts();
        } catch (RemoteException e) {
            Log.e(TAG, "RemoteException in getSerialPorts", e);
            return null;
        }
    }

    public SerialPort openSerialPort(String str, int i) throws IOException {
        try {
            ParcelFileDescriptor openSerialPort = this.mService.openSerialPort(str);
            if (openSerialPort != null) {
                SerialPort serialPort = new SerialPort(str);
                serialPort.open(openSerialPort, i);
                return serialPort;
            }
            throw new IOException("Could not open serial port " + str);
        } catch (RemoteException e) {
            Log.e(TAG, "exception in UsbManager.openDevice", e);
            return null;
        }
    }
}
