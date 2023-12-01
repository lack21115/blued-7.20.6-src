package com.qiniu.pili.droid.shortvideo;

import com.qiniu.pili.droid.shortvideo.f.e;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/shortvideo/PLAudioEncodeSetting.class */
public class PLAudioEncodeSetting {
    private static final String BITRATE = "bitrate";
    private static final String CHANNELS = "channels";
    private static final String IS_HW_CODEC_ENABLED = "isHWCodecEnabled";
    private static final String SAMPLE_RATE = "sampleRate";
    public static final String TAG = "PLAudioEncodeSetting";
    private int mSamplerate = 44100;
    private int mChannels = 1;
    private int mBitrate = 44100;
    private boolean mIsHWCodecEnabled = true;

    public static PLAudioEncodeSetting fromJSON(JSONObject jSONObject) {
        PLAudioEncodeSetting pLAudioEncodeSetting = new PLAudioEncodeSetting();
        pLAudioEncodeSetting.setSampleRate(jSONObject.optInt(SAMPLE_RATE, 44100));
        pLAudioEncodeSetting.setChannels(jSONObject.optInt(CHANNELS, 1));
        pLAudioEncodeSetting.setBitrate(jSONObject.optInt("bitrate", 44100));
        pLAudioEncodeSetting.setHWCodecEnabled(jSONObject.optBoolean(IS_HW_CODEC_ENABLED, true));
        return pLAudioEncodeSetting;
    }

    public int getBitrate() {
        return this.mBitrate;
    }

    public int getChannels() {
        return this.mChannels;
    }

    public int getSamplerate() {
        return this.mSamplerate;
    }

    public boolean isHWCodecEnabled() {
        return this.mIsHWCodecEnabled;
    }

    public PLAudioEncodeSetting setBitrate(int i) {
        e eVar = e.h;
        eVar.c(TAG, "setBitrate: " + i);
        this.mBitrate = i;
        return this;
    }

    public PLAudioEncodeSetting setChannels(int i) {
        e eVar = e.h;
        eVar.c(TAG, "setChannels: " + i);
        this.mChannels = i;
        return this;
    }

    public PLAudioEncodeSetting setHWCodecEnabled(boolean z) {
        e eVar = e.h;
        eVar.c(TAG, "setIFrameInterval: " + z);
        this.mIsHWCodecEnabled = z;
        return this;
    }

    public PLAudioEncodeSetting setSampleRate(int i) {
        e eVar = e.h;
        eVar.c(TAG, "setSampleRate: " + i);
        this.mSamplerate = i;
        return this;
    }

    public JSONObject toJSON() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(SAMPLE_RATE, this.mSamplerate);
            jSONObject.put(CHANNELS, this.mChannels);
            jSONObject.put("bitrate", this.mBitrate);
            jSONObject.put(IS_HW_CODEC_ENABLED, this.mIsHWCodecEnabled);
            return jSONObject;
        } catch (JSONException e) {
            return null;
        }
    }
}
