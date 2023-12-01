package com.blued.android.module.yy_china.model;

import com.chad.library.adapter.base.entity.MultiItemEntity;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/model/GiftWallInfoModel.class */
public final class GiftWallInfoModel implements MultiItemEntity {
    private YYGoodsWallListMode giftWallModel;
    private YYGoodsWallMode goodItem;
    private int type;
    private YYUserInfo us;
    private ArrayList<GiftWallInfoModel> das = new ArrayList<>();
    private String titleName = "";
    private String subTitleName = "";

    public final ArrayList<GiftWallInfoModel> getDas() {
        return this.das;
    }

    public final YYGoodsWallListMode getGiftWallModel() {
        return this.giftWallModel;
    }

    public final YYGoodsWallMode getGoodItem() {
        return this.goodItem;
    }

    @Override // com.chad.library.adapter.base.entity.MultiItemEntity
    public int getItemType() {
        return this.type;
    }

    public final String getSubTitleName() {
        return this.subTitleName;
    }

    public final String getTitleName() {
        return this.titleName;
    }

    public final int getType() {
        return this.type;
    }

    public final YYUserInfo getUs() {
        return this.us;
    }

    public final void setDas(ArrayList<GiftWallInfoModel> arrayList) {
        Intrinsics.e(arrayList, "<set-?>");
        this.das = arrayList;
    }

    public final void setGiftWallModel(YYGoodsWallListMode yYGoodsWallListMode) {
        this.giftWallModel = yYGoodsWallListMode;
    }

    public final void setGoodItem(YYGoodsWallMode yYGoodsWallMode) {
        this.goodItem = yYGoodsWallMode;
    }

    public final void setSubTitleName(String str) {
        Intrinsics.e(str, "<set-?>");
        this.subTitleName = str;
    }

    public final void setTitleName(String str) {
        Intrinsics.e(str, "<set-?>");
        this.titleName = str;
    }

    public final GiftWallInfoModel setType(int i) {
        this.type = i;
        return this;
    }

    /* renamed from: setType  reason: collision with other method in class */
    public final void m4707setType(int i) {
        this.type = i;
    }

    public final void setUs(YYUserInfo yYUserInfo) {
        this.us = yYUserInfo;
    }
}
