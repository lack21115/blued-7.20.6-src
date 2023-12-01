package com.blued.android.module.live_china.model;

import java.io.Serializable;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/model/RankAllDataModel.class */
public final class RankAllDataModel implements Serializable {
    private int avatar_frame_type;
    private long diff_score;
    private boolean isFake;
    private int is_hide;
    private long lid;
    private int rank;
    private long score;
    private ArrayList<RankTopDataModel> top;
    private String uid = "";
    private String avatar = "";
    private String name = "";
    private String avatar_frame = "";
    private String guild_name = "";
    private String badge_image = "";
    private RankExtraModel extra = new RankExtraModel();

    public final String getAvatar() {
        return this.avatar;
    }

    public final String getAvatar_frame() {
        return this.avatar_frame;
    }

    public final int getAvatar_frame_type() {
        return this.avatar_frame_type;
    }

    public final String getBadge_image() {
        return this.badge_image;
    }

    public final long getDiff_score() {
        return this.diff_score;
    }

    public final RankExtraModel getExtra() {
        return this.extra;
    }

    public final String getGuild_name() {
        return this.guild_name;
    }

    public final long getLid() {
        return this.lid;
    }

    public final String getName() {
        return this.name;
    }

    public final int getRank() {
        return this.rank;
    }

    public final long getScore() {
        return this.score;
    }

    public final ArrayList<RankTopDataModel> getTop() {
        return this.top;
    }

    public final String getUid() {
        return this.uid;
    }

    public final boolean isFake() {
        return this.isFake;
    }

    public final int is_hide() {
        return this.is_hide;
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

    public final void setBadge_image(String str) {
        Intrinsics.e(str, "<set-?>");
        this.badge_image = str;
    }

    public final void setDiff_score(long j) {
        this.diff_score = j;
    }

    public final void setExtra(RankExtraModel rankExtraModel) {
        Intrinsics.e(rankExtraModel, "<set-?>");
        this.extra = rankExtraModel;
    }

    public final void setFake(boolean z) {
        this.isFake = z;
    }

    public final void setGuild_name(String str) {
        Intrinsics.e(str, "<set-?>");
        this.guild_name = str;
    }

    public final void setLid(long j) {
        this.lid = j;
    }

    public final void setName(String str) {
        Intrinsics.e(str, "<set-?>");
        this.name = str;
    }

    public final void setRank(int i) {
        this.rank = i;
    }

    public final void setScore(long j) {
        this.score = j;
    }

    public final void setTop(ArrayList<RankTopDataModel> arrayList) {
        this.top = arrayList;
    }

    public final void setUid(String str) {
        Intrinsics.e(str, "<set-?>");
        this.uid = str;
    }

    public final void set_hide(int i) {
        this.is_hide = i;
    }
}
