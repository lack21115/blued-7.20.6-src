package android.bluetooth;

import android.net.LocalSocket;
import android.os.ParcelFileDescriptor;
import android.os.ParcelUuid;
import android.os.RemoteException;
import android.util.Log;
import java.io.Closeable;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Locale;
import java.util.UUID;

/* loaded from: source-9557208-dex2jar.jar:android/bluetooth/BluetoothSocket.class */
public final class BluetoothSocket implements Closeable {
    static final int EADDRINUSE = 98;
    static final int EBADFD = 77;
    public static final int MAX_RFCOMM_CHANNEL = 30;
    static final int SEC_FLAG_AUTH = 2;
    static final int SEC_FLAG_ENCRYPT = 1;
    static final int TYPE_L2CAP = 3;
    static final int TYPE_RFCOMM = 1;
    static final int TYPE_SCO = 2;
    private String mAddress;
    private final boolean mAuth;
    private BluetoothDevice mDevice;
    private final boolean mEncrypt;
    private int mFd;
    private final BluetoothInputStream mInputStream;
    private final BluetoothOutputStream mOutputStream;
    private ParcelFileDescriptor mPfd;
    private int mPort;
    private String mServiceName;
    private LocalSocket mSocket;
    private InputStream mSocketIS;
    private OutputStream mSocketOS;
    private volatile SocketState mSocketState;
    private final int mType;
    private final ParcelUuid mUuid;
    private static final String TAG = "BluetoothSocket";
    private static final boolean DBG = Log.isLoggable(TAG, 3);
    private static final boolean VDBG = Log.isLoggable(TAG, 2);
    private static int PROXY_CONNECTION_TIMEOUT = 5000;
    private static int SOCK_SIGNAL_SIZE = 16;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: source-9557208-dex2jar.jar:android/bluetooth/BluetoothSocket$SocketState.class */
    public enum SocketState {
        INIT,
        CONNECTED,
        LISTENING,
        CLOSED
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public BluetoothSocket(int i, int i2, boolean z, boolean z2, BluetoothDevice bluetoothDevice, int i3, ParcelUuid parcelUuid) throws IOException {
        if (i == 1 && parcelUuid == null && i2 == -1 && (i3 < 1 || i3 > 30)) {
            throw new IOException("Invalid RFCOMM channel: " + i3);
        }
        if (parcelUuid != null) {
            this.mUuid = parcelUuid;
        } else {
            this.mUuid = new ParcelUuid(new UUID(0L, 0L));
        }
        this.mType = i;
        this.mAuth = z;
        this.mEncrypt = z2;
        this.mDevice = bluetoothDevice;
        this.mPort = i3;
        this.mFd = i2;
        this.mSocketState = SocketState.INIT;
        if (bluetoothDevice == null) {
            this.mAddress = BluetoothAdapter.getDefaultAdapter().getAddress();
        } else {
            this.mAddress = bluetoothDevice.getAddress();
        }
        this.mInputStream = new BluetoothInputStream(this);
        this.mOutputStream = new BluetoothOutputStream(this);
    }

    private BluetoothSocket(int i, int i2, boolean z, boolean z2, String str, int i3) throws IOException {
        this(i, i2, z, z2, new BluetoothDevice(str), i3, null);
    }

    private BluetoothSocket(BluetoothSocket bluetoothSocket) {
        this.mUuid = bluetoothSocket.mUuid;
        this.mType = bluetoothSocket.mType;
        this.mAuth = bluetoothSocket.mAuth;
        this.mEncrypt = bluetoothSocket.mEncrypt;
        this.mPort = bluetoothSocket.mPort;
        this.mInputStream = new BluetoothInputStream(this);
        this.mOutputStream = new BluetoothOutputStream(this);
        this.mServiceName = bluetoothSocket.mServiceName;
    }

    private BluetoothSocket acceptSocket(String str) throws IOException {
        BluetoothSocket bluetoothSocket = new BluetoothSocket(this);
        bluetoothSocket.mSocketState = SocketState.CONNECTED;
        FileDescriptor[] ancillaryFileDescriptors = this.mSocket.getAncillaryFileDescriptors();
        if (DBG) {
            Log.d(TAG, "socket fd passed by stack  fds: " + ancillaryFileDescriptors);
        }
        if (ancillaryFileDescriptors == null || ancillaryFileDescriptors.length != 1) {
            Log.e(TAG, "socket fd passed from stack failed, fds: " + ancillaryFileDescriptors);
            bluetoothSocket.close();
            throw new IOException("bt socket acept failed");
        }
        bluetoothSocket.mSocket = new LocalSocket(ancillaryFileDescriptors[0]);
        try {
            bluetoothSocket.mSocket.closeExternalFd();
        } catch (IOException e) {
            Log.e(TAG, "closeExternalFd failed");
        }
        bluetoothSocket.mSocketIS = bluetoothSocket.mSocket.getInputStream();
        bluetoothSocket.mSocketOS = bluetoothSocket.mSocket.getOutputStream();
        bluetoothSocket.mAddress = str;
        bluetoothSocket.mDevice = BluetoothAdapter.getDefaultAdapter().getRemoteDevice(str);
        bluetoothSocket.mPort = this.mPort;
        return bluetoothSocket;
    }

    private String convertAddr(byte[] bArr) {
        return String.format(Locale.US, "%02X:%02X:%02X:%02X:%02X:%02X", Byte.valueOf(bArr[0]), Byte.valueOf(bArr[1]), Byte.valueOf(bArr[2]), Byte.valueOf(bArr[3]), Byte.valueOf(bArr[4]), Byte.valueOf(bArr[5]));
    }

    private int getSecurityFlags() {
        int i = 0;
        if (this.mAuth) {
            i = 0 | 2;
        }
        int i2 = i;
        if (this.mEncrypt) {
            i2 = i | 1;
        }
        return i2;
    }

    private int readAll(InputStream inputStream, byte[] bArr) throws IOException {
        int length = bArr.length;
        while (length > 0) {
            int read = inputStream.read(bArr, bArr.length - length, length);
            if (read <= 0) {
                throw new IOException("read failed, socket might closed or timeout, read ret: " + read);
            }
            int i = length - read;
            length = i;
            if (i != 0) {
                Log.w(TAG, "readAll() looping, read partial size: " + (bArr.length - i) + ", expect size: " + bArr.length);
                length = i;
            }
        }
        return bArr.length;
    }

    private int readInt(InputStream inputStream) throws IOException {
        byte[] bArr = new byte[4];
        int readAll = readAll(inputStream, bArr);
        if (VDBG) {
            Log.d(TAG, "inputStream.read ret: " + readAll);
        }
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        wrap.order(ByteOrder.nativeOrder());
        return wrap.getInt();
    }

    private String waitSocketSignal(InputStream inputStream) throws IOException {
        byte[] bArr = new byte[SOCK_SIGNAL_SIZE];
        int readAll = readAll(inputStream, bArr);
        if (VDBG) {
            Log.d(TAG, "waitSocketSignal read 16 bytes signal ret: " + readAll);
        }
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        wrap.order(ByteOrder.nativeOrder());
        short s = wrap.getShort();
        if (s != SOCK_SIGNAL_SIZE) {
            throw new IOException("Connection failure, wrong signal size: " + ((int) s));
        }
        byte[] bArr2 = new byte[6];
        wrap.get(bArr2);
        int i = wrap.getInt();
        int i2 = wrap.getInt();
        String convertAddr = convertAddr(bArr2);
        if (VDBG) {
            Log.d(TAG, "waitSocketSignal: sig size: " + ((int) s) + ", remote addr: " + convertAddr + ", channel: " + i + ", status: " + i2);
        }
        if (i2 != 0) {
            throw new IOException("Connection failure, status: " + i2);
        }
        return convertAddr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public BluetoothSocket accept(int i) throws IOException {
        BluetoothSocket acceptSocket;
        if (this.mSocketState != SocketState.LISTENING) {
            throw new IOException("bt socket is not in listen state");
        }
        if (i > 0) {
            Log.d(TAG, "accept() set timeout (ms):" + i);
            this.mSocket.setSoTimeout(i);
        }
        String waitSocketSignal = waitSocketSignal(this.mSocketIS);
        if (i > 0) {
            this.mSocket.setSoTimeout(0);
        }
        synchronized (this) {
            if (this.mSocketState != SocketState.LISTENING) {
                throw new IOException("bt socket is not in listen state");
            }
            acceptSocket = acceptSocket(waitSocketSignal);
        }
        return acceptSocket;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int available() throws IOException {
        if (VDBG) {
            Log.d(TAG, "available: " + this.mSocketIS);
        }
        return this.mSocketIS.available();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int bindListen() {
        if (this.mSocketState == SocketState.CLOSED) {
            return 77;
        }
        IBluetooth bluetoothService = BluetoothAdapter.getDefaultAdapter().getBluetoothService(null);
        if (bluetoothService == null) {
            Log.e(TAG, "bindListen fail, reason: bluetooth is off");
            return -1;
        }
        try {
            this.mPfd = bluetoothService.createSocketChannel(this.mType, this.mServiceName, this.mUuid, this.mPort, getSecurityFlags());
            try {
                synchronized (this) {
                    if (DBG) {
                        Log.d(TAG, "bindListen(), SocketState: " + this.mSocketState + ", mPfd: " + this.mPfd);
                    }
                    if (this.mSocketState != SocketState.INIT) {
                        return 77;
                    }
                    if (this.mPfd == null) {
                        return -1;
                    }
                    FileDescriptor fileDescriptor = this.mPfd.getFileDescriptor();
                    if (DBG) {
                        Log.d(TAG, "bindListen(), new LocalSocket ");
                    }
                    this.mSocket = new LocalSocket(fileDescriptor);
                    if (DBG) {
                        Log.d(TAG, "bindListen(), new LocalSocket.getInputStream() ");
                    }
                    this.mSocketIS = this.mSocket.getInputStream();
                    this.mSocketOS = this.mSocket.getOutputStream();
                    if (DBG) {
                        Log.d(TAG, "bindListen(), readInt mSocketIS: " + this.mSocketIS);
                    }
                    int readInt = readInt(this.mSocketIS);
                    synchronized (this) {
                        if (this.mSocketState == SocketState.INIT) {
                            this.mSocketState = SocketState.LISTENING;
                        }
                    }
                    if (DBG) {
                        Log.d(TAG, "channel: " + readInt);
                    }
                    if (this.mPort == -1) {
                        this.mPort = readInt;
                        return 0;
                    }
                    return 0;
                }
            } catch (IOException e) {
                if (this.mPfd != null) {
                    try {
                        this.mPfd.close();
                    } catch (IOException e2) {
                        Log.e(TAG, "bindListen, close mPfd: " + e2);
                    }
                    this.mPfd = null;
                }
                Log.e(TAG, "bindListen, fail to get port number, exception: " + e);
                return -1;
            }
        } catch (RemoteException e3) {
            Log.e(TAG, Log.getStackTraceString(new Throwable()));
            return -1;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (DBG) {
            Log.d(TAG, "close() in, this: " + this + ", channel: " + this.mPort + ", state: " + this.mSocketState);
        }
        if (this.mSocketState == SocketState.CLOSED) {
            return;
        }
        synchronized (this) {
            if (this.mSocketState == SocketState.CLOSED) {
                return;
            }
            this.mSocketState = SocketState.CLOSED;
            if (DBG) {
                Log.d(TAG, "close() this: " + this + ", channel: " + this.mPort + ", mSocketIS: " + this.mSocketIS + ", mSocketOS: " + this.mSocketOS + "mSocket: " + this.mSocket);
            }
            if (this.mSocket != null) {
                if (DBG) {
                    Log.d(TAG, "Closing mSocket: " + this.mSocket);
                }
                this.mSocket.shutdownInput();
                this.mSocket.shutdownOutput();
                this.mSocket.close();
                this.mSocket = null;
            }
            if (this.mPfd != null) {
                this.mPfd.close();
                this.mPfd = null;
            }
        }
    }

    public void connect() throws IOException {
        if (this.mDevice == null) {
            throw new IOException("Connect is called on null device");
        }
        try {
            if (this.mSocketState == SocketState.CLOSED) {
                throw new IOException("socket closed");
            }
            IBluetooth bluetoothService = BluetoothAdapter.getDefaultAdapter().getBluetoothService(null);
            if (bluetoothService == null) {
                throw new IOException("Bluetooth is off");
            }
            this.mPfd = bluetoothService.connectSocket(this.mDevice, this.mType, this.mUuid, this.mPort, getSecurityFlags());
            synchronized (this) {
                if (DBG) {
                    Log.d(TAG, "connect(), SocketState: " + this.mSocketState + ", mPfd: " + this.mPfd);
                }
                if (this.mSocketState == SocketState.CLOSED) {
                    throw new IOException("socket closed");
                }
                if (this.mPfd == null) {
                    throw new IOException("bt socket connect failed");
                }
                this.mSocket = new LocalSocket(this.mPfd.getFileDescriptor());
                this.mSocketIS = this.mSocket.getInputStream();
                this.mSocketOS = this.mSocket.getOutputStream();
            }
            int readInt = readInt(this.mSocketIS);
            if (readInt <= 0) {
                throw new IOException("bt socket connect failed");
            }
            this.mPort = readInt;
            waitSocketSignal(this.mSocketIS);
            synchronized (this) {
                if (this.mSocketState == SocketState.CLOSED) {
                    throw new IOException("bt socket closed");
                }
                this.mSocketState = SocketState.CONNECTED;
            }
        } catch (RemoteException e) {
            Log.e(TAG, Log.getStackTraceString(new Throwable()));
            throw new IOException("unable to send RPC: " + e.getMessage());
        }
    }

    protected void finalize() throws Throwable {
        try {
            close();
        } finally {
            super.finalize();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void flush() throws IOException {
        if (this.mSocketOS == null) {
            throw new IOException("flush is called on null OutputStream");
        }
        if (VDBG) {
            Log.d(TAG, "flush: " + this.mSocketOS);
        }
        this.mSocketOS.flush();
    }

    public InputStream getInputStream() throws IOException {
        return this.mInputStream;
    }

    public OutputStream getOutputStream() throws IOException {
        return this.mOutputStream;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getPort() {
        return this.mPort;
    }

    public BluetoothDevice getRemoteDevice() {
        return this.mDevice;
    }

    public int getSocketOpt(int i, byte[] bArr) throws IOException {
        if (this.mSocketState == SocketState.CLOSED) {
            throw new IOException("socket closed");
        }
        IBluetooth bluetoothService = BluetoothAdapter.getDefaultAdapter().getBluetoothService(null);
        if (bluetoothService == null) {
            Log.e(TAG, "getSocketOpt fail, reason: bluetooth is off");
            return -1;
        }
        try {
            if (VDBG) {
                Log.d(TAG, "getSocketOpt(), mType: " + this.mType + " mPort: " + this.mPort);
            }
            return bluetoothService.getSocketOpt(this.mType, this.mPort, i, bArr);
        } catch (RemoteException e) {
            Log.e(TAG, Log.getStackTraceString(new Throwable()));
            return -1;
        }
    }

    public boolean isConnected() {
        return this.mSocketState == SocketState.CONNECTED;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int read(byte[] bArr, int i, int i2) throws IOException {
        if (this.mSocketIS == null) {
            throw new IOException("read is called on null InputStream");
        }
        if (VDBG) {
            Log.d(TAG, "read in:  " + this.mSocketIS + " len: " + i2);
        }
        int read = this.mSocketIS.read(bArr, i, i2);
        if (read < 0) {
            throw new IOException("bt socket closed, read return: " + read);
        }
        if (VDBG) {
            Log.d(TAG, "read out:  " + this.mSocketIS + " ret: " + read);
        }
        return read;
    }

    void removeChannel() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setServiceName(String str) {
        this.mServiceName = str;
    }

    public int setSocketOpt(int i, byte[] bArr, int i2) throws IOException {
        if (this.mSocketState == SocketState.CLOSED) {
            throw new IOException("socket closed");
        }
        IBluetooth bluetoothService = BluetoothAdapter.getDefaultAdapter().getBluetoothService(null);
        if (bluetoothService == null) {
            Log.e(TAG, "setSocketOpt fail, reason: bluetooth is off");
            return -1;
        }
        try {
            if (VDBG) {
                Log.d(TAG, "setSocketOpt(), mType: " + this.mType + " mPort: " + this.mPort);
            }
            return bluetoothService.setSocketOpt(this.mType, this.mPort, i, bArr, i2);
        } catch (RemoteException e) {
            Log.e(TAG, Log.getStackTraceString(new Throwable()));
            return -1;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int write(byte[] bArr, int i, int i2) throws IOException {
        if (this.mSocketOS == null) {
            throw new IOException("write is called on null OutputStream");
        }
        if (VDBG) {
            Log.d(TAG, "write: " + this.mSocketOS + " length: " + i2);
        }
        this.mSocketOS.write(bArr, i, i2);
        if (VDBG) {
            Log.d(TAG, "write out: " + this.mSocketOS + " length: " + i2);
        }
        return i2;
    }
}
