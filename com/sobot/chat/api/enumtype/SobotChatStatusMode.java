package com.sobot.chat.api.enumtype;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/api/enumtype/SobotChatStatusMode.class */
public enum SobotChatStatusMode {
    ZCServerConnectOffline(0),
    ZCServerConnectRobot(1),
    ZCServerConnectArtificial(2),
    ZCServerConnectWaiting(3);
    
    private int value;

    SobotChatStatusMode(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
