package com.tencent.cloud.huiyansdkface.okhttp3.internal.http2;

import com.tencent.cloud.huiyansdkface.okhttp3.Protocol;
import com.tencent.cloud.huiyansdkface.okhttp3.internal.NamedRunnable;
import com.tencent.cloud.huiyansdkface.okhttp3.internal.Util;
import com.tencent.cloud.huiyansdkface.okhttp3.internal.http2.Http2Reader;
import com.tencent.cloud.huiyansdkface.okhttp3.internal.platform.Platform;
import com.tencent.cloud.huiyansdkface.okio.Buffer;
import com.tencent.cloud.huiyansdkface.okio.BufferedSink;
import com.tencent.cloud.huiyansdkface.okio.BufferedSource;
import com.tencent.cloud.huiyansdkface.okio.ByteString;
import com.tencent.cloud.huiyansdkface.okio.Okio;
import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/okhttp3/internal/http2/Http2Connection.class */
public final class Http2Connection implements Closeable {
    static final /* synthetic */ boolean r = !Http2Connection.class.desiredAssertionStatus();
    private static final ExecutorService s = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), Util.threadFactory("OkHttp Http2Connection", true));

    /* renamed from: a  reason: collision with root package name */
    final boolean f35983a;
    final Listener b;
    final String d;
    int e;
    int f;
    boolean g;
    final PushObserver h;
    long j;
    final Socket n;
    final Http2Writer o;
    final ReaderRunnable p;
    private final ScheduledExecutorService t;
    private final ExecutorService u;
    private boolean v;

    /* renamed from: c  reason: collision with root package name */
    final Map<Integer, Http2Stream> f35984c = new LinkedHashMap();
    long i = 0;
    Settings k = new Settings();
    final Settings l = new Settings();
    boolean m = false;
    final Set<Integer> q = new LinkedHashSet();

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/okhttp3/internal/http2/Http2Connection$Builder.class */
    public static class Builder {

        /* renamed from: a  reason: collision with root package name */
        Socket f35991a;
        String b;

        /* renamed from: c  reason: collision with root package name */
        BufferedSource f35992c;
        BufferedSink d;
        Listener e = Listener.f;
        PushObserver f = PushObserver.f36015a;
        boolean g;
        int h;

        public Builder(boolean z) {
            this.g = z;
        }

        public Http2Connection build() {
            return new Http2Connection(this);
        }

        public Builder listener(Listener listener) {
            this.e = listener;
            return this;
        }

        public Builder pingIntervalMillis(int i) {
            this.h = i;
            return this;
        }

        public Builder pushObserver(PushObserver pushObserver) {
            this.f = pushObserver;
            return this;
        }

        public Builder socket(Socket socket) throws IOException {
            return socket(socket, ((InetSocketAddress) socket.getRemoteSocketAddress()).getHostName(), Okio.buffer(Okio.source(socket)), Okio.buffer(Okio.sink(socket)));
        }

        public Builder socket(Socket socket, String str, BufferedSource bufferedSource, BufferedSink bufferedSink) {
            this.f35991a = socket;
            this.b = str;
            this.f35992c = bufferedSource;
            this.d = bufferedSink;
            return this;
        }
    }

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/okhttp3/internal/http2/Http2Connection$Listener.class */
    public static abstract class Listener {
        public static final Listener f = new Listener() { // from class: com.tencent.cloud.huiyansdkface.okhttp3.internal.http2.Http2Connection.Listener.1
            @Override // com.tencent.cloud.huiyansdkface.okhttp3.internal.http2.Http2Connection.Listener
            public void onStream(Http2Stream http2Stream) throws IOException {
                http2Stream.close(ErrorCode.REFUSED_STREAM);
            }
        };

        public void onSettings(Http2Connection http2Connection) {
        }

        public abstract void onStream(Http2Stream http2Stream) throws IOException;
    }

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/okhttp3/internal/http2/Http2Connection$PingRunnable.class */
    final class PingRunnable extends NamedRunnable {

        /* renamed from: a  reason: collision with root package name */
        final boolean f35993a;
        final int b;
        final int d;

        PingRunnable(boolean z, int i, int i2) {
            super("OkHttp %s ping %08x%08x", Http2Connection.this.d, Integer.valueOf(i), Integer.valueOf(i2));
            this.f35993a = z;
            this.b = i;
            this.d = i2;
        }

        @Override // com.tencent.cloud.huiyansdkface.okhttp3.internal.NamedRunnable
        public void execute() {
            Http2Connection.this.a(this.f35993a, this.b, this.d);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/okhttp3/internal/http2/Http2Connection$ReaderRunnable.class */
    public class ReaderRunnable extends NamedRunnable implements Http2Reader.Handler {

        /* renamed from: a  reason: collision with root package name */
        final Http2Reader f35994a;

        ReaderRunnable(Http2Reader http2Reader) {
            super("OkHttp %s", Http2Connection.this.d);
            this.f35994a = http2Reader;
        }

        private void a(final Settings settings) {
            try {
                Http2Connection.this.t.execute(new NamedRunnable("OkHttp %s ACK Settings", new Object[]{Http2Connection.this.d}) { // from class: com.tencent.cloud.huiyansdkface.okhttp3.internal.http2.Http2Connection.ReaderRunnable.3
                    @Override // com.tencent.cloud.huiyansdkface.okhttp3.internal.NamedRunnable
                    public void execute() {
                        try {
                            Http2Connection.this.o.applyAndAckSettings(settings);
                        } catch (IOException e) {
                            Http2Connection.this.b();
                        }
                    }
                });
            } catch (RejectedExecutionException e) {
            }
        }

        @Override // com.tencent.cloud.huiyansdkface.okhttp3.internal.http2.Http2Reader.Handler
        public void ackSettings() {
        }

        @Override // com.tencent.cloud.huiyansdkface.okhttp3.internal.http2.Http2Reader.Handler
        public void alternateService(int i, String str, ByteString byteString, String str2, int i2, long j) {
        }

        @Override // com.tencent.cloud.huiyansdkface.okhttp3.internal.http2.Http2Reader.Handler
        public void data(boolean z, int i, BufferedSource bufferedSource, int i2) throws IOException {
            if (Http2Connection.this.c(i)) {
                Http2Connection.this.a(i, bufferedSource, i2, z);
                return;
            }
            Http2Stream a2 = Http2Connection.this.a(i);
            if (a2 == null) {
                Http2Connection.this.a(i, ErrorCode.PROTOCOL_ERROR);
                long j = i2;
                Http2Connection.this.a(j);
                bufferedSource.skip(j);
                return;
            }
            a2.a(bufferedSource, i2);
            if (z) {
                a2.a();
            }
        }

        @Override // com.tencent.cloud.huiyansdkface.okhttp3.internal.NamedRunnable
        public void execute() {
            ErrorCode errorCode;
            Http2Connection http2Connection;
            ErrorCode errorCode2;
            ErrorCode errorCode3 = ErrorCode.INTERNAL_ERROR;
            ErrorCode errorCode4 = ErrorCode.INTERNAL_ERROR;
            ErrorCode errorCode5 = errorCode3;
            ErrorCode errorCode6 = errorCode3;
            try {
                try {
                    try {
                        this.f35994a.readConnectionPreface(this);
                        while (this.f35994a.nextFrame(false, this)) {
                        }
                        ErrorCode errorCode7 = ErrorCode.NO_ERROR;
                        errorCode6 = errorCode7;
                        errorCode = errorCode7;
                        errorCode2 = ErrorCode.CANCEL;
                        http2Connection = Http2Connection.this;
                    } catch (Throwable th) {
                        try {
                            Http2Connection.this.a(errorCode5, errorCode4);
                        } catch (IOException e) {
                        }
                        Util.closeQuietly(this.f35994a);
                        throw th;
                    }
                } catch (IOException e2) {
                    errorCode = ErrorCode.PROTOCOL_ERROR;
                    errorCode5 = errorCode;
                    ErrorCode errorCode8 = ErrorCode.PROTOCOL_ERROR;
                    http2Connection = Http2Connection.this;
                    errorCode2 = errorCode8;
                }
                http2Connection.a(errorCode, errorCode2);
            } catch (IOException e3) {
            }
            Util.closeQuietly(this.f35994a);
        }

        @Override // com.tencent.cloud.huiyansdkface.okhttp3.internal.http2.Http2Reader.Handler
        public void goAway(int i, ErrorCode errorCode, ByteString byteString) {
            Http2Stream[] http2StreamArr;
            byteString.size();
            synchronized (Http2Connection.this) {
                http2StreamArr = (Http2Stream[]) Http2Connection.this.f35984c.values().toArray(new Http2Stream[Http2Connection.this.f35984c.size()]);
                Http2Connection.this.g = true;
            }
            int length = http2StreamArr.length;
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= length) {
                    return;
                }
                Http2Stream http2Stream = http2StreamArr[i3];
                if (http2Stream.getId() > i && http2Stream.isLocallyInitiated()) {
                    http2Stream.a(ErrorCode.REFUSED_STREAM);
                    Http2Connection.this.b(http2Stream.getId());
                }
                i2 = i3 + 1;
            }
        }

        @Override // com.tencent.cloud.huiyansdkface.okhttp3.internal.http2.Http2Reader.Handler
        public void headers(boolean z, int i, int i2, List<Header> list) {
            if (Http2Connection.this.c(i)) {
                Http2Connection.this.a(i, list, z);
                return;
            }
            synchronized (Http2Connection.this) {
                Http2Stream a2 = Http2Connection.this.a(i);
                if (a2 != null) {
                    a2.a(list);
                    if (z) {
                        a2.a();
                    }
                } else if (Http2Connection.this.g) {
                } else {
                    if (i <= Http2Connection.this.e) {
                        return;
                    }
                    if (i % 2 == Http2Connection.this.f % 2) {
                        return;
                    }
                    final Http2Stream http2Stream = new Http2Stream(i, Http2Connection.this, false, z, Util.toHeaders(list));
                    Http2Connection.this.e = i;
                    Http2Connection.this.f35984c.put(Integer.valueOf(i), http2Stream);
                    Http2Connection.s.execute(new NamedRunnable("OkHttp %s stream %d", new Object[]{Http2Connection.this.d, Integer.valueOf(i)}) { // from class: com.tencent.cloud.huiyansdkface.okhttp3.internal.http2.Http2Connection.ReaderRunnable.1
                        @Override // com.tencent.cloud.huiyansdkface.okhttp3.internal.NamedRunnable
                        public void execute() {
                            try {
                                Http2Connection.this.b.onStream(http2Stream);
                            } catch (IOException e) {
                                Platform platform = Platform.get();
                                platform.log(4, "Http2Connection.Listener failure for " + Http2Connection.this.d, e);
                                try {
                                    http2Stream.close(ErrorCode.PROTOCOL_ERROR);
                                } catch (IOException e2) {
                                }
                            }
                        }
                    });
                }
            }
        }

        @Override // com.tencent.cloud.huiyansdkface.okhttp3.internal.http2.Http2Reader.Handler
        public void ping(boolean z, int i, int i2) {
            if (!z) {
                try {
                    Http2Connection.this.t.execute(new PingRunnable(true, i, i2));
                    return;
                } catch (RejectedExecutionException e) {
                    return;
                }
            }
            synchronized (Http2Connection.this) {
                Http2Connection.this.v = false;
                Http2Connection.this.notifyAll();
            }
        }

        @Override // com.tencent.cloud.huiyansdkface.okhttp3.internal.http2.Http2Reader.Handler
        public void priority(int i, int i2, int i3, boolean z) {
        }

        @Override // com.tencent.cloud.huiyansdkface.okhttp3.internal.http2.Http2Reader.Handler
        public void pushPromise(int i, int i2, List<Header> list) {
            Http2Connection.this.a(i2, list);
        }

        @Override // com.tencent.cloud.huiyansdkface.okhttp3.internal.http2.Http2Reader.Handler
        public void rstStream(int i, ErrorCode errorCode) {
            if (Http2Connection.this.c(i)) {
                Http2Connection.this.c(i, errorCode);
                return;
            }
            Http2Stream b = Http2Connection.this.b(i);
            if (b != null) {
                b.a(errorCode);
            }
        }

        @Override // com.tencent.cloud.huiyansdkface.okhttp3.internal.http2.Http2Reader.Handler
        public void settings(boolean z, Settings settings) {
            Http2Stream[] http2StreamArr;
            long j;
            int i;
            synchronized (Http2Connection.this) {
                int d = Http2Connection.this.l.d();
                if (z) {
                    Http2Connection.this.l.a();
                }
                Http2Connection.this.l.a(settings);
                a(settings);
                int d2 = Http2Connection.this.l.d();
                http2StreamArr = null;
                if (d2 == -1 || d2 == d) {
                    j = 0;
                } else {
                    long j2 = d2 - d;
                    if (!Http2Connection.this.m) {
                        Http2Connection.this.m = true;
                    }
                    j = j2;
                    if (!Http2Connection.this.f35984c.isEmpty()) {
                        http2StreamArr = (Http2Stream[]) Http2Connection.this.f35984c.values().toArray(new Http2Stream[Http2Connection.this.f35984c.size()]);
                        j = j2;
                    }
                }
                Http2Connection.s.execute(new NamedRunnable("OkHttp %s settings", Http2Connection.this.d) { // from class: com.tencent.cloud.huiyansdkface.okhttp3.internal.http2.Http2Connection.ReaderRunnable.2
                    @Override // com.tencent.cloud.huiyansdkface.okhttp3.internal.NamedRunnable
                    public void execute() {
                        Http2Connection.this.b.onSettings(Http2Connection.this);
                    }
                });
            }
            if (http2StreamArr == null || j == 0) {
                return;
            }
            for (Http2Stream http2Stream : http2StreamArr) {
                synchronized (http2Stream) {
                    http2Stream.a(j);
                }
            }
        }

        @Override // com.tencent.cloud.huiyansdkface.okhttp3.internal.http2.Http2Reader.Handler
        public void windowUpdate(int i, long j) {
            Http2Connection http2Connection = Http2Connection.this;
            if (i == 0) {
                synchronized (http2Connection) {
                    Http2Connection.this.j += j;
                    Http2Connection.this.notifyAll();
                }
                return;
            }
            Http2Stream a2 = http2Connection.a(i);
            if (a2 != null) {
                synchronized (a2) {
                    a2.a(j);
                }
            }
        }
    }

    Http2Connection(Builder builder) {
        this.h = builder.f;
        this.f35983a = builder.g;
        this.b = builder.e;
        this.f = builder.g ? 1 : 2;
        if (builder.g) {
            this.f += 2;
        }
        if (builder.g) {
            this.k.a(7, 16777216);
        }
        this.d = builder.b;
        this.t = new ScheduledThreadPoolExecutor(1, Util.threadFactory(Util.format("OkHttp %s Writer", this.d), false));
        if (builder.h != 0) {
            this.t.scheduleAtFixedRate(new PingRunnable(false, 0, 0), builder.h, builder.h, TimeUnit.MILLISECONDS);
        }
        this.u = new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), Util.threadFactory(Util.format("OkHttp %s Push Observer", this.d), true));
        this.l.a(7, 65535);
        this.l.a(5, 16384);
        this.j = this.l.d();
        this.n = builder.f35991a;
        this.o = new Http2Writer(builder.d, this.f35983a);
        this.p = new ReaderRunnable(new Http2Reader(builder.f35992c, this.f35983a));
    }

    private void a(NamedRunnable namedRunnable) {
        synchronized (this) {
            if (!isShutdown()) {
                this.u.execute(namedRunnable);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0069 A[Catch: all -> 0x00c7, TryCatch #1 {, blocks: (B:5:0x000f, B:27:0x0080, B:32:0x00a4, B:28:0x0090, B:30:0x0097, B:38:0x00b4, B:39:0x00be, B:40:0x00bf, B:7:0x0011, B:9:0x0019, B:11:0x0021, B:13:0x0027, B:15:0x004b, B:17:0x0054, B:20:0x0061, B:22:0x0069, B:24:0x007b, B:41:0x00c2, B:42:0x00c6), top: B:55:0x000f }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.tencent.cloud.huiyansdkface.okhttp3.internal.http2.Http2Stream b(int r9, java.util.List<com.tencent.cloud.huiyansdkface.okhttp3.internal.http2.Header> r10, boolean r11) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 222
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.cloud.huiyansdkface.okhttp3.internal.http2.Http2Connection.b(int, java.util.List, boolean):com.tencent.cloud.huiyansdkface.okhttp3.internal.http2.Http2Stream");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        try {
            a(ErrorCode.PROTOCOL_ERROR, ErrorCode.PROTOCOL_ERROR);
        } catch (IOException e) {
        }
    }

    Http2Stream a(int i) {
        Http2Stream http2Stream;
        synchronized (this) {
            http2Stream = this.f35984c.get(Integer.valueOf(i));
        }
        return http2Stream;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(final int i, final long j) {
        try {
            this.t.execute(new NamedRunnable("OkHttp Window Update %s stream %d", new Object[]{this.d, Integer.valueOf(i)}) { // from class: com.tencent.cloud.huiyansdkface.okhttp3.internal.http2.Http2Connection.2
                @Override // com.tencent.cloud.huiyansdkface.okhttp3.internal.NamedRunnable
                public void execute() {
                    try {
                        Http2Connection.this.o.windowUpdate(i, j);
                    } catch (IOException e) {
                        Http2Connection.this.b();
                    }
                }
            });
        } catch (RejectedExecutionException e) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(final int i, final ErrorCode errorCode) {
        try {
            this.t.execute(new NamedRunnable("OkHttp %s stream %d", new Object[]{this.d, Integer.valueOf(i)}) { // from class: com.tencent.cloud.huiyansdkface.okhttp3.internal.http2.Http2Connection.1
                @Override // com.tencent.cloud.huiyansdkface.okhttp3.internal.NamedRunnable
                public void execute() {
                    try {
                        Http2Connection.this.b(i, errorCode);
                    } catch (IOException e) {
                        Http2Connection.this.b();
                    }
                }
            });
        } catch (RejectedExecutionException e) {
        }
    }

    void a(final int i, BufferedSource bufferedSource, final int i2, final boolean z) throws IOException {
        final Buffer buffer = new Buffer();
        long j = i2;
        bufferedSource.require(j);
        bufferedSource.read(buffer, j);
        if (buffer.size() == j) {
            a(new NamedRunnable("OkHttp %s Push Data[%s]", new Object[]{this.d, Integer.valueOf(i)}) { // from class: com.tencent.cloud.huiyansdkface.okhttp3.internal.http2.Http2Connection.5
                @Override // com.tencent.cloud.huiyansdkface.okhttp3.internal.NamedRunnable
                public void execute() {
                    try {
                        boolean onData = Http2Connection.this.h.onData(i, buffer, i2, z);
                        if (onData) {
                            Http2Connection.this.o.rstStream(i, ErrorCode.CANCEL);
                        }
                        if (onData || z) {
                            synchronized (Http2Connection.this) {
                                Http2Connection.this.q.remove(Integer.valueOf(i));
                            }
                        }
                    } catch (IOException e) {
                    }
                }
            });
            return;
        }
        throw new IOException(buffer.size() + " != " + i2);
    }

    void a(final int i, final List<Header> list) {
        synchronized (this) {
            if (this.q.contains(Integer.valueOf(i))) {
                a(i, ErrorCode.PROTOCOL_ERROR);
                return;
            }
            this.q.add(Integer.valueOf(i));
            try {
                a(new NamedRunnable("OkHttp %s Push Request[%s]", new Object[]{this.d, Integer.valueOf(i)}) { // from class: com.tencent.cloud.huiyansdkface.okhttp3.internal.http2.Http2Connection.3
                    @Override // com.tencent.cloud.huiyansdkface.okhttp3.internal.NamedRunnable
                    public void execute() {
                        if (Http2Connection.this.h.onRequest(i, list)) {
                            try {
                                Http2Connection.this.o.rstStream(i, ErrorCode.CANCEL);
                                synchronized (Http2Connection.this) {
                                    Http2Connection.this.q.remove(Integer.valueOf(i));
                                }
                            } catch (IOException e) {
                            }
                        }
                    }
                });
            } catch (RejectedExecutionException e) {
            }
        }
    }

    void a(final int i, final List<Header> list, final boolean z) {
        try {
            a(new NamedRunnable("OkHttp %s Push Headers[%s]", new Object[]{this.d, Integer.valueOf(i)}) { // from class: com.tencent.cloud.huiyansdkface.okhttp3.internal.http2.Http2Connection.4
                @Override // com.tencent.cloud.huiyansdkface.okhttp3.internal.NamedRunnable
                public void execute() {
                    boolean onHeaders = Http2Connection.this.h.onHeaders(i, list, z);
                    if (onHeaders) {
                        try {
                            Http2Connection.this.o.rstStream(i, ErrorCode.CANCEL);
                        } catch (IOException e) {
                            return;
                        }
                    }
                    if (onHeaders || z) {
                        synchronized (Http2Connection.this) {
                            Http2Connection.this.q.remove(Integer.valueOf(i));
                        }
                    }
                }
            });
        } catch (RejectedExecutionException e) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(int i, boolean z, List<Header> list) throws IOException {
        this.o.synReply(z, i, list);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(long j) {
        synchronized (this) {
            long j2 = this.i + j;
            this.i = j2;
            if (j2 >= this.k.d() / 2) {
                a(0, this.i);
                this.i = 0L;
            }
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(14:8|(3:9|10|11)|12|27|20|21|(8:23|(2:24|(6:26|27|28|29|30|31)(0))|40|41|42|43|44|(1:46)(2:47|48))(0)|39|40|41|42|43|44|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00ac, code lost:
        r5 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00ad, code lost:
        r4 = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00b2, code lost:
        if (r8 == null) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00b5, code lost:
        r4 = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00c1, code lost:
        r4 = e;
     */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00d8 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00d9  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    void a(com.tencent.cloud.huiyansdkface.okhttp3.internal.http2.ErrorCode r4, com.tencent.cloud.huiyansdkface.okhttp3.internal.http2.ErrorCode r5) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 224
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.cloud.huiyansdkface.okhttp3.internal.http2.Http2Connection.a(com.tencent.cloud.huiyansdkface.okhttp3.internal.http2.ErrorCode, com.tencent.cloud.huiyansdkface.okhttp3.internal.http2.ErrorCode):void");
    }

    void a(boolean z) throws IOException {
        if (z) {
            this.o.connectionPreface();
            this.o.settings(this.k);
            int d = this.k.d();
            if (d != 65535) {
                this.o.windowUpdate(0, d - 65535);
            }
        }
        new Thread(this.p).start();
    }

    void a(boolean z, int i, int i2) {
        boolean z2;
        if (!z) {
            synchronized (this) {
                z2 = this.v;
                this.v = true;
            }
            if (z2) {
                b();
                return;
            }
        }
        try {
            this.o.ping(z, i, i2);
        } catch (IOException e) {
            b();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Http2Stream b(int i) {
        Http2Stream remove;
        synchronized (this) {
            remove = this.f35984c.remove(Integer.valueOf(i));
            notifyAll();
        }
        return remove;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(int i, ErrorCode errorCode) throws IOException {
        this.o.rstStream(i, errorCode);
    }

    void c(final int i, final ErrorCode errorCode) {
        a(new NamedRunnable("OkHttp %s Push Reset[%s]", new Object[]{this.d, Integer.valueOf(i)}) { // from class: com.tencent.cloud.huiyansdkface.okhttp3.internal.http2.Http2Connection.6
            @Override // com.tencent.cloud.huiyansdkface.okhttp3.internal.NamedRunnable
            public void execute() {
                Http2Connection.this.h.onReset(i, errorCode);
                synchronized (Http2Connection.this) {
                    Http2Connection.this.q.remove(Integer.valueOf(i));
                }
            }
        });
    }

    boolean c(int i) {
        return i != 0 && (i & 1) == 0;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        a(ErrorCode.NO_ERROR, ErrorCode.CANCEL);
    }

    public void flush() throws IOException {
        this.o.flush();
    }

    public Protocol getProtocol() {
        return Protocol.HTTP_2;
    }

    public boolean isShutdown() {
        boolean z;
        synchronized (this) {
            z = this.g;
        }
        return z;
    }

    public int maxConcurrentStreams() {
        int c2;
        synchronized (this) {
            c2 = this.l.c(Integer.MAX_VALUE);
        }
        return c2;
    }

    public Http2Stream newStream(List<Header> list, boolean z) throws IOException {
        return b(0, list, z);
    }

    public int openStreamCount() {
        int size;
        synchronized (this) {
            size = this.f35984c.size();
        }
        return size;
    }

    public Http2Stream pushStream(int i, List<Header> list, boolean z) throws IOException {
        if (this.f35983a) {
            throw new IllegalStateException("Client cannot push requests.");
        }
        return b(i, list, z);
    }

    public void setSettings(Settings settings) throws IOException {
        synchronized (this.o) {
            synchronized (this) {
                if (this.g) {
                    throw new ConnectionShutdownException();
                }
                this.k.a(settings);
            }
            this.o.settings(settings);
        }
    }

    public void shutdown(ErrorCode errorCode) throws IOException {
        synchronized (this.o) {
            synchronized (this) {
                if (this.g) {
                    return;
                }
                this.g = true;
                this.o.goAway(this.e, errorCode, Util.f35904a);
            }
        }
    }

    public void start() throws IOException {
        a(true);
    }

    public void writeData(int i, boolean z, Buffer buffer, long j) throws IOException {
        int min;
        long j2;
        long j3 = j;
        if (j == 0) {
            this.o.data(z, i, buffer, 0);
            return;
        }
        while (j3 > 0) {
            synchronized (this) {
                while (this.j <= 0) {
                    try {
                        if (!this.f35984c.containsKey(Integer.valueOf(i))) {
                            throw new IOException("stream closed");
                        }
                        wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        throw new InterruptedIOException();
                    }
                }
                min = Math.min((int) Math.min(j3, this.j), this.o.maxDataLength());
                j2 = min;
                this.j -= j2;
            }
            j3 -= j2;
            this.o.data(z && j3 == 0, i, buffer, min);
        }
    }
}
