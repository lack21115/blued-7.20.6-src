package com.mokee.volley.toolbox;

import android.os.SystemClock;
import com.mokee.volley.AuthFailureError;
import com.mokee.volley.Cache;
import com.mokee.volley.Network;
import com.mokee.volley.NetworkError;
import com.mokee.volley.NetworkResponse;
import com.mokee.volley.NoConnectionError;
import com.mokee.volley.Request;
import com.mokee.volley.RetryPolicy;
import com.mokee.volley.ServerError;
import com.mokee.volley.TimeoutError;
import com.mokee.volley.VolleyError;
import com.mokee.volley.VolleyLog;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.impl.cookie.DateUtils;

/* loaded from: source-4181928-dex2jar.jar:com/mokee/volley/toolbox/BasicNetwork.class */
public class BasicNetwork implements Network {
    protected static final boolean DEBUG = false;

    /* renamed from: a  reason: collision with root package name */
    private static int f24248a;
    private static int b;

    /* renamed from: c  reason: collision with root package name */
    private static final String[] f24249c = null;
    protected final HttpStack mHttpStack;
    protected final ByteArrayPool mPool;

    static {
        String[] strArr = new String[14];
        throw new VerifyError("bad dex opcode");
    }

    public BasicNetwork(HttpStack httpStack) {
        this(httpStack, new ByteArrayPool(b));
    }

    public BasicNetwork(HttpStack httpStack, ByteArrayPool byteArrayPool) {
        this.mHttpStack = httpStack;
        this.mPool = byteArrayPool;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x003c, code lost:
        r5 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x003e, code lost:
        throw r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:3:0x0012, code lost:
        if (r0 != false) goto L8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:4:0x0015, code lost:
        r0.put(r5[r7].getName(), r5[r7].getValue());
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x002e, code lost:
        r6 = r7 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0031, code lost:
        r7 = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x0036, code lost:
        if (r6 < r5.length) goto L8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x003b, code lost:
        return r0;
     */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:5:0x002e -> B:6:0x0031). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.util.Map<java.lang.String, java.lang.String> a(org.apache.http.Header[] r5) {
        /*
            boolean r0 = com.mokee.volley.toolbox.ImageLoader.h
            r8 = r0
            java.util.HashMap r0 = new java.util.HashMap
            r1 = r0
            r1.<init>()
            r9 = r0
            r0 = 0
            r6 = r0
            r0 = 0
            r7 = r0
            r0 = r8
            if (r0 == 0) goto L31
        L15:
            r0 = r9
            r1 = r5
            r2 = r7
            r1 = r1[r2]     // Catch: java.lang.RuntimeException -> L3c
            java.lang.String r1 = r1.getName()     // Catch: java.lang.RuntimeException -> L3c
            r2 = r5
            r3 = r7
            r2 = r2[r3]     // Catch: java.lang.RuntimeException -> L3c
            java.lang.String r2 = r2.getValue()     // Catch: java.lang.RuntimeException -> L3c
            java.lang.Object r0 = r0.put(r1, r2)     // Catch: java.lang.RuntimeException -> L3c
            r0 = r7
            r1 = 1
            int r0 = r0 + r1
            r6 = r0
        L31:
            r0 = r6
            r7 = r0
            r0 = r6
            r1 = r5
            int r1 = r1.length
            if (r0 < r1) goto L15
            r0 = r9
            return r0
        L3c:
            r5 = move-exception
            r0 = r5
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mokee.volley.toolbox.BasicNetwork.a(org.apache.http.Header[]):java.util.Map");
    }

    private void a(long j, Request<?> request, byte[] bArr, StatusLine statusLine) {
        try {
            try {
                try {
                    if (!DEBUG) {
                        if (j <= f24248a) {
                            return;
                        }
                    }
                    VolleyLog.d(f24249c[11], request, Long.valueOf(j), bArr != null ? Integer.valueOf(bArr.length) : f24249c[12], Integer.valueOf(statusLine.getStatusCode()), Integer.valueOf(request.getRetryPolicy().getCurrentRetryCount()));
                } catch (RuntimeException e) {
                    throw e;
                }
            } catch (RuntimeException e2) {
                throw e2;
            }
        } catch (RuntimeException e3) {
            throw e3;
        }
    }

    private static void a(String str, Request<?> request, VolleyError volleyError) throws VolleyError {
        RetryPolicy retryPolicy = request.getRetryPolicy();
        int timeoutMs = request.getTimeoutMs();
        try {
            retryPolicy.retry(volleyError);
            request.addMarker(String.format(f24249c[5], str, Integer.valueOf(timeoutMs)));
        } catch (VolleyError e) {
            request.addMarker(String.format(f24249c[4], str, Integer.valueOf(timeoutMs)));
            throw e;
        }
    }

    private void a(Map<String, String> map, Cache.Entry entry) {
        if (entry == null) {
            return;
        }
        try {
            if (entry.etag != null) {
                map.put(f24249c[0], entry.etag);
            }
            if (entry.serverDate > 0) {
                map.put(f24249c[1], DateUtils.formatDate(new Date(entry.serverDate)));
            }
        } catch (RuntimeException e) {
            throw e;
        }
    }

    private byte[] a(HttpEntity httpEntity) throws IOException, ServerError {
        PoolingByteArrayOutputStream poolingByteArrayOutputStream = new PoolingByteArrayOutputStream(this.mPool, (int) httpEntity.getContentLength());
        byte[] bArr = null;
        try {
            InputStream content = httpEntity.getContent();
            if (content == null) {
                bArr = null;
                try {
                    throw new ServerError();
                } catch (IOException e) {
                    throw e;
                }
            }
            byte[] buf = this.mPool.getBuf(1024);
            while (true) {
                int read = content.read(buf);
                if (read == -1) {
                    break;
                }
                poolingByteArrayOutputStream.write(buf, 0, read);
            }
            byte[] byteArray = poolingByteArrayOutputStream.toByteArray();
            try {
                httpEntity.consumeContent();
            } catch (IOException e2) {
                VolleyLog.v(f24249c[3], new Object[0]);
            }
            this.mPool.returnBuf(buf);
            poolingByteArrayOutputStream.close();
            return byteArray;
        } catch (Throwable th) {
            try {
                httpEntity.consumeContent();
            } catch (IOException e3) {
                VolleyLog.v(f24249c[2], new Object[0]);
            }
            this.mPool.returnBuf(bArr);
            poolingByteArrayOutputStream.close();
            throw th;
        }
    }

    protected void logError(String str, String str2, long j) {
        VolleyLog.v(f24249c[13], str, Long.valueOf(SystemClock.elapsedRealtime() - j), str2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v8, types: [byte[]] */
    @Override // com.mokee.volley.Network
    public NetworkResponse performRequest(Request<?> request) throws VolleyError {
        Map map;
        HashMap hashMap;
        HashMap hashMap2;
        HttpResponse performRequest;
        StatusLine statusLine;
        int statusCode;
        Map a2;
        boolean z = ImageLoader.h;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        while (true) {
            HttpResponse httpResponse = null;
            Map hashMap3 = new HashMap();
            try {
                try {
                    try {
                        hashMap2 = new HashMap();
                        a(hashMap2, request.getCacheEntry());
                        performRequest = this.mHttpStack.performRequest(request, hashMap2);
                        try {
                            statusLine = performRequest.getStatusLine();
                            statusCode = statusLine.getStatusCode();
                            a2 = a(performRequest.getAllHeaders());
                        } catch (IOException e) {
                            e = e;
                            httpResponse = performRequest;
                            map = hashMap3;
                            hashMap = null;
                        }
                    } catch (MalformedURLException e2) {
                        throw new RuntimeException(f24249c[9] + request.getUrl(), e2);
                    } catch (ConnectTimeoutException e3) {
                        a(f24249c[10], request, new TimeoutError());
                    }
                    try {
                        if (statusCode == 304) {
                            try {
                                return new NetworkResponse(304, request.getCacheEntry() == null ? null : request.getCacheEntry().data, a2, true);
                            } catch (SocketTimeoutException e4) {
                                throw e4;
                            }
                        }
                        byte[] a3 = performRequest.getEntity() != null ? a(performRequest.getEntity()) : new byte[0];
                        byte[] bArr = a3;
                        byte[] bArr2 = a3;
                        try {
                            try {
                                a(SystemClock.elapsedRealtime() - elapsedRealtime, request, a3, statusLine);
                                if (statusCode < 200 || statusCode > 299) {
                                    throw new IOException();
                                }
                                return new NetworkResponse(statusCode, a3, a2, false);
                            } catch (SocketTimeoutException e5) {
                                throw e5;
                            }
                        } catch (SocketTimeoutException e6) {
                            throw e6;
                        }
                    } catch (IOException e7) {
                        httpResponse = performRequest;
                        hashMap = hashMap2;
                        map = a2;
                        e = e7;
                        if (httpResponse != null) {
                            int statusCode2 = httpResponse.getStatusLine().getStatusCode();
                            if (!z) {
                                VolleyLog.e(f24249c[6], Integer.valueOf(statusCode2), request.getUrl());
                                if (hashMap != null) {
                                    NetworkResponse networkResponse = new NetworkResponse(statusCode2, hashMap, map, false);
                                    if (statusCode2 != 401 && statusCode2 != 403) {
                                        break;
                                    }
                                    try {
                                        a(f24249c[8], request, new AuthFailureError(networkResponse));
                                        if (z) {
                                            break;
                                        }
                                    } catch (SocketTimeoutException e8) {
                                        throw e8;
                                    }
                                    throw new ServerError(networkResponse);
                                }
                                throw new NetworkError((NetworkResponse) null);
                            }
                        }
                        try {
                            throw new NoConnectionError(e);
                        } catch (SocketTimeoutException e9) {
                            throw e9;
                        }
                    }
                } catch (IOException e10) {
                    e = e10;
                    map = hashMap3;
                    hashMap = null;
                }
            } catch (SocketTimeoutException e11) {
                a(f24249c[7], request, new TimeoutError());
            }
        }
        throw new ServerError(networkResponse);
    }
}
