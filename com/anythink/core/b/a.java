package com.anythink.core.b;

import android.content.Context;
import android.os.SystemClock;
import android.util.Log;
import com.anythink.core.api.ATBaseAdAdapter;
import com.anythink.core.api.ATBiddingResult;
import com.anythink.core.api.BaseAd;
import com.anythink.core.common.b.g;
import com.anythink.core.common.e.ai;
import com.anythink.core.common.e.l;
import com.anythink.core.common.e.m;
import com.anythink.core.common.k.n;
import com.anythink.core.common.k.s;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/core/b/a.class */
public class a extends d {

    /* renamed from: a  reason: collision with root package name */
    public static final String f6337a = a.class.getSimpleName();
    private List<ai> b;

    /* renamed from: c  reason: collision with root package name */
    private com.anythink.core.b.b.a f6338c;
    private long g;

    public a(com.anythink.core.common.e.a aVar) {
        super(aVar);
        this.b = Collections.synchronizedList(new ArrayList(this.d.i));
    }

    private static ATBiddingResult a(String str) {
        return ATBiddingResult.fail(str);
    }

    private void a(ATBiddingResult aTBiddingResult, ai aiVar) {
        synchronized (this) {
            a(false, aTBiddingResult, aiVar, -1, (com.anythink.core.b.c.a) null);
        }
    }

    private void a(ai aiVar, l lVar, long j, int i, com.anythink.core.b.c.a aVar) {
        if (!lVar.isSuccessWithUseType()) {
            a(aiVar, lVar.errorMsg, j, i);
            n.a(g.i.g, this.d.d, com.anythink.core.common.k.g.d(String.valueOf(this.d.e)), aiVar);
            return;
        }
        aiVar.a(j);
        aiVar.a(lVar.currency);
        StringBuilder sb = new StringBuilder("C2S Bidding Success: , AdSoruceId:");
        sb.append(aiVar.t());
        sb.append(", NetworkFirmId:");
        sb.append(aiVar.c());
        sb.append(" | price:");
        sb.append(lVar.getPrice());
        sb.append(" | sortPrice:");
        sb.append(lVar.getSortPrice());
        sb.append(" | currency:");
        sb.append(lVar.currency.toString());
        double a2 = a(lVar.getSortPrice(), aiVar);
        double d = a2;
        if (a2 <= 0.0d) {
            Log.w(n.f6818a, "NetworkName:" + aiVar.d() + ",AdSoruceId:" + aiVar.t() + " c2s price return 0,please check network placement c2s config");
            d = com.anythink.core.common.k.g.a(aiVar);
        }
        m mVar = new m(true, d, lVar.token, lVar.winNoticeUrl, lVar.loseNoticeUrl, lVar.displayNoticeUrl, "");
        mVar.l = a(aiVar);
        mVar.setBiddingNotice(lVar.biddingNotice);
        mVar.f = aiVar.n() + System.currentTimeMillis();
        mVar.e = aiVar.n();
        mVar.k = aiVar.t();
        mVar.d = aiVar.c();
        mVar.r = aVar;
        mVar.s = aVar != null;
        if (this.d != null) {
            mVar.b(this.d.f6612c);
        }
        a(aiVar.c(), mVar, 0.0d);
        a(aiVar, mVar);
        n.a(g.i.f, this.d.d, com.anythink.core.common.k.g.d(String.valueOf(this.d.e)), aiVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, ATBiddingResult aTBiddingResult, ai aiVar, int i, com.anythink.core.b.c.a aVar) {
        boolean z2;
        synchronized (this) {
            if (z) {
                f a2 = f.a();
                String t = aiVar.t();
                if (a2.e != null) {
                    if (a2.e.get(t + "_c2sfirstStatus") != null) {
                        z2 = false;
                        com.anythink.core.common.j.c.a(this.d.d, aiVar, z2, SystemClock.elapsedRealtime() - this.g, this.d);
                    }
                }
                z2 = true;
                com.anythink.core.common.j.c.a(this.d.d, aiVar, z2, SystemClock.elapsedRealtime() - this.g, this.d);
            }
            f a3 = f.a();
            String t2 = aiVar.t();
            if (a3.e == null) {
                a3.e = new ConcurrentHashMap<>();
            }
            a3.e.put(t2 + "_c2sfirstStatus", 1);
            if (this.f.get()) {
                if (aTBiddingResult != null && aTBiddingResult.biddingNotice != null) {
                    aTBiddingResult.biddingNotice.notifyBidLoss("2", 0.0d, new HashMap(1));
                }
                return;
            }
            a(aiVar, aTBiddingResult, SystemClock.elapsedRealtime() - this.g, i, aVar);
            List<ai> synchronizedList = Collections.synchronizedList(new ArrayList(1));
            synchronizedList.add(aiVar);
            this.b.remove(aiVar);
            if (this.b.size() == 0) {
                this.f.set(true);
            }
            if (this.f6338c != null) {
                if (!z) {
                    z = a(aiVar, aTBiddingResult.errorMsg, -1);
                }
                if (z) {
                    this.f6338c.a(synchronizedList, (List<ai>) null);
                    return;
                }
                this.f6338c.a((List<ai>) null, synchronizedList);
            }
        }
    }

    @Override // com.anythink.core.b.d
    public final void a() {
        synchronized (this) {
            if (!this.f.get()) {
                this.f.set(true);
                ArrayList arrayList = new ArrayList(3);
                ArrayList arrayList2 = new ArrayList(3);
                for (ai aiVar : this.b) {
                    if (a(aiVar, "bid timeout", -3)) {
                        arrayList.add(aiVar);
                    } else {
                        a(aiVar, ATBiddingResult.fail("bid timeout!"), SystemClock.elapsedRealtime() - this.g, -3, (com.anythink.core.b.c.a) null);
                        arrayList2.add(aiVar);
                    }
                }
                this.b.clear();
                this.f.set(true);
                if (this.f6338c != null) {
                    this.f6338c.a(arrayList, arrayList2);
                }
                this.f6338c = null;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.anythink.core.b.d
    public final void a(com.anythink.core.b.b.a aVar) {
        this.f6338c = aVar;
        List<ai> list = this.d.i;
        int size = list.size();
        this.g = SystemClock.elapsedRealtime();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= size) {
                return;
            }
            final ai aiVar = list.get(i2);
            ATBaseAdAdapter a2 = com.anythink.core.common.k.i.a(aiVar);
            if (a2 == null) {
                a(false, ATBiddingResult.fail(aiVar.h() + "not exist!"), aiVar, -9, (com.anythink.core.b.c.a) null);
            } else {
                try {
                    com.anythink.core.b.b.b bVar = new com.anythink.core.b.b.b(a2) { // from class: com.anythink.core.b.a.1
                        private void a(final ATBiddingResult aTBiddingResult, final com.anythink.core.b.c.a aVar2) {
                            com.anythink.core.common.k.b.a.a().a(new Runnable() { // from class: com.anythink.core.b.a.1.1
                                @Override // java.lang.Runnable
                                public final void run() {
                                    a.this.a(aTBiddingResult.isSuccessWithUseType(), aTBiddingResult, aiVar, aTBiddingResult.isSuccessWithUseType() ? 0 : -1, aVar2);
                                }
                            });
                        }

                        @Override // com.anythink.core.api.ATBiddingListener
                        public final void onC2SBidResult(ATBiddingResult aTBiddingResult) {
                            if (this.f6360c != null) {
                                this.f6360c.releaseLoadResource();
                            }
                            a(aTBiddingResult, null);
                        }

                        @Override // com.anythink.core.api.ATBiddingListener
                        public final void onC2SBiddingResultWithCache(ATBiddingResult aTBiddingResult, BaseAd baseAd) {
                            if (this.f6360c != null) {
                                this.f6360c.releaseLoadResource();
                            }
                            a(aTBiddingResult, new com.anythink.core.b.c.a(this.f6360c, baseAd));
                        }
                    };
                    new StringBuilder("start c2s bid request: ").append(a2.getNetworkName());
                    com.anythink.core.c.d a3 = com.anythink.core.c.e.a(this.d.f6611a).a(this.d.d);
                    Map<String, Object> a4 = a3.a(this.d.d, this.d.f6612c, aiVar);
                    double a5 = aiVar.a(a3);
                    if (a5 > 0.0d) {
                        a4.put("bid_floor", Double.valueOf(a5 * a(aiVar)));
                    }
                    com.anythink.core.common.e.e N = this.d.s.N();
                    s.a(N, aiVar, 0, false);
                    com.anythink.core.common.k.g.a(a4, N);
                    if (this.d.u == 8) {
                        a4.put(g.k.j, this.d.v < 0.0d ? "0" : Double.valueOf(this.d.v));
                    }
                    Context a6 = this.d.b != null ? this.d.b.a() : null;
                    Context context = a6;
                    if (a6 == null) {
                        context = this.d.f6611a;
                    }
                    boolean internalStartBiddingRequest = a2.internalStartBiddingRequest(context, a4, this.d.q, bVar);
                    aVar.a(aiVar, a2);
                    if (!internalStartBiddingRequest) {
                        a(ATBiddingResult.fail("This network don't support head bidding in current TopOn's version."), aiVar);
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                    a(ATBiddingResult.fail(th.getMessage()), aiVar);
                }
            }
            i = i2 + 1;
        }
    }

    @Override // com.anythink.core.b.d
    protected final void a(ai aiVar, l lVar, long j) {
        a(aiVar, lVar, j, -1, (com.anythink.core.b.c.a) null);
    }
}
