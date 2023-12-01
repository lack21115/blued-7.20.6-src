package com.kwad.sdk.core.a.kwai;

import com.kwad.sdk.contentalliance.coupon.model.ActivityInfo;
import com.kwad.sdk.core.response.model.SdkConfigData;
import com.kwad.sdk.core.response.model.TemplateConfig;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/a/kwai/bz.class */
public final class bz implements com.kwad.sdk.core.d<SdkConfigData.CouponActiveConfig> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(SdkConfigData.CouponActiveConfig couponActiveConfig, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        couponActiveConfig.popUpShowTimeSeconds = jSONObject.optInt("popUpShowTimeSeconds");
        couponActiveConfig.title = jSONObject.optString("title");
        if (couponActiveConfig.title == JSONObject.NULL) {
            couponActiveConfig.title = "";
        }
        couponActiveConfig.secondTitle = jSONObject.optString("secondTitle");
        if (couponActiveConfig.secondTitle == JSONObject.NULL) {
            couponActiveConfig.secondTitle = "";
        }
        couponActiveConfig.bottomTitle = jSONObject.optString("bottomTitle");
        if (couponActiveConfig.bottomTitle == JSONObject.NULL) {
            couponActiveConfig.bottomTitle = "";
        }
        couponActiveConfig.videoThreshold = jSONObject.optInt("videoThreshold");
        couponActiveConfig.videoSeconds = jSONObject.optInt("videoSeconds");
        couponActiveConfig.couponOpenConfig = new TemplateConfig();
        couponActiveConfig.couponOpenConfig.parseJson(jSONObject.optJSONObject("couponOpenConfig"));
        couponActiveConfig.couponInfoConfig = new TemplateConfig();
        couponActiveConfig.couponInfoConfig.parseJson(jSONObject.optJSONObject("couponInfoConfig"));
        couponActiveConfig.activityInfo = new ActivityInfo();
        couponActiveConfig.activityInfo.parseJson(jSONObject.optJSONObject("activityInfo"));
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(SdkConfigData.CouponActiveConfig couponActiveConfig, JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject;
        if (jSONObject == null) {
            jSONObject2 = new JSONObject();
        }
        if (couponActiveConfig.popUpShowTimeSeconds != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "popUpShowTimeSeconds", couponActiveConfig.popUpShowTimeSeconds);
        }
        if (couponActiveConfig.title != null && !couponActiveConfig.title.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "title", couponActiveConfig.title);
        }
        if (couponActiveConfig.secondTitle != null && !couponActiveConfig.secondTitle.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "secondTitle", couponActiveConfig.secondTitle);
        }
        if (couponActiveConfig.bottomTitle != null && !couponActiveConfig.bottomTitle.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "bottomTitle", couponActiveConfig.bottomTitle);
        }
        if (couponActiveConfig.videoThreshold != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "videoThreshold", couponActiveConfig.videoThreshold);
        }
        if (couponActiveConfig.videoSeconds != 0) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "videoSeconds", couponActiveConfig.videoSeconds);
        }
        com.kwad.sdk.utils.t.a(jSONObject2, "couponOpenConfig", couponActiveConfig.couponOpenConfig);
        com.kwad.sdk.utils.t.a(jSONObject2, "couponInfoConfig", couponActiveConfig.couponInfoConfig);
        com.kwad.sdk.utils.t.a(jSONObject2, "activityInfo", couponActiveConfig.activityInfo);
        return jSONObject2;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(SdkConfigData.CouponActiveConfig couponActiveConfig, JSONObject jSONObject) {
        a2(couponActiveConfig, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(SdkConfigData.CouponActiveConfig couponActiveConfig, JSONObject jSONObject) {
        return b2(couponActiveConfig, jSONObject);
    }
}
