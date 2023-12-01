package com.blued.android.module.yy_china.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/model/YYButtonConfigModel.class */
public final class YYButtonConfigModel {
    private final int action_type;
    private final String icon;
    private final String link_url;
    private final int status;

    public YYButtonConfigModel(int i, String link_url, int i2, String icon) {
        Intrinsics.e(link_url, "link_url");
        Intrinsics.e(icon, "icon");
        this.status = i;
        this.link_url = link_url;
        this.action_type = i2;
        this.icon = icon;
    }

    public static /* synthetic */ YYButtonConfigModel copy$default(YYButtonConfigModel yYButtonConfigModel, int i, String str, int i2, String str2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = yYButtonConfigModel.status;
        }
        if ((i3 & 2) != 0) {
            str = yYButtonConfigModel.link_url;
        }
        if ((i3 & 4) != 0) {
            i2 = yYButtonConfigModel.action_type;
        }
        if ((i3 & 8) != 0) {
            str2 = yYButtonConfigModel.icon;
        }
        return yYButtonConfigModel.copy(i, str, i2, str2);
    }

    public final int component1() {
        return this.status;
    }

    public final String component2() {
        return this.link_url;
    }

    public final int component3() {
        return this.action_type;
    }

    public final String component4() {
        return this.icon;
    }

    public final YYButtonConfigModel copy(int i, String link_url, int i2, String icon) {
        Intrinsics.e(link_url, "link_url");
        Intrinsics.e(icon, "icon");
        return new YYButtonConfigModel(i, link_url, i2, icon);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof YYButtonConfigModel) {
            YYButtonConfigModel yYButtonConfigModel = (YYButtonConfigModel) obj;
            return this.status == yYButtonConfigModel.status && Intrinsics.a((Object) this.link_url, (Object) yYButtonConfigModel.link_url) && this.action_type == yYButtonConfigModel.action_type && Intrinsics.a((Object) this.icon, (Object) yYButtonConfigModel.icon);
        }
        return false;
    }

    public final int getAction_type() {
        return this.action_type;
    }

    public final String getIcon() {
        return this.icon;
    }

    public final String getLink_url() {
        return this.link_url;
    }

    public final int getStatus() {
        return this.status;
    }

    public int hashCode() {
        return (((((this.status * 31) + this.link_url.hashCode()) * 31) + this.action_type) * 31) + this.icon.hashCode();
    }

    public String toString() {
        return "YYButtonConfigModel(status=" + this.status + ", link_url=" + this.link_url + ", action_type=" + this.action_type + ", icon=" + this.icon + ')';
    }
}
