package com.blued.android.module.live_china.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/model/LiveRankBehalfRecordsModel.class */
public final class LiveRankBehalfRecordsModel {
    private String avatar;
    private String beans;
    private String behalf_username;
    private String desc;
    private String target_username;

    public LiveRankBehalfRecordsModel(String desc, String behalf_username, String target_username, String beans, String avatar) {
        Intrinsics.e(desc, "desc");
        Intrinsics.e(behalf_username, "behalf_username");
        Intrinsics.e(target_username, "target_username");
        Intrinsics.e(beans, "beans");
        Intrinsics.e(avatar, "avatar");
        this.desc = desc;
        this.behalf_username = behalf_username;
        this.target_username = target_username;
        this.beans = beans;
        this.avatar = avatar;
    }

    public static /* synthetic */ LiveRankBehalfRecordsModel copy$default(LiveRankBehalfRecordsModel liveRankBehalfRecordsModel, String str, String str2, String str3, String str4, String str5, int i, Object obj) {
        if ((i & 1) != 0) {
            str = liveRankBehalfRecordsModel.desc;
        }
        if ((i & 2) != 0) {
            str2 = liveRankBehalfRecordsModel.behalf_username;
        }
        if ((i & 4) != 0) {
            str3 = liveRankBehalfRecordsModel.target_username;
        }
        if ((i & 8) != 0) {
            str4 = liveRankBehalfRecordsModel.beans;
        }
        if ((i & 16) != 0) {
            str5 = liveRankBehalfRecordsModel.avatar;
        }
        return liveRankBehalfRecordsModel.copy(str, str2, str3, str4, str5);
    }

    public final String component1() {
        return this.desc;
    }

    public final String component2() {
        return this.behalf_username;
    }

    public final String component3() {
        return this.target_username;
    }

    public final String component4() {
        return this.beans;
    }

    public final String component5() {
        return this.avatar;
    }

    public final LiveRankBehalfRecordsModel copy(String desc, String behalf_username, String target_username, String beans, String avatar) {
        Intrinsics.e(desc, "desc");
        Intrinsics.e(behalf_username, "behalf_username");
        Intrinsics.e(target_username, "target_username");
        Intrinsics.e(beans, "beans");
        Intrinsics.e(avatar, "avatar");
        return new LiveRankBehalfRecordsModel(desc, behalf_username, target_username, beans, avatar);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof LiveRankBehalfRecordsModel) {
            LiveRankBehalfRecordsModel liveRankBehalfRecordsModel = (LiveRankBehalfRecordsModel) obj;
            return Intrinsics.a((Object) this.desc, (Object) liveRankBehalfRecordsModel.desc) && Intrinsics.a((Object) this.behalf_username, (Object) liveRankBehalfRecordsModel.behalf_username) && Intrinsics.a((Object) this.target_username, (Object) liveRankBehalfRecordsModel.target_username) && Intrinsics.a((Object) this.beans, (Object) liveRankBehalfRecordsModel.beans) && Intrinsics.a((Object) this.avatar, (Object) liveRankBehalfRecordsModel.avatar);
        }
        return false;
    }

    public final String getAvatar() {
        return this.avatar;
    }

    public final String getBeans() {
        return this.beans;
    }

    public final String getBehalf_username() {
        return this.behalf_username;
    }

    public final String getDesc() {
        return this.desc;
    }

    public final String getTarget_username() {
        return this.target_username;
    }

    public int hashCode() {
        return (((((((this.desc.hashCode() * 31) + this.behalf_username.hashCode()) * 31) + this.target_username.hashCode()) * 31) + this.beans.hashCode()) * 31) + this.avatar.hashCode();
    }

    public final void setAvatar(String str) {
        Intrinsics.e(str, "<set-?>");
        this.avatar = str;
    }

    public final void setBeans(String str) {
        Intrinsics.e(str, "<set-?>");
        this.beans = str;
    }

    public final void setBehalf_username(String str) {
        Intrinsics.e(str, "<set-?>");
        this.behalf_username = str;
    }

    public final void setDesc(String str) {
        Intrinsics.e(str, "<set-?>");
        this.desc = str;
    }

    public final void setTarget_username(String str) {
        Intrinsics.e(str, "<set-?>");
        this.target_username = str;
    }

    public String toString() {
        return "LiveRankBehalfRecordsModel(desc=" + this.desc + ", behalf_username=" + this.behalf_username + ", target_username=" + this.target_username + ", beans=" + this.beans + ", avatar=" + this.avatar + ')';
    }
}
