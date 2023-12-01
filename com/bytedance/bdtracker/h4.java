package com.bytedance.bdtracker;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/bdtracker/h4.class */
public interface h4 extends IInterface {

    /* loaded from: source-7206380-dex2jar.jar:com/bytedance/bdtracker/h4$a.class */
    public static abstract class a extends Binder implements h4 {

        /* renamed from: com.bytedance.bdtracker.h4$a$a  reason: collision with other inner class name */
        /* loaded from: source-7206380-dex2jar.jar:com/bytedance/bdtracker/h4$a$a.class */
        public static class C0142a implements h4 {
            public static h4 b;

            /* renamed from: a  reason: collision with root package name */
            public IBinder f7621a;

            public C0142a(IBinder iBinder) {
                this.f7621a = iBinder;
            }

            public String a() {
                String readString;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bun.lib.MsaIdInterface");
                    if (this.f7621a.transact(1, obtain, obtain2, 0) || a.a() == null) {
                        obtain2.readException();
                        readString = obtain2.readString();
                    } else {
                        readString = ((C0142a) a.a()).a();
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
                return this.f7621a;
            }
        }

        public static h4 a() {
            return C0142a.b;
        }

        public static h4 a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.bun.lib.MsaIdInterface");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof h4)) ? new C0142a(iBinder) : (h4) queryLocalInterface;
        }
    }
}
