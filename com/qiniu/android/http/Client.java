package com.qiniu.android.http;

import android.content.ContentResolver;
import com.blued.android.module.common.web.jsbridge.BridgeUtil;
import com.qiniu.android.collect.LogHandler;
import com.qiniu.android.http.CancellationHandler;
import com.qiniu.android.http.MultipartBody;
import com.qiniu.android.storage.UpCancellationSignal;
import com.qiniu.android.storage.UpToken;
import com.qiniu.android.utils.AsyncRun;
import com.qiniu.android.utils.StringMap;
import com.qiniu.android.utils.StringUtils;
import com.tencent.qcloud.core.http.HttpConstants;
import java.io.IOException;
import java.net.ConnectException;
import java.net.InetAddress;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.json.JSONObject;

/* loaded from: source-8303388-dex2jar.jar:com/qiniu/android/http/Client.class */
public final class Client {
    public static final String ContentTypeHeader = "Content-Type";
    public static final String DefaultMime = "application/octet-stream";
    public static final String FormMime = "application/x-www-form-urlencoded";
    public static final String JsonMime = "application/json";
    private final UrlConverter converter;
    private OkHttpClient httpClient;

    /* loaded from: source-8303388-dex2jar.jar:com/qiniu/android/http/Client$ResponseTag.class */
    public static class ResponseTag {
        public String ip = "";
        public long duration = -1;
        public LogHandler logHandler = null;
    }

    public Client() {
        this(null, 10, 30, null, null);
    }

    public Client(ProxyConfiguration proxyConfiguration, int i, int i2, UrlConverter urlConverter, Dns dns) {
        this.converter = urlConverter;
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        if (proxyConfiguration != null) {
            builder.proxy(proxyConfiguration.proxy());
            if (proxyConfiguration.user != null && proxyConfiguration.password != null) {
                builder.proxyAuthenticator(proxyConfiguration.authenticator());
            }
        }
        builder.dns(new okhttp3.Dns() { // from class: com.qiniu.android.http.Client.1
            @Override // okhttp3.Dns
            public List<InetAddress> lookup(String str) throws UnknownHostException {
                List<InetAddress> inetAddressByHost = DnsPrefetcher.getDnsPrefetcher().getInetAddressByHost(str);
                return inetAddressByHost != null ? inetAddressByHost : okhttp3.Dns.SYSTEM.lookup(str);
            }
        });
        builder.networkInterceptors().add(new Interceptor() { // from class: com.qiniu.android.http.Client.2
            @Override // okhttp3.Interceptor
            public Response intercept(Interceptor.Chain chain) throws IOException {
                String str;
                Request request = chain.request();
                long currentTimeMillis = System.currentTimeMillis();
                Response proceed = chain.proceed(request);
                long currentTimeMillis2 = System.currentTimeMillis();
                ResponseTag responseTag = (ResponseTag) request.tag();
                try {
                    str = chain.connection().socket().getRemoteSocketAddress().toString();
                } catch (Exception e) {
                    e.printStackTrace();
                    str = "";
                }
                responseTag.ip = str;
                responseTag.duration = currentTimeMillis2 - currentTimeMillis;
                return proceed;
            }
        });
        builder.eventListenerFactory(HttpEventListener.FACTORY);
        builder.connectTimeout(i, TimeUnit.SECONDS);
        builder.readTimeout(i2, TimeUnit.SECONDS);
        builder.writeTimeout(0L, TimeUnit.SECONDS);
        this.httpClient = builder.build();
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0056, code lost:
        if (r20 != null) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void asyncMultipartPost(com.qiniu.android.collect.LogHandler r10, java.lang.String r11, com.qiniu.android.utils.StringMap r12, com.qiniu.android.storage.UpToken r13, long r14, com.qiniu.android.http.ProgressHandler r16, java.lang.String r17, okhttp3.RequestBody r18, com.qiniu.android.http.CompletionHandler r19, com.qiniu.android.http.CancellationHandler r20) {
        /*
            r9 = this;
            r0 = r9
            com.qiniu.android.http.UrlConverter r0 = r0.converter
            r21 = r0
            r0 = r21
            if (r0 == 0) goto L17
            r0 = r21
            r1 = r11
            java.lang.String r0 = r0.convert(r1)
            r11 = r0
            goto L17
        L17:
            com.qiniu.android.http.MultipartBody$Builder r0 = new com.qiniu.android.http.MultipartBody$Builder
            r1 = r0
            r1.<init>()
            r21 = r0
            r0 = r21
            java.lang.String r1 = "file"
            r2 = r17
            r3 = r18
            com.qiniu.android.http.MultipartBody$Builder r0 = r0.addFormDataPart(r1, r2, r3)
            r0 = r12
            com.qiniu.android.http.Client$6 r1 = new com.qiniu.android.http.Client$6
            r2 = r1
            r3 = r9
            r4 = r21
            r2.<init>()
            r0.forEach(r1)
            r0 = r21
            java.lang.String r1 = "multipart/form-data"
            okhttp3.MediaType r1 = okhttp3.MediaType.parse(r1)
            com.qiniu.android.http.MultipartBody$Builder r0 = r0.setType(r1)
            r0 = r21
            com.qiniu.android.http.MultipartBody r0 = r0.build()
            r17 = r0
            r0 = r16
            if (r0 != 0) goto L59
            r0 = r17
            r12 = r0
            r0 = r20
            if (r0 == 0) goto L69
        L59:
            com.qiniu.android.http.CountingRequestBody r0 = new com.qiniu.android.http.CountingRequestBody
            r1 = r0
            r2 = r17
            r3 = r16
            r4 = r14
            r5 = r20
            r1.<init>(r2, r3, r4, r5)
            r12 = r0
        L69:
            r0 = r9
            r1 = r10
            okhttp3.Request$Builder r2 = new okhttp3.Request$Builder
            r3 = r2
            r3.<init>()
            r3 = r11
            okhttp3.Request$Builder r2 = r2.url(r3)
            r3 = r12
            okhttp3.Request$Builder r2 = r2.post(r3)
            r3 = 0
            r4 = r13
            r5 = r14
            r6 = r19
            r0.asyncSend(r1, r2, r3, r4, r5, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qiniu.android.http.Client.asyncMultipartPost(com.qiniu.android.collect.LogHandler, java.lang.String, com.qiniu.android.utils.StringMap, com.qiniu.android.storage.UpToken, long, com.qiniu.android.http.ProgressHandler, java.lang.String, okhttp3.RequestBody, com.qiniu.android.http.CompletionHandler, com.qiniu.android.http.CancellationHandler):void");
    }

    private static JSONObject buildJsonResp(byte[] bArr) throws Exception {
        String str = new String(bArr, "utf-8");
        return StringUtils.isNullOrEmpty(str) ? new JSONObject() : new JSONObject(str);
    }

    private static ResponseInfo buildResponseInfo(LogHandler logHandler, Response response, String str, long j, UpToken upToken, long j2) {
        String message;
        byte[] bArr;
        String str2;
        int code = response.code();
        String header = response.header("X-Reqid");
        JSONObject jSONObject = null;
        JSONObject jSONObject2 = null;
        String str3 = header == null ? null : header.trim().split(",")[0];
        try {
            bArr = response.body().bytes();
            message = null;
        } catch (IOException e) {
            message = e.getMessage();
            bArr = null;
        }
        if (!ctype(response).equals("application/json") || bArr == null) {
            str2 = bArr == null ? "null body" : new String(bArr);
        } else {
            try {
                JSONObject buildJsonResp = buildJsonResp(bArr);
                jSONObject = buildJsonResp;
                str2 = message;
                if (response.code() != 200) {
                    jSONObject2 = buildJsonResp;
                    str2 = buildJsonResp.optString("error", new String(bArr, "utf-8"));
                    jSONObject = buildJsonResp;
                }
            } catch (Exception e2) {
                jSONObject = jSONObject2;
                str2 = message;
                if (response.code() < 300) {
                    str2 = e2.getMessage();
                    jSONObject = jSONObject2;
                }
            }
        }
        HttpUrl url = response.request().url();
        return ResponseInfo.create(logHandler, jSONObject, code, str3, response.header("X-Log"), via(response), url.host(), url.encodedPath(), str, url.port(), j, getContentLength(response), str2, upToken, j2);
    }

    private static String ctype(Response response) {
        MediaType contentType = response.body().contentType();
        if (contentType == null) {
            return "";
        }
        return contentType.type() + BridgeUtil.SPLIT_MARK + contentType.subtype();
    }

    private static long getContentLength(Response response) {
        try {
            RequestBody body = response.request().body();
            if (body == null) {
                return 0L;
            }
            return body.contentLength();
        } catch (Throwable th) {
            return -1L;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void onRet(LogHandler logHandler, Response response, String str, long j, UpToken upToken, long j2, final CompletionHandler completionHandler) {
        final ResponseInfo buildResponseInfo = buildResponseInfo(logHandler, response, str, j, upToken, j2);
        AsyncRun.runInMain(new Runnable() { // from class: com.qiniu.android.http.Client.3
            @Override // java.lang.Runnable
            public void run() {
                CompletionHandler completionHandler2 = CompletionHandler.this;
                ResponseInfo responseInfo = buildResponseInfo;
                completionHandler2.complete(responseInfo, responseInfo.response);
            }
        });
    }

    private ResponseInfo send(LogHandler logHandler, final Request.Builder builder, StringMap stringMap) {
        if (stringMap != null) {
            stringMap.forEach(new StringMap.Consumer() { // from class: com.qiniu.android.http.Client.7
                @Override // com.qiniu.android.utils.StringMap.Consumer
                public void accept(String str, Object obj) {
                    builder.header(str, obj.toString());
                }
            });
        }
        builder.header("User-Agent", UserAgent.instance().getUa(""));
        System.currentTimeMillis();
        ResponseTag responseTag = new ResponseTag();
        responseTag.logHandler = logHandler;
        Request build = builder.tag(responseTag).build();
        try {
            return buildResponseInfo(logHandler, this.httpClient.newCall(build).execute(), responseTag.ip, responseTag.duration, UpToken.NULL, 0L);
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseInfo.create(logHandler, null, -1, "", "", "", build.url().host(), build.url().encodedPath(), responseTag.ip, build.url().port(), responseTag.duration, -1L, e.getMessage(), UpToken.NULL, 0L);
        }
    }

    private ResponseInfo syncMultipartPost(LogHandler logHandler, String str, StringMap stringMap, UpToken upToken, long j, String str2, RequestBody requestBody) {
        final MultipartBody.Builder builder = new MultipartBody.Builder();
        builder.addFormDataPart(ContentResolver.SCHEME_FILE, str2, requestBody);
        stringMap.forEach(new StringMap.Consumer() { // from class: com.qiniu.android.http.Client.8
            @Override // com.qiniu.android.utils.StringMap.Consumer
            public void accept(String str3, Object obj) {
                builder.addFormDataPart(str3, obj.toString());
            }
        });
        builder.setType(MediaType.parse(HttpConstants.ContentType.MULTIPART_FORM_DATA));
        return syncSend(logHandler, new Request.Builder().url(str).post(builder.build()), null, upToken, j);
    }

    private static String via(Response response) {
        String header = response.header("X-Via", "");
        if (header.equals("")) {
            String header2 = response.header("X-Px", "");
            if (header2.equals("")) {
                String header3 = response.header("Fw-Via", "");
                if (!header3.equals("")) {
                }
                return header3;
            }
            return header2;
        }
        return header;
    }

    public void asyncGet(LogHandler logHandler, String str, StringMap stringMap, UpToken upToken, CompletionHandler completionHandler) {
        asyncSend(logHandler, new Request.Builder().get().url(str), stringMap, upToken, 0L, completionHandler);
    }

    public void asyncMultipartPost(LogHandler logHandler, String str, PostArgs postArgs, UpToken upToken, ProgressHandler progressHandler, CompletionHandler completionHandler, CancellationHandler cancellationHandler) {
        RequestBody create;
        long length;
        if (postArgs.file != null) {
            create = RequestBody.create(MediaType.parse(postArgs.mimeType), postArgs.file);
            length = postArgs.file.length();
        } else {
            create = RequestBody.create(MediaType.parse(postArgs.mimeType), postArgs.data);
            length = postArgs.data.length;
        }
        asyncMultipartPost(logHandler, str, postArgs.params, upToken, length, progressHandler, postArgs.fileName, create, completionHandler, cancellationHandler);
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x006b, code lost:
        if (r21 != null) goto L21;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void asyncPost(com.qiniu.android.collect.LogHandler r10, java.lang.String r11, byte[] r12, int r13, int r14, com.qiniu.android.utils.StringMap r15, com.qiniu.android.storage.UpToken r16, long r17, com.qiniu.android.http.ProgressHandler r19, com.qiniu.android.http.CompletionHandler r20, com.qiniu.android.http.CancellationHandler r21) {
        /*
            r9 = this;
            r0 = r9
            com.qiniu.android.http.UrlConverter r0 = r0.converter
            r22 = r0
            r0 = r22
            if (r0 == 0) goto L18
            r0 = r22
            r1 = r11
            java.lang.String r0 = r0.convert(r1)
            r22 = r0
            goto L1b
        L18:
            r0 = r11
            r22 = r0
        L1b:
            r0 = r12
            if (r0 == 0) goto L5a
            r0 = r12
            int r0 = r0.length
            if (r0 <= 0) goto L5a
            java.lang.String r0 = "application/octet-stream"
            okhttp3.MediaType r0 = okhttp3.MediaType.parse(r0)
            r23 = r0
            r0 = r23
            r11 = r0
            r0 = r15
            if (r0 == 0) goto L4d
            r0 = r15
            java.lang.String r1 = "Content-Type"
            java.lang.Object r0 = r0.get(r1)
            r24 = r0
            r0 = r23
            r11 = r0
            r0 = r24
            if (r0 == 0) goto L4d
            r0 = r24
            java.lang.String r0 = r0.toString()
            okhttp3.MediaType r0 = okhttp3.MediaType.parse(r0)
            r11 = r0
        L4d:
            r0 = r11
            r1 = r12
            r2 = r13
            r3 = r14
            okhttp3.RequestBody r0 = okhttp3.RequestBody.create(r0, r1, r2, r3)
            r11 = r0
            goto L62
        L5a:
            r0 = 0
            r1 = 0
            byte[] r1 = new byte[r1]
            okhttp3.RequestBody r0 = okhttp3.RequestBody.create(r0, r1)
            r11 = r0
        L62:
            r0 = r19
            if (r0 != 0) goto L6e
            r0 = r11
            r12 = r0
            r0 = r21
            if (r0 == 0) goto L7d
        L6e:
            com.qiniu.android.http.CountingRequestBody r0 = new com.qiniu.android.http.CountingRequestBody
            r1 = r0
            r2 = r11
            r3 = r19
            r4 = r17
            r5 = r21
            r1.<init>(r2, r3, r4, r5)
            r12 = r0
        L7d:
            r0 = r9
            r1 = r10
            okhttp3.Request$Builder r2 = new okhttp3.Request$Builder
            r3 = r2
            r3.<init>()
            r3 = r22
            okhttp3.Request$Builder r2 = r2.url(r3)
            r3 = r12
            okhttp3.Request$Builder r2 = r2.post(r3)
            r3 = r15
            r4 = r16
            r5 = r17
            r6 = r20
            r0.asyncSend(r1, r2, r3, r4, r5, r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qiniu.android.http.Client.asyncPost(com.qiniu.android.collect.LogHandler, java.lang.String, byte[], int, int, com.qiniu.android.utils.StringMap, com.qiniu.android.storage.UpToken, long, com.qiniu.android.http.ProgressHandler, com.qiniu.android.http.CompletionHandler, com.qiniu.android.http.CancellationHandler):void");
    }

    public void asyncPost(LogHandler logHandler, String str, byte[] bArr, StringMap stringMap, UpToken upToken, long j, ProgressHandler progressHandler, CompletionHandler completionHandler, UpCancellationSignal upCancellationSignal) {
        asyncPost(logHandler, str, bArr, 0, bArr.length, stringMap, upToken, j, progressHandler, completionHandler, upCancellationSignal);
    }

    public void asyncSend(final LogHandler logHandler, final Request.Builder builder, StringMap stringMap, final UpToken upToken, final long j, final CompletionHandler completionHandler) {
        if (stringMap != null) {
            stringMap.forEach(new StringMap.Consumer() { // from class: com.qiniu.android.http.Client.4
                @Override // com.qiniu.android.utils.StringMap.Consumer
                public void accept(String str, Object obj) {
                    builder.header(str, obj.toString());
                }
            });
        }
        if (upToken != null) {
            builder.header("User-Agent", UserAgent.instance().getUa(upToken.accessKey));
        } else {
            builder.header("User-Agent", UserAgent.instance().getUa("pandora"));
        }
        final ResponseTag responseTag = new ResponseTag();
        responseTag.logHandler = logHandler;
        this.httpClient.newCall(builder.tag(responseTag).build()).enqueue(new Callback() { // from class: com.qiniu.android.http.Client.5
            @Override // okhttp3.Callback
            public void onFailure(Call call, IOException iOException) {
                iOException.printStackTrace();
                String message = iOException.getMessage();
                int i = iOException instanceof CancellationHandler.CancellationException ? -2 : iOException instanceof UnknownHostException ? -1003 : (message == null || message.indexOf("Broken pipe") != 0) ? iOException instanceof SocketTimeoutException ? -1001 : iOException instanceof ConnectException ? -1004 : -1 : -1005;
                HttpUrl url = call.request().url();
                completionHandler.complete(ResponseInfo.create(logHandler, null, i, "", "", "", url.host(), url.encodedPath(), "", url.port(), responseTag.duration, -1L, iOException.getMessage(), upToken, j), null);
            }

            @Override // okhttp3.Callback
            public void onResponse(Call call, Response response) throws IOException {
                ResponseTag responseTag2 = (ResponseTag) response.request().tag();
                Client.onRet(logHandler, response, responseTag2.ip, responseTag2.duration, upToken, j, completionHandler);
            }
        });
    }

    public ResponseInfo syncGet(LogHandler logHandler, String str, StringMap stringMap) {
        return send(logHandler, new Request.Builder().get().url(str), stringMap);
    }

    public ResponseInfo syncMultipartPost(LogHandler logHandler, String str, PostArgs postArgs, UpToken upToken) {
        RequestBody create;
        long length;
        if (postArgs.file != null) {
            create = RequestBody.create(MediaType.parse(postArgs.mimeType), postArgs.file);
            length = postArgs.file.length();
        } else {
            create = RequestBody.create(MediaType.parse(postArgs.mimeType), postArgs.data);
            length = postArgs.data.length;
        }
        return syncMultipartPost(logHandler, str, postArgs.params, upToken, length, postArgs.fileName, create);
    }

    public ResponseInfo syncSend(LogHandler logHandler, final Request.Builder builder, StringMap stringMap, UpToken upToken, long j) {
        if (stringMap != null) {
            stringMap.forEach(new StringMap.Consumer() { // from class: com.qiniu.android.http.Client.9
                @Override // com.qiniu.android.utils.StringMap.Consumer
                public void accept(String str, Object obj) {
                    builder.header(str, obj.toString());
                }
            });
        }
        builder.header("User-Agent", UserAgent.instance().getUa(upToken.accessKey));
        ResponseTag responseTag = new ResponseTag();
        responseTag.logHandler = logHandler;
        Request request = null;
        try {
            Request build = builder.tag(responseTag).build();
            try {
                return buildResponseInfo(logHandler, this.httpClient.newCall(build).execute(), responseTag.ip, responseTag.duration, upToken, j);
            } catch (Exception e) {
                request = build;
                e = e;
                e.printStackTrace();
                String message = e.getMessage();
                int i = e instanceof UnknownHostException ? -1003 : (message == null || message.indexOf("Broken pipe") != 0) ? e instanceof SocketTimeoutException ? -1001 : e instanceof ConnectException ? -1004 : -1 : -1005;
                HttpUrl url = request.url();
                return ResponseInfo.create(logHandler, null, i, "", "", "", url.host(), url.encodedPath(), "", url.port(), 0L, 0L, e.getMessage(), upToken, j);
            }
        } catch (Exception e2) {
            e = e2;
        }
    }
}
