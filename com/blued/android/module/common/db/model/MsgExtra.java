package com.blued.android.module.common.db.model;

import android.text.TextUtils;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/db/model/MsgExtra.class */
public class MsgExtra {
    private String admins_uid;
    private String avatar;
    private String created_avatar;
    private String created_name;
    private String created_uid;
    private String groups_avatar;
    private String groups_city;
    private String groups_description;
    private long groups_gid;
    private String groups_iid;
    private String groups_members_count;
    private String groups_name;
    private String groups_type;
    private String kicked_uid;

    public String getAdmins_uid() {
        return this.admins_uid;
    }

    public String getAvatar() {
        return this.avatar;
    }

    public String getCreated_avatar() {
        return this.created_avatar;
    }

    public String getCreated_name() {
        return this.created_name;
    }

    public String getCreated_uid() {
        return this.created_uid;
    }

    public String getGroups_avatar() {
        return this.groups_avatar;
    }

    public String getGroups_city() {
        return this.groups_city;
    }

    public String getGroups_description() {
        return this.groups_description;
    }

    public String getGroups_gid() {
        String str = "";
        if (this.groups_gid > 0) {
            str = "" + this.groups_gid;
        }
        return str;
    }

    public String getGroups_iid() {
        return this.groups_iid;
    }

    public String getGroups_members_count() {
        return this.groups_members_count;
    }

    public String getGroups_name() {
        return this.groups_name;
    }

    public String getGroups_type() {
        return this.groups_type;
    }

    public String getKicked_uid() {
        return this.kicked_uid;
    }

    public void setAdmins_uid(String str) {
        this.admins_uid = str;
    }

    public void setAvatar(String str) {
        this.avatar = str;
    }

    public void setCreated_avatar(String str) {
        this.created_avatar = str;
    }

    public void setCreated_name(String str) {
        this.created_name = str;
    }

    public void setCreated_uid(String str) {
        this.created_uid = str;
    }

    public void setGroups_avatar(String str) {
        this.groups_avatar = str;
    }

    public void setGroups_city(String str) {
        this.groups_city = str;
    }

    public void setGroups_description(String str) {
        this.groups_description = str;
    }

    public void setGroups_gid(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            this.groups_gid = Long.parseLong(str);
        } catch (Exception e) {
        }
    }

    public void setGroups_iid(String str) {
        this.groups_iid = str;
    }

    public void setGroups_members_count(String str) {
        this.groups_members_count = str;
    }

    public void setGroups_name(String str) {
        this.groups_name = str;
    }

    public void setGroups_type(String str) {
        this.groups_type = str;
    }

    public void setKicked_uid(String str) {
        this.kicked_uid = str;
    }
}
