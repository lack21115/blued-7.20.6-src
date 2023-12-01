package com.tencent.cloud.huiyansdkface.okhttp3;

import com.tencent.cloud.huiyansdkface.okhttp3.Headers;
import com.tencent.cloud.huiyansdkface.okhttp3.Request;
import com.tencent.cloud.huiyansdkface.okhttp3.Response;
import com.tencent.cloud.huiyansdkface.okhttp3.internal.Util;
import com.tencent.cloud.huiyansdkface.okhttp3.internal.cache.CacheRequest;
import com.tencent.cloud.huiyansdkface.okhttp3.internal.cache.CacheStrategy;
import com.tencent.cloud.huiyansdkface.okhttp3.internal.cache.DiskLruCache;
import com.tencent.cloud.huiyansdkface.okhttp3.internal.cache.InternalCache;
import com.tencent.cloud.huiyansdkface.okhttp3.internal.http.HttpHeaders;
import com.tencent.cloud.huiyansdkface.okhttp3.internal.http.HttpMethod;
import com.tencent.cloud.huiyansdkface.okhttp3.internal.http.StatusLine;
import com.tencent.cloud.huiyansdkface.okhttp3.internal.io.FileSystem;
import com.tencent.cloud.huiyansdkface.okhttp3.internal.platform.Platform;
import com.tencent.cloud.huiyansdkface.okio.Buffer;
import com.tencent.cloud.huiyansdkface.okio.BufferedSink;
import com.tencent.cloud.huiyansdkface.okio.BufferedSource;
import com.tencent.cloud.huiyansdkface.okio.ByteString;
import com.tencent.cloud.huiyansdkface.okio.ForwardingSink;
import com.tencent.cloud.huiyansdkface.okio.ForwardingSource;
import com.tencent.cloud.huiyansdkface.okio.Okio;
import com.tencent.cloud.huiyansdkface.okio.Sink;
import com.tencent.cloud.huiyansdkface.okio.Source;
import java.io.Closeable;
import java.io.File;
import java.io.Flushable;
import java.io.IOException;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/okhttp3/Cache.class */
public final class Cache implements Closeable, Flushable {

    /* renamed from: a  reason: collision with root package name */
    final InternalCache f35807a;
    final DiskLruCache b;

    /* renamed from: c  reason: collision with root package name */
    int f35808c;
    int d;
    private int e;
    private int f;
    private int g;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/okhttp3/Cache$CacheRequestImpl.class */
    public final class CacheRequestImpl implements CacheRequest {

        /* renamed from: a  reason: collision with root package name */
        boolean f35812a;

        /* renamed from: c  reason: collision with root package name */
        private final DiskLruCache.Editor f35813c;
        private Sink d;
        private Sink e;

        CacheRequestImpl(final DiskLruCache.Editor editor) {
            this.f35813c = editor;
            Sink newSink = editor.newSink(1);
            this.d = newSink;
            this.e = new ForwardingSink(newSink) { // from class: com.tencent.cloud.huiyansdkface.okhttp3.Cache.CacheRequestImpl.1
                @Override // com.tencent.cloud.huiyansdkface.okio.ForwardingSink, com.tencent.cloud.huiyansdkface.okio.Sink, java.io.Closeable, java.lang.AutoCloseable
                public void close() throws IOException {
                    synchronized (Cache.this) {
                        if (CacheRequestImpl.this.f35812a) {
                            return;
                        }
                        CacheRequestImpl.this.f35812a = true;
                        Cache.this.f35808c++;
                        super.close();
                        editor.commit();
                    }
                }
            };
        }

        @Override // com.tencent.cloud.huiyansdkface.okhttp3.internal.cache.CacheRequest
        public void abort() {
            synchronized (Cache.this) {
                if (this.f35812a) {
                    return;
                }
                this.f35812a = true;
                Cache.this.d++;
                Util.closeQuietly(this.d);
                try {
                    this.f35813c.abort();
                } catch (IOException e) {
                }
            }
        }

        @Override // com.tencent.cloud.huiyansdkface.okhttp3.internal.cache.CacheRequest
        public Sink body() {
            return this.e;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/okhttp3/Cache$CacheResponseBody.class */
    public static class CacheResponseBody extends ResponseBody {

        /* renamed from: a  reason: collision with root package name */
        final DiskLruCache.Snapshot f35816a;
        private final BufferedSource b;

        /* renamed from: c  reason: collision with root package name */
        private final String f35817c;
        private final String d;

        CacheResponseBody(final DiskLruCache.Snapshot snapshot, String str, String str2) {
            this.f35816a = snapshot;
            this.f35817c = str;
            this.d = str2;
            this.b = Okio.buffer(new ForwardingSource(snapshot.getSource(1)) { // from class: com.tencent.cloud.huiyansdkface.okhttp3.Cache.CacheResponseBody.1
                @Override // com.tencent.cloud.huiyansdkface.okio.ForwardingSource, com.tencent.cloud.huiyansdkface.okio.Source, java.io.Closeable, java.lang.AutoCloseable
                public void close() throws IOException {
                    snapshot.close();
                    super.close();
                }
            });
        }

        @Override // com.tencent.cloud.huiyansdkface.okhttp3.ResponseBody
        public long contentLength() {
            long j = -1;
            try {
                if (this.d != null) {
                    j = Long.parseLong(this.d);
                }
                return j;
            } catch (NumberFormatException e) {
                return -1L;
            }
        }

        @Override // com.tencent.cloud.huiyansdkface.okhttp3.ResponseBody
        public MediaType contentType() {
            String str = this.f35817c;
            if (str != null) {
                return MediaType.parse(str);
            }
            return null;
        }

        @Override // com.tencent.cloud.huiyansdkface.okhttp3.ResponseBody
        public BufferedSource source() {
            return this.b;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/okhttp3/Cache$Entry.class */
    public static final class Entry {

        /* renamed from: a  reason: collision with root package name */
        private static final String f35819a = Platform.get().getPrefix() + "-Sent-Millis";
        private static final String b = Platform.get().getPrefix() + "-Received-Millis";

        /* renamed from: c  reason: collision with root package name */
        private final String f35820c;
        private final Headers d;
        private final String e;
        private final Protocol f;
        private final int g;
        private final String h;
        private final Headers i;
        private final Handshake j;
        private final long k;
        private final long l;

        Entry(Response response) {
            this.f35820c = response.request().url().toString();
            this.d = HttpHeaders.varyHeaders(response);
            this.e = response.request().method();
            this.f = response.protocol();
            this.g = response.code();
            this.h = response.message();
            this.i = response.headers();
            this.j = response.handshake();
            this.k = response.sentRequestAtMillis();
            this.l = response.receivedResponseAtMillis();
        }

        Entry(Source source) throws IOException {
            try {
                BufferedSource buffer = Okio.buffer(source);
                this.f35820c = buffer.readUtf8LineStrict();
                this.e = buffer.readUtf8LineStrict();
                Headers.Builder builder = new Headers.Builder();
                int a2 = Cache.a(buffer);
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= a2) {
                        break;
                    }
                    builder.a(buffer.readUtf8LineStrict());
                    i = i2 + 1;
                }
                this.d = builder.build();
                StatusLine parse = StatusLine.parse(buffer.readUtf8LineStrict());
                this.f = parse.f35958a;
                this.g = parse.b;
                this.h = parse.f35959c;
                Headers.Builder builder2 = new Headers.Builder();
                int a3 = Cache.a(buffer);
                int i3 = 0;
                while (true) {
                    int i4 = i3;
                    if (i4 >= a3) {
                        break;
                    }
                    builder2.a(buffer.readUtf8LineStrict());
                    i3 = i4 + 1;
                }
                String str = builder2.get(f35819a);
                String str2 = builder2.get(b);
                builder2.removeAll(f35819a);
                builder2.removeAll(b);
                this.k = str != null ? Long.parseLong(str) : 0L;
                this.l = str2 != null ? Long.parseLong(str2) : 0L;
                this.i = builder2.build();
                if (a()) {
                    String readUtf8LineStrict = buffer.readUtf8LineStrict();
                    if (readUtf8LineStrict.length() > 0) {
                        throw new IOException("expected \"\" but was \"" + readUtf8LineStrict + "\"");
                    }
                    this.j = Handshake.get(!buffer.exhausted() ? TlsVersion.forJavaName(buffer.readUtf8LineStrict()) : TlsVersion.SSL_3_0, CipherSuite.forJavaName(buffer.readUtf8LineStrict()), a(buffer), a(buffer));
                } else {
                    this.j = null;
                }
            } finally {
                source.close();
            }
        }

        private List<Certificate> a(BufferedSource bufferedSource) throws IOException {
            int a2 = Cache.a(bufferedSource);
            if (a2 == -1) {
                return Collections.emptyList();
            }
            try {
                CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
                ArrayList arrayList = new ArrayList(a2);
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= a2) {
                        return arrayList;
                    }
                    String readUtf8LineStrict = bufferedSource.readUtf8LineStrict();
                    Buffer buffer = new Buffer();
                    buffer.write(ByteString.decodeBase64(readUtf8LineStrict));
                    arrayList.add(certificateFactory.generateCertificate(buffer.inputStream()));
                    i = i2 + 1;
                }
            } catch (CertificateException e) {
                throw new IOException(e.getMessage());
            }
        }

        private void a(BufferedSink bufferedSink, List<Certificate> list) throws IOException {
            try {
                bufferedSink.writeDecimalLong(list.size()).writeByte(10);
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    bufferedSink.writeUtf8(ByteString.of(list.get(i).getEncoded()).base64()).writeByte(10);
                }
            } catch (CertificateEncodingException e) {
                throw new IOException(e.getMessage());
            }
        }

        private boolean a() {
            return this.f35820c.startsWith("https://");
        }

        public boolean matches(Request request, Response response) {
            return this.f35820c.equals(request.url().toString()) && this.e.equals(request.method()) && HttpHeaders.varyMatches(response, this.d, request);
        }

        public Response response(DiskLruCache.Snapshot snapshot) {
            String str = this.i.get("Content-Type");
            String str2 = this.i.get("Content-Length");
            return new Response.Builder().request(new Request.Builder().url(this.f35820c).method(this.e, null).headers(this.d).build()).protocol(this.f).code(this.g).message(this.h).headers(this.i).body(new CacheResponseBody(snapshot, str, str2)).handshake(this.j).sentRequestAtMillis(this.k).receivedResponseAtMillis(this.l).build();
        }

        public void writeTo(DiskLruCache.Editor editor) throws IOException {
            BufferedSink buffer = Okio.buffer(editor.newSink(0));
            buffer.writeUtf8(this.f35820c).writeByte(10);
            buffer.writeUtf8(this.e).writeByte(10);
            buffer.writeDecimalLong(this.d.size()).writeByte(10);
            int size = this.d.size();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= size) {
                    break;
                }
                buffer.writeUtf8(this.d.name(i2)).writeUtf8(": ").writeUtf8(this.d.value(i2)).writeByte(10);
                i = i2 + 1;
            }
            buffer.writeUtf8(new StatusLine(this.f, this.g, this.h).toString()).writeByte(10);
            buffer.writeDecimalLong(this.i.size() + 2).writeByte(10);
            int size2 = this.i.size();
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 >= size2) {
                    break;
                }
                buffer.writeUtf8(this.i.name(i4)).writeUtf8(": ").writeUtf8(this.i.value(i4)).writeByte(10);
                i3 = i4 + 1;
            }
            buffer.writeUtf8(f35819a).writeUtf8(": ").writeDecimalLong(this.k).writeByte(10);
            buffer.writeUtf8(b).writeUtf8(": ").writeDecimalLong(this.l).writeByte(10);
            if (a()) {
                buffer.writeByte(10);
                buffer.writeUtf8(this.j.cipherSuite().javaName()).writeByte(10);
                a(buffer, this.j.peerCertificates());
                a(buffer, this.j.localCertificates());
                buffer.writeUtf8(this.j.tlsVersion().javaName()).writeByte(10);
            }
            buffer.close();
        }
    }

    public Cache(File file, long j) {
        this(file, j, FileSystem.f36018a);
    }

    Cache(File file, long j, FileSystem fileSystem) {
        this.f35807a = new InternalCache() { // from class: com.tencent.cloud.huiyansdkface.okhttp3.Cache.1
            @Override // com.tencent.cloud.huiyansdkface.okhttp3.internal.cache.InternalCache
            public Response get(Request request) throws IOException {
                return Cache.this.a(request);
            }

            @Override // com.tencent.cloud.huiyansdkface.okhttp3.internal.cache.InternalCache
            public CacheRequest put(Response response) throws IOException {
                return Cache.this.a(response);
            }

            @Override // com.tencent.cloud.huiyansdkface.okhttp3.internal.cache.InternalCache
            public void remove(Request request) throws IOException {
                Cache.this.b(request);
            }

            @Override // com.tencent.cloud.huiyansdkface.okhttp3.internal.cache.InternalCache
            public void trackConditionalCacheHit() {
                Cache.this.a();
            }

            @Override // com.tencent.cloud.huiyansdkface.okhttp3.internal.cache.InternalCache
            public void trackResponse(CacheStrategy cacheStrategy) {
                Cache.this.a(cacheStrategy);
            }

            @Override // com.tencent.cloud.huiyansdkface.okhttp3.internal.cache.InternalCache
            public void update(Response response, Response response2) {
                Cache.this.a(response, response2);
            }
        };
        this.b = DiskLruCache.create(fileSystem, file, 201105, 2, j);
    }

    static int a(BufferedSource bufferedSource) throws IOException {
        try {
            long readDecimalLong = bufferedSource.readDecimalLong();
            String readUtf8LineStrict = bufferedSource.readUtf8LineStrict();
            if (readDecimalLong < 0 || readDecimalLong > 2147483647L || !readUtf8LineStrict.isEmpty()) {
                throw new IOException("expected an int but was \"" + readDecimalLong + readUtf8LineStrict + "\"");
            }
            return (int) readDecimalLong;
        } catch (NumberFormatException e) {
            throw new IOException(e.getMessage());
        }
    }

    private void a(DiskLruCache.Editor editor) {
        if (editor != null) {
            try {
                editor.abort();
            } catch (IOException e) {
            }
        }
    }

    public static String key(HttpUrl httpUrl) {
        return ByteString.encodeUtf8(httpUrl.toString()).md5().hex();
    }

    Response a(Request request) {
        try {
            DiskLruCache.Snapshot snapshot = this.b.get(key(request.url()));
            if (snapshot == null) {
                return null;
            }
            try {
                Entry entry = new Entry(snapshot.getSource(0));
                Response response = entry.response(snapshot);
                if (entry.matches(request, response)) {
                    return response;
                }
                Util.closeQuietly(response.body());
                return null;
            } catch (IOException e) {
                Util.closeQuietly(snapshot);
                return null;
            }
        } catch (IOException e2) {
            return null;
        }
    }

    CacheRequest a(Response response) {
        DiskLruCache.Editor editor;
        String method = response.request().method();
        if (HttpMethod.invalidatesCache(response.request().method())) {
            try {
                b(response.request());
                return null;
            } catch (IOException e) {
                return null;
            }
        } else if (!method.equals("GET") || HttpHeaders.hasVaryAll(response)) {
            return null;
        } else {
            Entry entry = new Entry(response);
            try {
                editor = this.b.edit(key(response.request().url()));
                if (editor == null) {
                    return null;
                }
                try {
                    entry.writeTo(editor);
                    return new CacheRequestImpl(editor);
                } catch (IOException e2) {
                    a(editor);
                    return null;
                }
            } catch (IOException e3) {
                editor = null;
            }
        }
    }

    void a() {
        synchronized (this) {
            this.f++;
        }
    }

    void a(Response response, Response response2) {
        DiskLruCache.Editor editor;
        Entry entry = new Entry(response2);
        try {
            editor = ((CacheResponseBody) response.body()).f35816a.edit();
            if (editor != null) {
                try {
                    entry.writeTo(editor);
                    editor.commit();
                } catch (IOException e) {
                    a(editor);
                }
            }
        } catch (IOException e2) {
            editor = null;
        }
    }

    void a(CacheStrategy cacheStrategy) {
        synchronized (this) {
            this.g++;
            if (cacheStrategy.f35910a != null) {
                this.e++;
            } else if (cacheStrategy.b != null) {
                this.f++;
            }
        }
    }

    void b(Request request) throws IOException {
        this.b.remove(key(request.url()));
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.b.close();
    }

    public void delete() throws IOException {
        this.b.delete();
    }

    public File directory() {
        return this.b.getDirectory();
    }

    public void evictAll() throws IOException {
        this.b.evictAll();
    }

    @Override // java.io.Flushable
    public void flush() throws IOException {
        this.b.flush();
    }

    public int hitCount() {
        int i;
        synchronized (this) {
            i = this.f;
        }
        return i;
    }

    public void initialize() throws IOException {
        this.b.initialize();
    }

    public boolean isClosed() {
        return this.b.isClosed();
    }

    public long maxSize() {
        return this.b.getMaxSize();
    }

    public int networkCount() {
        int i;
        synchronized (this) {
            i = this.e;
        }
        return i;
    }

    public int requestCount() {
        int i;
        synchronized (this) {
            i = this.g;
        }
        return i;
    }

    public long size() throws IOException {
        return this.b.size();
    }

    public Iterator<String> urls() throws IOException {
        return new Iterator<String>() { // from class: com.tencent.cloud.huiyansdkface.okhttp3.Cache.2

            /* renamed from: a  reason: collision with root package name */
            final Iterator<DiskLruCache.Snapshot> f35810a;
            String b;

            /* renamed from: c  reason: collision with root package name */
            boolean f35811c;

            {
                this.f35810a = Cache.this.b.snapshots();
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                if (this.b != null) {
                    return true;
                }
                this.f35811c = false;
                while (this.f35810a.hasNext()) {
                    DiskLruCache.Snapshot next = this.f35810a.next();
                    try {
                        this.b = Okio.buffer(next.getSource(0)).readUtf8LineStrict();
                        next.close();
                        return true;
                    } catch (IOException e) {
                        next.close();
                    } catch (Throwable th) {
                        next.close();
                        throw th;
                    }
                }
                return false;
            }

            @Override // java.util.Iterator
            public String next() {
                if (hasNext()) {
                    String str = this.b;
                    this.b = null;
                    this.f35811c = true;
                    return str;
                }
                throw new NoSuchElementException();
            }

            @Override // java.util.Iterator
            public void remove() {
                if (!this.f35811c) {
                    throw new IllegalStateException("remove() before next()");
                }
                this.f35810a.remove();
            }
        };
    }

    public int writeAbortCount() {
        int i;
        synchronized (this) {
            i = this.d;
        }
        return i;
    }

    public int writeSuccessCount() {
        int i;
        synchronized (this) {
            i = this.f35808c;
        }
        return i;
    }
}
