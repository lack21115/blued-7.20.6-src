package com.blued.android.module.yy_china.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/model/YYRelationShipRoomUserLeveLInfoUiMode.class */
public final class YYRelationShipRoomUserLeveLInfoUiMode {
    private String icon;
    private final String icon_animated;
    private final String icon_level;
    private final String icon_lv;
    private final String icon_static;

    public YYRelationShipRoomUserLeveLInfoUiMode(String icon, String icon_lv, String icon_level, String icon_animated, String icon_static) {
        Intrinsics.e(icon, "icon");
        Intrinsics.e(icon_lv, "icon_lv");
        Intrinsics.e(icon_level, "icon_level");
        Intrinsics.e(icon_animated, "icon_animated");
        Intrinsics.e(icon_static, "icon_static");
        this.icon = icon;
        this.icon_lv = icon_lv;
        this.icon_level = icon_level;
        this.icon_animated = icon_animated;
        this.icon_static = icon_static;
    }

    public static /* synthetic */ YYRelationShipRoomUserLeveLInfoUiMode copy$default(YYRelationShipRoomUserLeveLInfoUiMode yYRelationShipRoomUserLeveLInfoUiMode, String str, String str2, String str3, String str4, String str5, int i, Object obj) {
        if ((i & 1) != 0) {
            str = yYRelationShipRoomUserLeveLInfoUiMode.icon;
        }
        if ((i & 2) != 0) {
            str2 = yYRelationShipRoomUserLeveLInfoUiMode.icon_lv;
        }
        if ((i & 4) != 0) {
            str3 = yYRelationShipRoomUserLeveLInfoUiMode.icon_level;
        }
        if ((i & 8) != 0) {
            str4 = yYRelationShipRoomUserLeveLInfoUiMode.icon_animated;
        }
        if ((i & 16) != 0) {
            str5 = yYRelationShipRoomUserLeveLInfoUiMode.icon_static;
        }
        return yYRelationShipRoomUserLeveLInfoUiMode.copy(str, str2, str3, str4, str5);
    }

    public final String component1() {
        return this.icon;
    }

    public final String component2() {
        return this.icon_lv;
    }

    public final String component3() {
        return this.icon_level;
    }

    public final String component4() {
        return this.icon_animated;
    }

    public final String component5() {
        return this.icon_static;
    }

    public final YYRelationShipRoomUserLeveLInfoUiMode copy(String icon, String icon_lv, String icon_level, String icon_animated, String icon_static) {
        Intrinsics.e(icon, "icon");
        Intrinsics.e(icon_lv, "icon_lv");
        Intrinsics.e(icon_level, "icon_level");
        Intrinsics.e(icon_animated, "icon_animated");
        Intrinsics.e(icon_static, "icon_static");
        return new YYRelationShipRoomUserLeveLInfoUiMode(icon, icon_lv, icon_level, icon_animated, icon_static);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof YYRelationShipRoomUserLeveLInfoUiMode) {
            YYRelationShipRoomUserLeveLInfoUiMode yYRelationShipRoomUserLeveLInfoUiMode = (YYRelationShipRoomUserLeveLInfoUiMode) obj;
            return Intrinsics.a((Object) this.icon, (Object) yYRelationShipRoomUserLeveLInfoUiMode.icon) && Intrinsics.a((Object) this.icon_lv, (Object) yYRelationShipRoomUserLeveLInfoUiMode.icon_lv) && Intrinsics.a((Object) this.icon_level, (Object) yYRelationShipRoomUserLeveLInfoUiMode.icon_level) && Intrinsics.a((Object) this.icon_animated, (Object) yYRelationShipRoomUserLeveLInfoUiMode.icon_animated) && Intrinsics.a((Object) this.icon_static, (Object) yYRelationShipRoomUserLeveLInfoUiMode.icon_static);
        }
        return false;
    }

    public final String getIcon() {
        return this.icon;
    }

    public final String getIcon_animated() {
        return this.icon_animated;
    }

    public final String getIcon_level() {
        return this.icon_level;
    }

    public final String getIcon_lv() {
        return this.icon_lv;
    }

    public final String getIcon_static() {
        return this.icon_static;
    }

    public int hashCode() {
        return (((((((this.icon.hashCode() * 31) + this.icon_lv.hashCode()) * 31) + this.icon_level.hashCode()) * 31) + this.icon_animated.hashCode()) * 31) + this.icon_static.hashCode();
    }

    public final void setIcon(String str) {
        Intrinsics.e(str, "<set-?>");
        this.icon = str;
    }

    public String toString() {
        return "YYRelationShipRoomUserLeveLInfoUiMode(icon=" + this.icon + ", icon_lv=" + this.icon_lv + ", icon_level=" + this.icon_level + ", icon_animated=" + this.icon_animated + ", icon_static=" + this.icon_static + ')';
    }
}
