package com.soft.blued.ui.mine.model;

import com.blued.android.module.common.login.model.UserBasicModel;
import kotlin.Metadata;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/mine/model/UsersInfo.class */
public final class UsersInfo extends UserBasicModel {
    private int day_growth_value;
    private int exp_lvl_diff;
    private int exp_lvl_next;
    private int expire_time;
    private int is_annual_vip;
    private int vip_exp;

    public final int getDay_growth_value() {
        return this.day_growth_value;
    }

    public final int getExp_lvl_diff() {
        return this.exp_lvl_diff;
    }

    public final int getExp_lvl_next() {
        return this.exp_lvl_next;
    }

    public final int getExpire_time() {
        return this.expire_time;
    }

    public final int getVip_exp() {
        return this.vip_exp;
    }

    public final int is_annual_vip() {
        return this.is_annual_vip;
    }

    public final void setDay_growth_value(int i) {
        this.day_growth_value = i;
    }

    public final void setExp_lvl_diff(int i) {
        this.exp_lvl_diff = i;
    }

    public final void setExp_lvl_next(int i) {
        this.exp_lvl_next = i;
    }

    public final void setExpire_time(int i) {
        this.expire_time = i;
    }

    public final void setVip_exp(int i) {
        this.vip_exp = i;
    }

    public final void set_annual_vip(int i) {
        this.is_annual_vip = i;
    }
}
