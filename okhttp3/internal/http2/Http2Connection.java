package okhttp3.internal.http2;

import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
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
import okhttp3.internal.NamedRunnable;
import okhttp3.internal.Util;
import okhttp3.internal.http2.Http2Reader;
import okhttp3.internal.platform.Platform;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;

/* loaded from: source-3503164-dex2jar.jar:okhttp3/internal/http2/Http2Connection.class */
public final class Http2Connection implements Closeable {
    static final /* synthetic */ boolean p = !Http2Connection.class.desiredAssertionStatus();
    private static final ExecutorService q = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), Util.a("OkHttp Http2Connection", true));

    /* renamed from: a  reason: collision with root package name */
    final boolean f43919a;
    final Listener b;
    final String d;
    int e;
    int f;
    final PushObserver g;
    long i;
    final Socket l;
    final Http2Writer m;
    final ReaderRunnable n;
    private boolean r;
    private final ScheduledExecutorService s;
    private final ExecutorService t;

    /* renamed from: c  reason: collision with root package name */
    final Map<Integer, Http2Stream> f43920c = new LinkedHashMap();
    private long u = 0;
    private long v = 0;
    private long w = 0;
    private long x = 0;
    private long y = 0;
    private long z = 0;
    private long A = 0;
    long h = 0;
    Settings j = new Settings();
    final Settings k = new Settings();
    final Set<Integer> o = new LinkedHashSet();

    /* loaded from: source-3503164-dex2jar.jar:okhttp3/internal/http2/Http2Connection$Builder.class */
    public static class Builder {

        /* renamed from: a  reason: collision with root package name */
        Socket f43934a;
        String b;

        /* renamed from: c  reason: collision with root package name */
        BufferedSource f43935c;
        BufferedSink d;
        Listener e = Listener.f;
        PushObserver f = PushObserver.f43961a;
        boolean g;
        int h;

        public Builder(boolean z) {
            this.g = z;
        }

        public Builder a(int i) {
            this.h = i;
            return this;
        }

        public Builder a(Socket socket, String str, BufferedSource bufferedSource, BufferedSink bufferedSink) {
            this.f43934a = socket;
            this.b = str;
            this.f43935c = bufferedSource;
            this.d = bufferedSink;
            return this;
        }

        public Builder a(Listener listener) {
            this.e = listener;
            return this;
        }

        public Http2Connection a() {
            return new Http2Connection(this);
        }
    }

    /* loaded from: source-3503164-dex2jar.jar:okhttp3/internal/http2/Http2Connection$IntervalPingRunnable.class */
    final class IntervalPingRunnable extends NamedRunnable {
        IntervalPingRunnable() {
            super("OkHttp %s ping", Http2Connection.this.d);
        }

        @Override // okhttp3.internal.NamedRunnable
        public void execute() {
            boolean z;
            synchronized (Http2Connection.this) {
                if (Http2Connection.this.v < Http2Connection.this.u) {
                    z = true;
                } else {
                    Http2Connection.d(Http2Connection.this);
                    z = false;
                }
            }
            if (z) {
                Http2Connection.this.f();
            } else {
                Http2Connection.this.a(false, 1, 0);
            }
        }
    }

    /* loaded from: source-3503164-dex2jar.jar:okhttp3/internal/http2/Http2Connection$Listener.class */
    public static abstract class Listener {
        public static final Listener f = new Listener() { // from class: okhttp3.internal.http2.Http2Connection.Listener.1
            @Override // okhttp3.internal.http2.Http2Connection.Listener
            public void a(Http2Stream http2Stream) throws IOException {
                http2Stream.a(ErrorCode.REFUSED_STREAM);
            }
        };

        public void a(Http2Connection http2Connection) {
        }

        public abstract void a(Http2Stream http2Stream) throws IOException;
    }

    /* loaded from: source-3503164-dex2jar.jar:okhttp3/internal/http2/Http2Connection$PingRunnable.class */
    final class PingRunnable extends NamedRunnable {

        /* renamed from: a  reason: collision with root package name */
        final boolean f43937a;
        final int b;

        /* renamed from: c  reason: collision with root package name */
        final int f43938c;

        PingRunnable(boolean z, int i, int i2) {
            super("OkHttp %s ping %08x%08x", Http2Connection.this.d, Integer.valueOf(i), Integer.valueOf(i2));
            this.f43937a = z;
            this.b = i;
            this.f43938c = i2;
        }

        @Override // okhttp3.internal.NamedRunnable
        public void execute() {
            Http2Connection.this.a(this.f43937a, this.b, this.f43938c);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-3503164-dex2jar.jar:okhttp3/internal/http2/Http2Connection$ReaderRunnable.class */
    public class ReaderRunnable extends NamedRunnable implements Http2Reader.Handler {

        /* renamed from: a  reason: collision with root package name */
        final Http2Reader f43939a;

        ReaderRunnable(Http2Reader http2Reader) {
            super("OkHttp %s", Http2Connection.this.d);
            this.f43939a = http2Reader;
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void a() {
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void a(int i, int i2, int i3, boolean z) {
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void a(int i, int i2, List<Header> list) {
            Http2Connection.this.a(i2, list);
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void a(int i, long j) {
            if (i == 0) {
                synchronized (Http2Connection.this) {
                    Http2Connection.this.i += j;
                    Http2Connection.this.notifyAll();
                }
                return;
            }
            Http2Stream a2 = Http2Connection.this.a(i);
            if (a2 != null) {
                synchronized (a2) {
                    a2.a(j);
                }
            }
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void a(int i, ErrorCode errorCode) {
            if (Http2Connection.this.c(i)) {
                Http2Connection.this.c(i, errorCode);
                return;
            }
            Http2Stream b = Http2Connection.this.b(i);
            if (b != null) {
                b.c(errorCode);
            }
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void a(int i, ErrorCode errorCode, ByteString byteString) {
            Http2Stream[] http2StreamArr;
            byteString.size();
            synchronized (Http2Connection.this) {
                http2StreamArr = (Http2Stream[]) Http2Connection.this.f43920c.values().toArray(new Http2Stream[Http2Connection.this.f43920c.size()]);
                Http2Connection.this.r = true;
            }
            int length = http2StreamArr.length;
            int i2 = 0;
            while (true) {
                int i3 = i2;
                if (i3 >= length) {
                    return;
                }
                Http2Stream http2Stream = http2StreamArr[i3];
                if (http2Stream.a() > i && http2Stream.c()) {
                    http2Stream.c(ErrorCode.REFUSED_STREAM);
                    Http2Connection.this.b(http2Stream.a());
                }
                i2 = i3 + 1;
            }
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void a(boolean z, int i, int i2) {
            if (!z) {
                try {
                    Http2Connection.this.s.execute(new PingRunnable(true, i, i2));
                    return;
                } catch (RejectedExecutionException e) {
                    return;
                }
            }
            synchronized (Http2Connection.this) {
                if (i == 1) {
                    Http2Connection.g(Http2Connection.this);
                } else if (i == 2) {
                    Http2Connection.h(Http2Connection.this);
                } else if (i == 3) {
                    Http2Connection.i(Http2Connection.this);
                    Http2Connection.this.notifyAll();
                }
            }
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void a(boolean z, int i, int i2, List<Header> list) {
            if (Http2Connection.this.c(i)) {
                Http2Connection.this.a(i, list, z);
                return;
            }
            synchronized (Http2Connection.this) {
                Http2Stream a2 = Http2Connection.this.a(i);
                if (a2 != null) {
                    a2.a(list);
                    if (z) {
                        a2.i();
                    }
                } else if (Http2Connection.this.r) {
                } else {
                    if (i <= Http2Connection.this.e) {
                        return;
                    }
                    if (i % 2 == Http2Connection.this.f % 2) {
                        return;
                    }
                    final Http2Stream http2Stream = new Http2Stream(i, Http2Connection.this, false, z, Util.b(list));
                    Http2Connection.this.e = i;
                    Http2Connection.this.f43920c.put(Integer.valueOf(i), http2Stream);
                    Http2Connection.q.execute(new NamedRunnable("OkHttp %s stream %d", new Object[]{Http2Connection.this.d, Integer.valueOf(i)}) { // from class: okhttp3.internal.http2.Http2Connection.ReaderRunnable.1
                        @Override // okhttp3.internal.NamedRunnable
                        public void execute() {
                            try {
                                Http2Connection.this.b.a(http2Stream);
                            } catch (IOException e) {
                                Platform e2 = Platform.e();
                                e2.a(4, "Http2Connection.Listener failure for " + Http2Connection.this.d, e);
                                try {
                                    http2Stream.a(ErrorCode.PROTOCOL_ERROR);
                                } catch (IOException e3) {
                                }
                            }
                        }
                    });
                }
            }
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void a(boolean z, int i, BufferedSource bufferedSource, int i2) throws IOException {
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
                a2.i();
            }
        }

        @Override // okhttp3.internal.http2.Http2Reader.Handler
        public void a(final boolean z, final Settings settings) {
            try {
                Http2Connection.this.s.execute(new NamedRunnable("OkHttp %s ACK Settings", new Object[]{Http2Connection.this.d}) { // from class: okhttp3.internal.http2.Http2Connection.ReaderRunnable.2
                    @Override // okhttp3.internal.NamedRunnable
                    public void execute() {
                        ReaderRunnable.this.b(z, settings);
                    }
                });
            } catch (RejectedExecutionException e) {
            }
        }

        void b(boolean z, Settings settings) {
            Http2Stream[] http2StreamArr;
            long j;
            synchronized (Http2Connection.this.m) {
                synchronized (Http2Connection.this) {
                    int d = Http2Connection.this.k.d();
                    if (z) {
                        Http2Connection.this.k.a();
                    }
                    Http2Connection.this.k.a(settings);
                    int d2 = Http2Connection.this.k.d();
                    http2StreamArr = null;
                    if (d2 == -1 || d2 == d) {
                        j = 0;
                    } else {
                        long j2 = d2 - d;
                        j = j2;
                        if (!Http2Connection.this.f43920c.isEmpty()) {
                            http2StreamArr = (Http2Stream[]) Http2Connection.this.f43920c.values().toArray(new Http2Stream[Http2Connection.this.f43920c.size()]);
                            j = j2;
                        }
                    }
                }
                try {
                    Http2Connection.this.m.a(Http2Connection.this.k);
                } catch (IOException e) {
                    Http2Connection.this.f();
                }
            }
            if (http2StreamArr != null) {
                int length = http2StreamArr.length;
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= length) {
                        break;
                    }
                    Http2Stream http2Stream = http2StreamArr[i2];
                    synchronized (http2Stream) {
                        http2Stream.a(j);
                    }
                    i = i2 + 1;
                }
            }
            Http2Connection.q.execute(new NamedRunnable("OkHttp %s settings", Http2Connection.this.d) { // from class: okhttp3.internal.http2.Http2Connection.ReaderRunnable.3
                @Override // okhttp3.internal.NamedRunnable
                public void execute() {
                    Http2Connection.this.b.a(Http2Connection.this);
                }
            });
        }

        @Override // okhttp3.internal.NamedRunnable
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
                        this.f43939a.a(this);
                        while (this.f43939a.a(false, (Http2Reader.Handler) this)) {
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
                        Util.a(this.f43939a);
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
            Util.a(this.f43939a);
        }
    }

    Http2Connection(Builder builder) {
        this.g = builder.f;
        this.f43919a = builder.g;
        this.b = builder.e;
        this.f = builder.g ? 1 : 2;
        if (builder.g) {
            this.f += 2;
        }
        if (builder.g) {
            this.j.a(7, 16777216);
        }
        this.d = builder.b;
        this.s = new ScheduledThreadPoolExecutor(1, Util.a(Util.a("OkHttp %s Writer", this.d), false));
        if (builder.h != 0) {
            this.s.scheduleAtFixedRate(new IntervalPingRunnable(), builder.h, builder.h, TimeUnit.MILLISECONDS);
        }
        this.t = new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), Util.a(Util.a("OkHttp %s Push Observer", this.d), true));
        this.k.a(7, 65535);
        this.k.a(5, 16384);
        this.i = this.k.d();
        this.l = builder.f43934a;
        this.m = new Http2Writer(builder.d, this.f43919a);
        this.n = new ReaderRunnable(new Http2Reader(builder.f43935c, this.f43919a));
    }

    private void a(NamedRunnable namedRunnable) {
        synchronized (this) {
            if (!this.r) {
                this.t.execute(namedRunnable);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x006a A[Catch: all -> 0x00c8, TryCatch #1 {, blocks: (B:5:0x000f, B:27:0x0081, B:32:0x00a5, B:28:0x0091, B:30:0x0098, B:38:0x00b5, B:39:0x00bf, B:40:0x00c0, B:7:0x0011, B:9:0x001a, B:11:0x0022, B:13:0x0028, B:15:0x004c, B:17:0x0055, B:20:0x0062, B:22:0x006a, B:24:0x007c, B:41:0x00c3, B:42:0x00c7), top: B:55:0x000f }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private okhttp3.internal.http2.Http2Stream b(int r9, java.util.List<okhttp3.internal.http2.Header> r10, boolean r11) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 223
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http2.Http2Connection.b(int, java.util.List, boolean):okhttp3.internal.http2.Http2Stream");
    }

    static /* synthetic */ long d(Http2Connection http2Connection) {
        long j = http2Connection.u;
        http2Connection.u = 1 + j;
        return j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        try {
            a(ErrorCode.PROTOCOL_ERROR, ErrorCode.PROTOCOL_ERROR);
        } catch (IOException e) {
        }
    }

    static /* synthetic */ long g(Http2Connection http2Connection) {
        long j = http2Connection.v;
        http2Connection.v = 1 + j;
        return j;
    }

    static /* synthetic */ long h(Http2Connection http2Connection) {
        long j = http2Connection.x;
        http2Connection.x = 1 + j;
        return j;
    }

    static /* synthetic */ long i(Http2Connection http2Connection) {
        long j = http2Connection.z;
        http2Connection.z = 1 + j;
        return j;
    }

    public int a() {
        int c2;
        synchronized (this) {
            c2 = this.k.c(Integer.MAX_VALUE);
        }
        return c2;
    }

    Http2Stream a(int i) {
        Http2Stream http2Stream;
        synchronized (this) {
            http2Stream = this.f43920c.get(Integer.valueOf(i));
        }
        return http2Stream;
    }

    public Http2Stream a(List<Header> list, boolean z) throws IOException {
        return b(0, list, z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(final int i, final long j) {
        try {
            this.s.execute(new NamedRunnable("OkHttp Window Update %s stream %d", new Object[]{this.d, Integer.valueOf(i)}) { // from class: okhttp3.internal.http2.Http2Connection.2
                @Override // okhttp3.internal.NamedRunnable
                public void execute() {
                    try {
                        Http2Connection.this.m.a(i, j);
                    } catch (IOException e) {
                        Http2Connection.this.f();
                    }
                }
            });
        } catch (RejectedExecutionException e) {
        }
    }

    void a(final int i, final List<Header> list) {
        synchronized (this) {
            if (this.o.contains(Integer.valueOf(i))) {
                a(i, ErrorCode.PROTOCOL_ERROR);
                return;
            }
            this.o.add(Integer.valueOf(i));
            try {
                a(new NamedRunnable("OkHttp %s Push Request[%s]", new Object[]{this.d, Integer.valueOf(i)}) { // from class: okhttp3.internal.http2.Http2Connection.4
                    @Override // okhttp3.internal.NamedRunnable
                    public void execute() {
                        if (Http2Connection.this.g.a(i, list)) {
                            try {
                                Http2Connection.this.m.a(i, ErrorCode.CANCEL);
                                synchronized (Http2Connection.this) {
                                    Http2Connection.this.o.remove(Integer.valueOf(i));
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
            a(new NamedRunnable("OkHttp %s Push Headers[%s]", new Object[]{this.d, Integer.valueOf(i)}) { // from class: okhttp3.internal.http2.Http2Connection.5
                @Override // okhttp3.internal.NamedRunnable
                public void execute() {
                    boolean a2 = Http2Connection.this.g.a(i, list, z);
                    if (a2) {
                        try {
                            Http2Connection.this.m.a(i, ErrorCode.CANCEL);
                        } catch (IOException e) {
                            return;
                        }
                    }
                    if (a2 || z) {
                        synchronized (Http2Connection.this) {
                            Http2Connection.this.o.remove(Integer.valueOf(i));
                        }
                    }
                }
            });
        } catch (RejectedExecutionException e) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(final int i, final ErrorCode errorCode) {
        try {
            this.s.execute(new NamedRunnable("OkHttp %s stream %d", new Object[]{this.d, Integer.valueOf(i)}) { // from class: okhttp3.internal.http2.Http2Connection.1
                @Override // okhttp3.internal.NamedRunnable
                public void execute() {
                    try {
                        Http2Connection.this.b(i, errorCode);
                    } catch (IOException e) {
                        Http2Connection.this.f();
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
            a(new NamedRunnable("OkHttp %s Push Data[%s]", new Object[]{this.d, Integer.valueOf(i)}) { // from class: okhttp3.internal.http2.Http2Connection.6
                @Override // okhttp3.internal.NamedRunnable
                public void execute() {
                    try {
                        boolean a2 = Http2Connection.this.g.a(i, buffer, i2, z);
                        if (a2) {
                            Http2Connection.this.m.a(i, ErrorCode.CANCEL);
                        }
                        if (a2 || z) {
                            synchronized (Http2Connection.this) {
                                Http2Connection.this.o.remove(Integer.valueOf(i));
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

    public void a(int i, boolean z, Buffer buffer, long j) throws IOException {
        int min;
        long j2;
        long j3 = j;
        if (j == 0) {
            this.m.a(z, i, buffer, 0);
            return;
        }
        while (j3 > 0) {
            synchronized (this) {
                while (this.i <= 0) {
                    try {
                        if (!this.f43920c.containsKey(Integer.valueOf(i))) {
                            throw new IOException("stream closed");
                        }
                        wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        throw new InterruptedIOException();
                    }
                }
                min = Math.min((int) Math.min(j3, this.i), this.m.c());
                j2 = min;
                this.i -= j2;
            }
            j3 -= j2;
            this.m.a(z && j3 == 0, i, buffer, min);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(long j) {
        synchronized (this) {
            long j2 = this.h + j;
            this.h = j2;
            if (j2 >= this.j.d() / 2) {
                a(0, this.h);
                this.h = 0L;
            }
        }
    }

    public void a(ErrorCode errorCode) throws IOException {
        synchronized (this.m) {
            synchronized (this) {
                if (this.r) {
                    return;
                }
                this.r = true;
                this.m.a(this.e, errorCode, Util.f43840a);
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
    void a(okhttp3.internal.http2.ErrorCode r4, okhttp3.internal.http2.ErrorCode r5) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 224
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http2.Http2Connection.a(okhttp3.internal.http2.ErrorCode, okhttp3.internal.http2.ErrorCode):void");
    }

    void a(boolean z) throws IOException {
        if (z) {
            this.m.a();
            this.m.b(this.j);
            int d = this.j.d();
            if (d != 65535) {
                this.m.a(0, d - 65535);
            }
        }
        new Thread(this.n).start();
    }

    void a(boolean z, int i, int i2) {
        try {
            this.m.a(z, i, i2);
        } catch (IOException e) {
            f();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Http2Stream b(int i) {
        Http2Stream remove;
        synchronized (this) {
            remove = this.f43920c.remove(Integer.valueOf(i));
            notifyAll();
        }
        return remove;
    }

    public void b() throws IOException {
        this.m.b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(int i, ErrorCode errorCode) throws IOException {
        this.m.a(i, errorCode);
    }

    public boolean b(long j) {
        synchronized (this) {
            if (this.r) {
                return false;
            }
            if (this.x < this.w) {
                if (j >= this.A) {
                    return false;
                }
            }
            return true;
        }
    }

    public void c() throws IOException {
        a(true);
    }

    void c(final int i, final ErrorCode errorCode) {
        a(new NamedRunnable("OkHttp %s Push Reset[%s]", new Object[]{this.d, Integer.valueOf(i)}) { // from class: okhttp3.internal.http2.Http2Connection.7
            @Override // okhttp3.internal.NamedRunnable
            public void execute() {
                Http2Connection.this.g.a(i, errorCode);
                synchronized (Http2Connection.this) {
                    Http2Connection.this.o.remove(Integer.valueOf(i));
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

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d() {
        synchronized (this) {
            if (this.x < this.w) {
                return;
            }
            this.w++;
            this.A = System.nanoTime() + 1000000000;
            try {
                this.s.execute(new NamedRunnable("OkHttp %s ping", this.d) { // from class: okhttp3.internal.http2.Http2Connection.3
                    @Override // okhttp3.internal.NamedRunnable
                    public void execute() {
                        Http2Connection.this.a(false, 2, 0);
                    }
                });
            } catch (RejectedExecutionException e) {
            }
        }
    }
}
