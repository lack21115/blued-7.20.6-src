package com.tencent.qmsp.oaid2;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/qmsp/oaid2/f.class */
public interface f extends IInterface {

    /* loaded from: source-8829756-dex2jar.jar:com/tencent/qmsp/oaid2/f$a.class */
    public static abstract class a extends Binder implements f {

        /* renamed from: com.tencent.qmsp.oaid2.f$a$a  reason: collision with other inner class name */
        /* loaded from: source-8829756-dex2jar.jar:com/tencent/qmsp/oaid2/f$a$a.class */
        public static class C0808a implements f {

            /* renamed from: a  reason: collision with root package name */
            public IBinder f24775a;

            public C0808a(IBinder iBinder) {
                this.f24775a = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f24775a;
            }

            /* JADX WARN: Code restructure failed: missing block: B:4:0x002c, code lost:
                if (r0.readInt() == 0) goto L6;
             */
            @Override // com.tencent.qmsp.oaid2.f
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public boolean b() {
                /*
                    r6 = this;
                    android.os.Parcel r0 = android.os.Parcel.obtain()
                    r9 = r0
                    android.os.Parcel r0 = android.os.Parcel.obtain()
                    r10 = r0
                    r0 = 0
                    r8 = r0
                    r0 = r9
                    java.lang.String r1 = "com.asus.msa.SupplementaryDID.IDidAidlInterface"
                    r0.writeInterfaceToken(r1)     // Catch: java.lang.Throwable -> L32 java.lang.Exception -> L4d
                    r0 = r6
                    android.os.IBinder r0 = r0.f24775a     // Catch: java.lang.Throwable -> L32 java.lang.Exception -> L4d
                    r1 = 1
                    r2 = r9
                    r3 = r10
                    r4 = 0
                    boolean r0 = r0.transact(r1, r2, r3, r4)     // Catch: java.lang.Throwable -> L32 java.lang.Exception -> L4d
                    r0 = r10
                    r0.readException()     // Catch: java.lang.Throwable -> L32 java.lang.Exception -> L4d
                    r0 = r10
                    int r0 = r0.readInt()     // Catch: java.lang.Throwable -> L32 java.lang.Exception -> L4d
                    r7 = r0
                    r0 = r7
                    if (r0 != 0) goto L40
                    goto L42
                L32:
                    r11 = move-exception
                    r0 = r10
                    r0.recycle()
                    r0 = r9
                    r0.recycle()
                    r0 = r11
                    throw r0
                L40:
                    r0 = 1
                    r8 = r0
                L42:
                    r0 = r10
                    r0.recycle()
                    r0 = r9
                    r0.recycle()
                    r0 = r8
                    return r0
                L4d:
                    r11 = move-exception
                    goto L40
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.qmsp.oaid2.f.a.C0808a.b():boolean");
            }

            @Override // com.tencent.qmsp.oaid2.f
            public String c() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.asus.msa.SupplementaryDID.IDidAidlInterface");
                    this.f24775a.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    String readString = obtain2.readString();
                    obtain2.recycle();
                    obtain.recycle();
                    return readString;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    return "";
                }
            }

            @Override // com.tencent.qmsp.oaid2.f
            public String i() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.asus.msa.SupplementaryDID.IDidAidlInterface");
                    this.f24775a.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                    String readString = obtain2.readString();
                    obtain2.recycle();
                    obtain.recycle();
                    return readString;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    return "";
                }
            }
        }

        public static f a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.asus.msa.SupplementaryDID.IDidAidlInterface");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof f)) ? new C0808a(iBinder) : (f) queryLocalInterface;
        }
    }

    boolean b();

    String c();

    String i();
}
