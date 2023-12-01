package com.blued.android.module.yy_china.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/model/YYRoomBasicWeekStarMode.class */
public final class YYRoomBasicWeekStarMode {
    private final String icon;
    private final String is_show;
    private final String link;

    public YYRoomBasicWeekStarMode(String is_show, String icon, String link) {
        Intrinsics.e(is_show, "is_show");
        Intrinsics.e(icon, "icon");
        Intrinsics.e(link, "link");
        this.is_show = is_show;
        this.icon = icon;
        this.link = link;
    }

    public static /* synthetic */ YYRoomBasicWeekStarMode copy$default(YYRoomBasicWeekStarMode yYRoomBasicWeekStarMode, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = yYRoomBasicWeekStarMode.is_show;
        }
        if ((i & 2) != 0) {
            str2 = yYRoomBasicWeekStarMode.icon;
        }
        if ((i & 4) != 0) {
            str3 = yYRoomBasicWeekStarMode.link;
        }
        return yYRoomBasicWeekStarMode.copy(str, str2, str3);
    }

    public final String component1() {
        return this.is_show;
    }

    public final String component2() {
        return this.icon;
    }

    public final String component3() {
        return this.link;
    }

    public final YYRoomBasicWeekStarMode copy(String is_show, String icon, String link) {
        Intrinsics.e(is_show, "is_show");
        Intrinsics.e(icon, "icon");
        Intrinsics.e(link, "link");
        return new YYRoomBasicWeekStarMode(is_show, icon, link);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof YYRoomBasicWeekStarMode) {
            YYRoomBasicWeekStarMode yYRoomBasicWeekStarMode = (YYRoomBasicWeekStarMode) obj;
            return Intrinsics.a((Object) this.is_show, (Object) yYRoomBasicWeekStarMode.is_show) && Intrinsics.a((Object) this.icon, (Object) yYRoomBasicWeekStarMode.icon) && Intrinsics.a((Object) this.link, (Object) yYRoomBasicWeekStarMode.link);
        }
        return false;
    }

    public final String getIcon() {
        return this.icon;
    }

    public final String getLink() {
        return this.link;
    }

    public int hashCode() {
        return (((this.is_show.hashCode() * 31) + this.icon.hashCode()) * 31) + this.link.hashCode();
    }

    public final String is_show() {
        return this.is_show;
    }

    public String toString() {
        return "YYRoomBasicWeekStarMode(is_show=" + this.is_show + ", icon=" + this.icon + ", link=" + this.link + ')';
    }
}
