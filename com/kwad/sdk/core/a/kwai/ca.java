package com.kwad.sdk.core.a.kwai;

import android.provider.ContactsContract;
import com.kwad.sdk.core.response.model.CouponInfo;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/a/kwai/ca.class */
public final class ca implements com.kwad.sdk.core.d<CouponInfo> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(CouponInfo couponInfo, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        couponInfo.displayName = jSONObject.optString(ContactsContract.Directory.DISPLAY_NAME);
        if (couponInfo.displayName == JSONObject.NULL) {
            couponInfo.displayName = "";
        }
        couponInfo.displayTitle = jSONObject.optString("displayTitle");
        if (couponInfo.displayTitle == JSONObject.NULL) {
            couponInfo.displayTitle = "";
        }
        couponInfo.displayValue = jSONObject.optString("displayValue");
        if (couponInfo.displayValue == JSONObject.NULL) {
            couponInfo.displayValue = "";
        }
        couponInfo.displayBase = jSONObject.optString("displayBase");
        if (couponInfo.displayBase == JSONObject.NULL) {
            couponInfo.displayBase = "";
        }
        couponInfo.displayType = jSONObject.optString("displayType");
        if (couponInfo.displayType == JSONObject.NULL) {
            couponInfo.displayType = "";
        }
        couponInfo.displayActionWords = jSONObject.optString("displayActionWords");
        if (couponInfo.displayActionWords == JSONObject.NULL) {
            couponInfo.displayActionWords = "";
        }
        couponInfo.displayDiscount = jSONObject.optString("displayDiscount");
        if (couponInfo.displayDiscount == JSONObject.NULL) {
            couponInfo.displayDiscount = "";
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(CouponInfo couponInfo, JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject;
        if (jSONObject == null) {
            jSONObject2 = new JSONObject();
        }
        if (couponInfo.displayName != null && !couponInfo.displayName.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, ContactsContract.Directory.DISPLAY_NAME, couponInfo.displayName);
        }
        if (couponInfo.displayTitle != null && !couponInfo.displayTitle.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "displayTitle", couponInfo.displayTitle);
        }
        if (couponInfo.displayValue != null && !couponInfo.displayValue.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "displayValue", couponInfo.displayValue);
        }
        if (couponInfo.displayBase != null && !couponInfo.displayBase.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "displayBase", couponInfo.displayBase);
        }
        if (couponInfo.displayType != null && !couponInfo.displayType.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "displayType", couponInfo.displayType);
        }
        if (couponInfo.displayActionWords != null && !couponInfo.displayActionWords.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "displayActionWords", couponInfo.displayActionWords);
        }
        if (couponInfo.displayDiscount != null && !couponInfo.displayDiscount.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "displayDiscount", couponInfo.displayDiscount);
        }
        return jSONObject2;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(CouponInfo couponInfo, JSONObject jSONObject) {
        a2(couponInfo, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(CouponInfo couponInfo, JSONObject jSONObject) {
        return b2(couponInfo, jSONObject);
    }
}
