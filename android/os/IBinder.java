package android.os;

import java.io.FileDescriptor;

/* loaded from: source-9557208-dex2jar.jar:android/os/IBinder.class */
public interface IBinder {
    public static final int DUMP_TRANSACTION = 1598311760;
    public static final int FIRST_CALL_TRANSACTION = 1;
    public static final int FLAG_ONEWAY = 1;
    public static final int INTERFACE_TRANSACTION = 1598968902;
    public static final int LAST_CALL_TRANSACTION = 16777215;
    public static final int LIKE_TRANSACTION = 1598835019;
    public static final int PING_TRANSACTION = 1599098439;
    public static final int SYSPROPS_TRANSACTION = 1599295570;
    public static final int TWEET_TRANSACTION = 1599362900;

    /* loaded from: source-9557208-dex2jar.jar:android/os/IBinder$DeathRecipient.class */
    public interface DeathRecipient {
        void binderDied();
    }

    void dump(FileDescriptor fileDescriptor, String[] strArr) throws RemoteException;

    void dumpAsync(FileDescriptor fileDescriptor, String[] strArr) throws RemoteException;

    String getInterfaceDescriptor() throws RemoteException;

    boolean isBinderAlive();

    void linkToDeath(DeathRecipient deathRecipient, int i) throws RemoteException;

    boolean pingBinder();

    IInterface queryLocalInterface(String str);

    boolean transact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException;

    boolean unlinkToDeath(DeathRecipient deathRecipient, int i);
}
