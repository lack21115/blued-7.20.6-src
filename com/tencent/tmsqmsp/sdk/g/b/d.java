package com.tencent.tmsqmsp.sdk.g.b;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tmsqmsp/sdk/g/b/d.class */
public interface d extends IInterface {

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/tmsqmsp/sdk/g/b/d$a.class */
    public static abstract class a extends Binder implements d {

        /* renamed from: com.tencent.tmsqmsp.sdk.g.b.d$a$a  reason: collision with other inner class name */
        /* loaded from: source-8829756-dex2jar.jar:com/tencent/tmsqmsp/sdk/g/b/d$a$a.class */
        public static class C1051a implements d {

            /* renamed from: a  reason: collision with root package name */
            private IBinder f39769a;

            public C1051a(IBinder iBinder) {
                this.f39769a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f39769a;
            }

            @Override // com.tencent.tmsqmsp.sdk.g.b.d
            public boolean f() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
                    boolean z = false;
                    this.f39769a.transact(2, obtain, obtain2, 0);
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

            @Override // com.tencent.tmsqmsp.sdk.g.b.d
            public String i() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
                    this.f39769a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static d a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof d)) ? new C1051a(iBinder) : (d) queryLocalInterface;
        }
    }

    boolean f();

    String i();
}
