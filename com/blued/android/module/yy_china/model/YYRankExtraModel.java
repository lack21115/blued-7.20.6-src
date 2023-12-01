package com.blued.android.module.yy_china.model;

import com.blued.android.framework.http.parser.BluedEntityBaseExtra;
import kotlin.Metadata;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/model/YYRankExtraModel.class */
public final class YYRankExtraModel extends BluedEntityBaseExtra {
    private String avatar;
    private String name;
    private String score;
    private String sort;

    public final String getAvatar() {
        return this.avatar;
    }

    public final String getName() {
        return this.name;
    }

    public final String getScore() {
        return this.score;
    }

    public final String getSort() {
        return this.sort;
    }

    public final void setAvatar(String str) {
        this.avatar = str;
    }

    public final void setName(String str) {
        this.name = str;
    }

    public final void setScore(String str) {
        this.score = str;
    }

    public final void setSort(String str) {
        this.sort = str;
    }
}
