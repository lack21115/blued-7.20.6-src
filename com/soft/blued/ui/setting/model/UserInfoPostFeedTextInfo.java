package com.soft.blued.ui.setting.model;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/setting/model/UserInfoPostFeedTextInfo.class */
public final class UserInfoPostFeedTextInfo {
    private float arrayItemHeight;
    public float[] arrayItemWidth;
    public float[] arrayTextWidth;
    private int bgColor;
    private float itemBigCorner;
    private float itemLittleCorner;
    private float itemOriginBigCorner;
    private float itemOriginLittleCorner;
    private float leftRightMargin;
    private int line;
    private float originLeftRightMargin;
    private float originTopBottomMargin;
    private float realTextSize;
    private int sort;
    private float topBottomMargin;
    private float factor = 1.0f;
    private final ArrayList<ArrayList<UserInfoPostFeedItemLayoutInfo>> layoutInfo = new ArrayList<>();
    private final ArrayList<String> contentList = new ArrayList<>();

    public final float getArrayItemHeight() {
        return this.arrayItemHeight;
    }

    public final float[] getArrayItemWidth() {
        float[] fArr = this.arrayItemWidth;
        if (fArr != null) {
            return fArr;
        }
        Intrinsics.c("arrayItemWidth");
        return null;
    }

    public final float[] getArrayTextWidth() {
        float[] fArr = this.arrayTextWidth;
        if (fArr != null) {
            return fArr;
        }
        Intrinsics.c("arrayTextWidth");
        return null;
    }

    public final int getBgColor() {
        return this.bgColor;
    }

    public final ArrayList<String> getContentList() {
        return this.contentList;
    }

    public final float getFactor() {
        return this.factor;
    }

    public final float getItemBigCorner() {
        return this.itemBigCorner;
    }

    public final float getItemLittleCorner() {
        return this.itemLittleCorner;
    }

    public final float getItemOriginBigCorner() {
        return this.itemOriginBigCorner;
    }

    public final float getItemOriginLittleCorner() {
        return this.itemOriginLittleCorner;
    }

    public final ArrayList<ArrayList<UserInfoPostFeedItemLayoutInfo>> getLayoutInfo() {
        return this.layoutInfo;
    }

    public final float getLeftRightMargin() {
        return this.leftRightMargin;
    }

    public final int getLine() {
        return this.line;
    }

    public final float getOriginLeftRightMargin() {
        return this.originLeftRightMargin;
    }

    public final float getOriginTopBottomMargin() {
        return this.originTopBottomMargin;
    }

    public final float getRealTextSize() {
        return this.realTextSize;
    }

    public final int getSort() {
        return this.sort;
    }

    public final float getTopBottomMargin() {
        return this.topBottomMargin;
    }

    public final void setArrayItemHeight(float f) {
        this.arrayItemHeight = f;
    }

    public final void setArrayItemWidth(float[] fArr) {
        Intrinsics.e(fArr, "<set-?>");
        this.arrayItemWidth = fArr;
    }

    public final void setArrayTextWidth(float[] fArr) {
        Intrinsics.e(fArr, "<set-?>");
        this.arrayTextWidth = fArr;
    }

    public final void setBgColor(int i) {
        this.bgColor = i;
    }

    public final void setFactor(float f) {
        this.factor = f;
    }

    public final void setItemBigCorner(float f) {
        this.itemBigCorner = f;
    }

    public final void setItemLittleCorner(float f) {
        this.itemLittleCorner = f;
    }

    public final void setItemOriginBigCorner(float f) {
        this.itemOriginBigCorner = f;
    }

    public final void setItemOriginLittleCorner(float f) {
        this.itemOriginLittleCorner = f;
    }

    public final void setLeftRightMargin(float f) {
        this.leftRightMargin = f;
    }

    public final void setLine(int i) {
        this.line = i;
    }

    public final void setOriginLeftRightMargin(float f) {
        this.originLeftRightMargin = f;
    }

    public final void setOriginTopBottomMargin(float f) {
        this.originTopBottomMargin = f;
    }

    public final void setRealTextSize(float f) {
        this.realTextSize = f;
    }

    public final void setSort(int i) {
        this.sort = i;
    }

    public final void setTopBottomMargin(float f) {
        this.topBottomMargin = f;
    }
}
