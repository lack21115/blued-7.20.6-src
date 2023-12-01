package com.blued.android.module.yy_china.model;

import $r8;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/model/YYFirstMeetMode.class */
public final class YYFirstMeetMode {
    private final long duration;
    private final ArrayList<YYFirstMeetGiftsListItemMode> gifts_list;
    private final YYGiftModel goods_info;
    private YYFirstUserInfoMode info;
    private final int is_show_meet;

    public YYFirstMeetMode(int i, long j, YYGiftModel goods_info, ArrayList<YYFirstMeetGiftsListItemMode> gifts_list, YYFirstUserInfoMode info) {
        Intrinsics.e(goods_info, "goods_info");
        Intrinsics.e(gifts_list, "gifts_list");
        Intrinsics.e(info, "info");
        this.is_show_meet = i;
        this.duration = j;
        this.goods_info = goods_info;
        this.gifts_list = gifts_list;
        this.info = info;
    }

    public static /* synthetic */ YYFirstMeetMode copy$default(YYFirstMeetMode yYFirstMeetMode, int i, long j, YYGiftModel yYGiftModel, ArrayList arrayList, YYFirstUserInfoMode yYFirstUserInfoMode, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = yYFirstMeetMode.is_show_meet;
        }
        if ((i2 & 2) != 0) {
            j = yYFirstMeetMode.duration;
        }
        if ((i2 & 4) != 0) {
            yYGiftModel = yYFirstMeetMode.goods_info;
        }
        if ((i2 & 8) != 0) {
            arrayList = yYFirstMeetMode.gifts_list;
        }
        if ((i2 & 16) != 0) {
            yYFirstUserInfoMode = yYFirstMeetMode.info;
        }
        return yYFirstMeetMode.copy(i, j, yYGiftModel, arrayList, yYFirstUserInfoMode);
    }

    public final int component1() {
        return this.is_show_meet;
    }

    public final long component2() {
        return this.duration;
    }

    public final YYGiftModel component3() {
        return this.goods_info;
    }

    public final ArrayList<YYFirstMeetGiftsListItemMode> component4() {
        return this.gifts_list;
    }

    public final YYFirstUserInfoMode component5() {
        return this.info;
    }

    public final YYFirstMeetMode copy(int i, long j, YYGiftModel goods_info, ArrayList<YYFirstMeetGiftsListItemMode> gifts_list, YYFirstUserInfoMode info) {
        Intrinsics.e(goods_info, "goods_info");
        Intrinsics.e(gifts_list, "gifts_list");
        Intrinsics.e(info, "info");
        return new YYFirstMeetMode(i, j, goods_info, gifts_list, info);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof YYFirstMeetMode) {
            YYFirstMeetMode yYFirstMeetMode = (YYFirstMeetMode) obj;
            return this.is_show_meet == yYFirstMeetMode.is_show_meet && this.duration == yYFirstMeetMode.duration && Intrinsics.a(this.goods_info, yYFirstMeetMode.goods_info) && Intrinsics.a(this.gifts_list, yYFirstMeetMode.gifts_list) && Intrinsics.a(this.info, yYFirstMeetMode.info);
        }
        return false;
    }

    public final long getDuration() {
        return this.duration;
    }

    public final ArrayList<YYFirstMeetGiftsListItemMode> getGifts_list() {
        return this.gifts_list;
    }

    public final YYGiftModel getGoods_info() {
        return this.goods_info;
    }

    public final YYFirstUserInfoMode getInfo() {
        return this.info;
    }

    public int hashCode() {
        return (((((((this.is_show_meet * 31) + $r8.backportedMethods.utility.Long.1.hashCode.hashCode(this.duration)) * 31) + this.goods_info.hashCode()) * 31) + this.gifts_list.hashCode()) * 31) + this.info.hashCode();
    }

    public final int is_show_meet() {
        return this.is_show_meet;
    }

    public final void setInfo(YYFirstUserInfoMode yYFirstUserInfoMode) {
        Intrinsics.e(yYFirstUserInfoMode, "<set-?>");
        this.info = yYFirstUserInfoMode;
    }

    public String toString() {
        return "YYFirstMeetMode(is_show_meet=" + this.is_show_meet + ", duration=" + this.duration + ", goods_info=" + this.goods_info + ", gifts_list=" + this.gifts_list + ", info=" + this.info + ')';
    }
}
