package com.tencent.qmsp.sdk.g.c;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/qmsp/sdk/g/c/a.class */
public interface a extends IInterface {

    /* renamed from: com.tencent.qmsp.sdk.g.c.a$a  reason: collision with other inner class name */
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/qmsp/sdk/g/c/a$a.class */
    public static abstract class AbstractBinderC0995a extends Binder implements a {

        /* renamed from: com.tencent.qmsp.sdk.g.c.a$a$a  reason: collision with other inner class name */
        /* loaded from: source-8829756-dex2jar.jar:com/tencent/qmsp/sdk/g/c/a$a$a.class */
        static class C0996a implements a {

            /* renamed from: a  reason: collision with root package name */
            private IBinder f38620a;

            C0996a(IBinder iBinder) {
                this.f38620a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f38620a;
            }

            @Override // com.tencent.qmsp.sdk.g.c.a
            public String b(String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.zui.deviceidservice.IDeviceidInterface");
                    obtain.writeString(str);
                    this.f38620a.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                    String readString = obtain2.readString();
                    obtain2.recycle();
                    obtain.recycle();
                    return readString;
                } catch (RemoteException e) {
                    obtain2.recycle();
                    obtain.recycle();
                    return null;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    throw th;
                }
            }

            @Override // com.tencent.qmsp.sdk.g.c.a
            public boolean c() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                boolean z = false;
                try {
                    obtain.writeInterfaceToken("com.zui.deviceidservice.IDeviceidInterface");
                    this.f38620a.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                } catch (RemoteException e) {
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    throw th;
                }
                obtain2.recycle();
                obtain.recycle();
                return z;
            }

            @Override // com.tencent.qmsp.sdk.g.c.a
            public String g() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.zui.deviceidservice.IDeviceidInterface");
                    this.f38620a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    String readString = obtain2.readString();
                    obtain2.recycle();
                    obtain.recycle();
                    return readString;
                } catch (RemoteException e) {
                    obtain2.recycle();
                    obtain.recycle();
                    return null;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    throw th;
                }
            }
        }

        public static a a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.zui.deviceidservice.IDeviceidInterface");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof a)) ? new C0996a(iBinder) : (a) queryLocalInterface;
        }
    }

    String b(String str);

    boolean c();

    String g();
}
