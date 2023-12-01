package com.bun.miitmdid.supplier.msa;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.bun.lib.c;

/* loaded from: source-7206380-dex2jar.jar:com/bun/miitmdid/supplier/msa/MsaClient.class */
public class MsaClient {
    private static String TAG = "MSA Client library";
    private static String TARGET_PACKAGE = "com.mdid.msa";
    private com.bun.miitmdid.c.e.a _BindService;
    private ServiceConnection mConnection;
    private Context mContext;
    private c mDeviceidInterface;

    /* loaded from: source-7206380-dex2jar.jar:com/bun/miitmdid/supplier/msa/MsaClient$a.class */
    class a implements ServiceConnection {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ com.bun.miitmdid.c.e.a f21162a;

        a(com.bun.miitmdid.c.e.a aVar) {
            this.f21162a = aVar;
        }

        @Override // android.content.ServiceConnection
        public native synchronized void onServiceConnected(ComponentName componentName, IBinder iBinder);

        @Override // android.content.ServiceConnection
        public native void onServiceDisconnected(ComponentName componentName);
    }

    public MsaClient(Context context, com.bun.miitmdid.c.e.a aVar) {
        if (context == null) {
            throw new NullPointerException("Context can not be null.");
        }
        this.mContext = context;
        this._BindService = aVar;
        this.mConnection = new a(aVar);
    }

    public static native boolean CheckService(Context context);

    public static native void StartMsaKlService(Context context, String str);

    static native /* synthetic */ c access$000(MsaClient msaClient);

    static native /* synthetic */ c access$002(MsaClient msaClient, c cVar);

    static native /* synthetic */ String access$100();

    public native void BindService(String str);

    public native String getAAID();

    public native String getOAID();

    public native String getUDID();

    public native String getVAID();

    public native boolean isSupported();

    public native void shutdown();
}
