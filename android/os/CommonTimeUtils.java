package android.os;

import android.system.OsConstants;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.util.Locale;

/* loaded from: source-9557208-dex2jar.jar:android/os/CommonTimeUtils.class */
class CommonTimeUtils {
    public static final int ERROR = -1;
    public static final int ERROR_BAD_VALUE = -4;
    public static final int ERROR_DEAD_OBJECT = -7;
    public static final int SUCCESS = 0;
    private String mInterfaceDesc;
    private IBinder mRemote;

    public CommonTimeUtils(IBinder iBinder, String str) {
        this.mRemote = iBinder;
        this.mInterfaceDesc = str;
    }

    public int transactGetInt(int i, int i2) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken(this.mInterfaceDesc);
            this.mRemote.transact(i, obtain, obtain2, 0);
            int readInt = obtain2.readInt() == 0 ? obtain2.readInt() : i2;
            obtain2.recycle();
            obtain.recycle();
            return readInt;
        } catch (Throwable th) {
            obtain2.recycle();
            obtain.recycle();
            throw th;
        }
    }

    public long transactGetLong(int i, long j) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken(this.mInterfaceDesc);
            this.mRemote.transact(i, obtain, obtain2, 0);
            if (obtain2.readInt() == 0) {
                j = obtain2.readLong();
            }
            obtain2.recycle();
            obtain.recycle();
            return j;
        } catch (Throwable th) {
            obtain2.recycle();
            obtain.recycle();
            throw th;
        }
    }

    public InetSocketAddress transactGetSockaddr(int i) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken(this.mInterfaceDesc);
            this.mRemote.transact(i, obtain, obtain2, 0);
            InetSocketAddress inetSocketAddress = null;
            if (obtain2.readInt() == 0) {
                int i2 = 0;
                String str = null;
                int readInt = obtain2.readInt();
                if (OsConstants.AF_INET == readInt) {
                    int readInt2 = obtain2.readInt();
                    i2 = obtain2.readInt();
                    str = String.format(Locale.US, "%d.%d.%d.%d", Integer.valueOf((readInt2 >> 24) & 255), Integer.valueOf((readInt2 >> 16) & 255), Integer.valueOf((readInt2 >> 8) & 255), Integer.valueOf(readInt2 & 255));
                } else if (OsConstants.AF_INET6 == readInt) {
                    int readInt3 = obtain2.readInt();
                    int readInt4 = obtain2.readInt();
                    int readInt5 = obtain2.readInt();
                    int readInt6 = obtain2.readInt();
                    i2 = obtain2.readInt();
                    obtain2.readInt();
                    obtain2.readInt();
                    str = String.format(Locale.US, "[%04X:%04X:%04X:%04X:%04X:%04X:%04X:%04X]", Integer.valueOf((readInt3 >> 16) & 65535), Integer.valueOf(65535 & readInt3), Integer.valueOf((readInt4 >> 16) & 65535), Integer.valueOf(65535 & readInt4), Integer.valueOf((readInt5 >> 16) & 65535), Integer.valueOf(65535 & readInt5), Integer.valueOf((readInt6 >> 16) & 65535), Integer.valueOf(65535 & readInt6));
                }
                inetSocketAddress = null;
                if (str != null) {
                    inetSocketAddress = new InetSocketAddress(str, i2);
                }
            }
            obtain2.recycle();
            obtain.recycle();
            return inetSocketAddress;
        } catch (Throwable th) {
            obtain2.recycle();
            obtain.recycle();
            throw th;
        }
    }

    public String transactGetString(int i, String str) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken(this.mInterfaceDesc);
            this.mRemote.transact(i, obtain, obtain2, 0);
            if (obtain2.readInt() == 0) {
                str = obtain2.readString();
            }
            obtain2.recycle();
            obtain.recycle();
            return str;
        } catch (Throwable th) {
            obtain2.recycle();
            obtain.recycle();
            throw th;
        }
    }

    public int transactSetInt(int i, int i2) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken(this.mInterfaceDesc);
            obtain.writeInt(i2);
            this.mRemote.transact(i, obtain, obtain2, 0);
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

    public int transactSetLong(int i, long j) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken(this.mInterfaceDesc);
            obtain.writeLong(j);
            this.mRemote.transact(i, obtain, obtain2, 0);
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

    public int transactSetSockaddr(int i, InetSocketAddress inetSocketAddress) {
        int i2;
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken(this.mInterfaceDesc);
            if (inetSocketAddress == null) {
                obtain.writeInt(0);
            } else {
                obtain.writeInt(1);
                InetAddress address = inetSocketAddress.getAddress();
                byte[] address2 = address.getAddress();
                int port = inetSocketAddress.getPort();
                if (address instanceof Inet4Address) {
                    byte b = address2[0];
                    byte b2 = address2[1];
                    byte b3 = address2[2];
                    byte b4 = address2[3];
                    obtain.writeInt(OsConstants.AF_INET);
                    obtain.writeInt(((b & 255) << 24) | ((b2 & 255) << 16) | ((b3 & 255) << 8) | (b4 & 255));
                    obtain.writeInt(port);
                } else if (!(address instanceof Inet6Address)) {
                    obtain2.recycle();
                    obtain.recycle();
                    return -4;
                } else {
                    Inet6Address inet6Address = (Inet6Address) address;
                    obtain.writeInt(OsConstants.AF_INET6);
                    int i3 = 0;
                    while (true) {
                        int i4 = i3;
                        if (i4 >= 4) {
                            break;
                        }
                        obtain.writeInt(((address2[(i4 * 4) + 0] & 255) << 24) | ((address2[(i4 * 4) + 1] & 255) << 16) | ((address2[(i4 * 4) + 2] & 255) << 8) | (address2[(i4 * 4) + 3] & 255));
                        i3 = i4 + 1;
                    }
                    obtain.writeInt(port);
                    obtain.writeInt(0);
                    obtain.writeInt(inet6Address.getScopeId());
                }
            }
            this.mRemote.transact(i, obtain, obtain2, 0);
            i2 = obtain2.readInt();
        } catch (RemoteException e) {
            i2 = -7;
        } finally {
            obtain2.recycle();
            obtain.recycle();
        }
        return i2;
    }

    public int transactSetString(int i, String str) {
        Parcel obtain = Parcel.obtain();
        Parcel obtain2 = Parcel.obtain();
        try {
            obtain.writeInterfaceToken(this.mInterfaceDesc);
            obtain.writeString(str);
            this.mRemote.transact(i, obtain, obtain2, 0);
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
}
