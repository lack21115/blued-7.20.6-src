package com.blued.android.module.live_china.model;

import $r8;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/model/LiveOnlineUserEntity.class */
public final class LiveOnlineUserEntity implements Serializable {
    private final String avatar;
    private final String avatar_frame;
    private final int avatar_frame_type;
    private int behalf_status;
    private final int chat_badge_height;
    private final int chat_badge_length;
    private final String chat_badge_url;
    private final int club_level;
    private final String club_name;
    private final int fans_status;
    private final int is_hide;
    private final int is_manager;
    private final String name;
    private final String nameplate_img;
    private final int nameplate_img_height;
    private final int nameplate_img_width;
    private final String noble_badge_image;
    private final int noble_level;
    private final int rich_level;
    private final long uid;
    private final int vbadge;
    private final int weight;

    public LiveOnlineUserEntity(int i, int i2, String name, String avatar, long j, int i3, String chat_badge_url, int i4, int i5, String avatar_frame, int i6, int i7, int i8, String club_name, int i9, int i10, int i11, String noble_badge_image, String nameplate_img, int i12, int i13, int i14) {
        Intrinsics.e(name, "name");
        Intrinsics.e(avatar, "avatar");
        Intrinsics.e(chat_badge_url, "chat_badge_url");
        Intrinsics.e(avatar_frame, "avatar_frame");
        Intrinsics.e(club_name, "club_name");
        Intrinsics.e(noble_badge_image, "noble_badge_image");
        Intrinsics.e(nameplate_img, "nameplate_img");
        this.is_hide = i;
        this.is_manager = i2;
        this.name = name;
        this.avatar = avatar;
        this.uid = j;
        this.vbadge = i3;
        this.chat_badge_url = chat_badge_url;
        this.chat_badge_length = i4;
        this.chat_badge_height = i5;
        this.avatar_frame = avatar_frame;
        this.avatar_frame_type = i6;
        this.fans_status = i7;
        this.club_level = i8;
        this.club_name = club_name;
        this.rich_level = i9;
        this.weight = i10;
        this.noble_level = i11;
        this.noble_badge_image = noble_badge_image;
        this.nameplate_img = nameplate_img;
        this.nameplate_img_width = i12;
        this.nameplate_img_height = i13;
        this.behalf_status = i14;
    }

    public static /* synthetic */ LiveOnlineUserEntity copy$default(LiveOnlineUserEntity liveOnlineUserEntity, int i, int i2, String str, String str2, long j, int i3, String str3, int i4, int i5, String str4, int i6, int i7, int i8, String str5, int i9, int i10, int i11, String str6, String str7, int i12, int i13, int i14, int i15, Object obj) {
        if ((i15 & 1) != 0) {
            i = liveOnlineUserEntity.is_hide;
        }
        if ((i15 & 2) != 0) {
            i2 = liveOnlineUserEntity.is_manager;
        }
        if ((i15 & 4) != 0) {
            str = liveOnlineUserEntity.name;
        }
        if ((i15 & 8) != 0) {
            str2 = liveOnlineUserEntity.avatar;
        }
        if ((i15 & 16) != 0) {
            j = liveOnlineUserEntity.uid;
        }
        if ((i15 & 32) != 0) {
            i3 = liveOnlineUserEntity.vbadge;
        }
        if ((i15 & 64) != 0) {
            str3 = liveOnlineUserEntity.chat_badge_url;
        }
        if ((i15 & 128) != 0) {
            i4 = liveOnlineUserEntity.chat_badge_length;
        }
        if ((i15 & 256) != 0) {
            i5 = liveOnlineUserEntity.chat_badge_height;
        }
        if ((i15 & 512) != 0) {
            str4 = liveOnlineUserEntity.avatar_frame;
        }
        if ((i15 & 1024) != 0) {
            i6 = liveOnlineUserEntity.avatar_frame_type;
        }
        if ((i15 & 2048) != 0) {
            i7 = liveOnlineUserEntity.fans_status;
        }
        if ((i15 & 4096) != 0) {
            i8 = liveOnlineUserEntity.club_level;
        }
        if ((i15 & 8192) != 0) {
            str5 = liveOnlineUserEntity.club_name;
        }
        if ((i15 & 16384) != 0) {
            i9 = liveOnlineUserEntity.rich_level;
        }
        if ((i15 & 32768) != 0) {
            i10 = liveOnlineUserEntity.weight;
        }
        if ((i15 & 65536) != 0) {
            i11 = liveOnlineUserEntity.noble_level;
        }
        if ((i15 & 131072) != 0) {
            str6 = liveOnlineUserEntity.noble_badge_image;
        }
        if ((i15 & 262144) != 0) {
            str7 = liveOnlineUserEntity.nameplate_img;
        }
        if ((i15 & 524288) != 0) {
            i12 = liveOnlineUserEntity.nameplate_img_width;
        }
        if ((i15 & 1048576) != 0) {
            i13 = liveOnlineUserEntity.nameplate_img_height;
        }
        if ((i15 & 2097152) != 0) {
            i14 = liveOnlineUserEntity.behalf_status;
        }
        return liveOnlineUserEntity.copy(i, i2, str, str2, j, i3, str3, i4, i5, str4, i6, i7, i8, str5, i9, i10, i11, str6, str7, i12, i13, i14);
    }

    public final int component1() {
        return this.is_hide;
    }

    public final String component10() {
        return this.avatar_frame;
    }

    public final int component11() {
        return this.avatar_frame_type;
    }

    public final int component12() {
        return this.fans_status;
    }

    public final int component13() {
        return this.club_level;
    }

    public final String component14() {
        return this.club_name;
    }

    public final int component15() {
        return this.rich_level;
    }

    public final int component16() {
        return this.weight;
    }

    public final int component17() {
        return this.noble_level;
    }

    public final String component18() {
        return this.noble_badge_image;
    }

    public final String component19() {
        return this.nameplate_img;
    }

    public final int component2() {
        return this.is_manager;
    }

    public final int component20() {
        return this.nameplate_img_width;
    }

    public final int component21() {
        return this.nameplate_img_height;
    }

    public final int component22() {
        return this.behalf_status;
    }

    public final String component3() {
        return this.name;
    }

    public final String component4() {
        return this.avatar;
    }

    public final long component5() {
        return this.uid;
    }

    public final int component6() {
        return this.vbadge;
    }

    public final String component7() {
        return this.chat_badge_url;
    }

    public final int component8() {
        return this.chat_badge_length;
    }

    public final int component9() {
        return this.chat_badge_height;
    }

    public final LiveOnlineUserEntity copy(int i, int i2, String name, String avatar, long j, int i3, String chat_badge_url, int i4, int i5, String avatar_frame, int i6, int i7, int i8, String club_name, int i9, int i10, int i11, String noble_badge_image, String nameplate_img, int i12, int i13, int i14) {
        Intrinsics.e(name, "name");
        Intrinsics.e(avatar, "avatar");
        Intrinsics.e(chat_badge_url, "chat_badge_url");
        Intrinsics.e(avatar_frame, "avatar_frame");
        Intrinsics.e(club_name, "club_name");
        Intrinsics.e(noble_badge_image, "noble_badge_image");
        Intrinsics.e(nameplate_img, "nameplate_img");
        return new LiveOnlineUserEntity(i, i2, name, avatar, j, i3, chat_badge_url, i4, i5, avatar_frame, i6, i7, i8, club_name, i9, i10, i11, noble_badge_image, nameplate_img, i12, i13, i14);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof LiveOnlineUserEntity) {
            LiveOnlineUserEntity liveOnlineUserEntity = (LiveOnlineUserEntity) obj;
            return this.is_hide == liveOnlineUserEntity.is_hide && this.is_manager == liveOnlineUserEntity.is_manager && Intrinsics.a((Object) this.name, (Object) liveOnlineUserEntity.name) && Intrinsics.a((Object) this.avatar, (Object) liveOnlineUserEntity.avatar) && this.uid == liveOnlineUserEntity.uid && this.vbadge == liveOnlineUserEntity.vbadge && Intrinsics.a((Object) this.chat_badge_url, (Object) liveOnlineUserEntity.chat_badge_url) && this.chat_badge_length == liveOnlineUserEntity.chat_badge_length && this.chat_badge_height == liveOnlineUserEntity.chat_badge_height && Intrinsics.a((Object) this.avatar_frame, (Object) liveOnlineUserEntity.avatar_frame) && this.avatar_frame_type == liveOnlineUserEntity.avatar_frame_type && this.fans_status == liveOnlineUserEntity.fans_status && this.club_level == liveOnlineUserEntity.club_level && Intrinsics.a((Object) this.club_name, (Object) liveOnlineUserEntity.club_name) && this.rich_level == liveOnlineUserEntity.rich_level && this.weight == liveOnlineUserEntity.weight && this.noble_level == liveOnlineUserEntity.noble_level && Intrinsics.a((Object) this.noble_badge_image, (Object) liveOnlineUserEntity.noble_badge_image) && Intrinsics.a((Object) this.nameplate_img, (Object) liveOnlineUserEntity.nameplate_img) && this.nameplate_img_width == liveOnlineUserEntity.nameplate_img_width && this.nameplate_img_height == liveOnlineUserEntity.nameplate_img_height && this.behalf_status == liveOnlineUserEntity.behalf_status;
        }
        return false;
    }

    public final String getAvatar() {
        return this.avatar;
    }

    public final String getAvatar_frame() {
        return this.avatar_frame;
    }

    public final int getAvatar_frame_type() {
        return this.avatar_frame_type;
    }

    public final int getBehalf_status() {
        return this.behalf_status;
    }

    public final int getChat_badge_height() {
        return this.chat_badge_height;
    }

    public final int getChat_badge_length() {
        return this.chat_badge_length;
    }

    public final String getChat_badge_url() {
        return this.chat_badge_url;
    }

    public final int getClub_level() {
        return this.club_level;
    }

    public final String getClub_name() {
        return this.club_name;
    }

    public final int getFans_status() {
        return this.fans_status;
    }

    public final String getName() {
        return this.name;
    }

    public final String getNameplate_img() {
        return this.nameplate_img;
    }

    public final int getNameplate_img_height() {
        return this.nameplate_img_height;
    }

    public final int getNameplate_img_width() {
        return this.nameplate_img_width;
    }

    public final String getNoble_badge_image() {
        return this.noble_badge_image;
    }

    public final int getNoble_level() {
        return this.noble_level;
    }

    public final int getRich_level() {
        return this.rich_level;
    }

    public final long getUid() {
        return this.uid;
    }

    public final int getVbadge() {
        return this.vbadge;
    }

    public final int getWeight() {
        return this.weight;
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((((((((((((((((this.is_hide * 31) + this.is_manager) * 31) + this.name.hashCode()) * 31) + this.avatar.hashCode()) * 31) + $r8.backportedMethods.utility.Long.1.hashCode.hashCode(this.uid)) * 31) + this.vbadge) * 31) + this.chat_badge_url.hashCode()) * 31) + this.chat_badge_length) * 31) + this.chat_badge_height) * 31) + this.avatar_frame.hashCode()) * 31) + this.avatar_frame_type) * 31) + this.fans_status) * 31) + this.club_level) * 31) + this.club_name.hashCode()) * 31) + this.rich_level) * 31) + this.weight) * 31) + this.noble_level) * 31) + this.noble_badge_image.hashCode()) * 31) + this.nameplate_img.hashCode()) * 31) + this.nameplate_img_width) * 31) + this.nameplate_img_height) * 31) + this.behalf_status;
    }

    public final int is_hide() {
        return this.is_hide;
    }

    public final int is_manager() {
        return this.is_manager;
    }

    public final void setBehalf_status(int i) {
        this.behalf_status = i;
    }

    public String toString() {
        return "LiveOnlineUserEntity(is_hide=" + this.is_hide + ", is_manager=" + this.is_manager + ", name=" + this.name + ", avatar=" + this.avatar + ", uid=" + this.uid + ", vbadge=" + this.vbadge + ", chat_badge_url=" + this.chat_badge_url + ", chat_badge_length=" + this.chat_badge_length + ", chat_badge_height=" + this.chat_badge_height + ", avatar_frame=" + this.avatar_frame + ", avatar_frame_type=" + this.avatar_frame_type + ", fans_status=" + this.fans_status + ", club_level=" + this.club_level + ", club_name=" + this.club_name + ", rich_level=" + this.rich_level + ", weight=" + this.weight + ", noble_level=" + this.noble_level + ", noble_badge_image=" + this.noble_badge_image + ", nameplate_img=" + this.nameplate_img + ", nameplate_img_width=" + this.nameplate_img_width + ", nameplate_img_height=" + this.nameplate_img_height + ", behalf_status=" + this.behalf_status + ')';
    }
}
