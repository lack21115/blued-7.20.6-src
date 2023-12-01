package com.sobot.chat.widget.lablesview;

import java.io.Serializable;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/widget/lablesview/SobotLablesViewModel.class */
public class SobotLablesViewModel implements Serializable {
    private String anchor;
    private Object data;
    private String title;

    public String getAnchor() {
        return this.anchor;
    }

    public Object getData() {
        return this.data;
    }

    public String getTitle() {
        return this.title;
    }

    public void setAnchor(String str) {
        this.anchor = str;
    }

    public void setData(Object obj) {
        this.data = obj;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public String toString() {
        return "SobotLablesViewModel{title='" + this.title + "', anchor='" + this.anchor + "'}";
    }
}
