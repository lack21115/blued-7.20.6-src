package android.os;

import android.os.IBinder;
import java.net.InetSocketAddress;
import java.util.NoSuchElementException;

/* loaded from: source-9557208-dex2jar.jar:android/os/CommonTimeConfig.class */
public class CommonTimeConfig {
    public static final int ERROR = -1;
    public static final int ERROR_BAD_VALUE = -4;
    public static final int ERROR_DEAD_OBJECT = -7;
    public static final long INVALID_GROUP_ID = -1;
    private static final int METHOD_FORCE_NETWORKLESS_MASTER_MODE = 17;
    private static final int METHOD_GET_AUTO_DISABLE = 15;
    private static final int METHOD_GET_CLIENT_SYNC_INTERVAL = 11;
    private static final int METHOD_GET_INTERFACE_BINDING = 7;
    private static final int METHOD_GET_MASTER_ANNOUNCE_INTERVAL = 9;
    private static final int METHOD_GET_MASTER_ELECTION_ENDPOINT = 3;
    private static final int METHOD_GET_MASTER_ELECTION_GROUP_ID = 5;
    private static final int METHOD_GET_MASTER_ELECTION_PRIORITY = 1;
    private static final int METHOD_GET_PANIC_THRESHOLD = 13;
    private static final int METHOD_SET_AUTO_DISABLE = 16;
    private static final int METHOD_SET_CLIENT_SYNC_INTERVAL = 12;
    private static final int METHOD_SET_INTERFACE_BINDING = 8;
    private static final int METHOD_SET_MASTER_ANNOUNCE_INTERVAL = 10;
    private static final int METHOD_SET_MASTER_ELECTION_ENDPOINT = 4;
    private static final int METHOD_SET_MASTER_ELECTION_GROUP_ID = 6;
    private static final int METHOD_SET_MASTER_ELECTION_PRIORITY = 2;
    private static final int METHOD_SET_PANIC_THRESHOLD = 14;
    public static final String SERVICE_NAME = "common_time.config";
    public static final int SUCCESS = 0;
    private String mInterfaceDesc;
    private IBinder mRemote;
    private CommonTimeUtils mUtils;
    private final Object mListenerLock = new Object();
    private OnServerDiedListener mServerDiedListener = null;
    private IBinder.DeathRecipient mDeathHandler = new IBinder.DeathRecipient() { // from class: android.os.CommonTimeConfig.1
        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            synchronized (CommonTimeConfig.this.mListenerLock) {
                if (CommonTimeConfig.this.mServerDiedListener != null) {
                    CommonTimeConfig.this.mServerDiedListener.onServerDied();
                }
            }
        }
    };

    /* loaded from: source-9557208-dex2jar.jar:android/os/CommonTimeConfig$OnServerDiedListener.class */
    public interface OnServerDiedListener {
        void onServerDied();
    }

    public CommonTimeConfig() throws RemoteException {
        this.mRemote = null;
        this.mInterfaceDesc = "";
        this.mRemote = ServiceManager.getService(SERVICE_NAME);
        if (this.mRemote == null) {
            throw new RemoteException();
        }
        this.mInterfaceDesc = this.mRemote.getInterfaceDescriptor();
        this.mUtils = new CommonTimeUtils(this.mRemote, this.mInterfaceDesc);
        this.mRemote.linkToDeath(this.mDeathHandler, 0);
    }

    private boolean checkDeadServer() {
        return this.mRemote == null || this.mUtils == null;
    }

    public static CommonTimeConfig create() {
        try {
            return new CommonTimeConfig();
        } catch (RemoteException e) {
            return null;
        }
    }

    private void throwOnDeadServer() throws RemoteException {
        if (checkDeadServer()) {
            throw new RemoteException();
        }
    }

    protected void finalize() throws Throwable {
        release();
    }

    public int forceNetworklessMasterMode() {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken(this.mInterfaceDesc);
            this.mRemote.transact(17, obtain, obtain2, 0);
            int readInt = obtain2.readInt();
            obtain2.recycle();
            obtain.recycle();
            return readInt;
        } catch (RemoteException e) {
            obtain2.recycle();
            obtain.recycle();
            return -7;
        } catch (Throwable th) {
            obtain2.recycle();
            obtain.recycle();
            throw th;
        }
    }

    public boolean getAutoDisable() throws RemoteException {
        throwOnDeadServer();
        return 1 == this.mUtils.transactGetInt(15, 1);
    }

    public int getClientSyncInterval() throws RemoteException {
        throwOnDeadServer();
        return this.mUtils.transactGetInt(11, -1);
    }

    public String getInterfaceBinding() throws RemoteException {
        throwOnDeadServer();
        String transactGetString = this.mUtils.transactGetString(7, null);
        String str = transactGetString;
        if (transactGetString != null) {
            str = transactGetString;
            if (transactGetString.length() == 0) {
                str = null;
            }
        }
        return str;
    }

    public int getMasterAnnounceInterval() throws RemoteException {
        throwOnDeadServer();
        return this.mUtils.transactGetInt(9, -1);
    }

    public InetSocketAddress getMasterElectionEndpoint() throws RemoteException {
        throwOnDeadServer();
        return this.mUtils.transactGetSockaddr(3);
    }

    public long getMasterElectionGroupId() throws RemoteException {
        throwOnDeadServer();
        return this.mUtils.transactGetLong(5, -1L);
    }

    public byte getMasterElectionPriority() throws RemoteException {
        throwOnDeadServer();
        return (byte) this.mUtils.transactGetInt(1, -1);
    }

    public int getPanicThreshold() throws RemoteException {
        throwOnDeadServer();
        return this.mUtils.transactGetInt(13, -1);
    }

    public void release() {
        if (this.mRemote != null) {
            try {
                this.mRemote.unlinkToDeath(this.mDeathHandler, 0);
            } catch (NoSuchElementException e) {
            }
            this.mRemote = null;
        }
        this.mUtils = null;
    }

    public int setAutoDisable(boolean z) {
        if (checkDeadServer()) {
            return -7;
        }
        return this.mUtils.transactSetInt(16, z ? 1 : 0);
    }

    public int setClientSyncInterval(int i) {
        if (checkDeadServer()) {
            return -7;
        }
        return this.mUtils.transactSetInt(12, i);
    }

    public int setMasterAnnounceInterval(int i) {
        if (checkDeadServer()) {
            return -7;
        }
        return this.mUtils.transactSetInt(10, i);
    }

    public int setMasterElectionEndpoint(InetSocketAddress inetSocketAddress) {
        if (checkDeadServer()) {
            return -7;
        }
        return this.mUtils.transactSetSockaddr(4, inetSocketAddress);
    }

    public int setMasterElectionGroupId(long j) {
        if (checkDeadServer()) {
            return -7;
        }
        return this.mUtils.transactSetLong(6, j);
    }

    public int setMasterElectionPriority(byte b) {
        if (checkDeadServer()) {
            return -7;
        }
        return this.mUtils.transactSetInt(2, b);
    }

    public int setNetworkBinding(String str) {
        if (checkDeadServer()) {
            return -7;
        }
        CommonTimeUtils commonTimeUtils = this.mUtils;
        String str2 = str;
        if (str == null) {
            str2 = "";
        }
        return commonTimeUtils.transactSetString(8, str2);
    }

    public int setPanicThreshold(int i) {
        if (checkDeadServer()) {
            return -7;
        }
        return this.mUtils.transactSetInt(14, i);
    }

    public void setServerDiedListener(OnServerDiedListener onServerDiedListener) {
        synchronized (this.mListenerLock) {
            this.mServerDiedListener = onServerDiedListener;
        }
    }
}
