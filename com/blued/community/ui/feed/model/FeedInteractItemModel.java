package com.blued.community.ui.feed.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/community/ui/feed/model/FeedInteractItemModel.class */
public final class FeedInteractItemModel {
    private int id;
    private String drawableRes = "";
    private String name = "";

    public final String getDrawableRes() {
        return this.drawableRes;
    }

    public final int getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

    public final void setDrawableRes(String str) {
        Intrinsics.e(str, "<set-?>");
        this.drawableRes = str;
    }

    public final void setId(int i) {
        this.id = i;
    }

    public final void setName(String str) {
        Intrinsics.e(str, "<set-?>");
        this.name = str;
    }
}
