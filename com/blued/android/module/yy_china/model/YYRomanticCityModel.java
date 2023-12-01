package com.blued.android.module.yy_china.model;

import com.chad.library.adapter.base.entity.MultiItemEntity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/model/YYRomanticCityModel.class */
public final class YYRomanticCityModel implements MultiItemEntity {
    private final String id;
    private final String image;
    private final String name;
    private final String notice;
    private final String send_user_avatar;
    private final int total_count;
    private final int type;

    public YYRomanticCityModel(String id, String image, String name, String send_user_avatar, int i, int i2, String notice) {
        Intrinsics.e(id, "id");
        Intrinsics.e(image, "image");
        Intrinsics.e(name, "name");
        Intrinsics.e(send_user_avatar, "send_user_avatar");
        Intrinsics.e(notice, "notice");
        this.id = id;
        this.image = image;
        this.name = name;
        this.send_user_avatar = send_user_avatar;
        this.total_count = i;
        this.type = i2;
        this.notice = notice;
    }

    public static /* synthetic */ YYRomanticCityModel copy$default(YYRomanticCityModel yYRomanticCityModel, String str, String str2, String str3, String str4, int i, int i2, String str5, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = yYRomanticCityModel.id;
        }
        if ((i3 & 2) != 0) {
            str2 = yYRomanticCityModel.image;
        }
        if ((i3 & 4) != 0) {
            str3 = yYRomanticCityModel.name;
        }
        if ((i3 & 8) != 0) {
            str4 = yYRomanticCityModel.send_user_avatar;
        }
        if ((i3 & 16) != 0) {
            i = yYRomanticCityModel.total_count;
        }
        if ((i3 & 32) != 0) {
            i2 = yYRomanticCityModel.type;
        }
        if ((i3 & 64) != 0) {
            str5 = yYRomanticCityModel.notice;
        }
        return yYRomanticCityModel.copy(str, str2, str3, str4, i, i2, str5);
    }

    public final String component1() {
        return this.id;
    }

    public final String component2() {
        return this.image;
    }

    public final String component3() {
        return this.name;
    }

    public final String component4() {
        return this.send_user_avatar;
    }

    public final int component5() {
        return this.total_count;
    }

    public final int component6() {
        return this.type;
    }

    public final String component7() {
        return this.notice;
    }

    public final YYRomanticCityModel copy(String id, String image, String name, String send_user_avatar, int i, int i2, String notice) {
        Intrinsics.e(id, "id");
        Intrinsics.e(image, "image");
        Intrinsics.e(name, "name");
        Intrinsics.e(send_user_avatar, "send_user_avatar");
        Intrinsics.e(notice, "notice");
        return new YYRomanticCityModel(id, image, name, send_user_avatar, i, i2, notice);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof YYRomanticCityModel) {
            YYRomanticCityModel yYRomanticCityModel = (YYRomanticCityModel) obj;
            return Intrinsics.a((Object) this.id, (Object) yYRomanticCityModel.id) && Intrinsics.a((Object) this.image, (Object) yYRomanticCityModel.image) && Intrinsics.a((Object) this.name, (Object) yYRomanticCityModel.name) && Intrinsics.a((Object) this.send_user_avatar, (Object) yYRomanticCityModel.send_user_avatar) && this.total_count == yYRomanticCityModel.total_count && this.type == yYRomanticCityModel.type && Intrinsics.a((Object) this.notice, (Object) yYRomanticCityModel.notice);
        }
        return false;
    }

    public final String getId() {
        return this.id;
    }

    public final String getImage() {
        return this.image;
    }

    @Override // com.chad.library.adapter.base.entity.MultiItemEntity
    public int getItemType() {
        return this.type == 0 ? 0 : 1;
    }

    public final String getName() {
        return this.name;
    }

    public final String getNotice() {
        return this.notice;
    }

    public final String getSend_user_avatar() {
        return this.send_user_avatar;
    }

    public final int getTotal_count() {
        return this.total_count;
    }

    public final int getType() {
        return this.type;
    }

    public int hashCode() {
        return (((((((((((this.id.hashCode() * 31) + this.image.hashCode()) * 31) + this.name.hashCode()) * 31) + this.send_user_avatar.hashCode()) * 31) + this.total_count) * 31) + this.type) * 31) + this.notice.hashCode();
    }

    public String toString() {
        return "YYRomanticCityModel(id=" + this.id + ", image=" + this.image + ", name=" + this.name + ", send_user_avatar=" + this.send_user_avatar + ", total_count=" + this.total_count + ", type=" + this.type + ", notice=" + this.notice + ')';
    }
}
