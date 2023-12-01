package com.blued.android.module.yy_china.model;

import java.util.ArrayList;

/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/model/RoomSettingMode.class */
public class RoomSettingMode {
    public RoomSettingAnchorLevel anchor_level;
    private ArrayList<YYCreateTypeMode> background;
    public int is_fans_notice;
    private ArrayList<RoomSettingManagerMode> manager;
    private RoomSettingRoomInfoMode room_info;
    public ArrayList<RoomSettingTopicModel> theme;

    public ArrayList<YYCreateTypeMode> getBackground() {
        return this.background;
    }

    public ArrayList<RoomSettingManagerMode> getManager() {
        return this.manager;
    }

    public RoomSettingRoomInfoMode getRoom_info() {
        return this.room_info;
    }

    public void setBackground(ArrayList<YYCreateTypeMode> arrayList) {
        this.background = arrayList;
    }

    public void setManager(ArrayList<RoomSettingManagerMode> arrayList) {
        this.manager = arrayList;
    }

    public void setRoom_info(RoomSettingRoomInfoMode roomSettingRoomInfoMode) {
        this.room_info = roomSettingRoomInfoMode;
    }
}
