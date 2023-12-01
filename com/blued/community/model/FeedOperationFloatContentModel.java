package com.blued.community.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/community/model/FeedOperationFloatContentModel.class */
public final class FeedOperationFloatContentModel {
    private String img = "";
    private String title = "";
    private String subtitle = "";
    private String button = "";

    public final String getButton() {
        return this.button;
    }

    public final String getImg() {
        return this.img;
    }

    public final String getSubtitle() {
        return this.subtitle;
    }

    public final String getTitle() {
        return this.title;
    }

    public final void setButton(String str) {
        Intrinsics.e(str, "<set-?>");
        this.button = str;
    }

    public final void setImg(String str) {
        Intrinsics.e(str, "<set-?>");
        this.img = str;
    }

    public final void setSubtitle(String str) {
        Intrinsics.e(str, "<set-?>");
        this.subtitle = str;
    }

    public final void setTitle(String str) {
        Intrinsics.e(str, "<set-?>");
        this.title = str;
    }
}
