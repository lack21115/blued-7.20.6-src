package com.heytap.openid.sdk;

import android.content.Context;
import android.content.ServiceConnection;

/* loaded from: source-7994992-dex2jar.jar:com/heytap/openid/sdk/c.class */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public com.heytap.openid.a f8662a = null;
    public String b = null;

    /* renamed from: c  reason: collision with root package name */
    public String f8663c = null;
    public final Object d = new Object();
    public ServiceConnection e = new b(this);

    /* loaded from: source-7994992-dex2jar.jar:com/heytap/openid/sdk/c$a.class */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static final c f8664a = new c(null);
    }

    public /* synthetic */ c(b bVar) {
    }

    public native synchronized String a(Context context, String str);

    public native boolean a(Context context);

    public final native String b(Context context, String str);
}
