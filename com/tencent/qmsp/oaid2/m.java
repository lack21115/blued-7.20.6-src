package com.tencent.qmsp.oaid2;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/qmsp/oaid2/m.class */
public interface m extends IInterface {

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/qmsp/oaid2/m$a.class */
    public static abstract class a extends Binder implements m {

        /* renamed from: com.tencent.qmsp.oaid2.m$a$a  reason: collision with other inner class name */
        /* loaded from: source-8829756-dex2jar.jar:com/tencent/qmsp/oaid2/m$a$a.class */
        public static class C0981a implements m {

            /* renamed from: a  reason: collision with root package name */
            public IBinder f38491a;

            public C0981a(IBinder iBinder) {
                this.f38491a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f38491a;
            }

            @Override // com.tencent.qmsp.oaid2.m
            public boolean h() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
                    boolean z = false;
                    this.f38491a.transact(2, obtain, obtain2, 0);
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

            @Override // com.tencent.qmsp.oaid2.m
            public String m() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
                    this.f38491a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static m a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof m)) ? new C0981a(iBinder) : (m) queryLocalInterface;
        }
    }

    boolean h();

    String m();
}
