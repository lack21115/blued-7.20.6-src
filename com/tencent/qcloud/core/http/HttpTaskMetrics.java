package com.tencent.qcloud.core.http;

import android.text.TextUtils;
import com.igexin.push.core.b;
import java.net.InetAddress;
import java.util.List;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/qcloud/core/http/HttpTaskMetrics.class */
public class HttpTaskMetrics {
    private long calculateMD5STookTime;
    private long calculateMD5StartTime;
    InetAddress connectAddress;
    long connectTookTime;
    long dnsLookupTookTime;
    String domainName;
    private long fullTaskStartTime;
    private long fullTaskTookTime;
    private long httpTaskStartTime;
    private long httpTaskTookTime;
    long readResponseBodyTookTime;
    long readResponseHeaderTookTime;
    List<InetAddress> remoteAddress;
    long requestBodyByteCount;
    long responseBodyByteCount;
    long secureConnectTookTime;
    private long signRequestStartTime;
    private long signRequestTookTime;
    long writeRequestBodyTookTime;
    long writeRequestHeaderTookTime;

    public static HttpTaskMetrics createMetricsWithHost(String str) {
        HttpTaskMetrics httpTaskMetrics = new HttpTaskMetrics();
        httpTaskMetrics.domainName = str;
        return httpTaskMetrics;
    }

    private double toSeconds(long j) {
        return j / 1.0E9d;
    }

    public double calculateMD5STookTime() {
        return toSeconds(this.calculateMD5STookTime);
    }

    public double connectTookTime() {
        return toSeconds(this.connectTookTime);
    }

    public double dnsLookupTookTime() {
        return toSeconds(this.dnsLookupTookTime);
    }

    public double fullTaskTookTime() {
        return toSeconds(this.fullTaskTookTime);
    }

    public InetAddress getConnectAddress() {
        return this.connectAddress;
    }

    public String getDomainName() {
        return this.domainName;
    }

    public List<InetAddress> getRemoteAddress() {
        return this.remoteAddress;
    }

    public double httpTaskFullTime() {
        return toSeconds(this.httpTaskTookTime);
    }

    public HttpTaskMetrics merge(HttpTaskMetrics httpTaskMetrics) {
        synchronized (this) {
            if (TextUtils.isEmpty(this.domainName) || TextUtils.isEmpty(httpTaskMetrics.domainName) || this.domainName.equals(httpTaskMetrics.domainName)) {
                if (TextUtils.isEmpty(this.domainName) && httpTaskMetrics.domainName != null) {
                    this.domainName = httpTaskMetrics.domainName;
                }
                this.dnsLookupTookTime = Math.max(httpTaskMetrics.dnsLookupTookTime, this.dnsLookupTookTime);
                this.connectTookTime = Math.max(httpTaskMetrics.connectTookTime, this.connectTookTime);
                this.secureConnectTookTime = Math.max(httpTaskMetrics.secureConnectTookTime, this.secureConnectTookTime);
                this.writeRequestHeaderTookTime += httpTaskMetrics.writeRequestHeaderTookTime;
                this.writeRequestBodyTookTime += httpTaskMetrics.writeRequestBodyTookTime;
                this.readResponseHeaderTookTime += httpTaskMetrics.readResponseHeaderTookTime;
                this.readResponseBodyTookTime += httpTaskMetrics.readResponseBodyTookTime;
                this.requestBodyByteCount += httpTaskMetrics.requestBodyByteCount;
                this.responseBodyByteCount += httpTaskMetrics.responseBodyByteCount;
                this.fullTaskTookTime += httpTaskMetrics.fullTaskTookTime;
                this.httpTaskTookTime += httpTaskMetrics.httpTaskTookTime;
                this.calculateMD5STookTime += httpTaskMetrics.calculateMD5STookTime;
                this.signRequestTookTime += httpTaskMetrics.signRequestTookTime;
                if (httpTaskMetrics.getRemoteAddress() != null) {
                    this.remoteAddress = httpTaskMetrics.getRemoteAddress();
                }
                if (httpTaskMetrics.connectAddress != null) {
                    this.connectAddress = httpTaskMetrics.getConnectAddress();
                }
                return this;
            }
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onCalculateMD5End() {
        this.calculateMD5STookTime += System.nanoTime() - this.calculateMD5StartTime;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onCalculateMD5Start() {
        this.calculateMD5StartTime = System.nanoTime();
    }

    public void onDataReady() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onHttpTaskEnd() {
        this.httpTaskTookTime = System.nanoTime() - this.httpTaskStartTime;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onHttpTaskStart() {
        this.httpTaskStartTime = System.nanoTime();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onSignRequestEnd() {
        this.signRequestTookTime += System.nanoTime() - this.signRequestStartTime;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onSignRequestStart() {
        this.signRequestStartTime = System.nanoTime();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onTaskEnd() {
        this.fullTaskTookTime = System.nanoTime() - this.fullTaskStartTime;
        onDataReady();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onTaskStart() {
        this.fullTaskStartTime = System.nanoTime();
    }

    public double readResponseBodyTookTime() {
        return toSeconds(this.readResponseBodyTookTime);
    }

    public double readResponseHeaderTookTime() {
        return toSeconds(this.readResponseHeaderTookTime);
    }

    public void recordConnectAddress(InetAddress inetAddress) {
        if (inetAddress != null) {
            this.domainName = inetAddress.getHostName();
            this.connectAddress = inetAddress;
        }
    }

    public long requestBodyByteCount() {
        return this.requestBodyByteCount;
    }

    public long responseBodyByteCount() {
        return this.responseBodyByteCount;
    }

    public double secureConnectTookTime() {
        return toSeconds(this.secureConnectTookTime);
    }

    public void setDomainName(String str) {
        this.domainName = str;
    }

    public double signRequestTookTime() {
        return toSeconds(this.signRequestTookTime);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Http Metrics: \n");
        sb.append("domain : ");
        sb.append(this.domainName);
        sb.append("\n");
        sb.append("dns : ");
        InetAddress inetAddress = this.connectAddress;
        sb.append(inetAddress != null ? inetAddress.getHostAddress() : b.l);
        sb.append("\n");
        sb.append("fullTaskTookTime : ");
        sb.append(fullTaskTookTime());
        sb.append("\n");
        sb.append("calculateMD5STookTime : ");
        sb.append(calculateMD5STookTime());
        sb.append("\n");
        sb.append("signRequestTookTime : ");
        sb.append(signRequestTookTime());
        sb.append("\n");
        sb.append("dnsLookupTookTime : ");
        sb.append(dnsLookupTookTime());
        sb.append("\n");
        sb.append("connectTookTime : ");
        sb.append(connectTookTime());
        sb.append("\n");
        sb.append("secureConnectTookTime : ");
        sb.append(secureConnectTookTime());
        sb.append("\n");
        sb.append("writeRequestHeaderTookTime : ");
        sb.append(writeRequestHeaderTookTime());
        sb.append("\n");
        sb.append("writeRequestBodyTookTime : ");
        sb.append(writeRequestBodyTookTime());
        sb.append("\n");
        sb.append("readResponseHeaderTookTime : ");
        sb.append(readResponseHeaderTookTime());
        sb.append("\n");
        sb.append("readResponseBodyTookTime : ");
        sb.append(readResponseBodyTookTime());
        return sb.toString();
    }

    public double writeRequestBodyTookTime() {
        return toSeconds(this.writeRequestBodyTookTime);
    }

    public double writeRequestHeaderTookTime() {
        return toSeconds(this.writeRequestHeaderTookTime);
    }
}
