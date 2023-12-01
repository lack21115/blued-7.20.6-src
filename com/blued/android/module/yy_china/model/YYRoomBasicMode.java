package com.blued.android.module.yy_china.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/model/YYRoomBasicMode.class */
public final class YYRoomBasicMode {
    private final YYRoomBasicInfoMode anchor_info;
    private final YYRoomBasicFirstMeetMode first_meet;
    private final YYRoomBasicInfoMode honor_info;
    private final int open_batch_gifts;
    private final YYRoomBasicPropMode prop_info;
    private final YYRoomBasicRelationDataMode relation_data;
    private final YYTrueLovePackGiftMode true_love_box;
    private final YYRoomBasicWeekStarMode week_star;
    private final WeekStarMode zx_named;

    public YYRoomBasicMode(YYRoomBasicInfoMode honor_info, YYRoomBasicInfoMode anchor_info, YYRoomBasicWeekStarMode week_star, YYRoomBasicPropMode prop_info, YYRoomBasicFirstMeetMode first_meet, WeekStarMode zx_named, YYTrueLovePackGiftMode true_love_box, int i, YYRoomBasicRelationDataMode relation_data) {
        Intrinsics.e(honor_info, "honor_info");
        Intrinsics.e(anchor_info, "anchor_info");
        Intrinsics.e(week_star, "week_star");
        Intrinsics.e(prop_info, "prop_info");
        Intrinsics.e(first_meet, "first_meet");
        Intrinsics.e(zx_named, "zx_named");
        Intrinsics.e(true_love_box, "true_love_box");
        Intrinsics.e(relation_data, "relation_data");
        this.honor_info = honor_info;
        this.anchor_info = anchor_info;
        this.week_star = week_star;
        this.prop_info = prop_info;
        this.first_meet = first_meet;
        this.zx_named = zx_named;
        this.true_love_box = true_love_box;
        this.open_batch_gifts = i;
        this.relation_data = relation_data;
    }

    public static /* synthetic */ YYRoomBasicMode copy$default(YYRoomBasicMode yYRoomBasicMode, YYRoomBasicInfoMode yYRoomBasicInfoMode, YYRoomBasicInfoMode yYRoomBasicInfoMode2, YYRoomBasicWeekStarMode yYRoomBasicWeekStarMode, YYRoomBasicPropMode yYRoomBasicPropMode, YYRoomBasicFirstMeetMode yYRoomBasicFirstMeetMode, WeekStarMode weekStarMode, YYTrueLovePackGiftMode yYTrueLovePackGiftMode, int i, YYRoomBasicRelationDataMode yYRoomBasicRelationDataMode, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            yYRoomBasicInfoMode = yYRoomBasicMode.honor_info;
        }
        if ((i2 & 2) != 0) {
            yYRoomBasicInfoMode2 = yYRoomBasicMode.anchor_info;
        }
        if ((i2 & 4) != 0) {
            yYRoomBasicWeekStarMode = yYRoomBasicMode.week_star;
        }
        if ((i2 & 8) != 0) {
            yYRoomBasicPropMode = yYRoomBasicMode.prop_info;
        }
        if ((i2 & 16) != 0) {
            yYRoomBasicFirstMeetMode = yYRoomBasicMode.first_meet;
        }
        if ((i2 & 32) != 0) {
            weekStarMode = yYRoomBasicMode.zx_named;
        }
        if ((i2 & 64) != 0) {
            yYTrueLovePackGiftMode = yYRoomBasicMode.true_love_box;
        }
        if ((i2 & 128) != 0) {
            i = yYRoomBasicMode.open_batch_gifts;
        }
        if ((i2 & 256) != 0) {
            yYRoomBasicRelationDataMode = yYRoomBasicMode.relation_data;
        }
        return yYRoomBasicMode.copy(yYRoomBasicInfoMode, yYRoomBasicInfoMode2, yYRoomBasicWeekStarMode, yYRoomBasicPropMode, yYRoomBasicFirstMeetMode, weekStarMode, yYTrueLovePackGiftMode, i, yYRoomBasicRelationDataMode);
    }

    public final YYRoomBasicInfoMode component1() {
        return this.honor_info;
    }

    public final YYRoomBasicInfoMode component2() {
        return this.anchor_info;
    }

    public final YYRoomBasicWeekStarMode component3() {
        return this.week_star;
    }

    public final YYRoomBasicPropMode component4() {
        return this.prop_info;
    }

    public final YYRoomBasicFirstMeetMode component5() {
        return this.first_meet;
    }

    public final WeekStarMode component6() {
        return this.zx_named;
    }

    public final YYTrueLovePackGiftMode component7() {
        return this.true_love_box;
    }

    public final int component8() {
        return this.open_batch_gifts;
    }

    public final YYRoomBasicRelationDataMode component9() {
        return this.relation_data;
    }

    public final YYRoomBasicMode copy(YYRoomBasicInfoMode honor_info, YYRoomBasicInfoMode anchor_info, YYRoomBasicWeekStarMode week_star, YYRoomBasicPropMode prop_info, YYRoomBasicFirstMeetMode first_meet, WeekStarMode zx_named, YYTrueLovePackGiftMode true_love_box, int i, YYRoomBasicRelationDataMode relation_data) {
        Intrinsics.e(honor_info, "honor_info");
        Intrinsics.e(anchor_info, "anchor_info");
        Intrinsics.e(week_star, "week_star");
        Intrinsics.e(prop_info, "prop_info");
        Intrinsics.e(first_meet, "first_meet");
        Intrinsics.e(zx_named, "zx_named");
        Intrinsics.e(true_love_box, "true_love_box");
        Intrinsics.e(relation_data, "relation_data");
        return new YYRoomBasicMode(honor_info, anchor_info, week_star, prop_info, first_meet, zx_named, true_love_box, i, relation_data);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof YYRoomBasicMode) {
            YYRoomBasicMode yYRoomBasicMode = (YYRoomBasicMode) obj;
            return Intrinsics.a(this.honor_info, yYRoomBasicMode.honor_info) && Intrinsics.a(this.anchor_info, yYRoomBasicMode.anchor_info) && Intrinsics.a(this.week_star, yYRoomBasicMode.week_star) && Intrinsics.a(this.prop_info, yYRoomBasicMode.prop_info) && Intrinsics.a(this.first_meet, yYRoomBasicMode.first_meet) && Intrinsics.a(this.zx_named, yYRoomBasicMode.zx_named) && Intrinsics.a(this.true_love_box, yYRoomBasicMode.true_love_box) && this.open_batch_gifts == yYRoomBasicMode.open_batch_gifts && Intrinsics.a(this.relation_data, yYRoomBasicMode.relation_data);
        }
        return false;
    }

    public final YYRoomBasicInfoMode getAnchor_info() {
        return this.anchor_info;
    }

    public final YYRoomBasicFirstMeetMode getFirst_meet() {
        return this.first_meet;
    }

    public final YYRoomBasicInfoMode getHonor_info() {
        return this.honor_info;
    }

    public final int getOpen_batch_gifts() {
        return this.open_batch_gifts;
    }

    public final YYRoomBasicPropMode getProp_info() {
        return this.prop_info;
    }

    public final YYRoomBasicRelationDataMode getRelation_data() {
        return this.relation_data;
    }

    public final YYTrueLovePackGiftMode getTrue_love_box() {
        return this.true_love_box;
    }

    public final YYRoomBasicWeekStarMode getWeek_star() {
        return this.week_star;
    }

    public final WeekStarMode getZx_named() {
        return this.zx_named;
    }

    public int hashCode() {
        return (((((((((((((((this.honor_info.hashCode() * 31) + this.anchor_info.hashCode()) * 31) + this.week_star.hashCode()) * 31) + this.prop_info.hashCode()) * 31) + this.first_meet.hashCode()) * 31) + this.zx_named.hashCode()) * 31) + this.true_love_box.hashCode()) * 31) + this.open_batch_gifts) * 31) + this.relation_data.hashCode();
    }

    public String toString() {
        return "YYRoomBasicMode(honor_info=" + this.honor_info + ", anchor_info=" + this.anchor_info + ", week_star=" + this.week_star + ", prop_info=" + this.prop_info + ", first_meet=" + this.first_meet + ", zx_named=" + this.zx_named + ", true_love_box=" + this.true_love_box + ", open_batch_gifts=" + this.open_batch_gifts + ", relation_data=" + this.relation_data + ')';
    }
}
