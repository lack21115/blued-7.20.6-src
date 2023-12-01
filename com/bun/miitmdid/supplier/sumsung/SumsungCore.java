package com.bun.miitmdid.supplier.sumsung;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.samsung.android.deviceidservice.IDeviceIdService;

/* loaded from: source-7206380-dex2jar.jar:com/bun/miitmdid/supplier/sumsung/SumsungCore.class */
public class SumsungCore {
    private static boolean DBG = false;
    private static String SAMSUNGTAG = "Samsung_DeviceIdService";
    private static String TAG = "SumsungCore library";
    private com.bun.miitmdid.c.e.a mCallerCallBack;
    private ServiceConnection mConnection;
    private Context mContext;
    private IDeviceIdService mDeviceidInterface;

    /* loaded from: source-7206380-dex2jar.jar:com/bun/miitmdid/supplier/sumsung/SumsungCore$a.class */
    class a implements ServiceConnection {
        a() {
        }

        @Override // android.content.ServiceConnection
        public native synchronized void onServiceConnected(ComponentName componentName, IBinder iBinder);

        @Override // android.content.ServiceConnection
        public native void onServiceDisconnected(ComponentName componentName);
    }

    public SumsungCore(Context context, com.bun.miitmdid.c.e.a aVar) {
        this.mContext = null;
        this.mCallerCallBack = null;
        if (context == null) {
            throw new NullPointerException("Context can not be null.");
        }
        this.mContext = context;
        this.mCallerCallBack = aVar;
        this.mConnection = new a();
        Intent intent = new Intent();
        intent.setClassName("com.samsung.android.deviceidservice", "com.samsung.android.deviceidservice.DeviceIdService");
        if (this.mContext.bindService(intent, this.mConnection, 1)) {
            com.bun.lib.a.b(TAG, "bindService Successful!");
            return;
        }
        this.mContext.unbindService(this.mConnection);
        com.bun.lib.a.b(TAG, "bindService Failed!");
        com.bun.miitmdid.c.e.a aVar2 = this.mCallerCallBack;
        if (aVar2 != null) {
            aVar2.b();
        }
    }

    static native /* synthetic */ IDeviceIdService access$002(SumsungCore sumsungCore, IDeviceIdService iDeviceIdService);

    static native /* synthetic */ com.bun.miitmdid.c.e.a access$100(SumsungCore sumsungCore);

    static native /* synthetic */ String access$200();

    public native String getAAID();

    public native String getOAID();

    public native String getUDID();

    public native String getVAID();

    public native boolean isSupported();

    public native void shutdown();
}
