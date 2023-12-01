package com.blued.android.module.yy_china.model;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/model/HomeThemeModel.class */
public final class HomeThemeModel {
    private final String icon_after;
    private final String icon_before;
    private int id;
    private String name;
    private List<Integer> underLineColors;

    public HomeThemeModel(int i, String name, String icon_before, String icon_after, List<Integer> list) {
        Intrinsics.e(name, "name");
        Intrinsics.e(icon_before, "icon_before");
        Intrinsics.e(icon_after, "icon_after");
        this.id = i;
        this.name = name;
        this.icon_before = icon_before;
        this.icon_after = icon_after;
        this.underLineColors = list;
    }

    public /* synthetic */ HomeThemeModel(int i, String str, String str2, String str3, List list, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, str, str2, str3, (i2 & 16) != 0 ? null : list);
    }

    public static /* synthetic */ HomeThemeModel copy$default(HomeThemeModel homeThemeModel, int i, String str, String str2, String str3, List list, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = homeThemeModel.id;
        }
        if ((i2 & 2) != 0) {
            str = homeThemeModel.name;
        }
        if ((i2 & 4) != 0) {
            str2 = homeThemeModel.icon_before;
        }
        if ((i2 & 8) != 0) {
            str3 = homeThemeModel.icon_after;
        }
        if ((i2 & 16) != 0) {
            list = homeThemeModel.underLineColors;
        }
        return homeThemeModel.copy(i, str, str2, str3, list);
    }

    public final int component1() {
        return this.id;
    }

    public final String component2() {
        return this.name;
    }

    public final String component3() {
        return this.icon_before;
    }

    public final String component4() {
        return this.icon_after;
    }

    public final List<Integer> component5() {
        return this.underLineColors;
    }

    public final HomeThemeModel copy(int i, String name, String icon_before, String icon_after, List<Integer> list) {
        Intrinsics.e(name, "name");
        Intrinsics.e(icon_before, "icon_before");
        Intrinsics.e(icon_after, "icon_after");
        return new HomeThemeModel(i, name, icon_before, icon_after, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof HomeThemeModel) {
            HomeThemeModel homeThemeModel = (HomeThemeModel) obj;
            return this.id == homeThemeModel.id && Intrinsics.a((Object) this.name, (Object) homeThemeModel.name) && Intrinsics.a((Object) this.icon_before, (Object) homeThemeModel.icon_before) && Intrinsics.a((Object) this.icon_after, (Object) homeThemeModel.icon_after) && Intrinsics.a(this.underLineColors, homeThemeModel.underLineColors);
        }
        return false;
    }

    public final String getIcon_after() {
        return this.icon_after;
    }

    public final String getIcon_before() {
        return this.icon_before;
    }

    public final int getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

    public final List<Integer> getUnderLineColors() {
        return this.underLineColors;
    }

    public int hashCode() {
        int i = this.id;
        int hashCode = this.name.hashCode();
        int hashCode2 = this.icon_before.hashCode();
        int hashCode3 = this.icon_after.hashCode();
        List<Integer> list = this.underLineColors;
        return (((((((i * 31) + hashCode) * 31) + hashCode2) * 31) + hashCode3) * 31) + (list == null ? 0 : list.hashCode());
    }

    public final void setId(int i) {
        this.id = i;
    }

    public final void setName(String str) {
        Intrinsics.e(str, "<set-?>");
        this.name = str;
    }

    public final void setUnderLineColors(List<Integer> list) {
        this.underLineColors = list;
    }

    public String toString() {
        return "HomeThemeModel(id=" + this.id + ", name=" + this.name + ", icon_before=" + this.icon_before + ", icon_after=" + this.icon_after + ", underLineColors=" + this.underLineColors + ')';
    }
}
