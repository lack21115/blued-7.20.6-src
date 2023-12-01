package com.soft.blued.ui.mine.model;

import android.text.TextUtils;
import com.blued.android.module.common.login.model.BluedADExtra;
import com.blued.android.module.common.url.BluedHttpUrl;
import com.soft.blued.ui.user.model.UserInfoEntity;
import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/mine/model/MineEntryInfo.class */
public class MineEntryInfo {
    public String black_allowed_count;
    public String black_count;
    public VipInfo broadcast;
    public Columns columns;
    public ImgBanner img_banner;
    public int rich_level;
    public List<TvBanner> text_banner;
    public UserInfoEntity user;

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/mine/model/MineEntryInfo$Columns.class */
    public static class Columns {
        public List<ColumnsItem> anchors;
        public List<ColumnsItem> health;
        public List<ColumnsItem> others;
        public List<ColumnsItem> service;
    }

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/mine/model/MineEntryInfo$ColumnsExtra.class */
    public static class ColumnsExtra {
        public static final String TYPE_ANCHOR_LEVEL = "anchor_level";
        public static final String TYPE_CALL_ORDERS = "call_orders";
        public static final String TYPE_CHARGE = "charge";
        public static final String TYPE_RICH_LEVEL = "rich_level";
        public static final String TYPE_SHADOW = "shadow";
        public String anchor_level;
        public long beans;
        public int rich_level;
        public int show_new_icon;
        public int times;
        public String type;
    }

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/mine/model/MineEntryInfo$ColumnsItem.class */
    public static class ColumnsItem {
        public ColumnsExtra extra;
        public String icon;
        public String id;
        public int is_highlight;
        public String item_key;
        public String key;
        public String recommend_icon;
        public String recommend_text;
        public String title;
        public String url;
    }

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/mine/model/MineEntryInfo$ImgBanner.class */
    public static class ImgBanner extends BluedADExtra {
        public String img;
        public String link;
    }

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/mine/model/MineEntryInfo$TvBanner.class */
    public static class TvBanner {
        public String content;
        public String content_color;
        public String id;
        public String link;
        public String title;
        public String title_color;
    }

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/mine/model/MineEntryInfo$VipBroadcast.class */
    public static class VipBroadcast {
        public String text;
        public int type;
        public String url;
    }

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/mine/model/MineEntryInfo$VipInfo.class */
    public static class VipInfo {
        public String btn;
        public List<VipBroadcast> carousels;
        public int expire_type;
        public int is_broadcast_test;
        public int is_vip_annual;
        public String title;
        public String url;
        public int vip_exp_lvl;
        public int vip_expire_state;
        public int vip_grade;
    }

    public String getVipCenterUrl() {
        VipInfo vipInfo = this.broadcast;
        return (vipInfo == null || TextUtils.isEmpty(vipInfo.url)) ? BluedHttpUrl.g() : this.broadcast.url;
    }
}
