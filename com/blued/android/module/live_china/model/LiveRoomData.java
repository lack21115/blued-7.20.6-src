package com.blued.android.module.live_china.model;

import com.blued.android.chat.data.BadgeData;
import com.blued.android.module.common.utils.ReflectionUtils;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/model/LiveRoomData.class */
public class LiveRoomData implements Serializable {
    private static final long serialVersionUID = 1;
    public List<LiveActivityItemModel> activity;
    public String anchor_liang_id;
    public int anchor_liang_type;
    public int anchor_rich_level;
    public String avatar_frame;
    public List<BadgeData> badges;
    public double beans_count;
    public double beans_current_count;
    public int can_kick;
    public int can_mute;
    public String comeCode;
    public String conference_id;
    public long count;
    public DefinedRankInfo custom_rank;
    public String description;
    public String details;
    public long dynamic_goods_icon_countdown;
    public LiveRoomEntranceData effects;
    public long elapse_time;
    public LiveRoomWishingWellData entrance_extra;
    public String entrance_icon;
    public int entrance_status;
    public String entrance_url;
    public LiveFriendModel friends_line;
    public String gap_exp;
    public Map<String, Integer> giftBad_red_point;
    public LiveGiftWallFloatModel goods_wall;
    public boolean hasTransition;
    public String icon;
    public boolean isFollow;
    public boolean isShowHourRank;
    public int is_first;
    public int is_manager;
    public List<LiveBunchLightResponseModel> lantern;
    public LiveLayoutSetting layout_setting;
    public int level;
    public String liang_id;
    public int liang_type;
    public long lid;
    public LiveRoomLineModel line;
    public LiveInviteUpdateModel link_multi_line;
    public int link_type;
    public String liveFrom;
    public String liveFromInfo;
    public LiveOneKissModel liveOneKissModel;
    public int livePosition;
    public int liveProp;
    public LiveAnnounceInfoModel live_notice;
    public int live_quic;
    public int live_type;
    public String live_url;
    public LiveMakeLoverModel matchmaking;
    public LiveInviteUpdateModel multi_pk_info;
    public String nameplate_img;
    public int nameplate_img_height;
    public int nameplate_img_width;
    public int next_level;
    public int noble_config;
    public String noble_join_text;
    public int noble_level;
    public String note_type;
    public float percent;
    public LiveRoomPkModel pk;
    public LiveRoomAnchorModel profile;
    public String publish_url;
    public long rank;
    public RankingExtra rankingExtra;
    public RankingHourExtra rankingHourExtra;
    public int rechargeGiftBagIconShowType;
    public LiveRecordRecommendModel recommend;
    public String recommendType;
    public LivePropCardModel recommend_prop_info;
    public Map<String, String> red_point;
    public String relationship;
    public int screen_pattern;
    public boolean shout_card_audit_status;
    public String stream;
    public int stream_level;
    public String token;
    public String vip_frame;
    public int vip_level;
    public LiveRecordLevelStickerModel watermark;
    public List<LiveWishItemModel> wishList;
    public LiveWishingDrawModel wishing_well;

    public LiveRoomData() {
        this.isShowHourRank = false;
        this.rechargeGiftBagIconShowType = 0;
        this.comeCode = "";
        this.liveProp = 0;
        this.hasTransition = true;
        this.profile = new LiveRoomAnchorModel();
    }

    public LiveRoomData(long j, int i, String str, String str2, String str3, String str4, int i2) {
        this.isShowHourRank = false;
        this.rechargeGiftBagIconShowType = 0;
        this.comeCode = "";
        this.liveProp = 0;
        this.hasTransition = true;
        this.lid = j;
        this.screen_pattern = i;
        this.comeCode = str;
        this.profile = new LiveRoomAnchorModel(str2, str3, str4, i2);
    }

    public void copyModel(LiveRoomData liveRoomData) {
        ReflectionUtils.a(liveRoomData, this);
    }

    public void reset() {
        ReflectionUtils.a(new LiveRoomData(), this);
    }
}
