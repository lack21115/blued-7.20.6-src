package com.blued.community.ui.send.model;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/community/ui/send/model/FeedIntroduceModel.class */
public final class FeedIntroduceModel implements Serializable {
    private String describe = "";
    private int id;
    private String sort;

    public final String getDescribe() {
        return this.describe;
    }

    public final int getId() {
        return this.id;
    }

    public final String getSort() {
        return this.sort;
    }

    public final void setDescribe(String str) {
        Intrinsics.e(str, "<set-?>");
        this.describe = str;
    }

    public final void setId(int i) {
        this.id = i;
    }

    public final void setSort(String str) {
        this.sort = str;
    }
}
