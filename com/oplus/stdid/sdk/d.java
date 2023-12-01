package com.oplus.stdid.sdk;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import com.youzan.androidsdk.tool.AppSigning;
import s_a.s_a.s_a.b;

/* loaded from: source-8303388-dex2jar.jar:com/oplus/stdid/sdk/d.class */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public volatile s_a.s_a.s_a.b f10749a = null;
    public String b = null;

    /* renamed from: c  reason: collision with root package name */
    public String f10750c = null;
    public final Object d = new Object();
    public ServiceConnection e = new a();

    /* loaded from: source-8303388-dex2jar.jar:com/oplus/stdid/sdk/d$a.class */
    public class a implements ServiceConnection {
        public a() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            com.oplus.stdid.sdk.b.a("2014");
            d.this.f10749a = b.a.a(iBinder);
            synchronized (d.this.d) {
                com.oplus.stdid.sdk.b.a("2015");
                d.this.d.notify();
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            com.oplus.stdid.sdk.b.a("2016");
            d.this.f10749a = null;
        }
    }

    /* loaded from: source-8303388-dex2jar.jar:com/oplus/stdid/sdk/d$b.class */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static final d f10752a = new d();
    }

    public String a(Context context, String str) {
        String str2;
        String b2;
        synchronized (this) {
            if (this.f10749a == null) {
                com.oplus.stdid.sdk.b.a("2009");
                Intent intent = new Intent();
                intent.setComponent(new ComponentName("com.oplus.stdid", "com.oplus.stdid.IdentifyService"));
                intent.setAction("action.com.oplus.stdid.ID_SERVICE");
                com.oplus.stdid.sdk.b.a("2012");
                try {
                    if (context.bindService(intent, this.e, 1)) {
                        com.oplus.stdid.sdk.b.a("2013");
                        if (this.f10749a == null) {
                            synchronized (this.d) {
                                try {
                                    if (this.f10749a == null) {
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
                if (this.f10749a == null) {
                    str2 = "1004";
                } else {
                    try {
                        com.oplus.stdid.sdk.b.a("2010");
                        b2 = b(context, str);
                    } catch (RemoteException e3) {
                        str2 = "1005";
                    }
                }
                Log.e("StdIDHelper", str2);
                b2 = "";
            } else {
                try {
                    com.oplus.stdid.sdk.b.a("2011");
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
                if (this.f10749a != null) {
                    com.oplus.stdid.sdk.b.a("2019");
                    context.unbindService(this.e);
                    this.f10749a = null;
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
        if (TextUtils.isEmpty(this.f10750c)) {
            this.f10750c = s_a.s_a.s_a.a.a.a(context, this.b, AppSigning.SHA1);
        }
        com.oplus.stdid.sdk.b.a("2017");
        if (this.f10749a != null) {
            String a2 = this.f10749a.a(this.b, this.f10750c, str);
            com.oplus.stdid.sdk.b.a("2018");
            return TextUtils.isEmpty(a2) ? "" : a2;
        }
        Log.e("StdIDHelper", context.getPackageName() + " 1009");
        return "";
    }
}
