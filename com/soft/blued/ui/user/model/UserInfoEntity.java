package com.soft.blued.ui.user.model;

import com.blued.android.core.BlueAppLocal;
import com.blued.android.module.common.group.GroupInfoModel;
import com.blued.android.module.common.login.model.BluedADExtra;
import com.blued.android.module.common.login.model.UserBasicModel;
import com.blued.android.module.common.user.model.AuditingProfileModel;
import com.blued.android.module.common.user.model.BluedAlbum;
import com.blued.android.module.common.user.model.UserRestrictedDescModel;
import com.blued.android.module.common.user.model.UserTagAll;
import com.blued.android.module.common.user.model.VerifyStatus;
import com.blued.android.module.common.utils.DistanceUtils;
import com.blued.android.module.live_china.model.AnchorMedal;
import com.blued.community.ui.event.model.EventDetailsModel;
import com.blued.community.ui.send.model.FeedPostSignStateItem;
import java.io.Serializable;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/model/UserInfoEntity.class */
public class UserInfoEntity extends UserBasicModel implements Serializable {
    public int access_private_photos;
    public List<EventDetailsModel> activity_list;
    public _ads_activity ads_activity;
    public List<BluedADExtra> ads_banner;
    public List<BluedAlbum> album;
    public int allow_active;
    public int anchor;
    public int anchor_level;
    public String anchor_level_icon;
    public int anchor_sing_type;
    public _anchor_type anchor_type;
    public AuditingProfileModel auditing_profile;
    public String avatar_frame;
    public int avatar_frame_type;
    public String background_photo;
    public int background_photo_auditing;
    public List<AnchorMedal> badge;
    public String beans;
    public FeedPostSignStateItem bubble;
    public String collection_enter_url;
    public String credit_score;
    public String dirty_notice;
    public List<GroupInfoModel> fans_group;
    public String game_description;
    public String game_url;
    public int groups_count;
    public String groups_label;
    public String health_prpe_use_situation;
    public int health_test_info_show;
    public String health_test_result;
    public String health_test_time;
    public int history;
    public String ip_location;
    public int is_anchor;
    public int is_manager;
    public int is_show_collection_enter;
    public String kol_name;
    public String live;
    public _live livelist;
    public _liveshow liveshow;
    public _match_activity match_activity;
    public List<GroupInfoModel> mine_group;
    public String nickname_limit;
    public int personal_display;
    public int poke_days;
    public int privacy_photos_has_locked;
    public String recommendation;
    public int registration_time;
    public String registration_time_encrypt;
    public UserRestrictedDescModel restricted_desc;
    public int rich_level;
    public int secretly_followed_status;
    public int show_groups;
    public int stealth_status;
    public UserTagAll tags;
    public String ticktock_count;
    public int users_face;
    public int vbadge_hide_profile;
    public VerifyStatus[] verify;
    public List<BluedAlbum> vip_avatars;
    public String vip_url;
    public String visit_increase;
    public VoiceBroadcast voice_broadcast;
    public String status = "";
    public String education = "";
    public String last_offline = "";
    public String hometown = "";
    public String city_settled = "";
    public String ilike = "";
    public String birthday = "";
    public String astro = "";
    public String blood_type = "";
    public String weibo = "";
    public String industry = "";
    public String chinese_zodiac = "";
    public String last_login = "";
    public String qq = "";
    public String ihate = "";
    public String weixin = "";
    public String province = "";
    public String in_blacklist = "";
    public String red_ribbon = "";
    public String red_ribbon_link = "";
    public String followed_count = "";
    public String followers_count = "";
    public String my_ticktocks_count = "";
    public String is_access_groups = "";
    public String is_access_follows = "";
    public String is_access_followers = "";
    public String black_count = "";
    public String black_allowed_count = "";
    public String ethnicity = "";
    public String friends_count = "";
    public String avatar_pid = "";
    public String mate = "";
    public int is_locked = 0;
    public int avatar_audited = -1;
    public int is_audited = -1;

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/model/UserInfoEntity$CityKeys.class */
    public class CityKeys {
        public String name = "";
        public String longitude = "";
        public String latitude = "";

        public CityKeys() {
        }
    }

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/model/UserInfoEntity$VoiceBroadcast.class */
    public class VoiceBroadcast {
        public String room_id;
        public String room_name;
        public String room_type;
        public String uid;

        public VoiceBroadcast() {
        }
    }

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/model/UserInfoEntity$_ads_activity.class */
    public class _ads_activity extends BluedADExtra {
        public String title;

        public _ads_activity() {
        }
    }

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/model/UserInfoEntity$_anchor_type.class */
    public class _anchor_type {
        public int aid;
        public String name;

        public _anchor_type() {
        }
    }

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/model/UserInfoEntity$_fans.class */
    public class _fans {
        public String pic;
        public String sort;
        public String vbadge;

        public _fans() {
        }
    }

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/model/UserInfoEntity$_live.class */
    public class _live {
        public _fans[] consume_list;
        public int livetop;
        public _rich_list rich_list;
        public long total_beans;
        public long week_totaltime;

        public _live() {
        }
    }

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/model/UserInfoEntity$_liveshow.class */
    public class _liveshow {
        public Long session_id;
        public Short session_type;
        public String description = "";
        public String start_time = "";
        public String avatar = "";
        public int liked = 0;
        public int realtime_count = 0;
        public int watch_count = 0;

        public _liveshow() {
        }
    }

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/model/UserInfoEntity$_match_activity.class */
    public class _match_activity {
        public String[] click_url;
        public String icon;
        public String match_activity_text;
        public String[] show_url;
        public String url;

        public _match_activity() {
        }
    }

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/model/UserInfoEntity$_rich_list.class */
    public class _rich_list {
        public int all;
        public int day;
        public int week;

        public _rich_list() {
        }
    }

    public UserInfoEntity() {
    }

    public UserInfoEntity(UserBasicModel userBasicModel) {
        if (userBasicModel == null) {
            return;
        }
        this.uid = userBasicModel.uid;
        this.email = userBasicModel.email;
        this.name = userBasicModel.name;
        this.height = userBasicModel.height;
        this.weight = userBasicModel.weight;
        this.last_operate = userBasicModel.last_operate;
        this.location = DistanceUtils.a(userBasicModel.distance, BlueAppLocal.c(), true);
        this.avatar = userBasicModel.avatar;
        this.hot = userBasicModel.hot;
        this.description = userBasicModel.description;
        this.role = userBasicModel.role;
        this.age = userBasicModel.age;
        this.online_state = userBasicModel.online_state;
        this.distance = userBasicModel.distance;
        this.photos_count = userBasicModel.photos_count;
        this.note = userBasicModel.note;
        this.vbadge = userBasicModel.vbadge;
        this.is_recommend = userBasicModel.is_recommend;
        this.blued_pic = userBasicModel.blued_pic;
        this.weekstar = userBasicModel.weekstar;
        this.game_type = userBasicModel.game_type;
        this.is_call = userBasicModel.is_call;
        this.vip_grade = userBasicModel.vip_grade;
        this.vip_exp_lvl = userBasicModel.vip_exp_lvl;
        this.is_vip_annual = userBasicModel.is_vip_annual;
        this.is_hide_last_operate = userBasicModel.is_hide_last_operate;
        this.is_hide_distance = userBasicModel.is_hide_distance;
        this.is_hide_city_settled = userBasicModel.is_hide_city_settled;
        this.is_invisible_half = userBasicModel.is_invisible_half;
        this.is_invisible_all = userBasicModel.is_invisible_all;
        this.is_show_vip_page = userBasicModel.is_show_vip_page;
        this.is_traceless_access = userBasicModel.is_traceless_access;
        this.is_global_view_secretly = userBasicModel.is_global_view_secretly;
        this.is_find_on_map = userBasicModel.is_find_on_map;
        this.is_hide_vip_look = userBasicModel.is_hide_vip_look;
        this.is_shadow = userBasicModel.is_shadow;
    }
}
