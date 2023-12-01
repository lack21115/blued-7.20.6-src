package com.zego.zegoavkit2.mixstream;

/* loaded from: source-8829756-dex2jar.jar:com/zego/zegoavkit2/mixstream/ZegoStreamMixer.class */
public class ZegoStreamMixer {
    public static final String NON_EXIST_STREAM_ID_KEY = "NonExists";
    public static final String SEQ_KEY = "ReqSeq";

    public boolean mixStream(ZegoCompleteMixStreamInfo zegoCompleteMixStreamInfo, int i) {
        return ZegoMixStreamJNI.mixStream(zegoCompleteMixStreamInfo, i);
    }

    public int mixStreamEx(ZegoMixStreamConfig zegoMixStreamConfig, String str) {
        if (str.length() == 0) {
            return -1;
        }
        if (zegoMixStreamConfig.inputStreamList != null && zegoMixStreamConfig.inputStreamList.length > 0) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= zegoMixStreamConfig.inputStreamList.length) {
                    break;
                }
                ZegoMixStreamInfo zegoMixStreamInfo = zegoMixStreamConfig.inputStreamList[i2];
                if (zegoMixStreamInfo == null || zegoMixStreamInfo.streamID == null || zegoMixStreamInfo.streamID.length() < 1 || zegoMixStreamInfo.streamID.length() > 512) {
                    return -1;
                }
                i = i2 + 1;
            }
        }
        if (zegoMixStreamConfig.outputList != null && zegoMixStreamConfig.outputList.length > 0) {
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 >= zegoMixStreamConfig.outputList.length) {
                    break;
                }
                ZegoMixStreamOutput zegoMixStreamOutput = zegoMixStreamConfig.outputList[i4];
                if (zegoMixStreamOutput == null || zegoMixStreamOutput.target == null || zegoMixStreamOutput.target.length() < 1 || zegoMixStreamOutput.target.length() >= 1024) {
                    return -1;
                }
                i3 = i4 + 1;
            }
        }
        if (zegoMixStreamConfig.outputRateControlMode != 1 || (zegoMixStreamConfig.outputQuality >= 1 && zegoMixStreamConfig.outputQuality <= 51)) {
            return ZegoMixStreamJNI.mixStreamEx(zegoMixStreamConfig, str);
        }
        return -1;
    }

    public void setCallback(IZegoMixStreamCallback iZegoMixStreamCallback) {
        ZegoMixStreamJNI.setCallback(iZegoMixStreamCallback);
    }

    public void setMixStreamExCallback(IZegoMixStreamExCallback iZegoMixStreamExCallback) {
        ZegoMixStreamJNI.setMixStreamExCallback(iZegoMixStreamExCallback);
    }

    public void setRelayCDNStateCallback(IZegoMixStreamRelayCDNCallback iZegoMixStreamRelayCDNCallback) {
        ZegoMixStreamJNI.setRelayCDNCallback(iZegoMixStreamRelayCDNCallback);
    }

    public void setSoundLevelInMixStreamCallback(IZegoSoundLevelInMixStreamCallback iZegoSoundLevelInMixStreamCallback) {
        ZegoMixStreamJNI.setSoundLevelInMixStreamCallback(iZegoSoundLevelInMixStreamCallback);
    }
}
