package mtopsdk.a;

import io.grpc.internal.GrpcUtil;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import mtopsdk.common.util.StringUtils;
import mtopsdk.common.util.TBSdkLog;

/* loaded from: source-3503164-dex2jar.jar:mtopsdk/a/c.class */
public final class c implements a {
    volatile boolean a;
    private mtopsdk.a.b.b b;
    private ExecutorService c;
    private Future d;

    public c(mtopsdk.a.b.b bVar, ExecutorService executorService) {
        this.b = bVar;
        this.c = executorService;
    }

    private static void a(String str, Map map) {
        if (str == null || map == null) {
            return;
        }
        try {
            for (Map.Entry entry : map.entrySet()) {
                String str2 = (String) entry.getKey();
                if (str2 != null && (str2.equalsIgnoreCase("Set-Cookie") || str2.equalsIgnoreCase("Set-Cookie2"))) {
                    for (String str3 : (List) entry.getValue()) {
                        mtopsdk.a.a.a.a(str, str3);
                    }
                }
            }
        } catch (Exception e) {
        }
    }

    private static void a(HttpURLConnection httpURLConnection, mtopsdk.a.b.b bVar) {
        httpURLConnection.setRequestMethod(bVar.b());
        for (Map.Entry entry : bVar.c().entrySet()) {
            if (!((String) entry.getKey()).equalsIgnoreCase("Cookie")) {
                httpURLConnection.addRequestProperty((String) entry.getKey(), (String) entry.getValue());
            }
        }
        if (!StringUtils.b(mtopsdk.a.a.a.a(bVar.a()))) {
            httpURLConnection.addRequestProperty("Cookie", mtopsdk.a.a.a.a(bVar.a()));
        }
        if (GrpcUtil.HTTP_METHOD.equalsIgnoreCase(bVar.b())) {
            httpURLConnection.setDoOutput(true);
        }
        mtopsdk.a.b.d d = bVar.d();
        if (d != null) {
            httpURLConnection.setDoOutput(true);
            httpURLConnection.addRequestProperty("Content-Type", d.a());
            long b = d.b();
            if (b != -1) {
                httpURLConnection.setFixedLengthStreamingMode((int) b);
                httpURLConnection.addRequestProperty("Content-Length", String.valueOf(b));
            }
            OutputStream outputStream = httpURLConnection.getOutputStream();
            try {
                d.a(outputStream);
            } catch (Exception e) {
                TBSdkLog.b("mtopsdk.DefaultCallImpl", "write outputstream error.", e);
            } finally {
                com.taobao.tao.remotebusiness.listener.c.a(outputStream);
            }
        }
    }

    @Override // mtopsdk.a.a
    public final mtopsdk.a.b.b a() {
        return this.b;
    }

    @Override // mtopsdk.a.a
    public final void a(f fVar) {
        ExecutorService executorService = this.c;
        if (executorService == null) {
            fVar.a(this, new Exception("miss executorService in CallImpl "));
            return;
        }
        try {
            this.d = executorService.submit(new e(this, this.b, fVar));
        } catch (Exception e) {
            fVar.a(this, e);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:44:0x019f, code lost:
        r15 = r13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x01a5, code lost:
        if (r13 != null) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x01a8, code lost:
        r15 = new mtopsdk.a.b.h().a(r0).a(r8).a(r14).a();
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x01c4, code lost:
        return r15;
     */
    @Override // mtopsdk.a.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final mtopsdk.a.b.g b() {
        /*
            Method dump skipped, instructions count: 453
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: mtopsdk.a.c.b():mtopsdk.a.b.g");
    }

    @Override // mtopsdk.a.a
    public final void c() {
        TBSdkLog.a("mtopsdk.DefaultCallImpl", "try to cancel call");
        this.a = true;
        Future future = this.d;
        if (future != null) {
            future.cancel(true);
        }
    }
}
