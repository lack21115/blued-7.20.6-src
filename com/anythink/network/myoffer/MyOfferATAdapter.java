package com.anythink.network.myoffer;

import android.content.Context;
import com.anythink.basead.e.a;
import com.anythink.basead.e.c;
import com.anythink.basead.f.e;
import com.anythink.core.api.BaseAd;
import com.anythink.core.common.e.j;
import com.anythink.core.common.k.g;
import com.anythink.nativead.unitgroup.api.CustomNativeAdapter;
import java.util.Map;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/network/myoffer/MyOfferATAdapter.class */
public class MyOfferATAdapter extends CustomNativeAdapter {

    /* renamed from: a  reason: collision with root package name */
    e f6181a;
    j b;

    /* renamed from: c  reason: collision with root package name */
    private String f6182c = "";
    private boolean d = false;

    private void a(Context context) {
        this.f6181a = new e(context, this.b, this.f6182c, this.d);
    }

    public void destory() {
        e eVar = this.f6181a;
        if (eVar != null) {
            eVar.a((a) null);
            this.f6181a = null;
        }
    }

    public BaseAd getBaseAdObject(Context context) {
        e eVar = this.f6181a;
        if (eVar == null || !eVar.a()) {
            return null;
        }
        return new MyOfferATNativeAd(context, this.f6181a);
    }

    public String getNetworkName() {
        return "MyOffer";
    }

    public String getNetworkPlacementId() {
        return this.f6182c;
    }

    public String getNetworkSDKVersion() {
        return g.a();
    }

    public boolean initNetworkObjectByPlacementId(Context context, Map<String, Object> map, Map<String, Object> map2) {
        if (map.containsKey("my_oid")) {
            this.f6182c = map.get("my_oid").toString();
        }
        if (map.containsKey("basead_params")) {
            this.b = (j) map.get("basead_params");
        }
        if (map.containsKey("isDefaultOffer")) {
            this.d = ((Boolean) map.get("isDefaultOffer")).booleanValue();
        }
        this.f6181a = new e(context, this.b, this.f6182c, this.d);
        return true;
    }

    public void loadCustomNetworkAd(Context context, Map<String, Object> map, Map<String, Object> map2) {
        if (map.containsKey("my_oid")) {
            this.f6182c = map.get("my_oid").toString();
        }
        if (map.containsKey("basead_params")) {
            this.b = (j) map.get("basead_params");
        }
        this.f6181a = new e(context, this.b, this.f6182c, this.d);
        final Context applicationContext = context.getApplicationContext();
        this.f6181a.a(new c() { // from class: com.anythink.network.myoffer.MyOfferATAdapter.1
            public final void onAdCacheLoaded() {
                if (MyOfferATAdapter.this.mLoadListener != null) {
                    MyOfferATAdapter.this.mLoadListener.onAdCacheLoaded(new BaseAd[]{new MyOfferATNativeAd(applicationContext, MyOfferATAdapter.this.f6181a)});
                }
            }

            public final void onAdDataLoaded() {
            }

            public final void onAdLoadFailed(com.anythink.basead.c.e eVar) {
                if (MyOfferATAdapter.this.mLoadListener != null) {
                    MyOfferATAdapter.this.mLoadListener.onAdLoadError(eVar.a(), eVar.b());
                }
            }
        });
    }
}
