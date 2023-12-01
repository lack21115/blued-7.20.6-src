package com.anythink.expressad.foundation.g.f.g;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Proxy;
import com.anythink.expressad.foundation.h.o;
import java.util.Locale;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/expressad/foundation/g/f/g/b.class */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private static final String f5063a = b.class.getSimpleName();
    private static volatile b b;

    /* renamed from: c  reason: collision with root package name */
    private static ConnectivityManager f5064c;
    private static com.anythink.expressad.foundation.g.f.c.a d;

    private b() {
    }

    private static b a(Context context) {
        NetworkInfo activeNetworkInfo;
        String lowerCase;
        if (b == null) {
            synchronized (b.class) {
                try {
                    if (b == null) {
                        b = new b();
                        if (context != null) {
                            f5064c = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
                        }
                        d = new com.anythink.expressad.foundation.g.f.c.a();
                        try {
                            if (f5064c != null && (activeNetworkInfo = f5064c.getActiveNetworkInfo()) != null) {
                                if ("wifi".equals(activeNetworkInfo.getTypeName().toLowerCase(Locale.US))) {
                                    d.e = "wifi";
                                    d.d = false;
                                } else {
                                    if (activeNetworkInfo.getExtraInfo() != null && (lowerCase = activeNetworkInfo.getExtraInfo().toLowerCase(Locale.US)) != null) {
                                        if (!lowerCase.startsWith("cmwap") && !lowerCase.startsWith("uniwap") && !lowerCase.startsWith("3gwap")) {
                                            if (lowerCase.startsWith("ctwap")) {
                                                d.d = true;
                                                d.f5023a = lowerCase;
                                                d.b = "10.0.0.200";
                                                d.f5024c = "80";
                                            } else if (lowerCase.startsWith("cmnet") || lowerCase.startsWith("uninet") || lowerCase.startsWith("ctnet") || lowerCase.startsWith("3gnet")) {
                                                d.d = false;
                                                d.f5023a = lowerCase;
                                            }
                                            com.anythink.expressad.foundation.g.f.c.a aVar = d;
                                            aVar.e = aVar.f5023a;
                                        }
                                        d.d = true;
                                        d.f5023a = lowerCase;
                                        d.b = "10.0.0.172";
                                        d.f5024c = "80";
                                        com.anythink.expressad.foundation.g.f.c.a aVar2 = d;
                                        aVar2.e = aVar2.f5023a;
                                    }
                                    String defaultHost = Proxy.getDefaultHost();
                                    int defaultPort = Proxy.getDefaultPort();
                                    if (defaultHost == null || defaultHost.length() <= 0) {
                                        d.d = false;
                                    } else {
                                        d.b = defaultHost;
                                        if ("10.0.0.172".equals(d.b.trim())) {
                                            d.d = true;
                                            d.f5024c = "80";
                                        } else if ("10.0.0.200".equals(d.b.trim())) {
                                            d.d = true;
                                            d.f5024c = "80";
                                        } else {
                                            d.d = false;
                                            d.f5024c = Integer.toString(defaultPort);
                                        }
                                    }
                                    com.anythink.expressad.foundation.g.f.c.a aVar22 = d;
                                    aVar22.e = aVar22.f5023a;
                                }
                            }
                        } catch (Exception e) {
                            o.d(f5063a, e.getMessage());
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return b;
    }

    private static void a() {
        NetworkInfo activeNetworkInfo;
        String lowerCase;
        try {
            if (f5064c == null || (activeNetworkInfo = f5064c.getActiveNetworkInfo()) == null) {
                return;
            }
            if ("wifi".equals(activeNetworkInfo.getTypeName().toLowerCase(Locale.US))) {
                d.e = "wifi";
                d.d = false;
                return;
            }
            if (activeNetworkInfo.getExtraInfo() != null && (lowerCase = activeNetworkInfo.getExtraInfo().toLowerCase(Locale.US)) != null) {
                if (!lowerCase.startsWith("cmwap") && !lowerCase.startsWith("uniwap") && !lowerCase.startsWith("3gwap")) {
                    if (lowerCase.startsWith("ctwap")) {
                        d.d = true;
                        d.f5023a = lowerCase;
                        d.b = "10.0.0.200";
                        d.f5024c = "80";
                    } else if (lowerCase.startsWith("cmnet") || lowerCase.startsWith("uninet") || lowerCase.startsWith("ctnet") || lowerCase.startsWith("3gnet")) {
                        d.d = false;
                        d.f5023a = lowerCase;
                    }
                    com.anythink.expressad.foundation.g.f.c.a aVar = d;
                    aVar.e = aVar.f5023a;
                }
                d.d = true;
                d.f5023a = lowerCase;
                d.b = "10.0.0.172";
                d.f5024c = "80";
                com.anythink.expressad.foundation.g.f.c.a aVar2 = d;
                aVar2.e = aVar2.f5023a;
            }
            String defaultHost = Proxy.getDefaultHost();
            int defaultPort = Proxy.getDefaultPort();
            if (defaultHost == null || defaultHost.length() <= 0) {
                d.d = false;
            } else {
                d.b = defaultHost;
                if ("10.0.0.172".equals(d.b.trim())) {
                    d.d = true;
                    d.f5024c = "80";
                } else if ("10.0.0.200".equals(d.b.trim())) {
                    d.d = true;
                    d.f5024c = "80";
                } else {
                    d.d = false;
                    d.f5024c = Integer.toString(defaultPort);
                }
            }
            com.anythink.expressad.foundation.g.f.c.a aVar22 = d;
            aVar22.e = aVar22.f5023a;
        } catch (Exception e) {
            o.d(f5063a, e.getMessage());
        }
    }

    private static void a(NetworkInfo networkInfo) {
        String lowerCase;
        if (networkInfo.getExtraInfo() != null && (lowerCase = networkInfo.getExtraInfo().toLowerCase(Locale.US)) != null) {
            if (lowerCase.startsWith("cmwap") || lowerCase.startsWith("uniwap") || lowerCase.startsWith("3gwap")) {
                d.d = true;
                d.f5023a = lowerCase;
                d.b = "10.0.0.172";
                d.f5024c = "80";
                return;
            } else if (lowerCase.startsWith("ctwap")) {
                d.d = true;
                d.f5023a = lowerCase;
                d.b = "10.0.0.200";
                d.f5024c = "80";
                return;
            } else if (lowerCase.startsWith("cmnet") || lowerCase.startsWith("uninet") || lowerCase.startsWith("ctnet") || lowerCase.startsWith("3gnet")) {
                d.d = false;
                d.f5023a = lowerCase;
                return;
            }
        }
        String defaultHost = Proxy.getDefaultHost();
        int defaultPort = Proxy.getDefaultPort();
        if (defaultHost == null || defaultHost.length() <= 0) {
            d.d = false;
            return;
        }
        d.b = defaultHost;
        if ("10.0.0.172".equals(d.b.trim())) {
            d.d = true;
            d.f5024c = "80";
        } else if ("10.0.0.200".equals(d.b.trim())) {
            d.d = true;
            d.f5024c = "80";
        } else {
            d.d = false;
            d.f5024c = Integer.toString(defaultPort);
        }
    }

    private static com.anythink.expressad.foundation.g.f.c.a b() {
        return d;
    }
}
