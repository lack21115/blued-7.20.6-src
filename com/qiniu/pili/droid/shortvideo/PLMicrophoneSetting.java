package com.qiniu.pili.droid.shortvideo;

import android.media.audiofx.AcousticEchoCanceler;
import android.media.audiofx.NoiseSuppressor;
import com.qiniu.pili.droid.shortvideo.f.e;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/shortvideo/PLMicrophoneSetting.class */
public class PLMicrophoneSetting {
    private static final String AUDIO_FORMAT = "audioFormat";
    private static final String AUDIO_PTS_OPTIMIZE_ENABLE = "audioPtsOptimizeEnabled";
    private static final String AUDIO_SOURCE = "audioSource";
    private static final String BLUETOOTH_SCO_ENABLED = "bluetoothSCOEnabled";
    private static final String CHANNEL_CONFIG = "channelConfig";
    private static final String SAMPLE_RATE = "sampleRate";
    public static final String TAG = "PLMicrophoneSetting";
    private int mAudioSource = 1;
    private int mSampleRate = 44100;
    private int mChannelConfig = 16;
    private int mAudioFormat = 2;
    private boolean mBluetoothSCOEnabled = false;
    private boolean mAudioPtsOptimizeEnable = true;
    private boolean mIsNSEnabled = false;
    private boolean mIsAECEnabled = false;

    public static PLMicrophoneSetting fromJSON(JSONObject jSONObject) {
        PLMicrophoneSetting pLMicrophoneSetting = new PLMicrophoneSetting();
        pLMicrophoneSetting.setAudioSource(jSONObject.optInt(AUDIO_SOURCE, 1));
        pLMicrophoneSetting.setSampleRate(jSONObject.optInt(SAMPLE_RATE, 44100));
        pLMicrophoneSetting.setChannelConfig(jSONObject.optInt(CHANNEL_CONFIG, 16));
        pLMicrophoneSetting.setAudioFormat(jSONObject.optInt(AUDIO_FORMAT, 2));
        pLMicrophoneSetting.setBluetoothSCOEnabled(jSONObject.optBoolean(BLUETOOTH_SCO_ENABLED, false));
        pLMicrophoneSetting.setPtsOptimizeEnabled(jSONObject.optBoolean(AUDIO_PTS_OPTIMIZE_ENABLE, true));
        return pLMicrophoneSetting;
    }

    public int getAudioFormat() {
        return this.mAudioFormat;
    }

    public int getAudioSource() {
        return this.mAudioSource;
    }

    public int getChannelConfig() {
        return this.mChannelConfig;
    }

    public int getSampleRate() {
        return this.mSampleRate;
    }

    public boolean isAECEnabled() {
        return this.mIsAECEnabled;
    }

    public boolean isAudioPtsOptimizeEnabled() {
        return this.mAudioPtsOptimizeEnable;
    }

    public boolean isBluetoothSCOEnabled() {
        return this.mBluetoothSCOEnabled;
    }

    public boolean isNSEnabled() {
        return this.mIsNSEnabled;
    }

    public boolean setAECEnabled(boolean z) {
        if (!AcousticEchoCanceler.isAvailable()) {
            e.f.e(TAG, "failed to setAECEnabled, AcousticEchoCanceler not available !");
            return false;
        }
        this.mIsAECEnabled = z;
        e eVar = e.f;
        eVar.c(TAG, "setAECEnabled " + z);
        return true;
    }

    public PLMicrophoneSetting setAudioFormat(int i) {
        this.mAudioFormat = i;
        return this;
    }

    public PLMicrophoneSetting setAudioSource(int i) {
        this.mAudioSource = i;
        return this;
    }

    public PLMicrophoneSetting setBluetoothSCOEnabled(boolean z) {
        this.mBluetoothSCOEnabled = z;
        return this;
    }

    public PLMicrophoneSetting setChannelConfig(int i) {
        this.mChannelConfig = i;
        return this;
    }

    public boolean setNSEnabled(boolean z) {
        if (!NoiseSuppressor.isAvailable()) {
            e.f.e(TAG, "failed to setNSEnabled, NoiseSuppressor not available !");
            return false;
        }
        this.mIsNSEnabled = z;
        e eVar = e.f;
        eVar.c(TAG, "setNSEnabled " + z);
        return true;
    }

    public PLMicrophoneSetting setPtsOptimizeEnabled(boolean z) {
        this.mAudioPtsOptimizeEnable = z;
        return this;
    }

    public PLMicrophoneSetting setSampleRate(int i) {
        this.mSampleRate = i;
        return this;
    }

    public JSONObject toJSON() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(AUDIO_SOURCE, this.mAudioSource);
            jSONObject.put(SAMPLE_RATE, this.mSampleRate);
            jSONObject.put(CHANNEL_CONFIG, this.mChannelConfig);
            jSONObject.put(AUDIO_FORMAT, this.mAudioFormat);
            jSONObject.put(BLUETOOTH_SCO_ENABLED, this.mBluetoothSCOEnabled);
            jSONObject.put(AUDIO_PTS_OPTIMIZE_ENABLE, this.mAudioPtsOptimizeEnable);
            return jSONObject;
        } catch (JSONException e) {
            return null;
        }
    }
}
