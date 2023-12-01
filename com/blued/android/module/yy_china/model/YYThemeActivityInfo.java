package com.blued.android.module.yy_china.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/model/YYThemeActivityInfo.class */
public final class YYThemeActivityInfo {
    private final String description;
    private final String end_time;
    private final String id;
    private final String link;
    private final String name;
    private final String notice_type;
    private final String start_time;
    private final String type;
    private final String uid;

    public YYThemeActivityInfo(String id, String uid, String name, String type, String description, String notice_type, String start_time, String end_time, String link) {
        Intrinsics.e(id, "id");
        Intrinsics.e(uid, "uid");
        Intrinsics.e(name, "name");
        Intrinsics.e(type, "type");
        Intrinsics.e(description, "description");
        Intrinsics.e(notice_type, "notice_type");
        Intrinsics.e(start_time, "start_time");
        Intrinsics.e(end_time, "end_time");
        Intrinsics.e(link, "link");
        this.id = id;
        this.uid = uid;
        this.name = name;
        this.type = type;
        this.description = description;
        this.notice_type = notice_type;
        this.start_time = start_time;
        this.end_time = end_time;
        this.link = link;
    }

    public static /* synthetic */ YYThemeActivityInfo copy$default(YYThemeActivityInfo yYThemeActivityInfo, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, int i, Object obj) {
        if ((i & 1) != 0) {
            str = yYThemeActivityInfo.id;
        }
        if ((i & 2) != 0) {
            str2 = yYThemeActivityInfo.uid;
        }
        if ((i & 4) != 0) {
            str3 = yYThemeActivityInfo.name;
        }
        if ((i & 8) != 0) {
            str4 = yYThemeActivityInfo.type;
        }
        if ((i & 16) != 0) {
            str5 = yYThemeActivityInfo.description;
        }
        if ((i & 32) != 0) {
            str6 = yYThemeActivityInfo.notice_type;
        }
        if ((i & 64) != 0) {
            str7 = yYThemeActivityInfo.start_time;
        }
        if ((i & 128) != 0) {
            str8 = yYThemeActivityInfo.end_time;
        }
        if ((i & 256) != 0) {
            str9 = yYThemeActivityInfo.link;
        }
        return yYThemeActivityInfo.copy(str, str2, str3, str4, str5, str6, str7, str8, str9);
    }

    public final String component1() {
        return this.id;
    }

    public final String component2() {
        return this.uid;
    }

    public final String component3() {
        return this.name;
    }

    public final String component4() {
        return this.type;
    }

    public final String component5() {
        return this.description;
    }

    public final String component6() {
        return this.notice_type;
    }

    public final String component7() {
        return this.start_time;
    }

    public final String component8() {
        return this.end_time;
    }

    public final String component9() {
        return this.link;
    }

    public final YYThemeActivityInfo copy(String id, String uid, String name, String type, String description, String notice_type, String start_time, String end_time, String link) {
        Intrinsics.e(id, "id");
        Intrinsics.e(uid, "uid");
        Intrinsics.e(name, "name");
        Intrinsics.e(type, "type");
        Intrinsics.e(description, "description");
        Intrinsics.e(notice_type, "notice_type");
        Intrinsics.e(start_time, "start_time");
        Intrinsics.e(end_time, "end_time");
        Intrinsics.e(link, "link");
        return new YYThemeActivityInfo(id, uid, name, type, description, notice_type, start_time, end_time, link);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof YYThemeActivityInfo) {
            YYThemeActivityInfo yYThemeActivityInfo = (YYThemeActivityInfo) obj;
            return Intrinsics.a((Object) this.id, (Object) yYThemeActivityInfo.id) && Intrinsics.a((Object) this.uid, (Object) yYThemeActivityInfo.uid) && Intrinsics.a((Object) this.name, (Object) yYThemeActivityInfo.name) && Intrinsics.a((Object) this.type, (Object) yYThemeActivityInfo.type) && Intrinsics.a((Object) this.description, (Object) yYThemeActivityInfo.description) && Intrinsics.a((Object) this.notice_type, (Object) yYThemeActivityInfo.notice_type) && Intrinsics.a((Object) this.start_time, (Object) yYThemeActivityInfo.start_time) && Intrinsics.a((Object) this.end_time, (Object) yYThemeActivityInfo.end_time) && Intrinsics.a((Object) this.link, (Object) yYThemeActivityInfo.link);
        }
        return false;
    }

    public final String getDescription() {
        return this.description;
    }

    public final String getEnd_time() {
        return this.end_time;
    }

    public final String getId() {
        return this.id;
    }

    public final String getLink() {
        return this.link;
    }

    public final String getName() {
        return this.name;
    }

    public final String getNotice_type() {
        return this.notice_type;
    }

    public final String getStart_time() {
        return this.start_time;
    }

    public final String getType() {
        return this.type;
    }

    public final String getUid() {
        return this.uid;
    }

    public int hashCode() {
        return (((((((((((((((this.id.hashCode() * 31) + this.uid.hashCode()) * 31) + this.name.hashCode()) * 31) + this.type.hashCode()) * 31) + this.description.hashCode()) * 31) + this.notice_type.hashCode()) * 31) + this.start_time.hashCode()) * 31) + this.end_time.hashCode()) * 31) + this.link.hashCode();
    }

    public String toString() {
        return "YYThemeActivityInfo(id=" + this.id + ", uid=" + this.uid + ", name=" + this.name + ", type=" + this.type + ", description=" + this.description + ", notice_type=" + this.notice_type + ", start_time=" + this.start_time + ", end_time=" + this.end_time + ", link=" + this.link + ')';
    }
}
