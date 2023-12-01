package com.kwad.sdk.core.a.kwai;

import com.cdo.oaps.ad.OapsKey;
import com.kwad.components.core.webview.jshandler.WebCardRegisterLiveShopListener;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/a/kwai/v.class */
public final class v implements com.kwad.sdk.core.d<WebCardRegisterLiveShopListener.AdLiveItemShopInfo> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(WebCardRegisterLiveShopListener.AdLiveItemShopInfo adLiveItemShopInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        adLiveItemShopInfo.status = jSONObject.optInt("status");
        adLiveItemShopInfo.title = jSONObject.optString("title");
        if (adLiveItemShopInfo.title == JSONObject.NULL) {
            adLiveItemShopInfo.title = "";
        }
        adLiveItemShopInfo.url = jSONObject.optString("url");
        if (adLiveItemShopInfo.url == JSONObject.NULL) {
            adLiveItemShopInfo.url = "";
        }
        adLiveItemShopInfo.price = jSONObject.optString(OapsKey.KEY_PRICE);
        if (adLiveItemShopInfo.price == JSONObject.NULL) {
            adLiveItemShopInfo.price = "";
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(WebCardRegisterLiveShopListener.AdLiveItemShopInfo adLiveItemShopInfo, JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject;
        if (jSONObject == null) {
            jSONObject2 = new JSONObject();
        }
        if (adLiveItemShopInfo.status != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "status", adLiveItemShopInfo.status);
        }
        if (adLiveItemShopInfo.title != null && !adLiveItemShopInfo.title.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "title", adLiveItemShopInfo.title);
        }
        if (adLiveItemShopInfo.url != null && !adLiveItemShopInfo.url.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "url", adLiveItemShopInfo.url);
        }
        if (adLiveItemShopInfo.price != null && !adLiveItemShopInfo.price.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, OapsKey.KEY_PRICE, adLiveItemShopInfo.price);
        }
        return jSONObject2;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(WebCardRegisterLiveShopListener.AdLiveItemShopInfo adLiveItemShopInfo, JSONObject jSONObject) {
        a2(adLiveItemShopInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(WebCardRegisterLiveShopListener.AdLiveItemShopInfo adLiveItemShopInfo, JSONObject jSONObject) {
        return b2(adLiveItemShopInfo, jSONObject);
    }
}
