package com.sobot.chat.api.model;

import java.io.Serializable;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/api/model/SobotUserTicketInfoFlag.class */
public class SobotUserTicketInfoFlag implements Serializable {
    private String code;
    private boolean existFlag;
    private String msg;

    public String getCode() {
        return this.code;
    }

    public String getMsg() {
        return this.msg;
    }

    public boolean isExistFlag() {
        return this.existFlag;
    }

    public void setCode(String str) {
        this.code = str;
    }

    public void setExistFlag(boolean z) {
        this.existFlag = z;
    }

    public void setMsg(String str) {
        this.msg = str;
    }
}
