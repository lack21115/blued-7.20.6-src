package com.ss.android.socialbase.downloader.model;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.ss.android.socialbase.downloader.depend.IChunkCntAidlCalculator;
import com.ss.android.socialbase.downloader.depend.IDownloadAidlDepend;
import com.ss.android.socialbase.downloader.depend.IDownloadAidlFileProvider;
import com.ss.android.socialbase.downloader.depend.IDownloadAidlInterceptor;
import com.ss.android.socialbase.downloader.depend.IDownloadAidlListener;
import com.ss.android.socialbase.downloader.depend.IDownloadAidlMonitorDepend;
import com.ss.android.socialbase.downloader.depend.IDownloadCompleteAidlHandler;
import com.ss.android.socialbase.downloader.depend.IDownloadDiskSpaceAidlHandler;
import com.ss.android.socialbase.downloader.depend.IDownloadForbiddenAidlHandler;
import com.ss.android.socialbase.downloader.depend.IDownloadNotificationEventAidlListener;
import com.ss.android.socialbase.downloader.depend.INotificationClickAidlCallback;
import com.ss.android.socialbase.downloader.depend.IRetryDelayTimeAidlCalculator;

/* loaded from: source-8457232-dex2jar.jar:com/ss/android/socialbase/downloader/model/DownloadAidlTask.class */
public interface DownloadAidlTask extends IInterface {

    /* loaded from: source-8457232-dex2jar.jar:com/ss/android/socialbase/downloader/model/DownloadAidlTask$Default.class */
    public static class Default implements DownloadAidlTask {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.model.DownloadAidlTask
        public IChunkCntAidlCalculator getChunkStrategy() throws RemoteException {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.model.DownloadAidlTask
        public IDownloadAidlDepend getDepend() throws RemoteException {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.model.DownloadAidlTask
        public IDownloadDiskSpaceAidlHandler getDiskSpaceHandler() throws RemoteException {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.model.DownloadAidlTask
        public IDownloadCompleteAidlHandler getDownloadCompleteAidlHandlerByIndex(int i) throws RemoteException {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.model.DownloadAidlTask
        public int getDownloadCompleteHandlerSize() throws RemoteException {
            return 0;
        }

        @Override // com.ss.android.socialbase.downloader.model.DownloadAidlTask
        public DownloadInfo getDownloadInfo() throws RemoteException {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.model.DownloadAidlTask
        public IDownloadAidlListener getDownloadListenerByIndex(int i, int i2) throws RemoteException {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.model.DownloadAidlTask
        public int getDownloadListenerSize(int i) throws RemoteException {
            return 0;
        }

        @Override // com.ss.android.socialbase.downloader.model.DownloadAidlTask
        public IDownloadNotificationEventAidlListener getDownloadNotificationEventListener() throws RemoteException {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.model.DownloadAidlTask
        public IDownloadAidlFileProvider getFileProvider() throws RemoteException {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.model.DownloadAidlTask
        public IDownloadForbiddenAidlHandler getForbiddenHandler() throws RemoteException {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.model.DownloadAidlTask
        public IDownloadAidlInterceptor getInterceptor() throws RemoteException {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.model.DownloadAidlTask
        public IDownloadAidlMonitorDepend getMonitorDepend() throws RemoteException {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.model.DownloadAidlTask
        public INotificationClickAidlCallback getNotificationClickCallback() throws RemoteException {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.model.DownloadAidlTask
        public IRetryDelayTimeAidlCalculator getRetryDelayTimeCalculator() throws RemoteException {
            return null;
        }

        @Override // com.ss.android.socialbase.downloader.model.DownloadAidlTask
        public IDownloadAidlListener getSingleDownloadListener(int i) throws RemoteException {
            return null;
        }
    }

    /* loaded from: source-8457232-dex2jar.jar:com/ss/android/socialbase/downloader/model/DownloadAidlTask$Stub.class */
    public static abstract class Stub extends Binder implements DownloadAidlTask {
        private static final String DESCRIPTOR = "com.ss.android.socialbase.downloader.model.DownloadAidlTask";
        static final int TRANSACTION_getChunkStrategy = 2;
        static final int TRANSACTION_getDepend = 9;
        static final int TRANSACTION_getDiskSpaceHandler = 12;
        static final int TRANSACTION_getDownloadCompleteAidlHandlerByIndex = 16;
        static final int TRANSACTION_getDownloadCompleteHandlerSize = 15;
        static final int TRANSACTION_getDownloadInfo = 1;
        static final int TRANSACTION_getDownloadListenerByIndex = 4;
        static final int TRANSACTION_getDownloadListenerSize = 3;
        static final int TRANSACTION_getDownloadNotificationEventListener = 6;
        static final int TRANSACTION_getFileProvider = 14;
        static final int TRANSACTION_getForbiddenHandler = 10;
        static final int TRANSACTION_getInterceptor = 8;
        static final int TRANSACTION_getMonitorDepend = 13;
        static final int TRANSACTION_getNotificationClickCallback = 7;
        static final int TRANSACTION_getRetryDelayTimeCalculator = 11;
        static final int TRANSACTION_getSingleDownloadListener = 5;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* loaded from: source-8457232-dex2jar.jar:com/ss/android/socialbase/downloader/model/DownloadAidlTask$Stub$Proxy.class */
        public static class Proxy implements DownloadAidlTask {
            public static DownloadAidlTask sDefaultImpl;
            private IBinder mRemote;

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            @Override // com.ss.android.socialbase.downloader.model.DownloadAidlTask
            public IChunkCntAidlCalculator getChunkStrategy() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (this.mRemote.transact(2, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                        return IChunkCntAidlCalculator.Stub.asInterface(obtain2.readStrongBinder());
                    }
                    return Stub.getDefaultImpl().getChunkStrategy();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.model.DownloadAidlTask
            public IDownloadAidlDepend getDepend() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (this.mRemote.transact(9, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                        return IDownloadAidlDepend.Stub.asInterface(obtain2.readStrongBinder());
                    }
                    return Stub.getDefaultImpl().getDepend();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.model.DownloadAidlTask
            public IDownloadDiskSpaceAidlHandler getDiskSpaceHandler() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (this.mRemote.transact(12, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                        return IDownloadDiskSpaceAidlHandler.Stub.asInterface(obtain2.readStrongBinder());
                    }
                    return Stub.getDefaultImpl().getDiskSpaceHandler();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.model.DownloadAidlTask
            public IDownloadCompleteAidlHandler getDownloadCompleteAidlHandlerByIndex(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    if (this.mRemote.transact(16, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                        return IDownloadCompleteAidlHandler.Stub.asInterface(obtain2.readStrongBinder());
                    }
                    return Stub.getDefaultImpl().getDownloadCompleteAidlHandlerByIndex(i);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.model.DownloadAidlTask
            public int getDownloadCompleteHandlerSize() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (this.mRemote.transact(15, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                        return obtain2.readInt();
                    }
                    return Stub.getDefaultImpl().getDownloadCompleteHandlerSize();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.model.DownloadAidlTask
            public DownloadInfo getDownloadInfo() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (this.mRemote.transact(1, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                        DownloadInfo createFromParcel = obtain2.readInt() != 0 ? DownloadInfo.CREATOR.createFromParcel(obtain2) : null;
                        obtain2.recycle();
                        obtain.recycle();
                        return createFromParcel;
                    }
                    return Stub.getDefaultImpl().getDownloadInfo();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.model.DownloadAidlTask
            public IDownloadAidlListener getDownloadListenerByIndex(int i, int i2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeInt(i2);
                    if (this.mRemote.transact(4, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                        return IDownloadAidlListener.Stub.asInterface(obtain2.readStrongBinder());
                    }
                    return Stub.getDefaultImpl().getDownloadListenerByIndex(i, i2);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.model.DownloadAidlTask
            public int getDownloadListenerSize(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    if (this.mRemote.transact(3, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                        return obtain2.readInt();
                    }
                    return Stub.getDefaultImpl().getDownloadListenerSize(i);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.model.DownloadAidlTask
            public IDownloadNotificationEventAidlListener getDownloadNotificationEventListener() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (this.mRemote.transact(6, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                        return IDownloadNotificationEventAidlListener.Stub.asInterface(obtain2.readStrongBinder());
                    }
                    return Stub.getDefaultImpl().getDownloadNotificationEventListener();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.model.DownloadAidlTask
            public IDownloadAidlFileProvider getFileProvider() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (this.mRemote.transact(14, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                        return IDownloadAidlFileProvider.Stub.asInterface(obtain2.readStrongBinder());
                    }
                    return Stub.getDefaultImpl().getFileProvider();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.model.DownloadAidlTask
            public IDownloadForbiddenAidlHandler getForbiddenHandler() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (this.mRemote.transact(10, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                        return IDownloadForbiddenAidlHandler.Stub.asInterface(obtain2.readStrongBinder());
                    }
                    return Stub.getDefaultImpl().getForbiddenHandler();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.model.DownloadAidlTask
            public IDownloadAidlInterceptor getInterceptor() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (this.mRemote.transact(8, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                        return IDownloadAidlInterceptor.Stub.asInterface(obtain2.readStrongBinder());
                    }
                    return Stub.getDefaultImpl().getInterceptor();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // com.ss.android.socialbase.downloader.model.DownloadAidlTask
            public IDownloadAidlMonitorDepend getMonitorDepend() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (this.mRemote.transact(13, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                        return IDownloadAidlMonitorDepend.Stub.asInterface(obtain2.readStrongBinder());
                    }
                    return Stub.getDefaultImpl().getMonitorDepend();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.model.DownloadAidlTask
            public INotificationClickAidlCallback getNotificationClickCallback() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (this.mRemote.transact(7, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                        return INotificationClickAidlCallback.Stub.asInterface(obtain2.readStrongBinder());
                    }
                    return Stub.getDefaultImpl().getNotificationClickCallback();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.model.DownloadAidlTask
            public IRetryDelayTimeAidlCalculator getRetryDelayTimeCalculator() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (this.mRemote.transact(11, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                        return IRetryDelayTimeAidlCalculator.Stub.asInterface(obtain2.readStrongBinder());
                    }
                    return Stub.getDefaultImpl().getRetryDelayTimeCalculator();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.ss.android.socialbase.downloader.model.DownloadAidlTask
            public IDownloadAidlListener getSingleDownloadListener(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    if (this.mRemote.transact(5, obtain, obtain2, 0) || Stub.getDefaultImpl() == null) {
                        obtain2.readException();
                        return IDownloadAidlListener.Stub.asInterface(obtain2.readStrongBinder());
                    }
                    return Stub.getDefaultImpl().getSingleDownloadListener(i);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static DownloadAidlTask asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof DownloadAidlTask)) ? new Proxy(iBinder) : (DownloadAidlTask) queryLocalInterface;
        }

        public static DownloadAidlTask getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(DownloadAidlTask downloadAidlTask) {
            if (Proxy.sDefaultImpl != null || downloadAidlTask == null) {
                return false;
            }
            Proxy.sDefaultImpl = downloadAidlTask;
            return true;
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
                    DownloadInfo downloadInfo = getDownloadInfo();
                    parcel2.writeNoException();
                    if (downloadInfo == null) {
                        parcel2.writeInt(0);
                        return true;
                    }
                    parcel2.writeInt(1);
                    downloadInfo.writeToParcel(parcel2, 1);
                    return true;
                case 2:
                    parcel.enforceInterface(DESCRIPTOR);
                    IChunkCntAidlCalculator chunkStrategy = getChunkStrategy();
                    parcel2.writeNoException();
                    IBinder iBinder = null;
                    if (chunkStrategy != null) {
                        iBinder = chunkStrategy.asBinder();
                    }
                    parcel2.writeStrongBinder(iBinder);
                    return true;
                case 3:
                    parcel.enforceInterface(DESCRIPTOR);
                    int downloadListenerSize = getDownloadListenerSize(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(downloadListenerSize);
                    return true;
                case 4:
                    parcel.enforceInterface(DESCRIPTOR);
                    IDownloadAidlListener downloadListenerByIndex = getDownloadListenerByIndex(parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    IBinder iBinder2 = null;
                    if (downloadListenerByIndex != null) {
                        iBinder2 = downloadListenerByIndex.asBinder();
                    }
                    parcel2.writeStrongBinder(iBinder2);
                    return true;
                case 5:
                    parcel.enforceInterface(DESCRIPTOR);
                    IDownloadAidlListener singleDownloadListener = getSingleDownloadListener(parcel.readInt());
                    parcel2.writeNoException();
                    IBinder iBinder3 = null;
                    if (singleDownloadListener != null) {
                        iBinder3 = singleDownloadListener.asBinder();
                    }
                    parcel2.writeStrongBinder(iBinder3);
                    return true;
                case 6:
                    parcel.enforceInterface(DESCRIPTOR);
                    IDownloadNotificationEventAidlListener downloadNotificationEventListener = getDownloadNotificationEventListener();
                    parcel2.writeNoException();
                    IBinder iBinder4 = null;
                    if (downloadNotificationEventListener != null) {
                        iBinder4 = downloadNotificationEventListener.asBinder();
                    }
                    parcel2.writeStrongBinder(iBinder4);
                    return true;
                case 7:
                    parcel.enforceInterface(DESCRIPTOR);
                    INotificationClickAidlCallback notificationClickCallback = getNotificationClickCallback();
                    parcel2.writeNoException();
                    IBinder iBinder5 = null;
                    if (notificationClickCallback != null) {
                        iBinder5 = notificationClickCallback.asBinder();
                    }
                    parcel2.writeStrongBinder(iBinder5);
                    return true;
                case 8:
                    parcel.enforceInterface(DESCRIPTOR);
                    IDownloadAidlInterceptor interceptor = getInterceptor();
                    parcel2.writeNoException();
                    IBinder iBinder6 = null;
                    if (interceptor != null) {
                        iBinder6 = interceptor.asBinder();
                    }
                    parcel2.writeStrongBinder(iBinder6);
                    return true;
                case 9:
                    parcel.enforceInterface(DESCRIPTOR);
                    IDownloadAidlDepend depend = getDepend();
                    parcel2.writeNoException();
                    IBinder iBinder7 = null;
                    if (depend != null) {
                        iBinder7 = depend.asBinder();
                    }
                    parcel2.writeStrongBinder(iBinder7);
                    return true;
                case 10:
                    parcel.enforceInterface(DESCRIPTOR);
                    IDownloadForbiddenAidlHandler forbiddenHandler = getForbiddenHandler();
                    parcel2.writeNoException();
                    IBinder iBinder8 = null;
                    if (forbiddenHandler != null) {
                        iBinder8 = forbiddenHandler.asBinder();
                    }
                    parcel2.writeStrongBinder(iBinder8);
                    return true;
                case 11:
                    parcel.enforceInterface(DESCRIPTOR);
                    IRetryDelayTimeAidlCalculator retryDelayTimeCalculator = getRetryDelayTimeCalculator();
                    parcel2.writeNoException();
                    IBinder iBinder9 = null;
                    if (retryDelayTimeCalculator != null) {
                        iBinder9 = retryDelayTimeCalculator.asBinder();
                    }
                    parcel2.writeStrongBinder(iBinder9);
                    return true;
                case 12:
                    parcel.enforceInterface(DESCRIPTOR);
                    IDownloadDiskSpaceAidlHandler diskSpaceHandler = getDiskSpaceHandler();
                    parcel2.writeNoException();
                    IBinder iBinder10 = null;
                    if (diskSpaceHandler != null) {
                        iBinder10 = diskSpaceHandler.asBinder();
                    }
                    parcel2.writeStrongBinder(iBinder10);
                    return true;
                case 13:
                    parcel.enforceInterface(DESCRIPTOR);
                    IDownloadAidlMonitorDepend monitorDepend = getMonitorDepend();
                    parcel2.writeNoException();
                    IBinder iBinder11 = null;
                    if (monitorDepend != null) {
                        iBinder11 = monitorDepend.asBinder();
                    }
                    parcel2.writeStrongBinder(iBinder11);
                    return true;
                case 14:
                    parcel.enforceInterface(DESCRIPTOR);
                    IDownloadAidlFileProvider fileProvider = getFileProvider();
                    parcel2.writeNoException();
                    IBinder iBinder12 = null;
                    if (fileProvider != null) {
                        iBinder12 = fileProvider.asBinder();
                    }
                    parcel2.writeStrongBinder(iBinder12);
                    return true;
                case 15:
                    parcel.enforceInterface(DESCRIPTOR);
                    int downloadCompleteHandlerSize = getDownloadCompleteHandlerSize();
                    parcel2.writeNoException();
                    parcel2.writeInt(downloadCompleteHandlerSize);
                    return true;
                case 16:
                    parcel.enforceInterface(DESCRIPTOR);
                    IDownloadCompleteAidlHandler downloadCompleteAidlHandlerByIndex = getDownloadCompleteAidlHandlerByIndex(parcel.readInt());
                    parcel2.writeNoException();
                    IBinder iBinder13 = null;
                    if (downloadCompleteAidlHandlerByIndex != null) {
                        iBinder13 = downloadCompleteAidlHandlerByIndex.asBinder();
                    }
                    parcel2.writeStrongBinder(iBinder13);
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    IChunkCntAidlCalculator getChunkStrategy() throws RemoteException;

    IDownloadAidlDepend getDepend() throws RemoteException;

    IDownloadDiskSpaceAidlHandler getDiskSpaceHandler() throws RemoteException;

    IDownloadCompleteAidlHandler getDownloadCompleteAidlHandlerByIndex(int i) throws RemoteException;

    int getDownloadCompleteHandlerSize() throws RemoteException;

    DownloadInfo getDownloadInfo() throws RemoteException;

    IDownloadAidlListener getDownloadListenerByIndex(int i, int i2) throws RemoteException;

    int getDownloadListenerSize(int i) throws RemoteException;

    IDownloadNotificationEventAidlListener getDownloadNotificationEventListener() throws RemoteException;

    IDownloadAidlFileProvider getFileProvider() throws RemoteException;

    IDownloadForbiddenAidlHandler getForbiddenHandler() throws RemoteException;

    IDownloadAidlInterceptor getInterceptor() throws RemoteException;

    IDownloadAidlMonitorDepend getMonitorDepend() throws RemoteException;

    INotificationClickAidlCallback getNotificationClickCallback() throws RemoteException;

    IRetryDelayTimeAidlCalculator getRetryDelayTimeCalculator() throws RemoteException;

    IDownloadAidlListener getSingleDownloadListener(int i) throws RemoteException;
}
