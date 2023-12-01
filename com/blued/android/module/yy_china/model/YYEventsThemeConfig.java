package com.blued.android.module.yy_china.model;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/model/YYEventsThemeConfig.class */
public final class YYEventsThemeConfig {
    private final String beans_values;
    private final String prep_time;
    private final List<YYEventsThemeModel> types;

    public YYEventsThemeConfig(List<YYEventsThemeModel> types, String beans_values, String prep_time) {
        Intrinsics.e(types, "types");
        Intrinsics.e(beans_values, "beans_values");
        Intrinsics.e(prep_time, "prep_time");
        this.types = types;
        this.beans_values = beans_values;
        this.prep_time = prep_time;
    }

    public static /* synthetic */ YYEventsThemeConfig copy$default(YYEventsThemeConfig yYEventsThemeConfig, List list, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            list = yYEventsThemeConfig.types;
        }
        if ((i & 2) != 0) {
            str = yYEventsThemeConfig.beans_values;
        }
        if ((i & 4) != 0) {
            str2 = yYEventsThemeConfig.prep_time;
        }
        return yYEventsThemeConfig.copy(list, str, str2);
    }

    public final List<YYEventsThemeModel> component1() {
        return this.types;
    }

    public final String component2() {
        return this.beans_values;
    }

    public final String component3() {
        return this.prep_time;
    }

    public final YYEventsThemeConfig copy(List<YYEventsThemeModel> types, String beans_values, String prep_time) {
        Intrinsics.e(types, "types");
        Intrinsics.e(beans_values, "beans_values");
        Intrinsics.e(prep_time, "prep_time");
        return new YYEventsThemeConfig(types, beans_values, prep_time);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof YYEventsThemeConfig) {
            YYEventsThemeConfig yYEventsThemeConfig = (YYEventsThemeConfig) obj;
            return Intrinsics.a(this.types, yYEventsThemeConfig.types) && Intrinsics.a((Object) this.beans_values, (Object) yYEventsThemeConfig.beans_values) && Intrinsics.a((Object) this.prep_time, (Object) yYEventsThemeConfig.prep_time);
        }
        return false;
    }

    public final String getBeans_values() {
        return this.beans_values;
    }

    public final String getPrep_time() {
        return this.prep_time;
    }

    public final List<YYEventsThemeModel> getTypes() {
        return this.types;
    }

    public int hashCode() {
        return (((this.types.hashCode() * 31) + this.beans_values.hashCode()) * 31) + this.prep_time.hashCode();
    }

    public String toString() {
        return "YYEventsThemeConfig(types=" + this.types + ", beans_values=" + this.beans_values + ", prep_time=" + this.prep_time + ')';
    }
}
