package com.blued.android.module.live_china.model;

import android.text.TextUtils;
import com.blued.android.module.live.base.model.CommonLiveGiftModel;
import com.blued.android.module.live.base.model.LiveGiftNumberModel;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/model/LiveGiftModel.class */
public class LiveGiftModel extends CommonLiveGiftModel implements Serializable {
    public List<LiveGiftAdvancedModel> advance_list;
    public int anim_many;
    public String avatar_frame_url;
    public List<String> bg_color;
    public String bg_img;
    public double bonus;
    public LiveBunchLightModel bunchLightModel;
    public LiveChatBadgeModel chatBadgeModel;
    public LiveGiftConstellationModel constellation;
    public int consume;
    public String decoration_id;
    public String decoration_type;
    public String desc;
    public int draw_status;
    public List<LiveEffectModel> effect;
    public LiveEffectModel effectModel;
    public String errorMessage;
    public int event_type;
    public int exclusive_icon;
    public int expire;
    public String expire_info;
    public Object extraModel;
    public int fanClubLevel;
    public String fanClubName;
    public int fanStatus;
    public int gameplay_type;
    public long giftId;
    public int giftType;
    public LiveGiftSetInfoModel goods_set_info;
    public List<LiveGiftNumberModel> groups;
    public int inFanClub;
    public String info_content;
    public String info_img;
    public int info_screen_type;
    public String info_title;
    public int info_type;
    public String info_url;
    public int is_battle_goods;
    public int is_fans_goods;
    public int is_join_ticket;
    public boolean is_opponent;
    public int is_renewal;
    public int is_task;
    public int is_unexpire;
    public int level;
    public String liang_id;
    public int liang_type;
    public int link_type;
    public String luck_bag_img;
    public boolean onlyPlayScreen;
    public List<LiveGiftOperateIconModel> operate_icon_list;
    public String pop_up_description;
    public String pop_up_title;
    public LiveGiftRandomBarModel random;
    public String random_name;
    public String random_static;
    public List<LiveGiftOperateIconModel> realOperateIcons;
    public LiveGiftNumberModel selectNumModel;
    public LiveGiftSkinItemModel skin_on_process;
    public LiveGiftSkinItemModel skin_on_use;
    public int skin_status;
    public String source;
    public String sourceEvent;
    public String text;
    public String type;
    public String type_icon;
    public String type_name;
    public long userId;
    public int user_store_count;
    public int vibrate_status;
    public boolean is_draw_goods = false;
    public boolean is_luck_bag = false;
    public boolean is_help_wish_list = false;
    public boolean isExposure = false;
    public boolean isReward = false;
    public int displayCount = 1;
    public boolean always_show_animation = false;
    public boolean enterAnimLocal = false;
    public String link = "";

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof LiveGiftModel) {
            LiveGiftModel liveGiftModel = (LiveGiftModel) obj;
            if (TextUtils.equals(liveGiftModel.goods_id, this.goods_id) && TextUtils.equals(liveGiftModel.images_static, this.images_static) && TextUtils.equals(liveGiftModel.images_gif, this.images_gif) && TextUtils.equals(liveGiftModel.images_apng2, this.images_apng2) && TextUtils.equals(liveGiftModel.images_mp4, this.images_mp4) && TextUtils.equals(liveGiftModel.anim_code, this.anim_code) && TextUtils.equals(liveGiftModel.name, this.name) && TextUtils.equals(liveGiftModel.contents, this.contents) && TextUtils.equals(liveGiftModel.expire_time, this.expire_time) && liveGiftModel.user_store_count == this.user_store_count && liveGiftModel.beans == this.beans && liveGiftModel.sendGiftStatus == this.sendGiftStatus && liveGiftModel.availability == this.availability && liveGiftModel.count == this.count && liveGiftModel.ops == this.ops && liveGiftModel.animation == this.animation && liveGiftModel.hit_id == this.hit_id && liveGiftModel.hit_count == this.hit_count && liveGiftModel.double_hit == this.double_hit && liveGiftModel.beans_count == this.beans_count && liveGiftModel.beans_current_count == this.beans_current_count && liveGiftModel.free_number == this.free_number && liveGiftModel.one_month_beans == this.one_month_beans && liveGiftModel.is_my == this.is_my && liveGiftModel.is_use == this.is_use) {
                if (liveGiftModel.effect == null || this.effect != null) {
                    if (liveGiftModel.effect != null || this.effect == null) {
                        List<LiveEffectModel> list = liveGiftModel.effect;
                        return list == null || this.effect == null || Arrays.equals(list.toArray(), this.effect.toArray());
                    }
                    return false;
                }
                return false;
            }
            return false;
        }
        return false;
    }

    @Override // com.blued.android.module.common.model.BaseGiftModel
    public String getCompareParam() {
        return this.goods_id;
    }

    @Override // com.blued.android.module.common.model.BaseGiftModel
    public int getDeleteItemCount() {
        return this.user_store_count;
    }

    public int getDisplayCount() {
        return (this.hit_batch != 1 || this.hit_count <= 1) ? this.displayCount : this.hit_count;
    }

    public boolean isGiftSet() {
        LiveGiftSetInfoModel liveGiftSetInfoModel = this.goods_set_info;
        return liveGiftSetInfoModel != null && liveGiftSetInfoModel.getId() > 0;
    }

    public boolean isScrawlGift() {
        return this.draw_status == 1;
    }

    @Override // com.blued.android.module.live.base.model.CommonLiveGiftModel, com.blued.android.module.common.model.BaseGiftModel
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("LiveGiftModel[");
        sb.append(super.toString());
        sb.append(", user_store_count:");
        sb.append(this.user_store_count);
        sb.append(", bonus:");
        sb.append(this.bonus);
        sb.append(", text:");
        sb.append(this.text);
        sb.append(", expire:");
        sb.append(this.expire);
        sb.append(", is_fans_goods:");
        sb.append(this.is_fans_goods);
        sb.append(", is_join_ticket:");
        sb.append(this.is_join_ticket);
        sb.append(", is_task:");
        sb.append(this.is_task);
        sb.append(", exclusive_icon:");
        sb.append(this.exclusive_icon);
        sb.append(", fans_level:");
        sb.append(this.fans_level);
        sb.append(", info_type:");
        sb.append(this.info_type);
        sb.append(", info_img:");
        sb.append(this.info_img);
        sb.append(", info_url:");
        sb.append(this.info_url);
        sb.append(", images_mp4:");
        sb.append(this.images_mp4);
        sb.append(", images_static: ");
        sb.append(this.images_static);
        sb.append(", event_type:");
        sb.append(this.event_type);
        sb.append(", draw_status: ");
        sb.append(this.draw_status);
        sb.append(", displayCount: ");
        sb.append(this.displayCount);
        sb.append(", advance_list: ");
        List<LiveGiftAdvancedModel> list = this.advance_list;
        sb.append(list != null ? list.toString() : "null");
        sb.append("]");
        return sb.toString();
    }
}
