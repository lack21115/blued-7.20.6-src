package mtopsdk.mtop.common;

import mtopsdk.a.a;
import mtopsdk.a.b.g;
import mtopsdk.a.b.h;
import mtopsdk.a.f;
import mtopsdk.common.util.TBSdkLog;
import mtopsdk.mtop.MtopProxy;
import mtopsdk.mtop.common.MtopCallback;
import mtopsdk.mtop.common.MtopNetworkResultParser;
import mtopsdk.mtop.domain.MtopRequest;
import mtopsdk.mtop.domain.MtopResponse;
import mtopsdk.mtop.util.MtopSDKThreadPoolExecutorFactory;
import mtopsdk.mtop.util.MtopStatistics;

/* loaded from: source-3503164-dex2jar.jar:mtopsdk/mtop/common/NetworkListenerAdapter.class */
public class NetworkListenerAdapter implements f {

    /* renamed from: a  reason: collision with root package name */
    public MtopCallback.MtopFinishListener f43715a;
    public MtopCallback.MtopHeaderListener b;

    /* renamed from: c  reason: collision with root package name */
    public MtopStatistics f43716c = null;
    private MtopProxy d;
    private Object e;

    public NetworkListenerAdapter(MtopProxy mtopProxy) {
        this.d = mtopProxy;
        this.e = mtopProxy.f;
    }

    private String a() {
        MtopStatistics mtopStatistics = this.f43716c;
        if (mtopStatistics != null) {
            return mtopStatistics.g();
        }
        return null;
    }

    private void a(MtopStatistics mtopStatistics) {
        if (mtopStatistics == null) {
            return;
        }
        mtopStatistics.b();
        mtopStatistics.h();
        if (TBSdkLog.a(TBSdkLog.LogEnable.DebugEnable)) {
            TBSdkLog.a("mtopsdk.MtopStatistics", a(), mtopStatistics.toString());
        }
    }

    private int b() {
        String a2 = a();
        return a2 != null ? a2.hashCode() : hashCode();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(g gVar, Object obj) {
        if (this.f43716c == null) {
            this.f43716c = new MtopStatistics();
        }
        this.f43716c.f();
        if (gVar != null) {
            this.f43716c.a(gVar.d());
            this.f43716c.e = gVar.a();
        }
        String g = this.f43716c.g();
        if (this.f43715a == null) {
            TBSdkLog.d("mtopsdk.NetworkListenerAdapter", g, "[onFinishTask]finishListener is null");
            return;
        }
        MtopProxy mtopProxy = this.d;
        if (mtopProxy == null) {
            TBSdkLog.d("mtopsdk.NetworkListenerAdapter", g, "[onFinishTask]mtopProxy is null");
            return;
        }
        MtopRequest mtopRequest = mtopProxy.d;
        MtopResponse mtopResponse = new MtopResponse(mtopRequest.a(), mtopRequest.b(), null, null);
        mtopResponse.a(this.f43716c);
        MtopFinishEvent mtopFinishEvent = new MtopFinishEvent(mtopResponse);
        if (gVar == null) {
            mtopResponse.a("ANDROID_SYS_NETWORK_ERROR");
            mtopResponse.b("网络错误");
            a(this.f43716c);
            try {
                this.f43715a.onFinished(mtopFinishEvent, obj);
                return;
            } catch (Throwable th) {
                TBSdkLog.b("mtopsdk.NetworkListenerAdapter", g, "[onFinishTask]finishListener error --apiKey=" + mtopRequest.f(), th);
                return;
            }
        }
        this.f43716c.c();
        mtopFinishEvent.f43707a = MtopNetworkResultParser.a(mtopResponse, null, this.d, new MtopNetworkResultParser.ParseParameter(gVar.a(), gVar.b(), gVar.c()));
        this.f43716c.d();
        this.f43716c.f = mtopResponse.a();
        a(this.f43716c);
        try {
            this.f43715a.onFinished(mtopFinishEvent, obj);
        } catch (Throwable th2) {
            TBSdkLog.b("mtopsdk.NetworkListenerAdapter", g, "[onFinishTask]finishListener error --apiKey=" + mtopRequest.f(), th2);
        }
    }

    @Override // mtopsdk.a.f
    public void a(a aVar) {
        b(new h().a(aVar.a()).a(-8).a(), this.e);
    }

    @Override // mtopsdk.a.f
    public void a(a aVar, Exception exc) {
        b(new h().a(aVar.a()).a(-7).a(exc.getMessage()).a(), this.e);
    }

    @Override // mtopsdk.a.f
    public void a(a aVar, g gVar) {
        a(gVar, this.e);
        b(gVar, this.e);
    }

    public void a(final g gVar, final Object obj) {
        MtopSDKThreadPoolExecutorFactory.a(b(), new Runnable() { // from class: mtopsdk.mtop.common.NetworkListenerAdapter.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (NetworkListenerAdapter.this.b != null) {
                        NetworkListenerAdapter.this.b.onHeader(new MtopHeaderEvent(gVar.a(), gVar.b()), obj);
                    }
                } catch (Throwable th) {
                    TBSdkLog.b("mtopsdk.NetworkListenerAdapter", "onHeader failed.", th);
                }
            }
        });
    }

    public void b(final g gVar, final Object obj) {
        MtopSDKThreadPoolExecutorFactory.a(b(), new Runnable() { // from class: mtopsdk.mtop.common.NetworkListenerAdapter.2
            @Override // java.lang.Runnable
            public void run() {
                NetworkListenerAdapter.this.c(gVar, obj);
            }
        });
    }
}
