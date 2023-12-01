package com.soft.blued.ui.user.model;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/user/model/AvatarWidgetModel.class */
public class AvatarWidgetModel extends VIPCustomSettingBase {
    public String theme;

    public AvatarWidgetModel(boolean z, int i, boolean z2) {
        this.selected = i;
        this.isDefault = z;
        this.lastSelected = z2;
    }

    public void update(AvatarWidgetModel avatarWidgetModel) {
        this.id = avatarWidgetModel.id;
        this.version = avatarWidgetModel.version;
        this.vip_status = avatarWidgetModel.vip_status;
        this.theme = avatarWidgetModel.theme;
        this.front_cover = avatarWidgetModel.front_cover;
    }
}
