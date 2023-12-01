package com.soft.blued.ui.setting.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/setting/model/UserInfoPostFeedItemLayoutInfo.class */
public final class UserInfoPostFeedItemLayoutInfo {
    private float arrayDivider;
    private String content = "";
    private float height;
    private float startX;
    private float startY;
    private float width;

    public final float getArrayDivider() {
        return this.arrayDivider;
    }

    public final String getContent() {
        return this.content;
    }

    public final float getHeight() {
        return this.height;
    }

    public final float getStartX() {
        return this.startX;
    }

    public final float getStartY() {
        return this.startY;
    }

    public final float getWidth() {
        return this.width;
    }

    public final void setArrayDivider(float f) {
        this.arrayDivider = f;
    }

    public final void setContent(String str) {
        Intrinsics.e(str, "<set-?>");
        this.content = str;
    }

    public final void setHeight(float f) {
        this.height = f;
    }

    public final void setStartX(float f) {
        this.startX = f;
    }

    public final void setStartY(float f) {
        this.startY = f;
    }

    public final void setWidth(float f) {
        this.width = f;
    }
}
