package com.soft.blued.ui.user.model;

import com.soft.blued.user.BluedConfig;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/model/VIPRightOption.class */
public class VIPRightOption {
    public String corner;
    public String description;
    public String icon;
    public String icon_svip;
    public String icon_vip;
    public int is_new;
    public int is_on;
    public int is_svip;
    public int pid;
    public String title;
    public String unit;

    public static int getOnOffStatus(int i) {
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            if (i != 5) {
                                if (i != 11) {
                                    if (i != 13) {
                                        if (i != 25) {
                                            if (i != 27) {
                                                return -1;
                                            }
                                            return BluedConfig.a().h().is_filter_ads;
                                        } else if (BluedConfig.a().g().is_hide_vip_look == 1) {
                                            int i2 = 1;
                                            if (BluedConfig.a().h().is_hide_vip_look == 1) {
                                                i2 = 0;
                                            }
                                            return i2;
                                        } else {
                                            return 0;
                                        }
                                    }
                                    return BluedConfig.a().h().is_global_view_secretly;
                                }
                                return BluedConfig.a().h().is_traceless_access;
                            }
                            return BluedConfig.a().h().is_show_vip_page;
                        }
                        return BluedConfig.a().h().is_invisible_all;
                    }
                    return BluedConfig.a().h().is_invisible_half;
                }
                return BluedConfig.a().h().is_hide_city_settled;
            }
            return BluedConfig.a().h().is_hide_distance;
        }
        return BluedConfig.a().h().is_hide_last_operate;
    }

    public int getRightType() {
        int i = this.pid;
        return (i == 0 || i == 1 || i == 2 || i == 3 || i == 11 || i == 13 || i == 25 || i == 27) ? 0 : 1;
    }
}
