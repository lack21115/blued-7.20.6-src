package com.tencent.cloud.huiyansdkface.okhttp3.internal.ws;

import com.google.common.net.HttpHeaders;
import com.sensetime.stmobile.STMobileHumanActionNative;
import com.tencent.cloud.huiyansdkface.okhttp3.Call;
import com.tencent.cloud.huiyansdkface.okhttp3.Callback;
import com.tencent.cloud.huiyansdkface.okhttp3.EventListener;
import com.tencent.cloud.huiyansdkface.okhttp3.OkHttpClient;
import com.tencent.cloud.huiyansdkface.okhttp3.Protocol;
import com.tencent.cloud.huiyansdkface.okhttp3.Request;
import com.tencent.cloud.huiyansdkface.okhttp3.Response;
import com.tencent.cloud.huiyansdkface.okhttp3.WebSocket;
import com.tencent.cloud.huiyansdkface.okhttp3.WebSocketListener;
import com.tencent.cloud.huiyansdkface.okhttp3.internal.Internal;
import com.tencent.cloud.huiyansdkface.okhttp3.internal.Util;
import com.tencent.cloud.huiyansdkface.okhttp3.internal.connection.StreamAllocation;
import com.tencent.cloud.huiyansdkface.okhttp3.internal.ws.WebSocketReader;
import com.tencent.cloud.huiyansdkface.okio.BufferedSink;
import com.tencent.cloud.huiyansdkface.okio.BufferedSource;
import com.tencent.cloud.huiyansdkface.okio.ByteString;
import com.tencent.cloud.huiyansdkface.okio.Okio;
import java.io.Closeable;
import java.io.IOException;
import java.net.ProtocolException;
import java.net.SocketTimeoutException;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/okhttp3/internal/ws/RealWebSocket.class */
public final class RealWebSocket implements WebSocket, WebSocketReader.FrameCallback {
    static final /* synthetic */ boolean b = !RealWebSocket.class.desiredAssertionStatus();

    /* renamed from: c  reason: collision with root package name */
    private static final List<Protocol> f22344c = Collections.singletonList(Protocol.HTTP_1_1);

    /* renamed from: a  reason: collision with root package name */
    final WebSocketListener f22345a;
    private final Request d;
    private final Random e;
    private final long f;
    private final String g;
    private Call h;
    private final Runnable i;
    private WebSocketReader j;
    private WebSocketWriter k;
    private ScheduledExecutorService l;
    private Streams m;
    private long p;
    private boolean q;
    private ScheduledFuture<?> r;
    private String t;
    private boolean u;
    private int v;
    private int w;
    private int x;
    private boolean y;
    private final ArrayDeque<ByteString> n = new ArrayDeque<>();
    private final ArrayDeque<Object> o = new ArrayDeque<>();
    private int s = -1;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/okhttp3/internal/ws/RealWebSocket$CancelRunnable.class */
    public final class CancelRunnable implements Runnable {
        CancelRunnable() {
        }

        @Override // java.lang.Runnable
        public void run() {
            RealWebSocket.this.cancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/okhttp3/internal/ws/RealWebSocket$Close.class */
    public static final class Close {

        /* renamed from: a  reason: collision with root package name */
        final int f22349a;
        final ByteString b;

        /* renamed from: c  reason: collision with root package name */
        final long f22350c;

        Close(int i, ByteString byteString, long j) {
            this.f22349a = i;
            this.b = byteString;
            this.f22350c = j;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/okhttp3/internal/ws/RealWebSocket$Message.class */
    public static final class Message {

        /* renamed from: a  reason: collision with root package name */
        final int f22351a;
        final ByteString b;

        Message(int i, ByteString byteString) {
            this.f22351a = i;
            this.b = byteString;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/okhttp3/internal/ws/RealWebSocket$PingRunnable.class */
    public final class PingRunnable implements Runnable {
        PingRunnable() {
        }

        @Override // java.lang.Runnable
        public void run() {
            RealWebSocket.this.b();
        }
    }

    /* loaded from: source-8457232-dex2jar.jar:com/tencent/cloud/huiyansdkface/okhttp3/internal/ws/RealWebSocket$Streams.class */
    public static abstract class Streams implements Closeable {

        /* renamed from: c  reason: collision with root package name */
        public final boolean f22353c;
        public final BufferedSource d;
        public final BufferedSink e;

        public Streams(boolean z, BufferedSource bufferedSource, BufferedSink bufferedSink) {
            this.f22353c = z;
            this.d = bufferedSource;
            this.e = bufferedSink;
        }
    }

    public RealWebSocket(Request request, WebSocketListener webSocketListener, Random random, long j) {
        if (!"GET".equals(request.method())) {
            throw new IllegalArgumentException("Request must be GET: " + request.method());
        }
        this.d = request;
        this.f22345a = webSocketListener;
        this.e = random;
        this.f = j;
        byte[] bArr = new byte[16];
        random.nextBytes(bArr);
        this.g = ByteString.of(bArr).base64();
        this.i = new Runnable() { // from class: com.tencent.cloud.huiyansdkface.okhttp3.internal.ws.RealWebSocket.1
            @Override // java.lang.Runnable
            public void run() {
                do {
                    try {
                    } catch (IOException e) {
                        RealWebSocket.this.failWebSocket(e, null);
                        return;
                    }
                } while (RealWebSocket.this.a());
            }
        };
    }

    private boolean a(ByteString byteString, int i) {
        synchronized (this) {
            if (!this.u && !this.q) {
                if (this.p + byteString.size() > STMobileHumanActionNative.ST_MOBILE_DETECT_EXTRA_FACE_POINTS) {
                    close(1001, null);
                    return false;
                }
                this.p += byteString.size();
                this.o.add(new Message(i, byteString));
                c();
                return true;
            }
            return false;
        }
    }

    private void c() {
        if (!b && !Thread.holdsLock(this)) {
            throw new AssertionError();
        }
        ScheduledExecutorService scheduledExecutorService = this.l;
        if (scheduledExecutorService != null) {
            scheduledExecutorService.execute(this.i);
        }
    }

    void a(Response response) throws ProtocolException {
        if (response.code() != 101) {
            throw new ProtocolException("Expected HTTP 101 response but was '" + response.code() + " " + response.message() + "'");
        }
        String header = response.header("Connection");
        if (!HttpHeaders.UPGRADE.equalsIgnoreCase(header)) {
            throw new ProtocolException("Expected 'Connection' header value 'Upgrade' but was '" + header + "'");
        }
        String header2 = response.header(HttpHeaders.UPGRADE);
        if (!"websocket".equalsIgnoreCase(header2)) {
            throw new ProtocolException("Expected 'Upgrade' header value 'websocket' but was '" + header2 + "'");
        }
        String header3 = response.header(HttpHeaders.SEC_WEBSOCKET_ACCEPT);
        String base64 = ByteString.encodeUtf8(this.g + "258EAFA5-E914-47DA-95CA-C5AB0DC85B11").sha1().base64();
        if (base64.equals(header3)) {
            return;
        }
        throw new ProtocolException("Expected 'Sec-WebSocket-Accept' header value '" + base64 + "' but was '" + header3 + "'");
    }

    boolean a() throws IOException {
        Streams streams;
        String str;
        synchronized (this) {
            if (this.u) {
                return false;
            }
            WebSocketWriter webSocketWriter = this.k;
            ByteString poll = this.n.poll();
            int i = -1;
            Message message = null;
            if (poll == null) {
                Object poll2 = this.o.poll();
                if (poll2 instanceof Close) {
                    i = this.s;
                    str = this.t;
                    if (i != -1) {
                        Streams streams2 = this.m;
                        this.m = null;
                        this.l.shutdown();
                        message = poll2;
                        streams = streams2;
                    } else {
                        this.r = this.l.schedule(new CancelRunnable(), ((Close) poll2).f22350c, TimeUnit.MILLISECONDS);
                    }
                } else if (poll2 == 0) {
                    return false;
                } else {
                    str = null;
                }
                message = poll2;
                streams = null;
            } else {
                streams = null;
                str = null;
            }
            try {
                if (poll != null) {
                    webSocketWriter.b(poll);
                } else if (message instanceof Message) {
                    ByteString byteString = message.b;
                    BufferedSink buffer = Okio.buffer(webSocketWriter.a(message.f22351a, byteString.size()));
                    buffer.write(byteString);
                    buffer.close();
                    synchronized (this) {
                        this.p -= byteString.size();
                    }
                } else if (!(message instanceof Close)) {
                    throw new AssertionError();
                } else {
                    Close close = message;
                    webSocketWriter.a(close.f22349a, close.b);
                    if (streams != null) {
                        this.f22345a.onClosed(this, i, str);
                    }
                }
                Util.closeQuietly(streams);
                return true;
            } catch (Throwable th) {
                Util.closeQuietly(streams);
                throw th;
            }
        }
    }

    boolean a(int i, String str, long j) {
        synchronized (this) {
            WebSocketProtocol.b(i);
            ByteString byteString = null;
            if (str != null) {
                byteString = ByteString.encodeUtf8(str);
                if (byteString.size() > 123) {
                    throw new IllegalArgumentException("reason.size() > 123: " + str);
                }
            }
            if (!this.u && !this.q) {
                this.q = true;
                this.o.add(new Close(i, byteString, j));
                c();
                return true;
            }
            return false;
        }
    }

    void b() {
        synchronized (this) {
            if (this.u) {
                return;
            }
            WebSocketWriter webSocketWriter = this.k;
            int i = this.y ? this.v : -1;
            this.v++;
            this.y = true;
            if (i == -1) {
                try {
                    webSocketWriter.a(ByteString.EMPTY);
                    return;
                } catch (IOException e) {
                    failWebSocket(e, null);
                    return;
                }
            }
            failWebSocket(new SocketTimeoutException("sent ping but didn't receive pong within " + this.f + "ms (after " + (i - 1) + " successful ping/pongs)"), null);
        }
    }

    @Override // com.tencent.cloud.huiyansdkface.okhttp3.WebSocket
    public void cancel() {
        this.h.cancel();
    }

    @Override // com.tencent.cloud.huiyansdkface.okhttp3.WebSocket
    public boolean close(int i, String str) {
        return a(i, str, 60000L);
    }

    public void connect(OkHttpClient okHttpClient) {
        OkHttpClient build = okHttpClient.newBuilder().eventListener(EventListener.f22158a).protocols(f22344c).build();
        final Request build2 = this.d.newBuilder().header(HttpHeaders.UPGRADE, "websocket").header("Connection", HttpHeaders.UPGRADE).header(HttpHeaders.SEC_WEBSOCKET_KEY, this.g).header(HttpHeaders.SEC_WEBSOCKET_VERSION, "13").build();
        Call newWebSocketCall = Internal.f22211a.newWebSocketCall(build, build2);
        this.h = newWebSocketCall;
        newWebSocketCall.timeout().clearTimeout();
        this.h.enqueue(new Callback() { // from class: com.tencent.cloud.huiyansdkface.okhttp3.internal.ws.RealWebSocket.2
            @Override // com.tencent.cloud.huiyansdkface.okhttp3.Callback
            public void onFailure(Call call, IOException iOException) {
                RealWebSocket.this.failWebSocket(iOException, null);
            }

            @Override // com.tencent.cloud.huiyansdkface.okhttp3.Callback
            public void onResponse(Call call, Response response) {
                try {
                    RealWebSocket.this.a(response);
                    StreamAllocation streamAllocation = Internal.f22211a.streamAllocation(call);
                    streamAllocation.noNewStreams();
                    Streams newWebSocketStreams = streamAllocation.connection().newWebSocketStreams(streamAllocation);
                    try {
                        RealWebSocket.this.f22345a.onOpen(RealWebSocket.this, response);
                        RealWebSocket.this.initReaderAndWriter("OkHttp WebSocket " + build2.url().redact(), newWebSocketStreams);
                        streamAllocation.connection().socket().setSoTimeout(0);
                        RealWebSocket.this.loopReader();
                    } catch (Exception e) {
                        RealWebSocket.this.failWebSocket(e, null);
                    }
                } catch (ProtocolException e2) {
                    RealWebSocket.this.failWebSocket(e2, response);
                    Util.closeQuietly(response);
                }
            }
        });
    }

    public void failWebSocket(Exception exc, Response response) {
        synchronized (this) {
            if (this.u) {
                return;
            }
            this.u = true;
            Streams streams = this.m;
            this.m = null;
            if (this.r != null) {
                this.r.cancel(false);
            }
            if (this.l != null) {
                this.l.shutdown();
            }
            try {
                this.f22345a.onFailure(this, exc, response);
            } finally {
                Util.closeQuietly(streams);
            }
        }
    }

    public void initReaderAndWriter(String str, Streams streams) throws IOException {
        synchronized (this) {
            this.m = streams;
            this.k = new WebSocketWriter(streams.f22353c, streams.e, this.e);
            ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1, Util.threadFactory(str, false));
            this.l = scheduledThreadPoolExecutor;
            if (this.f != 0) {
                scheduledThreadPoolExecutor.scheduleAtFixedRate(new PingRunnable(), this.f, this.f, TimeUnit.MILLISECONDS);
            }
            if (!this.o.isEmpty()) {
                c();
            }
        }
        this.j = new WebSocketReader(streams.f22353c, streams.d, this);
    }

    public void loopReader() throws IOException {
        while (this.s == -1) {
            this.j.a();
        }
    }

    @Override // com.tencent.cloud.huiyansdkface.okhttp3.internal.ws.WebSocketReader.FrameCallback
    public void onReadClose(int i, String str) {
        Streams streams;
        if (i == -1) {
            throw new IllegalArgumentException();
        }
        synchronized (this) {
            if (this.s != -1) {
                throw new IllegalStateException("already closed");
            }
            this.s = i;
            this.t = str;
            streams = null;
            if (this.q) {
                streams = null;
                if (this.o.isEmpty()) {
                    streams = this.m;
                    this.m = null;
                    if (this.r != null) {
                        this.r.cancel(false);
                    }
                    this.l.shutdown();
                }
            }
        }
        try {
            this.f22345a.onClosing(this, i, str);
            if (streams != null) {
                this.f22345a.onClosed(this, i, str);
            }
            Util.closeQuietly(streams);
        } catch (Throwable th) {
            Util.closeQuietly(streams);
            throw th;
        }
    }

    @Override // com.tencent.cloud.huiyansdkface.okhttp3.internal.ws.WebSocketReader.FrameCallback
    public void onReadMessage(ByteString byteString) throws IOException {
        this.f22345a.onMessage(this, byteString);
    }

    @Override // com.tencent.cloud.huiyansdkface.okhttp3.internal.ws.WebSocketReader.FrameCallback
    public void onReadMessage(String str) throws IOException {
        this.f22345a.onMessage(this, str);
    }

    @Override // com.tencent.cloud.huiyansdkface.okhttp3.internal.ws.WebSocketReader.FrameCallback
    public void onReadPing(ByteString byteString) {
        synchronized (this) {
            if (!this.u && (!this.q || !this.o.isEmpty())) {
                this.n.add(byteString);
                c();
                this.w++;
            }
        }
    }

    @Override // com.tencent.cloud.huiyansdkface.okhttp3.internal.ws.WebSocketReader.FrameCallback
    public void onReadPong(ByteString byteString) {
        synchronized (this) {
            this.x++;
            this.y = false;
        }
    }

    @Override // com.tencent.cloud.huiyansdkface.okhttp3.WebSocket
    public long queueSize() {
        long j;
        synchronized (this) {
            j = this.p;
        }
        return j;
    }

    @Override // com.tencent.cloud.huiyansdkface.okhttp3.WebSocket
    public Request request() {
        return this.d;
    }

    @Override // com.tencent.cloud.huiyansdkface.okhttp3.WebSocket
    public boolean send(ByteString byteString) {
        if (byteString != null) {
            return a(byteString, 2);
        }
        throw new NullPointerException("bytes == null");
    }

    @Override // com.tencent.cloud.huiyansdkface.okhttp3.WebSocket
    public boolean send(String str) {
        if (str != null) {
            return a(ByteString.encodeUtf8(str), 1);
        }
        throw new NullPointerException("text == null");
    }
}
