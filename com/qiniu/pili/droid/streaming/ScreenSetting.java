package com.qiniu.pili.droid.streaming;

import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/streaming/ScreenSetting.class */
public class ScreenSetting {
    public int mDpi;
    public int mHeight;
    public int mWidth;

    public int getDpi() {
        return this.mDpi;
    }

    public int getHeight() {
        return this.mHeight;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public ScreenSetting setDpi(int i) {
        this.mDpi = i;
        return this;
    }

    public ScreenSetting setSize(int i, int i2) {
        this.mWidth = i;
        this.mHeight = i2;
        return this;
    }

    public String toString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("Width", this.mWidth);
            jSONObject.put("Height", this.mHeight);
            jSONObject.put("Dpi", this.mDpi);
            return jSONObject.toString();
        } catch (JSONException e) {
            e.printStackTrace();
            return e.toString();
        }
    }
}
