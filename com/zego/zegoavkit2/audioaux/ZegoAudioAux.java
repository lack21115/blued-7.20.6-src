package com.zego.zegoavkit2.audioaux;

import com.zego.zegoavkit2.audioaux.ZegoAudioAuxJNI;
import com.zego.zegoavkit2.entities.AuxDataEx;

/* loaded from: source-8829756-dex2jar.jar:com/zego/zegoavkit2/audioaux/ZegoAudioAux.class */
public class ZegoAudioAux implements ZegoAudioAuxJNI.IJniZegoAuxCallback {
    private IZegoAudioAuxCallbackEx mZegoAudioAuxCallbackEx = null;

    public boolean enableAux(boolean z) {
        return ZegoAudioAuxJNI.enableAux(z);
    }

    public boolean muteAux(boolean z) {
        return ZegoAudioAuxJNI.muteAux(z);
    }

    @Override // com.zego.zegoavkit2.audioaux.ZegoAudioAuxJNI.IJniZegoAuxCallback
    public AuxDataEx onAuxCallback(int i) {
        IZegoAudioAuxCallbackEx iZegoAudioAuxCallbackEx = this.mZegoAudioAuxCallbackEx;
        if (iZegoAudioAuxCallbackEx != null) {
            return iZegoAudioAuxCallbackEx.onAuxCallback(i);
        }
        return null;
    }

    public void setAuxPlayVolume(int i) {
        ZegoAudioAuxJNI.setAuxPlayVolume(i);
    }

    public void setAuxPublishVolume(int i) {
        ZegoAudioAuxJNI.setAuxPublishVolume(i);
    }

    public void setAuxVolume(int i) {
        ZegoAudioAuxJNI.setAuxVolume(i);
    }

    public void setZegoAuxCallbackEx(IZegoAudioAuxCallbackEx iZegoAudioAuxCallbackEx) {
        this.mZegoAudioAuxCallbackEx = iZegoAudioAuxCallbackEx;
        if (iZegoAudioAuxCallbackEx != null) {
            ZegoAudioAuxJNI.setCallback(this);
        } else {
            ZegoAudioAuxJNI.setCallback(null);
        }
    }
}
