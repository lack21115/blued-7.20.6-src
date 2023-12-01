package com.bytedance.sdk.openadsdk.downloadnew.core;

import org.json.JSONObject;

/* loaded from: source-7206380-dex2jar.jar:com/bytedance/sdk/openadsdk/downloadnew/core/TTDownloadEventModel.class */
public class TTDownloadEventModel {
    private JSONObject b;
    private JSONObject hj;
    private String mb;
    private String ox;

    public static TTDownloadEventModel builder() {
        return new TTDownloadEventModel();
    }

    public JSONObject getExtJson() {
        return this.b;
    }

    public String getLabel() {
        return this.ox;
    }

    public JSONObject getMaterialMeta() {
        return this.hj;
    }

    public String getTag() {
        return this.mb;
    }

    public TTDownloadEventModel setExtJson(JSONObject jSONObject) {
        this.b = jSONObject;
        return this;
    }

    public TTDownloadEventModel setLabel(String str) {
        this.ox = str;
        return this;
    }

    public TTDownloadEventModel setMaterialMeta(JSONObject jSONObject) {
        this.hj = jSONObject;
        return this;
    }

    public TTDownloadEventModel setTag(String str) {
        this.mb = str;
        return this;
    }
}
