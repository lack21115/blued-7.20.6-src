package com.blued.android.module.common.widget.emoticon.model;

import com.blued.android.module.common.widget.emoji.manager.Emoji;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/widget/emoticon/model/EmoticonModel.class */
public class EmoticonModel {
    public String code;
    private String content;
    public Emoji emoji;
    public int emoticonType;
    public long eventType;
    public String name;
    public String name_zh;
    public String name_zh_tw;
    public String original;
    public String packageCode;
    public String packageUrl;
    public String small;
    public String url;
    public String url_original;

    public EmoticonModel() {
    }

    public EmoticonModel(long j, String str, String str2) {
        this.eventType = j;
        this.original = str;
        this.content = str2;
    }
}
