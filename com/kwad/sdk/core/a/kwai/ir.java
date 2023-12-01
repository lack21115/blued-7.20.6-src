package com.kwad.sdk.core.a.kwai;

import com.kwad.sdk.core.response.model.SdkConfigData;
import com.kwad.sdk.core.response.model.TemplateConfig;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/a/kwai/ir.class */
public final class ir implements com.kwad.sdk.core.d<SdkConfigData.TemplateConfigMap> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(SdkConfigData.TemplateConfigMap templateConfigMap, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        templateConfigMap.couponOpenConfig = new TemplateConfig();
        templateConfigMap.couponOpenConfig.parseJson(jSONObject.optJSONObject("couponOpenConfig"));
        templateConfigMap.couponInfoConfig = new TemplateConfig();
        templateConfigMap.couponInfoConfig.parseJson(jSONObject.optJSONObject("couponInfoConfig"));
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(SdkConfigData.TemplateConfigMap templateConfigMap, JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject;
        if (jSONObject == null) {
            jSONObject2 = new JSONObject();
        }
        com.kwad.sdk.utils.t.a(jSONObject2, "couponOpenConfig", templateConfigMap.couponOpenConfig);
        com.kwad.sdk.utils.t.a(jSONObject2, "couponInfoConfig", templateConfigMap.couponInfoConfig);
        return jSONObject2;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(SdkConfigData.TemplateConfigMap templateConfigMap, JSONObject jSONObject) {
        a2(templateConfigMap, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(SdkConfigData.TemplateConfigMap templateConfigMap, JSONObject jSONObject) {
        return b2(templateConfigMap, jSONObject);
    }
}
