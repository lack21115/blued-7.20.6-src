package com.kwad.sdk.core.a.kwai;

import com.kwad.sdk.core.response.model.TemplateConfig;
import org.json.JSONObject;

/* loaded from: source-7994992-dex2jar.jar:com/kwad/sdk/core/a/kwai/iq.class */
public final class iq implements com.kwad.sdk.core.d<TemplateConfig> {
    /* renamed from: a  reason: avoid collision after fix types in other method */
    private static void a2(TemplateConfig templateConfig, JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        templateConfig.h5Url = jSONObject.optString("h5Url");
        if (templateConfig.h5Url == JSONObject.NULL) {
            templateConfig.h5Url = "";
        }
        templateConfig.h5Version = jSONObject.optString("h5Version");
        if (templateConfig.h5Version == JSONObject.NULL) {
            templateConfig.h5Version = "";
        }
        templateConfig.h5Checksum = jSONObject.optString("h5Checksum");
        if (templateConfig.h5Checksum == JSONObject.NULL) {
            templateConfig.h5Checksum = "";
        }
    }

    /* renamed from: b  reason: avoid collision after fix types in other method */
    private static JSONObject b2(TemplateConfig templateConfig, JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject;
        if (jSONObject == null) {
            jSONObject2 = new JSONObject();
        }
        if (templateConfig.h5Url != null && !templateConfig.h5Url.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "h5Url", templateConfig.h5Url);
        }
        if (templateConfig.h5Version != null && !templateConfig.h5Version.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "h5Version", templateConfig.h5Version);
        }
        if (templateConfig.h5Checksum != null && !templateConfig.h5Checksum.equals("")) {
            com.kwad.sdk.utils.t.putValue(jSONObject2, "h5Checksum", templateConfig.h5Checksum);
        }
        return jSONObject2;
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ void a(TemplateConfig templateConfig, JSONObject jSONObject) {
        a2(templateConfig, jSONObject);
    }

    @Override // com.kwad.sdk.core.d
    public final /* bridge */ /* synthetic */ JSONObject b(TemplateConfig templateConfig, JSONObject jSONObject) {
        return b2(templateConfig, jSONObject);
    }
}
