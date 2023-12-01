package com.sobot.chat.listener;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/listener/SobotFunctionType.class */
public enum SobotFunctionType {
    ZC_CloseLeave(1),
    ZC_CloseChat(2),
    ZC_CloseHelpCenter(3),
    ZC_CloseChatList(4),
    ZC_PhoneCustomerService(5);
    
    private int typeNum;

    SobotFunctionType(int i) {
        this.typeNum = i;
    }

    @Override // java.lang.Enum
    public String toString() {
        return "SobotFunctionEnum{typeNum=" + this.typeNum + '}';
    }
}
