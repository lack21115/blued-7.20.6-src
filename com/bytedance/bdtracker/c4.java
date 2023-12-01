package com.bytedance.bdtracker;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/bdtracker/c4.class */
public interface c4 extends IInterface {

    /* loaded from: source-7206380-dex2jar.jar:com/bytedance/bdtracker/c4$a.class */
    public static abstract class a extends Binder implements c4 {

        /* renamed from: com.bytedance.bdtracker.c4$a$a  reason: collision with other inner class name */
        /* loaded from: source-7206380-dex2jar.jar:com/bytedance/bdtracker/c4$a$a.class */
        public static class C0307a implements c4 {
            public static c4 b;

            /* renamed from: a  reason: collision with root package name */
            public IBinder f21205a;

            public C0307a(IBinder iBinder) {
                this.f21205a = iBinder;
            }

            public String a(String str) {
                String readString;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.coolpad.deviceidsupport.IDeviceIdManager");
                    obtain.writeString(str);
                    if (this.f21205a.transact(2, obtain, obtain2, 0) || a.a() == null) {
                        obtain2.readException();
                        readString = obtain2.readString();
                    } else {
                        readString = ((C0307a) a.a()).a(str);
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return readString;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    throw th;
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f21205a;
            }
        }

        public static c4 a() {
            return C0307a.b;
        }

        public static c4 a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.coolpad.deviceidsupport.IDeviceIdManager");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof c4)) ? new C0307a(iBinder) : (c4) queryLocalInterface;
        }
    }
}
