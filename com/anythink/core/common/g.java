package com.anythink.core.common;

import android.content.Context;
import android.os.CountDownTimer;
import android.os.SystemClock;
import com.anythink.core.api.ATBaseAdAdapter;
import com.anythink.core.api.ATCustomLoadListener;
import com.anythink.core.api.AdError;
import com.anythink.core.api.BaseAd;
import com.anythink.core.api.ErrorCode;
import com.anythink.core.common.b.g;
import com.anythink.core.common.e.ai;
import java.util.Arrays;
import java.util.List;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/core/common/g.class */
public final class g extends CountDownTimer {

    /* renamed from: a  reason: collision with root package name */
    protected ai f6702a;
    protected com.anythink.core.common.e.e b;

    /* renamed from: c  reason: collision with root package name */
    protected com.anythink.core.c.d f6703c;
    boolean d;
    private final String e;

    /* loaded from: source-6737240-dex2jar.jar:com/anythink/core/common/g$a.class */
    final class a implements ATCustomLoadListener {

        /* renamed from: a  reason: collision with root package name */
        ATBaseAdAdapter f6705a;
        long b;

        private a(long j, ATBaseAdAdapter aTBaseAdAdapter) {
            this.b = j;
            this.f6705a = aTBaseAdAdapter;
        }

        /* synthetic */ a(g gVar, long j, ATBaseAdAdapter aTBaseAdAdapter, byte b) {
            this(j, aTBaseAdAdapter);
        }

        @Override // com.anythink.core.api.ATCustomLoadListener
        public final void onAdCacheLoaded(BaseAd... baseAdArr) {
            g.this.a(this.b, this.f6705a, baseAdArr != null ? Arrays.asList(baseAdArr) : null);
            ATBaseAdAdapter aTBaseAdAdapter = this.f6705a;
            if (aTBaseAdAdapter != null) {
                aTBaseAdAdapter.releaseLoadResource();
            }
        }

        @Override // com.anythink.core.api.ATCustomLoadListener
        public final void onAdDataLoaded() {
            g.a(this.b, this.f6705a);
        }

        @Override // com.anythink.core.api.ATCustomLoadListener
        public final void onAdLoadError(String str, String str2) {
            g gVar = g.this;
            long j = this.b;
            ATBaseAdAdapter aTBaseAdAdapter = this.f6705a;
            AdError errorCode = ErrorCode.getErrorCode(ErrorCode.noADError, str, str2);
            com.anythink.core.common.e.e trackingInfo = aTBaseAdAdapter.getTrackingInfo();
            if (!gVar.d) {
                gVar.d = true;
                com.anythink.core.common.j.c.a(trackingInfo, 0, errorCode, SystemClock.elapsedRealtime() - j);
                com.anythink.core.common.k.g.a(trackingInfo, g.i.b, g.i.g, errorCode.printStackTrace());
            }
            ATBaseAdAdapter aTBaseAdAdapter2 = this.f6705a;
            if (aTBaseAdAdapter2 != null) {
                aTBaseAdAdapter2.releaseLoadResource();
            }
        }
    }

    public g(long j, long j2, ai aiVar, com.anythink.core.common.e.e eVar) {
        super(j, j2);
        this.e = getClass().getSimpleName();
        this.d = false;
        this.f6702a = aiVar;
        this.b = eVar;
    }

    protected static void a(long j, com.anythink.core.common.b.d dVar) {
        dVar.getTrackingInfo().c(SystemClock.elapsedRealtime() - j);
    }

    private void a(long j, com.anythink.core.common.b.d dVar, AdError adError) {
        com.anythink.core.common.e.e trackingInfo = dVar.getTrackingInfo();
        if (this.d) {
            return;
        }
        this.d = true;
        com.anythink.core.common.j.c.a(trackingInfo, 0, adError, SystemClock.elapsedRealtime() - j);
        com.anythink.core.common.k.g.a(trackingInfo, g.i.b, g.i.g, adError.printStackTrace());
    }

    private void a(Context context) {
        ATBaseAdAdapter a2 = com.anythink.core.common.k.i.a(this.f6702a);
        if (a2 == null) {
            return;
        }
        this.b.q = 1;
        this.b.r = 0;
        this.b.s = 0;
        a2.setTrackingInfo(this.b);
        a2.setUnitGroupInfo(this.f6702a);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        com.anythink.core.common.j.a.a(context).a(1, this.b);
        com.anythink.core.common.k.g.a(this.b, g.i.f6511a, g.i.h, "");
        this.f6703c = com.anythink.core.c.e.a(com.anythink.core.common.b.n.a().g()).a(this.b.W());
        com.anythink.core.common.a.a().a(this.b.W(), this.b.x());
        this.d = false;
        a2.internalLoad(context, this.f6703c.a(this.b.W(), this.b.X(), a2.getUnitGroupInfo()), v.a().c(this.b.W()), new a(this, elapsedRealtime, a2, (byte) 0));
    }

    protected final void a(long j, ATBaseAdAdapter aTBaseAdAdapter, List<? extends BaseAd> list) {
        com.anythink.core.common.e.e trackingInfo = aTBaseAdAdapter.getTrackingInfo();
        if (!this.d) {
            this.d = true;
            trackingInfo.d(SystemClock.elapsedRealtime() - j);
            com.anythink.core.common.j.a.a(com.anythink.core.common.b.n.a().g()).a(2, trackingInfo);
            com.anythink.core.common.k.g.a(trackingInfo, g.i.b, g.i.f, "");
        }
        com.anythink.core.common.a.a().a(trackingInfo.W(), trackingInfo.z(), aTBaseAdAdapter, list, this.f6702a.p());
    }

    @Override // android.os.CountDownTimer
    public final void onFinish() {
        Context g;
        ATBaseAdAdapter a2;
        if (this.f6702a == null || this.b == null || (g = com.anythink.core.common.b.n.a().g()) == null || (a2 = com.anythink.core.common.k.i.a(this.f6702a)) == null) {
            return;
        }
        this.b.q = 1;
        this.b.r = 0;
        this.b.s = 0;
        a2.setTrackingInfo(this.b);
        a2.setUnitGroupInfo(this.f6702a);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        com.anythink.core.common.j.a.a(g).a(1, this.b);
        com.anythink.core.common.k.g.a(this.b, g.i.f6511a, g.i.h, "");
        this.f6703c = com.anythink.core.c.e.a(com.anythink.core.common.b.n.a().g()).a(this.b.W());
        com.anythink.core.common.a.a().a(this.b.W(), this.b.x());
        this.d = false;
        a2.internalLoad(g, this.f6703c.a(this.b.W(), this.b.X(), a2.getUnitGroupInfo()), v.a().c(this.b.W()), new a(this, elapsedRealtime, a2, (byte) 0));
    }

    @Override // android.os.CountDownTimer
    public final void onTick(long j) {
    }
}
