package com.zui.deviceidservice;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: source-8829756-dex2jar.jar:com/zui/deviceidservice/IDeviceidInterface.class */
public interface IDeviceidInterface extends IInterface {

    /* loaded from: source-8829756-dex2jar.jar:com/zui/deviceidservice/IDeviceidInterface$Stub.class */
    public static abstract class Stub extends Binder implements IDeviceidInterface {

        /* loaded from: source-8829756-dex2jar.jar:com/zui/deviceidservice/IDeviceidInterface$Stub$Proxy.class */
        static class Proxy implements IDeviceidInterface {

            /* renamed from: a  reason: collision with root package name */
            private IBinder f42093a;

            Proxy(IBinder iBinder) {
                this.f42093a = iBinder;
            }

            @Override // com.zui.deviceidservice.IDeviceidInterface
            public native boolean a();

            @Override // android.os.IInterface
            public native IBinder asBinder();

            @Override // com.zui.deviceidservice.IDeviceidInterface
            public native String getAAID(String str);

            @Override // com.zui.deviceidservice.IDeviceidInterface
            public native String getOAID();

            @Override // com.zui.deviceidservice.IDeviceidInterface
            public native String getUDID();

            @Override // com.zui.deviceidservice.IDeviceidInterface
            public native String getVAID(String str);
        }

        public Stub() {
            attachInterface(this, "com.zui.deviceidservice.IDeviceidInterface");
        }

        public static native IDeviceidInterface a(IBinder iBinder);

        @Override // android.os.IInterface
        public native IBinder asBinder();

        @Override // android.os.Binder
        public native boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2);
    }

    boolean a();

    String getAAID(String str);

    String getOAID();

    String getUDID();

    String getVAID(String str);
}
