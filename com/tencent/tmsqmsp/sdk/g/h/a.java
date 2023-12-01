package com.tencent.tmsqmsp.sdk.g.h;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tmsqmsp/sdk/g/h/a.class */
public interface a extends IInterface {

    /* renamed from: com.tencent.tmsqmsp.sdk.g.h.a$a  reason: collision with other inner class name */
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/tmsqmsp/sdk/g/h/a$a.class */
    public static abstract class AbstractBinderC1057a extends Binder implements a {

        /* renamed from: com.tencent.tmsqmsp.sdk.g.h.a$a$a  reason: collision with other inner class name */
        /* loaded from: source-8829756-dex2jar.jar:com/tencent/tmsqmsp/sdk/g/h/a$a$a.class */
        public static class C1058a implements a {

            /* renamed from: a  reason: collision with root package name */
            private IBinder f39797a;

            public C1058a(IBinder iBinder) {
                this.f39797a = iBinder;
            }

            @Override // com.tencent.tmsqmsp.sdk.g.h.a
            public String a() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    try {
                        obtain.writeInterfaceToken("com.samsung.android.deviceidservice.IDeviceIdService");
                        this.f39797a.transact(1, obtain, obtain2, 0);
                        obtain2.readException();
                        return obtain2.readString();
                    } catch (RemoteException e) {
                        e.printStackTrace();
                        obtain2.recycle();
                        obtain.recycle();
                        return null;
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.tencent.tmsqmsp.sdk.g.h.a
            public String a(String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    try {
                        obtain.writeInterfaceToken("com.samsung.android.deviceidservice.IDeviceIdService");
                        obtain.writeString(str);
                        this.f39797a.transact(3, obtain, obtain2, 0);
                        obtain2.readException();
                        return obtain2.readString();
                    } catch (RemoteException e) {
                        e.printStackTrace();
                        obtain2.recycle();
                        obtain.recycle();
                        return null;
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f39797a;
            }
        }

        public static a a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.samsung.android.deviceidservice.IDeviceIdService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof a)) ? new C1058a(iBinder) : (a) queryLocalInterface;
        }
    }

    String a();

    String a(String str);
}
