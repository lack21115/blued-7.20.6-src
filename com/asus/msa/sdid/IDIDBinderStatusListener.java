package com.asus.msa.sdid;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.asus.msa.SupplementaryDID.IDidAidlInterface;

/* loaded from: source-8756600-dex2jar.jar:com/asus/msa/sdid/IDIDBinderStatusListener.class */
public interface IDIDBinderStatusListener extends IInterface {

    /* loaded from: source-8756600-dex2jar.jar:com/asus/msa/sdid/IDIDBinderStatusListener$Stub.class */
    public static abstract class Stub extends Binder implements IDIDBinderStatusListener {

        /* loaded from: source-8756600-dex2jar.jar:com/asus/msa/sdid/IDIDBinderStatusListener$Stub$Proxy.class */
        public static class Proxy implements IDIDBinderStatusListener {

            /* renamed from: a  reason: collision with root package name */
            public IBinder f6378a;

            @Override // com.asus.msa.sdid.IDIDBinderStatusListener
            public native void a(IDidAidlInterface iDidAidlInterface);

            @Override // android.os.IInterface
            public native IBinder asBinder();

            @Override // com.asus.msa.sdid.IDIDBinderStatusListener
            public native void b();
        }

        public Stub() {
            attachInterface(this, "com.asus.msa.sdid.IDIDBinderStatusListener");
        }

        @Override // android.os.IInterface
        public native IBinder asBinder();

        @Override // android.os.Binder
        public native boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2);
    }

    void a(IDidAidlInterface iDidAidlInterface);

    void b();
}
