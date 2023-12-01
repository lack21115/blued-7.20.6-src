package com.soft.blued.ui.login_register.model;

import java.util.List;

/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/login_register/model/RemindSettingModel.class */
public class RemindSettingModel {
    private List<GroupInfo> groups;
    public String is_at_push;
    private String is_bluedtone;
    private String is_comment_push;
    private String is_followed_push;
    private String is_groups_notify;
    public String is_like_push;
    private String is_live_push;
    public String is_open_individuality_recommend;
    private String is_open_shake;
    private String is_open_sound;
    public String is_other_message_push;
    private String is_private_msg_push;
    private String is_push_content;
    public String is_push_posting_post;
    public String is_recall_live_push;
    private String is_system_push;
    public String is_used_mobile_push;
    public String is_verify_mobile_push;
    public String is_visited_push;

    /* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/login_register/model/RemindSettingModel$GroupInfo.class */
    public class GroupInfo {
        public String gid;
        public int nodisturb;

        public GroupInfo() {
        }
    }

    public List<GroupInfo> getGroups() {
        return this.groups;
    }

    public String getIs_bluedtone() {
        return this.is_bluedtone;
    }

    public String getIs_comment_push() {
        return this.is_comment_push;
    }

    public String getIs_followed_push() {
        return this.is_followed_push;
    }

    public String getIs_groups_notify() {
        return this.is_groups_notify;
    }

    public String getIs_live_push() {
        return this.is_live_push;
    }

    public String getIs_open_shake() {
        return this.is_open_shake;
    }

    public String getIs_open_sound() {
        return this.is_open_sound;
    }

    public String getIs_private_msg_push() {
        return this.is_private_msg_push;
    }

    public String getIs_push_content() {
        return this.is_push_content;
    }

    public String getIs_push_pop_post() {
        return this.is_push_posting_post;
    }

    public String getIs_system_push() {
        return this.is_system_push;
    }

    public void setGroups(List<GroupInfo> list) {
        this.groups = list;
    }

    public void setIs_bluedtone(String str) {
        this.is_bluedtone = str;
    }

    public void setIs_comment_push(String str) {
        this.is_comment_push = str;
    }

    public void setIs_followed_push(String str) {
        this.is_followed_push = str;
    }

    public void setIs_groups_notify(String str) {
        this.is_groups_notify = str;
    }

    public void setIs_live_push(String str) {
        this.is_live_push = str;
    }

    public void setIs_open_shake(String str) {
        this.is_open_shake = str;
    }

    public void setIs_open_sound(String str) {
        this.is_open_sound = str;
    }

    public void setIs_private_msg_push(String str) {
        this.is_private_msg_push = str;
    }

    public void setIs_push_content(String str) {
        this.is_push_content = str;
    }

    public void setIs_push_pop_post(String str) {
        this.is_push_posting_post = str;
    }

    public void setIs_system_push(String str) {
        this.is_system_push = str;
    }
}
