package com.blued.community.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/community/model/BubbleExhibitionModel.class */
public final class BubbleExhibitionModel {
    private int height;
    private int realHeight;
    private int realWidth;
    private int width;
    private String name = "";
    private String image = "";
    private String pid = "";

    public final int getHeight() {
        return this.height;
    }

    public final String getImage() {
        return this.image;
    }

    public final String getName() {
        return this.name;
    }

    public final String getPid() {
        return this.pid;
    }

    public final int getRealHeight() {
        return this.realHeight;
    }

    public final int getRealWidth() {
        return this.realWidth;
    }

    public final int getWidth() {
        return this.width;
    }

    public final void setHeight(int i) {
        this.height = i;
    }

    public final void setImage(String str) {
        Intrinsics.e(str, "<set-?>");
        this.image = str;
    }

    public final void setName(String str) {
        Intrinsics.e(str, "<set-?>");
        this.name = str;
    }

    public final void setPid(String str) {
        Intrinsics.e(str, "<set-?>");
        this.pid = str;
    }

    public final void setRealHeight(int i) {
        this.realHeight = i;
    }

    public final void setRealWidth(int i) {
        this.realWidth = i;
    }

    public final void setWidth(int i) {
        this.width = i;
    }
}
