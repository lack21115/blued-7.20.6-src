package com.kwad.sdk.core.a.kwai;

import com.cdo.oaps.ad.OapsKey;
import com.kwad.sdk.core.response.model.TKAdLiveShopItemInfo;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/a/kwai/im.class */
public final class im implements com.kwad.sdk.core.d<TKAdLiveShopItemInfo> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(TKAdLiveShopItemInfo tKAdLiveShopItemInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        tKAdLiveShopItemInfo.itemId = jSONObject.optString("itemId");
        if (tKAdLiveShopItemInfo.itemId == JSONObject.NULL) {
            tKAdLiveShopItemInfo.itemId = "";
        }
        tKAdLiveShopItemInfo.imageUrl = jSONObject.optString("imageUrl");
        if (tKAdLiveShopItemInfo.imageUrl == JSONObject.NULL) {
            tKAdLiveShopItemInfo.imageUrl = "";
        }
        tKAdLiveShopItemInfo.title = jSONObject.optString("title");
        if (tKAdLiveShopItemInfo.title == JSONObject.NULL) {
            tKAdLiveShopItemInfo.title = "";
        }
        tKAdLiveShopItemInfo.price = jSONObject.optString(OapsKey.KEY_PRICE);
        if (tKAdLiveShopItemInfo.price == JSONObject.NULL) {
            tKAdLiveShopItemInfo.price = "";
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(TKAdLiveShopItemInfo tKAdLiveShopItemInfo, JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject;
        if (jSONObject == null) {
            jSONObject2 = new JSONObject();
        }
        if (tKAdLiveShopItemInfo.itemId != null && !tKAdLiveShopItemInfo.itemId.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "itemId", tKAdLiveShopItemInfo.itemId);
        }
        if (tKAdLiveShopItemInfo.imageUrl != null && !tKAdLiveShopItemInfo.imageUrl.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "imageUrl", tKAdLiveShopItemInfo.imageUrl);
        }
        if (tKAdLiveShopItemInfo.title != null && !tKAdLiveShopItemInfo.title.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "title", tKAdLiveShopItemInfo.title);
        }
        if (tKAdLiveShopItemInfo.price != null && !tKAdLiveShopItemInfo.price.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, OapsKey.KEY_PRICE, tKAdLiveShopItemInfo.price);
        }
        return jSONObject2;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(TKAdLiveShopItemInfo tKAdLiveShopItemInfo, JSONObject jSONObject) {
        a2(tKAdLiveShopItemInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(TKAdLiveShopItemInfo tKAdLiveShopItemInfo, JSONObject jSONObject) {
        return b2(tKAdLiveShopItemInfo, jSONObject);
    }
}
