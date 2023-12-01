package com.getui.gtc.dyc;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.Map;

/* loaded from: source-8110460-dex2jar.jar:com/getui/gtc/dyc/Callback.class */
public interface Callback extends IInterface {

    /* loaded from: source-8110460-dex2jar.jar:com/getui/gtc/dyc/Callback$a.class */
    public static abstract class a extends Binder implements Callback {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: com.getui.gtc.dyc.Callback$a$a  reason: collision with other inner class name */
        /* loaded from: source-8110460-dex2jar.jar:com/getui/gtc/dyc/Callback$a$a.class */
        public static class C0177a implements Callback {

            /* renamed from: a  reason: collision with root package name */
            public static Callback f8357a;

            /* renamed from: c  reason: collision with root package name */
            private IBinder f8358c;

            C0177a(IBinder iBinder) {
                this.f8358c = iBinder;
            }

            @Override // com.getui.gtc.dyc.Callback
            public void a(Map map, Map map2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.getui.gtc.dyc.Callback");
                    obtain.writeMap(map);
                    obtain.writeMap(map2);
                    if (this.f8358c.transact(1, obtain, obtain2, 0) || a.a() == null) {
                        obtain2.readException();
                    } else {
                        a.a().a(map, map2);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f8358c;
            }

            @Override // com.getui.gtc.dyc.Callback
            public void b(String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.getui.gtc.dyc.Callback");
                    obtain.writeString(str);
                    if (this.f8358c.transact(2, obtain, obtain2, 0) || a.a() == null) {
                        obtain2.readException();
                    } else {
                        a.a().b(str);
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public a() {
            attachInterface(this, "com.getui.gtc.dyc.Callback");
        }

        public static Callback a() {
            return C0177a.f8357a;
        }

        public static Callback a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.getui.gtc.dyc.Callback");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof Callback)) ? new C0177a(iBinder) : (Callback) queryLocalInterface;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i == 1) {
                parcel.enforceInterface("com.getui.gtc.dyc.Callback");
                ClassLoader classLoader = getClass().getClassLoader();
                a(parcel.readHashMap(classLoader), parcel.readHashMap(classLoader));
            } else if (i != 2) {
                if (i != 1598968902) {
                    return super.onTransact(i, parcel, parcel2, i2);
                }
                parcel2.writeString("com.getui.gtc.dyc.Callback");
                return true;
            } else {
                parcel.enforceInterface("com.getui.gtc.dyc.Callback");
                b(parcel.readString());
            }
            parcel2.writeNoException();
            return true;
        }
    }

    void a(Map map, Map map2) throws RemoteException;

    void b(String str) throws RemoteException;
}
