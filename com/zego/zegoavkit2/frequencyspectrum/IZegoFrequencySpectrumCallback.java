package com.zego.zegoavkit2.frequencyspectrum;

/* loaded from: source-8829756-dex2jar.jar:com/zego/zegoavkit2/frequencyspectrum/IZegoFrequencySpectrumCallback.class */
public interface IZegoFrequencySpectrumCallback {
    void onCaptureFrequencySpectrumUpdate(ZegoFrequencySpectrumInfo zegoFrequencySpectrumInfo);

    void onFrequencySpectrumUpdate(ZegoFrequencySpectrumInfo[] zegoFrequencySpectrumInfoArr);
}
