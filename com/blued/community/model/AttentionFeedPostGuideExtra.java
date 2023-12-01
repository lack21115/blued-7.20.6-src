package com.blued.community.model;

import com.blued.android.framework.http.parser.BluedEntityBaseExtra;
import kotlin.Metadata;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/community/model/AttentionFeedPostGuideExtra.class */
public final class AttentionFeedPostGuideExtra extends BluedEntityBaseExtra {
    private String last_date;
    private int return_num;

    public final String getLast_date() {
        return this.last_date;
    }

    public final int getReturn_num() {
        return this.return_num;
    }

    public final void setLast_date(String str) {
        this.last_date = str;
    }

    public final void setReturn_num(int i) {
        this.return_num = i;
    }
}
