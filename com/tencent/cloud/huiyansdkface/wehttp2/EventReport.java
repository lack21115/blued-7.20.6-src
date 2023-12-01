package com.tencent.cloud.huiyansdkface.wehttp2;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.security.Principal;
import java.security.cert.Certificate;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/wehttp2/EventReport.class */
public interface EventReport {
    void callEnd();

    void callFailed(IOException iOException);

    void callStart();

    void connectEnd(String str);

    void connectFailed(String str, IOException iOException);

    void connectStart(InetSocketAddress inetSocketAddress, Proxy proxy);

    void connectionAcquired();

    void connectionReleased();

    void dnsEnd(List<InetAddress> list);

    void dnsStart(String str);

    void requestBodyEnd(long j);

    void requestBodyStart();

    void requestHeadersEnd();

    void requestHeadersStart();

    void responseBodyEnd(long j);

    void responseBodyStart();

    void responseHeadersEnd(int i, String str, long j, long j2);

    void responseHeadersStart();

    void secureConnectEnd(String str, String str2, Principal principal, Principal principal2, List<Certificate> list, List<Certificate> list2);

    void secureConnectStart();
}
