package com.blued.android.module.common.login.model;

import com.anythink.nativead.api.ATNative;
import com.blued.ad.ADConstants;
import com.blued.android.framework.http.parser.BluedEntityBaseExtra;
import com.blued.android.module.common.adx.base.BaseNativeExpressAd;
import com.huawei.hms.ads.nativead.NativeAd;
import com.qq.e.ads.nativ.NativeUnifiedADData;
import java.io.Serializable;
import java.util.Arrays;
import java.util.HashSet;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/login/model/BluedADExtra.class */
public class BluedADExtra extends BluedEntityBaseExtra implements Serializable, Comparable {
    public int adPosition;
    public int adm_type;
    public String adm_type_source;
    public String adms_mark;
    public String adms_type;
    public String ads_apng;
    public String ads_gif;
    public long ads_id;
    public String ads_id_sub;
    public String ads_pics;
    public String aid;
    public transient ADConstants.AD_POSITION bannerPosition;
    public int bannerWidthUnitDP;
    public transient BaseNativeExpressAd baseNativeExpressAd;
    public float base_price;
    public int bid_fail_notice;
    public int bidding_type;
    public long bubble_frequency_time;
    public int bubble_frequency_type;
    public int bubble_stay_time;
    public String bubble_title;
    public int business_line;
    public int can_close;
    public String channel;
    public String[] click_post_url;
    public String[] click_url;
    public int close_time;
    public String comments_url;
    public String deep_link_url;
    public int department;
    public String detail_url;
    public DownLoadModel download;
    public int download_type;
    public String[] dp_post_url;
    public String[] dp_url;
    public String errorMsg;
    public String exclude_id;
    public ExtJson extra_json;
    public GdtBid gdt_bid;
    public boolean hasMaterial;
    public String[] hidden_url;
    public int hot_area_limit_type;
    public int hot_dynamic;
    public transient NativeAd hwNativeAd;
    public float interval;
    public boolean isAdxTimeout;
    public int is_ads;
    public int is_bidding;
    public int is_show_adm_icon;
    public String liked_url;
    public long local_closed_time;
    public String material_height;
    public int material_type;
    public String material_width;
    public transient com.anythink.nativead.api.NativeAd nativeAd;
    public transient com.anythink.nativead.api.NativeAd nativeAdGrid;
    public transient com.anythink.nativead.api.NativeAd nativeAdList;
    public transient ATNative nativeHandler;
    public NativeModel nativeModel;
    public transient NativeUnifiedADData nativeUnifiedADData;
    public double operating_time;
    public String platform;
    public String position_code;
    public float price;
    public int purpose;
    public int ranking_banner_one;
    public String recommend_type;
    public String request_id;
    public int request_time_out;
    public int security;
    public int settlement_price;
    public String share_url;
    public String[] show_post_url;
    public int show_time_limit;
    public String[] show_url;
    public int speed;
    public String style_material;
    public int style_view;
    public String target_url;
    public String text_click_button;
    public String text_shake_it;
    public String text_wipe_up;
    public String third_id;
    public int third_style_view;
    public int timeout;
    public int transparency;
    public boolean triggered;
    public int turn_angle;
    public String[] unliked_url;
    public String[] unliked_users_url;
    public String[] video_click;
    public String[] video_finish;
    public String[] video_start;
    public WXModel wx;
    public boolean is_unliked_url_visited = false;
    public boolean isIs_unliked_users_url_visited = false;
    public boolean isShowUrlVisited = false;
    public boolean isShowOperateVisited = false;
    public boolean isShowAdVisited = false;
    public HashSet<Long> ttShowSet = new HashSet<>();
    public HashSet<Long> topShowSet = new HashSet<>();
    public HashSet<Long> topRequestSet = new HashSet<>();
    public HashSet<String> ttAdxShowSet = new HashSet<>();

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/login/model/BluedADExtra$DownLoadModel.class */
    public static class DownLoadModel implements Serializable {
        public String app_icon;
        public String app_name;
        public String app_permission_url;
        public String app_privacy_url;
        public String app_size;
        public String app_version;
        public String bundle;
        public String[] down_finish;
        public String down_link;
        public String[] down_start;
        public String[] install_finish;
        public String[] install_start;

        public String toString() {
            return "DownLoadModel{bundle='" + this.bundle + "', down_link='" + this.down_link + "', down_start=" + Arrays.toString(this.down_start) + ", down_finish=" + Arrays.toString(this.down_finish) + ", install_start=" + Arrays.toString(this.install_start) + ", install_finish=" + Arrays.toString(this.install_finish) + ", app_name='" + this.app_name + "', app_icon='" + this.app_icon + "', app_size='" + this.app_size + "', app_version='" + this.app_version + "', app_permission_url='" + this.app_permission_url + "', app_privacy_url='" + this.app_privacy_url + "'}";
        }
    }

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/login/model/BluedADExtra$ExtJson.class */
    public static class ExtJson implements Serializable {
        public Excitation excitation;
        public Users users;
    }

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/login/model/BluedADExtra$GdtBid.class */
    public static class GdtBid implements Serializable {
        public String gdt_token;
        public String lurl;
        public String nurl;
        public float price;
    }

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/login/model/BluedADExtra$NativeModel.class */
    public static class NativeModel implements Serializable {
        public String ads_pics;
        public String avatar;
        public String description;
        public String name;
        public String style_material;
    }

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/login/model/BluedADExtra$Users.class */
    public static class Users implements Serializable {
        public String brand_monitor_url;
    }

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/login/model/BluedADExtra$WXModel.class */
    public static class WXModel implements Serializable {
        public String id;
        public int is_popup;
        public String path;

        public String toString() {
            return "WXModel{id='" + this.id + "', path='" + this.path + "', is_popup=" + this.is_popup + '}';
        }
    }

    @Override // java.lang.Comparable
    public int compareTo(Object obj) {
        BluedADExtra bluedADExtra = (BluedADExtra) obj;
        int i = this.ranking_banner_one;
        int i2 = bluedADExtra.ranking_banner_one;
        if (i > i2) {
            return -1;
        }
        if (i < i2) {
            return 1;
        }
        if (getHash() > bluedADExtra.getHash()) {
            return -1;
        }
        return getHash() < bluedADExtra.getHash() ? 1 : 0;
    }

    public int getHash() {
        return (hashCode() >>> 8) ^ hashCode();
    }

    public boolean isServerBidding() {
        return this.bidding_type == 2;
    }

    public boolean is_bidding() {
        return this.is_bidding == 1;
    }

    public String toString() {
        return "BluedADExtra{广告id=" + this.ads_id_sub + ", 广告源='" + this.adm_type_source + ", 广告位id='" + this.third_id + "', 是否为竞价广告=" + is_bidding() + ", 是否为服务端bidding=" + isServerBidding() + ", 广告价格=" + this.price + ", 是否获取到物料=" + this.hasMaterial + '}';
    }
}
