package com.blued.android.core.net.http;

import android.text.TextUtils;
import com.alibaba.fastjson.support.spring.FastJsonJsonView;
import com.android.internal.http.multipart.FilePart;
import com.anythink.core.common.g.g;
import com.blued.android.core.net.HttpManager;
import com.blued.android.core.net.HttpRequestWrapper;
import com.blued.android.core.net.HttpResponseHandler;
import com.blued.android.core.net.StringHttpResponseHandler;
import com.blued.android.core.utils.Log;
import com.qiniu.android.dns.DnsManager;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.Handshake;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okio.Buffer;
import okio.BufferedSink;
import okio.Okio;
import okio.Source;

/* loaded from: source-6737240-dex2jar.jar:com/blued/android/core/net/http/OkHttpUrlRequest.class */
public class OkHttpUrlRequest {
    private long a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.blued.android.core.net.http.OkHttpUrlRequest$3  reason: invalid class name */
    /* loaded from: source-6737240-dex2jar.jar:com/blued/android/core/net/http/OkHttpUrlRequest$3.class */
    public static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] a;

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x0036 -> B:21:0x0014). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x003a -> B:19:0x001f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x003e -> B:25:0x002a). Please submit an issue!!! */
        static {
            int[] iArr = new int[HttpRequestWrapper.HttpType.values().length];
            a = iArr;
            try {
                iArr[HttpRequestWrapper.HttpType.Get.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                a[HttpRequestWrapper.HttpType.Post.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                a[HttpRequestWrapper.HttpType.Put.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                a[HttpRequestWrapper.HttpType.Delete.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    private Callback a(final HttpResponseHandler<?> httpResponseHandler) {
        return new Callback() { // from class: com.blued.android.core.net.http.OkHttpUrlRequest.1
            @Override // okhttp3.Callback
            public void onFailure(Call call, IOException iOException) {
                if (httpResponseHandler != null) {
                    HttpUrl url = call.request().url();
                    OkHttpUrlRequest.this.a(url, (HttpUrl) null, httpResponseHandler);
                    httpResponseHandler.sendFailureMessage(url.toString(), iOException, StatusCode.a(iOException), null);
                    httpResponseHandler.sendFinishMessage();
                    OkHttpUrlRequest.this.a((Response) null);
                }
            }

            @Override // okhttp3.Callback
            public void onResponse(Call call, Response response) {
                Handshake handshake;
                if (httpResponseHandler != null) {
                    HttpUrl url = call.request().url();
                    String httpUrl = url.toString();
                    if (response == null) {
                        OkHttpUrlRequest.this.a(url, (HttpUrl) null, httpResponseHandler);
                        httpResponseHandler.sendFailureMessage(httpUrl, new Exception("response is null!"), g.b, null);
                    } else {
                        OkHttpUrlRequest.this.a(url, response.request().url(), httpResponseHandler);
                        if (HttpManager.c() && (handshake = response.handshake()) != null) {
                            Log.c("HttpManager", "onResponse() tlsVersion=" + handshake.tlsVersion() + ", cipherSuite=" + response.handshake().cipherSuite().toString());
                        }
                        int code = response.code();
                        if (response.body() == null) {
                            httpResponseHandler.sendFailureMessage(httpUrl, new Exception("response body is null!"), code, null);
                        } else {
                            HttpResponseHandler httpResponseHandler2 = httpResponseHandler;
                            if (httpResponseHandler2 instanceof StringHttpResponseHandler) {
                                StringHttpResponseHandler stringHttpResponseHandler = (StringHttpResponseHandler) httpResponseHandler2;
                                String str = "";
                                try {
                                    String string = response.body().string();
                                    if (response.isSuccessful()) {
                                        str = string;
                                        stringHttpResponseHandler.sendSuccessMessage(httpUrl, code, string);
                                    } else {
                                        StringBuilder sb = new StringBuilder();
                                        sb.append("response is not successful! Response:");
                                        sb.append(string);
                                        str = string;
                                        stringHttpResponseHandler.sendFailureMessage(httpUrl, new Exception(sb.toString()), code, string);
                                    }
                                } catch (Exception e) {
                                    e.printStackTrace();
                                    int i = code;
                                    if (code == 0) {
                                        i = code;
                                        if (e instanceof IOException) {
                                            i = StatusCode.a((IOException) e);
                                        }
                                    }
                                    int i2 = i;
                                    if (i >= 200) {
                                        i2 = i;
                                        if (i < 300) {
                                            i2 = 0 - i;
                                        }
                                    }
                                    stringHttpResponseHandler.sendFailureMessage(httpUrl, e, i2, str);
                                }
                            } else {
                                httpResponseHandler2.sendResponseMessage(httpUrl, response);
                            }
                        }
                    }
                    httpResponseHandler.sendFinishMessage();
                }
                OkHttpUrlRequest.this.a(response);
            }
        };
    }

    private static RequestBody a(final MediaType mediaType, final File file, final HttpResponseHandler<?> httpResponseHandler) {
        return new RequestBody() { // from class: com.blued.android.core.net.http.OkHttpUrlRequest.2
            @Override // okhttp3.RequestBody
            public long contentLength() {
                return file.length();
            }

            @Override // okhttp3.RequestBody
            public MediaType contentType() {
                return MediaType.this;
            }

            @Override // okhttp3.RequestBody
            public void writeTo(BufferedSink bufferedSink) throws IOException {
                try {
                    long contentLength = contentLength();
                    long j = 0;
                    int i = -1;
                    Source source = Okio.source(file);
                    Buffer buffer = new Buffer();
                    while (true) {
                        long read = source.read(buffer, 2048L);
                        if (read == -1) {
                            return;
                        }
                        bufferedSink.write(buffer, read);
                        long j2 = j + read;
                        j = j2;
                        if (httpResponseHandler != null) {
                            int i2 = (int) ((((float) j2) * 100.0f) / ((float) contentLength));
                            j = j2;
                            if (i2 != i) {
                                httpResponseHandler.sendProgressMessage(i2, (int) contentLength);
                                i = i2;
                                j = j2;
                            }
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(HttpUrl httpUrl, HttpUrl httpUrl2, HttpResponseHandler httpResponseHandler) {
        String[] queryFromCache;
        if (httpUrl2 != null) {
            String host = httpUrl2.host();
            if (DnsManager.validIP(host)) {
                httpResponseHandler.setServerIP(host);
                return;
            }
        }
        if (HttpManager.d() == null || (queryFromCache = HttpManager.d().queryFromCache(httpUrl.host())) == null || queryFromCache.length <= 0) {
            return;
        }
        httpResponseHandler.setServerIP(queryFromCache[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Response response) {
        if (HttpManager.c()) {
            StringBuilder sb = new StringBuilder("request take time:");
            sb.append(System.currentTimeMillis() - this.a);
            if (response != null) {
                sb.append(" / real take time:");
                sb.append(response.receivedResponseAtMillis() - response.sentRequestAtMillis());
                Request request = response.request();
                if (request != null && request.url() != null) {
                    sb.append(" [");
                    sb.append(response.request().url().toString());
                    sb.append("]");
                }
            }
            Log.a("HttpManager", sb.toString());
        }
    }

    private RequestBody b(HttpRequestWrapper httpRequestWrapper) {
        RequestParams b = httpRequestWrapper.b();
        if (b == null) {
            return RequestBody.create((MediaType) null, "");
        }
        if (b.e != null) {
            return RequestBody.create(MediaType.parse(FastJsonJsonView.DEFAULT_CONTENT_TYPE), b.e);
        }
        if (b.f != null) {
            FormBody.Builder builder = new FormBody.Builder();
            for (Map.Entry<String, String> entry : b.f.entrySet()) {
                builder.add(entry.getKey(), entry.getValue());
            }
            return builder.build();
        } else if (b.g != null) {
            return RequestBody.create(MediaType.parse(FilePart.DEFAULT_CONTENT_TYPE), b.g);
        } else {
            if (TextUtils.isEmpty(b.c)) {
                if (b.a != null) {
                    FormBody.Builder builder2 = new FormBody.Builder();
                    for (Map.Entry<String, String> entry2 : b.a.entrySet()) {
                        builder2.add(entry2.getKey(), entry2.getValue());
                    }
                    return builder2.build();
                }
                return RequestBody.create((MediaType) null, "");
            }
            MultipartBody.Builder type = new MultipartBody.Builder().setType(MultipartBody.FORM);
            for (Map.Entry<String, String> entry3 : b.a.entrySet()) {
                type.addFormDataPart(entry3.getKey(), entry3.getValue());
            }
            File file = new File(b.c);
            RequestBody a = a(MediaType.parse("image/jpeg"), file, httpRequestWrapper.c());
            if (TextUtils.isEmpty(b.b)) {
                type.addFormDataPart(file.getName(), file.getName(), a);
            } else {
                type.addFormDataPart(b.b, file.getName(), a);
            }
            return type.build();
        }
    }

    public Call a(HttpRequestWrapper httpRequestWrapper) {
        if (HttpManager.c()) {
            Log.a("HttpManager", "use okhttp to execute");
        }
        HttpResponseHandler<?> c = httpRequestWrapper.c();
        if (c != null) {
            c.sendStartMessage();
        }
        this.a = System.currentTimeMillis();
        String j = httpRequestWrapper.j();
        try {
            Request.Builder builder = new Request.Builder();
            int i = AnonymousClass3.a[httpRequestWrapper.getType().ordinal()];
            if (i == 1) {
                builder.get();
            } else if (i == 2) {
                builder.post(b(httpRequestWrapper));
            } else if (i == 3) {
                builder.put(b(httpRequestWrapper));
            } else if (i == 4) {
                builder.delete();
            }
            builder.url(j);
            Map<String, String> e = httpRequestWrapper.e();
            if (e != null && e.size() > 0) {
                for (Map.Entry<String, String> entry : e.entrySet()) {
                    builder.addHeader(entry.getKey(), entry.getValue());
                }
            }
            Call newCall = OkHttpUtils.a.newCall(builder.build());
            Callback a = a(c);
            if (!httpRequestWrapper.g()) {
                newCall.enqueue(a);
                return newCall;
            }
            try {
                a.onResponse(newCall, newCall.execute());
                return newCall;
            } catch (IOException e2) {
                a.onFailure(newCall, e2);
                return newCall;
            }
        } catch (Exception e3) {
            e3.printStackTrace();
            if (c != null) {
                c.sendFailureMessage(j, e3, -2001, null);
                c.sendFinishMessage();
                return null;
            }
            return null;
        }
    }
}
