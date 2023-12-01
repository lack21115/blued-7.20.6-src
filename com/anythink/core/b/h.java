package com.anythink.core.b;

import android.os.SystemClock;
import android.util.Log;
import com.anythink.core.api.ATBaseAdAdapter;
import com.anythink.core.api.MediationBidManager;
import com.anythink.core.common.e.ai;
import com.anythink.core.common.e.l;
import com.anythink.core.common.e.m;
import com.anythink.core.common.k.n;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/core/b/h.class */
public final class h extends d {

    /* renamed from: a  reason: collision with root package name */
    private String f6376a;
    private long b;

    /* renamed from: c  reason: collision with root package name */
    private com.anythink.core.b.b.a f6377c;

    public h(com.anythink.core.common.e.a aVar) {
        super(aVar);
        this.f6376a = "IH Bidding";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<ai> list, int i) {
        boolean z;
        synchronized (this) {
            if (this.f.get()) {
                return;
            }
            this.f.set(true);
            if (list == null) {
                list = new ArrayList();
            }
            long elapsedRealtime = SystemClock.elapsedRealtime() - this.b;
            ArrayList arrayList = new ArrayList();
            for (ai aiVar : this.d.i) {
                Iterator<ai> it = list.iterator();
                while (true) {
                    z = false;
                    if (!it.hasNext()) {
                        break;
                    }
                    ai next = it.next();
                    if (aiVar.t().equals(next.t())) {
                        next.a(elapsedRealtime);
                        next.g(0);
                        m mVar = new m(true, next.x(), next.y(), "", "", "", "");
                        mVar.f = next.n() + System.currentTimeMillis();
                        mVar.e = next.n();
                        if (this.d != null) {
                            mVar.b(this.d.f6612c);
                        }
                        a(next, mVar);
                        z = true;
                    }
                }
                if (!z) {
                    if (MediationBidManager.NO_BID_TOKEN_ERROR.equals(aiVar.z())) {
                        b(aiVar, "No Bid Info.", 0L, -2);
                    } else {
                        b(aiVar, "No Bid Info.", elapsedRealtime, i);
                    }
                    if (a(aiVar, "No Bid Info.", i)) {
                        list.add(aiVar);
                    } else {
                        arrayList.add(aiVar);
                    }
                }
            }
            if (this.e) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("IH Bidding Success List", a(list));
                    jSONObject.put("IH Bidding Fail List", a(arrayList));
                } catch (Exception e) {
                }
                n.a(this.f6376a, jSONObject.toString(), false);
            }
            this.f.set(true);
            if (this.f6377c != null) {
                this.f6377c.a(list, arrayList);
            }
        }
    }

    private void b(ai aiVar) {
        m mVar = new m(true, aiVar.x(), aiVar.y(), "", "", "", "");
        mVar.f = aiVar.n() + System.currentTimeMillis();
        mVar.e = aiVar.n();
        if (this.d != null) {
            mVar.b(this.d.f6612c);
        }
        a(aiVar, mVar);
    }

    private static void b(ai aiVar, String str, long j, int i) {
        a(aiVar, str, j, i);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.anythink.core.b.d
    public final void a() {
        a((List<ai>) null, -3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.anythink.core.b.d
    public final void a(final com.anythink.core.b.b.a aVar) {
        this.f6377c = aVar;
        this.b = SystemClock.elapsedRealtime();
        List<ai> list = this.d.i;
        if (this.e) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("Start IH Bidding List", a(list));
            } catch (Exception e) {
            }
            n.a(n.f6818a, jSONObject.toString(), false);
        }
        if (f.a().b() == null) {
            Iterator<ai> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                ATBaseAdAdapter a2 = com.anythink.core.common.k.i.a(it.next());
                if (a2 != null) {
                    MediationBidManager bidManager = a2.getBidManager();
                    if (bidManager != null) {
                        f.a().a(bidManager);
                    }
                }
            }
        }
        MediationBidManager b = f.a().b();
        if (b == null) {
            Log.i(n.f6818a, "No BidManager.");
            a((List<ai>) null, -9);
            return;
        }
        b.setBidRequestUrl(this.d.o);
        b.startBid(this.d, new MediationBidManager.BidListener() { // from class: com.anythink.core.b.h.1
            @Override // com.anythink.core.api.MediationBidManager.BidListener
            public final void onBidFail(String str) {
            }

            @Override // com.anythink.core.api.MediationBidManager.BidListener
            public final void onBidStart(ai aiVar, ATBaseAdAdapter aTBaseAdAdapter) {
                com.anythink.core.b.b.a aVar2 = aVar;
                if (aVar2 != null) {
                    aVar2.a(aiVar, aTBaseAdAdapter);
                }
            }

            @Override // com.anythink.core.api.MediationBidManager.BidListener
            public final void onBidSuccess(List<ai> list2) {
                h.this.a(list2, -1);
            }
        });
    }

    @Override // com.anythink.core.b.d
    protected final void a(ai aiVar, l lVar, long j) {
    }
}
