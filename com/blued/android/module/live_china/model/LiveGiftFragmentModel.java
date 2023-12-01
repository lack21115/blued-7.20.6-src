package com.blued.android.module.live_china.model;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/model/LiveGiftFragmentModel.class */
public final class LiveGiftFragmentModel implements Serializable {
    private final int consume;
    private final int count;
    private final String expire_time;
    private final int id;
    private final String image;
    private final int is_hide_expire_time;
    private final String name;
    private final int type;
    private final String type_icon;

    public LiveGiftFragmentModel(int i, String name, String image, String expire_time, int i2, int i3, int i4, int i5, String type_icon) {
        Intrinsics.e(name, "name");
        Intrinsics.e(image, "image");
        Intrinsics.e(expire_time, "expire_time");
        Intrinsics.e(type_icon, "type_icon");
        this.id = i;
        this.name = name;
        this.image = image;
        this.expire_time = expire_time;
        this.is_hide_expire_time = i2;
        this.count = i3;
        this.consume = i4;
        this.type = i5;
        this.type_icon = type_icon;
    }

    public static /* synthetic */ LiveGiftFragmentModel copy$default(LiveGiftFragmentModel liveGiftFragmentModel, int i, String str, String str2, String str3, int i2, int i3, int i4, int i5, String str4, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            i = liveGiftFragmentModel.id;
        }
        if ((i6 & 2) != 0) {
            str = liveGiftFragmentModel.name;
        }
        if ((i6 & 4) != 0) {
            str2 = liveGiftFragmentModel.image;
        }
        if ((i6 & 8) != 0) {
            str3 = liveGiftFragmentModel.expire_time;
        }
        if ((i6 & 16) != 0) {
            i2 = liveGiftFragmentModel.is_hide_expire_time;
        }
        if ((i6 & 32) != 0) {
            i3 = liveGiftFragmentModel.count;
        }
        if ((i6 & 64) != 0) {
            i4 = liveGiftFragmentModel.consume;
        }
        if ((i6 & 128) != 0) {
            i5 = liveGiftFragmentModel.type;
        }
        if ((i6 & 256) != 0) {
            str4 = liveGiftFragmentModel.type_icon;
        }
        return liveGiftFragmentModel.copy(i, str, str2, str3, i2, i3, i4, i5, str4);
    }

    public final int component1() {
        return this.id;
    }

    public final String component2() {
        return this.name;
    }

    public final String component3() {
        return this.image;
    }

    public final String component4() {
        return this.expire_time;
    }

    public final int component5() {
        return this.is_hide_expire_time;
    }

    public final int component6() {
        return this.count;
    }

    public final int component7() {
        return this.consume;
    }

    public final int component8() {
        return this.type;
    }

    public final String component9() {
        return this.type_icon;
    }

    public final LiveGiftFragmentModel copy(int i, String name, String image, String expire_time, int i2, int i3, int i4, int i5, String type_icon) {
        Intrinsics.e(name, "name");
        Intrinsics.e(image, "image");
        Intrinsics.e(expire_time, "expire_time");
        Intrinsics.e(type_icon, "type_icon");
        return new LiveGiftFragmentModel(i, name, image, expire_time, i2, i3, i4, i5, type_icon);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof LiveGiftFragmentModel) {
            LiveGiftFragmentModel liveGiftFragmentModel = (LiveGiftFragmentModel) obj;
            return this.id == liveGiftFragmentModel.id && Intrinsics.a((Object) this.name, (Object) liveGiftFragmentModel.name) && Intrinsics.a((Object) this.image, (Object) liveGiftFragmentModel.image) && Intrinsics.a((Object) this.expire_time, (Object) liveGiftFragmentModel.expire_time) && this.is_hide_expire_time == liveGiftFragmentModel.is_hide_expire_time && this.count == liveGiftFragmentModel.count && this.consume == liveGiftFragmentModel.consume && this.type == liveGiftFragmentModel.type && Intrinsics.a((Object) this.type_icon, (Object) liveGiftFragmentModel.type_icon);
        }
        return false;
    }

    public final int getConsume() {
        return this.consume;
    }

    public final int getCount() {
        return this.count;
    }

    public final String getExpire_time() {
        return this.expire_time;
    }

    public final int getId() {
        return this.id;
    }

    public final String getImage() {
        return this.image;
    }

    public final String getName() {
        return this.name;
    }

    public final int getType() {
        return this.type;
    }

    public final String getType_icon() {
        return this.type_icon;
    }

    public int hashCode() {
        return (((((((((((((((this.id * 31) + this.name.hashCode()) * 31) + this.image.hashCode()) * 31) + this.expire_time.hashCode()) * 31) + this.is_hide_expire_time) * 31) + this.count) * 31) + this.consume) * 31) + this.type) * 31) + this.type_icon.hashCode();
    }

    public final int is_hide_expire_time() {
        return this.is_hide_expire_time;
    }

    public String toString() {
        return "LiveGiftFragmentModel(id=" + this.id + ", name=" + this.name + ", image=" + this.image + ", expire_time=" + this.expire_time + ", is_hide_expire_time=" + this.is_hide_expire_time + ", count=" + this.count + ", consume=" + this.consume + ", type=" + this.type + ", type_icon=" + this.type_icon + ')';
    }
}
