package com.efs.sdk.net;

import com.efs.sdk.net.a.a.e;
import com.efs.sdk.net.a.a.f;
import com.efs.sdk.net.a.a.g;
import com.efs.sdk.net.a.a.h;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.zip.InflaterOutputStream;
import okhttp3.Connection;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.Okio;

/* loaded from: source-8110460-dex2jar.jar:com/efs/sdk/net/OkHttpInterceptor.class */
public class OkHttpInterceptor implements Interceptor {

    /* renamed from: a  reason: collision with root package name */
    private final f f21822a = g.c();

    /* loaded from: source-8110460-dex2jar.jar:com/efs/sdk/net/OkHttpInterceptor$a.class */
    static final class a extends ResponseBody {

        /* renamed from: a  reason: collision with root package name */
        private final ResponseBody f21823a;
        private final BufferedSource b;

        public a(ResponseBody responseBody, InputStream inputStream) {
            this.f21823a = responseBody;
            this.b = Okio.buffer(Okio.source(inputStream));
        }

        @Override // okhttp3.ResponseBody
        public final long contentLength() {
            return this.f21823a.contentLength();
        }

        @Override // okhttp3.ResponseBody
        public final MediaType contentType() {
            return this.f21823a.contentType();
        }

        @Override // okhttp3.ResponseBody
        public final BufferedSource source() {
            return this.b;
        }
    }

    /* loaded from: source-8110460-dex2jar.jar:com/efs/sdk/net/OkHttpInterceptor$b.class */
    static final class b implements f.a {

        /* renamed from: a  reason: collision with root package name */
        private final String f21824a;
        private final Request b;

        /* renamed from: c  reason: collision with root package name */
        private h f21825c;

        public b(String str, Request request, h hVar) {
            this.f21824a = str;
            this.b = request;
            this.f21825c = hVar;
        }

        @Override // com.efs.sdk.net.a.a.f.b
        public final String a() {
            return this.f21824a;
        }

        @Override // com.efs.sdk.net.a.a.f.a
        public final String b() {
            return this.b.url().toString();
        }

        @Override // com.efs.sdk.net.a.a.f.a
        public final String c() {
            return this.b.method();
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v15, types: [java.util.zip.InflaterOutputStream] */
        /* JADX WARN: Type inference failed for: r0v33, types: [com.efs.sdk.net.a.a.e] */
        @Override // com.efs.sdk.net.a.a.f.a
        public final byte[] d() {
            RequestBody body = this.b.body();
            if (body == null) {
                return null;
            }
            h hVar = this.f21825c;
            String header = this.b.header("Content-Encoding");
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            hVar.f21841c = new com.efs.sdk.net.a.a.a("gzip".equals(header) ? e.a(byteArrayOutputStream) : "deflate".equals(header) ? new InflaterOutputStream(byteArrayOutputStream) : byteArrayOutputStream);
            hVar.b = byteArrayOutputStream;
            BufferedSink buffer = Okio.buffer(Okio.sink(hVar.f21841c));
            try {
                body.writeTo(buffer);
                buffer.close();
                h hVar2 = this.f21825c;
                hVar2.b();
                return hVar2.b.toByteArray();
            } catch (Throwable th) {
                buffer.close();
                throw th;
            }
        }
    }

    /* loaded from: source-8110460-dex2jar.jar:com/efs/sdk/net/OkHttpInterceptor$c.class */
    static final class c implements f.c {

        /* renamed from: a  reason: collision with root package name */
        private final String f21826a;
        private final Request b;

        /* renamed from: c  reason: collision with root package name */
        private final Response f21827c;
        private final Connection d;

        public c(String str, Request request, Response response, Connection connection) {
            this.f21826a = str;
            this.b = request;
            this.f21827c = response;
            this.d = connection;
        }

        @Override // com.efs.sdk.net.a.a.f.d
        public final String a() {
            return this.f21826a;
        }

        @Override // com.efs.sdk.net.a.a.f.d
        public final int b() {
            return this.f21827c.code();
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(20:1|(5:2|3|4|(1:6)|8)|(3:65|66|(1:68)(9:69|70|21|(5:50|51|(1:53)|44|45)|23|(1:27)|28|29|(10:31|(1:33)(1:46)|34|35|(1:37)|38|39|(2:41|42)|44|45)(3:47|48|49)))|10|(1:12)(1:64)|13|14|15|16|17|18|19|20|21|(0)|23|(2:25|27)|28|29|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x00be, code lost:
        r13 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x00c0, code lost:
        r11 = r12;
        r12 = r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x00cd, code lost:
        r13 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x00cf, code lost:
        r12 = r11;
        r11 = null;
     */
    /* JADX WARN: Removed duplicated region for block: B:38:0x010b A[Catch: all -> 0x01d9, TRY_ENTER, TryCatch #1 {all -> 0x01d9, blocks: (B:33:0x00fd, B:38:0x010b, B:40:0x0113, B:42:0x0130, B:44:0x013a, B:46:0x015c, B:47:0x016c, B:50:0x017a, B:52:0x0182, B:54:0x01a7, B:56:0x01bd, B:56:0x01bd, B:57:0x01c0, B:58:0x01c6), top: B:70:0x00fd }] */
    /* JADX WARN: Removed duplicated region for block: B:44:0x013a A[Catch: all -> 0x01d9, TRY_ENTER, TRY_LEAVE, TryCatch #1 {all -> 0x01d9, blocks: (B:33:0x00fd, B:38:0x010b, B:40:0x0113, B:42:0x0130, B:44:0x013a, B:46:0x015c, B:47:0x016c, B:50:0x017a, B:52:0x0182, B:54:0x01a7, B:56:0x01bd, B:56:0x01bd, B:57:0x01c0, B:58:0x01c6), top: B:70:0x00fd }] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x01bd A[Catch: all -> 0x01d9, all -> 0x01d9, TRY_ENTER, TRY_LEAVE, TryCatch #1 {all -> 0x01d9, blocks: (B:33:0x00fd, B:38:0x010b, B:40:0x0113, B:42:0x0130, B:44:0x013a, B:46:0x015c, B:47:0x016c, B:50:0x017a, B:52:0x0182, B:54:0x01a7, B:56:0x01bd, B:56:0x01bd, B:57:0x01c0, B:58:0x01c6), top: B:70:0x00fd }] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00fd A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // okhttp3.Interceptor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public okhttp3.Response intercept(okhttp3.Interceptor.Chain r9) {
        /*
            Method dump skipped, instructions count: 485
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.efs.sdk.net.OkHttpInterceptor.intercept(okhttp3.Interceptor$Chain):okhttp3.Response");
    }
}
