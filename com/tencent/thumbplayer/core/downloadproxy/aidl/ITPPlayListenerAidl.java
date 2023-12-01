package com.tencent.thumbplayer.core.downloadproxy.aidl;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.List;
import java.util.Map;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/core/downloadproxy/aidl/ITPPlayListenerAidl.class */
public interface ITPPlayListenerAidl extends IInterface {

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/core/downloadproxy/aidl/ITPPlayListenerAidl$Stub.class */
    public static abstract class Stub extends Binder implements ITPPlayListenerAidl {
        private static final String DESCRIPTOR = "com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl";
        static final int TRANSACTION_getAdvRemainTime = 14;
        static final int TRANSACTION_getContentType = 21;
        static final int TRANSACTION_getCurrentPlayClipNo = 13;
        static final int TRANSACTION_getCurrentPlayOffset = 12;
        static final int TRANSACTION_getCurrentPosition = 11;
        static final int TRANSACTION_getDataFilePath = 20;
        static final int TRANSACTION_getDataTotalSize = 19;
        static final int TRANSACTION_getPlayInfo = 15;
        static final int TRANSACTION_getPlayerBufferLength = 10;
        static final int TRANSACTION_onDownloadCdnUrlExpired = 7;
        static final int TRANSACTION_onDownloadCdnUrlInfoUpdate = 6;
        static final int TRANSACTION_onDownloadCdnUrlUpdate = 5;
        static final int TRANSACTION_onDownloadError = 3;
        static final int TRANSACTION_onDownloadFinish = 2;
        static final int TRANSACTION_onDownloadProgressUpdate = 1;
        static final int TRANSACTION_onDownloadProtocolUpdate = 9;
        static final int TRANSACTION_onDownloadStatusUpdate = 8;
        static final int TRANSACTION_onPlayCallback = 4;
        static final int TRANSACTION_onReadData = 17;
        static final int TRANSACTION_onStartReadData = 16;
        static final int TRANSACTION_onStopReadData = 18;

        /* loaded from: source-8829756-dex2jar.jar:com/tencent/thumbplayer/core/downloadproxy/aidl/ITPPlayListenerAidl$Stub$Proxy.class */
        static class Proxy implements ITPPlayListenerAidl {
            private IBinder mRemote;

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl
            public long getAdvRemainTime() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(14, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readLong();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl
            public String getContentType(int i, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    this.mRemote.transact(21, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl
            public int getCurrentPlayClipNo() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(13, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl
            public long getCurrentPlayOffset() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(12, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readLong();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl
            public long getCurrentPosition() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(11, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readLong();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl
            public String getDataFilePath(int i, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    this.mRemote.transact(20, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl
            public long getDataTotalSize(int i, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    this.mRemote.transact(19, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readLong();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl
            public String getPlayInfo(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    this.mRemote.transact(15, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl
            public long getPlayerBufferLength() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readLong();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl
            public void onDownloadCdnUrlExpired(Map map) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeMap(map);
                    this.mRemote.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl
            public void onDownloadCdnUrlInfoUpdate(String str, String str2, String str3, String str4) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeString(str3);
                    obtain.writeString(str4);
                    this.mRemote.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl
            public void onDownloadCdnUrlUpdate(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    this.mRemote.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl
            public void onDownloadError(int i, int i2, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeString(str);
                    this.mRemote.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl
            public void onDownloadFinish() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl
            public void onDownloadProgressUpdate(int i, int i2, long j, long j2, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    obtain.writeLong(j);
                    obtain.writeLong(j2);
                    obtain.writeString(str);
                    this.mRemote.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl
            public void onDownloadProtocolUpdate(String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.mRemote.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl
            public void onDownloadStatusUpdate(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    this.mRemote.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl
            public int onPlayCallback(int i, List list) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeList(list);
                    this.mRemote.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl
            public int onReadData(int i, String str, long j, long j2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    obtain.writeLong(j);
                    obtain.writeLong(j2);
                    this.mRemote.transact(17, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl
            public int onStartReadData(int i, String str, long j, long j2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    obtain.writeLong(j);
                    obtain.writeLong(j2);
                    this.mRemote.transact(16, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.tencent.thumbplayer.core.downloadproxy.aidl.ITPPlayListenerAidl
            public int onStopReadData(int i, String str, int i2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    obtain.writeInt(i2);
                    this.mRemote.transact(18, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static ITPPlayListenerAidl asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof ITPPlayListenerAidl)) ? new Proxy(iBinder) : (ITPPlayListenerAidl) queryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1598968902) {
                parcel2.writeString(DESCRIPTOR);
                return true;
            }
            switch (i) {
                case 1:
                    parcel.enforceInterface(DESCRIPTOR);
                    onDownloadProgressUpdate(parcel.readInt(), parcel.readInt(), parcel.readLong(), parcel.readLong(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 2:
                    parcel.enforceInterface(DESCRIPTOR);
                    onDownloadFinish();
                    parcel2.writeNoException();
                    return true;
                case 3:
                    parcel.enforceInterface(DESCRIPTOR);
                    onDownloadError(parcel.readInt(), parcel.readInt(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 4:
                    parcel.enforceInterface(DESCRIPTOR);
                    int onPlayCallback = onPlayCallback(parcel.readInt(), parcel.readArrayList(getClass().getClassLoader()));
                    parcel2.writeNoException();
                    parcel2.writeInt(onPlayCallback);
                    return true;
                case 5:
                    parcel.enforceInterface(DESCRIPTOR);
                    onDownloadCdnUrlUpdate(parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 6:
                    parcel.enforceInterface(DESCRIPTOR);
                    onDownloadCdnUrlInfoUpdate(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 7:
                    parcel.enforceInterface(DESCRIPTOR);
                    onDownloadCdnUrlExpired(parcel.readHashMap(getClass().getClassLoader()));
                    parcel2.writeNoException();
                    return true;
                case 8:
                    parcel.enforceInterface(DESCRIPTOR);
                    onDownloadStatusUpdate(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                case 9:
                    parcel.enforceInterface(DESCRIPTOR);
                    onDownloadProtocolUpdate(parcel.readString(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                case 10:
                    parcel.enforceInterface(DESCRIPTOR);
                    long playerBufferLength = getPlayerBufferLength();
                    parcel2.writeNoException();
                    parcel2.writeLong(playerBufferLength);
                    return true;
                case 11:
                    parcel.enforceInterface(DESCRIPTOR);
                    long currentPosition = getCurrentPosition();
                    parcel2.writeNoException();
                    parcel2.writeLong(currentPosition);
                    return true;
                case 12:
                    parcel.enforceInterface(DESCRIPTOR);
                    long currentPlayOffset = getCurrentPlayOffset();
                    parcel2.writeNoException();
                    parcel2.writeLong(currentPlayOffset);
                    return true;
                case 13:
                    parcel.enforceInterface(DESCRIPTOR);
                    int currentPlayClipNo = getCurrentPlayClipNo();
                    parcel2.writeNoException();
                    parcel2.writeInt(currentPlayClipNo);
                    return true;
                case 14:
                    parcel.enforceInterface(DESCRIPTOR);
                    long advRemainTime = getAdvRemainTime();
                    parcel2.writeNoException();
                    parcel2.writeLong(advRemainTime);
                    return true;
                case 15:
                    parcel.enforceInterface(DESCRIPTOR);
                    String playInfo = getPlayInfo(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeString(playInfo);
                    return true;
                case 16:
                    parcel.enforceInterface(DESCRIPTOR);
                    int onStartReadData = onStartReadData(parcel.readInt(), parcel.readString(), parcel.readLong(), parcel.readLong());
                    parcel2.writeNoException();
                    parcel2.writeInt(onStartReadData);
                    return true;
                case 17:
                    parcel.enforceInterface(DESCRIPTOR);
                    int onReadData = onReadData(parcel.readInt(), parcel.readString(), parcel.readLong(), parcel.readLong());
                    parcel2.writeNoException();
                    parcel2.writeInt(onReadData);
                    return true;
                case 18:
                    parcel.enforceInterface(DESCRIPTOR);
                    int onStopReadData = onStopReadData(parcel.readInt(), parcel.readString(), parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(onStopReadData);
                    return true;
                case 19:
                    parcel.enforceInterface(DESCRIPTOR);
                    long dataTotalSize = getDataTotalSize(parcel.readInt(), parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeLong(dataTotalSize);
                    return true;
                case 20:
                    parcel.enforceInterface(DESCRIPTOR);
                    String dataFilePath = getDataFilePath(parcel.readInt(), parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeString(dataFilePath);
                    return true;
                case 21:
                    parcel.enforceInterface(DESCRIPTOR);
                    String contentType = getContentType(parcel.readInt(), parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeString(contentType);
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    long getAdvRemainTime() throws RemoteException;

    String getContentType(int i, String str) throws RemoteException;

    int getCurrentPlayClipNo() throws RemoteException;

    long getCurrentPlayOffset() throws RemoteException;

    long getCurrentPosition() throws RemoteException;

    String getDataFilePath(int i, String str) throws RemoteException;

    long getDataTotalSize(int i, String str) throws RemoteException;

    String getPlayInfo(String str) throws RemoteException;

    long getPlayerBufferLength() throws RemoteException;

    void onDownloadCdnUrlExpired(Map map) throws RemoteException;

    void onDownloadCdnUrlInfoUpdate(String str, String str2, String str3, String str4) throws RemoteException;

    void onDownloadCdnUrlUpdate(String str) throws RemoteException;

    void onDownloadError(int i, int i2, String str) throws RemoteException;

    void onDownloadFinish() throws RemoteException;

    void onDownloadProgressUpdate(int i, int i2, long j, long j2, String str) throws RemoteException;

    void onDownloadProtocolUpdate(String str, String str2) throws RemoteException;

    void onDownloadStatusUpdate(int i) throws RemoteException;

    int onPlayCallback(int i, List list) throws RemoteException;

    int onReadData(int i, String str, long j, long j2) throws RemoteException;

    int onStartReadData(int i, String str, long j, long j2) throws RemoteException;

    int onStopReadData(int i, String str, int i2) throws RemoteException;
}
