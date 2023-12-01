package com.tencent.cloud.huiyansdkface.wehttp2;

import com.tencent.cloud.huiyansdkface.okhttp3.Call;
import com.tencent.cloud.huiyansdkface.okhttp3.Connection;
import com.tencent.cloud.huiyansdkface.okhttp3.EventListener;
import com.tencent.cloud.huiyansdkface.okhttp3.Handshake;
import com.tencent.cloud.huiyansdkface.okhttp3.Protocol;
import com.tencent.cloud.huiyansdkface.okhttp3.Request;
import com.tencent.cloud.huiyansdkface.okhttp3.Response;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/wehttp2/ReportEventListener.class */
public class ReportEventListener extends EventListener {
    private Map<Request, EventReport> b = new ConcurrentHashMap();

    /* renamed from: c  reason: collision with root package name */
    private EventReportFactory f22410c;

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/wehttp2/ReportEventListener$EventReportFactory.class */
    public interface EventReportFactory {
        EventReport create(Request request);
    }

    public ReportEventListener(EventReportFactory eventReportFactory) {
        this.f22410c = eventReportFactory;
    }

    private EventReport a(Call call) {
        return this.b.get(call.request());
    }

    private void b(Call call) {
        this.b.remove(call);
    }

    @Override // com.tencent.cloud.huiyansdkface.okhttp3.EventListener
    public void callEnd(Call call) {
        EventReport a2 = a(call);
        if (a2 != null) {
            a2.callEnd();
            b(call);
        }
    }

    @Override // com.tencent.cloud.huiyansdkface.okhttp3.EventListener
    public void callFailed(Call call, IOException iOException) {
        EventReport a2 = a(call);
        if (a2 != null) {
            a2.callFailed(iOException);
            b(call);
        }
    }

    @Override // com.tencent.cloud.huiyansdkface.okhttp3.EventListener
    public void callStart(Call call) {
        if (a(call) == null) {
            EventReport create = this.f22410c.create(call.request());
            create.callStart();
            this.b.put(call.request(), create);
        }
    }

    @Override // com.tencent.cloud.huiyansdkface.okhttp3.EventListener
    public void connectEnd(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol) {
        EventReport a2 = a(call);
        if (a2 != null) {
            a2.connectEnd(protocol == null ? "" : protocol.name());
        }
    }

    @Override // com.tencent.cloud.huiyansdkface.okhttp3.EventListener
    public void connectFailed(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol, IOException iOException) {
        EventReport a2 = a(call);
        if (a2 != null) {
            a2.connectFailed(protocol == null ? "" : protocol.name(), iOException);
        }
    }

    @Override // com.tencent.cloud.huiyansdkface.okhttp3.EventListener
    public void connectStart(Call call, InetSocketAddress inetSocketAddress, Proxy proxy) {
        EventReport a2 = a(call);
        if (a2 != null) {
            a2.connectStart(inetSocketAddress, proxy);
        }
    }

    @Override // com.tencent.cloud.huiyansdkface.okhttp3.EventListener
    public void connectionAcquired(Call call, Connection connection) {
        EventReport a2 = a(call);
        if (a2 != null) {
            a2.connectionAcquired();
        }
    }

    @Override // com.tencent.cloud.huiyansdkface.okhttp3.EventListener
    public void connectionReleased(Call call, Connection connection) {
        EventReport a2 = a(call);
        if (a2 != null) {
            a2.connectionReleased();
        }
    }

    @Override // com.tencent.cloud.huiyansdkface.okhttp3.EventListener
    public void dnsEnd(Call call, String str, List<InetAddress> list) {
        EventReport a2 = a(call);
        if (a2 != null) {
            a2.dnsEnd(list);
        }
    }

    @Override // com.tencent.cloud.huiyansdkface.okhttp3.EventListener
    public void dnsStart(Call call, String str) {
        EventReport a2 = a(call);
        if (a2 != null) {
            a2.dnsStart(str);
        }
    }

    @Override // com.tencent.cloud.huiyansdkface.okhttp3.EventListener
    public void requestBodyEnd(Call call, long j) {
        EventReport a2 = a(call);
        if (a2 != null) {
            a2.requestBodyEnd(j);
        }
    }

    @Override // com.tencent.cloud.huiyansdkface.okhttp3.EventListener
    public void requestBodyStart(Call call) {
        EventReport a2 = a(call);
        if (a2 != null) {
            a2.requestBodyStart();
        }
    }

    @Override // com.tencent.cloud.huiyansdkface.okhttp3.EventListener
    public void requestHeadersEnd(Call call, Request request) {
        EventReport a2 = a(call);
        if (a2 != null) {
            a2.requestHeadersEnd();
        }
    }

    @Override // com.tencent.cloud.huiyansdkface.okhttp3.EventListener
    public void requestHeadersStart(Call call) {
        EventReport a2 = a(call);
        if (a2 != null) {
            a2.requestHeadersStart();
        }
    }

    @Override // com.tencent.cloud.huiyansdkface.okhttp3.EventListener
    public void responseBodyEnd(Call call, long j) {
        EventReport a2 = a(call);
        if (a2 != null) {
            a2.responseBodyEnd(j);
        }
    }

    @Override // com.tencent.cloud.huiyansdkface.okhttp3.EventListener
    public void responseBodyStart(Call call) {
        EventReport a2 = a(call);
        if (a2 != null) {
            a2.responseBodyStart();
        }
    }

    @Override // com.tencent.cloud.huiyansdkface.okhttp3.EventListener
    public void responseHeadersEnd(Call call, Response response) {
        EventReport a2 = a(call);
        if (a2 != null) {
            a2.responseHeadersEnd(response.code(), response.message(), response.receivedResponseAtMillis(), response.sentRequestAtMillis());
        }
    }

    @Override // com.tencent.cloud.huiyansdkface.okhttp3.EventListener
    public void responseHeadersStart(Call call) {
        EventReport a2 = a(call);
        if (a2 != null) {
            a2.responseHeadersStart();
        }
    }

    @Override // com.tencent.cloud.huiyansdkface.okhttp3.EventListener
    public void secureConnectEnd(Call call, Handshake handshake) {
        EventReport a2 = a(call);
        if (a2 != null) {
            a2.secureConnectEnd(handshake.tlsVersion().javaName(), handshake.cipherSuite().javaName(), handshake.localPrincipal(), handshake.peerPrincipal(), handshake.localCertificates(), handshake.peerCertificates());
        }
    }

    @Override // com.tencent.cloud.huiyansdkface.okhttp3.EventListener
    public void secureConnectStart(Call call) {
        EventReport a2 = a(call);
        if (a2 != null) {
            a2.secureConnectStart();
        }
    }
}
