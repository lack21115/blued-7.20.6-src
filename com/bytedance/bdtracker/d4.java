package com.bytedance.bdtracker;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/bdtracker/d4.class */
public interface d4 extends IInterface {

    /* loaded from: source-7206380-dex2jar.jar:com/bytedance/bdtracker/d4$a.class */
    public static abstract class a extends Binder implements d4 {

        /* renamed from: com.bytedance.bdtracker.d4$a$a  reason: collision with other inner class name */
        /* loaded from: source-7206380-dex2jar.jar:com/bytedance/bdtracker/d4$a$a.class */
        public static class C0308a implements d4 {

            /* renamed from: a  reason: collision with root package name */
            public IBinder f21209a;

            public C0308a(IBinder iBinder) {
                this.f21209a = iBinder;
            }

            public String a() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.samsung.android.deviceidservice.IDeviceIdService");
                    this.f21209a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f21209a;
            }
        }

        public static d4 a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.samsung.android.deviceidservice.IDeviceIdService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof d4)) ? new C0308a(iBinder) : (d4) queryLocalInterface;
        }
    }
}
