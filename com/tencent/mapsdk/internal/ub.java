package com.tencent.mapsdk.internal;

import com.tencent.map.tools.net.NetRequest;
import com.tencent.map.tools.net.http.HttpProxyRule;
import com.tencent.map.tools.net.processor.RequestProcessor;
import java.util.List;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/ub.class */
public class ub implements RequestProcessor {

    /* renamed from: a  reason: collision with root package name */
    private final List<HttpProxyRule> f24352a;
    private final boolean b;

    private ub(List<HttpProxyRule> list, boolean z) {
        this.f24352a = list;
        this.b = z;
    }

    public static ub a(List<HttpProxyRule> list) {
        return a(list, false);
    }

    public static ub a(List<HttpProxyRule> list, boolean z) {
        return new ub(list, z);
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0077, code lost:
        if (r0 > 65535) goto L24;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.tencent.map.tools.net.http.HttpProxy a(java.lang.String r8, boolean r9) {
        /*
            r7 = this;
            r0 = r7
            java.util.List<com.tencent.map.tools.net.http.HttpProxyRule> r0 = r0.f24352a
            r12 = r0
            r0 = r12
            if (r0 == 0) goto Lb1
            r0 = r12
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto Lb1
            r0 = 0
            r10 = r0
            r0 = r8
            r12 = r0
            r0 = 0
            r11 = r0
        L1d:
            r0 = r10
            r1 = r7
            java.util.List<com.tencent.map.tools.net.http.HttpProxyRule> r1 = r1.f24352a
            int r1 = r1.size()
            if (r0 >= r1) goto L54
            r0 = r7
            java.util.List<com.tencent.map.tools.net.http.HttpProxyRule> r0 = r0.f24352a
            r1 = r10
            java.lang.Object r0 = r0.get(r1)
            com.tencent.map.tools.net.http.HttpProxyRule r0 = (com.tencent.map.tools.net.http.HttpProxyRule) r0
            r13 = r0
            r0 = r13
            r1 = r8
            boolean r0 = r0.match(r1)
            if (r0 == 0) goto L4d
            r0 = r13
            r1 = r8
            java.lang.String r0 = r0.replaceHost(r1)
            r12 = r0
            r0 = 1
            r11 = r0
        L4d:
            r0 = r10
            r1 = 1
            int r0 = r0 + r1
            r10 = r0
            goto L1d
        L54:
            r0 = r11
            if (r0 == 0) goto Lb1
            r0 = r12
            android.net.Uri r0 = android.net.Uri.parse(r0)
            r8 = r0
            r0 = r8
            java.lang.String r0 = r0.getHost()
            r13 = r0
            r0 = r8
            int r0 = r0.getPort()
            r11 = r0
            r0 = r11
            if (r0 < 0) goto L7a
            r0 = r11
            r10 = r0
            r0 = r11
            r1 = 65535(0xffff, float:9.1834E-41)
            if (r0 <= r1) goto L90
        L7a:
            java.lang.String r0 = "https"
            r1 = r8
            java.lang.String r1 = r1.getScheme()
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L8d
            r0 = 443(0x1bb, float:6.21E-43)
            r10 = r0
            goto L90
        L8d:
            r0 = 80
            r10 = r0
        L90:
            java.net.InetSocketAddress r0 = new java.net.InetSocketAddress
            r1 = r0
            r2 = r13
            r3 = r10
            r1.<init>(r2, r3)
            r8 = r0
            com.tencent.map.tools.net.http.HttpProxy r0 = new com.tencent.map.tools.net.http.HttpProxy
            r1 = r0
            java.net.Proxy r2 = new java.net.Proxy
            r3 = r2
            java.net.Proxy$Type r4 = java.net.Proxy.Type.HTTP
            r5 = r8
            r3.<init>(r4, r5)
            r3 = r12
            r4 = r9
            r1.<init>(r2, r3, r4)
            return r0
        Lb1:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mapsdk.internal.ub.a(java.lang.String, boolean):com.tencent.map.tools.net.http.HttpProxy");
    }

    @Override // com.tencent.map.tools.net.processor.RequestProcessor
    public void onRequest(NetRequest netRequest) {
        netRequest.proxy = a(netRequest.url, this.b);
    }
}
