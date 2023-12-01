package com.blued.community.ui.video.model;

import android.text.TextUtils;

/* loaded from: source-7206380-dex2jar.jar:com/blued/community/ui/video/model/MusicCategory.class */
public class MusicCategory {
    public int classify_id;
    public String keyword;
    public String name;

    public MusicCategory(String str) {
        this.classify_id = -1;
        this.name = "";
        if (TextUtils.isEmpty(str)) {
            this.keyword = "";
        } else {
            this.keyword = str;
        }
    }

    public MusicCategory(String str, int i) {
        this.classify_id = i;
        this.name = str;
    }
}
