package com.blued.android.module.live.base.model;

import com.blued.android.module.common.model.BaseGiftModel;
import java.io.Serializable;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/live/base/model/CommonLiveGiftModel.class */
public class CommonLiveGiftModel extends BaseGiftModel implements Serializable {
    public static final int GIFT_CANCEL = 2;
    public static final int GIFT_DEFAULT = 0;
    public static final int GIFT_LOADING = 1;
    public static final int GIFT_NOT_AVAILABLE = -1;
    public static final int GIFT_SUCCESS = 3;
    public static final int GIFT_VENDIBILITY = 1;
    public String anim_code;
    public int animation;
    public int availability;
    public long beans;
    public double beans_count;
    public double beans_current_count;
    public String box_image;
    public int comboWaitTime;
    public String contents;
    public long danmu_count;
    public long discount;
    public int double_hit;
    public long effect_time;
    public String expire_time;
    public int fans_level;
    public int free_number;
    public String goods_id;
    public int hit_batch;
    public int hit_count;
    public long hit_id;
    public int imageType;
    public String images_apng2;
    public String images_gif;
    public String images_mp4;
    public String images_static;
    public String info;
    public int is_hide_expire_time = 0;
    public int is_my;
    public int is_use;
    public double one_month_beans;
    public int ops;
    public int opsType;
    public String packageTypeName;
    public int resWidth;
    public String resource_url;
    public int sendGiftStatus;
    public long sendGiftStatusLoadingTime;
    public int show_info;

    @Override // com.blued.android.module.common.model.BaseGiftModel
    public String toString() {
        return "CommonLiveGiftModel[" + super.toString() + ", goods_id:" + this.goods_id + ", beans:" + this.beans + ",sendGiftStatus:" + this.sendGiftStatus + ", hit_id:" + this.hit_id + ", hit_count:" + this.hit_count + ", double_hit:" + this.double_hit + ", hit_batch:" + this.hit_batch + ", fans_level:" + this.fans_level + ", comboWaitTime:" + this.comboWaitTime + ", show_info:" + this.show_info + ", info:" + this.info + ", ops:" + this.ops + ", danmu_count:" + this.danmu_count + ", free_number:" + this.free_number + ", is_my:" + this.is_my + ", is_use:" + this.is_use + "]";
    }
}
