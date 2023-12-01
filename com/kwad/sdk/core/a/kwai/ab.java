package com.kwad.sdk.core.a.kwai;

import com.cdo.oaps.ad.OapsKey;
import com.kwad.sdk.core.response.model.AdProductInfo;
import com.kwad.sdk.core.response.model.CouponInfo;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/a/kwai/ab.class */
public final class ab implements com.kwad.sdk.core.d<AdProductInfo> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(AdProductInfo adProductInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        adProductInfo.icon = jSONObject.optString("icon");
        if (adProductInfo.icon == JSONObject.NULL) {
            adProductInfo.icon = "";
        }
        adProductInfo.name = jSONObject.optString("name");
        if (adProductInfo.name == JSONObject.NULL) {
            adProductInfo.name = "";
        }
        adProductInfo.price = jSONObject.optString(OapsKey.KEY_PRICE);
        if (adProductInfo.price == JSONObject.NULL) {
            adProductInfo.price = "";
        }
        adProductInfo.originPrice = jSONObject.optString("originPrice");
        if (adProductInfo.originPrice == JSONObject.NULL) {
            adProductInfo.originPrice = "";
        }
        adProductInfo.couponList = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("couponList");
        if (optJSONArray != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= optJSONArray.length()) {
                    break;
                }
                CouponInfo couponInfo = new CouponInfo();
                couponInfo.parseJson(optJSONArray.optJSONObject(i2));
                adProductInfo.couponList.add(couponInfo);
                i = i2 + 1;
            }
        }
        adProductInfo.volume = jSONObject.optString("volume");
        if (adProductInfo.volume == JSONObject.NULL) {
            adProductInfo.volume = "";
        }
        adProductInfo.rating = jSONObject.optString(com.anythink.expressad.foundation.d.c.Y);
        if (adProductInfo.rating == JSONObject.NULL) {
            adProductInfo.rating = "";
        }
        adProductInfo.seckillInfo = new AdProductInfo.SpikeInfo();
        adProductInfo.seckillInfo.parseJson(jSONObject.optJSONObject("seckillInfo"));
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(AdProductInfo adProductInfo, JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject;
        if (jSONObject == null) {
            jSONObject2 = new JSONObject();
        }
        if (adProductInfo.icon != null && !adProductInfo.icon.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "icon", adProductInfo.icon);
        }
        if (adProductInfo.name != null && !adProductInfo.name.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "name", adProductInfo.name);
        }
        if (adProductInfo.price != null && !adProductInfo.price.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, OapsKey.KEY_PRICE, adProductInfo.price);
        }
        if (adProductInfo.originPrice != null && !adProductInfo.originPrice.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "originPrice", adProductInfo.originPrice);
        }
        com.kwad.sdk.utils.t.putValue(jSONObject2, "couponList", adProductInfo.couponList);
        if (adProductInfo.volume != null && !adProductInfo.volume.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "volume", adProductInfo.volume);
        }
        if (adProductInfo.rating != null && !adProductInfo.rating.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, com.anythink.expressad.foundation.d.c.Y, adProductInfo.rating);
        }
        com.kwad.sdk.utils.t.a(jSONObject2, "seckillInfo", adProductInfo.seckillInfo);
        return jSONObject2;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdProductInfo adProductInfo, JSONObject jSONObject) {
        a2(adProductInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdProductInfo adProductInfo, JSONObject jSONObject) {
        return b2(adProductInfo, jSONObject);
    }
}
