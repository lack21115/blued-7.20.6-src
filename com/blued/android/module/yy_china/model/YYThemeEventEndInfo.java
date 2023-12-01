package com.blued.android.module.yy_china.model;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/model/YYThemeEventEndInfo.class */
public final class YYThemeEventEndInfo {
    private final YYThemeActivityInfo activity_info;
    private final String duration_time;
    private List<YYThemeRankList> rank_list;
    private final String send_users_count;

    /* renamed from: skin  reason: collision with root package name */
    private final YYEventsThemeModel f57skin;
    private final String users_count;
    private final String value;
    private final String value_desc;

    public YYThemeEventEndInfo(List<YYThemeRankList> rank_list, String duration_time, String send_users_count, String users_count, String value, String value_desc, YYThemeActivityInfo activity_info, YYEventsThemeModel skin2) {
        Intrinsics.e(rank_list, "rank_list");
        Intrinsics.e(duration_time, "duration_time");
        Intrinsics.e(send_users_count, "send_users_count");
        Intrinsics.e(users_count, "users_count");
        Intrinsics.e(value, "value");
        Intrinsics.e(value_desc, "value_desc");
        Intrinsics.e(activity_info, "activity_info");
        Intrinsics.e(skin2, "skin");
        this.rank_list = rank_list;
        this.duration_time = duration_time;
        this.send_users_count = send_users_count;
        this.users_count = users_count;
        this.value = value;
        this.value_desc = value_desc;
        this.activity_info = activity_info;
        this.f57skin = skin2;
    }

    public static /* synthetic */ YYThemeEventEndInfo copy$default(YYThemeEventEndInfo yYThemeEventEndInfo, List list, String str, String str2, String str3, String str4, String str5, YYThemeActivityInfo yYThemeActivityInfo, YYEventsThemeModel yYEventsThemeModel, int i, Object obj) {
        if ((i & 1) != 0) {
            list = yYThemeEventEndInfo.rank_list;
        }
        if ((i & 2) != 0) {
            str = yYThemeEventEndInfo.duration_time;
        }
        if ((i & 4) != 0) {
            str2 = yYThemeEventEndInfo.send_users_count;
        }
        if ((i & 8) != 0) {
            str3 = yYThemeEventEndInfo.users_count;
        }
        if ((i & 16) != 0) {
            str4 = yYThemeEventEndInfo.value;
        }
        if ((i & 32) != 0) {
            str5 = yYThemeEventEndInfo.value_desc;
        }
        if ((i & 64) != 0) {
            yYThemeActivityInfo = yYThemeEventEndInfo.activity_info;
        }
        if ((i & 128) != 0) {
            yYEventsThemeModel = yYThemeEventEndInfo.f57skin;
        }
        return yYThemeEventEndInfo.copy(list, str, str2, str3, str4, str5, yYThemeActivityInfo, yYEventsThemeModel);
    }

    public final List<YYThemeRankList> component1() {
        return this.rank_list;
    }

    public final String component2() {
        return this.duration_time;
    }

    public final String component3() {
        return this.send_users_count;
    }

    public final String component4() {
        return this.users_count;
    }

    public final String component5() {
        return this.value;
    }

    public final String component6() {
        return this.value_desc;
    }

    public final YYThemeActivityInfo component7() {
        return this.activity_info;
    }

    public final YYEventsThemeModel component8() {
        return this.f57skin;
    }

    public final YYThemeEventEndInfo copy(List<YYThemeRankList> rank_list, String duration_time, String send_users_count, String users_count, String value, String value_desc, YYThemeActivityInfo activity_info, YYEventsThemeModel skin2) {
        Intrinsics.e(rank_list, "rank_list");
        Intrinsics.e(duration_time, "duration_time");
        Intrinsics.e(send_users_count, "send_users_count");
        Intrinsics.e(users_count, "users_count");
        Intrinsics.e(value, "value");
        Intrinsics.e(value_desc, "value_desc");
        Intrinsics.e(activity_info, "activity_info");
        Intrinsics.e(skin2, "skin");
        return new YYThemeEventEndInfo(rank_list, duration_time, send_users_count, users_count, value, value_desc, activity_info, skin2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof YYThemeEventEndInfo) {
            YYThemeEventEndInfo yYThemeEventEndInfo = (YYThemeEventEndInfo) obj;
            return Intrinsics.a(this.rank_list, yYThemeEventEndInfo.rank_list) && Intrinsics.a((Object) this.duration_time, (Object) yYThemeEventEndInfo.duration_time) && Intrinsics.a((Object) this.send_users_count, (Object) yYThemeEventEndInfo.send_users_count) && Intrinsics.a((Object) this.users_count, (Object) yYThemeEventEndInfo.users_count) && Intrinsics.a((Object) this.value, (Object) yYThemeEventEndInfo.value) && Intrinsics.a((Object) this.value_desc, (Object) yYThemeEventEndInfo.value_desc) && Intrinsics.a(this.activity_info, yYThemeEventEndInfo.activity_info) && Intrinsics.a(this.f57skin, yYThemeEventEndInfo.f57skin);
        }
        return false;
    }

    public final YYThemeActivityInfo getActivity_info() {
        return this.activity_info;
    }

    public final String getDuration_time() {
        return this.duration_time;
    }

    public final List<YYThemeRankList> getRank_list() {
        return this.rank_list;
    }

    public final String getSend_users_count() {
        return this.send_users_count;
    }

    public final YYEventsThemeModel getSkin() {
        return this.f57skin;
    }

    public final String getUsers_count() {
        return this.users_count;
    }

    public final String getValue() {
        return this.value;
    }

    public final String getValue_desc() {
        return this.value_desc;
    }

    public int hashCode() {
        return (((((((((((((this.rank_list.hashCode() * 31) + this.duration_time.hashCode()) * 31) + this.send_users_count.hashCode()) * 31) + this.users_count.hashCode()) * 31) + this.value.hashCode()) * 31) + this.value_desc.hashCode()) * 31) + this.activity_info.hashCode()) * 31) + this.f57skin.hashCode();
    }

    public final void setRank_list(List<YYThemeRankList> list) {
        Intrinsics.e(list, "<set-?>");
        this.rank_list = list;
    }

    public String toString() {
        return "YYThemeEventEndInfo(rank_list=" + this.rank_list + ", duration_time=" + this.duration_time + ", send_users_count=" + this.send_users_count + ", users_count=" + this.users_count + ", value=" + this.value + ", value_desc=" + this.value_desc + ", activity_info=" + this.activity_info + ", skin=" + this.f57skin + ')';
    }
}
