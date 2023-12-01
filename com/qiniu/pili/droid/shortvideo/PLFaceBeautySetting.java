package com.qiniu.pili.droid.shortvideo;

import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/shortvideo/PLFaceBeautySetting.class */
public class PLFaceBeautySetting {
    private static final String BEAUTY_LEVEL = "beautyLevel";
    private static final String ENABLED = "enabled";
    private static final String REDDEN = "redden";
    public static final String TAG = "PLFaceBeautySetting";
    private static final String WHITEN = "whiten";
    private float mBeautyLevel;
    private boolean mEnabled = true;
    private float mRedden;
    private float mWhiten;

    public PLFaceBeautySetting(float f, float f2, float f3) {
        this.mBeautyLevel = f;
        this.mRedden = f3;
        this.mWhiten = f2;
    }

    public static PLFaceBeautySetting fromJSON(JSONObject jSONObject) {
        PLFaceBeautySetting pLFaceBeautySetting = new PLFaceBeautySetting((float) jSONObject.optDouble(BEAUTY_LEVEL), (float) jSONObject.optDouble(WHITEN), (float) jSONObject.optDouble(REDDEN));
        pLFaceBeautySetting.setEnable(jSONObject.optBoolean("enabled", true));
        return pLFaceBeautySetting;
    }

    public float getBeautyLevel() {
        return this.mBeautyLevel;
    }

    public float getRedden() {
        return this.mRedden;
    }

    public float getWhiten() {
        return this.mWhiten;
    }

    public boolean isEnabled() {
        return this.mEnabled;
    }

    public void setBeautyLevel(float f) {
        this.mBeautyLevel = f;
    }

    public void setEnable(boolean z) {
        this.mEnabled = z;
    }

    public void setRedden(float f) {
        this.mRedden = f;
    }

    public void setWhiten(float f) {
        this.mWhiten = f;
    }

    public JSONObject toJSON() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("enabled", this.mEnabled);
            jSONObject.put(BEAUTY_LEVEL, this.mBeautyLevel);
            jSONObject.put(WHITEN, this.mWhiten);
            jSONObject.put(REDDEN, this.mRedden);
            return jSONObject;
        } catch (JSONException e) {
            return null;
        }
    }
}
