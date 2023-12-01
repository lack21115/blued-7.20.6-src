package com.qiniu.android.http;

import com.qiniu.android.collect.LogHandler;
import com.qiniu.android.http.Client;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import okhttp3.Call;
import okhttp3.Connection;
import okhttp3.EventListener;
import okhttp3.Handshake;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;

/* loaded from: source-8303388-dex2jar.jar:com/qiniu/android/http/HttpEventListener.class */
public class HttpEventListener extends EventListener {
    public static final EventListener.Factory FACTORY = new EventListener.Factory() { // from class: com.qiniu.android.http.HttpEventListener.2
        final AtomicLong nextCallId = new AtomicLong(1);

        public EventListener create(Call call) {
            return new HttpEventListener(this.nextCallId.getAndIncrement(), (Client.ResponseTag) call.request().tag(), System.nanoTime());
        }
    };
    private long callId;
    private final long callStartNanos;
    private long connect_elapsed_time;
    private long dns_elapsed_time;
    private LogHandler logHandler;
    private long request_elapsed_time;
    private Client.ResponseTag responseTag;
    private long response_elapsed_time;
    private long start_connect_elapsed_time;
    private long start_dns_elapsed_time;
    private long start_request_elapsed_time;
    private long start_response_elapsed_time;
    private long start_tls_connect_elapsed_time;
    private long start_total_elapsed_time;
    private long tls_connect_elapsed_time;
    private long total_elapsed_time;
    private long wait_elapsed_time;

    public HttpEventListener(long j, Client.ResponseTag responseTag, long j2) {
        this.callId = 1L;
        this.callId = j;
        this.callStartNanos = j2;
        this.responseTag = responseTag;
        if (responseTag.logHandler == null) {
            this.logHandler = new LogHandler() { // from class: com.qiniu.android.http.HttpEventListener.1
                @Override // com.qiniu.android.collect.LogHandler
                public Object getUploadInfo() {
                    return null;
                }

                @Override // com.qiniu.android.collect.LogHandler
                public void send(String str, Object obj) {
                }
            };
        } else {
            this.logHandler = responseTag.logHandler;
        }
    }

    public void callEnd(Call call) {
        super.callEnd(call);
        long currentTimeMillis = System.currentTimeMillis() - this.start_total_elapsed_time;
        this.total_elapsed_time = currentTimeMillis;
        this.logHandler.send("total_elapsed_time", Long.valueOf(currentTimeMillis));
    }

    public void callFailed(Call call, IOException iOException) {
        super.callFailed(call, iOException);
    }

    public void callStart(Call call) {
        super.callStart(call);
        this.start_total_elapsed_time = System.currentTimeMillis();
    }

    public void connectEnd(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol) {
        super.connectEnd(call, inetSocketAddress, proxy, protocol);
        long currentTimeMillis = System.currentTimeMillis() - this.start_connect_elapsed_time;
        this.connect_elapsed_time = currentTimeMillis;
        this.logHandler.send("connect_elapsed_time", Long.valueOf(currentTimeMillis));
    }

    public void connectFailed(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol, IOException iOException) {
        super.connectFailed(call, inetSocketAddress, proxy, protocol, iOException);
    }

    public void connectStart(Call call, InetSocketAddress inetSocketAddress, Proxy proxy) {
        super.connectStart(call, inetSocketAddress, proxy);
        this.start_connect_elapsed_time = System.currentTimeMillis();
    }

    public void connectionAcquired(Call call, Connection connection) {
        super.connectionAcquired(call, connection);
    }

    public void connectionReleased(Call call, Connection connection) {
        super.connectionReleased(call, connection);
    }

    public void dnsEnd(Call call, String str, List<InetAddress> list) {
        super.dnsEnd(call, str, list);
        long currentTimeMillis = System.currentTimeMillis() - this.start_dns_elapsed_time;
        this.dns_elapsed_time = currentTimeMillis;
        this.logHandler.send("dns_elapsed_time", Long.valueOf(currentTimeMillis));
    }

    public void dnsStart(Call call, String str) {
        super.dnsStart(call, str);
        this.start_dns_elapsed_time = System.currentTimeMillis();
    }

    public void requestBodyEnd(Call call, long j) {
        super.requestBodyEnd(call, j);
        long currentTimeMillis = System.currentTimeMillis() - this.start_request_elapsed_time;
        this.request_elapsed_time = currentTimeMillis;
        this.logHandler.send("request_elapsed_time", Long.valueOf(currentTimeMillis));
    }

    public void requestBodyStart(Call call) {
        super.requestBodyStart(call);
    }

    public void requestHeadersEnd(Call call, Request request) {
        super.requestHeadersEnd(call, request);
    }

    public void requestHeadersStart(Call call) {
        super.requestHeadersStart(call);
        this.start_request_elapsed_time = System.currentTimeMillis();
    }

    public void responseBodyEnd(Call call, long j) {
        super.responseBodyEnd(call, j);
        this.response_elapsed_time = System.currentTimeMillis() - this.start_response_elapsed_time;
        this.wait_elapsed_time = System.currentTimeMillis() - this.start_request_elapsed_time;
        this.logHandler.send("response_elapsed_time", Long.valueOf(this.response_elapsed_time));
        this.logHandler.send("wait_elapsed_time", Long.valueOf(this.wait_elapsed_time));
    }

    public void responseBodyStart(Call call) {
        super.responseBodyStart(call);
    }

    public void responseHeadersEnd(Call call, Response response) {
        super.responseHeadersEnd(call, response);
    }

    public void responseHeadersStart(Call call) {
        super.responseHeadersStart(call);
        this.start_response_elapsed_time = System.currentTimeMillis();
    }

    public void secureConnectEnd(Call call, Handshake handshake) {
        super.secureConnectEnd(call, handshake);
        long currentTimeMillis = System.currentTimeMillis() - this.start_tls_connect_elapsed_time;
        this.tls_connect_elapsed_time = currentTimeMillis;
        this.logHandler.send("tls_connect_elapsed_time", Long.valueOf(currentTimeMillis));
    }

    public void secureConnectStart(Call call) {
        super.secureConnectStart(call);
        this.start_tls_connect_elapsed_time = System.currentTimeMillis();
    }
}
