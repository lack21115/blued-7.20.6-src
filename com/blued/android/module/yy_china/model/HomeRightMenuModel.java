package com.blued.android.module.yy_china.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/model/HomeRightMenuModel.class */
public final class HomeRightMenuModel {
    private final HomeRightMenuDotModel dot;
    private final String icon;
    private final String icon_black;
    private final String name;
    private final String url;

    public HomeRightMenuModel(String name, String icon_black, String icon, String url, HomeRightMenuDotModel dot) {
        Intrinsics.e(name, "name");
        Intrinsics.e(icon_black, "icon_black");
        Intrinsics.e(icon, "icon");
        Intrinsics.e(url, "url");
        Intrinsics.e(dot, "dot");
        this.name = name;
        this.icon_black = icon_black;
        this.icon = icon;
        this.url = url;
        this.dot = dot;
    }

    public static /* synthetic */ HomeRightMenuModel copy$default(HomeRightMenuModel homeRightMenuModel, String str, String str2, String str3, String str4, HomeRightMenuDotModel homeRightMenuDotModel, int i, Object obj) {
        if ((i & 1) != 0) {
            str = homeRightMenuModel.name;
        }
        if ((i & 2) != 0) {
            str2 = homeRightMenuModel.icon_black;
        }
        if ((i & 4) != 0) {
            str3 = homeRightMenuModel.icon;
        }
        if ((i & 8) != 0) {
            str4 = homeRightMenuModel.url;
        }
        if ((i & 16) != 0) {
            homeRightMenuDotModel = homeRightMenuModel.dot;
        }
        return homeRightMenuModel.copy(str, str2, str3, str4, homeRightMenuDotModel);
    }

    public final String component1() {
        return this.name;
    }

    public final String component2() {
        return this.icon_black;
    }

    public final String component3() {
        return this.icon;
    }

    public final String component4() {
        return this.url;
    }

    public final HomeRightMenuDotModel component5() {
        return this.dot;
    }

    public final HomeRightMenuModel copy(String name, String icon_black, String icon, String url, HomeRightMenuDotModel dot) {
        Intrinsics.e(name, "name");
        Intrinsics.e(icon_black, "icon_black");
        Intrinsics.e(icon, "icon");
        Intrinsics.e(url, "url");
        Intrinsics.e(dot, "dot");
        return new HomeRightMenuModel(name, icon_black, icon, url, dot);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof HomeRightMenuModel) {
            HomeRightMenuModel homeRightMenuModel = (HomeRightMenuModel) obj;
            return Intrinsics.a((Object) this.name, (Object) homeRightMenuModel.name) && Intrinsics.a((Object) this.icon_black, (Object) homeRightMenuModel.icon_black) && Intrinsics.a((Object) this.icon, (Object) homeRightMenuModel.icon) && Intrinsics.a((Object) this.url, (Object) homeRightMenuModel.url) && Intrinsics.a(this.dot, homeRightMenuModel.dot);
        }
        return false;
    }

    public final HomeRightMenuDotModel getDot() {
        return this.dot;
    }

    public final String getIcon() {
        return this.icon;
    }

    public final String getIcon_black() {
        return this.icon_black;
    }

    public final String getName() {
        return this.name;
    }

    public final String getUrl() {
        return this.url;
    }

    public int hashCode() {
        return (((((((this.name.hashCode() * 31) + this.icon_black.hashCode()) * 31) + this.icon.hashCode()) * 31) + this.url.hashCode()) * 31) + this.dot.hashCode();
    }

    public String toString() {
        return "HomeRightMenuModel(name=" + this.name + ", icon_black=" + this.icon_black + ", icon=" + this.icon + ", url=" + this.url + ", dot=" + this.dot + ')';
    }
}
