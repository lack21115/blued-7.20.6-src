package com.blued.android.module.yy_china.model;

import java.util.ArrayList;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/model/YYChatRoomGuideMode.class */
public class YYChatRoomGuideMode {
    private String avatar;
    public boolean isUpload = false;
    public boolean is_Pow = false;
    public int is_new;
    private int is_same_city;
    public String label_link;
    public int mem_count;
    public ArrayList<String> others_avatar;
    private String room_id;
    private String room_name;
    private String room_type;
    private String type_id;
    private String uid;

    public String getAvatar() {
        return this.avatar;
    }

    public int getIs_same_city() {
        return this.is_same_city;
    }

    public String getRoom_id() {
        return this.room_id;
    }

    public String getRoom_name() {
        return this.room_name;
    }

    public String getRoom_type() {
        return this.room_type;
    }

    public String getType_id() {
        return this.type_id;
    }

    public String getUid() {
        return this.uid;
    }

    public void setAvatar(String str) {
        this.avatar = str;
    }

    public void setIs_same_city(int i) {
        this.is_same_city = i;
    }

    public void setRoom_id(String str) {
        this.room_id = str;
    }

    public void setRoom_name(String str) {
        this.room_name = str;
    }

    public void setRoom_type(String str) {
        this.room_type = str;
    }

    public void setType_id(String str) {
        this.type_id = str;
    }

    public void setUid(String str) {
        this.uid = str;
    }
}
