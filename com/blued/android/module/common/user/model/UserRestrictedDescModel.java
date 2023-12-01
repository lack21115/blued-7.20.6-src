package com.blued.android.module.common.user.model;

import com.blued.android.chat.core.pack.ReqAckPackage;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-4169892-dex2jar.jar:com/blued/android/module/common/user/model/UserRestrictedDescModel.class */
public final class UserRestrictedDescModel {
    private final String avatar_desc;
    private final String desc;
    private final String description_desc;
    private final List<String> items;
    private final String nickname_desc;
    private final String photo_desc;

    public UserRestrictedDescModel() {
        this(null, null, null, null, null, null, 63, null);
    }

    public UserRestrictedDescModel(String desc, String avatar_desc, String nickname_desc, String description_desc, String photo_desc, List<String> list) {
        Intrinsics.e(desc, "desc");
        Intrinsics.e(avatar_desc, "avatar_desc");
        Intrinsics.e(nickname_desc, "nickname_desc");
        Intrinsics.e(description_desc, "description_desc");
        Intrinsics.e(photo_desc, "photo_desc");
        this.desc = desc;
        this.avatar_desc = avatar_desc;
        this.nickname_desc = nickname_desc;
        this.description_desc = description_desc;
        this.photo_desc = photo_desc;
        this.items = list;
    }

    public /* synthetic */ UserRestrictedDescModel(String str, String str2, String str3, String str4, String str5, List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? "" : str3, (i & 8) != 0 ? "" : str4, (i & 16) != 0 ? "" : str5, (i & 32) != 0 ? null : list);
    }

    public static /* synthetic */ UserRestrictedDescModel copy$default(UserRestrictedDescModel userRestrictedDescModel, String str, String str2, String str3, String str4, String str5, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            str = userRestrictedDescModel.desc;
        }
        if ((i & 2) != 0) {
            str2 = userRestrictedDescModel.avatar_desc;
        }
        if ((i & 4) != 0) {
            str3 = userRestrictedDescModel.nickname_desc;
        }
        if ((i & 8) != 0) {
            str4 = userRestrictedDescModel.description_desc;
        }
        if ((i & 16) != 0) {
            str5 = userRestrictedDescModel.photo_desc;
        }
        if ((i & 32) != 0) {
            list = userRestrictedDescModel.items;
        }
        return userRestrictedDescModel.copy(str, str2, str3, str4, str5, list);
    }

    public final String component1() {
        return this.desc;
    }

    public final String component2() {
        return this.avatar_desc;
    }

    public final String component3() {
        return this.nickname_desc;
    }

    public final String component4() {
        return this.description_desc;
    }

    public final String component5() {
        return this.photo_desc;
    }

    public final List<String> component6() {
        return this.items;
    }

    public final UserRestrictedDescModel copy(String desc, String avatar_desc, String nickname_desc, String description_desc, String photo_desc, List<String> list) {
        Intrinsics.e(desc, "desc");
        Intrinsics.e(avatar_desc, "avatar_desc");
        Intrinsics.e(nickname_desc, "nickname_desc");
        Intrinsics.e(description_desc, "description_desc");
        Intrinsics.e(photo_desc, "photo_desc");
        return new UserRestrictedDescModel(desc, avatar_desc, nickname_desc, description_desc, photo_desc, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof UserRestrictedDescModel) {
            UserRestrictedDescModel userRestrictedDescModel = (UserRestrictedDescModel) obj;
            return Intrinsics.a((Object) this.desc, (Object) userRestrictedDescModel.desc) && Intrinsics.a((Object) this.avatar_desc, (Object) userRestrictedDescModel.avatar_desc) && Intrinsics.a((Object) this.nickname_desc, (Object) userRestrictedDescModel.nickname_desc) && Intrinsics.a((Object) this.description_desc, (Object) userRestrictedDescModel.description_desc) && Intrinsics.a((Object) this.photo_desc, (Object) userRestrictedDescModel.photo_desc) && Intrinsics.a(this.items, userRestrictedDescModel.items);
        }
        return false;
    }

    public final String getAvatar_desc() {
        return this.avatar_desc;
    }

    public final String getDesc() {
        return this.desc;
    }

    public final String getDescription_desc() {
        return this.description_desc;
    }

    public final List<String> getItems() {
        return this.items;
    }

    public final String getNickname_desc() {
        return this.nickname_desc;
    }

    public final String getPhoto_desc() {
        return this.photo_desc;
    }

    public int hashCode() {
        int hashCode = this.desc.hashCode();
        int hashCode2 = this.avatar_desc.hashCode();
        int hashCode3 = this.nickname_desc.hashCode();
        int hashCode4 = this.description_desc.hashCode();
        int hashCode5 = this.photo_desc.hashCode();
        List<String> list = this.items;
        return (((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + (list == null ? 0 : list.hashCode());
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public final boolean isExist(String str) {
        String str2;
        String str3 = str;
        if (str3 == null || str3.length() == 0) {
            return false;
        }
        List<String> list = this.items;
        if ((list == null || list.isEmpty()) || this.items.indexOf(str) < 0) {
            return false;
        }
        String lowerCase = str.toLowerCase(Locale.ROOT);
        Intrinsics.c(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        switch (lowerCase.hashCode()) {
            case -1724546052:
                if (lowerCase.equals("description")) {
                    str2 = this.description_desc;
                    break;
                }
                str2 = "";
                break;
            case -1405959847:
                if (lowerCase.equals(ReqAckPackage.REQ_RESPONSE_KEY.AVATAR)) {
                    str2 = this.avatar_desc;
                    break;
                }
                str2 = "";
                break;
            case 70690926:
                if (lowerCase.equals("nickname")) {
                    str2 = this.nickname_desc;
                    break;
                }
                str2 = "";
                break;
            case 106642994:
                if (lowerCase.equals("photo")) {
                    str2 = this.photo_desc;
                    break;
                }
                str2 = "";
                break;
            default:
                str2 = "";
                break;
        }
        return str2.length() > 0;
    }

    public String toString() {
        return "UserRestrictedDescModel(desc=" + this.desc + ", avatar_desc=" + this.avatar_desc + ", nickname_desc=" + this.nickname_desc + ", description_desc=" + this.description_desc + ", photo_desc=" + this.photo_desc + ", items=" + this.items + ')';
    }
}
