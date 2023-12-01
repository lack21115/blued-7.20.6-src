package com.qiniu.pili.droid.shortvideo;

import android.media.MediaFormat;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/shortvideo/PLScreenRecorderSetting.class */
public class PLScreenRecorderSetting {
    private int mDpi;
    private int mHeight;
    private String mRecordFile;
    private int mWidth;
    private boolean mInputAudioEnabled = false;
    private int mEncodingBitrateInBps = 4096000;

    public int getDpi() {
        return this.mDpi;
    }

    public int getEncodingBitrate() {
        return this.mEncodingBitrateInBps;
    }

    public int getHeight() {
        return this.mHeight;
    }

    public String getRecordFile() {
        return this.mRecordFile;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public boolean isInputAudioEnabled() {
        return this.mInputAudioEnabled;
    }

    public PLScreenRecorderSetting setDpi(int i) {
        this.mDpi = i;
        return this;
    }

    public PLScreenRecorderSetting setEncodingBitrate(int i) {
        this.mEncodingBitrateInBps = i;
        return this;
    }

    public PLScreenRecorderSetting setInputAudioEnabled(boolean z) {
        this.mInputAudioEnabled = z;
        return this;
    }

    public PLScreenRecorderSetting setRecordFile(String str) {
        this.mRecordFile = str;
        return this;
    }

    public PLScreenRecorderSetting setSize(int i, int i2) {
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
            jSONObject.put("recoredFile", this.mRecordFile);
            jSONObject.put("inputAudio", this.mInputAudioEnabled);
            jSONObject.put(MediaFormat.KEY_BIT_RATE, this.mEncodingBitrateInBps);
            return jSONObject.toString();
        } catch (JSONException e) {
            e.printStackTrace();
            return e.toString();
        }
    }
}
