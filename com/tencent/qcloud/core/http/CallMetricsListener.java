package com.tencent.qcloud.core.http;

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

    public void connectEnd(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol) {
        super.connectEnd(call, inetSocketAddress, proxy, protocol);
        this.connectTookTime += System.nanoTime() - this.connectStartTime;
    }

    public void connectFailed(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol, IOException iOException) {
        super.connectFailed(call, inetSocketAddress, proxy, protocol, iOException);
        this.connectTookTime += System.nanoTime() - this.connectStartTime;
    }

    public void connectStart(Call call, InetSocketAddress inetSocketAddress, Proxy proxy) {
        super.connectStart(call, inetSocketAddress, proxy);
        this.connectStartTime = System.nanoTime();
    }

    public void dnsEnd(Call call, String str, List<InetAddress> list) {
        super.dnsEnd(call, str, list);
        StringBuffer stringBuffer = new StringBuffer("{");
        if (list != null) {
            for (InetAddress inetAddress : list) {
                stringBuffer.append(inetAddress.getHostAddress());
                stringBuffer.append(",");
            }
        }
        stringBuffer.append("}");
        QCloudLogger.i(QCloudHttpClient.HTTP_LOG_TAG, "dns: " + str + ":" + stringBuffer.toString(), new Object[0]);
        this.dnsLookupTookTime = this.dnsLookupTookTime + (System.nanoTime() - this.dnsStartTime);
        this.inetAddressList = list;
    }

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

    public void requestBodyEnd(Call call, long j) {
        super.requestBodyEnd(call, j);
        this.writeRequestBodyTookTime += System.nanoTime() - this.writeRequestBodyStartTime;
        this.requestBodyByteCount = j;
    }

    public void requestBodyStart(Call call) {
        super.requestBodyStart(call);
        this.writeRequestBodyStartTime = System.nanoTime();
    }

    public void requestHeadersEnd(Call call, Request request) {
        super.requestHeadersEnd(call, request);
        this.writeRequestHeaderTookTime += System.nanoTime() - this.writeRequestHeaderStartTime;
    }

    public void requestHeadersStart(Call call) {
        super.requestHeadersStart(call);
        this.writeRequestHeaderStartTime = System.nanoTime();
    }

    public void responseBodyEnd(Call call, long j) {
        super.responseBodyEnd(call, j);
        this.readResponseBodyTookTime += System.nanoTime() - this.readResponseBodyStartTime;
        this.responseBodyByteCount = j;
    }

    public void responseBodyStart(Call call) {
        super.responseBodyStart(call);
        this.readResponseBodyStartTime = System.nanoTime();
    }

    public void responseHeadersEnd(Call call, Response response) {
        super.responseHeadersEnd(call, response);
        this.readResponseHeaderTookTime += System.nanoTime() - this.readResponseHeaderStartTime;
    }

    public void responseHeadersStart(Call call) {
        super.responseHeadersStart(call);
        this.readResponseHeaderStartTime = System.nanoTime();
    }

    public void secureConnectEnd(Call call, Handshake handshake) {
        super.secureConnectEnd(call, handshake);
        this.secureConnectTookTime += System.nanoTime() - this.secureConnectStartTime;
    }

    public void secureConnectStart(Call call) {
        super.secureConnectStart(call);
        this.secureConnectStartTime = System.nanoTime();
    }
}
