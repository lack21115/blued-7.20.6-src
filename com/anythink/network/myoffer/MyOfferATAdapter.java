package com.anythink.network.myoffer;

import android.content.Context;
import com.anythink.basead.e.a;
import com.anythink.basead.e.c;
import com.anythink.basead.f.e;
import com.anythink.core.api.BaseAd;
import com.anythink.core.common.b.g;
import com.anythink.core.common.e.j;
import com.anythink.core.common.k.g;
import com.anythink.core.common.s;
import com.anythink.nativead.unitgroup.api.CustomNativeAdapter;
import java.util.Map;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/network/myoffer/MyOfferATAdapter.class */
public class MyOfferATAdapter extends CustomNativeAdapter {

    /* renamed from: a  reason: collision with root package name */
    e f9021a;
    j b;

    /* renamed from: c  reason: collision with root package name */
    private String f9022c = "";
    private boolean d = false;

    private void a(Context context) {
        this.f9021a = new e(context, this.b, this.f9022c, this.d);
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public void destory() {
        e eVar = this.f9021a;
        if (eVar != null) {
            eVar.a((a) null);
            this.f9021a = null;
        }
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public BaseAd getBaseAdObject(Context context) {
        e eVar = this.f9021a;
        if (eVar == null || !eVar.a()) {
            return null;
        }
        return new MyOfferATNativeAd(context, this.f9021a);
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public String getNetworkName() {
        return "MyOffer";
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public String getNetworkPlacementId() {
        return this.f9022c;
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public String getNetworkSDKVersion() {
        return g.a();
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public boolean initNetworkObjectByPlacementId(Context context, Map<String, Object> map, Map<String, Object> map2) {
        if (map.containsKey("my_oid")) {
            this.f9022c = map.get("my_oid").toString();
        }
        if (map.containsKey(g.k.f6515a)) {
            this.b = (j) map.get(g.k.f6515a);
        }
        if (map.containsKey(s.b)) {
            this.d = ((Boolean) map.get(s.b)).booleanValue();
        }
        this.f9021a = new e(context, this.b, this.f9022c, this.d);
        return true;
    }

    @Override // com.anythink.core.api.ATBaseAdAdapter
    public void loadCustomNetworkAd(Context context, Map<String, Object> map, Map<String, Object> map2) {
        if (map.containsKey("my_oid")) {
            this.f9022c = map.get("my_oid").toString();
        }
        if (map.containsKey(g.k.f6515a)) {
            this.b = (j) map.get(g.k.f6515a);
        }
        this.f9021a = new e(context, this.b, this.f9022c, this.d);
        final Context applicationContext = context.getApplicationContext();
        this.f9021a.a(new c() { // from class: com.anythink.network.myoffer.MyOfferATAdapter.1
            @Override // com.anythink.basead.e.c
            public final void onAdCacheLoaded() {
                if (MyOfferATAdapter.this.mLoadListener != null) {
                    MyOfferATAdapter.this.mLoadListener.onAdCacheLoaded(new MyOfferATNativeAd(applicationContext, MyOfferATAdapter.this.f9021a));
                }
            }

            @Override // com.anythink.basead.e.c
            public final void onAdDataLoaded() {
            }

            @Override // com.anythink.basead.e.c
            public final void onAdLoadFailed(com.anythink.basead.c.e eVar) {
                if (MyOfferATAdapter.this.mLoadListener != null) {
                    MyOfferATAdapter.this.mLoadListener.onAdLoadError(eVar.a(), eVar.b());
                }
            }
        });
    }
}
