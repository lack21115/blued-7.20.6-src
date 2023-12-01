package com.blued.android.module.live_china.model;

import $r8;
import dalvik.bytecode.Opcodes;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5961304-dex2jar.jar:com/blued/android/module/live_china/model/LiveMedalItemData.class */
public final class LiveMedalItemData implements Serializable {
    private String badge_id;
    private long created_time;
    private String description;
    private String dynamic_icon;
    private long expire_time;
    private String icon;
    private int is_hide_expire_time;
    private String name;
    private int type;

    public LiveMedalItemData() {
        this(0L, 0L, 0, 0, null, null, null, null, null, Opcodes.OP_CHECK_CAST_JUMBO, null);
    }

    public LiveMedalItemData(long j, long j2, int i, int i2, String str, String str2, String str3, String str4, String str5) {
        this.created_time = j;
        this.expire_time = j2;
        this.is_hide_expire_time = i;
        this.type = i2;
        this.badge_id = str;
        this.name = str2;
        this.icon = str3;
        this.dynamic_icon = str4;
        this.description = str5;
    }

    public /* synthetic */ LiveMedalItemData(long j, long j2, int i, int i2, String str, String str2, String str3, String str4, String str5, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 0L : j, (i3 & 2) != 0 ? 0L : j2, (i3 & 4) != 0 ? 0 : i, (i3 & 8) != 0 ? -1 : i2, (i3 & 16) != 0 ? null : str, (i3 & 32) != 0 ? null : str2, (i3 & 64) != 0 ? null : str3, (i3 & 128) != 0 ? null : str4, (i3 & 256) != 0 ? null : str5);
    }

    public static /* synthetic */ LiveMedalItemData copy$default(LiveMedalItemData liveMedalItemData, long j, long j2, int i, int i2, String str, String str2, String str3, String str4, String str5, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            j = liveMedalItemData.created_time;
        }
        if ((i3 & 2) != 0) {
            j2 = liveMedalItemData.expire_time;
        }
        if ((i3 & 4) != 0) {
            i = liveMedalItemData.is_hide_expire_time;
        }
        if ((i3 & 8) != 0) {
            i2 = liveMedalItemData.type;
        }
        if ((i3 & 16) != 0) {
            str = liveMedalItemData.badge_id;
        }
        if ((i3 & 32) != 0) {
            str2 = liveMedalItemData.name;
        }
        if ((i3 & 64) != 0) {
            str3 = liveMedalItemData.icon;
        }
        if ((i3 & 128) != 0) {
            str4 = liveMedalItemData.dynamic_icon;
        }
        if ((i3 & 256) != 0) {
            str5 = liveMedalItemData.description;
        }
        return liveMedalItemData.copy(j, j2, i, i2, str, str2, str3, str4, str5);
    }

    public final long component1() {
        return this.created_time;
    }

    public final long component2() {
        return this.expire_time;
    }

    public final int component3() {
        return this.is_hide_expire_time;
    }

    public final int component4() {
        return this.type;
    }

    public final String component5() {
        return this.badge_id;
    }

    public final String component6() {
        return this.name;
    }

    public final String component7() {
        return this.icon;
    }

    public final String component8() {
        return this.dynamic_icon;
    }

    public final String component9() {
        return this.description;
    }

    public final LiveMedalItemData copy(long j, long j2, int i, int i2, String str, String str2, String str3, String str4, String str5) {
        return new LiveMedalItemData(j, j2, i, i2, str, str2, str3, str4, str5);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof LiveMedalItemData) {
            LiveMedalItemData liveMedalItemData = (LiveMedalItemData) obj;
            return this.created_time == liveMedalItemData.created_time && this.expire_time == liveMedalItemData.expire_time && this.is_hide_expire_time == liveMedalItemData.is_hide_expire_time && this.type == liveMedalItemData.type && Intrinsics.a((Object) this.badge_id, (Object) liveMedalItemData.badge_id) && Intrinsics.a((Object) this.name, (Object) liveMedalItemData.name) && Intrinsics.a((Object) this.icon, (Object) liveMedalItemData.icon) && Intrinsics.a((Object) this.dynamic_icon, (Object) liveMedalItemData.dynamic_icon) && Intrinsics.a((Object) this.description, (Object) liveMedalItemData.description);
        }
        return false;
    }

    public final String getBadge_id() {
        return this.badge_id;
    }

    public final long getCreated_time() {
        return this.created_time;
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getDynamic_icon() {
        return this.dynamic_icon;
    }

    public final long getExpire_time() {
        return this.expire_time;
    }

    public final String getIcon() {
        return this.icon;
    }

    public final String getName() {
        return this.name;
    }

    public final int getType() {
        return this.type;
    }

    public int hashCode() {
        int hashCode = $r8.backportedMethods.utility.Long.1.hashCode.hashCode(this.created_time);
        int hashCode2 = $r8.backportedMethods.utility.Long.1.hashCode.hashCode(this.expire_time);
        int i = this.is_hide_expire_time;
        int i2 = this.type;
        String str = this.badge_id;
        int i3 = 0;
        int hashCode3 = str == null ? 0 : str.hashCode();
        String str2 = this.name;
        int hashCode4 = str2 == null ? 0 : str2.hashCode();
        String str3 = this.icon;
        int hashCode5 = str3 == null ? 0 : str3.hashCode();
        String str4 = this.dynamic_icon;
        int hashCode6 = str4 == null ? 0 : str4.hashCode();
        String str5 = this.description;
        if (str5 != null) {
            i3 = str5.hashCode();
        }
        return (((((((((((((((hashCode * 31) + hashCode2) * 31) + i) * 31) + i2) * 31) + hashCode3) * 31) + hashCode4) * 31) + hashCode5) * 31) + hashCode6) * 31) + i3;
    }

    public final int is_hide_expire_time() {
        return this.is_hide_expire_time;
    }

    public final void setBadge_id(String str) {
        this.badge_id = str;
    }

    public final void setCreated_time(long j) {
        this.created_time = j;
    }

    public final void setDescription(String str) {
        this.description = str;
    }

    public final void setDynamic_icon(String str) {
        this.dynamic_icon = str;
    }

    public final void setExpire_time(long j) {
        this.expire_time = j;
    }

    public final void setIcon(String str) {
        this.icon = str;
    }

    public final void setName(String str) {
        this.name = str;
    }

    public final void setType(int i) {
        this.type = i;
    }

    public final void set_hide_expire_time(int i) {
        this.is_hide_expire_time = i;
    }

    public String toString() {
        return "LiveMedalItemData(created_time=" + this.created_time + ", expire_time=" + this.expire_time + ", is_hide_expire_time=" + this.is_hide_expire_time + ", type=" + this.type + ", badge_id=" + ((Object) this.badge_id) + ", name=" + ((Object) this.name) + ", icon=" + ((Object) this.icon) + ", dynamic_icon=" + ((Object) this.dynamic_icon) + ", description=" + ((Object) this.description) + ')';
    }
}
