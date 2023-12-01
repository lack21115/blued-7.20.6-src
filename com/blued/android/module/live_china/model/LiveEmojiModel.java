package com.blued.android.module.live_china.model;

import java.io.Serializable;
import kotlin.Metadata;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/model/LiveEmojiModel.class */
public final class LiveEmojiModel implements Serializable {
    private int emoji_h;
    private String emoji_id;
    private String emoji_url;
    private int emoji_w;

    public final int getEmoji_h() {
        return this.emoji_h;
    }

    public final String getEmoji_id() {
        return this.emoji_id;
    }

    public final String getEmoji_url() {
        return this.emoji_url;
    }

    public final int getEmoji_w() {
        return this.emoji_w;
    }

    public final void setEmoji_h(int i) {
        this.emoji_h = i;
    }

    public final void setEmoji_id(String str) {
        this.emoji_id = str;
    }

    public final void setEmoji_url(String str) {
        this.emoji_url = str;
    }

    public final void setEmoji_w(int i) {
        this.emoji_w = i;
    }
}
