package com.anythink.core.b;

import com.anythink.core.api.ATAdConst;
import com.anythink.core.api.ATBaseAdAdapter;
import com.anythink.core.api.ATBidRequestInfo;
import com.anythink.core.api.ATBidRequestInfoListener;
import com.anythink.core.common.b.n;
import com.anythink.core.common.e.ai;
import com.anythink.core.common.k.s;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: source-6737240-dex2jar.jar:com/anythink/core/b/i.class */
public class i {
    public static String a = i.class.getSimpleName();
    com.anythink.core.common.e.a b;
    Map<String, Object> c;
    a d;

    /* renamed from: com.anythink.core.b.i$1  reason: invalid class name */
    /* loaded from: source-6737240-dex2jar.jar:com/anythink/core/b/i$1.class */
    final class AnonymousClass1 implements Runnable {
        final /* synthetic */ ATBaseAdAdapter a;
        final /* synthetic */ ai b;

        /* JADX INFO: Access modifiers changed from: package-private */
        public AnonymousClass1(ATBaseAdAdapter aTBaseAdAdapter, ai aiVar) {
            this.a = aTBaseAdAdapter;
            this.b = aiVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            i.a(i.this, this.a, this.b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.anythink.core.b.i$2  reason: invalid class name */
    /* loaded from: source-6737240-dex2jar.jar:com/anythink/core/b/i$2.class */
    public final class AnonymousClass2 implements ATBidRequestInfoListener {
        final /* synthetic */ ai a;

        AnonymousClass2(ai aiVar) {
            this.a = aiVar;
        }

        @Override // com.anythink.core.api.ATBidRequestInfoListener
        public final void onFailed(String str) {
            if (i.this.d != null) {
                i.this.d.a(str, this.a);
            }
        }

        @Override // com.anythink.core.api.ATBidRequestInfoListener
        public final void onSuccess(ATBidRequestInfo aTBidRequestInfo) {
            i.a(i.this, this.a, aTBidRequestInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.anythink.core.b.i$3  reason: invalid class name */
    /* loaded from: source-6737240-dex2jar.jar:com/anythink/core/b/i$3.class */
    public final class AnonymousClass3 implements Runnable {
        final /* synthetic */ ATBidRequestInfo a;
        final /* synthetic */ ai b;

        AnonymousClass3(ATBidRequestInfo aTBidRequestInfo, ai aiVar) {
            this.a = aTBidRequestInfo;
            this.b = aiVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            JSONObject requestJSONObject;
            try {
                if (this.a == null || (requestJSONObject = this.a.toRequestJSONObject()) == null) {
                    if (i.this.d != null) {
                        i.this.d.a(ATBidRequestInfo.RETURN_PARAMS_ERROR_TYPE, this.b);
                        return;
                    }
                    return;
                }
                ATBidRequestInfo.fillBaseCommonParams(requestJSONObject, String.valueOf(i.this.b.e), i.this.b.n, this.b);
                if (this.b.l() == 3) {
                    requestJSONObject.put("unit_id", this.b.t());
                    requestJSONObject.put(ATAdConst.NETWORK_REQUEST_PARAMS_KEY.EXCLUDE_OFFER, n.a().l());
                }
                if (i.this.d != null) {
                    i.this.d.a(this.b, requestJSONObject);
                }
            } catch (Throwable th) {
                th.printStackTrace();
                if (i.this.d != null) {
                    i.this.d.a(th.getMessage(), this.b);
                }
            }
        }
    }

    /* loaded from: source-6737240-dex2jar.jar:com/anythink/core/b/i$a.class */
    public interface a {
        void a(ai aiVar, ATBaseAdAdapter aTBaseAdAdapter);

        void a(ai aiVar, JSONObject jSONObject);

        void a(String str, ai aiVar);
    }

    public i(com.anythink.core.common.e.a aVar) {
        this.b = aVar;
        this.c = aVar.q;
    }

    private void a(ATBaseAdAdapter aTBaseAdAdapter, ai aiVar) {
        try {
            Map<String, Object> a2 = this.b.n.a(this.b.d, this.b.c, aiVar);
            com.anythink.core.common.e.e N = this.b.s.N();
            s.a(N, aiVar, 0, false);
            com.anythink.core.common.k.g.a(a2, N);
            aTBaseAdAdapter.getBidRequestInfo(this.b.a, a2, this.c, new AnonymousClass2(aiVar));
            if (this.d != null) {
                this.d.a(aiVar, aTBaseAdAdapter);
            }
        } catch (Throwable th) {
            th.printStackTrace();
            a aVar = this.d;
            if (aVar != null) {
                aVar.a(th.getMessage(), aiVar);
            }
        }
    }

    static /* synthetic */ void a(i iVar, ATBaseAdAdapter aTBaseAdAdapter, ai aiVar) {
        try {
            Map<String, Object> a2 = iVar.b.n.a(iVar.b.d, iVar.b.c, aiVar);
            com.anythink.core.common.e.e N = iVar.b.s.N();
            s.a(N, aiVar, 0, false);
            com.anythink.core.common.k.g.a(a2, N);
            aTBaseAdAdapter.getBidRequestInfo(iVar.b.a, a2, iVar.c, new AnonymousClass2(aiVar));
            if (iVar.d != null) {
                iVar.d.a(aiVar, aTBaseAdAdapter);
            }
        } catch (Throwable th) {
            th.printStackTrace();
            a aVar = iVar.d;
            if (aVar != null) {
                aVar.a(th.getMessage(), aiVar);
            }
        }
    }

    static /* synthetic */ void a(i iVar, ai aiVar, ATBidRequestInfo aTBidRequestInfo) {
        com.anythink.core.common.k.b.a.a().a(new AnonymousClass3(aTBidRequestInfo, aiVar));
    }

    private void a(ai aiVar, ATBidRequestInfo aTBidRequestInfo) {
        com.anythink.core.common.k.b.a.a().a(new AnonymousClass3(aTBidRequestInfo, aiVar));
    }

    private void a(ai aiVar, a aVar) {
        this.d = aVar;
        ATBaseAdAdapter a2 = com.anythink.core.common.k.i.a(aiVar);
        if (a2 == null) {
            aVar.a(ATBidRequestInfo.NO_ADAPTER_ERROR_TYPE, aiVar);
        } else {
            com.anythink.core.common.k.b.a.a().a(new AnonymousClass1(a2, aiVar));
        }
    }
}
