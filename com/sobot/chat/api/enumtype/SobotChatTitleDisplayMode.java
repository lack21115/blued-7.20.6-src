package com.sobot.chat.api.enumtype;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/api/enumtype/SobotChatTitleDisplayMode.class */
public enum SobotChatTitleDisplayMode {
    Default(0),
    ShowFixedText(1),
    ShowCompanyName(2);
    
    private int value;

    SobotChatTitleDisplayMode(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
