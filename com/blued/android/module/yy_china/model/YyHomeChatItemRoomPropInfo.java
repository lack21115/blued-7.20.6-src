package com.blued.android.module.yy_china.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/model/YyHomeChatItemRoomPropInfo.class */
public final class YyHomeChatItemRoomPropInfo {
    private final YyHomeChatItemRoomCradInfo room_card;

    public YyHomeChatItemRoomPropInfo(YyHomeChatItemRoomCradInfo room_card) {
        Intrinsics.e(room_card, "room_card");
        this.room_card = room_card;
    }

    public static /* synthetic */ YyHomeChatItemRoomPropInfo copy$default(YyHomeChatItemRoomPropInfo yyHomeChatItemRoomPropInfo, YyHomeChatItemRoomCradInfo yyHomeChatItemRoomCradInfo, int i, Object obj) {
        if ((i & 1) != 0) {
            yyHomeChatItemRoomCradInfo = yyHomeChatItemRoomPropInfo.room_card;
        }
        return yyHomeChatItemRoomPropInfo.copy(yyHomeChatItemRoomCradInfo);
    }

    public final YyHomeChatItemRoomCradInfo component1() {
        return this.room_card;
    }

    public final YyHomeChatItemRoomPropInfo copy(YyHomeChatItemRoomCradInfo room_card) {
        Intrinsics.e(room_card, "room_card");
        return new YyHomeChatItemRoomPropInfo(room_card);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof YyHomeChatItemRoomPropInfo) && Intrinsics.a(this.room_card, ((YyHomeChatItemRoomPropInfo) obj).room_card);
    }

    public final YyHomeChatItemRoomCradInfo getRoom_card() {
        return this.room_card;
    }

    public int hashCode() {
        return this.room_card.hashCode();
    }

    public String toString() {
        return "YyHomeChatItemRoomPropInfo(room_card=" + this.room_card + ')';
    }
}
