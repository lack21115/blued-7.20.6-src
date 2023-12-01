package com.tencent.turingface.sdk.mfa;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/turingface/sdk/mfa/s5pTT.class */
public interface s5pTT extends IInterface {

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/turingface/sdk/mfa/s5pTT$spXPg.class */
    public static abstract class spXPg extends Binder implements s5pTT {

        /* renamed from: a  reason: collision with root package name */
        public static final String f26297a = kC0XR.a(kC0XR.M0);

        /* renamed from: com.tencent.turingface.sdk.mfa.s5pTT$spXPg$spXPg  reason: collision with other inner class name */
        /* loaded from: source-8829756-dex2jar.jar:com/tencent/turingface/sdk/mfa/s5pTT$spXPg$spXPg.class */
        public static final class C0893spXPg implements s5pTT {

            /* renamed from: a  reason: collision with root package name */
            public IBinder f26298a;

            public C0893spXPg(IBinder iBinder) {
                this.f26298a = iBinder;
            }

            @Override // com.tencent.turingface.sdk.mfa.s5pTT
            public final boolean a() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(spXPg.f26297a);
                    obtain.writeInt(2000);
                    boolean z = false;
                    this.f26298a.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return z;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    throw th;
                }
            }

            @Override // android.os.IInterface
            public final IBinder asBinder() {
                return this.f26298a;
            }

            @Override // com.tencent.turingface.sdk.mfa.s5pTT
            public final int b() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(spXPg.f26297a);
                    this.f26298a.transact(12, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.tencent.turingface.sdk.mfa.s5pTT
            public final int c() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(spXPg.f26297a);
                    obtain.writeInt(2000);
                    this.f26298a.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.tencent.turingface.sdk.mfa.s5pTT
            public final SWw7W d() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(spXPg.f26297a);
                    obtain.writeInt(2000);
                    this.f26298a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    SWw7W sWw7W = obtain2.readInt() != 0 ? new SWw7W(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return sWw7W;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    throw th;
                }
            }

            @Override // com.tencent.turingface.sdk.mfa.s5pTT
            public final int e() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(spXPg.f26297a);
                    obtain.writeInt(2000);
                    this.f26298a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }
    }

    boolean a() throws RemoteException;

    int b() throws RemoteException;

    int c() throws RemoteException;

    SWw7W d() throws RemoteException;

    int e() throws RemoteException;
}
