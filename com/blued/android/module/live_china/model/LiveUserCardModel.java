package com.blued.android.module.live_china.model;

import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/model/LiveUserCardModel.class */
public final class LiveUserCardModel implements Serializable {
    private LiveUserCardBadgeModel badge;
    private LiveUserCardGoodsModel goods;
    private LiveUserCardGreatModel great_friends;
    private List<LiveUserCardMouleModel> module;
    private LiveUserCardResourceModel resource;
    private LiveRoomUserModel user;

    public final LiveUserCardBadgeModel getBadge() {
        return this.badge;
    }

    public final LiveUserCardGoodsModel getGoods() {
        return this.goods;
    }

    public final LiveUserCardGreatModel getGreat_friends() {
        return this.great_friends;
    }

    public final List<LiveUserCardMouleModel> getModule() {
        return this.module;
    }

    public final LiveUserCardResourceModel getResource() {
        return this.resource;
    }

    public final LiveRoomUserModel getUser() {
        return this.user;
    }

    public final void setBadge(LiveUserCardBadgeModel liveUserCardBadgeModel) {
        this.badge = liveUserCardBadgeModel;
    }

    public final void setGoods(LiveUserCardGoodsModel liveUserCardGoodsModel) {
        this.goods = liveUserCardGoodsModel;
    }

    public final void setGreat_friends(LiveUserCardGreatModel liveUserCardGreatModel) {
        this.great_friends = liveUserCardGreatModel;
    }

    public final void setModule(List<LiveUserCardMouleModel> list) {
        this.module = list;
    }

    public final void setResource(LiveUserCardResourceModel liveUserCardResourceModel) {
        this.resource = liveUserCardResourceModel;
    }

    public final void setUser(LiveRoomUserModel liveRoomUserModel) {
        this.user = liveRoomUserModel;
    }
}
