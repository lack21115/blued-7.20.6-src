package com.blued.android.module.live_china.model;

import com.chad.library.adapter.base.entity.MultiItemEntity;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/model/LiverecommendListData.class */
public class LiverecommendListData implements MultiItemEntity {
    public static final int LIVE_RECOMMEND_MODEL = 0;
    public AnchorUserModel anchor;
    public int anchor_level;
    public String anchor_tag;
    public String description;
    public String game_screenshot;
    public String game_type;
    public int hb;
    public int is_emperor_recommend;
    public int is_exist_na_page;
    public int is_hot;
    public int is_recommend;
    public int is_top;
    public String lid;
    public String liked;
    public int link_type;
    public String live_play;
    public String live_type;
    public String pic_url;
    public int pk;
    public String realtime_count;
    public String screen_pattern;
    public String title;
    public String top_count;
    public String top_icon;
    public int type = 0;
    public String uid;
    public String watch_count;
    public int win_streak;

    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/model/LiverecommendListData$AnchorUserModel.class */
    public class AnchorUserModel {
        public String avatar;
        public String name;
        public String vbadge;
        public String weekstar;

        public AnchorUserModel() {
        }
    }

    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/model/LiverecommendListData$LINK_TYPE.class */
    public interface LINK_TYPE {
        public static final int BEAR = 7;
        public static final int BLIND_DATE = 3;
        public static final int FASHION = 8;
        public static final int FOLLOWER = 4;
        public static final int GROUP = 2;
        public static final int NEARBY = 5;
        public static final int NORMAL = 0;
        public static final int PK = 1;
        public static final int STRONG = 6;
    }

    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/model/LiverecommendListData$LIVE_LINK_TYPE.class */
    public interface LIVE_LINK_TYPE {
        public static final int BLIND_DATE = 4;
        public static final int CONNECTION = 3;
        public static final int GROUP = 2;
        public static final int NORMAL = 0;
        public static final int PK = 1;
        public static final int PK_DARED = 6;
    }

    public int getItemType() {
        return this.type;
    }

    public boolean isPKStreamShow() {
        int i = this.win_streak;
        return i == 10 || i == 20 || i == 30 || i == 40 || i == 50 || i == 60 || i == 70 || i == 80 || i == 90 || i == 99;
    }
}
