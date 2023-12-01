package android.media.session;

import android.content.Intent;
import android.media.Rating;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.ResultReceiver;

/* loaded from: source-9557208-dex2jar.jar:android/media/session/ISessionCallback.class */
public interface ISessionCallback extends IInterface {

    /* loaded from: source-9557208-dex2jar.jar:android/media/session/ISessionCallback$Stub.class */
    public static abstract class Stub extends Binder implements ISessionCallback {
        private static final String DESCRIPTOR = "android.media.session.ISessionCallback";
        static final int TRANSACTION_getRemoteControlClientNowPlayingEntries = 16;
        static final int TRANSACTION_onAdjustVolume = 19;
        static final int TRANSACTION_onCommand = 1;
        static final int TRANSACTION_onCustomAction = 18;
        static final int TRANSACTION_onFastForward = 11;
        static final int TRANSACTION_onMediaButton = 2;
        static final int TRANSACTION_onNext = 9;
        static final int TRANSACTION_onPause = 7;
        static final int TRANSACTION_onPlay = 3;
        static final int TRANSACTION_onPlayFromMediaId = 4;
        static final int TRANSACTION_onPlayFromSearch = 5;
        static final int TRANSACTION_onPrevious = 10;
        static final int TRANSACTION_onRate = 17;
        static final int TRANSACTION_onRewind = 12;
        static final int TRANSACTION_onSeekTo = 13;
        static final int TRANSACTION_onSetVolumeTo = 20;
        static final int TRANSACTION_onSkipToTrack = 6;
        static final int TRANSACTION_onStop = 8;
        static final int TRANSACTION_setRemoteControlClientBrowsedPlayer = 14;
        static final int TRANSACTION_setRemoteControlClientPlayItem = 15;

        /* loaded from: source-9557208-dex2jar.jar:android/media/session/ISessionCallback$Stub$Proxy.class */
        private static class Proxy implements ISessionCallback {
            private IBinder mRemote;

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return Stub.DESCRIPTOR;
            }

            @Override // android.media.session.ISessionCallback
            public void getRemoteControlClientNowPlayingEntries() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(16, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // android.media.session.ISessionCallback
            public void onAdjustVolume(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    this.mRemote.transact(19, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // android.media.session.ISessionCallback
            public void onCommand(String str, Bundle bundle, ResultReceiver resultReceiver) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (resultReceiver != null) {
                        obtain.writeInt(1);
                        resultReceiver.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.mRemote.transact(1, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // android.media.session.ISessionCallback
            public void onCustomAction(String str, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.mRemote.transact(18, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // android.media.session.ISessionCallback
            public void onFastForward() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(11, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // android.media.session.ISessionCallback
            public void onMediaButton(Intent intent, int i, ResultReceiver resultReceiver) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (intent != null) {
                        obtain.writeInt(1);
                        intent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeInt(i);
                    if (resultReceiver != null) {
                        obtain.writeInt(1);
                        resultReceiver.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.mRemote.transact(2, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // android.media.session.ISessionCallback
            public void onNext() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(9, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // android.media.session.ISessionCallback
            public void onPause() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(7, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // android.media.session.ISessionCallback
            public void onPlay() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(3, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // android.media.session.ISessionCallback
            public void onPlayFromMediaId(String str, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.mRemote.transact(4, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // android.media.session.ISessionCallback
            public void onPlayFromSearch(String str, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeString(str);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.mRemote.transact(5, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // android.media.session.ISessionCallback
            public void onPrevious() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(10, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // android.media.session.ISessionCallback
            public void onRate(Rating rating) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    if (rating != null) {
                        obtain.writeInt(1);
                        rating.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.mRemote.transact(17, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // android.media.session.ISessionCallback
            public void onRewind() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(12, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // android.media.session.ISessionCallback
            public void onSeekTo(long j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeLong(j);
                    this.mRemote.transact(13, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // android.media.session.ISessionCallback
            public void onSetVolumeTo(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    this.mRemote.transact(20, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // android.media.session.ISessionCallback
            public void onSkipToTrack(long j) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeLong(j);
                    this.mRemote.transact(6, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // android.media.session.ISessionCallback
            public void onStop() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(8, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // android.media.session.ISessionCallback
            public void setRemoteControlClientBrowsedPlayer() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    this.mRemote.transact(14, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // android.media.session.ISessionCallback
            public void setRemoteControlClientPlayItem(long j, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeLong(j);
                    obtain.writeInt(i);
                    this.mRemote.transact(15, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static ISessionCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof ISessionCallback)) ? new Proxy(iBinder) : (ISessionCallback) queryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            switch (i) {
                case 1:
                    parcel.enforceInterface(DESCRIPTOR);
                    onCommand(parcel.readString(), parcel.readInt() != 0 ? Bundle.CREATOR.createFromParcel(parcel) : null, parcel.readInt() != 0 ? ResultReceiver.CREATOR.createFromParcel(parcel) : null);
                    return true;
                case 2:
                    parcel.enforceInterface(DESCRIPTOR);
                    onMediaButton(parcel.readInt() != 0 ? Intent.CREATOR.createFromParcel(parcel) : null, parcel.readInt(), parcel.readInt() != 0 ? ResultReceiver.CREATOR.createFromParcel(parcel) : null);
                    return true;
                case 3:
                    parcel.enforceInterface(DESCRIPTOR);
                    onPlay();
                    return true;
                case 4:
                    parcel.enforceInterface(DESCRIPTOR);
                    onPlayFromMediaId(parcel.readString(), parcel.readInt() != 0 ? Bundle.CREATOR.createFromParcel(parcel) : null);
                    return true;
                case 5:
                    parcel.enforceInterface(DESCRIPTOR);
                    onPlayFromSearch(parcel.readString(), parcel.readInt() != 0 ? Bundle.CREATOR.createFromParcel(parcel) : null);
                    return true;
                case 6:
                    parcel.enforceInterface(DESCRIPTOR);
                    onSkipToTrack(parcel.readLong());
                    return true;
                case 7:
                    parcel.enforceInterface(DESCRIPTOR);
                    onPause();
                    return true;
                case 8:
                    parcel.enforceInterface(DESCRIPTOR);
                    onStop();
                    return true;
                case 9:
                    parcel.enforceInterface(DESCRIPTOR);
                    onNext();
                    return true;
                case 10:
                    parcel.enforceInterface(DESCRIPTOR);
                    onPrevious();
                    return true;
                case 11:
                    parcel.enforceInterface(DESCRIPTOR);
                    onFastForward();
                    return true;
                case 12:
                    parcel.enforceInterface(DESCRIPTOR);
                    onRewind();
                    return true;
                case 13:
                    parcel.enforceInterface(DESCRIPTOR);
                    onSeekTo(parcel.readLong());
                    return true;
                case 14:
                    parcel.enforceInterface(DESCRIPTOR);
                    setRemoteControlClientBrowsedPlayer();
                    return true;
                case 15:
                    parcel.enforceInterface(DESCRIPTOR);
                    setRemoteControlClientPlayItem(parcel.readLong(), parcel.readInt());
                    return true;
                case 16:
                    parcel.enforceInterface(DESCRIPTOR);
                    getRemoteControlClientNowPlayingEntries();
                    return true;
                case 17:
                    parcel.enforceInterface(DESCRIPTOR);
                    onRate(parcel.readInt() != 0 ? Rating.CREATOR.createFromParcel(parcel) : null);
                    return true;
                case 18:
                    parcel.enforceInterface(DESCRIPTOR);
                    onCustomAction(parcel.readString(), parcel.readInt() != 0 ? Bundle.CREATOR.createFromParcel(parcel) : null);
                    return true;
                case 19:
                    parcel.enforceInterface(DESCRIPTOR);
                    onAdjustVolume(parcel.readInt());
                    return true;
                case 20:
                    parcel.enforceInterface(DESCRIPTOR);
                    onSetVolumeTo(parcel.readInt());
                    return true;
                case IBinder.INTERFACE_TRANSACTION /* 1598968902 */:
                    parcel2.writeString(DESCRIPTOR);
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void getRemoteControlClientNowPlayingEntries() throws RemoteException;

    void onAdjustVolume(int i) throws RemoteException;

    void onCommand(String str, Bundle bundle, ResultReceiver resultReceiver) throws RemoteException;

    void onCustomAction(String str, Bundle bundle) throws RemoteException;

    void onFastForward() throws RemoteException;

    void onMediaButton(Intent intent, int i, ResultReceiver resultReceiver) throws RemoteException;

    void onNext() throws RemoteException;

    void onPause() throws RemoteException;

    void onPlay() throws RemoteException;

    void onPlayFromMediaId(String str, Bundle bundle) throws RemoteException;

    void onPlayFromSearch(String str, Bundle bundle) throws RemoteException;

    void onPrevious() throws RemoteException;

    void onRate(Rating rating) throws RemoteException;

    void onRewind() throws RemoteException;

    void onSeekTo(long j) throws RemoteException;

    void onSetVolumeTo(int i) throws RemoteException;

    void onSkipToTrack(long j) throws RemoteException;

    void onStop() throws RemoteException;

    void setRemoteControlClientBrowsedPlayer() throws RemoteException;

    void setRemoteControlClientPlayItem(long j, int i) throws RemoteException;
}
