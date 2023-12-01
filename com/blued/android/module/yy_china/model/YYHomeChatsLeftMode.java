package com.blued.android.module.yy_china.model;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata
/* loaded from: source-5382004-dex2jar.jar:com/blued/android/module/yy_china/model/YYHomeChatsLeftMode.class */
public final class YYHomeChatsLeftMode {
    private final ArrayList<YyHomeChatItemDataInfoMode> room_info;

    public YYHomeChatsLeftMode(ArrayList<YyHomeChatItemDataInfoMode> room_info) {
        Intrinsics.e(room_info, "room_info");
        this.room_info = room_info;
    }

    public static /* synthetic */ YYHomeChatsLeftMode copy$default(YYHomeChatsLeftMode yYHomeChatsLeftMode, ArrayList arrayList, int i, Object obj) {
        if ((i & 1) != 0) {
            arrayList = yYHomeChatsLeftMode.room_info;
        }
        return yYHomeChatsLeftMode.copy(arrayList);
    }

    public final ArrayList<YyHomeChatItemDataInfoMode> component1() {
        return this.room_info;
    }

    public final YYHomeChatsLeftMode copy(ArrayList<YyHomeChatItemDataInfoMode> room_info) {
        Intrinsics.e(room_info, "room_info");
        return new YYHomeChatsLeftMode(room_info);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof YYHomeChatsLeftMode) && Intrinsics.a(this.room_info, ((YYHomeChatsLeftMode) obj).room_info);
    }

    public final ArrayList<YyHomeChatItemDataInfoMode> getRoom_info() {
        return this.room_info;
    }

    public int hashCode() {
        return this.room_info.hashCode();
    }

    public String toString() {
        return "YYHomeChatsLeftMode(room_info=" + this.room_info + ')';
    }
}
