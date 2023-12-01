package com.blued.android.module.im.grpc;

import android.os.Handler;
import android.os.HandlerThread;
import com.blued.android.module.im.grpc.HeartBeat;
import com.blued.android.statistics.BluedStatistics;
import com.blued.android.statistics.util.Logger;
import com.blued.das.apm.ApmProtos;
import com.google.protobuf.Any;
import io.grpc.CallOptions;
import io.grpc.ClientCall;
import io.grpc.Metadata;
import io.grpc.MethodDescriptor;
import io.grpc.Status;
import java.util.HashSet;
import java.util.Iterator;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/im/grpc/BaseConnector.class */
public abstract class BaseConnector {
    private static final int[] b = {3000, 3000, 5000, 5000, 10000, 10000, 30000, 30000, 30000, 60000, 60000, 60000};

    /* renamed from: c  reason: collision with root package name */
    private volatile ConnectState f11344c;
    private Logger e;
    private ChannelManager n;
    private HeartBeat o;

    /* renamed from: a  reason: collision with root package name */
    private volatile int f11343a = 30000;
    private volatile boolean d = false;
    private String f = "";
    private boolean g = false;
    private boolean h = false;
    private HashSet<OnConnectStateListener> i = new HashSet<>();
    private Runnable j = new Runnable() { // from class: com.blued.android.module.im.grpc.BaseConnector.1
        @Override // java.lang.Runnable
        public void run() {
            if (BaseConnector.this.b()) {
                BaseConnector.this.e.e("**** reconnect **** [", Integer.valueOf(BaseConnector.this.k), "]");
            }
            BaseConnector.this.l();
        }
    };
    private int k = 0;
    private volatile HandlerThread l = null;
    private volatile Handler m = null;
    private Runnable p = null;
    private volatile long q = 0;
    private ClientCall<Any, Any> r = null;
    private ClientCall.Listener<Any> s = new ClientCall.Listener<Any>() { // from class: com.blued.android.module.im.grpc.BaseConnector.2
        @Override // io.grpc.ClientCall.Listener
        /* renamed from: a */
        public void onMessage(final Any any) {
            if (BaseConnector.this.b()) {
                BaseConnector.this.e.d(" << onMessage @", Thread.currentThread().getName(), " : ", any);
            }
            if (any == null) {
                return;
            }
            BaseConnector.this.a(new Runnable() { // from class: com.blued.android.module.im.grpc.BaseConnector.2.2
                @Override // java.lang.Runnable
                public void run() {
                    BaseConnector.this.c(any);
                }
            });
        }

        @Override // io.grpc.ClientCall.Listener
        public void onClose(final Status status, final Metadata metadata) {
            if (BaseConnector.this.b()) {
                BaseConnector.this.e.e(" << onClose : @", Thread.currentThread().getName(), " ", status == null ? "status is null!" : status.toString(), "\n", metadata == null ? "trailers is null!" : metadata.toString());
            }
            BaseConnector.this.a(new Runnable() { // from class: com.blued.android.module.im.grpc.BaseConnector.2.3
                @Override // java.lang.Runnable
                public void run() {
                    BaseConnector.this.a(status, metadata);
                }
            });
        }

        @Override // io.grpc.ClientCall.Listener
        public void onHeaders(final Metadata metadata) {
            if (BaseConnector.this.b()) {
                BaseConnector.this.e.a(" << onHeaders @", Thread.currentThread().getName(), metadata == null ? "" : metadata.toString());
            }
            BaseConnector.this.a(new Runnable() { // from class: com.blued.android.module.im.grpc.BaseConnector.2.1
                @Override // java.lang.Runnable
                public void run() {
                    BaseConnector.this.a(metadata);
                }
            });
        }

        @Override // io.grpc.ClientCall.Listener
        public void onReady() {
            if (BaseConnector.this.b()) {
                BaseConnector.this.e.a(" << onReady @", Thread.currentThread().getName());
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.blued.android.module.im.grpc.BaseConnector$7  reason: invalid class name */
    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/im/grpc/BaseConnector$7.class */
    public static /* synthetic */ class AnonymousClass7 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f11355a;
        static final /* synthetic */ int[] b;

        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0076 -> B:46:0x0014). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x007a -> B:42:0x001f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x007e -> B:56:0x002a). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:28:0x0082 -> B:50:0x0035). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:30:0x0086 -> B:12:0x0040). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:32:0x008a -> B:40:0x0054). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x008e -> B:54:0x005f). Please submit an issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:36:0x0092 -> B:48:0x006a). Please submit an issue!!! */
        static {
            int[] iArr = new int[Status.Code.values().length];
            b = iArr;
            try {
                iArr[Status.Code.OK.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                b[Status.Code.UNAUTHENTICATED.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                b[Status.Code.ALREADY_EXISTS.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                b[Status.Code.CANCELLED.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                b[Status.Code.UNAVAILABLE.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            int[] iArr2 = new int[ConnectState.values().length];
            f11355a = iArr2;
            try {
                iArr2[ConnectState.CONNECTING.ordinal()] = 1;
            } catch (NoSuchFieldError e6) {
            }
            try {
                f11355a[ConnectState.CONNECTED.ordinal()] = 2;
            } catch (NoSuchFieldError e7) {
            }
            try {
                f11355a[ConnectState.RECEIVE.ordinal()] = 3;
            } catch (NoSuchFieldError e8) {
            }
            try {
                f11355a[ConnectState.DISCONNECTED.ordinal()] = 4;
            } catch (NoSuchFieldError e9) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/im/grpc/BaseConnector$ConnectState.class */
    public enum ConnectState {
        CONNECTING,
        CONNECTED,
        RECEIVE,
        DISCONNECTED
    }

    public BaseConnector(ChannelManager channelManager) {
        this.n = channelManager;
    }

    private void a(int i, Exception exc) {
        long currentTimeMillis = System.currentTimeMillis() - this.q;
        BluedStatistics.b().a(a(), i, currentTimeMillis, exc, this.n.a(), this.n.b());
        if (b()) {
            this.e.a("writeApm : code=", Integer.valueOf(i), ", elapseTime=", Long.valueOf(currentTimeMillis));
        }
    }

    private void a(ConnectState connectState) {
        a(connectState, (Any) null);
    }

    private void a(ConnectState connectState, Any any) {
        this.f11344c = connectState;
        HashSet hashSet = new HashSet();
        synchronized (this.i) {
            hashSet.addAll(this.i);
        }
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            OnConnectStateListener onConnectStateListener = (OnConnectStateListener) it.next();
            int i = AnonymousClass7.f11355a[connectState.ordinal()];
            if (i == 1) {
                onConnectStateListener.onConnecting();
            } else if (i == 2) {
                onConnectStateListener.onConnected();
            } else if (i == 3) {
                onConnectStateListener.onReceive(any);
            } else if (i == 4) {
                onConnectStateListener.onDisconnected();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Metadata metadata) {
        if (b()) {
            this.e.a("  << onClientCallHeaders : @", Thread.currentThread().getName());
        }
        a(200, (Exception) null);
        n();
        this.k = 0;
        if (this.g) {
            o();
        }
        a(ConnectState.CONNECTED);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x00ac, code lost:
        if (r6.n.g() == false) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00e7, code lost:
        if (r14.equals("blued_connector_cancel") != false) goto L51;
     */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0110  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0164  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x016b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(io.grpc.Status r7, io.grpc.Metadata r8) {
        /*
            Method dump skipped, instructions count: 373
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blued.android.module.im.grpc.BaseConnector.a(io.grpc.Status, io.grpc.Metadata):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Runnable runnable) {
        if (this.m == null || runnable == null) {
            return;
        }
        this.m.post(runnable);
    }

    private void a(Runnable runnable, long j) {
        if (this.m == null || runnable == null) {
            return;
        }
        this.m.postDelayed(runnable, j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(Any any) {
        if (b()) {
            this.e.a("  << onClientCallMessage : @", Thread.currentThread().getName());
        }
        if (this.g) {
            p();
        }
        try {
            Any a2 = a(any);
            if (a2 != null) {
                a(ConnectState.RECEIVE, a2);
            }
        } catch (Exception e) {
            if (b()) {
                this.e.e("   << onMessage exception @", Thread.currentThread().getName(), " : \n", e);
            }
        }
    }

    private void g() {
        synchronized (this) {
            if (b()) {
                this.e.e("**** create thread ****");
            }
            a(ConnectState.CONNECTING);
            this.l = new HandlerThread(this.f + "-connector");
            this.l.start();
            this.m = new Handler(this.l.getLooper());
        }
    }

    private void h() {
        synchronized (this) {
            if (b()) {
                this.e.e("**** destroy thread ****");
            }
            if (this.l != null) {
                this.l.quit();
                this.m = null;
                this.l = null;
                a(ConnectState.DISCONNECTED);
            }
        }
    }

    private int i() {
        int[] iArr = b;
        int i = this.k;
        if (i >= iArr.length) {
            i = iArr.length - 1;
        }
        return iArr[i];
    }

    private void j() {
        if (this.m != null) {
            this.m.postDelayed(this.j, i());
            this.k++;
            a(ConnectState.CONNECTING);
        }
    }

    private void k() {
        a(new Runnable() { // from class: com.blued.android.module.im.grpc.BaseConnector.4
            @Override // java.lang.Runnable
            public void run() {
                if (BaseConnector.this.b()) {
                    BaseConnector.this.e.e("**** cancel ****");
                }
                if (BaseConnector.this.r != null) {
                    BaseConnector.this.r.cancel("blued_connector_cancel", null);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        ClientCall<Any, Any> clientCall;
        try {
            this.d = true;
            this.r = this.n.e().newCall(c(), this.h ? CallOptions.DEFAULT.withCompression("gzip") : CallOptions.DEFAULT);
            m();
            this.q = System.currentTimeMillis();
            if (b()) {
                this.e.b("## connector START!");
            }
            this.r.start(this.s, this.n.f());
            this.r.setMessageCompression(this.h);
            this.r.request(Integer.MAX_VALUE);
            if (b()) {
                this.e.b("## connector FINISH!");
            }
        } catch (Exception e) {
            a(Status.fromThrowable(e).getCode().value(), e);
            this.d = false;
            if (b()) {
                this.e.e("## connect ERROR! \n", e);
            }
        }
        if (this.d || (clientCall = this.r) == null) {
            return;
        }
        clientCall.cancel("blued_connector_cancel", null);
    }

    private void m() {
        if (this.p == null) {
            if (b()) {
                this.e.d("startAuthTimeoutChecker!");
            }
            Runnable runnable = new Runnable() { // from class: com.blued.android.module.im.grpc.BaseConnector.5
                @Override // java.lang.Runnable
                public void run() {
                    if (BaseConnector.this.r != null) {
                        BaseConnector.this.r.cancel("blued_connector_auth_timeout", null);
                        if (BaseConnector.this.b()) {
                            BaseConnector.this.e.d("AuthTimeout!");
                        }
                    }
                }
            };
            this.p = runnable;
            a(runnable, this.f11343a);
        }
    }

    private void n() {
        if (this.p != null) {
            if (b()) {
                this.e.d("cancelAuthTimeoutChecker!");
            }
            if (this.m != null) {
                this.m.removeCallbacks(this.p);
            }
            this.p = null;
        }
    }

    private void o() {
        if (this.o == null) {
            HeartBeat heartBeat = new HeartBeat(this.m);
            this.o = heartBeat;
            heartBeat.a(new HeartBeat.OnBeatListener() { // from class: com.blued.android.module.im.grpc.BaseConnector.6
                @Override // com.blued.android.module.im.grpc.HeartBeat.OnBeatListener
                public void a() {
                    if (BaseConnector.this.b()) {
                        BaseConnector.this.e.a("  -- HeartBeat onPing @", Thread.currentThread().getName());
                    }
                    try {
                        BaseConnector.this.d();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                @Override // com.blued.android.module.im.grpc.HeartBeat.OnBeatListener
                public void b() {
                    if (BaseConnector.this.b()) {
                        BaseConnector.this.e.d("  -- HeartBeat onTimeOut @", Thread.currentThread().getName());
                    }
                    if (BaseConnector.this.r != null) {
                        BaseConnector.this.r.cancel("blued_connector_ping_timeout", null);
                    }
                }
            });
        }
    }

    private void p() {
        HeartBeat heartBeat = this.o;
        if (heartBeat != null) {
            heartBeat.update();
        }
    }

    private void q() {
        HeartBeat heartBeat = this.o;
        if (heartBeat != null) {
            heartBeat.a();
            this.o = null;
        }
    }

    protected abstract ApmProtos.GrpcConnectTypeProto.BUSINESS a();

    protected abstract Any a(Any any) throws Exception;

    public void a(OnConnectStateListener onConnectStateListener) {
        if (onConnectStateListener != null) {
            synchronized (this.i) {
                this.i.add(onConnectStateListener);
            }
        }
    }

    public void a(String str) {
        this.f = str;
        this.e = new Logger(str);
    }

    public void a(boolean z) {
        this.h = z;
    }

    public void b(OnConnectStateListener onConnectStateListener) {
        if (onConnectStateListener != null) {
            synchronized (this.i) {
                this.i.remove(onConnectStateListener);
            }
        }
    }

    public void b(final Any any) {
        a(new Runnable() { // from class: com.blued.android.module.im.grpc.BaseConnector.3
            @Override // java.lang.Runnable
            public void run() {
                if (BaseConnector.this.r == null || !BaseConnector.this.r.isReady() || any == null) {
                    return;
                }
                BaseConnector.this.r.sendMessage(any);
                if (BaseConnector.this.b()) {
                    BaseConnector.this.e.c("    >> send data :", any);
                }
            }
        });
    }

    public void b(boolean z) {
        this.g = z;
    }

    protected abstract boolean b();

    protected abstract MethodDescriptor c();

    protected abstract void d();

    public void e() {
        synchronized (this) {
            if (this.l == null) {
                g();
                this.m.post(this.j);
            }
        }
    }

    public void f() {
        synchronized (this) {
            if (this.l != null) {
                this.m.removeCallbacks(this.j);
                if (this.d) {
                    k();
                } else {
                    h();
                }
            }
        }
    }
}
