package com.tencent.tmsqmsp.oaid2;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/tmsqmsp/oaid2/q.class */
public interface q extends IInterface {

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/tmsqmsp/oaid2/q$a.class */
    public static abstract class a extends Binder implements q {

        /* renamed from: com.tencent.tmsqmsp.oaid2.q$a$a  reason: collision with other inner class name */
        /* loaded from: source-8829756-dex2jar.jar:com/tencent/tmsqmsp/oaid2/q$a$a.class */
        public static class C0871a implements q {

            /* renamed from: a  reason: collision with root package name */
            public IBinder f25968a;

            public C0871a(IBinder iBinder) {
                this.f25968a = iBinder;
            }

            @Override // com.tencent.tmsqmsp.oaid2.q
            public String a() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    try {
                        obtain.writeInterfaceToken("com.bun.lib.MsaIdInterface");
                        this.f25968a.transact(3, obtain, obtain2, 0);
                        obtain2.readException();
                        return obtain2.readString();
                    } catch (RemoteException e) {
                        e.printStackTrace();
                        obtain2.recycle();
                        obtain.recycle();
                        return "";
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f25968a;
            }

            @Override // com.tencent.tmsqmsp.oaid2.q
            public boolean c() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                boolean z = false;
                try {
                    try {
                        obtain.writeInterfaceToken("com.bun.lib.MsaIdInterface");
                        this.f25968a.transact(2, obtain, obtain2, 0);
                        obtain2.readException();
                        if (obtain2.readInt() != 0) {
                            z = true;
                        }
                    } catch (RemoteException e) {
                        e.printStackTrace();
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

            @Override // com.tencent.tmsqmsp.oaid2.q
            public String d() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    try {
                        obtain.writeInterfaceToken("com.bun.lib.MsaIdInterface");
                        this.f25968a.transact(5, obtain, obtain2, 0);
                        obtain2.readException();
                        return obtain2.readString();
                    } catch (RemoteException e) {
                        e.printStackTrace();
                        obtain2.recycle();
                        obtain.recycle();
                        return "";
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.tencent.tmsqmsp.oaid2.q
            public void f() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.bun.lib.MsaIdInterface");
                    this.f25968a.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                } catch (RemoteException e) {
                    e.printStackTrace();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            /* JADX WARN: Code restructure failed: missing block: B:4:0x002c, code lost:
                if (r0.readInt() != 0) goto L8;
             */
            @Override // com.tencent.tmsqmsp.oaid2.q
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public boolean g() {
                /*
                    r6 = this;
                    android.os.Parcel r0 = android.os.Parcel.obtain()
                    r9 = r0
                    android.os.Parcel r0 = android.os.Parcel.obtain()
                    r10 = r0
                    r0 = 1
                    r8 = r0
                    r0 = r9
                    java.lang.String r1 = "com.bun.lib.MsaIdInterface"
                    r0.writeInterfaceToken(r1)     // Catch: java.lang.Throwable -> L32 android.os.RemoteException -> L37
                    r0 = r6
                    android.os.IBinder r0 = r0.f25968a     // Catch: java.lang.Throwable -> L32 android.os.RemoteException -> L37
                    r1 = 1
                    r2 = r9
                    r3 = r10
                    r4 = 0
                    boolean r0 = r0.transact(r1, r2, r3, r4)     // Catch: java.lang.Throwable -> L32 android.os.RemoteException -> L37
                    r0 = r10
                    r0.readException()     // Catch: java.lang.Throwable -> L32 android.os.RemoteException -> L37
                    r0 = r10
                    int r0 = r0.readInt()     // Catch: java.lang.Throwable -> L32 android.os.RemoteException -> L37
                    r7 = r0
                    r0 = r7
                    if (r0 == 0) goto L3e
                    goto L40
                L32:
                    r11 = move-exception
                    goto L4b
                L37:
                    r11 = move-exception
                    r0 = r11
                    r0.printStackTrace()     // Catch: java.lang.Throwable -> L32
                L3e:
                    r0 = 0
                    r8 = r0
                L40:
                    r0 = r10
                    r0.recycle()
                    r0 = r9
                    r0.recycle()
                    r0 = r8
                    return r0
                L4b:
                    r0 = r10
                    r0.recycle()
                    r0 = r9
                    r0.recycle()
                    r0 = r11
                    throw r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.tmsqmsp.oaid2.q.a.C0871a.g():boolean");
            }
        }

        public static q a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.bun.lib.MsaIdInterface");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof q)) ? new C0871a(iBinder) : (q) queryLocalInterface;
        }
    }

    String a();

    boolean c();

    String d();

    void f();

    boolean g();
}
