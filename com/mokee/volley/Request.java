package com.mokee.volley;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import com.mokee.volley.Cache;
import com.mokee.volley.Response;
import com.mokee.volley.VolleyLog;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;

/* loaded from: source-4181928-dex2jar.jar:com/mokee/volley/Request.class */
public abstract class Request<T> implements Comparable<Request<T>> {
    public static boolean e;
    private static final String[] p = null;
    private boolean a;
    private boolean b;
    private boolean c;
    private final int d;
    private Object f;
    private RequestQueue g;
    private final int h;
    private final String i;
    private long j;
    private RetryPolicy k;
    private final Response.ErrorListener l;
    private final VolleyLog.a m;
    private Cache.Entry n;
    private Integer o;

    /* loaded from: source-4181928-dex2jar.jar:com/mokee/volley/Request$Method.class */
    public interface Method {
        public static final int DELETE = 3;
        public static final int DEPRECATED_GET_OR_POST = -1;
        public static final int GET = 0;
        public static final int HEAD = 4;
        public static final int OPTIONS = 5;
        public static final int PATCH = 7;
        public static final int POST = 1;
        public static final int PUT = 2;
        public static final int TRACE = 6;
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: source-4181928-dex2jar.jar:com/mokee/volley/Request$Priority.class */
    public static final class Priority {
        public static final Priority HIGH = null;
        public static final Priority IMMEDIATE = null;
        public static final Priority LOW = null;
        public static final Priority NORMAL = null;
        private static final /* synthetic */ Priority[] a = null;
        private static final String[] b = null;

        static {
            String[] strArr = new String[4];
            throw new VerifyError("bad dex opcode");
        }

        private Priority(String str, int i) {
        }

        public static Priority valueOf(String str) {
            return (Priority) Enum.valueOf(Priority.class, str);
        }

        public static Priority[] values() {
            Priority[] priorityArr = a;
            int length = priorityArr.length;
            Priority[] priorityArr2 = new Priority[length];
            System.arraycopy(priorityArr, 0, priorityArr2, 0, length);
            return priorityArr2;
        }
    }

    /* loaded from: source-4181928-dex2jar.jar:com/mokee/volley/Request$a.class */
    class a implements Runnable {
        private final /* synthetic */ String val$tag;
        private final /* synthetic */ long val$threadId;

        a(String str, long j) {
            this.val$tag = str;
            this.val$threadId = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            Request.this.m.add(this.val$tag, this.val$threadId);
            Request.this.m.finish(toString());
        }
    }

    static {
        String[] strArr = new String[8];
        throw new VerifyError("bad dex opcode");
    }

    public Request(int i, String str, Response.ErrorListener errorListener) {
        VolleyLog.a aVar = null;
        boolean z = false;
        boolean z2 = e;
        try {
            this.m = VolleyLog.a.ENABLED ? new VolleyLog.a() : aVar;
            this.a = true;
            this.b = false;
            this.c = false;
            this.j = 0L;
            this.n = null;
            this.h = i;
            this.i = str;
            this.l = errorListener;
            setRetryPolicy(new DefaultRetryPolicy());
            this.d = a(str);
            if (z2) {
                VolleyError.b = VolleyError.b ? z : true;
            }
        } catch (IllegalStateException e2) {
            try {
                throw e2;
            } catch (IllegalStateException e3) {
                throw e3;
            }
        }
    }

    public Request(String str, Response.ErrorListener errorListener) {
        this(-1, str, errorListener);
    }

    private static int a(String str) {
        Uri parse;
        String host;
        if (TextUtils.isEmpty(str) || (parse = Uri.parse(str)) == null || (host = parse.getHost()) == null) {
            return 0;
        }
        try {
            return host.hashCode();
        } catch (IllegalStateException e2) {
            throw e2;
        }
    }

    private byte[] a(Map<String, String> map, String str) {
        boolean z = e;
        StringBuilder sb = new StringBuilder();
        try {
            Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
            if (z) {
                Map.Entry<String, String> next = it.next();
                sb.append(URLEncoder.encode(next.getKey(), str));
                sb.append('=');
                sb.append(URLEncoder.encode(next.getValue(), str));
                sb.append('&');
            }
            while (it.hasNext()) {
                Map.Entry<String, String> next2 = it.next();
                sb.append(URLEncoder.encode(next2.getKey(), str));
                sb.append('=');
                sb.append(URLEncoder.encode(next2.getValue(), str));
                sb.append('&');
            }
            return sb.toString().getBytes(str);
        } catch (UnsupportedEncodingException e2) {
            throw new RuntimeException(p[4] + str, e2);
        }
    }

    public void addMarker(String str) {
        try {
            try {
                try {
                    if (VolleyLog.a.ENABLED) {
                        this.m.add(str, Thread.currentThread().getId());
                        if (!e) {
                            return;
                        }
                    }
                    if (this.j == 0) {
                        this.j = SystemClock.elapsedRealtime();
                    }
                } catch (IllegalStateException e2) {
                    throw e2;
                }
            } catch (IllegalStateException e3) {
                throw e3;
            }
        } catch (IllegalStateException e4) {
            throw e4;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(String str) {
        try {
            if (this.g != null) {
                this.g.a(this);
            }
            if (VolleyLog.a.ENABLED) {
                long id = Thread.currentThread().getId();
                if (Looper.myLooper() != Looper.getMainLooper()) {
                    new Handler(Looper.getMainLooper()).post(new a(str, id));
                    return;
                }
                this.m.add(str, id);
                this.m.finish(toString());
                if (!e) {
                    return;
                }
            }
            long elapsedRealtime = SystemClock.elapsedRealtime() - this.j;
            if (elapsedRealtime >= 3000) {
                try {
                    VolleyLog.d(p[5], Long.valueOf(elapsedRealtime), toString());
                } catch (IllegalStateException e2) {
                    throw e2;
                }
            }
        } catch (IllegalStateException e3) {
            throw e3;
        }
    }

    public void cancel() {
        this.b = true;
    }

    public int compareTo(Request<T> request) {
        Priority priority = getPriority();
        Priority priority2 = request.getPriority();
        if (priority == priority2) {
            try {
                return this.o.intValue() - request.o.intValue();
            } catch (IllegalStateException e2) {
                throw e2;
            }
        }
        return priority2.ordinal() - priority.ordinal();
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(Object obj) {
        return compareTo((Request) ((Request) obj));
    }

    public void deliverError(VolleyError volleyError) {
        try {
            if (this.l != null) {
                this.l.onErrorResponse(volleyError);
            }
        } catch (IllegalStateException e2) {
            throw e2;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void deliverResponse(T t);

    public byte[] getBody() throws AuthFailureError {
        Map<String, String> params = getParams();
        try {
            if (params != null) {
                try {
                    if (params.size() > 0) {
                        return a(params, getParamsEncoding());
                    }
                    return null;
                } catch (AuthFailureError e2) {
                    throw e2;
                }
            }
            return null;
        } catch (AuthFailureError e3) {
            throw e3;
        }
    }

    public String getBodyContentType() {
        return p[3] + getParamsEncoding();
    }

    public Cache.Entry getCacheEntry() {
        return this.n;
    }

    public String getCacheKey() {
        return getUrl();
    }

    public Map<String, String> getHeaders() throws AuthFailureError {
        return Collections.emptyMap();
    }

    public int getMethod() {
        return this.h;
    }

    protected Map<String, String> getParams() throws AuthFailureError {
        return null;
    }

    protected String getParamsEncoding() {
        return p[7];
    }

    public byte[] getPostBody() throws AuthFailureError {
        Map<String, String> postParams = getPostParams();
        try {
            if (postParams != null) {
                try {
                    if (postParams.size() > 0) {
                        return a(postParams, getPostParamsEncoding());
                    }
                    return null;
                } catch (AuthFailureError e2) {
                    throw e2;
                }
            }
            return null;
        } catch (AuthFailureError e3) {
            throw e3;
        }
    }

    public String getPostBodyContentType() {
        return getBodyContentType();
    }

    protected Map<String, String> getPostParams() throws AuthFailureError {
        return getParams();
    }

    protected String getPostParamsEncoding() {
        return getParamsEncoding();
    }

    public Priority getPriority() {
        return Priority.NORMAL;
    }

    public RetryPolicy getRetryPolicy() {
        return this.k;
    }

    public final int getSequence() {
        try {
            if (this.o == null) {
                throw new IllegalStateException(p[6]);
            }
            return this.o.intValue();
        } catch (IllegalStateException e2) {
            throw e2;
        }
    }

    public Object getTag() {
        return this.f;
    }

    public final int getTimeoutMs() {
        return this.k.getCurrentTimeout();
    }

    public int getTrafficStatsTag() {
        return this.d;
    }

    public String getUrl() {
        return this.i;
    }

    public boolean hasHadResponseDelivered() {
        return this.c;
    }

    public boolean isCanceled() {
        return this.b;
    }

    public void markDelivered() {
        this.c = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public VolleyError parseNetworkError(VolleyError volleyError) {
        return volleyError;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract Response<T> parseNetworkResponse(NetworkResponse networkResponse);

    /* JADX WARN: Multi-variable type inference failed */
    public Request<?> setCacheEntry(Cache.Entry entry) {
        this.n = entry;
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Request<?> setRequestQueue(RequestQueue requestQueue) {
        this.g = requestQueue;
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Request<?> setRetryPolicy(RetryPolicy retryPolicy) {
        this.k = retryPolicy;
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Request<?> setSequence(int i) {
        this.o = Integer.valueOf(i);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Request<?> setShouldCache(boolean z) {
        this.a = z;
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Request<?> setTag(Object obj) {
        this.f = obj;
        return this;
    }

    public final boolean shouldCache() {
        return this.a;
    }

    public String toString() {
        try {
            return String.valueOf(this.b ? p[2] : p[0]) + getUrl() + " " + (p[1] + Integer.toHexString(getTrafficStatsTag())) + " " + getPriority() + " " + this.o;
        } catch (IllegalStateException e2) {
            throw e2;
        }
    }
}
