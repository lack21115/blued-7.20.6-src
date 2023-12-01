package com.qiniu.pili.droid.streaming;

import com.baidu.mobads.sdk.api.IAdInterListener;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/streaming/PreviewAppearance.class */
public class PreviewAppearance {
    public float h;
    public ScaleType scaleType;
    public float w;
    public float x;
    public float y;

    /* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/streaming/PreviewAppearance$ScaleType.class */
    public enum ScaleType {
        FULL,
        FIT
    }

    public PreviewAppearance(float f, float f2, float f3, float f4, ScaleType scaleType) {
        this.x = f;
        this.y = f2;
        this.w = f3;
        this.h = f4;
        this.scaleType = scaleType;
    }

    public PreviewAppearance(ScaleType scaleType) {
        this.x = 0.0f;
        this.y = 0.0f;
        this.w = 1.0f;
        this.h = 1.0f;
        this.scaleType = scaleType;
    }

    public String toString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("x", this.x);
            jSONObject.put("y", this.y);
            jSONObject.put(IAdInterListener.AdReqParam.WIDTH, this.w);
            jSONObject.put("h", this.h);
            jSONObject.put("scaleType", this.scaleType);
            return jSONObject.toString();
        } catch (JSONException e) {
            e.printStackTrace();
            return e.toString();
        }
    }
}
