package com.blued.android.module.yy_china.model;

import $r8;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/model/IMJsonContents108Model.class */
public final class IMJsonContents108Model {
    private final YYThemeActivityInfo activity_info;
    private final long countdown_time;

    /* renamed from: skin  reason: collision with root package name */
    private final YYEventsThemeModel f54skin;
    private final int type;

    public IMJsonContents108Model(int i, long j, YYThemeActivityInfo activity_info, YYEventsThemeModel skin2) {
        Intrinsics.e(activity_info, "activity_info");
        Intrinsics.e(skin2, "skin");
        this.type = i;
        this.countdown_time = j;
        this.activity_info = activity_info;
        this.f54skin = skin2;
    }

    public static /* synthetic */ IMJsonContents108Model copy$default(IMJsonContents108Model iMJsonContents108Model, int i, long j, YYThemeActivityInfo yYThemeActivityInfo, YYEventsThemeModel yYEventsThemeModel, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = iMJsonContents108Model.type;
        }
        if ((i2 & 2) != 0) {
            j = iMJsonContents108Model.countdown_time;
        }
        if ((i2 & 4) != 0) {
            yYThemeActivityInfo = iMJsonContents108Model.activity_info;
        }
        if ((i2 & 8) != 0) {
            yYEventsThemeModel = iMJsonContents108Model.f54skin;
        }
        return iMJsonContents108Model.copy(i, j, yYThemeActivityInfo, yYEventsThemeModel);
    }

    public final int component1() {
        return this.type;
    }

    public final long component2() {
        return this.countdown_time;
    }

    public final YYThemeActivityInfo component3() {
        return this.activity_info;
    }

    public final YYEventsThemeModel component4() {
        return this.f54skin;
    }

    public final IMJsonContents108Model copy(int i, long j, YYThemeActivityInfo activity_info, YYEventsThemeModel skin2) {
        Intrinsics.e(activity_info, "activity_info");
        Intrinsics.e(skin2, "skin");
        return new IMJsonContents108Model(i, j, activity_info, skin2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof IMJsonContents108Model) {
            IMJsonContents108Model iMJsonContents108Model = (IMJsonContents108Model) obj;
            return this.type == iMJsonContents108Model.type && this.countdown_time == iMJsonContents108Model.countdown_time && Intrinsics.a(this.activity_info, iMJsonContents108Model.activity_info) && Intrinsics.a(this.f54skin, iMJsonContents108Model.f54skin);
        }
        return false;
    }

    public final YYThemeActivityInfo getActivity_info() {
        return this.activity_info;
    }

    public final long getCountdown_time() {
        return this.countdown_time;
    }

    public final YYEventsThemeModel getSkin() {
        return this.f54skin;
    }

    public final int getType() {
        return this.type;
    }

    public int hashCode() {
        return (((((this.type * 31) + $r8.backportedMethods.utility.Long.1.hashCode.hashCode(this.countdown_time)) * 31) + this.activity_info.hashCode()) * 31) + this.f54skin.hashCode();
    }

    public String toString() {
        return "IMJsonContents108Model(type=" + this.type + ", countdown_time=" + this.countdown_time + ", activity_info=" + this.activity_info + ", skin=" + this.f54skin + ')';
    }
}
