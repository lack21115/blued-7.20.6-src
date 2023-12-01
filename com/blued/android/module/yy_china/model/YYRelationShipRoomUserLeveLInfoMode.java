package com.blued.android.module.yy_china.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/model/YYRelationShipRoomUserLeveLInfoMode.class */
public final class YYRelationShipRoomUserLeveLInfoMode {
    private final String background_personal_data_image;
    private final int current_level;
    private final int current_level_score;
    private final String gap;
    private final String icon_progress_relation_center;
    private final String level_name;
    private final int next_level;
    private final int next_level_score;
    private final String percent;
    private final String theme_color_6;

    public YYRelationShipRoomUserLeveLInfoMode(String level_name, int i, int i2, int i3, int i4, String gap, String percent, String theme_color_6, String background_personal_data_image, String icon_progress_relation_center) {
        Intrinsics.e(level_name, "level_name");
        Intrinsics.e(gap, "gap");
        Intrinsics.e(percent, "percent");
        Intrinsics.e(theme_color_6, "theme_color_6");
        Intrinsics.e(background_personal_data_image, "background_personal_data_image");
        Intrinsics.e(icon_progress_relation_center, "icon_progress_relation_center");
        this.level_name = level_name;
        this.current_level = i;
        this.current_level_score = i2;
        this.next_level = i3;
        this.next_level_score = i4;
        this.gap = gap;
        this.percent = percent;
        this.theme_color_6 = theme_color_6;
        this.background_personal_data_image = background_personal_data_image;
        this.icon_progress_relation_center = icon_progress_relation_center;
    }

    public static /* synthetic */ YYRelationShipRoomUserLeveLInfoMode copy$default(YYRelationShipRoomUserLeveLInfoMode yYRelationShipRoomUserLeveLInfoMode, String str, int i, int i2, int i3, int i4, String str2, String str3, String str4, String str5, String str6, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            str = yYRelationShipRoomUserLeveLInfoMode.level_name;
        }
        if ((i5 & 2) != 0) {
            i = yYRelationShipRoomUserLeveLInfoMode.current_level;
        }
        if ((i5 & 4) != 0) {
            i2 = yYRelationShipRoomUserLeveLInfoMode.current_level_score;
        }
        if ((i5 & 8) != 0) {
            i3 = yYRelationShipRoomUserLeveLInfoMode.next_level;
        }
        if ((i5 & 16) != 0) {
            i4 = yYRelationShipRoomUserLeveLInfoMode.next_level_score;
        }
        if ((i5 & 32) != 0) {
            str2 = yYRelationShipRoomUserLeveLInfoMode.gap;
        }
        if ((i5 & 64) != 0) {
            str3 = yYRelationShipRoomUserLeveLInfoMode.percent;
        }
        if ((i5 & 128) != 0) {
            str4 = yYRelationShipRoomUserLeveLInfoMode.theme_color_6;
        }
        if ((i5 & 256) != 0) {
            str5 = yYRelationShipRoomUserLeveLInfoMode.background_personal_data_image;
        }
        if ((i5 & 512) != 0) {
            str6 = yYRelationShipRoomUserLeveLInfoMode.icon_progress_relation_center;
        }
        return yYRelationShipRoomUserLeveLInfoMode.copy(str, i, i2, i3, i4, str2, str3, str4, str5, str6);
    }

    public final String component1() {
        return this.level_name;
    }

    public final String component10() {
        return this.icon_progress_relation_center;
    }

    public final int component2() {
        return this.current_level;
    }

    public final int component3() {
        return this.current_level_score;
    }

    public final int component4() {
        return this.next_level;
    }

    public final int component5() {
        return this.next_level_score;
    }

    public final String component6() {
        return this.gap;
    }

    public final String component7() {
        return this.percent;
    }

    public final String component8() {
        return this.theme_color_6;
    }

    public final String component9() {
        return this.background_personal_data_image;
    }

    public final YYRelationShipRoomUserLeveLInfoMode copy(String level_name, int i, int i2, int i3, int i4, String gap, String percent, String theme_color_6, String background_personal_data_image, String icon_progress_relation_center) {
        Intrinsics.e(level_name, "level_name");
        Intrinsics.e(gap, "gap");
        Intrinsics.e(percent, "percent");
        Intrinsics.e(theme_color_6, "theme_color_6");
        Intrinsics.e(background_personal_data_image, "background_personal_data_image");
        Intrinsics.e(icon_progress_relation_center, "icon_progress_relation_center");
        return new YYRelationShipRoomUserLeveLInfoMode(level_name, i, i2, i3, i4, gap, percent, theme_color_6, background_personal_data_image, icon_progress_relation_center);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof YYRelationShipRoomUserLeveLInfoMode) {
            YYRelationShipRoomUserLeveLInfoMode yYRelationShipRoomUserLeveLInfoMode = (YYRelationShipRoomUserLeveLInfoMode) obj;
            return Intrinsics.a((Object) this.level_name, (Object) yYRelationShipRoomUserLeveLInfoMode.level_name) && this.current_level == yYRelationShipRoomUserLeveLInfoMode.current_level && this.current_level_score == yYRelationShipRoomUserLeveLInfoMode.current_level_score && this.next_level == yYRelationShipRoomUserLeveLInfoMode.next_level && this.next_level_score == yYRelationShipRoomUserLeveLInfoMode.next_level_score && Intrinsics.a((Object) this.gap, (Object) yYRelationShipRoomUserLeveLInfoMode.gap) && Intrinsics.a((Object) this.percent, (Object) yYRelationShipRoomUserLeveLInfoMode.percent) && Intrinsics.a((Object) this.theme_color_6, (Object) yYRelationShipRoomUserLeveLInfoMode.theme_color_6) && Intrinsics.a((Object) this.background_personal_data_image, (Object) yYRelationShipRoomUserLeveLInfoMode.background_personal_data_image) && Intrinsics.a((Object) this.icon_progress_relation_center, (Object) yYRelationShipRoomUserLeveLInfoMode.icon_progress_relation_center);
        }
        return false;
    }

    public final String getBackground_personal_data_image() {
        return this.background_personal_data_image;
    }

    public final int getCurrent_level() {
        return this.current_level;
    }

    public final int getCurrent_level_score() {
        return this.current_level_score;
    }

    public final String getGap() {
        return this.gap;
    }

    public final String getIcon_progress_relation_center() {
        return this.icon_progress_relation_center;
    }

    public final String getLevel_name() {
        return this.level_name;
    }

    public final int getNext_level() {
        return this.next_level;
    }

    public final int getNext_level_score() {
        return this.next_level_score;
    }

    public final String getPercent() {
        return this.percent;
    }

    public final String getTheme_color_6() {
        return this.theme_color_6;
    }

    public int hashCode() {
        return (((((((((((((((((this.level_name.hashCode() * 31) + this.current_level) * 31) + this.current_level_score) * 31) + this.next_level) * 31) + this.next_level_score) * 31) + this.gap.hashCode()) * 31) + this.percent.hashCode()) * 31) + this.theme_color_6.hashCode()) * 31) + this.background_personal_data_image.hashCode()) * 31) + this.icon_progress_relation_center.hashCode();
    }

    public String toString() {
        return "YYRelationShipRoomUserLeveLInfoMode(level_name=" + this.level_name + ", current_level=" + this.current_level + ", current_level_score=" + this.current_level_score + ", next_level=" + this.next_level + ", next_level_score=" + this.next_level_score + ", gap=" + this.gap + ", percent=" + this.percent + ", theme_color_6=" + this.theme_color_6 + ", background_personal_data_image=" + this.background_personal_data_image + ", icon_progress_relation_center=" + this.icon_progress_relation_center + ')';
    }
}
