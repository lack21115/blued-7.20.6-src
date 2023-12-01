package com.kwad.sdk.core.report;

import android.R;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import com.kwad.sdk.core.network.BaseResultData;
import com.kwad.sdk.core.network.g;
import com.kwad.sdk.core.report.f;
import com.kwad.sdk.core.response.model.BatchReportResult;
import com.kwad.sdk.core.threads.GlobalThreadPools;
import com.kwad.sdk.service.ServiceProvider;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/report/b.class */
public abstract class b<T extends f, R extends com.kwad.sdk.core.network.g> {
    private static ExecutorService ahX;
    private static volatile Handler mHandler;
    private T aia;
    private Context mContext;
    private volatile long ahV = com.igexin.push.config.c.l;
    private n ahW = new p();
    private AtomicInteger ahY = new AtomicInteger(0);
    private AtomicInteger mRetryCount = new AtomicInteger(0);
    private int ahZ = 5;

    /* JADX INFO: Access modifiers changed from: protected */
    public b() {
        if (ahX == null) {
            ahX = GlobalThreadPools.xP();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void R(long j) {
        synchronized (this) {
            if (mHandler == null) {
                return;
            }
            mHandler.removeMessages(R.attr.childDivider);
            Message obtain = Message.obtain(mHandler, a(this.mContext, this.ahW, this.ahY));
            obtain.what = R.attr.childDivider;
            mHandler.sendMessageDelayed(obtain, j);
        }
    }

    private void c(final m<T> mVar) {
        new com.kwad.sdk.core.network.m<R, BatchReportResult>() { // from class: com.kwad.sdk.core.report.b.4
            private static BatchReportResult cx(String str) {
                JSONObject jSONObject = new JSONObject(str);
                BatchReportResult batchReportResult = new BatchReportResult();
                batchReportResult.parseJson(jSONObject);
                return batchReportResult;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.kwad.sdk.core.network.a
            public final R createRequest() {
                f wT = mVar.wT();
                b.this.aia = wT;
                return (R) b.this.a((b) wT);
            }

            @Override // com.kwad.sdk.core.network.m
            public final boolean enableMonitorReport() {
                return false;
            }

            @Override // com.kwad.sdk.core.network.a
            public final ExecutorService getExecutor() {
                return b.ahX;
            }

            @Override // com.kwad.sdk.core.network.m
            public final /* synthetic */ BatchReportResult parseData(String str) {
                return cx(str);
            }
        }.request(new com.kwad.sdk.core.network.p<R, BatchReportResult>() { // from class: com.kwad.sdk.core.report.b.5
            private void a(BatchReportResult batchReportResult) {
                com.kwad.sdk.core.d.b.d("BaseBatchReporter", "立即上报 onSuccess action= " + b.this.aia + " result " + batchReportResult.getResult());
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // com.kwad.sdk.core.network.p, com.kwad.sdk.core.network.h
            public final void onError(R r, int i, String str) {
                b.this.a((m) new m<T>() { // from class: com.kwad.sdk.core.report.b.5.1
                    @Override // com.kwad.sdk.core.report.m
                    public final T wT() {
                        return (T) b.this.aia;
                    }
                });
            }

            @Override // com.kwad.sdk.core.network.p, com.kwad.sdk.core.network.h
            public final /* synthetic */ void onSuccess(com.kwad.sdk.core.network.g gVar, BaseResultData baseResultData) {
                a((BatchReportResult) baseResultData);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean wO() {
        int i = this.mRetryCount.get();
        int i2 = i;
        if (i > 16) {
            i2 = 16;
        }
        v vVar = (v) ServiceProvider.get(v.class);
        return this.ahW.size() >= (vVar != null ? (long) (vVar.su() << i2) : 20L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wQ() {
        int andIncrement = this.mRetryCount.getAndIncrement();
        if (andIncrement <= this.ahZ) {
            if (andIncrement > 0) {
                this.ahV *= 2;
            }
            R(this.ahV);
        }
    }

    protected final void Q(long j) {
        this.ahV = j < 60 ? 60000L : j * 1000;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public R a(T t) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(t);
        return n(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Runnable a(Context context, n<T> nVar, AtomicInteger atomicInteger) {
        return new z(context, nVar, this, atomicInteger);
    }

    public final void a(final m<T> mVar) {
        ahX.execute(new Runnable() { // from class: com.kwad.sdk.core.report.b.1
            @Override // java.lang.Runnable
            public final void run() {
                if (b.mHandler != null && !b.mHandler.hasMessages(R.attr.childDivider)) {
                    b bVar = b.this;
                    bVar.R(bVar.ahV);
                }
                f wT = mVar.wT();
                if (wT != null) {
                    b.this.ahW.e(wT);
                }
                if (b.this.wO()) {
                    b.this.wP();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(n nVar) {
        this.ahW = nVar;
    }

    public final void a(final List<T> list, final AtomicBoolean atomicBoolean) {
        if (list == null || list.size() <= 0) {
            return;
        }
        this.ahY.getAndIncrement();
        new com.kwad.sdk.core.network.m<R, BatchReportResult>() { // from class: com.kwad.sdk.core.report.b.2
            private static BatchReportResult cx(String str) {
                JSONObject jSONObject = new JSONObject(str);
                BatchReportResult batchReportResult = new BatchReportResult();
                batchReportResult.parseJson(jSONObject);
                return batchReportResult;
            }

            @Override // com.kwad.sdk.core.network.a
            public final R createRequest() {
                return (R) b.this.n(list);
            }

            @Override // com.kwad.sdk.core.network.m
            public final boolean enableMonitorReport() {
                return false;
            }

            @Override // com.kwad.sdk.core.network.a
            public final ExecutorService getExecutor() {
                return b.ahX;
            }

            @Override // com.kwad.sdk.core.network.m
            public final /* synthetic */ BatchReportResult parseData(String str) {
                return cx(str);
            }
        }.request(new com.kwad.sdk.core.network.p<R, BatchReportResult>() { // from class: com.kwad.sdk.core.report.b.3
            private void a(BatchReportResult batchReportResult) {
                b.this.ahW.o(list);
                if (b.this.ahY.decrementAndGet() == 0 && atomicBoolean.get()) {
                    b.this.wQ();
                }
                b.this.Q(batchReportResult.getInterval());
                b bVar = b.this;
                bVar.R(bVar.ahV);
            }

            @Override // com.kwad.sdk.core.network.p, com.kwad.sdk.core.network.h
            public final void onError(R r, int i, String str) {
                atomicBoolean.set(true);
                if (b.this.ahY.decrementAndGet() == 0) {
                    b.this.wQ();
                }
            }

            @Override // com.kwad.sdk.core.network.p, com.kwad.sdk.core.network.h
            public final /* synthetic */ void onSuccess(com.kwad.sdk.core.network.g gVar, BaseResultData baseResultData) {
                a((BatchReportResult) baseResultData);
            }
        });
    }

    public final void b(m<T> mVar) {
        try {
            c(mVar);
        } catch (Throwable th) {
            ((com.kwad.sdk.service.kwai.d) ServiceProvider.get(com.kwad.sdk.service.kwai.d.class)).gatherException(th);
        }
    }

    public void i(Context context, int i) {
        synchronized (this) {
            this.mContext = context;
            if (mHandler == null) {
                mHandler = com.kwad.sdk.core.threads.a.xJ();
            }
        }
    }

    protected abstract R n(List<T> list);

    public final void wP() {
        R(0L);
    }
}
