package com.sobot.chat.api.model;

import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/api/model/BaseListCode.class */
public class BaseListCode<T> {
    private String code;
    private List<T> data;
    private String ustatus;

    public String getCode() {
        return this.code;
    }

    public List<T> getData() {
        return this.data;
    }

    public String getUstatus() {
        return this.ustatus;
    }

    public void setCode(String str) {
        this.code = str;
    }

    public void setData(List<T> list) {
        this.data = list;
    }

    public void setUstatus(String str) {
        this.ustatus = str;
    }
}
