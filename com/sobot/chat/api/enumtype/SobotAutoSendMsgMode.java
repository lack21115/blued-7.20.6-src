package com.sobot.chat.api.enumtype;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/api/enumtype/SobotAutoSendMsgMode.class */
public enum SobotAutoSendMsgMode {
    Default(0),
    SendToRobot(1),
    SendToOperator(2),
    SendToAll(3);
    
    private int auto_send_msgtype;
    private String content;
    private boolean isEveryTimeAutoSend = false;
    private int value;
    public static int ZCMessageTypeText = 0;
    public static int ZCMessageTypePhoto = 1;
    public static int ZCMessageTypeFile = 12;
    public static int ZCMessageTypeVideo = 23;

    SobotAutoSendMsgMode(int i) {
        this.value = i;
    }

    public boolean geIsEveryTimeAutoSend() {
        return this.isEveryTimeAutoSend;
    }

    public int getAuto_send_msgtype() {
        return this.auto_send_msgtype;
    }

    public String getContent() {
        return this.content;
    }

    public int getValue() {
        return this.value;
    }

    public SobotAutoSendMsgMode setAuto_send_msgtype(int i) {
        this.auto_send_msgtype = i;
        return this;
    }

    public SobotAutoSendMsgMode setContent(String str) {
        this.content = str;
        return this;
    }

    public SobotAutoSendMsgMode setIsEveryTimeAutoSend(boolean z) {
        this.isEveryTimeAutoSend = z;
        return this;
    }
}
