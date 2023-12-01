package com.sobot.chat.widget.emoji;

/* loaded from: source-8303388-dex2jar.jar:com/sobot/chat/widget/emoji/Emojicon.class */
public class Emojicon {
    private final String emojiStr;
    private final String remote;
    private final int resId;
    private final String resName;
    private final int value;

    public Emojicon(String str, int i, String str2, String str3, int i2) {
        this.resName = str;
        this.value = i;
        this.emojiStr = str2;
        this.remote = str3;
        this.resId = i2;
    }

    public String getEmojiStr() {
        return this.emojiStr;
    }

    public String getRemote() {
        return this.remote;
    }

    public int getResId() {
        return this.resId;
    }

    public String getResName() {
        return this.resName;
    }

    public int getValue() {
        return this.value;
    }
}
