package com.oplus.stdid.sdk;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import com.anythink.core.api.ErrorCode;
import com.youzan.androidsdk.tool.AppSigning;
import s_a.s_a.s_a.b;

/* loaded from: source-8303388-dex2jar.jar:com/oplus/stdid/sdk/d.class */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public volatile s_a.s_a.s_a.b f24436a = null;
    public String b = null;

    /* renamed from: c  reason: collision with root package name */
    public String f24437c = null;
    public final Object d = new Object();
    public ServiceConnection e = new a();

    /* loaded from: source-8303388-dex2jar.jar:com/oplus/stdid/sdk/d$a.class */
    public class a implements ServiceConnection {
        public a() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            com.oplus.stdid.sdk.b.a(ErrorCode.inNetworkErrorCodeRequestFailPacing);
            d.this.f24436a = b.a.a(iBinder);
            synchronized (d.this.d) {
                com.oplus.stdid.sdk.b.a("2015");
                d.this.d.notify();
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            com.oplus.stdid.sdk.b.a("2016");
            d.this.f24436a = null;
        }
    }

    /* loaded from: source-8303388-dex2jar.jar:com/oplus/stdid/sdk/d$b.class */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static final d f24439a = new d();
    }

    public String a(Context context, String str) {
        String str2;
        String b2;
        synchronized (this) {
            if (this.f24436a == null) {
                com.oplus.stdid.sdk.b.a(ErrorCode.loadCappingError);
                Intent intent = new Intent();
                intent.setComponent(new ComponentName("com.oplus.stdid", "com.oplus.stdid.IdentifyService"));
                intent.setAction("action.com.oplus.stdid.ID_SERVICE");
                com.oplus.stdid.sdk.b.a(ErrorCode.c2sBiddingCacheError);
                try {
                    if (context.bindService(intent, this.e, 1)) {
                        com.oplus.stdid.sdk.b.a(ErrorCode.networkFirmIdfilterSourceError);
                        if (this.f24436a == null) {
                            synchronized (this.d) {
                                try {
                                    if (this.f24436a == null) {
                                        this.d.wait(10000L);
                                    }
                                } catch (InterruptedException e) {
                                    Log.e("StdIDHelper", "1006");
                                }
                            }
                        }
                    } else {
                        Log.e("StdIDHelper", "1007");
                    }
                } catch (Exception e2) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("1008 ");
                    sb.append(e2.getMessage() != null ? e2.getMessage() : e2.getLocalizedMessage());
                    Log.e("StdIDHelper", sb.toString());
                }
                if (this.f24436a == null) {
                    str2 = "1004";
                } else {
                    try {
                        com.oplus.stdid.sdk.b.a(ErrorCode.filterSourceError);
                        b2 = b(context, str);
                    } catch (RemoteException e3) {
                        str2 = "1005";
                    }
                }
                Log.e("StdIDHelper", str2);
                b2 = "";
            } else {
                try {
                    com.oplus.stdid.sdk.b.a(ErrorCode.loadInShowingFilter);
                    b2 = b(context, str);
                } catch (RemoteException e4) {
                    str2 = "1005";
                }
            }
        }
        return b2;
    }

    public void a(Context context) {
        synchronized (this) {
            try {
                if (this.f24436a != null) {
                    com.oplus.stdid.sdk.b.a("2019");
                    context.unbindService(this.e);
                    this.f24436a = null;
                }
            } catch (Exception e) {
                Log.e("StdIDHelper", "1010");
            }
        }
    }

    public final String b(Context context, String str) {
        if (TextUtils.isEmpty(this.b)) {
            this.b = context.getPackageName();
        }
        if (TextUtils.isEmpty(this.f24437c)) {
            this.f24437c = s_a.s_a.s_a.a.a.a(context, this.b, AppSigning.SHA1);
        }
        com.oplus.stdid.sdk.b.a("2017");
        if (this.f24436a != null) {
            String a2 = this.f24436a.a(this.b, this.f24437c, str);
            com.oplus.stdid.sdk.b.a("2018");
            return TextUtils.isEmpty(a2) ? "" : a2;
        }
        Log.e("StdIDHelper", context.getPackageName() + " 1009");
        return "";
    }
}
