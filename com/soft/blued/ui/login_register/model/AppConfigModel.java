package com.soft.blued.ui.login_register.model;

import com.blued.android.module.common.login.model.UserBasicModel;
import com.blued.android.module.common.user.model.BluedAlbum;
import com.blued.android.module.live_china.model.LiveTabModel;
import com.blued.community.model.BubbleExhibitionModel;
import com.blued.community.ui.square.model.DiscoveryBubble;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/login_register/model/AppConfigModel.class */
public class AppConfigModel extends UserBasicModel {
    public int ab_circle_test;
    public int activity_feed_topic_publish;
    public int ad_close_pop;
    public AiRecommendImChatRoom ai_recommend_im_chat_room;
    public int allow_selected_setting;
    public String black_allowed_count;
    public String black_count;
    public List<BubbleExhibitionModel> bubble_exhibition_data;
    public CallBubbleTest call_bubble_test;
    public int call_buy_group;
    public int call_count;
    public int call_experiment;
    public int call_pack_config;
    public int can_not_modify;
    public int chat_box_is_show;
    public int circle_open;
    public int complete_rate;
    public int create_topic;
    public int credit_score;
    public int deactive_user;
    public String default_home_tabs;
    public int eros_alt;
    public List<String> festival_activities;
    public String festival_icon;
    public int has_buy_call;
    public List<List<String>> home_menu;
    public List<NearbyPeopleTabModel> home_tabs;
    public int index_is_complete_rate;
    public Indexing_top_bar indexing_top_bar;
    public int is_activity_white;
    public int is_anchor;
    public int is_android_paid;
    public int is_bubble_exhibition;
    public int is_call_open;
    public int is_hide_group_graph;
    public int is_open_call_sure_box;
    public int is_open_fans_club;
    public int is_open_logout;
    public int is_open_sign;
    public int is_register_expierment_open;
    public int is_send_feed_msg;
    public int is_show_group_burn_after_reading;
    public int is_sign_today;
    public int is_user_reactive;
    public String is_vip;
    public List<String> jsbridge_url;
    public int live_allowed_time;
    public int live_index_page;
    public List<LiveTabModel> live_tabs;
    public int live_tabs_ab_test;
    public int message_ice_breaking;
    public int message_is_complete_rate;
    public int message_push_box;
    public int mine_tab_new_ui;
    public int multi_call_experiment;
    public int nearby_online_time_ui;
    public int nearby_recommend_live_ui;
    public String new_gift_key;
    public int new_regist_expirement;
    public List<String> official_account;
    public String official_unique_account;
    public int oneclick;
    public int open_call_seven_day;
    public int publish_post;
    public int push_box_frequency;
    public int quietly_call_allow;
    public RedDotSign red_dot_sign;
    public String regist_time;
    public int selected_not_vip_show_type;
    public int show_half_invisible;
    public int show_home_guide;
    public int show_msg_box_guide;
    public int show_msg_list_src;
    public int show_msg_src;
    public int show_net_error_toast;
    public int show_search_face;
    public String show_star_dialog_button_bad;
    public String show_star_dialog_button_praise;
    public int show_star_dialog_count;
    public String show_star_dialog_text;
    public int show_star_dialog_text_type;
    public String show_star_dialog_title;
    public List<SignData> sign_data;
    public int sign_day_total;
    public String sign_money_total;
    public long sign_show_duration;
    public int sign_show_rate;
    public String sign_url;
    public int state_list_ab;
    public int super_call_config;
    public int super_topics_type;
    public int tick_city_bubble;
    public int tick_state_test;
    public DiscoveryBubble ticktocks_bubble;
    public int topics_open;
    public FeedPromotion tt_promotion;
    public int user_filter_style;
    public String user_type;
    public int users_call_filter;
    public List<BluedAlbum> vip_avatars;
    public VIPRight vip_split;
    public int visitor_experiment;
    public String withdraw_url;
    public Tip tips = new Tip();
    public int force_expand_msg_safe_tip = 0;
    public int expand_safety_tips = 0;
    public int use_new_visitor_vip_guide = 1;
    public int chat_sdk_type = 1;
    public int is_live_tx_player = 0;

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/login_register/model/AppConfigModel$AiRecommendImChatRoom.class */
    public static class AiRecommendImChatRoom {
        public List<AiRecommendRandomText> random_text;
        public int update_time;
    }

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/login_register/model/AppConfigModel$AiRecommendRandomText.class */
    public static class AiRecommendRandomText {
        public int id;
        public String text;
    }

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/login_register/model/AppConfigModel$CallBubbleTest.class */
    public class CallBubbleTest {
        public int group;
        public String text;

        public CallBubbleTest() {
        }
    }

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/login_register/model/AppConfigModel$FeedPromotion.class */
    public static class FeedPromotion {
        public String btn;
        public int discount_money;
        public String discount_text;
        public long duration;
        public String img;
        public int open;
        public int origin_money;
        public List<String> subhead;
        public String subtitle;
        public String text;
        public String title;
        public int type;
    }

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/login_register/model/AppConfigModel$HOME_TOP_TAB_ID.class */
    public interface HOME_TOP_TAB_ID {
        public static final int FEEDS = 2;
        public static final int FRIENDS = 1;
        public static final int GROUPS = 3;
    }

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/login_register/model/AppConfigModel$Indexing_top_bar.class */
    public class Indexing_top_bar {
        public int default_show;
        public List<Integer> sort;

        public Indexing_top_bar() {
        }
    }

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/login_register/model/AppConfigModel$RedDotSign.class */
    public class RedDotSign {
        public String code;
        public int is_open;

        public RedDotSign() {
        }
    }

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/login_register/model/AppConfigModel$SignData.class */
    public class SignData {
        public String additionalReward;
        public int dayIndex;
        public String money;

        public SignData() {
        }
    }

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/login_register/model/AppConfigModel$Tip.class */
    public class Tip {
        public String link;
        public String text;

        public Tip() {
        }
    }

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/login_register/model/AppConfigModel$VIPRight.class */
    public static class VIPRight {
        public int is_advanced_recently_view;
        public int is_change_blued_icon;
        public int is_chat_backgrounds;
        public int is_chat_shadow;
        public int is_filter_ads;
        public int is_filter_vip;
        public int is_find_on_map;
        public int is_global_view_secretly;
        public int is_hide_city_settled;
        public int is_hide_distance;
        public int is_hide_last_operate;
        public int is_hide_vip_look;
        public int is_high_invisible;
        public int is_improve_backlist;
        public int is_improve_grouplist;
        public int is_invisible_all;
        public int is_invisible_half;
        public int is_secretly_followed;
        public int is_show_vip_page;
        public int is_top_feed_views;
        public int is_traceless_access;
        public int is_view_secretly;
        public int is_vip_mark;
        public int is_vip_more_avatar;
        public int is_vip_red_name;
        public int is_vip_select;
    }
}
