package com.blued.android.module.live_china.model;

import java.io.Serializable;
import kotlin.Metadata;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/model/LiveChatBadgeModel.class */
public final class LiveChatBadgeModel implements Serializable {
    private String chat_badge_url = "";
    private Integer chat_badge_length = 0;
    private Integer chat_badge_height = 0;

    public final Integer getChat_badge_height() {
        return this.chat_badge_height;
    }

    public final Integer getChat_badge_length() {
        return this.chat_badge_length;
    }

    public final String getChat_badge_url() {
        return this.chat_badge_url;
    }

    public final void setChat_badge_height(Integer num) {
        this.chat_badge_height = num;
    }

    public final void setChat_badge_length(Integer num) {
        this.chat_badge_length = num;
    }

    public final void setChat_badge_url(String str) {
        this.chat_badge_url = str;
    }
}
