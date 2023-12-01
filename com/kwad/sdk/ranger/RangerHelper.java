package com.kwad.sdk.ranger;

import android.text.TextUtils;
import android.util.Log;
import com.kwad.sdk.ranger.c;
import com.kwad.sdk.utils.aw;
import com.kwad.sdk.utils.g;
import com.kwad.sdk.utils.s;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLSocket;
import okhttp3.Address;
import okhttp3.Call;
import okhttp3.ConnectionPool;
import okhttp3.ConnectionSpec;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Route;
import okhttp3.internal.Internal;
import okhttp3.internal.Version;
import okhttp3.internal.cache.InternalCache;
import okhttp3.internal.connection.RealConnection;
import okhttp3.internal.connection.RouteDatabase;
import okhttp3.internal.connection.StreamAllocation;
import okhttp3.internal.http.HttpCodec;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/ranger/RangerHelper.class */
public class RangerHelper {
    private static volatile boolean aya = false;
    private static List<String> ayb;
    private static d ayc;
    private static List<OkHttpClient> ayd = new ArrayList();

    private static boolean Cq() {
        try {
            String a2 = Version.a();
            if (TextUtils.isEmpty(a2)) {
                com.kwad.sdk.core.d.b.d("Ranger_Helper", "TextUtils.isEmpty(userAgent)");
                return false;
            }
            com.kwad.sdk.core.d.b.d("Ranger_Helper", "userAgent:" + a2);
            String replace = a2.replace("okhttp/", "");
            if (replace.startsWith("3.")) {
                int parseInt = Integer.parseInt(replace.replaceAll("\\.", ""));
                return parseInt >= 390 && parseInt <= 3131;
            }
            return false;
        } catch (Throwable th) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(final StreamAllocation streamAllocation) {
        g.schedule(new aw() { // from class: com.kwad.sdk.ranger.RangerHelper.2
            @Override // com.kwad.sdk.utils.aw
            public final void doTask() {
                RangerHelper.h(s.d(streamAllocation, "call"));
            }
        }, 0L, TimeUnit.SECONDS);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void c(d dVar) {
        ayc = dVar;
        ayb = dVar.axT;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void h(Object obj) {
        if (obj == null) {
            com.kwad.sdk.core.d.b.d("Ranger_Helper", "real call null");
            return;
        }
        try {
            OkHttpClient okHttpClient = (OkHttpClient) s.d(obj, "client");
            if (ayd.contains(okHttpClient)) {
                com.kwad.sdk.core.d.b.d("Ranger_Helper", "already invoke");
                return;
            }
            ayd.add(okHttpClient);
            Object d = s.d(obj, "eventListener");
            if (d != null) {
                com.kwad.sdk.core.d.b.d("Ranger_Helper", "eventListener.getClass().getName():" + d.getClass().getName());
                s.a(okHttpClient, "eventListenerFactory", new c(d, new c.a() { // from class: com.kwad.sdk.ranger.RangerHelper.3
                }));
            }
        } catch (Throwable th) {
            com.kwad.sdk.core.d.b.e("Ranger_Helper", Log.getStackTraceString(th));
        }
    }

    public static void replaceInternal() {
        if (aya) {
            return;
        }
        if (!Cq()) {
            aya = true;
            return;
        }
        final Internal internal = (Internal) s.c(Internal.class, "instance");
        if (internal == null) {
            aya = true;
            return;
        }
        com.kwad.sdk.core.d.b.d("Ranger_Helper", "internal:" + internal.getClass().getName());
        try {
            s.a(internal, "instance", new Internal() { // from class: com.kwad.sdk.ranger.RangerHelper.1
                public final void acquire(ConnectionPool connectionPool, Address address, StreamAllocation streamAllocation, Route route) {
                    RangerHelper.a(streamAllocation);
                    s.b((Object) internal, "acquire", connectionPool, address, streamAllocation, route);
                }

                public final void addLenient(Headers.Builder builder, String str) {
                    try {
                        internal.addLenient(builder, str);
                    } catch (Throwable th) {
                        com.kwad.sdk.core.d.b.e("Ranger_Helper", Log.getStackTraceString(th));
                    }
                }

                public final void addLenient(Headers.Builder builder, String str, String str2) {
                    try {
                        internal.addLenient(builder, str, str2);
                    } catch (Throwable th) {
                        com.kwad.sdk.core.d.b.e("Ranger_Helper", Log.getStackTraceString(th));
                    }
                }

                public final void apply(ConnectionSpec connectionSpec, SSLSocket sSLSocket, boolean z) {
                    try {
                        internal.apply(connectionSpec, sSLSocket, z);
                    } catch (Throwable th) {
                        com.kwad.sdk.core.d.b.e("Ranger_Helper", Log.getStackTraceString(th));
                    }
                }

                public final int code(Response.Builder builder) {
                    try {
                        return internal.code(builder);
                    } catch (Throwable th) {
                        com.kwad.sdk.core.d.b.e("Ranger_Helper", Log.getStackTraceString(th));
                        return -1;
                    }
                }

                public final boolean connectionBecameIdle(ConnectionPool connectionPool, RealConnection realConnection) {
                    try {
                        return internal.connectionBecameIdle(connectionPool, realConnection);
                    } catch (Throwable th) {
                        com.kwad.sdk.core.d.b.e("Ranger_Helper", Log.getStackTraceString(th));
                        return false;
                    }
                }

                public final Socket deduplicate(ConnectionPool connectionPool, Address address, StreamAllocation streamAllocation) {
                    try {
                        return internal.deduplicate(connectionPool, address, streamAllocation);
                    } catch (Throwable th) {
                        com.kwad.sdk.core.d.b.e("Ranger_Helper", Log.getStackTraceString(th));
                        return null;
                    }
                }

                public final boolean equalsNonHost(Address address, Address address2) {
                    Boolean bool = (Boolean) s.b((Object) internal, "equalsNonHost", address, address2);
                    if (bool != null) {
                        return bool.booleanValue();
                    }
                    return false;
                }

                public final RealConnection get(ConnectionPool connectionPool, Address address, StreamAllocation streamAllocation) {
                    return (RealConnection) s.b((Object) internal, MonitorConstants.CONNECT_TYPE_GET, connectionPool, address, streamAllocation);
                }

                public final RealConnection get(ConnectionPool connectionPool, Address address, StreamAllocation streamAllocation, Route route) {
                    RangerHelper.a(streamAllocation);
                    return (RealConnection) s.b((Object) internal, MonitorConstants.CONNECT_TYPE_GET, connectionPool, address, streamAllocation, route);
                }

                public final HttpUrl getHttpUrlChecked(String str) {
                    return (HttpUrl) s.b((Object) internal, "getHttpUrlChecked", str);
                }

                public final void initCodec(Response.Builder builder, HttpCodec httpCodec) {
                    s.b((Object) internal, "initCodec", builder, httpCodec);
                }

                public final boolean isInvalidHttpUrlHost(IllegalArgumentException illegalArgumentException) {
                    Boolean bool = (Boolean) s.b((Object) internal, "isInvalidHttpUrlHost", illegalArgumentException);
                    if (bool != null) {
                        return bool.booleanValue();
                    }
                    return false;
                }

                public final Call newWebSocketCall(OkHttpClient okHttpClient, Request request) {
                    try {
                        return internal.newWebSocketCall(okHttpClient, request);
                    } catch (Throwable th) {
                        com.kwad.sdk.core.d.b.e("Ranger_Helper", Log.getStackTraceString(th));
                        return null;
                    }
                }

                public final void put(ConnectionPool connectionPool, RealConnection realConnection) {
                    s.b((Object) internal, "put", connectionPool, realConnection);
                }

                public final RouteDatabase routeDatabase(ConnectionPool connectionPool) {
                    try {
                        return internal.routeDatabase(connectionPool);
                    } catch (Throwable th) {
                        com.kwad.sdk.core.d.b.e("Ranger_Helper", Log.getStackTraceString(th));
                        return null;
                    }
                }

                public final void setCache(OkHttpClient.Builder builder, InternalCache internalCache) {
                    try {
                        internal.setCache(builder, internalCache);
                    } catch (Throwable th) {
                        com.kwad.sdk.core.d.b.e("Ranger_Helper", Log.getStackTraceString(th));
                    }
                }

                public final StreamAllocation streamAllocation(Call call) {
                    try {
                        return internal.streamAllocation(call);
                    } catch (Throwable th) {
                        com.kwad.sdk.core.d.b.e("Ranger_Helper", Log.getStackTraceString(th));
                        return null;
                    }
                }

                public final IOException timeoutExit(Call call, IOException iOException) {
                    return (IOException) s.b((Object) internal, "timeoutExit", call, iOException);
                }
            });
            aya = true;
        } catch (Throwable th) {
            aya = true;
            com.kwad.sdk.core.d.b.e("Ranger_Helper", Log.getStackTraceString(th));
        }
    }
}
