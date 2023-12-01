package com.soft.blued.ui.mine.model;

import android.text.TextUtils;
import com.blued.android.module.common.login.model.BluedADExtra;
import com.soft.blued.ui.user.model.UserInfoEntity;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/mine/model/MinePageModel.class */
public class MinePageModel {
    public MineAnchor anchor;
    public MineBanner banner;
    public List<EmotionItem> emotions;
    public HealthItem healthy;
    public List<ColumnsItem> healthy_banner;
    public List<ColumnsItem> others;
    public List<ColumnsItem> service;
    public UserInfoEntity user;
    public VipInfo vip_broadcast;

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/mine/model/MinePageModel$AnchorType.class */
    public interface AnchorType {
        public static final int AGENT = 4;
        public static final int ALL = 3;
        public static final int CHAT = 2;
        public static final int LIVE = 1;
        public static final int NONE = 0;
    }

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/mine/model/MinePageModel$ColumnsItem.class */
    public static class ColumnsItem {
        public String activity_text;
        public String content;
        public String content_color;
        public String icon;
        public String icon1;
        public String icon2;
        public String id;
        public int is_highlight;
        public List<ColumnsItem> item;
        public String item_key;
        public String key;
        public String recommend_icon;
        public String recommend_text;
        public int sort = 0;
        public String sub_color;
        public String title;
        public String title_color;
        public String url;

        public ColumnsItem(String str, String str2) {
            this.title = str;
            this.icon1 = str2;
        }
    }

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/mine/model/MinePageModel$EmotionItem.class */
    public static class EmotionItem {
        public String banner;
        public String code;
        public String emotion_id;
        public String redirect_url;
    }

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/mine/model/MinePageModel$HealthItem.class */
    public static class HealthItem {
        public ColumnsItem left;
        public ColumnsItem mid;
        public ColumnsItem right;
    }

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/mine/model/MinePageModel$MineAnchor.class */
    public static class MineAnchor {
        public String anchor_level;
        public String anchor_level_icon;
        public int is_anchor;
        public String rich_level;
    }

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/mine/model/MinePageModel$MineBanner.class */
    public static class MineBanner extends BluedADExtra {
        public String img;
        public String link;
    }

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/mine/model/MinePageModel$VipBroadcast.class */
    public static class VipBroadcast {
        public String text;
        public int type;
        public String url;
    }

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/mine/model/MinePageModel$VipInfo.class */
    public static class VipInfo {
        public String arrow_pic;
        public String background_gif;
        public String background_picture;
        public String btn;
        public List<VipBroadcast> carousels;
        public int expire_type;
        public int is_vip_annual;
        public String title;
        public String url;
        public int vip_exp_lvl;
        public int vip_expire_state;
        public int vip_grade;
        public String vip_level_pic;

        public String getBg() {
            return !TextUtils.isEmpty(this.background_gif) ? this.background_gif : this.background_picture;
        }
    }
}
