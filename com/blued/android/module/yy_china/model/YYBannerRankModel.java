package com.blued.android.module.yy_china.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/model/YYBannerRankModel.class */
public final class YYBannerRankModel {
    private final String activity_type;
    private final String rank_color;
    private final String rank_title;
    private String rank_value;
    private final String score_color;
    private final String score_title;
    private String score_value;

    public YYBannerRankModel(String activity_type, String score_title, String rank_title, String score_value, String rank_value, String score_color, String rank_color) {
        Intrinsics.e(activity_type, "activity_type");
        Intrinsics.e(score_title, "score_title");
        Intrinsics.e(rank_title, "rank_title");
        Intrinsics.e(score_value, "score_value");
        Intrinsics.e(rank_value, "rank_value");
        Intrinsics.e(score_color, "score_color");
        Intrinsics.e(rank_color, "rank_color");
        this.activity_type = activity_type;
        this.score_title = score_title;
        this.rank_title = rank_title;
        this.score_value = score_value;
        this.rank_value = rank_value;
        this.score_color = score_color;
        this.rank_color = rank_color;
    }

    public static /* synthetic */ YYBannerRankModel copy$default(YYBannerRankModel yYBannerRankModel, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i, Object obj) {
        if ((i & 1) != 0) {
            str = yYBannerRankModel.activity_type;
        }
        if ((i & 2) != 0) {
            str2 = yYBannerRankModel.score_title;
        }
        if ((i & 4) != 0) {
            str3 = yYBannerRankModel.rank_title;
        }
        if ((i & 8) != 0) {
            str4 = yYBannerRankModel.score_value;
        }
        if ((i & 16) != 0) {
            str5 = yYBannerRankModel.rank_value;
        }
        if ((i & 32) != 0) {
            str6 = yYBannerRankModel.score_color;
        }
        if ((i & 64) != 0) {
            str7 = yYBannerRankModel.rank_color;
        }
        return yYBannerRankModel.copy(str, str2, str3, str4, str5, str6, str7);
    }

    public final String component1() {
        return this.activity_type;
    }

    public final String component2() {
        return this.score_title;
    }

    public final String component3() {
        return this.rank_title;
    }

    public final String component4() {
        return this.score_value;
    }

    public final String component5() {
        return this.rank_value;
    }

    public final String component6() {
        return this.score_color;
    }

    public final String component7() {
        return this.rank_color;
    }

    public final YYBannerRankModel copy(String activity_type, String score_title, String rank_title, String score_value, String rank_value, String score_color, String rank_color) {
        Intrinsics.e(activity_type, "activity_type");
        Intrinsics.e(score_title, "score_title");
        Intrinsics.e(rank_title, "rank_title");
        Intrinsics.e(score_value, "score_value");
        Intrinsics.e(rank_value, "rank_value");
        Intrinsics.e(score_color, "score_color");
        Intrinsics.e(rank_color, "rank_color");
        return new YYBannerRankModel(activity_type, score_title, rank_title, score_value, rank_value, score_color, rank_color);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof YYBannerRankModel) {
            YYBannerRankModel yYBannerRankModel = (YYBannerRankModel) obj;
            return Intrinsics.a((Object) this.activity_type, (Object) yYBannerRankModel.activity_type) && Intrinsics.a((Object) this.score_title, (Object) yYBannerRankModel.score_title) && Intrinsics.a((Object) this.rank_title, (Object) yYBannerRankModel.rank_title) && Intrinsics.a((Object) this.score_value, (Object) yYBannerRankModel.score_value) && Intrinsics.a((Object) this.rank_value, (Object) yYBannerRankModel.rank_value) && Intrinsics.a((Object) this.score_color, (Object) yYBannerRankModel.score_color) && Intrinsics.a((Object) this.rank_color, (Object) yYBannerRankModel.rank_color);
        }
        return false;
    }

    public final String getActivity_type() {
        return this.activity_type;
    }

    public final String getRank_color() {
        return this.rank_color;
    }

    public final String getRank_title() {
        return this.rank_title;
    }

    public final String getRank_value() {
        return this.rank_value;
    }

    public final String getScore_color() {
        return this.score_color;
    }

    public final String getScore_title() {
        return this.score_title;
    }

    public final String getScore_value() {
        return this.score_value;
    }

    public int hashCode() {
        return (((((((((((this.activity_type.hashCode() * 31) + this.score_title.hashCode()) * 31) + this.rank_title.hashCode()) * 31) + this.score_value.hashCode()) * 31) + this.rank_value.hashCode()) * 31) + this.score_color.hashCode()) * 31) + this.rank_color.hashCode();
    }

    public final void setRank_value(String str) {
        Intrinsics.e(str, "<set-?>");
        this.rank_value = str;
    }

    public final void setScore_value(String str) {
        Intrinsics.e(str, "<set-?>");
        this.score_value = str;
    }

    public String toString() {
        return "YYBannerRankModel(activity_type=" + this.activity_type + ", score_title=" + this.score_title + ", rank_title=" + this.rank_title + ", score_value=" + this.score_value + ", rank_value=" + this.rank_value + ", score_color=" + this.score_color + ", rank_color=" + this.rank_color + ')';
    }
}
