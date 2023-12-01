package com.anythink.expressad.advanced.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import android.util.Base64;
import android.webkit.WebView;
import com.anythink.expressad.advanced.js.NativeAdvancedJsUtils;
import com.anythink.expressad.atsignalcommon.windvane.j;
import com.anythink.expressad.foundation.h.k;
import com.anythink.expressad.foundation.h.o;
import org.json.JSONObject;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/advanced/a/c.class */
public class c extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    private static final String f6992a = c.class.getSimpleName();
    private WebView b;

    /* renamed from: c  reason: collision with root package name */
    private int f6993c;

    public c(WebView webView) {
        this.b = webView;
    }

    private static void a(WebView webView, int i) {
        if (webView != null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(NativeAdvancedJsUtils.m, i);
                j.a();
                j.a(webView, NativeAdvancedJsUtils.l, Base64.encodeToString(jSONObject.toString().getBytes(), 2));
            } catch (Throwable th) {
                o.a(f6992a, th.getMessage());
            }
        }
    }

    public final void a() {
        this.b = null;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            if (connectivityManager == null) {
                a(this.b, 0);
            } else if (!com.anythink.expressad.foundation.g.a.bW) {
                a(this.b, 0);
            } else {
                NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                if (activeNetworkInfo == null) {
                    a(this.b, 0);
                } else if (activeNetworkInfo.getState() == NetworkInfo.State.CONNECTING || activeNetworkInfo.getState() == NetworkInfo.State.DISCONNECTING) {
                } else {
                    if (activeNetworkInfo.getType() == 1) {
                        a(this.b, 9);
                        return;
                    }
                    TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                    if (telephonyManager == null) {
                        a(this.b, 0);
                        return;
                    }
                    int networkType = telephonyManager.getNetworkType();
                    this.f6993c = networkType;
                    int a2 = k.a(networkType);
                    this.f6993c = a2;
                    a(this.b, a2);
                }
            }
        } catch (Throwable th) {
            o.a(f6992a, th.getMessage());
        }
    }
}
