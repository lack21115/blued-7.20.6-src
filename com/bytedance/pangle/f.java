package com.bytedance.pangle;

import android.content.ComponentName;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/pangle/f.class */
public interface f extends IInterface {

    /* loaded from: source-7206380-dex2jar.jar:com/bytedance/pangle/f$a.class */
    public static abstract class a extends Binder implements f {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.bytedance.pangle.f$a$a  reason: collision with other inner class name */
        /* loaded from: source-7206380-dex2jar.jar:com/bytedance/pangle/f$a$a.class */
        public static final class C0317a implements f {

            /* renamed from: a  reason: collision with root package name */
            public static f f21398a;
            private IBinder b;

            C0317a(IBinder iBinder) {
                this.b = iBinder;
            }

            @Override // com.bytedance.pangle.f
            public final int a() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bytedance.pangle.ServiceConnection");
                    if (this.b.transact(2, obtain, obtain2, 0) || a.b() == null) {
                        obtain2.readException();
                        return obtain2.readInt();
                    }
                    return a.b().a();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.bytedance.pangle.f
            public final void a(ComponentName componentName, IBinder iBinder) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bytedance.pangle.ServiceConnection");
                    if (componentName != null) {
                        obtain.writeInt(1);
                        componentName.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    obtain.writeStrongBinder(iBinder);
                    if (this.b.transact(1, obtain, obtain2, 0) || a.b() == null) {
                        obtain2.readException();
                    } else {
                        a.b().a(componentName, iBinder);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public final IBinder asBinder() {
                return this.b;
            }
        }

        public a() {
            attachInterface(this, "com.bytedance.pangle.ServiceConnection");
        }

        public static f a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.bytedance.pangle.ServiceConnection");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof f)) ? new C0317a(iBinder) : (f) queryLocalInterface;
        }

        public static f b() {
            return C0317a.f21398a;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            if (i == 1) {
                parcel.enforceInterface("com.bytedance.pangle.ServiceConnection");
                a(parcel.readInt() != 0 ? ComponentName.CREATOR.createFromParcel(parcel) : null, parcel.readStrongBinder());
                parcel2.writeNoException();
                return true;
            } else if (i != 2) {
                if (i != 1598968902) {
                    return super.onTransact(i, parcel, parcel2, i2);
                }
                parcel2.writeString("com.bytedance.pangle.ServiceConnection");
                return true;
            } else {
                parcel.enforceInterface("com.bytedance.pangle.ServiceConnection");
                int a2 = a();
                parcel2.writeNoException();
                parcel2.writeInt(a2);
                return true;
            }
        }
    }

    int a();

    void a(ComponentName componentName, IBinder iBinder);
}
