package com.blued.android.module.live_china.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/model/LiveFinishData.class */
public final class LiveFinishData {
    private int fan_club_level;
    private int fans_status;
    private int in_fan_club;
    private int nameplate_img_height;
    private int nameplate_img_width;
    private int rich_level;
    private String uid = "";
    private String name = "";
    private String avatar = "";
    private String text = "";
    private String fan_club_name = "";
    private String nameplate_img = "";
    private String vip_frame = "";
    private String from = "";
    private String count = "";
    private String relationship = "";

    public final String getAvatar() {
        return this.avatar;
    }

    public final String getCount() {
        return this.count;
    }

    public final int getFan_club_level() {
        return this.fan_club_level;
    }

    public final String getFan_club_name() {
        return this.fan_club_name;
    }

    public final int getFans_status() {
        return this.fans_status;
    }

    public final String getFrom() {
        return this.from;
    }

    public final int getIn_fan_club() {
        return this.in_fan_club;
    }

    public final String getName() {
        return this.name;
    }

    public final String getNameplate_img() {
        return this.nameplate_img;
    }

    public final int getNameplate_img_height() {
        return this.nameplate_img_height;
    }

    public final int getNameplate_img_width() {
        return this.nameplate_img_width;
    }

    public final String getRelationship() {
        return this.relationship;
    }

    public final int getRich_level() {
        return this.rich_level;
    }

    public final String getText() {
        return this.text;
    }

    public final String getUid() {
        return this.uid;
    }

    public final String getVip_frame() {
        return this.vip_frame;
    }

    public final void setAvatar(String str) {
        Intrinsics.e(str, "<set-?>");
        this.avatar = str;
    }

    public final void setCount(String str) {
        Intrinsics.e(str, "<set-?>");
        this.count = str;
    }

    public final void setFan_club_level(int i) {
        this.fan_club_level = i;
    }

    public final void setFan_club_name(String str) {
        Intrinsics.e(str, "<set-?>");
        this.fan_club_name = str;
    }

    public final void setFans_status(int i) {
        this.fans_status = i;
    }

    public final void setFrom(String str) {
        Intrinsics.e(str, "<set-?>");
        this.from = str;
    }

    public final void setIn_fan_club(int i) {
        this.in_fan_club = i;
    }

    public final void setName(String str) {
        Intrinsics.e(str, "<set-?>");
        this.name = str;
    }

    public final void setNameplate_img(String str) {
        Intrinsics.e(str, "<set-?>");
        this.nameplate_img = str;
    }

    public final void setNameplate_img_height(int i) {
        this.nameplate_img_height = i;
    }

    public final void setNameplate_img_width(int i) {
        this.nameplate_img_width = i;
    }

    public final void setRelationship(String str) {
        this.relationship = str;
    }

    public final void setRich_level(int i) {
        this.rich_level = i;
    }

    public final void setText(String str) {
        Intrinsics.e(str, "<set-?>");
        this.text = str;
    }

    public final void setUid(String str) {
        Intrinsics.e(str, "<set-?>");
        this.uid = str;
    }

    public final void setVip_frame(String str) {
        Intrinsics.e(str, "<set-?>");
        this.vip_frame = str;
    }
}
