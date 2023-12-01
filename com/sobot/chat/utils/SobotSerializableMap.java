package com.sobot.chat.utils;

import java.io.Serializable;
import java.util.LinkedHashMap;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/utils/SobotSerializableMap.class */
public class SobotSerializableMap implements Serializable {
    private LinkedHashMap map;

    public LinkedHashMap getMap() {
        return this.map;
    }

    public void setMap(LinkedHashMap linkedHashMap) {
        this.map = linkedHashMap;
    }
}
