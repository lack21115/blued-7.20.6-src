package com.qq.e.comm.pi;

import java.util.Map;

/* loaded from: source-8303388-dex2jar.jar:com/qq/e/comm/pi/AdData.class */
public interface AdData {

    /* loaded from: source-8303388-dex2jar.jar:com/qq/e/comm/pi/AdData$VideoPlayer.class */
    public interface VideoPlayer {
        int getCurrentPosition();

        int getDuration();

        int getVideoState();
    }

    boolean equalsAdData(AdData adData);

    int getAdPatternType();

    String getDesc();

    int getECPM();

    String getECPMLevel();

    Map<String, Object> getExtraInfo();

    <T> T getProperty(Class<T> cls);

    String getProperty(String str);

    String getTitle();

    int getVideoDuration();

    void setECPMLevel(String str);
}
