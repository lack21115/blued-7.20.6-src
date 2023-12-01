package com.anythink.china.a.a;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/china/a/a/l.class */
public interface l extends IInterface {

    /* loaded from: source-6737240-dex2jar.jar:com/anythink/china/a/a/l$a.class */
    public static final class a implements l {

        /* renamed from: a  reason: collision with root package name */
        private IBinder f6238a;

        public a(IBinder iBinder) {
            this.f6238a = iBinder;
        }

        @Override // com.anythink.china.a.a.l
        public final String a() {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                try {
                    obtain.writeInterfaceToken("com.zui.deviceidservice.IDeviceidInterface");
                    this.f6238a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } catch (Exception e) {
                    e.printStackTrace();
                    obtain2.recycle();
                    obtain.recycle();
                    return null;
                }
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        @Override // android.os.IInterface
        public final IBinder asBinder() {
            return null;
        }

        @Override // com.anythink.china.a.a.l
        public final String b() {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                try {
                    obtain.writeInterfaceToken("com.zui.deviceidservice.IDeviceidInterface");
                    this.f6238a.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readString();
                } catch (Exception e) {
                    e.printStackTrace();
                    obtain2.recycle();
                    obtain.recycle();
                    return null;
                }
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }
    }

    String a();

    String b();
}
