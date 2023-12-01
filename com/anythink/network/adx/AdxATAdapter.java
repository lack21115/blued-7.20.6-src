package com.anythink.network.adx;

import android.content.Context;
import android.text.TextUtils;
import com.anythink.basead.d.b;
import com.anythink.basead.d.e;
import com.anythink.basead.d.h;
import com.anythink.basead.e.d;
import com.anythink.core.api.ATBidRequestInfoListener;
import com.anythink.core.api.ATInitMediation;
import com.anythink.core.common.e.j;
import com.anythink.nativead.unitgroup.api.CustomNativeAdapter;
import java.util.Map;

/* loaded from: source-8756600-dex2jar.jar:com/anythink/network/adx/AdxATAdapter.class */
public class AdxATAdapter extends CustomNativeAdapter {

    /* renamed from: a  reason: collision with root package name */
    e f5987a;
    j b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f5988c;

    private void a(Context context, Map<String, Object> map) {
        this.b = (j) map.get("basead_params");
        this.f5987a = new e(context, b.a.a, this.b);
    }

    public void destory() {
        if (this.f5987a != null) {
            this.f5987a = null;
        }
    }

    public void getBidRequestInfo(Context context, Map<String, Object> map, Map<String, Object> map2, ATBidRequestInfoListener aTBidRequestInfoListener) {
        j jVar = (j) map.get("basead_params");
        AdxBidRequestInfo adxBidRequestInfo = new AdxBidRequestInfo(context, jVar != null ? jVar.b : "");
        boolean equals = TextUtils.equals("1", ATInitMediation.getStringFromMap(map, "layout_type"));
        this.f5988c = equals;
        if (equals) {
            adxBidRequestInfo.fillAdAcceptType();
        }
        if (aTBidRequestInfoListener != null) {
            aTBidRequestInfoListener.onSuccess(adxBidRequestInfo);
        }
    }

    public String getNetworkName() {
        return AdxATInitManager.getInstance().getNetworkName();
    }

    public String getNetworkPlacementId() {
        j jVar = this.b;
        return jVar != null ? jVar.b : "";
    }

    public String getNetworkSDKVersion() {
        return "";
    }

    public void loadCustomNetworkAd(Context context, Map<String, Object> map, Map<String, Object> map2) {
        int i;
        this.b = (j) map.get("basead_params");
        this.f5987a = new e(context, b.a.a, this.b);
        this.f5988c = TextUtils.equals("1", ATInitMediation.getStringFromMap(map, "layout_type"));
        final boolean equals = TextUtils.equals("0", ATInitMediation.getStringFromMap(map, "close_button", "0"));
        final boolean equals2 = TextUtils.equals("0", ATInitMediation.getStringFromMap(map, "v_m", "0"));
        final String stringFromMap = ATInitMediation.getStringFromMap(map, "video_autoplay", "1");
        int i2 = -1;
        if (map2 != null) {
            i2 = ATInitMediation.getIntFromMap(map2, "key_width");
            i = ATInitMediation.getIntFromMap(map2, "key_height");
        } else {
            i = -1;
        }
        int i3 = context.getResources().getDisplayMetrics().widthPixels;
        int i4 = context.getResources().getDisplayMetrics().heightPixels;
        int i5 = i2;
        if (i2 <= 0) {
            i5 = Math.min(i3, i4);
        }
        int i6 = i;
        if (i <= 0) {
            i6 = (i5 * 3) / 4;
        }
        int i7 = i5 > i3 ? i3 : i5;
        if (i6 > i4) {
            i6 = i4;
        }
        final Context applicationContext = context.getApplicationContext();
        final int i8 = i7;
        final int i9 = i6;
        this.f5987a.a(new d() { // from class: com.anythink.network.adx.AdxATAdapter.1
            public final void onNativeAdLoadError(com.anythink.basead.c.e eVar) {
                if (AdxATAdapter.this.mLoadListener != null) {
                    AdxATAdapter.this.mLoadListener.onAdLoadError(eVar.a(), eVar.b());
                }
            }

            public final void onNativeAdLoaded(h... hVarArr) {
                AdxATNativeAd[] adxATNativeAdArr = new AdxATNativeAd[hVarArr.length];
                int i10 = 0;
                while (true) {
                    int i11 = i10;
                    if (i11 >= hVarArr.length) {
                        break;
                    }
                    h hVar = hVarArr[i11];
                    hVar.a(i8, i9);
                    hVar.a(equals2);
                    hVar.a(stringFromMap);
                    adxATNativeAdArr[i11] = new AdxATNativeAd(applicationContext, hVar, AdxATAdapter.this.f5988c, equals);
                    i10 = i11 + 1;
                }
                if (AdxATAdapter.this.mLoadListener != null) {
                    AdxATAdapter.this.mLoadListener.onAdCacheLoaded(adxATNativeAdArr);
                }
            }
        });
    }
}
