package com.blued.android.module.live_china.model;

import android.text.TextUtils;
import com.blued.android.framework.http.parser.BluedEntityBaseExtra;
import com.blued.android.module.common.login.model.UserBasicModel;
import com.blued.android.module.common.utils.CommonStringUtils;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import java.util.List;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/model/BluedLiveListData.class */
public class BluedLiveListData extends BluedEntityBaseExtra implements MultiItemEntity {
    public static final int SCREEN_HORIZONTAL = 1;
    public static final int SCREEN_VERTICAL = 0;
    public UserBasicModel anchor;
    public int anchor_level;
    public String anchor_tag;
    public String auth;
    public String[] badges;
    public List<BannerModel> banner_list;
    public List<BluedLiveListData> carousel;
    public String carousel_content;
    public String[] click_url;
    public String cover_box_id;
    public String cover_box_url;
    public String description;
    public String distance;
    public String end_time;
    public String event_tracking;
    public int fan_club_level;
    public String fan_club_name;
    public int fans_status;
    public String game_id;
    public String game_name;
    public boolean hasOfficialList;
    public boolean hasPKList;
    public boolean hasRedList;
    public int hb;
    public String[] hidden_url;
    public LiveHotListDiversion hot_diversion;
    public List<BluedLiveListData> hotpk_list;
    public String id;
    public String imgurl;
    public String imgurl_small;
    public int in_fan_club;
    public boolean isShowUrlVisited;
    public int is_distance;
    public int is_emperor_recommend;
    public int is_exist_na_page;
    public int is_hot;
    public int is_recommend;
    public int is_top;
    public long last_start_time;
    public String lid;
    public String liked;
    public int link_type;
    public List<LiveRecommendModel> liveRecommendModelList;
    public int liveType;
    public String live_play;
    public String live_starttime;
    public int live_type;
    public int livetype;
    public String mComeCode;
    public int notify;
    public String pic_url;
    public int pk;
    public int position;
    public int positionReal;
    public String realtime_count;
    public LiveHotListDiversion recommend_ad;
    public int recommend_type;
    public int recommended_prop;
    public String rtmp_live_urls;
    public int screen_pattern;
    public String[] show_url;
    public String sort;
    public String source;
    public String start_time;
    public String stream_id;
    public String stream_json;
    public String title;
    public String top_card;
    public String top_card_img;
    public String top_count;
    public String top_icon;
    public String type;
    public String uid;
    public String url;
    public String watch_count;
    public int weight;
    public int win_streak;

    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/model/BluedLiveListData$LINK_TYPE.class */
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

    /* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/model/BluedLiveListData$LIVE_LINK_TYPE.class */
    public interface LIVE_LINK_TYPE {
        public static final int BLIND_DATE = 4;
        public static final int CONNECTION = 3;
        public static final int GROUP = 2;
        public static final int NORMAL = 0;
        public static final int PK = 1;
        public static final int PK_DARED = 6;
        public static final int PK_MULTI = 7;
        public static final int POCKET_CARD = 8;
        public static final int POCKET_CARD_HIGH = 9;
    }

    public BluedLiveListData() {
        this.isShowUrlVisited = false;
        this.anchor = new UserBasicModel();
    }

    public BluedLiveListData(String str, UserBasicModel userBasicModel) {
        this.isShowUrlVisited = false;
        this.anchor = userBasicModel;
        this.lid = str;
    }

    @Override // com.chad.library.adapter.base.entity.MultiItemEntity
    public int getItemType() {
        return this.liveType;
    }

    public boolean isLivingForFollow() {
        UserBasicModel userBasicModel;
        return (CommonStringUtils.c(this.lid) <= 0 || (userBasicModel = this.anchor) == null || TextUtils.isEmpty(userBasicModel.uid)) ? false : true;
    }

    public boolean isPKStreamShow() {
        int i = this.win_streak;
        return i == 10 || i == 20 || i == 30 || i == 40 || i == 50 || i == 60 || i == 70 || i == 80 || i == 90 || i == 99;
    }

    public void setItemType(int i) {
        this.liveType = i;
    }
}
