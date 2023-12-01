package com.blued.android.module.yy_china.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/model/WelcomeInfoMode.class */
public final class WelcomeInfoMode {
    private final String anchor_avatar;
    private final String content;
    private final String icon;
    private final String icon_small;

    public WelcomeInfoMode(String content, String anchor_avatar, String icon_small, String icon) {
        Intrinsics.e(content, "content");
        Intrinsics.e(anchor_avatar, "anchor_avatar");
        Intrinsics.e(icon_small, "icon_small");
        Intrinsics.e(icon, "icon");
        this.content = content;
        this.anchor_avatar = anchor_avatar;
        this.icon_small = icon_small;
        this.icon = icon;
    }

    public static /* synthetic */ WelcomeInfoMode copy$default(WelcomeInfoMode welcomeInfoMode, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = welcomeInfoMode.content;
        }
        if ((i & 2) != 0) {
            str2 = welcomeInfoMode.anchor_avatar;
        }
        if ((i & 4) != 0) {
            str3 = welcomeInfoMode.icon_small;
        }
        if ((i & 8) != 0) {
            str4 = welcomeInfoMode.icon;
        }
        return welcomeInfoMode.copy(str, str2, str3, str4);
    }

    public final String component1() {
        return this.content;
    }

    public final String component2() {
        return this.anchor_avatar;
    }

    public final String component3() {
        return this.icon_small;
    }

    public final String component4() {
        return this.icon;
    }

    public final WelcomeInfoMode copy(String content, String anchor_avatar, String icon_small, String icon) {
        Intrinsics.e(content, "content");
        Intrinsics.e(anchor_avatar, "anchor_avatar");
        Intrinsics.e(icon_small, "icon_small");
        Intrinsics.e(icon, "icon");
        return new WelcomeInfoMode(content, anchor_avatar, icon_small, icon);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof WelcomeInfoMode) {
            WelcomeInfoMode welcomeInfoMode = (WelcomeInfoMode) obj;
            return Intrinsics.a((Object) this.content, (Object) welcomeInfoMode.content) && Intrinsics.a((Object) this.anchor_avatar, (Object) welcomeInfoMode.anchor_avatar) && Intrinsics.a((Object) this.icon_small, (Object) welcomeInfoMode.icon_small) && Intrinsics.a((Object) this.icon, (Object) welcomeInfoMode.icon);
        }
        return false;
    }

    public final String getAnchor_avatar() {
        return this.anchor_avatar;
    }

    public final String getContent() {
        return this.content;
    }

    public final String getIcon() {
        return this.icon;
    }

    public final String getIcon_small() {
        return this.icon_small;
    }

    public int hashCode() {
        return (((((this.content.hashCode() * 31) + this.anchor_avatar.hashCode()) * 31) + this.icon_small.hashCode()) * 31) + this.icon.hashCode();
    }

    public String toString() {
        return "WelcomeInfoMode(content=" + this.content + ", anchor_avatar=" + this.anchor_avatar + ", icon_small=" + this.icon_small + ", icon=" + this.icon + ')';
    }
}
