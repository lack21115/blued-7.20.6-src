package com.kwad.sdk.core.a.kwai;

import com.kwad.sdk.core.response.model.AdStyleInfo;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/a/kwai/gg.class */
public final class gg implements com.kwad.sdk.core.d<AdStyleInfo.PlayDetailInfo.PatchEcInfo> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(AdStyleInfo.PlayDetailInfo.PatchEcInfo patchEcInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        patchEcInfo.strongStyleItemId = jSONObject.optString("strongStyleItemId");
        if (patchEcInfo.strongStyleItemId == JSONObject.NULL) {
            patchEcInfo.strongStyleItemId = "";
        }
        patchEcInfo.strongStylePicUrl = jSONObject.optString("strongStylePicUrl");
        if (patchEcInfo.strongStylePicUrl == JSONObject.NULL) {
            patchEcInfo.strongStylePicUrl = "";
        }
        patchEcInfo.strongStyleItemUrl = jSONObject.optString("strongStyleItemUrl");
        if (patchEcInfo.strongStyleItemUrl == JSONObject.NULL) {
            patchEcInfo.strongStyleItemUrl = "";
        }
        patchEcInfo.strongStyleItemPrice = jSONObject.optString("strongStyleItemPrice");
        if (patchEcInfo.strongStyleItemPrice == JSONObject.NULL) {
            patchEcInfo.strongStyleItemPrice = "";
        }
        patchEcInfo.strongStylePriceAfterComm = jSONObject.optString("strongStylePriceAfterComm");
        if (patchEcInfo.strongStylePriceAfterComm == JSONObject.NULL) {
            patchEcInfo.strongStylePriceAfterComm = "";
        }
        patchEcInfo.strongStyleUserCommAmountBuying = jSONObject.optString("strongStyleUserCommAmountBuying");
        if (patchEcInfo.strongStyleUserCommAmountBuying == JSONObject.NULL) {
            patchEcInfo.strongStyleUserCommAmountBuying = "";
        }
        patchEcInfo.strongStyleUserCommAmountSharing = jSONObject.optString("strongStyleUserCommAmountSharing");
        if (patchEcInfo.strongStyleUserCommAmountSharing == JSONObject.NULL) {
            patchEcInfo.strongStyleUserCommAmountSharing = "";
        }
        patchEcInfo.nebulaKwaiLink = jSONObject.optString("nebulaKwaiLink");
        if (patchEcInfo.nebulaKwaiLink == JSONObject.NULL) {
            patchEcInfo.nebulaKwaiLink = "";
        }
        patchEcInfo.linkCode = jSONObject.optString("linkCode");
        if (patchEcInfo.linkCode == JSONObject.NULL) {
            patchEcInfo.linkCode = "";
        }
        patchEcInfo.platformTypeCode = jSONObject.optInt("platformTypeCode");
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(AdStyleInfo.PlayDetailInfo.PatchEcInfo patchEcInfo, JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject;
        if (jSONObject == null) {
            jSONObject2 = new JSONObject();
        }
        if (patchEcInfo.strongStyleItemId != null && !patchEcInfo.strongStyleItemId.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "strongStyleItemId", patchEcInfo.strongStyleItemId);
        }
        if (patchEcInfo.strongStylePicUrl != null && !patchEcInfo.strongStylePicUrl.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "strongStylePicUrl", patchEcInfo.strongStylePicUrl);
        }
        if (patchEcInfo.strongStyleItemUrl != null && !patchEcInfo.strongStyleItemUrl.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "strongStyleItemUrl", patchEcInfo.strongStyleItemUrl);
        }
        if (patchEcInfo.strongStyleItemPrice != null && !patchEcInfo.strongStyleItemPrice.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "strongStyleItemPrice", patchEcInfo.strongStyleItemPrice);
        }
        if (patchEcInfo.strongStylePriceAfterComm != null && !patchEcInfo.strongStylePriceAfterComm.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "strongStylePriceAfterComm", patchEcInfo.strongStylePriceAfterComm);
        }
        if (patchEcInfo.strongStyleUserCommAmountBuying != null && !patchEcInfo.strongStyleUserCommAmountBuying.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "strongStyleUserCommAmountBuying", patchEcInfo.strongStyleUserCommAmountBuying);
        }
        if (patchEcInfo.strongStyleUserCommAmountSharing != null && !patchEcInfo.strongStyleUserCommAmountSharing.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "strongStyleUserCommAmountSharing", patchEcInfo.strongStyleUserCommAmountSharing);
        }
        if (patchEcInfo.nebulaKwaiLink != null && !patchEcInfo.nebulaKwaiLink.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "nebulaKwaiLink", patchEcInfo.nebulaKwaiLink);
        }
        if (patchEcInfo.linkCode != null && !patchEcInfo.linkCode.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "linkCode", patchEcInfo.linkCode);
        }
        if (patchEcInfo.platformTypeCode != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "platformTypeCode", patchEcInfo.platformTypeCode);
        }
        return jSONObject2;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(AdStyleInfo.PlayDetailInfo.PatchEcInfo patchEcInfo, JSONObject jSONObject) {
        a2(patchEcInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(AdStyleInfo.PlayDetailInfo.PatchEcInfo patchEcInfo, JSONObject jSONObject) {
        return b2(patchEcInfo, jSONObject);
    }
}
