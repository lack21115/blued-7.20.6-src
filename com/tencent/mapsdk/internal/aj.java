package com.tencent.mapsdk.internal;

import android.content.Context;
import com.tencent.map.tools.net.NetManager;
import com.tencent.map.tools.net.NetResponse;
import com.tencent.map.tools.net.NetUtil;
import com.tencent.map.tools.net.exception.NetErrorException;
import com.tencent.map.tools.net.exception.NetUnavailableException;
import com.tencent.mapsdk.vector.VectorMap;

/* loaded from: source-8829756-dex2jar.jar:com/tencent/mapsdk/internal/aj.class */
public class aj extends ib {
    private Context b;
    private String d;
    private VectorMap f;
    private w6 g;

    /* renamed from: c  reason: collision with root package name */
    private nb f23609c = new nb();
    private String e = "";

    public aj(gj gjVar) {
        this.d = "UNKNOW";
        Context context = gjVar.getContext();
        this.b = context;
        this.d = context.getClass().getSimpleName();
        this.b = this.b.getApplicationContext();
        this.f = gjVar.getMap();
        this.g = gjVar.A().w();
    }

    @Override // com.tencent.mapsdk.internal.ib
    public byte[] e(String str) {
        na.a(ma.f, "download url : " + str);
        if (this.b == null || f7.b(str) || !this.f23609c.b(str)) {
            return null;
        }
        if (this.f != null && f7.b(this.e) && !f7.b(this.f.y())) {
            this.e = "&eng_ver=" + this.f.y();
        }
        String g = g(str);
        na.a(ma.f, "rectify url : " + g);
        try {
            NetResponse doGet = NetManager.getInstance().builder().url(g).userAgent(NetUtil.STR_UserAgent).doGet();
            if (doGet == null) {
                return null;
            }
            if (!g.contains("qt=rtt")) {
                this.f23609c.a(g);
            }
            return doGet.data;
        } catch (Exception e) {
            if (g.contains("/mvd_map")) {
                int i = -1;
                if (e instanceof NetUnavailableException) {
                    i = ((NetUnavailableException) e).errorCode;
                } else if (e instanceof NetErrorException) {
                    i = ((NetErrorException) e).statusCode;
                }
                this.g.l().a(System.currentTimeMillis(), g.substring(g.indexOf(63) + 1), i);
                return null;
            }
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0089, code lost:
        if (r0.startsWith(r0) != false) goto L7;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String g(java.lang.String r6) {
        /*
            Method dump skipped, instructions count: 283
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mapsdk.internal.aj.g(java.lang.String):java.lang.String");
    }
}
