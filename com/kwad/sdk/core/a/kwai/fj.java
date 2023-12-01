package com.kwad.sdk.core.a.kwai;

import com.kwad.sdk.core.response.model.AdMatrixInfo;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/a/kwai/fj.class */
public final class fj implements com.kwad.sdk.core.d<AdMatrixInfo.MerchantLiveReservationInfo> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(AdMatrixInfo.MerchantLiveReservationInfo merchantLiveReservationInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        merchantLiveReservationInfo.title = jSONObject.optString("title");
        if (merchantLiveReservationInfo.title == JSONObject.NULL) {
            merchantLiveReservationInfo.title = "";
        }
        merchantLiveReservationInfo.userHeadUrl = jSONObject.optString("userHeadUrl");
        if (merchantLiveReservationInfo.userHeadUrl == JSONObject.NULL) {
            merchantLiveReservationInfo.userHeadUrl = "";
        }
        merchantLiveReservationInfo.bookUserCount = jSONObject.optInt("bookUserCount");
        merchantLiveReservationInfo.liveStartTime = jSONObject.optString("liveStartTime");
        if (merchantLiveReservationInfo.liveStartTime == JSONObject.NULL) {
            merchantLiveReservationInfo.liveStartTime = "";
        }
        merchantLiveReservationInfo.displayWeakCard = jSONObject.optBoolean("displayWeakCard");
        merchantLiveReservationInfo.bookUserUrlList = new ArrayList();
        JSONArray optJSONArray = jSONObject.optJSONArray("bookUserUrlList");
        if (optJSONArray != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= optJSONArray.length()) {
                    break;
                }
                merchantLiveReservationInfo.bookUserUrlList.add((String) optJSONArray.opt(i2));
                i = i2 + 1;
            }
        }
        merchantLiveReservationInfo.displayBookCount = jSONObject.optBoolean("displayBookCount");
        merchantLiveReservationInfo.playEndCard = new AdMatrixInfo.MerchantLiveReservationInfo.LiveReservationPlayEndInfo();
        merchantLiveReservationInfo.playEndCard.parseJson(jSONObject.optJSONObject("playEndCard"));
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(AdMatrixInfo.MerchantLiveReservationInfo merchantLiveReservationInfo, JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject;
        if (jSONObject == null) {
            jSONObject2 = new JSONObject();
        }
        if (merchantLiveReservationInfo.title != null && !merchantLiveReservationInfo.title.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "title", merchantLiveReservationInfo.title);
        }
        if (merchantLiveReservationInfo.userHeadUrl != null && !merchantLiveReservationInfo.userHeadUrl.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "userHeadUrl", merchantLiveReservationInfo.userHeadUrl);
        }
        if (merchantLiveReservationInfo.bookUserCount != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "bookUserCount", merchantLiveReservationInfo.bookUserCount);
        }
        if (merchantLiveReservationInfo.liveStartTime != null && !merchantLiveReservationInfo.liveStartTime.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "liveStartTime", merchantLiveReservationInfo.liveStartTime);
        }
        if (merchantLiveReservationInfo.displayWeakCard) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "displayWeakCard", merchantLiveReservationInfo.displayWeakCard);
        }
        com.kwad.sdk.utils.t.putValue(jSONObject2, "bookUserUrlList", merchantLiveReservationInfo.bookUserUrlList);
        if (merchantLiveReservationInfo.displayBookCount) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "displayBookCount", merchantLiveReservationInfo.displayBookCount);
        }
        com.kwad.sdk.utils.t.a(jSONObject2, "playEndCard", merchantLiveReservationInfo.playEndCard);
        return jSONObject2;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdMatrixInfo.MerchantLiveReservationInfo merchantLiveReservationInfo, JSONObject jSONObject) {
        a2(merchantLiveReservationInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdMatrixInfo.MerchantLiveReservationInfo merchantLiveReservationInfo, JSONObject jSONObject) {
        return b2(merchantLiveReservationInfo, jSONObject);
    }
}
