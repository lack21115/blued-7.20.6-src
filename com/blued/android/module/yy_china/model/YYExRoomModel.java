package com.blued.android.module.yy_china.model;

import com.blued.android.framework.http.parser.BluedEntityBaseExtra;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/model/YYExRoomModel.class */
public class YYExRoomModel extends BluedEntityBaseExtra {
    private int chat_room_list_stealth;
    private int is_exist_charge;
    private String task_url;

    public int getChat_room_list_stealth() {
        return this.chat_room_list_stealth;
    }

    public int getIs_exist_charge() {
        return this.is_exist_charge;
    }

    public String getTask_url() {
        return this.task_url;
    }

    public void setChat_room_list_stealth(int i) {
        this.chat_room_list_stealth = i;
    }

    public void setIs_exist_charge(int i) {
        this.is_exist_charge = i;
    }

    public void setTask_url(String str) {
        this.task_url = str;
    }
}
