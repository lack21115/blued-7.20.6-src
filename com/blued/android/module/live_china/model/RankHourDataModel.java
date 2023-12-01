package com.blued.android.module.live_china.model;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/model/RankHourDataModel.class */
public final class RankHourDataModel implements Serializable {
    private int avatar_frame_type;
    private int bonus;
    private int hour;
    private int is_match;
    private long live;
    private int rank;
    private long uid;
    private String avatar = "";
    private String name = "";
    private String avatar_frame = "";
    private String daytime = "";
    private String type = "";
    private String text = "";

    public final String getAvatar() {
        return this.avatar;
    }

    public final String getAvatar_frame() {
        return this.avatar_frame;
    }

    public final int getAvatar_frame_type() {
        return this.avatar_frame_type;
    }

    public final int getBonus() {
        return this.bonus;
    }

    public final String getDaytime() {
        return this.daytime;
    }

    public final int getHour() {
        return this.hour;
    }

    public final long getLive() {
        return this.live;
    }

    public final String getName() {
        return this.name;
    }

    public final int getRank() {
        return this.rank;
    }

    public final String getText() {
        return this.text;
    }

    public final String getType() {
        return this.type;
    }

    public final long getUid() {
        return this.uid;
    }

    public final int is_match() {
        return this.is_match;
    }

    public final void setAvatar(String str) {
        Intrinsics.e(str, "<set-?>");
        this.avatar = str;
    }

    public final void setAvatar_frame(String str) {
        Intrinsics.e(str, "<set-?>");
        this.avatar_frame = str;
    }

    public final void setAvatar_frame_type(int i) {
        this.avatar_frame_type = i;
    }

    public final void setBonus(int i) {
        this.bonus = i;
    }

    public final void setDaytime(String str) {
        Intrinsics.e(str, "<set-?>");
        this.daytime = str;
    }

    public final void setHour(int i) {
        this.hour = i;
    }

    public final void setLive(long j) {
        this.live = j;
    }

    public final void setName(String str) {
        Intrinsics.e(str, "<set-?>");
        this.name = str;
    }

    public final void setRank(int i) {
        this.rank = i;
    }

    public final void setText(String str) {
        Intrinsics.e(str, "<set-?>");
        this.text = str;
    }

    public final void setType(String str) {
        Intrinsics.e(str, "<set-?>");
        this.type = str;
    }

    public final void setUid(long j) {
        this.uid = j;
    }

    public final void set_match(int i) {
        this.is_match = i;
    }
}
