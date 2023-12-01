package com.soft.blued.ui.live.model;

import com.blued.android.module.common.login.model.UserBasicModel;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/live/model/RequestAnchorLiveModel.class */
public class RequestAnchorLiveModel extends UserBasicModel {
    public int count;
    public RequestLiveRewardGoodsInfo goods_info;
    public int rich_level;
    public int status;
    public long time;

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/live/model/RequestAnchorLiveModel$RequestLiveRewardGoodsInfo.class */
    public class RequestLiveRewardGoodsInfo {
        public String goods_id;
        public String image_static;

        public RequestLiveRewardGoodsInfo() {
        }
    }
}
