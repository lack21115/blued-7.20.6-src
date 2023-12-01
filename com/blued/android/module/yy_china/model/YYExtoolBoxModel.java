package com.blued.android.module.yy_china.model;

import com.blued.android.framework.http.parser.BluedEntityBaseExtra;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/model/YYExtoolBoxModel.class */
public class YYExtoolBoxModel extends BluedEntityBaseExtra {
    private YYExtraBubbleModel bubble_message;
    private int is_show_Invite_button;
    private int is_show_share_button;

    public YYExtraBubbleModel getBubble_message() {
        return this.bubble_message;
    }

    public int getIs_show_Invite_button() {
        return this.is_show_Invite_button;
    }

    public int getIs_show_share_button() {
        return this.is_show_share_button;
    }

    public void setBubble_message(YYExtraBubbleModel yYExtraBubbleModel) {
        this.bubble_message = yYExtraBubbleModel;
    }

    public void setIs_show_Invite_button(int i) {
        this.is_show_Invite_button = i;
    }

    public void setIs_show_share_button(int i) {
        this.is_show_share_button = i;
    }
}
