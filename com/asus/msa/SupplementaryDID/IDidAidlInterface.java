package com.asus.msa.SupplementaryDID;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: source-8756600-dex2jar.jar:com/asus/msa/SupplementaryDID/IDidAidlInterface.class */
public interface IDidAidlInterface extends IInterface {

    /* loaded from: source-8756600-dex2jar.jar:com/asus/msa/SupplementaryDID/IDidAidlInterface$Stub.class */
    public static abstract class Stub extends Binder implements IDidAidlInterface {

        /* loaded from: source-8756600-dex2jar.jar:com/asus/msa/SupplementaryDID/IDidAidlInterface$Stub$Proxy.class */
        public static class Proxy implements IDidAidlInterface {

            /* renamed from: a  reason: collision with root package name */
            public IBinder f6377a;

            public Proxy(IBinder iBinder) {
                this.f6377a = iBinder;
            }

            @Override // com.asus.msa.SupplementaryDID.IDidAidlInterface
            public native boolean a();

            @Override // android.os.IInterface
            public native IBinder asBinder();

            @Override // com.asus.msa.SupplementaryDID.IDidAidlInterface
            public native String getAAID();

            @Override // com.asus.msa.SupplementaryDID.IDidAidlInterface
            public native String getOAID();

            @Override // com.asus.msa.SupplementaryDID.IDidAidlInterface
            public native String getUDID();

            @Override // com.asus.msa.SupplementaryDID.IDidAidlInterface
            public native String getVAID();
        }

        public Stub() {
            attachInterface(this, "com.asus.msa.SupplementaryDID.IDidAidlInterface");
        }

        public static native IDidAidlInterface a(IBinder iBinder);

        @Override // android.os.IInterface
        public native IBinder asBinder();

        @Override // android.os.Binder
        public native boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2);
    }

    boolean a();

    String getAAID();

    String getOAID();

    String getUDID();

    String getVAID();
}
