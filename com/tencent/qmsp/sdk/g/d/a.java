package com.tencent.qmsp.sdk.g.d;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/qmsp/sdk/g/d/a.class */
public interface a extends IInterface {

    /* renamed from: com.tencent.qmsp.sdk.g.d.a$a  reason: collision with other inner class name */
    /* loaded from: source-8829756-dex2jar.jar:com/tencent/qmsp/sdk/g/d/a$a.class */
    public static abstract class AbstractBinderC0827a extends Binder implements a {

        /* renamed from: com.tencent.qmsp.sdk.g.d.a$a$a  reason: collision with other inner class name */
        /* loaded from: source-8829756-dex2jar.jar:com/tencent/qmsp/sdk/g/d/a$a$a.class */
        static class C0828a implements a {

            /* renamed from: a  reason: collision with root package name */
            private IBinder f24934a;

            C0828a(IBinder iBinder) {
                this.f24934a = iBinder;
            }

            @Override // com.tencent.qmsp.sdk.g.d.a
            public String a() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    try {
                        obtain.writeInterfaceToken("com.bun.lib.MsaIdInterface");
                        this.f24934a.transact(3, obtain, obtain2, 0);
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
                return this.f24934a;
            }

            @Override // com.tencent.qmsp.sdk.g.d.a
            public String b() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    try {
                        obtain.writeInterfaceToken("com.bun.lib.MsaIdInterface");
                        this.f24934a.transact(5, obtain, obtain2, 0);
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

            @Override // com.tencent.qmsp.sdk.g.d.a
            public boolean c() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                boolean z = false;
                try {
                    try {
                        obtain.writeInterfaceToken("com.bun.lib.MsaIdInterface");
                        this.f24934a.transact(2, obtain, obtain2, 0);
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

            /* JADX WARN: Code restructure failed: missing block: B:4:0x002c, code lost:
                if (r0.readInt() != 0) goto L8;
             */
            @Override // com.tencent.qmsp.sdk.g.d.a
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public boolean d() {
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
                    android.os.IBinder r0 = r0.f24934a     // Catch: java.lang.Throwable -> L32 android.os.RemoteException -> L37
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
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.qmsp.sdk.g.d.a.AbstractBinderC0827a.C0828a.d():boolean");
            }

            @Override // com.tencent.qmsp.sdk.g.d.a
            public void e() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    try {
                        obtain.writeInterfaceToken("com.bun.lib.MsaIdInterface");
                        this.f24934a.transact(6, obtain, obtain2, 0);
                        obtain2.readException();
                    } catch (RemoteException e) {
                        e.printStackTrace();
                    }
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static a a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.bun.lib.MsaIdInterface");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof a)) ? new C0828a(iBinder) : (a) queryLocalInterface;
        }
    }

    String a();

    String b();

    boolean c();

    boolean d();

    void e();
}
