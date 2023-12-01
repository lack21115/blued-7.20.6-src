package com.kwad.sdk.core.report;

import android.content.Context;
import com.kwad.sdk.core.network.g;
import com.kwad.sdk.core.report.f;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ag;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/report/z.class */
public final class z<T extends f, R extends com.kwad.sdk.core.network.g> implements Runnable {
    protected final n<T> ahW;
    protected final b<T, R> akU;
    protected final AtomicInteger akV;
    protected final Context mContext;

    public z(Context context, n<T> nVar, b<T, R> bVar, AtomicInteger atomicInteger) {
        this.mContext = context;
        this.ahW = nVar;
        this.akU = bVar;
        this.akV = atomicInteger;
    }

    private void q(List<T> list) {
        List d = com.kwad.sdk.utils.z.d(list, 200);
        int size = d.size();
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        for (int i = 0; i < size; i++) {
            this.akU.a((List) d.get(i), atomicBoolean);
        }
    }

    private void xn() {
        try {
            List<T> wV = this.ahW.wV();
            if (wV.isEmpty()) {
                return;
            }
            q(wV);
        } catch (Throwable th) {
            ((com.kwad.sdk.service.kwai.d) ServiceProvider.get(com.kwad.sdk.service.kwai.d.class)).gatherException(th);
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.akV.get() > 0 || !ag.isNetworkConnected(this.mContext)) {
            return;
        }
        xn();
    }
}
