package com.blued.android.module.yy_china.model;

import com.chad.library.adapter.base.entity.MultiItemEntity;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/model/YYFirstMeetGiftsListItemMode.class */
public final class YYFirstMeetGiftsListItemMode implements MultiItemEntity {
    private final String beans;
    private final String duration;
    private final String gift_id;
    private int itemTy;
    private final String name;
    private final String pic;
    private final String type;

    public YYFirstMeetGiftsListItemMode(String type, String gift_id, String name, String duration, String beans, String pic, int i) {
        Intrinsics.e(type, "type");
        Intrinsics.e(gift_id, "gift_id");
        Intrinsics.e(name, "name");
        Intrinsics.e(duration, "duration");
        Intrinsics.e(beans, "beans");
        Intrinsics.e(pic, "pic");
        this.type = type;
        this.gift_id = gift_id;
        this.name = name;
        this.duration = duration;
        this.beans = beans;
        this.pic = pic;
        this.itemTy = i;
    }

    public /* synthetic */ YYFirstMeetGiftsListItemMode(String str, String str2, String str3, String str4, String str5, String str6, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, str4, str5, str6, (i2 & 64) != 0 ? 2 : i);
    }

    public static /* synthetic */ YYFirstMeetGiftsListItemMode copy$default(YYFirstMeetGiftsListItemMode yYFirstMeetGiftsListItemMode, String str, String str2, String str3, String str4, String str5, String str6, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = yYFirstMeetGiftsListItemMode.type;
        }
        if ((i2 & 2) != 0) {
            str2 = yYFirstMeetGiftsListItemMode.gift_id;
        }
        if ((i2 & 4) != 0) {
            str3 = yYFirstMeetGiftsListItemMode.name;
        }
        if ((i2 & 8) != 0) {
            str4 = yYFirstMeetGiftsListItemMode.duration;
        }
        if ((i2 & 16) != 0) {
            str5 = yYFirstMeetGiftsListItemMode.beans;
        }
        if ((i2 & 32) != 0) {
            str6 = yYFirstMeetGiftsListItemMode.pic;
        }
        if ((i2 & 64) != 0) {
            i = yYFirstMeetGiftsListItemMode.itemTy;
        }
        return yYFirstMeetGiftsListItemMode.copy(str, str2, str3, str4, str5, str6, i);
    }

    public final String component1() {
        return this.type;
    }

    public final String component2() {
        return this.gift_id;
    }

    public final String component3() {
        return this.name;
    }

    public final String component4() {
        return this.duration;
    }

    public final String component5() {
        return this.beans;
    }

    public final String component6() {
        return this.pic;
    }

    public final int component7() {
        return this.itemTy;
    }

    public final YYFirstMeetGiftsListItemMode copy(String type, String gift_id, String name, String duration, String beans, String pic, int i) {
        Intrinsics.e(type, "type");
        Intrinsics.e(gift_id, "gift_id");
        Intrinsics.e(name, "name");
        Intrinsics.e(duration, "duration");
        Intrinsics.e(beans, "beans");
        Intrinsics.e(pic, "pic");
        return new YYFirstMeetGiftsListItemMode(type, gift_id, name, duration, beans, pic, i);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof YYFirstMeetGiftsListItemMode) {
            YYFirstMeetGiftsListItemMode yYFirstMeetGiftsListItemMode = (YYFirstMeetGiftsListItemMode) obj;
            return Intrinsics.a((Object) this.type, (Object) yYFirstMeetGiftsListItemMode.type) && Intrinsics.a((Object) this.gift_id, (Object) yYFirstMeetGiftsListItemMode.gift_id) && Intrinsics.a((Object) this.name, (Object) yYFirstMeetGiftsListItemMode.name) && Intrinsics.a((Object) this.duration, (Object) yYFirstMeetGiftsListItemMode.duration) && Intrinsics.a((Object) this.beans, (Object) yYFirstMeetGiftsListItemMode.beans) && Intrinsics.a((Object) this.pic, (Object) yYFirstMeetGiftsListItemMode.pic) && this.itemTy == yYFirstMeetGiftsListItemMode.itemTy;
        }
        return false;
    }

    public final String getBeans() {
        return this.beans;
    }

    public final String getDuration() {
        return this.duration;
    }

    public final String getGift_id() {
        return this.gift_id;
    }

    public final int getItemTy() {
        return this.itemTy;
    }

    public int getItemType() {
        return this.itemTy;
    }

    public final String getName() {
        return this.name;
    }

    public final String getPic() {
        return this.pic;
    }

    public final String getType() {
        return this.type;
    }

    public int hashCode() {
        return (((((((((((this.type.hashCode() * 31) + this.gift_id.hashCode()) * 31) + this.name.hashCode()) * 31) + this.duration.hashCode()) * 31) + this.beans.hashCode()) * 31) + this.pic.hashCode()) * 31) + this.itemTy;
    }

    public final void setItemTy(int i) {
        this.itemTy = i;
    }

    public String toString() {
        return "YYFirstMeetGiftsListItemMode(type=" + this.type + ", gift_id=" + this.gift_id + ", name=" + this.name + ", duration=" + this.duration + ", beans=" + this.beans + ", pic=" + this.pic + ", itemTy=" + this.itemTy + ')';
    }
}
