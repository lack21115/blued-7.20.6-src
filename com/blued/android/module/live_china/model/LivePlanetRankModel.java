package com.blued.android.module.live_china.model;

import com.chad.library.adapter.base.entity.MultiItemEntity;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/model/LivePlanetRankModel.class */
public final class LivePlanetRankModel implements MultiItemEntity, Serializable {
    private List<LivePlanetGiftModel> goods;
    private int type;
    private String num = "";
    private String name = "";
    private String avatar = "";
    private String uid = "";
    private String lid = "";
    private String energy = "";

    public final String getAvatar() {
        return this.avatar;
    }

    public final String getEnergy() {
        return this.energy;
    }

    public final List<LivePlanetGiftModel> getGoods() {
        return this.goods;
    }

    public int getItemType() {
        return this.type;
    }

    public final String getLid() {
        return this.lid;
    }

    public final String getName() {
        return this.name;
    }

    public final String getNum() {
        return this.num;
    }

    public final int getType() {
        return this.type;
    }

    public final String getUid() {
        return this.uid;
    }

    public final void setAvatar(String str) {
        Intrinsics.e(str, "<set-?>");
        this.avatar = str;
    }

    public final void setEnergy(String str) {
        Intrinsics.e(str, "<set-?>");
        this.energy = str;
    }

    public final void setGoods(List<LivePlanetGiftModel> list) {
        this.goods = list;
    }

    public final void setLid(String str) {
        Intrinsics.e(str, "<set-?>");
        this.lid = str;
    }

    public final void setName(String str) {
        Intrinsics.e(str, "<set-?>");
        this.name = str;
    }

    public final void setNum(String str) {
        Intrinsics.e(str, "<set-?>");
        this.num = str;
    }

    public final void setType(int i) {
        this.type = i;
    }

    public final void setUid(String str) {
        Intrinsics.e(str, "<set-?>");
        this.uid = str;
    }
}
