package com.tencent.qcloud.core.http;

import com.alipay.sdk.util.i;
import com.tencent.qcloud.core.logger.QCloudLogger;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.List;
import okhttp3.Call;
import okhttp3.EventListener;
import okhttp3.Handshake;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/qcloud/core/http/CallMetricsListener.class */
public class CallMetricsListener extends EventListener {
    private long connectStartTime;
    private long connectTookTime;
    private long dnsLookupTookTime;
    private long dnsStartTime;
    private List<InetAddress> inetAddressList;
    private long readResponseBodyStartTime;
    private long readResponseBodyTookTime;
    private long readResponseHeaderStartTime;
    private long readResponseHeaderTookTime;
    private long requestBodyByteCount;
    private long responseBodyByteCount;
    private long secureConnectStartTime;
    private long secureConnectTookTime;
    private long writeRequestBodyStartTime;
    private long writeRequestBodyTookTime;
    private long writeRequestHeaderStartTime;
    private long writeRequestHeaderTookTime;

    public CallMetricsListener(Call call) {
    }

    @Override // okhttp3.EventListener
    public void connectEnd(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol) {
        super.connectEnd(call, inetSocketAddress, proxy, protocol);
        this.connectTookTime += System.nanoTime() - this.connectStartTime;
    }

    @Override // okhttp3.EventListener
    public void connectFailed(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol, IOException iOException) {
        super.connectFailed(call, inetSocketAddress, proxy, protocol, iOException);
        this.connectTookTime += System.nanoTime() - this.connectStartTime;
    }

    @Override // okhttp3.EventListener
    public void connectStart(Call call, InetSocketAddress inetSocketAddress, Proxy proxy) {
        super.connectStart(call, inetSocketAddress, proxy);
        this.connectStartTime = System.nanoTime();
    }

    @Override // okhttp3.EventListener
    public void dnsEnd(Call call, String str, List<InetAddress> list) {
        super.dnsEnd(call, str, list);
        StringBuffer stringBuffer = new StringBuffer("{");
        if (list != null) {
            for (InetAddress inetAddress : list) {
                stringBuffer.append(inetAddress.getHostAddress());
                stringBuffer.append(",");
            }
        }
        stringBuffer.append(i.d);
        QCloudLogger.i(QCloudHttpClient.HTTP_LOG_TAG, "dns: " + str + ":" + stringBuffer.toString(), new Object[0]);
        this.dnsLookupTookTime = this.dnsLookupTookTime + (System.nanoTime() - this.dnsStartTime);
        this.inetAddressList = list;
    }

    @Override // okhttp3.EventListener
    public void dnsStart(Call call, String str) {
        super.dnsStart(call, str);
        this.dnsStartTime = System.nanoTime();
    }

    public List<InetAddress> dumpDns() {
        return this.inetAddressList;
    }

    public void dumpMetrics(HttpTaskMetrics httpTaskMetrics) {
        httpTaskMetrics.remoteAddress = this.inetAddressList;
        httpTaskMetrics.dnsLookupTookTime += this.dnsLookupTookTime;
        httpTaskMetrics.connectTookTime += this.connectTookTime;
        httpTaskMetrics.secureConnectTookTime += this.secureConnectTookTime;
        httpTaskMetrics.writeRequestHeaderTookTime += this.writeRequestHeaderTookTime;
        httpTaskMetrics.writeRequestBodyTookTime += this.writeRequestBodyTookTime;
        httpTaskMetrics.readResponseHeaderTookTime += this.readResponseHeaderTookTime;
        httpTaskMetrics.readResponseBodyTookTime += this.readResponseBodyTookTime;
        httpTaskMetrics.requestBodyByteCount = this.requestBodyByteCount;
        httpTaskMetrics.responseBodyByteCount = this.responseBodyByteCount;
    }

    @Override // okhttp3.EventListener
    public void requestBodyEnd(Call call, long j) {
        super.requestBodyEnd(call, j);
        this.writeRequestBodyTookTime += System.nanoTime() - this.writeRequestBodyStartTime;
        this.requestBodyByteCount = j;
    }

    @Override // okhttp3.EventListener
    public void requestBodyStart(Call call) {
        super.requestBodyStart(call);
        this.writeRequestBodyStartTime = System.nanoTime();
    }

    @Override // okhttp3.EventListener
    public void requestHeadersEnd(Call call, Request request) {
        super.requestHeadersEnd(call, request);
        this.writeRequestHeaderTookTime += System.nanoTime() - this.writeRequestHeaderStartTime;
    }

    @Override // okhttp3.EventListener
    public void requestHeadersStart(Call call) {
        super.requestHeadersStart(call);
        this.writeRequestHeaderStartTime = System.nanoTime();
    }

    @Override // okhttp3.EventListener
    public void responseBodyEnd(Call call, long j) {
        super.responseBodyEnd(call, j);
        this.readResponseBodyTookTime += System.nanoTime() - this.readResponseBodyStartTime;
        this.responseBodyByteCount = j;
    }

    @Override // okhttp3.EventListener
    public void responseBodyStart(Call call) {
        super.responseBodyStart(call);
        this.readResponseBodyStartTime = System.nanoTime();
    }

    @Override // okhttp3.EventListener
    public void responseHeadersEnd(Call call, Response response) {
        super.responseHeadersEnd(call, response);
        this.readResponseHeaderTookTime += System.nanoTime() - this.readResponseHeaderStartTime;
    }

    @Override // okhttp3.EventListener
    public void responseHeadersStart(Call call) {
        super.responseHeadersStart(call);
        this.readResponseHeaderStartTime = System.nanoTime();
    }

    @Override // okhttp3.EventListener
    public void secureConnectEnd(Call call, Handshake handshake) {
        super.secureConnectEnd(call, handshake);
        this.secureConnectTookTime += System.nanoTime() - this.secureConnectStartTime;
    }

    @Override // okhttp3.EventListener
    public void secureConnectStart(Call call) {
        super.secureConnectStart(call);
        this.secureConnectStartTime = System.nanoTime();
    }
}
