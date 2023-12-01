package com.huawei.openalliance.ad.ipc;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.huawei.hms.ads.ge;
import com.huawei.openalliance.ad.ipc.e;

/* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/ipc/f.class */
public interface f extends IInterface {

    /* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/ipc/f$a.class */
    public static abstract class a extends Binder implements f {
        static final int Code = 1;
        private static final String I = "IPPSServiceApi";
        static final int V = 2;
        private static final String Z = "com.huawei.android.hms.ppskit.IPPSServiceApi";

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.huawei.openalliance.ad.ipc.f$a$a  reason: collision with other inner class name */
        /* loaded from: source-7994992-dex2jar.jar:com/huawei/openalliance/ad/ipc/f$a$a.class */
        public static class C0268a implements f {
            public static f Code;
            private IBinder V;

            C0268a(IBinder iBinder) {
                this.V = iBinder;
            }

            @Override // com.huawei.openalliance.ad.ipc.f
            public void Code() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.Z);
                    if (this.V.transact(1, obtain, obtain2, 0) || a.V() == null) {
                        obtain2.readException();
                    } else {
                        a.V().Code();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.huawei.openalliance.ad.ipc.f
            public void Code(String str, String str2, e eVar) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(a.Z);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    obtain.writeStrongBinder(eVar != null ? eVar.asBinder() : null);
                    if (this.V.transact(2, obtain, obtain2, 0) || a.V() == null) {
                        obtain2.readException();
                    } else {
                        a.V().Code(str, str2, eVar);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String V() {
                return a.Z;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.V;
            }
        }

        public a() {
            attachInterface(this, Z);
        }

        public static f Code(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            try {
                IInterface queryLocalInterface = iBinder.queryLocalInterface(Z);
                return (queryLocalInterface == null || !(queryLocalInterface instanceof f)) ? new C0268a(iBinder) : (f) queryLocalInterface;
            } catch (Throwable th) {
                ge.I(I, "IPPSServiceApi err: " + th.getClass().getSimpleName());
                return null;
            }
        }

        public static boolean Code(f fVar) {
            if (C0268a.Code != null || fVar == null) {
                return false;
            }
            C0268a.Code = fVar;
            return true;
        }

        public static f V() {
            return C0268a.Code;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            if (i == 1) {
                parcel.enforceInterface(Z);
                Code();
            } else if (i != 2) {
                if (i != 1598968902) {
                    return super.onTransact(i, parcel, parcel2, i2);
                }
                parcel2.writeString(Z);
                return true;
            } else {
                parcel.enforceInterface(Z);
                Code(parcel.readString(), parcel.readString(), e.a.Code(parcel.readStrongBinder()));
            }
            parcel2.writeNoException();
            return true;
        }
    }

    void Code();

    void Code(String str, String str2, e eVar);
}
