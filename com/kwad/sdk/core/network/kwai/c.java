package com.kwad.sdk.core.network.kwai;

import android.text.TextUtils;
import android.util.Log;
import com.anythink.expressad.video.module.a.a.m;
import com.google.common.net.HttpHeaders;
import com.huawei.openalliance.ad.utils.ay;
import com.kwad.sdk.core.network.f;
import com.kwad.sdk.core.network.q;
import com.kwad.sdk.export.proxy.AdHttpBodyBuilder;
import com.kwad.sdk.export.proxy.AdHttpFormDataBuilder;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.SocketTimeoutException;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.GZIPInputStream;
import okhttp3.ConnectionSpec;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/network/kwai/c.class */
public final class c {
    private static final Pattern ahg = Pattern.compile("Unexpected response code for CONNECT: ([0-9]+)", 2);
    public static String ahh = "UTF-8";
    private static OkHttpClient ahi = null;
    public static OkHttpClient ahj = wl();

    public static com.kwad.sdk.core.network.c a(String str, Map<String, String> map, boolean z) {
        com.kwad.sdk.core.network.c cVar = new com.kwad.sdk.core.network.c();
        try {
            Request.Builder url = new Request.Builder().url(str);
            a(url);
            a(url, map);
            Response execute = wk().newCall(url.build()).execute();
            cVar.code = execute.code();
            cVar.agd = cVar.code;
            cVar.agf = z ? a(execute) : "";
            return cVar;
        } catch (Exception e) {
            a(cVar, e);
            return cVar;
        }
    }

    private static String a(Response response) {
        InputStream inputStream;
        InputStream inputStream2;
        InputStreamReader inputStreamReader;
        InputStream inputStream3;
        BufferedReader bufferedReader;
        InputStream inputStream4;
        GZIPInputStream gZIPInputStream;
        StringBuilder sb = new StringBuilder();
        try {
            InputStream byteStream = response.body().byteStream();
            try {
                List headers = response.headers("Content-Encoding");
                boolean z = false;
                if (headers != null) {
                    Iterator it = headers.iterator();
                    while (true) {
                        z = false;
                        if (!it.hasNext()) {
                            break;
                        } else if ("gzip".equalsIgnoreCase((String) it.next())) {
                            z = true;
                            break;
                        }
                    }
                }
                if (z) {
                    gZIPInputStream = new GZIPInputStream(byteStream);
                    inputStream4 = gZIPInputStream;
                } else {
                    inputStream4 = null;
                    gZIPInputStream = byteStream;
                }
                try {
                    InputStreamReader inputStreamReader2 = new InputStreamReader(gZIPInputStream, ahh);
                    try {
                        bufferedReader = new BufferedReader(inputStreamReader2, 8);
                        while (true) {
                            try {
                                String readLine = bufferedReader.readLine();
                                if (readLine == null) {
                                    com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader);
                                    com.kwad.sdk.crash.utils.b.closeQuietly(inputStreamReader2);
                                    com.kwad.sdk.crash.utils.b.closeQuietly(inputStream4);
                                    com.kwad.sdk.crash.utils.b.closeQuietly(byteStream);
                                    return sb.toString();
                                }
                                sb.append(readLine);
                            } catch (Throwable th) {
                                inputStream3 = byteStream;
                                inputStream2 = inputStream4;
                                inputStreamReader = inputStreamReader2;
                                th = th;
                                com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader);
                                com.kwad.sdk.crash.utils.b.closeQuietly(inputStreamReader);
                                com.kwad.sdk.crash.utils.b.closeQuietly(inputStream2);
                                com.kwad.sdk.crash.utils.b.closeQuietly(inputStream3);
                                throw th;
                            }
                        }
                    } catch (Throwable th2) {
                        bufferedReader = null;
                        inputStream3 = byteStream;
                        inputStream2 = inputStream4;
                        inputStreamReader = inputStreamReader2;
                        th = th2;
                    }
                } catch (Throwable th3) {
                    bufferedReader = null;
                    inputStream3 = byteStream;
                    inputStream2 = inputStream4;
                    inputStreamReader = null;
                    th = th3;
                }
            } catch (Throwable th4) {
                th = th4;
                inputStream = byteStream;
                inputStream2 = null;
                inputStreamReader = null;
                inputStream3 = inputStream;
                bufferedReader = null;
                com.kwad.sdk.crash.utils.b.closeQuietly(bufferedReader);
                com.kwad.sdk.crash.utils.b.closeQuietly(inputStreamReader);
                com.kwad.sdk.crash.utils.b.closeQuietly(inputStream2);
                com.kwad.sdk.crash.utils.b.closeQuietly(inputStream3);
                throw th;
            }
        } catch (Throwable th5) {
            th = th5;
            inputStream = null;
        }
    }

    private static void a(com.kwad.sdk.core.network.c cVar, Exception exc) {
        String message;
        cVar.age = exc;
        if (cVar.agd == -1 && (exc instanceof IOException) && (message = exc.getMessage()) != null) {
            Matcher matcher = ahg.matcher(message);
            if (matcher.find()) {
                try {
                    cVar.agd = Integer.parseInt(matcher.group(1));
                } catch (Exception e) {
                }
            }
        }
        if (exc instanceof SocketTimeoutException) {
            cVar.code = f.agi.errorCode;
            cVar.agf = f.agi.msg;
        } else {
            cVar.code = f.agj.errorCode;
            try {
                cVar.agf = f.agj.msg + "/n" + Log.getStackTraceString(exc);
            } catch (Exception e2) {
            }
        }
        if (com.kwad.b.kwai.a.bI.booleanValue()) {
            com.kwad.sdk.core.d.b.printStackTraceOnly(exc);
        }
    }

    private static void a(Request.Builder builder) {
        builder.addHeader("User-Agent", q.getUserAgent());
        builder.addHeader("BrowserUa", q.wh());
        builder.addHeader("SystemUa", q.wg());
    }

    private static void a(Request.Builder builder, Map<String, String> map) {
        if (builder == null || map == null || map.isEmpty()) {
            return;
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (entry != null) {
                try {
                    builder.removeHeader(entry.getKey());
                    builder.addHeader(entry.getKey(), entry.getValue());
                } catch (Exception e) {
                }
            }
        }
    }

    private static void a(Request.Builder builder, JSONObject jSONObject) {
        builder.post(RequestBody.create(MediaType.parse("application/json; charset=utf-8"), jSONObject.toString()));
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0044 A[Catch: all -> 0x0112, TRY_ENTER, TRY_LEAVE, TryCatch #2 {all -> 0x0112, blocks: (B:5:0x0010, B:7:0x001a, B:9:0x0022, B:11:0x002a, B:17:0x0044), top: B:61:0x0010 }] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0074 A[Catch: all -> 0x00ec, LOOP:1: B:25:0x0074->B:29:0x0095, LOOP_START, PHI: r9 
      PHI: (r9v1 long) = (r9v0 long), (r9v2 long) binds: [B:24:0x0071, B:29:0x0095] A[DONT_GENERATE, DONT_INLINE], TRY_ENTER, TRY_LEAVE, TryCatch #4 {all -> 0x00ec, blocks: (B:22:0x0069, B:25:0x0074, B:33:0x00a7), top: B:65:0x0069 }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x009f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean a(okhttp3.Response r5, java.io.OutputStream r6, int r7) {
        /*
            Method dump skipped, instructions count: 333
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.core.network.kwai.c.a(okhttp3.Response, java.io.OutputStream, int):boolean");
    }

    private static void b(Request.Builder builder, Map<String, String> map) {
        RequestBody requestBody;
        if (map == null || map.isEmpty()) {
            requestBody = null;
        } else {
            FormBody.Builder builder2 = new FormBody.Builder();
            for (Map.Entry<String, String> entry : map.entrySet()) {
                if (entry != null) {
                    try {
                        builder2.addEncoded(entry.getKey(), encode(entry.getValue()));
                    } catch (Exception e) {
                    }
                }
            }
            requestBody = builder2.build();
        }
        if (builder == null || requestBody == null) {
            return;
        }
        builder.post(requestBody);
    }

    public static com.kwad.sdk.core.network.c doGet(String str, Map<String, String> map) {
        return a(str, map, true);
    }

    public static com.kwad.sdk.core.network.c doPost(String str, Map<String, String> map, AdHttpBodyBuilder adHttpBodyBuilder) {
        com.kwad.sdk.core.network.c cVar = new com.kwad.sdk.core.network.c();
        try {
            final MultipartBody.Builder type = new MultipartBody.Builder().setType(MultipartBody.FORM);
            if (adHttpBodyBuilder != null) {
                adHttpBodyBuilder.buildFormData(new AdHttpFormDataBuilder() { // from class: com.kwad.sdk.core.network.kwai.c.1
                    @Override // com.kwad.sdk.export.proxy.AdHttpFormDataBuilder
                    public final void addFormDataPart(String str2, String str3) {
                        type.addFormDataPart(str2, str3);
                    }

                    @Override // com.kwad.sdk.export.proxy.AdHttpFormDataBuilder
                    public final void addFormDataPart(String str2, String str3, String str4, byte[] bArr) {
                        type.addFormDataPart(str2, str3, RequestBody.create(MediaType.parse(str4), bArr));
                    }
                });
            }
            Request.Builder post = new Request.Builder().url(str).post(type.build());
            a(post, map);
            Response execute = wk().newCall(post.build()).execute();
            cVar.code = execute.code();
            cVar.agd = cVar.code;
            cVar.agf = a(execute);
            return cVar;
        } catch (Exception e) {
            a(cVar, e);
            return cVar;
        }
    }

    public static com.kwad.sdk.core.network.c doPost(String str, Map<String, String> map, Map<String, String> map2) {
        com.kwad.sdk.core.network.c cVar = new com.kwad.sdk.core.network.c();
        try {
            Request.Builder url = new Request.Builder().url(str);
            a(url);
            a(url, map);
            b(url, map2);
            Response execute = wk().newCall(url.build()).execute();
            cVar.code = execute.code();
            cVar.agd = cVar.code;
            cVar.agf = a(execute);
            return cVar;
        } catch (Exception e) {
            a(cVar, e);
            return cVar;
        }
    }

    public static com.kwad.sdk.core.network.c doPost(String str, Map<String, String> map, JSONObject jSONObject) {
        com.kwad.sdk.core.network.c cVar = new com.kwad.sdk.core.network.c();
        try {
            Request.Builder url = new Request.Builder().url(str);
            a(url);
            a(url, map);
            a(url, jSONObject);
            Response execute = wk().newCall(url.build()).execute();
            cVar.code = execute.code();
            cVar.agd = cVar.code;
            cVar.agf = a(execute);
            return cVar;
        } catch (Exception e) {
            a(cVar, e);
            return cVar;
        }
    }

    public static boolean downloadUrlToStream(String str, OutputStream outputStream, int i) {
        com.kwad.sdk.core.network.c cVar = new com.kwad.sdk.core.network.c();
        Request.Builder url = new Request.Builder().url(str);
        HashMap hashMap = new HashMap();
        hashMap.put(HttpHeaders.ACCEPT_LANGUAGE, ay.Code);
        hashMap.put("Connection", "keep-alive");
        hashMap.put("Charset", "UTF-8");
        a(url);
        a(url, hashMap);
        Response execute = wk().newCall(url.build()).execute();
        cVar.code = execute.code();
        cVar.agd = cVar.code;
        a(execute, outputStream, i);
        return true;
    }

    private static String encode(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            com.kwad.sdk.core.d.b.printStackTrace(e);
            return "";
        }
    }

    public static OkHttpClient wk() {
        if (com.kwad.b.kwai.a.bI.booleanValue()) {
            if (ahi == null) {
                ahi = ahj.newBuilder().build();
            }
            return ahi;
        }
        return ahj;
    }

    private static OkHttpClient wl() {
        if (ahj == null) {
            OkHttpClient.Builder connectionSpecs = new OkHttpClient.Builder().connectTimeout((long) m.ag, TimeUnit.MILLISECONDS).readTimeout(6000L, TimeUnit.MILLISECONDS).connectionSpecs(Arrays.asList(ConnectionSpec.MODERN_TLS, ConnectionSpec.COMPATIBLE_TLS, ConnectionSpec.CLEARTEXT));
            try {
                connectionSpecs.dns(new d());
            } catch (Throwable th) {
                com.kwad.sdk.core.d.b.printStackTrace(th);
            }
            ahj = connectionSpecs.build();
        }
        return ahj;
    }
}
