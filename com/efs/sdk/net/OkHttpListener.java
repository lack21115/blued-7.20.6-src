package com.efs.sdk.net;

import android.text.TextUtils;
import com.efs.sdk.base.EfsReporter;
import com.efs.sdk.base.core.util.Log;
import com.efs.sdk.base.integrationtesting.IntegrationTestingUtil;
import com.efs.sdk.base.protocol.record.EfsJSONLog;
import com.efs.sdk.net.a.a;
import com.efs.sdk.net.a.b;
import com.efs.sdk.net.a.c;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import okhttp3.Call;
import okhttp3.EventListener;
import okhttp3.Handshake;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;

/* loaded from: source-8110460-dex2jar.jar:com/efs/sdk/net/OkHttpListener.class */
public class OkHttpListener extends EventListener {

    /* renamed from: a  reason: collision with root package name */
    private static AtomicInteger f8221a = new AtomicInteger(0);
    private String b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f8222c;
    private List d = new ArrayList();

    private void a() {
        try {
            c c2 = a.a().c(this.b);
            if (c2 != null) {
                Map<String, Long> map = c2.D;
                Map<String, Long> map2 = c2.E;
                map2.put(c.s, Long.valueOf(com.efs.sdk.net.b.a.a(map, c.f8237a, c.b)));
                map2.put(c.t, Long.valueOf(com.efs.sdk.net.b.a.a(map, c.d, c.e)));
                map2.put(c.u, Long.valueOf(com.efs.sdk.net.b.a.a(map, c.g, c.h)));
                map2.put(c.v, Long.valueOf(com.efs.sdk.net.b.a.a(map, c.f, c.i)));
                map2.put(c.w, Long.valueOf(com.efs.sdk.net.b.a.a(map, c.k, c.l)));
                map2.put(c.x, Long.valueOf(com.efs.sdk.net.b.a.a(map, c.m, c.n)));
                map2.put(c.y, Long.valueOf(com.efs.sdk.net.b.a.a(map, c.o, c.p)));
                map2.put(c.z, Long.valueOf(com.efs.sdk.net.b.a.a(map, c.q, c.r)));
                b();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void a(String str) {
        Map<String, Long> map;
        try {
            c c2 = a.a().c(this.b);
            if (c2 == null || (map = c2.D) == null) {
                return;
            }
            map.put(str, Long.valueOf(System.currentTimeMillis()));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void b() {
        try {
            c c2 = a.a().c(this.b);
            b a2 = a.a().a(this.b);
            if (c2 == null || a2 == null) {
                return;
            }
            Map<String, Long> map = c2.D;
            Map<String, Long> map2 = c2.E;
            Log.i("NetTrace-Listener", a2.toString());
            if (TextUtils.isEmpty(c2.B)) {
                Log.d("NetTrace-Listener", "url is null.");
                return;
            }
            EfsJSONLog efsJSONLog = new EfsJSONLog("netperf");
            if (map.containsKey(c.d)) {
                efsJSONLog.put("wd_dns", map.get(c.d));
            }
            if (map.containsKey(c.e)) {
                efsJSONLog.put("wd_dnstm", map.get(c.e));
            }
            if (map2.containsKey(c.t)) {
                efsJSONLog.put("wl_dns", map2.get(c.t));
            }
            if (map.containsKey(c.f)) {
                efsJSONLog.put("wd_tcp", map.get(c.f));
            }
            if (map.containsKey(c.i)) {
                efsJSONLog.put("wd_tcptm", map.get(c.i));
            }
            if (map2.containsKey(c.v)) {
                efsJSONLog.put("wl_tcp", map2.get(c.v));
            }
            if (map.containsKey(c.g)) {
                efsJSONLog.put("wd_ssl", map.get(c.g));
            }
            if (map.containsKey(c.h)) {
                efsJSONLog.put("wd_ssltm", map.get(c.h));
            }
            if (map2.containsKey(c.u)) {
                efsJSONLog.put("wl_ssl", map2.get(c.u));
            }
            if (map.containsKey(c.k)) {
                efsJSONLog.put("wd_ds", map.get(c.k));
            }
            if (map.containsKey(c.n)) {
                efsJSONLog.put("wd_dstm", map.get(c.n));
            }
            if (map2.containsKey(c.w) && map2.containsKey(c.x)) {
                efsJSONLog.put("wl_ds", Long.valueOf(map2.get(c.w).longValue() + map2.get(c.x).longValue()));
            }
            if (map.containsKey(c.o)) {
                efsJSONLog.put("wd_srt", map.get(c.o));
            }
            if (map.containsKey(c.r)) {
                efsJSONLog.put("wd_srttm", map.get(c.r));
            }
            if (map2.containsKey(c.y) && map2.containsKey(c.z)) {
                efsJSONLog.put("wl_srt", Long.valueOf(map2.get(c.y).longValue() + map2.get(c.z).longValue()));
            }
            String str = null;
            String[] split = c2.B.split("\\?");
            if (split != null) {
                str = split[0];
            }
            if (this.d == null || str == null || this.d.contains(str)) {
                efsJSONLog.put("wd_ttfb", 0);
                efsJSONLog.put("wd_ttfbtm", 0);
                efsJSONLog.put("wl_ttfb", 0);
            } else {
                this.d.add(str);
                if (map.containsKey(c.n)) {
                    efsJSONLog.put("wd_ttfb", map.get(c.n));
                } else if (map.containsKey(c.l)) {
                    efsJSONLog.put("wd_ttfb", map.get(c.l));
                }
                if (map.containsKey(c.o)) {
                    efsJSONLog.put("wd_ttfbtm", map.get(c.o));
                }
                if (map.containsKey(c.o)) {
                    if (map.containsKey(c.n)) {
                        efsJSONLog.put("wl_ttfb", Long.valueOf(map.get(c.o).longValue() - map.get(c.n).longValue()));
                    } else if (map.containsKey(c.l)) {
                        efsJSONLog.put("wl_ttfb", Long.valueOf(map.get(c.o).longValue() - map.get(c.l).longValue()));
                    }
                }
            }
            if (map.containsKey(c.f8237a)) {
                efsJSONLog.put("wd_rt", map.get(c.f8237a));
            }
            if (map.containsKey(c.b)) {
                efsJSONLog.put("wd_rttm", map.get(c.b));
            }
            if (map2.containsKey(c.s)) {
                efsJSONLog.put("wl_rt", map2.get(c.s));
            }
            efsJSONLog.put("wk_res", c2.B);
            efsJSONLog.put("wk_method", a2.e);
            efsJSONLog.put("wk_rc", Integer.valueOf(a2.g));
            efsJSONLog.put("wl_up", Long.valueOf(a2.f));
            efsJSONLog.put("wl_down", Long.valueOf(a2.i));
            efsJSONLog.put("wl_total", Long.valueOf(a2.f + a2.i));
            EfsReporter reporter = NetManager.getReporter();
            if (reporter != null) {
                reporter.send(efsJSONLog);
                a.a().d(this.b);
                a.a().b(this.b);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static EventListener.Factory get() {
        return new EventListener.Factory() { // from class: com.efs.sdk.net.OkHttpListener.1
            public final EventListener create(Call call) {
                return new OkHttpListener();
            }
        };
    }

    public void callEnd(Call call) {
        super.callEnd(call);
        try {
            Log.d("NetTrace-Listener", "callEnd");
            if (!this.f8222c && !IntegrationTestingUtil.isIntegrationTestingInPeriod()) {
                Log.d("NetTrace-Listener", "callEnd net enable false.");
                return;
            }
            a(c.b);
            a();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void callFailed(Call call, IOException iOException) {
        super.callFailed(call, iOException);
        try {
            Log.d("NetTrace-Listener", "callFailed");
            if (!this.f8222c && !IntegrationTestingUtil.isIntegrationTestingInPeriod()) {
                Log.d("NetTrace-Listener", "callFailed net enable false.");
                return;
            }
            a(c.f8238c);
            a();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void callStart(Call call) {
        super.callStart(call);
        try {
            Log.d("NetTrace-Listener", "callStart");
            if (NetManager.getNetConfigManager() != null && NetManager.getNetConfigManager().enableTracer()) {
                this.f8222c = true;
            }
            if (!this.f8222c && !IntegrationTestingUtil.isIntegrationTestingInPeriod()) {
                Log.d("NetTrace-Listener", "callStart net enable false.");
                return;
            }
            this.b = String.valueOf(f8221a.getAndIncrement());
            Log.i("NetTrace-Listener", "requestId is" + this.b);
            a(c.f8237a);
            String httpUrl = call.request().url().toString();
            c c2 = a.a().c(this.b);
            if (c2 != null) {
                c2.B = httpUrl;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void connectEnd(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol) {
        super.connectEnd(call, inetSocketAddress, proxy, protocol);
        try {
            Log.d("NetTrace-Listener", "connectEnd");
            if (!this.f8222c && !IntegrationTestingUtil.isIntegrationTestingInPeriod()) {
                Log.d("NetTrace-Listener", "connectEnd net enable false.");
                return;
            }
            a(c.i);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void connectFailed(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol, IOException iOException) {
        super.connectFailed(call, inetSocketAddress, proxy, protocol, iOException);
        try {
            Log.d("NetTrace-Listener", "connectFailed");
            if (!this.f8222c && !IntegrationTestingUtil.isIntegrationTestingInPeriod()) {
                Log.d("NetTrace-Listener", "connectFailed net enable false.");
                return;
            }
            a(c.j);
            a();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void connectStart(Call call, InetSocketAddress inetSocketAddress, Proxy proxy) {
        super.connectStart(call, inetSocketAddress, proxy);
        try {
            Log.d("NetTrace-Listener", "connectStart");
            if (!this.f8222c && !IntegrationTestingUtil.isIntegrationTestingInPeriod()) {
                Log.d("NetTrace-Listener", "connectStart net enable false.");
                return;
            }
            a(c.f);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void dnsEnd(Call call, String str, List<InetAddress> list) {
        super.dnsEnd(call, str, list);
        try {
            Log.d("NetTrace-Listener", "dnsEnd");
            if (!this.f8222c && !IntegrationTestingUtil.isIntegrationTestingInPeriod()) {
                Log.d("NetTrace-Listener", "dnsEnd net enable false.");
                return;
            }
            a(c.e);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void dnsStart(Call call, String str) {
        super.dnsStart(call, str);
        try {
            Log.d("NetTrace-Listener", "dnsStart");
            if (!this.f8222c && !IntegrationTestingUtil.isIntegrationTestingInPeriod()) {
                Log.d("NetTrace-Listener", "dnsStart net enable false.");
                return;
            }
            a(c.d);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void requestBodyEnd(Call call, long j) {
        super.requestBodyEnd(call, j);
        try {
            Log.d("NetTrace-Listener", "requestBodyEnd");
            if (!this.f8222c && !IntegrationTestingUtil.isIntegrationTestingInPeriod()) {
                Log.d("NetTrace-Listener", "requestBodyEnd net enable false.");
                return;
            }
            a(c.n);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void requestBodyStart(Call call) {
        super.requestBodyStart(call);
        try {
            Log.d("NetTrace-Listener", "requestBodyStart");
            if (!this.f8222c && !IntegrationTestingUtil.isIntegrationTestingInPeriod()) {
                Log.d("NetTrace-Listener", "requestBodyStart net enable false.");
                return;
            }
            a(c.m);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void requestHeadersEnd(Call call, Request request) {
        super.requestHeadersEnd(call, request);
        try {
            Log.d("NetTrace-Listener", "requestHeadersEnd");
            if (!this.f8222c && !IntegrationTestingUtil.isIntegrationTestingInPeriod()) {
                Log.d("NetTrace-Listener", "requestHeadersEnd net enable false.");
                return;
            }
            a(c.l);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void requestHeadersStart(Call call) {
        super.requestHeadersStart(call);
        try {
            Log.d("NetTrace-Listener", "requestHeadersStart");
            if (!this.f8222c && !IntegrationTestingUtil.isIntegrationTestingInPeriod()) {
                Log.d("NetTrace-Listener", "requestHeadersStart net enable false.");
                return;
            }
            a(c.k);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void responseBodyEnd(Call call, long j) {
        super.responseBodyEnd(call, j);
        try {
            Log.d("NetTrace-Listener", "responseBodyEnd");
            if (!this.f8222c && !IntegrationTestingUtil.isIntegrationTestingInPeriod()) {
                Log.d("NetTrace-Listener", "responseBodyEnd net enable false.");
                return;
            }
            a(c.r);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void responseBodyStart(Call call) {
        super.responseBodyStart(call);
        try {
            Log.d("NetTrace-Listener", "responseBodyStart");
            if (!this.f8222c && !IntegrationTestingUtil.isIntegrationTestingInPeriod()) {
                Log.d("NetTrace-Listener", "responseBodyStart net enable false.");
                return;
            }
            a(c.q);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void responseHeadersEnd(Call call, Response response) {
        super.responseHeadersEnd(call, response);
        try {
            Log.d("NetTrace-Listener", "responseHeadersEnd");
            if (!this.f8222c && !IntegrationTestingUtil.isIntegrationTestingInPeriod()) {
                Log.d("NetTrace-Listener", "responseHeadersEnd net enable false.");
                return;
            }
            a(c.p);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void responseHeadersStart(Call call) {
        super.responseHeadersStart(call);
        try {
            Log.d("NetTrace-Listener", "responseHeadersStart");
            if (!this.f8222c && !IntegrationTestingUtil.isIntegrationTestingInPeriod()) {
                Log.d("NetTrace-Listener", "responseHeadersStart net enable false.");
                return;
            }
            a(c.o);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void secureConnectEnd(Call call, Handshake handshake) {
        super.secureConnectEnd(call, handshake);
        try {
            Log.d("NetTrace-Listener", "secureConnectEnd");
            if (!this.f8222c && !IntegrationTestingUtil.isIntegrationTestingInPeriod()) {
                Log.d("NetTrace-Listener", "secureConnectEnd net enable false.");
                return;
            }
            a(c.h);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void secureConnectStart(Call call) {
        super.secureConnectStart(call);
        try {
            Log.d("NetTrace-Listener", "secureConnectStart");
            if (!this.f8222c && !IntegrationTestingUtil.isIntegrationTestingInPeriod()) {
                Log.d("NetTrace-Listener", "secureConnectStart net enable false.");
                return;
            }
            a(c.g);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
