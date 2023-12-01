package com.mokee.volley.toolbox;

import com.mokee.volley.AuthFailureError;
import com.mokee.volley.Request;
import java.io.IOException;
import java.net.URI;
import java.util.Iterator;
import java.util.Map;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpHead;
import org.apache.http.client.methods.HttpOptions;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpTrace;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

/* loaded from: source-4181928-dex2jar.jar:com/mokee/volley/toolbox/HttpClientStack.class */
public class HttpClientStack implements HttpStack {
    private static final String[] a = null;
    protected final HttpClient mClient;

    /* loaded from: source-4181928-dex2jar.jar:com/mokee/volley/toolbox/HttpClientStack$HttpPatch.class */
    public static final class HttpPatch extends HttpEntityEnclosingRequestBase {
        public static final String METHOD_NAME;
        private static final String a;

        /* JADX WARN: Removed duplicated region for block: B:12:0x005c A[LOOP:1: B:7:0x001b->B:12:0x005c, LOOP_END] */
        /* JADX WARN: Removed duplicated region for block: B:16:0x007c  */
        /* JADX WARN: Removed duplicated region for block: B:21:0x00b0  */
        /* JADX WARN: Removed duplicated region for block: B:22:0x00b6  */
        /* JADX WARN: Removed duplicated region for block: B:23:0x00bc  */
        /* JADX WARN: Removed duplicated region for block: B:24:0x00c2  */
        /* JADX WARN: Removed duplicated region for block: B:27:0x0061 A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:9:0x0048  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x0079 -> B:6:0x0017). Please submit an issue!!! */
        static {
            /*
                Method dump skipped, instructions count: 214
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mokee.volley.toolbox.HttpClientStack.HttpPatch.m11292clinit():void");
        }

        public HttpPatch() {
        }

        public HttpPatch(String str) {
            setURI(URI.create(str));
        }

        public HttpPatch(URI uri) {
            setURI(uri);
        }

        public String getMethod() {
            return a;
        }
    }

    static {
        String[] strArr = new String[5];
        throw new VerifyError("bad dex opcode");
    }

    public HttpClientStack(HttpClient httpClient) {
        this.mClient = httpClient;
    }

    static HttpUriRequest a(Request<?> request, Map<String, String> map) throws AuthFailureError {
        switch (request.getMethod()) {
            case -1:
                byte[] postBody = request.getPostBody();
                if (postBody != null) {
                    HttpPost httpPost = new HttpPost(request.getUrl());
                    httpPost.addHeader(a[0], request.getPostBodyContentType());
                    httpPost.setEntity(new ByteArrayEntity(postBody));
                    return httpPost;
                }
                return new HttpGet(request.getUrl());
            case 0:
                return new HttpGet(request.getUrl());
            case 1:
                HttpPost httpPost2 = new HttpPost(request.getUrl());
                httpPost2.addHeader(a[2], request.getBodyContentType());
                a((HttpEntityEnclosingRequestBase) httpPost2, request);
                return httpPost2;
            case 2:
                HttpPut httpPut = new HttpPut(request.getUrl());
                httpPut.addHeader(a[3], request.getBodyContentType());
                a((HttpEntityEnclosingRequestBase) httpPut, request);
                return httpPut;
            case 3:
                return new HttpDelete(request.getUrl());
            case 4:
                return new HttpHead(request.getUrl());
            case 5:
                return new HttpOptions(request.getUrl());
            case 6:
                return new HttpTrace(request.getUrl());
            case 7:
                HttpPatch httpPatch = new HttpPatch(request.getUrl());
                httpPatch.addHeader(a[1], request.getBodyContentType());
                a(httpPatch, request);
                return httpPatch;
            default:
                throw new IllegalStateException(a[4]);
        }
    }

    private static void a(HttpEntityEnclosingRequestBase httpEntityEnclosingRequestBase, Request<?> request) throws AuthFailureError {
        byte[] body = request.getBody();
        if (body != null) {
            httpEntityEnclosingRequestBase.setEntity(new ByteArrayEntity(body));
        }
    }

    private static void a(HttpUriRequest httpUriRequest, Map<String, String> map) {
        boolean z = ImageLoader.h;
        Iterator<String> it = map.keySet().iterator();
        if (z) {
            String next = it.next();
            httpUriRequest.setHeader(next, map.get(next));
        }
        while (it.hasNext()) {
            String next2 = it.next();
            httpUriRequest.setHeader(next2, map.get(next2));
        }
    }

    protected void onPrepareRequest(HttpUriRequest httpUriRequest) throws IOException {
    }

    @Override // com.mokee.volley.toolbox.HttpStack
    public HttpResponse performRequest(Request<?> request, Map<String, String> map) throws IOException, AuthFailureError {
        HttpUriRequest a2 = a(request, map);
        a(a2, map);
        a(a2, request.getHeaders());
        onPrepareRequest(a2);
        HttpParams params = a2.getParams();
        int timeoutMs = request.getTimeoutMs();
        HttpConnectionParams.setConnectionTimeout(params, 5000);
        HttpConnectionParams.setSoTimeout(params, timeoutMs);
        return this.mClient.execute(a2);
    }
}
