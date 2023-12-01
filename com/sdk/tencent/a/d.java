package com.sdk.tencent.a;

import android.content.Context;
import com.sdk.tencent.base.module.manager.SDKManager;
import com.tencent.qcloud.core.http.HttpConstants;
import java.util.ArrayList;
import java.util.UUID;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

/* loaded from: source-8303388-dex2jar.jar:com/sdk/tencent/a/d.class */
public class d<T> {

    /* renamed from: c  reason: collision with root package name */
    public static final String f14320c = "d";
    public static boolean d = com.sdk.tencent.f.c.b;
    public static final String e = UUID.randomUUID().toString();
    public static final HostnameVerifier f = new a();

    /* renamed from: a  reason: collision with root package name */
    public Context f14321a;
    public e<T> b;

    /* loaded from: source-8303388-dex2jar.jar:com/sdk/tencent/a/d$a.class */
    public static final class a implements HostnameVerifier {
        @Override // javax.net.ssl.HostnameVerifier
        public boolean verify(String str, SSLSession sSLSession) {
            return true;
        }
    }

    /* loaded from: source-8303388-dex2jar.jar:com/sdk/tencent/a/d$b.class */
    public enum b {
        GET("GET"),
        POST("POST"),
        PUT("PUT"),
        HEAD("HEAD"),
        MOVE("MOVE"),
        COPY("COPY"),
        DELETE("DELETE"),
        OPTIONS("OPTIONS"),
        TRACE(HttpConstants.RequestMethod.TRACE),
        CONNECT("CONNECT");
        

        /* renamed from: a  reason: collision with root package name */
        public final String f14323a;

        b(String str) {
            this.f14323a = str;
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.f14323a;
        }
    }

    public d(Context context, e<T> eVar) {
        this.f14321a = context;
        this.b = eVar;
    }

    public e<T> a() {
        return this.b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:65:0x01e6 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x01e8  */
    /* JADX WARN: Type inference failed for: r0v88, types: [java.net.HttpURLConnection] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.net.HttpURLConnection a(java.lang.String r6, boolean r7) {
        /*
            Method dump skipped, instructions count: 515
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sdk.tencent.a.d.a(java.lang.String, boolean):java.net.HttpURLConnection");
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0083  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.net.HttpURLConnection a(java.net.HttpURLConnection r6) {
        /*
            Method dump skipped, instructions count: 719
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sdk.tencent.a.d.a(java.net.HttpURLConnection):java.net.HttpURLConnection");
    }

    public final boolean a(String str) {
        return (!SDKManager.isIsStrong() || str.contains("/api/netm/v1.0/qhbt") || str.contains("/api/netm/v1.0/qhbv") || str.contains("/st/api/v1.0/ses")) ? false : true;
    }

    public String b() {
        e<T> eVar;
        String str;
        StringBuilder sb;
        String str2;
        try {
            eVar = this.b;
        } catch (Exception e2) {
            com.sdk.tencent.n.b.a(f14320c, e2.getMessage(), Boolean.valueOf(d));
            return null;
        }
        if (eVar != null) {
            String str3 = eVar.f14324a;
            String str4 = eVar.b;
            if (!str3.equals("GET")) {
                this.b.getClass();
                str = str4;
                if (com.sdk.tencent.n.b.b(null).booleanValue()) {
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(str4);
                    sb2.append("?unikey=");
                    sb = sb2;
                    str2 = null;
                    sb.append(str2);
                    str = sb.toString();
                }
                return str;
            }
            e<T> eVar2 = this.b;
            String a2 = eVar2.a(eVar2.f14325c);
            str = str4;
            if (com.sdk.tencent.n.b.b(a2).booleanValue()) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append(str4);
                sb3.append("?");
                str2 = a2;
                sb = sb3;
                sb.append(str2);
                str = sb.toString();
            }
            return str;
            com.sdk.tencent.n.b.a(f14320c, e2.getMessage(), Boolean.valueOf(d));
            return null;
        }
        return null;
    }

    public int c() {
        String str = this.b.b;
        if (a(str)) {
            ArrayList arrayList = new ArrayList();
            if (com.sdk.tencent.n.b.b(str).booleanValue()) {
                arrayList.add(str);
            }
        }
        Context context = this.f14321a;
        int i = com.sdk.tencent.o.b.f14378a;
        return com.sdk.tencent.o.a.a(context).a();
    }
}
