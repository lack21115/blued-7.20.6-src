package com.zx.a.I8b7;

import com.ss.android.socialbase.downloader.utils.DownloadUtils;
import com.zx.a.I8b7.b1;
import com.zx.a.I8b7.e1;
import com.zx.a.I8b7.f1;
import com.zx.a.I8b7.g0;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.zip.GZIPInputStream;

/* loaded from: source-8829756-dex2jar.jar:com/zx/a/I8b7/f.class */
public class f implements g0 {
    @Override // com.zx.a.I8b7.g0
    public e1 a(g0.a aVar) throws IOException {
        f1 f1Var;
        v0 v0Var = (v0) aVar;
        b1 b1Var = v0Var.f42217c;
        b1.a aVar2 = new b1.a(b1Var);
        HttpURLConnection httpURLConnection = (HttpURLConnection) b1Var.f42104a.openConnection();
        d1 d1Var = b1Var.d;
        if (d1Var != null) {
            c1 c1Var = (c1) d1Var;
            n0 n0Var = c1Var.f42110a;
            if (n0Var != null) {
                aVar2.f42107c.put("Content-Type", n0Var.f42151a);
            }
            long j = c1Var.b;
            if (j != -1) {
                aVar2.f42107c.put("Content-Length", Long.toString(j));
                aVar2.f42107c.remove("Transfer-Encoding");
            } else {
                aVar2.f42107c.put("Transfer-Encoding", DownloadUtils.VALUE_CHUNKED);
                aVar2.f42107c.remove("Content-Length");
            }
        }
        if (b1Var.f42105c.get("Host") == null) {
            aVar2.f42107c.put("Host", b1Var.f42104a.getHost());
        }
        if (b1Var.f42105c.get("Connection") == null) {
            aVar2.f42107c.put("Connection", com.anythink.expressad.foundation.g.f.g.c.f7906c);
        }
        boolean z = false;
        if (b1Var.f42105c.get("Accept-Encoding") == null) {
            z = false;
            if (b1Var.f42105c.get("Range") == null) {
                z = true;
                aVar2.f42107c.put("Accept-Encoding", "gzip");
            }
        }
        e1 a2 = v0Var.a(new b1(aVar2), httpURLConnection);
        e1.a aVar3 = new e1.a(a2);
        aVar3.f42122a = b1Var;
        if (z && "gzip".equalsIgnoreCase(a2.a("Content-Encoding")) && (f1Var = a2.e) != null) {
            aVar3.e = f1.a(((f1.a) f1Var).f42127a, -1L, new GZIPInputStream(((f1.a) a2.e).f42128c));
            aVar3.d.remove("Content-Encoding");
            aVar3.d.remove("Content-Length");
        }
        return aVar3.a();
    }
}
