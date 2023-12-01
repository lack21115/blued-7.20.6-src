package com.blued.android.module.common.user.model;

import com.chad.library.adapter.base.entity.MultiItemEntity;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/user/model/UserTag.class */
public class UserTag implements MultiItemEntity, Serializable {
    public int checked;
    public boolean chooseable;
    public String desc;
    public boolean enable;
    public String[] exclude_id;
    public String icon;
    public String id;
    public String name;
    public boolean select;
    public List<UserTag> tagList;
    public int type;

    public UserTag() {
        this.chooseable = true;
        this.chooseable = true;
    }

    public UserTag(String str) {
        this.chooseable = true;
        this.name = str;
    }

    public UserTag(String str, int i) {
        this.chooseable = true;
        this.name = str;
        this.type = i;
    }

    public UserTag(String str, String str2) {
        this.chooseable = true;
        this.id = str;
        this.name = str2;
    }

    public UserTag(String str, String str2, int i) {
        this.chooseable = true;
        this.id = str;
        this.name = str2;
        this.checked = i;
        this.chooseable = true;
    }

    public UserTag(List<UserTag> list) {
        this.chooseable = true;
        this.tagList = list;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.id.equals(((UserTag) obj).id);
    }

    public int getItemType() {
        return this.type;
    }

    public int hashCode() {
        return Objects.hash(this.id);
    }
}
