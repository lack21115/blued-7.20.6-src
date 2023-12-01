package com.soft.blued.ui.user.model;

import java.io.Serializable;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/model/VIPCustomSettingBase.class */
public class VIPCustomSettingBase implements Serializable {
    public int can_select = 1;
    public String corner_text;
    public String front_cover;
    public int id;
    public boolean isDefault;
    public int is_termination;
    public boolean lastSelected;
    public String name;
    public int selected;
    public long start_time;
    public long stop_time;
    public int version;
    public int vip_status;

    public VIPCustomSettingBase() {
    }

    public VIPCustomSettingBase(int i, boolean z) {
        this.selected = i;
        this.isDefault = z;
    }
}
