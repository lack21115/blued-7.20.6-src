package com.blued.community.ui.send.model;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/community/ui/send/model/FeedTemplateTitleModel.class */
public final class FeedTemplateTitleModel implements Serializable {
    private int p_id;
    private String sort;
    private String text = "";

    public final int getP_id() {
        return this.p_id;
    }

    public final String getSort() {
        return this.sort;
    }

    public final String getText() {
        return this.text;
    }

    public final void setP_id(int i) {
        this.p_id = i;
    }

    public final void setSort(String str) {
        this.sort = str;
    }

    public final void setText(String str) {
        Intrinsics.e(str, "<set-?>");
        this.text = str;
    }
}
