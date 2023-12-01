package com.blued.android.module.yy_china.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/model/UserCardHonorInfoMode.class */
public final class UserCardHonorInfoMode {
    private final int level;
    private final String personal_profile_badge;

    public UserCardHonorInfoMode(int i, String personal_profile_badge) {
        Intrinsics.e(personal_profile_badge, "personal_profile_badge");
        this.level = i;
        this.personal_profile_badge = personal_profile_badge;
    }

    public static /* synthetic */ UserCardHonorInfoMode copy$default(UserCardHonorInfoMode userCardHonorInfoMode, int i, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = userCardHonorInfoMode.level;
        }
        if ((i2 & 2) != 0) {
            str = userCardHonorInfoMode.personal_profile_badge;
        }
        return userCardHonorInfoMode.copy(i, str);
    }

    public final int component1() {
        return this.level;
    }

    public final String component2() {
        return this.personal_profile_badge;
    }

    public final UserCardHonorInfoMode copy(int i, String personal_profile_badge) {
        Intrinsics.e(personal_profile_badge, "personal_profile_badge");
        return new UserCardHonorInfoMode(i, personal_profile_badge);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof UserCardHonorInfoMode) {
            UserCardHonorInfoMode userCardHonorInfoMode = (UserCardHonorInfoMode) obj;
            return this.level == userCardHonorInfoMode.level && Intrinsics.a((Object) this.personal_profile_badge, (Object) userCardHonorInfoMode.personal_profile_badge);
        }
        return false;
    }

    public final int getLevel() {
        return this.level;
    }

    public final String getPersonal_profile_badge() {
        return this.personal_profile_badge;
    }

    public int hashCode() {
        return (this.level * 31) + this.personal_profile_badge.hashCode();
    }

    public String toString() {
        return "UserCardHonorInfoMode(level=" + this.level + ", personal_profile_badge=" + this.personal_profile_badge + ')';
    }
}
