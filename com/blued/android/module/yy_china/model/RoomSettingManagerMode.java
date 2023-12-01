package com.blued.android.module.yy_china.model;

import com.chad.library.adapter.base.entity.MultiItemEntity;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/model/RoomSettingManagerMode.class */
public class RoomSettingManagerMode implements MultiItemEntity {
    private String avatar;
    private String avatar_audited;
    private String name;
    private int type;
    private String uid;

    public String getAvatar() {
        return this.avatar;
    }

    public String getAvatar_audited() {
        return this.avatar_audited;
    }

    public int getItemType() {
        return this.type;
    }

    public String getName() {
        return this.name;
    }

    public String getUid() {
        return this.uid;
    }

    public void setAvatar(String str) {
        this.avatar = str;
    }

    public void setAvatar_audited(String str) {
        this.avatar_audited = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setUid(String str) {
        this.uid = str;
    }
}
