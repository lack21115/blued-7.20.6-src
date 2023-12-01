package com.sobot.chat.api.enumtype;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/api/enumtype/SobotChatAvatarDisplayMode.class */
public enum SobotChatAvatarDisplayMode {
    Default(0),
    ShowFixedAvatar(1),
    ShowCompanyAvatar(2);
    
    private int value;

    SobotChatAvatarDisplayMode(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
