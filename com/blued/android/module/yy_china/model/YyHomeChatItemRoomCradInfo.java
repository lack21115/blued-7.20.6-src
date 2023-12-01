package com.blued.android.module.yy_china.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/model/YyHomeChatItemRoomCradInfo.class */
public final class YyHomeChatItemRoomCradInfo {
    private final String icon;
    private final String img;

    public YyHomeChatItemRoomCradInfo(String img, String icon) {
        Intrinsics.e(img, "img");
        Intrinsics.e(icon, "icon");
        this.img = img;
        this.icon = icon;
    }

    public static /* synthetic */ YyHomeChatItemRoomCradInfo copy$default(YyHomeChatItemRoomCradInfo yyHomeChatItemRoomCradInfo, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = yyHomeChatItemRoomCradInfo.img;
        }
        if ((i & 2) != 0) {
            str2 = yyHomeChatItemRoomCradInfo.icon;
        }
        return yyHomeChatItemRoomCradInfo.copy(str, str2);
    }

    public final String component1() {
        return this.img;
    }

    public final String component2() {
        return this.icon;
    }

    public final YyHomeChatItemRoomCradInfo copy(String img, String icon) {
        Intrinsics.e(img, "img");
        Intrinsics.e(icon, "icon");
        return new YyHomeChatItemRoomCradInfo(img, icon);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof YyHomeChatItemRoomCradInfo) {
            YyHomeChatItemRoomCradInfo yyHomeChatItemRoomCradInfo = (YyHomeChatItemRoomCradInfo) obj;
            return Intrinsics.a((Object) this.img, (Object) yyHomeChatItemRoomCradInfo.img) && Intrinsics.a((Object) this.icon, (Object) yyHomeChatItemRoomCradInfo.icon);
        }
        return false;
    }

    public final String getIcon() {
        return this.icon;
    }

    public final String getImg() {
        return this.img;
    }

    public int hashCode() {
        return (this.img.hashCode() * 31) + this.icon.hashCode();
    }

    public String toString() {
        return "YyHomeChatItemRoomCradInfo(img=" + this.img + ", icon=" + this.icon + ')';
    }
}
