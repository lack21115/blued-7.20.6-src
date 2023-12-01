package com.qiniu.pili.droid.streaming;

import a.a.a.a.a.e.e;
import android.media.audiofx.AcousticEchoCanceler;
import android.os.Build;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: source-8303388-dex2jar.jar:com/qiniu/pili/droid/streaming/MicrophoneStreamingSetting.class */
public class MicrophoneStreamingSetting {

    /* renamed from: a  reason: collision with root package name */
    public boolean f14133a;

    /* renamed from: c  reason: collision with root package name */
    public boolean f14134c;
    public boolean b = true;
    public int d = 44100;
    public int e = 16;
    public int f = 4;
    public boolean g = false;
    public int h = 1;

    public boolean a() {
        return this.g;
    }

    public boolean b() {
        return this.b;
    }

    public boolean c() {
        return this.f14134c;
    }

    public int getAudioSource() {
        return this.h;
    }

    public int getChannelConfig() {
        return this.e;
    }

    public int getChannelConfigOut() {
        return this.f;
    }

    public int getReqSampleRate() {
        return this.d;
    }

    public boolean isBluetoothSCOEnabled() {
        return this.f14133a;
    }

    public boolean setAECEnabled(boolean z) {
        if (Build.VERSION.SDK_INT < 16) {
            e.g.e("MicrophoneSetting", "failed to setAECEnabled, Android version < JELLY_BEAN !");
            return false;
        } else if (!AcousticEchoCanceler.isAvailable()) {
            e.g.e("MicrophoneSetting", "failed to setAECEnabled, AcousticEchoCanceler not available !");
            return false;
        } else {
            this.g = z;
            e eVar = e.g;
            eVar.e("MicrophoneSetting", "setAECEnabled " + z);
            return true;
        }
    }

    public MicrophoneStreamingSetting setAudioPtsOptimizeEnabled(boolean z) {
        this.b = z;
        return this;
    }

    public MicrophoneStreamingSetting setAudioSource(int i) {
        this.h = i;
        return this;
    }

    public MicrophoneStreamingSetting setBluetoothSCOEnabled(boolean z) {
        this.f14133a = z;
        return this;
    }

    public MicrophoneStreamingSetting setCaptureAudioFrameOnly(boolean z) {
        this.f14134c = z;
        return this;
    }

    public MicrophoneStreamingSetting setChannelConfig(int i) {
        this.e = i;
        this.f = i == 16 ? 4 : 12;
        return this;
    }

    public MicrophoneStreamingSetting setSampleRate(int i) {
        this.d = i;
        return this;
    }

    public String toString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("SampleRate", this.d);
            jSONObject.put("Channel", this.e);
            jSONObject.put("BluetoothSCOEnabled", this.f14133a);
            jSONObject.put("AudioPtsOptimizeEnable", this.b);
            jSONObject.put("IsAECEnabled", this.g);
            return jSONObject.toString();
        } catch (JSONException e) {
            e.printStackTrace();
            return e.toString();
        }
    }
}
