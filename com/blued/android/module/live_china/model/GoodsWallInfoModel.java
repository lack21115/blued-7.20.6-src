package com.blued.android.module.live_china.model;

import java.io.Serializable;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/model/GoodsWallInfoModel.class */
public final class GoodsWallInfoModel implements Serializable {
    private int aglow;
    private int anchor;
    private int current_task_count;
    private int current_task_progress;
    private int enable_hall;
    private int not_aglow;
    private int stamp_count;
    private ArrayList<String> tab;
    private String avatar = "";
    private String avatar_frame = "";
    private String username = "";
    private String time_str = "";
    private String play_desc = "";
    private String link = "";
    private String current_task = "";

    public final int getAglow() {
        return this.aglow;
    }

    public final int getAnchor() {
        return this.anchor;
    }

    public final String getAvatar() {
        return this.avatar;
    }

    public final String getAvatar_frame() {
        return this.avatar_frame;
    }

    public final String getCurrent_task() {
        return this.current_task;
    }

    public final int getCurrent_task_count() {
        return this.current_task_count;
    }

    public final int getCurrent_task_progress() {
        return this.current_task_progress;
    }

    public final int getEnable_hall() {
        return this.enable_hall;
    }

    public final String getLink() {
        return this.link;
    }

    public final int getNot_aglow() {
        return this.not_aglow;
    }

    public final String getPlay_desc() {
        return this.play_desc;
    }

    public final int getStamp_count() {
        return this.stamp_count;
    }

    public final ArrayList<String> getTab() {
        return this.tab;
    }

    public final String getTime_str() {
        return this.time_str;
    }

    public final String getUsername() {
        return this.username;
    }

    public final void setAglow(int i) {
        this.aglow = i;
    }

    public final void setAnchor(int i) {
        this.anchor = i;
    }

    public final void setAvatar(String str) {
        Intrinsics.e(str, "<set-?>");
        this.avatar = str;
    }

    public final void setAvatar_frame(String str) {
        Intrinsics.e(str, "<set-?>");
        this.avatar_frame = str;
    }

    public final void setCurrent_task(String str) {
        Intrinsics.e(str, "<set-?>");
        this.current_task = str;
    }

    public final void setCurrent_task_count(int i) {
        this.current_task_count = i;
    }

    public final void setCurrent_task_progress(int i) {
        this.current_task_progress = i;
    }

    public final void setEnable_hall(int i) {
        this.enable_hall = i;
    }

    public final void setLink(String str) {
        Intrinsics.e(str, "<set-?>");
        this.link = str;
    }

    public final void setNot_aglow(int i) {
        this.not_aglow = i;
    }

    public final void setPlay_desc(String str) {
        Intrinsics.e(str, "<set-?>");
        this.play_desc = str;
    }

    public final void setStamp_count(int i) {
        this.stamp_count = i;
    }

    public final void setTab(ArrayList<String> arrayList) {
        this.tab = arrayList;
    }

    public final void setTime_str(String str) {
        Intrinsics.e(str, "<set-?>");
        this.time_str = str;
    }

    public final void setUsername(String str) {
        Intrinsics.e(str, "<set-?>");
        this.username = str;
    }
}
