package com.soft.blued.ui.mine.model;

import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/mine/model/SuperExposureModel.class */
public class SuperExposureModel {
    public int buy_limited;
    public SuperExposureFeedModel feed;
    public int is_limit;
    public List<SuperExposurePayItemModel> list;
    public List<FireBag> pack_list;
    public SuperExposureUserModel user;

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/mine/model/SuperExposureModel$FireBag.class */
    public class FireBag {
        public int average_beans;
        public float average_price;
        public int buy_num;
        public String discount;
        public int id;
        public int is_recommend;
        public int total_beans;
        public int total_price;
        public String unit;

        public FireBag() {
        }
    }
}
