package com.soft.blued.ui.msg.model;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-8457232-dex2jar.jar:com/soft/blued/ui/msg/model/DateTodayMatchUserModel.class */
public final class DateTodayMatchUserModel {
    private final int age;
    private final List<String> attestation_info;
    private final String avatar;
    private final int height;
    private final String name;
    private final List<String> others_evaluation;
    private final float role;
    private String uid;
    private final int weight;
    private final List<String> your_like_type;

    public DateTodayMatchUserModel(String str, String str2, String str3, int i, int i2, int i3, float f, List<String> list, List<String> list2, List<String> list3) {
        Intrinsics.e(str, "uid");
        Intrinsics.e(str2, "name");
        Intrinsics.e(str3, "avatar");
        this.uid = str;
        this.name = str2;
        this.avatar = str3;
        this.age = i;
        this.height = i2;
        this.weight = i3;
        this.role = f;
        this.your_like_type = list;
        this.others_evaluation = list2;
        this.attestation_info = list3;
    }

    public /* synthetic */ DateTodayMatchUserModel(String str, String str2, String str3, int i, int i2, int i3, float f, List list, List list2, List list3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? "" : str, (i4 & 2) != 0 ? "" : str2, (i4 & 4) != 0 ? "" : str3, (i4 & 8) != 0 ? 0 : i, (i4 & 16) != 0 ? 0 : i2, (i4 & 32) != 0 ? 0 : i3, (i4 & 64) != 0 ? 0.0f : f, list, list2, list3);
    }

    public static /* synthetic */ DateTodayMatchUserModel copy$default(DateTodayMatchUserModel dateTodayMatchUserModel, String str, String str2, String str3, int i, int i2, int i3, float f, List list, List list2, List list3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            str = dateTodayMatchUserModel.uid;
        }
        if ((i4 & 2) != 0) {
            str2 = dateTodayMatchUserModel.name;
        }
        if ((i4 & 4) != 0) {
            str3 = dateTodayMatchUserModel.avatar;
        }
        if ((i4 & 8) != 0) {
            i = dateTodayMatchUserModel.age;
        }
        if ((i4 & 16) != 0) {
            i2 = dateTodayMatchUserModel.height;
        }
        if ((i4 & 32) != 0) {
            i3 = dateTodayMatchUserModel.weight;
        }
        if ((i4 & 64) != 0) {
            f = dateTodayMatchUserModel.role;
        }
        if ((i4 & 128) != 0) {
            list = dateTodayMatchUserModel.your_like_type;
        }
        if ((i4 & 256) != 0) {
            list2 = dateTodayMatchUserModel.others_evaluation;
        }
        if ((i4 & 512) != 0) {
            list3 = dateTodayMatchUserModel.attestation_info;
        }
        return dateTodayMatchUserModel.copy(str, str2, str3, i, i2, i3, f, list, list2, list3);
    }

    public final String component1() {
        return this.uid;
    }

    public final List<String> component10() {
        return this.attestation_info;
    }

    public final String component2() {
        return this.name;
    }

    public final String component3() {
        return this.avatar;
    }

    public final int component4() {
        return this.age;
    }

    public final int component5() {
        return this.height;
    }

    public final int component6() {
        return this.weight;
    }

    public final float component7() {
        return this.role;
    }

    public final List<String> component8() {
        return this.your_like_type;
    }

    public final List<String> component9() {
        return this.others_evaluation;
    }

    public final DateTodayMatchUserModel copy(String str, String str2, String str3, int i, int i2, int i3, float f, List<String> list, List<String> list2, List<String> list3) {
        Intrinsics.e(str, "uid");
        Intrinsics.e(str2, "name");
        Intrinsics.e(str3, "avatar");
        return new DateTodayMatchUserModel(str, str2, str3, i, i2, i3, f, list, list2, list3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DateTodayMatchUserModel) {
            DateTodayMatchUserModel dateTodayMatchUserModel = (DateTodayMatchUserModel) obj;
            return Intrinsics.a(this.uid, dateTodayMatchUserModel.uid) && Intrinsics.a(this.name, dateTodayMatchUserModel.name) && Intrinsics.a(this.avatar, dateTodayMatchUserModel.avatar) && this.age == dateTodayMatchUserModel.age && this.height == dateTodayMatchUserModel.height && this.weight == dateTodayMatchUserModel.weight && Intrinsics.a(Float.valueOf(this.role), Float.valueOf(dateTodayMatchUserModel.role)) && Intrinsics.a(this.your_like_type, dateTodayMatchUserModel.your_like_type) && Intrinsics.a(this.others_evaluation, dateTodayMatchUserModel.others_evaluation) && Intrinsics.a(this.attestation_info, dateTodayMatchUserModel.attestation_info);
        }
        return false;
    }

    public final int getAge() {
        return this.age;
    }

    public final List<String> getAttestation_info() {
        return this.attestation_info;
    }

    public final String getAvatar() {
        return this.avatar;
    }

    public final int getHeight() {
        return this.height;
    }

    public final String getName() {
        return this.name;
    }

    public final List<String> getOthers_evaluation() {
        return this.others_evaluation;
    }

    public final float getRole() {
        return this.role;
    }

    public final String getUid() {
        return this.uid;
    }

    public final int getWeight() {
        return this.weight;
    }

    public final List<String> getYour_like_type() {
        return this.your_like_type;
    }

    public int hashCode() {
        int hashCode = this.uid.hashCode();
        int hashCode2 = this.name.hashCode();
        int hashCode3 = this.avatar.hashCode();
        int i = this.age;
        int i2 = this.height;
        int i3 = this.weight;
        int floatToIntBits = Float.floatToIntBits(this.role);
        List<String> list = this.your_like_type;
        int i4 = 0;
        int hashCode4 = list == null ? 0 : list.hashCode();
        List<String> list2 = this.others_evaluation;
        int hashCode5 = list2 == null ? 0 : list2.hashCode();
        List<String> list3 = this.attestation_info;
        if (list3 != null) {
            i4 = list3.hashCode();
        }
        return (((((((((((((((((hashCode * 31) + hashCode2) * 31) + hashCode3) * 31) + i) * 31) + i2) * 31) + i3) * 31) + floatToIntBits) * 31) + hashCode4) * 31) + hashCode5) * 31) + i4;
    }

    public final void setUid(String str) {
        Intrinsics.e(str, "<set-?>");
        this.uid = str;
    }

    public String toString() {
        return "DateTodayMatchUserModel(uid=" + this.uid + ", name=" + this.name + ", avatar=" + this.avatar + ", age=" + this.age + ", height=" + this.height + ", weight=" + this.weight + ", role=" + this.role + ", your_like_type=" + this.your_like_type + ", others_evaluation=" + this.others_evaluation + ", attestation_info=" + this.attestation_info + ')';
    }
}
