package com.soft.blued.ui.user.model;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/model/DynamicSkinModel.class */
public class DynamicSkinModel extends VIPCustomSettingBase {
    public String theme;

    public DynamicSkinModel(boolean z, int i, boolean z2) {
        this.selected = i;
        this.isDefault = z;
        this.lastSelected = z2;
    }

    public void update(DynamicSkinModel dynamicSkinModel) {
        this.id = dynamicSkinModel.id;
        this.version = dynamicSkinModel.version;
        this.vip_status = dynamicSkinModel.vip_status;
        this.theme = dynamicSkinModel.theme;
        this.front_cover = dynamicSkinModel.front_cover;
    }
}
