package com.blued.android.module.common.model;

import java.io.Serializable;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/model/LiveChargeCouponModel.class */
public class LiveChargeCouponModel implements Serializable {
    public int count;
    public String description;
    public long effect_time;
    public long expire_time;
    public int id;
    public String image;
    public int is_hide_expire_time = 0;
    public int itemType;
    public String name;
    public String pop_up_description;
    public String pop_up_title;
    public String prepayId;
    public int prop_status;
    public int prop_type;
    public int realPayMoney;
    public int reward_count;
    public int status;
    public int threshold;
    public String tradeNo;
    public int type;
    public long use_time;

    /* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/model/LiveChargeCouponModel$CouponType.class */
    public interface CouponType {
    }

    public String toString() {
        return "LiveChargeCouponModel{id=" + this.id + ", name='" + this.name + "', threshold=" + this.threshold + '}';
    }
}
