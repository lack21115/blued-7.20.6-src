package com.blued.android.module.yy_china.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/model/YYPackGiftUserMode.class */
public final class YYPackGiftUserMode {
    private String avatar;
    private final String chat_anchor;
    private final String name;
    private final String uid;

    public YYPackGiftUserMode(String name, String uid, String str, String chat_anchor) {
        Intrinsics.e(name, "name");
        Intrinsics.e(uid, "uid");
        Intrinsics.e(chat_anchor, "chat_anchor");
        this.name = name;
        this.uid = uid;
        this.avatar = str;
        this.chat_anchor = chat_anchor;
    }

    public /* synthetic */ YYPackGiftUserMode(String str, String str2, String str3, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i & 4) != 0 ? null : str3, str4);
    }

    public static /* synthetic */ YYPackGiftUserMode copy$default(YYPackGiftUserMode yYPackGiftUserMode, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = yYPackGiftUserMode.name;
        }
        if ((i & 2) != 0) {
            str2 = yYPackGiftUserMode.uid;
        }
        if ((i & 4) != 0) {
            str3 = yYPackGiftUserMode.avatar;
        }
        if ((i & 8) != 0) {
            str4 = yYPackGiftUserMode.chat_anchor;
        }
        return yYPackGiftUserMode.copy(str, str2, str3, str4);
    }

    public final String component1() {
        return this.name;
    }

    public final String component2() {
        return this.uid;
    }

    public final String component3() {
        return this.avatar;
    }

    public final String component4() {
        return this.chat_anchor;
    }

    public final YYPackGiftUserMode copy(String name, String uid, String str, String chat_anchor) {
        Intrinsics.e(name, "name");
        Intrinsics.e(uid, "uid");
        Intrinsics.e(chat_anchor, "chat_anchor");
        return new YYPackGiftUserMode(name, uid, str, chat_anchor);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof YYPackGiftUserMode) {
            YYPackGiftUserMode yYPackGiftUserMode = (YYPackGiftUserMode) obj;
            return Intrinsics.a((Object) this.name, (Object) yYPackGiftUserMode.name) && Intrinsics.a((Object) this.uid, (Object) yYPackGiftUserMode.uid) && Intrinsics.a((Object) this.avatar, (Object) yYPackGiftUserMode.avatar) && Intrinsics.a((Object) this.chat_anchor, (Object) yYPackGiftUserMode.chat_anchor);
        }
        return false;
    }

    public final String getAvatar() {
        return this.avatar;
    }

    public final String getChatAnchorName() {
        return Intrinsics.a((Object) "1", (Object) this.chat_anchor) ? "房主" : Intrinsics.a((Object) "2", (Object) this.chat_anchor) ? "场控" : "";
    }

    public final String getChat_anchor() {
        return this.chat_anchor;
    }

    public final String getName() {
        return this.name;
    }

    public final String getUid() {
        return this.uid;
    }

    public int hashCode() {
        int hashCode = this.name.hashCode();
        int hashCode2 = this.uid.hashCode();
        String str = this.avatar;
        return (((((hashCode * 31) + hashCode2) * 31) + (str == null ? 0 : str.hashCode())) * 31) + this.chat_anchor.hashCode();
    }

    public final void setAvatar(String str) {
        this.avatar = str;
    }

    public String toString() {
        return "YYPackGiftUserMode(name=" + this.name + ", uid=" + this.uid + ", avatar=" + ((Object) this.avatar) + ", chat_anchor=" + this.chat_anchor + ')';
    }
}
