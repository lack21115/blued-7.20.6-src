package com.blued.android.module.yy_china.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/model/BadgeMode.class */
public final class BadgeMode {
    private String bid;
    private String condition;
    private long end_time;
    private String image_dym;
    private String name;
    private String pic;
    private int score;
    private int show;
    private long start_time;
    private String title;
    private int type;
    private String upgrade_description;

    public BadgeMode(String pic, String name, String bid, String title, String upgrade_description, String image_dym, int i, long j, long j2, int i2, String condition, int i3) {
        Intrinsics.e(pic, "pic");
        Intrinsics.e(name, "name");
        Intrinsics.e(bid, "bid");
        Intrinsics.e(title, "title");
        Intrinsics.e(upgrade_description, "upgrade_description");
        Intrinsics.e(image_dym, "image_dym");
        Intrinsics.e(condition, "condition");
        this.pic = pic;
        this.name = name;
        this.bid = bid;
        this.title = title;
        this.upgrade_description = upgrade_description;
        this.image_dym = image_dym;
        this.type = i;
        this.start_time = j;
        this.end_time = j2;
        this.show = i2;
        this.condition = condition;
        this.score = i3;
    }

    public static /* synthetic */ BadgeMode copy$default(BadgeMode badgeMode, String str, String str2, String str3, String str4, String str5, String str6, int i, long j, long j2, int i2, String str7, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            str = badgeMode.pic;
        }
        if ((i4 & 2) != 0) {
            str2 = badgeMode.name;
        }
        if ((i4 & 4) != 0) {
            str3 = badgeMode.bid;
        }
        if ((i4 & 8) != 0) {
            str4 = badgeMode.title;
        }
        if ((i4 & 16) != 0) {
            str5 = badgeMode.upgrade_description;
        }
        if ((i4 & 32) != 0) {
            str6 = badgeMode.image_dym;
        }
        if ((i4 & 64) != 0) {
            i = badgeMode.type;
        }
        if ((i4 & 128) != 0) {
            j = badgeMode.start_time;
        }
        if ((i4 & 256) != 0) {
            j2 = badgeMode.end_time;
        }
        if ((i4 & 512) != 0) {
            i2 = badgeMode.show;
        }
        if ((i4 & 1024) != 0) {
            str7 = badgeMode.condition;
        }
        if ((i4 & 2048) != 0) {
            i3 = badgeMode.score;
        }
        return badgeMode.copy(str, str2, str3, str4, str5, str6, i, j, j2, i2, str7, i3);
    }

    public final String component1() {
        return this.pic;
    }

    public final int component10() {
        return this.show;
    }

    public final String component11() {
        return this.condition;
    }

    public final int component12() {
        return this.score;
    }

    public final String component2() {
        return this.name;
    }

    public final String component3() {
        return this.bid;
    }

    public final String component4() {
        return this.title;
    }

    public final String component5() {
        return this.upgrade_description;
    }

    public final String component6() {
        return this.image_dym;
    }

    public final int component7() {
        return this.type;
    }

    public final long component8() {
        return this.start_time;
    }

    public final long component9() {
        return this.end_time;
    }

    public final BadgeMode copy(String pic, String name, String bid, String title, String upgrade_description, String image_dym, int i, long j, long j2, int i2, String condition, int i3) {
        Intrinsics.e(pic, "pic");
        Intrinsics.e(name, "name");
        Intrinsics.e(bid, "bid");
        Intrinsics.e(title, "title");
        Intrinsics.e(upgrade_description, "upgrade_description");
        Intrinsics.e(image_dym, "image_dym");
        Intrinsics.e(condition, "condition");
        return new BadgeMode(pic, name, bid, title, upgrade_description, image_dym, i, j, j2, i2, condition, i3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof BadgeMode) {
            BadgeMode badgeMode = (BadgeMode) obj;
            return Intrinsics.a((Object) this.pic, (Object) badgeMode.pic) && Intrinsics.a((Object) this.name, (Object) badgeMode.name) && Intrinsics.a((Object) this.bid, (Object) badgeMode.bid) && Intrinsics.a((Object) this.title, (Object) badgeMode.title) && Intrinsics.a((Object) this.upgrade_description, (Object) badgeMode.upgrade_description) && Intrinsics.a((Object) this.image_dym, (Object) badgeMode.image_dym) && this.type == badgeMode.type && this.start_time == badgeMode.start_time && this.end_time == badgeMode.end_time && this.show == badgeMode.show && Intrinsics.a((Object) this.condition, (Object) badgeMode.condition) && this.score == badgeMode.score;
        }
        return false;
    }

    public final String getBid() {
        return this.bid;
    }

    public final String getCondition() {
        return this.condition;
    }

    public final long getEnd_time() {
        return this.end_time;
    }

    public final String getImage_dym() {
        return this.image_dym;
    }

    public final String getName() {
        return this.name;
    }

    public final String getPic() {
        return this.pic;
    }

    public final int getScore() {
        return this.score;
    }

    public final int getShow() {
        return this.show;
    }

    public final long getStart_time() {
        return this.start_time;
    }

    public final String getTitle() {
        return this.title;
    }

    public final int getType() {
        return this.type;
    }

    public final String getUpgrade_description() {
        return this.upgrade_description;
    }

    public int hashCode() {
        return (((((((((((((((((((((this.pic.hashCode() * 31) + this.name.hashCode()) * 31) + this.bid.hashCode()) * 31) + this.title.hashCode()) * 31) + this.upgrade_description.hashCode()) * 31) + this.image_dym.hashCode()) * 31) + this.type) * 31) + C$r8$backportedMethods$utility$Long$1$hashCode.hashCode(this.start_time)) * 31) + C$r8$backportedMethods$utility$Long$1$hashCode.hashCode(this.end_time)) * 31) + this.show) * 31) + this.condition.hashCode()) * 31) + this.score;
    }

    public final void setBid(String str) {
        Intrinsics.e(str, "<set-?>");
        this.bid = str;
    }

    public final void setCondition(String str) {
        Intrinsics.e(str, "<set-?>");
        this.condition = str;
    }

    public final void setEnd_time(long j) {
        this.end_time = j;
    }

    public final void setImage_dym(String str) {
        Intrinsics.e(str, "<set-?>");
        this.image_dym = str;
    }

    public final void setName(String str) {
        Intrinsics.e(str, "<set-?>");
        this.name = str;
    }

    public final void setPic(String str) {
        Intrinsics.e(str, "<set-?>");
        this.pic = str;
    }

    public final void setScore(int i) {
        this.score = i;
    }

    public final void setShow(int i) {
        this.show = i;
    }

    public final void setStart_time(long j) {
        this.start_time = j;
    }

    public final void setTitle(String str) {
        Intrinsics.e(str, "<set-?>");
        this.title = str;
    }

    public final void setType(int i) {
        this.type = i;
    }

    public final void setUpgrade_description(String str) {
        Intrinsics.e(str, "<set-?>");
        this.upgrade_description = str;
    }

    public String toString() {
        return "BadgeMode(pic=" + this.pic + ", name=" + this.name + ", bid=" + this.bid + ", title=" + this.title + ", upgrade_description=" + this.upgrade_description + ", image_dym=" + this.image_dym + ", type=" + this.type + ", start_time=" + this.start_time + ", end_time=" + this.end_time + ", show=" + this.show + ", condition=" + this.condition + ", score=" + this.score + ')';
    }
}
