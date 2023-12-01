package com.blued.android.module.yy_china.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/model/BgCollectionMode.class */
public final class BgCollectionMode {
    private final int allow_level;
    private final String bg_id;
    private final String default_pic;
    private final String level_notice;
    private final String pic;

    public BgCollectionMode(int i, String bg_id, String level_notice, String default_pic, String pic) {
        Intrinsics.e(bg_id, "bg_id");
        Intrinsics.e(level_notice, "level_notice");
        Intrinsics.e(default_pic, "default_pic");
        Intrinsics.e(pic, "pic");
        this.allow_level = i;
        this.bg_id = bg_id;
        this.level_notice = level_notice;
        this.default_pic = default_pic;
        this.pic = pic;
    }

    public static /* synthetic */ BgCollectionMode copy$default(BgCollectionMode bgCollectionMode, int i, String str, String str2, String str3, String str4, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = bgCollectionMode.allow_level;
        }
        if ((i2 & 2) != 0) {
            str = bgCollectionMode.bg_id;
        }
        if ((i2 & 4) != 0) {
            str2 = bgCollectionMode.level_notice;
        }
        if ((i2 & 8) != 0) {
            str3 = bgCollectionMode.default_pic;
        }
        if ((i2 & 16) != 0) {
            str4 = bgCollectionMode.pic;
        }
        return bgCollectionMode.copy(i, str, str2, str3, str4);
    }

    public final int component1() {
        return this.allow_level;
    }

    public final String component2() {
        return this.bg_id;
    }

    public final String component3() {
        return this.level_notice;
    }

    public final String component4() {
        return this.default_pic;
    }

    public final String component5() {
        return this.pic;
    }

    public final BgCollectionMode copy(int i, String bg_id, String level_notice, String default_pic, String pic) {
        Intrinsics.e(bg_id, "bg_id");
        Intrinsics.e(level_notice, "level_notice");
        Intrinsics.e(default_pic, "default_pic");
        Intrinsics.e(pic, "pic");
        return new BgCollectionMode(i, bg_id, level_notice, default_pic, pic);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof BgCollectionMode) {
            BgCollectionMode bgCollectionMode = (BgCollectionMode) obj;
            return this.allow_level == bgCollectionMode.allow_level && Intrinsics.a((Object) this.bg_id, (Object) bgCollectionMode.bg_id) && Intrinsics.a((Object) this.level_notice, (Object) bgCollectionMode.level_notice) && Intrinsics.a((Object) this.default_pic, (Object) bgCollectionMode.default_pic) && Intrinsics.a((Object) this.pic, (Object) bgCollectionMode.pic);
        }
        return false;
    }

    public final int getAllow_level() {
        return this.allow_level;
    }

    public final String getBg_id() {
        return this.bg_id;
    }

    public final String getDefault_pic() {
        return this.default_pic;
    }

    public final String getLevel_notice() {
        return this.level_notice;
    }

    public final String getPic() {
        return this.pic;
    }

    public int hashCode() {
        return (((((((this.allow_level * 31) + this.bg_id.hashCode()) * 31) + this.level_notice.hashCode()) * 31) + this.default_pic.hashCode()) * 31) + this.pic.hashCode();
    }

    public String toString() {
        return "BgCollectionMode(allow_level=" + this.allow_level + ", bg_id=" + this.bg_id + ", level_notice=" + this.level_notice + ", default_pic=" + this.default_pic + ", pic=" + this.pic + ')';
    }
}
