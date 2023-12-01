package com.tencent.cloud.huiyansdkface.wehttp2;

import com.tencent.cloud.huiyansdkface.okhttp3.Request;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.security.Principal;
import java.security.cert.Certificate;
import java.text.SimpleDateFormat;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/wehttp2/WeEventReport.class */
public class WeEventReport implements EventReport {

    /* renamed from: a  reason: collision with root package name */
    private final SimpleDateFormat f22434a = new SimpleDateFormat("mm:ss.SSS");
    private final StringBuilder b = new StringBuilder();

    /* renamed from: c  reason: collision with root package name */
    private final TimePointInfo f22435c = new TimePointInfo();
    private final ReportCallback d;
    private Request e;

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/wehttp2/WeEventReport$ReportCallback.class */
    public interface ReportCallback {
        void reportFinish(TimePointInfo timePointInfo, StringBuilder sb);
    }

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/wehttp2/WeEventReport$TimePointInfo.class */
    public static class TimePointInfo {

        /* renamed from: a  reason: collision with root package name */
        private long f22436a;
        private long b;

        /* renamed from: c  reason: collision with root package name */
        private long f22437c;
        private long d;
        private long e;
        private long f;
        private long g;
        private long h;
        private long i;
        private long j;
        private long k;
        private long l;
        private int m;
        private int n;

        static /* synthetic */ int b(TimePointInfo timePointInfo) {
            int i = timePointInfo.m;
            timePointInfo.m = i + 1;
            return i;
        }

        static /* synthetic */ int e(TimePointInfo timePointInfo) {
            int i = timePointInfo.n;
            timePointInfo.n = i + 1;
            return i;
        }

        public long getCallUseTime() {
            return this.l;
        }

        public long getConnectStart() {
            return this.f22437c;
        }

        public int getConnectStartCount() {
            return this.n;
        }

        public long getConnectUseTime() {
            return this.h;
        }

        public long getDnsStart() {
            return this.b;
        }

        public int getDnsStartCount() {
            return this.m;
        }

        public long getDnsUseTime() {
            return this.g;
        }

        public long getReqStart() {
            return this.e;
        }

        public long getReqUseTime() {
            return this.j;
        }

        public long getRespStart() {
            return this.f;
        }

        public long getRespUseTime() {
            return this.k;
        }

        public long getSecureConnectStart() {
            return this.d;
        }

        public long getSecureConnectUseTime() {
            return this.i;
        }

        public long getStartTime() {
            return this.f22436a;
        }
    }

    public WeEventReport(Request request, ReportCallback reportCallback) {
        this.e = request;
        this.d = reportCallback;
    }

    private String a(long j) {
        return this.f22434a.format(Long.valueOf(j));
    }

    private void a() {
        this.f22435c.l = System.currentTimeMillis() - this.f22435c.f22436a;
        StringBuilder sb = this.b;
        int indexOf = sb.indexOf("]]]");
        sb.insert(indexOf, "(" + this.f22435c.l + ")");
    }

    private void a(List<InetAddress> list, StringBuilder sb) {
        if (list == null || list.size() <= 0) {
            sb.append("NONE");
            return;
        }
        int size = list.size();
        for (int i = 0; i < size - 1; i++) {
            sb.append(list.get(i).toString());
            sb.append(",");
        }
        sb.append(list.get(list.size() - 1));
    }

    private String b() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(Long.valueOf(System.currentTimeMillis()));
    }

    private String b(long j) {
        return this.f22434a.format(Long.valueOf(j));
    }

    @Override // com.tencent.cloud.huiyansdkface.wehttp2.EventReport
    public void callEnd() {
        StringBuilder sb = this.b;
        sb.append(a(System.currentTimeMillis()));
        sb.append(":callEnd\n");
        a();
        this.b.append("Statistical data：\n");
        StringBuilder sb2 = this.b;
        sb2.append("\tdnsUseTime:");
        sb2.append(this.f22435c.g);
        sb2.append("\n");
        StringBuilder sb3 = this.b;
        sb3.append("\tsecureConnectUseTime:");
        sb3.append(this.f22435c.i);
        sb3.append("\n");
        StringBuilder sb4 = this.b;
        sb4.append("\tconnectUseTime:");
        sb4.append(this.f22435c.h);
        sb4.append("\n");
        StringBuilder sb5 = this.b;
        sb5.append("\treqUseTime:");
        sb5.append(this.f22435c.j);
        sb5.append("\n");
        StringBuilder sb6 = this.b;
        sb6.append("\trespUseTime:");
        sb6.append(this.f22435c.k);
        sb6.append("\n");
        StringBuilder sb7 = this.b;
        sb7.append("\ttotalUseTime:");
        sb7.append(this.f22435c.l);
        sb7.append("\n");
        ReportCallback reportCallback = this.d;
        if (reportCallback != null) {
            reportCallback.reportFinish(this.f22435c, this.b);
        }
    }

    @Override // com.tencent.cloud.huiyansdkface.wehttp2.EventReport
    public void callFailed(IOException iOException) {
        StringBuilder sb = this.b;
        sb.append(a(System.currentTimeMillis()));
        sb.append(":callFailed:");
        sb.append(iOException);
        sb.append("\n");
        a();
        ReportCallback reportCallback = this.d;
        if (reportCallback != null) {
            reportCallback.reportFinish(this.f22435c, this.b);
        }
    }

    @Override // com.tencent.cloud.huiyansdkface.wehttp2.EventReport
    public void callStart() {
        this.f22435c.f22436a = System.currentTimeMillis();
        StringBuilder sb = this.b;
        sb.append("WeHttp Log: \n[[[");
        sb.append(b());
        sb.append("\t");
        sb.append(this.e.url().toString());
        sb.append("]]]\n");
        LogTag logTag = (LogTag) this.e.tag(LogTag.class);
        if (logTag != null && logTag.getTag() != null) {
            StringBuilder sb2 = this.b;
            sb2.append(logTag.getTag());
            sb2.append("\n");
        }
        StringBuilder sb3 = this.b;
        sb3.append(a(this.f22435c.f22436a));
        sb3.append(":callStart\n");
    }

    @Override // com.tencent.cloud.huiyansdkface.wehttp2.EventReport
    public void connectEnd(String str) {
        if (!this.e.isHttps()) {
            this.f22435c.h = System.currentTimeMillis() - this.f22435c.f22437c;
        }
        StringBuilder sb = this.b;
        sb.append(a(System.currentTimeMillis()));
        sb.append(":connectEnd(");
        sb.append(this.f22435c.h);
        sb.append("):");
        sb.append(str);
        sb.append("\n");
    }

    @Override // com.tencent.cloud.huiyansdkface.wehttp2.EventReport
    public void connectFailed(String str, IOException iOException) {
        long currentTimeMillis = System.currentTimeMillis();
        if (!this.e.isHttps() || this.f22435c.h <= 0) {
            TimePointInfo timePointInfo = this.f22435c;
            timePointInfo.h = currentTimeMillis - timePointInfo.f22437c;
        }
        if (this.e.isHttps() && this.f22435c.d > 0 && this.f22435c.i <= 0) {
            TimePointInfo timePointInfo2 = this.f22435c;
            timePointInfo2.i = currentTimeMillis - timePointInfo2.d;
        }
        StringBuilder sb = this.b;
        sb.append(a(currentTimeMillis));
        sb.append(":connectFailed(");
        sb.append(this.f22435c.h);
        sb.append("):");
        sb.append(str);
        sb.append(":");
        sb.append(iOException);
        sb.append("\n");
    }

    @Override // com.tencent.cloud.huiyansdkface.wehttp2.EventReport
    public void connectStart(InetSocketAddress inetSocketAddress, Proxy proxy) {
        TimePointInfo.e(this.f22435c);
        this.f22435c.f22437c = System.currentTimeMillis();
        StringBuilder sb = this.b;
        sb.append(a(this.f22435c.f22437c));
        sb.append(":connectStart:");
        sb.append(inetSocketAddress.toString());
        sb.append(",");
        sb.append(proxy.toString());
        sb.append("\n");
    }

    @Override // com.tencent.cloud.huiyansdkface.wehttp2.EventReport
    public void connectionAcquired() {
        StringBuilder sb = this.b;
        sb.append(a(System.currentTimeMillis()));
        sb.append(":connectionAcquired");
        sb.append("\n");
    }

    @Override // com.tencent.cloud.huiyansdkface.wehttp2.EventReport
    public void connectionReleased() {
        StringBuilder sb = this.b;
        sb.append(a(System.currentTimeMillis()));
        sb.append(":connectionReleased\n");
    }

    @Override // com.tencent.cloud.huiyansdkface.wehttp2.EventReport
    public void dnsEnd(List<InetAddress> list) {
        long currentTimeMillis = System.currentTimeMillis();
        TimePointInfo timePointInfo = this.f22435c;
        timePointInfo.g = currentTimeMillis - timePointInfo.b;
        StringBuilder sb = this.b;
        sb.append(a(currentTimeMillis));
        sb.append(":dnsEnd(");
        sb.append(this.f22435c.g);
        sb.append("):");
        a(list, this.b);
        this.b.append("\n");
    }

    @Override // com.tencent.cloud.huiyansdkface.wehttp2.EventReport
    public void dnsStart(String str) {
        TimePointInfo.b(this.f22435c);
        this.f22435c.b = System.currentTimeMillis();
        StringBuilder sb = this.b;
        sb.append(a(this.f22435c.b));
        sb.append(":dnsStart:" + str);
        sb.append("\n");
    }

    @Override // com.tencent.cloud.huiyansdkface.wehttp2.EventReport
    public void requestBodyEnd(long j) {
        long currentTimeMillis = System.currentTimeMillis();
        TimePointInfo timePointInfo = this.f22435c;
        timePointInfo.j = currentTimeMillis - timePointInfo.e;
        StringBuilder sb = this.b;
        sb.append(a(currentTimeMillis));
        sb.append(":requestBodyEnd(");
        sb.append(this.f22435c.j);
        sb.append("):");
        sb.append(j);
        sb.append("\n");
    }

    @Override // com.tencent.cloud.huiyansdkface.wehttp2.EventReport
    public void requestBodyStart() {
        StringBuilder sb = this.b;
        sb.append(a(System.currentTimeMillis()));
        sb.append(":requestBodyStart\n");
    }

    @Override // com.tencent.cloud.huiyansdkface.wehttp2.EventReport
    public void requestHeadersEnd() {
        StringBuilder sb = this.b;
        sb.append(a(System.currentTimeMillis()));
        sb.append(":requestHeadersEnd\n");
    }

    @Override // com.tencent.cloud.huiyansdkface.wehttp2.EventReport
    public void requestHeadersStart() {
        this.f22435c.e = System.currentTimeMillis();
        StringBuilder sb = this.b;
        sb.append(a(this.f22435c.e));
        sb.append(":requestHeadersStart\n");
    }

    @Override // com.tencent.cloud.huiyansdkface.wehttp2.EventReport
    public void responseBodyEnd(long j) {
        long currentTimeMillis = System.currentTimeMillis();
        TimePointInfo timePointInfo = this.f22435c;
        timePointInfo.k = currentTimeMillis - timePointInfo.f;
        StringBuilder sb = this.b;
        sb.append(a(currentTimeMillis));
        sb.append(":responseBodyEnd(");
        sb.append(this.f22435c.k);
        sb.append("):");
        sb.append(j);
        sb.append("\n");
    }

    @Override // com.tencent.cloud.huiyansdkface.wehttp2.EventReport
    public void responseBodyStart() {
        StringBuilder sb = this.b;
        sb.append(a(System.currentTimeMillis()));
        sb.append(":responseBodyStart\n");
    }

    @Override // com.tencent.cloud.huiyansdkface.wehttp2.EventReport
    public void responseHeadersEnd(int i, String str, long j, long j2) {
        StringBuilder sb = this.b;
        sb.append(a(System.currentTimeMillis()));
        sb.append(":responseHeadersEnd:");
        sb.append(i);
        sb.append(",");
        sb.append(str);
        sb.append(",");
        sb.append(b(j));
        sb.append(",");
        sb.append(b(j2));
        sb.append("\n");
    }

    @Override // com.tencent.cloud.huiyansdkface.wehttp2.EventReport
    public void responseHeadersStart() {
        this.f22435c.f = System.currentTimeMillis();
        StringBuilder sb = this.b;
        sb.append(a(this.f22435c.f));
        sb.append(":responseHeadersStart\n");
    }

    @Override // com.tencent.cloud.huiyansdkface.wehttp2.EventReport
    public void secureConnectEnd(String str, String str2, Principal principal, Principal principal2, List<Certificate> list, List<Certificate> list2) {
        long currentTimeMillis = System.currentTimeMillis();
        TimePointInfo timePointInfo = this.f22435c;
        timePointInfo.i = currentTimeMillis - timePointInfo.d;
        StringBuilder sb = this.b;
        sb.append(a(currentTimeMillis));
        sb.append(":secureConnectEnd(");
        sb.append(this.f22435c.i);
        sb.append("):");
        sb.append(str);
        sb.append(",");
        sb.append(str2);
        sb.append(",");
        sb.append(principal != null ? principal.getName() : "none localPrincipal");
        sb.append(",");
        sb.append(principal2 != null ? principal2.getName() : "none peerPrincipal");
        sb.append(",");
        sb.append(list != null ? list.size() : 0);
        sb.append(",");
        int i = 0;
        if (list2 != null) {
            i = list2.size();
        }
        sb.append(i);
        sb.append("\n");
    }

    @Override // com.tencent.cloud.huiyansdkface.wehttp2.EventReport
    public void secureConnectStart() {
        this.f22435c.d = System.currentTimeMillis();
        TimePointInfo timePointInfo = this.f22435c;
        timePointInfo.h = timePointInfo.d - this.f22435c.f22437c;
        StringBuilder sb = this.b;
        sb.append(a(System.currentTimeMillis()));
        sb.append(":secureConnectStart\n");
    }
}
