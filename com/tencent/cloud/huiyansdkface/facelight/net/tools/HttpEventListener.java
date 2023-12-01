package com.tencent.cloud.huiyansdkface.facelight.net.tools;

import android.provider.Downloads;
import com.cdo.oaps.ad.OapsWrapper;
import com.huawei.openalliance.ad.constant.t;
import com.tencent.cloud.huiyansdkface.facelight.common.KycWaSDK;
import com.tencent.cloud.huiyansdkface.normal.tools.WLogger;
import com.tencent.cloud.huiyansdkface.okhttp3.Call;
import com.tencent.cloud.huiyansdkface.okhttp3.Connection;
import com.tencent.cloud.huiyansdkface.okhttp3.EventListener;
import com.tencent.cloud.huiyansdkface.okhttp3.Handshake;
import com.tencent.cloud.huiyansdkface.okhttp3.HttpUrl;
import com.tencent.cloud.huiyansdkface.okhttp3.Protocol;
import com.tencent.cloud.huiyansdkface.okhttp3.Request;
import com.tencent.cloud.huiyansdkface.okhttp3.Response;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.List;
import java.util.Locale;
import java.util.Properties;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/facelight/net/tools/HttpEventListener.class */
public class HttpEventListener extends EventListener {
    private final long callId;
    private final long callStartNanos;
    private boolean isNeedRecord;
    private StringBuilder sbLog;
    private static final String TAG = HttpEventListener.class.getSimpleName();
    public static final EventListener.Factory FACTORY = new EventListener.Factory() { // from class: com.tencent.cloud.huiyansdkface.facelight.net.tools.HttpEventListener.1

        /* renamed from: a  reason: collision with root package name */
        final AtomicLong f21907a = new AtomicLong(1);

        @Override // com.tencent.cloud.huiyansdkface.okhttp3.EventListener.Factory
        public EventListener create(Call call) {
            long andIncrement = this.f21907a.getAndIncrement();
            String encodedPath = call.request().url().encodedPath();
            return (encodedPath.contains("Login") || encodedPath.contains("resource") || encodedPath.contains("Resource") || encodedPath.contains("facecompare") || encodedPath.contains("Facecompare") || encodedPath.contains("faceCompare") || encodedPath.contains("appupload") || encodedPath.contains("appUpload") || encodedPath.contains("uploadData") || encodedPath.contains("WbGradeInfo.json")) ? new HttpEventListener(true, andIncrement, call.request().url(), System.nanoTime()) : new HttpEventListener(false, andIncrement, call.request().url(), System.nanoTime());
        }
    };

    public HttpEventListener(boolean z, long j, HttpUrl httpUrl, long j2) {
        this.isNeedRecord = z;
        this.callId = j;
        this.callStartNanos = j2;
        StringBuilder sb = new StringBuilder(httpUrl.encodedPath());
        sb.append(" ");
        sb.append(j);
        sb.append(":");
        this.sbLog = sb;
    }

    private void recordEventLog(String str) {
        if (this.isNeedRecord) {
            long nanoTime = System.nanoTime();
            long j = this.callStartNanos;
            StringBuilder sb = this.sbLog;
            sb.append(String.format(Locale.CHINA, "%.3f-%s", Double.valueOf((nanoTime - j) / 1.0E9d), str));
            sb.append(t.aE);
            if ("callEnd".equalsIgnoreCase(str) || "callFailed".equalsIgnoreCase(str)) {
                WLogger.i(TAG, this.sbLog.toString());
                KycWaSDK.getInstance().trackCustomKVEvent(null, "face_service_http_event", this.sbLog.toString(), null);
            }
        }
    }

    @Override // com.tencent.cloud.huiyansdkface.okhttp3.EventListener
    public void callEnd(Call call) {
        super.callEnd(call);
        recordEventLog("callEnd");
    }

    @Override // com.tencent.cloud.huiyansdkface.okhttp3.EventListener
    public void callFailed(Call call, IOException iOException) {
        super.callFailed(call, iOException);
        recordEventLog("callFailed");
    }

    @Override // com.tencent.cloud.huiyansdkface.okhttp3.EventListener
    public void callStart(Call call) {
        super.callStart(call);
        recordEventLog("callStart");
    }

    @Override // com.tencent.cloud.huiyansdkface.okhttp3.EventListener
    public void connectEnd(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol) {
        super.connectEnd(call, inetSocketAddress, proxy, protocol);
        recordEventLog("connectEnd");
    }

    @Override // com.tencent.cloud.huiyansdkface.okhttp3.EventListener
    public void connectFailed(Call call, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol, IOException iOException) {
        super.connectFailed(call, inetSocketAddress, proxy, protocol, iOException);
        String str = "";
        String hostAddress = (inetSocketAddress == null || inetSocketAddress.getAddress() == null) ? "" : inetSocketAddress.getAddress().getHostAddress();
        recordEventLog("connectFailed:" + hostAddress);
        if (this.isNeedRecord) {
            if (iOException != null) {
                iOException.printStackTrace();
                str = iOException.toString();
            }
            String encodedPath = call.request().url().encodedPath();
            Properties properties = new Properties();
            properties.setProperty(OapsWrapper.KEY_PATH, encodedPath);
            properties.setProperty("ipInfo", hostAddress);
            properties.setProperty(Downloads.Impl.COLUMN_ERROR_MSG, str);
            KycWaSDK.getInstance().trackIMSWarnVEvent(null, "faceservice_http_connect_failed", null, properties);
        }
    }

    @Override // com.tencent.cloud.huiyansdkface.okhttp3.EventListener
    public void connectStart(Call call, InetSocketAddress inetSocketAddress, Proxy proxy) {
        super.connectStart(call, inetSocketAddress, proxy);
        String hostAddress = (inetSocketAddress == null || inetSocketAddress.getAddress() == null) ? "" : inetSocketAddress.getAddress().getHostAddress();
        recordEventLog("connectStart:" + hostAddress);
        String str = TAG;
        WLogger.d(str, "connectStart:" + hostAddress);
    }

    @Override // com.tencent.cloud.huiyansdkface.okhttp3.EventListener
    public void connectionAcquired(Call call, Connection connection) {
        super.connectionAcquired(call, connection);
        recordEventLog("connectionAcquired");
    }

    @Override // com.tencent.cloud.huiyansdkface.okhttp3.EventListener
    public void connectionReleased(Call call, Connection connection) {
        super.connectionReleased(call, connection);
        recordEventLog("connectionReleased");
    }

    @Override // com.tencent.cloud.huiyansdkface.okhttp3.EventListener
    public void dnsEnd(Call call, String str, List<InetAddress> list) {
        super.dnsEnd(call, str, list);
        recordEventLog("dnsEnd");
    }

    @Override // com.tencent.cloud.huiyansdkface.okhttp3.EventListener
    public void dnsStart(Call call, String str) {
        super.dnsStart(call, str);
        recordEventLog("dnsStart:" + str);
    }

    @Override // com.tencent.cloud.huiyansdkface.okhttp3.EventListener
    public void requestBodyEnd(Call call, long j) {
        super.requestBodyEnd(call, j);
        recordEventLog("requestBodyEnd:" + j);
    }

    @Override // com.tencent.cloud.huiyansdkface.okhttp3.EventListener
    public void requestBodyStart(Call call) {
        super.requestBodyStart(call);
        recordEventLog("requestBodyStart");
    }

    @Override // com.tencent.cloud.huiyansdkface.okhttp3.EventListener
    public void requestHeadersEnd(Call call, Request request) {
        super.requestHeadersEnd(call, request);
        recordEventLog("requestHeadersEnd");
    }

    @Override // com.tencent.cloud.huiyansdkface.okhttp3.EventListener
    public void requestHeadersStart(Call call) {
        super.requestHeadersStart(call);
        recordEventLog("requestHeadersStart");
    }

    @Override // com.tencent.cloud.huiyansdkface.okhttp3.EventListener
    public void responseBodyEnd(Call call, long j) {
        super.responseBodyEnd(call, j);
        recordEventLog("responseBodyEnd");
    }

    @Override // com.tencent.cloud.huiyansdkface.okhttp3.EventListener
    public void responseBodyStart(Call call) {
        super.responseBodyStart(call);
        recordEventLog("responseBodyStart");
    }

    @Override // com.tencent.cloud.huiyansdkface.okhttp3.EventListener
    public void responseHeadersEnd(Call call, Response response) {
        super.responseHeadersEnd(call, response);
        recordEventLog("responseHeadersEnd");
    }

    @Override // com.tencent.cloud.huiyansdkface.okhttp3.EventListener
    public void responseHeadersStart(Call call) {
        super.responseHeadersStart(call);
        recordEventLog("responseHeadersStart");
    }

    @Override // com.tencent.cloud.huiyansdkface.okhttp3.EventListener
    public void secureConnectEnd(Call call, Handshake handshake) {
        super.secureConnectEnd(call, handshake);
        recordEventLog("secureConnectEnd:" + handshake.tlsVersion());
    }

    @Override // com.tencent.cloud.huiyansdkface.okhttp3.EventListener
    public void secureConnectStart(Call call) {
        super.secureConnectStart(call);
        recordEventLog("secureConnectStart");
    }
}
