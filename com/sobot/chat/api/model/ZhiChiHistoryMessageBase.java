package com.sobot.chat.api.model;

import java.io.Serializable;
import java.util.List;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/api/model/ZhiChiHistoryMessageBase.class */
public class ZhiChiHistoryMessageBase implements Serializable {
    private static final long serialVersionUID = 1;
    private List<ZhiChiMessageBase> content;
    private String date;

    public List<ZhiChiMessageBase> getContent() {
        return this.content;
    }

    public String getDate() {
        return this.date;
    }

    public void setContent(List<ZhiChiMessageBase> list) {
        this.content = list;
    }

    public void setDate(String str) {
        this.date = str;
    }

    public String toString() {
        return "ZhiChiHistoryMessageBase{date='" + this.date + "', content=" + this.content + '}';
    }
}
